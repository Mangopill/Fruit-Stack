package com.fruitstack.fruitstack.common.block;

import com.fruitstack.fruitstack.common.block.entity.JuicerBlockEntity;
import com.fruitstack.fruitstack.common.block.state.FryingPanStage;
import com.fruitstack.fruitstack.common.block.state.JuicerStage;
import com.fruitstack.fruitstack.common.registry.ModBlocks;
import com.fruitstack.fruitstack.common.registry.ModItems;
import com.fruitstack.fruitstack.common.registry.ModParticleTypes;
import com.fruitstack.fruitstack.common.registry.ModSounds;
import com.fruitstack.fruitstack.common.tag.ModTags;
import com.fruitstack.fruitstack.common.utility.TextUtils;
import com.fruitstack.fruitstack.fruitstack;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;
import net.minecraft.util.random.WeightedRandomList;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.ticks.TickPriority;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.Tags;
import net.minecraftforge.network.NetworkHooks;

import java.util.*;
import java.util.function.Supplier;

public class FryingPanBlock extends Block {
	public static final DamageSource FRYING_PAN_DAMAGE = (new DamageSource(fruitstack.MODID + ".frying_pan")).setIsFire();
	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
	public static final EnumProperty<FryingPanStage> STAGE = EnumProperty.create("stage", FryingPanStage.class);
	protected static final VoxelShape SHAPE = Block.box(2.0, 1.0, 2.0, 14.0, 2.0, 14.0);
	public FryingPanBlock(BlockBehaviour.Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(STAGE, FryingPanStage.NONE));
	}

	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}

	public boolean isRandomlyTicking(BlockState state) {
		return true;
	}

	public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
		return !level.isEmptyBlock(pos.below());
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING,STAGE);
		super.createBlockStateDefinition(builder);
	}
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
		if (level.isClientSide) {
			if (this.fryingPan(level, pos, state, player, hand, hit).consumesAction()) {
				return InteractionResult.SUCCESS;
			}
		}
		return this.fryingPan(level, pos, state, player, hand, hit);
	}
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}
	public InteractionResult fryingPan(Level level, BlockPos pos, BlockState state, Player player, InteractionHand hand, BlockHitResult result) {
		ItemStack heldStack = player.getItemInHand(hand);
		boolean isHeated = isHeated(level, pos);
		boolean isice = isice(level, pos);
		ItemStack sunflower_oil = ModItems.SUNFLOWER_OIL.get().getDefaultInstance();
		ItemStack pot_cover = ModItems.POT_COVER.get().getDefaultInstance();
		ItemStack bowl = Items.BOWL.getDefaultInstance();
		if (isHeated) {
			if (state.getValue(STAGE).equals(FryingPanStage.NONE)) {
				if (heldStack.getItem() == ModItems.SUNFLOWER_OIL.get()) {
					heldStack.shrink(1);
					if (!player.getInventory().add(Items.BOWL.getDefaultInstance())) {
						player.drop(Items.BOWL.getDefaultInstance(), false);
					}
					level.setBlock(pos, state.setValue(STAGE, FryingPanStage.SUNFLOWER_OIL), 3);
					level.playSound(null, pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F,
							ModSounds.BLOCK_FRYING_PAN_OIL_SIZZLE.get(), SoundSource.BLOCKS, 0.8F, 1.0F);
				}else if (heldStack.getItem() == Items.SUGAR) {//add food(milk tea)
					level.playSound(null, pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F,
							ModSounds.BLOCK_FRYING_PAN_ADD_FOOD.get(), SoundSource.BLOCKS, 0.8F, 1.0F);
					heldStack.shrink(1);
					level.setBlock(pos, state.setValue(STAGE, FryingPanStage.FRYING_PAN_MILKY_TEA_SUGAR_AGE0), 3);
					return InteractionResult.SUCCESS;
				} else {
					player.displayClientMessage(TextUtils.getTranslation("block.frying_pan.sunflower_oil", sunflower_oil.getCraftingRemainingItem().getHoverName()), true);
				}
				return InteractionResult.SUCCESS;
			} else if (state.getValue(STAGE).equals(FryingPanStage.FIRE)) {
				if (heldStack.getItem() == ModItems.POT_COVER.get()) {
					heldStack.shrink(1);
					level.playSound(null, pos, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS, 1.0F, 1.0F);
					level.setBlock(pos, state.setValue(STAGE, FryingPanStage.POT_COVER), 3);
				} else {
					player.displayClientMessage(TextUtils.getTranslation("block.frying_pan.pot_cover", pot_cover.getCraftingRemainingItem().getHoverName()), true);
				}
				return InteractionResult.SUCCESS;
			}else if (state.getValue(STAGE).equals(FryingPanStage.POT_COVER)) {
				if (heldStack.getItem() == Items.BOWL) {
					heldStack.shrink(1);
					if (!player.getInventory().add(ModItems.THE_BURNT_DISH.get().getDefaultInstance())) {
						player.drop(ModItems.THE_BURNT_DISH.get().getDefaultInstance(), false);
					}
					if (!player.getInventory().add(ModItems.POT_COVER.get().getDefaultInstance())) {
						player.drop(ModItems.POT_COVER.get().getDefaultInstance(), false);
					}
					level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
					level.setBlock(pos, state.setValue(STAGE, FryingPanStage.NONE), 3);
				} else {
					player.displayClientMessage(TextUtils.getTranslation("block.frying_pan.bowl", bowl.getCraftingRemainingItem().getHoverName()), true);
				}
				return InteractionResult.SUCCESS;
			}else if (state.getValue(STAGE).equals(FryingPanStage.SUNFLOWER_OIL)) {//add food
				if (heldStack.getItem() == ModItems.BEATING_MELONS_SEEDS.get()) {
					level.playSound(null, pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F,
							ModSounds.BLOCK_FRYING_PAN_ADD_FOOD.get(), SoundSource.BLOCKS, 0.8F, 1.0F);
					heldStack.shrink(1);
					level.setBlock(pos, state.setValue(STAGE, FryingPanStage.FRYING_PAN_STIR_FRIED_BEATING_MELONS_SEEDS_AGE0), 3);
				}
				if (heldStack.getItem() == ModItems.LITCHI_BALL.get()) {
					level.playSound(null, pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F,
							ModSounds.BLOCK_FRYING_PAN_ADD_FOOD.get(), SoundSource.BLOCKS, 0.8F, 1.0F);
					heldStack.shrink(1);
					level.setBlock(pos, state.setValue(STAGE, FryingPanStage.FRYING_PAN_CRISPY_LITCHI_BALL_AGE0), 3);
				}
				if (heldStack.getItem() == ModItems.UNFINISHED_HONEY_MELON_CHICKEN_BALLS.get()) {
					level.playSound(null, pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F,
							ModSounds.BLOCK_FRYING_PAN_ADD_FOOD.get(), SoundSource.BLOCKS, 0.8F, 1.0F);
					heldStack.shrink(1);
					level.setBlock(pos, state.setValue(STAGE, FryingPanStage.FRYING_PAN_UNFINISHED_HONEY_MELON_CHICKEN_BALLS_AGE0), 3);
				}
				return InteractionResult.SUCCESS;
			}else if (state.getValue(STAGE).equals(FryingPanStage.FRYING_PAN_MILKY_TEA_SUGAR_AGE1)) {//add food(milk tea)
				if (heldStack.getItem() == ModItems.BLACK_TEA_LEAVES_ITEM.get()) {
					level.playSound(null, pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F,
							ModSounds.BLOCK_FRYING_PAN_ADD_FOOD.get(), SoundSource.BLOCKS, 0.8F, 1.0F);
					heldStack.shrink(1);
					level.setBlock(pos, state.setValue(STAGE, FryingPanStage.FRYING_PAN_MILKY_TEA_BLACK_TEA_AGE0), 3);
				}
				return InteractionResult.SUCCESS;
			}else if (state.getValue(STAGE).equals(FryingPanStage.FRYING_PAN_MILKY_TEA_BLACK_TEA_AGE1)) {//add food(milk tea)
				if (heldStack.getItem() == Items.MILK_BUCKET) {
					level.playSound(null, pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F,
							ModSounds.BLOCK_FRYING_PAN_ADD_FOOD.get(), SoundSource.BLOCKS, 0.8F, 1.0F);
					heldStack.shrink(1);
					if (!player.getInventory().add(Items.BUCKET.getDefaultInstance())) {
						player.drop(Items.BUCKET.getDefaultInstance(), false);
					}
					level.setBlock(pos, state.setValue(STAGE, FryingPanStage.FRYING_PAN_MILKY_TEA_MILK_AGE0), 3);
				}
				return InteractionResult.SUCCESS;
			}else if(heldStack.getItem() == ModItems.SPATULA.get()) {//spatula
				RandomSource random = level.random;
				if (random.nextFloat() < 0.1f) {
					if (state.getValue(STAGE).equals(FryingPanStage.FRYING_PAN_STIR_FRIED_BEATING_MELONS_SEEDS_AGE0)) {
						level.setBlock(pos, state.setValue(STAGE, FryingPanStage.FRYING_PAN_STIR_FRIED_BEATING_MELONS_SEEDS_AGE1), 3);
						level.playSound(null, pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F,
								ModSounds.BLOCK_FRYING_PAN_SPATULA.get(), SoundSource.BLOCKS, 0.8F, 1.0F);
					} else if (state.getValue(STAGE) == FryingPanStage.FRYING_PAN_STIR_FRIED_BEATING_MELONS_SEEDS_AGE1) {
						level.setBlock(pos, state.setValue(STAGE, FryingPanStage.FRYING_PAN_STIR_FRIED_BEATING_MELONS_SEEDS_AGE2), 3);
						level.playSound(null, pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F,
								ModSounds.BLOCK_FRYING_PAN_SPATULA.get(), SoundSource.BLOCKS, 0.8F, 1.0F);
					} else if (state.getValue(STAGE).equals(FryingPanStage.FRYING_PAN_CRISPY_LITCHI_BALL_AGE0)) {
						level.setBlock(pos, state.setValue(STAGE, FryingPanStage.FRYING_PAN_CRISPY_LITCHI_BALL_AGE1), 3);
						level.playSound(null, pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F,
								ModSounds.BLOCK_FRYING_PAN_SPATULA.get(), SoundSource.BLOCKS, 0.8F, 1.0F);
					} else if (state.getValue(STAGE) == FryingPanStage.FRYING_PAN_CRISPY_LITCHI_BALL_AGE1) {
						level.setBlock(pos, state.setValue(STAGE, FryingPanStage.FRYING_PAN_CRISPY_LITCHI_BALL_AGE2), 3);
						level.playSound(null, pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F,
								ModSounds.BLOCK_FRYING_PAN_SPATULA.get(), SoundSource.BLOCKS, 0.8F, 1.0F);
					} else if (state.getValue(STAGE).equals(FryingPanStage.FRYING_PAN_UNFINISHED_HONEY_MELON_CHICKEN_BALLS_AGE0)) {
						level.setBlock(pos, state.setValue(STAGE, FryingPanStage.FRYING_PAN_UNFINISHED_HONEY_MELON_CHICKEN_BALLS_AGE1), 3);
						level.playSound(null, pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F,
								ModSounds.BLOCK_FRYING_PAN_SPATULA.get(), SoundSource.BLOCKS, 0.8F, 1.0F);
					} else if (state.getValue(STAGE) == FryingPanStage.FRYING_PAN_UNFINISHED_HONEY_MELON_CHICKEN_BALLS_AGE1) {
						level.setBlock(pos, state.setValue(STAGE, FryingPanStage.FRYING_PAN_UNFINISHED_HONEY_MELON_CHICKEN_BALLS_AGE2), 3);
						level.playSound(null, pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F,
								ModSounds.BLOCK_FRYING_PAN_SPATULA.get(), SoundSource.BLOCKS, 0.8F, 1.0F);
					} else if (state.getValue(STAGE).equals(FryingPanStage.FRYING_PAN_MILKY_TEA_SUGAR_AGE0)) {
						level.setBlock(pos, state.setValue(STAGE, FryingPanStage.FRYING_PAN_MILKY_TEA_SUGAR_AGE1), 3);
						level.playSound(null, pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F,
								ModSounds.BLOCK_FRYING_PAN_SPATULA.get(), SoundSource.BLOCKS, 0.8F, 1.0F);
					} else if (state.getValue(STAGE) == FryingPanStage.FRYING_PAN_MILKY_TEA_BLACK_TEA_AGE0) {
						level.setBlock(pos, state.setValue(STAGE, FryingPanStage.FRYING_PAN_MILKY_TEA_BLACK_TEA_AGE1), 3);
						level.playSound(null, pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F,
								ModSounds.BLOCK_FRYING_PAN_SPATULA.get(), SoundSource.BLOCKS, 0.8F, 1.0F);
					} else if (state.getValue(STAGE).equals(FryingPanStage.FRYING_PAN_MILKY_TEA_MILK_AGE0)) {
						level.setBlock(pos, state.setValue(STAGE, FryingPanStage.FRYING_PAN_MILKY_TEA_MILK_AGE1), 3);
						level.playSound(null, pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F,
								ModSounds.BLOCK_FRYING_PAN_SPATULA.get(), SoundSource.BLOCKS, 0.8F, 1.0F);
					}
				}
				return InteractionResult.SUCCESS;
			}else if(state.getValue(STAGE).equals(FryingPanStage.FRYING_PAN_STIR_FRIED_BEATING_MELONS_SEEDS_AGE2)) {//get beating melons
					if (!player.getInventory().add(ModItems.STIR_FRIED_BEATING_MELONS_SEEDS.get().getDefaultInstance())) {
						player.drop(ModItems.STIR_FRIED_BEATING_MELONS_SEEDS.get().getDefaultInstance(), false);
					}
					level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
				level.setBlock(pos, state.setValue(STAGE, FryingPanStage.NONE), 3);
				return InteractionResult.SUCCESS;
			}else if(heldStack.getItem() == Items.BOWL) {//get bowled food
				if (state.getValue(STAGE).equals(FryingPanStage.FRYING_PAN_CRISPY_LITCHI_BALL_AGE2)) {
					heldStack.shrink(1);
					if (!player.getInventory().add(ModItems.CRISPY_LITCHI_BALL.get().getDefaultInstance())) {
						player.drop(ModItems.CRISPY_LITCHI_BALL.get().getDefaultInstance(), false);
					}
					level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
					level.setBlock(pos, state.setValue(STAGE, FryingPanStage.NONE), 3);
				}
				if (state.getValue(STAGE).equals(FryingPanStage.FRYING_PAN_UNFINISHED_HONEY_MELON_CHICKEN_BALLS_AGE2)) {
					heldStack.shrink(1);
					if (!player.getInventory().add(ModItems.HONEY_MELON_CHICKEN_BALLS.get().getDefaultInstance())) {
						player.drop(ModItems.HONEY_MELON_CHICKEN_BALLS.get().getDefaultInstance(), false);
					}
					level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
					level.setBlock(pos, state.setValue(STAGE, FryingPanStage.NONE), 3);
				}
				return InteractionResult.SUCCESS;
			}else if(state.getValue(STAGE).equals(FryingPanStage.FRYING_PAN_MILKY_TEA_MILK_AGE1) && heldStack.getItem() == ModItems.MILK_TEA_CUP.get()) {//get milky tea
				heldStack.shrink(1);
				if (!player.getInventory().add(ModItems.MILKY_TEA.get().getDefaultInstance())) {
					player.drop(ModItems.MILKY_TEA.get().getDefaultInstance(), false);
				}
				level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
				level.setBlock(pos, state.setValue(STAGE, FryingPanStage.NONE), 3);
				return InteractionResult.SUCCESS;
			}
		}
		if (isice) {
			if (state.getValue(STAGE).equals(FryingPanStage.NONE)) {//add food
				if (heldStack.getItem() == Items.MILK_BUCKET) {
					heldStack.shrink(1);
					if (!player.getInventory().add(Items.BUCKET.getDefaultInstance())) {
						player.drop(Items.BUCKET.getDefaultInstance(), false);
					}
					level.setBlock(pos, state.setValue(STAGE, FryingPanStage.FRYING_PAN_STIR_FRIED_YOGURT_AGE0), 3);
				}
				return InteractionResult.SUCCESS;
			}else if(heldStack.getItem() == ModItems.SPATULA.get()) {//spatula
				RandomSource random = level.random;
				if (random.nextFloat() < 0.1f) {
					if (state.getValue(STAGE).equals(FryingPanStage.FRYING_PAN_STIR_FRIED_YOGURT_AGE0)) {
						level.setBlock(pos, state.setValue(STAGE, FryingPanStage.FRYING_PAN_STIR_FRIED_YOGURT_AGE1), 3);
						level.playSound(null, pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F,
								ModSounds.BLOCK_FRYING_PAN_SPATULA.get(), SoundSource.BLOCKS, 0.8F, 1.0F);
					} else if (state.getValue(STAGE) == FryingPanStage.FRYING_PAN_STIR_FRIED_YOGURT_AGE1) {
						level.setBlock(pos, state.setValue(STAGE, FryingPanStage.FRYING_PAN_STIR_FRIED_YOGURT_AGE2), 3);
						level.playSound(null, pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F,
								ModSounds.BLOCK_FRYING_PAN_SPATULA.get(), SoundSource.BLOCKS, 0.8F, 1.0F);
					}
				}
				return InteractionResult.SUCCESS;
			}else if(heldStack.getItem() == Items.BOWL) {//get bowled food
				if (state.getValue(STAGE).equals(FryingPanStage.FRYING_PAN_STIR_FRIED_YOGURT_AGE2)) {
					heldStack.shrink(1);
					if (!player.getInventory().add(ModItems.STIR_FRIED_YOGURT.get().getDefaultInstance())) {
						player.drop(ModItems.STIR_FRIED_YOGURT.get().getDefaultInstance(), false);
					}
					level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
					level.setBlock(pos, state.setValue(STAGE, FryingPanStage.NONE), 3);
				}
				return InteractionResult.SUCCESS;
			}
		}
		return InteractionResult.PASS;
	}
	@Override
	public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource random) {
		if (!worldIn.isClientSide) {
			if (random.nextFloat() <= 0.5F && state.getValue(STAGE).equals(FryingPanStage.FIRE)) {
				BlockPos blockPos;
				// 在四个方向上生成火焰
				blockPos = pos.north();
				BlockState northBlockState = worldIn.getBlockState(blockPos);
				if (northBlockState.getMaterial().isFlammable()) {
				worldIn.setBlockAndUpdate(blockPos, Blocks.FIRE.defaultBlockState());
				}
				blockPos = pos.south();
				BlockState southBlockState = worldIn.getBlockState(blockPos);
				if (southBlockState.getMaterial().isFlammable()) {
				worldIn.setBlockAndUpdate(blockPos, Blocks.FIRE.defaultBlockState());
				}
				blockPos = pos.east();
				BlockState eastBlockState = worldIn.getBlockState(blockPos);
				if (eastBlockState.getMaterial().isFlammable()) {
				worldIn.setBlockAndUpdate(blockPos, Blocks.FIRE.defaultBlockState());
			    }
				blockPos = pos.west();
				BlockState westBlockState = worldIn.getBlockState(blockPos);
				if (westBlockState.getMaterial().isFlammable()) {
				worldIn.setBlockAndUpdate(blockPos, Blocks.FIRE.defaultBlockState());
		        }
			}
			if (!state.getValue(STAGE).equals(FryingPanStage.NONE) && !state.getValue(STAGE).equals(FryingPanStage.FIRE) && !state.getValue(STAGE).equals(FryingPanStage.POT_COVER) && !state.getValue(STAGE).equals(FryingPanStage.SUNFLOWER_OIL) && random.nextFloat() <= 0.1F) {
				worldIn.setBlock(pos, state.setValue(STAGE, FryingPanStage.FIRE), 3);
			}
		}
	}
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource rand) {
		boolean isHeated = isHeated(level, pos);
		boolean isice = isice(level, pos);
		if (isHeated) {
				double x = (double) pos.getX() + 0.5D;
				double y = pos.getY() + 0.2D;
				double z = (double) pos.getZ() + 0.5D;
				level.addParticle(ParticleTypes.SMOKE, x, y, z, 0.0D, 0.0D, 0.0D);
				if (state.getValue(STAGE).equals(FryingPanStage.SUNFLOWER_OIL)) {
					level.addParticle(ModParticleTypes.OIL.get(), x, y, z, 0.0D, 0.0D, 0.0D);
				}
			if (rand.nextInt(10) == 0 && !state.getValue(STAGE).equals(FryingPanStage.NONE)) {
				level.playLocalSound(x, y, z, ModSounds.BLOCK_FRYING_PAN_SIZZLE.get(), SoundSource.BLOCKS, 0.4F, rand.nextFloat() * 0.2F + 0.9F, false);
			}
		}
		if (isice) {
			double x = (double) pos.getX() + 0.5D;
			double y = pos.getY() + 0.2D;
			double z = (double) pos.getZ() + 0.5D;
			level.addParticle(ParticleTypes.SNOWFLAKE, x, y, z, 0.0D, 0.0D, 0.0D);
		}
		if (isHeated && state.getValue(STAGE).equals(FryingPanStage.FIRE)) {
			double x = (double) pos.getX() + 0.5D;
			double y = pos.getY() + 0.4D;
			double z = (double) pos.getZ() + 0.5D;
			level.addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, x, y, z, 0.0D, 0.0D, 0.0D);
		}
	}
	@Override
	public BlockState rotate(BlockState pState, Rotation pRot) {
		return pState.setValue(FACING, pRot.rotate(pState.getValue(FACING)));
	}

	@Override
	public BlockState mirror(BlockState pState, Mirror pMirror) {
		return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
	}
	@Override
	public RenderShape getRenderShape(BlockState pState) {
		return RenderShape.MODEL;
	}
	@Override
	public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
		boolean isHeated = isHeated(level, pos);
		if (isHeated && !entity.fireImmune() && entity instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity) entity)) {
			entity.hurt(FRYING_PAN_DAMAGE, 1.0F);
		}

		super.stepOn(level, pos, state, entity);
	}

	boolean isHeated(Level level, BlockPos pos) {
		BlockState stateBelow = level.getBlockState(pos.below());
		if (stateBelow.is(ModBlocks.CLAY_OVEN.get())) {
			return true;
		}
		return false;
	}
	boolean isice(Level level, BlockPos pos) {
		BlockState stateBelow = level.getBlockState(pos.below());
		if (stateBelow.is(Blocks.BLUE_ICE)) {
			return true;
		}
		return false;
	}
}
package com.fruitstack.fruitstack.common.block;

import com.fruitstack.fruitstack.common.block.entity.JuicerBlockEntity;
import com.fruitstack.fruitstack.common.registry.ModBlocks;
import com.fruitstack.fruitstack.common.registry.ModItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
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
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;

import java.util.Random;
import java.util.function.Supplier;

public class PopsicleMachineBlock extends Block {
	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
	public static final IntegerProperty STAGE = IntegerProperty.create("stage", 0, 3);
	protected static final VoxelShape SHAPE = Block.box(0.0, 1.0, 0.0, 16.0, 9.0, 16.0);
	public PopsicleMachineBlock(BlockBehaviour.Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(STAGE, 0));
	}

	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}

	public boolean isRandomlyTicking(BlockState state) {
		return true;
	}
    @Override
	public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
		return !level.isEmptyBlock(pos.below());
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING,STAGE);
		super.createBlockStateDefinition(builder);
	}
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player,
								 InteractionHand hand, BlockHitResult result) {
		ItemStack heldStack = player.getItemInHand(hand);
		int stage = state.getValue(STAGE);
		if (!level.isClientSide) {
			if (stage == 0 && heldStack.getItem() == Items.WATER_BUCKET) {
				heldStack.shrink(1);
				if (!player.getInventory().add(Items.BUCKET.getDefaultInstance())) {
					player.drop(Items.BUCKET.getDefaultInstance(), false);
				}
				level.setBlock(pos, state.setValue(STAGE, 1), 3);
				level.playSound(null, pos, SoundEvents.AMBIENT_UNDERWATER_LOOP, SoundSource.BLOCKS, 1.0F, 1.0F);
				return InteractionResult.SUCCESS;
			}
			if (stage == 3) {
				if (!player.getInventory().add(Items.ICE.getDefaultInstance())) {
					player.drop(Items.ICE.getDefaultInstance(), false);
				}
				level.setBlock(pos, state.setValue(STAGE, 0), 3);
				level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
				return InteractionResult.SUCCESS;
			}
			if (stage == 0 && heldStack.getItem() == ModItems.BLUEBERRIES_JUICE.get() && heldStack.getCount() >= 2) {
				heldStack.shrink(2);
				for (int i = 0; i < 2; i++) {
					if (!player.getInventory().add(ModItems.JUICE_CUP.get().getDefaultInstance().copy())) {
						player.drop(ModItems.JUICE_CUP.get().getDefaultInstance().copy(), false);
					}
				}
				level.playSound(null, pos, SoundEvents.HONEY_DRINK, SoundSource.BLOCKS, 1.0F, 1.0F);
				BlockPlaceContext blockPlaceContext = new BlockPlaceContext(new UseOnContext(level, player, hand, heldStack, result));
				BlockState originalState = level.getBlockState(pos);
				Direction originalDirection = originalState.getValue(BlockStateProperties.HORIZONTAL_FACING);
				BlockState newState = ModBlocks.BLUEBERRIES_POPSICLE_MACHINE.get().getStateForPlacement(blockPlaceContext);
				newState = newState.setValue(BlockStateProperties.HORIZONTAL_FACING, originalDirection);
				level.setBlock(pos, newState, 3);
				return InteractionResult.SUCCESS;
			}
			if (stage == 0 && heldStack.getItem() == ModItems.HAMIMELON_JUICE.get() && heldStack.getCount() >= 2) {
				heldStack.shrink(2);
				for (int i = 0; i < 2; i++) {
					if (!player.getInventory().add(ModItems.JUICE_CUP.get().getDefaultInstance().copy())) {
						player.drop(ModItems.JUICE_CUP.get().getDefaultInstance().copy(), false);
					}
				}
				level.playSound(null, pos, SoundEvents.HONEY_DRINK, SoundSource.BLOCKS, 1.0F, 1.0F);
				BlockPlaceContext blockPlaceContext = new BlockPlaceContext(new UseOnContext(level, player, hand, heldStack, result));
				BlockState originalState = level.getBlockState(pos);
				Direction originalDirection = originalState.getValue(BlockStateProperties.HORIZONTAL_FACING);
				BlockState newState = ModBlocks.HAMIMELON_POPSICLE_MACHINE.get().getStateForPlacement(blockPlaceContext);
				newState = newState.setValue(BlockStateProperties.HORIZONTAL_FACING, originalDirection);
				level.setBlock(pos, newState, 3);
				return InteractionResult.SUCCESS;
			}
			if (stage == 0 && heldStack.getItem() == ModItems.BEATING_MELONS_JUICE.get() && heldStack.getCount() >= 2) {
				heldStack.shrink(2);
				for (int i = 0; i < 2; i++) {
					if (!player.getInventory().add(ModItems.JUICE_CUP.get().getDefaultInstance().copy())) {
						player.drop(ModItems.JUICE_CUP.get().getDefaultInstance().copy(), false);
					}
				}
				level.playSound(null, pos, SoundEvents.HONEY_DRINK, SoundSource.BLOCKS, 1.0F, 1.0F);
				BlockPlaceContext blockPlaceContext = new BlockPlaceContext(new UseOnContext(level, player, hand, heldStack, result));
				BlockState originalState = level.getBlockState(pos);
				Direction originalDirection = originalState.getValue(BlockStateProperties.HORIZONTAL_FACING);
				BlockState newState = ModBlocks.BEATING_MELONS_POPSICLE_MACHINE.get().getStateForPlacement(blockPlaceContext);
				newState = newState.setValue(BlockStateProperties.HORIZONTAL_FACING, originalDirection);
				level.setBlock(pos, newState, 3);
				return InteractionResult.SUCCESS;
			}
			if (stage == 0 && heldStack.getItem() == ModItems.GROUND_CUCUMBER_JUICE.get() && heldStack.getCount() >= 2) {
				heldStack.shrink(2);
				for (int i = 0; i < 2; i++) {
					if (!player.getInventory().add(ModItems.JUICE_CUP.get().getDefaultInstance().copy())) {
						player.drop(ModItems.JUICE_CUP.get().getDefaultInstance().copy(), false);
					}
				}
				level.playSound(null, pos, SoundEvents.HONEY_DRINK, SoundSource.BLOCKS, 1.0F, 1.0F);
				BlockPlaceContext blockPlaceContext = new BlockPlaceContext(new UseOnContext(level, player, hand, heldStack, result));
				BlockState originalState = level.getBlockState(pos);
				Direction originalDirection = originalState.getValue(BlockStateProperties.HORIZONTAL_FACING);
				BlockState newState = ModBlocks.GROUND_CUCUMBER_POPSICLE_MACHINE.get().getStateForPlacement(blockPlaceContext);
				newState = newState.setValue(BlockStateProperties.HORIZONTAL_FACING, originalDirection);
				level.setBlock(pos, newState, 3);
				return InteractionResult.SUCCESS;
			}
			if (stage == 0 && heldStack.getItem() == ModItems.MANGO_JUICE.get() && heldStack.getCount() >= 2) {
				heldStack.shrink(2);
				for (int i = 0; i < 2; i++) {
					if (!player.getInventory().add(ModItems.JUICE_CUP.get().getDefaultInstance().copy())) {
						player.drop(ModItems.JUICE_CUP.get().getDefaultInstance().copy(), false);
					}
				}
				level.playSound(null, pos, SoundEvents.HONEY_DRINK, SoundSource.BLOCKS, 1.0F, 1.0F);
				BlockPlaceContext blockPlaceContext = new BlockPlaceContext(new UseOnContext(level, player, hand, heldStack, result));
				BlockState originalState = level.getBlockState(pos);
				Direction originalDirection = originalState.getValue(BlockStateProperties.HORIZONTAL_FACING);
				BlockState newState = ModBlocks.MANGO_POPSICLE_MACHINE.get().getStateForPlacement(blockPlaceContext);
				newState = newState.setValue(BlockStateProperties.HORIZONTAL_FACING, originalDirection);
				level.setBlock(pos, newState, 3);
				return InteractionResult.SUCCESS;
			}
			if (stage == 0 && heldStack.getItem() == ModItems.HOLBOELLIA_LATIFOLIA_JUICE.get() && heldStack.getCount() >= 2) {
				heldStack.shrink(2);
				for (int i = 0; i < 2; i++) {
					if (!player.getInventory().add(ModItems.JUICE_CUP.get().getDefaultInstance().copy())) {
						player.drop(ModItems.JUICE_CUP.get().getDefaultInstance().copy(), false);
					}
				}
				level.playSound(null, pos, SoundEvents.HONEY_DRINK, SoundSource.BLOCKS, 1.0F, 1.0F);
				BlockPlaceContext blockPlaceContext = new BlockPlaceContext(new UseOnContext(level, player, hand, heldStack, result));
				BlockState originalState = level.getBlockState(pos);
				Direction originalDirection = originalState.getValue(BlockStateProperties.HORIZONTAL_FACING);
				BlockState newState = ModBlocks.HOLBOELLIA_LATIFOLIA_POPSICLE_MACHINE.get().getStateForPlacement(blockPlaceContext);
				newState = newState.setValue(BlockStateProperties.HORIZONTAL_FACING, originalDirection);
				level.setBlock(pos, newState, 3);
				return InteractionResult.SUCCESS;
			}
			if (stage == 0 && heldStack.getItem() == ModItems.LITCHI_JUICE.get() && heldStack.getCount() >= 2) {
				heldStack.shrink(2);
				for (int i = 0; i < 2; i++) {
					if (!player.getInventory().add(ModItems.JUICE_CUP.get().getDefaultInstance().copy())) {
						player.drop(ModItems.JUICE_CUP.get().getDefaultInstance().copy(), false);
					}
				}
				level.playSound(null, pos, SoundEvents.HONEY_DRINK, SoundSource.BLOCKS, 1.0F, 1.0F);
				BlockPlaceContext blockPlaceContext = new BlockPlaceContext(new UseOnContext(level, player, hand, heldStack, result));
				BlockState originalState = level.getBlockState(pos);
				Direction originalDirection = originalState.getValue(BlockStateProperties.HORIZONTAL_FACING);
				BlockState newState = ModBlocks.LITCHI_POPSICLE_MACHINE.get().getStateForPlacement(blockPlaceContext);
				newState = newState.setValue(BlockStateProperties.HORIZONTAL_FACING, originalDirection);
				level.setBlock(pos, newState, 3);
				return InteractionResult.SUCCESS;
			}
			if (stage == 0 && heldStack.getItem() == ModItems.HUOSHEN_FRUIT_JUICE.get() && heldStack.getCount() >= 2) {
				heldStack.shrink(2);
				for (int i = 0; i < 2; i++) {
					if (!player.getInventory().add(ModItems.JUICE_CUP.get().getDefaultInstance().copy())) {
						player.drop(ModItems.JUICE_CUP.get().getDefaultInstance().copy(), false);
					}
				}
				level.playSound(null, pos, SoundEvents.HONEY_DRINK, SoundSource.BLOCKS, 1.0F, 1.0F);
				BlockPlaceContext blockPlaceContext = new BlockPlaceContext(new UseOnContext(level, player, hand, heldStack, result));
				BlockState originalState = level.getBlockState(pos);
				Direction originalDirection = originalState.getValue(BlockStateProperties.HORIZONTAL_FACING);
				BlockState newState = ModBlocks.HUOSHEN_FRUIT_POPSICLE_MACHINE.get().getStateForPlacement(blockPlaceContext);
				newState = newState.setValue(BlockStateProperties.HORIZONTAL_FACING, originalDirection);
				level.setBlock(pos, newState, 3);
				return InteractionResult.SUCCESS;
			}
			if (stage == 0 && heldStack.getItem() == ModItems.SEPTEMBER_MELON_JUICE.get() && heldStack.getCount() >= 2) {
				heldStack.shrink(2);
				for (int i = 0; i < 2; i++) {
					if (!player.getInventory().add(ModItems.JUICE_CUP.get().getDefaultInstance().copy())) {
						player.drop(ModItems.JUICE_CUP.get().getDefaultInstance().copy(), false);
					}
				}
				level.playSound(null, pos, SoundEvents.HONEY_DRINK, SoundSource.BLOCKS, 1.0F, 1.0F);
				BlockPlaceContext blockPlaceContext = new BlockPlaceContext(new UseOnContext(level, player, hand, heldStack, result));
				BlockState originalState = level.getBlockState(pos);
				Direction originalDirection = originalState.getValue(BlockStateProperties.HORIZONTAL_FACING);
				BlockState newState = ModBlocks.SEPTEMBER_MELON_POPSICLE_MACHINE.get().getStateForPlacement(blockPlaceContext);
				newState = newState.setValue(BlockStateProperties.HORIZONTAL_FACING, originalDirection);
				level.setBlock(pos, newState, 3);
				return InteractionResult.SUCCESS;
			}
			if (stage == 0 && heldStack.getItem() == ModItems.PITAYA_JUICE.get() && heldStack.getCount() >= 2) {
				heldStack.shrink(2);
				for (int i = 0; i < 2; i++) {
					if (!player.getInventory().add(ModItems.JUICE_CUP.get().getDefaultInstance().copy())) {
						player.drop(ModItems.JUICE_CUP.get().getDefaultInstance().copy(), false);
					}
				}
				level.playSound(null, pos, SoundEvents.HONEY_DRINK, SoundSource.BLOCKS, 1.0F, 1.0F);
				BlockPlaceContext blockPlaceContext = new BlockPlaceContext(new UseOnContext(level, player, hand, heldStack, result));
				BlockState originalState = level.getBlockState(pos);
				Direction originalDirection = originalState.getValue(BlockStateProperties.HORIZONTAL_FACING);
				BlockState newState = ModBlocks.PITAYA_POPSICLE_MACHINE.get().getStateForPlacement(blockPlaceContext);
				newState = newState.setValue(BlockStateProperties.HORIZONTAL_FACING, originalDirection);
				level.setBlock(pos, newState, 3);
				return InteractionResult.SUCCESS;
			}
			if (stage == 0 && heldStack.getItem() == ModItems.GOLDEN_PURE_SHEEP_HORN_HONEY_JUICE.get() && heldStack.getCount() >= 2) {
				heldStack.shrink(2);
				for (int i = 0; i < 2; i++) {
					if (!player.getInventory().add(ModItems.JUICE_CUP.get().getDefaultInstance().copy())) {
						player.drop(ModItems.JUICE_CUP.get().getDefaultInstance().copy(), false);
					}
				}
				level.playSound(null, pos, SoundEvents.HONEY_DRINK, SoundSource.BLOCKS, 1.0F, 1.0F);
				BlockPlaceContext blockPlaceContext = new BlockPlaceContext(new UseOnContext(level, player, hand, heldStack, result));
				BlockState originalState = level.getBlockState(pos);
				Direction originalDirection = originalState.getValue(BlockStateProperties.HORIZONTAL_FACING);
				BlockState newState = ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_POPSICLE_MACHINE.get().getStateForPlacement(blockPlaceContext);
				newState = newState.setValue(BlockStateProperties.HORIZONTAL_FACING, originalDirection);
				level.setBlock(pos, newState, 3);
				return InteractionResult.SUCCESS;
			}
			if (stage == 0 && heldStack.getItem() == ModItems.PEAR_JUICE.get() && heldStack.getCount() >= 2) {
				heldStack.shrink(2);
				for (int i = 0; i < 2; i++) {
					if (!player.getInventory().add(ModItems.JUICE_CUP.get().getDefaultInstance().copy())) {
						player.drop(ModItems.JUICE_CUP.get().getDefaultInstance().copy(), false);
					}
				}
				level.playSound(null, pos, SoundEvents.HONEY_DRINK, SoundSource.BLOCKS, 1.0F, 1.0F);
				BlockPlaceContext blockPlaceContext = new BlockPlaceContext(new UseOnContext(level, player, hand, heldStack, result));
				BlockState originalState = level.getBlockState(pos);
				Direction originalDirection = originalState.getValue(BlockStateProperties.HORIZONTAL_FACING);
				BlockState newState = ModBlocks.PEAR_POPSICLE_MACHINE.get().getStateForPlacement(blockPlaceContext);
				newState = newState.setValue(BlockStateProperties.HORIZONTAL_FACING, originalDirection);
				level.setBlock(pos, newState, 3);
				return InteractionResult.SUCCESS;
			}
			if (stage == 0 && heldStack.getItem() == ModItems.MAYTHORN_JUICE.get() && heldStack.getCount() >= 2) {
				heldStack.shrink(2);
				for (int i = 0; i < 2; i++) {
					if (!player.getInventory().add(ModItems.JUICE_CUP.get().getDefaultInstance().copy())) {
						player.drop(ModItems.JUICE_CUP.get().getDefaultInstance().copy(), false);
					}
				}
				level.playSound(null, pos, SoundEvents.HONEY_DRINK, SoundSource.BLOCKS, 1.0F, 1.0F);
				BlockPlaceContext blockPlaceContext = new BlockPlaceContext(new UseOnContext(level, player, hand, heldStack, result));
				BlockState originalState = level.getBlockState(pos);
				Direction originalDirection = originalState.getValue(BlockStateProperties.HORIZONTAL_FACING);
				BlockState newState = ModBlocks.MAYTHORN_POPSICLE_MACHINE.get().getStateForPlacement(blockPlaceContext);
				newState = newState.setValue(BlockStateProperties.HORIZONTAL_FACING, originalDirection);
				level.setBlock(pos, newState, 3);
				return InteractionResult.SUCCESS;
			}
			if (stage == 0 && heldStack.getItem() == ModItems.CHINESE_PEAR_LEAVED_JUICE.get() && heldStack.getCount() >= 2) {
				heldStack.shrink(2);
				for (int i = 0; i < 2; i++) {
					if (!player.getInventory().add(ModItems.JUICE_CUP.get().getDefaultInstance().copy())) {
						player.drop(ModItems.JUICE_CUP.get().getDefaultInstance().copy(), false);
					}
				}
				level.playSound(null, pos, SoundEvents.HONEY_DRINK, SoundSource.BLOCKS, 1.0F, 1.0F);
				BlockPlaceContext blockPlaceContext = new BlockPlaceContext(new UseOnContext(level, player, hand, heldStack, result));
				BlockState originalState = level.getBlockState(pos);
				Direction originalDirection = originalState.getValue(BlockStateProperties.HORIZONTAL_FACING);
				BlockState newState = ModBlocks.CHINESE_PEAR_LEAVED_POPSICLE_MACHINE.get().getStateForPlacement(blockPlaceContext);
				newState = newState.setValue(BlockStateProperties.HORIZONTAL_FACING, originalDirection);
				level.setBlock(pos, newState, 3);
				return InteractionResult.SUCCESS;
			}
			if (stage == 0 && heldStack.getItem() == ModItems.PLUM_JUICE.get() && heldStack.getCount() >= 2) {
				heldStack.shrink(2);
				for (int i = 0; i < 2; i++) {
					if (!player.getInventory().add(ModItems.JUICE_CUP.get().getDefaultInstance().copy())) {
						player.drop(ModItems.JUICE_CUP.get().getDefaultInstance().copy(), false);
					}
				}
				level.playSound(null, pos, SoundEvents.HONEY_DRINK, SoundSource.BLOCKS, 1.0F, 1.0F);
				BlockPlaceContext blockPlaceContext = new BlockPlaceContext(new UseOnContext(level, player, hand, heldStack, result));
				BlockState originalState = level.getBlockState(pos);
				Direction originalDirection = originalState.getValue(BlockStateProperties.HORIZONTAL_FACING);
				BlockState newState = ModBlocks.PLUM_POPSICLE_MACHINE.get().getStateForPlacement(blockPlaceContext);
				newState = newState.setValue(BlockStateProperties.HORIZONTAL_FACING, originalDirection);
				level.setBlock(pos, newState, 3);
				return InteractionResult.SUCCESS;
			}
			if (stage == 0 && heldStack.getItem() == ModItems.JUJUBE_JUICE.get() && heldStack.getCount() >= 2) {
				heldStack.shrink(2);
				for (int i = 0; i < 2; i++) {
					if (!player.getInventory().add(ModItems.JUICE_CUP.get().getDefaultInstance().copy())) {
						player.drop(ModItems.JUICE_CUP.get().getDefaultInstance().copy(), false);
					}
				}
				level.playSound(null, pos, SoundEvents.HONEY_DRINK, SoundSource.BLOCKS, 1.0F, 1.0F);
				BlockPlaceContext blockPlaceContext = new BlockPlaceContext(new UseOnContext(level, player, hand, heldStack, result));
				BlockState originalState = level.getBlockState(pos);
				Direction originalDirection = originalState.getValue(BlockStateProperties.HORIZONTAL_FACING);
				BlockState newState = ModBlocks.JUJUBE_POPSICLE_MACHINE.get().getStateForPlacement(blockPlaceContext);
				newState = newState.setValue(BlockStateProperties.HORIZONTAL_FACING, originalDirection);
				level.setBlock(pos, newState, 3);
				return InteractionResult.SUCCESS;
			}
			if (stage == 0 && heldStack.getItem() == ModItems.APRICOT_JUICE.get() && heldStack.getCount() >= 2) {
				heldStack.shrink(2);
				for (int i = 0; i < 2; i++) {
					if (!player.getInventory().add(ModItems.JUICE_CUP.get().getDefaultInstance().copy())) {
						player.drop(ModItems.JUICE_CUP.get().getDefaultInstance().copy(), false);
					}
				}
				level.playSound(null, pos, SoundEvents.HONEY_DRINK, SoundSource.BLOCKS, 1.0F, 1.0F);
				BlockPlaceContext blockPlaceContext = new BlockPlaceContext(new UseOnContext(level, player, hand, heldStack, result));
				BlockState originalState = level.getBlockState(pos);
				Direction originalDirection = originalState.getValue(BlockStateProperties.HORIZONTAL_FACING);
				BlockState newState = ModBlocks.APRICOT_POPSICLE_MACHINE.get().getStateForPlacement(blockPlaceContext);
				newState = newState.setValue(BlockStateProperties.HORIZONTAL_FACING, originalDirection);
				level.setBlock(pos, newState, 3);
				return InteractionResult.SUCCESS;
			}
			if (stage == 0 && heldStack.getItem() == ModItems.RED_BAYBERRY_JUICE.get() && heldStack.getCount() >= 2) {
				heldStack.shrink(2);
				for (int i = 0; i < 2; i++) {
					if (!player.getInventory().add(ModItems.JUICE_CUP.get().getDefaultInstance().copy())) {
						player.drop(ModItems.JUICE_CUP.get().getDefaultInstance().copy(), false);
					}
				}
				level.playSound(null, pos, SoundEvents.HONEY_DRINK, SoundSource.BLOCKS, 1.0F, 1.0F);
				BlockPlaceContext blockPlaceContext = new BlockPlaceContext(new UseOnContext(level, player, hand, heldStack, result));
				BlockState originalState = level.getBlockState(pos);
				Direction originalDirection = originalState.getValue(BlockStateProperties.HORIZONTAL_FACING);
				BlockState newState = ModBlocks.RED_BAYBERRY_POPSICLE_MACHINE.get().getStateForPlacement(blockPlaceContext);
				newState = newState.setValue(BlockStateProperties.HORIZONTAL_FACING, originalDirection);
				level.setBlock(pos, newState, 3);
				return InteractionResult.SUCCESS;
			}
			if (stage == 0 && heldStack.getItem() == ModItems.GREEN_PLUM_JUICE.get() && heldStack.getCount() >= 2) {
				heldStack.shrink(2);
				for (int i = 0; i < 2; i++) {
					if (!player.getInventory().add(ModItems.JUICE_CUP.get().getDefaultInstance().copy())) {
						player.drop(ModItems.JUICE_CUP.get().getDefaultInstance().copy(), false);
					}
				}
				level.playSound(null, pos, SoundEvents.HONEY_DRINK, SoundSource.BLOCKS, 1.0F, 1.0F);
				BlockPlaceContext blockPlaceContext = new BlockPlaceContext(new UseOnContext(level, player, hand, heldStack, result));
				BlockState originalState = level.getBlockState(pos);
				Direction originalDirection = originalState.getValue(BlockStateProperties.HORIZONTAL_FACING);
				BlockState newState = ModBlocks.GREEN_PLUM_POPSICLE_MACHINE.get().getStateForPlacement(blockPlaceContext);
				newState = newState.setValue(BlockStateProperties.HORIZONTAL_FACING, originalDirection);
				level.setBlock(pos, newState, 3);
				return InteractionResult.SUCCESS;
			}
			if (stage == 0 && heldStack.getItem() == ModItems.GRAPE_JUICE.get() && heldStack.getCount() >= 2) {
				heldStack.shrink(2);
				for (int i = 0; i < 2; i++) {
					if (!player.getInventory().add(ModItems.JUICE_CUP.get().getDefaultInstance().copy())) {
						player.drop(ModItems.JUICE_CUP.get().getDefaultInstance().copy(), false);
					}
				}
				level.playSound(null, pos, SoundEvents.HONEY_DRINK, SoundSource.BLOCKS, 1.0F, 1.0F);
				BlockPlaceContext blockPlaceContext = new BlockPlaceContext(new UseOnContext(level, player, hand, heldStack, result));
				BlockState originalState = level.getBlockState(pos);
				Direction originalDirection = originalState.getValue(BlockStateProperties.HORIZONTAL_FACING);
				BlockState newState = ModBlocks.GRAPE_POPSICLE_MACHINE.get().getStateForPlacement(blockPlaceContext);
				newState = newState.setValue(BlockStateProperties.HORIZONTAL_FACING, originalDirection);
				level.setBlock(pos, newState, 3);
				return InteractionResult.SUCCESS;
			}
			if (stage == 0 && heldStack.getItem() == ModItems.PEACH_JUICE.get() && heldStack.getCount() >= 2) {
				heldStack.shrink(2);
				for (int i = 0; i < 2; i++) {
					if (!player.getInventory().add(ModItems.JUICE_CUP.get().getDefaultInstance().copy())) {
						player.drop(ModItems.JUICE_CUP.get().getDefaultInstance().copy(), false);
					}
				}
				level.playSound(null, pos, SoundEvents.HONEY_DRINK, SoundSource.BLOCKS, 1.0F, 1.0F);
				BlockPlaceContext blockPlaceContext = new BlockPlaceContext(new UseOnContext(level, player, hand, heldStack, result));
				BlockState originalState = level.getBlockState(pos);
				Direction originalDirection = originalState.getValue(BlockStateProperties.HORIZONTAL_FACING);
				BlockState newState = ModBlocks.PEACH_POPSICLE_MACHINE.get().getStateForPlacement(blockPlaceContext);
				newState = newState.setValue(BlockStateProperties.HORIZONTAL_FACING, originalDirection);
				level.setBlock(pos, newState, 3);
				return InteractionResult.SUCCESS;
			}
		}
		return InteractionResult.PASS;
	}
	@Override
	public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource random) {
		if (!worldIn.isClientSide) {
			if (isDaytime(worldIn) && !worldIn.isRaining() && worldIn.canSeeSky(pos)) {
				if (worldIn.canSeeSky(pos)) {
					if (random.nextFloat() <= 0.1F) {
						int stage = state.getValue(STAGE);
						if (stage == 1) {
							worldIn.setBlock(pos, state.setValue(STAGE, 2), 3);
							worldIn.updateNeighborsAt(pos, this); // 通知周围方块更新红石信号
						} else if (stage == 2) {
							worldIn.setBlock(pos, state.setValue(STAGE, 3), 3);
							worldIn.updateNeighborsAt(pos, this); // 通知周围方块更新红石信号
						}
					}
				}
			}
		}
	}
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState stateIn, Level level, BlockPos pos, RandomSource rand) {
		if (isDaytime(level) && !level.isRaining() && level.canSeeSky(pos)) {
			if (level.canSeeSky(pos)) {
				double x = (double) pos.getX() + 0.5D;
				double y = pos.getY() + 0.6D; // 在方块正上方生成粒子
				double z = (double) pos.getZ() + 0.5D;
				level.addParticle(ParticleTypes.SNOWFLAKE, x, y, z, 0.0D, 0.0D, 0.0D);
			}
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
	public boolean canConnectRedstone(BlockState state, BlockGetter world, BlockPos pos, Direction side) {
		return true;
	}
	public boolean isSignalSource(BlockState p_55213_) {
		return true;
	}
	public int getSignal(BlockState p_55208_, BlockGetter p_55209_, BlockPos p_55210_, Direction p_55211_) {
		int age = p_55208_.getValue(STAGE);
		return age + 1;
	}
	private boolean isDaytime(Level world) {
		long timeOfDay = world.getDayTime() % 24000;
		return timeOfDay >= 0 && timeOfDay < 12000;
	}
}
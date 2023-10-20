package com.fruitstack.fruitstack.common.block;

import com.fruitstack.fruitstack.common.block.entity.ClayOvenBlockEntity;
import com.fruitstack.fruitstack.common.registry.ModBlockEntityTypes;
import com.fruitstack.fruitstack.common.registry.ModDamageTypes;
import com.fruitstack.fruitstack.common.registry.ModSounds;
import com.fruitstack.fruitstack.common.utility.MathUtils;
import com.fruitstack.fruitstack.common.utility.ItemUtils;
import com.fruitstack.fruitstack.fruitstack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.crafting.CampfireCookingRecipe;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolActions;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.Random;

@SuppressWarnings("deprecation")
public class ClayOvenBlock extends BaseEntityBlock
{
	public static final BooleanProperty LIT = BlockStateProperties.LIT;
	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

	public ClayOvenBlock(Properties properties) {
		super(Properties.of().mapColor(MapColor.STONE)
				.strength(2F, 6.0F)
				.sound(SoundType.STONE));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(LIT, false));
	}

	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
		ItemStack heldStack = player.getItemInHand(hand);
		Item heldItem = heldStack.getItem();

		if (state.getValue(LIT)) {
			if (heldStack.canPerformAction(ToolActions.SHOVEL_DIG)) {
				extinguish(state, level, pos);
				heldStack.hurtAndBreak(1, player, action -> action.broadcastBreakEvent(hand));
				return InteractionResult.SUCCESS;
			} else if (heldItem == Items.WATER_BUCKET) {
				if (!level.isClientSide()) {
					level.playSound(null, pos, SoundEvents.GENERIC_EXTINGUISH_FIRE, SoundSource.BLOCKS, 1.0F, 1.0F);
				}
				extinguish(state, level, pos);
				if (!player.isCreative()) {
					player.setItemInHand(hand, new ItemStack(Items.BUCKET));
				}
				return InteractionResult.SUCCESS;
			}
		} else {
			if (heldItem instanceof FlintAndSteelItem) {
				level.playSound(player, pos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0F, MathUtils.RAND.nextFloat() * 0.4F + 0.8F);
				level.setBlock(pos, state.setValue(BlockStateProperties.LIT, Boolean.TRUE), 11);
				heldStack.hurtAndBreak(1, player, action -> action.broadcastBreakEvent(hand));
				return InteractionResult.SUCCESS;
			} else if (heldItem instanceof FireChargeItem) {
				level.playSound(null, pos, SoundEvents.FIRECHARGE_USE, SoundSource.BLOCKS, 1.0F, (MathUtils.RAND.nextFloat() - MathUtils.RAND.nextFloat()) * 0.2F + 1.0F);
				level.setBlock(pos, state.setValue(BlockStateProperties.LIT, Boolean.TRUE), 11);
				if (!player.isCreative()) {
					heldStack.shrink(1);
				}
				return InteractionResult.SUCCESS;
			}
		}

		BlockEntity tileEntity = level.getBlockEntity(pos);
		if (tileEntity instanceof ClayOvenBlockEntity calyovenEntity) {
			int calyovenSlot = calyovenEntity.getNextEmptySlot();
			if (calyovenSlot < 0 || calyovenEntity.isCalyOvenBlockedAbove()) {
				return InteractionResult.PASS;
			}
			Optional<CampfireCookingRecipe> recipe = calyovenEntity.getMatchingRecipe(new SimpleContainer(heldStack), calyovenSlot);
			if (recipe.isPresent()) {
				if (!level.isClientSide && calyovenEntity.addItem(player.getAbilities().instabuild ? heldStack.copy() : heldStack, recipe.get(), calyovenSlot)) {
					return InteractionResult.SUCCESS;
				}
				return InteractionResult.CONSUME;
			}
		}

		return InteractionResult.PASS;
	}

	@Override
	public RenderShape getRenderShape(BlockState pState) {
		return RenderShape.MODEL;
	}

	public void extinguish(BlockState state, Level level, BlockPos pos) {
		level.setBlock(pos, state.setValue(LIT, false), 2);
		double x = (double) pos.getX() + 0.5D;
		double y = pos.getY();
		double z = (double) pos.getZ() + 0.5D;
		level.playLocalSound(x, y, z, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS, 0.5F, 2.6F, false);
	}

	@Override
	public BlockState getStateForPlacement (BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(LIT, true);
	}

	@Override
	public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
		boolean isLit = level.getBlockState(pos).getValue(ClayOvenBlock.LIT);
		if (isLit && !entity.fireImmune() && entity instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity) entity)) {
			entity.hurt(ModDamageTypes.getSimpleDamageSource(level, ModDamageTypes.CLAYOVEN_BURN), 1.0F);
		}

		super.stepOn(level, pos, state, entity);
	}

	@Override
	public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			BlockEntity tileEntity = level.getBlockEntity(pos);
			if (tileEntity instanceof ClayOvenBlockEntity) {
				ItemUtils.dropItems(level, pos, ((ClayOvenBlockEntity) tileEntity).getInventory());
			}

			super.onRemove(state, level, pos, newState, isMoving);
		}
	}

	@Override
	protected void createBlockStateDefinition(final StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(LIT, FACING);
	}

	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState stateIn, Level level, BlockPos pos, RandomSource rand) {
		if (stateIn.getValue(CampfireBlock.LIT)) {
			double x = (double) pos.getX() + 0.5D;
			double y = pos.getY();
			double z = (double) pos.getZ() + 0.5D;
			if (rand.nextInt(10) == 0) {
				level.playLocalSound(x, y, z, ModSounds.BLOCK_CLAY_OVEN_CRACKLE.get(), SoundSource.BLOCKS, 1.0F, 1.0F, false);
			}

			Direction direction = stateIn.getValue(HorizontalDirectionalBlock.FACING);
			Direction.Axis direction$axis = direction.getAxis();
			double horizontalOffset = rand.nextDouble() * 0.6D - 0.3D;
			double xOffset = direction$axis == Direction.Axis.X ? (double) direction.getStepX() * 0.52D : horizontalOffset;
			double yOffset = rand.nextDouble() * 6.0D / 16.0D;
			double zOffset = direction$axis == Direction.Axis.Z ? (double) direction.getStepZ() * 0.52D : horizontalOffset;
			level.addParticle(ParticleTypes.SMOKE, x + xOffset, y + yOffset, z + zOffset, 0.0D, 0.0D, 0.0D);
			level.addParticle(ParticleTypes.FLAME, x + xOffset, y + yOffset, z + zOffset, 0.0D, 0.0D, 0.0D);
		}
	}

	@Nullable
	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return ModBlockEntityTypes.CLAY_OVEN.get().create(pos, state);
	}
	@Nullable
	@Override
	public BlockPathTypes getBlockPathType(BlockState state, BlockGetter world, BlockPos pos, @Nullable Mob entity) {
		return state.getValue(LIT) ? BlockPathTypes.DAMAGE_FIRE : null;
	}

	@Override
	public BlockState rotate(BlockState pState, Rotation pRot) {
		return pState.setValue(FACING, pRot.rotate(pState.getValue(FACING)));
	}

	@Override
	public BlockState mirror(BlockState pState, Mirror pMirror) {
		return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
	}
}

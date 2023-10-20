package com.fruitstack.fruitstack.common.block;


import com.fruitstack.fruitstack.common.block.entity.PlateBlockEntity;
import com.fruitstack.fruitstack.common.registry.ModBlockEntityTypes;
import com.fruitstack.fruitstack.common.registry.ModItems;
import com.fruitstack.fruitstack.common.registry.ModSounds;
import com.fruitstack.fruitstack.common.utility.MathUtils;
import com.fruitstack.fruitstack.fruitstack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import com.fruitstack.fruitstack.common.utility.ItemUtils;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;
import java.util.Random;

@SuppressWarnings("deprecation")
public class PlateBlock extends BaseEntityBlock
{
	protected static final VoxelShape SHAPE = Block.box(3.0D, 1.0D, 3.0D, 13.0D, 3.0D, 13.0D);

	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
	public PlateBlock(BlockBehaviour.Properties builder) {
		super(Properties.of(Material.STONE)
				.strength(1F, 3.0F)
				.sound(SoundType.STONE));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}
	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
		ItemStack heldStack = player.getItemInHand(hand);
		Item heldItem = heldStack.getItem();

		BlockEntity tileEntity = level.getBlockEntity(pos);
		if (tileEntity instanceof PlateBlockEntity plateBlockEntity) {
			int plateSlot = plateBlockEntity.getNextEmptySlot();
			if (!level.isClientSide && plateBlockEntity.addItem(player.getAbilities().instabuild ? heldStack.copy() : heldStack,plateSlot,player,hand)) {
				player.setItemInHand(hand, ItemStack.EMPTY);
				return InteractionResult.SUCCESS;
			}
			if(heldStack.isEmpty() && plateSlot < 0 && !player.isShiftKeyDown()){
				plateBlockEntity.giveItem(player);
				return InteractionResult.SUCCESS;
			}
			if(heldStack.isEmpty() && player.isShiftKeyDown() && plateSlot < 0){
				plateBlockEntity.giveItemShift(player);
				return InteractionResult.SUCCESS;
			}
			if(heldItem == ModItems.FORK.get() || heldItem == ModItems.CHOPSTICKS.get()&& plateSlot < 0 && !player.isShiftKeyDown()){
				plateBlockEntity.finishUsingItem(player);
				return InteractionResult.SUCCESS;
			}
			return InteractionResult.CONSUME;
		}

		return InteractionResult.PASS;
	}
	@Override
	public RenderShape getRenderShape(BlockState pState) {
		return RenderShape.MODEL;
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	@Override
	public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			BlockEntity tileEntity = level.getBlockEntity(pos);
			if (tileEntity instanceof PlateBlockEntity) {
				ItemUtils.dropItems(level, pos, ((PlateBlockEntity) tileEntity).getInventory());
			}

			super.onRemove(state, level, pos, newState, isMoving);
		}
	}

	@Override
	protected void createBlockStateDefinition(final StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING);
	}

	@Nullable
	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return ModBlockEntityTypes.PLATE.get().create(pos, state);
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

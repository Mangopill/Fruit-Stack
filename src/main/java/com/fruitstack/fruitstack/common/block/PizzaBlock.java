package com.fruitstack.fruitstack.common.block;

import com.fruitstack.fruitstack.common.block.state.FryingPanStage;
import com.fruitstack.fruitstack.common.block.state.PizzaStage;
import com.fruitstack.fruitstack.common.registry.ModItems;
import com.fruitstack.fruitstack.fruitstack;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.StateDefinition;

public class PizzaBlock extends Block {
	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
	public static final EnumProperty<PizzaStage> STAGE = EnumProperty.create("stage", PizzaStage.class);
	protected static final VoxelShape SHAPE = Block.box(2.0, 1.0, 2.0, 14.0, 2.0, 14.0);
	public PizzaBlock(BlockBehaviour.Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(STAGE, PizzaStage.DOUGH_STAGE0));
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
			if (this.pizza(level, pos, state, player, hand, hit).consumesAction()) {
				return InteractionResult.SUCCESS;
			}
		}
		return this.pizza(level, pos, state, player, hand, hit);
	}
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}
	public InteractionResult pizza(Level level, BlockPos pos, BlockState state, Player player, InteractionHand hand, BlockHitResult result) {
		ItemStack heldStack = player.getItemInHand(hand);
		if (heldStack.getItem() == ModItems.ROLLING_PIN.get() && state.getValue(STAGE) == PizzaStage.DOUGH_STAGE0){
			level.setBlock(pos, state.setValue(STAGE, PizzaStage.DOUGH_STAGE1), 3);
			level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
			return InteractionResult.SUCCESS;
		}
		if (heldStack.getItem() == ModItems.ROLLING_PIN.get() && state.getValue(STAGE) == PizzaStage.DOUGH_STAGE1){
			level.setBlock(pos, state.setValue(STAGE, PizzaStage.DOUGH_STAGE2), 3);
			level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
			return InteractionResult.SUCCESS;
		}

		if (heldStack.getItem() == Items.APPLE && state.getValue(STAGE) == PizzaStage.DOUGH_STAGE2){
			heldStack.shrink(1);
			level.setBlock(pos, state.setValue(STAGE, PizzaStage.UNBAKED_GRAPE_FRUIT_SAND_PIZZA_STAGE0), 3);
			level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
			return InteractionResult.SUCCESS;
		}
		if (heldStack.getItem() == ModItems.CHINESE_PEAR_LEAVED_SLICE.get() && state.getValue(STAGE) == PizzaStage.UNBAKED_GRAPE_FRUIT_SAND_PIZZA_STAGE0){
			heldStack.shrink(1);
			level.setBlock(pos, state.setValue(STAGE, PizzaStage.UNBAKED_GRAPE_FRUIT_SAND_PIZZA_STAGE1), 3);
			level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
			return InteractionResult.SUCCESS;
		}
		if (heldStack.getItem() == ModItems.GRAPE.get() && state.getValue(STAGE) == PizzaStage.UNBAKED_GRAPE_FRUIT_SAND_PIZZA_STAGE1){
			heldStack.shrink(1);
			level.setBlock(pos, state.setValue(STAGE, PizzaStage.UNBAKED_GRAPE_FRUIT_SAND_PIZZA_STAGE2), 3);
			level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
			return InteractionResult.SUCCESS;
		}
		if (state.getValue(STAGE) == PizzaStage.UNBAKED_GRAPE_FRUIT_SAND_PIZZA_STAGE2){
			level.removeBlock(pos, false);
			if (!player.getInventory().add(ModItems.UNBAKED_GRAPE_FRUIT_SAND_PIZZA.get().getDefaultInstance())) {
				player.drop(ModItems.UNBAKED_GRAPE_FRUIT_SAND_PIZZA.get().getDefaultInstance(), false);
			}
			level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
			return InteractionResult.SUCCESS;
		}

		if (heldStack.getItem() == ModItems.BLUEBERRIES.get() && state.getValue(STAGE) == PizzaStage.DOUGH_STAGE2){
			heldStack.shrink(1);
			level.setBlock(pos, state.setValue(STAGE, PizzaStage.UNBAKED_BLUE_RED_MANGO_PIZZA_STAGE0), 3);
			level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
			return InteractionResult.SUCCESS;
		}
		if (heldStack.getItem() == ModItems.MANGO_SLICE.get() && state.getValue(STAGE) == PizzaStage.UNBAKED_BLUE_RED_MANGO_PIZZA_STAGE0){
			heldStack.shrink(1);
			level.setBlock(pos, state.setValue(STAGE, PizzaStage.UNBAKED_BLUE_RED_MANGO_PIZZA_STAGE1), 3);
			level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
			return InteractionResult.SUCCESS;
		}
		if (heldStack.getItem() == ModItems.PITAYA_SLICE.get() && state.getValue(STAGE) == PizzaStage.UNBAKED_BLUE_RED_MANGO_PIZZA_STAGE1){
			heldStack.shrink(1);
			level.setBlock(pos, state.setValue(STAGE, PizzaStage.UNBAKED_BLUE_RED_MANGO_PIZZA_STAGE2), 3);
			level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
			return InteractionResult.SUCCESS;
		}
		if (state.getValue(STAGE) == PizzaStage.UNBAKED_BLUE_RED_MANGO_PIZZA_STAGE2){
			level.removeBlock(pos, false);
			if (!player.getInventory().add(ModItems.UNBAKED_BLUE_RED_MANGO_PIZZA.get().getDefaultInstance())) {
				player.drop(ModItems.UNBAKED_BLUE_RED_MANGO_PIZZA.get().getDefaultInstance(), false);
			}
			level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
			return InteractionResult.SUCCESS;
		}

		if (heldStack.getItem() == ModItems.MAYTHORN.get() && state.getValue(STAGE) == PizzaStage.DOUGH_STAGE2){
			heldStack.shrink(1);
			level.setBlock(pos, state.setValue(STAGE, PizzaStage.UNBAKED_HAWTHORN_NUT_PIZZA_STAGE0), 3);
			level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
			return InteractionResult.SUCCESS;
		}
		if (heldStack.getItem() == ModItems.JUJUBE.get() && state.getValue(STAGE) == PizzaStage.UNBAKED_HAWTHORN_NUT_PIZZA_STAGE0){
			heldStack.shrink(1);
			level.setBlock(pos, state.setValue(STAGE, PizzaStage.UNBAKED_HAWTHORN_NUT_PIZZA_STAGE1), 3);
			level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
			return InteractionResult.SUCCESS;
		}
		if (heldStack.getItem() == ModItems.APRICOT.get() && state.getValue(STAGE) == PizzaStage.UNBAKED_HAWTHORN_NUT_PIZZA_STAGE1){
			heldStack.shrink(1);
			level.setBlock(pos, state.setValue(STAGE, PizzaStage.UNBAKED_HAWTHORN_NUT_PIZZA_STAGE2), 3);
			level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
			return InteractionResult.SUCCESS;
		}
		if (state.getValue(STAGE) == PizzaStage.UNBAKED_HAWTHORN_NUT_PIZZA_STAGE2){
			level.removeBlock(pos, false);
			if (!player.getInventory().add(ModItems.UNBAKED_HAWTHORN_NUT_PIZZA.get().getDefaultInstance())) {
				player.drop(ModItems.UNBAKED_HAWTHORN_NUT_PIZZA.get().getDefaultInstance(), false);
			}
			level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
			return InteractionResult.SUCCESS;
		}

		if (heldStack.getItem() == ModItems.RED_BAYBERRY.get() && state.getValue(STAGE) == PizzaStage.DOUGH_STAGE2){
			heldStack.shrink(1);
			level.setBlock(pos, state.setValue(STAGE, PizzaStage.UNBAKED_SWEET_AND_REFRESHING_FLAVORED_PIZZA_STAGE0), 3);
			level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
			return InteractionResult.SUCCESS;
		}
		if (heldStack.getItem() == ModItems.GREEN_PLUM.get() && state.getValue(STAGE) == PizzaStage.UNBAKED_SWEET_AND_REFRESHING_FLAVORED_PIZZA_STAGE0){
			heldStack.shrink(1);
			level.setBlock(pos, state.setValue(STAGE, PizzaStage.UNBAKED_SWEET_AND_REFRESHING_FLAVORED_PIZZA_STAGE1), 3);
			level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
			return InteractionResult.SUCCESS;
		}
		if (heldStack.getItem() == ModItems.PLUM.get() && state.getValue(STAGE) == PizzaStage.UNBAKED_SWEET_AND_REFRESHING_FLAVORED_PIZZA_STAGE1){
			heldStack.shrink(1);
			level.setBlock(pos, state.setValue(STAGE, PizzaStage.UNBAKED_SWEET_AND_REFRESHING_FLAVORED_PIZZA_STAGE2), 3);
			level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
			return InteractionResult.SUCCESS;
		}
		if (state.getValue(STAGE) == PizzaStage.UNBAKED_SWEET_AND_REFRESHING_FLAVORED_PIZZA_STAGE2){
			level.removeBlock(pos, false);
			if (!player.getInventory().add(ModItems.UNBAKED_SWEET_AND_REFRESHING_FLAVORED_PIZZA.get().getDefaultInstance())) {
				player.drop(ModItems.UNBAKED_SWEET_AND_REFRESHING_FLAVORED_PIZZA.get().getDefaultInstance(), false);
			}
			level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.PASS;
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
}
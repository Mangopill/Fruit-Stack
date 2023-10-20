package com.fruitstack.fruitstack.common.block;

import com.fruitstack.fruitstack.common.block.state.OvenStage;
import com.fruitstack.fruitstack.common.registry.ModItems;
import com.fruitstack.fruitstack.common.registry.ModSounds;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

public class OvenBlock extends Block {
	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
	public static final EnumProperty<OvenStage> STAGE = EnumProperty.create("stage", OvenStage.class);
	protected static final VoxelShape SHAPE = Block.box(1.0, 1.0, 1.0, 15.0, 15.0, 15.0);
	public OvenBlock(BlockBehaviour.Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(STAGE, OvenStage.OVEN));
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
			if (this.oven(level, pos, state, player, hand, hit).consumesAction()) {
				return InteractionResult.SUCCESS;
			}
		}
		return this.oven(level, pos, state, player, hand, hit);
	}
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}
	public InteractionResult oven(Level level, BlockPos pos, BlockState state, Player player, InteractionHand hand, BlockHitResult result) {
		ItemStack heldStack = player.getItemInHand(hand);
		if (heldStack.getItem() == ModItems.UNBAKED_GRAPE_FRUIT_SAND_PIZZA.get() && state.getValue(STAGE) == OvenStage.OVEN){
			heldStack.shrink(1);
			level.setBlock(pos, state.setValue(STAGE, OvenStage.OVEN_WITH_UNBAKED_GRAPE_FRUIT_SAND_PIZZA), 3);
			level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
			return InteractionResult.SUCCESS;
		}
		if (state.getValue(STAGE) == OvenStage.OVEN_WITH_GRAPE_FRUIT_SAND_PIZZA){
			if (!player.getInventory().add(ModItems.GRAPE_FRUIT_SAND_PIZZA.get().getDefaultInstance())) {
				player.drop(ModItems.GRAPE_FRUIT_SAND_PIZZA.get().getDefaultInstance(), false);
			}
			level.setBlock(pos, state.setValue(STAGE, OvenStage.OVEN), 3);
			level.playSound(null, pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F,
					ModSounds.BLOCK_OVEN_DING.get(), SoundSource.BLOCKS, 0.8F, 1.0F);
			level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
			return InteractionResult.SUCCESS;
		}

		if (heldStack.getItem() == ModItems.UNBAKED_BLUE_RED_MANGO_PIZZA.get() && state.getValue(STAGE) == OvenStage.OVEN){
			heldStack.shrink(1);
			level.setBlock(pos, state.setValue(STAGE, OvenStage.OVEN_WITH_UNBAKED_BLUE_RED_MANGO_PIZZA), 3);
			level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
			return InteractionResult.SUCCESS;
		}
		if (state.getValue(STAGE) == OvenStage.OVEN_WITH_BLUE_RED_MANGO_PIZZA){
			if (!player.getInventory().add(ModItems.BLUE_RED_MANGO_PIZZA.get().getDefaultInstance())) {
				player.drop(ModItems.BLUE_RED_MANGO_PIZZA.get().getDefaultInstance(), false);
			}
			level.setBlock(pos, state.setValue(STAGE, OvenStage.OVEN), 3);
			level.playSound(null, pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F,
					ModSounds.BLOCK_OVEN_DING.get(), SoundSource.BLOCKS, 0.8F, 1.0F);
			level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
			return InteractionResult.SUCCESS;
		}

		if (heldStack.getItem() == ModItems.UNBAKED_HAWTHORN_NUT_PIZZA.get() && state.getValue(STAGE) == OvenStage.OVEN){
			heldStack.shrink(1);
			level.setBlock(pos, state.setValue(STAGE, OvenStage.OVEN_WITH_UNBAKED_HAWTHORN_NUT_PIZZA), 3);
			level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
			return InteractionResult.SUCCESS;
		}
		if (state.getValue(STAGE) == OvenStage.OVEN_WITH_HAWTHORN_NUT_PIZZA){
			if (!player.getInventory().add(ModItems.HAWTHORN_NUT_PIZZA.get().getDefaultInstance())) {
				player.drop(ModItems.HAWTHORN_NUT_PIZZA.get().getDefaultInstance(), false);
			}
			level.setBlock(pos, state.setValue(STAGE, OvenStage.OVEN), 3);
			level.playSound(null, pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F,
					ModSounds.BLOCK_OVEN_DING.get(), SoundSource.BLOCKS, 0.8F, 1.0F);
			level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
			return InteractionResult.SUCCESS;
		}

		if (heldStack.getItem() == ModItems.UNBAKED_SWEET_AND_REFRESHING_FLAVORED_PIZZA.get() && state.getValue(STAGE) == OvenStage.OVEN){
			heldStack.shrink(1);
			level.setBlock(pos, state.setValue(STAGE, OvenStage.OVEN_WITH_UNBAKED_SWEET_AND_REFRESHING_FLAVORED_PIZZA), 3);
			level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
			return InteractionResult.SUCCESS;
		}
		if (state.getValue(STAGE) == OvenStage.OVEN_WITH_SWEET_AND_REFRESHING_FLAVORED_PIZZA){
			if (!player.getInventory().add(ModItems.SWEET_AND_REFRESHING_FLAVORED_PIZZA.get().getDefaultInstance())) {
				player.drop(ModItems.SWEET_AND_REFRESHING_FLAVORED_PIZZA.get().getDefaultInstance(), false);
			}
			level.setBlock(pos, state.setValue(STAGE, OvenStage.OVEN), 3);
			level.playSound(null, pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F,
					ModSounds.BLOCK_OVEN_DING.get(), SoundSource.BLOCKS, 0.8F, 1.0F);
			level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
			return InteractionResult.SUCCESS;
		}

		return InteractionResult.PASS;
	}
	public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, Random random) {
		if (!worldIn.isClientSide) {
			boolean isHeated = isHeated(worldIn, pos);
			if (random.nextFloat() <= 0.1F && isHeated) {
				if (state.getValue(STAGE) == OvenStage.OVEN_WITH_UNBAKED_GRAPE_FRUIT_SAND_PIZZA) {
					worldIn.setBlock(pos, state.setValue(STAGE, OvenStage.OVEN_WITH_GRAPE_FRUIT_SAND_PIZZA), 3);
				}
				if (state.getValue(STAGE) == OvenStage.OVEN_WITH_UNBAKED_BLUE_RED_MANGO_PIZZA) {
					worldIn.setBlock(pos, state.setValue(STAGE, OvenStage.OVEN_WITH_BLUE_RED_MANGO_PIZZA), 3);
				}
				if (state.getValue(STAGE) == OvenStage.OVEN_WITH_UNBAKED_HAWTHORN_NUT_PIZZA) {
					worldIn.setBlock(pos, state.setValue(STAGE, OvenStage.OVEN_WITH_HAWTHORN_NUT_PIZZA), 3);
				}
				if (state.getValue(STAGE) == OvenStage.OVEN_WITH_UNBAKED_SWEET_AND_REFRESHING_FLAVORED_PIZZA) {
					worldIn.setBlock(pos, state.setValue(STAGE, OvenStage.OVEN_WITH_SWEET_AND_REFRESHING_FLAVORED_PIZZA), 3);
				}
			}
		}
	}
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState state, Level level, BlockPos pos, Random rand) {
		boolean isHeated = isHeated(level, pos);
		if (isHeated) {
			double x = (double) pos.getX() + 0.5D;
			double y = pos.getY() + 0.5D;
			double z = (double) pos.getZ() + 0.5D;
			if (rand.nextInt(8) == 0 && !state.getValue(STAGE).equals(OvenStage.OVEN)) {
				level.playLocalSound(x, y, z, ModSounds.BLOCK_OVEN_BAKE.get(), SoundSource.BLOCKS, 0.4F, rand.nextFloat() * 0.2F + 0.9F, false);
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

	boolean isHeated(Level level, BlockPos pos) {
		if (isDaytime(level) && !level.isRaining() && level.canSeeSky(pos)) {
			if (level.canSeeSky(pos)) {
				return true;
			}
		}

		return false;
	}
	private boolean isDaytime(Level world) {
		long timeOfDay = world.getDayTime() % 24000;
		return timeOfDay >= 0 && timeOfDay < 12000;
	}
}
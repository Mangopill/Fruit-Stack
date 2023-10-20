package com.fruitstack.fruitstack.common.block;

import com.fruitstack.fruitstack.common.registry.ModBlocks;
import com.fruitstack.fruitstack.common.registry.ModItems;
import com.fruitstack.fruitstack.common.registry.ModSounds;
import com.fruitstack.fruitstack.common.tag.ModTags;
import com.fruitstack.fruitstack.common.utility.TextUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

import static net.minecraft.world.level.block.RedStoneWireBlock.POWER;

public class FruitPopsicleMachineBlock extends Block
{
	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
	public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 2);
	protected static final VoxelShape SHAPE = Block.box(0.0, 1.0, 0.0, 16.0, 9.0, 16.0);
	public final Supplier<Item> popsicleItem;
	/**
	 * @param properties   Block properties.
	 * @param popsicleItem  The popsicle to be served.
	 */

	public FruitPopsicleMachineBlock(BlockBehaviour.Properties properties, Supplier<Item> popsicleItem) {
		super(properties);
		this.popsicleItem = popsicleItem;
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(AGE, 0));
	}
	public ItemStack getPopsicleItem(BlockState state) {
		return new ItemStack(this.popsicleItem.get());
	}

	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}

	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
		if (level.isClientSide) {
			if (this.mackPopsicle(level, pos, state, player, hand, hit).consumesAction()) {
				return InteractionResult.SUCCESS;
			}
		}
		return this.mackPopsicle(level, pos, state, player, hand, hit);
	}
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}
	protected InteractionResult mackPopsicle(Level level, BlockPos pos, BlockState state, Player player, InteractionHand hand, BlockHitResult result) {
		int age = state.getValue(AGE);
		ItemStack heldStack = player.getItemInHand(hand);
		ItemStack popsicle = this.getPopsicleItem(state);
		    if (age == 0 && heldStack.getItem() == Items.STICK && heldStack.getCount() >= 6) {
			heldStack.shrink(6);
			level.setBlock(pos, state.setValue(AGE, 1), 3);
			level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
			return InteractionResult.SUCCESS;
			}
			if (age == 2) {
				for (int i = 0; i < 6; i++) {
					if (!player.getInventory().add(popsicle.copy())) {
						player.drop(popsicle.copy(), false);
					}
				}
				BlockPlaceContext blockPlaceContext = new BlockPlaceContext(new UseOnContext(level, player, hand, heldStack, result));
				BlockState originalState = level.getBlockState(pos);
				Direction originalDirection = originalState.getValue(BlockStateProperties.HORIZONTAL_FACING);
				BlockState newState = ModBlocks.POPSICLE_MACHINE.get().getStateForPlacement(blockPlaceContext);
				newState = newState.setValue(BlockStateProperties.HORIZONTAL_FACING, originalDirection);
				level.setBlock(pos, newState, 3);
				level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
				return InteractionResult.SUCCESS;
			}

		return InteractionResult.PASS;
	}
	public boolean isRandomlyTicking(BlockState state) {
		return true;
	}
	@Override
	public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
		return !level.isEmptyBlock(pos.below());
	}
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING, AGE);
		super.createBlockStateDefinition(builder);
	}
    @Override
	public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource random) {
		if (!worldIn.isClientSide) {
			if (isDaytime(worldIn) && !worldIn.isRaining() && worldIn.canSeeSky(pos)) {
				if (worldIn.canSeeSky(pos)) {
					if (random.nextFloat() <= 0.1F) {
						int age = state.getValue(AGE);
						if (age == 1) {
							worldIn.setBlock(pos, state.setValue(AGE, 2), 3);
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
		int age = p_55208_.getValue(AGE);
		return age + 2;
	}
	private boolean isDaytime(Level world) {
		long timeOfDay = world.getDayTime() % 24000;
		return timeOfDay >= 0 && timeOfDay < 12000;
	}
}

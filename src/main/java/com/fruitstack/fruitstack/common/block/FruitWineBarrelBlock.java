package com.fruitstack.fruitstack.common.block;

import com.fruitstack.fruitstack.common.registry.ModBlocks;
import com.fruitstack.fruitstack.common.registry.ModItems;
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

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

import static net.minecraft.world.level.block.RedStoneWireBlock.POWER;

public class FruitWineBarrelBlock extends Block
{
	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
	public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 9);
	protected static final VoxelShape SHAPE = Block.box(1.0, 1.0, 1.0, 15.0, 15.0, 15.0);
	public final Supplier<Item> wineItem;
	public final Supplier<Item> wineTwoItem;
	public final Supplier<Item> wineThreeItem;
	public final Supplier<Item> wineFourItem;
	public final Supplier<Item> wineFiveItem;
	public final Supplier<Item> wineSixItem;
	public final Supplier<Item> wineSevenItem;
	public final Supplier<Item> wineEightItem;
	public final Supplier<Item> wineNineItem;
	public final Supplier<Item> wineTenItem;
	public final Supplier<Item> wineBeatItem;
	/**
	 * @param properties   Block properties.
	 * @param wineItem  The wine to be served.
	 * @param wineTwoItem  The wine to be served.
	 * @param wineThreeItem  The wine to be served.
	 * @param wineFourItem  The wine to be served.
	 * @param wineFiveItem  The wine to be served.
	 * @param wineSixItem  The wine to be served.
	 * @param wineSevenItem  The wine to be served.
	 * @param wineEightItem  The wine to be served.
	 * @param wineNineItem  The wine to be served.
	 * @param wineTenItem  The wine to be served.
	 * @param wineBeatItem  The wine to be served.
	 */

	public FruitWineBarrelBlock(BlockBehaviour.Properties properties, Supplier<Item> wineItem, Supplier<Item> wineTwoItem, Supplier<Item> wineThreeItem, Supplier<Item> wineFourItem, Supplier<Item> wineFiveItem, Supplier<Item> wineSixItem, Supplier<Item> wineSevenItem, Supplier<Item> wineEightItem, Supplier<Item> wineNineItem, Supplier<Item> wineTenItem, Supplier<Item> wineBeatItem) {
		super(properties);
		this.wineItem = wineItem;
		this.wineTwoItem = wineTwoItem;
		this.wineThreeItem = wineThreeItem;
		this.wineFourItem = wineFourItem;
		this.wineFiveItem = wineFiveItem;
		this.wineSixItem = wineSixItem;
		this.wineSevenItem = wineSevenItem;
		this.wineEightItem = wineEightItem;
		this.wineNineItem = wineNineItem;
		this.wineTenItem = wineTenItem;
		this.wineBeatItem = wineBeatItem;
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(AGE, 0));
	}
	public ItemStack getWineItem(BlockState state) {
		return new ItemStack(this.wineItem.get());
	}
	public ItemStack getWineTwoItem(BlockState state) {
		return new ItemStack(this.wineTwoItem.get());
	}
	public ItemStack getWineThreeItem(BlockState state) {
		return new ItemStack(this.wineThreeItem.get());
	}
	public ItemStack getWineFourItem(BlockState state) {
		return new ItemStack(this.wineFourItem.get());
	}
	public ItemStack getWineFiveItem(BlockState state) {
		return new ItemStack(this.wineFiveItem.get());
	}
	public ItemStack getWineSixItem(BlockState state) {
		return new ItemStack(this.wineSixItem.get());
	}
	public ItemStack getWineSevenItem(BlockState state) {
		return new ItemStack(this.wineSevenItem.get());
	}
	public ItemStack getWineEightItem(BlockState state) {
		return new ItemStack(this.wineEightItem.get());
	}
	public ItemStack getWineNineItem(BlockState state) {
		return new ItemStack(this.wineNineItem.get());
	}
	public ItemStack getWineTenItem(BlockState state) {
		return new ItemStack(this.wineTenItem.get());
	}
	public ItemStack getWineBeatItem(BlockState state) {
		return new ItemStack(this.wineBeatItem.get());
	}

	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}

	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
		if (level.isClientSide) {
			if (this.takeWine(level, pos, state, player, hand, hit).consumesAction()) {
				return InteractionResult.SUCCESS;
			}
		}
		return this.takeWine(level, pos, state, player, hand, hit);
	}
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}
	protected InteractionResult takeWine(Level level, BlockPos pos, BlockState state, Player player, InteractionHand hand, BlockHitResult result) {
		int age = state.getValue(AGE);
		ItemStack heldStack = player.getItemInHand(hand);
		ItemStack wineItem0 = this.getWineItem(state);
		ItemStack wineItem1 = this.getWineTwoItem(state);
		ItemStack wineItem2 = this.getWineThreeItem(state);
		ItemStack wineItem3 = this.getWineFourItem(state);
		ItemStack wineItem4 = this.getWineFiveItem(state);
		ItemStack wineItem5 = this.getWineSixItem(state);
		ItemStack wineItem6 = this.getWineSevenItem(state);
		ItemStack wineItem7 = this.getWineEightItem(state);
		ItemStack wineItem8 = this.getWineNineItem(state);
		ItemStack wineItem9 = this.getWineTenItem(state);
		ItemStack wineItem10 = this.getWineBeatItem(state);
		if (heldStack.getItem() == ModItems.CANN.get()) {
			BlockPlaceContext blockPlaceContext = new BlockPlaceContext(new UseOnContext(level, player, hand, heldStack, result));
			BlockState originalState = level.getBlockState(pos);
			Direction originalDirection = originalState.getValue(BlockStateProperties.HORIZONTAL_FACING);
			BlockState newState = ModBlocks.WINE_BARREL.get().getStateForPlacement(blockPlaceContext);
			newState = newState.setValue(BlockStateProperties.HORIZONTAL_FACING, originalDirection);
			level.setBlock(pos, newState, 3);
			heldStack.shrink(1);
			if (age == 0) {
				if (!player.getInventory().add(wineItem0)) {
					player.drop(wineItem0, false);
				}
				level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
				return InteractionResult.SUCCESS;
			}
			if (age == 1) {
				if (!player.getInventory().add(wineItem1)) {
					player.drop(wineItem1, false);
				}
				level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
				return InteractionResult.SUCCESS;
			}
			if (age == 2) {
				if (!player.getInventory().add(wineItem2)) {
					player.drop(wineItem2, false);
				}
				level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
				return InteractionResult.SUCCESS;
			}
			if (age == 3) {
				if (!player.getInventory().add(wineItem3)) {
					player.drop(wineItem3, false);
				}
				level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
				return InteractionResult.SUCCESS;
			}
			if (age == 4) {
				if (!player.getInventory().add(wineItem4)) {
					player.drop(wineItem4, false);
				}
				level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
				return InteractionResult.SUCCESS;
			}
			if (age == 5) {
				if (!player.getInventory().add(wineItem5)) {
					player.drop(wineItem5, false);
				}
				level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
				return InteractionResult.SUCCESS;
			}
			if (age == 6) {
				if (!player.getInventory().add(wineItem6)) {
					player.drop(wineItem6, false);
				}
				level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
				return InteractionResult.SUCCESS;
			}
			if (age == 7) {
				if (!player.getInventory().add(wineItem7)) {
					player.drop(wineItem7, false);
				}
				level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
				return InteractionResult.SUCCESS;
			}
			if (age == 8) {
				if (!player.getInventory().add(wineItem8)) {
					player.drop(wineItem8, false);
				}
				level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
				return InteractionResult.SUCCESS;
			}
			if (age == 9) {
				Random random = new Random();
				double probability = random.nextDouble(); // 生成一个介于 [0, 1) 之间的随机数

				// 根据 0.001 的概率选择不同的物品
				ItemStack wineItem = probability < 0.001 ? wineItem10 : wineItem9;

				if (!player.getInventory().add(wineItem)) {
					player.drop(wineItem, false);
				}
				level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
				return InteractionResult.SUCCESS;
			}
		}
		return InteractionResult.PASS;
	}
	public boolean isRandomlyTicking(BlockState state) {
		return true;
	}
	public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
		return !level.isEmptyBlock(pos.below());
	}
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING, AGE);
		super.createBlockStateDefinition(builder);
	}

	public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, Random random) {
		if (!worldIn.isClientSide) {
			if (random.nextFloat() <= 0.1F) {
				int age = state.getValue(AGE);
				if (age == 0) {
					worldIn.setBlock(pos, state.setValue(AGE, 1), 3);
					worldIn.updateNeighborsAt(pos, this); // 通知周围方块更新红石信号
				} else if (age == 1) {
					worldIn.setBlock(pos, state.setValue(AGE, 2), 3);
					worldIn.updateNeighborsAt(pos, this); // 通知周围方块更新红石信号
				} else if (age == 2) {
					worldIn.setBlock(pos, state.setValue(AGE, 3), 3);
					worldIn.updateNeighborsAt(pos, this); // 通知周围方块更新红石信号
				} else if (age == 3) {
					worldIn.setBlock(pos, state.setValue(AGE, 4), 3);
					worldIn.updateNeighborsAt(pos, this); // 通知周围方块更新红石信号
				} else if (age == 4) {
					worldIn.setBlock(pos, state.setValue(AGE, 5), 3);
					worldIn.updateNeighborsAt(pos, this); // 通知周围方块更新红石信号
				} else if (age == 5) {
					worldIn.setBlock(pos, state.setValue(AGE, 6), 3);
					worldIn.updateNeighborsAt(pos, this); // 通知周围方块更新红石信号
				} else if (age == 6) {
					worldIn.setBlock(pos, state.setValue(AGE, 7), 3);
					worldIn.updateNeighborsAt(pos, this); // 通知周围方块更新红石信号
				} else if (age == 7) {
					worldIn.setBlock(pos, state.setValue(AGE, 8), 3);
					worldIn.updateNeighborsAt(pos, this); // 通知周围方块更新红石信号
				} else if (age == 8) {
					worldIn.setBlock(pos, state.setValue(AGE, 9), 3);
					worldIn.updateNeighborsAt(pos, this); // 通知周围方块更新红石信号
				}
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
		return age + 1;
	}
}

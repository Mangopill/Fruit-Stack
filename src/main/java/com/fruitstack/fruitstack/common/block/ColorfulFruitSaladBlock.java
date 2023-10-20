package com.fruitstack.fruitstack.common.block;

import com.fruitstack.fruitstack.common.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

@SuppressWarnings("deprecation")
public class ColorfulFruitSaladBlock extends FeastBlock
{
	public static final IntegerProperty ROLL_SERVINGS = IntegerProperty.create("servings", 0, 6);

	protected static final VoxelShape PLATE_SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 2.0D, 15.0D);
	protected static final VoxelShape FOOD_SHAPE = Shapes.joinUnoptimized(PLATE_SHAPE, Block.box(2.0D, 2.0D, 2.0D, 14.0D, 4.0D, 14.0D), BooleanOp.OR);

	public final List<Supplier<Item>> riceRollServings = Arrays.asList(
			ModItems.PITAYA_SLICE,
			ModItems.GOLDEN_PURE_SHEEP_HORN_HONEY_SLICE,
			ModItems.SEPTEMBER_MELON,
			ModItems.HUOSHEN_FRUIT_SLICE,
			ModItems.BEATING_MELONS_SLICE,
			ModItems.GREEN_MANGO_SLICE
	);

	public ColorfulFruitSaladBlock(Properties properties) {
		super(properties, ModItems.PITAYA_SLICE, true);
	}

	@Override
	public IntegerProperty getServingsProperty() {
		return ROLL_SERVINGS;
	}

	@Override
	public int getMaxServings() {
		return 6;
	}

	@Override
	public ItemStack getServingItem(BlockState state) {
		return new ItemStack(riceRollServings.get(state.getValue(getServingsProperty()) - 1).get());
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return state.getValue(getServingsProperty()) == 0 ? PLATE_SHAPE : FOOD_SHAPE;
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING, ROLL_SERVINGS);
	}
}
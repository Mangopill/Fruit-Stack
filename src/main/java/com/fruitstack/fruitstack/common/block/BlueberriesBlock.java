package com.fruitstack.fruitstack.common.block;

import com.fruitstack.fruitstack.common.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BlueberriesBlock extends CropBlock{
	//每个阶段我们的作物的高低
	private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
			Block.box(6.0D, 0.0D, 6.0D, 10.0D, 2.0D, 10.0D),
			Block.box(6.0D, 0.0D, 6.0D, 10.0D, 4.0D, 10.0D),
			Block.box(6.0D, 0.0D, 6.0D, 10.0D, 6.0D, 10.0D),
			Block.box(6.0D, 0.0D, 6.0D, 10.0D, 8.0D, 10.0D),
			Block.box(6.0D, 0.0D, 6.0D, 10.0D, 10.0D, 10.0D),
			Block.box(6.0D, 0.0D, 6.0D, 10.0D, 12.0D, 10.0D),
			Block.box(6.0D, 0.0D, 6.0D, 10.0D, 14.0D, 10.0D),
			Block.box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D)};

	public BlueberriesBlock(Properties builder)
	{
		super(builder);
	}

	//该作物对应哪个物品
	protected ItemLike getBaseSeedId() {
		return ModItems.BLUEBERRIES_SEEDS.get();
	}

	public VoxelShape getShape(BlockState state, BlockGetter blockgetter, BlockPos blockpos, CollisionContext contex) {
		return SHAPE_BY_AGE[state.getValue(this.getAgeProperty())];
	}
}
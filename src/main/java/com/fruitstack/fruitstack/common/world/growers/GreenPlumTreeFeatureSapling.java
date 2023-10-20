package com.fruitstack.fruitstack.common.world.growers;

import com.fruitstack.fruitstack.common.registry.ModBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.Random;

import static net.minecraft.world.level.block.LeavesBlock.PERSISTENT;

public class GreenPlumTreeFeatureSapling extends Feature<NoneFeatureConfiguration> {
	public GreenPlumTreeFeatureSapling(Codec<NoneFeatureConfiguration> configFactory) {
		super(configFactory);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
		NoneFeatureConfiguration config = pContext.config();
		WorldGenLevel world = pContext.level();
		ChunkGenerator generator = pContext.chunkGenerator();
		RandomSource random = pContext.random();
		BlockPos pos = pContext.origin();

		return place(config, world, generator, random, pos);
	}
	@Override
	public boolean place(NoneFeatureConfiguration config, WorldGenLevel world, ChunkGenerator generator, RandomSource random, BlockPos pos) {
		if (isValidGround(world.getBlockState(pos.below()), world, pos)
				&& world.getBlockState(pos).canBeReplaced()) {
			int type = 1;
			generateTree(world, pos, random, type);
			return true;
		}
		return false;
	}

	private boolean isValidGround(BlockState state, BlockGetter worldIn, BlockPos pos) {
		Block block = state.getBlock();
		return block == Blocks.GRASS_BLOCK || block == Blocks.DIRT || block == Blocks.COARSE_DIRT
				|| block == Blocks.PODZOL;
	}

	public static void generateTree(WorldGenLevel world, BlockPos pos, RandomSource random, int verify) {
		BlockState trunk = getTrunk();
		BlockState trunktwo = getTrunkTwo();
		BlockState leaves = getLeaves();
		BlockState fruit = getFruit(verify, random);

		world.setBlock(pos.above(0), trunk, 3);
		world.setBlock(pos.above(1), trunktwo, 3);
		//Layer Fruit
		if (world.getBlockState(pos.above(1).north().north()).canBeReplaced())
			world.setBlock(pos.above(1).north().north(), fruit, 3);//fruit
		if (world.getBlockState(pos.above(1).north().east()).canBeReplaced())
			world.setBlock(pos.above(1).north().east(), fruit, 3);//fruit
		if (world.getBlockState(pos.above(1).north().west()).canBeReplaced())
			world.setBlock(pos.above(1).north().west(), fruit, 3);//fruit
		if (world.getBlockState(pos.above(1).south().south()).canBeReplaced())
			world.setBlock(pos.above(1).south().south(), fruit, 3);//fruit
		if (world.getBlockState(pos.above(1).south().east()).canBeReplaced())
			world.setBlock(pos.above(1).south().east(), fruit, 3);//fruit
		if (world.getBlockState(pos.above(1).south().west()).canBeReplaced())
			world.setBlock(pos.above(1).south().west(), fruit, 3);//fruit
		if (world.getBlockState(pos.above(1).east().east()).canBeReplaced())
			world.setBlock(pos.above(1).east().east(), fruit, 3);//fruit
		if (world.getBlockState(pos.above(1).west().west()).canBeReplaced())
			world.setBlock(pos.above(1).west().west(), fruit, 3);//fruit

		//Leaves 1
		if (world.getBlockState(pos.above(2)).canBeReplaced())
			world.setBlock(pos.above(2), leaves, 3);
		if (world.getBlockState(pos.above(2).north()).canBeReplaced())
			world.setBlock(pos.above(2).north(), leaves, 3);
		if (world.getBlockState(pos.above(2).south()).canBeReplaced())
			world.setBlock(pos.above(2).south(), leaves, 3);
		if (world.getBlockState(pos.above(2).east()).canBeReplaced())
			world.setBlock(pos.above(2).east(), leaves, 3);
		if (world.getBlockState(pos.above(2).west()).canBeReplaced())
			world.setBlock(pos.above(2).west(), leaves, 3);
		if (world.getBlockState(pos.above(2).north().east()).canBeReplaced())
			world.setBlock(pos.above(2).north().east(), leaves, 3);
		if (world.getBlockState(pos.above(2).north().west()).canBeReplaced())
			world.setBlock(pos.above(2).north().west(), leaves, 3);
		if (world.getBlockState(pos.above(2).south().east()).canBeReplaced())
			world.setBlock(pos.above(2).south().east(), leaves, 3);
		if (world.getBlockState(pos.above(2).south().west()).canBeReplaced())
			world.setBlock(pos.above(2).south().west(), leaves, 3);

		if (world.getBlockState(pos.above(2).north().north()).canBeReplaced())
			world.setBlock(pos.above(2).north().north(), leaves, 3);
		if (world.getBlockState(pos.above(2).south().south()).canBeReplaced())
			world.setBlock(pos.above(2).south().south(), leaves, 3);
		if (world.getBlockState(pos.above(2).east().east()).canBeReplaced())
			world.setBlock(pos.above(2).east().east(), leaves, 3);
		if (world.getBlockState(pos.above(2).west().west()).canBeReplaced())
			world.setBlock(pos.above(2).west().west(), leaves, 3);
		if (world.getBlockState(pos.above(2).north().east().north()).canBeReplaced())
			world.setBlock(pos.above(2).north().east().north(), leaves, 3);
		if (world.getBlockState(pos.above(2).north().east().east()).canBeReplaced())
			world.setBlock(pos.above(2).north().east().east(), leaves, 3);
		if (world.getBlockState(pos.above(2).north().west().north()).canBeReplaced())
			world.setBlock(pos.above(2).north().west().north(), leaves, 3);
		if (world.getBlockState(pos.above(2).north().west().west()).canBeReplaced())
			world.setBlock(pos.above(2).north().west().west(), leaves, 3);
		if (world.getBlockState(pos.above(2).south().east().south()).canBeReplaced())
			world.setBlock(pos.above(2).south().east().south(), leaves, 3);
		if (world.getBlockState(pos.above(2).south().east().east()).canBeReplaced())
			world.setBlock(pos.above(2).south().east().east(), leaves, 3);
		if (world.getBlockState(pos.above(2).south().west().south()).canBeReplaced())
			world.setBlock(pos.above(2).south().west().south(), leaves, 3);
		if (world.getBlockState(pos.above(2).south().west().west()).canBeReplaced())
			world.setBlock(pos.above(2).south().west().west(), leaves, 3);
		//Leaves 2
		if (world.getBlockState(pos.above(3)).canBeReplaced())
			world.setBlock(pos.above(3), leaves, 3);
		if (world.getBlockState(pos.above(3).north()).canBeReplaced())
			world.setBlock(pos.above(3).north(), leaves, 3);
		if (world.getBlockState(pos.above(3).south()).canBeReplaced())
			world.setBlock(pos.above(3).south(), leaves, 3);
		if (world.getBlockState(pos.above(3).east()).canBeReplaced())
			world.setBlock(pos.above(3).east(), leaves, 3);
		if (world.getBlockState(pos.above(3).west()).canBeReplaced())
			world.setBlock(pos.above(3).west(), leaves, 3);
		if (world.getBlockState(pos.above(3).north().east()).canBeReplaced())
			world.setBlock(pos.above(3).north().east(), leaves, 3);
		if (world.getBlockState(pos.above(3).south().east()).canBeReplaced())
			world.setBlock(pos.above(3).south().east(), leaves, 3);
		if (world.getBlockState(pos.above(3).north().west()).canBeReplaced())
			world.setBlock(pos.above(3).north().west(), leaves, 3);
		if (world.getBlockState(pos.above(3).south().west()).canBeReplaced())
			world.setBlock(pos.above(3).south().west(), leaves, 3);

		if (world.getBlockState(pos.above(4)).canBeReplaced())
			world.setBlock(pos.above(4), leaves, 3);
	}

	private static BlockState getLeaves()
	{
		return ModBlocks.BAYBERRY_LEAVES.get().defaultBlockState().setValue(BlockStateProperties.DISTANCE, 1).setValue(PERSISTENT, Boolean.valueOf(true));
	}

	private static BlockState getTrunk()
	{
		return ModBlocks.BAYBERRY_LOG_BIG.get().defaultBlockState();
	}
	private static BlockState getTrunkTwo()
	{
		return ModBlocks.BAYBERRY_LOG_BIFURCATE.get().defaultBlockState();
	}

	public static BlockState getFruit(int verify, RandomSource random)
	{
		int i = 0;
		switch (verify) {
			case 1:
					return ModBlocks.GREEN_PLUM_CROP.get().defaultBlockState().setValue(BlockStateProperties.AGE_7, i);
			default:
				return ModBlocks.GREEN_PLUM_CROP.get().defaultBlockState().setValue(BlockStateProperties.AGE_7, i);
		}
	}
}
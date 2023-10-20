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

public class MaythornTreeFeatureSapling extends Feature<NoneFeatureConfiguration> {
	public MaythornTreeFeatureSapling(Codec<NoneFeatureConfiguration> configFactory) {
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
				&& world.getBlockState(pos).getMaterial().isReplaceable()) {
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
		BlockState trunkthree = getTrunkThree();
		BlockState leaves = getLeaves();
		BlockState fruit = getFruit(verify, random);

		world.setBlock(pos.above(0), trunk, 3);
		world.setBlock(pos.above(1), trunk, 3);
		world.setBlock(pos.above(2), trunktwo, 3);
		world.setBlock(pos.above(3), trunktwo, 3);
		world.setBlock(pos.above(4), trunkthree, 3);
		//Layer Fruit
		if (world.getBlockState(pos.above(5).north().north()).getMaterial().isReplaceable())
			world.setBlock(pos.above(5).north().north(), fruit, 3);//fruit
		if (world.getBlockState(pos.above(5).north().east()).getMaterial().isReplaceable())
			world.setBlock(pos.above(5).north().east(), fruit, 3);//fruit
		if (world.getBlockState(pos.above(5).north().west()).getMaterial().isReplaceable())
			world.setBlock(pos.above(5).north().west(), fruit, 3);//fruit
		if (world.getBlockState(pos.above(5).south().south()).getMaterial().isReplaceable())
			world.setBlock(pos.above(5).south().south(), fruit, 3);//fruit
		if (world.getBlockState(pos.above(5).south().east()).getMaterial().isReplaceable())
			world.setBlock(pos.above(5).south().east(), fruit, 3);//fruit
		if (world.getBlockState(pos.above(5).south().west()).getMaterial().isReplaceable())
			world.setBlock(pos.above(5).south().west(), fruit, 3);//fruit
		if (world.getBlockState(pos.above(5).east().east()).getMaterial().isReplaceable())
			world.setBlock(pos.above(5).east().east(), fruit, 3);//fruit
		if (world.getBlockState(pos.above(5).west().west()).getMaterial().isReplaceable())
			world.setBlock(pos.above(5).west().west(), fruit, 3);//fruit

		//Leaves 1
		if (world.getBlockState(pos.above(5).north()).getMaterial().isReplaceable())
			world.setBlock(pos.above(5).north(), leaves, 3);
		if (world.getBlockState(pos.above(5).south()).getMaterial().isReplaceable())
			world.setBlock(pos.above(5).south(), leaves, 3);
		if (world.getBlockState(pos.above(5).east()).getMaterial().isReplaceable())
			world.setBlock(pos.above(5).east(), leaves, 3);
		if (world.getBlockState(pos.above(5).west()).getMaterial().isReplaceable())
			world.setBlock(pos.above(5).west(), leaves, 3);
		//Leaves 2
		if (world.getBlockState(pos.above(6).north()).getMaterial().isReplaceable())
			world.setBlock(pos.above(6).north(), leaves, 3);
		if (world.getBlockState(pos.above(6).south()).getMaterial().isReplaceable())
			world.setBlock(pos.above(6).south(), leaves, 3);
		if (world.getBlockState(pos.above(6).east()).getMaterial().isReplaceable())
			world.setBlock(pos.above(6).east(), leaves, 3);
		if (world.getBlockState(pos.above(6).west()).getMaterial().isReplaceable())
			world.setBlock(pos.above(6).west(), leaves, 3);
		if (world.getBlockState(pos.above(6).north().east()).getMaterial().isReplaceable())
			world.setBlock(pos.above(6).north().east(), leaves, 3);
		if (world.getBlockState(pos.above(6).north().west()).getMaterial().isReplaceable())
			world.setBlock(pos.above(6).north().west(), leaves, 3);
		if (world.getBlockState(pos.above(6).south().east()).getMaterial().isReplaceable())
			world.setBlock(pos.above(6).south().east(), leaves, 3);
		if (world.getBlockState(pos.above(6).south().west()).getMaterial().isReplaceable())
			world.setBlock(pos.above(6).south().west(), leaves, 3);

		if (world.getBlockState(pos.above(6).north().north()).getMaterial().isReplaceable())
			world.setBlock(pos.above(6).north().north(), leaves, 3);
		if (world.getBlockState(pos.above(6).south().south()).getMaterial().isReplaceable())
			world.setBlock(pos.above(6).south().south(), leaves, 3);
		if (world.getBlockState(pos.above(6).east().east()).getMaterial().isReplaceable())
			world.setBlock(pos.above(6).east().east(), leaves, 3);
		if (world.getBlockState(pos.above(6).west().west()).getMaterial().isReplaceable())
			world.setBlock(pos.above(6).west().west(), leaves, 3);
		if (world.getBlockState(pos.above(6).north().east().north()).getMaterial().isReplaceable())
			world.setBlock(pos.above(6).north().east().north(), leaves, 3);
		if (world.getBlockState(pos.above(6).north().east().east()).getMaterial().isReplaceable())
			world.setBlock(pos.above(6).north().east().east(), leaves, 3);
		if (world.getBlockState(pos.above(6).north().west().north()).getMaterial().isReplaceable())
			world.setBlock(pos.above(6).north().west().north(), leaves, 3);
		if (world.getBlockState(pos.above(6).north().west().west()).getMaterial().isReplaceable())
			world.setBlock(pos.above(6).north().west().west(), leaves, 3);
		if (world.getBlockState(pos.above(6).south().east().south()).getMaterial().isReplaceable())
			world.setBlock(pos.above(6).south().east().south(), leaves, 3);
		if (world.getBlockState(pos.above(6).south().east().east()).getMaterial().isReplaceable())
			world.setBlock(pos.above(6).south().east().east(), leaves, 3);
		if (world.getBlockState(pos.above(6).south().west().south()).getMaterial().isReplaceable())
			world.setBlock(pos.above(6).south().west().south(), leaves, 3);
		if (world.getBlockState(pos.above(6).south().west().west()).getMaterial().isReplaceable())
			world.setBlock(pos.above(6).south().west().west(), leaves, 3);
		//Leaves 3
		if (world.getBlockState(pos.above(7)).getMaterial().isReplaceable())
			world.setBlock(pos.above(7), leaves, 3);
		if (world.getBlockState(pos.above(7).north()).getMaterial().isReplaceable())
			world.setBlock(pos.above(7).north(), leaves, 3);
		if (world.getBlockState(pos.above(7).south()).getMaterial().isReplaceable())
			world.setBlock(pos.above(7).south(), leaves, 3);
		if (world.getBlockState(pos.above(7).east()).getMaterial().isReplaceable())
			world.setBlock(pos.above(7).east(), leaves, 3);
		if (world.getBlockState(pos.above(7).west()).getMaterial().isReplaceable())
			world.setBlock(pos.above(7).west(), leaves, 3);
	}

	private static BlockState getLeaves()
	{
		return ModBlocks.MAYTHORN_LEAVES.get().defaultBlockState().setValue(BlockStateProperties.DISTANCE, 1).setValue(PERSISTENT, Boolean.valueOf(true));
	}

	private static BlockState getTrunk()
	{
		return ModBlocks.MAYTHORN_LOG_BIG.get().defaultBlockState();
	}
	private static BlockState getTrunkTwo()
	{
		return ModBlocks.MAYTHORN_LOG_MEDIUM.get().defaultBlockState();
	}
	private static BlockState getTrunkThree()
	{
		return ModBlocks.MAYTHORN_LOG_BIFURCATE.get().defaultBlockState();
	}

	public static BlockState getFruit(int verify, RandomSource random)
	{
		int i = 0;
		switch (verify) {
			case 1:
					return ModBlocks.MAYTHORN_CROP.get().defaultBlockState().setValue(BlockStateProperties.AGE_7, i);
			default:
				return ModBlocks.MAYTHORN_CROP.get().defaultBlockState().setValue(BlockStateProperties.AGE_7, i);
		}
	}
}
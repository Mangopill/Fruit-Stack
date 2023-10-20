package com.fruitstack.fruitstack.common.worldgen;

import com.fruitstack.fruitstack.common.registry.ModBlocks;
import com.fruitstack.fruitstack.config.ChanceConfig;
import com.fruitstack.fruitstack.config.DimensionConfig;
import com.fruitstack.fruitstack.config.EnableConfig;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.Random;

public class WildDroughtCropFeature extends Feature<NoneFeatureConfiguration> {
	public WildDroughtCropFeature(Codec<NoneFeatureConfiguration> configFactory) {
		super(configFactory);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
		NoneFeatureConfiguration config = pContext.config();
		WorldGenLevel world = pContext.level();
		ChunkGenerator generator = pContext.chunkGenerator();
		Random random = pContext.random();
		BlockPos pos = pContext.origin();

		return place(config, world, generator, random, pos);
	}

	@Override
	public boolean place(NoneFeatureConfiguration config, WorldGenLevel world, ChunkGenerator generator, Random random, BlockPos pos) {
		if (random.nextInt(ChanceConfig.wild_crop_chance.get()) != 0
			|| DimensionConfig.blacklist.get().contains(world.dimensionType().effectsLocation().toString())
			|| (!DimensionConfig.whitelist.get().contains(world.dimensionType().effectsLocation().toString()) && DimensionConfig.whitelist.get().size()>0))
			return false;

		if (isValidGround(world.getBlockState(pos.below()), world, pos)
				&& world.getBlockState(pos).getMaterial().isReplaceable()) {
			int type = random.nextInt(2) + 1;
			generateCrop(world, pos, random, type);
			return true;
		}
		return false;
	}
	
	private boolean isValidGround(BlockState state, BlockGetter worldIn, BlockPos pos) {
		Block block = state.getBlock();
		return block == Blocks.SAND;
	}

	public static void generateCrop(WorldGenLevel world, BlockPos pos, Random random, int verify) {
		BlockState crop = getCrop(verify, random);
		world.setBlock(pos.above(0), crop, 3);
		if (world.getBlockState(pos.below(1).north().north()).getBlock() == Blocks.SAND)
			world.setBlock(pos.above(0).north().north(), crop, 3);
		if (world.getBlockState(pos.below(1).north()).getBlock() == Blocks.SAND)
			world.setBlock(pos.above(0).north(), crop, 3);
		if (world.getBlockState(pos.below(1).east()).getBlock() == Blocks.SAND)
			world.setBlock(pos.above(0).east(), crop, 3);
		if (world.getBlockState(pos.below(1).east().south()).getBlock() == Blocks.SAND)
			world.setBlock(pos.above(0).east().south(), crop, 3);
		if (world.getBlockState(pos.below(1).south()).getBlock() == Blocks.SAND)
			world.setBlock(pos.above(0).south(), crop, 3);
		if (world.getBlockState(pos.below(1).west()).getBlock() == Blocks.SAND)
			world.setBlock(pos.above(0).west(), crop, 3);
		if (world.getBlockState(pos.below(1).west().south()).getBlock() == Blocks.SAND)
			world.setBlock(pos.above(0).west().south(), crop, 3);
		
	}

	private static BlockState getCrop(int verify, Random random)
	{
		int i = random.nextInt(2);
		switch (verify) {
		case 1:
			if (EnableConfig.ground_cucumber_worldgen != null)
			return ModBlocks.WILD_GROUND_CUCUMBER.get().defaultBlockState();
		case 2:
			if (EnableConfig.huoshen_fruit_worldgen != null)
			return ModBlocks.WILD_HUOSHEN_FRUIT.get().defaultBlockState();
		default:
			return ModBlocks.WILD_GROUND_CUCUMBER.get().defaultBlockState();
		}
	}
}
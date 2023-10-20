package com.fruitstack.fruitstack.common.world;

import com.fruitstack.fruitstack.common.Configuration;
import com.fruitstack.fruitstack.common.registry.ModBiomeFeatures;
import com.fruitstack.fruitstack.common.registry.ModBlocks;
import com.fruitstack.fruitstack.common.world.configuration.WildCropConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RandomizedIntStateProvider;
import net.minecraft.world.level.levelgen.placement.*;
import com.fruitstack.fruitstack.fruitstack;

import java.util.List;

@SuppressWarnings("unused")
public class WildCropGeneration
{
	public static Holder<ConfiguredFeature<WildCropConfiguration, ?>> FEATURE_PATCH_WILD_BLUEBERRIES;
	public static Holder<ConfiguredFeature<WildCropConfiguration, ?>> FEATURE_PATCH_WILD_HAMIMELON;
	public static Holder<ConfiguredFeature<WildCropConfiguration, ?>> FEATURE_PATCH_WILD_BEATING_MELONS;
	public static Holder<ConfiguredFeature<WildCropConfiguration, ?>> FEATURE_PATCH_WILD_GROUND_CUCUMBER;
	public static Holder<ConfiguredFeature<WildCropConfiguration, ?>> FEATURE_PATCH_WILD_HOLBOELLIA_LATIFOLIA;
	public static Holder<ConfiguredFeature<WildCropConfiguration, ?>> FEATURE_PATCH_WILD_HUOSHEN_FRUIT;
	public static Holder<ConfiguredFeature<WildCropConfiguration, ?>> FEATURE_PATCH_WILD_SEPTEMBER_MELON;
	public static Holder<ConfiguredFeature<WildCropConfiguration, ?>> FEATURE_PATCH_WILD_PITAYA;
	public static Holder<ConfiguredFeature<WildCropConfiguration, ?>> FEATURE_PATCH_WILD_GOLDEN_PURE_SHEEP_HORN_HONEY;
	public static Holder<ConfiguredFeature<WildCropConfiguration, ?>> FEATURE_PATCH_WILD_GRAPE;
	public static Holder<ConfiguredFeature<WildCropConfiguration, ?>> FEATURE_PATCH_WILD_GLUTINOUS_RICE;
	public static Holder<ConfiguredFeature<WildCropConfiguration, ?>> FEATURE_PATCH_WILD_ZONG_ZI_LEAVES;
	public static Holder<ConfiguredFeature<WildCropConfiguration, ?>> FEATURE_PATCH_WILD_BLACK_TEA_LEAVES;

	public static Holder<ConfiguredFeature<WildCropConfiguration, ?>> FEATURE_PATCH_WILD_APPLE_TREE;
	public static Holder<ConfiguredFeature<WildCropConfiguration, ?>> FEATURE_PATCH_WILD_APRICOT_TREE;
	public static Holder<ConfiguredFeature<WildCropConfiguration, ?>> FEATURE_PATCH_WILD_GREEN_PLUM_TREE;
	public static Holder<ConfiguredFeature<WildCropConfiguration, ?>> FEATURE_PATCH_WILD_JUJUBE_TREE;
	public static Holder<ConfiguredFeature<WildCropConfiguration, ?>> FEATURE_PATCH_WILD_MAYTHORN_TREE;
	public static Holder<ConfiguredFeature<WildCropConfiguration, ?>> FEATURE_PATCH_WILD_PEAR_TREE;
	public static Holder<ConfiguredFeature<WildCropConfiguration, ?>> FEATURE_PATCH_WILD_PLUM_TREE;
	public static Holder<ConfiguredFeature<WildCropConfiguration, ?>> FEATURE_PATCH_WILD_RED_BAYBERRY_TREE;
	public static Holder<ConfiguredFeature<WildCropConfiguration, ?>> FEATURE_PATCH_WILD_CHINESE_PEAR_LEAVED_TREE;
	public static Holder<ConfiguredFeature<WildCropConfiguration, ?>> FEATURE_PATCH_WILD_LITCHI_TREE;
	public static Holder<ConfiguredFeature<WildCropConfiguration, ?>> FEATURE_PATCH_WILD_MANGO_TREE;
	public static Holder<ConfiguredFeature<WildCropConfiguration, ?>> FEATURE_PATCH_WILD_PEACH_TREE;

	public static Holder<PlacedFeature> PATCH_WILD_BLUEBERRIES;
	public static Holder<PlacedFeature> PATCH_WILD_HAMIMELON;
	public static Holder<PlacedFeature> PATCH_WILD_BEATING_MELONS;
	public static Holder<PlacedFeature> PATCH_WILD_GROUND_CUCUMBER;
	public static Holder<PlacedFeature> PATCH_WILD_HOLBOELLIA_LATIFOLIA;
	public static Holder<PlacedFeature> PATCH_WILD_HUOSHEN_FRUIT;
	public static Holder<PlacedFeature> PATCH_WILD_SEPTEMBER_MELON;
	public static Holder<PlacedFeature> PATCH_WILD_PITAYA;
	public static Holder<PlacedFeature> PATCH_WILD_GOLDEN_PURE_SHEEP_HORN_HONEY;
	public static Holder<PlacedFeature> PATCH_WILD_GRAPE;
	public static Holder<PlacedFeature> PATCH_WILD_GLUTINOUS_RICE;
	public static Holder<PlacedFeature> PATCH_WILD_ZONG_ZI_LEAVES;
	public static Holder<PlacedFeature> PATCH_WILD_BLACK_TEA_LEAVES;

	public static Holder<PlacedFeature> PATCH_WILD_APPLE_TREE;
	public static Holder<PlacedFeature> PATCH_WILD_APRICOT_TREE;
	public static Holder<PlacedFeature> PATCH_WILD_GREEN_PLUM_TREE;
	public static Holder<PlacedFeature> PATCH_WILD_JUJUBE_TREE;
	public static Holder<PlacedFeature> PATCH_WILD_MAYTHORN_TREE;
	public static Holder<PlacedFeature> PATCH_WILD_PEAR_TREE;
	public static Holder<PlacedFeature> PATCH_WILD_PLUM_TREE;
	public static Holder<PlacedFeature> PATCH_WILD_RED_BAYBERRY_TREE;
	public static Holder<PlacedFeature> PATCH_WILD_CHINESE_PEAR_LEAVED_TREE;
	public static Holder<PlacedFeature> PATCH_WILD_LITCHI_TREE;
	public static Holder<PlacedFeature> PATCH_WILD_MANGO_TREE;
	public static Holder<PlacedFeature> PATCH_WILD_PEACH_TREE;

	public static final BlockPos BLOCK_BELOW = new BlockPos(0, -1, 0);
	public static final BlockPos BLOCK_ABOVE = new BlockPos(0, 1, 0);

	public static void registerWildCropGeneration() {
		FEATURE_PATCH_WILD_BLUEBERRIES = register(new ResourceLocation(fruitstack.MODID, "patch_wild_blueberries"),
				ModBiomeFeatures.WILD_CROP.get(), wildCropConfig(ModBlocks.WILD_BLUEBERRIES.get(), Blocks.GRASS, BlockPredicate.matchesTag(BLOCK_BELOW, BlockTags.DIRT)));

		FEATURE_PATCH_WILD_HAMIMELON = register(new ResourceLocation(fruitstack.MODID, "patch_wild_hamimelon"),
				ModBiomeFeatures.WILD_CROP.get(), wildCropConfig(ModBlocks.WILD_HAMIMELON.get(), Blocks.GRASS, BlockPredicate.matchesTag(BLOCK_BELOW, BlockTags.DIRT)));

		FEATURE_PATCH_WILD_BEATING_MELONS = register(new ResourceLocation(fruitstack.MODID, "patch_wild_beating_melons"),
				ModBiomeFeatures.WILD_CROP.get(), wildCropConfig(ModBlocks.WILD_BEATING_MELONS.get(), Blocks.GRASS, BlockPredicate.matchesTag(BLOCK_BELOW, BlockTags.DIRT)));

		FEATURE_PATCH_WILD_GROUND_CUCUMBER = register(new ResourceLocation(fruitstack.MODID, "patch_wild_ground_cucumber"),
				ModBiomeFeatures.WILD_CROP.get(), wildCropConfig(ModBlocks.WILD_GROUND_CUCUMBER.get(), Blocks.SAND, BlockPredicate.matchesTag(BLOCK_BELOW, BlockTags.SAND)));

		FEATURE_PATCH_WILD_HOLBOELLIA_LATIFOLIA = register(new ResourceLocation(fruitstack.MODID, "patch_wild_holboellia_latifolia"),
				ModBiomeFeatures.WILD_CROP.get(), wildCropConfig(ModBlocks.WILD_HOLBOELLIA_LATIFOLIA.get(), Blocks.GRASS, BlockPredicate.matchesTag(BLOCK_BELOW, BlockTags.DIRT)));

		FEATURE_PATCH_WILD_HUOSHEN_FRUIT = register(new ResourceLocation(fruitstack.MODID, "patch_wild_huoshen_fruit"),
				ModBiomeFeatures.WILD_CROP.get(), wildCropConfig(ModBlocks.WILD_HUOSHEN_FRUIT.get(), Blocks.SAND, BlockPredicate.matchesTag(BLOCK_BELOW, BlockTags.SAND)));

		FEATURE_PATCH_WILD_SEPTEMBER_MELON = register(new ResourceLocation(fruitstack.MODID, "patch_wild_september_melon"),
				ModBiomeFeatures.WILD_CROP.get(), wildCropConfig(ModBlocks.WILD_SEPTEMBER_MELON.get(), Blocks.GRASS, BlockPredicate.matchesTag(BLOCK_BELOW, BlockTags.DIRT)));

		FEATURE_PATCH_WILD_PITAYA = register(new ResourceLocation(fruitstack.MODID, "patch_wild_pitaya"),
				ModBiomeFeatures.WILD_CROP.get(), wildCropConfig(ModBlocks.WILD_PITAYA.get(), Blocks.GRASS, BlockPredicate.matchesTag(BLOCK_BELOW, BlockTags.DIRT)));

		FEATURE_PATCH_WILD_GOLDEN_PURE_SHEEP_HORN_HONEY = register(new ResourceLocation(fruitstack.MODID, "patch_wild_golden_pure_sheep_horn_honey"),
				ModBiomeFeatures.WILD_CROP.get(), wildCropConfig(ModBlocks.WILD_GOLDEN_PURE_SHEEP_HORN_HONEY.get(), Blocks.GRASS, BlockPredicate.matchesTag(BLOCK_BELOW, BlockTags.DIRT)));

		FEATURE_PATCH_WILD_GRAPE = register(new ResourceLocation(fruitstack.MODID, "patch_wild_grape"),
				ModBiomeFeatures.WILD_CROP.get(), wildCropConfig(ModBlocks.WILD_GRAPE.get(), Blocks.GRASS, BlockPredicate.matchesTag(BLOCK_BELOW, BlockTags.DIRT)));

		FEATURE_PATCH_WILD_GLUTINOUS_RICE = register(new ResourceLocation(fruitstack.MODID, "patch_wild_glutinous_rice"),
				ModBiomeFeatures.WILD_CROP.get(), wildCropConfig(ModBlocks.WILD_GLUTINOUS_RICE.get(), Blocks.GRASS, BlockPredicate.matchesTag(BLOCK_BELOW, BlockTags.DIRT)));

		FEATURE_PATCH_WILD_ZONG_ZI_LEAVES = register(new ResourceLocation(fruitstack.MODID, "patch_wild_zong_zi_leaves"),
				ModBiomeFeatures.WILD_CROP.get(), wildCropConfig(ModBlocks.WILD_ZONG_ZI_LEAVES.get(), Blocks.GRASS, BlockPredicate.matchesTag(BLOCK_BELOW, BlockTags.DIRT)));

		FEATURE_PATCH_WILD_BLACK_TEA_LEAVES = register(new ResourceLocation(fruitstack.MODID, "patch_wild_black_tea_leaves"),
				ModBiomeFeatures.WILD_CROP.get(), wildCropConfig(ModBlocks.WILD_BLACK_TEA_LEAVES.get(), Blocks.GRASS, BlockPredicate.matchesTag(BLOCK_BELOW, BlockTags.DIRT)));


		PATCH_WILD_BLUEBERRIES = registerPlacement(new ResourceLocation(fruitstack.MODID, "patch_wild_blueberries"),
				FEATURE_PATCH_WILD_BLUEBERRIES, RarityFilter.onAverageOnceEvery(Configuration.CHANCE_WILD_BLUEBERRIES.get()), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

		PATCH_WILD_HAMIMELON = registerPlacement(new ResourceLocation(fruitstack.MODID, "patch_wild_hamimelon"),
				FEATURE_PATCH_WILD_HAMIMELON, RarityFilter.onAverageOnceEvery(Configuration.CHANCE_WILD_HAMIMELON.get()), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

		PATCH_WILD_BEATING_MELONS = registerPlacement(new ResourceLocation(fruitstack.MODID, "patch_wild_beating_melons"),
				FEATURE_PATCH_WILD_BEATING_MELONS, RarityFilter.onAverageOnceEvery(Configuration.CHANCE_WILD_BEATING_MELONS.get()), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

		PATCH_WILD_GROUND_CUCUMBER = registerPlacement(new ResourceLocation(fruitstack.MODID, "patch_wild_ground_cucumber"),
				FEATURE_PATCH_WILD_GROUND_CUCUMBER, RarityFilter.onAverageOnceEvery(Configuration.CHANCE_WILD_GROUND_CUCUMBER.get()), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

		PATCH_WILD_HOLBOELLIA_LATIFOLIA = registerPlacement(new ResourceLocation(fruitstack.MODID, "patch_wild_holboellia_latifolia"),
				FEATURE_PATCH_WILD_HOLBOELLIA_LATIFOLIA, RarityFilter.onAverageOnceEvery(Configuration.CHANCE_WILD_HOLBOELLIA_LATIFOLIA.get()), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

		PATCH_WILD_HUOSHEN_FRUIT = registerPlacement(new ResourceLocation(fruitstack.MODID, "patch_wild_huoshen_fruit"),
				FEATURE_PATCH_WILD_HUOSHEN_FRUIT, RarityFilter.onAverageOnceEvery(Configuration.CHANCE_WILD_HUOSHEN_FRUIT.get()), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

		PATCH_WILD_SEPTEMBER_MELON = registerPlacement(new ResourceLocation(fruitstack.MODID, "patch_wild_september_melon"),
				FEATURE_PATCH_WILD_SEPTEMBER_MELON, RarityFilter.onAverageOnceEvery(Configuration.CHANCE_WILD_SEPTEMBER_MELON.get()), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

		PATCH_WILD_PITAYA = registerPlacement(new ResourceLocation(fruitstack.MODID, "patch_wild_pitaya"),
				FEATURE_PATCH_WILD_PITAYA, RarityFilter.onAverageOnceEvery(Configuration.CHANCE_WILD_PITAYA.get()), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

		PATCH_WILD_GOLDEN_PURE_SHEEP_HORN_HONEY = registerPlacement(new ResourceLocation(fruitstack.MODID, "patch_wild_golden_pure_sheep_horn_honey"),
				FEATURE_PATCH_WILD_GOLDEN_PURE_SHEEP_HORN_HONEY, RarityFilter.onAverageOnceEvery(Configuration.CHANCE_WILD_GOLDEN_PURE_SHEEP_HORN_HONEY.get()), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

		PATCH_WILD_GRAPE = registerPlacement(new ResourceLocation(fruitstack.MODID, "patch_wild_grape"),
				FEATURE_PATCH_WILD_GRAPE, RarityFilter.onAverageOnceEvery(Configuration.CHANCE_WILD_GRAPE.get()), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

		PATCH_WILD_GLUTINOUS_RICE = registerPlacement(new ResourceLocation(fruitstack.MODID, "patch_wild_glutinous_rice"),
				FEATURE_PATCH_WILD_GLUTINOUS_RICE, RarityFilter.onAverageOnceEvery(Configuration.CHANCE_WILD_GLUTINOUS_RICE.get()), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

		PATCH_WILD_ZONG_ZI_LEAVES = registerPlacement(new ResourceLocation(fruitstack.MODID, "patch_wild_zong_zi_leaves"),
				FEATURE_PATCH_WILD_ZONG_ZI_LEAVES, RarityFilter.onAverageOnceEvery(Configuration.CHANCE_WILD_ZONG_ZI_LEAVES.get()), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

		PATCH_WILD_BLACK_TEA_LEAVES = registerPlacement(new ResourceLocation(fruitstack.MODID, "patch_wild_black_tea_leaves"),
				FEATURE_PATCH_WILD_BLACK_TEA_LEAVES, RarityFilter.onAverageOnceEvery(Configuration.CHANCE_WILD_BLACK_TEA_LEAVES.get()), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());


		PATCH_WILD_APPLE_TREE = registerPlacement(new ResourceLocation(fruitstack.MODID, "patch_wild_apple_tree"),
				FEATURE_PATCH_WILD_APPLE_TREE, RarityFilter.onAverageOnceEvery(Configuration.CHANCE_WILD_APPLE_TREE.get()), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

		PATCH_WILD_APRICOT_TREE = registerPlacement(new ResourceLocation(fruitstack.MODID, "patch_wild_apricot_tree"),
				FEATURE_PATCH_WILD_APRICOT_TREE, RarityFilter.onAverageOnceEvery(Configuration.CHANCE_WILD_APRICOT_TREE.get()), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

		PATCH_WILD_GREEN_PLUM_TREE = registerPlacement(new ResourceLocation(fruitstack.MODID, "patch_wild_green_plum_tree"),
				FEATURE_PATCH_WILD_GREEN_PLUM_TREE, RarityFilter.onAverageOnceEvery(Configuration.CHANCE_WILD_GREEN_PLUM_TREE.get()), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

		PATCH_WILD_JUJUBE_TREE = registerPlacement(new ResourceLocation(fruitstack.MODID, "patch_wild_jujube_tree"),
				FEATURE_PATCH_WILD_JUJUBE_TREE, RarityFilter.onAverageOnceEvery(Configuration.CHANCE_WILD_JUJUBE_TREE.get()), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

		PATCH_WILD_MAYTHORN_TREE = registerPlacement(new ResourceLocation(fruitstack.MODID, "patch_wild_maythorn_tree"),
				FEATURE_PATCH_WILD_MAYTHORN_TREE, RarityFilter.onAverageOnceEvery(Configuration.CHANCE_WILD_MAYTHORN_TREE.get()), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

		PATCH_WILD_PEAR_TREE = registerPlacement(new ResourceLocation(fruitstack.MODID, "patch_wild_pear_tree"),
				FEATURE_PATCH_WILD_PEAR_TREE, RarityFilter.onAverageOnceEvery(Configuration.CHANCE_WILD_PEAR_TREE.get()), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

		PATCH_WILD_PLUM_TREE = registerPlacement(new ResourceLocation(fruitstack.MODID, "patch_wild_plum_tree"),
				FEATURE_PATCH_WILD_PLUM_TREE, RarityFilter.onAverageOnceEvery(Configuration.CHANCE_WILD_PLUM_TREE.get()), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

		PATCH_WILD_RED_BAYBERRY_TREE = registerPlacement(new ResourceLocation(fruitstack.MODID, "patch_wild_red_bayberry_tree"),
				FEATURE_PATCH_WILD_RED_BAYBERRY_TREE, RarityFilter.onAverageOnceEvery(Configuration.CHANCE_WILD_RED_BAYBERRY_TREE.get()), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

		PATCH_WILD_CHINESE_PEAR_LEAVED_TREE = registerPlacement(new ResourceLocation(fruitstack.MODID, "patch_wild_chinese_pear_leaved_tree"),
				FEATURE_PATCH_WILD_CHINESE_PEAR_LEAVED_TREE, RarityFilter.onAverageOnceEvery(Configuration.CHANCE_WILD_CHINESE_PEAR_LEAVED_TREE.get()), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

		PATCH_WILD_LITCHI_TREE = registerPlacement(new ResourceLocation(fruitstack.MODID, "patch_wild_litchi_tree"),
				FEATURE_PATCH_WILD_LITCHI_TREE, RarityFilter.onAverageOnceEvery(Configuration.CHANCE_WILD_LITCHI_TREE.get()), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

		PATCH_WILD_MANGO_TREE = registerPlacement(new ResourceLocation(fruitstack.MODID, "patch_wild_mango_tree"),
				FEATURE_PATCH_WILD_MANGO_TREE, RarityFilter.onAverageOnceEvery(Configuration.CHANCE_WILD_MANGO_TREE.get()), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
		PATCH_WILD_PEACH_TREE = registerPlacement(new ResourceLocation(fruitstack.MODID, "patch_wild_peach_tree"),
				FEATURE_PATCH_WILD_PEACH_TREE, RarityFilter.onAverageOnceEvery(Configuration.CHANCE_WILD_PEACH_TREE.get()), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
	}

	public static RandomPatchConfiguration randomPatchConfig(Block block, int tries, int xzSpread, BlockPredicate plantedOn) {
		return new RandomPatchConfiguration(tries, xzSpread, 3, PlacementUtils.filtered(
				Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(block)),
				BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE, plantedOn)));
	}

	public static WildCropConfiguration wildCropConfig(Block primaryBlock, Block secondaryBlock, BlockPredicate plantedOn) {
		return new WildCropConfiguration(64, 6, 3, plantBlockConfig(primaryBlock, plantedOn), plantBlockConfig(secondaryBlock, plantedOn), null);
	}

	public static WildCropConfiguration wildCropWithFloorConfig(Block primaryBlock, Block secondaryBlock, BlockPredicate plantedOn, Block floorBlock, BlockPredicate replaces) {
		return new WildCropConfiguration(64, 6, 3, plantBlockConfig(primaryBlock, plantedOn), plantBlockConfig(secondaryBlock, plantedOn), floorBlockConfig(floorBlock, replaces));
	}
	public static Holder<PlacedFeature> plantBlockConfig(Block block, BlockPredicate plantedOn) {
		return PlacementUtils.filtered(
				Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(block)),
				BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE, plantedOn));
	}
	public static Holder<PlacedFeature> floorBlockConfig(Block block, BlockPredicate replaces) {
		return PlacementUtils.filtered(
				Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(block)),
				BlockPredicate.allOf(BlockPredicate.replaceable(BLOCK_ABOVE), replaces));
	}

	// Registry stuff

	static Holder<PlacedFeature> registerPlacement(ResourceLocation id, Holder<? extends ConfiguredFeature<?, ?>> feature, PlacementModifier... modifiers) {
		return BuiltinRegistries.register(BuiltinRegistries.PLACED_FEATURE, id, new PlacedFeature(Holder.hackyErase(feature), List.of(modifiers)));
	}

	protected static <FC extends FeatureConfiguration, F extends Feature<FC>> Holder<ConfiguredFeature<FC, ?>> register(ResourceLocation id, F feature, FC featureConfig) {
		return register(BuiltinRegistries.CONFIGURED_FEATURE, id, new ConfiguredFeature<>(feature, featureConfig));
	}

	private static <V extends T, T> Holder<V> register(Registry<T> registry, ResourceLocation id, V value) {
		return (Holder<V>) BuiltinRegistries.<T>register(registry, id, value);
	}
}

package com.fruitstack.fruitstack.common.registry;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.world.level.levelgen.feature.*;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class WildCropConfiguredFeatures {
    public static Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> BLUEBERRIES_WORLDGEN = configureCrop("blueberries_worldgen", WorldGenRegistry.blueberries_worldgen);
    public static Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> HOLBOELLIA_LATIFOLIA_WORLDGEN = configureCrop("holboellia_latifolia_worldgen", WorldGenRegistry.holboellia_latifolia_worldgen);
    public static Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> HAMIMELON_WORLDGEN = configureCrop("hamimelon_worldgen", WorldGenRegistry.hamimelon_worldgen);
    public static Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> GROUND_CUCUMBER_WORLDGEN = configureCrop("ground_cucumber_worldgen", WorldGenRegistry.ground_cucumber_worldgen);
    public static Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> HUOSHEN_FRUIT_WORLDGEN = configureCrop("huoshen_fruit_worldgen", WorldGenRegistry.huoshen_fruit_worldgen);
    public static Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> BEATING_MELONS_WORLDGEN = configureCrop("beating_melons_worldgen", WorldGenRegistry.beating_melons_worldgen);
    public static Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> SEPTEMBER_MELON_WORLDGEN = configureCrop("september_melon_worldgen", WorldGenRegistry.september_melon_worldgen);
    public static Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> PITAYA_WORLDGEN = configureCrop("pitaya_worldgen", WorldGenRegistry.pitaya_worldgen);
    public static Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> GOLDEN_PURE_SHEEP_HORN_HONEY_WORLDGEN = configureCrop("golden_pure_sheep_horn_honey_worldgen", WorldGenRegistry.golden_pure_sheep_horn_honey_worldgen);
    public static Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> ZONG_ZI_LEAVES_WORLDGEN = configureCrop("zong_zi_leaves_worldgen", WorldGenRegistry.zong_zi_leaves_worldgen);
    public static Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> GRAPE_WORLDGEN = configureCrop("grape_worldgen", WorldGenRegistry.grape_worldgen);
    public static Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> GLUTINOUS_RICE_WORLDGEN = configureCrop("glutinous_rice_worldgen", WorldGenRegistry.glutinous_rice_worldgen);
    public static Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> BLACK_TEA_LEAVES_WORLDGEN = configureCrop("black_tea_leaves_worldgen", WorldGenRegistry.black_tea_leaves_worldgen);
    private static Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> configureCrop(String name, Feature<NoneFeatureConfiguration> tree){
        return FeatureUtils.register(name, tree, NoneFeatureConfiguration.INSTANCE);
    }
}

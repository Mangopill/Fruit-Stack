package com.fruitstack.fruitstack.common.registry;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.world.level.levelgen.feature.*;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class TreeConfiguredFeatures {

    //warm
    public static Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> MANGO_WORLDGEN = configureTree("mango_worldgen", WorldGenRegistry.mango_worldgen);
    public static Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> LITCHI_WORLDGEN = configureTree("litchi_worldgen", WorldGenRegistry.litchi_worldgen);
    public static Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> CHINESE_PEAR_LEAVED_WORLDGEN = configureTree("chinese_pear_leaved_worldgen", WorldGenRegistry.chinese_pear_leaved_worldgen);
    //temperate
    public static Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> APPLE_WORLDGEN = configureTree("apple_worldgen", WorldGenRegistry.apple_worldgen);
    public static Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> PEAR_WORLDGEN = configureTree("pear_worldgen", WorldGenRegistry.pear_worldgen);
    public static Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> MAYTHORN_WORLDGEN = configureTree("maythorn_worldgen", WorldGenRegistry.maythorn_worldgen);
    public static Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> PLUM_WORLDGEN = configureTree("plum_worldgen", WorldGenRegistry.plum_worldgen);
    public static Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> JUJUBE_WORLDGEN = configureTree("jujube_worldgen", WorldGenRegistry.jujube_worldgen);
    public static Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> APRICOT_WORLDGEN = configureTree("apricot_worldgen", WorldGenRegistry.apricot_worldgen);
    public static Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> RED_BAYBERRY_WORLDGEN = configureTree("red_bayberry_worldgen", WorldGenRegistry.red_bayberry_worldgen);
    public static Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> GREEN_PLUM_WORLDGEN = configureTree("green_plum_worldgen", WorldGenRegistry.green_plum_worldgen);
    public static Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> PEACH_WORLDGEN = configureTree("peach_worldgen", WorldGenRegistry.peach_worldgen);
    private static Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> configureTree(String name, Feature<NoneFeatureConfiguration> tree){
        return FeatureUtils.register(name, tree, NoneFeatureConfiguration.INSTANCE);
    }
}

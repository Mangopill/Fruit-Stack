package com.fruitstack.fruitstack.common.registry;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class TreePlacedFeatures {
    //warm
    public static Holder<PlacedFeature> MANGO_WORLDGEN = registerTree("mango_worldgen", TreeConfiguredFeatures.MANGO_WORLDGEN);
    public static Holder<PlacedFeature> LITCHI_WORLDGEN = registerTree("litchi_worldgen", TreeConfiguredFeatures.LITCHI_WORLDGEN);
    public static Holder<PlacedFeature> CHINESE_PEAR_LEAVED_WORLDGEN = registerTree("chinese_pear_leaved_worldgen", TreeConfiguredFeatures.CHINESE_PEAR_LEAVED_WORLDGEN);

    //temperate
    public static Holder<PlacedFeature> APPLE_WORLDGEN = registerTree("apple_worldgen", TreeConfiguredFeatures.APPLE_WORLDGEN);
    public static Holder<PlacedFeature> PEAR_WORLDGEN = registerTree("pear_worldgen", TreeConfiguredFeatures.PEAR_WORLDGEN);
    public static Holder<PlacedFeature> MAYTHORN_WORLDGEN = registerTree("maythorn_worldgen", TreeConfiguredFeatures.MAYTHORN_WORLDGEN);
    public static Holder<PlacedFeature> PLUM_WORLDGEN = registerTree("plum_worldgen", TreeConfiguredFeatures.PLUM_WORLDGEN);
    public static Holder<PlacedFeature> JUJUBE_WORLDGEN = registerTree("jujube_worldgen", TreeConfiguredFeatures.JUJUBE_WORLDGEN);
    public static Holder<PlacedFeature> APRICOT_WORLDGEN = registerTree("apricot_worldgen", TreeConfiguredFeatures.APRICOT_WORLDGEN);
    public static Holder<PlacedFeature> RED_BAYBERRY_WORLDGEN = registerTree("red_bayberry_worldgen", TreeConfiguredFeatures.RED_BAYBERRY_WORLDGEN);
    public static Holder<PlacedFeature> GREEN_PLUM_WORLDGEN = registerTree("green_plum_worldgen", TreeConfiguredFeatures.GREEN_PLUM_WORLDGEN);
    public static Holder<PlacedFeature> PEACH_WORLDGEN = registerTree("peach_worldgen", TreeConfiguredFeatures.PEACH_WORLDGEN);
    private static Holder<PlacedFeature> registerTree(String name, Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> tree) {
        return PlacementUtils.register(name, tree, VegetationPlacements.TREE_THRESHOLD,PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                                        PlacementUtils.countExtra(100, 1F, 0));
    }

}

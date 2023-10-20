package com.fruitstack.fruitstack.common.registry;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class WildCropPlacedFeatures {
    public static Holder<PlacedFeature> BLUEBERRIES_WORLDGEN = registerctrop("blueberries_worldgen", WildCropConfiguredFeatures.BLUEBERRIES_WORLDGEN);
    public static Holder<PlacedFeature> HOLBOELLIA_LATIFOLIA_WORLDGEN = registerctrop("holboellia_latifolia_worldgen", WildCropConfiguredFeatures.HOLBOELLIA_LATIFOLIA_WORLDGEN);
    public static Holder<PlacedFeature> HAMIMELON_WORLDGEN = registerctrop("hamimelon_worldgen", WildCropConfiguredFeatures.HAMIMELON_WORLDGEN);
    public static Holder<PlacedFeature> GROUND_CUCUMBER_WORLDGEN = registerctrop("ground_cucumber_worldgen", WildCropConfiguredFeatures.GROUND_CUCUMBER_WORLDGEN);
    public static Holder<PlacedFeature> HUOSHEN_FRUIT_WORLDGEN = registerctrop("huoshen_fruit_worldgen", WildCropConfiguredFeatures.HUOSHEN_FRUIT_WORLDGEN);
    public static Holder<PlacedFeature> BEATING_MELONS_WORLDGEN = registerctrop("beating_melons_worldgen", WildCropConfiguredFeatures.BEATING_MELONS_WORLDGEN);
    public static Holder<PlacedFeature> SEPTEMBER_MELON_WORLDGEN = registerctrop("september_melon_worldgen", WildCropConfiguredFeatures.SEPTEMBER_MELON_WORLDGEN);
    public static Holder<PlacedFeature> PITAYA_WORLDGEN = registerctrop("pitaya_worldgen", WildCropConfiguredFeatures.PITAYA_WORLDGEN);
    public static Holder<PlacedFeature> GOLDEN_PURE_SHEEP_HORN_HONEY_WORLDGEN = registerctrop("golden_pure_sheep_horn_honey_worldgen", WildCropConfiguredFeatures.GOLDEN_PURE_SHEEP_HORN_HONEY_WORLDGEN);
    public static Holder<PlacedFeature> ZONG_ZI_LEAVES_WORLDGEN = registerctrop("zong_zi_leaves_worldgen", WildCropConfiguredFeatures.ZONG_ZI_LEAVES_WORLDGEN);
    public static Holder<PlacedFeature> GRAPE_WORLDGEN = registerctrop("grape_worldgen", WildCropConfiguredFeatures.GRAPE_WORLDGEN);
    public static Holder<PlacedFeature> GLUTINOUS_RICE_WORLDGEN = registerctrop("glutinous_rice_worldgen", WildCropConfiguredFeatures.GLUTINOUS_RICE_WORLDGEN);
    public static Holder<PlacedFeature> BLACK_TEA_LEAVES_WORLDGEN = registerctrop("black_tea_leaves_worldgen", WildCropConfiguredFeatures.BLACK_TEA_LEAVES_WORLDGEN);
    private static Holder<PlacedFeature> registerctrop(String name, Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> tree) {
        // countExtra can't take 0F for the weight, but the extra is 0 anyway so 1F is fine.
        return PlacementUtils.register(name, tree, VegetationPlacements.TREE_THRESHOLD,PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                                        PlacementUtils.countExtra(100, 1F, 0));
    }

}

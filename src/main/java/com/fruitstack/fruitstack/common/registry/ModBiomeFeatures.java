package com.fruitstack.fruitstack.common.registry;

import com.fruitstack.fruitstack.common.world.configuration.WildCropConfiguration;
import com.fruitstack.fruitstack.common.world.feature.WildCropFeature;
import com.fruitstack.fruitstack.common.world.growers.*;
import com.fruitstack.fruitstack.fruitstack;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomeFeatures
{
	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, fruitstack.MODID);

	public static final RegistryObject<Feature<WildCropConfiguration>> WILD_CROP = FEATURES.register("wild_crop", () -> new WildCropFeature(WildCropConfiguration.CODEC));
	public static final RegistryObject<Feature<NoneFeatureConfiguration>> WILD_APPLE_TREE = FEATURES.register("wild_apple_tree", () -> new AppleTreeFeatureSapling(NoneFeatureConfiguration.CODEC));
	public static final RegistryObject<Feature<NoneFeatureConfiguration>> WILD_APRICOT_TREE = FEATURES.register("wild_apricot_tree", () -> new ApricotTreeFeatureSapling(NoneFeatureConfiguration.CODEC));
	public static final RegistryObject<Feature<NoneFeatureConfiguration>> WILD_GREEN_PLUM_TREE = FEATURES.register("wild_green_plum_tree", () -> new GreenPlumTreeFeatureSapling(NoneFeatureConfiguration.CODEC));
	public static final RegistryObject<Feature<NoneFeatureConfiguration>> WILD_JUJUBE_TREE = FEATURES.register("wild_jujube_tree", () -> new JujubeTreeFeatureSapling(NoneFeatureConfiguration.CODEC));
	public static final RegistryObject<Feature<NoneFeatureConfiguration>> WILD_MAYTHORN_TREE = FEATURES.register("wild_maythorn_tree", () -> new MaythornTreeFeatureSapling(NoneFeatureConfiguration.CODEC));
	public static final RegistryObject<Feature<NoneFeatureConfiguration>> WILD_PEAR_TREE = FEATURES.register("wild_pear_tree", () -> new PearTreeFeatureSapling(NoneFeatureConfiguration.CODEC));
	public static final RegistryObject<Feature<NoneFeatureConfiguration>> WILD_PLUM_TREE = FEATURES.register("wild_plum_tree", () -> new PlumTreeFeatureSapling(NoneFeatureConfiguration.CODEC));
	public static final RegistryObject<Feature<NoneFeatureConfiguration>> WILD_RED_BAYBERRY_TREE = FEATURES.register("wild_red_bayberry_tree", () -> new BayberryTreeFeatureSapling(NoneFeatureConfiguration.CODEC));
	public static final RegistryObject<Feature<NoneFeatureConfiguration>> WILD_CHINESE_PEAR_LEAVED_TREE = FEATURES.register("wild_chinese_pear_leaved_tree", () -> new ChinesePearLeavedTreeFeatureSapling(NoneFeatureConfiguration.CODEC));
	public static final RegistryObject<Feature<NoneFeatureConfiguration>> WILD_LITCHI_TREE = FEATURES.register("wild_litchi_tree", () -> new LitchiTreeFeatureSapling(NoneFeatureConfiguration.CODEC));
	public static final RegistryObject<Feature<NoneFeatureConfiguration>> WILD_MANGO_TREE = FEATURES.register("wild_mango_tree", () -> new MangoTreeFeatureSapling(NoneFeatureConfiguration.CODEC));
	public static final RegistryObject<Feature<NoneFeatureConfiguration>> WILD_PEACH_TREE = FEATURES.register("wild_peach_tree", () -> new PeachTreeFeatureSapling(NoneFeatureConfiguration.CODEC));
}

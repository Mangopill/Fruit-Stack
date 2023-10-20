package com.fruitstack.fruitstack.common.registry;

import com.fruitstack.fruitstack.common.worldgen.*;
import com.fruitstack.fruitstack.config.EnableConfig;
import com.fruitstack.fruitstack.fruitstack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;


public class WorldGenRegistry {
	public static Feature<NoneFeatureConfiguration> mango_worldgen;
	public static Feature<NoneFeatureConfiguration> litchi_worldgen;
	public static Feature<NoneFeatureConfiguration> apple_worldgen;
	public static Feature<NoneFeatureConfiguration> blueberries_worldgen;
	public static Feature<NoneFeatureConfiguration> holboellia_latifolia_worldgen;
	public static Feature<NoneFeatureConfiguration> hamimelon_worldgen;
	public static Feature<NoneFeatureConfiguration> ground_cucumber_worldgen;
	public static Feature<NoneFeatureConfiguration> huoshen_fruit_worldgen;
	public static Feature<NoneFeatureConfiguration> beating_melons_worldgen;
	public static Feature<NoneFeatureConfiguration> september_melon_worldgen;
	public static Feature<NoneFeatureConfiguration> pitaya_worldgen;
	public static Feature<NoneFeatureConfiguration> golden_pure_sheep_horn_honey_worldgen;
	public static Feature<NoneFeatureConfiguration> zong_zi_leaves_worldgen;
	public static Feature<NoneFeatureConfiguration> pear_worldgen;
	public static Feature<NoneFeatureConfiguration> maythorn_worldgen;
	public static Feature<NoneFeatureConfiguration> chinese_pear_leaved_worldgen;
	public static Feature<NoneFeatureConfiguration> plum_worldgen;
	public static Feature<NoneFeatureConfiguration> jujube_worldgen;
	public static Feature<NoneFeatureConfiguration> apricot_worldgen;
	public static Feature<NoneFeatureConfiguration> red_bayberry_worldgen;
	public static Feature<NoneFeatureConfiguration> green_plum_worldgen;
	public static Feature<NoneFeatureConfiguration> grape_worldgen;
	public static Feature<NoneFeatureConfiguration> peach_worldgen;
	public static Feature<NoneFeatureConfiguration> glutinous_rice_worldgen;
	public static Feature<NoneFeatureConfiguration> black_tea_leaves_worldgen;
	public static void registerAll(RegistryEvent.Register<Feature<?>> event) {
		if (!event.getName().equals(ForgeRegistries.FEATURES.getRegistryName()))
			return;
		IForgeRegistry<Feature<?>> r = event.getRegistry();
		if (EnableConfig.apple_worldgen.get())
			apple_worldgen = register(r, new AppleTreeFeature(NoneFeatureConfiguration.CODEC), "apple_worldgen");
		if (EnableConfig.mango_worldgen.get())
			mango_worldgen = register(r, new MangoTreeFeature(NoneFeatureConfiguration.CODEC), "mango_worldgen");
		if (EnableConfig.litchi_worldgen.get())
			litchi_worldgen = register(r, new LitchiTreeFeature(NoneFeatureConfiguration.CODEC), "litchi_worldgen");
		if (EnableConfig.blueberries_worldgen.get())
			blueberries_worldgen = register(r, new WildColdCropFeature(NoneFeatureConfiguration.CODEC), "blueberries_worldgen");
		if (EnableConfig.holboellia_latifolia_worldgen.get())
			holboellia_latifolia_worldgen = register(r, new WildTemperateCropFeature(NoneFeatureConfiguration.CODEC), "holboellia_latifolia_worldgen");
		if (EnableConfig.hamimelon_worldgen.get())
			hamimelon_worldgen = register(r, new WildWarmCropFeature(NoneFeatureConfiguration.CODEC), "hamimelon_worldgen");
		if (EnableConfig.ground_cucumber_worldgen.get())
			ground_cucumber_worldgen = register(r, new WildDroughtCropFeature(NoneFeatureConfiguration.CODEC), "ground_cucumber_worldgen");
		if (EnableConfig.huoshen_fruit_worldgen.get())
			huoshen_fruit_worldgen = register(r, new WildDroughtCropFeature(NoneFeatureConfiguration.CODEC), "huoshen_fruit_worldgen");
		if (EnableConfig.beating_melons_worldgen.get())
			beating_melons_worldgen = register(r, new WildTemperateCropFeature(NoneFeatureConfiguration.CODEC), "beating_melons_worldgen");
		if (EnableConfig.september_melon_worldgen.get())
			september_melon_worldgen = register(r, new WildTemperateCropFeature(NoneFeatureConfiguration.CODEC), "september_melon_worldgen");
		if (EnableConfig.pitaya_worldgen.get())
			pitaya_worldgen = register(r, new WildWarmCropFeature(NoneFeatureConfiguration.CODEC), "pitaya_worldgen");
		if (EnableConfig.golden_pure_sheep_horn_honey_worldgen.get())
			golden_pure_sheep_horn_honey_worldgen = register(r, new WildTemperateCropFeature(NoneFeatureConfiguration.CODEC), "golden_pure_sheep_horn_honey_worldgen");
		if (EnableConfig.grape_worldgen.get())
			grape_worldgen = register(r, new WildWarmCropFeature(NoneFeatureConfiguration.CODEC), "grape_worldgen");
		if (EnableConfig.glutinous_rice_worldgen.get())
			glutinous_rice_worldgen = register(r, new WildTemperateCropFeature(NoneFeatureConfiguration.CODEC), "glutinous_rice_worldgen");
		if (EnableConfig.zong_zi_leaves_worldgen.get())
			zong_zi_leaves_worldgen = register(r, new WildTemperateCropFeature(NoneFeatureConfiguration.CODEC), "zong_zi_leaves_worldgen");
		if (EnableConfig.pear_worldgen.get())
			pear_worldgen = register(r, new PearTreeFeature(NoneFeatureConfiguration.CODEC), "pear_worldgen");
		if (EnableConfig.maythorn_worldgen.get())
			maythorn_worldgen = register(r, new MaythornTreeFeature(NoneFeatureConfiguration.CODEC), "maythorn_worldgen");
		if (EnableConfig.chinese_pear_leaved_worldgen.get())
			chinese_pear_leaved_worldgen = register(r, new ChinesePearLeavedTreeFeature(NoneFeatureConfiguration.CODEC), "chinese_pear_leaved_worldgen");
		if (EnableConfig.plum_worldgen.get())
			plum_worldgen = register(r, new PlumTreeFeature(NoneFeatureConfiguration.CODEC), "plum_worldgen");
		if (EnableConfig.jujube_worldgen.get())
			jujube_worldgen = register(r, new JujubeTreeFeature(NoneFeatureConfiguration.CODEC), "jujube_worldgen");
		if (EnableConfig.apricot_worldgen.get())
			apricot_worldgen = register(r, new ApricotTreeFeature(NoneFeatureConfiguration.CODEC), "apricot_worldgen");
		if (EnableConfig.red_bayberry_worldgen.get())
			red_bayberry_worldgen = register(r, new BayberryTreeFeature(NoneFeatureConfiguration.CODEC), "red_bayberry_worldgen");
		if (EnableConfig.green_plum_worldgen.get())
			green_plum_worldgen = register(r, new BayberryTreeFeature(NoneFeatureConfiguration.CODEC), "green_plum_worldgen");
		if (EnableConfig.black_tea_leaves_worldgen.get())
			black_tea_leaves_worldgen = register(r, new WildWarmCropFeature(NoneFeatureConfiguration.CODEC), "black_tea_leaves_worldgen");
		if (EnableConfig.peach_worldgen.get())
			peach_worldgen = register(r, new PeachTreeFeature(NoneFeatureConfiguration.CODEC), "peach_worldgen");
	}

	private static <V extends R, R extends IForgeRegistryEntry<R>> V register(IForgeRegistry<R> registry, V value,
			String name) {
		ResourceLocation id = fruitstack.getId(name);
		value.setRegistryName(id);
		registry.register(value);
		return value;
	}
}

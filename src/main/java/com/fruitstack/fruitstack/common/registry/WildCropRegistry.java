package com.fruitstack.fruitstack.common.registry;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.Set;

public class WildCropRegistry {
	
	public static void addToBiome(BiomeLoadingEvent evt) {
		ResourceKey<Biome> key = ResourceKey.create(Registry.BIOME_REGISTRY, evt.getName());
		Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);
		//cold
		if (WorldGenRegistry.blueberries_worldgen != null) {
			if (evt.getCategory().equals(Biome.BiomeCategory.TAIGA)) {
						evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
								WildCropPlacedFeatures.BLUEBERRIES_WORLDGEN);
			}
		}
		//temperate
		if (WorldGenRegistry.holboellia_latifolia_worldgen != null) {
			if (evt.getCategory().equals(Biome.BiomeCategory.FOREST) || evt.getCategory().equals(Biome.BiomeCategory.PLAINS)) {
				evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
						WildCropPlacedFeatures.HOLBOELLIA_LATIFOLIA_WORLDGEN);
			}
		}
		if (WorldGenRegistry.beating_melons_worldgen != null) {
			if (evt.getCategory().equals(Biome.BiomeCategory.FOREST) || evt.getCategory().equals(Biome.BiomeCategory.PLAINS)) {
				evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
						WildCropPlacedFeatures.BEATING_MELONS_WORLDGEN);
			}
		}
		if (WorldGenRegistry.september_melon_worldgen != null) {
			if (evt.getCategory().equals(Biome.BiomeCategory.FOREST) || evt.getCategory().equals(Biome.BiomeCategory.PLAINS)) {
				evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
						WildCropPlacedFeatures.SEPTEMBER_MELON_WORLDGEN);
			}
		}
		if (WorldGenRegistry.golden_pure_sheep_horn_honey_worldgen != null) {
			if (evt.getCategory().equals(Biome.BiomeCategory.FOREST) || evt.getCategory().equals(Biome.BiomeCategory.PLAINS)) {
				evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
						WildCropPlacedFeatures.GOLDEN_PURE_SHEEP_HORN_HONEY_WORLDGEN);
			}
		}
		if (WorldGenRegistry.zong_zi_leaves_worldgen != null) {
			if (evt.getCategory().equals(Biome.BiomeCategory.FOREST) || evt.getCategory().equals(Biome.BiomeCategory.PLAINS)) {
				evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
						WildCropPlacedFeatures.ZONG_ZI_LEAVES_WORLDGEN);
			}
		}
		if (WorldGenRegistry.glutinous_rice_worldgen != null) {
			if (evt.getCategory().equals(Biome.BiomeCategory.FOREST) || evt.getCategory().equals(Biome.BiomeCategory.PLAINS)) {
				evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
						WildCropPlacedFeatures.GLUTINOUS_RICE_WORLDGEN);
			}
		}
		//warm
		if (WorldGenRegistry.hamimelon_worldgen != null) {
			if (evt.getCategory().equals(Biome.BiomeCategory.JUNGLE)) {
				evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
						WildCropPlacedFeatures.HAMIMELON_WORLDGEN);
			}
		}
		if (WorldGenRegistry.pitaya_worldgen != null) {
			if (evt.getCategory().equals(Biome.BiomeCategory.JUNGLE)) {
				evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
						WildCropPlacedFeatures.PITAYA_WORLDGEN);
			}
		}
		if (WorldGenRegistry.grape_worldgen != null) {
			if (evt.getCategory().equals(Biome.BiomeCategory.JUNGLE)) {
				evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
						WildCropPlacedFeatures.GRAPE_WORLDGEN);
			}
		}
		if (WorldGenRegistry.black_tea_leaves_worldgen != null) {
			if (evt.getCategory().equals(Biome.BiomeCategory.JUNGLE)) {
				evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
						WildCropPlacedFeatures.BLACK_TEA_LEAVES_WORLDGEN);
			}
		}
		//drought
		if (WorldGenRegistry.ground_cucumber_worldgen != null) {
			if (evt.getCategory().equals(Biome.BiomeCategory.DESERT)) {
				evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
						WildCropPlacedFeatures.GROUND_CUCUMBER_WORLDGEN);
			}
		}
		if (WorldGenRegistry.huoshen_fruit_worldgen != null) {
			if (evt.getCategory().equals(Biome.BiomeCategory.DESERT)) {
				evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
						WildCropPlacedFeatures.HUOSHEN_FRUIT_WORLDGEN);
			}
		}
	}


}

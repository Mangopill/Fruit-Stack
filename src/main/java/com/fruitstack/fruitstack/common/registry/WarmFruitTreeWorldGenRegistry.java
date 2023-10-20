package com.fruitstack.fruitstack.common.registry;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.Set;

public class WarmFruitTreeWorldGenRegistry {
	
	public static void addToBiomes(BiomeLoadingEvent evt) {
		ResourceKey<Biome> key = ResourceKey.create(Registry.BIOME_REGISTRY, evt.getName());
		Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);
		if (WorldGenRegistry.mango_worldgen != null) {
			if (evt.getCategory().equals(Biome.BiomeCategory.JUNGLE)) {
				evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
						TreePlacedFeatures.MANGO_WORLDGEN);
			}
			else if (evt.getCategory().equals(Biome.BiomeCategory.OCEAN)) {
				evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
						TreePlacedFeatures.MANGO_WORLDGEN);
			}
			else if (evt.getCategory().equals(Biome.BiomeCategory.SWAMP)) {
				evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
						TreePlacedFeatures.MANGO_WORLDGEN);
			}
		}
		if (WorldGenRegistry.litchi_worldgen != null) {
			if (evt.getCategory().equals(Biome.BiomeCategory.JUNGLE)) {
				evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
						TreePlacedFeatures.LITCHI_WORLDGEN);
			}
			else if (evt.getCategory().equals(Biome.BiomeCategory.OCEAN)) {
				evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
						TreePlacedFeatures.LITCHI_WORLDGEN);
			}
			else if (evt.getCategory().equals(Biome.BiomeCategory.SWAMP)) {
				evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
						TreePlacedFeatures.LITCHI_WORLDGEN);
			}
		}
		if (WorldGenRegistry.chinese_pear_leaved_worldgen != null) {
			if (evt.getCategory().equals(Biome.BiomeCategory.JUNGLE)) {
				evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
						TreePlacedFeatures.CHINESE_PEAR_LEAVED_WORLDGEN);
			}
			else if (evt.getCategory().equals(Biome.BiomeCategory.OCEAN)) {
				evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
						TreePlacedFeatures.CHINESE_PEAR_LEAVED_WORLDGEN);
			}
			else if (evt.getCategory().equals(Biome.BiomeCategory.SWAMP)) {
				evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
						TreePlacedFeatures.CHINESE_PEAR_LEAVED_WORLDGEN);
			}
		}
	}
}
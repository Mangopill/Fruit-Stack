package com.fruitstack.fruitstack.common.registry;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.Set;

public class TemperateFruitTreeWorldGenRegistry {
	
	public static void addToBiome(BiomeLoadingEvent evt) {
		ResourceKey<Biome> key = ResourceKey.create(Registry.BIOME_REGISTRY, evt.getName());
		Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);
		if ((evt.getClimate().temperature >= 1F || evt.getClimate().temperature < 0.2F) && !types.contains(BiomeDictionary.Type.SPOOKY)) return;
		//apple
		if (WorldGenRegistry.apple_worldgen != null) {
			if (evt.getCategory().equals(Biome.BiomeCategory.FOREST)) {
						evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
								TreePlacedFeatures.APPLE_WORLDGEN);
			}
			else if (types.contains(BiomeDictionary.Type.HILLS)) {
						evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
								TreePlacedFeatures.APPLE_WORLDGEN);
			}
			else if (types.contains(BiomeDictionary.Type.SPOOKY)) {
				evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
						TreePlacedFeatures.APPLE_WORLDGEN);
			}
		}
		//pear
		if (WorldGenRegistry.pear_worldgen != null) {
			if (evt.getCategory().equals(Biome.BiomeCategory.FOREST)) {
				evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
						TreePlacedFeatures.PEAR_WORLDGEN);
			}
			else if (types.contains(BiomeDictionary.Type.HILLS)) {
				evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
						TreePlacedFeatures.PEAR_WORLDGEN);
			}
			else if (types.contains(BiomeDictionary.Type.SPOOKY)) {
				evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
						TreePlacedFeatures.PEAR_WORLDGEN);
			}
		}
		//maythorn
		if (WorldGenRegistry.maythorn_worldgen != null) {
			if (evt.getCategory().equals(Biome.BiomeCategory.FOREST)) {
				evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
						TreePlacedFeatures.MAYTHORN_WORLDGEN);
			}
			else if (types.contains(BiomeDictionary.Type.HILLS)) {
				evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
						TreePlacedFeatures.MAYTHORN_WORLDGEN);
			}
			else if (types.contains(BiomeDictionary.Type.SPOOKY)) {
				evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
						TreePlacedFeatures.MAYTHORN_WORLDGEN);
			}
		}
		//plum
		if (WorldGenRegistry.plum_worldgen != null) {
			if (evt.getCategory().equals(Biome.BiomeCategory.FOREST)) {
				evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
						TreePlacedFeatures.PLUM_WORLDGEN);
			}
			else if (types.contains(BiomeDictionary.Type.HILLS)) {
				evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
						TreePlacedFeatures.PLUM_WORLDGEN);
			}
			else if (types.contains(BiomeDictionary.Type.SPOOKY)) {
				evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
						TreePlacedFeatures.PLUM_WORLDGEN);
			}
		}
		//jujube
		if (WorldGenRegistry.jujube_worldgen != null) {
			if (evt.getCategory().equals(Biome.BiomeCategory.FOREST)) {
				evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
						TreePlacedFeatures.JUJUBE_WORLDGEN);
			}
			else if (types.contains(BiomeDictionary.Type.HILLS)) {
				evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
						TreePlacedFeatures.JUJUBE_WORLDGEN);
			}
			else if (types.contains(BiomeDictionary.Type.SPOOKY)) {
				evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
						TreePlacedFeatures.JUJUBE_WORLDGEN);
			}
		}
		//apricot
		if (WorldGenRegistry.apricot_worldgen != null) {
			if (evt.getCategory().equals(Biome.BiomeCategory.FOREST)) {
				evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
						TreePlacedFeatures.APRICOT_WORLDGEN);
			}
			else if (types.contains(BiomeDictionary.Type.HILLS)) {
				evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
						TreePlacedFeatures.APRICOT_WORLDGEN);
			}
			else if (types.contains(BiomeDictionary.Type.SPOOKY)) {
				evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
						TreePlacedFeatures.APRICOT_WORLDGEN);
			}
		}
		//red_bayberry
		if (WorldGenRegistry.red_bayberry_worldgen != null) {
			if (evt.getCategory().equals(Biome.BiomeCategory.FOREST)) {
				evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
						TreePlacedFeatures.RED_BAYBERRY_WORLDGEN);
			}
			else if (types.contains(BiomeDictionary.Type.HILLS)) {
				evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
						TreePlacedFeatures.RED_BAYBERRY_WORLDGEN);
			}
			else if (types.contains(BiomeDictionary.Type.SPOOKY)) {
				evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
						TreePlacedFeatures.RED_BAYBERRY_WORLDGEN);
			}
		}
		//green_plum
		if (WorldGenRegistry.green_plum_worldgen != null) {
			if (evt.getCategory().equals(Biome.BiomeCategory.FOREST)) {
				evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
						TreePlacedFeatures.GREEN_PLUM_WORLDGEN);
			}
			else if (types.contains(BiomeDictionary.Type.HILLS)) {
				evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
						TreePlacedFeatures.GREEN_PLUM_WORLDGEN);
			}
			else if (types.contains(BiomeDictionary.Type.SPOOKY)) {
				evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
						TreePlacedFeatures.GREEN_PLUM_WORLDGEN);
			}
		}
		//peach
		if (WorldGenRegistry.peach_worldgen != null) {
			if (evt.getCategory().equals(Biome.BiomeCategory.FOREST)) {
				evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
						TreePlacedFeatures.PEACH_WORLDGEN);
			}
			else if (types.contains(BiomeDictionary.Type.HILLS)) {
				evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
						TreePlacedFeatures.PEACH_WORLDGEN);
			}
			else if (types.contains(BiomeDictionary.Type.SPOOKY)) {
				evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
						TreePlacedFeatures.PEACH_WORLDGEN);
			}
		}
	}


}

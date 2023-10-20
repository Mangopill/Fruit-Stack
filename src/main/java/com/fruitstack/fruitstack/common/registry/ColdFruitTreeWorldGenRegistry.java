package com.fruitstack.fruitstack.common.registry;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.Set;

public class ColdFruitTreeWorldGenRegistry {
	
	public static void addToBiomes(BiomeLoadingEvent evt) {
		ResourceKey<Biome> key = ResourceKey.create(Registry.BIOME_REGISTRY, evt.getName());
		Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);
		//maple
		/*if (WorldGenRegistry.maple_worldgen != null) {
			if (evt.getCategory().equals(Biome.BiomeCategory.CONIFEROUS)) {
				evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
						TreePlacedFeatures.MAPLE_WORLDGEN);
			}
			 else if (evt.getCategory().equals(Biome.BiomeCategory.COLD)) {
				evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
						TreePlacedFeatures.MAPLE_WORLDGEN);
			}
			else if (evt.getCategory().equals(Biome.BiomeCategory.HILLS) && types.contains(BiomeDictionary.Type.COLD)) {
				evt.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
						TreePlacedFeatures.MAPLE_WORLDGEN);
			}
		}*/
	}
}

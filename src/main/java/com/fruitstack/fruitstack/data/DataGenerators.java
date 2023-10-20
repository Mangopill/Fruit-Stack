package com.fruitstack.fruitstack.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import com.fruitstack.fruitstack.fruitstack;


@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = fruitstack.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators
{
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		ExistingFileHelper helper = event.getExistingFileHelper();

		BlockTags blockTags = new BlockTags(generator, fruitstack.MODID, helper);
		generator.addProvider(event.includeServer(), blockTags);
		generator.addProvider(event.includeServer(), new ItemTags(generator, blockTags, fruitstack.MODID, helper));
		generator.addProvider(event.includeServer(), new Recipes(generator));
		generator.addProvider(event.includeServer(), new Advancements(generator));

		BlockStates blockStates = new BlockStates(generator, helper);
		generator.addProvider(event.includeClient(), blockStates);
		generator.addProvider(event.includeClient(), new ItemModels(generator, blockStates.models().existingFileHelper));
		}
	}

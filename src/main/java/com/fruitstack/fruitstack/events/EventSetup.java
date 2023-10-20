package com.fruitstack.fruitstack.events;

import com.fruitstack.fruitstack.config.FeatureConfig;
import com.fruitstack.fruitstack.config.RightClickConfig;
import com.fruitstack.fruitstack.events.harvest.FruitHarvest;

import net.minecraftforge.common.MinecraftForge;


public class EventSetup {
	public static void setupEvents() {
		MinecraftForge.EVENT_BUS.register(new EventSetup());

		if (FeatureConfig.rightclick_harvest.get()) {
			if (RightClickConfig.crop_right_click.get())
				MinecraftForge.EVENT_BUS.register(new FruitHarvest());
		}

	
}
}

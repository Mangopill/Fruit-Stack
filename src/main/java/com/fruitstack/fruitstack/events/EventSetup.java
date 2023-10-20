package com.fruitstack.fruitstack.events;

import com.fruitstack.fruitstack.events.harvest.FruitHarvest;

import net.minecraftforge.common.MinecraftForge;


public class EventSetup {
	public static void setupEvents() {
		MinecraftForge.EVENT_BUS.register(new EventSetup());
		MinecraftForge.EVENT_BUS.register(new FruitHarvest());
    }
}

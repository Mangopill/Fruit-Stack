package com.fruitstack.fruitstack.client;

import com.fruitstack.fruitstack.client.gui.JuicerScreen;
import com.fruitstack.fruitstack.common.registry.ModMenuTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import com.fruitstack.fruitstack.client.gui.TvfmpoiPotScreen;

public class ClientSetup
{
	public static void init(final FMLClientSetupEvent event) {
		event.enqueueWork(() ->
		{
			MenuScreens.register(ModMenuTypes.TRIPOD_VESSEL_FOR_MAKING_PILLS_OF_IMMORTALITY.get(), TvfmpoiPotScreen::new);
			MenuScreens.register(ModMenuTypes.JUICER.get(), JuicerScreen::new);
		});
	}
}

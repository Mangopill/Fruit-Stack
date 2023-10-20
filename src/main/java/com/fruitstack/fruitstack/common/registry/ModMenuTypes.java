package com.fruitstack.fruitstack.common.registry;

import com.fruitstack.fruitstack.common.block.entity.container.JuicerBlockMenu;
import com.fruitstack.fruitstack.common.block.entity.container.TvfmpoitBlockMenu;
import com.fruitstack.fruitstack.fruitstack;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModMenuTypes
{
	public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, fruitstack.MODID);

	public static final RegistryObject<MenuType<TvfmpoitBlockMenu>> TRIPOD_VESSEL_FOR_MAKING_PILLS_OF_IMMORTALITY = MENU_TYPES
			.register("tvfmpoit", () -> IForgeMenuType.create(TvfmpoitBlockMenu::new));
	public static final RegistryObject<MenuType<JuicerBlockMenu>> JUICER = MENU_TYPES
			.register("juicer", () -> IForgeMenuType.create(JuicerBlockMenu::new));
}

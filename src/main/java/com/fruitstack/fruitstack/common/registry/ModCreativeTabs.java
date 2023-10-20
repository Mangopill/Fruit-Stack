package com.fruitstack.fruitstack.common.registry;

import com.fruitstack.fruitstack.fruitstack;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs
{
	public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, fruitstack.MODID);

	public static final RegistryObject<CreativeModeTab> TAB_FARMERS_DELIGHT = CREATIVE_TABS.register(fruitstack.MODID,
			() -> CreativeModeTab.builder()
					.title(Component.translatable("itemGroup.fruitstack"))
					.icon(() -> new ItemStack(ModBlocks.CLAY_OVEN.get()))
					.displayItems((parameters, output) -> ModItems.CREATIVE_TAB_ITEMS.forEach((item) -> output.accept(item.get())))
					.build());
}
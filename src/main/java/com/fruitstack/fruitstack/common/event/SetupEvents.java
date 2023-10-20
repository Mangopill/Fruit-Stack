package com.fruitstack.fruitstack.common.event;

import com.fruitstack.fruitstack.common.crafting.ingredient.ToolActionIngredient;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.fruitstack.fruitstack.fruitstack.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SetupEvents
{
	@SubscribeEvent
	public static void registerRecipeElements(RegistryEvent.Register<RecipeSerializer<?>> event) {
		CraftingHelper.register(new ResourceLocation(MODID, "tool_action"), ToolActionIngredient.SERIALIZER);
	}
}

package com.fruitstack.fruitstack.common.registry;

import com.fruitstack.fruitstack.common.crafting.JuicerRecipe;
import com.fruitstack.fruitstack.common.crafting.TvfmpoitRecipe;
import com.fruitstack.fruitstack.fruitstack;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleRecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import com.fruitstack.fruitstack.common.crafting.FoodServingRecipe;

public class ModRecipeSerializers
{
	public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, fruitstack.MODID);

	public static final RegistryObject<RecipeSerializer<?>> COOKING = RECIPE_SERIALIZERS.register("cooking", TvfmpoitRecipe.Serializer::new);
	public static final RegistryObject<RecipeSerializer<?>> JUICER = RECIPE_SERIALIZERS.register("juicer", JuicerRecipe.Serializer::new);


	public static final RegistryObject<SimpleRecipeSerializer<?>> FOOD_SERVING =
			RECIPE_SERIALIZERS.register("food_serving", () -> new SimpleRecipeSerializer<>(FoodServingRecipe::new));
}

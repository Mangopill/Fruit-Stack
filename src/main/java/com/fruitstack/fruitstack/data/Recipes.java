package com.fruitstack.fruitstack.data;

import com.fruitstack.fruitstack.data.recipe.JuicerRecipe;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import com.fruitstack.fruitstack.data.recipe.TvfmpoitRecipe;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Consumer;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class Recipes extends RecipeProvider
{
	public Recipes(DataGenerator generator) {
		super(generator);
	}

	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
		TvfmpoitRecipe.register(consumer);
		JuicerRecipe.register(consumer);
	}

}

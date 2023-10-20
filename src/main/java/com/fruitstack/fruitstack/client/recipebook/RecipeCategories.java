package com.fruitstack.fruitstack.client.recipebook;

import com.fruitstack.fruitstack.common.crafting.TvfmpoitRecipe;
import com.fruitstack.fruitstack.common.item.DrinkableItem;
import com.fruitstack.fruitstack.common.registry.ModItems;
import com.fruitstack.fruitstack.common.registry.ModRecipeTypes;
import com.fruitstack.fruitstack.fruitstack;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.RecipeBookCategories;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.client.RecipeBookRegistry;

import java.util.function.Supplier;

public class RecipeCategories
{
	public static final Supplier<RecipeBookCategories> COOKING_SEARCH = Suppliers.memoize(() -> RecipeBookCategories.create("COOKING_SEARCH", new ItemStack(Items.COMPASS)));
	public static final Supplier<RecipeBookCategories> COOKING_MEALS = Suppliers.memoize(() -> RecipeBookCategories.create("COOKING_MEALS", new ItemStack(ModItems.SOUR_PLUM_CHICKEN_BLOCK.get())));
	public static final Supplier<RecipeBookCategories> COOKING_DRINKS = Suppliers.memoize(() -> RecipeBookCategories.create("COOKING_DRINKS", new ItemStack(ModItems.MANGO_JAM.get())));
	public static final Supplier<RecipeBookCategories> COOKING_MISC = Suppliers.memoize(() -> RecipeBookCategories.create("COOKING_MISC", new ItemStack(ModItems.APRICOT_RICE_DUMPLING.get()), new ItemStack(ModItems.APRICOT_RICE_DUMPLING.get())));

	public static void init() {
		RecipeBookRegistry.addCategoriesToType(fruitstack.RECIPE_TYPE_COOKING, ImmutableList.of(COOKING_SEARCH.get(), COOKING_MEALS.get(), COOKING_DRINKS.get(), COOKING_MISC.get()));
		RecipeBookRegistry.addAggregateCategories(COOKING_SEARCH.get(), ImmutableList.of(COOKING_MEALS.get(), COOKING_DRINKS.get(), COOKING_MISC.get()));
		RecipeBookRegistry.addCategoriesFinder(ModRecipeTypes.COOKING.get(), recipe ->
		{
			if (recipe instanceof TvfmpoitRecipe cookingRecipe) {
				return null;
			}

			// If no tab is specified in recipe, this fallback organizes them instead
			if (recipe.getResultItem().getItem() instanceof DrinkableItem) {
				return COOKING_DRINKS.get();
			}
			return COOKING_MISC.get();
		});
	}
}

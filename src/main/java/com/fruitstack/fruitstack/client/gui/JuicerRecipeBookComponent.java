package com.fruitstack.fruitstack.client.gui;

import com.fruitstack.fruitstack.common.crafting.JuicerRecipe;
import com.fruitstack.fruitstack.common.utility.TextUtils;
import com.fruitstack.fruitstack.fruitstack;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;

import javax.annotation.Nonnull;
import java.util.List;

public class JuicerRecipeBookComponent extends RecipeBookComponent
{
	protected static final ResourceLocation RECIPE_BOOK_BUTTONS = new ResourceLocation(fruitstack.MODID, "textures/gui/recipe_book_buttons.png");

	@Override
	protected void initFilterButtonTextures() {
		this.filterButton.initTextureValues(0, 0, 28, 18, RECIPE_BOOK_BUTTONS);
	}

	public void hide() {
		this.setVisible(false);
	}

	@Override
	@Nonnull
	protected Component getRecipeFilterName() {
		return TextUtils.getTranslation("container.recipe_book.cookable");
	}

	@Override
	public void setupGhostRecipe(Recipe<?> recipe, List<Slot> slots) {
		ItemStack resultStack = recipe.getResultItem();
		this.ghostRecipe.setRecipe(recipe);
		if (slots.get(8).getItem().isEmpty()) {
			this.ghostRecipe.addIngredient(Ingredient.of(resultStack), (slots.get(8)).x, (slots.get(8)).y);
		}

		if (recipe instanceof JuicerRecipe cookingRecipe) {
			ItemStack containerStack = cookingRecipe.getOutputContainer();
			if (!containerStack.isEmpty()) {
				this.ghostRecipe.addIngredient(Ingredient.of(containerStack), (slots.get(9)).x, (slots.get(9)).y);
			}
		}

		this.placeRecipe(this.menu.getGridWidth(), this.menu.getGridHeight(), this.menu.getResultSlotIndex(), recipe, recipe.getIngredients().iterator(), 0);
	}
}

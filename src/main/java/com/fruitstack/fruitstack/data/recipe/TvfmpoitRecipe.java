package com.fruitstack.fruitstack.data.recipe;

import com.fruitstack.fruitstack.common.registry.ModItems;
import com.fruitstack.fruitstack.data.builder.TvfmpoitRecipeBuilder;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class TvfmpoitRecipe
{
	public static final int FAST_COOKING = 100;      // 5 seconds
	public static final int NORMAL_COOKING = 200;    // 10 seconds
	public static final int SLOW_COOKING = 400;      // 20 seconds

	public static final float SMALL_EXP = 0.35F;
	public static final float MEDIUM_EXP = 1.0F;
	public static final float LARGE_EXP = 2.0F;

	public static void register(Consumer<FinishedRecipe> consumer) {
		cookMiscellaneous(consumer);
		cookMinecraftSoups(consumer);
		cookMeals(consumer);
	}

	private static void cookMiscellaneous(Consumer<FinishedRecipe> consumer) {
		TvfmpoitRecipeBuilder.tripodVesselForMakingPillsOfImmortalityRecipe(ModItems.BLUEBERRIES_RICE_DUMPLING_BLOCK.get(), 1, NORMAL_COOKING, MEDIUM_EXP)
				.addIngredient(Items.EGG)
				.unlockedByAnyIngredient(Items.EGG)
				.build(consumer);
	}

	private static void cookMinecraftSoups(Consumer<FinishedRecipe> consumer) {
	}

	private static void cookMeals(Consumer<FinishedRecipe> consumer) {
	}
}

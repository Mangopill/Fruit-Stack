package com.fruitstack.fruitstack.data.builder;


import com.fruitstack.fruitstack.common.registry.ModRecipeSerializers;
import com.fruitstack.fruitstack.fruitstack;
import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.function.Consumer;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class JuicerRecipeBuilder
{
	private final List<Ingredient> ingredients = Lists.newArrayList();
	private final Item result;
	private final int count;
	private final int cookingTime;
	private final float experience;
	private final Item container;
	private final Advancement.Builder advancement = Advancement.Builder.advancement();

	private JuicerRecipeBuilder(ItemLike resultIn, int count, int cookingTime, float experience, @Nullable ItemLike container) {
		this.result = resultIn.asItem();
		this.count = count;
		this.cookingTime = cookingTime;
		this.experience = experience;
		this.container = container != null ? container.asItem() : null;
	}

	public static JuicerRecipeBuilder tripodVesselForMakingPillsOfImmortalityRecipe(ItemLike mainResult, int count, int cookingTime, float experience) {
		return new JuicerRecipeBuilder(mainResult, count, cookingTime, experience, null);
	}

	public static JuicerRecipeBuilder tripodVesselForMakingPillsOfImmortalityRecipe(ItemLike mainResult, int count, int cookingTime, float experience, ItemLike container) {
		return new JuicerRecipeBuilder(mainResult, count, cookingTime, experience, container);
	}

	public JuicerRecipeBuilder addIngredient(TagKey<Item> tagIn) {
		return addIngredient(Ingredient.of(tagIn));
	}

	public JuicerRecipeBuilder addIngredient(ItemLike itemIn) {
		return addIngredient(itemIn, 1);
	}

	public JuicerRecipeBuilder addIngredient(ItemLike itemIn, int quantity) {
		for (int i = 0; i < quantity; ++i) {
			addIngredient(Ingredient.of(itemIn));
		}
		return this;
	}

	public JuicerRecipeBuilder addIngredient(Ingredient ingredientIn) {
		return addIngredient(ingredientIn, 1);
	}

	public JuicerRecipeBuilder addIngredient(Ingredient ingredientIn, int quantity) {
		for (int i = 0; i < quantity; ++i) {
			ingredients.add(ingredientIn);
		}
		return this;
	}

	public JuicerRecipeBuilder unlockedBy(String criterionName, CriterionTriggerInstance criterionTrigger) {
		advancement.addCriterion(criterionName, criterionTrigger);
		return this;
	}

	public JuicerRecipeBuilder unlockedByItems(String criterionName, ItemLike... items) {
		return unlockedBy(criterionName, InventoryChangeTrigger.TriggerInstance.hasItems(items));
	}

	public JuicerRecipeBuilder unlockedByAnyIngredient(ItemLike... items) {
		advancement.addCriterion("has_any_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items).build()));
		return this;
	}


	public void build(Consumer<FinishedRecipe> consumerIn) {
		ResourceLocation location = ForgeRegistries.ITEMS.getKey(result);
		build(consumerIn, fruitstack.MODID + ":juicer/" + location.getPath());
	}

	public void build(Consumer<FinishedRecipe> consumerIn, String save) {
		ResourceLocation resourcelocation = ForgeRegistries.ITEMS.getKey(result);
		if ((new ResourceLocation(save)).equals(resourcelocation)) {
			throw new IllegalStateException("Juicer Recipe " + save + " should remove its 'save' argument");
		} else {
			build(consumerIn, new ResourceLocation(save));
		}
	}

	public void build(Consumer<FinishedRecipe> consumerIn, ResourceLocation id) {
		if (!advancement.getCriteria().isEmpty()) {
			advancement.parent(new ResourceLocation("recipes/root")).addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id))
					.rewards(AdvancementRewards.Builder.recipe(id))
					.requirements(RequirementsStrategy.OR);
			ResourceLocation advancementId = new ResourceLocation(id.getNamespace(), "recipes/" + id.getPath());
			consumerIn.accept(new JuicerRecipeBuilder.Result(id, result, count, ingredients, cookingTime, experience, container,  advancement, advancementId));
		} else {
			consumerIn.accept(new JuicerRecipeBuilder.Result(id, result, count, ingredients, cookingTime, experience, container));
		}
	}

	public static class Result implements FinishedRecipe
	{
		private final ResourceLocation id;
		private final List<Ingredient> ingredients;
		private final Item result;
		private final int count;
		private final int cookingTime;
		private final float experience;
		private final Item container;
		private final Advancement.Builder advancement;
		private final ResourceLocation advancementId;

		public Result(ResourceLocation idIn, Item resultIn, int countIn, List<Ingredient> ingredientsIn, int cookingTimeIn, float experienceIn, @Nullable Item containerIn,  @Nullable Advancement.Builder advancement, @Nullable ResourceLocation advancementId) {
			this.id = idIn;
			this.ingredients = ingredientsIn;
			this.result = resultIn;
			this.count = countIn;
			this.cookingTime = cookingTimeIn;
			this.experience = experienceIn;
			this.container = containerIn;
			this.advancement = advancement;
			this.advancementId = advancementId;
		}

		public Result(ResourceLocation idIn, Item resultIn, int countIn, List<Ingredient> ingredientsIn, int cookingTimeIn, float experienceIn, @Nullable Item containerIn) {
			this(idIn, resultIn, countIn, ingredientsIn, cookingTimeIn, experienceIn, containerIn, null, null);
		}

		@Override
		public void serializeRecipeData(JsonObject json) {

			JsonArray arrayIngredients = new JsonArray();

			for (Ingredient ingredient : ingredients) {
				arrayIngredients.add(ingredient.toJson());
			}
			json.add("ingredients", arrayIngredients);

			JsonObject objectResult = new JsonObject();
			objectResult.addProperty("item", ForgeRegistries.ITEMS.getKey(result).toString());
			if (count > 1) {
				objectResult.addProperty("count", count);
			}
			json.add("result", objectResult);

			if (container != null) {
				JsonObject objectContainer = new JsonObject();
				objectContainer.addProperty("item", ForgeRegistries.ITEMS.getKey(container).toString());
				json.add("container", objectContainer);
			}
			if (experience > 0) {
				json.addProperty("experience", experience);
			}
			json.addProperty("cookingtime", cookingTime);
		}

		@Override
		public ResourceLocation getId() {
			return id;
		}

		@Override
		public RecipeSerializer<?> getType() {
			return ModRecipeSerializers.JUICER.get();
		}

		@Nullable
		@Override
		public JsonObject serializeAdvancement() {
			return advancement != null ? advancement.serializeToJson() : null;
		}

		@Nullable
		@Override
		public ResourceLocation getAdvancementId() {
			return advancementId;
		}
	}
}

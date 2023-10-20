package com.fruitstack.fruitstack.common.crafting;

import com.fruitstack.fruitstack.common.block.entity.TvfmpoitBlockEntity;
import com.fruitstack.fruitstack.common.registry.ModItems;
import com.fruitstack.fruitstack.common.registry.ModRecipeSerializers;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;


public class FoodServingRecipe extends CustomRecipe
{
	public FoodServingRecipe(ResourceLocation id) {
		super(id);
	}

	@Override
	public boolean matches(CraftingContainer container, Level level) {
		ItemStack tripodVesselForMakingPillsOfImmortalityStack = ItemStack.EMPTY;
		ItemStack containerStack = ItemStack.EMPTY;
		ItemStack secondStack = ItemStack.EMPTY;

		for (int index = 0; index < container.getContainerSize(); ++index) {
			ItemStack selectedStack = container.getItem(index);
			if (!selectedStack.isEmpty()) {
				if (tripodVesselForMakingPillsOfImmortalityStack.isEmpty()) {
					ItemStack mealStack = TvfmpoitBlockEntity.getMealFromItem(selectedStack);
					if (!mealStack.isEmpty()) {
						tripodVesselForMakingPillsOfImmortalityStack = selectedStack;
						containerStack = TvfmpoitBlockEntity.getContainerFromItem(selectedStack);
						continue;
					}
				}
				if (secondStack.isEmpty()) {
					secondStack = selectedStack;
				} else {
					return false;
				}
			}
		}

		return !tripodVesselForMakingPillsOfImmortalityStack.isEmpty() && !secondStack.isEmpty() && secondStack.is(containerStack.getItem());
	}

	@Override
	public ItemStack assemble(CraftingContainer container) {
		for (int i = 0; i < container.getContainerSize(); ++i) {
			ItemStack selectedStack = container.getItem(i);
			if (!selectedStack.isEmpty() && selectedStack.is(ModItems.TRIPOD_VESSEL_FOR_MAKING_PILLS_OF_IMMORTALITY.get())) {
				ItemStack resultStack = TvfmpoitBlockEntity.getMealFromItem(selectedStack).copy();
				resultStack.setCount(1);
				return resultStack;
			}
		}

		return ItemStack.EMPTY;
	}

	@Override
	public NonNullList<ItemStack> getRemainingItems(CraftingContainer container) {
		NonNullList<ItemStack> remainders = NonNullList.withSize(container.getContainerSize(), ItemStack.EMPTY);

		for (int i = 0; i < remainders.size(); ++i) {
			ItemStack selectedStack = container.getItem(i);
			if (selectedStack.hasContainerItem()) {
				remainders.set(i, selectedStack.getContainerItem());
			} else if (selectedStack.is(ModItems.TRIPOD_VESSEL_FOR_MAKING_PILLS_OF_IMMORTALITY.get())) {
				TvfmpoitBlockEntity.takeServingFromItem(selectedStack);
				ItemStack newTripodVesselForMakingPillsOfImmortalityStack = selectedStack.copy();
				newTripodVesselForMakingPillsOfImmortalityStack.setCount(1);
				remainders.set(i, newTripodVesselForMakingPillsOfImmortalityStack);
				break;
			}
		}

		return remainders;
	}

	@Override
	public boolean canCraftInDimensions(int width, int height) {
		return width >= 2 && height >= 2;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return ModRecipeSerializers.FOOD_SERVING.get();
	}
}

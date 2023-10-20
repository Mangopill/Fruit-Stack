package com.fruitstack.fruitstack.common.block.entity.container;


import com.fruitstack.fruitstack.common.block.entity.TvfmpoitBlockEntity;
import com.fruitstack.fruitstack.common.registry.ModBlocks;
import com.fruitstack.fruitstack.common.registry.ModMenuTypes;
import com.fruitstack.fruitstack.fruitstack;
import com.mojang.datafixers.util.Pair;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.RecipeWrapper;

import java.util.Objects;

public class TvfmpoitBlockMenu extends RecipeBookMenu<RecipeWrapper>
{
	public final TvfmpoitBlockEntity tileEntity;
	public final ItemStackHandler inventory;
	private final ContainerData tripodVesselForMakingPillsOfImmortalityData;
	private final ContainerLevelAccess canInteractWithCallable;
	protected final Level level;

	public TvfmpoitBlockMenu(final int windowId, final Inventory playerInventory, final TvfmpoitBlockEntity tileEntity, ContainerData tripodVesselForMakingPillsOfImmortalityDataIn) {
		super(ModMenuTypes.TRIPOD_VESSEL_FOR_MAKING_PILLS_OF_IMMORTALITY.get(), windowId);
		this.tileEntity = tileEntity;
		this.inventory = tileEntity.getInventory();
		this.tripodVesselForMakingPillsOfImmortalityData = tripodVesselForMakingPillsOfImmortalityDataIn;
		this.level = playerInventory.player.level;
		this.canInteractWithCallable = ContainerLevelAccess.create(tileEntity.getLevel(), tileEntity.getBlockPos());

		int startX = 8;
		int startY = 18;
		int inputStartX = 12;
		int inputStartY = 17;
		int borderSlotSize = 18;
		for (int row = 0; row < 2; ++row) {
			for (int column = 0; column < 4; ++column) {
				this.addSlot(new SlotItemHandler(inventory, (row * 4) + column,
						inputStartX + (column * borderSlotSize),
						inputStartY + (row * borderSlotSize)));
			}
		}

		// Meal Display
		this.addSlot(new TvfmpoitMealSlot(inventory, 8, 124, 26));

		// Bowl Input
		this.addSlot(new SlotItemHandler(inventory, 9, 92, 55));

		// Bowl Output
		this.addSlot(new TvfmpoitBlockResultSlot(playerInventory.player, tileEntity, inventory, 10, 124, 55));

		// Main Player Inventory
		int startPlayerInvY = startY * 4 + 12;
		for (int row = 0; row < 3; ++row) {
			for (int column = 0; column < 9; ++column) {
				this.addSlot(new Slot(playerInventory, 9 + (row * 9) + column, startX + (column * borderSlotSize),
						startPlayerInvY + (row * borderSlotSize)));
			}
		}

		// Hotbar
		for (int column = 0; column < 9; ++column) {
			this.addSlot(new Slot(playerInventory, column, startX + (column * borderSlotSize), 142));
		}

		this.addDataSlots(tripodVesselForMakingPillsOfImmortalityDataIn);
	}

	private static TvfmpoitBlockEntity getTileEntity(final Inventory playerInventory, final FriendlyByteBuf data) {
		Objects.requireNonNull(playerInventory, "playerInventory cannot be null");
		Objects.requireNonNull(data, "data cannot be null");
		final BlockEntity tileAtPos = playerInventory.player.level.getBlockEntity(data.readBlockPos());
		if (tileAtPos instanceof TvfmpoitBlockEntity) {
			return (TvfmpoitBlockEntity) tileAtPos;
		}
		throw new IllegalStateException("Tile entity is not correct! " + tileAtPos);
	}

	public TvfmpoitBlockMenu(final int windowId, final Inventory playerInventory, final FriendlyByteBuf data) {
		this(windowId, playerInventory, getTileEntity(playerInventory, data), new SimpleContainerData(4));
	}

	@Override
	public boolean stillValid(Player playerIn) {
		return stillValid(canInteractWithCallable, playerIn, ModBlocks.TRIPOD_VESSEL_FOR_MAKING_PILLS_OF_IMMORTALITY.get());
	}

	@Override
	public ItemStack quickMoveStack(Player playerIn, int index) {
		int indexMealDisplay = 8;
		int indexContainerInput = 9;
		int indexOutput = 10;
		int startPlayerInv = indexOutput + 1;
		int endPlayerInv = startPlayerInv + 36;
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.slots.get(index);
		if (slot.hasItem()) {
			ItemStack itemstack1 = slot.getItem();
			itemstack = itemstack1.copy();
			if (index == indexOutput) {
				if (!this.moveItemStackTo(itemstack1, startPlayerInv, endPlayerInv, true)) {
					return ItemStack.EMPTY;
				}
			} else if (index > indexOutput) {
				if (itemstack1.getItem() == Items.BOWL && !this.moveItemStackTo(itemstack1, indexContainerInput, indexContainerInput + 1, false)) {
					return ItemStack.EMPTY;
				} else if (!this.moveItemStackTo(itemstack1, 0, indexMealDisplay, false)) {
					return ItemStack.EMPTY;
				} else if (!this.moveItemStackTo(itemstack1, indexContainerInput, indexOutput, false)) {
					return ItemStack.EMPTY;
				}
			} else if (!this.moveItemStackTo(itemstack1, startPlayerInv, endPlayerInv, false)) {
				return ItemStack.EMPTY;
			}

			if (itemstack1.isEmpty()) {
				slot.set(ItemStack.EMPTY);
			} else {
				slot.setChanged();
			}

			if (itemstack1.getCount() == itemstack.getCount()) {
				return ItemStack.EMPTY;
			}

			slot.onTake(playerIn, itemstack1);
		}
		return itemstack;
	}

	@OnlyIn(Dist.CLIENT)
	public int getCookProgressionScaled() {
		int i = this.tripodVesselForMakingPillsOfImmortalityData.get(0);
		int j = this.tripodVesselForMakingPillsOfImmortalityData.get(1);
		return j != 0 && i != 0 ? i * 24 / j : 0;
	}

	@OnlyIn(Dist.CLIENT)
	public boolean isHeated() {
		return tileEntity.isHeated();
	}

	@Override
	public void fillCraftSlotsStackedContents(StackedContents helper) {
		for (int i = 0; i < inventory.getSlots(); i++) {
			helper.accountSimpleStack(inventory.getStackInSlot(i));
		}
	}

	@Override
	public void clearCraftingContent() {
		for (int i = 0; i < 8; i++) {
			this.inventory.setStackInSlot(i, ItemStack.EMPTY);
		}
	}

	@Override
	public boolean recipeMatches(Recipe<? super RecipeWrapper> recipe) {
		return recipe.matches(new RecipeWrapper(inventory), level);
	}

	@Override
	public int getResultSlotIndex() {
		return 9;
	}

	@Override
	public int getGridWidth() {
		return 4;
	}

	@Override
	public int getGridHeight() {
		return 2;
	}

	@Override
	public int getSize() {
		return 9;
	}

	@Override
	public RecipeBookType getRecipeBookType() {
		return fruitstack.RECIPE_TYPE_COOKING;
	}

	@Override
	public boolean shouldMoveToInventory(int slot) {
		return slot < (getGridWidth() * getGridHeight());
	}
}

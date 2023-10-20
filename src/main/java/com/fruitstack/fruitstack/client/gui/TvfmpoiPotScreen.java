package com.fruitstack.fruitstack.client.gui;

import com.fruitstack.fruitstack.common.block.entity.container.TvfmpoitBlockMenu;
import com.fruitstack.fruitstack.common.utility.TextUtils;
import com.fruitstack.fruitstack.fruitstack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.client.gui.screens.recipebook.RecipeUpdateListener;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@ParametersAreNonnullByDefault
public class TvfmpoiPotScreen extends AbstractContainerScreen<TvfmpoitBlockMenu> implements RecipeUpdateListener
{
	private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(fruitstack.MODID, "textures/gui/tripod_vessel_for_making_pills_of_immortality.png");
	private static final Rectangle HEAT_ICON = new Rectangle(37, 55, 17, 15);
	private static final Rectangle PROGRESS_ARROW = new Rectangle(89, 25, 0, 17);

	private final TvfmpoiRecipeBookComponent recipeBookComponent = new TvfmpoiRecipeBookComponent();
	private boolean widthTooNarrow;

	public TvfmpoiPotScreen(TvfmpoitBlockMenu screenContainer, Inventory inv, Component titleIn) {
		super(screenContainer, inv, titleIn);
	}

	@Override
	public void init() {
		super.init();
		this.widthTooNarrow = this.width < 379;
		this.titleLabelX = 28;
		this.recipeBookComponent.init(this.width, this.height, this.minecraft, this.widthTooNarrow, this.menu);
		this.leftPos = this.recipeBookComponent.updateScreenPosition(this.width, this.imageWidth);
	}

	@Override
	protected void containerTick() {
		super.containerTick();
		this.recipeBookComponent.tick();
	}

	@Override
	public void render(GuiGraphics gui, final int mouseX, final int mouseY, float partialTicks) {
		this.renderBackground(gui);

		if (this.recipeBookComponent.isVisible() && this.widthTooNarrow) {
			this.renderBg(gui, partialTicks, mouseX, mouseY);
			this.recipeBookComponent.render(gui, mouseX, mouseY, partialTicks);
		} else {
			this.recipeBookComponent.render(gui, mouseX, mouseY, partialTicks);
			super.render(gui, mouseX, mouseY, partialTicks);
			this.recipeBookComponent.renderGhostRecipe(gui, this.leftPos, this.topPos, false, partialTicks);
		}

		this.renderMealDisplayTooltip(gui, mouseX, mouseY);
		this.renderHeatIndicatorTooltip(gui, mouseX, mouseY);
		this.recipeBookComponent.renderTooltip(gui, this.leftPos, this.topPos, mouseX, mouseY);
	}

	private void renderHeatIndicatorTooltip(GuiGraphics gui, int mouseX, int mouseY) {
		if (this.isHovering(HEAT_ICON.x, HEAT_ICON.y, HEAT_ICON.width, HEAT_ICON.height, mouseX, mouseY)) {
			String key = "container.tripod_vessel_for_making_pills_of_immortality." + (this.menu.isHeated() ? "heated" : "not_heated");
			gui.renderTooltip(this.font, TextUtils.getTranslation(key, menu), mouseX, mouseY);
		}
	}

	protected void renderMealDisplayTooltip(GuiGraphics gui, int mouseX, int mouseY) {
		if (this.minecraft != null && this.minecraft.player != null && this.menu.getCarried().isEmpty() && this.hoveredSlot != null && this.hoveredSlot.hasItem()) {
			if (this.hoveredSlot.index == 8) {
				List<Component> tooltip = new ArrayList<>();

				ItemStack mealStack = this.hoveredSlot.getItem();
				tooltip.add(((MutableComponent) mealStack.getItem().getDescription()).withStyle(mealStack.getRarity().color));

				ItemStack containerStack = this.menu.tileEntity.getContainer();
				String container = !containerStack.isEmpty() ? containerStack.getItem().getDescription().getString() : "";

				tooltip.add(TextUtils.getTranslation("container.tripod_vessel_for_making_pills_of_immortality.served_on", container).withStyle(ChatFormatting.GRAY));

				gui.renderComponentTooltip(font, tooltip, mouseX, mouseY);
			} else {
				gui.renderTooltip(font, this.hoveredSlot.getItem(), mouseX, mouseY);
			}
		}
	}

	@Override
	protected void renderLabels(GuiGraphics gui, int mouseX, int mouseY) {
		super.renderLabels(gui, mouseX, mouseY);
		gui.drawString(this.font, this.playerInventoryTitle, 8, (this.imageHeight - 96 + 2), 4210752, false);
	}

	@Override
	protected void renderBg(GuiGraphics gui, float partialTicks, int mouseX, int mouseY) {
		// Render UI background
		RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
		if (this.minecraft == null)
			return;

		RenderSystem.setShaderTexture(0, BACKGROUND_TEXTURE);
		gui.blit(BACKGROUND_TEXTURE, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);

		// Render heat icon
		if (this.menu.isHeated()) {
			gui.blit(BACKGROUND_TEXTURE, this.leftPos + HEAT_ICON.x, this.topPos + HEAT_ICON.y, 176, 0, HEAT_ICON.width, HEAT_ICON.height);
		}

		// Render progress arrow
		int l = this.menu.getCookProgressionScaled();
		gui.blit(BACKGROUND_TEXTURE, this.leftPos + PROGRESS_ARROW.x, this.topPos + PROGRESS_ARROW.y, 176, 15, l + 1, PROGRESS_ARROW.height);
	}

	@Override
	protected boolean isHovering(int x, int y, int width, int height, double mouseX, double mouseY) {
		return (!this.widthTooNarrow || !this.recipeBookComponent.isVisible()) && super.isHovering(x, y, width, height, mouseX, mouseY);
	}

	@Override
	public boolean mouseClicked(double mouseX, double mouseY, int buttonId) {
		if (this.recipeBookComponent.mouseClicked(mouseX, mouseY, buttonId)) {
			this.setFocused(this.recipeBookComponent);
			return true;
		}
		return this.widthTooNarrow && this.recipeBookComponent.isVisible() || super.mouseClicked(mouseX, mouseY, buttonId);
	}

	@Override
	protected boolean hasClickedOutside(double mouseX, double mouseY, int x, int y, int buttonIdx) {
		boolean flag = mouseX < (double) x || mouseY < (double) y || mouseX >= (double) (x + this.imageWidth) || mouseY >= (double) (y + this.imageHeight);
		return flag && this.recipeBookComponent.hasClickedOutside(mouseX, mouseY, this.leftPos, this.topPos, this.imageWidth, this.imageHeight, buttonIdx);
	}

	@Override
	protected void slotClicked(Slot slot, int mouseX, int mouseY, ClickType clickType) {
		super.slotClicked(slot, mouseX, mouseY, clickType);
		this.recipeBookComponent.slotClicked(slot);
	}

	@Override
	public void recipesUpdated() {
		this.recipeBookComponent.recipesUpdated();
	}

//	@Override
//	public void removed() {
//		this.recipeBookComponent.removed();
//		super.removed();
//	}

	@Override
	@Nonnull
	public RecipeBookComponent getRecipeBookComponent() {
		return this.recipeBookComponent;
	}
}

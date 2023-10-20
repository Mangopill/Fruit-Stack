package com.fruitstack.fruitstack.client.renderer;

import com.fruitstack.fruitstack.common.block.ClayOvenBlock;
import com.fruitstack.fruitstack.common.block.entity.ClayOvenBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec2;
import net.minecraftforge.items.ItemStackHandler;

public class ClayOvenRenderer implements BlockEntityRenderer<ClayOvenBlockEntity> {
	public ClayOvenRenderer(BlockEntityRendererProvider.Context context) {
	}

	@Override
	public void render(ClayOvenBlockEntity ClayOvenEntity, float partialTicks, PoseStack poseStack, MultiBufferSource buffer,
			int combinedLightIn, int combinedOverlayIn) {
		Direction direction = ClayOvenEntity.getBlockState().getValue(ClayOvenBlock.FACING).getOpposite();

		ItemStackHandler inventory = ClayOvenEntity.getInventory();
		int posLong = (int) ClayOvenEntity.getBlockPos().asLong();

		for (int i = 0; i < inventory.getSlots(); ++i) {
			ItemStack ClayOvenStack = inventory.getStackInSlot(i);
			if (!ClayOvenStack.isEmpty()) {
				poseStack.pushPose();

				// Center item above the ClayOven
				poseStack.translate(0.5D, 1.02D, 0.5D);

				// Rotate item to face the ClayOven's front side
				float f = -direction.toYRot();
				poseStack.mulPose(Axis.YP.rotationDegrees(f));

				// Rotate item flat on the ClayOven. Use X and Y from now on
				poseStack.mulPose(Axis.XP.rotationDegrees(90.0F));

				// Neatly align items according to their index
				Vec2 itemOffset = ClayOvenEntity.getCalyOvenItemOffset(i);
				poseStack.translate(itemOffset.x, itemOffset.y, 0.0D);

				// Resize the items
				poseStack.scale(0.375F, 0.375F, 0.375F);

				if (ClayOvenEntity.getLevel() != null)
					Minecraft.getInstance().getItemRenderer().renderStatic(ClayOvenStack, ItemDisplayContext.FIXED, LevelRenderer.getLightColor(ClayOvenEntity.getLevel(), ClayOvenEntity.getBlockPos().above()), combinedOverlayIn, poseStack, buffer, ClayOvenEntity.getLevel(), posLong + i);
				poseStack.popPose();
			}
		}
	}
}
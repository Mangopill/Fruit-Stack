package com.fruitstack.fruitstack.client.renderer;

import com.fruitstack.fruitstack.common.block.PlateBlock;
import com.fruitstack.fruitstack.common.block.entity.PlateBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.items.ItemStackHandler;

public class PlateRenderer implements BlockEntityRenderer<PlateBlockEntity> {
	public PlateRenderer(BlockEntityRendererProvider.Context context) {
	}

	@Override
	public void render(PlateBlockEntity PlateBlockEntity, float partialTicks, PoseStack poseStack, MultiBufferSource buffer,
					   int combinedLightIn, int combinedOverlayIn) {
		Direction direction = PlateBlockEntity.getBlockState().getValue(PlateBlock.FACING).getOpposite();

		ItemStackHandler inventory = PlateBlockEntity.getInventory();
		int posLong = (int) PlateBlockEntity.getBlockPos().asLong();

		for (int i = 0; i < inventory.getSlots(); ++i) {
			ItemStack plateStack = inventory.getStackInSlot(i);
			if (!plateStack.isEmpty()) {
				poseStack.pushPose();

				// Center item above the Plate
				poseStack.translate(0.5D, 0.135D, 0.5D);

				// Rotate item to face the Plate's front side
				float f = -direction.toYRot();
				poseStack.mulPose(Axis.YP.rotationDegrees(f));

				// Rotate item flat on the Plate. Use X and Y from now on
				poseStack.mulPose(Axis.XP.rotationDegrees(90.0F));

				// Neatly align items according to their index
				Vec3 itemOffset = PlateBlockEntity.getPlateItemOffset(i);
				poseStack.translate(itemOffset.x, itemOffset.y, itemOffset.z);

				// Resize the items
				poseStack.scale(0.375F, 0.375F, 0.375F);

				if (PlateBlockEntity.getLevel() != null)
					Minecraft.getInstance().getItemRenderer().renderStatic(plateStack, ItemDisplayContext.FIXED, LevelRenderer.getLightColor(PlateBlockEntity.getLevel(), PlateBlockEntity.getBlockPos().above()), combinedOverlayIn, poseStack, buffer, PlateBlockEntity.getLevel(), posLong + i);
				poseStack.popPose();
			}
		}
	}
}
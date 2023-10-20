package com.fruitstack.fruitstack.client.renderer;

import com.fruitstack.fruitstack.common.block.BowlBlock;
import com.fruitstack.fruitstack.common.block.entity.BowlBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.items.ItemStackHandler;

public class BowlBlockRenderer implements BlockEntityRenderer<BowlBlockEntity> {
	public BowlBlockRenderer(BlockEntityRendererProvider.Context context) {
	}

	@Override
	public void render(BowlBlockEntity BowlBlockEntity, float partialTicks, PoseStack poseStack, MultiBufferSource buffer,
					   int combinedLightIn, int combinedOverlayIn) {
		Direction direction = BowlBlockEntity.getBlockState().getValue(BowlBlock.FACING).getOpposite();

		ItemStackHandler inventory = BowlBlockEntity.getInventory();
		int posLong = (int) BowlBlockEntity.getBlockPos().asLong();

		for (int i = 0; i < inventory.getSlots(); ++i) {
			ItemStack bowlStack = inventory.getStackInSlot(i);
			if (!bowlStack.isEmpty()) {
				poseStack.pushPose();

				// Center item above the ClayOven
				poseStack.translate(0.5D, 0.130D, 0.5D);

				// Rotate item to face the ClayOven's front side
				float f = -direction.toYRot();
				poseStack.mulPose(Vector3f.YP.rotationDegrees(f));

				// Rotate item flat on the ClayOven. Use X and Y from now on
				poseStack.mulPose(Vector3f.XP.rotationDegrees(90.0F));

				// Neatly align items according to their index
				Vec3 itemOffset = BowlBlockEntity.getBowlItemOffset(i);
				poseStack.translate(itemOffset.x, itemOffset.y, itemOffset.z);

				// Resize the items
				poseStack.scale(0.2F, 0.2F, 0.2F);

				if (BowlBlockEntity.getLevel() != null)
					Minecraft.getInstance().getItemRenderer().renderStatic(bowlStack, ItemTransforms.TransformType.FIXED, LevelRenderer.getLightColor(BowlBlockEntity.getLevel(), BowlBlockEntity.getBlockPos().above()), combinedOverlayIn, poseStack, buffer, posLong + i);
				poseStack.popPose();
			}
		}
	}
}
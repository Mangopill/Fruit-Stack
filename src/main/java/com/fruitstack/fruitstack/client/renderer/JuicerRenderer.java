package com.fruitstack.fruitstack.client.renderer;

import com.fruitstack.fruitstack.common.block.JuicerBlock;
import com.fruitstack.fruitstack.common.block.entity.JuicerBlockEntity;
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
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.items.ItemStackHandler;

public class JuicerRenderer implements BlockEntityRenderer<JuicerBlockEntity> {
	public JuicerRenderer(BlockEntityRendererProvider.Context context) {
	}

	@Override
	public void render(JuicerBlockEntity JuicerBlockEntity, float partialTicks, PoseStack poseStack, MultiBufferSource buffer,
			int combinedLightIn, int combinedOverlayIn) {
		Direction direction = JuicerBlockEntity.getBlockState().getValue(JuicerBlock.FACING).getOpposite();

		ItemStackHandler inventory = JuicerBlockEntity.getInventory();
		int posLong = (int) JuicerBlockEntity.getBlockPos().asLong();

		for (int i = 0; i < inventory.getSlots(); ++i) {
			ItemStack ClayOvenStack = inventory.getStackInSlot(i);
			if (!ClayOvenStack.isEmpty()) {
				poseStack.pushPose();

				// Center item above the Juicer
				poseStack.translate(0.5D, 0.5D, 0.5D);

				// Rotate item to face the Juicer's front side
				float f = -direction.toYRot();
				poseStack.mulPose(Vector3f.YP.rotationDegrees(f));

				// Rotate item flat on the Juicer. Use X and Y from now on
				poseStack.mulPose(Vector3f.XP.rotationDegrees(90.0F));

				// Neatly align items according to their index
				Vec3 itemOffset = JuicerBlockEntity.getJuicerItemOffset(i);
				poseStack.translate(itemOffset.x, itemOffset.y, itemOffset.z);

				// Resize the items
				poseStack.scale(0.375F, 0.375F, 0.375F);

				if (JuicerBlockEntity.getLevel() != null)
					Minecraft.getInstance().getItemRenderer().renderStatic(ClayOvenStack,
							ItemTransforms.TransformType.FIXED,
							LevelRenderer.getLightColor(JuicerBlockEntity.getLevel(), JuicerBlockEntity.getBlockPos().above()),
							combinedOverlayIn, poseStack, buffer, posLong + i);
				poseStack.popPose();
			}
		}
	}
}
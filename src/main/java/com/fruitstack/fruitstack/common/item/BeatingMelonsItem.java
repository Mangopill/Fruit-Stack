package com.fruitstack.fruitstack.common.item;

import com.fruitstack.fruitstack.common.entity.RawMoonCakeEntity;
import com.fruitstack.fruitstack.common.registry.ModItems;
import com.fruitstack.fruitstack.common.registry.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

public class BeatingMelonsItem extends Item {
	public BeatingMelonsItem(Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		BlockPos clickedPos = context.getClickedPos();
		BlockState clickedBlockState = context.getLevel().getBlockState(clickedPos);
		Player player = context.getPlayer();

		if (clickedBlockState.getMaterial() == Material.STONE || clickedBlockState.getMaterial() == Material.WOOD) {
			ItemStack heldStack = context.getItemInHand();
			heldStack.shrink(1);
			player.getInventory().add(new ItemStack(ModItems.BEATING_MELONS_SLICE.get(), 2));
			player.getInventory().add(new ItemStack(ModItems.BEATING_MELONS_SEEDS.get(), 1));
			context.getLevel().playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.BEATING_MELONS.get(), SoundSource.BLOCKS, 0.5F, 1.0F);

			return InteractionResult.SUCCESS;
		}

		return InteractionResult.PASS;
	}
}
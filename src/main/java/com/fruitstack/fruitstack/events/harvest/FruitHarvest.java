package com.fruitstack.fruitstack.events.harvest;

import com.fruitstack.fruitstack.common.block.BlockFruitCrop;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.List;

public class FruitHarvest {

	/*private static final Method seedDrops;

	static {
		seedDrops = ObfuscationReflectionHelper.findMethod(CropBlock.class, "func_199772_f");
	}

	private Item getCropSeed(Block block) {
		try {
			return (Item) seedDrops.invoke(block);
		}

		catch (Exception e) {
			Pamhc2trees.LOGGER.error("Where the heck is the seed", e);
		}

		return null;
	}*/

	@SubscribeEvent
	public void onCropHarvest(RightClickBlock event) {
		if (event.getEntity().getItemBySlot(EquipmentSlot.MAINHAND).getItem() != Items.BONE_MEAL) {

			BlockState state = event.getLevel().getBlockState(event.getPos());
			Block block = state.getBlock();

			if (block instanceof BlockFruitCrop) {
				if (!event.getEntity().getItemBySlot(EquipmentSlot.MAINHAND).isEmpty())
					event.setCanceled(true);

				// Really need to move isMaxAge to an interface or something.
				if (((BlockFruitCrop) block).isMaxAge(state)) {
					if (!event.getLevel().isClientSide()) {
						List<ItemStack> drops = Block.getDrops(event.getLevel().getBlockState(event.getPos()),
								(ServerLevel) event.getLevel(), event.getPos(),
								event.getLevel().getBlockEntity(event.getPos()));

						for(int i = 0; i < drops.size(); ++i) {
							event.getLevel().addFreshEntity(new ItemEntity(event.getLevel(), (double)event.getPos().getX(), (double)event.getPos().getY(), (double)event.getPos().getZ(), (ItemStack)drops.get(i)));
						}
					}

					event.getEntity().causeFoodExhaustion(0.05F);
					event.getLevel().playSound((Player) null, event.getPos(), SoundEvents.CROP_BREAK,
							SoundSource.BLOCKS, 1.0F, 0.8F + event.getLevel().random.nextFloat() * 0.4F);
					event.getLevel().setBlock(event.getPos(), block.defaultBlockState(), 2);
				}
				
				event.getEntity().swing(InteractionHand.MAIN_HAND);
			}
		}
	}
}



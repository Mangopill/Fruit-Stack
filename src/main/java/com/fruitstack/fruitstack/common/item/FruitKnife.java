package com.fruitstack.fruitstack.common.item;

import com.fruitstack.fruitstack.common.tag.ModTags;
import com.fruitstack.fruitstack.common.utility.ItemUtils;
import com.google.common.collect.Sets;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.living.LivingKnockBackEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import com.fruitstack.fruitstack.fruitstack;

import java.util.Set;

public class FruitKnife extends DiggerItem
{
	public FruitKnife(Tier tier, float attackDamage, float attackSpeed, Properties properties) {
		super(attackDamage, attackSpeed, tier, ModTags.FRUIT_BLOCK_CAN_MINE, properties);
	}

	@Override
	public boolean canAttackBlock(BlockState state, Level level, BlockPos pos, Player player) {
		return !player.isCreative();
	}

	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		stack.hurtAndBreak(1, attacker, (user) -> user.broadcastBreakEvent(EquipmentSlot.MAINHAND));
		return true;
	}

	@Mod.EventBusSubscriber(modid = fruitstack.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
	public static class KnifeEvents
	{
		@SubscribeEvent
		public static void onKnifeKnockback(LivingKnockBackEvent event) {
			LivingEntity attacker = event.getEntityLiving().getKillCredit();
			ItemStack toolStack = attacker != null ? attacker.getItemInHand(InteractionHand.MAIN_HAND) : ItemStack.EMPTY;
			if (toolStack.getItem() instanceof FruitKnife) {
				event.setStrength(event.getOriginalStrength() - 0.1F);
			}
		}
	}
	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack, net.minecraft.world.item.enchantment.Enchantment enchantment) {
		Set<Enchantment> ALLOWED_ENCHANTMENTS = Sets.newHashSet(Enchantments.SHARPNESS, Enchantments.SMITE, Enchantments.BANE_OF_ARTHROPODS, Enchantments.KNOCKBACK, Enchantments.FIRE_ASPECT, Enchantments.MOB_LOOTING);
		if (ALLOWED_ENCHANTMENTS.contains(enchantment)) {
			return true;
		}
		Set<Enchantment> DENIED_ENCHANTMENTS = Sets.newHashSet(Enchantments.BLOCK_FORTUNE);
		if (DENIED_ENCHANTMENTS.contains(enchantment)) {
			return false;
		}
		return enchantment.category.canEnchant(stack.getItem());
	}
}

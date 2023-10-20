package com.fruitstack.fruitstack.common.item;

import com.fruitstack.fruitstack.common.utility.TextUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BestWineItem extends ConsumableItem
{
	public BestWineItem(Properties properties) {
		super(properties);
	}

	public BestWineItem(Properties properties, boolean hasFoodEffectTooltip) {
		super(properties, hasFoodEffectTooltip);
	}

	public BestWineItem(Properties properties, boolean hasPotionEffectTooltip, boolean hasCustomTooltip) {
		super(properties, hasPotionEffectTooltip, hasCustomTooltip);
	}

	@Override
	public int getUseDuration(ItemStack stack) {
		return 32;
	}

	@Override
	public UseAnim getUseAnimation(ItemStack stack) {
		return UseAnim.DRINK;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		ItemStack heldStack = player.getItemInHand(hand);
		if (heldStack.isEdible()) {
			if (player.canEat(heldStack.getFoodProperties(player).canAlwaysEat())) {
				player.startUsingItem(hand);
				return InteractionResultHolder.consume(heldStack);
			} else {
				return InteractionResultHolder.fail(heldStack);
			}
		}
		return ItemUtils.startUsingInstantly(level, player, hand);
	}
	@Override
	public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity entity) {
		// 调用方法使药水效果持续时间变为无限
		makePotionEffectsInfinite(entity);

		// 继续原来的处理逻辑
		return super.finishUsingItem(stack, world, entity);
	}
	public void makePotionEffectsInfinite(LivingEntity player) {
		// 获取玩家当前的药水效果列表
		Collection<MobEffectInstance> effects = player.getActiveEffects();

		for (MobEffectInstance effect : effects) {
			player.addEffect(new MobEffectInstance(effect.getEffect(), Integer.MAX_VALUE, effect.getAmplifier(), effect.isAmbient(), effect.isVisible()));
		}
	}
	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag isAdvanced) {
		if (this.hasCustomTooltip) {
			MutableComponent textEmpty = TextUtils.getTranslation("tooltip." + this);
			tooltip.add(textEmpty.withStyle(ChatFormatting.GOLD));
		}
		if (this.hasFoodEffectTooltip) {
			TextUtils.addFoodEffectTooltip(stack, tooltip, 1.0F);
		}
	}
}

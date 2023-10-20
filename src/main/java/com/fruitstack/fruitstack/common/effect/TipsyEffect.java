package com.fruitstack.fruitstack.common.effect;


import com.mojang.blaze3d.shaders.Effect;
import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;

import java.io.IOException;
import java.util.UUID;

@SuppressWarnings("unused")
public class TipsyEffect extends MobEffect {
	private int tickCounter = 0;  // 计数器，用于跟踪时间

	public TipsyEffect() {
		super(MobEffectCategory.HARMFUL, 0xFFFFFF);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		try {
			tickCounter++;

			if (tickCounter >= 500) {
				tickCounter = 0;

				if (entity instanceof Player player) {
					player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 150));
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
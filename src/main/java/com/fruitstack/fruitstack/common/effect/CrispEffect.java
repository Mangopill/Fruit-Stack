package com.fruitstack.fruitstack.common.effect;

import net.minecraft.world.damagesource.DamageSource;
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
import net.minecraft.world.food.FoodData;
import net.minecraft.world.level.GameRules;

import java.util.UUID;

public class CrispEffect extends MobEffect {
	private final AttributeModifier damageModifier;
	private final AttributeModifier speedModifier;
	public CrispEffect() {
		super(MobEffectCategory.BENEFICIAL, 0);
		this.damageModifier = new AttributeModifier(UUID.randomUUID(), "additional_damage", 10.0, AttributeModifier.Operation.ADDITION);
		this.speedModifier = new AttributeModifier(UUID.randomUUID(), "custom_speed", 10, AttributeModifier.Operation.MULTIPLY_TOTAL);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		if (!entity.getCommandSenderWorld().isClientSide && entity instanceof Player player) {
			if (player.getHealth() > 10) {
				player.hurt(DamageSource.GENERIC, 2.0F);
				AttributeInstance damageAttribute = player.getAttribute(Attributes.ATTACK_DAMAGE);
				if (!damageAttribute.hasModifier(damageModifier)) {
					damageAttribute.addTransientModifier(damageModifier);
				}
				AttributeInstance speedAttribute = player.getAttribute(Attributes.MOVEMENT_SPEED);
				if (!speedAttribute.hasModifier(speedModifier)) {
					speedAttribute.addTransientModifier(speedModifier);
				}
			}
		}
	}
	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributes, int amplifier) {
		super.removeAttributeModifiers(entity, attributes, amplifier);
		AttributeInstance damageAttribute = entity.getAttribute(Attributes.ATTACK_DAMAGE);
		if (damageAttribute != null) {
			damageAttribute.removeModifier(damageModifier);
		}
		AttributeInstance speedAttribute = entity.getAttribute(Attributes.MOVEMENT_SPEED);
		if (speedAttribute != null) {
			speedAttribute.removeModifier(speedModifier);
		}
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
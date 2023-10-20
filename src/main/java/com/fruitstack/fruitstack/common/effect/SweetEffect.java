package com.fruitstack.fruitstack.common.effect;


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

import java.util.UUID;

@SuppressWarnings("unused")
public class SweetEffect extends MobEffect {
	private final AttributeModifier armorModifier;
	private final AttributeModifier speedModifier;

	public SweetEffect() {
		super(MobEffectCategory.BENEFICIAL, 0xFFA500);
		this.armorModifier = new AttributeModifier(UUID.randomUUID(), "custom_armor", 20.0, AttributeModifier.Operation.ADDITION);
		this.speedModifier = new AttributeModifier(UUID.randomUUID(), "custom_speed", -0.80, AttributeModifier.Operation.MULTIPLY_TOTAL);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		if (entity instanceof Player player) {
			AttributeInstance armorAttribute = player.getAttribute(Attributes.ARMOR);
			if (!armorAttribute.hasModifier(armorModifier)) {
				armorAttribute.addTransientModifier(armorModifier);
			}
		}
		if (entity instanceof Player player) {
			AttributeInstance speedAttribute = player.getAttribute(Attributes.MOVEMENT_SPEED);
			if (!speedAttribute.hasModifier(speedModifier)) {
				speedAttribute.addTransientModifier(speedModifier);
			}
		}
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributes, int amplifier) {
		super.removeAttributeModifiers(entity, attributes, amplifier);
		AttributeInstance armorAttribute = entity.getAttribute(Attributes.ARMOR);
		if (armorAttribute != null) {
			armorAttribute.removeModifier(armorModifier);
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
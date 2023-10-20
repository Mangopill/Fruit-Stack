package com.fruitstack.fruitstack.common.registry;

import com.fruitstack.fruitstack.fruitstack;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.level.Level;

public class ModDamageTypes
{
	public static final ResourceKey<DamageType> CLAYOVEN_BURN = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(fruitstack.MODID, "clayoven_burn"));
	public static final ResourceKey<DamageType> FRYING_PAN_BURN = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(fruitstack.MODID, "frying_pan_burn"));

	public static DamageSource getSimpleDamageSource(Level level, ResourceKey<DamageType> type) {
		return new DamageSource(level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(type));
	}
}

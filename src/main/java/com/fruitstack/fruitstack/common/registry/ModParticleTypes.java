package com.fruitstack.fruitstack.common.registry;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import com.fruitstack.fruitstack.fruitstack;

public class ModParticleTypes
{
	public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, fruitstack.MODID);
	public static final RegistryObject<SimpleParticleType> STEAM = PARTICLE_TYPES.register("steam",
			() -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> OIL = PARTICLE_TYPES.register("oil",
			() -> new SimpleParticleType(true));
}

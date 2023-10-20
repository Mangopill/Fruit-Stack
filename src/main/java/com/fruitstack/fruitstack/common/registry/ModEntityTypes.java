package com.fruitstack.fruitstack.common.registry;

import com.fruitstack.fruitstack.common.entity.RawMoonCakeEntity;
import com.fruitstack.fruitstack.fruitstack;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes
{
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, fruitstack.MODID);

	public static final RegistryObject<EntityType<RawMoonCakeEntity>> RAW_BLUEBERRIES_MOON_CAKE = ENTITIES.register("raw_blueberries_moon_cake", () -> (
			EntityType.Builder.<RawMoonCakeEntity>of(RawMoonCakeEntity::new, MobCategory.MISC)
					.sized(0.25F, 0.25F)
					.clientTrackingRange(4)
					.updateInterval(10)
					.build("raw_blueberries_moon_cake")));
}

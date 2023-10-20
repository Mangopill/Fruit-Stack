package com.fruitstack.fruitstack.common.registry;

import com.fruitstack.fruitstack.fruitstack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds
{
	public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, fruitstack.MODID);
	public static final RegistryObject<SoundEvent> BLOCK_CLAY_OVEN_CRACKLE = SOUNDS.register("block.clay_oven.crackle",
			() -> new SoundEvent(new ResourceLocation(fruitstack.MODID, "block.clay_oven.crackle")));

	public static final RegistryObject<SoundEvent> BLOCK_TVFMPOIT_BOIL = SOUNDS.register("block.tripod_vessel_for_making_pills_of_immortality.boil",
			() -> new SoundEvent(new ResourceLocation(fruitstack.MODID, "block.tripod_vessel_for_making_pills_of_immortality.boil")));

	public static final RegistryObject<SoundEvent> BLOCK_TVFMPOIT_BOIL_SOUP = SOUNDS.register("block.tripod_vessel_for_making_pills_of_immortality.boil_soup",
			() -> new SoundEvent(new ResourceLocation(fruitstack.MODID, "block.tripod_vessel_for_making_pills_of_immortality.boil_soup")));

	public static final RegistryObject<SoundEvent> BEATING_MELONS = SOUNDS.register("block.beating_melons.hit",
			() -> new SoundEvent(new ResourceLocation(fruitstack.MODID, "block.beating_melons.hit")));
	public static final RegistryObject<SoundEvent> JUICER = SOUNDS.register("block.juicer.stir",
			() -> new SoundEvent(new ResourceLocation(fruitstack.MODID, "block.juicer.stir")));

	public static final RegistryObject<SoundEvent> BLOCK_FRYING_PAN_SIZZLE = SOUNDS.register("block.frying_pan.sizzle",
			() -> new SoundEvent(new ResourceLocation(fruitstack.MODID, "block.frying_pan.sizzle")));
	public static final RegistryObject<SoundEvent> BLOCK_FRYING_PAN_ADD_FOOD = SOUNDS.register("block.frying_pan.add_food",
			() -> new SoundEvent(new ResourceLocation(fruitstack.MODID, "block.frying_pan.add_food")));
	public static final RegistryObject<SoundEvent> BLOCK_FRYING_PAN_OIL_SIZZLE = SOUNDS.register("block.frying_pan.oil_sizzle",
			() -> new SoundEvent(new ResourceLocation(fruitstack.MODID, "block.frying_pan.oil_sizzle")));
	public static final RegistryObject<SoundEvent> BLOCK_FRYING_PAN_SPATULA = SOUNDS.register("block.frying_pan.spatula",
			() -> new SoundEvent(new ResourceLocation(fruitstack.MODID, "block.frying_pan.spatula")));

	public static final RegistryObject<SoundEvent> BLOCK_OVEN_BAKE = SOUNDS.register("block.oven.bake",
			() -> new SoundEvent(new ResourceLocation(fruitstack.MODID, "block.oven.bake")));
	public static final RegistryObject<SoundEvent> BLOCK_OVEN_DING = SOUNDS.register("block.oven.ding",
			() -> new SoundEvent(new ResourceLocation(fruitstack.MODID, "block.oven.ding")));
}

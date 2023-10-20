package com.fruitstack.fruitstack.common.tag;

import com.fruitstack.fruitstack.fruitstack;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

/**
 * References to tags under the fruitstack namespace.
 * These tags are used for mod mechanics.
 */
public class ModTags
{
	// Blocks that are efficiently mined with a Knife.
	public static final TagKey<Block> FRUIT_BLOCK_CAN_MINE = modBlockTag("fruitstack/fruit_block_can_mine");
	public static final TagKey<Item> FRUIT_KNIVES = modItemTag("tools/fruit_knives");
	public static final TagKey<Block> FRUIT_BLOCK = modBlockTag("fruit_block");
	public static final TagKey<Item> FRUIT_SLICE = modItemTag("fruit_slice");
	public static final TagKey<Block> TRAY_HEAT_SOURCES = modBlockTag("tray_heat_sources");
	public static final TagKey<Block> HEAT_SOURCES = modBlockTag("heat_sources");
	public static final TagKey<Block> HEAT_CONDUCTORS = modBlockTag("heat_conductors");
	private static TagKey<Item> modItemTag(String path) {
		return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(fruitstack.MODID + ":" + path));
	}

	private static TagKey<Block> modBlockTag(String path) {
		return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(fruitstack.MODID + ":" + path));
	}

	private static TagKey<EntityType<?>> modEntityTag(String path) {
		return TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation(fruitstack.MODID + ":" + path));
	}
}

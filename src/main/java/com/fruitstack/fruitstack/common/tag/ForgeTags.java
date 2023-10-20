package com.fruitstack.fruitstack.common.tag;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

/**
 * References to tags under the Forge namespace.
 * These tags are generic concepts, meant to be shared with other mods for compatibility.
 */
public class ForgeTags
{
	public static final TagKey<Item> T00L_FRUIT_KNIFE = forgeItemTag("tools/fruit_knife");
	private static TagKey<Block> forgeBlockTag(String path) {
		return BlockTags.create(new ResourceLocation("forge", path));
	}

	private static TagKey<Item> forgeItemTag(String path) {
		return ItemTags.create(new ResourceLocation("forge", path));
	}

}

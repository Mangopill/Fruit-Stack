package com.fruitstack.fruitstack.data;

import com.fruitstack.fruitstack.common.registry.ModItems;
import com.fruitstack.fruitstack.common.tag.ForgeTags;
import com.fruitstack.fruitstack.common.tag.ModTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class ItemTags extends ItemTagsProvider
{
	public ItemTags(DataGenerator generatorIn, BlockTagsProvider blockTagProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
		super(generatorIn, blockTagProvider, modId, existingFileHelper);
	}

	@Override
	protected void addTags() {
		copy(ModTags.FRUIT_BLOCK_CAN_MINE, ModTags.FRUIT_SLICE);
		copy(BlockTags.CARPETS, net.minecraft.tags.ItemTags.CARPETS);
		copy(BlockTags.SMALL_FLOWERS, net.minecraft.tags.ItemTags.SMALL_FLOWERS);

		tag(net.minecraft.tags.ItemTags.TALL_FLOWERS).add(ModItems.GLUTINOUS_RICE.get());
		tag(net.minecraft.tags.ItemTags.PIGLIN_LOVED).add(ModItems.GOLDEN_FRUIT_KNIFE.get());

		this.registerModTags();
		this.registerForgeTags();
	}


	private void registerModTags() {
		tag(ModTags.FRUIT_KNIVES).add(ModItems.FLINT_FRUIT_KNIFE.get(), ModItems.IRON_FRUIT_KNIFE.get(), ModItems.DIAMOND_FRUIT_KNIFE.get(), ModItems.GOLDEN_FRUIT_KNIFE.get(), ModItems.NETHERITE_FRUIT_KNIFE.get());
	}

	@SuppressWarnings("unchecked")
	private void registerForgeTags() {
		tag(ForgeTags.T00L_FRUIT_KNIFE).add(ModItems.FLINT_FRUIT_KNIFE.get(), ModItems.IRON_FRUIT_KNIFE.get(), ModItems.DIAMOND_FRUIT_KNIFE.get(), ModItems.GOLDEN_FRUIT_KNIFE.get(), ModItems.NETHERITE_FRUIT_KNIFE.get());
	}
}

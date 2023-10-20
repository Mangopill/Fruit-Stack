package com.fruitstack.fruitstack.data;

import com.fruitstack.fruitstack.common.registry.ModItems;
import com.fruitstack.fruitstack.common.tag.ForgeTags;
import com.fruitstack.fruitstack.common.tag.ModTags;
import com.fruitstack.fruitstack.fruitstack;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ItemTags extends ItemTagsProvider
{
	public ItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, CompletableFuture<TagsProvider.TagLookup<Block>> blockTagProvider, @Nullable ExistingFileHelper existingFileHelper) {
		super(output, provider, blockTagProvider, fruitstack.MODID, existingFileHelper);
	}

	@Override
	protected void addTags(HolderLookup.Provider provider) {
		copy(ModTags.FRUIT_BLOCK_CAN_MINE, ModTags.FRUIT_SLICE);
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

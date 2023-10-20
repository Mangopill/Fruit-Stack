package com.fruitstack.fruitstack.data;

import com.fruitstack.fruitstack.common.registry.ModBlocks;
import com.fruitstack.fruitstack.common.tag.ModTags;
import com.fruitstack.fruitstack.fruitstack;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class BlockTags extends BlockTagsProvider
{
	public BlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, fruitstack.MODID, existingFileHelper);
	}

	@Override
	protected void addTags(HolderLookup.Provider provider) {
		this.registerModTags();
		this.registerBlockMineables();
	}

	protected void registerBlockMineables() {
		tag(ModTags.FRUIT_BLOCK_CAN_MINE).add(
				ModBlocks.MANGO_BLOCK.get());
	}
	protected void registerModTags() {
		tag(ModTags.TRAY_HEAT_SOURCES).add(
						Blocks.LAVA)
				.addTag(net.minecraft.tags.BlockTags.CAMPFIRES)
				.addTag(net.minecraft.tags.BlockTags.FIRE);
		tag(ModTags.HEAT_CONDUCTORS).add(
						Blocks.HOPPER)
				.addOptional(new ResourceLocation("create:chute"));
		tag(ModTags.HEAT_SOURCES).add(
						Blocks.MAGMA_BLOCK,
						Blocks.LAVA_CAULDRON,
						ModBlocks.CLAY_OVEN.get())
				.addTag(ModTags.TRAY_HEAT_SOURCES);
	}

}

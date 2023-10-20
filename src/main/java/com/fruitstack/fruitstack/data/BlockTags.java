package com.fruitstack.fruitstack.data;

import com.fruitstack.fruitstack.common.registry.ModBlocks;
import com.fruitstack.fruitstack.common.tag.ModTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class BlockTags extends BlockTagsProvider
{
	public BlockTags(DataGenerator generatorIn, String modId, @Nullable ExistingFileHelper existingFileHelper) {
		super(generatorIn, modId, existingFileHelper);
	}

	@Override
	protected void addTags() {
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

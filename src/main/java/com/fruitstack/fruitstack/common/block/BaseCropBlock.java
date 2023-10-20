package com.fruitstack.fruitstack.common.block;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class BaseCropBlock extends CropBlock {
    private final Supplier<? extends ItemLike> seedItem;

    public BaseCropBlock(Properties proper, Supplier<? extends ItemLike> seed) {
        super(proper);
        this.seedItem = seed;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return this.seedItem.get();
    }

    public BlockState withAge(int age) {
        return this.defaultBlockState().setValue(this.getAgeProperty(), age);
    }
}

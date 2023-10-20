package com.fruitstack.fruitstack.common.effect;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.PowderSnowBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;

public class WarmStomachEffect extends MobEffect {
    public WarmStomachEffect() {
        super(MobEffectCategory.BENEFICIAL, 0xFF0000);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        BlockPos blockPos = entity.blockPosition().below();
        BlockState state = entity.level().getBlockState(blockPos);;
        Level level = entity.level(); // 获取玩家所在的世界对象
        if (state.getBlock() instanceof PowderSnowBlock) {
            level.setBlock(blockPos, Blocks.SNOW_BLOCK.defaultBlockState(), 3);
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}

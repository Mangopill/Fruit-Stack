package com.fruitstack.fruitstack.common.block.entity;

import com.fruitstack.fruitstack.common.registry.ModBlocks;
import com.fruitstack.fruitstack.common.tag.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;


public interface HeatableBlockEntityTwo
{
	default boolean isHeated(Level level, BlockPos pos) {
			if (isDaytime(level) && !level.isRaining() && level.canSeeSky(pos)) {
				if (level.canSeeSky(pos)) {
					return true;
				}
			}

		return false;
	}

	private boolean isDaytime(Level world) {
		long timeOfDay = world.getDayTime() % 24000;
		return timeOfDay >= 0 && timeOfDay < 12000;
	}
	default boolean requiresDirectHeat() {
		return false;
	}
}

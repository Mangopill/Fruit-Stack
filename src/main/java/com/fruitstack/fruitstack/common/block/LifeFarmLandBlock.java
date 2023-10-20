package com.fruitstack.fruitstack.common.block;

import com.fruitstack.fruitstack.common.registry.ModBlocks;
import com.fruitstack.fruitstack.common.utility.MathUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.PlantType;

import java.util.Random;

public class LifeFarmLandBlock extends FarmBlock
{
    public LifeFarmLandBlock(Properties properties) {
        super(properties);
    }

    private static boolean hasWater(LevelReader level, BlockPos pos) {
        for (BlockPos nearbyPos : BlockPos.betweenClosed(pos.offset(-4, 0, -4), pos.offset(4, 1, 4))) {
            if (level.getFluidState(nearbyPos).is(FluidTags.WATER)) {
                return true;
            }
        }
        return net.minecraftforge.common.FarmlandWaterManager.hasBlockWaterTicket(level, pos);
    }

    public static void turnToRichSoil(BlockState state, Level level, BlockPos pos) {
        level.setBlockAndUpdate(pos, pushEntitiesUp(state, ModBlocks.LIFE_DIRT.get().defaultBlockState(), level, pos));
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockState aboveState = level.getBlockState(pos.above());
        return super.canSurvive(state, level, pos) || aboveState.getBlock() instanceof StemGrownBlock;
    }

    @Override
    public boolean isFertile(BlockState state, BlockGetter world, BlockPos pos) {
        if (state.is(ModBlocks.LIFE_FARMLAND.get()))
            return state.getValue(LifeFarmLandBlock.MOISTURE) > 0;

        return false;
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, Random rand) {
        if (!state.canSurvive(level, pos)) {
            turnToRichSoil(state, level, pos);
        }
    }

    private static boolean isNearWater(LevelReader p_53259_, BlockPos p_53260_) {
        for (BlockPos blockpos : BlockPos.betweenClosed(p_53260_.offset(-4, 0, -4), p_53260_.offset(4, 1, 4))) {
            if (p_53259_.getFluidState(blockpos).is(FluidTags.WATER)) {
                return true;
            }
        }

        return net.minecraftforge.common.FarmlandWaterManager.hasBlockWaterTicket(p_53259_, p_53260_);
    }
    private static boolean isUnderCrops(BlockGetter world, BlockPos pos) {
        BlockState blockState = world.getBlockState(pos.below());
        return blockState.getBlock() instanceof CropBlock;
    }
    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, Random random) {
        int moistureLevel = state.getValue(MOISTURE);
            if (!isNearWater(world, pos) && !world.isRainingAt(pos.above())) {
                if (moistureLevel > 0) {
                    world.setBlock(pos, state.setValue(MOISTURE, moistureLevel - 1), 2);
                } else if (!isUnderCrops(world, pos)) {
                    turnToDirt(state, world, pos);
                    return;
                }
            } else if (moistureLevel < 7) {
                world.setBlock(pos, state.setValue(MOISTURE, 7), 2);
            }
            BlockPos abovePos = pos.above();
            BlockState cropState = world.getBlockState(abovePos);
            Block cropBlock = cropState.getBlock();
            if (cropBlock instanceof CropBlock) {
                CropBlock crop = (CropBlock) cropBlock;
                if (crop.getStateDefinition().getProperties().contains(CropBlock.AGE)) {
                    int growthStage = cropState.getValue(CropBlock.AGE);
                    int growthIncrement = 6; // 生长速度提升的倍数
                    if (growthStage < crop.getMaxAge()) {
                        int newGrowthStage = Math.min(growthStage + growthIncrement, crop.getMaxAge());
                        world.setBlock(abovePos, cropState.setValue(CropBlock.AGE, newGrowthStage), 2);
                    }
                }
            }
        }

    public static void turnToDirt(BlockState p_53297_, Level p_53298_, BlockPos p_53299_) {
        p_53298_.setBlockAndUpdate(p_53299_, pushEntitiesUp(p_53297_, ModBlocks.LIFE_DIRT.get().defaultBlockState(), p_53298_, p_53299_));
    }

    @Override
    public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing, net.minecraftforge.common.IPlantable plantable) {
        net.minecraftforge.common.PlantType plantType = plantable.getPlantType(world, pos.relative(facing));
        return plantType == PlantType.CROP || plantType == PlantType.PLAINS;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return !this.defaultBlockState().canSurvive(context.getLevel(), context.getClickedPos()) ? ModBlocks.LIFE_DIRT.get().defaultBlockState() : super.getStateForPlacement(context);
    }

    @Override
    public void fallOn(Level p_153227_, BlockState p_153228_, BlockPos p_153229_, Entity p_153230_, float p_153231_) {
        if (!p_153227_.isClientSide && net.minecraftforge.common.ForgeHooks.onFarmlandTrample(p_153227_, p_153229_, ModBlocks.LIFE_DIRT.get().defaultBlockState(), p_153231_, p_153230_)) {
            turnToDirt(p_153228_, p_153227_, p_153229_);
        }

        super.fallOn(p_153227_, p_153228_, p_153229_, p_153230_, p_153231_);
    }
}

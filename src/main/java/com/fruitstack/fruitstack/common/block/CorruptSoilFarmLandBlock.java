package com.fruitstack.fruitstack.common.block;

import com.fruitstack.fruitstack.common.registry.ModBlocks;
import com.fruitstack.fruitstack.common.utility.MathUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
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

public class CorruptSoilFarmLandBlock extends FarmBlock
{
    public CorruptSoilFarmLandBlock(Properties properties) {
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
        level.setBlockAndUpdate(pos, pushEntitiesUp(state, ModBlocks.CORRUPT_SOIL.get().defaultBlockState(), level, pos));
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockState aboveState = level.getBlockState(pos.above());
        return super.canSurvive(state, level, pos) || aboveState.getBlock() instanceof StemGrownBlock;
    }

    @Override
    public boolean isFertile(BlockState state, BlockGetter world, BlockPos pos) {
        if (state.is(ModBlocks.CORRUPT_SOIL_FARMLAND.get()))
            return state.getValue(LifeFarmLandBlock.MOISTURE) > 0;

        return false;
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource rand) {
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
    @Override
    public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {
        int moistureLevel = state.getValue(MOISTURE);
            if (!isNearWater(worldIn, pos) && !worldIn.isRainingAt(pos.above())) {
                if (moistureLevel > 0) {
                    worldIn.setBlock(pos, state.setValue(MOISTURE, moistureLevel - 1), 2);
                } else if (!isUnderCrops(worldIn, pos)) {
                    turnToDirt(state, worldIn, pos);
                    return;
                }
            } else if (moistureLevel < 7) {
                worldIn.setBlock(pos, state.setValue(MOISTURE, 7), 2);
            }
            BlockPos abovePos = pos.above();
            BlockState cropState = worldIn.getBlockState(abovePos);
            Block cropBlock = cropState.getBlock();
        if (cropBlock instanceof CropBlock && !(cropBlock == ModBlocks.CORRUPT_CROP.get())) {
            int randomNumber = rand.nextInt(100);

            if (randomNumber < 60) {
                worldIn.setBlock(pos.above(), Blocks.AIR.defaultBlockState(), 3);
            } else {
                worldIn.setBlock(pos.above(), ModBlocks.CORRUPT_CROP.get().defaultBlockState(), 3);
            }
        }
    }


    public static void turnToDirt(BlockState p_53297_, Level p_53298_, BlockPos p_53299_) {
        p_53298_.setBlockAndUpdate(p_53299_, pushEntitiesUp(p_53297_, ModBlocks.CORRUPT_SOIL.get().defaultBlockState(), p_53298_, p_53299_));
    }
    @Override
    public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing, net.minecraftforge.common.IPlantable plantable) {
        net.minecraftforge.common.PlantType plantType = plantable.getPlantType(world, pos.relative(facing));
        return plantType == PlantType.CROP || plantType == PlantType.PLAINS;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return !this.defaultBlockState().canSurvive(context.getLevel(), context.getClickedPos()) ? ModBlocks.CORRUPT_SOIL.get().defaultBlockState() : super.getStateForPlacement(context);
    }

    @Override
    public void fallOn(Level p_153227_, BlockState p_153228_, BlockPos p_153229_, Entity p_153230_, float p_153231_) {
        if (!p_153227_.isClientSide && net.minecraftforge.common.ForgeHooks.onFarmlandTrample(p_153227_, p_153229_, ModBlocks.CORRUPT_SOIL.get().defaultBlockState(), p_153231_, p_153230_)) {
            turnToDirt(p_153228_, p_153227_, p_153229_);
        }

        super.fallOn(p_153227_, p_153228_, p_153229_, p_153230_, p_153231_);
    }
}

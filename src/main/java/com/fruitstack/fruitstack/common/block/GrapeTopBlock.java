package com.fruitstack.fruitstack.common.block;

import com.fruitstack.fruitstack.common.registry.ModBlocks;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.BlockPos;

import java.util.Random;
import java.util.function.Supplier;

public class GrapeTopBlock extends Block {

    protected static final VoxelShape SHAPE = Block.box(5.0, 1.0, 5.0, 10.0, 15.0, 10.0);
    private final Supplier<Block> grapeother;

    public GrapeTopBlock(Supplier<Block> grapeother, BlockBehaviour.Properties properties) {
        super(properties);
        this.grapeother = grapeother;
    }

    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    public BlockState updateShape(BlockState state, Direction direction, BlockState facingState, LevelAccessor level, BlockPos pos, BlockPos facingPos) {
        if (!state.canSurvive(level, pos)) {
            return Blocks.AIR.defaultBlockState();
        } else {
            return super.updateShape(state, direction, facingState, level, pos, facingPos);
        }
    }

    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return level.getBlockState(pos.below()).is(ModBlocks.GRAPE_CROP_MIDDLE.get());
    }
    @Override
    public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {
        if (!worldIn.isClientSide) {
            if (rand.nextFloat() <= 0.1F) {
                if (worldIn.getBlockState(pos.north()).is(ModBlocks.GRAPE_BRACKET.get())) {
                    worldIn.setBlock(pos.north(), this.grapeother.get().defaultBlockState(), 3);
                } else if (worldIn.getBlockState(pos.south()).is(ModBlocks.GRAPE_BRACKET.get())) {
                    worldIn.setBlock(pos.south(), this.grapeother.get().defaultBlockState(), 3);
                } else if (worldIn.getBlockState(pos.west()).is(ModBlocks.GRAPE_BRACKET.get())) {
                    worldIn.setBlock(pos.west(), this.grapeother.get().defaultBlockState(), 3);
                } else if (worldIn.getBlockState(pos.east()).is(ModBlocks.GRAPE_BRACKET.get())) {
                    worldIn.setBlock(pos.east(), this.grapeother.get().defaultBlockState(), 3);
                }
            }
        }
    }
}
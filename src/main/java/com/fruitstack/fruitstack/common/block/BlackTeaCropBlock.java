package com.fruitstack.fruitstack.common.block;

import com.fruitstack.fruitstack.common.registry.ModBlocks;
import com.fruitstack.fruitstack.common.registry.ModItems;
import com.fruitstack.fruitstack.common.utility.TextUtils;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.BlockPos;
import net.minecraft.util.random.WeightedRandomList;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.StateDefinition;
import java.util.Random;
import java.util.function.Supplier;

import static net.minecraft.world.level.block.LeavesBlock.PERSISTENT;

public class BlackTeaCropBlock extends Block {
    protected static final VoxelShape SHAPE = Block.box(2.0, 1.0, 2.0, 14.0, 15.0, 14.0);
    private final Supplier<Block> blackTeaCropMiddle;
    private final Supplier<Block> blackTeaCropTop;
    private final Supplier<Block> blackTeaLeaves;

    public BlackTeaCropBlock(Supplier<Block> blackTeaCropMiddle, Supplier<Block> blackTeaCropTop, Supplier<Block> blackTeaLeaves, BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any());
        this.blackTeaCropMiddle = blackTeaCropMiddle;
        this.blackTeaCropTop = blackTeaCropTop;
        this.blackTeaLeaves = blackTeaLeaves;
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
        return level.getBlockState(pos.below()).is(Blocks.GRASS_BLOCK);
    }

    public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, Random random) {
        if (!worldIn.isClientSide) {
            if (random.nextFloat() <= 0.1F) {
                worldIn.setBlock(pos.above(), this.blackTeaCropMiddle.get().defaultBlockState(), 3);
                if(worldIn.getBlockState(pos.above()).is(this.blackTeaCropMiddle.get())) {
                    worldIn.setBlock(pos.above().above(), this.blackTeaCropTop.get().defaultBlockState(), 3);
                    worldIn.setBlock(pos.above().north(), this.blackTeaLeaves.get().defaultBlockState().setValue(BlockStateProperties.DISTANCE, 1).setValue(PERSISTENT, Boolean.valueOf(true)), 3);
                    worldIn.setBlock(pos.above().south(), this.blackTeaLeaves.get().defaultBlockState().setValue(BlockStateProperties.DISTANCE, 1).setValue(PERSISTENT, Boolean.valueOf(true)), 3);
                    worldIn.setBlock(pos.above().west(), this.blackTeaLeaves.get().defaultBlockState().setValue(BlockStateProperties.DISTANCE, 1).setValue(PERSISTENT, Boolean.valueOf(true)), 3);
                    worldIn.setBlock(pos.above().east(), this.blackTeaLeaves.get().defaultBlockState().setValue(BlockStateProperties.DISTANCE, 1).setValue(PERSISTENT, Boolean.valueOf(true)), 3);
                }
                if(worldIn.getBlockState(pos.above().above()).is(this.blackTeaCropTop.get())) {
                    worldIn.setBlock(pos.above().above().north(), this.blackTeaLeaves.get().defaultBlockState().setValue(BlockStateProperties.DISTANCE, 1).setValue(PERSISTENT, Boolean.valueOf(true)), 3);
                    worldIn.setBlock(pos.above().above().south(), this.blackTeaLeaves.get().defaultBlockState().setValue(BlockStateProperties.DISTANCE, 1).setValue(PERSISTENT, Boolean.valueOf(true)), 3);
                    worldIn.setBlock(pos.above().above().west(), this.blackTeaLeaves.get().defaultBlockState().setValue(BlockStateProperties.DISTANCE, 1).setValue(PERSISTENT, Boolean.valueOf(true)), 3);
                    worldIn.setBlock(pos.above().above().east(), this.blackTeaLeaves.get().defaultBlockState().setValue(BlockStateProperties.DISTANCE, 1).setValue(PERSISTENT, Boolean.valueOf(true)), 3);
                }
            }
        }
    }
}
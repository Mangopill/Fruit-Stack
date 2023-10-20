package com.fruitstack.fruitstack.common.block;

import com.fruitstack.fruitstack.common.registry.ModBlocks;
import com.fruitstack.fruitstack.common.registry.ModItems;
import com.fruitstack.fruitstack.common.utility.TextUtils;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
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

public class GrapeBottomBlock extends Block {
    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 2);
    protected static final VoxelShape SHAPE = Block.box(5.0, 1.0, 5.0, 10.0, 15.0, 10.0);
    private final Supplier<Block> grapeMiddle;

    public GrapeBottomBlock(Supplier<Block> grapeMiddle, BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
        this.grapeMiddle = grapeMiddle;
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

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
        super.createBlockStateDefinition(builder);
    }
    @Override
    public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {
        if (!worldIn.isClientSide) {
            if (rand.nextFloat() <= 0.1F) {
                int age = state.getValue(AGE);
                if (age == 0) {
                    worldIn.setBlock(pos, state.setValue(AGE, 1), 3);
                } else if (age == 1) {
                    worldIn.setBlock(pos, state.setValue(AGE, 2), 3);
                } else if (age == 2 && worldIn.getBlockState(pos.above()).isAir()) {
                    worldIn.setBlock(pos.above(), this.grapeMiddle.get().defaultBlockState(), 3);
                }
            }
        }
    }
    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (level.isClientSide) {
            if (this.boneMeal(level, pos, state, player, hand).consumesAction()) {
                return InteractionResult.SUCCESS;
            }
        }
        return this.boneMeal(level, pos, state, player, hand);
    }
    protected InteractionResult boneMeal(LevelAccessor level, BlockPos pos, BlockState state, Player player, InteractionHand hand) {
        int age = state.getValue(AGE);
        ItemStack heldStack = player.getItemInHand(hand);
        if (age == 0 && heldStack.getItem() == Items.BONE_MEAL) {
            level.playSound(null, pos, SoundEvents.BONE_MEAL_USE, SoundSource.PLAYERS, 0.8F, 0.8F);
            level.setBlock(pos, state.setValue(AGE, 1), 3);
            heldStack.shrink(1);
            level.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, 0, 0.1, 0);
            return InteractionResult.SUCCESS;
        }
        if (age == 1 && heldStack.getItem() == Items.BONE_MEAL) {
            level.playSound(null, pos, SoundEvents.BONE_MEAL_USE, SoundSource.PLAYERS, 0.8F, 0.8F);
            level.setBlock(pos, state.setValue(AGE, 2), 3);
            heldStack.shrink(1);
            level.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, 0, 0.1, 0);
            return InteractionResult.SUCCESS;
        }
        if (age == 2 && heldStack.getItem() == Items.BONE_MEAL) {
            level.playSound(null, pos, SoundEvents.BONE_MEAL_USE, SoundSource.PLAYERS, 0.8F, 0.8F);
            level.setBlock(pos.above(), ModBlocks.GRAPE_CROP_MIDDLE.get().defaultBlockState(), 3);
            heldStack.shrink(1);
            level.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, 0, 0.1, 0);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }
}
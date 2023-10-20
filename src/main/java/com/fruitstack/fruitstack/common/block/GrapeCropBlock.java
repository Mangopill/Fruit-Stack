package com.fruitstack.fruitstack.common.block;

import com.fruitstack.fruitstack.common.registry.ModBlocks;
import com.fruitstack.fruitstack.common.registry.ModItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.CropBlock;
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
import net.minecraftforge.fml.common.Mod;

import java.util.Random;
import java.util.function.Supplier;

public class GrapeCropBlock extends Block {
    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 7);
    protected static final VoxelShape SHAPE = Block.box(1.0, 5.0, 1.0, 15.0, 15.0, 15.0);
    private final Supplier<Block> grapeother;
    public final Supplier<Item> grapeItem;
    /**
     * This block provides up to 4 servings of food to players who interact with it.
     * If a leftover item is specified, the block lingers at 0 servings, and is destroyed on right-click.
     *
     * @param properties   Block properties.
     * @param grapeItem  The bread to be served.
     */
    public GrapeCropBlock(Supplier<Block> grapeother, BlockBehaviour.Properties properties, Supplier<Item> grapeItem) {
        super(properties);
        this.grapeItem = grapeItem;
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
        this.grapeother = grapeother;
    }

    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
    public ItemStack getGrapeItem(BlockState state) {
        return new ItemStack(this.grapeItem.get());
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
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
        super.createBlockStateDefinition(builder);
    }
    public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, Random random) {
        if (!worldIn.isClientSide) {
            if (random.nextFloat() <= 0.1F) {
                int age = state.getValue(AGE);
                if (age == 0) {
                    worldIn.setBlock(pos, state.setValue(AGE, 1), 3);
                } else if (age < 7) {
                    worldIn.setBlock(pos, state.setValue(AGE, age + 1), 3);
                }
                if (hasGrapeCropTopOutsideRange(worldIn, pos, 6)) {
                    return;
                }
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

    private boolean hasGrapeCropTopOutsideRange(Level world, BlockPos pos, int range) {
        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();
        for (int x = -range; x <= range; x++) {
            for (int y = -range; y <= range; y++) {
                for (int z = -range; z <= range; z++) {
                    mutablePos.setWithOffset(pos, x, y, z);
                    if (Math.abs(x) > range-1 || Math.abs(y) > range-1 || Math.abs(z) > range-1) {
                        if (world.getBlockState(mutablePos).is(ModBlocks.GRAPE_CROP_TOP.get())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
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
        ItemStack grape = this.getGrapeItem(state);
        ItemStack heldStack = player.getItemInHand(hand);
        if (age == 0 && heldStack.getItem() == Items.BONE_MEAL) {
            level.playSound(null, pos, SoundEvents.BONE_MEAL_USE, SoundSource.PLAYERS, 0.8F, 0.8F);
            level.setBlock(pos, state.setValue(AGE, 1), 3);
            heldStack.shrink(1);
            level.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, 0, 0.1, 0);
            return InteractionResult.SUCCESS;
        }
        if (age < 7 && heldStack.getItem() == Items.BONE_MEAL) {
            level.playSound(null, pos, SoundEvents.BONE_MEAL_USE, SoundSource.PLAYERS, 0.8F, 0.8F);
            level.setBlock(pos, state.setValue(AGE, age + 1), 3);
            heldStack.shrink(1);
            level.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, 0, 0.1, 0);
            return InteractionResult.SUCCESS;
        }
        if (age == 7 && heldStack.isEmpty()) {
            level.playSound(null, pos, SoundEvents.CROP_BREAK, SoundSource.PLAYERS, 0.8F, 0.8F);
            level.setBlock(pos, state.setValue(AGE, 0), 3);
                ItemStack itemStack = new ItemStack(ModItems.GRAPE.get());
                ItemEntity itemEntity = new ItemEntity((Level) level, pos.getX() - 0.5, pos.getY() - 0.5, pos.getZ() - 0.5, itemStack);
                level.addFreshEntity(itemEntity);
                return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }
}
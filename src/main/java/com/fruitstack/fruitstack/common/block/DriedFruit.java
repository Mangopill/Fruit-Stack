package com.fruitstack.fruitstack.common.block;

import com.fruitstack.fruitstack.common.utility.TextUtils;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
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

public class DriedFruit extends Block {
    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 2);
    protected static final VoxelShape SHAPE = Block.box(1.0, 1.0, 1.0, 15.0, 5.0, 15.0);
    public final Supplier<Item> driedItem;
    /**
     * @param properties   Block properties.
     * @param driedItem  The dried to be served.
     */
    public DriedFruit(BlockBehaviour.Properties properties, Supplier<Item> driedItem) {
        super(properties);
        this.driedItem = driedItem;
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
    }
    public ItemStack getDriedItem(BlockState state) {
        return new ItemStack(this.driedItem.get());
    }
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (level.isClientSide) {
            if (this.takeDried(level, pos, state, player, hand).consumesAction()) {
                return InteractionResult.SUCCESS;
            }
        }
        return this.takeDried(level, pos, state, player, hand);
    }
    protected InteractionResult takeDried(LevelAccessor level, BlockPos pos, BlockState state, Player player, InteractionHand hand) {
        int age = state.getValue(AGE);
        ItemStack dried = this.getDriedItem(state);
            if (age == 2) {
                level.removeBlock(pos,false);
                if (!player.getInventory().add(dried)) {
                    player.drop(dried, false);
                }
                level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
                return InteractionResult.SUCCESS;
            } else {
                player.displayClientMessage(TextUtils.getTranslation("block.dried.get", dried.getContainerItem().getHoverName()), true);
            }
        return InteractionResult.PASS;
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
        if (level.getBlockState(pos.below()).getBlock() == this) {
            return false;
        }
        return !level.isEmptyBlock(pos.below());
    }
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
        super.createBlockStateDefinition(builder);
    }

    public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, Random random) {
        if (!worldIn.isClientSide && isDaytime(worldIn) && !worldIn.isRaining()) {
            if (random.nextFloat() <= 0.1F) {
                int age = state.getValue(AGE);
                if (age == 0) {
                    if (worldIn.canSeeSky(pos)) {
                        worldIn.setBlock(pos, state.setValue(AGE, 1), 3);
                    }
                } else if (age == 1 && isDaytime(worldIn)) {
                    if (worldIn.canSeeSky(pos)) {
                        worldIn.setBlock(pos, state.setValue(AGE, 2), 3);
                    }
                }
            }
        }
        boolean hasBlockAbove = false;
        for (int y = pos.getY() + 1; y <= worldIn.getHeight(); y++) {
            BlockPos checkPos = new BlockPos(pos.getX(), y, pos.getZ());
            if (!worldIn.getBlockState(checkPos).isAir()) {
                hasBlockAbove = true;
                break;
            }
        }

        if (!worldIn.isClientSide && worldIn.isRaining() && worldIn.canSeeSky(pos) && !hasBlockAbove) {
            worldIn.setBlock(pos, state.setValue(AGE, 0), 3);
        }

    }
    private boolean isDaytime(ServerLevel world) {
        long timeOfDay = world.getDayTime() % 24000;
        return timeOfDay >= 0 && timeOfDay < 12000;
    }
}
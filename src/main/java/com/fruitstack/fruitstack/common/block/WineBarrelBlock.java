package com.fruitstack.fruitstack.common.block;

import com.fruitstack.fruitstack.common.block.entity.JuicerBlockEntity;
import com.fruitstack.fruitstack.common.registry.ModBlocks;
import com.fruitstack.fruitstack.common.registry.ModItems;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;
import net.minecraft.util.random.WeightedRandomList;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraftforge.network.NetworkHooks;

import java.util.Random;
import java.util.function.Supplier;

public class WineBarrelBlock extends Block {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final IntegerProperty STAGE = IntegerProperty.create("stage", 0, 3);
    protected static final VoxelShape SHAPE = Block.box(1.0, 1.0, 1.0, 15.0, 15.0, 15.0);
    public WineBarrelBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(STAGE, 0));
    }

    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
    public ItemStack getCannItem(BlockState state) {
        return new ItemStack(ModItems.CANN.get());
    }

    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return !level.isEmptyBlock(pos.below());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING,STAGE);
        super.createBlockStateDefinition(builder);
    }
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player,
                                 InteractionHand hand, BlockHitResult result) {
        ItemStack heldStack = player.getItemInHand(hand);
        ItemStack cann = this.getCannItem(state);
        int sugar = state.getValue(STAGE);
        if (!level.isClientSide) {
            if (sugar == 0 && heldStack.getItem() == Items.SUGAR && heldStack.getCount() >= 3) {
                heldStack.shrink(3);
                level.setBlock(pos, state.setValue(STAGE, 1), 3);
                return InteractionResult.SUCCESS;
            }
            if (sugar == 0 && heldStack.getItem() == Items.WHEAT && heldStack.getCount() >= 5) {
                heldStack.shrink(5);
                level.setBlock(pos, state.setValue(STAGE, 3), 3);
                return InteractionResult.SUCCESS;
            }
            if (sugar == 1 && heldStack.getItem() == ModItems.CHINESE_SPIRITS_TEN.get() && heldStack.getCount() >= 1) {
                heldStack.shrink(1);
                if (!player.getInventory().add(cann)) {
                    player.drop(cann, false);
                }
                level.setBlock(pos, state.setValue(STAGE, 2), 3);
                return InteractionResult.SUCCESS;
            }
            if (sugar == 3 && heldStack.getItem() == ModItems.GLUTINOUS_RICE.get() && heldStack.getCount() >= 8) {
                heldStack.shrink(8);
                BlockPlaceContext blockPlaceContext = new BlockPlaceContext(new UseOnContext(level, player, hand, heldStack, result));
                BlockState originalState = level.getBlockState(pos);
                Direction originalDirection = originalState.getValue(BlockStateProperties.HORIZONTAL_FACING);
                BlockState newState = ModBlocks.CHINESE_SPIRITS_BARREL.get().getStateForPlacement(blockPlaceContext);
                newState = newState.setValue(BlockStateProperties.HORIZONTAL_FACING, originalDirection);
                level.setBlock(pos, newState, 3);
                return InteractionResult.SUCCESS;
            }
            if (sugar == 2 && (heldStack.getItem() == ModItems.MANGO_SLICE.get() || heldStack.getItem() == ModItems.GREEN_MANGO_SLICE.get()) && heldStack.getCount() >= 8) {
                heldStack.shrink(8);
                BlockPlaceContext blockPlaceContext = new BlockPlaceContext(new UseOnContext(level, player, hand, heldStack, result));
                BlockState originalState = level.getBlockState(pos);
                Direction originalDirection = originalState.getValue(BlockStateProperties.HORIZONTAL_FACING);
                BlockState newState = ModBlocks.MANGO_WINE_BARREL.get().getStateForPlacement(blockPlaceContext);
                newState = newState.setValue(BlockStateProperties.HORIZONTAL_FACING, originalDirection);
                level.setBlock(pos, newState, 3);
                return InteractionResult.SUCCESS;
            }
            if (sugar == 2 && heldStack.getItem() == ModItems.BLUEBERRIES.get() && heldStack.getCount() >= 8) {
                heldStack.shrink(8);
                BlockPlaceContext blockPlaceContext = new BlockPlaceContext(new UseOnContext(level, player, hand, heldStack, result));
                BlockState originalState = level.getBlockState(pos);
                Direction originalDirection = originalState.getValue(BlockStateProperties.HORIZONTAL_FACING);
                BlockState newState = ModBlocks.BLUEBERRIES_WINE_BARREL.get().getStateForPlacement(blockPlaceContext);
                newState = newState.setValue(BlockStateProperties.HORIZONTAL_FACING, originalDirection);
                level.setBlock(pos, newState, 3);
                return InteractionResult.SUCCESS;
            }
            if (sugar == 2 && heldStack.getItem() == ModItems.HAMIMELON.get() && heldStack.getCount() >= 8) {
                heldStack.shrink(8);
                BlockPlaceContext blockPlaceContext = new BlockPlaceContext(new UseOnContext(level, player, hand, heldStack, result));
                BlockState originalState = level.getBlockState(pos);
                Direction originalDirection = originalState.getValue(BlockStateProperties.HORIZONTAL_FACING);
                BlockState newState = ModBlocks.HAMIMELON_WINE_BARREL.get().getStateForPlacement(blockPlaceContext);
                newState = newState.setValue(BlockStateProperties.HORIZONTAL_FACING, originalDirection);
                level.setBlock(pos, newState, 3);
                return InteractionResult.SUCCESS;
            }
            if (sugar == 2 && heldStack.getItem() == ModItems.HOLBOELLIA_LATIFOLIA_SLICE.get() && heldStack.getCount() >= 8) {
                heldStack.shrink(8);
                BlockPlaceContext blockPlaceContext = new BlockPlaceContext(new UseOnContext(level, player, hand, heldStack, result));
                BlockState originalState = level.getBlockState(pos);
                Direction originalDirection = originalState.getValue(BlockStateProperties.HORIZONTAL_FACING);
                BlockState newState = ModBlocks.HOLBOELLIA_LATIFOLIA_WINE_BARREL.get().getStateForPlacement(blockPlaceContext);
                newState = newState.setValue(BlockStateProperties.HORIZONTAL_FACING, originalDirection);
                level.setBlock(pos, newState, 3);
                return InteractionResult.SUCCESS;
            }
            if (sugar == 2 && heldStack.getItem() == ModItems.LITCHI_SLICE.get() && heldStack.getCount() >= 8) {
                heldStack.shrink(8);
                BlockPlaceContext blockPlaceContext = new BlockPlaceContext(new UseOnContext(level, player, hand, heldStack, result));
                BlockState originalState = level.getBlockState(pos);
                Direction originalDirection = originalState.getValue(BlockStateProperties.HORIZONTAL_FACING);
                BlockState newState = ModBlocks.LITCHI_WINE_BARREL.get().getStateForPlacement(blockPlaceContext);
                newState = newState.setValue(BlockStateProperties.HORIZONTAL_FACING, originalDirection);
                level.setBlock(pos, newState, 3);
                return InteractionResult.SUCCESS;
            }
            if (sugar == 2 && heldStack.getItem() == ModItems.HUOSHEN_FRUIT_SLICE.get() && heldStack.getCount() >= 8) {
                heldStack.shrink(8);
                BlockPlaceContext blockPlaceContext = new BlockPlaceContext(new UseOnContext(level, player, hand, heldStack, result));
                BlockState originalState = level.getBlockState(pos);
                Direction originalDirection = originalState.getValue(BlockStateProperties.HORIZONTAL_FACING);
                BlockState newState = ModBlocks.HUOSHEN_FRUIT_WINE_BARREL.get().getStateForPlacement(blockPlaceContext);
                newState = newState.setValue(BlockStateProperties.HORIZONTAL_FACING, originalDirection);
                level.setBlock(pos, newState, 3);
                return InteractionResult.SUCCESS;
            }
            if (sugar == 2 && heldStack.getItem() == ModItems.BEATING_MELONS_SLICE.get() && heldStack.getCount() >= 8) {
                heldStack.shrink(8);
                BlockPlaceContext blockPlaceContext = new BlockPlaceContext(new UseOnContext(level, player, hand, heldStack, result));
                BlockState originalState = level.getBlockState(pos);
                Direction originalDirection = originalState.getValue(BlockStateProperties.HORIZONTAL_FACING);
                BlockState newState = ModBlocks.BEATING_MELONS_WINE_BARREL.get().getStateForPlacement(blockPlaceContext);
                newState = newState.setValue(BlockStateProperties.HORIZONTAL_FACING, originalDirection);
                level.setBlock(pos, newState, 3);
                return InteractionResult.SUCCESS;
            }
            if (sugar == 2 && heldStack.getItem() == ModItems.GROUND_CUCUMBER_SLICE.get() && heldStack.getCount() >= 8) {
                heldStack.shrink(8);
                BlockPlaceContext blockPlaceContext = new BlockPlaceContext(new UseOnContext(level, player, hand, heldStack, result));
                BlockState originalState = level.getBlockState(pos);
                Direction originalDirection = originalState.getValue(BlockStateProperties.HORIZONTAL_FACING);
                BlockState newState = ModBlocks.GROUND_CUCUMBER_WINE_BARREL.get().getStateForPlacement(blockPlaceContext);
                newState = newState.setValue(BlockStateProperties.HORIZONTAL_FACING, originalDirection);
                level.setBlock(pos, newState, 3);
                return InteractionResult.SUCCESS;
            }
            if (sugar == 2 && heldStack.getItem() == ModItems.SEPTEMBER_MELON.get() && heldStack.getCount() >= 8) {
                heldStack.shrink(8);
                BlockPlaceContext blockPlaceContext = new BlockPlaceContext(new UseOnContext(level, player, hand, heldStack, result));
                BlockState originalState = level.getBlockState(pos);
                Direction originalDirection = originalState.getValue(BlockStateProperties.HORIZONTAL_FACING);
                BlockState newState = ModBlocks.SEPTEMBER_MELON_WINE_BARREL.get().getStateForPlacement(blockPlaceContext);
                newState = newState.setValue(BlockStateProperties.HORIZONTAL_FACING, originalDirection);
                level.setBlock(pos, newState, 3);
                return InteractionResult.SUCCESS;
            }
            if (sugar == 2 && heldStack.getItem() == ModItems.PITAYA_SLICE.get() && heldStack.getCount() >= 8) {
                heldStack.shrink(8);
                BlockPlaceContext blockPlaceContext = new BlockPlaceContext(new UseOnContext(level, player, hand, heldStack, result));
                BlockState originalState = level.getBlockState(pos);
                Direction originalDirection = originalState.getValue(BlockStateProperties.HORIZONTAL_FACING);
                BlockState newState = ModBlocks.PITAYA_WINE_BARREL.get().getStateForPlacement(blockPlaceContext);
                newState = newState.setValue(BlockStateProperties.HORIZONTAL_FACING, originalDirection);
                level.setBlock(pos, newState, 3);
                return InteractionResult.SUCCESS;
            }
            if (sugar == 2 && heldStack.getItem() == ModItems.GOLDEN_PURE_SHEEP_HORN_HONEY_SLICE.get() && heldStack.getCount() >= 8) {
                heldStack.shrink(8);
                BlockPlaceContext blockPlaceContext = new BlockPlaceContext(new UseOnContext(level, player, hand, heldStack, result));
                BlockState originalState = level.getBlockState(pos);
                Direction originalDirection = originalState.getValue(BlockStateProperties.HORIZONTAL_FACING);
                BlockState newState = ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_BARREL.get().getStateForPlacement(blockPlaceContext);
                newState = newState.setValue(BlockStateProperties.HORIZONTAL_FACING, originalDirection);
                level.setBlock(pos, newState, 3);
                return InteractionResult.SUCCESS;
            }
            if (sugar == 2 && heldStack.getItem() == ModItems.PEAR_SLICE.get() && heldStack.getCount() >= 8) {
                heldStack.shrink(8);
                BlockPlaceContext blockPlaceContext = new BlockPlaceContext(new UseOnContext(level, player, hand, heldStack, result));
                BlockState originalState = level.getBlockState(pos);
                Direction originalDirection = originalState.getValue(BlockStateProperties.HORIZONTAL_FACING);
                BlockState newState = ModBlocks.PEAR_WINE_BARREL.get().getStateForPlacement(blockPlaceContext);
                newState = newState.setValue(BlockStateProperties.HORIZONTAL_FACING, originalDirection);
                level.setBlock(pos, newState, 3);
                return InteractionResult.SUCCESS;
            }
            if (sugar == 2 && heldStack.getItem() == ModItems.MAYTHORN.get() && heldStack.getCount() >= 8) {
                heldStack.shrink(8);
                BlockPlaceContext blockPlaceContext = new BlockPlaceContext(new UseOnContext(level, player, hand, heldStack, result));
                BlockState originalState = level.getBlockState(pos);
                Direction originalDirection = originalState.getValue(BlockStateProperties.HORIZONTAL_FACING);
                BlockState newState = ModBlocks.MAYTHORN_WINE_BARREL.get().getStateForPlacement(blockPlaceContext);
                newState = newState.setValue(BlockStateProperties.HORIZONTAL_FACING, originalDirection);
                level.setBlock(pos, newState, 3);
                return InteractionResult.SUCCESS;
            }
            if (sugar == 2 && heldStack.getItem() == ModItems.CHINESE_PEAR_LEAVED_SLICE.get() && heldStack.getCount() >= 8) {
                heldStack.shrink(8);
                BlockPlaceContext blockPlaceContext = new BlockPlaceContext(new UseOnContext(level, player, hand, heldStack, result));
                BlockState originalState = level.getBlockState(pos);
                Direction originalDirection = originalState.getValue(BlockStateProperties.HORIZONTAL_FACING);
                BlockState newState = ModBlocks.CHINESE_PEAR_LEAVED_WINE_BARREL.get().getStateForPlacement(blockPlaceContext);
                newState = newState.setValue(BlockStateProperties.HORIZONTAL_FACING, originalDirection);
                level.setBlock(pos, newState, 3);
                return InteractionResult.SUCCESS;
            }
            if (sugar == 2 && heldStack.getItem() == ModItems.PLUM.get() && heldStack.getCount() >= 8) {
                heldStack.shrink(8);
                BlockPlaceContext blockPlaceContext = new BlockPlaceContext(new UseOnContext(level, player, hand, heldStack, result));
                BlockState originalState = level.getBlockState(pos);
                Direction originalDirection = originalState.getValue(BlockStateProperties.HORIZONTAL_FACING);
                BlockState newState = ModBlocks.PLUM_WINE_BARREL.get().getStateForPlacement(blockPlaceContext);
                newState = newState.setValue(BlockStateProperties.HORIZONTAL_FACING, originalDirection);
                level.setBlock(pos, newState, 3);
                return InteractionResult.SUCCESS;
            }
            if (sugar == 2 && heldStack.getItem() == ModItems.JUJUBE.get() && heldStack.getCount() >= 8) {
                heldStack.shrink(8);
                BlockPlaceContext blockPlaceContext = new BlockPlaceContext(new UseOnContext(level, player, hand, heldStack, result));
                BlockState originalState = level.getBlockState(pos);
                Direction originalDirection = originalState.getValue(BlockStateProperties.HORIZONTAL_FACING);
                BlockState newState = ModBlocks.JUJUBE_WINE_BARREL.get().getStateForPlacement(blockPlaceContext);
                newState = newState.setValue(BlockStateProperties.HORIZONTAL_FACING, originalDirection);
                level.setBlock(pos, newState, 3);
                return InteractionResult.SUCCESS;
            }
            if (sugar == 2 && heldStack.getItem() == ModItems.APRICOT.get() && heldStack.getCount() >= 8) {
                heldStack.shrink(8);
                BlockPlaceContext blockPlaceContext = new BlockPlaceContext(new UseOnContext(level, player, hand, heldStack, result));
                BlockState originalState = level.getBlockState(pos);
                Direction originalDirection = originalState.getValue(BlockStateProperties.HORIZONTAL_FACING);
                BlockState newState = ModBlocks.APRICOT_WINE_BARREL.get().getStateForPlacement(blockPlaceContext);
                newState = newState.setValue(BlockStateProperties.HORIZONTAL_FACING, originalDirection);
                level.setBlock(pos, newState, 3);
                return InteractionResult.SUCCESS;
            }
            if (sugar == 2 && heldStack.getItem() == ModItems.RED_BAYBERRY.get() && heldStack.getCount() >= 8) {
                heldStack.shrink(8);
                BlockPlaceContext blockPlaceContext = new BlockPlaceContext(new UseOnContext(level, player, hand, heldStack, result));
                BlockState originalState = level.getBlockState(pos);
                Direction originalDirection = originalState.getValue(BlockStateProperties.HORIZONTAL_FACING);
                BlockState newState = ModBlocks.RED_BAYBERRY_WINE_BARREL.get().getStateForPlacement(blockPlaceContext);
                newState = newState.setValue(BlockStateProperties.HORIZONTAL_FACING, originalDirection);
                level.setBlock(pos, newState, 3);
                return InteractionResult.SUCCESS;
            }
            if (sugar == 2 && heldStack.getItem() == ModItems.GREEN_PLUM.get() && heldStack.getCount() >= 8) {
                heldStack.shrink(8);
                BlockPlaceContext blockPlaceContext = new BlockPlaceContext(new UseOnContext(level, player, hand, heldStack, result));
                BlockState originalState = level.getBlockState(pos);
                Direction originalDirection = originalState.getValue(BlockStateProperties.HORIZONTAL_FACING);
                BlockState newState = ModBlocks.GREEN_PLUM_WINE_BARREL.get().getStateForPlacement(blockPlaceContext);
                newState = newState.setValue(BlockStateProperties.HORIZONTAL_FACING, originalDirection);
                level.setBlock(pos, newState, 3);
                return InteractionResult.SUCCESS;
            }
            if (sugar == 2 && heldStack.getItem() == ModItems.CRUSHED_GRAPES.get() && heldStack.getCount() >= 8) {
                heldStack.shrink(8);
                BlockPlaceContext blockPlaceContext = new BlockPlaceContext(new UseOnContext(level, player, hand, heldStack, result));
                BlockState originalState = level.getBlockState(pos);
                Direction originalDirection = originalState.getValue(BlockStateProperties.HORIZONTAL_FACING);
                BlockState newState = ModBlocks.GRAPE_WINE_BARREL.get().getStateForPlacement(blockPlaceContext);
                newState = newState.setValue(BlockStateProperties.HORIZONTAL_FACING, originalDirection);
                level.setBlock(pos, newState, 3);
                return InteractionResult.SUCCESS;
            }
            if (sugar == 2 && heldStack.getItem() == ModItems.PEACH_SLICE.get() && heldStack.getCount() >= 8) {
                heldStack.shrink(8);
                BlockPlaceContext blockPlaceContext = new BlockPlaceContext(new UseOnContext(level, player, hand, heldStack, result));
                BlockState originalState = level.getBlockState(pos);
                Direction originalDirection = originalState.getValue(BlockStateProperties.HORIZONTAL_FACING);
                BlockState newState = ModBlocks.PEACH_WINE_BARREL.get().getStateForPlacement(blockPlaceContext);
                newState = newState.setValue(BlockStateProperties.HORIZONTAL_FACING, originalDirection);
                level.setBlock(pos, newState, 3);
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }
    @Override
    public BlockState rotate(BlockState pState, Rotation pRot) {
        return pState.setValue(FACING, pRot.rotate(pState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }
    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

}
package com.fruitstack.fruitstack.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class ApricotRecipePackageBlock extends Block {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public final static VoxelShape N_S_SHAPE = Block.box(5, 1, 5, 11, 6, 11);
    public final static VoxelShape E_W_SHAPE = Block.box(5, 1, 5, 11, 6, 11);

    public ApricotRecipePackageBlock() {
        super(Properties.of(Material.METAL).strength(1.0f).noOcclusion());
        this.registerDefaultState(this.defaultBlockState().setValue(FACING, Direction.NORTH));
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!world.isClientSide()) {
            world.playSound(null, pos, SoundEvents.WOOD_BREAK, SoundSource.BLOCKS, 0.8f, 1f);
            getRecipeBoardDrop().forEach(itemStack -> Containers.dropItemStack(world, pos.getX(), pos.getY(), pos.getZ(), itemStack));
            world.setBlock(pos, Blocks.AIR.defaultBlockState(), 1);
        }
        return InteractionResult.sidedSuccess(world.isClientSide);
    }

    private List<ItemStack> getRecipeBoardDrop() {
        return ForgeRegistries.BLOCKS.getValues().stream().filter(block -> {
            if (block instanceof ApricotRecipeBlock) {
                return ((ApricotRecipeBlock) block).isAcquirableViaPackage();
            } else return false;
        }).map(block -> block.asItem().getDefaultInstance()).collect(Collectors.toList());
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public VoxelShape getShape(BlockState p_220053_1_, BlockGetter p_220053_2_, BlockPos p_220053_3_, CollisionContext p_220053_4_) {
        Direction dir = p_220053_1_.getValue(FACING);
        switch (dir) {
            case NORTH:
            case SOUTH:
                return N_S_SHAPE;
            default:
                return E_W_SHAPE;
        }
    }
}

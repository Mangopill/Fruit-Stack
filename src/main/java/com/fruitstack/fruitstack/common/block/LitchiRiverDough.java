package com.fruitstack.fruitstack.common.block;

import com.fruitstack.fruitstack.common.registry.ModItems;
import com.fruitstack.fruitstack.common.tag.ModTags;
import com.fruitstack.fruitstack.common.utility.TextUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class LitchiRiverDough extends Block
{ ;

	protected static final VoxelShape SHAPE = Block.box(4.0, 0.0, 3.0, 12.0, 4.0, 13.0);

	public LitchiRiverDough(Properties properties) {
		super(properties);
	}

	@Override
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
		ItemStack heldStack = player.getItemInHand(hand);
		ItemStack itemStack = new ItemStack(ModItems.LITCHI_RIVER_DOUGH.get());
		ItemStack itemStackTwo = new ItemStack(ModItems.LITCHI_RIVER_NOODLES.get());
			if (heldStack.isEmpty()) {
				level.removeBlock(pos, false);
				ItemEntity itemEntity = new ItemEntity((Level) level, pos.getX(), pos.getY() + 0.5, pos.getZ(), itemStack);
				level.addFreshEntity(itemEntity);
			}
			if (heldStack.is(ModTags.FRUIT_KNIVES)) {
				level.removeBlock(pos,false);
				ItemEntity itemEntityTwo = new ItemEntity((Level) level, pos.getX(), pos.getY() + 0.5, pos.getZ(), itemStackTwo);
				level.addFreshEntity(itemEntityTwo);
			}
			level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
			return InteractionResult.SUCCESS;
		}
	}

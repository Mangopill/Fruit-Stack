package com.fruitstack.fruitstack.common.block.entity;

import com.fruitstack.fruitstack.common.registry.*;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.items.ItemStackHandler;

public class PlateBlockEntity extends SyncedBlockEntity
{
	private static final VoxelShape GRILLING_AREA = Block.box(3.0F, 0.0F, 3.0F, 13.0F, 1.0F, 13.0F);
	private static final int INVENTORY_SLOT_COUNT = 1;

	private final ItemStackHandler inventory;

	public PlateBlockEntity(BlockPos pos, BlockState state) {
		super(ModBlockEntityTypes.PLATE.get(),  pos, state);
		inventory = createHandler();
	}
	public boolean addItem(ItemStack itemStackIn, int slot, Player player, InteractionHand hand) {
		if (0 <= slot && slot < inventory.getSlots()) {
			ItemStack heldStack = player.getItemInHand(hand);
			ItemStack slotStack = inventory.getStackInSlot(slot);
			int stackSize = heldStack.getCount();
			if (slotStack.isEmpty()) {
				inventory.setStackInSlot(slot, itemStackIn.copy());
				heldStack.shrink(stackSize);
				inventoryChanged();
				return true;
			}
		}
		return false;
	}

	public void giveItemShift(Player player) {
		ItemStack slotStack = inventory.getStackInSlot(0);
		if (!slotStack.isEmpty()) {
			int stackSize = slotStack.getCount(); // 获取物品堆叠的数量
			inventory.setStackInSlot(0, ItemStack.EMPTY); // 清空槽位物品
			ItemStack extractedStack = slotStack.copy(); // 创建一个新的 ItemStack，同时复制原始 ItemStack 的 NBT 数据
			extractedStack.setCount(stackSize); // 设置堆叠数量
			if (!player.getInventory().add(extractedStack)) {
				player.drop(extractedStack, false);
			}
			inventoryChanged();
		}
	}

	public void giveItem(Player player) {
		ItemStack slotStack = inventory.getStackInSlot(0);
		if (!slotStack.isEmpty()) {
			ItemStack extractedStack = new ItemStack(slotStack.getItem(), 1); // 创建一个只包含一个物品的新 ItemStack 对象
			extractedStack.setTag(slotStack.getTag()); // 将原始 ItemStack 的 NBT 数据复制到新对象中
			if (!player.getInventory().add(extractedStack)) {
				player.drop(extractedStack, false);
			}
			slotStack.setCount(slotStack.getCount() - 1);
			if (slotStack.getCount() <= 0) {
				inventory.setStackInSlot(0, ItemStack.EMPTY);
			}
			inventoryChanged();
		}
	}
	public void finishUsingItem(Player player) {
		ItemStack slotStack = inventory.getStackInSlot(0);
		if (!slotStack.isEmpty() && slotStack.getItem().isEdible()) {
			ItemStack extractedStack = new ItemStack(slotStack.getItem(), 1);
			player.eat(level , extractedStack);
			slotStack.setCount(slotStack.getCount() - 1);
			if (slotStack.getCount() <= 0) {
				inventory.setStackInSlot(0, ItemStack.EMPTY);
			}
			inventoryChanged();
		}
	}


	@Override
	public void load(CompoundTag compound) {
		super.load(compound);
		if (compound.contains("Inventory")) {
			inventory.deserializeNBT(compound.getCompound("Inventory"));
		} else {
			inventory.deserializeNBT(compound);
		}
	}

	private CompoundTag writeItems(CompoundTag compound) {
		super.saveAdditional(compound);
		compound.put("Inventory", inventory.serializeNBT());
		return compound;
	}

	public int getNextEmptySlot() {
		for (int i = 0; i < inventory.getSlots(); ++i) {
			ItemStack slotStack = inventory.getStackInSlot(i);
			if (slotStack.isEmpty()) {
				return i;
			}
		}
		return -1;
	}

	public ItemStackHandler getInventory() {
		return this.inventory;
	}
	public boolean isPlateBlockedAbove() {
		if (level != null) {
			BlockState above = level.getBlockState(worldPosition.above());
			return Shapes.joinIsNotEmpty(GRILLING_AREA, above.getShape(level, worldPosition.above()), BooleanOp.AND);
		}
		return false;
	}

	public Vec3 getPlateItemOffset(int index) {
		final Vec3[] OFFSETS = {
				new Vec3(0.0, 0.0, 0.0),
		};
		return OFFSETS[index];
	}
	@Override
	public CompoundTag getUpdateTag() {
		return writeItems(new CompoundTag());
	}

	private ItemStackHandler createHandler() {
		return new ItemStackHandler(INVENTORY_SLOT_COUNT)
		{
			@Override
			public int getSlotLimit(int slot) {
				return 64;
			}
		};
	}
}

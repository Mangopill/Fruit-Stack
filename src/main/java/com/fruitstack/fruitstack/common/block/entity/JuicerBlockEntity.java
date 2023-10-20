package com.fruitstack.fruitstack.common.block.entity;

import com.fruitstack.fruitstack.common.block.JuicerBlock;
import com.fruitstack.fruitstack.common.block.entity.container.JuicerBlockMenu;
import com.fruitstack.fruitstack.common.block.entity.inventory.JuicerItemHandler;
import com.fruitstack.fruitstack.common.block.state.JuicerStage;
import com.fruitstack.fruitstack.common.core.NewRecipeManager;
import com.fruitstack.fruitstack.common.crafting.JuicerRecipe;
import com.fruitstack.fruitstack.common.registry.*;
import com.fruitstack.fruitstack.common.utility.ItemUtils;
import com.fruitstack.fruitstack.common.utility.TextUtils;
import com.google.common.collect.Lists;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.Nameable;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeHolder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.RecipeWrapper;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static com.fruitstack.fruitstack.common.block.JuicerBlock.STAGE;
import static com.fruitstack.fruitstack.common.block.state.JuicerStage.*;

public class JuicerBlockEntity extends SyncedBlockEntity implements MenuProvider, HeatableBlockEntityTwo, Nameable, RecipeHolder
{
	public static final int MEAL_DISPLAY_SLOT = 3;
	public static final int CONTAINER_SLOT = 4;
	public static final int OUTPUT_SLOT = 5;
	public static final int INVENTORY_SIZE = OUTPUT_SLOT + 1;
	public static final EnumProperty<JuicerStage> STAGE = EnumProperty.create("stage", JuicerStage.class);

	private final ItemStackHandler inventory;
	private final LazyOptional<IItemHandler> inputHandler;
	private final LazyOptional<IItemHandler> outputHandler;

	private int cookTime;
	private int cookTimeTotal;
	private ItemStack mealContainerStack;
	private Component customName;

	protected final ContainerData tripodVesselForMakingPillsOfImmortalityData;
	private final Object2IntOpenHashMap<ResourceLocation> usedRecipeTracker;

	private ResourceLocation lastRecipeID;
	private boolean checkNewRecipe;

	public JuicerBlockEntity(BlockPos pos, BlockState state) {
		super(ModBlockEntityTypes.JUICER.get(), pos, state);
		this.inventory = createHandler();
		this.inputHandler = LazyOptional.of(() -> new JuicerItemHandler(inventory, Direction.UP));
		this.outputHandler = LazyOptional.of(() -> new JuicerItemHandler(inventory, Direction.DOWN));
		this.mealContainerStack = ItemStack.EMPTY;
		this.tripodVesselForMakingPillsOfImmortalityData = createIntArray();
		this.usedRecipeTracker = new Object2IntOpenHashMap<>();
		this.checkNewRecipe = true;
	}

	public static ItemStack getMealFromItem(ItemStack tripodVesselForMakingPillsOfImmortalityStack) {
		if (!tripodVesselForMakingPillsOfImmortalityStack.is(ModItems.JUICER.get())) {
			return ItemStack.EMPTY;
		}

		CompoundTag compound = tripodVesselForMakingPillsOfImmortalityStack.getTagElement("BlockEntityTag");
		if (compound != null) {
			CompoundTag inventoryTag = compound.getCompound("Inventory");
			if (inventoryTag.contains("Items", 4)) {
				ItemStackHandler handler = new ItemStackHandler();
				handler.deserializeNBT(inventoryTag);
				return handler.getStackInSlot(3);
			}
		}

		return ItemStack.EMPTY;
	}

	public static void takeServingFromItem(ItemStack tripodVesselForMakingPillsOfImmortalityStack) {
		if (!tripodVesselForMakingPillsOfImmortalityStack.is(ModItems.JUICER.get())) {
			return;
		}

		CompoundTag compound = tripodVesselForMakingPillsOfImmortalityStack.getTagElement("BlockEntityTag");
		if (compound != null) {
			CompoundTag inventoryTag = compound.getCompound("Inventory");
			if (inventoryTag.contains("Items", 4)) {
				ItemStackHandler handler = new ItemStackHandler();
				handler.deserializeNBT(inventoryTag);
				ItemStack newMealStack = handler.getStackInSlot(3);
				newMealStack.shrink(1);
				compound.remove("Inventory");
				compound.put("Inventory", handler.serializeNBT());
			}
		}
	}

	public static ItemStack getContainerFromItem(ItemStack tripodVesselForMakingPillsOfImmortalityStack) {
		if (!tripodVesselForMakingPillsOfImmortalityStack.is(ModItems.JUICER.get())) {
			return ItemStack.EMPTY;
		}

		CompoundTag compound = tripodVesselForMakingPillsOfImmortalityStack.getTagElement("BlockEntityTag");
		if (compound != null) {
			return ItemStack.of(compound.getCompound("Container"));
		}

		return ItemStack.EMPTY;
	}

	@Override
	public void load(CompoundTag compound) {
		super.load(compound);
		inventory.deserializeNBT(compound.getCompound("Inventory"));
		cookTime = compound.getInt("CookTime");
		cookTimeTotal = compound.getInt("CookTimeTotal");
		mealContainerStack = ItemStack.of(compound.getCompound("Container"));
		if (compound.contains("CustomName", 3)) {
			customName = Component.Serializer.fromJson(compound.getString("CustomName"));
		}
		CompoundTag compoundRecipes = compound.getCompound("RecipesUsed");
		for (String key : compoundRecipes.getAllKeys()) {
			usedRecipeTracker.put(new ResourceLocation(key), compoundRecipes.getInt(key));
		}
	}

	@Override
	public void saveAdditional(CompoundTag compound) {
		super.saveAdditional(compound);
		compound.putInt("CookTime", cookTime);
		compound.putInt("CookTimeTotal", cookTimeTotal);
		compound.put("Container", mealContainerStack.serializeNBT());
		if (customName != null) {
			compound.putString("CustomName", Component.Serializer.toJson(customName));
		}
		compound.put("Inventory", inventory.serializeNBT());
		CompoundTag compoundRecipes = new CompoundTag();
		usedRecipeTracker.forEach((recipeId, craftedAmount) -> compoundRecipes.putInt(recipeId.toString(), craftedAmount));
		compound.put("RecipesUsed", compoundRecipes);
	}

	private CompoundTag writeItems(CompoundTag compound) {
		super.saveAdditional(compound);
		compound.put("Container", mealContainerStack.serializeNBT());
		compound.put("Inventory", inventory.serializeNBT());
		return compound;
	}

	public CompoundTag writeMeal(CompoundTag compound) {
		if (getMeal().isEmpty()) return compound;

		ItemStackHandler drops = new ItemStackHandler(INVENTORY_SIZE);
		for (int i = 0; i < INVENTORY_SIZE; ++i) {
			drops.setStackInSlot(i, i == MEAL_DISPLAY_SLOT ? inventory.getStackInSlot(i) : ItemStack.EMPTY);
		}
		if (customName != null) {
			compound.putString("CustomName", Component.Serializer.toJson(customName));
		}
		compound.put("Container", mealContainerStack.serializeNBT());
		compound.put("Inventory", drops.serializeNBT());
		return compound;
	}

	public static void cookingTick(Level level, BlockPos pos, BlockState state, JuicerBlockEntity tripodVesselForMakingPillsOfImmortality) {
		boolean isHeated = tripodVesselForMakingPillsOfImmortality.isHeated(level, pos);
		boolean didInventoryChange = false;
		BlockState originalState = level.getBlockState(pos); // 保存原始的锅方块状态

		if (isHeated && tripodVesselForMakingPillsOfImmortality.hasInput()) {
			Optional<JuicerRecipe> recipe = tripodVesselForMakingPillsOfImmortality.getMatchingRecipe(new RecipeWrapper(tripodVesselForMakingPillsOfImmortality.inventory));
			if (recipe.isPresent() && tripodVesselForMakingPillsOfImmortality.canCook(recipe.get())) {
				didInventoryChange = tripodVesselForMakingPillsOfImmortality.processCooking(recipe.get(), tripodVesselForMakingPillsOfImmortality);
			} else {
				tripodVesselForMakingPillsOfImmortality.cookTime = 0;
			}
		} else if (tripodVesselForMakingPillsOfImmortality.cookTime > 0) {
			tripodVesselForMakingPillsOfImmortality.cookTime = Mth.clamp(tripodVesselForMakingPillsOfImmortality.cookTime - 2, 0, tripodVesselForMakingPillsOfImmortality.cookTimeTotal);
		}

		ItemStack mealStack = tripodVesselForMakingPillsOfImmortality.getMeal();
		if (!mealStack.isEmpty()) {
			if (!tripodVesselForMakingPillsOfImmortality.doesMealHaveContainer(mealStack)) {
				tripodVesselForMakingPillsOfImmortality.moveMealToOutput();
				didInventoryChange = true;
			} else if (!tripodVesselForMakingPillsOfImmortality.inventory.getStackInSlot(CONTAINER_SLOT).isEmpty()) {
				tripodVesselForMakingPillsOfImmortality.useStoredContainersOnMeal();
				didInventoryChange = true;
			}
		}

		if (didInventoryChange) {
			tripodVesselForMakingPillsOfImmortality.inventoryChanged();
		}
		if (level.getBlockState(pos).getBlock() == ModBlocks.JUICER.get()) {
			if (tripodVesselForMakingPillsOfImmortality.cookTime >= tripodVesselForMakingPillsOfImmortality.cookTimeTotal) {
				level.setBlockAndUpdate(pos, originalState.setValue(STAGE, JuicerStage.OVER));
			}
// 在锅烹饪时将锅方块状态设置为STIR
			if (isHeated && tripodVesselForMakingPillsOfImmortality.cookTimeTotal > 0 && tripodVesselForMakingPillsOfImmortality.cookTime < tripodVesselForMakingPillsOfImmortality.cookTimeTotal) {
				level.setBlockAndUpdate(pos, originalState.setValue(STAGE, JuicerStage.STIR));
			}
// 在锅烹饪完成后将锅方块状态设置为OVER
			else if (tripodVesselForMakingPillsOfImmortality.cookTimeTotal > 0 && tripodVesselForMakingPillsOfImmortality.cookTime == tripodVesselForMakingPillsOfImmortality.cookTimeTotal) {
				level.setBlockAndUpdate(pos, originalState.setValue(STAGE, JuicerStage.OVER));
			}
// 在取出食物后将锅方块状态恢复为初始状态
			else if (mealStack.isEmpty()) {
				level.setBlockAndUpdate(pos, originalState.setValue(STAGE, JuicerStage.NONE));
			}
		}
	}
	private Optional<JuicerRecipe> getMatchingRecipe(RecipeWrapper inventoryWrapper) {
		if (level == null) return Optional.empty();

		if (lastRecipeID != null) {
			NewRecipeManager recipeManager = new NewRecipeManager();
			Recipe<RecipeWrapper> recipe = recipeManager.fruitstack_invokeGetRecipeMap(ModRecipeTypes.JUICER.get())
					.get(lastRecipeID);
			if (recipe instanceof JuicerRecipe) {
				if (recipe.matches(inventoryWrapper, level)) {
					return Optional.of((JuicerRecipe) recipe);
				}
				if (recipe.getResultItem().sameItem(getMeal())) {
					return Optional.empty();
				}
			}
		}

		if (checkNewRecipe) {
			Optional<JuicerRecipe> recipe = level.getRecipeManager().getRecipeFor(ModRecipeTypes.JUICER.get(), inventoryWrapper, level);
			if (recipe.isPresent()) {
				lastRecipeID = recipe.get().getId();
				return recipe;
			}
		}

		checkNewRecipe = false;
		return Optional.empty();
	}

	public ItemStack getContainer() {
		if (!mealContainerStack.isEmpty()) {
			return mealContainerStack;
		} else {
			return getMeal().getContainerItem();
		}
	}

	private boolean hasInput() {
		for (int i = 0; i < MEAL_DISPLAY_SLOT; ++i) {
			if (!inventory.getStackInSlot(i).isEmpty()) return true;
		}
		return false;
	}

	protected boolean canCook(JuicerRecipe recipe) {
		if (hasInput()) {
			ItemStack resultStack = recipe.getResultItem();
			if (resultStack.isEmpty()) {
				return false;
			} else {
				ItemStack storedMealStack = inventory.getStackInSlot(MEAL_DISPLAY_SLOT);
				if (storedMealStack.isEmpty()) {
					return true;
				} else if (!storedMealStack.sameItem(resultStack)) {
					return false;
				} else if (storedMealStack.getCount() + resultStack.getCount() <= inventory.getSlotLimit(MEAL_DISPLAY_SLOT)) {
					return true;
				} else {
					return storedMealStack.getCount() + resultStack.getCount() <= resultStack.getMaxStackSize();
				}
			}
		} else {
			return false;
		}
	}

	private boolean processCooking(JuicerRecipe recipe, JuicerBlockEntity tripodVesselForMakingPillsOfImmortality) {
		if (level == null) return false;

		++cookTime;
		cookTimeTotal = recipe.getCookTime();
		if (cookTime < cookTimeTotal) {
			return false;
		}

		cookTime = 0;
		mealContainerStack = recipe.getOutputContainer();
		ItemStack resultStack = recipe.getResultItem();
		ItemStack storedMealStack = inventory.getStackInSlot(MEAL_DISPLAY_SLOT);
		if (storedMealStack.isEmpty()) {
			inventory.setStackInSlot(MEAL_DISPLAY_SLOT, resultStack.copy());
		} else if (storedMealStack.sameItem(resultStack)) {
			storedMealStack.grow(resultStack.getCount());
		}
		tripodVesselForMakingPillsOfImmortality.setRecipeUsed(recipe);

		for (int i = 0; i < MEAL_DISPLAY_SLOT; ++i) {
			ItemStack slotStack = inventory.getStackInSlot(i);
			if (slotStack.hasContainerItem()) {
				Direction direction = getBlockState().getValue(JuicerBlock.FACING).getCounterClockWise();
				double x = worldPosition.getX() + 0.5 + (direction.getStepX() * 0.25);
				double y = worldPosition.getY() + 0.7;
				double z = worldPosition.getZ() + 0.5 + (direction.getStepZ() * 0.25);
				ItemUtils.spawnItemEntity(level, inventory.getStackInSlot(i).getContainerItem(), x, y, z,
						direction.getStepX() * 0.08F, 0.25F, direction.getStepZ() * 0.08F);
			}
			if (!slotStack.isEmpty())
				slotStack.shrink(1);
		}
		return true;
	}

	@Override
	public void setRecipeUsed(@Nullable Recipe<?> recipe) {
		if (recipe != null) {
			ResourceLocation recipeID = recipe.getId();
			usedRecipeTracker.addTo(recipeID, 1);
		}
	}

	@Nullable
	@Override
	public Recipe<?> getRecipeUsed() {
		return null;
	}

	@Override
	public void awardUsedRecipes(Player player) {
		List<Recipe<?>> usedRecipes = getUsedRecipesAndPopExperience(player.level, player.position());
		player.awardRecipes(usedRecipes);
		usedRecipeTracker.clear();
	}

	public List<Recipe<?>> getUsedRecipesAndPopExperience(Level level, Vec3 pos) {
		List<Recipe<?>> list = Lists.newArrayList();

		for (Object2IntMap.Entry<ResourceLocation> entry : usedRecipeTracker.object2IntEntrySet()) {
			level.getRecipeManager().byKey(entry.getKey()).ifPresent((recipe) -> {
				list.add(recipe);
				splitAndSpawnExperience((ServerLevel) level, pos, entry.getIntValue(), ((JuicerRecipe) recipe).getExperience());
			});
		}

		return list;
	}

	private static void splitAndSpawnExperience(ServerLevel level, Vec3 pos, int craftedAmount, float experience) {
		int expTotal = Mth.floor((float) craftedAmount * experience);
		float expFraction = Mth.frac((float) craftedAmount * experience);
		if (expFraction != 0.0F && Math.random() < (double) expFraction) {
			++expTotal;
		}

		ExperienceOrb.award(level, pos, expTotal);
	}

	public boolean isHeated() {
		if (level == null) return false;
		return this.isHeated(level, worldPosition);
	}

	public ItemStackHandler getInventory() {
		return inventory;
	}

	public ItemStack getMeal() {
		return inventory.getStackInSlot(MEAL_DISPLAY_SLOT);
	}

	public NonNullList<ItemStack> getDroppableInventory() {
		NonNullList<ItemStack> drops = NonNullList.create();
		for (int i = 0; i < INVENTORY_SIZE; ++i) {
			if (i != MEAL_DISPLAY_SLOT) {
				drops.add(inventory.getStackInSlot(i));
			}
		}
		return drops;
	}

	private void moveMealToOutput() {
		ItemStack mealStack = inventory.getStackInSlot(MEAL_DISPLAY_SLOT);
		ItemStack outputStack = inventory.getStackInSlot(OUTPUT_SLOT);
		int mealCount = Math.min(mealStack.getCount(), mealStack.getMaxStackSize() - outputStack.getCount());
		if (outputStack.isEmpty()) {
			inventory.setStackInSlot(OUTPUT_SLOT, mealStack.split(mealCount));
		} else if (outputStack.getItem() == mealStack.getItem()) {
			mealStack.shrink(mealCount);
			outputStack.grow(mealCount);
		}
	}

	private void useStoredContainersOnMeal() {
		ItemStack mealStack = inventory.getStackInSlot(MEAL_DISPLAY_SLOT);
		ItemStack containerInputStack = inventory.getStackInSlot(CONTAINER_SLOT);
		ItemStack outputStack = inventory.getStackInSlot(OUTPUT_SLOT);

		if (isContainerValid(containerInputStack) && outputStack.getCount() < outputStack.getMaxStackSize()) {
			int smallerStackCount = Math.min(mealStack.getCount(), containerInputStack.getCount());
			int mealCount = Math.min(smallerStackCount, mealStack.getMaxStackSize() - outputStack.getCount());
			if (outputStack.isEmpty()) {
				containerInputStack.shrink(mealCount);
				inventory.setStackInSlot(OUTPUT_SLOT, mealStack.split(mealCount));
			} else if (outputStack.getItem() == mealStack.getItem()) {
				mealStack.shrink(mealCount);
				containerInputStack.shrink(mealCount);
				outputStack.grow(mealCount);
			}
		}
	}

	public ItemStack useHeldItemOnMeal(ItemStack container) {
		if (isContainerValid(container) && !getMeal().isEmpty()) {
			container.shrink(1);
			return getMeal().split(1);
		}
		return ItemStack.EMPTY;
	}

	private boolean doesMealHaveContainer(ItemStack meal) {
		return !mealContainerStack.isEmpty() || meal.hasContainerItem();
	}

	public boolean isContainerValid(ItemStack containerItem) {
		if (containerItem.isEmpty()) return false;
		if (!mealContainerStack.isEmpty()) {
			return mealContainerStack.sameItem(containerItem);
		} else {
			return getMeal().getContainerItem().sameItem(containerItem);
		}
	}

	@Override
	public Component getName() {
		return customName != null ? customName : TextUtils.getTranslation("container.juicer");
	}

	@Override
	public Component getDisplayName() {
		return getName();
	}

	@Override
	@Nullable
	public Component getCustomName() {
		return customName;
	}

	public void setCustomName(Component name) {
		customName = name;
	}

	@Override
	public AbstractContainerMenu createMenu(int id, Inventory player, Player entity) {
		return new JuicerBlockMenu(id, player, this, tripodVesselForMakingPillsOfImmortalityData);
	}

	@Override
	@Nonnull
	public <T> LazyOptional<T> getCapability(Capability<T> cap, @Nullable Direction side) {
		if (cap.equals(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)) {
			if (side == null || side.equals(Direction.UP)) {
				return inputHandler.cast();
			} else {
				return outputHandler.cast();
			}
		}
		return super.getCapability(cap, side);
	}

	@Override
	public void setRemoved() {
		super.setRemoved();
		inputHandler.invalidate();
		outputHandler.invalidate();
	}

	@Override
	public CompoundTag getUpdateTag() {
		return writeItems(new CompoundTag());
	}

	private ItemStackHandler createHandler() {
		return new ItemStackHandler(INVENTORY_SIZE)
		{
			@Override
			protected void onContentsChanged(int slot) {
				if (slot >= 0 && slot < MEAL_DISPLAY_SLOT) {
					checkNewRecipe = true;
				}
				inventoryChanged();
			}
		};
	}

	private ContainerData createIntArray() {
		return new ContainerData()
		{
			@Override
			public int get(int index) {
				return switch (index) {
					case 0 -> JuicerBlockEntity.this.cookTime;
					case 1 -> JuicerBlockEntity.this.cookTimeTotal;
					default -> 0;
				};
			}

			@Override
			public void set(int index, int value) {
				switch (index) {
					case 0 -> JuicerBlockEntity.this.cookTime = value;
					case 1 -> JuicerBlockEntity.this.cookTimeTotal = value;
				}
			}

			@Override
			public int getCount() {
				return 2;
			}
		};
	}
	public Vec3 getJuicerItemOffset(int index) {
		final Vec3[] OFFSETS = {
				new Vec3(0.0, 0.0, 0.0),
				new Vec3(0.0, 0.0, 0.0),
				new Vec3(0.0, 0.0, 0.0),
				new Vec3(0.0, 0.0, 0.0),
				new Vec3(0.0, 0.0, 0.0),
				new Vec3(0.0, 0.0, 0.0),
		};
		return OFFSETS[index];
	}
}
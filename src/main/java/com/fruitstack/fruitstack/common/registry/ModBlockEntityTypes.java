package com.fruitstack.fruitstack.common.registry;

import com.fruitstack.fruitstack.common.block.entity.*;
import com.fruitstack.fruitstack.fruitstack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModBlockEntityTypes
{
	public static final DeferredRegister<BlockEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, fruitstack.MODID);

	public static final RegistryObject<BlockEntityType<ClayOvenBlockEntity>> CLAY_OVEN = TILES.register("clay_oven",
			() -> BlockEntityType.Builder.of(ClayOvenBlockEntity::new, ModBlocks.CLAY_OVEN.get()).build(null));
	public static final RegistryObject<BlockEntityType<TvfmpoitBlockEntity>> TRIPOD_VESSEL_FOR_MAKING_PILLS_OF_IMMORTALITY = TILES.register("tripod_vessel_for_making_pills_of_immortality",
			() -> BlockEntityType.Builder.of(TvfmpoitBlockEntity::new, ModBlocks.TRIPOD_VESSEL_FOR_MAKING_PILLS_OF_IMMORTALITY.get()).build(null));
	public static final RegistryObject<BlockEntityType<JuicerBlockEntity>> JUICER = TILES.register("juicer",
			() -> BlockEntityType.Builder.of(JuicerBlockEntity::new, ModBlocks.JUICER.get()).build(null));
	public static final RegistryObject<BlockEntityType<PlateBlockEntity>> PLATE = TILES.register("plate",
			() -> BlockEntityType.Builder.of(PlateBlockEntity::new, ModBlocks.PLATE.get()).build(null));
	public static final RegistryObject<BlockEntityType<BowlBlockEntity>> BOWL_BLOCK = TILES.register("bowl_block",
			() -> BlockEntityType.Builder.of(BowlBlockEntity::new, ModBlocks.BOWL_BLOCK.get()).build(null));
}

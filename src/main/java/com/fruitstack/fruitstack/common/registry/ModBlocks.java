package com.fruitstack.fruitstack.common.registry;

import com.fruitstack.fruitstack.common.FoodValues;
import com.fruitstack.fruitstack.common.block.*;
import com.fruitstack.fruitstack.common.block.PitayaRecipeBlock;
import com.fruitstack.fruitstack.common.block.PitayaRecipePackageBlock;
import com.fruitstack.fruitstack.fruitstack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.lwjgl.system.CallbackI;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

import static com.fruitstack.fruitstack.common.registry.ModItems.ITEMS;
import static org.jline.utils.Signals.register;

public class ModBlocks {
	private static ToIntFunction<BlockState> litBlockEmission(int lightValue) {
		return (state) -> state.getValue(BlockStateProperties.LIT) ? lightValue : 0;
	}
	private static Boolean ocelotOrParrot(BlockState state, BlockGetter world, BlockPos pos, EntityType<?> entityType)
	{
		return entityType == EntityType.OCELOT || entityType == EntityType.PARROT;
	}
	private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> supplier, CreativeModeTab tab)
	{
		RegistryObject<T> block = BLOCKS.register(name, supplier);
		ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
		return block;
	}
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, fruitstack.MODID);
	//core food
	public static final RegistryObject<Block> CHINESE_SPIRITS_BARREL = BLOCKS.register("chinese_spirits_barrel",
			() -> new FruitWineBarrelBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(0.5F, 3.0F), ModItems.CHINESE_SPIRITS_ONE, ModItems.CHINESE_SPIRITS_TWO, ModItems.CHINESE_SPIRITS_THREE, ModItems.CHINESE_SPIRITS_FOUR, ModItems.CHINESE_SPIRITS_FIVE, ModItems.CHINESE_SPIRITS_SIX, ModItems.CHINESE_SPIRITS_SEVEN, ModItems.CHINESE_SPIRITS_EIGHT, ModItems.CHINESE_SPIRITS_NINE, ModItems.CHINESE_SPIRITS_TEN, ModItems.CHINESE_SPIRITS_TEN));
	//blueberries
	public static final RegistryObject<Block> BLUEBERRIES_CROP = BLOCKS.register("blueberries",
			() -> new BlueberriesBlock(Block.Properties.copy(Blocks.WHEAT)));
	public static final RegistryObject<Block> BLUEBERRIES_CAKE = BLOCKS.register("blueberries_cake",
			() -> new ModCakeBlock(Block.Properties.copy(Blocks.CAKE), ModItems.BLUEBERRIES_CAKE_SLICE));
	public static final RegistryObject<Block> BLUEBERRIES_PIE = BLOCKS.register("blueberries_pie",
			() -> new PieBlock(Block.Properties.copy(Blocks.CAKE), ModItems.BLUEBERRIES_PIE_SLICE));
	public static final RegistryObject<Block> BLUEBERRIES_CRATE = BLOCKS.register("blueberries_crate",
			() -> new Block(Block.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> WILD_BLUEBERRIES = BLOCKS.register("wild_blueberries",
			() -> new WildCropBlock(MobEffects.DAMAGE_BOOST, 6, Block.Properties.copy(Blocks.TALL_GRASS)));
	public static final RegistryObject<Block> BLUEBERRIES_JAM = BLOCKS.register("blueberries_jam",
			() -> new JamBlock(Block.Properties.copy(Blocks.GLASS), ModItems.BLUEBERRIES_BREAD, ModItems.BLUEBERRIES_DOUGHNUT,true));
	public static final RegistryObject<Block> SWEETENED_BLUEBERRIES = BLOCKS.register("sweetened_blueberries",
			() -> new DriedFruit(BlockBehaviour.Properties.of(Material.SNOW).strength(0.5F, 3.0F),ModItems.DRIED_BLUEBERRIES));
	public static final RegistryObject<Block> BLUEBERRIES_WINE_BARREL = BLOCKS.register("blueberries_wine_barrel",
			() -> new FruitWineBarrelBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(0.5F, 3.0F), ModItems.BLUEBERRIES_WINE_ONE, ModItems.BLUEBERRIES_WINE_TWO, ModItems.BLUEBERRIES_WINE_THREE, ModItems.BLUEBERRIES_WINE_FOUR, ModItems.BLUEBERRIES_WINE_FIVE, ModItems.BLUEBERRIES_WINE_SIX, ModItems.BLUEBERRIES_WINE_SEVEN, ModItems.BLUEBERRIES_WINE_EIGHT, ModItems.BLUEBERRIES_WINE_NINE, ModItems.BLUEBERRIES_WINE_TEN, ModItems.BEST_BLUEBERRIES_WINE));
	public static final RegistryObject<Block> BLUEBERRIES_POPSICLE_MACHINE = BLOCKS.register("blueberries_popsicle_machine",
			() -> new FruitPopsicleMachineBlock(BlockBehaviour.Properties.of(Material.METAL).strength(0.5F, 6.0F), ModItems.BLUEBERRIES_POPSICLE));
	//hamimelon
	public static final RegistryObject<Block> HAMIMELON_CROP = BLOCKS.register("hamimelon",
			() -> new HaMiMelonBlock(Block.Properties.copy(Blocks.WHEAT)));
	public static final RegistryObject<Block> HAMIMELON_SAGO_SOUP_BLOCK = BLOCKS.register("hamimelon_sago_soup_block",
			() -> new ThreeFeastBlock(Block.Properties.copy(Blocks.PUMPKIN), ModItems.HAMIMELON_SAGO_SOUP, false));
	public static final RegistryObject<Block> WILD_HAMIMELON = BLOCKS.register("wild_hamimelon",
			() -> new WildCropBlock(MobEffects.DAMAGE_BOOST, 6, Block.Properties.copy(Blocks.TALL_GRASS)));
	public static final RegistryObject<Block> HAMIMELON_CAKE = BLOCKS.register("hamimelon_cake",
			() -> new ModCakeBlock(Block.Properties.copy(Blocks.CAKE), ModItems.HAMIMELON_CAKE_SLICE));
	public static final RegistryObject<Block> HAMIMELON_PIE = BLOCKS.register("hamimelon_pie",
			() -> new PieBlock(Block.Properties.copy(Blocks.CAKE), ModItems.HAMIMELON_PIE_SLICE));
	public static final RegistryObject<Block> HAMIMELON_CRATE = BLOCKS.register("hamimelon_crate",
			() -> new Block(Block.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> HAMIMELON_JAM = BLOCKS.register("hamimelon_jam",
			() -> new JamBlock(Block.Properties.copy(Blocks.GLASS), ModItems.HAMIMELON_BREAD, ModItems.HAMIMELON_DOUGHNUT,true));
	public static final RegistryObject<Block> SWEETENED_HAMIMELON = BLOCKS.register("sweetened_hamimelon",
			() -> new DriedFruit(BlockBehaviour.Properties.of(Material.SNOW).strength(0.5F, 3.0F),ModItems.DRIED_HAMIMELON));
	public static final RegistryObject<Block> HAMIMELON_WINE_BARREL = BLOCKS.register("hamimelon_wine_barrel",
			() -> new FruitWineBarrelBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(0.5F, 3.0F), ModItems.HAMIMELON_WINE_ONE, ModItems.HAMIMELON_WINE_TWO, ModItems.HAMIMELON_WINE_THREE, ModItems.HAMIMELON_WINE_FOUR, ModItems.HAMIMELON_WINE_FIVE, ModItems.HAMIMELON_WINE_SIX, ModItems.HAMIMELON_WINE_SEVEN, ModItems.HAMIMELON_WINE_EIGHT, ModItems.HAMIMELON_WINE_NINE, ModItems.HAMIMELON_WINE_TEN, ModItems.BEST_HAMIMELON_WINE));
	public static final RegistryObject<Block> HAMIMELON_POPSICLE_MACHINE = BLOCKS.register("hamimelon_popsicle_machine",
			() -> new FruitPopsicleMachineBlock(BlockBehaviour.Properties.of(Material.METAL).strength(0.5F, 6.0F), ModItems.HAMIMELON_POPSICLE));
	//beating melons
	public static final RegistryObject<Block> BEATING_MELONS_CROP = BLOCKS.register("beating_melons_crop",
			() -> new BeatingMelonsBlock(Block.Properties.copy(Blocks.WHEAT)));
	public static final RegistryObject<Block> WILD_BEATING_MELONS = BLOCKS.register("wild_beating_melons",
			() -> new WildCropBlock(MobEffects.DAMAGE_BOOST, 6, Block.Properties.copy(Blocks.TALL_GRASS)));
	public static final RegistryObject<Block> BEATING_MELONS_CAKE = BLOCKS.register("beating_melons_cake",
			() -> new ModCakeBlock(Block.Properties.copy(Blocks.CAKE), ModItems.BEATING_MELONS_CAKE_SLICE));
	public static final RegistryObject<Block> BEATING_MELONS_PIE = BLOCKS.register("beating_melons_pie",
			() -> new PieBlock(Block.Properties.copy(Blocks.CAKE), ModItems.BEATING_MELONS_PIE_SLICE));
	public static final RegistryObject<Block> BEATING_MELONS_CRATE = BLOCKS.register("beating_melons_crate",
			() -> new Block(Block.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> BEATING_MELONS_JAM = BLOCKS.register("beating_melons_jam",
			() -> new JamBlock(Block.Properties.copy(Blocks.GLASS), ModItems.BEATING_MELONS_BREAD, ModItems.BEATING_MELONS_DOUGHNUT,true));
	public static final RegistryObject<Block> STIR_FRIED_BEATING_MELONS_SEEDS = BLOCKS.register("stir_fried_beating_melons_seeds",
			() -> new DriedFruit(BlockBehaviour.Properties.of(Material.SNOW).strength(0.5F, 3.0F),ModItems.DRIED_BEATING_MELONS_SEEDS));
	public static final RegistryObject<Block> BEATING_MELONS_WINE_BARREL = BLOCKS.register("beating_melons_wine_barrel",
			() -> new FruitWineBarrelBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(0.5F, 3.0F), ModItems.BEATING_MELONS_WINE_ONE, ModItems.BEATING_MELONS_WINE_TWO, ModItems.BEATING_MELONS_WINE_THREE, ModItems.BEATING_MELONS_WINE_FOUR, ModItems.BEATING_MELONS_WINE_FIVE, ModItems.BEATING_MELONS_WINE_SIX, ModItems.BEATING_MELONS_WINE_SEVEN, ModItems.BEATING_MELONS_WINE_EIGHT, ModItems.BEATING_MELONS_WINE_NINE, ModItems.BEATING_MELONS_WINE_TEN, ModItems.BEST_BEATING_MELONS_WINE));
	public static final RegistryObject<Block> BEATING_MELONS_POPSICLE_MACHINE = BLOCKS.register("beating_melons_popsicle_machine",
			() -> new FruitPopsicleMachineBlock(BlockBehaviour.Properties.of(Material.METAL).strength(0.5F, 6.0F), ModItems.BEATING_MELONS_POPSICLE));
	//ground cucumber
	public static final RegistryObject<Block> GROUND_CUCUMBER = BLOCKS.register("ground_cucumber",
			() -> new CanMineFruitBlock(Block.Properties.copy(Blocks.PUMPKIN), ModItems.GROUND_CUCUMBER_SLICE, false));
	public static final RegistryObject<Block> GROUND_CUCUMBER_CROP = BLOCKS.register("ground_cucumber_crop",
			() -> new GroundCucumberBlock(Block.Properties.copy(Blocks.WHEAT)));
	public static final RegistryObject<Block> WILD_GROUND_CUCUMBER = BLOCKS.register("wild_ground_cucumber",
			() -> new WildCropBlock(MobEffects.DAMAGE_BOOST, 6, Block.Properties.copy(Blocks.TALL_GRASS)));
	public static final RegistryObject<Block> GROUND_CUCUMBER_CAKE = BLOCKS.register("ground_cucumber_cake",
			() -> new ModCakeBlock(Block.Properties.copy(Blocks.CAKE), ModItems.GROUND_CUCUMBER_CAKE_SLICE));
	public static final RegistryObject<Block> GROUND_CUCUMBER_PIE = BLOCKS.register("ground_cucumber_pie",
			() -> new PieBlock(Block.Properties.copy(Blocks.CAKE), ModItems.GROUND_CUCUMBER_PIE_SLICE));
	public static final RegistryObject<Block> GROUND_CUCUMBER_CRATE = BLOCKS.register("ground_cucumber_crate",
			() -> new Block(Block.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> GROUND_CUCUMBER_JAM = BLOCKS.register("ground_cucumber_jam",
			() -> new JamBlock(Block.Properties.copy(Blocks.GLASS), ModItems.GROUND_CUCUMBER_BREAD, ModItems.GROUND_CUCUMBER_DOUGHNUT,true));
	public static final RegistryObject<Block> GROUND_CUCUMBER_WINE_BARREL = BLOCKS.register("ground_cucumber_wine_barrel",
			() -> new FruitWineBarrelBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(0.5F, 3.0F), ModItems.GROUND_CUCUMBER_WINE_ONE, ModItems.GROUND_CUCUMBER_WINE_TWO, ModItems.GROUND_CUCUMBER_WINE_THREE, ModItems.GROUND_CUCUMBER_WINE_FOUR, ModItems.GROUND_CUCUMBER_WINE_FIVE, ModItems.GROUND_CUCUMBER_WINE_SIX, ModItems.GROUND_CUCUMBER_WINE_SEVEN, ModItems.GROUND_CUCUMBER_WINE_EIGHT, ModItems.GROUND_CUCUMBER_WINE_NINE, ModItems.GROUND_CUCUMBER_WINE_TEN, ModItems.BEST_GROUND_CUCUMBER_WINE));
	public static final RegistryObject<Block> GROUND_CUCUMBER_POPSICLE_MACHINE = BLOCKS.register("ground_cucumber_popsicle_machine",
			() -> new FruitPopsicleMachineBlock(BlockBehaviour.Properties.of(Material.METAL).strength(0.5F, 6.0F), ModItems.GROUND_CUCUMBER_POPSICLE));
	//mango
	public static final RegistryObject<Block> MANGO_BLOCK = BLOCKS.register("mango_block",
			() -> new CanMineFruitBlock(Block.Properties.copy(Blocks.PUMPKIN), ModItems.MANGO_SLICE, true));
	public static final RegistryObject<Block> GREEN_MANGO_BLOCK = BLOCKS.register("green_mango_block",
			() -> new CanMineFruitBlock(Block.Properties.copy(Blocks.PUMPKIN), ModItems.GREEN_MANGO_SLICE,true));
	public static final RegistryObject<Block> MANGO_SAPLING = BLOCKS.register("mango_sapling",
	() -> new MangoSapling(Block.Properties.of(Material.PLANT)
				.noCollission().randomTicks().strength(0f).sound(SoundType.CROP), 1));
	public static final RegistryObject<Block> MANGO_LOG_BIG = register("mango_log_big",
			() -> new LogBlock(BlockBehaviour.Properties.of(Material.WOOD, state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.WOOD : MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD)), fruitstack.CREATIVE_TAB);
	public static final RegistryObject<Block> MANGO_LOG_MEDIUM = register("mango_log_medium",
			() -> new LogBlock(BlockBehaviour.Properties.of(Material.WOOD, state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.WOOD : MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD)), fruitstack.CREATIVE_TAB);
	public static final RegistryObject<Block> MANGO_LOG_SMALL = register("mango_log_small",
			() -> new LogBlock(BlockBehaviour.Properties.of(Material.WOOD, state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.WOOD : MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD)), fruitstack.CREATIVE_TAB);
	public static final RegistryObject<Block> MANGO_LOG_TOP = register("mango_log_top",
			() -> new LogBlock(BlockBehaviour.Properties.of(Material.WOOD, state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.WOOD : MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD)), fruitstack.CREATIVE_TAB);
	public static final RegistryObject<Block> MANGO_LEAVES = register("mango_leaves",
			() -> new ModLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(ModBlocks::ocelotOrParrot).isSuffocating((a, b, c) -> false).isViewBlocking((a, b, c) -> false)), fruitstack.CREATIVE_TAB);
	public static final RegistryObject<BlockFruitCrop> MANGO_CROP = BLOCKS.register("mango_crop",
			() -> new BlockFruitCrop(Block.Properties.of(Material.PLANT).strength(5F)
						.noCollission().randomTicks().sound(SoundType.CROP), "mango_block"));
	public static final RegistryObject<Block> MANGO_CAKE = BLOCKS.register("mango_cake",
			() -> new ModCakeBlock(Block.Properties.copy(Blocks.CAKE), ModItems.MANGO_CAKE_SLICE));
	public static final RegistryObject<Block> MANGO_PIE = BLOCKS.register("mango_pie",
			() -> new PieBlock(Block.Properties.copy(Blocks.CAKE), ModItems.MANGO_PIE_SLICE));
	public static final RegistryObject<Block> MANGO_CRATE = BLOCKS.register("mango_crate",
			() -> new Block(Block.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> MANGO_JAM = BLOCKS.register("mango_jam",
			() -> new JamBlock(Block.Properties.copy(Blocks.GLASS), ModItems.MANGO_BREAD, ModItems.MANGO_DOUGHNUT,true));
	public static final RegistryObject<Block> SWEETENED_MANGO = BLOCKS.register("sweetened_mango",
			() -> new DriedFruit(BlockBehaviour.Properties.of(Material.SNOW).strength(0.5F, 3.0F),ModItems.DRIED_MANGO));
	public static final RegistryObject<Block> MANGO_WINE_BARREL = BLOCKS.register("mango_wine_barrel",
			() -> new FruitWineBarrelBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(0.5F, 3.0F), ModItems.MANGO_WINE_ONE, ModItems.MANGO_WINE_TWO, ModItems.MANGO_WINE_THREE, ModItems.MANGO_WINE_FOUR, ModItems.MANGO_WINE_FIVE, ModItems.MANGO_WINE_SIX, ModItems.MANGO_WINE_SEVEN, ModItems.MANGO_WINE_EIGHT, ModItems.MANGO_WINE_NINE, ModItems.MANGO_WINE_TEN, ModItems.BEST_MANGO_WINE));
	public static final RegistryObject<Block> MANGO_LANTERN = BLOCKS.register("mango_lantern",
			FruitLanternBlock::new);
	public static final RegistryObject<Block> MANGO_POPSICLE_MACHINE = BLOCKS.register("mango_popsicle_machine",
			() -> new FruitPopsicleMachineBlock(BlockBehaviour.Properties.of(Material.METAL).strength(0.5F, 6.0F), ModItems.MANGO_POPSICLE));
	//holboellia latifolia
	public static final RegistryObject<Block> HOLBOELLIA_LATIFOLIA_CROP = BLOCKS.register("holboellia_latifolia_crop",
			() -> new HolboelliaCrop(Block.Properties.copy(Blocks.WHEAT), ModItems.HOLBOELLIA_LATIFOLIA_SEEDS));
	public static final RegistryObject<Block> HOLBOELLIA_LATIFOLIA = BLOCKS.register("holboellia_latifolia",
			() -> new CanMineFruitBlock(Block.Properties.copy(Blocks.PUMPKIN), ModItems.HOLBOELLIA_LATIFOLIA_SLICE, false));
	public static final RegistryObject<Block> WILD_HOLBOELLIA_LATIFOLIA = BLOCKS.register("wild_holboellia_latifolia",
			() -> new WildCropBlock(MobEffects.DAMAGE_BOOST, 6, Block.Properties.copy(Blocks.TALL_GRASS)));
	public static final RegistryObject<Block> HOLBOELLIA_LATIFOLIA_EGG_MILK_PUDDING = BLOCKS.register("holboellia_latifolia_egg_milk_pudding",
			() -> new HolboelliaLatifoliaEggMilkPudding(Block.Properties.copy(Blocks.CAKE), ModItems.MANGO_CAKE_SLICE));
	public static final RegistryObject<Block> HOLBOELLIA_LATIFOLIA_CAKE = BLOCKS.register("holboellia_latifolia_cake",
			() -> new ModCakeBlock(Block.Properties.copy(Blocks.CAKE), ModItems.HOLBOELLIA_LATIFOLIA_CAKE_SLICE));
	public static final RegistryObject<Block> HOLBOELLIA_LATIFOLIA_PIE = BLOCKS.register("holboellia_latifolia_pie",
			() -> new PieBlock(Block.Properties.copy(Blocks.CAKE), ModItems.HOLBOELLIA_LATIFOLIA_PIE_SLICE));
	public static final RegistryObject<Block> HOLBOELLIA_LATIFOLIA_CRATE = BLOCKS.register("holboellia_latifolia_crate",
			() -> new Block(Block.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> HOLBOELLIA_LATIFOLIA_JAM = BLOCKS.register("holboellia_latifolia_jam",
			() -> new JamBlock(Block.Properties.copy(Blocks.GLASS), ModItems.HOLBOELLIA_LATIFOLIA_BREAD, ModItems.HOLBOELLIA_LATIFOLIA_DOUGHNUT,true));
	public static final RegistryObject<Block> HOLBOELLIA_LATIFOLIA_WINE_BARREL = BLOCKS.register("holboellia_latifolia_wine_barrel",
			() -> new FruitWineBarrelBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(0.5F, 3.0F), ModItems.HOLBOELLIA_LATIFOLIA_WINE_ONE, ModItems.HOLBOELLIA_LATIFOLIA_WINE_TWO, ModItems.HOLBOELLIA_LATIFOLIA_WINE_THREE, ModItems.HOLBOELLIA_LATIFOLIA_WINE_FOUR, ModItems.HOLBOELLIA_LATIFOLIA_WINE_FIVE, ModItems.HOLBOELLIA_LATIFOLIA_WINE_SIX, ModItems.HOLBOELLIA_LATIFOLIA_WINE_SEVEN, ModItems.HOLBOELLIA_LATIFOLIA_WINE_EIGHT, ModItems.HOLBOELLIA_LATIFOLIA_WINE_NINE, ModItems.HOLBOELLIA_LATIFOLIA_WINE_TEN, ModItems.BEST_HOLBOELLIA_LATIFOLIA_WINE));
	public static final RegistryObject<Block> HOLBOELLIA_LATIFOLIA_POPSICLE_MACHINE = BLOCKS.register("holboellia_latifolia_popsicle_machine",
			() -> new FruitPopsicleMachineBlock(BlockBehaviour.Properties.of(Material.METAL).strength(0.5F, 6.0F), ModItems.HOLBOELLIA_LATIFOLIA_POPSICLE));
	//litchi
	public static final RegistryObject<Block> LITCHI_BLOCK = BLOCKS.register("litchi_block",
			() -> new CanMineFruitBlock(Block.Properties.copy(Blocks.PUMPKIN), ModItems.LITCHI_SLICE, false));
	public static final RegistryObject<Block> LITCHI_SAPLING = BLOCKS.register("litchi_sapling",
			() -> new LitchiSapling(Block.Properties.of(Material.PLANT)
					.noCollission().randomTicks().strength(0f).sound(SoundType.CROP), 1));
	public static final RegistryObject<Block> LITCHI_LOG_BIG = register("litchi_log_big",
			() -> new LogBlock(BlockBehaviour.Properties.of(Material.WOOD, state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.WOOD : MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD)), fruitstack.CREATIVE_TAB);
	public static final RegistryObject<Block> LITCHI_LOG_MEDIUM = register("litchi_log_medium",
			() -> new LogBlock(BlockBehaviour.Properties.of(Material.WOOD, state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.WOOD : MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD)), fruitstack.CREATIVE_TAB);
	public static final RegistryObject<Block> LITCHI_LOG_BIFURCATE = register("litchi_log_bifurcate",
			() -> new LogBlock(BlockBehaviour.Properties.of(Material.WOOD, state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.WOOD : MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD)), fruitstack.CREATIVE_TAB);
	public static final RegistryObject<Block> LITCHI_LOG_TOP = register("litchi_log_top",
			() -> new LogBlock(BlockBehaviour.Properties.of(Material.WOOD, state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.WOOD : MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD)), fruitstack.CREATIVE_TAB);
	public static final RegistryObject<Block> LITCHI_LEAVES = register("litchi_leaves",
			() -> new ModLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(ModBlocks::ocelotOrParrot).isSuffocating((a, b, c) -> false).isViewBlocking((a, b, c) -> false)), fruitstack.CREATIVE_TAB);
	public static final RegistryObject<BlockFruitCrop> LITCHI_CROP = BLOCKS.register("litchi_crop",
			() -> new BlockFruitCrop(Block.Properties.of(Material.PLANT).strength(5F)
					.noCollission().randomTicks().sound(SoundType.CROP), "litchi_block"));
	public static final RegistryObject<Block> LITCHI_CAKE = BLOCKS.register("litchi_cake",
			() -> new ModCakeBlock(Block.Properties.copy(Blocks.CAKE), ModItems.LITCHI_CAKE_SLICE));
	public static final RegistryObject<Block> LITCHI_PIE = BLOCKS.register("litchi_pie",
			() -> new PieBlock(Block.Properties.copy(Blocks.CAKE), ModItems.LITCHI_PIE_SLICE));
	public static final RegistryObject<Block> LITCHI_CRATE = BLOCKS.register("litchi_crate",
			() -> new Block(Block.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> BOWLED_LITCHI_RIVER_NOODLES = BLOCKS.register("bowled_litchi_river_noodles",
			() -> new LitchiRiverNoodlesBlock(Block.Properties.copy(Blocks.CAKE)));
	public static final RegistryObject<Block> LITCHI_JAM = BLOCKS.register("litchi_jam",
			() -> new JamBlock(Block.Properties.copy(Blocks.GLASS), ModItems.LITCHI_BREAD, ModItems.LITCHI_DOUGHNUT,true));
	public static final RegistryObject<Block> LITCHI_RIVER_DOUGH = BLOCKS.register("litchi_river_dough", () ->
			new LitchiRiverDough(BlockBehaviour.Properties.of(Material.SNOW).strength(0.5F, 3.0F)));
	public static final RegistryObject<Block> UNFORMED_LITCHI_RIVER_DOUGH = BLOCKS.register("unformed_litchi_river_dough",
			() -> new UnformedLitchiRiverDough(ModBlocks.LITCHI_RIVER_DOUGH,BlockBehaviour.Properties.of(Material.SNOW).strength(0.5F, 3.0F)));
	public static final RegistryObject<Block> SWEETENED_LITCHI = BLOCKS.register("sweetened_litchi",
			() -> new DriedFruit(BlockBehaviour.Properties.of(Material.SNOW).strength(0.5F, 3.0F),ModItems.DRIED_LITCHI));
	public static final RegistryObject<Block> LITCHI_WINE_BARREL = BLOCKS.register("litchi_wine_barrel",
			() -> new FruitWineBarrelBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(0.5F, 3.0F), ModItems.LITCHI_WINE_ONE, ModItems.LITCHI_WINE_TWO, ModItems.LITCHI_WINE_THREE, ModItems.LITCHI_WINE_FOUR, ModItems.LITCHI_WINE_FIVE, ModItems.LITCHI_WINE_SIX, ModItems.LITCHI_WINE_SEVEN, ModItems.LITCHI_WINE_EIGHT, ModItems.LITCHI_WINE_NINE, ModItems.LITCHI_WINE_TEN, ModItems.BEST_LITCHI_WINE));
	public static final RegistryObject<Block> LITCHI_POPSICLE_MACHINE = BLOCKS.register("litchi_popsicle_machine",
			() -> new FruitPopsicleMachineBlock(BlockBehaviour.Properties.of(Material.METAL).strength(0.5F, 6.0F), ModItems.LITCHI_POPSICLE));
	//apple
	public static final RegistryObject<BlockFruitCrop> APPLE_CROP = BLOCKS.register("apple_crop",
			() -> new BlockFruitCrop(Block.Properties.of(Material.PLANT).strength(5F)
					.noCollission().randomTicks().sound(SoundType.CROP), "apple"));
	public static final RegistryObject<Block> APPLE_SAPLING = BLOCKS.register("apple_sapling",
			() -> new AppleSapling(Block.Properties.of(Material.PLANT)
					.noCollission().randomTicks().strength(0f).sound(SoundType.CROP), 1));
	public static final RegistryObject<Block> APPLE_LOG_BIG = register("apple_log_big",
			() -> new LogBlock(BlockBehaviour.Properties.of(Material.WOOD, state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.WOOD : MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD)), fruitstack.CREATIVE_TAB);
	public static final RegistryObject<Block> APPLE_LOG_MEDIUM = register("apple_log_medium",
			() -> new LogBlock(BlockBehaviour.Properties.of(Material.WOOD, state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.WOOD : MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD)), fruitstack.CREATIVE_TAB);
	public static final RegistryObject<Block> APPLE_LOG_BIFURCATE = register("apple_log_bifurcate",
			() -> new LogBlock(BlockBehaviour.Properties.of(Material.WOOD, state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.WOOD : MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD)), fruitstack.CREATIVE_TAB);
	public static final RegistryObject<Block> APPLE_LOG_TOP = register("apple_log_top",
			() -> new LogBlock(BlockBehaviour.Properties.of(Material.WOOD, state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.WOOD : MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD)), fruitstack.CREATIVE_TAB);
	public static final RegistryObject<Block> APPLE_LEAVES = register("apple_leaves",
			() -> new ModLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(ModBlocks::ocelotOrParrot).isSuffocating((a, b, c) -> false).isViewBlocking((a, b, c) -> false)), fruitstack.CREATIVE_TAB);
    //black tea
	public static final RegistryObject<Block> BLACK_TEA_LOG_BIG = BLOCKS.register("black_tea_log_big",
			() -> new BlackTeaCropBlock(ModBlocks.BLACK_TEA_LOG_MEDIUM, ModBlocks.BLACK_TEA_LOG_TOP, ModBlocks.BLACK_TEA_LEAVES,Block.Properties.of(Material.WOOD)));
	public static final RegistryObject<Block> BLACK_TEA_LOG_MEDIUM = register("black_tea_log_medium",
			() -> new LogBlock(BlockBehaviour.Properties.of(Material.WOOD, state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.WOOD : MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD)), fruitstack.CREATIVE_TAB);
	public static final RegistryObject<Block> BLACK_TEA_LOG_TOP = register("black_tea_log_top",
			() -> new LogBlock(BlockBehaviour.Properties.of(Material.WOOD, state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.WOOD : MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD)), fruitstack.CREATIVE_TAB);
	public static final RegistryObject<Block> BLACK_TEA_LEAVES = register("black_tea_leaves",
			() -> new ModLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(ModBlocks::ocelotOrParrot).isSuffocating((a, b, c) -> false).isViewBlocking((a, b, c) -> false)), fruitstack.CREATIVE_TAB);
	public static final RegistryObject<Block> WILD_BLACK_TEA_LEAVES = BLOCKS.register("wild_black_tea_leaves",
			() -> new WildCropBlock(MobEffects.DAMAGE_BOOST, 6, Block.Properties.copy(Blocks.TALL_GRASS)));
	public static final RegistryObject<Block> BLACK_TEA_LEAVES_BAG = BLOCKS.register("black_tea_leaves_bag",
			() -> new Block(Block.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	//sugar_cane
	public static final RegistryObject<Block> SUGAR_CANE_BUNDLE = BLOCKS.register("sugar_cane_bundle",
			() -> new Block(Block.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	//huoshen fruit
	public static final RegistryObject<Block> HUOSHEN_FRUIT = BLOCKS.register("huoshen_fruit",
			() -> new CanMineFruitBlock(Block.Properties.copy(Blocks.PUMPKIN), ModItems.HUOSHEN_FRUIT_SLICE, false));
	public static final RegistryObject<Block> HUOSHEN_FRUIT_CROP = BLOCKS.register("huoshen_fruit_crop",
			() -> new HolboelliaCrop(Block.Properties.copy(Blocks.WHEAT), ModItems.HUOSHEN_FRUIT_SEEDS));
	public static final RegistryObject<Block> WILD_HUOSHEN_FRUIT = BLOCKS.register("wild_huoshen_fruit",
			() -> new WildCropBlock(MobEffects.DAMAGE_BOOST, 6, Block.Properties.copy(Blocks.TALL_GRASS)));
	public static final RegistryObject<Block> HUOSHEN_FRUIT_CAKE = BLOCKS.register("huoshen_fruit_cake",
			() -> new ModCakeBlock(Block.Properties.copy(Blocks.CAKE), ModItems.HUOSHEN_FRUIT_CAKE_SLICE));
	public static final RegistryObject<Block> HUOSHEN_FRUIT_PIE = BLOCKS.register("huoshen_fruit_pie",
			() -> new PieBlock(Block.Properties.copy(Blocks.CAKE), ModItems.LITCHI_PIE_SLICE));
	public static final RegistryObject<Block> HUOSHEN_FRUIT_CRATE = BLOCKS.register("huoshen_fruit_crate",
			() -> new Block(Block.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> HUOSHEN_FRUIT_HONEY_SAUCE = BLOCKS.register("huoshen_fruit_honey_sauce",
			() -> new HuoshenFruitHoneySauce(Block.Properties.copy(Blocks.CAKE), ModItems.MANGO_CAKE_SLICE,true));
	public static final RegistryObject<Block> HUOSHEN_FRUIT_JAM = BLOCKS.register("huoshen_fruit_jam",
			() -> new JamBlock(Block.Properties.copy(Blocks.GLASS), ModItems.HUOSHEN_FRUIT_BREAD, ModItems.HUOSHEN_FRUIT_DOUGHNUT,true));
	public static final RegistryObject<Block> HUOSHEN_FRUIT_WINE_BARREL = BLOCKS.register("huoshen_fruit_wine_barrel",
			() -> new FruitWineBarrelBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(0.5F, 3.0F), ModItems.HUOSHEN_FRUIT_WINE_ONE, ModItems.HUOSHEN_FRUIT_WINE_TWO, ModItems.HUOSHEN_FRUIT_WINE_THREE, ModItems.HUOSHEN_FRUIT_WINE_FOUR, ModItems.HUOSHEN_FRUIT_WINE_FIVE, ModItems.HUOSHEN_FRUIT_WINE_SIX, ModItems.HUOSHEN_FRUIT_WINE_SEVEN, ModItems.HUOSHEN_FRUIT_WINE_EIGHT, ModItems.HUOSHEN_FRUIT_WINE_NINE, ModItems.HUOSHEN_FRUIT_WINE_TEN, ModItems.BEST_HUOSHEN_FRUIT_WINE));
	public static final RegistryObject<Block> HUOSHEN_FRUIT_POPSICLE_MACHINE = BLOCKS.register("huoshen_fruit_popsicle_machine",
			() -> new FruitPopsicleMachineBlock(BlockBehaviour.Properties.of(Material.METAL).strength(0.5F, 6.0F), ModItems.HUOSHEN_FRUIT_POPSICLE));
	//September Melon
	public static final RegistryObject<Block> SEPTEMBER_MELON_CROP = BLOCKS.register("september_melon_crop",
			() -> new HolboelliaCrop(Block.Properties.copy(Blocks.WHEAT), ModItems.SEPTEMBER_MELON_SEEDS));
	public static final RegistryObject<Block> WILD_SEPTEMBER_MELON = BLOCKS.register("wild_september_melon",
			() -> new WildCropBlock(MobEffects.DAMAGE_BOOST, 6, Block.Properties.copy(Blocks.TALL_GRASS)));
	public static final RegistryObject<Block> SEPTEMBER_MELON_CAKE = BLOCKS.register("september_melon_cake",
			() -> new ModCakeBlock(Block.Properties.copy(Blocks.CAKE), ModItems.SEPTEMBER_MELON_CAKE_SLICE));
	public static final RegistryObject<Block> SEPTEMBER_MELON_PIE = BLOCKS.register("september_melon_pie",
			() -> new PieBlock(Block.Properties.copy(Blocks.CAKE), ModItems.LITCHI_PIE_SLICE));
	public static final RegistryObject<Block> SEPTEMBER_MELON_CRATE = BLOCKS.register("september_melon_crate",
			() -> new Block(Block.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> SEPTEMBER_MELON_JAM = BLOCKS.register("september_melon_jam",
				() -> new JamBlock(Block.Properties.copy(Blocks.GLASS), ModItems.SEPTEMBER_MELON_BREAD, ModItems.SEPTEMBER_MELON_DOUGHNUT,true));
	public static final RegistryObject<Block> SEPTEMBER_MELON_WINE_BARREL = BLOCKS.register("september_melon_wine_barrel",
			() -> new FruitWineBarrelBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(0.5F, 3.0F), ModItems.SEPTEMBER_MELON_WINE_ONE, ModItems.SEPTEMBER_MELON_WINE_TWO, ModItems.SEPTEMBER_MELON_WINE_THREE, ModItems.SEPTEMBER_MELON_WINE_FOUR, ModItems.SEPTEMBER_MELON_WINE_FIVE, ModItems.SEPTEMBER_MELON_WINE_SIX, ModItems.SEPTEMBER_MELON_WINE_SEVEN, ModItems.SEPTEMBER_MELON_WINE_EIGHT, ModItems.SEPTEMBER_MELON_WINE_NINE, ModItems.SEPTEMBER_MELON_WINE_TEN, ModItems.BEST_SEPTEMBER_MELON_WINE));
	public static final RegistryObject<Block> SEPTEMBER_MELON_POPSICLE_MACHINE = BLOCKS.register("september_melon_popsicle_machine",
			() -> new FruitPopsicleMachineBlock(BlockBehaviour.Properties.of(Material.METAL).strength(0.5F, 6.0F), ModItems.SEPTEMBER_MELON_POPSICLE));
	//pitaya
	public static final RegistryObject<Block> PITAYA = BLOCKS.register("pitaya",
			() -> new CanMineFruitBlock(Block.Properties.copy(Blocks.PUMPKIN), ModItems.PITAYA_SLICE, false));
	public static final RegistryObject<Block> PITAYA_CROP = BLOCKS.register("pitaya_crop",
			() -> new PitayaBlock(Block.Properties.copy(Blocks.WHEAT)));
	public static final RegistryObject<Block> WILD_PITAYA = BLOCKS.register("wild_pitaya",
			() -> new WildCropBlock(MobEffects.DAMAGE_BOOST, 6, Block.Properties.copy(Blocks.TALL_GRASS)));
	public static final RegistryObject<Block> COLORFUL_FRUIT_SALAD_BLOCK = BLOCKS.register("colorful_fruit_salad_block",
			() -> new ColorfulFruitSaladBlock(Block.Properties.copy(Blocks.CAKE)));
	public static final RegistryObject<Block> PITAYA_CAKE = BLOCKS.register("pitaya_cake",
			() -> new ModCakeBlock(Block.Properties.copy(Blocks.CAKE), ModItems.PITAYA_CAKE_SLICE));
	public static final RegistryObject<Block> PITAYA_PIE = BLOCKS.register("pitaya_pie",
			() -> new PieBlock(Block.Properties.copy(Blocks.CAKE), ModItems.PITAYA_PIE_SLICE));
	public static final RegistryObject<Block> PITAYA_CRATE = BLOCKS.register("pitaya_crate",
			() -> new Block(Block.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> PITAYA_JAM = BLOCKS.register("pitaya_jam",
			() -> new JamBlock(Block.Properties.copy(Blocks.GLASS), ModItems.PITAYA_BREAD, ModItems.PITAYA_DOUGHNUT,true));
	public static final RegistryObject<Block> SWEETENED_PITAYA = BLOCKS.register("sweetened_pitaya",
			() -> new DriedFruit(BlockBehaviour.Properties.of(Material.SNOW).strength(0.5F, 3.0F),ModItems.DRIED_PITAYA));
	public static final RegistryObject<Block> PITAYA_WINE_BARREL = BLOCKS.register("pitaya_wine_barrel",
			() -> new FruitWineBarrelBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(0.5F, 3.0F), ModItems.PITAYA_WINE_ONE, ModItems.PITAYA_WINE_TWO, ModItems.PITAYA_WINE_THREE, ModItems.PITAYA_WINE_FOUR, ModItems.PITAYA_WINE_FIVE, ModItems.PITAYA_WINE_SIX, ModItems.PITAYA_WINE_SEVEN, ModItems.PITAYA_WINE_EIGHT, ModItems.PITAYA_WINE_NINE, ModItems.PITAYA_WINE_TEN, ModItems.BEST_PITAYA_WINE));
	public static final RegistryObject<Block> PITAYA_POPSICLE_MACHINE = BLOCKS.register("pitaya_popsicle_machine",
			() -> new FruitPopsicleMachineBlock(BlockBehaviour.Properties.of(Material.METAL).strength(0.5F, 6.0F), ModItems.PITAYA_POPSICLE));
	//golden pure sheep horn honey
	public static final RegistryObject<Block> GOLDEN_PURE_SHEEP_HORN_HONEY = BLOCKS.register("golden_pure_sheep_horn_honey",
			() -> new CanMineFruitBlock(Block.Properties.copy(Blocks.PUMPKIN), ModItems.GOLDEN_PURE_SHEEP_HORN_HONEY_SLICE, false));
	public static final RegistryObject<Block> GOLDEN_PURE_SHEEP_HORN_HONEY_CROP = BLOCKS.register("golden_pure_sheep_horn_honey_crop",
			() -> new HolboelliaCrop(Block.Properties.copy(Blocks.WHEAT), ModItems.GOLDEN_PURE_SHEEP_HORN_HONEY_SEEDS));
	public static final RegistryObject<Block> WILD_GOLDEN_PURE_SHEEP_HORN_HONEY = BLOCKS.register("wild_golden_pure_sheep_horn_honey",
			() -> new WildCropBlock(MobEffects.DAMAGE_BOOST, 6, Block.Properties.copy(Blocks.TALL_GRASS)));
	public static final RegistryObject<Block> GOLDEN_PURE_SHEEP_HORN_HONEY_CAKE = BLOCKS.register("golden_pure_sheep_horn_honey_cake",
			() -> new ModCakeBlock(Block.Properties.copy(Blocks.CAKE), ModItems.GOLDEN_PURE_SHEEP_HORN_HONEY_CAKE_SLICE));
	public static final RegistryObject<Block> GOLDEN_PURE_SHEEP_HORN_HONEY_PIE = BLOCKS.register("golden_pure_sheep_horn_honey_pie",
			() -> new PieBlock(Block.Properties.copy(Blocks.CAKE), ModItems.GOLDEN_PURE_SHEEP_HORN_HONEY_PIE_SLICE));
	public static final RegistryObject<Block> GOLDEN_PURE_SHEEP_HORN_HONEY_CRATE = BLOCKS.register("golden_pure_sheep_horn_honey_crate",
			() -> new Block(Block.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> GOLDEN_PURE_SHEEP_HORN_HONEY_JAM = BLOCKS.register("golden_pure_sheep_horn_honey_jam",
			() -> new JamBlock(Block.Properties.copy(Blocks.GLASS), ModItems.GOLDEN_PURE_SHEEP_HORN_HONEY_BREAD, ModItems.GOLDEN_PURE_SHEEP_HORN_HONEY_DOUGHNUT,true));
	public static final RegistryObject<Block> GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_BARREL = BLOCKS.register("golden_pure_sheep_horn_honey_wine_barrel",
			() -> new FruitWineBarrelBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(0.5F, 3.0F), ModItems.GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_ONE, ModItems.GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_TWO, ModItems.GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_THREE, ModItems.GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_FOUR, ModItems.GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_FIVE, ModItems.GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_SIX, ModItems.GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_SEVEN, ModItems.GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_EIGHT, ModItems.GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_NINE, ModItems.GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_TEN, ModItems.BEST_GOLDEN_PURE_SHEEP_HORN_HONEY_WINE));
	public static final RegistryObject<Block> GOLDEN_PURE_SHEEP_HORN_HONEY_POPSICLE_MACHINE = BLOCKS.register("golden_pure_sheep_horn_honey_popsicle_machine",
			() -> new FruitPopsicleMachineBlock(BlockBehaviour.Properties.of(Material.METAL).strength(0.5F, 6.0F), ModItems.GOLDEN_PURE_SHEEP_HORN_HONEY_POPSICLE));
	//pear
	public static final RegistryObject<Block> PEAR_BLOCK = BLOCKS.register("pear_block",
			() -> new CanMineFruitBlock(Block.Properties.copy(Blocks.PUMPKIN), ModItems.PEAR_SLICE, false));
	public static final RegistryObject<Block> PEAR_SAPLING = BLOCKS.register("pear_sapling",
			() -> new PearSapling(Block.Properties.of(Material.PLANT)
					.noCollission().randomTicks().strength(0f).sound(SoundType.CROP), 1));
	public static final RegistryObject<Block> PEAR_LOG_BIG = register("pear_log_big",
			() -> new LogBlock(BlockBehaviour.Properties.of(Material.WOOD, state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.WOOD : MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD)), fruitstack.CREATIVE_TAB);
	public static final RegistryObject<Block> PEAR_LOG_MEDIUM = register("pear_log_medium",
			() -> new LogBlock(BlockBehaviour.Properties.of(Material.WOOD, state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.WOOD : MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD)), fruitstack.CREATIVE_TAB);
	public static final RegistryObject<Block> PEAR_LOG_BIFURCATE = register("pear_log_bifurcate",
			() -> new LogBlock(BlockBehaviour.Properties.of(Material.WOOD, state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.WOOD : MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD)), fruitstack.CREATIVE_TAB);
	public static final RegistryObject<Block> PEAR_LOG_TOP = register("pear_log_top",
			() -> new LogBlock(BlockBehaviour.Properties.of(Material.WOOD, state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.WOOD : MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD)), fruitstack.CREATIVE_TAB);
	public static final RegistryObject<Block> PEAR_LEAVES = register("pear_leaves",
			() -> new ModLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(ModBlocks::ocelotOrParrot).isSuffocating((a, b, c) -> false).isViewBlocking((a, b, c) -> false)), fruitstack.CREATIVE_TAB);
	public static final RegistryObject<BlockFruitCrop> PEAR_CROP = BLOCKS.register("pear_crop",
			() -> new BlockFruitCrop(Block.Properties.of(Material.PLANT).strength(5F)
					.noCollission().randomTicks().sound(SoundType.CROP), "pear_block"));
	public static final RegistryObject<Block> PEAR_CAKE = BLOCKS.register("pear_cake",
			() -> new ModCakeBlock(Block.Properties.copy(Blocks.CAKE), ModItems.PEAR_CAKE_SLICE));
	public static final RegistryObject<Block> PEAR_PIE = BLOCKS.register("pear_pie",
			() -> new PieBlock(Block.Properties.copy(Blocks.CAKE), ModItems.PEAR_PIE_SLICE));
	public static final RegistryObject<Block> PEAR_CRATE = BLOCKS.register("pear_crate",
			() -> new Block(Block.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ROCK_SUPAR_SNOW_PEAR = BLOCKS.register("rock_sugar_snow_pear",
			() -> new RockSugarSnowPear(Block.Properties.copy(Blocks.CAKE), ModItems.PEAR_CAKE_SLICE,true));
	public static final RegistryObject<Block> PEAR_JAM = BLOCKS.register("pear_jam",
			() -> new JamBlock(Block.Properties.copy(Blocks.GLASS), ModItems.PEAR_BREAD, ModItems.PEAR_DOUGHNUT,true));
	public static final RegistryObject<Block> PEAR_WINE_BARREL = BLOCKS.register("pear_wine_barrel",
			() -> new FruitWineBarrelBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(0.5F, 3.0F), ModItems.PEAR_WINE_ONE, ModItems.PEAR_WINE_TWO, ModItems.PEAR_WINE_THREE, ModItems.PEAR_WINE_FOUR, ModItems.PEAR_WINE_FIVE, ModItems.PEAR_WINE_SIX, ModItems.PEAR_WINE_SEVEN, ModItems.PEAR_WINE_EIGHT, ModItems.PEAR_WINE_NINE, ModItems.PEAR_WINE_TEN, ModItems.BEST_PEAR_WINE));
	public static final RegistryObject<Block> PEAR_POPSICLE_MACHINE = BLOCKS.register("pear_popsicle_machine",
			() -> new FruitPopsicleMachineBlock(BlockBehaviour.Properties.of(Material.METAL).strength(0.5F, 6.0F), ModItems.PEAR_POPSICLE));
	//maythorn
	public static final RegistryObject<Block> MAYTHORN_SAPLING = BLOCKS.register("maythorn_sapling",
			() -> new MaythornSapling(Block.Properties.of(Material.PLANT)
					.noCollission().randomTicks().strength(0f).sound(SoundType.CROP), 1));
	public static final RegistryObject<Block> MAYTHORN_LOG_BIG = register("maythorn_log_big",
			() -> new LogBlock(BlockBehaviour.Properties.of(Material.WOOD, state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.WOOD : MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD)), fruitstack.CREATIVE_TAB);
	public static final RegistryObject<Block> MAYTHORN_LOG_MEDIUM = register("maythorn_log_medium",
			() -> new LogBlock(BlockBehaviour.Properties.of(Material.WOOD, state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.WOOD : MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD)), fruitstack.CREATIVE_TAB);
	public static final RegistryObject<Block> MAYTHORN_LOG_BIFURCATE = register("maythorn_log_bifurcate",
			() -> new LogBlock(BlockBehaviour.Properties.of(Material.WOOD, state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.WOOD : MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD)), fruitstack.CREATIVE_TAB);
	public static final RegistryObject<Block> MAYTHORN_LEAVES = register("maythorn_leaves",
			() -> new ModLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(ModBlocks::ocelotOrParrot).isSuffocating((a, b, c) -> false).isViewBlocking((a, b, c) -> false)), fruitstack.CREATIVE_TAB);
	public static final RegistryObject<BlockFruitCrop> MAYTHORN_CROP = BLOCKS.register("maythorn_crop",
			() -> new BlockFruitCrop(Block.Properties.of(Material.PLANT).strength(5F)
					.noCollission().randomTicks().sound(SoundType.CROP), "maythorn"));
	public static final RegistryObject<Block> MAYTHORN_CAKE = BLOCKS.register("maythorn_cake",
			() -> new ModCakeBlock(Block.Properties.copy(Blocks.CAKE), ModItems.MAYTHORN_CAKE_SLICE));
	public static final RegistryObject<Block> MAYTHORN_PIE = BLOCKS.register("maythorn_pie",
			() -> new PieBlock(Block.Properties.copy(Blocks.CAKE), ModItems.MAYTHORN_PIE_SLICE));
	public static final RegistryObject<Block> MAYTHORN_CRATE = BLOCKS.register("maythorn_crate",
			() -> new Block(Block.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> BOWLED_CANDIED_HAWS_ON_A_STICK = BLOCKS.register("bowled_candied_haws_on_a_stick",
			() -> new BowledCandiedHawsOnAStick(Block.Properties.copy(Blocks.CAKE)));
	public static final RegistryObject<Block> A_BUNDLE_OF_CANDIED_HAWS_ON_A_STICK = BLOCKS.register("a_bundle_of_candied_haws_on_a_stick",
			() -> new CandiedHawsOnAStickBlock(Block.Properties.copy(Blocks.CAKE)));
	public static final RegistryObject<Block> RED_FRUIT_MAYTHORN_CAKE = BLOCKS.register("red_fruit_maythorn_cake",
				() -> new RedFruitMaythornCake(Block.Properties.copy(Blocks.CAKE), ModItems.MAYTHORN_PIE_SLICE,true));
	public static final RegistryObject<Block> MAYTHORN_JAM = BLOCKS.register("maythorn_jam",
			() -> new JamBlock(Block.Properties.copy(Blocks.GLASS), ModItems.MAYTHORN_BREAD, ModItems.MAYTHORN_DOUGHNUT,true));
	public static final RegistryObject<Block> SWEETENED_MAYTHORN = BLOCKS.register("sweetened_maythorn",
			() -> new DriedFruit(BlockBehaviour.Properties.of(Material.SNOW).strength(0.5F, 3.0F),ModItems.DRIED_MAYTHORN));
	public static final RegistryObject<Block> MAYTHORN_WINE_BARREL = BLOCKS.register("maythorn_wine_barrel",
			() -> new FruitWineBarrelBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(0.5F, 3.0F), ModItems.MAYTHORN_WINE_ONE, ModItems.MAYTHORN_WINE_TWO, ModItems.MAYTHORN_WINE_THREE, ModItems.MAYTHORN_WINE_FOUR, ModItems.MAYTHORN_WINE_FIVE, ModItems.MAYTHORN_WINE_SIX, ModItems.MAYTHORN_WINE_SEVEN, ModItems.MAYTHORN_WINE_EIGHT, ModItems.MAYTHORN_WINE_NINE, ModItems.MAYTHORN_WINE_TEN, ModItems.BEST_MAYTHORN_WINE));
	public static final RegistryObject<Block> MAYTHORN_POPSICLE_MACHINE = BLOCKS.register("maythorn_popsicle_machine",
			() -> new FruitPopsicleMachineBlock(BlockBehaviour.Properties.of(Material.METAL).strength(0.5F, 6.0F), ModItems.MAYTHORN_POPSICLE));
	//chinese_pear-leaved
	public static final RegistryObject<Block>  CHINESE_PEAR_LEAVED_BLOCK = BLOCKS.register("chinese_pear_leaved_block",
			() -> new CanMineFruitBlock(Block.Properties.copy(Blocks.PUMPKIN), ModItems. CHINESE_PEAR_LEAVED_SLICE, false));
	public static final RegistryObject<Block> CHINESE_PEAR_LEAVED_SAPLING = BLOCKS.register("chinese_pear_leaved_sapling",
			() -> new ChinesePearLeavedSapling(Block.Properties.of(Material.PLANT)
					.noCollission().randomTicks().strength(0f).sound(SoundType.CROP), 1));
	public static final RegistryObject<BlockFruitCrop> CHINESE_PEAR_LEAVED_CROP = BLOCKS.register("chinese_pear_leaved_crop",
			() -> new BlockFruitCrop(Block.Properties.of(Material.PLANT).strength(5F)
					.noCollission().randomTicks().sound(SoundType.CROP), "chinese_pear_leaved_block"));
	public static final RegistryObject<Block> CHINESE_PEAR_LEAVED_LEAVES = register("chinese_pear_leaved_leaves",
			() -> new ModLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(ModBlocks::ocelotOrParrot).isSuffocating((a, b, c) -> false).isViewBlocking((a, b, c) -> false)), fruitstack.CREATIVE_TAB);
	public static final RegistryObject<Block> CHINESE_PEAR_LEAVED_CAKE = BLOCKS.register("chinese_pear_leaved_cake",
			() -> new ModCakeBlock(Block.Properties.copy(Blocks.CAKE), ModItems.CHINESE_PEAR_LEAVED_CAKE_SLICE));
	public static final RegistryObject<Block> CHINESE_PEAR_LEAVED_PIE = BLOCKS.register("chinese_pear_leaved_pie",
			() -> new PieBlock(Block.Properties.copy(Blocks.CAKE), ModItems.CHINESE_PEAR_LEAVED_PIE_SLICE));
	public static final RegistryObject<Block> CHINESE_PEAR_LEAVED_CRATE = BLOCKS.register("chinese_pear_leaved_crate",
			() -> new Block(Block.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> CHINESE_PEAR_LEAVED_JAM = BLOCKS.register("chinese_pear_leaved_jam",
			() -> new JamBlock(Block.Properties.copy(Blocks.GLASS), ModItems.CHINESE_PEAR_LEAVED_BREAD, ModItems.CHINESE_PEAR_LEAVED_DOUGHNUT,true));
	public static final RegistryObject<Block> CHINESE_PEAR_LEAVED_WINE_BARREL = BLOCKS.register("chinese_pear_leaved_wine_barrel",
			() -> new FruitWineBarrelBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(0.5F, 3.0F), ModItems.CHINESE_PEAR_LEAVED_WINE_ONE, ModItems.CHINESE_PEAR_LEAVED_WINE_TWO, ModItems.CHINESE_PEAR_LEAVED_WINE_THREE, ModItems.CHINESE_PEAR_LEAVED_WINE_FOUR, ModItems.CHINESE_PEAR_LEAVED_WINE_FIVE, ModItems.CHINESE_PEAR_LEAVED_WINE_SIX, ModItems.CHINESE_PEAR_LEAVED_WINE_SEVEN, ModItems.CHINESE_PEAR_LEAVED_WINE_EIGHT, ModItems.CHINESE_PEAR_LEAVED_WINE_NINE, ModItems.CHINESE_PEAR_LEAVED_WINE_TEN, ModItems.BEST_CHINESE_PEAR_LEAVED_WINE));
	public static final RegistryObject<Block> CHINESE_PEAR_LEAVED_POPSICLE_MACHINE = BLOCKS.register("chinese_pear_leaved_popsicle_machine",
			() -> new FruitPopsicleMachineBlock(BlockBehaviour.Properties.of(Material.METAL).strength(0.5F, 6.0F), ModItems.CHINESE_PEAR_LEAVED_POPSICLE));
	//plum
	public static final RegistryObject<Block> PLUM_SAPLING = BLOCKS.register("plum_sapling",
			() -> new PlumSapling(Block.Properties.of(Material.PLANT)
					.noCollission().randomTicks().strength(0f).sound(SoundType.CROP), 1));
	public static final RegistryObject<Block> PLUM_LOG_BIG = register("plum_log_big",
			() -> new LogBlock(BlockBehaviour.Properties.of(Material.WOOD, state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.WOOD : MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD)), fruitstack.CREATIVE_TAB);
	public static final RegistryObject<Block> PLUM_LOG_TOP = register("plum_log_top",
			() -> new LogBlock(BlockBehaviour.Properties.of(Material.WOOD, state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.WOOD : MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD)), fruitstack.CREATIVE_TAB);
	public static final RegistryObject<Block> PLUM_LEAVES = register("plum_leaves",
			() -> new ModLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(ModBlocks::ocelotOrParrot).isSuffocating((a, b, c) -> false).isViewBlocking((a, b, c) -> false)), fruitstack.CREATIVE_TAB);
	public static final RegistryObject<BlockFruitCrop> PLUM_CROP = BLOCKS.register("plum_crop",
			() -> new BlockFruitCrop(Block.Properties.of(Material.PLANT).strength(5F)
					.noCollission().randomTicks().sound(SoundType.CROP), "plum"));
	public static final RegistryObject<Block> PLUM_CAKE = BLOCKS.register("plum_cake",
			() -> new ModCakeBlock(Block.Properties.copy(Blocks.CAKE), ModItems.PLUM_CAKE_SLICE));
	public static final RegistryObject<Block> PLUM_PIE = BLOCKS.register("plum_pie",
			() -> new PieBlock(Block.Properties.copy(Blocks.CAKE), ModItems.PLUM_PIE_SLICE));
	public static final RegistryObject<Block> PLUM_CRATE = BLOCKS.register("plum_crate",
			() -> new Block(Block.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> SOUR_AND_SWEET_PLUM_CAKE = BLOCKS.register("sour_and_sweet_plum_cake",
			() -> new RedFruitMaythornCake(Block.Properties.copy(Blocks.CAKE), ModItems.PLUM_PIE_SLICE,true));
	public static final RegistryObject<Block> PLUM_JAM = BLOCKS.register("plum_jam",
			() -> new JamBlock(Block.Properties.copy(Blocks.GLASS), ModItems.PLUM_BREAD, ModItems.PLUM_DOUGHNUT,true));
	public static final RegistryObject<Block> SWEETENED_PLUM = BLOCKS.register("sweetened_plum",
			() -> new DriedFruit(BlockBehaviour.Properties.of(Material.SNOW).strength(0.5F, 3.0F),ModItems.DRIED_PLUM));
	public static final RegistryObject<Block> PLUM_WINE_BARREL = BLOCKS.register("plum_wine_barrel",
			() -> new FruitWineBarrelBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(0.5F, 3.0F), ModItems.PLUM_WINE_ONE, ModItems.PLUM_WINE_TWO, ModItems.PLUM_WINE_THREE, ModItems.PLUM_WINE_FOUR, ModItems.PLUM_WINE_FIVE, ModItems.PLUM_WINE_SIX, ModItems.PLUM_WINE_SEVEN, ModItems.PLUM_WINE_EIGHT, ModItems.PLUM_WINE_NINE, ModItems.PLUM_WINE_TEN, ModItems.BEST_PLUM_WINE));
	public static final RegistryObject<Block> PLUM_POPSICLE_MACHINE = BLOCKS.register("plum_popsicle_machine",
			() -> new FruitPopsicleMachineBlock(BlockBehaviour.Properties.of(Material.METAL).strength(0.5F, 6.0F), ModItems.PLUM_POPSICLE));
	//jujube
	public static final RegistryObject<Block> JUJUBE_SAPLING = BLOCKS.register("jujube_sapling",
			() -> new JujubeSapling(Block.Properties.of(Material.PLANT)
					.noCollission().randomTicks().strength(0f).sound(SoundType.CROP), 1));
	public static final RegistryObject<Block> JUJUBE_LOG_BIG = register("jujube_log_big",
			() -> new LogBlock(BlockBehaviour.Properties.of(Material.WOOD, state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.WOOD : MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD)), fruitstack.CREATIVE_TAB);
	public static final RegistryObject<Block> JUJUBE_LOG_TOP = register("jujube_log_top",
			() -> new LogBlock(BlockBehaviour.Properties.of(Material.WOOD, state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.WOOD : MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD)), fruitstack.CREATIVE_TAB);
	public static final RegistryObject<Block> JUJUBE_LEAVES = register("jujube_leaves",
			() -> new ModLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(ModBlocks::ocelotOrParrot).isSuffocating((a, b, c) -> false).isViewBlocking((a, b, c) -> false)), fruitstack.CREATIVE_TAB);
	public static final RegistryObject<BlockFruitCrop> JUJUBE_CROP = BLOCKS.register("jujube_crop",
			() -> new BlockFruitCrop(Block.Properties.of(Material.PLANT).strength(5F)
					.noCollission().randomTicks().sound(SoundType.CROP), "jujube"));
	public static final RegistryObject<Block> JUJUBE_CAKE = BLOCKS.register("jujube_cake",
			() -> new ModCakeBlock(Block.Properties.copy(Blocks.CAKE), ModItems.JUJUBE_CAKE_SLICE));
	public static final RegistryObject<Block> JUJUBE_PIE = BLOCKS.register("jujube_pie",
			() -> new PieBlock(Block.Properties.copy(Blocks.CAKE), ModItems.JUJUBE_PIE_SLICE));
	public static final RegistryObject<Block> JUJUBE_CRATE = BLOCKS.register("jujube_crate",
			() -> new Block(Block.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> RED_GATE_GLUTINOUS_RICE = BLOCKS.register("red_gate_glutinous_rice",
			() -> new RedFruitMaythornCake(Block.Properties.copy(Blocks.CAKE), ModItems.JUJUBE_PIE_SLICE,true));
	public static final RegistryObject<Block> JUJUBE_JAM = BLOCKS.register("jujube_jam",
			() -> new JamBlock(Block.Properties.copy(Blocks.GLASS), ModItems.JUJUBE_BREAD, ModItems.JUJUBE_DOUGHNUT,true));
	public static final RegistryObject<Block> SWEETENED_JUJUBE = BLOCKS.register("sweetened_jujube",
			() -> new DriedFruit(BlockBehaviour.Properties.of(Material.SNOW).strength(0.5F, 3.0F),ModItems.DRIED_JUJUBE));
	public static final RegistryObject<Block> JUJUBE_WINE_BARREL = BLOCKS.register("jujube_wine_barrel",
			() -> new FruitWineBarrelBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(0.5F, 3.0F), ModItems.JUJUBE_WINE_ONE, ModItems.JUJUBE_WINE_TWO, ModItems.JUJUBE_WINE_THREE, ModItems.JUJUBE_WINE_FOUR, ModItems.JUJUBE_WINE_FIVE, ModItems.JUJUBE_WINE_SIX, ModItems.JUJUBE_WINE_SEVEN, ModItems.JUJUBE_WINE_EIGHT, ModItems.JUJUBE_WINE_NINE, ModItems.JUJUBE_WINE_TEN, ModItems.BEST_JUJUBE_WINE));
	public static final RegistryObject<Block> JUJUBE_POPSICLE_MACHINE = BLOCKS.register("jujube_popsicle_machine",
			() -> new FruitPopsicleMachineBlock(BlockBehaviour.Properties.of(Material.METAL).strength(0.5F, 6.0F), ModItems.JUJUBE_POPSICLE));
	//apricot
	public static final RegistryObject<Block> APRICOT_SAPLING = BLOCKS.register("apricot_sapling",
			() -> new ApricotSapling(Block.Properties.of(Material.PLANT)
					.noCollission().randomTicks().strength(0f).sound(SoundType.CROP), 1));
	public static final RegistryObject<Block> APRICOT_LOG_BIG = register("apricot_log_big",
			() -> new LogBlock(BlockBehaviour.Properties.of(Material.WOOD, state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.WOOD : MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD)), fruitstack.CREATIVE_TAB);
	public static final RegistryObject<Block> APRICOT_LOG_MEDIUM = register("apricot_log_medium",
			() -> new LogBlock(BlockBehaviour.Properties.of(Material.WOOD, state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.WOOD : MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD)), fruitstack.CREATIVE_TAB);
	public static final RegistryObject<Block> APRICOT_LOG_BIFURCATE = register("apricot_log_bifurcate",
			() -> new LogBlock(BlockBehaviour.Properties.of(Material.WOOD, state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.WOOD : MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD)), fruitstack.CREATIVE_TAB);
	public static final RegistryObject<Block> APRICOT_LOG_TOP = register("apricot_log_top",
			() -> new LogBlock(BlockBehaviour.Properties.of(Material.WOOD, state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.WOOD : MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD)), fruitstack.CREATIVE_TAB);
	public static final RegistryObject<Block> APRICOT_LEAVES = register("apricot_leaves",
			() -> new ModLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(ModBlocks::ocelotOrParrot).isSuffocating((a, b, c) -> false).isViewBlocking((a, b, c) -> false)), fruitstack.CREATIVE_TAB);
	public static final RegistryObject<BlockFruitCrop> APRICOT_CROP = BLOCKS.register("apricot_crop",
			() -> new BlockFruitCrop(Block.Properties.of(Material.PLANT).strength(5F)
					.noCollission().randomTicks().sound(SoundType.CROP), "apricot"));
	public static final RegistryObject<Block> APRICOT_CAKE = BLOCKS.register("apricot_cake",
			() -> new ModCakeBlock(Block.Properties.copy(Blocks.CAKE), ModItems.APRICOT_CAKE_SLICE));
	public static final RegistryObject<Block> APRICOT_PIE = BLOCKS.register("apricot_pie",
			() -> new PieBlock(Block.Properties.copy(Blocks.CAKE), ModItems.APRICOT_PIE_SLICE));
	public static final RegistryObject<Block> APRICOT_CRATE = BLOCKS.register("apricot_crate",
			() -> new Block(Block.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> APRICOT_SMOOTHIE = BLOCKS.register("apricot_smoothie",
			() -> new RedFruitMaythornCake(Block.Properties.copy(Blocks.CAKE), ModItems.APRICOT_PIE_SLICE,true));
	public static final RegistryObject<Block> APRICOT_JAM = BLOCKS.register("apricot_jam",
			() -> new JamBlock(Block.Properties.copy(Blocks.GLASS), ModItems.APRICOT_BREAD, ModItems.APRICOT_DOUGHNUT,true));
	public static final RegistryObject<Block> APRICOT_WINE_BARREL = BLOCKS.register("apricot_wine_barrel",
			() -> new FruitWineBarrelBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(0.5F, 3.0F), ModItems.APRICOT_WINE_ONE, ModItems.APRICOT_WINE_TWO, ModItems.APRICOT_WINE_THREE, ModItems.APRICOT_WINE_FOUR, ModItems.APRICOT_WINE_FIVE, ModItems.APRICOT_WINE_SIX, ModItems.APRICOT_WINE_SEVEN, ModItems.APRICOT_WINE_EIGHT, ModItems.APRICOT_WINE_NINE, ModItems.APRICOT_WINE_TEN, ModItems.BEST_APRICOT_WINE));
	public static final RegistryObject<Block> APRICOT_POPSICLE_MACHINE = BLOCKS.register("apricot_popsicle_machine",
			() -> new FruitPopsicleMachineBlock(BlockBehaviour.Properties.of(Material.METAL).strength(0.5F, 6.0F), ModItems.APRICOT_POPSICLE));
	//red_bayberry
	public static final RegistryObject<Block> RED_BAYBERRY_SAPLING = BLOCKS.register("red_bayberry_sapling",
			() -> new BayberrySapling(Block.Properties.of(Material.PLANT)
					.noCollission().randomTicks().strength(0f).sound(SoundType.CROP), 1));
	public static final RegistryObject<Block> BAYBERRY_LOG_BIG = register("bayberry_log_big",
			() -> new LogBlock(BlockBehaviour.Properties.of(Material.WOOD, state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.WOOD : MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD)), fruitstack.CREATIVE_TAB);
	public static final RegistryObject<Block> BAYBERRY_LOG_BIFURCATE = register("bayberry_log_bifurcate",
			() -> new LogBlock(BlockBehaviour.Properties.of(Material.WOOD, state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.WOOD : MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD)), fruitstack.CREATIVE_TAB);
	public static final RegistryObject<Block> BAYBERRY_LEAVES = register("bayberry_leaves",
			() -> new ModLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(ModBlocks::ocelotOrParrot).isSuffocating((a, b, c) -> false).isViewBlocking((a, b, c) -> false)), fruitstack.CREATIVE_TAB);
	public static final RegistryObject<BlockFruitCrop> RED_BAYBERRY_CROP = BLOCKS.register("red_bayberry_crop",
			() -> new BlockFruitCrop(Block.Properties.of(Material.PLANT).strength(5F)
					.noCollission().randomTicks().sound(SoundType.CROP), "red_bayberry"));
	public static final RegistryObject<Block> RED_BAYBERRY_CAKE = BLOCKS.register("red_bayberry_cake",
			() -> new ModCakeBlock(Block.Properties.copy(Blocks.CAKE), ModItems.RED_BAYBERRY_CAKE_SLICE));
	public static final RegistryObject<Block> RED_BAYBERRY_PIE = BLOCKS.register("red_bayberry_pie",
			() -> new PieBlock(Block.Properties.copy(Blocks.CAKE), ModItems.RED_BAYBERRY_PIE_SLICE));
	public static final RegistryObject<Block> RED_BAYBERRY_CRATE = BLOCKS.register("red_bayberry_crate",
			() -> new Block(Block.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> SOUR_PLUM_CHICKEN_BLOCK = BLOCKS.register("sour_plum_chicken_block",
			() -> new SourPlumChickenBlock(Block.Properties.copy(Blocks.WHITE_WOOL), ModItems.SOUR_PLUM_CHICKEN, true));
	public static final RegistryObject<Block> RED_BAYBERRY_JAM = BLOCKS.register("red_bayberry_jam",
			() -> new JamBlock(Block.Properties.copy(Blocks.GLASS), ModItems.RED_BAYBERRY_BREAD, ModItems.RED_BAYBERRY_DOUGHNUT,true));
	public static final RegistryObject<Block> RED_BAYBERRY_WINE_BARREL = BLOCKS.register("red_bayberry_wine_barrel",
			() -> new FruitWineBarrelBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(0.5F, 3.0F), ModItems.RED_BAYBERRY_WINE_ONE, ModItems.RED_BAYBERRY_WINE_TWO, ModItems.RED_BAYBERRY_WINE_THREE, ModItems.RED_BAYBERRY_WINE_FOUR, ModItems.RED_BAYBERRY_WINE_FIVE, ModItems.RED_BAYBERRY_WINE_SIX, ModItems.RED_BAYBERRY_WINE_SEVEN, ModItems.RED_BAYBERRY_WINE_EIGHT, ModItems.RED_BAYBERRY_WINE_NINE, ModItems.RED_BAYBERRY_WINE_TEN, ModItems.BEST_RED_BAYBERRY_WINE));
	public static final RegistryObject<Block> RED_BAYBERRY_POPSICLE_MACHINE = BLOCKS.register("red_bayberry_popsicle_machine",
			() -> new FruitPopsicleMachineBlock(BlockBehaviour.Properties.of(Material.METAL).strength(0.5F, 6.0F), ModItems.RED_BAYBERRY_POPSICLE));
	//green_plum
	public static final RegistryObject<Block> GREEN_PLUM_SAPLING = BLOCKS.register("green_plum_sapling",
			() -> new BayberrySapling(Block.Properties.of(Material.PLANT)
					.noCollission().randomTicks().strength(0f).sound(SoundType.CROP), 2));
	public static final RegistryObject<BlockFruitCrop> GREEN_PLUM_CROP = BLOCKS.register("green_plum_crop",
			() -> new BlockFruitCrop(Block.Properties.of(Material.PLANT).strength(5F)
					.noCollission().randomTicks().sound(SoundType.CROP), "green_plum"));
	public static final RegistryObject<Block> GREEN_PLUM_CAKE = BLOCKS.register("green_plum_cake",
			() -> new ModCakeBlock(Block.Properties.copy(Blocks.CAKE), ModItems.GREEN_PLUM_CAKE_SLICE));
	public static final RegistryObject<Block> GREEN_PLUM_PIE = BLOCKS.register("green_plum_pie",
			() -> new PieBlock(Block.Properties.copy(Blocks.CAKE), ModItems.GREEN_PLUM_PIE_SLICE));
	public static final RegistryObject<Block> GREEN_PLUM_CRATE = BLOCKS.register("green_plum_crate",
			() -> new Block(Block.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> GREEN_PLUM_JAM = BLOCKS.register("green_plum_jam",
			() -> new JamBlock(Block.Properties.copy(Blocks.GLASS), ModItems.GREEN_PLUM_BREAD, ModItems.GREEN_PLUM_DOUGHNUT,true));
	public static final RegistryObject<Block> GREEN_PLUM_WINE_BARREL = BLOCKS.register("green_plum_wine_barrel",
			() -> new FruitWineBarrelBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(0.5F, 3.0F), ModItems.GREEN_PLUM_WINE_ONE, ModItems.GREEN_PLUM_WINE_TWO, ModItems.GREEN_PLUM_WINE_THREE, ModItems.GREEN_PLUM_WINE_FOUR, ModItems.GREEN_PLUM_WINE_FIVE, ModItems.GREEN_PLUM_WINE_SIX, ModItems.GREEN_PLUM_WINE_SEVEN, ModItems.GREEN_PLUM_WINE_EIGHT, ModItems.GREEN_PLUM_WINE_NINE, ModItems.GREEN_PLUM_WINE_TEN, ModItems.BEST_GREEN_PLUM_WINE));
	public static final RegistryObject<Block> GREEN_PLUM_POPSICLE_MACHINE = BLOCKS.register("green_plum_popsicle_machine",
			() -> new FruitPopsicleMachineBlock(BlockBehaviour.Properties.of(Material.METAL).strength(0.5F, 6.0F), ModItems.GREEN_PLUM_POPSICLE));
	//grape
	public static final RegistryObject<Block> WILD_GRAPE = BLOCKS.register("wild_grape",
			() -> new WildCropBlock(MobEffects.DAMAGE_BOOST, 6, Block.Properties.copy(Blocks.TALL_GRASS)));
	public static final RegistryObject<Block> GRAPE_CROP_BOTTOM = BLOCKS.register("grape_crop_bottom",
			() -> new GrapeBottomBlock(ModBlocks.GRAPE_CROP_MIDDLE,BlockBehaviour.Properties.of(Material.WOOD)));
	public static final RegistryObject<Block> GRAPE_CROP_MIDDLE = BLOCKS.register("grape_crop_middle",
			() -> new GrapeMiddleBlock(ModBlocks.GRAPE_CROP_TOP,BlockBehaviour.Properties.of(Material.WOOD)));
	public static final RegistryObject<Block> GRAPE_CROP_TOP = BLOCKS.register("grape_crop_top",
			() -> new GrapeTopBlock(ModBlocks.GRAPE_CROP,BlockBehaviour.Properties.of(Material.WOOD)));
	public static final RegistryObject<Block> GRAPE_CROP = BLOCKS.register("grape_crop",
			() -> new GrapeCropBlock(ModBlocks.GRAPE_CROP,BlockBehaviour.Properties.of(Material.WOOD),ModItems.GRAPE));
	public static final RegistryObject<Block> GRAPE_BRACKET_TOP = BLOCKS.register("grape_bracket_top",
			() -> new GrapeBracket(BlockBehaviour.Properties.of(Material.WOOD)));
	public static final RegistryObject<Block> GRAPE_BRACKET = BLOCKS.register("grape_bracket",
			() -> new GrapeBracket(BlockBehaviour.Properties.of(Material.WOOD)));
	public static final RegistryObject<Block> GRAPE_CAKE = BLOCKS.register("grape_cake",
			() -> new ModCakeBlock(Block.Properties.copy(Blocks.CAKE), ModItems.GRAPE_CAKE_SLICE));
	public static final RegistryObject<Block> GRAPE_PIE = BLOCKS.register("grape_pie",
			() -> new PieBlock(Block.Properties.copy(Blocks.CAKE), ModItems.GRAPE_PIE_SLICE));
	public static final RegistryObject<Block> GRAPE_CRATE = BLOCKS.register("grape_crate",
			() -> new Block(Block.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> GRAPE_JAM = BLOCKS.register("grape_jam",
			() -> new JamBlock(Block.Properties.copy(Blocks.GLASS), ModItems.GRAPE_BREAD, ModItems.GRAPE_DOUGHNUT,true));
	public static final RegistryObject<Block> SWEETENED_GRAPE = BLOCKS.register("sweetened_grape",
			() -> new DriedFruit(BlockBehaviour.Properties.of(Material.SNOW).strength(0.5F, 3.0F),ModItems.DRIED_GRAPE));
	public static final RegistryObject<Block> GRAPE_JELLY = BLOCKS.register("grape_jelly",
			() -> new GrapeJellyBlock(Block.Properties.copy(Blocks.CAKE), ModItems.GRAPE_JELLY_SLICE));
	public static final RegistryObject<Block> GRAPE_WINE_BARREL = BLOCKS.register("grape_wine_barrel",
			() -> new FruitWineBarrelBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(0.5F, 3.0F), ModItems.GRAPE_WINE_ONE, ModItems.GRAPE_WINE_TWO, ModItems.GRAPE_WINE_THREE, ModItems.GRAPE_WINE_FOUR, ModItems.GRAPE_WINE_FIVE, ModItems.GRAPE_WINE_SIX, ModItems.GRAPE_WINE_SEVEN, ModItems.GRAPE_WINE_EIGHT, ModItems.GRAPE_WINE_NINE, ModItems.GRAPE_WINE_TEN, ModItems.BEST_GRAPE_WINE));
	public static final RegistryObject<Block> GRAPE_POPSICLE_MACHINE = BLOCKS.register("grape_popsicle_machine",
			() -> new FruitPopsicleMachineBlock(BlockBehaviour.Properties.of(Material.METAL).strength(0.5F, 6.0F), ModItems.GRAPE_POPSICLE));
	//peach
	public static final RegistryObject<Block> PEACH_BLOCK = BLOCKS.register("peach_block",
			() -> new CanMineFruitBlock(Block.Properties.copy(Blocks.PUMPKIN), ModItems.PEACH_SLICE, true));
	public static final RegistryObject<Block> PEACH_SAPLING = BLOCKS.register("peach_sapling",
			() -> new PeachSapling(Block.Properties.of(Material.PLANT)
					.noCollission().randomTicks().strength(0f).sound(SoundType.CROP), 1));
	public static final RegistryObject<Block> PEACH_LOG_BIG = register("peach_log_big",
			() -> new LogBlock(BlockBehaviour.Properties.of(Material.WOOD, state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.WOOD : MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD)), fruitstack.CREATIVE_TAB);
	public static final RegistryObject<Block> PEACH_LOG_TOP = register("peach_log_top",
			() -> new LogBlock(BlockBehaviour.Properties.of(Material.WOOD, state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.WOOD : MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD)), fruitstack.CREATIVE_TAB);
	public static final RegistryObject<Block> PEACH_LEAVES = register("peach_leaves",
			() -> new ModLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(ModBlocks::ocelotOrParrot).isSuffocating((a, b, c) -> false).isViewBlocking((a, b, c) -> false)), fruitstack.CREATIVE_TAB);
	public static final RegistryObject<BlockFruitCrop> PEACH_CROP = BLOCKS.register("peach_crop",
			() -> new BlockFruitCrop(Block.Properties.of(Material.PLANT).strength(5F)
					.noCollission().randomTicks().sound(SoundType.CROP), "peach"));
	public static final RegistryObject<Block> PEACH_CAKE = BLOCKS.register("peach_cake",
			() -> new ModCakeBlock(Block.Properties.copy(Blocks.CAKE), ModItems.PEACH_CAKE_SLICE));
	public static final RegistryObject<Block> PEACH_PIE = BLOCKS.register("peach_pie",
			() -> new PieBlock(Block.Properties.copy(Blocks.CAKE), ModItems.PEACH_PIE_SLICE));
	public static final RegistryObject<Block> PEACH_CRATE = BLOCKS.register("peach_crate",
			() -> new Block(Block.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> PEACH_JAM = BLOCKS.register("peach_jam",
			() -> new JamBlock(Block.Properties.copy(Blocks.GLASS), ModItems.PEACH_BREAD, ModItems.PEACH_DOUGHNUT,true));
	public static final RegistryObject<Block> SWEETENED_PEACH = BLOCKS.register("sweetened_peach",
			() -> new DriedFruit(BlockBehaviour.Properties.of(Material.SNOW).strength(0.5F, 3.0F),ModItems.DRIED_PEACH));
	public static final RegistryObject<Block> PEACH_WINE_BARREL = BLOCKS.register("peach_wine_barrel",
			() -> new FruitWineBarrelBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(0.5F, 3.0F), ModItems.PEACH_WINE_ONE, ModItems.PEACH_WINE_TWO, ModItems.PEACH_WINE_THREE, ModItems.PEACH_WINE_FOUR, ModItems.PEACH_WINE_FIVE, ModItems.PEACH_WINE_SIX, ModItems.PEACH_WINE_SEVEN, ModItems.PEACH_WINE_EIGHT, ModItems.PEACH_WINE_NINE, ModItems.PEACH_WINE_TEN, ModItems.BEST_PEACH_WINE));
	public static final RegistryObject<Block> PEACH_POPSICLE_MACHINE = BLOCKS.register("peach_popsicle_machine",
			() -> new FruitPopsicleMachineBlock(BlockBehaviour.Properties.of(Material.METAL).strength(0.5F, 6.0F), ModItems.PEACH_POPSICLE));
	public static final RegistryObject<Block> LACTOBACILLUS_HONEY_PEACH_ICE = BLOCKS.register("lactobacillus_honey_peach_ice",
			() -> new RedFruitMaythornCake(Block.Properties.copy(Blocks.CAKE), ModItems.PEACH_POPSICLE,true));
	//zong zi
	public static final RegistryObject<Block> WILD_GLUTINOUS_RICE = BLOCKS.register("wild_glutinous_rice",
			() -> new WildCropBlock(MobEffects.DAMAGE_BOOST, 6, Block.Properties.copy(Blocks.TALL_GRASS)));
	public static final RegistryObject<Block> GLUTINOUS_RICE_BAG = BLOCKS.register("glutinous_rice_bag",
			() -> new Block(Block.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> GLUTINOUS_RICE_BALE = BLOCKS.register("glutinous_rice_bale",
			() -> new Block(Block.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ZONG_ZI_LEAVES_CROP = BLOCKS.register("zong_zi_leaves_crop",
			() -> new HolboelliaCrop(Block.Properties.copy(Blocks.WHEAT), ModItems.ZONG_ZI_LEAVES));
	public static final RegistryObject<Block> WILD_ZONG_ZI_LEAVES = BLOCKS.register("wild_zong_zi_leaves",
			() -> new WildCropBlock(MobEffects.DAMAGE_BOOST, 6, Block.Properties.copy(Blocks.TALL_GRASS)));
	public static final RegistryObject<Block> GLUTINOUS_RICE_CROP = BLOCKS.register("glutinous_rice_crop",
			() -> new GlutinousRiceBlock(Block.Properties.copy(Blocks.WHEAT).strength(0.2F)));
	public static final RegistryObject<Block> GLUTINOUS_RICE_CROP_PANICLES = BLOCKS.register("glutinous_rice_crop_panicles",
			() -> new GlutinousRicePaniclesBlock(Block.Properties.copy(Blocks.WHEAT)));
	public static final RegistryObject<Block> ZONG_ZI = BLOCKS.register("zong_zi",
			() -> new ZongZiBlock(Block.Properties.copy(Blocks.CAKE), ModItems.PEAR_BREAD,true));
	public static final RegistryObject<Block> BLUEBERRIES_AND_MANGO_ZONG_ZI = BLOCKS.register("blueberries_and_mango_zong_zi",
			() -> new ZongZiBlock(Block.Properties.copy(Blocks.CAKE), ModItems.BLUEBERRIES_BREAD,true));
	public static final RegistryObject<Block> AGREEABLE_SWEETNESS_ZONG_ZI = BLOCKS.register("agreeable_sweetness_zong_zi",
			() -> new ZongZiBlock(Block.Properties.copy(Blocks.CAKE), ModItems.MAYTHORN_DOUGHNUT,true));
	public static final RegistryObject<Block> MELON_ZONG_ZI = BLOCKS.register("melon_zong_zi",
			() -> new ZongZiBlock(Block.Properties.copy(Blocks.CAKE), ModItems.GROUND_CUCUMBER_BREAD,true));
	public static final RegistryObject<Block> CRIMSON_ZONG_ZI = BLOCKS.register("crimson_zong_zi",
			() -> new ZongZiBlock(Block.Properties.copy(Blocks.CAKE), ModItems.LITCHI_BREAD,true));
	//moon cake
	public static final RegistryObject<Block> BLUEBERRIES_MOON_CAKE = BLOCKS.register("blueberries_moon_cake",
			() -> new MoonCakeBlock(Block.Properties.copy(Blocks.CAKE), ModItems.BLUEBERRIES_PIE_SLICE));
	public static final RegistryObject<Block> HAMIMELON_MOON_CAKE = BLOCKS.register("hamimelon_moon_cake",
			() -> new MoonCakeBlock(Block.Properties.copy(Blocks.CAKE), ModItems.HAMIMELON_PIE_SLICE));
	public static final RegistryObject<Block> BEATING_MELONS_MOON_CAKE = BLOCKS.register("beating_melons_moon_cake",
			() -> new MoonCakeBlock(Block.Properties.copy(Blocks.CAKE), ModItems.BEATING_MELONS_PIE_SLICE));
	public static final RegistryObject<Block> GROUND_CUCUMBER_MOON_CAKE = BLOCKS.register("ground_cucumber_moon_cake",
			() -> new MoonCakeBlock(Block.Properties.copy(Blocks.CAKE), ModItems.GROUND_CUCUMBER_PIE_SLICE));
	public static final RegistryObject<Block> MANGO_MOON_CAKE = BLOCKS.register("mango_moon_cake",
			() -> new MoonCakeBlock(Block.Properties.copy(Blocks.CAKE), ModItems.MANGO_PIE_SLICE));
	public static final RegistryObject<Block> HOLBOELLIA_LATIFOLIA_MOON_CAKE = BLOCKS.register("holboellia_latifolia_moon_cake",
			() -> new MoonCakeBlock(Block.Properties.copy(Blocks.CAKE), ModItems.HOLBOELLIA_LATIFOLIA_PIE_SLICE));
	public static final RegistryObject<Block> LITCHI_MOON_CAKE = BLOCKS.register("litchi_moon_cake",
			() -> new MoonCakeBlock(Block.Properties.copy(Blocks.CAKE), ModItems.LITCHI_PIE_SLICE));
	public static final RegistryObject<Block> HUOSHEN_FRUIT_MOON_CAKE = BLOCKS.register("huoshen_fruit_moon_cake",
			() -> new MoonCakeBlock(Block.Properties.copy(Blocks.CAKE), ModItems.HUOSHEN_FRUIT_PIE_SLICE));
	public static final RegistryObject<Block> SEPTEMBER_MELON_MOON_CAKE = BLOCKS.register("september_melon_moon_cake",
			() -> new MoonCakeBlock(Block.Properties.copy(Blocks.CAKE), ModItems.SEPTEMBER_MELON_PIE_SLICE));
	public static final RegistryObject<Block> PITAYA_MOON_CAKE = BLOCKS.register("pitaya_moon_cake",
			() -> new MoonCakeBlock(Block.Properties.copy(Blocks.CAKE), ModItems.PITAYA_PIE_SLICE));
	public static final RegistryObject<Block> GOLDEN_PURE_SHEEP_HORN_HONEY_MOON_CAKE = BLOCKS.register("golden_pure_sheep_horn_honey_moon_cake",
			() -> new MoonCakeBlock(Block.Properties.copy(Blocks.CAKE), ModItems.GOLDEN_PURE_SHEEP_HORN_HONEY_PIE_SLICE));
	public static final RegistryObject<Block> PEAR_MOON_CAKE = BLOCKS.register("pear_moon_cake",
			() -> new MoonCakeBlock(Block.Properties.copy(Blocks.CAKE), ModItems.PEAR_PIE_SLICE));
	public static final RegistryObject<Block> MAYTHORN_MOON_CAKE = BLOCKS.register("maythorn_moon_cake",
			() -> new MoonCakeBlock(Block.Properties.copy(Blocks.CAKE), ModItems.MAYTHORN_PIE_SLICE));
	public static final RegistryObject<Block> CHINESE_PEAR_LEAVED_MOON_CAKE = BLOCKS.register("chinese_pear_leaved_moon_cake",
			() -> new MoonCakeBlock(Block.Properties.copy(Blocks.CAKE), ModItems.CHINESE_PEAR_LEAVED_PIE_SLICE));
	public static final RegistryObject<Block> PLUM_MOON_CAKE = BLOCKS.register("plum_moon_cake",
			() -> new MoonCakeBlock(Block.Properties.copy(Blocks.CAKE), ModItems.PLUM_PIE_SLICE));
	public static final RegistryObject<Block> JUJUBE_MOON_CAKE = BLOCKS.register("jujube_moon_cake",
			() -> new MoonCakeBlock(Block.Properties.copy(Blocks.CAKE), ModItems.JUJUBE_PIE_SLICE));
	public static final RegistryObject<Block> APRICOT_MOON_CAKE = BLOCKS.register("apricot_moon_cake",
			() -> new MoonCakeBlock(Block.Properties.copy(Blocks.CAKE), ModItems.APRICOT_PIE_SLICE));
	public static final RegistryObject<Block> RED_BAYBERRY_MOON_CAKE = BLOCKS.register("red_bayberry_moon_cake",
			() -> new MoonCakeBlock(Block.Properties.copy(Blocks.CAKE), ModItems.RED_BAYBERRY_PIE_SLICE));
	public static final RegistryObject<Block> GREEN_PLUM_MOON_CAKE = BLOCKS.register("green_plum_moon_cake",
			() -> new MoonCakeBlock(Block.Properties.copy(Blocks.CAKE), ModItems.GREEN_PLUM_PIE_SLICE));
	public static final RegistryObject<Block> GRAPE_MOON_CAKE = BLOCKS.register("grape_moon_cake",
			() -> new MoonCakeBlock(Block.Properties.copy(Blocks.CAKE), ModItems.GRAPE_PIE_SLICE));
	public static final RegistryObject<Block> PEACH_MOON_CAKE = BLOCKS.register("peach_moon_cake",
			() -> new MoonCakeBlock(Block.Properties.copy(Blocks.CAKE), ModItems.PEACH_PIE_SLICE));
	//rice dumpling
	public static final RegistryObject<Block> BLUEBERRIES_RICE_DUMPLING_BLOCK = BLOCKS.register("blueberries_rice_dumpling_block",
			() -> new RiceDumpling(Block.Properties.copy(Blocks.PUMPKIN), ModItems.BLUEBERRIES_RICE_DUMPLING, true));
	public static final RegistryObject<Block> HAMIMELON_RICE_DUMPLING_BLOCK = BLOCKS.register("hamimelon_rice_dumpling_block",
			() -> new RiceDumpling(Block.Properties.copy(Blocks.PUMPKIN), ModItems.HAMIMELON_RICE_DUMPLING, true));
	public static final RegistryObject<Block> BEATING_MELONS_RICE_DUMPLING_BLOCK = BLOCKS.register("beating_melons_rice_dumpling_block",
			() -> new RiceDumpling(Block.Properties.copy(Blocks.PUMPKIN), ModItems.BEATING_MELONS_RICE_DUMPLING, true));
	public static final RegistryObject<Block> GROUND_CUCUMBER_RICE_DUMPLING_BLOCK = BLOCKS.register("ground_cucumber_rice_dumpling_block",
			() -> new RiceDumpling(Block.Properties.copy(Blocks.PUMPKIN), ModItems.GROUND_CUCUMBER_RICE_DUMPLING, true));
	public static final RegistryObject<Block> MANGO_RICE_DUMPLING_BLOCK = BLOCKS.register("mango_rice_dumpling_block",
			() -> new RiceDumpling(Block.Properties.copy(Blocks.PUMPKIN), ModItems.MANGO_RICE_DUMPLING, true));
	public static final RegistryObject<Block> HOLBOELLIA_LATIFOLIA_RICE_DUMPLING_BLOCK = BLOCKS.register("holboellia_latifolia_rice_dumpling_block",
			() -> new RiceDumpling(Block.Properties.copy(Blocks.PUMPKIN), ModItems.HOLBOELLIA_LATIFOLIA_RICE_DUMPLING, true));
	public static final RegistryObject<Block> LITCHI_RICE_DUMPLING_BLOCK = BLOCKS.register("litchi_rice_dumpling_block",
			() -> new RiceDumpling(Block.Properties.copy(Blocks.PUMPKIN), ModItems.LITCHI_RICE_DUMPLING, true));
	public static final RegistryObject<Block> HUOSHEN_FRUIT_RICE_DUMPLING_BLOCK = BLOCKS.register("huoshen_fruit_rice_dumpling_block",
			() -> new RiceDumpling(Block.Properties.copy(Blocks.PUMPKIN), ModItems.HUOSHEN_FRUIT_RICE_DUMPLING, true));
	public static final RegistryObject<Block> SEPTEMBER_MELON_RICE_DUMPLING_BLOCK = BLOCKS.register("september_melon_rice_dumpling_block",
			() -> new RiceDumpling(Block.Properties.copy(Blocks.PUMPKIN), ModItems.SEPTEMBER_MELON_RICE_DUMPLING, true));
	public static final RegistryObject<Block> PITAYA_RICE_DUMPLING_BLOCK = BLOCKS.register("pitaya_rice_dumpling_block",
			() -> new RiceDumpling(Block.Properties.copy(Blocks.PUMPKIN), ModItems.PITAYA_RICE_DUMPLING, true));
	public static final RegistryObject<Block> GOLDEN_PURE_SHEEP_HORN_HONEY_RICE_DUMPLING_BLOCK = BLOCKS.register("golden_pure_sheep_horn_honey_rice_dumpling_block",
			() -> new RiceDumpling(Block.Properties.copy(Blocks.PUMPKIN), ModItems.GOLDEN_PURE_SHEEP_HORN_HONEY_RICE_DUMPLING, true));
	public static final RegistryObject<Block> PEAR_RICE_DUMPLING_BLOCK = BLOCKS.register("pear_rice_dumpling_block",
			() -> new RiceDumpling(Block.Properties.copy(Blocks.PUMPKIN), ModItems.PEAR_RICE_DUMPLING, true));
	public static final RegistryObject<Block> MAYTHORN_RICE_DUMPLING_BLOCK = BLOCKS.register("maythorn_rice_dumpling_block",
			() -> new RiceDumpling(Block.Properties.copy(Blocks.PUMPKIN), ModItems.MAYTHORN_RICE_DUMPLING, true));
	public static final RegistryObject<Block> CHINESE_PEAR_LEAVED_RICE_DUMPLING_BLOCK = BLOCKS.register("chinese_pear_leaved_rice_dumpling_block",
			() -> new RiceDumpling(Block.Properties.copy(Blocks.PUMPKIN), ModItems.CHINESE_PEAR_LEAVED_RICE_DUMPLING, true));
	public static final RegistryObject<Block> PLUM_RICE_DUMPLING_BLOCK = BLOCKS.register("plum_rice_dumpling_block",
			() -> new RiceDumpling(Block.Properties.copy(Blocks.PUMPKIN), ModItems.PLUM_RICE_DUMPLING, true));
	public static final RegistryObject<Block> JUJUBE_RICE_DUMPLING_BLOCK = BLOCKS.register("jujube_rice_dumpling_block",
			() -> new RiceDumpling(Block.Properties.copy(Blocks.PUMPKIN), ModItems.JUJUBE_RICE_DUMPLING, true));
	public static final RegistryObject<Block> APRICOT_RICE_DUMPLING_BLOCK = BLOCKS.register("apricot_rice_dumpling_block",
			() -> new RiceDumpling(Block.Properties.copy(Blocks.PUMPKIN), ModItems.APRICOT_RICE_DUMPLING, true));
	public static final RegistryObject<Block> RED_BAYBERRY_RICE_DUMPLING_BLOCK = BLOCKS.register("red_bayberry_rice_dumpling_block",
			() -> new RiceDumpling(Block.Properties.copy(Blocks.PUMPKIN), ModItems.RED_BAYBERRY_RICE_DUMPLING, true));
	public static final RegistryObject<Block> GREEN_PLUM_RICE_DUMPLING_BLOCK = BLOCKS.register("green_plum_rice_dumpling_block",
			() -> new RiceDumpling(Block.Properties.copy(Blocks.PUMPKIN), ModItems.GREEN_PLUM_RICE_DUMPLING, true));
	public static final RegistryObject<Block> GRAPE_RICE_DUMPLING_BLOCK = BLOCKS.register("grape_rice_dumpling_block",
			() -> new RiceDumpling(Block.Properties.copy(Blocks.PUMPKIN), ModItems.GRAPE_RICE_DUMPLING, true));
	public static final RegistryObject<Block> PEACH_RICE_DUMPLING_BLOCK = BLOCKS.register("peach_rice_dumpling_block",
			() -> new RiceDumpling(Block.Properties.copy(Blocks.PUMPKIN), ModItems.PEACH_RICE_DUMPLING, true));
	//pizza
	public static final RegistryObject<Block> PIZZA_DOUGH = BLOCKS.register("pizza_dough",
			() -> new PizzaBlock(BlockBehaviour.Properties.of(Material.SNOW).strength(0.5F, 6.0F)));
	public static final RegistryObject<Block> GRAPE_FRUIT_SAND_PIZZA = BLOCKS.register("grape_fruit_sand_pizza",
			() -> new CompletedPizzaBlock(Block.Properties.copy(Blocks.CAKE), ModItems.GRAPE_FRUIT_SAND_PIZZA_SLICE));
	public static final RegistryObject<Block> BLUE_RED_MANGO_PIZZA = BLOCKS.register("blue_red_mango_pizza",
			() -> new CompletedPizzaBlock(Block.Properties.copy(Blocks.CAKE), ModItems.BLUE_RED_MANGO_PIZZA_SLICE));
	public static final RegistryObject<Block> HAWTHORN_NUT_PIZZA = BLOCKS.register("hawthorn_nut_pizza",
			() -> new CompletedPizzaBlock(Block.Properties.copy(Blocks.CAKE), ModItems.HAWTHORN_NUT_PIZZA_SLICE));
	public static final RegistryObject<Block> SWEET_AND_REFRESHING_FLAVORED_PIZZA = BLOCKS.register("sweet_and_refreshing_flavored_pizza",
			() -> new CompletedPizzaBlock(Block.Properties.copy(Blocks.CAKE), ModItems.SWEET_AND_REFRESHING_FLAVORED_PIZZA_SLICE));
    //pot
	public static final RegistryObject<Block> CLAY_OVEN = BLOCKS.register("clay_oven", () -> new ClayOvenBlock(BlockBehaviour.Properties.copy(Blocks.STONE).lightLevel(litBlockEmission(13))));
	public static final RegistryObject<Block> TRIPOD_VESSEL_FOR_MAKING_PILLS_OF_IMMORTALITY = BLOCKS.register("tripod_vessel_for_making_pills_of_immortality", TvfmpoiBlock::new);
	public static final RegistryObject<Block> JUICER = BLOCKS.register("juicer", JuicerBlock::new);
	public static final RegistryObject<Block> WINE_BARREL = BLOCKS.register("wine_barrel",
			() -> new WineBarrelBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(0.5F, 3.0F)));
	public static final RegistryObject<Block> PLATE = BLOCKS.register("plate", () -> new PlateBlock(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BLOCK)));
	public static final RegistryObject<Block> BOWL_BLOCK = BLOCKS.register("bowl_block", () -> new BowlBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
	public static final RegistryObject<Block> LOW_WOODEN_BARREL = BLOCKS.register("low_wooden_barrel",
			() -> new LowWoodenBarrelBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(0.5F, 3.0F)));
	public static final RegistryObject<Block> POPSICLE_MACHINE = BLOCKS.register("popsicle_machine",
			() -> new PopsicleMachineBlock(BlockBehaviour.Properties.of(Material.METAL).strength(0.5F, 6.0F)));
	public static final RegistryObject<Block> FRYING_PAN = BLOCKS.register("frying_pan",
			() -> new FryingPanBlock(BlockBehaviour.Properties.of(Material.METAL).strength(0.5F, 6.0F)));
	public static final RegistryObject<Block> OVEN = BLOCKS.register("oven",
			() -> new OvenBlock(BlockBehaviour.Properties.of(Material.METAL).strength(0.5F, 6.0F)));
	//farmland
	public static final RegistryObject<Block> LIFE_DIRT = BLOCKS.register("life_dirt", () -> new LifeDirtBlock(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.DIRT).strength(0.5F).sound(SoundType.GRAVEL)));
	public static final RegistryObject<Block> LIFE_FARMLAND = BLOCKS.register("life_farmland",
			() -> new LifeFarmLandBlock(Block.Properties.copy(Blocks.FARMLAND)));
	public static final RegistryObject<Block> CORRUPT_SOIL = BLOCKS.register("corrupt_soil", () -> new CorruptSoilBlock(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.DIRT).strength(0.5F).sound(SoundType.GRAVEL)));
	public static final RegistryObject<Block> CORRUPT_SOIL_FARMLAND = BLOCKS.register("corrupt_soil_farmland",
			() -> new CorruptSoilFarmLandBlock(Block.Properties.copy(Blocks.FARMLAND)));
	public static final RegistryObject<Block> CORRUPT_CROP = BLOCKS.register("corrupt_crop",
			() -> new CorruptCorpBlock(Block.Properties.copy(Blocks.WHEAT)));
	//recipe
	public static final RegistryObject<Block> MANGO_RECIPE_PACKAGE = BLOCKS.register("mango_recipe_package", MangoRecipePackageBlock::new);
	public static final RegistryObject<Block> MANGO_TREE_RECIPE = BLOCKS.register("mango_tree_recipe", () -> new MangoRecipeBlock(true));
	public static final RegistryObject<Block> GREEN_MANGO_SLICE_RECIPE = BLOCKS.register("green_mango_slice_recipe", () -> new MangoRecipeBlock(true));
	public static final RegistryObject<Block> MANGO_CAKE_RECIPE = BLOCKS.register("mango_cake_recipe", () -> new MangoRecipeBlock(true));
	public static final RegistryObject<Block> MANGO_CAKE_SLICE_RECIPE = BLOCKS.register("mango_cake_slice_recipe", () -> new MangoRecipeBlock(true));
	public static final RegistryObject<Block> MANGO_COOKIE_RECIPE = BLOCKS.register("mango_cookie_recipe", () -> new MangoRecipeBlock(true));
	public static final RegistryObject<Block> MANGO_CRATE_RECIPE = BLOCKS.register("mango_crate_recipe", () -> new MangoRecipeBlock(true));
	public static final RegistryObject<Block> MANGO_JAM_RECIPE = BLOCKS.register("mango_jam_recipe", () -> new MangoRecipeBlock(true));
	public static final RegistryObject<Block> MANGO_PIE_RECIPE = BLOCKS.register("mango_pie_recipe", () -> new MangoRecipeBlock(true));
	public static final RegistryObject<Block> MANGO_PIE_SLICE_RECIPE = BLOCKS.register("mango_pie_slice_recipe", () -> new MangoRecipeBlock(true));
	public static final RegistryObject<Block> MANGO_SLICE_RECIPE = BLOCKS.register("mango_slice_recipe", () -> new MangoRecipeBlock(true));
	public static final RegistryObject<Block> MANGO_RICE_DUMPLING_BLOCK_RECIPE = BLOCKS.register("mango_rice_dumpling_block_recipe", () -> new MangoRecipeBlock(true));
	public static final RegistryObject<Block> MANGO_FILLING_RECIPE = BLOCKS.register("mango_filling_recipe", () -> new MangoRecipeBlock(true));
	public static final RegistryObject<Block> RAW_MANGO_MOON_CAKE_RECIPE = BLOCKS.register("raw_mango_moon_cake_recipe", () -> new MangoRecipeBlock(true));
	public static final RegistryObject<Block> SWEETENED_MANGO_RECIPE = BLOCKS.register("sweetened_mango_recipe", () -> new MangoRecipeBlock(true));
	public static final RegistryObject<Block> MANGO_JUICE_RECIPE = BLOCKS.register("mango_juice_recipe", () -> new MangoRecipeBlock(true));
	public static final RegistryObject<Block> MANGO_MILK_ICE_CREAM_RECIPE = BLOCKS.register("mango_milk_ice_cream_recipe", () -> new MangoRecipeBlock(true));
	public static final RegistryObject<Block> MANGO_MILK_TEA_RECIPE = BLOCKS.register("mango_milk_tea_recipe", () -> new MangoRecipeBlock(true));

	public static final RegistryObject<Block> BLUEBERRIES_RECIPE_PACKAGE = BLOCKS.register("blueberries_recipe_package", BlueberriesRecipePackageBlock::new);
	public static final RegistryObject<Block> BLUEBERRIES_CAKE_SLICE_RECIPE = BLOCKS.register("blueberries_cake_slice_recipe", () -> new BlueberriesRecipeBlock(true));
	public static final RegistryObject<Block> BLUEBERRIES_JAM_RECIPE = BLOCKS.register("blueberries_jam_recipe", () -> new BlueberriesRecipeBlock(true));
	public static final RegistryObject<Block> BLUEBERRIES_CAKE_RECIPE = BLOCKS.register("blueberries_cake_recipe", () -> new BlueberriesRecipeBlock(true));
	public static final RegistryObject<Block> BLUEBERRIES_BARQUILLO_RECIPE = BLOCKS.register("blueberries_barquillo_recipe", () -> new BlueberriesRecipeBlock(true));
	public static final RegistryObject<Block> BLUEBERRIES_PIE_RECIPE = BLOCKS.register("blueberries_pie_recipe", () -> new BlueberriesRecipeBlock(true));
	public static final RegistryObject<Block> BLUEBERRIES_PIE_SLICE_RECIPE = BLOCKS.register("blueberries_pie_slice_recipe", () -> new BlueberriesRecipeBlock(true));
	public static final RegistryObject<Block> BLUEBERRIES_COOKIE_RECIPE = BLOCKS.register("blueberries_cookie_recipe", () -> new BlueberriesRecipeBlock(true));
	public static final RegistryObject<Block> BLUEBERRIES_CRATE_RECIPE = BLOCKS.register("blueberries_crate_recipe", () -> new BlueberriesRecipeBlock(true));
	public static final RegistryObject<Block> BLUEBERRIES_RICE_DUMPLING_BLOCK_RECIPE = BLOCKS.register("blueberries_rice_dumpling_block_recipe", () -> new BlueberriesRecipeBlock(true));
	public static final RegistryObject<Block> BLUEBERRIES_FILLING_RECIPE = BLOCKS.register("blueberries_filling_recipe", () -> new BlueberriesRecipeBlock(true));
	public static final RegistryObject<Block> RAW_BLUEBERRIES_MOON_CAKE_RECIPE = BLOCKS.register("raw_blueberries_moon_cake_recipe", () -> new BlueberriesRecipeBlock(true));
	public static final RegistryObject<Block> SWEETENED_BLUEBERRIES_RECIPE = BLOCKS.register("sweetened_blueberries_recipe", () -> new BlueberriesRecipeBlock(true));
	public static final RegistryObject<Block> BLUEBERRIES_JUICE_RECIPE = BLOCKS.register("blueberries_juice_recipe", () -> new BlueberriesRecipeBlock(true));
	public static final RegistryObject<Block> BLUEBERRIES_MILK_TEA_RECIPE = BLOCKS.register("blueberries_milk_tea_recipe", () -> new BlueberriesRecipeBlock(true));

	public static final RegistryObject<Block> HAMIMELON_RECIPE_PACKAGE = BLOCKS.register("hamimelon_recipe_package", HamimelonRecipePackageBlock::new);
	public static final RegistryObject<Block> HAMIMELON_CAKE_SLICE_RECIPE = BLOCKS.register("hamimelon_cake_slice_recipe", () -> new HamimelonRecipeBlock(true));
	public static final RegistryObject<Block> HAMIMELON_COOKIE_RECIPE = BLOCKS.register("hamimelon_cookie_recipe", () -> new HamimelonRecipeBlock(true));
	public static final RegistryObject<Block> HAMIMELON_CRATE_RECIPE = BLOCKS.register("hamimelon_crate_recipe", () -> new HamimelonRecipeBlock(true));
	public static final RegistryObject<Block> HAMIMELON_JAM_RECIPE = BLOCKS.register("hamimelon_jam_recipe", () -> new HamimelonRecipeBlock(true));
	public static final RegistryObject<Block> SWEETENED_HAMIMELON_RECIPE = BLOCKS.register("sweetened_hamimelon_recipe", () -> new HamimelonRecipeBlock(true));
	public static final RegistryObject<Block> HAMIMELON_CAKE_RECIPE = BLOCKS.register("hamimelon_cake_recipe", () -> new HamimelonRecipeBlock(true));
	public static final RegistryObject<Block> HAMIMELON_PIE_RECIPE = BLOCKS.register("hamimelon_pie_recipe", () -> new HamimelonRecipeBlock(true));
	public static final RegistryObject<Block> HAMIMELON_PIE_SLICE_RECIPE = BLOCKS.register("hamimelon_pie_slice_recipe", () -> new HamimelonRecipeBlock(true));
	public static final RegistryObject<Block> FISH_SKIN_RECIPE = BLOCKS.register("fish_skin_recipe", () -> new HamimelonRecipeBlock(true));
	public static final RegistryObject<Block> SAGO_SOUP_RECIPE = BLOCKS.register("sago_soup_recipe", () -> new HamimelonRecipeBlock(true));
	public static final RegistryObject<Block> PROSCIUTTO_CANTALOUPE_RECIPE = BLOCKS.register("prosciutto_cantaloupe_recipe", () -> new HamimelonRecipeBlock(true));
	public static final RegistryObject<Block> HAMIMELON_SAGO_SOUP_BLOCK_RECIPE = BLOCKS.register("hamimelon_sago_soup_block_recipe", () -> new HamimelonRecipeBlock(true));
	public static final RegistryObject<Block> HAMIMELON_FILLING_RECIPE = BLOCKS.register("hamimelon_filling_recipe", () -> new HamimelonRecipeBlock(true));
	public static final RegistryObject<Block> RAW_HAMIMELON_MOON_CAKE_RECIPE = BLOCKS.register("raw_hamimelon_moon_cake_recipe", () -> new HamimelonRecipeBlock(true));
	public static final RegistryObject<Block> HAMIMELON_RICE_DUMPLING_BLOCK_RECIPE = BLOCKS.register("hamimelon_rice_dumpling_block_recipe", () -> new HamimelonRecipeBlock(true));
	public static final RegistryObject<Block> HAMIMELON_JUICE_RECIPE = BLOCKS.register("hamimelon_juice_recipe", () -> new HamimelonRecipeBlock(true));
	public static final RegistryObject<Block> HAMIMELON_MILK_TEA_RECIPE = BLOCKS.register("hamimelon_milk_tea_recipe", () -> new HamimelonRecipeBlock(true));

	public static final RegistryObject<Block> BEATING_MELONS_RECIPE_PACKAGE = BLOCKS.register("beating_melons_recipe_package", BeatingMelonsRecipePackageBlock::new);
	public static final RegistryObject<Block> BEATING_MELONS_CRATE_RECIPE = BLOCKS.register("beating_melons_crate_recipe", () -> new BeatingMelonsRecipeBlock(true));
	public static final RegistryObject<Block> BEATING_MELONS_CAKE_RECIPE = BLOCKS.register("beating_melons_cake_recipe", () -> new BeatingMelonsRecipeBlock(true));
	public static final RegistryObject<Block> BEATING_MELONS_CAKE_SLICE_RECIPE = BLOCKS.register("beating_melons_cake_slice_recipe", () -> new BeatingMelonsRecipeBlock(true));
	public static final RegistryObject<Block> BEATING_MELONS_JAM_RECIPE = BLOCKS.register("beating_melons_jam_recipe", () -> new BeatingMelonsRecipeBlock(true));
	public static final RegistryObject<Block> BEATING_MELONS_PIE_RECIPE = BLOCKS.register("beating_melons_pie_recipe", () -> new BeatingMelonsRecipeBlock(true));
	public static final RegistryObject<Block> BEATING_MELONS_PIE_SLICE_RECIPE = BLOCKS.register("beating_melons_pie_slice_recipe", () -> new BeatingMelonsRecipeBlock(true));
	public static final RegistryObject<Block> BEATING_MELONS_COOKIE_RECIPE = BLOCKS.register("beating_melons_cookie_recipe", () -> new BeatingMelonsRecipeBlock(true));
	public static final RegistryObject<Block> BEATING_MELONS_FILLING_RECIPE = BLOCKS.register("beating_melons_filling_recipe", () -> new BeatingMelonsRecipeBlock(true));
	public static final RegistryObject<Block> RAW_BEATING_MELONS_MOON_CAKE_RECIPE = BLOCKS.register("raw_beating_melons_moon_cake_recipe", () -> new BeatingMelonsRecipeBlock(true));
	public static final RegistryObject<Block> BEATING_MELONS_RICE_DUMPLING_BLOCK_RECIPE = BLOCKS.register("beating_melons_rice_dumpling_block_recipe", () -> new BeatingMelonsRecipeBlock(true));
	public static final RegistryObject<Block> BEATING_MELONS_JUICE_RECIPE = BLOCKS.register("beating_melons_juice_recipe", () -> new BeatingMelonsRecipeBlock(true));
	public static final RegistryObject<Block> BEATING_MELONS_MILK_TEA_RECIPE = BLOCKS.register("beating_melons_milk_tea_recipe", () -> new BeatingMelonsRecipeBlock(true));

	public static final RegistryObject<Block> GROUND_CUCUMBER_RECIPE_PACKAGE = BLOCKS.register("ground_cucumber_recipe_package", GroundCucumberRecipePackageBlock::new);
	public static final RegistryObject<Block> GROUND_CUCUMBER_CAKE_RECIPE = BLOCKS.register("ground_cucumber_cake_recipe", () -> new GroundCucumberRecipeBlock(true));
	public static final RegistryObject<Block> GROUND_CUCUMBER_CAKE_SLICE_RECIPE = BLOCKS.register("ground_cucumber_cake_slice_recipe", () -> new GroundCucumberRecipeBlock(true));
	public static final RegistryObject<Block> GROUND_CUCUMBER_COOKIE_RECIPE = BLOCKS.register("ground_cucumber_cookie_recipe", () -> new GroundCucumberRecipeBlock(true));
	public static final RegistryObject<Block> GROUND_CUCUMBER_CRATE_RECIPE = BLOCKS.register("ground_cucumber_crate_recipe", () -> new GroundCucumberRecipeBlock(true));
	public static final RegistryObject<Block> GROUND_CUCUMBER_FILLING_RECIPE = BLOCKS.register("ground_cucumber_filling_recipe", () -> new GroundCucumberRecipeBlock(true));
	public static final RegistryObject<Block> GROUND_CUCUMBER_JAM_RECIPE = BLOCKS.register("ground_cucumber_jam_recipe", () -> new GroundCucumberRecipeBlock(true));
	public static final RegistryObject<Block> GROUND_CUCUMBER_PIE_RECIPE = BLOCKS.register("ground_cucumber_pie_recipe", () -> new GroundCucumberRecipeBlock(true));
	public static final RegistryObject<Block> GROUND_CUCUMBER_PIE_SLICE_RECIPE = BLOCKS.register("ground_cucumber_pie_slice_recipe", () -> new GroundCucumberRecipeBlock(true));
	public static final RegistryObject<Block> GROUND_CUCUMBER_RICE_DUMPLING_BLOCK_RECIPE = BLOCKS.register("ground_cucumber_rice_dumpling_block_recipe", () -> new GroundCucumberRecipeBlock(true));
	public static final RegistryObject<Block> GROUND_CUCUMBER_SLICE_RECIPE = BLOCKS.register("ground_cucumber_slice_recipe", () -> new GroundCucumberRecipeBlock(true));
	public static final RegistryObject<Block> RAW_GROUND_CUCUMBER_MOON_CAKE_RECIPE = BLOCKS.register("raw_ground_cucumber_moon_cake_recipe", () -> new GroundCucumberRecipeBlock(true));
	public static final RegistryObject<Block> GROUND_CUCUMBER_JUICE_RECIPE = BLOCKS.register("ground_cucumber_juice_recipe", () -> new GroundCucumberRecipeBlock(true));
	public static final RegistryObject<Block> GROUND_CUCUMBER_MILK_TEA_RECIPE = BLOCKS.register("ground_cucumber_milk_tea_recipe", () -> new GroundCucumberRecipeBlock(true));

	public static final RegistryObject<Block> HOLBOELLIA_LATIFOLIA_RECIPE_PACKAGE = BLOCKS.register("holboellia_latifolia_recipe_package", HolboelliaLatifoliaRecipePackageBlock::new);
	public static final RegistryObject<Block> HOLBOELLIA_LATIFOLIA_CAKE_RECIPE = BLOCKS.register("holboellia_latifolia_cake_recipe", () -> new HolboelliaLatifoliaRecipeBlock(true));
	public static final RegistryObject<Block> HOLBOELLIA_LATIFOLIA_CAKE_SLICE_RECIPE = BLOCKS.register("holboellia_latifolia_cake_slice_recipe", () -> new HolboelliaLatifoliaRecipeBlock(true));
	public static final RegistryObject<Block> HOLBOELLIA_LATIFOLIA_COOKIE_RECIPE = BLOCKS.register("holboellia_latifolia_cookie_recipe", () -> new HolboelliaLatifoliaRecipeBlock(true));
	public static final RegistryObject<Block> HOLBOELLIA_LATIFOLIA_CRATE_RECIPE = BLOCKS.register("holboellia_latifolia_crate_recipe", () -> new HolboelliaLatifoliaRecipeBlock(true));
	public static final RegistryObject<Block> HOLBOELLIA_LATIFOLIA_FILLING_RECIPE = BLOCKS.register("holboellia_latifolia_filling_recipe", () -> new HolboelliaLatifoliaRecipeBlock(true));
	public static final RegistryObject<Block> HOLBOELLIA_LATIFOLIA_JAM_RECIPE = BLOCKS.register("holboellia_latifolia_jam_recipe", () -> new HolboelliaLatifoliaRecipeBlock(true));
	public static final RegistryObject<Block> HOLBOELLIA_LATIFOLIA_PIE_RECIPE = BLOCKS.register("holboellia_latifolia_pie_recipe", () -> new HolboelliaLatifoliaRecipeBlock(true));
	public static final RegistryObject<Block> HOLBOELLIA_LATIFOLIA_PIE_SLICE_RECIPE = BLOCKS.register("holboellia_latifolia_pie_slice_recipe", () -> new HolboelliaLatifoliaRecipeBlock(true));
	public static final RegistryObject<Block> HOLBOELLIA_LATIFOLIA_RICE_DUMPLING_BLOCK_RECIPE = BLOCKS.register("holboellia_latifolia_rice_dumpling_block_recipe", () -> new HolboelliaLatifoliaRecipeBlock(true));
	public static final RegistryObject<Block> HOLBOELLIA_LATIFOLIA_SLICE_RECIPE = BLOCKS.register("holboellia_latifolia_slice_recipe", () -> new HolboelliaLatifoliaRecipeBlock(true));
	public static final RegistryObject<Block> RAW_HOLBOELLIA_LATIFOLIA_MOON_CAKE_RECIPE = BLOCKS.register("raw_holboellia_latifolia_moon_cake_recipe", () -> new HolboelliaLatifoliaRecipeBlock(true));
	public static final RegistryObject<Block> ONION_TOMATO_HOLBOELLIA_LATIFOLIA_RECIPE = BLOCKS.register("onion_tomato_holboellia_latifolia_recipe", () -> new HolboelliaLatifoliaRecipeBlock(true));
	public static final RegistryObject<Block> HOLBOELLIA_LATIFOLIA_EGG_MILK_PUDDING_RECIPE = BLOCKS.register("holboellia_latifolia_egg_milk_pudding_recipe", () -> new HolboelliaLatifoliaRecipeBlock(true));
	public static final RegistryObject<Block> HOLBOELLIA_LATIFOLIA_JUICE_RECIPE = BLOCKS.register("holboellia_latifolia_juice_recipe", () -> new HolboelliaLatifoliaRecipeBlock(true));
	public static final RegistryObject<Block> HOLBOELLIA_LATIFOLIA_MILK_TEA_RECIPE = BLOCKS.register("holboellia_latifolia_milk_tea_recipe", () -> new HolboelliaLatifoliaRecipeBlock(true));

	public static final RegistryObject<Block> LITCHI_RECIPE_PACKAGE = BLOCKS.register("litchi_recipe_package", LitchiRecipePackageBlock::new);
	public static final RegistryObject<Block> LITCHI_CAKE_RECIPE = BLOCKS.register("litchi_cake_recipe", () -> new LitchiRecipeBlock(true));
	public static final RegistryObject<Block> LITCHI_CAKE_SLICE_RECIPE = BLOCKS.register("litchi_cake_slice_recipe", () -> new LitchiRecipeBlock(true));
	public static final RegistryObject<Block> LITCHI_COOKIE_RECIPE = BLOCKS.register("litchi_cookie_recipe", () -> new LitchiRecipeBlock(true));
	public static final RegistryObject<Block> LITCHI_CRATE_RECIPE = BLOCKS.register("litchi_crate_recipe", () -> new LitchiRecipeBlock(true));
	public static final RegistryObject<Block> LITCHI_FILLING_RECIPE = BLOCKS.register("litchi_filling_recipe", () -> new LitchiRecipeBlock(true));
	public static final RegistryObject<Block> LITCHI_JAM_RECIPE = BLOCKS.register("litchi_jam_recipe", () -> new LitchiRecipeBlock(true));
	public static final RegistryObject<Block> LITCHI_PIE_RECIPE = BLOCKS.register("litchi_pie_recipe", () -> new LitchiRecipeBlock(true));
	public static final RegistryObject<Block> LITCHI_PIE_SLICE_RECIPE = BLOCKS.register("litchi_pie_slice_recipe", () -> new LitchiRecipeBlock(true));
	public static final RegistryObject<Block> LITCHI_RICE_DUMPLING_BLOCK_RECIPE = BLOCKS.register("litchi_rice_dumpling_block_recipe", () -> new LitchiRecipeBlock(true));
	public static final RegistryObject<Block> LITCHI_SLICE_RECIPE = BLOCKS.register("litchi_slice_recipe", () -> new LitchiRecipeBlock(true));
	public static final RegistryObject<Block> RAW_LITCHI_MOON_CAKE_RECIPE = BLOCKS.register("raw_litchi_moon_cake_recipe", () -> new LitchiRecipeBlock(true));
	public static final RegistryObject<Block> LITCHI_JUICE_RECIPE = BLOCKS.register("litchi_juice_recipe", () -> new LitchiRecipeBlock(true));
	public static final RegistryObject<Block> BOWLED_LITCHI_RIVER_NOODLES_RECIPE = BLOCKS.register("bowled_litchi_river_noodles_recipe", () -> new LitchiRecipeBlock(true));
	public static final RegistryObject<Block> LITCHI_ICE_CREAM_REICPE = BLOCKS.register("litchi_ice_cream_recipe", () -> new LitchiRecipeBlock(true));
	public static final RegistryObject<Block> LITCHI_SAPLING_REICPE = BLOCKS.register("litchi_sapling_recipe", () -> new LitchiRecipeBlock(true));
	public static final RegistryObject<Block> SWEETENED_LITCHI_REICPE = BLOCKS.register("sweetened_litchi_recipe", () -> new LitchiRecipeBlock(true));
	public static final RegistryObject<Block> UNFORMED_LITCHI_RIVER_DOUGH_REICPE = BLOCKS.register("unformed_litchi_river_dough_recipe", () -> new LitchiRecipeBlock(true));
	public static final RegistryObject<Block> LITCHI_MILK_TEA_RECIPE = BLOCKS.register("litchi_milk_tea_recipe", () -> new LitchiRecipeBlock(true));

	public static final RegistryObject<Block> HUOSHEN_FRUIT_RECIPE_PACKAGE = BLOCKS.register("huoshen_fruit_recipe_package", HuoShenFruitRecipePackageBlock::new);
	public static final RegistryObject<Block> HUOSHEN_FRUIT_CAKE_RECIPE = BLOCKS.register("huoshen_fruit_cake_recipe", () -> new HuoShenFruitRecipeBlock(true));
	public static final RegistryObject<Block> HUOSHEN_FRUIT_CAKE_SLICE_RECIPE = BLOCKS.register("huoshen_fruit_cake_slice_recipe", () -> new HuoShenFruitRecipeBlock(true));
	public static final RegistryObject<Block> HUOSHEN_FRUIT_COOKIE_RECIPE = BLOCKS.register("huoshen_fruit_cookie_recipe", () -> new HuoShenFruitRecipeBlock(true));
	public static final RegistryObject<Block> HUOSHEN_FRUIT_CRATE_RECIPE = BLOCKS.register("huoshen_fruit_crate_recipe", () -> new HuoShenFruitRecipeBlock(true));
	public static final RegistryObject<Block> HUOSHEN_FRUIT_FILLING_RECIPE = BLOCKS.register("huoshen_fruit_filling_recipe", () -> new HuoShenFruitRecipeBlock(true));
	public static final RegistryObject<Block> HUOSHEN_FRUIT_JAM_RECIPE = BLOCKS.register("huoshen_fruit_jam_recipe", () -> new HuoShenFruitRecipeBlock(true));
	public static final RegistryObject<Block> HUOSHEN_FRUIT_PIE_RECIPE = BLOCKS.register("huoshen_fruit_pie_recipe", () -> new HuoShenFruitRecipeBlock(true));
	public static final RegistryObject<Block> HUOSHEN_FRUIT_PIE_SLICE_RECIPE = BLOCKS.register("huoshen_fruit_pie_slice_recipe", () -> new HuoShenFruitRecipeBlock(true));
	public static final RegistryObject<Block> HUOSHEN_FRUIT_RICE_DUMPLING_BLOCK_RECIPE = BLOCKS.register("huoshen_fruit_rice_dumpling_block_recipe", () -> new HuoShenFruitRecipeBlock(true));
	public static final RegistryObject<Block> HUOSHEN_FRUIT_SLICE_RECIPE = BLOCKS.register("huoshen_fruit_slice_recipe", () -> new HuoShenFruitRecipeBlock(true));
	public static final RegistryObject<Block> RAW_HUOSHEN_FRUIT_MOON_CAKE_RECIPE = BLOCKS.register("raw_huoshen_fruit_moon_cake_recipe", () -> new HuoShenFruitRecipeBlock(true));
	public static final RegistryObject<Block> HUOSHEN_FRUIT_JUICE_RECIPE = BLOCKS.register("huoshen_fruit_juice_recipe", () -> new HuoShenFruitRecipeBlock(true));
	public static final RegistryObject<Block> HUOSHEN_FRUIT_HONEY_SAUCE_RECIPE = BLOCKS.register("huoshen_fruit_honey_sauce_recipe", () -> new HuoShenFruitRecipeBlock(true));
	public static final RegistryObject<Block> HUOSHEN_FRUIT_SEEDS_RECIPE = BLOCKS.register("huoshen_fruit_seeds_recipe", () -> new HuoShenFruitRecipeBlock(true));
	public static final RegistryObject<Block> HUOSHEN_FRUIT_MILK_TEA_RECIPE = BLOCKS.register("huoshen_fruit_milk_tea_recipe", () -> new HuoShenFruitRecipeBlock(true));

	public static final RegistryObject<Block> SEPTEMBER_MELON_RECIPE_PACKAGE = BLOCKS.register("september_melon_recipe_package", SeptemberMelonRecipePackageBlock::new);
	public static final RegistryObject<Block> SEPTEMBER_MELON_CAKE_RECIPE = BLOCKS.register("september_melon_cake_recipe", () -> new SeptemberMelonRecipeBlock(true));
	public static final RegistryObject<Block> SEPTEMBER_MELON_CAKE_SLICE_RECIPE = BLOCKS.register("september_melon_cake_slice_recipe", () -> new SeptemberMelonRecipeBlock(true));
	public static final RegistryObject<Block> SEPTEMBER_MELON_COOKIE_RECIPE = BLOCKS.register("september_melon_cookie_recipe", () -> new SeptemberMelonRecipeBlock(true));
	public static final RegistryObject<Block> SEPTEMBER_MELON_CRATE_RECIPE = BLOCKS.register("september_melon_crate_recipe", () -> new SeptemberMelonRecipeBlock(true));
	public static final RegistryObject<Block> SEPTEMBER_MELON_FILLING_RECIPE = BLOCKS.register("september_melon_filling_recipe", () -> new SeptemberMelonRecipeBlock(true));
	public static final RegistryObject<Block> SEPTEMBER_MELON_JAM_RECIPE = BLOCKS.register("september_melon_jam_recipe", () -> new SeptemberMelonRecipeBlock(true));
	public static final RegistryObject<Block> SEPTEMBER_MELON_PIE_RECIPE = BLOCKS.register("september_melon_pie_recipe", () -> new SeptemberMelonRecipeBlock(true));
	public static final RegistryObject<Block> SEPTEMBER_MELON_PIE_SLICE_RECIPE = BLOCKS.register("september_melon_pie_slice_recipe", () -> new SeptemberMelonRecipeBlock(true));
	public static final RegistryObject<Block> SEPTEMBER_MELON_RICE_DUMPLING_BLOCK_RECIPE = BLOCKS.register("september_melon_rice_dumpling_block_recipe", () -> new SeptemberMelonRecipeBlock(true));
	public static final RegistryObject<Block> RAW_SEPTEMBER_MELON_MOON_CAKE_RECIPE = BLOCKS.register("raw_september_melon_moon_cake_recipe", () -> new SeptemberMelonRecipeBlock(true));
	public static final RegistryObject<Block> SEPTEMBER_MELON_JUICE_RECIPE = BLOCKS.register("september_melon_juice_recipe", () -> new SeptemberMelonRecipeBlock(true));
	public static final RegistryObject<Block> SEPTEMBER_MELON_SEEDS_RECIPE = BLOCKS.register("september_melon_seeds_recipe", () -> new SeptemberMelonRecipeBlock(true));
	public static final RegistryObject<Block> SEPTEMBER_MELON_MILK_TEA_RECIPE = BLOCKS.register("september_melon_milk_tea_recipe", () -> new SeptemberMelonRecipeBlock(true));

	public static final RegistryObject<Block> PITAYA_RECIPE_PACKAGE = BLOCKS.register("pitaya_recipe_package", PitayaRecipePackageBlock::new);
	public static final RegistryObject<Block> PITAYA_CAKE_RECIPE = BLOCKS.register("pitaya_cake_recipe", () -> new PitayaRecipeBlock(true));
	public static final RegistryObject<Block> PITAYA_CAKE_SLICE_RECIPE = BLOCKS.register("pitaya_cake_slice_recipe", () -> new PitayaRecipeBlock(true));
	public static final RegistryObject<Block> PITAYA_COOKIE_RECIPE = BLOCKS.register("pitaya_cookie_recipe", () -> new PitayaRecipeBlock(true));
	public static final RegistryObject<Block> PITAYA_CRATE_RECIPE = BLOCKS.register("pitaya_crate_recipe", () -> new PitayaRecipeBlock(true));
	public static final RegistryObject<Block> PITAYA_FILLING_RECIPE = BLOCKS.register("pitaya_filling_recipe", () -> new PitayaRecipeBlock(true));
	public static final RegistryObject<Block> PITAYA_JAM_RECIPE = BLOCKS.register("pitaya_jam_recipe", () -> new PitayaRecipeBlock(true));
	public static final RegistryObject<Block> PITAYA_PIE_RECIPE = BLOCKS.register("pitaya_pie_recipe", () -> new PitayaRecipeBlock(true));
	public static final RegistryObject<Block> PITAYA_PIE_SLICE_RECIPE = BLOCKS.register("pitaya_pie_slice_recipe", () -> new PitayaRecipeBlock(true));
	public static final RegistryObject<Block> PITAYA_RICE_DUMPLING_BLOCK_RECIPE = BLOCKS.register("pitaya_rice_dumpling_block_recipe", () -> new PitayaRecipeBlock(true));
	public static final RegistryObject<Block> RAW_PITAYA_MOON_CAKE_RECIPE = BLOCKS.register("raw_pitaya_moon_cake_recipe", () -> new PitayaRecipeBlock(true));
	public static final RegistryObject<Block> PITAYA_JUICE_RECIPE = BLOCKS.register("pitaya_juice_recipe", () -> new PitayaRecipeBlock(true));
	public static final RegistryObject<Block> PITAYA_SLICE_RECIPE = BLOCKS.register("pitaya_slice_recipe", () -> new PitayaRecipeBlock(true));
	public static final RegistryObject<Block> SWEETENED_PITAYA_RECIPE = BLOCKS.register("sweetened_pitaya_recipe", () -> new PitayaRecipeBlock(true));
	public static final RegistryObject<Block> COLORFUL_FRUIT_SALAD_BLOCK_RECIPE = BLOCKS.register("colorful_fruit_salad_block_recipe", () -> new PitayaRecipeBlock(true));
	public static final RegistryObject<Block> PITAYA_RICE_AND_VEGETABLE_ROLL_RECIPE = BLOCKS.register("pitaya_rice_and_vegetable_roll_recipe", () -> new PitayaRecipeBlock(true));
	public static final RegistryObject<Block> PITAYA_MILK_TEA_RECIPE = BLOCKS.register("pitaya_milk_tea_recipe", () -> new PitayaRecipeBlock(true));

	public static final RegistryObject<Block> GOLDEN_PURE_SHEEP_HORN_HONEY_RECIPE_PACKAGE = BLOCKS.register("golden_pure_sheep_horn_honey_recipe_package", GoldenPureSheepHornHoneyRecipePackageBlock::new);
	public static final RegistryObject<Block> GOLDEN_PURE_SHEEP_HORN_HONEY_CAKE_RECIPE = BLOCKS.register("golden_pure_sheep_horn_honey_cake_recipe", () -> new GoldenPureSheepHornHoneyRecipeBlock(true));
	public static final RegistryObject<Block> GOLDEN_PURE_SHEEP_HORN_HONEY_CAKE_SLICE_RECIPE = BLOCKS.register("golden_pure_sheep_horn_honey_cake_slice_recipe", () -> new GoldenPureSheepHornHoneyRecipeBlock(true));
	public static final RegistryObject<Block> GOLDEN_PURE_SHEEP_HORN_HONEY_COOKIE_RECIPE = BLOCKS.register("golden_pure_sheep_horn_honey_cookie_recipe", () -> new GoldenPureSheepHornHoneyRecipeBlock(true));
	public static final RegistryObject<Block> GOLDEN_PURE_SHEEP_HORN_HONEY_CRATE_RECIPE = BLOCKS.register("golden_pure_sheep_horn_honey_crate_recipe", () -> new GoldenPureSheepHornHoneyRecipeBlock(true));
	public static final RegistryObject<Block> GOLDEN_PURE_SHEEP_HORN_HONEY_FILLING_RECIPE = BLOCKS.register("golden_pure_sheep_horn_honey_filling_recipe", () -> new GoldenPureSheepHornHoneyRecipeBlock(true));
	public static final RegistryObject<Block> GOLDEN_PURE_SHEEP_HORN_HONEY_JAM_RECIPE = BLOCKS.register("golden_pure_sheep_horn_honey_jam_recipe", () -> new GoldenPureSheepHornHoneyRecipeBlock(true));
	public static final RegistryObject<Block> GOLDEN_PURE_SHEEP_HORN_HONEY_PIE_RECIPE = BLOCKS.register("golden_pure_sheep_horn_honey_pie_recipe", () -> new GoldenPureSheepHornHoneyRecipeBlock(true));
	public static final RegistryObject<Block> GOLDEN_PURE_SHEEP_HORN_HONEY_PIE_SLICE_RECIPE = BLOCKS.register("golden_pure_sheep_horn_honey_pie_slice_recipe", () -> new GoldenPureSheepHornHoneyRecipeBlock(true));
	public static final RegistryObject<Block> GOLDEN_PURE_SHEEP_HORN_HONEY_RICE_DUMPLING_BLOCK_RECIPE = BLOCKS.register("golden_pure_sheep_horn_honey_rice_dumpling_block_recipe", () -> new GoldenPureSheepHornHoneyRecipeBlock(true));
	public static final RegistryObject<Block> RAW_GOLDEN_PURE_SHEEP_HORN_HONEY_MOON_CAKE_RECIPE = BLOCKS.register("raw_golden_pure_sheep_horn_honey_moon_cake_recipe", () -> new GoldenPureSheepHornHoneyRecipeBlock(true));
	public static final RegistryObject<Block> GOLDEN_PURE_SHEEP_HORN_HONEY_JUICE_RECIPE = BLOCKS.register("golden_pure_sheep_horn_honey_juice_recipe", () -> new GoldenPureSheepHornHoneyRecipeBlock(true));
	public static final RegistryObject<Block> GOLDEN_PURE_SHEEP_HORN_HONEY_SLICE_RECIPE = BLOCKS.register("golden_pure_sheep_horn_honey_slice_recipe", () -> new GoldenPureSheepHornHoneyRecipeBlock(true));
	public static final RegistryObject<Block> GOLDEN_PURE_SHEEP_HORN_HONEY_SEEDS_RECIPE = BLOCKS.register("golden_pure_sheep_horn_honey_seeds_recipe", () -> new GoldenPureSheepHornHoneyRecipeBlock(true));
	public static final RegistryObject<Block> GOLDEN_PURE_SHEEP_HORN_HONEY_FLAVOR_GOLDEN_PURE_SHEEP_HORN_HONEY_RECIPE = BLOCKS.register("golden_pure_sheep_horn_honey_flavor_golden_pure_sheep_horn_honey_recipe", () -> new GoldenPureSheepHornHoneyRecipeBlock(true));
	public static final RegistryObject<Block> GOLDEN_PURE_SHEEP_HORN_HONEY_MILK_TEA_RECIPE = BLOCKS.register("golden_pure_sheep_horn_honey_milk_tea_recipe", () -> new GoldenPureSheepHornHoneyRecipeBlock(true));

	public static final RegistryObject<Block> PEAR_RECIPE_PACKAGE = BLOCKS.register("pear_recipe_package", PearRecipePackageBlock::new);
	public static final RegistryObject<Block> PEAR_CAKE_RECIPE = BLOCKS.register("pear_cake_recipe", () -> new PearRecipeBlock(true));
	public static final RegistryObject<Block> PEAR_CAKE_SLICE_RECIPE = BLOCKS.register("pear_cake_slice_recipe", () -> new PearRecipeBlock(true));
	public static final RegistryObject<Block> PEAR_COOKIE_RECIPE = BLOCKS.register("pear_cookie_recipe", () -> new PearRecipeBlock(true));
	public static final RegistryObject<Block> PEAR_CRATE_RECIPE = BLOCKS.register("pear_crate_recipe", () -> new PearRecipeBlock(true));
	public static final RegistryObject<Block> PEAR_FILLING_RECIPE = BLOCKS.register("pear_filling_recipe", () -> new PearRecipeBlock(true));
	public static final RegistryObject<Block> PEAR_JAM_RECIPE = BLOCKS.register("pear_jam_recipe", () -> new PearRecipeBlock(true));
	public static final RegistryObject<Block> PEAR_PIE_RECIPE = BLOCKS.register("pear_pie_recipe", () -> new PearRecipeBlock(true));
	public static final RegistryObject<Block> PEAR_PIE_SLICE_RECIPE = BLOCKS.register("pear_pie_slice_recipe", () -> new PearRecipeBlock(true));
	public static final RegistryObject<Block> PEAR_RICE_DUMPLING_BLOCK_RECIPE = BLOCKS.register("pear_rice_dumpling_block_recipe", () -> new PearRecipeBlock(true));
	public static final RegistryObject<Block> RAW_PEAR_MOON_CAKE_RECIPE = BLOCKS.register("raw_pear_moon_cake_recipe", () -> new PearRecipeBlock(true));
	public static final RegistryObject<Block> PEAR_JUICE_RECIPE = BLOCKS.register("pear_juice_recipe", () -> new PearRecipeBlock(true));
	public static final RegistryObject<Block> PEAR_SLICE_RECIPE = BLOCKS.register("pear_slice_recipe", () -> new PearRecipeBlock(true));
	public static final RegistryObject<Block> PEAR_SAPLING_RECIPE = BLOCKS.register("pear_sapling_recipe", () -> new PearRecipeBlock(true));
	public static final RegistryObject<Block> ROCK_SUGAR_SNOW_PEAR_RECIPE = BLOCKS.register("rock_sugar_snow_pear_recipe", () -> new PearRecipeBlock(true));
	public static final RegistryObject<Block> PEAR_MILK_TEA_RECIPE = BLOCKS.register("pear_milk_tea_recipe", () -> new PearRecipeBlock(true));

	public static final RegistryObject<Block> MAYTHORN_RECIPE_PACKAGE = BLOCKS.register("maythorn_recipe_package", MaythornRecipePackageBlock::new);
	public static final RegistryObject<Block> MAYTHORN_CAKE_RECIPE = BLOCKS.register("maythorn_cake_recipe", () -> new MaythornRecipeBlock(true));
	public static final RegistryObject<Block> MAYTHORN_CAKE_SLICE_RECIPE = BLOCKS.register("maythorn_cake_slice_recipe", () -> new MaythornRecipeBlock(true));
	public static final RegistryObject<Block> MAYTHORN_COOKIE_RECIPE = BLOCKS.register("maythorn_cookie_recipe", () -> new MaythornRecipeBlock(true));
	public static final RegistryObject<Block> MAYTHORN_CRATE_RECIPE = BLOCKS.register("maythorn_crate_recipe", () -> new MaythornRecipeBlock(true));
	public static final RegistryObject<Block> MAYTHORN_FILLING_RECIPE = BLOCKS.register("maythorn_filling_recipe", () -> new MaythornRecipeBlock(true));
	public static final RegistryObject<Block> MAYTHORN_JAM_RECIPE = BLOCKS.register("maythorn_jam_recipe", () -> new MaythornRecipeBlock(true));
	public static final RegistryObject<Block> MAYTHORN_PIE_RECIPE = BLOCKS.register("maythorn_pie_recipe", () -> new MaythornRecipeBlock(true));
	public static final RegistryObject<Block> MAYTHORN_PIE_SLICE_RECIPE = BLOCKS.register("maythorn_pie_slice_recipe", () -> new MaythornRecipeBlock(true));
	public static final RegistryObject<Block> MAYTHORN_RICE_DUMPLING_BLOCK_RECIPE = BLOCKS.register("maythorn_rice_dumpling_block_recipe", () -> new MaythornRecipeBlock(true));
	public static final RegistryObject<Block> RAW_MAYTHORN_MOON_CAKE_RECIPE = BLOCKS.register("raw_maythorn_moon_cake_recipe", () -> new MaythornRecipeBlock(true));
	public static final RegistryObject<Block> MAYTHORN_JUICE_RECIPE = BLOCKS.register("maythorn_juice_recipe", () -> new MaythornRecipeBlock(true));
	public static final RegistryObject<Block> SWEETENED_MAYTHORN_RECIPE = BLOCKS.register("sweetened_maythorn_recipe", () -> new MaythornRecipeBlock(true));
	public static final RegistryObject<Block> MAYTHORN_SAPLING_RECIPE = BLOCKS.register("maythorn_sapling_recipe", () -> new MaythornRecipeBlock(true));
	public static final RegistryObject<Block> CANDIED_HAWS_ON_A_STICK_RECIPE = BLOCKS.register("candied_haws_on_a_stick_recipe", () -> new MaythornRecipeBlock(true));
	public static final RegistryObject<Block> BOWLED_CANDIED_HAWS_ON_A_STICK_RECIPE = BLOCKS.register("bowled_candied_haws_on_a_stick_recipe", () -> new MaythornRecipeBlock(true));
	public static final RegistryObject<Block> A_BUNDLE_OF_CANDIED_HAWS_ON_A_STICK_RECIPE = BLOCKS.register("a_bundle_of_candied_haws_on_a_stick_recipe", () -> new MaythornRecipeBlock(true));
	public static final RegistryObject<Block> RED_FRUIT_MAYTHORN_CAKE_RECIPE = BLOCKS.register("red_fruit_maythorn_cake_recipe", () -> new MaythornRecipeBlock(true));
	public static final RegistryObject<Block> MAYTHORN_MILK_TEA_RECIPE = BLOCKS.register("maythorn_milk_tea_recipe", () -> new MaythornRecipeBlock(true));

	public static final RegistryObject<Block> CHINESE_PEAR_LEAVED_RECIPE_PACKAGE = BLOCKS.register("chinese_pear_leaved_recipe_package", ChinesePearLeavedRecipePackageBlock::new);
	public static final RegistryObject<Block> CHINESE_PEAR_LEAVED_CAKE_RECIPE = BLOCKS.register("chinese_pear_leaved_cake_recipe", () -> new ChinesePearLeavedRecipeBlock(true));
	public static final RegistryObject<Block> CHINESE_PEAR_LEAVED_CAKE_SLICE_RECIPE = BLOCKS.register("chinese_pear_leaved_cake_slice_recipe", () -> new ChinesePearLeavedRecipeBlock(true));
	public static final RegistryObject<Block> CHINESE_PEAR_LEAVED_COOKIE_RECIPE = BLOCKS.register("chinese_pear_leaved_cookie_recipe", () -> new ChinesePearLeavedRecipeBlock(true));
	public static final RegistryObject<Block> CHINESE_PEAR_LEAVED_CRATE_RECIPE = BLOCKS.register("chinese_pear_leaved_crate_recipe", () -> new ChinesePearLeavedRecipeBlock(true));
	public static final RegistryObject<Block> CHINESE_PEAR_LEAVED_FILLING_RECIPE = BLOCKS.register("chinese_pear_leaved_filling_recipe", () -> new ChinesePearLeavedRecipeBlock(true));
	public static final RegistryObject<Block> CHINESE_PEAR_LEAVED_JAM_RECIPE = BLOCKS.register("chinese_pear_leaved_jam_recipe", () -> new ChinesePearLeavedRecipeBlock(true));
	public static final RegistryObject<Block> CHINESE_PEAR_LEAVED_PIE_RECIPE = BLOCKS.register("chinese_pear_leaved_pie_recipe", () -> new ChinesePearLeavedRecipeBlock(true));
	public static final RegistryObject<Block> CHINESE_PEAR_LEAVED_PIE_SLICE_RECIPE = BLOCKS.register("chinese_pear_leaved_pie_slice_recipe", () -> new ChinesePearLeavedRecipeBlock(true));
	public static final RegistryObject<Block> CHINESE_PEAR_LEAVED_RICE_DUMPLING_BLOCK_RECIPE = BLOCKS.register("chinese_pear_leaved_rice_dumpling_block_recipe", () -> new ChinesePearLeavedRecipeBlock(true));
	public static final RegistryObject<Block> RAW_CHINESE_PEAR_LEAVED_MOON_CAKE_RECIPE = BLOCKS.register("raw_chinese_pear_leaved_moon_cake_recipe", () -> new ChinesePearLeavedRecipeBlock(true));
	public static final RegistryObject<Block> CHINESE_PEAR_LEAVED_JUICE_RECIPE = BLOCKS.register("chinese_pear_leaved_juice_recipe", () -> new ChinesePearLeavedRecipeBlock(true));
	public static final RegistryObject<Block> CHINESE_PEAR_LEAVED_SAPLING_RECIPE = BLOCKS.register("chinese_pear_leaved_sapling_recipe", () -> new ChinesePearLeavedRecipeBlock(true));
	public static final RegistryObject<Block> CHINESE_PEAR_LEAVED_ROLLS_RECIPE = BLOCKS.register("chinese_pear_leaved_rolls_recipe", () -> new ChinesePearLeavedRecipeBlock(true));
	public static final RegistryObject<Block> CHINESE_PEAR_LEAVED_MILK_TEA_RECIPE = BLOCKS.register("chinese_pear_leaved_milk_tea_recipe", () -> new ChinesePearLeavedRecipeBlock(true));

	public static final RegistryObject<Block> PLUM_RECIPE_PACKAGE = BLOCKS.register("plum_recipe_package", PlumRecipePackageBlock::new);
	public static final RegistryObject<Block> PLUM_CAKE_RECIPE = BLOCKS.register("plum_cake_recipe", () -> new PlumRecipeBlock(true));
	public static final RegistryObject<Block> PLUM_CAKE_SLICE_RECIPE = BLOCKS.register("plum_cake_slice_recipe", () -> new PlumRecipeBlock(true));
	public static final RegistryObject<Block> PLUM_COOKIE_RECIPE = BLOCKS.register("plum_cookie_recipe", () -> new PlumRecipeBlock(true));
	public static final RegistryObject<Block> PLUM_CRATE_RECIPE = BLOCKS.register("plum_crate_recipe", () -> new PlumRecipeBlock(true));
	public static final RegistryObject<Block> PLUM_FILLING_RECIPE = BLOCKS.register("plum_filling_recipe", () -> new PlumRecipeBlock(true));
	public static final RegistryObject<Block> PLUM_JAM_RECIPE = BLOCKS.register("plum_jam_recipe", () -> new PlumRecipeBlock(true));
	public static final RegistryObject<Block> PLUM_PIE_RECIPE = BLOCKS.register("plum_pie_recipe", () -> new PlumRecipeBlock(true));
	public static final RegistryObject<Block> PLUM_PIE_SLICE_RECIPE = BLOCKS.register("plum_pie_slice_recipe", () -> new PlumRecipeBlock(true));
	public static final RegistryObject<Block> PLUM_RICE_DUMPLING_BLOCK_RECIPE = BLOCKS.register("plum_rice_dumpling_block_recipe", () -> new PlumRecipeBlock(true));
	public static final RegistryObject<Block> RAW_PLUM_MOON_CAKE_RECIPE = BLOCKS.register("raw_plum_moon_cake_recipe", () -> new PlumRecipeBlock(true));
	public static final RegistryObject<Block> PLUM_JUICE_RECIPE = BLOCKS.register("plum_juice_recipe", () -> new PlumRecipeBlock(true));
	public static final RegistryObject<Block> SWEETENED_PLUM_RECIPE = BLOCKS.register("sweetened_plum_recipe", () -> new PlumRecipeBlock(true));
	public static final RegistryObject<Block> PLUM_SAPLING_RECIPE = BLOCKS.register("plum_sapling_recipe", () -> new PlumRecipeBlock(true));
	public static final RegistryObject<Block> SOUR_AND_SWEET_PLUM_CAKE_RECIPE = BLOCKS.register("sour_and_sweet_plum_cake_recipe", () -> new PlumRecipeBlock(true));
	public static final RegistryObject<Block> PLUM_MILK_TEA_RECIPE = BLOCKS.register("plum_milk_tea_recipe", () -> new PlumRecipeBlock(true));

	public static final RegistryObject<Block> JUJUBE_RECIPE_PACKAGE = BLOCKS.register("jujube_recipe_package", JujubeRecipePackageBlock::new);
	public static final RegistryObject<Block> JUJUBE_CAKE_RECIPE = BLOCKS.register("jujube_cake_recipe", () -> new JujubeRecipeBlock(true));
	public static final RegistryObject<Block> JUJUBE_CAKE_SLICE_RECIPE = BLOCKS.register("jujube_cake_slice_recipe", () -> new JujubeRecipeBlock(true));
	public static final RegistryObject<Block> JUJUBE_COOKIE_RECIPE = BLOCKS.register("jujube_cookie_recipe", () -> new JujubeRecipeBlock(true));
	public static final RegistryObject<Block> JUJUBE_CRATE_RECIPE = BLOCKS.register("jujube_crate_recipe", () -> new JujubeRecipeBlock(true));
	public static final RegistryObject<Block> JUJUBE_FILLING_RECIPE = BLOCKS.register("jujube_filling_recipe", () -> new JujubeRecipeBlock(true));
	public static final RegistryObject<Block> JUJUBE_JAM_RECIPE = BLOCKS.register("jujube_jam_recipe", () -> new JujubeRecipeBlock(true));
	public static final RegistryObject<Block> JUJUBE_PIE_RECIPE = BLOCKS.register("jujube_pie_recipe", () -> new JujubeRecipeBlock(true));
	public static final RegistryObject<Block> JUJUBE_PIE_SLICE_RECIPE = BLOCKS.register("jujube_pie_slice_recipe", () -> new JujubeRecipeBlock(true));
	public static final RegistryObject<Block> JUJUBE_RICE_DUMPLING_BLOCK_RECIPE = BLOCKS.register("jujube_rice_dumpling_block_recipe", () -> new JujubeRecipeBlock(true));
	public static final RegistryObject<Block> RAW_JUJUBE_MOON_CAKE_RECIPE = BLOCKS.register("raw_jujube_moon_cake_recipe", () -> new JujubeRecipeBlock(true));
	public static final RegistryObject<Block> JUJUBE_JUICE_RECIPE = BLOCKS.register("jujube_juice_recipe", () -> new JujubeRecipeBlock(true));
	public static final RegistryObject<Block> SWEETENED_JUJUBE_RECIPE = BLOCKS.register("sweetened_jujube_recipe", () -> new JujubeRecipeBlock(true));
	public static final RegistryObject<Block> JUJUBE_SAPLING_RECIPE = BLOCKS.register("jujube_sapling_recipe", () -> new JujubeRecipeBlock(true));
	public static final RegistryObject<Block> RED_GATE_GLUTINOUS_RICE_RECIPE = BLOCKS.register("red_gate_glutinous_rice_recipe", () -> new JujubeRecipeBlock(true));
	public static final RegistryObject<Block> JUJUBE_MILK_TEA_RECIPE = BLOCKS.register("jujube_milk_tea_recipe", () -> new JujubeRecipeBlock(true));

	public static final RegistryObject<Block> APRICOT_RECIPE_PACKAGE = BLOCKS.register("apricot_recipe_package", ApricotRecipePackageBlock::new);
	public static final RegistryObject<Block> APRICOT_CAKE_RECIPE = BLOCKS.register("apricot_cake_recipe", () -> new ApricotRecipeBlock(true));
	public static final RegistryObject<Block> APRICOT_CAKE_SLICE_RECIPE = BLOCKS.register("apricot_cake_slice_recipe", () -> new ApricotRecipeBlock(true));
	public static final RegistryObject<Block> APRICOT_COOKIE_RECIPE = BLOCKS.register("apricot_cookie_recipe", () -> new ApricotRecipeBlock(true));
	public static final RegistryObject<Block> APRICOT_CRATE_RECIPE = BLOCKS.register("apricot_crate_recipe", () -> new ApricotRecipeBlock(true));
	public static final RegistryObject<Block> APRICOT_FILLING_RECIPE = BLOCKS.register("apricot_filling_recipe", () -> new ApricotRecipeBlock(true));
	public static final RegistryObject<Block> APRICOT_JAM_RECIPE = BLOCKS.register("apricot_jam_recipe", () -> new ApricotRecipeBlock(true));
	public static final RegistryObject<Block> APRICOT_PIE_RECIPE = BLOCKS.register("apricot_pie_recipe", () -> new ApricotRecipeBlock(true));
	public static final RegistryObject<Block> APRICOT_PIE_SLICE_RECIPE = BLOCKS.register("apricot_pie_slice_recipe", () -> new ApricotRecipeBlock(true));
	public static final RegistryObject<Block> APRICOT_RICE_DUMPLING_BLOCK_RECIPE = BLOCKS.register("apricot_rice_dumpling_block_recipe", () -> new ApricotRecipeBlock(true));
	public static final RegistryObject<Block> RAW_APRICOT_MOON_CAKE_RECIPE = BLOCKS.register("raw_apricot_moon_cake_recipe", () -> new ApricotRecipeBlock(true));
	public static final RegistryObject<Block> APRICOT_JUICE_RECIPE = BLOCKS.register("apricot_juice_recipe", () -> new ApricotRecipeBlock(true));
	public static final RegistryObject<Block> APRICOT_SAPLING_RECIPE = BLOCKS.register("apricot_sapling_recipe", () -> new ApricotRecipeBlock(true));
	public static final RegistryObject<Block> APRICOT_SMOOTHIE_RECIPE = BLOCKS.register("apricot_smoothie_recipe", () -> new ApricotRecipeBlock(true));
	public static final RegistryObject<Block> APRICOT_MILK_TEA_RECIPE = BLOCKS.register("apricot_milk_tea_recipe", () -> new ApricotRecipeBlock(true));

	public static final RegistryObject<Block> RED_BAYBERRY_RECIPE_PACKAGE = BLOCKS.register("red_bayberry_recipe_package", RedBayberryRecipePackageBlock::new);
	public static final RegistryObject<Block> RED_BAYBERRY_CAKE_RECIPE = BLOCKS.register("red_bayberry_cake_recipe", () -> new RedBayberryRecipeBlock(true));
	public static final RegistryObject<Block> RED_BAYBERRY_CAKE_SLICE_RECIPE = BLOCKS.register("red_bayberry_cake_slice_recipe", () -> new RedBayberryRecipeBlock(true));
	public static final RegistryObject<Block> RED_BAYBERRY_COOKIE_RECIPE = BLOCKS.register("red_bayberry_cookie_recipe", () -> new RedBayberryRecipeBlock(true));
	public static final RegistryObject<Block> RED_BAYBERRY_CRATE_RECIPE = BLOCKS.register("red_bayberry_crate_recipe", () -> new RedBayberryRecipeBlock(true));
	public static final RegistryObject<Block> RED_BAYBERRY_FILLING_RECIPE = BLOCKS.register("red_bayberry_filling_recipe", () -> new RedBayberryRecipeBlock(true));
	public static final RegistryObject<Block> RED_BAYBERRY_JAM_RECIPE = BLOCKS.register("red_bayberry_jam_recipe", () -> new RedBayberryRecipeBlock(true));
	public static final RegistryObject<Block> RED_BAYBERRY_PIE_RECIPE = BLOCKS.register("red_bayberry_pie_recipe", () -> new RedBayberryRecipeBlock(true));
	public static final RegistryObject<Block> RED_BAYBERRY_PIE_SLICE_RECIPE = BLOCKS.register("red_bayberry_pie_slice_recipe", () -> new RedBayberryRecipeBlock(true));
	public static final RegistryObject<Block> RED_BAYBERRY_RICE_DUMPLING_BLOCK_RECIPE = BLOCKS.register("red_bayberry_rice_dumpling_block_recipe", () -> new RedBayberryRecipeBlock(true));
	public static final RegistryObject<Block> RAW_RED_BAYBERRY_MOON_CAKE_RECIPE = BLOCKS.register("raw_red_bayberry_moon_cake_recipe", () -> new RedBayberryRecipeBlock(true));
	public static final RegistryObject<Block> RED_BAYBERRY_JUICE_RECIPE = BLOCKS.register("red_bayberry_juice_recipe", () -> new RedBayberryRecipeBlock(true));
	public static final RegistryObject<Block> RED_BAYBERRY_SAPLING_RECIPE = BLOCKS.register("red_bayberry_sapling_recipe", () -> new RedBayberryRecipeBlock(true));
	public static final RegistryObject<Block> SOUR_PLUM_CHICKEN_BLOCK_RECIPE = BLOCKS.register("sour_plum_chicken_block_recipe", () -> new RedBayberryRecipeBlock(true));
	public static final RegistryObject<Block> RED_BAYBERRY_MILK_TEA_RECIPE = BLOCKS.register("red_bayberry_milk_tea_recipe", () -> new RedBayberryRecipeBlock(true));

	public static final RegistryObject<Block> GREEN_PLUM_RECIPE_PACKAGE = BLOCKS.register("green_plum_recipe_package", GreenPlumRecipePackageBlock::new);
	public static final RegistryObject<Block> GREEN_PLUM_CAKE_RECIPE = BLOCKS.register("green_plum_cake_recipe", () -> new GreenPlumRecipeBlock(true));
	public static final RegistryObject<Block> GREEN_PLUM_CAKE_SLICE_RECIPE = BLOCKS.register("green_plum_cake_slice_recipe", () -> new GreenPlumRecipeBlock(true));
	public static final RegistryObject<Block> GREEN_PLUM_COOKIE_RECIPE = BLOCKS.register("green_plum_cookie_recipe", () -> new GreenPlumRecipeBlock(true));
	public static final RegistryObject<Block> GREEN_PLUM_CRATE_RECIPE = BLOCKS.register("green_plum_crate_recipe", () -> new GreenPlumRecipeBlock(true));
	public static final RegistryObject<Block> GREEN_PLUM_FILLING_RECIPE = BLOCKS.register("green_plum_filling_recipe", () -> new GreenPlumRecipeBlock(true));
	public static final RegistryObject<Block> GREEN_PLUM_JAM_RECIPE = BLOCKS.register("green_plum_jam_recipe", () -> new GreenPlumRecipeBlock(true));
	public static final RegistryObject<Block> GREEN_PLUM_PIE_RECIPE = BLOCKS.register("green_plum_pie_recipe", () -> new GreenPlumRecipeBlock(true));
	public static final RegistryObject<Block> GREEN_PLUM_PIE_SLICE_RECIPE = BLOCKS.register("green_plum_pie_slice_recipe", () -> new GreenPlumRecipeBlock(true));
	public static final RegistryObject<Block> GREEN_PLUM_RICE_DUMPLING_BLOCK_RECIPE = BLOCKS.register("green_plum_rice_dumpling_block_recipe", () -> new GreenPlumRecipeBlock(true));
	public static final RegistryObject<Block> RAW_GREEN_PLUM_MOON_CAKE_RECIPE = BLOCKS.register("raw_green_plum_moon_cake_recipe", () -> new GreenPlumRecipeBlock(true));
	public static final RegistryObject<Block> GREEN_PLUM_JUICE_RECIPE = BLOCKS.register("green_plum_juice_recipe", () -> new GreenPlumRecipeBlock(true));
	public static final RegistryObject<Block> GREEN_PLUM_SAPLING_RECIPE = BLOCKS.register("green_plum_sapling_recipe", () -> new GreenPlumRecipeBlock(true));
	public static final RegistryObject<Block> GREEN_PLUM_MILK_TEA_RECIPE = BLOCKS.register("green_plum_milk_tea_recipe", () -> new GreenPlumRecipeBlock(true));

	public static final RegistryObject<Block> GRAPE_RECIPE_PACKAGE = BLOCKS.register("grape_recipe_package", GrapeRecipePackageBlock::new);
	public static final RegistryObject<Block> GRAPE_CAKE_RECIPE = BLOCKS.register("grape_cake_recipe", () -> new GrapeRecipeBlock(true));
	public static final RegistryObject<Block> GRAPE_CAKE_SLICE_RECIPE = BLOCKS.register("grape_cake_slice_recipe", () -> new GrapeRecipeBlock(true));
	public static final RegistryObject<Block> GRAPE_COOKIE_RECIPE = BLOCKS.register("grape_cookie_recipe", () -> new GrapeRecipeBlock(true));
	public static final RegistryObject<Block> GRAPE_CRATE_RECIPE = BLOCKS.register("grape_crate_recipe", () -> new GrapeRecipeBlock(true));
	public static final RegistryObject<Block> GRAPE_FILLING_RECIPE = BLOCKS.register("grape_filling_recipe", () -> new GrapeRecipeBlock(true));
	public static final RegistryObject<Block> GRAPE_JAM_RECIPE = BLOCKS.register("grape_jam_recipe", () -> new GrapeRecipeBlock(true));
	public static final RegistryObject<Block> GRAPE_PIE_RECIPE = BLOCKS.register("grape_pie_recipe", () -> new GrapeRecipeBlock(true));
	public static final RegistryObject<Block> GRAPE_PIE_SLICE_RECIPE = BLOCKS.register("grape_pie_slice_recipe", () -> new GrapeRecipeBlock(true));
	public static final RegistryObject<Block> GRAPE_RICE_DUMPLING_BLOCK_RECIPE = BLOCKS.register("grape_rice_dumpling_block_recipe", () -> new GrapeRecipeBlock(true));
	public static final RegistryObject<Block> RAW_GRAPE_MOON_CAKE_RECIPE = BLOCKS.register("raw_grape_moon_cake_recipe", () -> new GrapeRecipeBlock(true));
	public static final RegistryObject<Block> GRAPE_JUICE_RECIPE = BLOCKS.register("grape_juice_recipe", () -> new GrapeRecipeBlock(true));
	public static final RegistryObject<Block> SWEETENED_GRAPE_RECIPE = BLOCKS.register("sweetened_grape_recipe", () -> new GrapeRecipeBlock(true));
	public static final RegistryObject<Block> GRAPE_JELLY_RECIPE = BLOCKS.register("grape_jelly_recipe", () -> new GrapeRecipeBlock(true));
	public static final RegistryObject<Block> GRAPE_MILK_TEA_RECIPE = BLOCKS.register("grape_milk_tea_recipe", () -> new GrapeRecipeBlock(true));

	public static final RegistryObject<Block> PEACH_RECIPE_PACKAGE = BLOCKS.register("peach_recipe_package", PeachRecipePackageBlock::new);
	public static final RegistryObject<Block> PEACH_SAPLING_RECIPE = BLOCKS.register("peach_sapling_recipe", () -> new PeachRecipeBlock(true));
	public static final RegistryObject<Block> PEACH_CAKE_RECIPE = BLOCKS.register("peach_cake_recipe", () -> new PeachRecipeBlock(true));
	public static final RegistryObject<Block> PEACH_CAKE_SLICE_RECIPE = BLOCKS.register("peach_cake_slice_recipe", () -> new PeachRecipeBlock(true));
	public static final RegistryObject<Block> PEACH_COOKIE_RECIPE = BLOCKS.register("peach_cookie_recipe", () -> new PeachRecipeBlock(true));
	public static final RegistryObject<Block> PEACH_CRATE_RECIPE = BLOCKS.register("peach_crate_recipe", () -> new PeachRecipeBlock(true));
	public static final RegistryObject<Block> PEACH_JAM_RECIPE = BLOCKS.register("peach_jam_recipe", () -> new PeachRecipeBlock(true));
	public static final RegistryObject<Block> PEACH_PIE_RECIPE = BLOCKS.register("peach_pie_recipe", () -> new PeachRecipeBlock(true));
	public static final RegistryObject<Block> PEACH_PIE_SLICE_RECIPE = BLOCKS.register("peach_pie_slice_recipe", () -> new PeachRecipeBlock(true));
	public static final RegistryObject<Block> PEACH_SLICE_RECIPE = BLOCKS.register("peach_slice_recipe", () -> new PeachRecipeBlock(true));
	public static final RegistryObject<Block> PEACH_RICE_DUMPLING_BLOCK_RECIPE = BLOCKS.register("peach_rice_dumpling_block_recipe", () -> new PeachRecipeBlock(true));
	public static final RegistryObject<Block> PEACH_FILLING_RECIPE = BLOCKS.register("peach_filling_recipe", () -> new PeachRecipeBlock(true));
	public static final RegistryObject<Block> RAW_PEACH_MOON_CAKE_RECIPE = BLOCKS.register("raw_peach_moon_cake_recipe", () -> new PeachRecipeBlock(true));
	public static final RegistryObject<Block> SWEETENED_PEACH_RECIPE = BLOCKS.register("sweetened_peach_recipe", () -> new PeachRecipeBlock(true));
	public static final RegistryObject<Block> PEACH_JUICE_RECIPE = BLOCKS.register("peach_juice_recipe", () -> new PeachRecipeBlock(true));
	public static final RegistryObject<Block> PEACH_MILK_TEA_RECIPE = BLOCKS.register("peach_milk_tea_recipe", () -> new PeachRecipeBlock(true));
	public static final RegistryObject<Block> LACTOBACILLUS_HONEY_PEACH_ICE_RECIPE = BLOCKS.register("lactobacillus_honey_peach_ice_recipe", () -> new PeachRecipeBlock(true));

	public static final RegistryObject<Block> FRYING_PAN_RECIPE_PACKAGE = BLOCKS.register("frying_pan_recipe_package", FryingPanRecipePackageBlock::new);
	public static final RegistryObject<Block> FRYING_PAN_STIR_FRIED_BEATING_MELONS_SEEDS_RECIPE = BLOCKS.register("frying_pan_stir_fried_beating_melons_seeds_recipe", () -> new FryingPanRecipeBlock(true));
	public static final RegistryObject<Block> FRYING_PAN_CRISPY_LITCHI_BALL_RECIPE = BLOCKS.register("frying_pan_crispy_litchi_ball_recipe", () -> new FryingPanRecipeBlock(true));
	public static final RegistryObject<Block> FRYING_PAN_HONEY_MELON_CHICKEN_BALLS_RECIPE = BLOCKS.register("frying_pan_honey_melon_chicken_balls_recipe", () -> new FryingPanRecipeBlock(true));
	public static final RegistryObject<Block> FRYING_PAN_STIR_FRIED_YOGURT_RECIPE = BLOCKS.register("frying_pan_stir_fried_yogurt_recipe", () -> new FryingPanRecipeBlock(true));
	public static final RegistryObject<Block> FRYING_PAN_MILKY_TEA_RECIPE_RECIPE = BLOCKS.register("frying_pan_milky_tea_recipe", () -> new FryingPanRecipeBlock(true));

	public static final RegistryObject<Block> PIZZA_RECIPE_PACKAGE = BLOCKS.register("pizza_recipe_package", PizzaRecipePackageBlock::new);
	public static final RegistryObject<Block> PIZZA_RECIPE = BLOCKS.register("pizza_recipe", () -> new PizzaRecipeBlock(true));
}

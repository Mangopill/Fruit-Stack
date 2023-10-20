package com.fruitstack.fruitstack.common.registry;

import com.fruitstack.fruitstack.common.FoodValues;
import com.fruitstack.fruitstack.common.block.MangoRecipePackageBlock;
import com.fruitstack.fruitstack.common.block.WildCropBlock;
import com.fruitstack.fruitstack.common.item.*;
import com.fruitstack.fruitstack.fruitstack;
import com.google.common.collect.Sets;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public class ModItems
{
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, fruitstack.MODID);
	public static LinkedHashSet<RegistryObject<Item>> CREATIVE_TAB_ITEMS = Sets.newLinkedHashSet();

	public static RegistryObject<Item> registerWithTab(final String name, final Supplier<Item> supplier) {
		RegistryObject<Item> block = ITEMS.register(name, supplier);
		CREATIVE_TAB_ITEMS.add(block);
		return block;
	}
	// Helper methods
	public static Item.Properties basicItem() {
		return new Item.Properties();
	}

	public static Item.Properties foodItem(FoodProperties food) {
		return new Item.Properties().food(food);
	}

	public static Item.Properties bowlFoodItem(FoodProperties food) {
		return new Item.Properties().food(food).craftRemainder(Items.BOWL).stacksTo(16);
	}
	public static Item.Properties drinkItem() {
		return new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16);
	}
	//new cup
	public static final RegistryObject<Item> JUICE_CUP = registerWithTab("juice_cup",
			() -> new BottleItem(new Item.Properties()));
	public static final RegistryObject<Item> CANN = registerWithTab("cann",
			() -> new BottleItem(new Item.Properties()));
	public static final RegistryObject<Item> MILK_TEA_CUP = registerWithTab("milk_tea_cup",
			() -> new BottleItem(new Item.Properties()));
	public static Item.Properties juiceItem() {
		return new Item.Properties().craftRemainder(ModItems.JUICE_CUP.get()).stacksTo(16);
	}
	public static Item.Properties wineItem() {
		return new Item.Properties().craftRemainder(ModItems.CANN.get()).stacksTo(16);
	}
	public static Item.Properties milkyTeaItem() {
		return new Item.Properties().craftRemainder(ModItems.MILK_TEA_CUP.get()).stacksTo(16);
	}
	//fork / chopsticks
	public static final RegistryObject<Item> FORK = registerWithTab("fork",
			() -> new Item(new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> CHOPSTICKS = registerWithTab("chopsticks",
			() -> new Item(new Item.Properties().stacksTo(1)));
	//core food
	public static final RegistryObject<Item> SUNFLOWER_OIL = registerWithTab("sunflower_oil",
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> THE_BURNT_DISH = registerWithTab("the_burnt_dish",
			() -> new ConsumableItem(bowlFoodItem(FoodValues.THE_BURNT_DISH), true));
	public static final RegistryObject<Item> STIR_FRIED_YOGURT = registerWithTab("stir_fried_yogurt",
			() -> new ConsumableItem(bowlFoodItem(FoodValues.STIR_FRIED_YOGURT), true));
	public static final RegistryObject<Item> DOUGHNUT = registerWithTab("doughnut",
			() -> new Item(foodItem(FoodValues.DOUGHNUT)));
	public static final RegistryObject<Item> MILKY_TEA = registerWithTab("milky_tea",
			() -> new DrinkableItem(milkyTeaItem().food(FoodValues.MILKY_TEA), true, false));
	public static final RegistryObject<Item> CHINESE_SPIRITS_BARREL = registerWithTab("chinese_spirits_barrel",
			() -> new BlockItem(ModBlocks.CHINESE_SPIRITS_BARREL.get(), basicItem()));
	public static final RegistryObject<Item> CHINESE_SPIRITS_ONE = registerWithTab("chinese_spirits_one",
			() -> new DrinkableItem(wineItem().food(FoodValues.CHINESE_SPIRITS_ONE), true, true));
	public static final RegistryObject<Item> CHINESE_SPIRITS_TWO = registerWithTab("chinese_spirits_two",
			() -> new DrinkableItem(wineItem().food(FoodValues.CHINESE_SPIRITS_TWO), true, true));
	public static final RegistryObject<Item> CHINESE_SPIRITS_THREE = registerWithTab("chinese_spirits_three",
			() -> new DrinkableItem(wineItem().food(FoodValues.CHINESE_SPIRITS_THREE), true, true));
	public static final RegistryObject<Item> CHINESE_SPIRITS_FOUR = registerWithTab("chinese_spirits_four",
			() -> new DrinkableItem(wineItem().food(FoodValues.CHINESE_SPIRITS_FOUR), true, true));
	public static final RegistryObject<Item> CHINESE_SPIRITS_FIVE = registerWithTab("chinese_spirits_five",
			() -> new DrinkableItem(wineItem().food(FoodValues.CHINESE_SPIRITS_FIVE), true, true));
	public static final RegistryObject<Item> CHINESE_SPIRITS_SIX = registerWithTab("chinese_spirits_six",
			() -> new DrinkableItem(wineItem().food(FoodValues.CHINESE_SPIRITS_SIX), true, true));
	public static final RegistryObject<Item> CHINESE_SPIRITS_SEVEN = registerWithTab("chinese_spirits_seven",
			() -> new DrinkableItem(wineItem().food(FoodValues.CHINESE_SPIRITS_SEVEN), true, true));
	public static final RegistryObject<Item> CHINESE_SPIRITS_EIGHT = registerWithTab("chinese_spirits_eight",
			() -> new DrinkableItem(wineItem().food(FoodValues.CHINESE_SPIRITS_EIGHT), true, true));
	public static final RegistryObject<Item> CHINESE_SPIRITS_NINE = registerWithTab("chinese_spirits_nine",
			() -> new DrinkableItem(wineItem().food(FoodValues.CHINESE_SPIRITS_NINE), true, true));
	public static final RegistryObject<Item> CHINESE_SPIRITS_TEN = registerWithTab("chinese_spirits_ten",
			() -> new DrinkableItem(wineItem().food(FoodValues.CHINESE_SPIRITS_TEN), true, true));
	//blueberries
	public static final RegistryObject<Item> BLUEBERRIES_SEEDS = registerWithTab("blueberries_seeds",
			()-> new ItemNameBlockItem(ModBlocks.BLUEBERRIES_CROP.get(),new Item.Properties()
					
			));
	public static final RegistryObject<Item> WILD_BLUEBERRIES = registerWithTab("wild_blueberries",
			() -> new BlockItem(ModBlocks.WILD_BLUEBERRIES.get(), basicItem()));
	public static final RegistryObject<Item> BLUEBERRIES = registerWithTab("blueberries",
			() -> new Item(foodItem(FoodValues.BLUEBERRIES)));
	public static final RegistryObject<Item> BLUEBERRIES_POPSICLE = registerWithTab("blueberries_popsicle",
			() -> new PopsicleItem(foodItem(FoodValues.BLUEBERRIES_POPSICLE)));
	public static final RegistryObject<Item> BLUEBERRIES_CAKE = registerWithTab("blueberries_cake",
			()-> new ItemNameBlockItem(ModBlocks.BLUEBERRIES_CAKE.get(),new Item.Properties()
					
			));
	public static final RegistryObject<Item> BLUEBERRIES_PIE = registerWithTab("blueberries_pie",
			() -> new BlockItem(ModBlocks.BLUEBERRIES_PIE.get(), basicItem()));
	public static final RegistryObject<Item> BLUEBERRIES_PIE_SLICE = registerWithTab("blueberries_pie_slice",
			() -> new Item(foodItem(FoodValues.BLUEBERRIES_PIE_SLICE)));
	public static final RegistryObject<Item> BLUEBERRIES_CAKE_SLICE = registerWithTab("blueberries_cake_slice",
			() -> new Item(foodItem(FoodValues.BLUEBERRIES_CAKE_SLICE)));
	public static final RegistryObject<Item> BLUEBERRIES_CRATE = registerWithTab("blueberries_crate",
			() -> new BlockItem(ModBlocks.BLUEBERRIES_CRATE.get(), basicItem()));
	public static final RegistryObject<Item> BLUEBERRIES_BARQUILLO = registerWithTab("blueberries_barquillo",
			() -> new Item(foodItem(FoodValues.BLUEBERRIES_BARQUILLO)));
	public static final RegistryObject<Item> BLUEBERRIES_COOKIE = registerWithTab("blueberries_cookie",
			() -> new Item(foodItem(FoodValues.BLUEBERRIES_COOKIE)));
	public static final RegistryObject<Item> BLUEBERRIES_JAM = registerWithTab("blueberries_jam",
			() -> new BlockItem(ModBlocks.BLUEBERRIES_JAM.get(), basicItem()));
	public static final RegistryObject<Item> BLUEBERRIES_BREAD = registerWithTab("blueberries_bread",
			() -> new Item(foodItem(FoodValues.BLUEBERRIES_BREAD)));
	public static final RegistryObject<Item> BLUEBERRIES_DOUGHNUT = registerWithTab("blueberries_doughnut",
			() -> new Item(foodItem(FoodValues.BLUEBERRIES_DOUGHNUT)));
	public static final RegistryObject<Item> SWEETENED_BLUEBERRIES = registerWithTab("sweetened_blueberries",
			() -> new BlockItem(ModBlocks.SWEETENED_BLUEBERRIES.get(), basicItem()));
	public static final RegistryObject<Item> DRIED_BLUEBERRIES = registerWithTab("dried_blueberries",
			() -> new Item(foodItem(FoodValues.DRIED_BLUEBERRIES)));
	public static final RegistryObject<Item> BLUEBERRIES_JUICE = registerWithTab("blueberries_juice",
			() -> new DrinkableItem(juiceItem().food(FoodValues.BLUEBERRIES_JUICE), true, false));
	public static final RegistryObject<Item> BLUEBERRIES_WINE_BARREL = registerWithTab("blueberries_wine_barrel",
			() -> new BlockItem(ModBlocks.BLUEBERRIES_WINE_BARREL.get(), basicItem()));
	public static final RegistryObject<Item> BLUEBERRIES_WINE_ONE = registerWithTab("blueberries_wine_one",
			() -> new DrinkableItem(wineItem().food(FoodValues.BLUEBERRIES_WINE_ONE), true, true));
	public static final RegistryObject<Item> BLUEBERRIES_WINE_TWO = registerWithTab("blueberries_wine_two",
			() -> new DrinkableItem(wineItem().food(FoodValues.BLUEBERRIES_WINE_TWO), true, true));
	public static final RegistryObject<Item> BLUEBERRIES_WINE_THREE = registerWithTab("blueberries_wine_three",
			() -> new DrinkableItem(wineItem().food(FoodValues.BLUEBERRIES_WINE_THREE), true, true));
	public static final RegistryObject<Item> BLUEBERRIES_WINE_FOUR = registerWithTab("blueberries_wine_four",
			() -> new DrinkableItem(wineItem().food(FoodValues.BLUEBERRIES_WINE_FOUR), true, true));
	public static final RegistryObject<Item> BLUEBERRIES_WINE_FIVE = registerWithTab("blueberries_wine_five",
			() -> new DrinkableItem(wineItem().food(FoodValues.BLUEBERRIES_WINE_FIVE), true, true));
	public static final RegistryObject<Item> BLUEBERRIES_WINE_SIX = registerWithTab("blueberries_wine_six",
			() -> new DrinkableItem(wineItem().food(FoodValues.BLUEBERRIES_WINE_SIX), true, true));
	public static final RegistryObject<Item> BLUEBERRIES_WINE_SEVEN = registerWithTab("blueberries_wine_seven",
			() -> new DrinkableItem(wineItem().food(FoodValues.BLUEBERRIES_WINE_SEVEN), true, true));
	public static final RegistryObject<Item> BLUEBERRIES_WINE_EIGHT = registerWithTab("blueberries_wine_eight",
			() -> new DrinkableItem(wineItem().food(FoodValues.BLUEBERRIES_WINE_EIGHT), true, true));
	public static final RegistryObject<Item> BLUEBERRIES_WINE_NINE = registerWithTab("blueberries_wine_nine",
			() -> new DrinkableItem(wineItem().food(FoodValues.BLUEBERRIES_WINE_NINE), true, true));
	public static final RegistryObject<Item> BLUEBERRIES_WINE_TEN = registerWithTab("blueberries_wine_ten",
			() -> new DrinkableItem(wineItem().food(FoodValues.BLUEBERRIES_WINE_TEN), true, true));
	public static final RegistryObject<Item> BEST_BLUEBERRIES_WINE = registerWithTab("best_blueberries_wine",
			() -> new BestWineItem(wineItem(), true, true));
	public static final RegistryObject<Item> BLUEBERRIES_POPSICLE_MACHINE = registerWithTab("blueberries_popsicle_machine",
			() -> new BlockItem(ModBlocks.BLUEBERRIES_POPSICLE_MACHINE.get(), basicItem()));
	public static final RegistryObject<Item> BLUEBERRIES_MILK_TEA = registerWithTab("blueberries_milk_tea",
			() -> new DrinkableItem(juiceItem().food(FoodValues.BLUEBERRIES_MILK_TEA), true, false));
	//hamimelon
	public static final RegistryObject<Item> HAMIMELON_SEEDS = registerWithTab("hamimelon_seeds",
			()-> new ItemNameBlockItem(ModBlocks.HAMIMELON_CROP.get(),new Item.Properties()
					
			));
	public static final RegistryObject<Item> HAMIMELON = registerWithTab("hamimelon",
			() -> new Item(foodItem(FoodValues.HAMIMELON)));
	public static final RegistryObject<Item> HAMIMELON_POPSICLE = registerWithTab("hamimelon_popsicle",
			() -> new PopsicleItem(foodItem(FoodValues.HAMIMELON_POPSICLE)));
	public static final RegistryObject<Item> HAMIMELON_SAGO_SOUP_BLOCK = registerWithTab("hamimelon_sago_soup_block",
			() -> new BlockItem(ModBlocks.HAMIMELON_SAGO_SOUP_BLOCK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> HAMIMELON_SAGO_SOUP = registerWithTab("hamimelon_sago_soup",
			() -> new ConsumableItem(bowlFoodItem(FoodValues.HAMIMELON_SAGO_SOUP), true));
	public static final RegistryObject<Item> WILD_HAMIMELON = registerWithTab("wild_hamimelon",
			() -> new BlockItem(ModBlocks.WILD_HAMIMELON.get(), basicItem()));
	public static final RegistryObject<Item> HAMIMELON_CAKE = registerWithTab("hamimelon_cake",
			()-> new ItemNameBlockItem(ModBlocks.HAMIMELON_CAKE.get(),new Item.Properties()
					
			));
	public static final RegistryObject<Item> HAMIMELON_CAKE_SLICE = registerWithTab("hamimelon_cake_slice",
			() -> new Item(foodItem(FoodValues.HAMIMELON_CAKE_SLICE)));
	public static final RegistryObject<Item> HAMIMELON_CRATE = registerWithTab("hamimelon_crate",
			() -> new BlockItem(ModBlocks.HAMIMELON_CRATE.get(), basicItem()));
	public static final RegistryObject<Item> HAMIMELON_PIE = registerWithTab("hamimelon_pie",
			() -> new BlockItem(ModBlocks.HAMIMELON_PIE.get(), basicItem()));
	public static final RegistryObject<Item> HAMIMELON_PIE_SLICE = registerWithTab("hamimelon_pie_slice",
			() -> new Item(foodItem(FoodValues.HAMIMELON_PIE_SLICE)));
	public static final RegistryObject<Item> HAMIMELON_COOKIE = registerWithTab("hamimelon_cookie",
			() -> new Item(foodItem(FoodValues.HAMIMELON_COOKIE)));
	public static final RegistryObject<Item> PROSCIUTTO_CANTALOUPE = registerWithTab("prosciutto_cantaloupe",
			() -> new Item(foodItem(FoodValues.PROSCIUTTO_CANTALOUPE)));
	public static final RegistryObject<Item> HONEY_MELON_CHICKEN_BALLS = registerWithTab("honey_melon_chicken_balls",
			() -> new ConsumableItem(bowlFoodItem(FoodValues.HONEY_MELON_CHICKEN_BALLS), true));
	public static final RegistryObject<Item> UNFINISHED_HONEY_MELON_CHICKEN_BALLS = registerWithTab("unfinished_honey_melon_chicken_balls",
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> SAGO_SOUP = registerWithTab("sago_soup",
			() -> new Item(foodItem(FoodValues.SAGO_SOUP)));
	public static final RegistryObject<Item> FISH_SKIN = registerWithTab("fish_skin",
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> HAMIMELON_JAM = registerWithTab("hamimelon_jam",
			() -> new BlockItem(ModBlocks.HAMIMELON_JAM.get(), basicItem()));
	public static final RegistryObject<Item> HAMIMELON_BREAD = registerWithTab("hamimelon_bread",
			() -> new Item(foodItem(FoodValues.HAMIMELON_BREAD)));
	public static final RegistryObject<Item> HAMIMELON_DOUGHNUT = registerWithTab("hamimelon_doughnut",
			() -> new Item(foodItem(FoodValues.HAMIMELON_DOUGHNUT)));
	public static final RegistryObject<Item> SWEETENED_HAMIMELON = registerWithTab("sweetened_hamimelon",
			() -> new BlockItem(ModBlocks.SWEETENED_HAMIMELON.get(), basicItem()));
	public static final RegistryObject<Item> DRIED_HAMIMELON = registerWithTab("dried_hamimelon",
			() -> new Item(foodItem(FoodValues.DRIED_HAMIMELON)));
	public static final RegistryObject<Item> HAMIMELON_JUICE = registerWithTab("hamimelon_juice",
			() -> new DrinkableItem(juiceItem().food(FoodValues.HAMIMELON_JUICE), true, false));
	public static final RegistryObject<Item> HAMIMELON_WINE_BARREL = registerWithTab("hamimelon_wine_barrel",
			() -> new BlockItem(ModBlocks.HAMIMELON_WINE_BARREL.get(), basicItem()));
	public static final RegistryObject<Item> HAMIMELON_WINE_ONE = registerWithTab("hamimelon_wine_one",
			() -> new DrinkableItem(wineItem().food(FoodValues.HAMIMELON_WINE_ONE), true, true));
	public static final RegistryObject<Item> HAMIMELON_WINE_TWO = registerWithTab("hamimelon_wine_two",
			() -> new DrinkableItem(wineItem().food(FoodValues.HAMIMELON_WINE_TWO), true, true));
	public static final RegistryObject<Item> HAMIMELON_WINE_THREE = registerWithTab("hamimelon_wine_three",
			() -> new DrinkableItem(wineItem().food(FoodValues.HAMIMELON_WINE_THREE), true, true));
	public static final RegistryObject<Item> HAMIMELON_WINE_FOUR = registerWithTab("hamimelon_wine_four",
			() -> new DrinkableItem(wineItem().food(FoodValues.HAMIMELON_WINE_FOUR), true, true));
	public static final RegistryObject<Item> HAMIMELON_WINE_FIVE = registerWithTab("hamimelon_wine_five",
			() -> new DrinkableItem(wineItem().food(FoodValues.HAMIMELON_WINE_FIVE), true, true));
	public static final RegistryObject<Item> HAMIMELON_WINE_SIX = registerWithTab("hamimelon_wine_six",
			() -> new DrinkableItem(wineItem().food(FoodValues.HAMIMELON_WINE_SIX), true, true));
	public static final RegistryObject<Item> HAMIMELON_WINE_SEVEN = registerWithTab("hamimelon_wine_seven",
			() -> new DrinkableItem(wineItem().food(FoodValues.HAMIMELON_WINE_SEVEN), true, true));
	public static final RegistryObject<Item> HAMIMELON_WINE_EIGHT = registerWithTab("hamimelon_wine_eight",
			() -> new DrinkableItem(wineItem().food(FoodValues.HAMIMELON_WINE_EIGHT), true, true));
	public static final RegistryObject<Item> HAMIMELON_WINE_NINE = registerWithTab("hamimelon_wine_nine",
			() -> new DrinkableItem(wineItem().food(FoodValues.HAMIMELON_WINE_NINE), true, true));
	public static final RegistryObject<Item> HAMIMELON_WINE_TEN = registerWithTab("hamimelon_wine_ten",
			() -> new DrinkableItem(wineItem().food(FoodValues.HAMIMELON_WINE_TEN), true, true));
	public static final RegistryObject<Item> BEST_HAMIMELON_WINE = registerWithTab("best_hamimelon_wine",
			() -> new BestWineItem(wineItem(), true, true));
	public static final RegistryObject<Item> HAMIMELON_POPSICLE_MACHINE = registerWithTab("hamimelon_popsicle_machine",
			() -> new BlockItem(ModBlocks.HAMIMELON_POPSICLE_MACHINE.get(), basicItem()));
	public static final RegistryObject<Item> HAMIMELON_MILK_TEA = registerWithTab("hamimelon_milk_tea",
			() -> new DrinkableItem(juiceItem().food(FoodValues.HAMIMELON_MILK_TEA), true, false));
	//beating melons
	public static final RegistryObject<Item> BEATING_MELONS_SEEDS = registerWithTab("beating_melons_seeds",
			()-> new ItemNameBlockItem(ModBlocks.BEATING_MELONS_CROP.get(),new Item.Properties()
					
			));
	public static final RegistryObject<Item> STIR_FRIED_BEATING_MELONS_SEEDS = registerWithTab("stir_fried_beating_melons_seeds",
			() -> new BlockItem(ModBlocks.STIR_FRIED_BEATING_MELONS_SEEDS.get(), basicItem()));
	public static final RegistryObject<Item> DRIED_BEATING_MELONS_SEEDS = registerWithTab("dried_beating_melons_seeds",
			() -> new Item(foodItem(FoodValues.DRIED_BEATING_MELONS_SEEDS)));
	public static final RegistryObject<Item> BEATING_MELONS = registerWithTab("beating_melons",
			() -> new BeatingMelonsItem(foodItem(FoodValues.BEATING_MELONS)));
	public static final RegistryObject<Item> BEATING_MELONS_SLICE = registerWithTab("beating_melons_slice",
			() -> new Item(foodItem(FoodValues.BEATING_MELONS_SLICE)));
	public static final RegistryObject<Item> BEATING_MELONS_POPSICLE = registerWithTab("beating_melons_popsicle",
			() -> new PopsicleItem(foodItem(FoodValues.BEATING_MELONS_POPSICLE)));
	public static final RegistryObject<Item> BEATING_MELONS_COOKIE = registerWithTab("beating_melons_cookie",
			() -> new Item(foodItem(FoodValues.BEATING_MELONS_COOKIE)));
	public static final RegistryObject<Item> WILD_BEATING_MELONS = registerWithTab("wild_beating_melons",
			() -> new BlockItem(ModBlocks.WILD_BEATING_MELONS.get(), basicItem()));
	public static final RegistryObject<Item> BEATING_MELONS_CAKE = registerWithTab("beating_melons_cake",
			()-> new ItemNameBlockItem(ModBlocks.BEATING_MELONS_CAKE.get(),new Item.Properties()
					
			));
	public static final RegistryObject<Item> BEATING_MELONS_CAKE_SLICE = registerWithTab("beating_melons_cake_slice",
			() -> new Item(foodItem(FoodValues.BEATING_MELONS_CAKE_SLICE)));
	public static final RegistryObject<Item> BEATING_MELONS_CRATE = registerWithTab("beating_melons_crate",
			() -> new BlockItem(ModBlocks.BEATING_MELONS_CRATE.get(), basicItem()));
	public static final RegistryObject<Item> BEATING_MELONS_PIE = registerWithTab("beating_melons_pie",
			() -> new BlockItem(ModBlocks.BEATING_MELONS_PIE.get(), basicItem()));
	public static final RegistryObject<Item> BEATING_MELONS_PIE_SLICE = registerWithTab("beating_melons_pie_slice",
			() -> new Item(foodItem(FoodValues.BEATING_MELONS_PIE_SLICE)));
	public static final RegistryObject<Item> BEATING_MELONS_JAM = registerWithTab("beating_melons_jam",
			() -> new BlockItem(ModBlocks.BEATING_MELONS_JAM.get(), basicItem()));
	public static final RegistryObject<Item> BEATING_MELONS_BREAD = registerWithTab("beating_melons_bread",
			() -> new Item(foodItem(FoodValues.BEATING_MELONS_BREAD)));
	public static final RegistryObject<Item> BEATING_MELONS_DOUGHNUT = registerWithTab("beating_melons_doughnut",
			() -> new Item(foodItem(FoodValues.BEATING_MELONS_DOUGHNUT)));
	public static final RegistryObject<Item> BEATING_MELONS_JUICE = registerWithTab("beating_melons_juice",
			() -> new DrinkableItem(juiceItem().food(FoodValues.BEATING_MELONS_JUICE), true, false));
	public static final RegistryObject<Item> BEATING_MELONS_WINE_BARREL = registerWithTab("beating_melons_wine_barrel",
			() -> new BlockItem(ModBlocks.BEATING_MELONS_WINE_BARREL.get(), basicItem()));
	public static final RegistryObject<Item> BEATING_MELONS_WINE_ONE = registerWithTab("beating_melons_wine_one",
			() -> new DrinkableItem(wineItem().food(FoodValues.BEATING_MELONS_WINE_ONE), true, true));
	public static final RegistryObject<Item> BEATING_MELONS_WINE_TWO = registerWithTab("beating_melons_wine_two",
			() -> new DrinkableItem(wineItem().food(FoodValues.BEATING_MELONS_WINE_TWO), true, true));
	public static final RegistryObject<Item> BEATING_MELONS_WINE_THREE = registerWithTab("beating_melons_wine_three",
			() -> new DrinkableItem(wineItem().food(FoodValues.BEATING_MELONS_WINE_THREE), true, true));
	public static final RegistryObject<Item> BEATING_MELONS_WINE_FOUR = registerWithTab("beating_melons_wine_four",
			() -> new DrinkableItem(wineItem().food(FoodValues.BEATING_MELONS_WINE_FOUR), true, true));
	public static final RegistryObject<Item> BEATING_MELONS_WINE_FIVE = registerWithTab("beating_melons_wine_five",
			() -> new DrinkableItem(wineItem().food(FoodValues.BEATING_MELONS_WINE_FIVE), true, true));
	public static final RegistryObject<Item> BEATING_MELONS_WINE_SIX = registerWithTab("beating_melons_wine_six",
			() -> new DrinkableItem(wineItem().food(FoodValues.BEATING_MELONS_WINE_SIX), true, true));
	public static final RegistryObject<Item> BEATING_MELONS_WINE_SEVEN = registerWithTab("beating_melons_wine_seven",
			() -> new DrinkableItem(wineItem().food(FoodValues.BEATING_MELONS_WINE_SEVEN), true, true));
	public static final RegistryObject<Item> BEATING_MELONS_WINE_EIGHT = registerWithTab("beating_melons_wine_eight",
			() -> new DrinkableItem(wineItem().food(FoodValues.BEATING_MELONS_WINE_EIGHT), true, true));
	public static final RegistryObject<Item> BEATING_MELONS_WINE_NINE = registerWithTab("beating_melons_wine_nine",
			() -> new DrinkableItem(wineItem().food(FoodValues.BEATING_MELONS_WINE_NINE), true, true));
	public static final RegistryObject<Item> BEATING_MELONS_WINE_TEN = registerWithTab("beating_melons_wine_ten",
			() -> new DrinkableItem(wineItem().food(FoodValues.BEATING_MELONS_WINE_TEN), true, true));
	public static final RegistryObject<Item> BEST_BEATING_MELONS_WINE = registerWithTab("best_beating_melons_wine",
			() -> new BestWineItem(wineItem(), true, true));
	public static final RegistryObject<Item> BEATING_MELONS_POPSICLE_MACHINE = registerWithTab("beating_melons_popsicle_machine",
			() -> new BlockItem(ModBlocks.BEATING_MELONS_POPSICLE_MACHINE.get(), basicItem()));
	public static final RegistryObject<Item> BEATING_MELONS_MILK_TEA = registerWithTab("beating_melons_milk_tea",
			() -> new DrinkableItem(juiceItem().food(FoodValues.BEATING_MELONS_MILK_TEA), true, false));
	//ground cucumber
	public static final RegistryObject<Item> GROUND_CUCUMBER_SEEDS = registerWithTab("ground_cucumber_seeds",
			()-> new ItemNameBlockItem(ModBlocks.GROUND_CUCUMBER_CROP.get(),new Item.Properties()
					
			));
	public static final RegistryObject<Item> GROUND_CUCUMBER = registerWithTab("ground_cucumber",
			() -> new BlockItem(ModBlocks.GROUND_CUCUMBER.get(), basicItem().stacksTo(64)));
	public static final RegistryObject<Item> GROUND_CUCUMBER_POPSICLE = registerWithTab("ground_cucumber_popsicle",
			() -> new PopsicleItem(foodItem(FoodValues.GROUND_CUCUMBER_POPSICLE)));
	public static final RegistryObject<Item> GROUND_CUCUMBER_SLICE = registerWithTab("ground_cucumber_slice",
			() -> new Item(foodItem(FoodValues.GROUND_CUCUMBER_SLICE)));
	public static final RegistryObject<Item> WILD_GROUND_CUCUMBER = registerWithTab("wild_ground_cucumber",
			() -> new BlockItem(ModBlocks.WILD_GROUND_CUCUMBER.get(), basicItem()));
	public static final RegistryObject<Item> GROUND_CUCUMBER_CAKE = registerWithTab("ground_cucumber_cake",
			()-> new ItemNameBlockItem(ModBlocks.GROUND_CUCUMBER_CAKE.get(),new Item.Properties()
					
			));
	public static final RegistryObject<Item> GROUND_CUCUMBER_PIE = registerWithTab("ground_cucumber_pie",
			() -> new BlockItem(ModBlocks.GROUND_CUCUMBER_PIE.get(), basicItem()));
	public static final RegistryObject<Item> GROUND_CUCUMBER_PIE_SLICE = registerWithTab("ground_cucumber_pie_slice",
			() -> new Item(foodItem(FoodValues.GROUND_CUCUMBER_PIE_SLICE)));
	public static final RegistryObject<Item> GROUND_CUCUMBER_CAKE_SLICE = registerWithTab("ground_cucumber_cake_slice",
			() -> new Item(foodItem(FoodValues.GROUND_CUCUMBER_CAKE_SLICE)));
	public static final RegistryObject<Item> GROUND_CUCUMBER_CRATE = registerWithTab("ground_cucumber_crate",
			() -> new BlockItem(ModBlocks.GROUND_CUCUMBER_CRATE.get(), basicItem()));
	public static final RegistryObject<Item> GROUND_CUCUMBER_COOKIE = registerWithTab("ground_cucumber_cookie",
			() -> new Item(foodItem(FoodValues.GROUND_CUCUMBER_COOKIE)));
	public static final RegistryObject<Item> GROUND_CUCUMBER_JAM = registerWithTab("ground_cucumber_jam",
			() -> new BlockItem(ModBlocks.GROUND_CUCUMBER_JAM.get(), basicItem()));
	public static final RegistryObject<Item> GROUND_CUCUMBER_BREAD = registerWithTab("ground_cucumber_bread",
			() -> new Item(foodItem(FoodValues.GROUND_CUCUMBER_BREAD)));
	public static final RegistryObject<Item> GROUND_CUCUMBER_DOUGHNUT = registerWithTab("ground_cucumber_doughnut",
			() -> new Item(foodItem(FoodValues.GROUND_CUCUMBER_DOUGHNUT)));
	public static final RegistryObject<Item> GROUND_CUCUMBER_JUICE = registerWithTab("ground_cucumber_juice",
			() -> new DrinkableItem(juiceItem().food(FoodValues.GROUND_CUCUMBER_JUICE), true, false));
	public static final RegistryObject<Item> GROUND_CUCUMBER_WINE_BARREL = registerWithTab("ground_cucumber_wine_barrel",
			() -> new BlockItem(ModBlocks.GROUND_CUCUMBER_WINE_BARREL.get(), basicItem()));
	public static final RegistryObject<Item> GROUND_CUCUMBER_WINE_ONE = registerWithTab("ground_cucumber_wine_one",
			() -> new DrinkableItem(wineItem().food(FoodValues.GROUND_CUCUMBER_WINE_ONE), true, true));
	public static final RegistryObject<Item> GROUND_CUCUMBER_WINE_TWO = registerWithTab("ground_cucumber_wine_two",
			() -> new DrinkableItem(wineItem().food(FoodValues.GROUND_CUCUMBER_WINE_TWO), true, true));
	public static final RegistryObject<Item> GROUND_CUCUMBER_WINE_THREE = registerWithTab("ground_cucumber_wine_three",
			() -> new DrinkableItem(wineItem().food(FoodValues.GROUND_CUCUMBER_WINE_THREE), true, true));
	public static final RegistryObject<Item> GROUND_CUCUMBER_WINE_FOUR = registerWithTab("ground_cucumber_wine_four",
			() -> new DrinkableItem(wineItem().food(FoodValues.GROUND_CUCUMBER_WINE_FOUR), true, true));
	public static final RegistryObject<Item> GROUND_CUCUMBER_WINE_FIVE = registerWithTab("ground_cucumber_wine_five",
			() -> new DrinkableItem(wineItem().food(FoodValues.GROUND_CUCUMBER_WINE_FIVE), true, true));
	public static final RegistryObject<Item> GROUND_CUCUMBER_WINE_SIX = registerWithTab("ground_cucumber_wine_six",
			() -> new DrinkableItem(wineItem().food(FoodValues.GROUND_CUCUMBER_WINE_SIX), true, true));
	public static final RegistryObject<Item> GROUND_CUCUMBER_WINE_SEVEN = registerWithTab("ground_cucumber_wine_seven",
			() -> new DrinkableItem(wineItem().food(FoodValues.GROUND_CUCUMBER_WINE_SEVEN), true, true));
	public static final RegistryObject<Item> GROUND_CUCUMBER_WINE_EIGHT = registerWithTab("ground_cucumber_wine_eight",
			() -> new DrinkableItem(wineItem().food(FoodValues.GROUND_CUCUMBER_WINE_EIGHT), true, true));
	public static final RegistryObject<Item> GROUND_CUCUMBER_WINE_NINE = registerWithTab("ground_cucumber_wine_nine",
			() -> new DrinkableItem(wineItem().food(FoodValues.GROUND_CUCUMBER_WINE_NINE), true, true));
	public static final RegistryObject<Item> GROUND_CUCUMBER_WINE_TEN = registerWithTab("ground_cucumber_wine_ten",
			() -> new DrinkableItem(wineItem().food(FoodValues.GROUND_CUCUMBER_WINE_TEN), true, true));
	public static final RegistryObject<Item> BEST_GROUND_CUCUMBER_WINE = registerWithTab("best_ground_cucumber_wine",
			() -> new BestWineItem(wineItem(), true, true));
	public static final RegistryObject<Item> GROUND_CUCUMBER_POPSICLE_MACHINE = registerWithTab("ground_cucumber_popsicle_machine",
			() -> new BlockItem(ModBlocks.GROUND_CUCUMBER_POPSICLE_MACHINE.get(), basicItem()));
	public static final RegistryObject<Item> GROUND_CUCUMBER_MILK_TEA = registerWithTab("ground_cucumber_milk_tea",
			() -> new DrinkableItem(juiceItem().food(FoodValues.GROUND_CUCUMBER_MILK_TEA), true, false));
	//mango
	public static final RegistryObject<Item> MANGO_BLOCK = registerWithTab("mango_block",
			() -> new BlockItem(ModBlocks.MANGO_BLOCK.get(), basicItem().stacksTo(64)));
	public static final RegistryObject<Item> MANGO_SLICE = registerWithTab("mango_slice",
			() -> new Item(foodItem(FoodValues.MANGO_SLICE)));
	public static final RegistryObject<Item> GREEN_MANGO_BLOCK = registerWithTab("green_mango_block",
			() -> new BlockItem(ModBlocks.GREEN_MANGO_BLOCK.get(), basicItem().stacksTo(64)));
	public static final RegistryObject<Item> GREEN_MANGO_SLICE = registerWithTab("green_mango_slice",
			() -> new Item(foodItem(FoodValues.GREEN_MANGO_SLICE)));
	public static final RegistryObject<Item> MANGO_SEEDS = registerWithTab("mango_seeds",
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> MANGO_SAPLING = registerWithTab("mango_sapling",
			() -> new BlockItem(ModBlocks.MANGO_SAPLING.get(), new Item.Properties()));
	public static final RegistryObject<Item> MANGO_POPSICLE = registerWithTab("mango_popsicle",
			() -> new PopsicleItem(foodItem(FoodValues.MANGO_POPSICLE)));
	public static final RegistryObject<Item> MANGO_CAKE = registerWithTab("mango_cake",
			()-> new ItemNameBlockItem(ModBlocks.MANGO_CAKE.get(),new Item.Properties()
					
			));
	public static final RegistryObject<Item> MANGO_PIE = registerWithTab("mango_pie",
			() -> new BlockItem(ModBlocks.MANGO_PIE.get(), basicItem()));
	public static final RegistryObject<Item> MANGO_PIE_SLICE = registerWithTab("mango_pie_slice",
			() -> new Item(foodItem(FoodValues.MANGO_PIE_SLICE)));
	public static final RegistryObject<Item> MANGO_CAKE_SLICE = registerWithTab("mango_cake_slice",
			() -> new Item(foodItem(FoodValues.MANGO_CAKE_SLICE)));
	public static final RegistryObject<Item> MANGO_CRATE = registerWithTab("mango_crate",
			() -> new BlockItem(ModBlocks.MANGO_CRATE.get(), basicItem()));
	public static final RegistryObject<Item> MANGO_COOKIE = registerWithTab("mango_cookie",
			() -> new Item(foodItem(FoodValues.MANGO_COOKIE)));
	public static final RegistryObject<Item> MANGO_JAM = registerWithTab("mango_jam",
			() -> new BlockItem(ModBlocks.MANGO_JAM.get(), basicItem()));
	public static final RegistryObject<Item> MANGO_BREAD = registerWithTab("mango_bread",
			() -> new Item(foodItem(FoodValues.MANGO_BREAD)));
	public static final RegistryObject<Item> MANGO_DOUGHNUT = registerWithTab("mango_doughnut",
			() -> new Item(foodItem(FoodValues.MANGO_DOUGHNUT)));
	public static final RegistryObject<Item> SWEETENED_MANGO = registerWithTab("sweetened_mango",
			() -> new BlockItem(ModBlocks.SWEETENED_MANGO.get(), basicItem()));
	public static final RegistryObject<Item> DRIED_MANGO = registerWithTab("dried_mango",
			() -> new Item(foodItem(FoodValues.DRIED_MANGO)));
	public static final RegistryObject<Item> MANGO_JUICE = registerWithTab("mango_juice",
			() -> new DrinkableItem(juiceItem().food(FoodValues.MANGO_JUICE), true, false));
	public static final RegistryObject<Item> MANGO_MILK_ICE_CREAM = registerWithTab("mango_milk_ice_cream",
			() -> new PopsicleItem(foodItem(FoodValues.MANGO_MILK_ICE_CREAM)));
	public static final RegistryObject<Item> MANGO_WINE_BARREL = registerWithTab("mango_wine_barrel",
			() -> new BlockItem(ModBlocks.MANGO_WINE_BARREL.get(), basicItem()));
	public static final RegistryObject<Item> MANGO_WINE_ONE = registerWithTab("mango_wine_one",
			() -> new DrinkableItem(wineItem().food(FoodValues.MANGO_WINE_ONE), true, true));
	public static final RegistryObject<Item> MANGO_WINE_TWO = registerWithTab("mango_wine_two",
			() -> new DrinkableItem(wineItem().food(FoodValues.MANGO_WINE_TWO), true, true));
	public static final RegistryObject<Item> MANGO_WINE_THREE = registerWithTab("mango_wine_three",
			() -> new DrinkableItem(wineItem().food(FoodValues.MANGO_WINE_THREE), true, true));
	public static final RegistryObject<Item> MANGO_WINE_FOUR = registerWithTab("mango_wine_four",
			() -> new DrinkableItem(wineItem().food(FoodValues.MANGO_WINE_FOUR), true, true));
	public static final RegistryObject<Item> MANGO_WINE_FIVE = registerWithTab("mango_wine_five",
			() -> new DrinkableItem(wineItem().food(FoodValues.MANGO_WINE_FIVE), true, true));
	public static final RegistryObject<Item> MANGO_WINE_SIX = registerWithTab("mango_wine_six",
			() -> new DrinkableItem(wineItem().food(FoodValues.MANGO_WINE_SIX), true, true));
	public static final RegistryObject<Item> MANGO_WINE_SEVEN = registerWithTab("mango_wine_seven",
			() -> new DrinkableItem(wineItem().food(FoodValues.MANGO_WINE_SEVEN), true, true));
	public static final RegistryObject<Item> MANGO_WINE_EIGHT = registerWithTab("mango_wine_eight",
			() -> new DrinkableItem(wineItem().food(FoodValues.MANGO_WINE_EIGHT), true, true));
	public static final RegistryObject<Item> MANGO_WINE_NINE = registerWithTab("mango_wine_nine",
			() -> new DrinkableItem(wineItem().food(FoodValues.MANGO_WINE_NINE), true, true));
	public static final RegistryObject<Item> MANGO_WINE_TEN = registerWithTab("mango_wine_ten",
			() -> new DrinkableItem(wineItem().food(FoodValues.MANGO_WINE_TEN), true, true));
	public static final RegistryObject<Item> BEST_MANGO_WINE = registerWithTab("best_mango_wine",
			() -> new BestWineItem(wineItem(), true, true));
	public static final RegistryObject<Item> MANGO_LANTERN = registerWithTab("mango_lantern",
			() -> new BlockItem(ModBlocks.MANGO_LANTERN.get(), basicItem()));
	public static final RegistryObject<Item> MANGO_POPSICLE_MACHINE = registerWithTab("mango_popsicle_machine",
			() -> new BlockItem(ModBlocks.MANGO_POPSICLE_MACHINE.get(), basicItem()));
	public static final RegistryObject<Item> MANGO_MILK_TEA = registerWithTab("mango_milk_tea",
			() -> new DrinkableItem(juiceItem().food(FoodValues.MANGO_MILK_TEA), true, false));
	//holboellia latifolia
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_SEEDS = registerWithTab("holboellia_latifolia_seeds",
			() -> new ItemNameBlockItem(ModBlocks.HOLBOELLIA_LATIFOLIA_CROP.get(),new Item.Properties()
					
			));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA = registerWithTab("holboellia_latifolia",
			() -> new BlockItem(ModBlocks.HOLBOELLIA_LATIFOLIA.get(), basicItem().stacksTo(64)));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_SLICE = registerWithTab("holboellia_latifolia_slice",
			() -> new Item(foodItem(FoodValues.HOLBOELLIA_LATIFOLIA_SLICE)));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_POPSICLE = registerWithTab("holboellia_latifolia_popsicle",
			() -> new PopsicleItem(foodItem(FoodValues.HOLBOELLIA_LATIFOLIA_POPSICLE)));
	public static final RegistryObject<Item> ONION_TOMATO_HOLBOELLIA_LATIFOLIA = registerWithTab("onion_tomato_holboellia_latifolia",
			() -> new ConsumableItem(bowlFoodItem(FoodValues.ONION_TOMATO_HOLBOELLIA_LATIFOLIA), true));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_EGG_MILK_PUDDING = registerWithTab("holboellia_latifolia_egg_milk_pudding",
			() -> new BlockItem(ModBlocks.HOLBOELLIA_LATIFOLIA_EGG_MILK_PUDDING.get(), basicItem()));
	public static final RegistryObject<Item> WILD_HOLBOELLIA_LATIFOLIA = registerWithTab("wild_holboellia_latifolia",
			() -> new BlockItem(ModBlocks.WILD_HOLBOELLIA_LATIFOLIA.get(), basicItem()));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_CAKE = registerWithTab("holboellia_latifolia_cake",
			()-> new ItemNameBlockItem(ModBlocks.HOLBOELLIA_LATIFOLIA_CAKE.get(),new Item.Properties()
					
			));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_CAKE_SLICE = registerWithTab("holboellia_latifolia_cake_slice",
			() -> new Item(foodItem(FoodValues.HOLBOELLIA_LATIFOLIA_CAKE_SLICE)));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_CRATE = registerWithTab("holboellia_latifolia_crate",
			() -> new BlockItem(ModBlocks.HOLBOELLIA_LATIFOLIA_CRATE.get(), basicItem()));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_PIE = registerWithTab("holboellia_latifolia_pie",
			() -> new BlockItem(ModBlocks.HOLBOELLIA_LATIFOLIA_PIE.get(), basicItem()));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_PIE_SLICE = registerWithTab("holboellia_latifolia_pie_slice",
			() -> new Item(foodItem(FoodValues.HOLBOELLIA_LATIFOLIA_PIE_SLICE)));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_COOKIE = registerWithTab("holboellia_latifolia_cookie",
			() -> new Item(foodItem(FoodValues.HOLBOELLIA_LATIFOLIA_COOKIE)));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_JAM = registerWithTab("holboellia_latifolia_jam",
			() -> new BlockItem(ModBlocks.HOLBOELLIA_LATIFOLIA_JAM.get(), basicItem()));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_BREAD = registerWithTab("holboellia_latifolia_bread",
			() -> new Item(foodItem(FoodValues.HOLBOELLIA_LATIFOLIA_BREAD)));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_DOUGHNUT = registerWithTab("holboellia_latifolia_doughnut",
			() -> new Item(foodItem(FoodValues.HOLBOELLIA_LATIFOLIA_DOUGHNUT)));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_JUICE = registerWithTab("holboellia_latifolia_juice",
			() -> new DrinkableItem(juiceItem().food(FoodValues.HOLBOELLIA_LATIFOLIA_JUICE), true, false));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_WINE_BARREL = registerWithTab("holboellia_latifolia_wine_barrel",
			() -> new BlockItem(ModBlocks.HOLBOELLIA_LATIFOLIA_WINE_BARREL.get(), basicItem()));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_WINE_ONE = registerWithTab("holboellia_latifolia_wine_one",
			() -> new DrinkableItem(wineItem().food(FoodValues.HOLBOELLIA_LATIFOLIA_WINE_ONE), true, true));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_WINE_TWO = registerWithTab("holboellia_latifolia_wine_two",
			() -> new DrinkableItem(wineItem().food(FoodValues.HOLBOELLIA_LATIFOLIA_WINE_TWO), true, true));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_WINE_THREE = registerWithTab("holboellia_latifolia_wine_three",
			() -> new DrinkableItem(wineItem().food(FoodValues.HOLBOELLIA_LATIFOLIA_WINE_THREE), true, true));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_WINE_FOUR = registerWithTab("holboellia_latifolia_wine_four",
			() -> new DrinkableItem(wineItem().food(FoodValues.HOLBOELLIA_LATIFOLIA_WINE_FOUR), true, true));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_WINE_FIVE = registerWithTab("holboellia_latifolia_wine_five",
			() -> new DrinkableItem(wineItem().food(FoodValues.HOLBOELLIA_LATIFOLIA_WINE_FIVE), true, true));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_WINE_SIX = registerWithTab("holboellia_latifolia_wine_six",
			() -> new DrinkableItem(wineItem().food(FoodValues.HOLBOELLIA_LATIFOLIA_WINE_SIX), true, true));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_WINE_SEVEN = registerWithTab("holboellia_latifolia_wine_seven",
			() -> new DrinkableItem(wineItem().food(FoodValues.HOLBOELLIA_LATIFOLIA_WINE_SEVEN), true, true));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_WINE_EIGHT = registerWithTab("holboellia_latifolia_wine_eight",
			() -> new DrinkableItem(wineItem().food(FoodValues.HOLBOELLIA_LATIFOLIA_WINE_EIGHT), true, true));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_WINE_NINE = registerWithTab("holboellia_latifolia_wine_nine",
			() -> new DrinkableItem(wineItem().food(FoodValues.HOLBOELLIA_LATIFOLIA_WINE_NINE), true, true));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_WINE_TEN = registerWithTab("holboellia_latifolia_wine_ten",
			() -> new DrinkableItem(wineItem().food(FoodValues.HOLBOELLIA_LATIFOLIA_WINE_TEN), true, true));
	public static final RegistryObject<Item> BEST_HOLBOELLIA_LATIFOLIA_WINE = registerWithTab("best_holboellia_latifolia_wine",
			() -> new BestWineItem(wineItem(), true, true));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_POPSICLE_MACHINE = registerWithTab("holboellia_latifolia_popsicle_machine",
			() -> new BlockItem(ModBlocks.HOLBOELLIA_LATIFOLIA_POPSICLE_MACHINE.get(), basicItem()));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_MILK_TEA = registerWithTab("holboellia_latifolia_milk_tea",
			() -> new DrinkableItem(juiceItem().food(FoodValues.HOLBOELLIA_LATIFOLIA_MILK_TEA), true, false));
	//litchi
	public static final RegistryObject<Item> LITCHI_SAPLING = registerWithTab("litchi_sapling",
			() -> new BlockItem(ModBlocks.LITCHI_SAPLING.get(), new Item.Properties()));
	public static final RegistryObject<Item> LITCHI_BLOCK = registerWithTab("litchi_block",
			() -> new BlockItem(ModBlocks.LITCHI_BLOCK.get(), basicItem().stacksTo(64)));
	public static final RegistryObject<Item> LITCHI_SEEDS = registerWithTab("litchi_seeds",
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> LITCHI_SLICE = registerWithTab("litchi_slice",
			() -> new Item(foodItem(FoodValues.LITCHI_SLICE)));
	public static final RegistryObject<Item> LITCHI_POPSICLE = registerWithTab("litchi_popsicle",
			() -> new PopsicleItem(foodItem(FoodValues.LITCHI_POPSICLE)));
	public static final RegistryObject<Item> LITCHI_CAKE = registerWithTab("litchi_cake",
			()-> new ItemNameBlockItem(ModBlocks.LITCHI_CAKE.get(),new Item.Properties()
					
			));
	public static final RegistryObject<Item> LITCHI_CAKE_SLICE = registerWithTab("litchi_cake_slice",
			() -> new Item(foodItem(FoodValues.LITCHI_CAKE_SLICE)));
	public static final RegistryObject<Item> LITCHI_CRATE = registerWithTab("litchi_crate",
			() -> new BlockItem(ModBlocks.LITCHI_CRATE.get(), basicItem()));
	public static final RegistryObject<Item> LITCHI_PIE = registerWithTab("litchi_pie",
			() -> new BlockItem(ModBlocks.LITCHI_PIE.get(), basicItem()));
	public static final RegistryObject<Item> LITCHI_PIE_SLICE = registerWithTab("litchi_pie_slice",
			() -> new Item(foodItem(FoodValues.LITCHI_PIE_SLICE)));
	public static final RegistryObject<Item> LITCHI_COOKIE = registerWithTab("litchi_cookie",
			() -> new Item(foodItem(FoodValues.LITCHI_COOKIE)));
	public static final RegistryObject<Item> LITCHI_RIVER_NOODLES = registerWithTab("litchi_river_noodles",
			() -> new Item(foodItem(FoodValues.LITCHI_RIVER_NOODLES)));
	public static final RegistryObject<Item> LITCHI_RIVER_DOUGH = registerWithTab("litchi_river_dough",
			() -> new BlockItem(ModBlocks.LITCHI_RIVER_DOUGH.get(), basicItem()));
	public static final RegistryObject<Item> UNFORMED_LITCHI_RIVER_DOUGH = registerWithTab("unformed_litchi_river_dough",
			() -> new BlockItem(ModBlocks.UNFORMED_LITCHI_RIVER_DOUGH.get(), basicItem()));
	public static final RegistryObject<Item> CRISPY_LITCHI_BALL = registerWithTab("crispy_litchi_ball",
			() -> new ConsumableItem(bowlFoodItem(FoodValues.CRISPY_LITCHI_BALL), true));
	public static final RegistryObject<Item> LITCHI_BALL = registerWithTab("litchi_ball",
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> BOWLED_LITCHI_RIVER_NOODLES = registerWithTab("bowled_litchi_river_noodles",
			() -> new BlockItem(ModBlocks.BOWLED_LITCHI_RIVER_NOODLES.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> LITCHI_ICE_CREAM = registerWithTab("litchi_ice_cream",
			() -> new ConsumableItem(bowlFoodItem(FoodValues.LITCHI_ICE_CREAM), true));
	public static final RegistryObject<Item> LITCHI_JAM = registerWithTab("litchi_jam",
			() -> new BlockItem(ModBlocks.LITCHI_JAM.get(), basicItem()));
	public static final RegistryObject<Item> LITCHI_BREAD = registerWithTab("litchi_bread",
			() -> new Item(foodItem(FoodValues.LITCHI_BREAD)));
	public static final RegistryObject<Item> LITCHI_DOUGHNUT = registerWithTab("litchi_doughnut",
			() -> new Item(foodItem(FoodValues.LITCHI_DOUGHNUT)));
	public static final RegistryObject<Item> SWEETENED_LITCHI = registerWithTab("sweetened_litchi",
			() -> new BlockItem(ModBlocks.SWEETENED_LITCHI.get(), basicItem()));
	public static final RegistryObject<Item> DRIED_LITCHI = registerWithTab("dried_litchi",
			() -> new Item(foodItem(FoodValues.DRIED_LITCHI)));
	public static final RegistryObject<Item> LITCHI_JUICE = registerWithTab("litchi_juice",
			() -> new DrinkableItem(juiceItem().food(FoodValues.LITCHI_JUICE), true, false));
	public static final RegistryObject<Item> LITCHI_WINE_BARREL = registerWithTab("litchi_wine_barrel",
			() -> new BlockItem(ModBlocks.LITCHI_WINE_BARREL.get(), basicItem()));
	public static final RegistryObject<Item> LITCHI_WINE_ONE = registerWithTab("litchi_wine_one",
			() -> new DrinkableItem(wineItem().food(FoodValues.LITCHI_WINE_ONE), true, true));
	public static final RegistryObject<Item> LITCHI_WINE_TWO = registerWithTab("litchi_wine_two",
			() -> new DrinkableItem(wineItem().food(FoodValues.LITCHI_WINE_TWO), true, true));
	public static final RegistryObject<Item> LITCHI_WINE_THREE = registerWithTab("litchi_wine_three",
			() -> new DrinkableItem(wineItem().food(FoodValues.LITCHI_WINE_THREE), true, true));
	public static final RegistryObject<Item> LITCHI_WINE_FOUR = registerWithTab("litchi_wine_four",
			() -> new DrinkableItem(wineItem().food(FoodValues.LITCHI_WINE_FOUR), true, true));
	public static final RegistryObject<Item> LITCHI_WINE_FIVE = registerWithTab("litchi_wine_five",
			() -> new DrinkableItem(wineItem().food(FoodValues.LITCHI_WINE_FIVE), true, true));
	public static final RegistryObject<Item> LITCHI_WINE_SIX = registerWithTab("litchi_wine_six",
			() -> new DrinkableItem(wineItem().food(FoodValues.LITCHI_WINE_SIX), true, true));
	public static final RegistryObject<Item> LITCHI_WINE_SEVEN = registerWithTab("litchi_wine_seven",
			() -> new DrinkableItem(wineItem().food(FoodValues.LITCHI_WINE_SEVEN), true, true));
	public static final RegistryObject<Item> LITCHI_WINE_EIGHT = registerWithTab("litchi_wine_eight",
			() -> new DrinkableItem(wineItem().food(FoodValues.LITCHI_WINE_EIGHT), true, true));
	public static final RegistryObject<Item> LITCHI_WINE_NINE = registerWithTab("litchi_wine_nine",
			() -> new DrinkableItem(wineItem().food(FoodValues.LITCHI_WINE_NINE), true, true));
	public static final RegistryObject<Item> LITCHI_WINE_TEN = registerWithTab("litchi_wine_ten",
			() -> new DrinkableItem(wineItem().food(FoodValues.LITCHI_WINE_TEN), true, true));
	public static final RegistryObject<Item> BEST_LITCHI_WINE = registerWithTab("best_litchi_wine",
			() -> new BestWineItem(wineItem(), true, true));
	public static final RegistryObject<Item> LITCHI_POPSICLE_MACHINE = registerWithTab("litchi_popsicle_machine",
			() -> new BlockItem(ModBlocks.LITCHI_POPSICLE_MACHINE.get(), basicItem()));
	public static final RegistryObject<Item> LITCHI_MILK_TEA = registerWithTab("litchi_milk_tea",
			() -> new DrinkableItem(juiceItem().food(FoodValues.LITCHI_MILK_TEA), true, false));
	//apple
	public static final RegistryObject<Item> APPLE_SAPLING = registerWithTab("apple_sapling",
			() -> new BlockItem(ModBlocks.APPLE_SAPLING.get(), new Item.Properties()));
	//black tea
	public static final RegistryObject<Item> BLACK_TEA_LOG_BIG = ITEMS.register("black_tea_log_big",
			() -> new BlockItem(ModBlocks.BLACK_TEA_LOG_BIG.get(), basicItem()));
	public static final RegistryObject<Item> BLACK_TEA_LEAVES_ITEM = registerWithTab("black_tea_leaves_item",
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> WILD_BLACK_TEA_LEAVES = ITEMS.register("wild_black_tea_leaves",
			() -> new BlockItem(ModBlocks.WILD_BLACK_TEA_LEAVES.get(), basicItem()));
	public static final RegistryObject<Item> BLACK_TEA_LEAVES_BAG = ITEMS.register("black_tea_leaves_bag",
			() -> new BlockItem(ModBlocks.BLACK_TEA_LEAVES_BAG.get(), basicItem()));
	//sugar_cane
	public static final RegistryObject<Item> SUGAR_CANE_BUNDLE = ITEMS.register("sugar_cane_bundle",
			() -> new BlockItem(ModBlocks.SUGAR_CANE_BUNDLE.get(), basicItem()));
	//huoshen fruit
	public static final RegistryObject<Item> HUOSHEN_FRUIT_SEEDS = registerWithTab("huoshen_fruit_seeds",
			() -> new ItemNameBlockItem(ModBlocks.HUOSHEN_FRUIT_CROP.get(),new Item.Properties()
					
			));
	public static final RegistryObject<Item> HUOSHEN_FRUIT = registerWithTab("huoshen_fruit",
			() -> new BlockItem(ModBlocks.HUOSHEN_FRUIT.get(), basicItem().stacksTo(64)));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_SLICE = registerWithTab("huoshen_fruit_slice",
			() -> new Item(foodItem(FoodValues.HUOSHEN_FRUIT_SLICE)));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_POPSICLE = registerWithTab("huoshen_fruit_popsicle",
			() -> new PopsicleItem(foodItem(FoodValues.HUOSHEN_FRUIT_POPSICLE)));
	public static final RegistryObject<Item> WILD_HUOSHEN_FRUIT = registerWithTab("wild_huoshen_fruit",
			() -> new BlockItem(ModBlocks.WILD_HUOSHEN_FRUIT.get(), basicItem()));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_CAKE = registerWithTab("huoshen_fruit_cake",
			()-> new ItemNameBlockItem(ModBlocks.HUOSHEN_FRUIT_CAKE.get(),new Item.Properties()
					
			));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_CAKE_SLICE = registerWithTab("huoshen_fruit_cake_slice",
			() -> new Item(foodItem(FoodValues.HUOSHEN_FRUIT_CAKE_SLICE)));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_CRATE = registerWithTab("huoshen_fruit_crate",
			() -> new BlockItem(ModBlocks.HUOSHEN_FRUIT_CRATE.get(), basicItem()));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_PIE = registerWithTab("huoshen_fruit_pie",
			() -> new BlockItem(ModBlocks.HUOSHEN_FRUIT_PIE.get(), basicItem()));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_PIE_SLICE = registerWithTab("huoshen_fruit_pie_slice",
			() -> new Item(foodItem(FoodValues.HUOSHEN_FRUIT_PIE_SLICE)));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_COOKIE = registerWithTab("huoshen_fruit_cookie",
			() -> new Item(foodItem(FoodValues.HUOSHEN_FRUIT_COOKIE)));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_HONEY_SAUCE = registerWithTab("huoshen_fruit_honey_sauce",
			() -> new BlockItem(ModBlocks.HUOSHEN_FRUIT_HONEY_SAUCE.get(), basicItem()));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_JAM = registerWithTab("huoshen_fruit_jam",
			() -> new BlockItem(ModBlocks.HUOSHEN_FRUIT_JAM.get(), basicItem()));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_BREAD = registerWithTab("huoshen_fruit_bread",
			() -> new Item(foodItem(FoodValues.HUOSHEN_FRUIT_BREAD)));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_DOUGHNUT = registerWithTab("huoshen_fruit_doughnut",
			() -> new Item(foodItem(FoodValues.HUOSHEN_FRUIT_DOUGHNUT)));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_JUICE = registerWithTab("huoshen_fruit_juice",
			() -> new DrinkableItem(juiceItem().food(FoodValues.HUOSHEN_FRUIT_JUICE), true, false));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_WINE_BARREL = registerWithTab("huoshen_fruit_wine_barrel",
			() -> new BlockItem(ModBlocks.HUOSHEN_FRUIT_WINE_BARREL.get(), basicItem()));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_WINE_ONE = registerWithTab("huoshen_fruit_wine_one",
			() -> new DrinkableItem(wineItem().food(FoodValues.HUOSHEN_FRUIT_WINE_ONE), true, true));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_WINE_TWO = registerWithTab("huoshen_fruit_wine_two",
			() -> new DrinkableItem(wineItem().food(FoodValues.HUOSHEN_FRUIT_WINE_TWO), true, true));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_WINE_THREE = registerWithTab("huoshen_fruit_wine_three",
			() -> new DrinkableItem(wineItem().food(FoodValues.HUOSHEN_FRUIT_WINE_THREE), true, true));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_WINE_FOUR = registerWithTab("huoshen_fruit_wine_four",
			() -> new DrinkableItem(wineItem().food(FoodValues.HUOSHEN_FRUIT_WINE_FOUR), true, true));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_WINE_FIVE = registerWithTab("huoshen_fruit_wine_five",
			() -> new DrinkableItem(wineItem().food(FoodValues.HUOSHEN_FRUIT_WINE_FIVE), true, true));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_WINE_SIX = registerWithTab("huoshen_fruit_wine_six",
			() -> new DrinkableItem(wineItem().food(FoodValues.HUOSHEN_FRUIT_WINE_SIX), true, true));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_WINE_SEVEN = registerWithTab("huoshen_fruit_wine_seven",
			() -> new DrinkableItem(wineItem().food(FoodValues.HUOSHEN_FRUIT_WINE_SEVEN), true, true));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_WINE_EIGHT = registerWithTab("huoshen_fruit_wine_eight",
			() -> new DrinkableItem(wineItem().food(FoodValues.HUOSHEN_FRUIT_WINE_EIGHT), true, true));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_WINE_NINE = registerWithTab("huoshen_fruit_wine_nine",
			() -> new DrinkableItem(wineItem().food(FoodValues.HUOSHEN_FRUIT_WINE_NINE), true, true));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_WINE_TEN = registerWithTab("huoshen_fruit_wine_ten",
			() -> new DrinkableItem(wineItem().food(FoodValues.HUOSHEN_FRUIT_WINE_TEN), true, true));
	public static final RegistryObject<Item> BEST_HUOSHEN_FRUIT_WINE = registerWithTab("best_huoshen_fruit_wine",
			() -> new BestWineItem(wineItem(), true, true));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_POPSICLE_MACHINE = registerWithTab("huoshen_fruit_popsicle_machine",
			() -> new BlockItem(ModBlocks.HUOSHEN_FRUIT_POPSICLE_MACHINE.get(), basicItem()));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_MILK_TEA = registerWithTab("huoshen_fruit_milk_tea",
			() -> new DrinkableItem(juiceItem().food(FoodValues.HUOSHEN_FRUIT_MILK_TEA), true, false));
	//September Melon
	public static final RegistryObject<Item> SEPTEMBER_MELON_SEEDS = registerWithTab("september_melon_seeds",
			() -> new ItemNameBlockItem(ModBlocks.SEPTEMBER_MELON_CROP.get(),new Item.Properties()
					
			));
	public static final RegistryObject<Item> SEPTEMBER_MELON = registerWithTab("september_melon",
			() -> new Item(foodItem(FoodValues.SEPTEMBER_MELON)));
	public static final RegistryObject<Item> SEPTEMBER_MELON_POPSICLE = registerWithTab("september_melon_popsicle",
			() -> new PopsicleItem(foodItem(FoodValues.SEPTEMBER_MELON_POPSICLE)));
	public static final RegistryObject<Item> WILD_SEPTEMBER_MELON = registerWithTab("wild_september_melon",
			() -> new BlockItem(ModBlocks.WILD_SEPTEMBER_MELON.get(), basicItem()));
	public static final RegistryObject<Item> SEPTEMBER_MELON_CAKE = registerWithTab("september_melon_cake",
			()-> new ItemNameBlockItem(ModBlocks.SEPTEMBER_MELON_CAKE.get(),new Item.Properties()
					
			));
	public static final RegistryObject<Item> SEPTEMBER_MELON_CAKE_SLICE = registerWithTab("september_melon_cake_slice",
			() -> new Item(foodItem(FoodValues.SEPTEMBER_MELON_CAKE_SLICE)));
	public static final RegistryObject<Item> SEPTEMBER_MELON_CRATE = registerWithTab("september_melon_crate",
			() -> new BlockItem(ModBlocks.SEPTEMBER_MELON_CRATE.get(), basicItem()));
	public static final RegistryObject<Item> SEPTEMBER_MELON_PIE = registerWithTab("september_melon_pie",
			() -> new BlockItem(ModBlocks.SEPTEMBER_MELON_PIE.get(), basicItem()));
	public static final RegistryObject<Item> SEPTEMBER_MELON_PIE_SLICE = registerWithTab("september_melon_pie_slice",
			() -> new Item(foodItem(FoodValues.SEPTEMBER_MELON_PIE_SLICE)));
	public static final RegistryObject<Item> SEPTEMBER_MELON_COOKIE = registerWithTab("september_melon_cookie",
			() -> new Item(foodItem(FoodValues.SEPTEMBER_MELON_COOKIE)));
	public static final RegistryObject<Item> SEPTEMBER_MELON_JAM = registerWithTab("september_melon_jam",
			() -> new BlockItem(ModBlocks.SEPTEMBER_MELON_JAM.get(), basicItem()));
	public static final RegistryObject<Item> SEPTEMBER_MELON_BREAD = registerWithTab("september_melon_bread",
			() -> new Item(foodItem(FoodValues.SEPTEMBER_MELON_BREAD)));
	public static final RegistryObject<Item> SEPTEMBER_MELON_DOUGHNUT = registerWithTab("september_melon_doughnut",
			() -> new Item(foodItem(FoodValues.SEPTEMBER_MELON_DOUGHNUT)));
	public static final RegistryObject<Item> SEPTEMBER_MELON_JUICE = registerWithTab("september_melon_juice",
			() -> new DrinkableItem(juiceItem().food(FoodValues.SEPTEMBER_MELON_JUICE), true, false));
	public static final RegistryObject<Item> SEPTEMBER_MELON_WINE_BARREL = registerWithTab("september_melon_wine_barrel",
			() -> new BlockItem(ModBlocks.SEPTEMBER_MELON_WINE_BARREL.get(), basicItem()));
	public static final RegistryObject<Item> SEPTEMBER_MELON_WINE_ONE = registerWithTab("september_melon_wine_one",
			() -> new DrinkableItem(wineItem().food(FoodValues.SEPTEMBER_MELON_WINE_ONE), true, true));
	public static final RegistryObject<Item> SEPTEMBER_MELON_WINE_TWO = registerWithTab("september_melon_wine_two",
			() -> new DrinkableItem(wineItem().food(FoodValues.SEPTEMBER_MELON_WINE_TWO), true, true));
	public static final RegistryObject<Item> SEPTEMBER_MELON_WINE_THREE = registerWithTab("september_melon_wine_three",
			() -> new DrinkableItem(wineItem().food(FoodValues.SEPTEMBER_MELON_WINE_THREE), true, true));
	public static final RegistryObject<Item> SEPTEMBER_MELON_WINE_FOUR = registerWithTab("september_melon_wine_four",
			() -> new DrinkableItem(wineItem().food(FoodValues.SEPTEMBER_MELON_WINE_FOUR), true, true));
	public static final RegistryObject<Item> SEPTEMBER_MELON_WINE_FIVE = registerWithTab("september_melon_wine_five",
			() -> new DrinkableItem(wineItem().food(FoodValues.SEPTEMBER_MELON_WINE_FIVE), true, true));
	public static final RegistryObject<Item> SEPTEMBER_MELON_WINE_SIX = registerWithTab("september_melon_wine_six",
			() -> new DrinkableItem(wineItem().food(FoodValues.SEPTEMBER_MELON_WINE_SIX), true, true));
	public static final RegistryObject<Item> SEPTEMBER_MELON_WINE_SEVEN = registerWithTab("september_melon_wine_seven",
			() -> new DrinkableItem(wineItem().food(FoodValues.SEPTEMBER_MELON_WINE_SEVEN), true, true));
	public static final RegistryObject<Item> SEPTEMBER_MELON_WINE_EIGHT = registerWithTab("september_melon_wine_eight",
			() -> new DrinkableItem(wineItem().food(FoodValues.SEPTEMBER_MELON_WINE_EIGHT), true, true));
	public static final RegistryObject<Item> SEPTEMBER_MELON_WINE_NINE = registerWithTab("september_melon_wine_nine",
			() -> new DrinkableItem(wineItem().food(FoodValues.SEPTEMBER_MELON_WINE_NINE), true, true));
	public static final RegistryObject<Item> SEPTEMBER_MELON_WINE_TEN = registerWithTab("september_melon_wine_ten",
			() -> new DrinkableItem(wineItem().food(FoodValues.SEPTEMBER_MELON_WINE_TEN), true, true));
	public static final RegistryObject<Item> BEST_SEPTEMBER_MELON_WINE = registerWithTab("best_september_melon_wine",
			() -> new BestWineItem(wineItem(), true, true));
	public static final RegistryObject<Item> SEPTEMBER_MELON_POPSICLE_MACHINE = registerWithTab("september_melon_popsicle_machine",
			() -> new BlockItem(ModBlocks.SEPTEMBER_MELON_POPSICLE_MACHINE.get(), basicItem()));
	public static final RegistryObject<Item> SEPTEMBER_MELON_MILK_TEA = registerWithTab("september_melon_milk_tea",
			() -> new DrinkableItem(juiceItem().food(FoodValues.SEPTEMBER_MELON_MILK_TEA), true, false));
	//pitaya
	public static final RegistryObject<Item> PITAYA_SEEDS = registerWithTab("pitaya_seeds",
			()-> new ItemNameBlockItem(ModBlocks.PITAYA_CROP.get(),new Item.Properties()
					
			));
	public static final RegistryObject<Item> PITAYA = registerWithTab("pitaya",
			() -> new BlockItem(ModBlocks.PITAYA.get(), basicItem().stacksTo(64)));
	public static final RegistryObject<Item> PITAYA_SLICE = registerWithTab("pitaya_slice",
			() -> new Item(foodItem(FoodValues.PITAYA_SLICE)));
	public static final RegistryObject<Item> WILD_PITAYA = registerWithTab("wild_pitaya",
			() -> new BlockItem(ModBlocks.WILD_PITAYA.get(), basicItem()));
	public static final RegistryObject<Item> COLORFUL_FRUIT_SALAD_BLOCK = registerWithTab("colorful_fruit_salad_block",
			() -> new BlockItem(ModBlocks.COLORFUL_FRUIT_SALAD_BLOCK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> PITAYA_POPSICLE = registerWithTab("pitaya_popsicle",
			() -> new PopsicleItem(foodItem(FoodValues.PITAYA_POPSICLE)));
	public static final RegistryObject<Item> PITAYA_CAKE = registerWithTab("pitaya_cake",
			()-> new ItemNameBlockItem(ModBlocks.PITAYA_CAKE.get(),new Item.Properties()
					
			));
	public static final RegistryObject<Item> PITAYA_CAKE_SLICE = registerWithTab("pitaya_cake_slice",
			() -> new Item(foodItem(FoodValues.PITAYA_CAKE_SLICE)));
	public static final RegistryObject<Item> PITAYA_CRATE = registerWithTab("pitaya_crate",
			() -> new BlockItem(ModBlocks.PITAYA_CRATE.get(), basicItem()));
	public static final RegistryObject<Item> PITAYA_PIE = registerWithTab("pitaya_pie",
			() -> new BlockItem(ModBlocks.PITAYA_PIE.get(), basicItem()));
	public static final RegistryObject<Item> PITAYA_PIE_SLICE = registerWithTab("pitaya_pie_slice",
			() -> new Item(foodItem(FoodValues.PITAYA_PIE_SLICE)));
	public static final RegistryObject<Item> PITAYA_RICE_AND_VEGETABLE_ROLL = registerWithTab("pitaya_rice_and_vegetable_roll",
			() -> new Item(foodItem(FoodValues.PITAYA_RICE_AND_VEGETABLE_ROLL)));
	public static final RegistryObject<Item> PITAYA_COOKIE = registerWithTab("pitaya_cookie",
			() -> new Item(foodItem(FoodValues.PITAYA_COOKIE)));
	public static final RegistryObject<Item> PITAYA_JAM = registerWithTab("pitaya_jam",
			() -> new BlockItem(ModBlocks.PITAYA_JAM.get(), basicItem()));
	public static final RegistryObject<Item> PITAYA_BREAD = registerWithTab("pitaya_bread",
			() -> new Item(foodItem(FoodValues.PITAYA_BREAD)));
	public static final RegistryObject<Item> PITAYA_DOUGHNUT = registerWithTab("pitaya_doughnut",
			() -> new Item(foodItem(FoodValues.PITAYA_DOUGHNUT)));
	public static final RegistryObject<Item> PITAYA_JUICE = registerWithTab("pitaya_juice",
			() -> new DrinkableItem(juiceItem().food(FoodValues.PITAYA_JUICE), true, false));
	public static final RegistryObject<Item> SWEETENED_PITAYA = registerWithTab("sweetened_pitaya",
			() -> new BlockItem(ModBlocks.SWEETENED_PITAYA.get(), basicItem()));
	public static final RegistryObject<Item> DRIED_PITAYA = registerWithTab("dried_pitaya",
			() -> new Item(foodItem(FoodValues.DRIED_PITAYA)));
	public static final RegistryObject<Item> PITAYA_WINE_BARREL = registerWithTab("pitaya_wine_barrel",
			() -> new BlockItem(ModBlocks.PITAYA_WINE_BARREL.get(), basicItem()));
	public static final RegistryObject<Item> PITAYA_WINE_ONE = registerWithTab("pitaya_wine_one",
			() -> new DrinkableItem(wineItem().food(FoodValues.PITAYA_WINE_ONE), true, true));
	public static final RegistryObject<Item> PITAYA_WINE_TWO = registerWithTab("pitaya_wine_two",
			() -> new DrinkableItem(wineItem().food(FoodValues.PITAYA_WINE_TWO), true, true));
	public static final RegistryObject<Item> PITAYA_WINE_THREE = registerWithTab("pitaya_wine_three",
			() -> new DrinkableItem(wineItem().food(FoodValues.PITAYA_WINE_THREE), true, true));
	public static final RegistryObject<Item> PITAYA_WINE_FOUR = registerWithTab("pitaya_wine_four",
			() -> new DrinkableItem(wineItem().food(FoodValues.PITAYA_WINE_FOUR), true, true));
	public static final RegistryObject<Item> PITAYA_WINE_FIVE = registerWithTab("pitaya_wine_five",
			() -> new DrinkableItem(wineItem().food(FoodValues.PITAYA_WINE_FIVE), true, true));
	public static final RegistryObject<Item> PITAYA_WINE_SIX = registerWithTab("pitaya_wine_six",
			() -> new DrinkableItem(wineItem().food(FoodValues.PITAYA_WINE_SIX), true, true));
	public static final RegistryObject<Item> PITAYA_WINE_SEVEN = registerWithTab("pitaya_wine_seven",
			() -> new DrinkableItem(wineItem().food(FoodValues.PITAYA_WINE_SEVEN), true, true));
	public static final RegistryObject<Item> PITAYA_WINE_EIGHT = registerWithTab("pitaya_wine_eight",
			() -> new DrinkableItem(wineItem().food(FoodValues.PITAYA_WINE_EIGHT), true, true));
	public static final RegistryObject<Item> PITAYA_WINE_NINE = registerWithTab("pitaya_wine_nine",
			() -> new DrinkableItem(wineItem().food(FoodValues.PITAYA_WINE_NINE), true, true));
	public static final RegistryObject<Item> PITAYA_WINE_TEN = registerWithTab("pitaya_wine_ten",
			() -> new DrinkableItem(wineItem().food(FoodValues.PITAYA_WINE_TEN), true, true));
	public static final RegistryObject<Item> BEST_PITAYA_WINE = registerWithTab("best_pitaya_wine",
			() -> new BestWineItem(wineItem(), true, true));
	public static final RegistryObject<Item> PITAYA_POPSICLE_MACHINE = registerWithTab("pitaya_popsicle_machine",
			() -> new BlockItem(ModBlocks.PITAYA_POPSICLE_MACHINE.get(), basicItem()));
	public static final RegistryObject<Item> PITAYA_MILK_TEA = registerWithTab("pitaya_milk_tea",
			() -> new DrinkableItem(juiceItem().food(FoodValues.PITAYA_MILK_TEA), true, false));
	//golden pure sheep horn honey
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY = registerWithTab("golden_pure_sheep_horn_honey",
			() -> new BlockItem(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY.get(), basicItem().stacksTo(64)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_SEEDS = registerWithTab("golden_pure_sheep_horn_honey_seeds",
			() -> new ItemNameBlockItem(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_CROP.get(),new Item.Properties()
					
			));
	public static final RegistryObject<Item> WILD_GOLDEN_PURE_SHEEP_HORN_HONEY = registerWithTab("wild_golden_pure_sheep_horn_honey",
			() -> new BlockItem(ModBlocks.WILD_GOLDEN_PURE_SHEEP_HORN_HONEY.get(), basicItem()));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_SLICE = registerWithTab("golden_pure_sheep_horn_honey_slice",
			() -> new Item(foodItem(FoodValues.GOLDEN_PURE_SHEEP_HORN_HONEY_SLICE)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_POPSICLE = registerWithTab("golden_pure_sheep_horn_honey_popsicle",
			() -> new PopsicleItem(foodItem(FoodValues.GOLDEN_PURE_SHEEP_HORN_HONEY_POPSICLE)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_CAKE = registerWithTab("golden_pure_sheep_horn_honey_cake",
			()-> new ItemNameBlockItem(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_CAKE.get(),new Item.Properties()
					
			));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_CAKE_SLICE = registerWithTab("golden_pure_sheep_horn_honey_cake_slice",
			() -> new Item(foodItem(FoodValues.GOLDEN_PURE_SHEEP_HORN_HONEY_CAKE_SLICE)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_CRATE = registerWithTab("golden_pure_sheep_horn_honey_crate",
			() -> new BlockItem(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_CRATE.get(), basicItem()));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_PIE = registerWithTab("golden_pure_sheep_horn_honey_pie",
			() -> new BlockItem(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_PIE.get(), basicItem()));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_PIE_SLICE = registerWithTab("golden_pure_sheep_horn_honey_pie_slice",
			() -> new Item(foodItem(FoodValues.GOLDEN_PURE_SHEEP_HORN_HONEY_PIE_SLICE)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_COOKIE = registerWithTab("golden_pure_sheep_horn_honey_cookie",
			() -> new Item(foodItem(FoodValues.GOLDEN_PURE_SHEEP_HORN_HONEY_COOKIE)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_FLAVOR_GOLDEN_PURE_SHEEP_HORN_HONEY = registerWithTab("golden_pure_sheep_horn_honey_flavor_golden_pure_sheep_horn_honey",
			() -> new Item(foodItem(FoodValues.GOLDEN_PURE_SHEEP_HORN_HONEY_FLAVOR_GOLDEN_PURE_SHEEP_HORN_HONEY)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_JAM = registerWithTab("golden_pure_sheep_horn_honey_jam",
			() -> new BlockItem(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_JAM.get(), basicItem()));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_BREAD = registerWithTab("golden_pure_sheep_horn_honey_bread",
			() -> new Item(foodItem(FoodValues.GOLDEN_PURE_SHEEP_HORN_HONEY_BREAD)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_DOUGHNUT = registerWithTab("golden_pure_sheep_horn_honey_doughnut",
			() -> new Item(foodItem(FoodValues.GOLDEN_PURE_SHEEP_HORN_HONEY_DOUGHNUT)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_JUICE = registerWithTab("golden_pure_sheep_horn_honey_juice",
			() -> new DrinkableItem(juiceItem().food(FoodValues.GOLDEN_PURE_SHEEP_HORN_HONEY_JUICE), true, false));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_BARREL = registerWithTab("golden_pure_sheep_horn_honey_wine_barrel",
			() -> new BlockItem(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_BARREL.get(), basicItem()));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_ONE = registerWithTab("golden_pure_sheep_horn_honey_wine_one",
			() -> new DrinkableItem(wineItem().food(FoodValues.GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_ONE), true, true));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_TWO = registerWithTab("golden_pure_sheep_horn_honey_wine_two",
			() -> new DrinkableItem(wineItem().food(FoodValues.GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_TWO), true, true));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_THREE = registerWithTab("golden_pure_sheep_horn_honey_wine_three",
			() -> new DrinkableItem(wineItem().food(FoodValues.GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_THREE), true, true));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_FOUR = registerWithTab("golden_pure_sheep_horn_honey_wine_four",
			() -> new DrinkableItem(wineItem().food(FoodValues.GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_FOUR), true, true));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_FIVE = registerWithTab("golden_pure_sheep_horn_honey_wine_five",
			() -> new DrinkableItem(wineItem().food(FoodValues.GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_FIVE), true, true));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_SIX = registerWithTab("golden_pure_sheep_horn_honey_wine_six",
			() -> new DrinkableItem(wineItem().food(FoodValues.GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_SIX), true, true));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_SEVEN = registerWithTab("golden_pure_sheep_horn_honey_wine_seven",
			() -> new DrinkableItem(wineItem().food(FoodValues.GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_SEVEN), true, true));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_EIGHT = registerWithTab("golden_pure_sheep_horn_honey_wine_eight",
			() -> new DrinkableItem(wineItem().food(FoodValues.GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_EIGHT), true, true));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_NINE = registerWithTab("golden_pure_sheep_horn_honey_wine_nine",
			() -> new DrinkableItem(wineItem().food(FoodValues.GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_NINE), true, true));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_TEN = registerWithTab("golden_pure_sheep_horn_honey_wine_ten",
			() -> new DrinkableItem(wineItem().food(FoodValues.GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_TEN), true, true));
	public static final RegistryObject<Item> BEST_GOLDEN_PURE_SHEEP_HORN_HONEY_WINE = registerWithTab("best_golden_pure_sheep_horn_honey_wine",
			() -> new BestWineItem(wineItem(), true, true));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_POPSICLE_MACHINE = registerWithTab("golden_pure_sheep_horn_honey_popsicle_machine",
			() -> new BlockItem(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_POPSICLE_MACHINE.get(), basicItem()));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_MILK_TEA = registerWithTab("golden_pure_sheep_horn_honey_milk_tea",
			() -> new DrinkableItem(juiceItem().food(FoodValues.GOLDEN_PURE_SHEEP_HORN_HONEY_MILK_TEA), true, false));
	//pear
	public static final RegistryObject<Item> PEAR_BLOCK = registerWithTab("pear_block",
			() -> new BlockItem(ModBlocks.PEAR_BLOCK.get(), basicItem().stacksTo(64)));
	public static final RegistryObject<Item> PEAR_SLICE = registerWithTab("pear_slice",
			() -> new Item(foodItem(FoodValues.PEAR_SLICE)));
	public static final RegistryObject<Item> PEAR_SAPLING = registerWithTab("pear_sapling",
			() -> new BlockItem(ModBlocks.PEAR_SAPLING.get(), new Item.Properties()));
	public static final RegistryObject<Item> PEAR_POPSICLE = registerWithTab("pear_popsicle",
			() -> new PopsicleItem(foodItem(FoodValues.PEAR_POPSICLE)));
	public static final RegistryObject<Item> PEAR_CAKE = registerWithTab("pear_cake",
			()-> new ItemNameBlockItem(ModBlocks.PEAR_CAKE.get(),new Item.Properties()
					
			));
	public static final RegistryObject<Item> PEAR_PIE = registerWithTab("pear_pie",
			() -> new BlockItem(ModBlocks.PEAR_PIE.get(), basicItem()));
	public static final RegistryObject<Item> PEAR_PIE_SLICE = registerWithTab("pear_pie_slice",
			() -> new Item(foodItem(FoodValues.PEAR_PIE_SLICE)));
	public static final RegistryObject<Item> PEAR_CAKE_SLICE = registerWithTab("pear_cake_slice",
			() -> new Item(foodItem(FoodValues.PEAR_CAKE_SLICE)));
	public static final RegistryObject<Item> PEAR_CRATE = registerWithTab("pear_crate",
			() -> new BlockItem(ModBlocks.PEAR_CRATE.get(), basicItem()));
	public static final RegistryObject<Item> PEAR_COOKIE = registerWithTab("pear_cookie",
			() -> new Item(foodItem(FoodValues.PEAR_COOKIE)));
	public static final RegistryObject<Item> PEAR_JAM = registerWithTab("pear_jam",
			() -> new BlockItem(ModBlocks.PEAR_JAM.get(), basicItem()));
	public static final RegistryObject<Item> PEAR_BREAD = registerWithTab("pear_bread",
			() -> new Item(foodItem(FoodValues.PEAR_BREAD)));
	public static final RegistryObject<Item> PEAR_DOUGHNUT = registerWithTab("pear_doughnut",
			() -> new Item(foodItem(FoodValues.PEAR_DOUGHNUT)));
	public static final RegistryObject<Item> PEAR_JUICE = registerWithTab("pear_juice",
			() -> new DrinkableItem(juiceItem().food(FoodValues.PEAR_JUICE), true, false));
	public static final RegistryObject<Item> ROCK_SUPAR_SNOW_PEAR = registerWithTab("rock_sugar_snow_pear",
			() -> new BlockItem(ModBlocks.ROCK_SUPAR_SNOW_PEAR.get(), basicItem()));
	public static final RegistryObject<Item> PEAR_WINE_BARREL = registerWithTab("pear_wine_barrel",
			() -> new BlockItem(ModBlocks.PEAR_WINE_BARREL.get(), basicItem()));
	public static final RegistryObject<Item> PEAR_WINE_ONE = registerWithTab("pear_wine_one",
			() -> new DrinkableItem(wineItem().food(FoodValues.PEAR_WINE_ONE), true, true));
	public static final RegistryObject<Item> PEAR_WINE_TWO = registerWithTab("pear_wine_two",
			() -> new DrinkableItem(wineItem().food(FoodValues.PEAR_WINE_TWO), true, true));
	public static final RegistryObject<Item> PEAR_WINE_THREE = registerWithTab("pear_wine_three",
			() -> new DrinkableItem(wineItem().food(FoodValues.PEAR_WINE_THREE), true, true));
	public static final RegistryObject<Item> PEAR_WINE_FOUR = registerWithTab("pear_wine_four",
			() -> new DrinkableItem(wineItem().food(FoodValues.PEAR_WINE_FOUR), true, true));
	public static final RegistryObject<Item> PEAR_WINE_FIVE = registerWithTab("pear_wine_five",
			() -> new DrinkableItem(wineItem().food(FoodValues.PEAR_WINE_FIVE), true, true));
	public static final RegistryObject<Item> PEAR_WINE_SIX = registerWithTab("pear_wine_six",
			() -> new DrinkableItem(wineItem().food(FoodValues.PEAR_WINE_SIX), true, true));
	public static final RegistryObject<Item> PEAR_WINE_SEVEN = registerWithTab("pear_wine_seven",
			() -> new DrinkableItem(wineItem().food(FoodValues.PEAR_WINE_SEVEN), true, true));
	public static final RegistryObject<Item> PEAR_WINE_EIGHT = registerWithTab("pear_wine_eight",
			() -> new DrinkableItem(wineItem().food(FoodValues.PEAR_WINE_EIGHT), true, true));
	public static final RegistryObject<Item> PEAR_WINE_NINE = registerWithTab("pear_wine_nine",
			() -> new DrinkableItem(wineItem().food(FoodValues.PEAR_WINE_NINE), true, true));
	public static final RegistryObject<Item> PEAR_WINE_TEN = registerWithTab("pear_wine_ten",
			() -> new DrinkableItem(wineItem().food(FoodValues.PEAR_WINE_TEN), true, true));
	public static final RegistryObject<Item> BEST_PEAR_WINE = registerWithTab("best_pear_wine",
			() -> new BestWineItem(wineItem(), true, true));
	public static final RegistryObject<Item> PEAR_POPSICLE_MACHINE = registerWithTab("pear_popsicle_machine",
			() -> new BlockItem(ModBlocks.PEAR_POPSICLE_MACHINE.get(), basicItem()));
	public static final RegistryObject<Item> PEAR_MILK_TEA = registerWithTab("pear_milk_tea",
			() -> new DrinkableItem(juiceItem().food(FoodValues.PEAR_MILK_TEA), true, false));
	//maythorn
	public static final RegistryObject<Item> MAYTHORN = registerWithTab("maythorn",
			() -> new Item(foodItem(FoodValues.MAYTHORN)));
	public static final RegistryObject<Item> MAYTHORN_SAPLING = registerWithTab("maythorn_sapling",
			() -> new BlockItem(ModBlocks.MAYTHORN_SAPLING.get(), new Item.Properties()));
	public static final RegistryObject<Item> MAYTHORN_POPSICLE = registerWithTab("maythorn_popsicle",
			() -> new PopsicleItem(foodItem(FoodValues.MAYTHORN_POPSICLE)));
	public static final RegistryObject<Item> MAYTHORN_CAKE = registerWithTab("maythorn_cake",
			()-> new ItemNameBlockItem(ModBlocks.MAYTHORN_CAKE.get(),new Item.Properties()
					
			));
	public static final RegistryObject<Item> MAYTHORN_PIE = registerWithTab("maythorn_pie",
			() -> new BlockItem(ModBlocks.MAYTHORN_PIE.get(), basicItem()));
	public static final RegistryObject<Item> MAYTHORN_PIE_SLICE = registerWithTab("maythorn_pie_slice",
			() -> new Item(foodItem(FoodValues.MAYTHORN_PIE_SLICE)));
	public static final RegistryObject<Item> MAYTHORN_CAKE_SLICE = registerWithTab("maythorn_cake_slice",
			() -> new Item(foodItem(FoodValues.MAYTHORN_CAKE_SLICE)));
	public static final RegistryObject<Item> MAYTHORN_CRATE = registerWithTab("maythorn_crate",
			() -> new BlockItem(ModBlocks.MAYTHORN_CRATE.get(), basicItem()));
	public static final RegistryObject<Item> MAYTHORN_COOKIE = registerWithTab("maythorn_cookie",
			() -> new Item(foodItem(FoodValues.MAYTHORN_COOKIE)));
	public static final RegistryObject<Item> MAYTHORN_JAM = registerWithTab("maythorn_jam",
			() -> new BlockItem(ModBlocks.MAYTHORN_JAM.get(), basicItem()));
	public static final RegistryObject<Item> MAYTHORN_BREAD = registerWithTab("maythorn_bread",
			() -> new Item(foodItem(FoodValues.MAYTHORN_BREAD)));
	public static final RegistryObject<Item> MAYTHORN_DOUGHNUT = registerWithTab("maythorn_doughnut",
			() -> new Item(foodItem(FoodValues.MAYTHORN_DOUGHNUT)));
	public static final RegistryObject<Item> MAYTHORN_JUICE = registerWithTab("maythorn_juice",
			() -> new DrinkableItem(juiceItem().food(FoodValues.MAYTHORN_JUICE), true, false));
	public static final RegistryObject<Item> SWEETENED_MAYTHORN = registerWithTab("sweetened_maythorn",
			() -> new BlockItem(ModBlocks.SWEETENED_MAYTHORN.get(), basicItem()));
	public static final RegistryObject<Item> DRIED_MAYTHORN = registerWithTab("dried_maythorn",
			() -> new Item(foodItem(FoodValues.DRIED_MAYTHORN)));
	public static final RegistryObject<Item> CANDIED_HAWS_ON_A_STICK = registerWithTab("candied_haws_on_a_stick",
			() -> new ConsumableItem(foodItem(FoodValues.CANDIED_HAWS_ON_A_STICK),true));
	public static final RegistryObject<Item> BOWLED_CANDIED_HAWS_ON_A_STICK = registerWithTab("bowled_candied_haws_on_a_stick",
			() -> new BlockItem(ModBlocks.BOWLED_CANDIED_HAWS_ON_A_STICK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> A_BUNDLE_OF_CANDIED_HAWS_ON_A_STICK = registerWithTab("a_bundle_of_candied_haws_on_a_stick",
			() -> new BlockItem(ModBlocks.A_BUNDLE_OF_CANDIED_HAWS_ON_A_STICK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> RED_FRUIT_MAYTHORN_CAKE = registerWithTab("red_fruit_maythorn_cake",
			() -> new BlockItem(ModBlocks.RED_FRUIT_MAYTHORN_CAKE.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> MAYTHORN_WINE_BARREL = registerWithTab("maythorn_wine_barrel",
			() -> new BlockItem(ModBlocks.MAYTHORN_WINE_BARREL.get(), basicItem()));
	public static final RegistryObject<Item> MAYTHORN_WINE_ONE = registerWithTab("maythorn_wine_one",
			() -> new DrinkableItem(wineItem().food(FoodValues.MAYTHORN_WINE_ONE), true, true));
	public static final RegistryObject<Item> MAYTHORN_WINE_TWO = registerWithTab("maythorn_wine_two",
			() -> new DrinkableItem(wineItem().food(FoodValues.MAYTHORN_WINE_TWO), true, true));
	public static final RegistryObject<Item> MAYTHORN_WINE_THREE = registerWithTab("maythorn_wine_three",
			() -> new DrinkableItem(wineItem().food(FoodValues.MAYTHORN_WINE_THREE), true, true));
	public static final RegistryObject<Item> MAYTHORN_WINE_FOUR = registerWithTab("maythorn_wine_four",
			() -> new DrinkableItem(wineItem().food(FoodValues.MAYTHORN_WINE_FOUR), true, true));
	public static final RegistryObject<Item> MAYTHORN_WINE_FIVE = registerWithTab("maythorn_wine_five",
			() -> new DrinkableItem(wineItem().food(FoodValues.MAYTHORN_WINE_FIVE), true, true));
	public static final RegistryObject<Item> MAYTHORN_WINE_SIX = registerWithTab("maythorn_wine_six",
			() -> new DrinkableItem(wineItem().food(FoodValues.MAYTHORN_WINE_SIX), true, true));
	public static final RegistryObject<Item> MAYTHORN_WINE_SEVEN = registerWithTab("maythorn_wine_seven",
			() -> new DrinkableItem(wineItem().food(FoodValues.MAYTHORN_WINE_SEVEN), true, true));
	public static final RegistryObject<Item> MAYTHORN_WINE_EIGHT = registerWithTab("maythorn_wine_eight",
			() -> new DrinkableItem(wineItem().food(FoodValues.MAYTHORN_WINE_EIGHT), true, true));
	public static final RegistryObject<Item> MAYTHORN_WINE_NINE = registerWithTab("maythorn_wine_nine",
			() -> new DrinkableItem(wineItem().food(FoodValues.MAYTHORN_WINE_NINE), true, true));
	public static final RegistryObject<Item> MAYTHORN_WINE_TEN = registerWithTab("maythorn_wine_ten",
			() -> new DrinkableItem(wineItem().food(FoodValues.MAYTHORN_WINE_TEN), true, true));
	public static final RegistryObject<Item> BEST_MAYTHORN_WINE = registerWithTab("best_maythorn_wine",
			() -> new BestWineItem(wineItem(), true, true));
	public static final RegistryObject<Item> MAYTHORN_POPSICLE_MACHINE = registerWithTab("maythorn_popsicle_machine",
			() -> new BlockItem(ModBlocks.MAYTHORN_POPSICLE_MACHINE.get(), basicItem()));
	public static final RegistryObject<Item> MAYTHORN_MILK_TEA = registerWithTab("maythorn_milk_tea",
			() -> new DrinkableItem(juiceItem().food(FoodValues.MAYTHORN_MILK_TEA), true, false));
	//chinese_pear-leaved
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_BLOCK = registerWithTab("chinese_pear_leaved_block",
			() -> new BlockItem(ModBlocks.CHINESE_PEAR_LEAVED_BLOCK.get(), basicItem().stacksTo(64)));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_SLICE = registerWithTab("chinese_pear_leaved_slice",
			() -> new Item(foodItem(FoodValues.CHINESE_PEAR_LEAVED_SLICE)));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_SAPLING = registerWithTab("chinese_pear_leaved_sapling",
			() -> new BlockItem(ModBlocks.CHINESE_PEAR_LEAVED_SAPLING.get(), new Item.Properties()));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_POPSICLE = registerWithTab("chinese_pear_leaved_popsicle",
			() -> new PopsicleItem(foodItem(FoodValues.CHINESE_PEAR_LEAVED_POPSICLE)));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_CAKE = registerWithTab("chinese_pear_leaved_cake",
			()-> new ItemNameBlockItem(ModBlocks.CHINESE_PEAR_LEAVED_CAKE.get(),new Item.Properties()
					
			));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_PIE = registerWithTab("chinese_pear_leaved_pie",
			() -> new BlockItem(ModBlocks.CHINESE_PEAR_LEAVED_PIE.get(), basicItem()));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_PIE_SLICE = registerWithTab("chinese_pear_leaved_pie_slice",
			() -> new Item(foodItem(FoodValues.CHINESE_PEAR_LEAVED_PIE_SLICE)));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_CAKE_SLICE = registerWithTab("chinese_pear_leaved_cake_slice",
			() -> new Item(foodItem(FoodValues.CHINESE_PEAR_LEAVED_CAKE_SLICE)));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_CRATE = registerWithTab("chinese_pear_leaved_crate",
			() -> new BlockItem(ModBlocks.CHINESE_PEAR_LEAVED_CRATE.get(), basicItem()));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_COOKIE = registerWithTab("chinese_pear_leaved_cookie",
			() -> new Item(foodItem(FoodValues.CHINESE_PEAR_LEAVED_COOKIE)));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_JAM = registerWithTab("chinese_pear_leaved_jam",
			() -> new BlockItem(ModBlocks.CHINESE_PEAR_LEAVED_JAM.get(), basicItem()));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_BREAD = registerWithTab("chinese_pear_leaved_bread",
			() -> new Item(foodItem(FoodValues.CHINESE_PEAR_LEAVED_BREAD)));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_DOUGHNUT = registerWithTab("chinese_pear_leaved_doughnut",
			() -> new Item(foodItem(FoodValues.CHINESE_PEAR_LEAVED_DOUGHNUT)));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_JUICE = registerWithTab("chinese_pear_leaved_juice",
			() -> new DrinkableItem(juiceItem().food(FoodValues.CHINESE_PEAR_LEAVED_JUICE), true, false));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_ROLLS = registerWithTab("chinese_pear_leaved_rolls",
			() -> new Item(foodItem(FoodValues.CHINESE_PEAR_LEAVED_ROLLS)));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_WINE_BARREL = registerWithTab("chinese_pear_leaved_wine_barrel",
			() -> new BlockItem(ModBlocks.CHINESE_PEAR_LEAVED_WINE_BARREL.get(), basicItem()));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_WINE_ONE = registerWithTab("chinese_pear_leaved_wine_one",
			() -> new DrinkableItem(wineItem().food(FoodValues.CHINESE_PEAR_LEAVED_WINE_ONE), true, true));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_WINE_TWO = registerWithTab("chinese_pear_leaved_wine_two",
			() -> new DrinkableItem(wineItem().food(FoodValues.CHINESE_PEAR_LEAVED_WINE_TWO), true, true));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_WINE_THREE = registerWithTab("chinese_pear_leaved_wine_three",
			() -> new DrinkableItem(wineItem().food(FoodValues.CHINESE_PEAR_LEAVED_WINE_THREE), true, true));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_WINE_FOUR = registerWithTab("chinese_pear_leaved_wine_four",
			() -> new DrinkableItem(wineItem().food(FoodValues.CHINESE_PEAR_LEAVED_WINE_FOUR), true, true));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_WINE_FIVE = registerWithTab("chinese_pear_leaved_wine_five",
			() -> new DrinkableItem(wineItem().food(FoodValues.CHINESE_PEAR_LEAVED_WINE_FIVE), true, true));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_WINE_SIX = registerWithTab("chinese_pear_leaved_wine_six",
			() -> new DrinkableItem(wineItem().food(FoodValues.CHINESE_PEAR_LEAVED_WINE_SIX), true, true));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_WINE_SEVEN = registerWithTab("chinese_pear_leaved_wine_seven",
			() -> new DrinkableItem(wineItem().food(FoodValues.CHINESE_PEAR_LEAVED_WINE_SEVEN), true, true));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_WINE_EIGHT = registerWithTab("chinese_pear_leaved_wine_eight",
			() -> new DrinkableItem(wineItem().food(FoodValues.CHINESE_PEAR_LEAVED_WINE_EIGHT), true, true));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_WINE_NINE = registerWithTab("chinese_pear_leaved_wine_nine",
			() -> new DrinkableItem(wineItem().food(FoodValues.CHINESE_PEAR_LEAVED_WINE_NINE), true, true));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_WINE_TEN = registerWithTab("chinese_pear_leaved_wine_ten",
			() -> new DrinkableItem(wineItem().food(FoodValues.CHINESE_PEAR_LEAVED_WINE_TEN), true, true));
	public static final RegistryObject<Item> BEST_CHINESE_PEAR_LEAVED_WINE = registerWithTab("best_chinese_pear_leaved_wine",
			() -> new BestWineItem(wineItem(), true, true));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_POPSICLE_MACHINE = registerWithTab("chinese_pear_leaved_popsicle_machine",
			() -> new BlockItem(ModBlocks.CHINESE_PEAR_LEAVED_POPSICLE_MACHINE.get(), basicItem()));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_MILK_TEA = registerWithTab("chinese_pear_leaved_milk_tea",
			() -> new DrinkableItem(juiceItem().food(FoodValues.CHINESE_PEAR_LEAVED_MILK_TEA), true, false));
	//plum
	public static final RegistryObject<Item> PLUM = registerWithTab("plum",
			() -> new Item(foodItem(FoodValues.PLUM)));
	public static final RegistryObject<Item> PLUM_SAPLING = registerWithTab("plum_sapling",
			() -> new BlockItem(ModBlocks.PLUM_SAPLING.get(), new Item.Properties()));
	public static final RegistryObject<Item> PLUM_POPSICLE = registerWithTab("plum_popsicle",
			() -> new PopsicleItem(foodItem(FoodValues.PLUM_POPSICLE)));
	public static final RegistryObject<Item> PLUM_CAKE = registerWithTab("plum_cake",
			()-> new ItemNameBlockItem(ModBlocks.PLUM_CAKE.get(),new Item.Properties()
					
			));
	public static final RegistryObject<Item> PLUM_PIE = registerWithTab("plum_pie",
			() -> new BlockItem(ModBlocks.PLUM_PIE.get(), basicItem()));
	public static final RegistryObject<Item> PLUM_PIE_SLICE = registerWithTab("plum_pie_slice",
			() -> new Item(foodItem(FoodValues.PLUM_PIE_SLICE)));
	public static final RegistryObject<Item> PLUM_CAKE_SLICE = registerWithTab("plum_cake_slice",
			() -> new Item(foodItem(FoodValues.PLUM_CAKE_SLICE)));
	public static final RegistryObject<Item> PLUM_CRATE = registerWithTab("plum_crate",
			() -> new BlockItem(ModBlocks.PLUM_CRATE.get(), basicItem()));
	public static final RegistryObject<Item> PLUM_COOKIE = registerWithTab("plum_cookie",
			() -> new Item(foodItem(FoodValues.PLUM_COOKIE)));
	public static final RegistryObject<Item> PLUM_JAM = registerWithTab("plum_jam",
			() -> new BlockItem(ModBlocks.PLUM_JAM.get(), basicItem()));
	public static final RegistryObject<Item> PLUM_BREAD = registerWithTab("plum_bread",
			() -> new Item(foodItem(FoodValues.PLUM_BREAD)));
	public static final RegistryObject<Item> PLUM_DOUGHNUT = registerWithTab("plum_doughnut",
			() -> new Item(foodItem(FoodValues.PLUM_DOUGHNUT)));
	public static final RegistryObject<Item> SWEETENED_PLUM = registerWithTab("sweetened_plum",
			() -> new BlockItem(ModBlocks.SWEETENED_PLUM.get(), basicItem()));
	public static final RegistryObject<Item> DRIED_PLUM = registerWithTab("dried_plum",
			() -> new Item(foodItem(FoodValues.DRIED_PLUM)));
	public static final RegistryObject<Item> PLUM_JUICE = registerWithTab("plum_juice",
			() -> new DrinkableItem(juiceItem().food(FoodValues.PLUM_JUICE), true, false));
	public static final RegistryObject<Item> SOUR_AND_SWEET_PLUM_CAKE = registerWithTab("sour_and_sweet_plum_cake",
			() -> new BlockItem(ModBlocks.SOUR_AND_SWEET_PLUM_CAKE.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> PLUM_WINE_BARREL = registerWithTab("plum_wine_barrel",
			() -> new BlockItem(ModBlocks.PLUM_WINE_BARREL.get(), basicItem()));
	public static final RegistryObject<Item> PLUM_WINE_ONE = registerWithTab("plum_wine_one",
			() -> new DrinkableItem(wineItem().food(FoodValues.PLUM_WINE_ONE), true, true));
	public static final RegistryObject<Item> PLUM_WINE_TWO = registerWithTab("plum_wine_two",
			() -> new DrinkableItem(wineItem().food(FoodValues.PLUM_WINE_TWO), true, true));
	public static final RegistryObject<Item> PLUM_WINE_THREE = registerWithTab("plum_wine_three",
			() -> new DrinkableItem(wineItem().food(FoodValues.PLUM_WINE_THREE), true, true));
	public static final RegistryObject<Item> PLUM_WINE_FOUR = registerWithTab("plum_wine_four",
			() -> new DrinkableItem(wineItem().food(FoodValues.PLUM_WINE_FOUR), true, true));
	public static final RegistryObject<Item> PLUM_WINE_FIVE = registerWithTab("plum_wine_five",
			() -> new DrinkableItem(wineItem().food(FoodValues.PLUM_WINE_FIVE), true, true));
	public static final RegistryObject<Item> PLUM_WINE_SIX = registerWithTab("plum_wine_six",
			() -> new DrinkableItem(wineItem().food(FoodValues.PLUM_WINE_SIX), true, true));
	public static final RegistryObject<Item> PLUM_WINE_SEVEN = registerWithTab("plum_wine_seven",
			() -> new DrinkableItem(wineItem().food(FoodValues.PLUM_WINE_SEVEN), true, true));
	public static final RegistryObject<Item> PLUM_WINE_EIGHT = registerWithTab("plum_wine_eight",
			() -> new DrinkableItem(wineItem().food(FoodValues.PLUM_WINE_EIGHT), true, true));
	public static final RegistryObject<Item> PLUM_WINE_NINE = registerWithTab("plum_wine_nine",
			() -> new DrinkableItem(wineItem().food(FoodValues.PLUM_WINE_NINE), true, true));
	public static final RegistryObject<Item> PLUM_WINE_TEN = registerWithTab("plum_wine_ten",
			() -> new DrinkableItem(wineItem().food(FoodValues.PLUM_WINE_TEN), true, true));
	public static final RegistryObject<Item> BEST_PLUM_WINE = registerWithTab("best_plum_wine",
			() -> new BestWineItem(wineItem(), true, true));
	public static final RegistryObject<Item> PLUM_POPSICLE_MACHINE = registerWithTab("plum_popsicle_machine",
			() -> new BlockItem(ModBlocks.PLUM_POPSICLE_MACHINE.get(), basicItem()));
	public static final RegistryObject<Item> PLUM_MILK_TEA = registerWithTab("plum_milk_tea",
			() -> new DrinkableItem(juiceItem().food(FoodValues.PLUM_MILK_TEA), true, false));
	//jujube
	public static final RegistryObject<Item> JUJUBE = registerWithTab("jujube",
			() -> new Item(foodItem(FoodValues.JUJUBE)));
	public static final RegistryObject<Item> JUJUBE_SAPLING = registerWithTab("jujube_sapling",
			() -> new BlockItem(ModBlocks.JUJUBE_SAPLING.get(), new Item.Properties()));
	public static final RegistryObject<Item> JUJUBE_POPSICLE = registerWithTab("jujube_popsicle",
			() -> new PopsicleItem(foodItem(FoodValues.JUJUBE_POPSICLE)));
	public static final RegistryObject<Item> JUJUBE_CAKE = registerWithTab("jujube_cake",
			()-> new ItemNameBlockItem(ModBlocks.JUJUBE_CAKE.get(),new Item.Properties()
					
			));
	public static final RegistryObject<Item> JUJUBE_PIE = registerWithTab("jujube_pie",
			() -> new BlockItem(ModBlocks.JUJUBE_PIE.get(), basicItem()));
	public static final RegistryObject<Item> JUJUBE_PIE_SLICE = registerWithTab("jujube_pie_slice",
			() -> new Item(foodItem(FoodValues.JUJUBE_PIE_SLICE)));
	public static final RegistryObject<Item> JUJUBE_CAKE_SLICE = registerWithTab("jujube_cake_slice",
			() -> new Item(foodItem(FoodValues.JUJUBE_CAKE_SLICE)));
	public static final RegistryObject<Item> JUJUBE_CRATE = registerWithTab("jujube_crate",
			() -> new BlockItem(ModBlocks.JUJUBE_CRATE.get(), basicItem()));
	public static final RegistryObject<Item> JUJUBE_COOKIE = registerWithTab("jujube_cookie",
			() -> new Item(foodItem(FoodValues.JUJUBE_COOKIE)));
	public static final RegistryObject<Item> JUJUBE_JAM = registerWithTab("jujube_jam",
			() -> new BlockItem(ModBlocks.JUJUBE_JAM.get(), basicItem()));
	public static final RegistryObject<Item> JUJUBE_BREAD = registerWithTab("jujube_bread",
			() -> new Item(foodItem(FoodValues.JUJUBE_BREAD)));
	public static final RegistryObject<Item> JUJUBE_DOUGHNUT = registerWithTab("jujube_doughnut",
			() -> new Item(foodItem(FoodValues.JUJUBE_DOUGHNUT)));
	public static final RegistryObject<Item> SWEETENED_JUJUBE = registerWithTab("sweetened_jujube",
			() -> new BlockItem(ModBlocks.SWEETENED_JUJUBE.get(), basicItem()));
	public static final RegistryObject<Item> DRIED_JUJUBE = registerWithTab("dried_jujube",
			() -> new Item(foodItem(FoodValues.DRIED_JUJUBE)));
	public static final RegistryObject<Item> JUJUBE_JUICE = registerWithTab("jujube_juice",
			() -> new DrinkableItem(juiceItem().food(FoodValues.JUJUBE_JUICE), true, false));
	public static final RegistryObject<Item> RED_GATE_GLUTINOUS_RICE = registerWithTab("red_gate_glutinous_rice",
			() -> new BlockItem(ModBlocks.RED_GATE_GLUTINOUS_RICE.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> JUJUBE_WINE_BARREL = registerWithTab("jujube_wine_barrel",
			() -> new BlockItem(ModBlocks.JUJUBE_WINE_BARREL.get(), basicItem()));
	public static final RegistryObject<Item> JUJUBE_WINE_ONE = registerWithTab("jujube_wine_one",
			() -> new DrinkableItem(wineItem().food(FoodValues.JUJUBE_WINE_ONE), true, true));
	public static final RegistryObject<Item> JUJUBE_WINE_TWO = registerWithTab("jujube_wine_two",
			() -> new DrinkableItem(wineItem().food(FoodValues.JUJUBE_WINE_TWO), true, true));
	public static final RegistryObject<Item> JUJUBE_WINE_THREE = registerWithTab("jujube_wine_three",
			() -> new DrinkableItem(wineItem().food(FoodValues.JUJUBE_WINE_THREE), true, true));
	public static final RegistryObject<Item> JUJUBE_WINE_FOUR = registerWithTab("jujube_wine_four",
			() -> new DrinkableItem(wineItem().food(FoodValues.JUJUBE_WINE_FOUR), true, true));
	public static final RegistryObject<Item> JUJUBE_WINE_FIVE = registerWithTab("jujube_wine_five",
			() -> new DrinkableItem(wineItem().food(FoodValues.JUJUBE_WINE_FIVE), true, true));
	public static final RegistryObject<Item> JUJUBE_WINE_SIX = registerWithTab("jujube_wine_six",
			() -> new DrinkableItem(wineItem().food(FoodValues.JUJUBE_WINE_SIX), true, true));
	public static final RegistryObject<Item> JUJUBE_WINE_SEVEN = registerWithTab("jujube_wine_seven",
			() -> new DrinkableItem(wineItem().food(FoodValues.JUJUBE_WINE_SEVEN), true, true));
	public static final RegistryObject<Item> JUJUBE_WINE_EIGHT = registerWithTab("jujube_wine_eight",
			() -> new DrinkableItem(wineItem().food(FoodValues.JUJUBE_WINE_EIGHT), true, true));
	public static final RegistryObject<Item> JUJUBE_WINE_NINE = registerWithTab("jujube_wine_nine",
			() -> new DrinkableItem(wineItem().food(FoodValues.JUJUBE_WINE_NINE), true, true));
	public static final RegistryObject<Item> JUJUBE_WINE_TEN = registerWithTab("jujube_wine_ten",
			() -> new DrinkableItem(wineItem().food(FoodValues.JUJUBE_WINE_TEN), true, true));
	public static final RegistryObject<Item> BEST_JUJUBE_WINE = registerWithTab("best_jujube_wine",
			() -> new BestWineItem(wineItem(), true, true));
	public static final RegistryObject<Item> JUJUBE_POPSICLE_MACHINE = registerWithTab("jujube_popsicle_machine",
			() -> new BlockItem(ModBlocks.JUJUBE_POPSICLE_MACHINE.get(), basicItem()));
	public static final RegistryObject<Item> JUJUBE_MILK_TEA = registerWithTab("jujube_milk_tea",
			() -> new DrinkableItem(juiceItem().food(FoodValues.JUJUBE_MILK_TEA), true, false));
	//apricot
	public static final RegistryObject<Item> APRICOT = registerWithTab("apricot",
			() -> new Item(foodItem(FoodValues.APRICOT)));
	public static final RegistryObject<Item> APRICOT_SAPLING = registerWithTab("apricot_sapling",
			() -> new BlockItem(ModBlocks.APRICOT_SAPLING.get(), new Item.Properties()));
	public static final RegistryObject<Item> APRICOT_POPSICLE = registerWithTab("apricot_popsicle",
			() -> new PopsicleItem(foodItem(FoodValues.APRICOT_POPSICLE)));
	public static final RegistryObject<Item> APRICOT_CAKE = registerWithTab("apricot_cake",
			()-> new ItemNameBlockItem(ModBlocks.APRICOT_CAKE.get(),new Item.Properties()
					
			));
	public static final RegistryObject<Item> APRICOT_PIE = registerWithTab("apricot_pie",
			() -> new BlockItem(ModBlocks.APRICOT_PIE.get(), basicItem()));
	public static final RegistryObject<Item> APRICOT_PIE_SLICE = registerWithTab("apricot_pie_slice",
			() -> new Item(foodItem(FoodValues.APRICOT_PIE_SLICE)));
	public static final RegistryObject<Item> APRICOT_CAKE_SLICE = registerWithTab("apricot_cake_slice",
			() -> new Item(foodItem(FoodValues.APRICOT_CAKE_SLICE)));
	public static final RegistryObject<Item> APRICOT_CRATE = registerWithTab("apricot_crate",
			() -> new BlockItem(ModBlocks.APRICOT_CRATE.get(), basicItem()));
	public static final RegistryObject<Item> APRICOT_COOKIE = registerWithTab("apricot_cookie",
			() -> new Item(foodItem(FoodValues.APRICOT_COOKIE)));
	public static final RegistryObject<Item> APRICOT_JAM = registerWithTab("apricot_jam",
			() -> new BlockItem(ModBlocks.APRICOT_JAM.get(), basicItem()));
	public static final RegistryObject<Item> APRICOT_BREAD = registerWithTab("apricot_bread",
			() -> new Item(foodItem(FoodValues.APRICOT_BREAD)));
	public static final RegistryObject<Item> APRICOT_DOUGHNUT = registerWithTab("apricot_doughnut",
			() -> new Item(foodItem(FoodValues.APRICOT_DOUGHNUT)));
	public static final RegistryObject<Item> APRICOT_JUICE = registerWithTab("apricot_juice",
			() -> new DrinkableItem(juiceItem().food(FoodValues.APRICOT_JUICE), true, false));
	public static final RegistryObject<Item> APRICOT_SMOOTHIE = registerWithTab("apricot_smoothie",
			() -> new BlockItem(ModBlocks.APRICOT_SMOOTHIE.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> APRICOT_WINE_BARREL = registerWithTab("apricot_wine_barrel",
			() -> new BlockItem(ModBlocks.APRICOT_WINE_BARREL.get(), basicItem()));
	public static final RegistryObject<Item> APRICOT_WINE_ONE = registerWithTab("apricot_wine_one",
			() -> new DrinkableItem(wineItem().food(FoodValues.APRICOT_WINE_ONE), true, true));
	public static final RegistryObject<Item> APRICOT_WINE_TWO = registerWithTab("apricot_wine_two",
			() -> new DrinkableItem(wineItem().food(FoodValues.APRICOT_WINE_TWO), true, true));
	public static final RegistryObject<Item> APRICOT_WINE_THREE = registerWithTab("apricot_wine_three",
			() -> new DrinkableItem(wineItem().food(FoodValues.APRICOT_WINE_THREE), true, true));
	public static final RegistryObject<Item> APRICOT_WINE_FOUR = registerWithTab("apricot_wine_four",
			() -> new DrinkableItem(wineItem().food(FoodValues.APRICOT_WINE_FOUR), true, true));
	public static final RegistryObject<Item> APRICOT_WINE_FIVE = registerWithTab("apricot_wine_five",
			() -> new DrinkableItem(wineItem().food(FoodValues.APRICOT_WINE_FIVE), true, true));
	public static final RegistryObject<Item> APRICOT_WINE_SIX = registerWithTab("apricot_wine_six",
			() -> new DrinkableItem(wineItem().food(FoodValues.APRICOT_WINE_SIX), true, true));
	public static final RegistryObject<Item> APRICOT_WINE_SEVEN = registerWithTab("apricot_wine_seven",
			() -> new DrinkableItem(wineItem().food(FoodValues.APRICOT_WINE_SEVEN), true, true));
	public static final RegistryObject<Item> APRICOT_WINE_EIGHT = registerWithTab("apricot_wine_eight",
			() -> new DrinkableItem(wineItem().food(FoodValues.APRICOT_WINE_EIGHT), true, true));
	public static final RegistryObject<Item> APRICOT_WINE_NINE = registerWithTab("apricot_wine_nine",
			() -> new DrinkableItem(wineItem().food(FoodValues.APRICOT_WINE_NINE), true, true));
	public static final RegistryObject<Item> APRICOT_WINE_TEN = registerWithTab("apricot_wine_ten",
			() -> new DrinkableItem(wineItem().food(FoodValues.APRICOT_WINE_TEN), true, true));
	public static final RegistryObject<Item> BEST_APRICOT_WINE = registerWithTab("best_apricot_wine",
			() -> new BestWineItem(wineItem(), true, true));
	public static final RegistryObject<Item> APRICOT_POPSICLE_MACHINE = registerWithTab("apricot_popsicle_machine",
			() -> new BlockItem(ModBlocks.APRICOT_POPSICLE_MACHINE.get(), basicItem()));
	public static final RegistryObject<Item> APRICOT_MILK_TEA = registerWithTab("apricot_milk_tea",
			() -> new DrinkableItem(juiceItem().food(FoodValues.APRICOT_MILK_TEA), true, false));
	//red_bayberry
	public static final RegistryObject<Item> RED_BAYBERRY = registerWithTab("red_bayberry",
			() -> new Item(foodItem(FoodValues.RED_BAYBERRY)));
	public static final RegistryObject<Item> RED_BAYBERRY_SAPLING = registerWithTab("red_bayberry_sapling",
			() -> new BlockItem(ModBlocks.RED_BAYBERRY_SAPLING.get(), new Item.Properties()));
	public static final RegistryObject<Item> RED_BAYBERRY_POPSICLE = registerWithTab("red_bayberry_popsicle",
			() -> new PopsicleItem(foodItem(FoodValues.RED_BAYBERRY_POPSICLE)));
	public static final RegistryObject<Item> RED_BAYBERRY_CAKE = registerWithTab("red_bayberry_cake",
			()-> new ItemNameBlockItem(ModBlocks.RED_BAYBERRY_CAKE.get(),new Item.Properties()
					
			));
	public static final RegistryObject<Item> RED_BAYBERRY_PIE = registerWithTab("red_bayberry_pie",
			() -> new BlockItem(ModBlocks.RED_BAYBERRY_PIE.get(), basicItem()));
	public static final RegistryObject<Item> RED_BAYBERRY_PIE_SLICE = registerWithTab("red_bayberry_pie_slice",
			() -> new Item(foodItem(FoodValues.RED_BAYBERRY_PIE_SLICE)));
	public static final RegistryObject<Item> RED_BAYBERRY_CAKE_SLICE = registerWithTab("red_bayberry_cake_slice",
			() -> new Item(foodItem(FoodValues.RED_BAYBERRY_CAKE_SLICE)));
	public static final RegistryObject<Item> RED_BAYBERRY_CRATE = registerWithTab("red_bayberry_crate",
			() -> new BlockItem(ModBlocks.RED_BAYBERRY_CRATE.get(), basicItem()));
	public static final RegistryObject<Item> RED_BAYBERRY_COOKIE = registerWithTab("red_bayberry_cookie",
			() -> new Item(foodItem(FoodValues.RED_BAYBERRY_COOKIE)));
	public static final RegistryObject<Item> SOUR_PLUM_CHICKEN_BLOCK = registerWithTab("sour_plum_chicken_block",
			() -> new BlockItem(ModBlocks.SOUR_PLUM_CHICKEN_BLOCK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> SOUR_PLUM_CHICKEN = registerWithTab("sour_plum_chicken",
			() -> new ConsumableItem(bowlFoodItem(FoodValues.SOUR_PLUM_CHICKEN), true));
	public static final RegistryObject<Item> RED_BAYBERRY_JAM = registerWithTab("red_bayberry_jam",
			() -> new BlockItem(ModBlocks.RED_BAYBERRY_JAM.get(), basicItem()));
	public static final RegistryObject<Item> RED_BAYBERRY_BREAD = registerWithTab("red_bayberry_bread",
			() -> new Item(foodItem(FoodValues.RED_BAYBERRY_BREAD)));
	public static final RegistryObject<Item> RED_BAYBERRY_DOUGHNUT = registerWithTab("red_bayberry_doughnut",
			() -> new Item(foodItem(FoodValues.RED_BAYBERRY_DOUGHNUT)));
	public static final RegistryObject<Item> RED_BAYBERRY_JUICE = registerWithTab("red_bayberry_juice",
			() -> new DrinkableItem(juiceItem().food(FoodValues.RED_BAYBERRY_JUICE), true, false));
	public static final RegistryObject<Item> RED_BAYBERRY_WINE_BARREL = registerWithTab("red_bayberry_wine_barrel",
			() -> new BlockItem(ModBlocks.RED_BAYBERRY_WINE_BARREL.get(), basicItem()));
	public static final RegistryObject<Item> RED_BAYBERRY_WINE_ONE = registerWithTab("red_bayberry_wine_one",
			() -> new DrinkableItem(wineItem().food(FoodValues.RED_BAYBERRY_WINE_ONE), true, true));
	public static final RegistryObject<Item> RED_BAYBERRY_WINE_TWO = registerWithTab("red_bayberry_wine_two",
			() -> new DrinkableItem(wineItem().food(FoodValues.RED_BAYBERRY_WINE_TWO), true, true));
	public static final RegistryObject<Item> RED_BAYBERRY_WINE_THREE = registerWithTab("red_bayberry_wine_three",
			() -> new DrinkableItem(wineItem().food(FoodValues.RED_BAYBERRY_WINE_THREE), true, true));
	public static final RegistryObject<Item> RED_BAYBERRY_WINE_FOUR = registerWithTab("red_bayberry_wine_four",
			() -> new DrinkableItem(wineItem().food(FoodValues.RED_BAYBERRY_WINE_FOUR), true, true));
	public static final RegistryObject<Item> RED_BAYBERRY_WINE_FIVE = registerWithTab("red_bayberry_wine_five",
			() -> new DrinkableItem(wineItem().food(FoodValues.RED_BAYBERRY_WINE_FIVE), true, true));
	public static final RegistryObject<Item> RED_BAYBERRY_WINE_SIX = registerWithTab("red_bayberry_wine_six",
			() -> new DrinkableItem(wineItem().food(FoodValues.RED_BAYBERRY_WINE_SIX), true, true));
	public static final RegistryObject<Item> RED_BAYBERRY_WINE_SEVEN = registerWithTab("red_bayberry_wine_seven",
			() -> new DrinkableItem(wineItem().food(FoodValues.RED_BAYBERRY_WINE_SEVEN), true, true));
	public static final RegistryObject<Item> RED_BAYBERRY_WINE_EIGHT = registerWithTab("red_bayberry_wine_eight",
			() -> new DrinkableItem(wineItem().food(FoodValues.RED_BAYBERRY_WINE_EIGHT), true, true));
	public static final RegistryObject<Item> RED_BAYBERRY_WINE_NINE = registerWithTab("red_bayberry_wine_nine",
			() -> new DrinkableItem(wineItem().food(FoodValues.RED_BAYBERRY_WINE_NINE), true, true));
	public static final RegistryObject<Item> RED_BAYBERRY_WINE_TEN = registerWithTab("red_bayberry_wine_ten",
			() -> new DrinkableItem(wineItem().food(FoodValues.RED_BAYBERRY_WINE_TEN), true, true));
	public static final RegistryObject<Item> BEST_RED_BAYBERRY_WINE = registerWithTab("best_red_bayberry_wine",
			() -> new BestWineItem(wineItem(), true, true));
	public static final RegistryObject<Item> RED_BAYBERRY_POPSICLE_MACHINE = registerWithTab("red_bayberry_popsicle_machine",
			() -> new BlockItem(ModBlocks.RED_BAYBERRY_POPSICLE_MACHINE.get(), basicItem()));
	public static final RegistryObject<Item> RED_BAYBERRY_MILK_TEA = registerWithTab("red_bayberry_milk_tea",
			() -> new DrinkableItem(juiceItem().food(FoodValues.RED_BAYBERRY_MILK_TEA), true, false));
	//green plum
	public static final RegistryObject<Item> GREEN_PLUM = registerWithTab("green_plum",
			() -> new Item(foodItem(FoodValues.GREEN_PLUM)));
	public static final RegistryObject<Item> GREEN_PLUM_SAPLING = registerWithTab("green_plum_sapling",
			() -> new BlockItem(ModBlocks.GREEN_PLUM_SAPLING.get(), new Item.Properties()));
	public static final RegistryObject<Item> GREEN_PLUM_POPSICLE = registerWithTab("green_plum_popsicle",
			() -> new PopsicleItem(foodItem(FoodValues.GREEN_PLUM_POPSICLE)));
	public static final RegistryObject<Item> GREEN_PLUM_CAKE = registerWithTab("green_plum_cake",
			()-> new ItemNameBlockItem(ModBlocks.GREEN_PLUM_CAKE.get(),new Item.Properties()
					
			));
	public static final RegistryObject<Item> GREEN_PLUM_PIE = registerWithTab("green_plum_pie",
			() -> new BlockItem(ModBlocks.GREEN_PLUM_PIE.get(), basicItem()));
	public static final RegistryObject<Item> GREEN_PLUM_PIE_SLICE = registerWithTab("green_plum_pie_slice",
			() -> new Item(foodItem(FoodValues.GREEN_PLUM_PIE_SLICE)));
	public static final RegistryObject<Item> GREEN_PLUM_CAKE_SLICE = registerWithTab("green_plum_cake_slice",
			() -> new Item(foodItem(FoodValues.GREEN_PLUM_CAKE_SLICE)));
	public static final RegistryObject<Item> GREEN_PLUM_CRATE = registerWithTab("green_plum_crate",
			() -> new BlockItem(ModBlocks.GREEN_PLUM_CRATE.get(), basicItem()));
	public static final RegistryObject<Item> GREEN_PLUM_COOKIE = registerWithTab("green_plum_cookie",
			() -> new Item(foodItem(FoodValues.GREEN_PLUM_COOKIE)));
	public static final RegistryObject<Item> GREEN_PLUM_JAM = registerWithTab("green_plum_jam",
			() -> new BlockItem(ModBlocks.GREEN_PLUM_JAM.get(), basicItem()));
	public static final RegistryObject<Item> GREEN_PLUM_BREAD = registerWithTab("green_plum_bread",
			() -> new Item(foodItem(FoodValues.GREEN_PLUM_BREAD)));
	public static final RegistryObject<Item> GREEN_PLUM_DOUGHNUT = registerWithTab("green_plum_doughnut",
			() -> new Item(foodItem(FoodValues.GREEN_PLUM_DOUGHNUT)));
	public static final RegistryObject<Item> GREEN_PLUM_JUICE = registerWithTab("green_plum_juice",
			() -> new DrinkableItem(juiceItem().food(FoodValues.GREEN_PLUM_JUICE), true, false));
	public static final RegistryObject<Item> GREEN_PLUM_WINE_BARREL = registerWithTab("green_plum_wine_barrel",
			() -> new BlockItem(ModBlocks.GREEN_PLUM_WINE_BARREL.get(), basicItem()));
	public static final RegistryObject<Item> GREEN_PLUM_WINE_ONE = registerWithTab("green_plum_wine_one",
			() -> new DrinkableItem(wineItem().food(FoodValues.GREEN_PLUM_WINE_ONE), true, true));
	public static final RegistryObject<Item> GREEN_PLUM_WINE_TWO = registerWithTab("green_plum_wine_two",
			() -> new DrinkableItem(wineItem().food(FoodValues.GREEN_PLUM_WINE_TWO), true, true));
	public static final RegistryObject<Item> GREEN_PLUM_WINE_THREE = registerWithTab("green_plum_wine_three",
			() -> new DrinkableItem(wineItem().food(FoodValues.GREEN_PLUM_WINE_THREE), true, true));
	public static final RegistryObject<Item> GREEN_PLUM_WINE_FOUR = registerWithTab("green_plum_wine_four",
			() -> new DrinkableItem(wineItem().food(FoodValues.GREEN_PLUM_WINE_FOUR), true, true));
	public static final RegistryObject<Item> GREEN_PLUM_WINE_FIVE = registerWithTab("green_plum_wine_five",
			() -> new DrinkableItem(wineItem().food(FoodValues.GREEN_PLUM_WINE_FIVE), true, true));
	public static final RegistryObject<Item> GREEN_PLUM_WINE_SIX = registerWithTab("green_plum_wine_six",
			() -> new DrinkableItem(wineItem().food(FoodValues.GREEN_PLUM_WINE_SIX), true, true));
	public static final RegistryObject<Item> GREEN_PLUM_WINE_SEVEN = registerWithTab("green_plum_wine_seven",
			() -> new DrinkableItem(wineItem().food(FoodValues.GREEN_PLUM_WINE_SEVEN), true, true));
	public static final RegistryObject<Item> GREEN_PLUM_WINE_EIGHT = registerWithTab("green_plum_wine_eight",
			() -> new DrinkableItem(wineItem().food(FoodValues.GREEN_PLUM_WINE_EIGHT), true, true));
	public static final RegistryObject<Item> GREEN_PLUM_WINE_NINE = registerWithTab("green_plum_wine_nine",
			() -> new DrinkableItem(wineItem().food(FoodValues.GREEN_PLUM_WINE_NINE), true, true));
	public static final RegistryObject<Item> GREEN_PLUM_WINE_TEN = registerWithTab("green_plum_wine_ten",
			() -> new DrinkableItem(wineItem().food(FoodValues.GREEN_PLUM_WINE_TEN), true, true));
	public static final RegistryObject<Item> BEST_GREEN_PLUM_WINE = registerWithTab("best_green_plum_wine",
			() -> new BestWineItem(wineItem(), true, true));
	public static final RegistryObject<Item> GREEN_PLUM_POPSICLE_MACHINE = registerWithTab("green_plum_popsicle_machine",
			() -> new BlockItem(ModBlocks.GREEN_PLUM_POPSICLE_MACHINE.get(), basicItem()));
	public static final RegistryObject<Item> GREEN_PLUM_MILK_TEA = registerWithTab("green_plum_milk_tea",
			() -> new DrinkableItem(juiceItem().food(FoodValues.GREEN_PLUM_MILK_TEA), true, false));
	//grape
	public static final RegistryObject<Item> GRAPE_CROP_BOTTOM = registerWithTab("grape_crop_bottom",
			() -> new BlockItem(ModBlocks.GRAPE_CROP_BOTTOM.get(), basicItem()));
	public static final RegistryObject<Item> GRAPE_CROP_MIDDLE = registerWithTab("grape_crop_middle",
			() -> new BlockItem(ModBlocks.GRAPE_CROP_MIDDLE.get(), basicItem()));
	public static final RegistryObject<Item> GRAPE_CROP_TOP = registerWithTab("grape_crop_top",
			() -> new BlockItem(ModBlocks.GRAPE_CROP_TOP.get(), basicItem()));
	public static final RegistryObject<Item> GRAPE_CROP = registerWithTab("grape_crop",
			() -> new BlockItem(ModBlocks.GRAPE_CROP.get(), basicItem()));
	public static final RegistryObject<Item> GRAPE_BRACKET_TOP = registerWithTab("grape_bracket_top",
			() -> new BlockItem(ModBlocks.GRAPE_BRACKET_TOP.get(), basicItem()));
	public static final RegistryObject<Item> GRAPE_BRACKET = registerWithTab("grape_bracket",
			() -> new BlockItem(ModBlocks.GRAPE_BRACKET.get(), basicItem()));
	public static final RegistryObject<Item> WILD_GRAPE = registerWithTab("wild_grape",
			() -> new BlockItem(ModBlocks.WILD_GRAPE.get(), basicItem()));
	public static final RegistryObject<Item> GRAPE = registerWithTab("grape",
			() -> new Item(foodItem(FoodValues.GRAPE)));
	public static final RegistryObject<Item> CRUSHED_GRAPES = registerWithTab("crushed_grapes",
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> GRAPE_POPSICLE = registerWithTab("grape_popsicle",
			() -> new PopsicleItem(foodItem(FoodValues.GRAPE_POPSICLE)));
	public static final RegistryObject<Item> GRAPE_CAKE = registerWithTab("grape_cake",
			()-> new ItemNameBlockItem(ModBlocks.GRAPE_CAKE.get(),new Item.Properties()
					
			));
	public static final RegistryObject<Item> GRAPE_PIE = registerWithTab("grape_pie",
			() -> new BlockItem(ModBlocks.GRAPE_PIE.get(), basicItem()));
	public static final RegistryObject<Item> GRAPE_PIE_SLICE = registerWithTab("grape_pie_slice",
			() -> new Item(foodItem(FoodValues.GRAPE_PIE_SLICE)));
	public static final RegistryObject<Item> GRAPE_CAKE_SLICE = registerWithTab("grape_cake_slice",
			() -> new Item(foodItem(FoodValues.GRAPE_CAKE_SLICE)));
	public static final RegistryObject<Item> GRAPE_CRATE = registerWithTab("grape_crate",
			() -> new BlockItem(ModBlocks.GRAPE_CRATE.get(), basicItem()));
	public static final RegistryObject<Item> GRAPE_COOKIE = registerWithTab("grape_cookie",
			() -> new Item(foodItem(FoodValues.GRAPE_COOKIE)));
	public static final RegistryObject<Item> GRAPE_JAM = registerWithTab("grape_jam",
			() -> new BlockItem(ModBlocks.GRAPE_JAM.get(), basicItem()));
	public static final RegistryObject<Item> GRAPE_BREAD = registerWithTab("grape_bread",
			() -> new Item(foodItem(FoodValues.GRAPE_BREAD)));
	public static final RegistryObject<Item> GRAPE_DOUGHNUT = registerWithTab("grape_doughnut",
			() -> new Item(foodItem(FoodValues.GRAPE_DOUGHNUT)));
	public static final RegistryObject<Item> GRAPE_JUICE = registerWithTab("grape_juice",
			() -> new DrinkableItem(juiceItem().food(FoodValues.GRAPE_JUICE), true, false));
	public static final RegistryObject<Item> SWEETENED_GRAPE = registerWithTab("sweetened_grape",
			() -> new BlockItem(ModBlocks.SWEETENED_GRAPE.get(), basicItem()));
	public static final RegistryObject<Item> DRIED_GRAPE = registerWithTab("dried_grape",
			() -> new Item(foodItem(FoodValues.DRIED_GRAPE)));
	public static final RegistryObject<Item> GRAPE_JELLY = registerWithTab("grape_jelly",
			()-> new ItemNameBlockItem(ModBlocks.GRAPE_JELLY.get(),new Item.Properties()
					
			));
	public static final RegistryObject<Item> GRAPE_JELLY_SLICE = registerWithTab("grape_jelly_slice",
			() -> new Item(foodItem(FoodValues.GRAPE_JELLY_SLICE)));
	public static final RegistryObject<Item> GRAPE_WINE_BARREL = registerWithTab("grape_wine_barrel",
			() -> new BlockItem(ModBlocks.GRAPE_WINE_BARREL.get(), basicItem()));
	public static final RegistryObject<Item> GRAPE_WINE_ONE = registerWithTab("grape_wine_one",
			() -> new DrinkableItem(wineItem().food(FoodValues.GRAPE_WINE_ONE), true, true));
	public static final RegistryObject<Item> GRAPE_WINE_TWO = registerWithTab("grape_wine_two",
			() -> new DrinkableItem(wineItem().food(FoodValues.GRAPE_WINE_TWO), true, true));
	public static final RegistryObject<Item> GRAPE_WINE_THREE = registerWithTab("grape_wine_three",
			() -> new DrinkableItem(wineItem().food(FoodValues.GRAPE_WINE_THREE), true, true));
	public static final RegistryObject<Item> GRAPE_WINE_FOUR = registerWithTab("grape_wine_four",
			() -> new DrinkableItem(wineItem().food(FoodValues.GRAPE_WINE_FOUR), true, true));
	public static final RegistryObject<Item> GRAPE_WINE_FIVE = registerWithTab("grape_wine_five",
			() -> new DrinkableItem(wineItem().food(FoodValues.GRAPE_WINE_FIVE), true, true));
	public static final RegistryObject<Item> GRAPE_WINE_SIX = registerWithTab("grape_wine_six",
			() -> new DrinkableItem(wineItem().food(FoodValues.GRAPE_WINE_SIX), true, true));
	public static final RegistryObject<Item> GRAPE_WINE_SEVEN = registerWithTab("grape_wine_seven",
			() -> new DrinkableItem(wineItem().food(FoodValues.GRAPE_WINE_SEVEN), true, true));
	public static final RegistryObject<Item> GRAPE_WINE_EIGHT = registerWithTab("grape_wine_eight",
			() -> new DrinkableItem(wineItem().food(FoodValues.GRAPE_WINE_EIGHT), true, true));
	public static final RegistryObject<Item> GRAPE_WINE_NINE = registerWithTab("grape_wine_nine",
			() -> new DrinkableItem(wineItem().food(FoodValues.GRAPE_WINE_NINE), true, true));
	public static final RegistryObject<Item> GRAPE_WINE_TEN = registerWithTab("grape_wine_ten",
			() -> new DrinkableItem(wineItem().food(FoodValues.GRAPE_WINE_TEN), true, true));
	public static final RegistryObject<Item> BEST_GRAPE_WINE = registerWithTab("best_grape_wine",
			() -> new BestWineItem(wineItem(), true, true));
	public static final RegistryObject<Item> GRAPE_POPSICLE_MACHINE = registerWithTab("grape_popsicle_machine",
			() -> new BlockItem(ModBlocks.GRAPE_POPSICLE_MACHINE.get(), basicItem()));
	public static final RegistryObject<Item> GRAPE_MILK_TEA = registerWithTab("grape_milk_tea",
			() -> new DrinkableItem(juiceItem().food(FoodValues.GRAPE_MILK_TEA), true, false));
	//peach
	public static final RegistryObject<Item> PEACH_BLOCK = registerWithTab("peach_block",
			() -> new BlockItem(ModBlocks.PEACH_BLOCK.get(), basicItem().stacksTo(64)));
	public static final RegistryObject<Item> PEACH_SLICE = registerWithTab("peach_slice",
			() -> new Item(foodItem(FoodValues.PEACH_SLICE)));
	public static final RegistryObject<Item> PEACH_SAPLING = registerWithTab("peach_sapling",
			() -> new BlockItem(ModBlocks.PEACH_SAPLING.get(), new Item.Properties()));
	public static final RegistryObject<Item> PEACH_POPSICLE = registerWithTab("peach_popsicle",
			() -> new PopsicleItem(foodItem(FoodValues.PEACH_POPSICLE)));
	public static final RegistryObject<Item> PEACH_CAKE = registerWithTab("peach_cake",
			()-> new ItemNameBlockItem(ModBlocks.PEACH_CAKE.get(),new Item.Properties()
			));
	public static final RegistryObject<Item> PEACH_PIE = registerWithTab("peach_pie",
			() -> new BlockItem(ModBlocks.PEACH_PIE.get(), basicItem()));
	public static final RegistryObject<Item> PEACH_PIE_SLICE = registerWithTab("peach_pie_slice",
			() -> new Item(foodItem(FoodValues.PEACH_PIE_SLICE)));
	public static final RegistryObject<Item> PEACH_CAKE_SLICE = registerWithTab("peach_cake_slice",
			() -> new Item(foodItem(FoodValues.PEACH_CAKE_SLICE)));
	public static final RegistryObject<Item> PEACH_CRATE = registerWithTab("peach_crate",
			() -> new BlockItem(ModBlocks.PEACH_CRATE.get(), basicItem()));
	public static final RegistryObject<Item> PEACH_COOKIE = registerWithTab("peach_cookie",
			() -> new Item(foodItem(FoodValues.PEACH_COOKIE)));
	public static final RegistryObject<Item> PEACH_JAM = registerWithTab("peach_jam",
			() -> new BlockItem(ModBlocks.PEACH_JAM.get(), basicItem()));
	public static final RegistryObject<Item> PEACH_BREAD = registerWithTab("peach_bread",
			() -> new Item(foodItem(FoodValues.PEACH_BREAD)));
	public static final RegistryObject<Item> PEACH_DOUGHNUT = registerWithTab("peach_doughnut",
			() -> new Item(foodItem(FoodValues.PEACH_DOUGHNUT)));
	public static final RegistryObject<Item> PEACH_JUICE = registerWithTab("peach_juice",
			() -> new DrinkableItem(juiceItem().food(FoodValues.PEACH_JUICE), true, false));
	public static final RegistryObject<Item> PEACH_WINE_BARREL = registerWithTab("peach_wine_barrel",
			() -> new BlockItem(ModBlocks.PEACH_WINE_BARREL.get(), basicItem()));
	public static final RegistryObject<Item> PEACH_WINE_ONE = registerWithTab("peach_wine_one",
			() -> new DrinkableItem(wineItem().food(FoodValues.PEACH_WINE_ONE), true, true));
	public static final RegistryObject<Item> PEACH_WINE_TWO = registerWithTab("peach_wine_two",
			() -> new DrinkableItem(wineItem().food(FoodValues.PEACH_WINE_TWO), true, true));
	public static final RegistryObject<Item> PEACH_WINE_THREE = registerWithTab("peach_wine_three",
			() -> new DrinkableItem(wineItem().food(FoodValues.PEACH_WINE_THREE), true, true));
	public static final RegistryObject<Item> PEACH_WINE_FOUR = registerWithTab("peach_wine_four",
			() -> new DrinkableItem(wineItem().food(FoodValues.PEACH_WINE_FOUR), true, true));
	public static final RegistryObject<Item> PEACH_WINE_FIVE = registerWithTab("peach_wine_five",
			() -> new DrinkableItem(wineItem().food(FoodValues.PEACH_WINE_FIVE), true, true));
	public static final RegistryObject<Item> PEACH_WINE_SIX = registerWithTab("peach_wine_six",
			() -> new DrinkableItem(wineItem().food(FoodValues.PEACH_WINE_SIX), true, true));
	public static final RegistryObject<Item> PEACH_WINE_SEVEN = registerWithTab("peach_wine_seven",
			() -> new DrinkableItem(wineItem().food(FoodValues.PEACH_WINE_SEVEN), true, true));
	public static final RegistryObject<Item> PEACH_WINE_EIGHT = registerWithTab("peach_wine_eight",
			() -> new DrinkableItem(wineItem().food(FoodValues.PEACH_WINE_EIGHT), true, true));
	public static final RegistryObject<Item> PEACH_WINE_NINE = registerWithTab("peach_wine_nine",
			() -> new DrinkableItem(wineItem().food(FoodValues.PEACH_WINE_NINE), true, true));
	public static final RegistryObject<Item> PEACH_WINE_TEN = registerWithTab("peach_wine_ten",
			() -> new DrinkableItem(wineItem().food(FoodValues.PEACH_WINE_TEN), true, true));
	public static final RegistryObject<Item> BEST_PEACH_WINE = registerWithTab("best_peach_wine",
			() -> new BestWineItem(wineItem(), true, true));
	public static final RegistryObject<Item> PEACH_POPSICLE_MACHINE = registerWithTab("peach_popsicle_machine",
			() -> new BlockItem(ModBlocks.PEACH_POPSICLE_MACHINE.get(), basicItem()));
	public static final RegistryObject<Item> PEACH_MILK_TEA = registerWithTab("peach_milk_tea",
			() -> new DrinkableItem(juiceItem().food(FoodValues.PEACH_MILK_TEA), true, false));
	public static final RegistryObject<Item> SWEETENED_PEACH = registerWithTab("sweetened_peach",
			() -> new BlockItem(ModBlocks.SWEETENED_PEACH.get(), basicItem()));
	public static final RegistryObject<Item> DRIED_PEACH = registerWithTab("dried_peach",
			() -> new Item(foodItem(FoodValues.DRIED_PEACH)));
	public static final RegistryObject<Item> LACTOBACILLUS_HONEY_PEACH_ICE = registerWithTab("lactobacillus_honey_peach_ice",
			() -> new BlockItem(ModBlocks.LACTOBACILLUS_HONEY_PEACH_ICE.get(), basicItem().stacksTo(1)));
	//zongzi
	public static final RegistryObject<Item> WILD_GLUTINOUS_RICE = registerWithTab("wild_glutinous_rice",
			() -> new BlockItem(ModBlocks.WILD_GLUTINOUS_RICE.get(), basicItem()));
	public static final RegistryObject<Item> GLUTINOUS_RICE_BAG = ITEMS.register("glutinous_rice_bag",
			() -> new BlockItem(ModBlocks.GLUTINOUS_RICE_BAG.get(), basicItem()));
	public static final RegistryObject<Item> GLUTINOUS_RICE_BALE = ITEMS.register("glutinous_rice_bale",
			() -> new BlockItem(ModBlocks.GLUTINOUS_RICE_BALE.get(), basicItem()));
	public static final RegistryObject<Item> ZONG_ZI_LEAVES = registerWithTab("zong_zi_leaves",
			()-> new ItemNameBlockItem(ModBlocks.ZONG_ZI_LEAVES_CROP.get(),new Item.Properties()
					
			));
	public static final RegistryObject<Item> WILD_ZONG_ZI_LEAVES = registerWithTab("wild_zong_zi_leaves",
			() -> new BlockItem(ModBlocks.WILD_ZONG_ZI_LEAVES.get(), basicItem()));
	public static final RegistryObject<Item> GLUTINOUS_RICE = registerWithTab("glutinous_rice",
			() -> new GlutinousRiceItem(ModBlocks.GLUTINOUS_RICE_CROP.get(), basicItem()));
	public static final RegistryObject<Item> GLUTINOUS_RICE_PANICLE = registerWithTab("glutinous_rice_panicle",
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> ZONG_ZI = registerWithTab("zong_zi",
			() -> new BlockItem(ModBlocks.ZONG_ZI.get(), basicItem()));
	public static final RegistryObject<Item> RAW_ZONG_ZI = registerWithTab("raw_zong_zi",
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> BLUEBERRIES_AND_MANGO_ZONG_ZI = registerWithTab("blueberries_and_mango_zong_zi",
			() -> new BlockItem(ModBlocks.BLUEBERRIES_AND_MANGO_ZONG_ZI.get(), basicItem()));
	public static final RegistryObject<Item> RAW_BLUEBERRIES_AND_MANGO_ZONG_ZI = registerWithTab("raw_blueberries_and_mango_zong_zi",
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> AGREEABLE_SWEETNESS_ZONG_ZI = registerWithTab("agreeable_sweetness_zong_zi",
			() -> new BlockItem(ModBlocks.AGREEABLE_SWEETNESS_ZONG_ZI.get(), basicItem()));
	public static final RegistryObject<Item> RAW_AGREEABLE_SWEETNESS_ZONG_ZI = registerWithTab("raw_agreeable_sweetness_zong_zi",
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> MELON_ZONG_ZI = registerWithTab("melon_zong_zi",
			() -> new BlockItem(ModBlocks.MELON_ZONG_ZI.get(), basicItem()));
	public static final RegistryObject<Item> RAW_MELON_ZONG_ZI = registerWithTab("raw_melon_zong_zi",
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> CRIMSON_ZONG_ZI = registerWithTab("crimson_zong_zi",
			() -> new BlockItem(ModBlocks.CRIMSON_ZONG_ZI.get(), basicItem()));
	public static final RegistryObject<Item> RAW_CRIMSON_ZONG_ZI = registerWithTab("raw_crimson_zong_zi",
			() -> new Item(new Item.Properties()));
	//moon cake
	public static final RegistryObject<Item> BLUEBERRIES_MOON_CAKE = registerWithTab("blueberries_moon_cake",
			() -> new BlockItem(ModBlocks.BLUEBERRIES_MOON_CAKE.get(), basicItem()));
	public static final RegistryObject<Item> RAW_BLUEBERRIES_MOON_CAKE = registerWithTab("raw_blueberries_moon_cake",
			() -> new RawMoonCakeItem(new Item.Properties()));
	public static final RegistryObject<Item> BLUEBERRIES_FILLING = registerWithTab("blueberries_filling",
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> HAMIMELON_MOON_CAKE = registerWithTab("hamimelon_moon_cake",
			() -> new BlockItem(ModBlocks.HAMIMELON_MOON_CAKE.get(), basicItem()));
	public static final RegistryObject<Item> RAW_HAMIMELON_MOON_CAKE = registerWithTab("raw_hamimelon_moon_cake",
			() -> new RawMoonCakeItem(new Item.Properties()));
	public static final RegistryObject<Item> HAMIMELON_FILLING = registerWithTab("hamimelon_filling",
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> BEATING_MELONS_MOON_CAKE = registerWithTab("beating_melons_moon_cake",
			() -> new BlockItem(ModBlocks.BEATING_MELONS_MOON_CAKE.get(), basicItem()));
	public static final RegistryObject<Item> RAW_BEATING_MELONS_MOON_CAKE = registerWithTab("raw_beating_melons_moon_cake",
			() -> new RawMoonCakeItem(new Item.Properties()));
	public static final RegistryObject<Item> BEATING_MELONS_FILLING = registerWithTab("beating_melons_filling",
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> GROUND_CUCUMBER_MOON_CAKE = registerWithTab("ground_cucumber_moon_cake",
			() -> new BlockItem(ModBlocks.GROUND_CUCUMBER_MOON_CAKE.get(), basicItem()));
	public static final RegistryObject<Item> RAW_GROUND_CUCUMBER_MOON_CAKE = registerWithTab("raw_ground_cucumber_moon_cake",
			() -> new RawMoonCakeItem(new Item.Properties()));
	public static final RegistryObject<Item> GROUND_CUCUMBER_FILLING = registerWithTab("ground_cucumber_filling",
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> MANGO_MOON_CAKE = registerWithTab("mango_moon_cake",
			() -> new BlockItem(ModBlocks.MANGO_MOON_CAKE.get(), basicItem()));
	public static final RegistryObject<Item> RAW_MANGO_MOON_CAKE = registerWithTab("raw_mango_moon_cake",
			() -> new RawMoonCakeItem(new Item.Properties()));
	public static final RegistryObject<Item> MANGO_FILLING = registerWithTab("mango_filling",
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_MOON_CAKE = registerWithTab("holboellia_latifolia_moon_cake",
			() -> new BlockItem(ModBlocks.HOLBOELLIA_LATIFOLIA_MOON_CAKE.get(), basicItem()));
	public static final RegistryObject<Item> RAW_HOLBOELLIA_LATIFOLIA_MOON_CAKE = registerWithTab("raw_holboellia_latifolia_moon_cake",
			() -> new RawMoonCakeItem(new Item.Properties()));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_FILLING = registerWithTab("holboellia_latifolia_filling",
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> LITCHI_MOON_CAKE = registerWithTab("litchi_moon_cake",
			() -> new BlockItem(ModBlocks.LITCHI_MOON_CAKE.get(), basicItem()));
	public static final RegistryObject<Item> RAW_LITCHI_MOON_CAKE = registerWithTab("raw_litchi_moon_cake",
			() -> new RawMoonCakeItem(new Item.Properties()));
	public static final RegistryObject<Item> LITCHI_FILLING = registerWithTab("litchi_filling",
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_MOON_CAKE = registerWithTab("huoshen_fruit_moon_cake",
			() -> new BlockItem(ModBlocks.HUOSHEN_FRUIT_MOON_CAKE.get(), basicItem()));
	public static final RegistryObject<Item> RAW_HUOSHEN_FRUIT_MOON_CAKE = registerWithTab("raw_huoshen_fruit_moon_cake",
			() -> new RawMoonCakeItem(new Item.Properties()));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_FILLING = registerWithTab("huoshen_fruit_filling",
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> SEPTEMBER_MELON_MOON_CAKE = registerWithTab("september_melon_moon_cake",
			() -> new BlockItem(ModBlocks.SEPTEMBER_MELON_MOON_CAKE.get(), basicItem()));
	public static final RegistryObject<Item> RAW_SEPTEMBER_MELON_MOON_CAKE = registerWithTab("raw_september_melon_moon_cake",
			() -> new RawMoonCakeItem(new Item.Properties()));
	public static final RegistryObject<Item> SEPTEMBER_MELON_FILLING = registerWithTab("september_melon_filling",
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> PITAYA_MOON_CAKE = registerWithTab("pitaya_moon_cake",
			() -> new BlockItem(ModBlocks.PITAYA_MOON_CAKE.get(), basicItem()));
	public static final RegistryObject<Item> RAW_PITAYA_MOON_CAKE = registerWithTab("raw_pitaya_moon_cake",
			() -> new RawMoonCakeItem(new Item.Properties()));
	public static final RegistryObject<Item> PITAYA_FILLING = registerWithTab("pitaya_filling",
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_MOON_CAKE = registerWithTab("golden_pure_sheep_horn_honey_moon_cake",
			() -> new BlockItem(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_MOON_CAKE.get(), basicItem()));
	public static final RegistryObject<Item> RAW_GOLDEN_PURE_SHEEP_HORN_HONEY_MOON_CAKE = registerWithTab("raw_golden_pure_sheep_horn_honey_moon_cake",
			() -> new RawMoonCakeItem(new Item.Properties()));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_FILLING = registerWithTab("golden_pure_sheep_horn_honey_filling",
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> PEAR_MOON_CAKE = registerWithTab("pear_moon_cake",
			() -> new BlockItem(ModBlocks.PEAR_MOON_CAKE.get(), basicItem()));
	public static final RegistryObject<Item> RAW_PEAR_MOON_CAKE = registerWithTab("raw_pear_moon_cake",
			() -> new RawMoonCakeItem(new Item.Properties()));
	public static final RegistryObject<Item> PEAR_FILLING = registerWithTab("pear_filling",
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> MAYTHORN_MOON_CAKE = registerWithTab("maythorn_moon_cake",
			() -> new BlockItem(ModBlocks.MAYTHORN_MOON_CAKE.get(), basicItem()));
	public static final RegistryObject<Item> RAW_MAYTHORN_MOON_CAKE = registerWithTab("raw_maythorn_moon_cake",
			() -> new RawMoonCakeItem(new Item.Properties()));
	public static final RegistryObject<Item> MAYTHORN_FILLING = registerWithTab("maythorn_filling",
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_MOON_CAKE = registerWithTab("chinese_pear_leaved_moon_cake",
			() -> new BlockItem(ModBlocks.CHINESE_PEAR_LEAVED_MOON_CAKE.get(), basicItem()));
	public static final RegistryObject<Item> RAW_CHINESE_PEAR_LEAVED_MOON_CAKE = registerWithTab("raw_chinese_pear_leaved_moon_cake",
			() -> new RawMoonCakeItem(new Item.Properties()));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_FILLING = registerWithTab("chinese_pear_leaved_filling",
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> PLUM_MOON_CAKE = registerWithTab("plum_moon_cake",
			() -> new BlockItem(ModBlocks.PLUM_MOON_CAKE.get(), basicItem()));
	public static final RegistryObject<Item> RAW_PLUM_MOON_CAKE = registerWithTab("raw_plum_moon_cake",
			() -> new RawMoonCakeItem(new Item.Properties()));
	public static final RegistryObject<Item> PLUM_FILLING = registerWithTab("plum_filling",
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> JUJUBE_MOON_CAKE = registerWithTab("jujube_moon_cake",
			() -> new BlockItem(ModBlocks.JUJUBE_MOON_CAKE.get(), basicItem()));
	public static final RegistryObject<Item> RAW_JUJUBE_MOON_CAKE = registerWithTab("raw_jujube_moon_cake",
			() -> new RawMoonCakeItem(new Item.Properties()));
	public static final RegistryObject<Item> JUJUBE_FILLING = registerWithTab("jujube_filling",
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> APRICOT_MOON_CAKE = registerWithTab("apricot_moon_cake",
			() -> new BlockItem(ModBlocks.APRICOT_MOON_CAKE.get(), basicItem()));
	public static final RegistryObject<Item> RAW_APRICOT_MOON_CAKE = registerWithTab("raw_apricot_moon_cake",
			() -> new RawMoonCakeItem(new Item.Properties()));
	public static final RegistryObject<Item> APRICOT_FILLING = registerWithTab("apricot_filling",
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> RED_BAYBERRY_MOON_CAKE = registerWithTab("red_bayberry_moon_cake",
			() -> new BlockItem(ModBlocks.RED_BAYBERRY_MOON_CAKE.get(), basicItem()));
	public static final RegistryObject<Item> RAW_RED_BAYBERRY_MOON_CAKE = registerWithTab("raw_red_bayberry_moon_cake",
			() -> new RawMoonCakeItem(new Item.Properties()));
	public static final RegistryObject<Item> RED_BAYBERRY_FILLING = registerWithTab("red_bayberry_filling",
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> GREEN_PLUM_MOON_CAKE = registerWithTab("green_plum_moon_cake",
			() -> new BlockItem(ModBlocks.GREEN_PLUM_MOON_CAKE.get(), basicItem()));
	public static final RegistryObject<Item> RAW_GREEN_PLUM_MOON_CAKE = registerWithTab("raw_green_plum_moon_cake",
			() -> new RawMoonCakeItem(new Item.Properties()));
	public static final RegistryObject<Item> GREEN_PLUM_FILLING = registerWithTab("green_plum_filling",
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> GRAPE_MOON_CAKE = registerWithTab("grape_moon_cake",
			() -> new BlockItem(ModBlocks.GRAPE_MOON_CAKE.get(), basicItem()));
	public static final RegistryObject<Item> RAW_GRAPE_MOON_CAKE = registerWithTab("raw_grape_moon_cake",
			() -> new RawMoonCakeItem(new Item.Properties()));
	public static final RegistryObject<Item> GRAPE_FILLING = registerWithTab("grape_filling",
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> PEACH_MOON_CAKE = registerWithTab("peach_moon_cake",
			() -> new BlockItem(ModBlocks.PEACH_MOON_CAKE.get(), basicItem()));
	public static final RegistryObject<Item> RAW_PEACH_MOON_CAKE = registerWithTab("raw_peach_moon_cake",
			() -> new RawMoonCakeItem(new Item.Properties()));
	public static final RegistryObject<Item> PEACH_FILLING = registerWithTab("peach_filling",
			() -> new Item(new Item.Properties()));
	//rice dumpling
	public static final RegistryObject<Item> SPOON = registerWithTab("spoon",
			() -> new ConsumableItem(new Item.Properties()));
	public static final RegistryObject<Item> RICE_DUMPLING_POT = registerWithTab("rice_dumpling_pot",
			() -> new ConsumableItem(new Item.Properties()));
	public static final RegistryObject<Item> BLUEBERRIES_RICE_DUMPLING_BLOCK = registerWithTab("blueberries_rice_dumpling_block",
			() -> new BlockItem(ModBlocks.BLUEBERRIES_RICE_DUMPLING_BLOCK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> BLUEBERRIES_RICE_DUMPLING = registerWithTab("blueberries_rice_dumpling",
			() -> new ConsumableItem(foodItem(FoodValues.BLUEBERRIES_RICE_DUMPLING)));
	public static final RegistryObject<Item> HAMIMELON_RICE_DUMPLING_BLOCK = registerWithTab("hamimelon_rice_dumpling_block",
			() -> new BlockItem(ModBlocks.HAMIMELON_RICE_DUMPLING_BLOCK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> HAMIMELON_RICE_DUMPLING = registerWithTab("hamimelon_rice_dumpling",
			() -> new ConsumableItem(foodItem(FoodValues.HAMIMELON_RICE_DUMPLING)));
	public static final RegistryObject<Item> BEATING_MELONS_RICE_DUMPLING_BLOCK = registerWithTab("beating_melons_rice_dumpling_block",
			() -> new BlockItem(ModBlocks.BEATING_MELONS_RICE_DUMPLING_BLOCK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> BEATING_MELONS_RICE_DUMPLING = registerWithTab("beating_melons_rice_dumpling",
			() -> new ConsumableItem(foodItem(FoodValues.BEATING_MELONS_RICE_DUMPLING)));
	public static final RegistryObject<Item> GROUND_CUCUMBER_RICE_DUMPLING_BLOCK = registerWithTab("ground_cucumber_rice_dumpling_block",
			() -> new BlockItem(ModBlocks.GROUND_CUCUMBER_RICE_DUMPLING_BLOCK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> GROUND_CUCUMBER_RICE_DUMPLING = registerWithTab("ground_cucumber_rice_dumpling",
			() -> new ConsumableItem(foodItem(FoodValues.GROUND_CUCUMBER_RICE_DUMPLING)));
	public static final RegistryObject<Item> MANGO_RICE_DUMPLING_BLOCK = registerWithTab("mango_rice_dumpling_block",
			() -> new BlockItem(ModBlocks.MANGO_RICE_DUMPLING_BLOCK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> MANGO_RICE_DUMPLING = registerWithTab("mango_rice_dumpling",
			() -> new ConsumableItem(foodItem(FoodValues.MANGO_RICE_DUMPLING)));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_RICE_DUMPLING_BLOCK = registerWithTab("holboellia_latifolia_rice_dumpling_block",
			() -> new BlockItem(ModBlocks.HOLBOELLIA_LATIFOLIA_RICE_DUMPLING_BLOCK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_RICE_DUMPLING = registerWithTab("holboellia_latifolia_rice_dumpling",
			() -> new ConsumableItem(foodItem(FoodValues.HOLBOELLIA_LATIFOLIA_RICE_DUMPLING)));
	public static final RegistryObject<Item> LITCHI_RICE_DUMPLING_BLOCK = registerWithTab("litchi_rice_dumpling_block",
			() -> new BlockItem(ModBlocks.LITCHI_RICE_DUMPLING_BLOCK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> LITCHI_RICE_DUMPLING = registerWithTab("litchi_rice_dumpling",
			() -> new ConsumableItem(foodItem(FoodValues.LITCHI_RICE_DUMPLING)));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_RICE_DUMPLING_BLOCK = registerWithTab("huoshen_fruit_rice_dumpling_block",
			() -> new BlockItem(ModBlocks.HUOSHEN_FRUIT_RICE_DUMPLING_BLOCK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_RICE_DUMPLING = registerWithTab("huoshen_fruit_rice_dumpling",
			() -> new ConsumableItem(foodItem(FoodValues.HUOSHEN_FRUIT_RICE_DUMPLING)));
	public static final RegistryObject<Item> SEPTEMBER_MELON_RICE_DUMPLING_BLOCK = registerWithTab("september_melon_rice_dumpling_block",
			() -> new BlockItem(ModBlocks.SEPTEMBER_MELON_RICE_DUMPLING_BLOCK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> SEPTEMBER_MELON_RICE_DUMPLING = registerWithTab("september_melon_rice_dumpling",
			() -> new ConsumableItem(foodItem(FoodValues.SEPTEMBER_MELON_RICE_DUMPLING)));
	public static final RegistryObject<Item> PITAYA_RICE_DUMPLING_BLOCK = registerWithTab("pitaya_rice_dumpling_block",
			() -> new BlockItem(ModBlocks.PITAYA_RICE_DUMPLING_BLOCK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> PITAYA_RICE_DUMPLING = registerWithTab("pitaya_rice_dumpling",
			() -> new ConsumableItem(foodItem(FoodValues.PITAYA_RICE_DUMPLING)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_RICE_DUMPLING_BLOCK = registerWithTab("golden_pure_sheep_horn_honey_rice_dumpling_block",
			() -> new BlockItem(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_RICE_DUMPLING_BLOCK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_RICE_DUMPLING = registerWithTab("golden_pure_sheep_horn_honey_rice_dumpling",
			() -> new ConsumableItem(foodItem(FoodValues.GOLDEN_PURE_SHEEP_HORN_HONEY_RICE_DUMPLING)));
	public static final RegistryObject<Item> PEAR_RICE_DUMPLING_BLOCK = registerWithTab("pear_rice_dumpling_block",
			() -> new BlockItem(ModBlocks.PEAR_RICE_DUMPLING_BLOCK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> PEAR_RICE_DUMPLING = registerWithTab("pear_rice_dumpling",
			() -> new ConsumableItem(foodItem(FoodValues.PEAR_RICE_DUMPLING)));
	public static final RegistryObject<Item> MAYTHORN_RICE_DUMPLING_BLOCK = registerWithTab("maythorn_rice_dumpling_block",
			() -> new BlockItem(ModBlocks.MAYTHORN_RICE_DUMPLING_BLOCK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> MAYTHORN_RICE_DUMPLING = registerWithTab("maythorn_rice_dumpling",
			() -> new ConsumableItem(foodItem(FoodValues.MAYTHORN_RICE_DUMPLING)));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_RICE_DUMPLING_BLOCK = registerWithTab("chinese_pear_leaved_rice_dumpling_block",
			() -> new BlockItem(ModBlocks.CHINESE_PEAR_LEAVED_RICE_DUMPLING_BLOCK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_RICE_DUMPLING = registerWithTab("chinese_pear_leaved_rice_dumpling",
			() -> new ConsumableItem(foodItem(FoodValues.CHINESE_PEAR_LEAVED_RICE_DUMPLING)));
	public static final RegistryObject<Item> PLUM_RICE_DUMPLING_BLOCK = registerWithTab("plum_rice_dumpling_block",
			() -> new BlockItem(ModBlocks.PLUM_RICE_DUMPLING_BLOCK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> PLUM_RICE_DUMPLING = registerWithTab("plum_rice_dumpling",
			() -> new ConsumableItem(foodItem(FoodValues.PLUM_RICE_DUMPLING)));
	public static final RegistryObject<Item> JUJUBE_RICE_DUMPLING_BLOCK = registerWithTab("jujube_rice_dumpling_block",
			() -> new BlockItem(ModBlocks.JUJUBE_RICE_DUMPLING_BLOCK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> JUJUBE_RICE_DUMPLING = registerWithTab("jujube_rice_dumpling",
			() -> new ConsumableItem(foodItem(FoodValues.JUJUBE_RICE_DUMPLING)));
	public static final RegistryObject<Item> APRICOT_RICE_DUMPLING_BLOCK = registerWithTab("apricot_rice_dumpling_block",
			() -> new BlockItem(ModBlocks.APRICOT_RICE_DUMPLING_BLOCK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> APRICOT_RICE_DUMPLING = registerWithTab("apricot_rice_dumpling",
			() -> new ConsumableItem(foodItem(FoodValues.APRICOT_RICE_DUMPLING)));
	public static final RegistryObject<Item> RED_BAYBERRY_RICE_DUMPLING_BLOCK = registerWithTab("red_bayberry_rice_dumpling_block",
			() -> new BlockItem(ModBlocks.RED_BAYBERRY_RICE_DUMPLING_BLOCK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> RED_BAYBERRY_RICE_DUMPLING = registerWithTab("red_bayberry_rice_dumpling",
			() -> new ConsumableItem(foodItem(FoodValues.RED_BAYBERRY_RICE_DUMPLING)));
	public static final RegistryObject<Item> GREEN_PLUM_RICE_DUMPLING_BLOCK = registerWithTab("green_plum_rice_dumpling_block",
			() -> new BlockItem(ModBlocks.GREEN_PLUM_RICE_DUMPLING_BLOCK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> GREEN_PLUM_RICE_DUMPLING = registerWithTab("green_plum_rice_dumpling",
			() -> new ConsumableItem(foodItem(FoodValues.GREEN_PLUM_RICE_DUMPLING)));
	public static final RegistryObject<Item> GRAPE_RICE_DUMPLING_BLOCK = registerWithTab("grape_rice_dumpling_block",
			() -> new BlockItem(ModBlocks.GRAPE_RICE_DUMPLING_BLOCK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> GRAPE_RICE_DUMPLING = registerWithTab("grape_rice_dumpling",
			() -> new ConsumableItem(foodItem(FoodValues.GRAPE_RICE_DUMPLING)));
	public static final RegistryObject<Item> PEACH_RICE_DUMPLING_BLOCK = registerWithTab("peach_rice_dumpling_block",
			() -> new BlockItem(ModBlocks.PEACH_RICE_DUMPLING_BLOCK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> PEACH_RICE_DUMPLING = registerWithTab("peach_rice_dumpling",
			() -> new ConsumableItem(foodItem(FoodValues.PEACH_RICE_DUMPLING)));
	//pizza
	public static final RegistryObject<Item> ROLLING_PIN = registerWithTab("rolling_pin",
			() -> new Item(new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PIZZA_DOUGH = registerWithTab("pizza_dough",
			() -> new BlockItem(ModBlocks.PIZZA_DOUGH.get(), basicItem()));
	public static final RegistryObject<Item> UNBAKED_GRAPE_FRUIT_SAND_PIZZA = registerWithTab("unbaked_grape_fruit_sand_pizza",
			() -> new Item(new Item.Properties().stacksTo(16)));
	public static final RegistryObject<Item> UNBAKED_BLUE_RED_MANGO_PIZZA = registerWithTab("unbaked_blue_red_mango_pizza",
			() -> new Item(new Item.Properties().stacksTo(16)));
	public static final RegistryObject<Item> UNBAKED_HAWTHORN_NUT_PIZZA = registerWithTab("unbaked_hawthorn_nut_pizza",
			() -> new Item(new Item.Properties().stacksTo(16)));
	public static final RegistryObject<Item> UNBAKED_SWEET_AND_REFRESHING_FLAVORED_PIZZA = registerWithTab("unbaked_sweet_and_refreshing_flavored_pizza",
			() -> new Item(new Item.Properties().stacksTo(16)));
	public static final RegistryObject<Item> GRAPE_FRUIT_SAND_PIZZA = registerWithTab("grape_fruit_sand_pizza",
			() -> new BlockItem(ModBlocks.GRAPE_FRUIT_SAND_PIZZA.get(), basicItem()));
	public static final RegistryObject<Item> GRAPE_FRUIT_SAND_PIZZA_SLICE = registerWithTab("grape_fruit_sand_pizza_slice",
			() -> new Item(foodItem(FoodValues.GRAPE_FRUIT_SAND_PIZZA_SLICE)));
	public static final RegistryObject<Item> BLUE_RED_MANGO_PIZZA = registerWithTab("blue_red_mango_pizza",
			() -> new BlockItem(ModBlocks.BLUE_RED_MANGO_PIZZA.get(), basicItem()));
	public static final RegistryObject<Item> BLUE_RED_MANGO_PIZZA_SLICE = registerWithTab("blue_red_mango_pizza_slice",
			() -> new Item(foodItem(FoodValues.BLUE_RED_MANGO_PIZZA_SLICE)));
	public static final RegistryObject<Item> HAWTHORN_NUT_PIZZA = registerWithTab("hawthorn_nut_pizza",
			() -> new BlockItem(ModBlocks.HAWTHORN_NUT_PIZZA.get(), basicItem()));
	public static final RegistryObject<Item> HAWTHORN_NUT_PIZZA_SLICE = registerWithTab("hawthorn_nut_pizza_slice",
			() -> new Item(foodItem(FoodValues.HAWTHORN_NUT_PIZZA_SLICE)));
	public static final RegistryObject<Item> SWEET_AND_REFRESHING_FLAVORED_PIZZA = registerWithTab("sweet_and_refreshing_flavored_pizza",
			() -> new BlockItem(ModBlocks.SWEET_AND_REFRESHING_FLAVORED_PIZZA.get(), basicItem()));
	public static final RegistryObject<Item> SWEET_AND_REFRESHING_FLAVORED_PIZZA_SLICE = registerWithTab("sweet_and_refreshing_flavored_pizza_slice",
			() -> new Item(foodItem(FoodValues.SWEET_AND_REFRESHING_FLAVORED_PIZZA_SLICE)));
	//fruit knfie
	public static final RegistryObject<Item> FLINT_FRUIT_KNIFE = registerWithTab("flint_fruit_knife",
			() -> new FruitKnife(ModMaterials.FLINT, 0.6F, -2.0F, basicItem()));
	public static final RegistryObject<Item> IRON_FRUIT_KNIFE = registerWithTab("iron_fruit_knife",
			() -> new FruitKnife(Tiers.IRON, 0.6F, -2.0F, basicItem()));
	public static final RegistryObject<Item> DIAMOND_FRUIT_KNIFE = registerWithTab("diamond_fruit_knife",
			() -> new FruitKnife(Tiers.DIAMOND, 0.6F, -2.0F, basicItem()));
	public static final RegistryObject<Item> NETHERITE_FRUIT_KNIFE = registerWithTab("netherite_fruit_knife",
			() -> new FruitKnife(Tiers.NETHERITE, 0.6F, -2.0F, basicItem().fireResistant()));
	public static final RegistryObject<Item> GOLDEN_FRUIT_KNIFE = registerWithTab("golden_fruit_knife",
			() -> new FruitKnife(Tiers.GOLD, 0.6F, -2.0F, basicItem()));
	//pot
	public static final RegistryObject<Item> CLAY_OVEN = registerWithTab("clay_oven",
			() -> new BlockItem(ModBlocks.CLAY_OVEN.get(), basicItem()));
	public static final RegistryObject<Item> JUICER = registerWithTab("juicer",
			() -> new BlockItem(ModBlocks.JUICER.get(), basicItem()));
	public static final RegistryObject<Item> TRIPOD_VESSEL_FOR_MAKING_PILLS_OF_IMMORTALITY = registerWithTab("tripod_vessel_for_making_pills_of_immortality",
			() -> new BlockItem(ModBlocks.TRIPOD_VESSEL_FOR_MAKING_PILLS_OF_IMMORTALITY.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> PLATE = registerWithTab("plate",
			() -> new BlockItem(ModBlocks.PLATE.get(), basicItem()));
	public static final RegistryObject<Item> BOWL_BLOCK = registerWithTab("bowl_block",
			() -> new BlockItem(ModBlocks.BOWL_BLOCK.get(), basicItem()));
	public static final RegistryObject<Item> WINE_BARREL = registerWithTab("wine_barrel",
			() -> new BlockItem(ModBlocks.WINE_BARREL.get(), basicItem()));
	public static final RegistryObject<Item> LOW_WOODEN_BARREL = registerWithTab("low_wooden_barrel",
			() -> new BlockItem(ModBlocks.LOW_WOODEN_BARREL.get(), basicItem()));
	public static final RegistryObject<Item> POPSICLE_MACHINE = registerWithTab("popsicle_machine",
			() -> new BlockItem(ModBlocks.POPSICLE_MACHINE.get(), basicItem()));
	public static final RegistryObject<Item> FRYING_PAN = registerWithTab("frying_pan",
			() -> new BlockItem(ModBlocks.FRYING_PAN.get(), basicItem()));
	public static final RegistryObject<Item> POT_COVER = registerWithTab("pot_cover",
			() -> new Item(new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> SPATULA = registerWithTab("spatula",
			() -> new Item(new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> OVEN = registerWithTab("oven",
			() -> new BlockItem(ModBlocks.OVEN.get(), basicItem()));
    //farmland
    public static final RegistryObject<Item> LIFE_DIRT = registerWithTab("life_dirt",
            () -> new BlockItem(ModBlocks.LIFE_DIRT.get(), new Item.Properties().stacksTo(64)));
	public static final RegistryObject<Item> LIFE_FARMLAND = registerWithTab("life_farmland",
			() -> new BlockItem(ModBlocks.LIFE_FARMLAND.get(), new Item.Properties().stacksTo(64)));
	public static final RegistryObject<Item> CORRUPT_SOIL = registerWithTab("corrupt_soil",
			() -> new BlockItem(ModBlocks.CORRUPT_SOIL.get(), new Item.Properties().stacksTo(64)));
	public static final RegistryObject<Item> CORRUPT_SOIL_FARMLAND = registerWithTab("corrupt_soil_farmland",
			() -> new BlockItem(ModBlocks.CORRUPT_SOIL_FARMLAND.get(), new Item.Properties().stacksTo(64)));
	public static final RegistryObject<Item> CORRUPT_ESSENCE = registerWithTab("corrupt_essence",
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> LIFE_ESSENCE = registerWithTab("life_essence",
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> CORPSE = registerWithTab("corpse",
			() -> new Item(new Item.Properties()));
	//recipe
	public static final RegistryObject<Item> MANGO_RECIPE_PACKAGE = registerWithTab("mango_recipe_package",
			() -> new BlockItem(ModBlocks.MANGO_RECIPE_PACKAGE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> MANGO_TREE_RECIPE = registerWithTab("mango_tree_recipe",
			() -> new BlockItem(ModBlocks.MANGO_TREE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> GREEN_MANGO_SLICE_RECIPE = registerWithTab("green_mango_slice_recipe", () -> new BlockItem(ModBlocks.GREEN_MANGO_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> MANGO_CAKE_RECIPE = registerWithTab("mango_cake_recipe",
			() -> new BlockItem(ModBlocks.MANGO_CAKE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> MANGO_CAKE_SLICE_RECIPE = registerWithTab("mango_cake_slice_recipe",
			() -> new BlockItem(ModBlocks.MANGO_CAKE_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> MANGO_COOKIE_RECIPE = registerWithTab("mango_cookie_recipe",
			() -> new BlockItem(ModBlocks.MANGO_COOKIE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> MANGO_CRATE_RECIPE = registerWithTab("mango_crate_recipe",
			() -> new BlockItem(ModBlocks.MANGO_CRATE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> MANGO_JAM_RECIPE = registerWithTab("mango_jam_recipe",
			() -> new BlockItem(ModBlocks.MANGO_JAM_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> MANGO_PIE_RECIPE = registerWithTab("mango_pie_recipe",
			() -> new BlockItem(ModBlocks.MANGO_PIE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> MANGO_PIE_SLICE_RECIPE = registerWithTab("mango_pie_slice_recipe",
			() -> new BlockItem(ModBlocks.MANGO_PIE_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> MANGO_SLICE_RECIPE = registerWithTab("mango_slice_recipe",
			() -> new BlockItem(ModBlocks.MANGO_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> MANGO_RICE_DUMPLING_BLOCK_RECIPE = registerWithTab("mango_rice_dumpling_block_recipe",
			() -> new BlockItem(ModBlocks.MANGO_RICE_DUMPLING_BLOCK_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> MANGO_FILLING_RECIPE = registerWithTab("mango_filling_recipe",
			() -> new BlockItem(ModBlocks.MANGO_FILLING_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> RAW_MANGO_MOON_CAKE_RECIPE = registerWithTab("raw_mango_moon_cake_recipe",
			() -> new BlockItem(ModBlocks.RAW_MANGO_MOON_CAKE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> SWEETENED_MANGO_RECIPE = registerWithTab("sweetened_mango_recipe",
			() -> new BlockItem(ModBlocks.SWEETENED_MANGO_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> MANGO_JUICE_RECIPE = registerWithTab("mango_juice_recipe",
			() -> new BlockItem(ModBlocks.MANGO_JUICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> MANGO_MILK_ICE_CREAM_RECIPE = registerWithTab("mango_milk_ice_cream_recipe",
			() -> new BlockItem(ModBlocks.MANGO_MILK_ICE_CREAM_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> MANGO_MILK_TEA_RECIPE = registerWithTab("mango_milk_tea_recipe",
			() -> new BlockItem(ModBlocks.MANGO_MILK_TEA_RECIPE.get(), new Item.Properties().stacksTo(1)));

	public static final RegistryObject<Item> BLUEBERRIES_RECIPE_PACKAGE = registerWithTab("blueberries_recipe_package",
			() -> new BlockItem(ModBlocks.BLUEBERRIES_RECIPE_PACKAGE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> BLUEBERRIES_CAKE_SLICE_RECIPE = registerWithTab("blueberries_cake_slice_recipe",
			() -> new BlockItem(ModBlocks.BLUEBERRIES_CAKE_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> BLUEBERRIES_JAM_RECIPE = registerWithTab("blueberries_jam_recipe",
			() -> new BlockItem(ModBlocks.BLUEBERRIES_JAM_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> BLUEBERRIES_CAKE_RECIPE = registerWithTab("blueberries_cake_recipe",
			() -> new BlockItem(ModBlocks.BLUEBERRIES_CAKE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> BLUEBERRIES_BARQUILLO_RECIPE = registerWithTab("blueberries_barquillo_recipe",
			() -> new BlockItem(ModBlocks.BLUEBERRIES_BARQUILLO_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> BLUEBERRIES_PIE_RECIPE = registerWithTab("blueberries_pie_recipe",
			() -> new BlockItem(ModBlocks.BLUEBERRIES_PIE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> BLUEBERRIES_PIE_SLICE_RECIPE = registerWithTab("blueberries_pie_slice_recipe",
			() -> new BlockItem(ModBlocks.BLUEBERRIES_PIE_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> BLUEBERRIES_COOKIE_RECIPE = registerWithTab("blueberries_cookie_recipe",
			() -> new BlockItem(ModBlocks.BLUEBERRIES_COOKIE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> BLUEBERRIES_CRATE_RECIPE = registerWithTab("blueberries_crate_recipe",
			() -> new BlockItem(ModBlocks.BLUEBERRIES_CRATE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> BLUEBERRIES_RICE_DUMPLING_BLOCK_RECIPE = registerWithTab("blueberries_rice_dumpling_block_recipe",
			() -> new BlockItem(ModBlocks.BLUEBERRIES_RICE_DUMPLING_BLOCK_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> BLUEBERRIES_FILLING_RECIPE = registerWithTab("blueberries_filling_recipe",
			() -> new BlockItem(ModBlocks.BLUEBERRIES_FILLING_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> RAW_BLUEBERRIES_MOON_CAKE_RECIPE = registerWithTab("raw_blueberries_moon_cake_recipe",
			() -> new BlockItem(ModBlocks.RAW_BLUEBERRIES_MOON_CAKE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> SWEETENED_BLUEBERRIES_RECIPE = registerWithTab("sweetened_blueberries_recipe",
			() -> new BlockItem(ModBlocks.SWEETENED_BLUEBERRIES_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> BLUEBERRIES_JUICE_RECIPE = registerWithTab("blueberries_juice_recipe",
			() -> new BlockItem(ModBlocks.BLUEBERRIES_JUICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> BLUEBERRIES_MILK_TEA_RECIPE = registerWithTab("blueberries_milk_tea_recipe",
			() -> new BlockItem(ModBlocks.BLUEBERRIES_MILK_TEA_RECIPE.get(), new Item.Properties().stacksTo(1)));

	public static final RegistryObject<Item> HAMIMELON_RECIPE_PACKAGE = registerWithTab("hamimelon_recipe_package",
			() -> new BlockItem(ModBlocks.HAMIMELON_RECIPE_PACKAGE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> HAMIMELON_CAKE_SLICE_RECIPE = registerWithTab("hamimelon_cake_slice_recipe",
			() -> new BlockItem(ModBlocks.HAMIMELON_CAKE_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> HAMIMELON_COOKIE_RECIPE = registerWithTab("hamimelon_cookie_recipe",
			() -> new BlockItem(ModBlocks.HAMIMELON_COOKIE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> HAMIMELON_CRATE_RECIPE = registerWithTab("hamimelon_crate_recipe",
			() -> new BlockItem(ModBlocks.HAMIMELON_CRATE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> HAMIMELON_JAM_RECIPE = registerWithTab("hamimelon_jam_recipe",
			() -> new BlockItem(ModBlocks.HAMIMELON_JAM_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> SWEETENED_HAMIMELON_RECIPE = registerWithTab("sweetened_hamimelon_recipe",
			() -> new BlockItem(ModBlocks.SWEETENED_HAMIMELON_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> HAMIMELON_CAKE_RECIPE = registerWithTab("hamimelon_cake_recipe",
			() -> new BlockItem(ModBlocks.HAMIMELON_CAKE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> HAMIMELON_PIE_RECIPE = registerWithTab("hamimelon_pie_recipe",
			() -> new BlockItem(ModBlocks.HAMIMELON_PIE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> HAMIMELON_PIE_SLICE_RECIPE = registerWithTab("hamimelon_pie_slice_recipe",
			() -> new BlockItem(ModBlocks.HAMIMELON_PIE_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> FISH_SKIN_RECIPE = registerWithTab("fish_skin_recipe",
			() -> new BlockItem(ModBlocks.FISH_SKIN_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> SAGO_SOUP_RECIPE = registerWithTab("sago_soup_recipe",
			() -> new BlockItem(ModBlocks.SAGO_SOUP_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PROSCIUTTO_CANTALOUPE_RECIPE = registerWithTab("prosciutto_cantaloupe_recipe",
			() -> new BlockItem(ModBlocks.PROSCIUTTO_CANTALOUPE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> HAMIMELON_SAGO_SOUP_BLOCK_RECIPE = registerWithTab("hamimelon_sago_soup_block_recipe",
			() -> new BlockItem(ModBlocks.HAMIMELON_SAGO_SOUP_BLOCK_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> HAMIMELON_FILLING_RECIPE = registerWithTab("hamimelon_filling_recipe",
			() -> new BlockItem(ModBlocks.HAMIMELON_FILLING_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> RAW_HAMIMELON_MOON_CAKE_RECIPE = registerWithTab("raw_hamimelon_moon_cake_recipe",
			() -> new BlockItem(ModBlocks.RAW_HAMIMELON_MOON_CAKE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> HAMIMELON_RICE_DUMPLING_BLOCK_RECIPE = registerWithTab("hamimelon_rice_dumpling_block_recipe",
			() -> new BlockItem(ModBlocks.HAMIMELON_RICE_DUMPLING_BLOCK_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> HAMIMELON_JUICE_RECIPE = registerWithTab("hamimelon_juice_recipe",
			() -> new BlockItem(ModBlocks.HAMIMELON_JUICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> HAMIMELON_MILK_TEA_RECIPE = registerWithTab("hamimelon_milk_tea_recipe",
			() -> new BlockItem(ModBlocks.HAMIMELON_MILK_TEA_RECIPE.get(), new Item.Properties().stacksTo(1)));

	public static final RegistryObject<Item> BEATING_MELONS_RECIPE_PACKAGE = registerWithTab("beating_melons_recipe_package",
			() -> new BlockItem(ModBlocks.BEATING_MELONS_RECIPE_PACKAGE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> BEATING_MELONS_CRATE_RECIPE = registerWithTab("beating_melons_crate_recipe",
			() -> new BlockItem(ModBlocks.BEATING_MELONS_CRATE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> BEATING_MELONS_CAKE_RECIPE = registerWithTab("beating_melons_cake_recipe",
			() -> new BlockItem(ModBlocks.BEATING_MELONS_CAKE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> BEATING_MELONS_CAKE_SLICE_RECIPE = registerWithTab("beating_melons_cake_slice_recipe",
			() -> new BlockItem(ModBlocks.BEATING_MELONS_CAKE_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> BEATING_MELONS_JAM_RECIPE = registerWithTab("beating_melons_jam_recipe",
			() -> new BlockItem(ModBlocks.BEATING_MELONS_JAM_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> BEATING_MELONS_PIE_RECIPE = registerWithTab("beating_melons_pie_recipe",
			() -> new BlockItem(ModBlocks.BEATING_MELONS_PIE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> BEATING_MELONS_PIE_SLICE_RECIPE = registerWithTab("beating_melons_pie_slice_recipe",
			() -> new BlockItem(ModBlocks.BEATING_MELONS_PIE_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> BEATING_MELONS_COOKIE_RECIPE = registerWithTab("beating_melons_cookie_recipe",
			() -> new BlockItem(ModBlocks.BEATING_MELONS_COOKIE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> BEATING_MELONS_FILLING_RECIPE = registerWithTab("beating_melons_filling_recipe",
			() -> new BlockItem(ModBlocks.BEATING_MELONS_FILLING_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> RAW_BEATING_MELONS_MOON_CAKE_RECIPE = registerWithTab("raw_beating_melons_moon_cake_recipe",
			() -> new BlockItem(ModBlocks.RAW_BEATING_MELONS_MOON_CAKE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> BEATING_MELONS_RICE_DUMPLING_BLOCK_RECIPE = registerWithTab("beating_melons_rice_dumpling_block_recipe",
			() -> new BlockItem(ModBlocks.BEATING_MELONS_RICE_DUMPLING_BLOCK_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> BEATING_MELONS_JUICE_RECIPE = registerWithTab("beating_melons_juice_recipe",
			() -> new BlockItem(ModBlocks.BEATING_MELONS_JUICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> BEATING_MELONS_MILK_TEA_RECIPE = registerWithTab("beating_melons_milk_tea_recipe",
			() -> new BlockItem(ModBlocks.BEATING_MELONS_MILK_TEA_RECIPE.get(), new Item.Properties().stacksTo(1)));

	public static final RegistryObject<Item> GROUND_CUCUMBER_RECIPE_PACKAGE = registerWithTab("ground_cucumber_recipe_package",
			() -> new BlockItem(ModBlocks.GROUND_CUCUMBER_RECIPE_PACKAGE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> GROUND_CUCUMBER_CAKE_RECIPE = registerWithTab("ground_cucumber_cake_recipe",
			() -> new BlockItem(ModBlocks.GROUND_CUCUMBER_CAKE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> GROUND_CUCUMBER_CAKE_SLICE_RECIPE = registerWithTab("ground_cucumber_cake_slice_recipe",
			() -> new BlockItem(ModBlocks.GROUND_CUCUMBER_CAKE_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> GROUND_CUCUMBER_COOKIE__RECIPE = registerWithTab("ground_cucumber_cookie_recipe",
			() -> new BlockItem(ModBlocks.GROUND_CUCUMBER_COOKIE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> GROUND_CUCUMBER_CRATE_RECIPE = registerWithTab("ground_cucumber_crate_recipe",
			() -> new BlockItem(ModBlocks.GROUND_CUCUMBER_CRATE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> GROUND_CUCUMBER_FILLING_RECIPE = registerWithTab("ground_cucumber_filling_recipe",
			() -> new BlockItem(ModBlocks.GROUND_CUCUMBER_FILLING_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> GROUND_CUCUMBER_JAM_RECIPE = registerWithTab("ground_cucumber_jam_recipe",
			() -> new BlockItem(ModBlocks.GROUND_CUCUMBER_JAM_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> GROUND_CUCUMBER_PIE_RECIPE = registerWithTab("ground_cucumber_pie_recipe",
			() -> new BlockItem(ModBlocks.GROUND_CUCUMBER_PIE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> GROUND_CUCUMBER_PIE_SLICE_RECIPE = registerWithTab("ground_cucumber_pie_slice_recipe",
			() -> new BlockItem(ModBlocks.GROUND_CUCUMBER_PIE_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> GROUND_CUCUMBER_RICE_DUMPLING_BLOCK_RECIPE = registerWithTab("ground_cucumber_rice_dumpling_block_recipe",
			() -> new BlockItem(ModBlocks.GROUND_CUCUMBER_RICE_DUMPLING_BLOCK_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> GROUND_CUCUMBER_SLICE_RECIPE = registerWithTab("ground_cucumber_slice_recipe",
			() -> new BlockItem(ModBlocks.GROUND_CUCUMBER_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> RAW_GROUND_CUCUMBER_MOON_CAKE_RECIPE = registerWithTab("raw_ground_cucumber_moon_cake_recipe",
			() -> new BlockItem(ModBlocks.RAW_GROUND_CUCUMBER_MOON_CAKE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> GROUND_CUCUMBER_JUICE_RECIPE = registerWithTab("ground_cucumber_juice_recipe",
			() -> new BlockItem(ModBlocks.GROUND_CUCUMBER_JUICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> GROUND_CUCUMBER_MILK_TEA_RECIPE = registerWithTab("ground_cucumber_milk_tea_recipe",
			() -> new BlockItem(ModBlocks.GROUND_CUCUMBER_MILK_TEA_RECIPE.get(), new Item.Properties().stacksTo(1)));

	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_RECIPE_PACKAGE = registerWithTab("holboellia_latifolia_recipe_package",
			() -> new BlockItem(ModBlocks.HOLBOELLIA_LATIFOLIA_RECIPE_PACKAGE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_CAKE_RECIPE = registerWithTab("holboellia_latifolia_cake_recipe",
			() -> new BlockItem(ModBlocks.HOLBOELLIA_LATIFOLIA_CAKE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_CAKE_SLICE_RECIPE = registerWithTab("holboellia_latifolia_cake_slice_recipe",
			() -> new BlockItem(ModBlocks.HOLBOELLIA_LATIFOLIA_CAKE_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_COOKIE__RECIPE = registerWithTab("holboellia_latifolia_cookie_recipe",
			() -> new BlockItem(ModBlocks.HOLBOELLIA_LATIFOLIA_COOKIE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_CRATE_RECIPE = registerWithTab("holboellia_latifolia_crate_recipe",
			() -> new BlockItem(ModBlocks.HOLBOELLIA_LATIFOLIA_CRATE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_FILLING_RECIPE = registerWithTab("holboellia_latifolia_filling_recipe",
			() -> new BlockItem(ModBlocks.HOLBOELLIA_LATIFOLIA_FILLING_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_JAM_RECIPE = registerWithTab("holboellia_latifolia_jam_recipe",
			() -> new BlockItem(ModBlocks.HOLBOELLIA_LATIFOLIA_JAM_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_PIE_RECIPE = registerWithTab("holboellia_latifolia_pie_recipe",
			() -> new BlockItem(ModBlocks.HOLBOELLIA_LATIFOLIA_PIE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_PIE_SLICE_RECIPE = registerWithTab("holboellia_latifolia_pie_slice_recipe",
			() -> new BlockItem(ModBlocks.HOLBOELLIA_LATIFOLIA_PIE_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_RICE_DUMPLING_BLOCK_RECIPE = registerWithTab("holboellia_latifolia_rice_dumpling_block_recipe",
			() -> new BlockItem(ModBlocks.HOLBOELLIA_LATIFOLIA_RICE_DUMPLING_BLOCK_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_SLICE_RECIPE = registerWithTab("holboellia_latifolia_slice_recipe",
			() -> new BlockItem(ModBlocks.HOLBOELLIA_LATIFOLIA_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> RAW_HOLBOELLIA_LATIFOLIA_MOON_CAKE_RECIPE = registerWithTab("raw_holboellia_latifolia_moon_cake_recipe",
			() -> new BlockItem(ModBlocks.RAW_HOLBOELLIA_LATIFOLIA_MOON_CAKE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> ONION_TOMATO_HOLBOELLIA_LATIFOLIA_RECIPE = registerWithTab("onion_tomato_holboellia_latifolia_recipe",
			() -> new BlockItem(ModBlocks.ONION_TOMATO_HOLBOELLIA_LATIFOLIA_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_EGG_MILK_PUDDING_RECIPE = registerWithTab("holboellia_latifolia_egg_milk_pudding_recipe",
			() -> new BlockItem(ModBlocks.HOLBOELLIA_LATIFOLIA_EGG_MILK_PUDDING_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_JUICE_RECIPE = registerWithTab("holboellia_latifolia_juice_recipe",
			() -> new BlockItem(ModBlocks.HOLBOELLIA_LATIFOLIA_JUICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_MILK_TEA_RECIPE = registerWithTab("holboellia_latifolia_milk_tea_recipe",
			() -> new BlockItem(ModBlocks.HOLBOELLIA_LATIFOLIA_MILK_TEA_RECIPE.get(), new Item.Properties().stacksTo(1)));

	public static final RegistryObject<Item> LITCHI_RECIPE_PACKAGE = registerWithTab("litchi_recipe_package",
			() -> new BlockItem(ModBlocks.LITCHI_RECIPE_PACKAGE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> LITCHI_CAKE_RECIPE = registerWithTab("litchi_cake_recipe",
			() -> new BlockItem(ModBlocks.LITCHI_CAKE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> LITCHI_CAKE_SLICE_RECIPE = registerWithTab("litchi_cake_slice_recipe",
			() -> new BlockItem(ModBlocks.LITCHI_CAKE_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> LITCHI_COOKIE_RECIPE = registerWithTab("litchi_cookie_recipe",
			() -> new BlockItem(ModBlocks.LITCHI_COOKIE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> LITCHI_CRATE_RECIPE = registerWithTab("litchi_crate_recipe",
			() -> new BlockItem(ModBlocks.LITCHI_CRATE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> LITCHI_FILLING_RECIPE = registerWithTab("litchi_filling_recipe",
			() -> new BlockItem(ModBlocks.LITCHI_FILLING_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> LITCHI_JAM_RECIPE = registerWithTab("litchi_jam_recipe",
			() -> new BlockItem(ModBlocks.LITCHI_JAM_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> LITCHI_PIE_RECIPE = registerWithTab("litchi_pie_recipe",
			() -> new BlockItem(ModBlocks.LITCHI_PIE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> LITCHI_PIE_SLICE_RECIPE = registerWithTab("litchi_pie_slice_recipe",
			() -> new BlockItem(ModBlocks.LITCHI_PIE_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> LITCHI_RICE_DUMPLING_BLOCK_RECIPE = registerWithTab("litchi_rice_dumpling_block_recipe",
			() -> new BlockItem(ModBlocks.LITCHI_RICE_DUMPLING_BLOCK_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> LITCHI_SLICE_RECIPE = registerWithTab("litchi_slice_recipe",
			() -> new BlockItem(ModBlocks.LITCHI_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> RAW_LITCHI_MOON_CAKE_RECIPE = registerWithTab("raw_litchi_moon_cake_recipe",
			() -> new BlockItem(ModBlocks.RAW_LITCHI_MOON_CAKE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> LITCHI_JUICE_RECIPE = registerWithTab("litchi_juice_recipe",
			() -> new BlockItem(ModBlocks.LITCHI_JUICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> BOWLED_LITCHI_RIVER_NOODLES_RECIPE = registerWithTab("bowled_litchi_river_noodles_recipe",
			() -> new BlockItem(ModBlocks.BOWLED_LITCHI_RIVER_NOODLES_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> LITCHI_ICE_CREAM_REICPE = registerWithTab("litchi_ice_cream_recipe",
			() -> new BlockItem(ModBlocks.LITCHI_ICE_CREAM_REICPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> LITCHI_SAPLING_REICPE = registerWithTab("litchi_sapling_recipe",
			() -> new BlockItem(ModBlocks.LITCHI_SAPLING_REICPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> SWEETENED_LITCHI_REICPE = registerWithTab("sweetened_litchi_recipe",
			() -> new BlockItem(ModBlocks.SWEETENED_LITCHI_REICPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> UNFORMED_LITCHI_RIVER_DOUGH_REICPE = registerWithTab("unformed_litchi_river_dough_recipe",
			() -> new BlockItem(ModBlocks.UNFORMED_LITCHI_RIVER_DOUGH_REICPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> LITCHI_MILK_TEA_RECIPE = registerWithTab("litchi_milk_tea_recipe",
			() -> new BlockItem(ModBlocks.LITCHI_MILK_TEA_RECIPE.get(), new Item.Properties().stacksTo(1)));

	public static final RegistryObject<Item> HUOSHEN_FRUIT_RECIPE_PACKAGE = registerWithTab("huoshen_fruit_recipe_package",
			() -> new BlockItem(ModBlocks.HUOSHEN_FRUIT_RECIPE_PACKAGE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_CAKE_RECIPE = registerWithTab("huoshen_fruit_cake_recipe",
			() -> new BlockItem(ModBlocks.HUOSHEN_FRUIT_CAKE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_CAKE_SLICE_RECIPE = registerWithTab("huoshen_fruit_cake_slice_recipe",
			() -> new BlockItem(ModBlocks.HUOSHEN_FRUIT_CAKE_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_COOKIE_RECIPE = registerWithTab("huoshen_fruit_cookie_recipe",
			() -> new BlockItem(ModBlocks.HUOSHEN_FRUIT_COOKIE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_CRATE_RECIPE = registerWithTab("huoshen_fruit_crate_recipe",
			() -> new BlockItem(ModBlocks.HUOSHEN_FRUIT_CRATE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_FILLING_RECIPE = registerWithTab("huoshen_fruit_filling_recipe",
			() -> new BlockItem(ModBlocks.HUOSHEN_FRUIT_FILLING_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_JAM_RECIPE = registerWithTab("huoshen_fruit_jam_recipe",
			() -> new BlockItem(ModBlocks.HUOSHEN_FRUIT_JAM_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_PIE_RECIPE = registerWithTab("huoshen_fruit_pie_recipe",
			() -> new BlockItem(ModBlocks.HUOSHEN_FRUIT_PIE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_PIE_SLICE_RECIPE = registerWithTab("huoshen_fruit_pie_slice_recipe",
			() -> new BlockItem(ModBlocks.HUOSHEN_FRUIT_PIE_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_RICE_DUMPLING_BLOCK_RECIPE = registerWithTab("huoshen_fruit_rice_dumpling_block_recipe",
			() -> new BlockItem(ModBlocks.HUOSHEN_FRUIT_RICE_DUMPLING_BLOCK_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_SLICE_RECIPE = registerWithTab("huoshen_fruit_slice_recipe",
			() -> new BlockItem(ModBlocks.HUOSHEN_FRUIT_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> RAW_HUOSHEN_FRUIT_MOON_CAKE_RECIPE = registerWithTab("raw_huoshen_fruit_moon_cake_recipe",
			() -> new BlockItem(ModBlocks.RAW_HUOSHEN_FRUIT_MOON_CAKE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_JUICE_RECIPE = registerWithTab("huoshen_fruit_juice_recipe",
			() -> new BlockItem(ModBlocks.HUOSHEN_FRUIT_JUICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_HONEY_SAUCE_RECIPE = registerWithTab("huoshen_fruit_honey_sauce_recipe",
			() -> new BlockItem(ModBlocks.HUOSHEN_FRUIT_HONEY_SAUCE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_SEEDS_RECIPE = registerWithTab("huoshen_fruit_seeds_recipe",
			() -> new BlockItem(ModBlocks.HUOSHEN_FRUIT_SEEDS_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_MILK_TEA_RECIPE = registerWithTab("huoshen_fruit_milk_tea_recipe",
			() -> new BlockItem(ModBlocks.HUOSHEN_FRUIT_MILK_TEA_RECIPE.get(), new Item.Properties().stacksTo(1)));

	public static final RegistryObject<Item> SEPTEMBER_MELON_RECIPE_PACKAGE = registerWithTab("september_melon_recipe_package",
			() -> new BlockItem(ModBlocks.SEPTEMBER_MELON_RECIPE_PACKAGE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> SEPTEMBER_MELON_CAKE_RECIPE = registerWithTab("september_melon_cake_recipe",
			() -> new BlockItem(ModBlocks.SEPTEMBER_MELON_CAKE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> SEPTEMBER_MELON_CAKE_SLICE_RECIPE = registerWithTab("september_melon_cake_slice_recipe",
			() -> new BlockItem(ModBlocks.SEPTEMBER_MELON_CAKE_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> SEPTEMBER_MELON_COOKIE_RECIPE = registerWithTab("september_melon_cookie_recipe",
			() -> new BlockItem(ModBlocks.SEPTEMBER_MELON_COOKIE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> SEPTEMBER_MELON_CRATE_RECIPE = registerWithTab("september_melon_crate_recipe",
			() -> new BlockItem(ModBlocks.SEPTEMBER_MELON_CRATE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> SEPTEMBER_MELON_FILLING_RECIPE = registerWithTab("september_melon_filling_recipe",
			() -> new BlockItem(ModBlocks.SEPTEMBER_MELON_FILLING_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> SEPTEMBER_MELON_JAM_RECIPE = registerWithTab("september_melon_jam_recipe",
			() -> new BlockItem(ModBlocks.SEPTEMBER_MELON_JAM_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> SEPTEMBER_MELON_PIE_RECIPE = registerWithTab("september_melon_pie_recipe",
			() -> new BlockItem(ModBlocks.SEPTEMBER_MELON_PIE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> SEPTEMBER_MELON_PIE_SLICE_RECIPE = registerWithTab("september_melon_pie_slice_recipe",
			() -> new BlockItem(ModBlocks.SEPTEMBER_MELON_PIE_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> SEPTEMBER_MELON_RICE_DUMPLING_BLOCK_RECIPE = registerWithTab("september_melon_rice_dumpling_block_recipe",
			() -> new BlockItem(ModBlocks.SEPTEMBER_MELON_RICE_DUMPLING_BLOCK_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> RAW_SEPTEMBER_MELON_MOON_CAKE_RECIPE = registerWithTab("raw_september_melon_moon_cake_recipe",
			() -> new BlockItem(ModBlocks.RAW_SEPTEMBER_MELON_MOON_CAKE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> SEPTEMBER_MELON_JUICE_RECIPE = registerWithTab("september_melon_juice_recipe",
			() -> new BlockItem(ModBlocks.SEPTEMBER_MELON_JUICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> SEPTEMBER_MELON_SEEDS_RECIPE = registerWithTab("september_melon_seeds_recipe",
			() -> new BlockItem(ModBlocks.SEPTEMBER_MELON_SEEDS_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> SEPTEMBER_MELON_MILK_TEA_RECIPE = registerWithTab("september_melon_milk_tea_recipe",
			() -> new BlockItem(ModBlocks.SEPTEMBER_MELON_MILK_TEA_RECIPE.get(), new Item.Properties().stacksTo(1)));

	public static final RegistryObject<Item> PITAYA_RECIPE_PACKAGE = registerWithTab("pitaya_recipe_package",
			() -> new BlockItem(ModBlocks.PITAYA_RECIPE_PACKAGE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PITAYA_CAKE_RECIPE = registerWithTab("pitaya_cake_recipe",
			() -> new BlockItem(ModBlocks.PITAYA_CAKE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PITAYA_CAKE_SLICE_RECIPE = registerWithTab("pitaya_cake_slice_recipe",
			() -> new BlockItem(ModBlocks.PITAYA_CAKE_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PITAYA_COOKIE_RECIPE = registerWithTab("pitaya_cookie_recipe",
			() -> new BlockItem(ModBlocks.PITAYA_COOKIE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PITAYA_CRATE_RECIPE = registerWithTab("pitaya_crate_recipe",
			() -> new BlockItem(ModBlocks.PITAYA_CRATE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PITAYA_FILLING_RECIPE = registerWithTab("pitaya_filling_recipe",
			() -> new BlockItem(ModBlocks.PITAYA_FILLING_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PITAYA_JAM_RECIPE = registerWithTab("pitaya_jam_recipe",
			() -> new BlockItem(ModBlocks.PITAYA_JAM_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PITAYA_PIE_RECIPE = registerWithTab("pitaya_pie_recipe",
			() -> new BlockItem(ModBlocks.PITAYA_PIE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PITAYA_PIE_SLICE_RECIPE = registerWithTab("pitaya_pie_slice_recipe",
			() -> new BlockItem(ModBlocks.PITAYA_PIE_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PITAYA_RICE_DUMPLING_BLOCK_RECIPE = registerWithTab("pitaya_rice_dumpling_block_recipe",
			() -> new BlockItem(ModBlocks.PITAYA_RICE_DUMPLING_BLOCK_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> RAW_PITAYA_MOON_CAKE_RECIPE = registerWithTab("raw_pitaya_moon_cake_recipe",
			() -> new BlockItem(ModBlocks.RAW_PITAYA_MOON_CAKE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PITAYA_JUICE_RECIPE = registerWithTab("pitaya_juice_recipe",
			() -> new BlockItem(ModBlocks.PITAYA_JUICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PITAYA_SLICE_RECIPE = registerWithTab("pitaya_slice_recipe",
			() -> new BlockItem(ModBlocks.PITAYA_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> SWEETENED_PITAYA_RECIPE = registerWithTab("sweetened_pitaya_recipe",
			() -> new BlockItem(ModBlocks.SWEETENED_PITAYA_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> COLORFUL_FRUIT_SALAD_BLOCK_RECIPE = registerWithTab("colorful_fruit_salad_block_recipe",
			() -> new BlockItem(ModBlocks.COLORFUL_FRUIT_SALAD_BLOCK_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PITAYA_RICE_AND_VEGETABLE_ROLL_RECIPE = registerWithTab("pitaya_rice_and_vegetable_roll_recipe",
			() -> new BlockItem(ModBlocks.PITAYA_RICE_AND_VEGETABLE_ROLL_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PITAYA_MILK_TEA_RECIPE = registerWithTab("pitaya_milk_tea_recipe",
			() -> new BlockItem(ModBlocks.PITAYA_MILK_TEA_RECIPE.get(), new Item.Properties().stacksTo(1)));

	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_RECIPE_PACKAGE = registerWithTab("golden_pure_sheep_horn_honey_recipe_package",
			() -> new BlockItem(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_RECIPE_PACKAGE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_CAKE_RECIPE = registerWithTab("golden_pure_sheep_horn_honey_cake_recipe",
			() -> new BlockItem(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_CAKE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_CAKE_SLICE_RECIPE = registerWithTab("golden_pure_sheep_horn_honey_cake_slice_recipe",
			() -> new BlockItem(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_CAKE_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_COOKIE_RECIPE = registerWithTab("golden_pure_sheep_horn_honey_cookie_recipe",
			() -> new BlockItem(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_COOKIE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_CRATE_RECIPE = registerWithTab("golden_pure_sheep_horn_honey_crate_recipe",
			() -> new BlockItem(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_CRATE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_FILLING_RECIPE = registerWithTab("golden_pure_sheep_horn_honey_filling_recipe",
			() -> new BlockItem(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_FILLING_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_JAM_RECIPE = registerWithTab("golden_pure_sheep_horn_honey_jam_recipe",
			() -> new BlockItem(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_JAM_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_PIE_RECIPE = registerWithTab("golden_pure_sheep_horn_honey_pie_recipe",
			() -> new BlockItem(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_PIE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_PIE_SLICE_RECIPE = registerWithTab("golden_pure_sheep_horn_honey_pie_slice_recipe",
			() -> new BlockItem(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_PIE_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_RICE_DUMPLING_BLOCK_RECIPE = registerWithTab("golden_pure_sheep_horn_honey_rice_dumpling_block_recipe",
			() -> new BlockItem(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_RICE_DUMPLING_BLOCK_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> RAW_GOLDEN_PURE_SHEEP_HORN_HONEY_MOON_CAKE_RECIPE = registerWithTab("raw_golden_pure_sheep_horn_honey_moon_cake_recipe",
			() -> new BlockItem(ModBlocks.RAW_GOLDEN_PURE_SHEEP_HORN_HONEY_MOON_CAKE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_JUICE_RECIPE = registerWithTab("golden_pure_sheep_horn_honey_juice_recipe",
			() -> new BlockItem(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_JUICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_SLICE_RECIPE = registerWithTab("golden_pure_sheep_horn_honey_slice_recipe",
			() -> new BlockItem(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_SEEDS_RECIPE = registerWithTab("golden_pure_sheep_horn_honey_seeds_recipe",
			() -> new BlockItem(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_SEEDS_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_FLAVOR_GOLDEN_PURE_SHEEP_HORN_HONEY_RECIPE = registerWithTab("golden_pure_sheep_horn_honey_flavor_golden_pure_sheep_horn_honey_recipe",
			() -> new BlockItem(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_FLAVOR_GOLDEN_PURE_SHEEP_HORN_HONEY_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_MILK_TEA_RECIPE = registerWithTab("golden_pure_sheep_horn_honey_milk_tea_recipe",
			() -> new BlockItem(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_MILK_TEA_RECIPE.get(), new Item.Properties().stacksTo(1)));

	public static final RegistryObject<Item> PEAR_RECIPE_PACKAGE = registerWithTab("pear_recipe_package",
			() -> new BlockItem(ModBlocks.PEAR_RECIPE_PACKAGE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PEAR_CAKE_RECIPE = registerWithTab("pear_cake_recipe",
			() -> new BlockItem(ModBlocks.PEAR_CAKE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PEAR_CAKE_SLICE_RECIPE = registerWithTab("pear_cake_slice_recipe",
			() -> new BlockItem(ModBlocks.PEAR_CAKE_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PEAR_COOKIE_RECIPE = registerWithTab("pear_cookie_recipe",
			() -> new BlockItem(ModBlocks.PEAR_COOKIE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PEAR_CRATE_RECIPE = registerWithTab("pear_crate_recipe",
			() -> new BlockItem(ModBlocks.PEAR_CRATE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PEAR_FILLING_RECIPE = registerWithTab("pear_filling_recipe",
			() -> new BlockItem(ModBlocks.PEAR_FILLING_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PEAR_JAM_RECIPE = registerWithTab("pear_jam_recipe",
			() -> new BlockItem(ModBlocks.PEAR_JAM_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PEAR_PIE_RECIPE = registerWithTab("pear_pie_recipe",
			() -> new BlockItem(ModBlocks.PEAR_PIE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PEAR_PIE_SLICE_RECIPE = registerWithTab("pear_pie_slice_recipe",
			() -> new BlockItem(ModBlocks.PEAR_PIE_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PEAR_RICE_DUMPLING_BLOCK_RECIPE = registerWithTab("pear_rice_dumpling_block_recipe",
			() -> new BlockItem(ModBlocks.PEAR_RICE_DUMPLING_BLOCK_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> RAW_PEAR_MOON_CAKE_RECIPE = registerWithTab("raw_pear_moon_cake_recipe",
			() -> new BlockItem(ModBlocks.RAW_PEAR_MOON_CAKE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PEAR_JUICE_RECIPE = registerWithTab("pear_juice_recipe",
			() -> new BlockItem(ModBlocks.PEAR_JUICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PEAR_SLICE_RECIPE = registerWithTab("pear_slice_recipe",
			() -> new BlockItem(ModBlocks.PEAR_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PEAR_SAPLING_RECIPE = registerWithTab("pear_sapling_recipe",
			() -> new BlockItem(ModBlocks.PEAR_SAPLING_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> ROCK_SUGAR_SNOW_PEAR_RECIPE = registerWithTab("rock_sugar_snow_pear_recipe",
			() -> new BlockItem(ModBlocks.ROCK_SUGAR_SNOW_PEAR_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PEAR_MILK_TEA_RECIPE = registerWithTab("pear_milk_tea_recipe",
			() -> new BlockItem(ModBlocks.PEAR_MILK_TEA_RECIPE.get(), new Item.Properties().stacksTo(1)));

	public static final RegistryObject<Item> MAYTHORN_RECIPE_PACKAGE = registerWithTab("maythorn_recipe_package",
			() -> new BlockItem(ModBlocks.MAYTHORN_RECIPE_PACKAGE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> MAYTHORN_CAKE_RECIPE = registerWithTab("maythorn_cake_recipe",
			() -> new BlockItem(ModBlocks.MAYTHORN_CAKE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> MAYTHORN_CAKE_SLICE_RECIPE = registerWithTab("maythorn_cake_slice_recipe",
			() -> new BlockItem(ModBlocks.MAYTHORN_CAKE_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> MAYTHORN_COOKIE_RECIPE = registerWithTab("maythorn_cookie_recipe",
			() -> new BlockItem(ModBlocks.MAYTHORN_COOKIE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> MAYTHORN_CRATE_RECIPE = registerWithTab("maythorn_crate_recipe",
			() -> new BlockItem(ModBlocks.MAYTHORN_CRATE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> MAYTHORN_FILLING_RECIPE = registerWithTab("maythorn_filling_recipe",
			() -> new BlockItem(ModBlocks.MAYTHORN_FILLING_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> MAYTHORN_JAM_RECIPE = registerWithTab("maythorn_jam_recipe",
			() -> new BlockItem(ModBlocks.MAYTHORN_JAM_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> MAYTHORN_PIE_RECIPE = registerWithTab("maythorn_pie_recipe",
			() -> new BlockItem(ModBlocks.MAYTHORN_PIE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> MAYTHORN_PIE_SLICE_RECIPE = registerWithTab("maythorn_pie_slice_recipe",
			() -> new BlockItem(ModBlocks.MAYTHORN_PIE_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> MAYTHORN_RICE_DUMPLING_BLOCK_RECIPE = registerWithTab("maythorn_rice_dumpling_block_recipe",
			() -> new BlockItem(ModBlocks.MAYTHORN_RICE_DUMPLING_BLOCK_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> RAW_MAYTHORN_MOON_CAKE_RECIPE = registerWithTab("raw_maythorn_moon_cake_recipe",
			() -> new BlockItem(ModBlocks.RAW_MAYTHORN_MOON_CAKE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> MAYTHORN_JUICE_RECIPE = registerWithTab("maythorn_juice_recipe",
			() -> new BlockItem(ModBlocks.MAYTHORN_JUICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> SWEETENED_MAYTHORN_RECIPE = registerWithTab("sweetened_maythorn_recipe",
			() -> new BlockItem(ModBlocks.SWEETENED_MAYTHORN_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> MAYTHORN_SAPLING_RECIPE = registerWithTab("maythorn_sapling_recipe",
			() -> new BlockItem(ModBlocks.MAYTHORN_SAPLING_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> CANDIED_HAWS_ON_A_STICK_RECIPE = registerWithTab("candied_haws_on_a_stick_recipe",
			() -> new BlockItem(ModBlocks.CANDIED_HAWS_ON_A_STICK_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> BOWLED_CANDIED_HAWS_ON_A_STICK_RECIPE = registerWithTab("bowled_candied_haws_on_a_stick_recipe",
			() -> new BlockItem(ModBlocks.BOWLED_CANDIED_HAWS_ON_A_STICK_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> A_BUNDLE_OF_CANDIED_HAWS_ON_A_STICK_RECIPE = registerWithTab("a_bundle_of_candied_haws_on_a_stick_recipe",
			() -> new BlockItem(ModBlocks.A_BUNDLE_OF_CANDIED_HAWS_ON_A_STICK_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> RED_FRUIT_MAYTHORN_CAKE_RECIPE = registerWithTab("red_fruit_maythorn_cake_recipe",
			() -> new BlockItem(ModBlocks.RED_FRUIT_MAYTHORN_CAKE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> MAYTHORN_MILK_TEA_RECIPE = registerWithTab("maythorn_milk_tea_recipe",
			() -> new BlockItem(ModBlocks.MAYTHORN_MILK_TEA_RECIPE.get(), new Item.Properties().stacksTo(1)));

	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_RECIPE_PACKAGE = registerWithTab("chinese_pear_leaved_recipe_package",
			() -> new BlockItem(ModBlocks.CHINESE_PEAR_LEAVED_RECIPE_PACKAGE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_CAKE_RECIPE = registerWithTab("chinese_pear_leaved_cake_recipe",
			() -> new BlockItem(ModBlocks.CHINESE_PEAR_LEAVED_CAKE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_CAKE_SLICE_RECIPE = registerWithTab("chinese_pear_leaved_cake_slice_recipe",
			() -> new BlockItem(ModBlocks.CHINESE_PEAR_LEAVED_CAKE_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_COOKIE_RECIPE = registerWithTab("chinese_pear_leaved_cookie_recipe",
			() -> new BlockItem(ModBlocks.CHINESE_PEAR_LEAVED_COOKIE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_CRATE_RECIPE = registerWithTab("chinese_pear_leaved_crate_recipe",
			() -> new BlockItem(ModBlocks.CHINESE_PEAR_LEAVED_CRATE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_FILLING_RECIPE = registerWithTab("chinese_pear_leaved_filling_recipe",
			() -> new BlockItem(ModBlocks.CHINESE_PEAR_LEAVED_FILLING_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_JAM_RECIPE = registerWithTab("chinese_pear_leaved_jam_recipe",
			() -> new BlockItem(ModBlocks.CHINESE_PEAR_LEAVED_JAM_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_PIE_RECIPE = registerWithTab("chinese_pear_leaved_pie_recipe",
			() -> new BlockItem(ModBlocks.CHINESE_PEAR_LEAVED_PIE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_PIE_SLICE_RECIPE = registerWithTab("chinese_pear_leaved_pie_slice_recipe",
			() -> new BlockItem(ModBlocks.CHINESE_PEAR_LEAVED_PIE_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_RICE_DUMPLING_BLOCK_RECIPE = registerWithTab("chinese_pear_leaved_rice_dumpling_block_recipe",
			() -> new BlockItem(ModBlocks.CHINESE_PEAR_LEAVED_RICE_DUMPLING_BLOCK_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> RAW_CHINESE_PEAR_LEAVED_MOON_CAKE_RECIPE = registerWithTab("raw_chinese_pear_leaved_moon_cake_recipe",
			() -> new BlockItem(ModBlocks.RAW_CHINESE_PEAR_LEAVED_MOON_CAKE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_JUICE_RECIPE = registerWithTab("chinese_pear_leaved_juice_recipe",
			() -> new BlockItem(ModBlocks.CHINESE_PEAR_LEAVED_JUICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_SAPLING_RECIPE = registerWithTab("chinese_pear_leaved_sapling_recipe",
			() -> new BlockItem(ModBlocks.CHINESE_PEAR_LEAVED_SAPLING_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_ROLLS_RECIPE = registerWithTab("chinese_pear_leaved_rolls_recipe",
			() -> new BlockItem(ModBlocks.CHINESE_PEAR_LEAVED_ROLLS_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_MILK_TEA_RECIPE = registerWithTab("chinese_pear_leaved_milk_tea_recipe",
			() -> new BlockItem(ModBlocks.CHINESE_PEAR_LEAVED_MILK_TEA_RECIPE.get(), new Item.Properties().stacksTo(1)));

	public static final RegistryObject<Item> PLUM_RECIPE_PACKAGE = registerWithTab("plum_recipe_package",
			() -> new BlockItem(ModBlocks.PLUM_RECIPE_PACKAGE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PLUM_CAKE_RECIPE = registerWithTab("plum_cake_recipe",
			() -> new BlockItem(ModBlocks.PLUM_CAKE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PLUM_CAKE_SLICE_RECIPE = registerWithTab("plum_cake_slice_recipe",
			() -> new BlockItem(ModBlocks.PLUM_CAKE_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PLUM_COOKIE_RECIPE = registerWithTab("plum_cookie_recipe",
			() -> new BlockItem(ModBlocks.PLUM_COOKIE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PLUM_CRATE_RECIPE = registerWithTab("plum_crate_recipe",
			() -> new BlockItem(ModBlocks.PLUM_CRATE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PLUM_FILLING_RECIPE = registerWithTab("plum_filling_recipe",
			() -> new BlockItem(ModBlocks.PLUM_FILLING_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PLUM_JAM_RECIPE = registerWithTab("plum_jam_recipe",
			() -> new BlockItem(ModBlocks.PLUM_JAM_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PLUM_PIE_RECIPE = registerWithTab("plum_pie_recipe",
			() -> new BlockItem(ModBlocks.PLUM_PIE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PLUM_PIE_SLICE_RECIPE = registerWithTab("plum_pie_slice_recipe",
			() -> new BlockItem(ModBlocks.PLUM_PIE_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PLUM_RICE_DUMPLING_BLOCK_RECIPE = registerWithTab("plum_rice_dumpling_block_recipe",
			() -> new BlockItem(ModBlocks.PLUM_RICE_DUMPLING_BLOCK_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> RAW_PLUM_MOON_CAKE_RECIPE = registerWithTab("raw_plum_moon_cake_recipe",
			() -> new BlockItem(ModBlocks.RAW_PLUM_MOON_CAKE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PLUM_JUICE_RECIPE = registerWithTab("plum_juice_recipe",
			() -> new BlockItem(ModBlocks.PLUM_JUICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> SWEETENED_PLUM_RECIPE = registerWithTab("sweetened_plum_recipe",
			() -> new BlockItem(ModBlocks.SWEETENED_PLUM_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PLUM_SAPLING_RECIPE = registerWithTab("plum_sapling_recipe",
			() -> new BlockItem(ModBlocks.PLUM_SAPLING_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> SOUR_AND_SWEET_PLUM_CAKE_RECIPE = registerWithTab("sour_and_sweet_plum_cake_recipe",
			() -> new BlockItem(ModBlocks.SOUR_AND_SWEET_PLUM_CAKE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PLUM_MILK_TEA_RECIPE = registerWithTab("plum_milk_tea_recipe",
			() -> new BlockItem(ModBlocks.PLUM_MILK_TEA_RECIPE.get(), new Item.Properties().stacksTo(1)));

	public static final RegistryObject<Item> JUJUBE_RECIPE_PACKAGE = registerWithTab("jujube_recipe_package",
			() -> new BlockItem(ModBlocks.JUJUBE_RECIPE_PACKAGE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> JUJUBE_CAKE_RECIPE = registerWithTab("jujube_cake_recipe",
			() -> new BlockItem(ModBlocks.JUJUBE_CAKE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> JUJUBE_CAKE_SLICE_RECIPE = registerWithTab("jujube_cake_slice_recipe",
			() -> new BlockItem(ModBlocks.JUJUBE_CAKE_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> JUJUBE_COOKIE_RECIPE = registerWithTab("jujube_cookie_recipe",
			() -> new BlockItem(ModBlocks.JUJUBE_COOKIE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> JUJUBE_CRATE_RECIPE = registerWithTab("jujube_crate_recipe",
			() -> new BlockItem(ModBlocks.JUJUBE_CRATE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> JUJUBE_FILLING_RECIPE = registerWithTab("jujube_filling_recipe",
			() -> new BlockItem(ModBlocks.JUJUBE_FILLING_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> JUJUBE_JAM_RECIPE = registerWithTab("jujube_jam_recipe",
			() -> new BlockItem(ModBlocks.JUJUBE_JAM_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> JUJUBE_PIE_RECIPE = registerWithTab("jujube_pie_recipe",
			() -> new BlockItem(ModBlocks.JUJUBE_PIE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> JUJUBE_PIE_SLICE_RECIPE = registerWithTab("jujube_pie_slice_recipe",
			() -> new BlockItem(ModBlocks.JUJUBE_PIE_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> JUJUBE_RICE_DUMPLING_BLOCK_RECIPE = registerWithTab("jujube_rice_dumpling_block_recipe",
			() -> new BlockItem(ModBlocks.JUJUBE_RICE_DUMPLING_BLOCK_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> RAW_JUJUBE_MOON_CAKE_RECIPE = registerWithTab("raw_jujube_moon_cake_recipe",
			() -> new BlockItem(ModBlocks.RAW_JUJUBE_MOON_CAKE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> JUJUBE_JUICE_RECIPE = registerWithTab("jujube_juice_recipe",
			() -> new BlockItem(ModBlocks.JUJUBE_JUICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> SWEETENED_JUJUBE_RECIPE = registerWithTab("sweetened_jujube_recipe",
			() -> new BlockItem(ModBlocks.SWEETENED_JUJUBE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> JUJUBE_SAPLING_RECIPE = registerWithTab("jujube_sapling_recipe",
			() -> new BlockItem(ModBlocks.JUJUBE_SAPLING_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> RED_GATE_GLUTINOUS_RICE_RECIPE = registerWithTab("red_gate_glutinous_rice_recipe",
			() -> new BlockItem(ModBlocks.RED_GATE_GLUTINOUS_RICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> JUJUBE_MILK_TEA_RECIPE = registerWithTab("jujube_milk_tea_recipe",
			() -> new BlockItem(ModBlocks.JUJUBE_MILK_TEA_RECIPE.get(), new Item.Properties().stacksTo(1)));

	public static final RegistryObject<Item> APRICOT_RECIPE_PACKAGE = registerWithTab("apricot_recipe_package",
			() -> new BlockItem(ModBlocks.APRICOT_RECIPE_PACKAGE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> APRICOT_CAKE_RECIPE = registerWithTab("apricot_cake_recipe",
			() -> new BlockItem(ModBlocks.APRICOT_CAKE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> APRICOT_CAKE_SLICE_RECIPE = registerWithTab("apricot_cake_slice_recipe",
			() -> new BlockItem(ModBlocks.APRICOT_CAKE_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> APRICOT_COOKIE_RECIPE = registerWithTab("apricot_cookie_recipe",
			() -> new BlockItem(ModBlocks.APRICOT_COOKIE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> APRICOT_CRATE_RECIPE = registerWithTab("apricot_crate_recipe",
			() -> new BlockItem(ModBlocks.APRICOT_CRATE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> APRICOT_FILLING_RECIPE = registerWithTab("apricot_filling_recipe",
			() -> new BlockItem(ModBlocks.APRICOT_FILLING_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> APRICOT_JAM_RECIPE = registerWithTab("apricot_jam_recipe",
			() -> new BlockItem(ModBlocks.APRICOT_JAM_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> APRICOT_PIE_RECIPE = registerWithTab("apricot_pie_recipe",
			() -> new BlockItem(ModBlocks.APRICOT_PIE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> APRICOT_PIE_SLICE_RECIPE = registerWithTab("apricot_pie_slice_recipe",
			() -> new BlockItem(ModBlocks.APRICOT_PIE_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> APRICOT_RICE_DUMPLING_BLOCK_RECIPE = registerWithTab("apricot_rice_dumpling_block_recipe",
			() -> new BlockItem(ModBlocks.APRICOT_RICE_DUMPLING_BLOCK_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> RAW_APRICOT_MOON_CAKE_RECIPE = registerWithTab("raw_apricot_moon_cake_recipe",
			() -> new BlockItem(ModBlocks.RAW_APRICOT_MOON_CAKE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> APRICOT_JUICE_RECIPE = registerWithTab("apricot_juice_recipe",
			() -> new BlockItem(ModBlocks.APRICOT_JUICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> APRICOT_SAPLING_RECIPE = registerWithTab("apricot_sapling_recipe",
			() -> new BlockItem(ModBlocks.APRICOT_SAPLING_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> APRICOT_SMOOTHIE_RECIPE = registerWithTab("apricot_smoothie_recipe",
			() -> new BlockItem(ModBlocks.APRICOT_SMOOTHIE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> APRICOT_MILK_TEA_RECIPE = registerWithTab("apricot_milk_tea_recipe",
			() -> new BlockItem(ModBlocks.APRICOT_MILK_TEA_RECIPE.get(), new Item.Properties().stacksTo(1)));

	public static final RegistryObject<Item> RED_BAYBERRY_RECIPE_PACKAGE = registerWithTab("red_bayberry_recipe_package",
			() -> new BlockItem(ModBlocks.RED_BAYBERRY_RECIPE_PACKAGE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> RED_BAYBERRY_CAKE_RECIPE = registerWithTab("red_bayberry_cake_recipe",
			() -> new BlockItem(ModBlocks.RED_BAYBERRY_CAKE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> RED_BAYBERRY_CAKE_SLICE_RECIPE = registerWithTab("red_bayberry_cake_slice_recipe",
			() -> new BlockItem(ModBlocks.RED_BAYBERRY_CAKE_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> RED_BAYBERRY_COOKIE_RECIPE = registerWithTab("red_bayberry_cookie_recipe",
			() -> new BlockItem(ModBlocks.RED_BAYBERRY_COOKIE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> RED_BAYBERRY_CRATE_RECIPE = registerWithTab("red_bayberry_crate_recipe",
			() -> new BlockItem(ModBlocks.RED_BAYBERRY_CRATE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> RED_BAYBERRY_FILLING_RECIPE = registerWithTab("red_bayberry_filling_recipe",
			() -> new BlockItem(ModBlocks.RED_BAYBERRY_FILLING_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> RED_BAYBERRY_JAM_RECIPE = registerWithTab("red_bayberry_jam_recipe",
			() -> new BlockItem(ModBlocks.RED_BAYBERRY_JAM_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> RED_BAYBERRY_PIE_RECIPE = registerWithTab("red_bayberry_pie_recipe",
			() -> new BlockItem(ModBlocks.RED_BAYBERRY_PIE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> RED_BAYBERRY_PIE_SLICE_RECIPE = registerWithTab("red_bayberry_pie_slice_recipe",
			() -> new BlockItem(ModBlocks.RED_BAYBERRY_PIE_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> RED_BAYBERRY_RICE_DUMPLING_BLOCK_RECIPE = registerWithTab("red_bayberry_rice_dumpling_block_recipe",
			() -> new BlockItem(ModBlocks.RED_BAYBERRY_RICE_DUMPLING_BLOCK_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> RAW_RED_BAYBERRY_MOON_CAKE_RECIPE = registerWithTab("raw_red_bayberry_moon_cake_recipe",
			() -> new BlockItem(ModBlocks.RAW_RED_BAYBERRY_MOON_CAKE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> RED_BAYBERRY_JUICE_RECIPE = registerWithTab("red_bayberry_juice_recipe",
			() -> new BlockItem(ModBlocks.RED_BAYBERRY_JUICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> RED_BAYBERRY_SAPLING_RECIPE = registerWithTab("red_bayberry_sapling_recipe",
			() -> new BlockItem(ModBlocks.RED_BAYBERRY_SAPLING_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> SOUR_PLUM_CHICKEN_BLOCK_RECIPE = registerWithTab("sour_plum_chicken_block_recipe",
			() -> new BlockItem(ModBlocks.SOUR_PLUM_CHICKEN_BLOCK_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> RED_BAYBERRY_MILK_TEA_RECIPE = registerWithTab("red_bayberry_milk_tea_recipe",
			() -> new BlockItem(ModBlocks.RED_BAYBERRY_MILK_TEA_RECIPE.get(), new Item.Properties().stacksTo(1)));

	public static final RegistryObject<Item> GREEN_PLUM_RECIPE_PACKAGE = registerWithTab("green_plum_recipe_package",
			() -> new BlockItem(ModBlocks.GREEN_PLUM_RECIPE_PACKAGE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> GREEN_PLUM_CAKE_RECIPE = registerWithTab("green_plum_cake_recipe",
			() -> new BlockItem(ModBlocks.GREEN_PLUM_CAKE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> GREEN_PLUM_CAKE_SLICE_RECIPE = registerWithTab("green_plum_cake_slice_recipe",
			() -> new BlockItem(ModBlocks.GREEN_PLUM_CAKE_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> GREEN_PLUM_COOKIE_RECIPE = registerWithTab("green_plum_cookie_recipe",
			() -> new BlockItem(ModBlocks.GREEN_PLUM_COOKIE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> GREEN_PLUM_CRATE_RECIPE = registerWithTab("green_plum_crate_recipe",
			() -> new BlockItem(ModBlocks.GREEN_PLUM_CRATE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> GREEN_PLUM_FILLING_RECIPE = registerWithTab("green_plum_filling_recipe",
			() -> new BlockItem(ModBlocks.GREEN_PLUM_FILLING_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> GREEN_PLUM_JAM_RECIPE = registerWithTab("green_plum_jam_recipe",
			() -> new BlockItem(ModBlocks.GREEN_PLUM_JAM_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> GREEN_PLUM_PIE_RECIPE = registerWithTab("green_plum_pie_recipe",
			() -> new BlockItem(ModBlocks.GREEN_PLUM_PIE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> GREEN_PLUM_PIE_SLICE_RECIPE = registerWithTab("green_plum_pie_slice_recipe",
			() -> new BlockItem(ModBlocks.GREEN_PLUM_PIE_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> GREEN_PLUM_RICE_DUMPLING_BLOCK_RECIPE = registerWithTab("green_plum_rice_dumpling_block_recipe",
			() -> new BlockItem(ModBlocks.GREEN_PLUM_RICE_DUMPLING_BLOCK_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> RAW_GREEN_PLUM_MOON_CAKE_RECIPE = registerWithTab("raw_green_plum_moon_cake_recipe",
			() -> new BlockItem(ModBlocks.RAW_GREEN_PLUM_MOON_CAKE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> GREEN_PLUM_JUICE_RECIPE = registerWithTab("green_plum_juice_recipe",
			() -> new BlockItem(ModBlocks.GREEN_PLUM_JUICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> GREEN_PLUM_SAPLING_RECIPE = registerWithTab("green_plum_sapling_recipe",
			() -> new BlockItem(ModBlocks.GREEN_PLUM_SAPLING_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> GREEN_PLUM_MILK_TEA_RECIPE = registerWithTab("green_plum_milk_tea_recipe",
			() -> new BlockItem(ModBlocks.GREEN_PLUM_MILK_TEA_RECIPE.get(), new Item.Properties().stacksTo(1)));

	public static final RegistryObject<Item> GRAPE_RECIPE_PACKAGE = registerWithTab("grape_recipe_package",
			() -> new BlockItem(ModBlocks.GRAPE_RECIPE_PACKAGE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> GRAPE_CAKE_RECIPE = registerWithTab("grape_cake_recipe",
			() -> new BlockItem(ModBlocks.GRAPE_CAKE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> GRAPE_CAKE_SLICE_RECIPE = registerWithTab("grape_cake_slice_recipe",
			() -> new BlockItem(ModBlocks.GRAPE_CAKE_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> GRAPE_COOKIE_RECIPE = registerWithTab("grape_cookie_recipe",
			() -> new BlockItem(ModBlocks.GRAPE_COOKIE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> GRAPE_CRATE_RECIPE = registerWithTab("grape_crate_recipe",
			() -> new BlockItem(ModBlocks.GRAPE_CRATE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> GRAPE_FILLING_RECIPE = registerWithTab("grape_filling_recipe",
			() -> new BlockItem(ModBlocks.GRAPE_FILLING_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> GRAPE_JAM_RECIPE = registerWithTab("grape_jam_recipe",
			() -> new BlockItem(ModBlocks.GRAPE_JAM_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> GRAPE_PIE_RECIPE = registerWithTab("grape_pie_recipe",
			() -> new BlockItem(ModBlocks.GRAPE_PIE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> GRAPE_PIE_SLICE_RECIPE = registerWithTab("grape_pie_slice_recipe",
			() -> new BlockItem(ModBlocks.GRAPE_PIE_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> GRAPE_RICE_DUMPLING_BLOCK_RECIPE = registerWithTab("grape_rice_dumpling_block_recipe",
			() -> new BlockItem(ModBlocks.GRAPE_RICE_DUMPLING_BLOCK_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> RAW_GRAPE_MOON_CAKE_RECIPE = registerWithTab("raw_grape_moon_cake_recipe",
			() -> new BlockItem(ModBlocks.RAW_GRAPE_MOON_CAKE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> GRAPE_JUICE_RECIPE = registerWithTab("grape_juice_recipe",
			() -> new BlockItem(ModBlocks.GRAPE_JUICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> SWEETENED_GRAPE_RECIPE = registerWithTab("sweetened_grape_recipe",
			() -> new BlockItem(ModBlocks.SWEETENED_GRAPE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> GRAPE_JELLY_RECIPE = registerWithTab("grape_jelly_recipe",
			() -> new BlockItem(ModBlocks.GRAPE_JELLY_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> GRAPE_MILK_TEA_RECIPE = registerWithTab("grape_milk_tea_recipe",
			() -> new BlockItem(ModBlocks.GRAPE_MILK_TEA_RECIPE.get(), new Item.Properties().stacksTo(1)));

	public static final RegistryObject<Item> PEACH_RECIPE_PACKAGE = registerWithTab("peach_recipe_package",
			() -> new BlockItem(ModBlocks.PEACH_RECIPE_PACKAGE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PEACH_SAPLING_RECIPE = registerWithTab("peach_sapling_recipe",
			() -> new BlockItem(ModBlocks.PEACH_SAPLING_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PEACH_CAKE_RECIPE = registerWithTab("peach_cake_recipe",
			() -> new BlockItem(ModBlocks.PEACH_CAKE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PEACH_CAKE_SLICE_RECIPE = registerWithTab("peach_cake_slice_recipe",
			() -> new BlockItem(ModBlocks.PEACH_CAKE_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PEACH_COOKIE_RECIPE = registerWithTab("peach_cookie_recipe",
			() -> new BlockItem(ModBlocks.PEACH_COOKIE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PEACH_CRATE_RECIPE = registerWithTab("peach_crate_recipe",
			() -> new BlockItem(ModBlocks.PEACH_CRATE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PEACH_JAM_RECIPE = registerWithTab("peach_jam_recipe",
			() -> new BlockItem(ModBlocks.PEACH_JAM_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PEACH_PIE_RECIPE = registerWithTab("peach_pie_recipe",
			() -> new BlockItem(ModBlocks.PEACH_PIE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PEACH_PIE_SLICE_RECIPE = registerWithTab("peach_pie_slice_recipe",
			() -> new BlockItem(ModBlocks.PEACH_PIE_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PEACH_SLICE_RECIPE = registerWithTab("peach_slice_recipe",
			() -> new BlockItem(ModBlocks.PEACH_SLICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PEACH_RICE_DUMPLING_BLOCK_RECIPE = registerWithTab("peach_rice_dumpling_block_recipe",
			() -> new BlockItem(ModBlocks.PEACH_RICE_DUMPLING_BLOCK_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PEACH_FILLING_RECIPE = registerWithTab("peach_filling_recipe",
			() -> new BlockItem(ModBlocks.PEACH_FILLING_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> RAW_PEACH_MOON_CAKE_RECIPE = registerWithTab("raw_peach_moon_cake_recipe",
			() -> new BlockItem(ModBlocks.RAW_PEACH_MOON_CAKE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> SWEETENED_PEACH_RECIPE = registerWithTab("sweetened_peach_recipe",
			() -> new BlockItem(ModBlocks.SWEETENED_PEACH_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PEACH_JUICE_RECIPE = registerWithTab("peach_juice_recipe",
			() -> new BlockItem(ModBlocks.PEACH_JUICE_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PEACH_MILK_TEA_RECIPE = registerWithTab("peach_milk_tea_recipe",
			() -> new BlockItem(ModBlocks.PEACH_MILK_TEA_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> LACTOBACILLUS_HONEY_PEACH_ICE_RECIPE = registerWithTab("lactobacillus_honey_peach_ice_recipe",
			() -> new BlockItem(ModBlocks.LACTOBACILLUS_HONEY_PEACH_ICE_RECIPE.get(), new Item.Properties().stacksTo(1)));

	public static final RegistryObject<Item> FRYING_PAN_RECIPE_PACKAGE = registerWithTab("frying_pan_recipe_package",
			() -> new BlockItem(ModBlocks.FRYING_PAN_RECIPE_PACKAGE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> FRYING_PAN_STIR_FRIED_BEATING_MELONS_SEEDS_RECIPE = registerWithTab("frying_pan_stir_fried_beating_melons_seeds_recipe",
			() -> new BlockItem(ModBlocks.FRYING_PAN_STIR_FRIED_BEATING_MELONS_SEEDS_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> FRYING_PAN_CRISPY_LITCHI_BALL_RECIPE = registerWithTab("frying_pan_crispy_litchi_ball_recipe",
			() -> new BlockItem(ModBlocks.FRYING_PAN_CRISPY_LITCHI_BALL_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> FRYING_PAN_HONEY_MELON_CHICKEN_BALLS_RECIPE = registerWithTab("frying_pan_honey_melon_chicken_balls_recipe",
			() -> new BlockItem(ModBlocks.FRYING_PAN_HONEY_MELON_CHICKEN_BALLS_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> FRYING_PAN_STIR_FRIED_YOGURT_RECIPE = registerWithTab("frying_pan_stir_fried_yogurt_recipe",
			() -> new BlockItem(ModBlocks.FRYING_PAN_STIR_FRIED_YOGURT_RECIPE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> FRYING_PAN_MILKY_TEA_RECIPE_RECIPE = registerWithTab("frying_pan_milky_tea_recipe",
			() -> new BlockItem(ModBlocks.FRYING_PAN_MILKY_TEA_RECIPE_RECIPE.get(), new Item.Properties().stacksTo(1)));

	public static final RegistryObject<Item> PIZZA_RECIPE_PACKAGE = registerWithTab("pizza_recipe_package",
			() -> new BlockItem(ModBlocks.PIZZA_RECIPE_PACKAGE.get(), new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> PIZZA_RECIPE = registerWithTab("pizza_recipe",
			() -> new BlockItem(ModBlocks.PIZZA_RECIPE.get(), new Item.Properties().stacksTo(1)));
}
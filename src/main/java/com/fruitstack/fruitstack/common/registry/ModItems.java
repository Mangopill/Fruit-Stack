package com.fruitstack.fruitstack.common.registry;

import com.fruitstack.fruitstack.common.FoodValues;
import com.fruitstack.fruitstack.common.item.*;
import com.fruitstack.fruitstack.fruitstack;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings("unused")
public class ModItems
{
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, fruitstack.MODID);
	// Helper methods
	public static Item.Properties basicItem() {
		return new Item.Properties().tab(fruitstack.CREATIVE_TAB);
	}

	public static Item.Properties foodItem(FoodProperties food) {
		return new Item.Properties().food(food).tab(fruitstack.CREATIVE_TAB);
	}

	public static Item.Properties bowlFoodItem(FoodProperties food) {
		return new Item.Properties().food(food).craftRemainder(Items.BOWL).stacksTo(16).tab(fruitstack.CREATIVE_TAB);
	}
	public static Item.Properties drinkItem() {
		return new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).tab(fruitstack.CREATIVE_TAB);
	}
	//new cup
	public static final RegistryObject<Item> JUICE_CUP = ITEMS.register("juice_cup",
			() -> new BottleItem(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> CANN = ITEMS.register("cann",
			() -> new BottleItem(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> MILK_TEA_CUP = ITEMS.register("milk_tea_cup",
			() -> new BottleItem(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static Item.Properties juiceItem() {
		return new Item.Properties().craftRemainder(ModItems.JUICE_CUP.get()).stacksTo(16).tab(fruitstack.CREATIVE_TAB);
	}
	public static Item.Properties wineItem() {
		return new Item.Properties().craftRemainder(ModItems.CANN.get()).stacksTo(16).tab(fruitstack.CREATIVE_TAB);
	}
	public static Item.Properties milkyTeaItem() {
		return new Item.Properties().craftRemainder(ModItems.MILK_TEA_CUP.get()).stacksTo(16).tab(fruitstack.CREATIVE_TAB);
	}
	//fork / chopsticks
	public static final RegistryObject<Item> FORK = ITEMS.register("fork",
			() -> new Item(new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> CHOPSTICKS = ITEMS.register("chopsticks",
			() -> new Item(new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	//core food
	public static final RegistryObject<Item> SUNFLOWER_OIL = ITEMS.register("sunflower_oil",
			() -> new Item(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> THE_BURNT_DISH = ITEMS.register("the_burnt_dish",
			() -> new ConsumableItem(bowlFoodItem(FoodValues.THE_BURNT_DISH), true));
	public static final RegistryObject<Item> STIR_FRIED_YOGURT = ITEMS.register("stir_fried_yogurt",
			() -> new ConsumableItem(bowlFoodItem(FoodValues.STIR_FRIED_YOGURT), true));
	public static final RegistryObject<Item> DOUGHNUT = ITEMS.register("doughnut",
			() -> new Item(foodItem(FoodValues.DOUGHNUT).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> MILKY_TEA = ITEMS.register("milky_tea",
			() -> new DrinkableItem(milkyTeaItem().food(FoodValues.MILKY_TEA), true, false));
	public static final RegistryObject<Item> CHINESE_SPIRITS_BARREL = ITEMS.register("chinese_spirits_barrel",
			() -> new BlockItem(ModBlocks.CHINESE_SPIRITS_BARREL.get(), basicItem()));
	public static final RegistryObject<Item> CHINESE_SPIRITS_ONE = ITEMS.register("chinese_spirits_one",
			() -> new DrinkableItem(wineItem().food(FoodValues.CHINESE_SPIRITS_ONE), true, true));
	public static final RegistryObject<Item> CHINESE_SPIRITS_TWO = ITEMS.register("chinese_spirits_two",
			() -> new DrinkableItem(wineItem().food(FoodValues.CHINESE_SPIRITS_TWO), true, true));
	public static final RegistryObject<Item> CHINESE_SPIRITS_THREE = ITEMS.register("chinese_spirits_three",
			() -> new DrinkableItem(wineItem().food(FoodValues.CHINESE_SPIRITS_THREE), true, true));
	public static final RegistryObject<Item> CHINESE_SPIRITS_FOUR = ITEMS.register("chinese_spirits_four",
			() -> new DrinkableItem(wineItem().food(FoodValues.CHINESE_SPIRITS_FOUR), true, true));
	public static final RegistryObject<Item> CHINESE_SPIRITS_FIVE = ITEMS.register("chinese_spirits_five",
			() -> new DrinkableItem(wineItem().food(FoodValues.CHINESE_SPIRITS_FIVE), true, true));
	public static final RegistryObject<Item> CHINESE_SPIRITS_SIX = ITEMS.register("chinese_spirits_six",
			() -> new DrinkableItem(wineItem().food(FoodValues.CHINESE_SPIRITS_SIX), true, true));
	public static final RegistryObject<Item> CHINESE_SPIRITS_SEVEN = ITEMS.register("chinese_spirits_seven",
			() -> new DrinkableItem(wineItem().food(FoodValues.CHINESE_SPIRITS_SEVEN), true, true));
	public static final RegistryObject<Item> CHINESE_SPIRITS_EIGHT = ITEMS.register("chinese_spirits_eight",
			() -> new DrinkableItem(wineItem().food(FoodValues.CHINESE_SPIRITS_EIGHT), true, true));
	public static final RegistryObject<Item> CHINESE_SPIRITS_NINE = ITEMS.register("chinese_spirits_nine",
			() -> new DrinkableItem(wineItem().food(FoodValues.CHINESE_SPIRITS_NINE), true, true));
	public static final RegistryObject<Item> CHINESE_SPIRITS_TEN = ITEMS.register("chinese_spirits_ten",
			() -> new DrinkableItem(wineItem().food(FoodValues.CHINESE_SPIRITS_TEN), true, true));
	//blueberries
	public static final RegistryObject<Item> BLUEBERRIES_SEEDS = ITEMS.register("blueberries_seeds",
			()-> new ItemNameBlockItem(ModBlocks.BLUEBERRIES_CROP.get(),new Item.Properties()
					.tab(fruitstack.CREATIVE_TAB)
			));
	public static final RegistryObject<Item> WILD_BLUEBERRIES = ITEMS.register("wild_blueberries",
			() -> new BlockItem(ModBlocks.WILD_BLUEBERRIES.get(), basicItem()));
	public static final RegistryObject<Item> BLUEBERRIES = ITEMS.register("blueberries",
			() -> new Item(foodItem(FoodValues.BLUEBERRIES).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> BLUEBERRIES_POPSICLE = ITEMS.register("blueberries_popsicle",
			() -> new PopsicleItem(foodItem(FoodValues.BLUEBERRIES_POPSICLE)));
	public static final RegistryObject<Item> BLUEBERRIES_CAKE = ITEMS.register("blueberries_cake",
			()-> new ItemNameBlockItem(ModBlocks.BLUEBERRIES_CAKE.get(),new Item.Properties()
					.tab(fruitstack.CREATIVE_TAB)
			));
	public static final RegistryObject<Item> BLUEBERRIES_PIE = ITEMS.register("blueberries_pie",
			() -> new BlockItem(ModBlocks.BLUEBERRIES_PIE.get(), basicItem()));
	public static final RegistryObject<Item> BLUEBERRIES_PIE_SLICE = ITEMS.register("blueberries_pie_slice",
			() -> new Item(foodItem(FoodValues.BLUEBERRIES_PIE_SLICE)));
	public static final RegistryObject<Item> BLUEBERRIES_CAKE_SLICE = ITEMS.register("blueberries_cake_slice",
			() -> new Item(foodItem(FoodValues.BLUEBERRIES_CAKE_SLICE)));
	public static final RegistryObject<Item> BLUEBERRIES_CRATE = ITEMS.register("blueberries_crate",
			() -> new BlockItem(ModBlocks.BLUEBERRIES_CRATE.get(), basicItem()));
	public static final RegistryObject<Item> BLUEBERRIES_BARQUILLO = ITEMS.register("blueberries_barquillo",
			() -> new Item(foodItem(FoodValues.BLUEBERRIES_BARQUILLO)));
	public static final RegistryObject<Item> BLUEBERRIES_COOKIE = ITEMS.register("blueberries_cookie",
			() -> new Item(foodItem(FoodValues.BLUEBERRIES_COOKIE)));
	public static final RegistryObject<Item> BLUEBERRIES_JAM = ITEMS.register("blueberries_jam",
			() -> new BlockItem(ModBlocks.BLUEBERRIES_JAM.get(), basicItem()));
	public static final RegistryObject<Item> BLUEBERRIES_BREAD = ITEMS.register("blueberries_bread",
			() -> new Item(foodItem(FoodValues.BLUEBERRIES_BREAD).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> BLUEBERRIES_DOUGHNUT = ITEMS.register("blueberries_doughnut",
			() -> new Item(foodItem(FoodValues.BLUEBERRIES_DOUGHNUT).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> SWEETENED_BLUEBERRIES = ITEMS.register("sweetened_blueberries",
			() -> new BlockItem(ModBlocks.SWEETENED_BLUEBERRIES.get(), basicItem()));
	public static final RegistryObject<Item> DRIED_BLUEBERRIES = ITEMS.register("dried_blueberries",
			() -> new Item(foodItem(FoodValues.DRIED_BLUEBERRIES).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> BLUEBERRIES_JUICE = ITEMS.register("blueberries_juice",
			() -> new DrinkableItem(juiceItem().food(FoodValues.BLUEBERRIES_JUICE), true, false));
	public static final RegistryObject<Item> BLUEBERRIES_WINE_BARREL = ITEMS.register("blueberries_wine_barrel",
			() -> new BlockItem(ModBlocks.BLUEBERRIES_WINE_BARREL.get(), basicItem()));
	public static final RegistryObject<Item> BLUEBERRIES_WINE_ONE = ITEMS.register("blueberries_wine_one",
			() -> new DrinkableItem(wineItem().food(FoodValues.BLUEBERRIES_WINE_ONE), true, true));
	public static final RegistryObject<Item> BLUEBERRIES_WINE_TWO = ITEMS.register("blueberries_wine_two",
			() -> new DrinkableItem(wineItem().food(FoodValues.BLUEBERRIES_WINE_TWO), true, true));
	public static final RegistryObject<Item> BLUEBERRIES_WINE_THREE = ITEMS.register("blueberries_wine_three",
			() -> new DrinkableItem(wineItem().food(FoodValues.BLUEBERRIES_WINE_THREE), true, true));
	public static final RegistryObject<Item> BLUEBERRIES_WINE_FOUR = ITEMS.register("blueberries_wine_four",
			() -> new DrinkableItem(wineItem().food(FoodValues.BLUEBERRIES_WINE_FOUR), true, true));
	public static final RegistryObject<Item> BLUEBERRIES_WINE_FIVE = ITEMS.register("blueberries_wine_five",
			() -> new DrinkableItem(wineItem().food(FoodValues.BLUEBERRIES_WINE_FIVE), true, true));
	public static final RegistryObject<Item> BLUEBERRIES_WINE_SIX = ITEMS.register("blueberries_wine_six",
			() -> new DrinkableItem(wineItem().food(FoodValues.BLUEBERRIES_WINE_SIX), true, true));
	public static final RegistryObject<Item> BLUEBERRIES_WINE_SEVEN = ITEMS.register("blueberries_wine_seven",
			() -> new DrinkableItem(wineItem().food(FoodValues.BLUEBERRIES_WINE_SEVEN), true, true));
	public static final RegistryObject<Item> BLUEBERRIES_WINE_EIGHT = ITEMS.register("blueberries_wine_eight",
			() -> new DrinkableItem(wineItem().food(FoodValues.BLUEBERRIES_WINE_EIGHT), true, true));
	public static final RegistryObject<Item> BLUEBERRIES_WINE_NINE = ITEMS.register("blueberries_wine_nine",
			() -> new DrinkableItem(wineItem().food(FoodValues.BLUEBERRIES_WINE_NINE), true, true));
	public static final RegistryObject<Item> BLUEBERRIES_WINE_TEN = ITEMS.register("blueberries_wine_ten",
			() -> new DrinkableItem(wineItem().food(FoodValues.BLUEBERRIES_WINE_TEN), true, true));
	public static final RegistryObject<Item> BEST_BLUEBERRIES_WINE = ITEMS.register("best_blueberries_wine",
			() -> new BestWineItem(wineItem(), true, true));
	public static final RegistryObject<Item> BLUEBERRIES_POPSICLE_MACHINE = ITEMS.register("blueberries_popsicle_machine",
			() -> new BlockItem(ModBlocks.BLUEBERRIES_POPSICLE_MACHINE.get(), basicItem()));
	public static final RegistryObject<Item> BLUEBERRIES_MILK_TEA = ITEMS.register("blueberries_milk_tea",
			() -> new DrinkableItem(juiceItem().food(FoodValues.BLUEBERRIES_MILK_TEA), true, false));
	//hamimelon
	public static final RegistryObject<Item> HAMIMELON_SEEDS = ITEMS.register("hamimelon_seeds",
			()-> new ItemNameBlockItem(ModBlocks.HAMIMELON_CROP.get(),new Item.Properties()
					.tab(fruitstack.CREATIVE_TAB)
			));
	public static final RegistryObject<Item> HAMIMELON = ITEMS.register("hamimelon",
			() -> new Item(foodItem(FoodValues.HAMIMELON).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> HAMIMELON_POPSICLE = ITEMS.register("hamimelon_popsicle",
			() -> new PopsicleItem(foodItem(FoodValues.HAMIMELON_POPSICLE).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> HAMIMELON_SAGO_SOUP_BLOCK = ITEMS.register("hamimelon_sago_soup_block",
			() -> new BlockItem(ModBlocks.HAMIMELON_SAGO_SOUP_BLOCK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> HAMIMELON_SAGO_SOUP = ITEMS.register("hamimelon_sago_soup",
			() -> new ConsumableItem(bowlFoodItem(FoodValues.HAMIMELON_SAGO_SOUP), true));
	public static final RegistryObject<Item> WILD_HAMIMELON = ITEMS.register("wild_hamimelon",
			() -> new BlockItem(ModBlocks.WILD_HAMIMELON.get(), basicItem()));
	public static final RegistryObject<Item> HAMIMELON_CAKE = ITEMS.register("hamimelon_cake",
			()-> new ItemNameBlockItem(ModBlocks.HAMIMELON_CAKE.get(),new Item.Properties()
					.tab(fruitstack.CREATIVE_TAB)
			));
	public static final RegistryObject<Item> HAMIMELON_CAKE_SLICE = ITEMS.register("hamimelon_cake_slice",
			() -> new Item(foodItem(FoodValues.HAMIMELON_CAKE_SLICE)));
	public static final RegistryObject<Item> HAMIMELON_CRATE = ITEMS.register("hamimelon_crate",
			() -> new BlockItem(ModBlocks.HAMIMELON_CRATE.get(), basicItem()));
	public static final RegistryObject<Item> HAMIMELON_PIE = ITEMS.register("hamimelon_pie",
			() -> new BlockItem(ModBlocks.HAMIMELON_PIE.get(), basicItem()));
	public static final RegistryObject<Item> HAMIMELON_PIE_SLICE = ITEMS.register("hamimelon_pie_slice",
			() -> new Item(foodItem(FoodValues.HAMIMELON_PIE_SLICE)));
	public static final RegistryObject<Item> HAMIMELON_COOKIE = ITEMS.register("hamimelon_cookie",
			() -> new Item(foodItem(FoodValues.HAMIMELON_COOKIE)));
	public static final RegistryObject<Item> PROSCIUTTO_CANTALOUPE = ITEMS.register("prosciutto_cantaloupe",
			() -> new Item(foodItem(FoodValues.PROSCIUTTO_CANTALOUPE)));
	public static final RegistryObject<Item> HONEY_MELON_CHICKEN_BALLS = ITEMS.register("honey_melon_chicken_balls",
			() -> new ConsumableItem(bowlFoodItem(FoodValues.HONEY_MELON_CHICKEN_BALLS), true));
	public static final RegistryObject<Item> UNFINISHED_HONEY_MELON_CHICKEN_BALLS = ITEMS.register("unfinished_honey_melon_chicken_balls",
			() -> new Item(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> SAGO_SOUP = ITEMS.register("sago_soup",
			() -> new Item(foodItem(FoodValues.SAGO_SOUP)));
	public static final RegistryObject<Item> FISH_SKIN = ITEMS.register("fish_skin",
			() -> new Item(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> HAMIMELON_JAM = ITEMS.register("hamimelon_jam",
			() -> new BlockItem(ModBlocks.HAMIMELON_JAM.get(), basicItem()));
	public static final RegistryObject<Item> HAMIMELON_BREAD = ITEMS.register("hamimelon_bread",
			() -> new Item(foodItem(FoodValues.HAMIMELON_BREAD).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> HAMIMELON_DOUGHNUT = ITEMS.register("hamimelon_doughnut",
			() -> new Item(foodItem(FoodValues.HAMIMELON_DOUGHNUT).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> SWEETENED_HAMIMELON = ITEMS.register("sweetened_hamimelon",
			() -> new BlockItem(ModBlocks.SWEETENED_HAMIMELON.get(), basicItem()));
	public static final RegistryObject<Item> DRIED_HAMIMELON = ITEMS.register("dried_hamimelon",
			() -> new Item(foodItem(FoodValues.DRIED_HAMIMELON).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> HAMIMELON_JUICE = ITEMS.register("hamimelon_juice",
			() -> new DrinkableItem(juiceItem().food(FoodValues.HAMIMELON_JUICE), true, false));
	public static final RegistryObject<Item> HAMIMELON_WINE_BARREL = ITEMS.register("hamimelon_wine_barrel",
			() -> new BlockItem(ModBlocks.HAMIMELON_WINE_BARREL.get(), basicItem()));
	public static final RegistryObject<Item> HAMIMELON_WINE_ONE = ITEMS.register("hamimelon_wine_one",
			() -> new DrinkableItem(wineItem().food(FoodValues.HAMIMELON_WINE_ONE), true, true));
	public static final RegistryObject<Item> HAMIMELON_WINE_TWO = ITEMS.register("hamimelon_wine_two",
			() -> new DrinkableItem(wineItem().food(FoodValues.HAMIMELON_WINE_TWO), true, true));
	public static final RegistryObject<Item> HAMIMELON_WINE_THREE = ITEMS.register("hamimelon_wine_three",
			() -> new DrinkableItem(wineItem().food(FoodValues.HAMIMELON_WINE_THREE), true, true));
	public static final RegistryObject<Item> HAMIMELON_WINE_FOUR = ITEMS.register("hamimelon_wine_four",
			() -> new DrinkableItem(wineItem().food(FoodValues.HAMIMELON_WINE_FOUR), true, true));
	public static final RegistryObject<Item> HAMIMELON_WINE_FIVE = ITEMS.register("hamimelon_wine_five",
			() -> new DrinkableItem(wineItem().food(FoodValues.HAMIMELON_WINE_FIVE), true, true));
	public static final RegistryObject<Item> HAMIMELON_WINE_SIX = ITEMS.register("hamimelon_wine_six",
			() -> new DrinkableItem(wineItem().food(FoodValues.HAMIMELON_WINE_SIX), true, true));
	public static final RegistryObject<Item> HAMIMELON_WINE_SEVEN = ITEMS.register("hamimelon_wine_seven",
			() -> new DrinkableItem(wineItem().food(FoodValues.HAMIMELON_WINE_SEVEN), true, true));
	public static final RegistryObject<Item> HAMIMELON_WINE_EIGHT = ITEMS.register("hamimelon_wine_eight",
			() -> new DrinkableItem(wineItem().food(FoodValues.HAMIMELON_WINE_EIGHT), true, true));
	public static final RegistryObject<Item> HAMIMELON_WINE_NINE = ITEMS.register("hamimelon_wine_nine",
			() -> new DrinkableItem(wineItem().food(FoodValues.HAMIMELON_WINE_NINE), true, true));
	public static final RegistryObject<Item> HAMIMELON_WINE_TEN = ITEMS.register("hamimelon_wine_ten",
			() -> new DrinkableItem(wineItem().food(FoodValues.HAMIMELON_WINE_TEN), true, true));
	public static final RegistryObject<Item> BEST_HAMIMELON_WINE = ITEMS.register("best_hamimelon_wine",
			() -> new BestWineItem(wineItem(), true, true));
	public static final RegistryObject<Item> HAMIMELON_POPSICLE_MACHINE = ITEMS.register("hamimelon_popsicle_machine",
			() -> new BlockItem(ModBlocks.HAMIMELON_POPSICLE_MACHINE.get(), basicItem()));
	public static final RegistryObject<Item> HAMIMELON_MILK_TEA = ITEMS.register("hamimelon_milk_tea",
			() -> new DrinkableItem(juiceItem().food(FoodValues.HAMIMELON_MILK_TEA), true, false));
	//beating melons
	public static final RegistryObject<Item> BEATING_MELONS_SEEDS = ITEMS.register("beating_melons_seeds",
			()-> new ItemNameBlockItem(ModBlocks.BEATING_MELONS_CROP.get(),new Item.Properties()
					.tab(fruitstack.CREATIVE_TAB)
			));
	public static final RegistryObject<Item> STIR_FRIED_BEATING_MELONS_SEEDS = ITEMS.register("stir_fried_beating_melons_seeds",
			() -> new BlockItem(ModBlocks.STIR_FRIED_BEATING_MELONS_SEEDS.get(), basicItem()));
	public static final RegistryObject<Item> DRIED_BEATING_MELONS_SEEDS = ITEMS.register("dried_beating_melons_seeds",
			() -> new Item(foodItem(FoodValues.DRIED_BEATING_MELONS_SEEDS).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> BEATING_MELONS = ITEMS.register("beating_melons",
			() -> new BeatingMelonsItem(foodItem(FoodValues.BEATING_MELONS).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> BEATING_MELONS_SLICE = ITEMS.register("beating_melons_slice",
			() -> new Item(foodItem(FoodValues.BEATING_MELONS_SLICE).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> BEATING_MELONS_POPSICLE = ITEMS.register("beating_melons_popsicle",
			() -> new PopsicleItem(foodItem(FoodValues.BEATING_MELONS_POPSICLE).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> BEATING_MELONS_COOKIE = ITEMS.register("beating_melons_cookie",
			() -> new Item(foodItem(FoodValues.BEATING_MELONS_COOKIE)));
	public static final RegistryObject<Item> WILD_BEATING_MELONS = ITEMS.register("wild_beating_melons",
			() -> new BlockItem(ModBlocks.WILD_BEATING_MELONS.get(), basicItem()));
	public static final RegistryObject<Item> BEATING_MELONS_CAKE = ITEMS.register("beating_melons_cake",
			()-> new ItemNameBlockItem(ModBlocks.BEATING_MELONS_CAKE.get(),new Item.Properties()
					.tab(fruitstack.CREATIVE_TAB)
			));
	public static final RegistryObject<Item> BEATING_MELONS_CAKE_SLICE = ITEMS.register("beating_melons_cake_slice",
			() -> new Item(foodItem(FoodValues.BEATING_MELONS_CAKE_SLICE)));
	public static final RegistryObject<Item> BEATING_MELONS_CRATE = ITEMS.register("beating_melons_crate",
			() -> new BlockItem(ModBlocks.BEATING_MELONS_CRATE.get(), basicItem()));
	public static final RegistryObject<Item> BEATING_MELONS_PIE = ITEMS.register("beating_melons_pie",
			() -> new BlockItem(ModBlocks.BEATING_MELONS_PIE.get(), basicItem()));
	public static final RegistryObject<Item> BEATING_MELONS_PIE_SLICE = ITEMS.register("beating_melons_pie_slice",
			() -> new Item(foodItem(FoodValues.BEATING_MELONS_PIE_SLICE)));
	public static final RegistryObject<Item> BEATING_MELONS_JAM = ITEMS.register("beating_melons_jam",
			() -> new BlockItem(ModBlocks.BEATING_MELONS_JAM.get(), basicItem()));
	public static final RegistryObject<Item> BEATING_MELONS_BREAD = ITEMS.register("beating_melons_bread",
			() -> new Item(foodItem(FoodValues.BEATING_MELONS_BREAD).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> BEATING_MELONS_DOUGHNUT = ITEMS.register("beating_melons_doughnut",
			() -> new Item(foodItem(FoodValues.BEATING_MELONS_DOUGHNUT).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> BEATING_MELONS_JUICE = ITEMS.register("beating_melons_juice",
			() -> new DrinkableItem(juiceItem().food(FoodValues.BEATING_MELONS_JUICE), true, false));
	public static final RegistryObject<Item> BEATING_MELONS_WINE_BARREL = ITEMS.register("beating_melons_wine_barrel",
			() -> new BlockItem(ModBlocks.BEATING_MELONS_WINE_BARREL.get(), basicItem()));
	public static final RegistryObject<Item> BEATING_MELONS_WINE_ONE = ITEMS.register("beating_melons_wine_one",
			() -> new DrinkableItem(wineItem().food(FoodValues.BEATING_MELONS_WINE_ONE), true, true));
	public static final RegistryObject<Item> BEATING_MELONS_WINE_TWO = ITEMS.register("beating_melons_wine_two",
			() -> new DrinkableItem(wineItem().food(FoodValues.BEATING_MELONS_WINE_TWO), true, true));
	public static final RegistryObject<Item> BEATING_MELONS_WINE_THREE = ITEMS.register("beating_melons_wine_three",
			() -> new DrinkableItem(wineItem().food(FoodValues.BEATING_MELONS_WINE_THREE), true, true));
	public static final RegistryObject<Item> BEATING_MELONS_WINE_FOUR = ITEMS.register("beating_melons_wine_four",
			() -> new DrinkableItem(wineItem().food(FoodValues.BEATING_MELONS_WINE_FOUR), true, true));
	public static final RegistryObject<Item> BEATING_MELONS_WINE_FIVE = ITEMS.register("beating_melons_wine_five",
			() -> new DrinkableItem(wineItem().food(FoodValues.BEATING_MELONS_WINE_FIVE), true, true));
	public static final RegistryObject<Item> BEATING_MELONS_WINE_SIX = ITEMS.register("beating_melons_wine_six",
			() -> new DrinkableItem(wineItem().food(FoodValues.BEATING_MELONS_WINE_SIX), true, true));
	public static final RegistryObject<Item> BEATING_MELONS_WINE_SEVEN = ITEMS.register("beating_melons_wine_seven",
			() -> new DrinkableItem(wineItem().food(FoodValues.BEATING_MELONS_WINE_SEVEN), true, true));
	public static final RegistryObject<Item> BEATING_MELONS_WINE_EIGHT = ITEMS.register("beating_melons_wine_eight",
			() -> new DrinkableItem(wineItem().food(FoodValues.BEATING_MELONS_WINE_EIGHT), true, true));
	public static final RegistryObject<Item> BEATING_MELONS_WINE_NINE = ITEMS.register("beating_melons_wine_nine",
			() -> new DrinkableItem(wineItem().food(FoodValues.BEATING_MELONS_WINE_NINE), true, true));
	public static final RegistryObject<Item> BEATING_MELONS_WINE_TEN = ITEMS.register("beating_melons_wine_ten",
			() -> new DrinkableItem(wineItem().food(FoodValues.BEATING_MELONS_WINE_TEN), true, true));
	public static final RegistryObject<Item> BEST_BEATING_MELONS_WINE = ITEMS.register("best_beating_melons_wine",
			() -> new BestWineItem(wineItem(), true, true));
	public static final RegistryObject<Item> BEATING_MELONS_POPSICLE_MACHINE = ITEMS.register("beating_melons_popsicle_machine",
			() -> new BlockItem(ModBlocks.BEATING_MELONS_POPSICLE_MACHINE.get(), basicItem()));
	public static final RegistryObject<Item> BEATING_MELONS_MILK_TEA = ITEMS.register("beating_melons_milk_tea",
			() -> new DrinkableItem(juiceItem().food(FoodValues.BEATING_MELONS_MILK_TEA), true, false));
	//ground cucumber
	public static final RegistryObject<Item> GROUND_CUCUMBER_SEEDS = ITEMS.register("ground_cucumber_seeds",
			()-> new ItemNameBlockItem(ModBlocks.GROUND_CUCUMBER_CROP.get(),new Item.Properties()
					.tab(fruitstack.CREATIVE_TAB)
			));
	public static final RegistryObject<Item> GROUND_CUCUMBER = ITEMS.register("ground_cucumber",
			() -> new BlockItem(ModBlocks.GROUND_CUCUMBER.get(), basicItem().stacksTo(64)));
	public static final RegistryObject<Item> GROUND_CUCUMBER_POPSICLE = ITEMS.register("ground_cucumber_popsicle",
			() -> new PopsicleItem(foodItem(FoodValues.GROUND_CUCUMBER_POPSICLE).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> GROUND_CUCUMBER_SLICE = ITEMS.register("ground_cucumber_slice",
			() -> new Item(foodItem(FoodValues.GROUND_CUCUMBER_SLICE).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> WILD_GROUND_CUCUMBER = ITEMS.register("wild_ground_cucumber",
			() -> new BlockItem(ModBlocks.WILD_GROUND_CUCUMBER.get(), basicItem()));
	public static final RegistryObject<Item> GROUND_CUCUMBER_CAKE = ITEMS.register("ground_cucumber_cake",
			()-> new ItemNameBlockItem(ModBlocks.GROUND_CUCUMBER_CAKE.get(),new Item.Properties()
					.tab(fruitstack.CREATIVE_TAB)
			));
	public static final RegistryObject<Item> GROUND_CUCUMBER_PIE = ITEMS.register("ground_cucumber_pie",
			() -> new BlockItem(ModBlocks.GROUND_CUCUMBER_PIE.get(), basicItem()));
	public static final RegistryObject<Item> GROUND_CUCUMBER_PIE_SLICE = ITEMS.register("ground_cucumber_pie_slice",
			() -> new Item(foodItem(FoodValues.GROUND_CUCUMBER_PIE_SLICE)));
	public static final RegistryObject<Item> GROUND_CUCUMBER_CAKE_SLICE = ITEMS.register("ground_cucumber_cake_slice",
			() -> new Item(foodItem(FoodValues.GROUND_CUCUMBER_CAKE_SLICE)));
	public static final RegistryObject<Item> GROUND_CUCUMBER_CRATE = ITEMS.register("ground_cucumber_crate",
			() -> new BlockItem(ModBlocks.GROUND_CUCUMBER_CRATE.get(), basicItem()));
	public static final RegistryObject<Item> GROUND_CUCUMBER_COOKIE = ITEMS.register("ground_cucumber_cookie",
			() -> new Item(foodItem(FoodValues.GROUND_CUCUMBER_COOKIE)));
	public static final RegistryObject<Item> GROUND_CUCUMBER_JAM = ITEMS.register("ground_cucumber_jam",
			() -> new BlockItem(ModBlocks.GROUND_CUCUMBER_JAM.get(), basicItem()));
	public static final RegistryObject<Item> GROUND_CUCUMBER_BREAD = ITEMS.register("ground_cucumber_bread",
			() -> new Item(foodItem(FoodValues.GROUND_CUCUMBER_BREAD).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> GROUND_CUCUMBER_DOUGHNUT = ITEMS.register("ground_cucumber_doughnut",
			() -> new Item(foodItem(FoodValues.GROUND_CUCUMBER_DOUGHNUT).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> GROUND_CUCUMBER_JUICE = ITEMS.register("ground_cucumber_juice",
			() -> new DrinkableItem(juiceItem().food(FoodValues.GROUND_CUCUMBER_JUICE), true, false));
	public static final RegistryObject<Item> GROUND_CUCUMBER_WINE_BARREL = ITEMS.register("ground_cucumber_wine_barrel",
			() -> new BlockItem(ModBlocks.GROUND_CUCUMBER_WINE_BARREL.get(), basicItem()));
	public static final RegistryObject<Item> GROUND_CUCUMBER_WINE_ONE = ITEMS.register("ground_cucumber_wine_one",
			() -> new DrinkableItem(wineItem().food(FoodValues.GROUND_CUCUMBER_WINE_ONE), true, true));
	public static final RegistryObject<Item> GROUND_CUCUMBER_WINE_TWO = ITEMS.register("ground_cucumber_wine_two",
			() -> new DrinkableItem(wineItem().food(FoodValues.GROUND_CUCUMBER_WINE_TWO), true, true));
	public static final RegistryObject<Item> GROUND_CUCUMBER_WINE_THREE = ITEMS.register("ground_cucumber_wine_three",
			() -> new DrinkableItem(wineItem().food(FoodValues.GROUND_CUCUMBER_WINE_THREE), true, true));
	public static final RegistryObject<Item> GROUND_CUCUMBER_WINE_FOUR = ITEMS.register("ground_cucumber_wine_four",
			() -> new DrinkableItem(wineItem().food(FoodValues.GROUND_CUCUMBER_WINE_FOUR), true, true));
	public static final RegistryObject<Item> GROUND_CUCUMBER_WINE_FIVE = ITEMS.register("ground_cucumber_wine_five",
			() -> new DrinkableItem(wineItem().food(FoodValues.GROUND_CUCUMBER_WINE_FIVE), true, true));
	public static final RegistryObject<Item> GROUND_CUCUMBER_WINE_SIX = ITEMS.register("ground_cucumber_wine_six",
			() -> new DrinkableItem(wineItem().food(FoodValues.GROUND_CUCUMBER_WINE_SIX), true, true));
	public static final RegistryObject<Item> GROUND_CUCUMBER_WINE_SEVEN = ITEMS.register("ground_cucumber_wine_seven",
			() -> new DrinkableItem(wineItem().food(FoodValues.GROUND_CUCUMBER_WINE_SEVEN), true, true));
	public static final RegistryObject<Item> GROUND_CUCUMBER_WINE_EIGHT = ITEMS.register("ground_cucumber_wine_eight",
			() -> new DrinkableItem(wineItem().food(FoodValues.GROUND_CUCUMBER_WINE_EIGHT), true, true));
	public static final RegistryObject<Item> GROUND_CUCUMBER_WINE_NINE = ITEMS.register("ground_cucumber_wine_nine",
			() -> new DrinkableItem(wineItem().food(FoodValues.GROUND_CUCUMBER_WINE_NINE), true, true));
	public static final RegistryObject<Item> GROUND_CUCUMBER_WINE_TEN = ITEMS.register("ground_cucumber_wine_ten",
			() -> new DrinkableItem(wineItem().food(FoodValues.GROUND_CUCUMBER_WINE_TEN), true, true));
	public static final RegistryObject<Item> BEST_GROUND_CUCUMBER_WINE = ITEMS.register("best_ground_cucumber_wine",
			() -> new BestWineItem(wineItem(), true, true));
	public static final RegistryObject<Item> GROUND_CUCUMBER_POPSICLE_MACHINE = ITEMS.register("ground_cucumber_popsicle_machine",
			() -> new BlockItem(ModBlocks.GROUND_CUCUMBER_POPSICLE_MACHINE.get(), basicItem()));
	public static final RegistryObject<Item> GROUND_CUCUMBER_MILK_TEA = ITEMS.register("ground_cucumber_milk_tea",
			() -> new DrinkableItem(juiceItem().food(FoodValues.GROUND_CUCUMBER_MILK_TEA), true, false));
	//mango
	public static final RegistryObject<Item> MANGO_BLOCK = ITEMS.register("mango_block",
			() -> new BlockItem(ModBlocks.MANGO_BLOCK.get(), basicItem().stacksTo(64)));
	public static final RegistryObject<Item> MANGO_SLICE = ITEMS.register("mango_slice",
			() -> new Item(foodItem(FoodValues.MANGO_SLICE).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> GREEN_MANGO_BLOCK = ITEMS.register("green_mango_block",
			() -> new BlockItem(ModBlocks.GREEN_MANGO_BLOCK.get(), basicItem().stacksTo(64)));
	public static final RegistryObject<Item> GREEN_MANGO_SLICE = ITEMS.register("green_mango_slice",
			() -> new Item(foodItem(FoodValues.GREEN_MANGO_SLICE).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> MANGO_SEEDS = ITEMS.register("mango_seeds",
			() -> new Item(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> MANGO_SAPLING = ITEMS.register("mango_sapling",
			() -> new BlockItem(ModBlocks.MANGO_SAPLING.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> MANGO_POPSICLE = ITEMS.register("mango_popsicle",
			() -> new PopsicleItem(foodItem(FoodValues.MANGO_POPSICLE).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> MANGO_CAKE = ITEMS.register("mango_cake",
			()-> new ItemNameBlockItem(ModBlocks.MANGO_CAKE.get(),new Item.Properties()
					.tab(fruitstack.CREATIVE_TAB)
			));
	public static final RegistryObject<Item> MANGO_PIE = ITEMS.register("mango_pie",
			() -> new BlockItem(ModBlocks.MANGO_PIE.get(), basicItem()));
	public static final RegistryObject<Item> MANGO_PIE_SLICE = ITEMS.register("mango_pie_slice",
			() -> new Item(foodItem(FoodValues.MANGO_PIE_SLICE)));
	public static final RegistryObject<Item> MANGO_CAKE_SLICE = ITEMS.register("mango_cake_slice",
			() -> new Item(foodItem(FoodValues.MANGO_CAKE_SLICE)));
	public static final RegistryObject<Item> MANGO_CRATE = ITEMS.register("mango_crate",
			() -> new BlockItem(ModBlocks.MANGO_CRATE.get(), basicItem()));
	public static final RegistryObject<Item> MANGO_COOKIE = ITEMS.register("mango_cookie",
			() -> new Item(foodItem(FoodValues.MANGO_COOKIE)));
	public static final RegistryObject<Item> MANGO_JAM = ITEMS.register("mango_jam",
			() -> new BlockItem(ModBlocks.MANGO_JAM.get(), basicItem()));
	public static final RegistryObject<Item> MANGO_BREAD = ITEMS.register("mango_bread",
			() -> new Item(foodItem(FoodValues.MANGO_BREAD).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> MANGO_DOUGHNUT = ITEMS.register("mango_doughnut",
			() -> new Item(foodItem(FoodValues.MANGO_DOUGHNUT).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> SWEETENED_MANGO = ITEMS.register("sweetened_mango",
			() -> new BlockItem(ModBlocks.SWEETENED_MANGO.get(), basicItem()));
	public static final RegistryObject<Item> DRIED_MANGO = ITEMS.register("dried_mango",
			() -> new Item(foodItem(FoodValues.DRIED_MANGO).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> MANGO_JUICE = ITEMS.register("mango_juice",
			() -> new DrinkableItem(juiceItem().food(FoodValues.MANGO_JUICE), true, false));
	public static final RegistryObject<Item> MANGO_MILK_ICE_CREAM = ITEMS.register("mango_milk_ice_cream",
			() -> new PopsicleItem(foodItem(FoodValues.MANGO_MILK_ICE_CREAM).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> MANGO_WINE_BARREL = ITEMS.register("mango_wine_barrel",
			() -> new BlockItem(ModBlocks.MANGO_WINE_BARREL.get(), basicItem()));
	public static final RegistryObject<Item> MANGO_WINE_ONE = ITEMS.register("mango_wine_one",
			() -> new DrinkableItem(wineItem().food(FoodValues.MANGO_WINE_ONE), true, true));
	public static final RegistryObject<Item> MANGO_WINE_TWO = ITEMS.register("mango_wine_two",
			() -> new DrinkableItem(wineItem().food(FoodValues.MANGO_WINE_TWO), true, true));
	public static final RegistryObject<Item> MANGO_WINE_THREE = ITEMS.register("mango_wine_three",
			() -> new DrinkableItem(wineItem().food(FoodValues.MANGO_WINE_THREE), true, true));
	public static final RegistryObject<Item> MANGO_WINE_FOUR = ITEMS.register("mango_wine_four",
			() -> new DrinkableItem(wineItem().food(FoodValues.MANGO_WINE_FOUR), true, true));
	public static final RegistryObject<Item> MANGO_WINE_FIVE = ITEMS.register("mango_wine_five",
			() -> new DrinkableItem(wineItem().food(FoodValues.MANGO_WINE_FIVE), true, true));
	public static final RegistryObject<Item> MANGO_WINE_SIX = ITEMS.register("mango_wine_six",
			() -> new DrinkableItem(wineItem().food(FoodValues.MANGO_WINE_SIX), true, true));
	public static final RegistryObject<Item> MANGO_WINE_SEVEN = ITEMS.register("mango_wine_seven",
			() -> new DrinkableItem(wineItem().food(FoodValues.MANGO_WINE_SEVEN), true, true));
	public static final RegistryObject<Item> MANGO_WINE_EIGHT = ITEMS.register("mango_wine_eight",
			() -> new DrinkableItem(wineItem().food(FoodValues.MANGO_WINE_EIGHT), true, true));
	public static final RegistryObject<Item> MANGO_WINE_NINE = ITEMS.register("mango_wine_nine",
			() -> new DrinkableItem(wineItem().food(FoodValues.MANGO_WINE_NINE), true, true));
	public static final RegistryObject<Item> MANGO_WINE_TEN = ITEMS.register("mango_wine_ten",
			() -> new DrinkableItem(wineItem().food(FoodValues.MANGO_WINE_TEN), true, true));
	public static final RegistryObject<Item> BEST_MANGO_WINE = ITEMS.register("best_mango_wine",
			() -> new BestWineItem(wineItem(), true, true));
	public static final RegistryObject<Item> MANGO_LANTERN = ITEMS.register("mango_lantern",
			() -> new BlockItem(ModBlocks.MANGO_LANTERN.get(), basicItem()));
	public static final RegistryObject<Item> MANGO_POPSICLE_MACHINE = ITEMS.register("mango_popsicle_machine",
			() -> new BlockItem(ModBlocks.MANGO_POPSICLE_MACHINE.get(), basicItem()));
	public static final RegistryObject<Item> MANGO_MILK_TEA = ITEMS.register("mango_milk_tea",
			() -> new DrinkableItem(juiceItem().food(FoodValues.MANGO_MILK_TEA), true, false));
	//holboellia latifolia
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_SEEDS = ITEMS.register("holboellia_latifolia_seeds",
			() -> new ItemNameBlockItem(ModBlocks.HOLBOELLIA_LATIFOLIA_CROP.get(),new Item.Properties()
					.tab(fruitstack.CREATIVE_TAB)
			));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA = ITEMS.register("holboellia_latifolia",
			() -> new BlockItem(ModBlocks.HOLBOELLIA_LATIFOLIA.get(), basicItem().stacksTo(64)));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_SLICE = ITEMS.register("holboellia_latifolia_slice",
			() -> new Item(foodItem(FoodValues.HOLBOELLIA_LATIFOLIA_SLICE).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_POPSICLE = ITEMS.register("holboellia_latifolia_popsicle",
			() -> new PopsicleItem(foodItem(FoodValues.HOLBOELLIA_LATIFOLIA_POPSICLE).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> ONION_TOMATO_HOLBOELLIA_LATIFOLIA = ITEMS.register("onion_tomato_holboellia_latifolia",
			() -> new ConsumableItem(bowlFoodItem(FoodValues.ONION_TOMATO_HOLBOELLIA_LATIFOLIA), true));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_EGG_MILK_PUDDING = ITEMS.register("holboellia_latifolia_egg_milk_pudding",
			() -> new BlockItem(ModBlocks.HOLBOELLIA_LATIFOLIA_EGG_MILK_PUDDING.get(), basicItem()));
	public static final RegistryObject<Item> WILD_HOLBOELLIA_LATIFOLIA = ITEMS.register("wild_holboellia_latifolia",
			() -> new BlockItem(ModBlocks.WILD_HOLBOELLIA_LATIFOLIA.get(), basicItem()));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_CAKE = ITEMS.register("holboellia_latifolia_cake",
			()-> new ItemNameBlockItem(ModBlocks.HOLBOELLIA_LATIFOLIA_CAKE.get(),new Item.Properties()
					.tab(fruitstack.CREATIVE_TAB)
			));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_CAKE_SLICE = ITEMS.register("holboellia_latifolia_cake_slice",
			() -> new Item(foodItem(FoodValues.HOLBOELLIA_LATIFOLIA_CAKE_SLICE)));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_CRATE = ITEMS.register("holboellia_latifolia_crate",
			() -> new BlockItem(ModBlocks.HOLBOELLIA_LATIFOLIA_CRATE.get(), basicItem()));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_PIE = ITEMS.register("holboellia_latifolia_pie",
			() -> new BlockItem(ModBlocks.HOLBOELLIA_LATIFOLIA_PIE.get(), basicItem()));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_PIE_SLICE = ITEMS.register("holboellia_latifolia_pie_slice",
			() -> new Item(foodItem(FoodValues.HOLBOELLIA_LATIFOLIA_PIE_SLICE)));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_COOKIE = ITEMS.register("holboellia_latifolia_cookie",
			() -> new Item(foodItem(FoodValues.HOLBOELLIA_LATIFOLIA_COOKIE)));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_JAM = ITEMS.register("holboellia_latifolia_jam",
			() -> new BlockItem(ModBlocks.HOLBOELLIA_LATIFOLIA_JAM.get(), basicItem()));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_BREAD = ITEMS.register("holboellia_latifolia_bread",
			() -> new Item(foodItem(FoodValues.HOLBOELLIA_LATIFOLIA_BREAD).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_DOUGHNUT = ITEMS.register("holboellia_latifolia_doughnut",
			() -> new Item(foodItem(FoodValues.HOLBOELLIA_LATIFOLIA_DOUGHNUT).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_JUICE = ITEMS.register("holboellia_latifolia_juice",
			() -> new DrinkableItem(juiceItem().food(FoodValues.HOLBOELLIA_LATIFOLIA_JUICE), true, false));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_WINE_BARREL = ITEMS.register("holboellia_latifolia_wine_barrel",
			() -> new BlockItem(ModBlocks.HOLBOELLIA_LATIFOLIA_WINE_BARREL.get(), basicItem()));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_WINE_ONE = ITEMS.register("holboellia_latifolia_wine_one",
			() -> new DrinkableItem(wineItem().food(FoodValues.HOLBOELLIA_LATIFOLIA_WINE_ONE), true, true));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_WINE_TWO = ITEMS.register("holboellia_latifolia_wine_two",
			() -> new DrinkableItem(wineItem().food(FoodValues.HOLBOELLIA_LATIFOLIA_WINE_TWO), true, true));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_WINE_THREE = ITEMS.register("holboellia_latifolia_wine_three",
			() -> new DrinkableItem(wineItem().food(FoodValues.HOLBOELLIA_LATIFOLIA_WINE_THREE), true, true));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_WINE_FOUR = ITEMS.register("holboellia_latifolia_wine_four",
			() -> new DrinkableItem(wineItem().food(FoodValues.HOLBOELLIA_LATIFOLIA_WINE_FOUR), true, true));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_WINE_FIVE = ITEMS.register("holboellia_latifolia_wine_five",
			() -> new DrinkableItem(wineItem().food(FoodValues.HOLBOELLIA_LATIFOLIA_WINE_FIVE), true, true));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_WINE_SIX = ITEMS.register("holboellia_latifolia_wine_six",
			() -> new DrinkableItem(wineItem().food(FoodValues.HOLBOELLIA_LATIFOLIA_WINE_SIX), true, true));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_WINE_SEVEN = ITEMS.register("holboellia_latifolia_wine_seven",
			() -> new DrinkableItem(wineItem().food(FoodValues.HOLBOELLIA_LATIFOLIA_WINE_SEVEN), true, true));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_WINE_EIGHT = ITEMS.register("holboellia_latifolia_wine_eight",
			() -> new DrinkableItem(wineItem().food(FoodValues.HOLBOELLIA_LATIFOLIA_WINE_EIGHT), true, true));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_WINE_NINE = ITEMS.register("holboellia_latifolia_wine_nine",
			() -> new DrinkableItem(wineItem().food(FoodValues.HOLBOELLIA_LATIFOLIA_WINE_NINE), true, true));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_WINE_TEN = ITEMS.register("holboellia_latifolia_wine_ten",
			() -> new DrinkableItem(wineItem().food(FoodValues.HOLBOELLIA_LATIFOLIA_WINE_TEN), true, true));
	public static final RegistryObject<Item> BEST_HOLBOELLIA_LATIFOLIA_WINE = ITEMS.register("best_holboellia_latifolia_wine",
			() -> new BestWineItem(wineItem(), true, true));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_POPSICLE_MACHINE = ITEMS.register("holboellia_latifolia_popsicle_machine",
			() -> new BlockItem(ModBlocks.HOLBOELLIA_LATIFOLIA_POPSICLE_MACHINE.get(), basicItem()));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_MILK_TEA = ITEMS.register("holboellia_latifolia_milk_tea",
			() -> new DrinkableItem(juiceItem().food(FoodValues.HOLBOELLIA_LATIFOLIA_MILK_TEA), true, false));
	//litchi
	public static final RegistryObject<Item> LITCHI_SAPLING = ITEMS.register("litchi_sapling",
			() -> new BlockItem(ModBlocks.LITCHI_SAPLING.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> LITCHI_BLOCK = ITEMS.register("litchi_block",
			() -> new BlockItem(ModBlocks.LITCHI_BLOCK.get(), basicItem().stacksTo(64)));
	public static final RegistryObject<Item> LITCHI_SEEDS = ITEMS.register("litchi_seeds",
			() -> new Item(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> LITCHI_SLICE = ITEMS.register("litchi_slice",
			() -> new Item(foodItem(FoodValues.LITCHI_SLICE).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> LITCHI_POPSICLE = ITEMS.register("litchi_popsicle",
			() -> new PopsicleItem(foodItem(FoodValues.LITCHI_POPSICLE).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> LITCHI_CAKE = ITEMS.register("litchi_cake",
			()-> new ItemNameBlockItem(ModBlocks.LITCHI_CAKE.get(),new Item.Properties()
					.tab(fruitstack.CREATIVE_TAB)
			));
	public static final RegistryObject<Item> LITCHI_CAKE_SLICE = ITEMS.register("litchi_cake_slice",
			() -> new Item(foodItem(FoodValues.LITCHI_CAKE_SLICE)));
	public static final RegistryObject<Item> LITCHI_CRATE = ITEMS.register("litchi_crate",
			() -> new BlockItem(ModBlocks.LITCHI_CRATE.get(), basicItem()));
	public static final RegistryObject<Item> LITCHI_PIE = ITEMS.register("litchi_pie",
			() -> new BlockItem(ModBlocks.LITCHI_PIE.get(), basicItem()));
	public static final RegistryObject<Item> LITCHI_PIE_SLICE = ITEMS.register("litchi_pie_slice",
			() -> new Item(foodItem(FoodValues.LITCHI_PIE_SLICE)));
	public static final RegistryObject<Item> LITCHI_COOKIE = ITEMS.register("litchi_cookie",
			() -> new Item(foodItem(FoodValues.LITCHI_COOKIE)));
	public static final RegistryObject<Item> LITCHI_RIVER_NOODLES = ITEMS.register("litchi_river_noodles",
			() -> new Item(foodItem(FoodValues.LITCHI_RIVER_NOODLES).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> LITCHI_RIVER_DOUGH = ITEMS.register("litchi_river_dough",
			() -> new BlockItem(ModBlocks.LITCHI_RIVER_DOUGH.get(), basicItem()));
	public static final RegistryObject<Item> UNFORMED_LITCHI_RIVER_DOUGH = ITEMS.register("unformed_litchi_river_dough",
			() -> new BlockItem(ModBlocks.UNFORMED_LITCHI_RIVER_DOUGH.get(), basicItem()));
	public static final RegistryObject<Item> CRISPY_LITCHI_BALL = ITEMS.register("crispy_litchi_ball",
			() -> new ConsumableItem(bowlFoodItem(FoodValues.CRISPY_LITCHI_BALL), true));
	public static final RegistryObject<Item> LITCHI_BALL = ITEMS.register("litchi_ball",
			() -> new Item(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> BOWLED_LITCHI_RIVER_NOODLES = ITEMS.register("bowled_litchi_river_noodles",
			() -> new BlockItem(ModBlocks.BOWLED_LITCHI_RIVER_NOODLES.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> LITCHI_ICE_CREAM = ITEMS.register("litchi_ice_cream",
			() -> new ConsumableItem(bowlFoodItem(FoodValues.LITCHI_ICE_CREAM), true));
	public static final RegistryObject<Item> LITCHI_JAM = ITEMS.register("litchi_jam",
			() -> new BlockItem(ModBlocks.LITCHI_JAM.get(), basicItem()));
	public static final RegistryObject<Item> LITCHI_BREAD = ITEMS.register("litchi_bread",
			() -> new Item(foodItem(FoodValues.LITCHI_BREAD).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> LITCHI_DOUGHNUT = ITEMS.register("litchi_doughnut",
			() -> new Item(foodItem(FoodValues.LITCHI_DOUGHNUT).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> SWEETENED_LITCHI = ITEMS.register("sweetened_litchi",
			() -> new BlockItem(ModBlocks.SWEETENED_LITCHI.get(), basicItem()));
	public static final RegistryObject<Item> DRIED_LITCHI = ITEMS.register("dried_litchi",
			() -> new Item(foodItem(FoodValues.DRIED_LITCHI).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> LITCHI_JUICE = ITEMS.register("litchi_juice",
			() -> new DrinkableItem(juiceItem().food(FoodValues.LITCHI_JUICE), true, false));
	public static final RegistryObject<Item> LITCHI_WINE_BARREL = ITEMS.register("litchi_wine_barrel",
			() -> new BlockItem(ModBlocks.LITCHI_WINE_BARREL.get(), basicItem()));
	public static final RegistryObject<Item> LITCHI_WINE_ONE = ITEMS.register("litchi_wine_one",
			() -> new DrinkableItem(wineItem().food(FoodValues.LITCHI_WINE_ONE), true, true));
	public static final RegistryObject<Item> LITCHI_WINE_TWO = ITEMS.register("litchi_wine_two",
			() -> new DrinkableItem(wineItem().food(FoodValues.LITCHI_WINE_TWO), true, true));
	public static final RegistryObject<Item> LITCHI_WINE_THREE = ITEMS.register("litchi_wine_three",
			() -> new DrinkableItem(wineItem().food(FoodValues.LITCHI_WINE_THREE), true, true));
	public static final RegistryObject<Item> LITCHI_WINE_FOUR = ITEMS.register("litchi_wine_four",
			() -> new DrinkableItem(wineItem().food(FoodValues.LITCHI_WINE_FOUR), true, true));
	public static final RegistryObject<Item> LITCHI_WINE_FIVE = ITEMS.register("litchi_wine_five",
			() -> new DrinkableItem(wineItem().food(FoodValues.LITCHI_WINE_FIVE), true, true));
	public static final RegistryObject<Item> LITCHI_WINE_SIX = ITEMS.register("litchi_wine_six",
			() -> new DrinkableItem(wineItem().food(FoodValues.LITCHI_WINE_SIX), true, true));
	public static final RegistryObject<Item> LITCHI_WINE_SEVEN = ITEMS.register("litchi_wine_seven",
			() -> new DrinkableItem(wineItem().food(FoodValues.LITCHI_WINE_SEVEN), true, true));
	public static final RegistryObject<Item> LITCHI_WINE_EIGHT = ITEMS.register("litchi_wine_eight",
			() -> new DrinkableItem(wineItem().food(FoodValues.LITCHI_WINE_EIGHT), true, true));
	public static final RegistryObject<Item> LITCHI_WINE_NINE = ITEMS.register("litchi_wine_nine",
			() -> new DrinkableItem(wineItem().food(FoodValues.LITCHI_WINE_NINE), true, true));
	public static final RegistryObject<Item> LITCHI_WINE_TEN = ITEMS.register("litchi_wine_ten",
			() -> new DrinkableItem(wineItem().food(FoodValues.LITCHI_WINE_TEN), true, true));
	public static final RegistryObject<Item> BEST_LITCHI_WINE = ITEMS.register("best_litchi_wine",
			() -> new BestWineItem(wineItem(), true, true));
	public static final RegistryObject<Item> LITCHI_POPSICLE_MACHINE = ITEMS.register("litchi_popsicle_machine",
			() -> new BlockItem(ModBlocks.LITCHI_POPSICLE_MACHINE.get(), basicItem()));
	public static final RegistryObject<Item> LITCHI_MILK_TEA = ITEMS.register("litchi_milk_tea",
			() -> new DrinkableItem(juiceItem().food(FoodValues.LITCHI_MILK_TEA), true, false));
	//apple
	public static final RegistryObject<Item> APPLE_SAPLING = ITEMS.register("apple_sapling",
			() -> new BlockItem(ModBlocks.APPLE_SAPLING.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	//black tea
	public static final RegistryObject<Item> BLACK_TEA_LOG_BIG = ITEMS.register("black_tea_log_big",
			() -> new BlockItem(ModBlocks.BLACK_TEA_LOG_BIG.get(), basicItem()));
	public static final RegistryObject<Item> BLACK_TEA_LEAVES_ITEM = ITEMS.register("black_tea_leaves_item",
			() -> new Item(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> WILD_BLACK_TEA_LEAVES = ITEMS.register("wild_black_tea_leaves",
			() -> new BlockItem(ModBlocks.WILD_BLACK_TEA_LEAVES.get(), basicItem()));
	public static final RegistryObject<Item> BLACK_TEA_LEAVES_BAG = ITEMS.register("black_tea_leaves_bag",
			() -> new BlockItem(ModBlocks.BLACK_TEA_LEAVES_BAG.get(), basicItem()));
	//sugar_cane
	public static final RegistryObject<Item> SUGAR_CANE_BUNDLE = ITEMS.register("sugar_cane_bundle",
			() -> new BlockItem(ModBlocks.SUGAR_CANE_BUNDLE.get(), basicItem()));
	//huoshen fruit
	public static final RegistryObject<Item> HUOSHEN_FRUIT_SEEDS = ITEMS.register("huoshen_fruit_seeds",
			() -> new ItemNameBlockItem(ModBlocks.HUOSHEN_FRUIT_CROP.get(),new Item.Properties()
					.tab(fruitstack.CREATIVE_TAB)
			));
	public static final RegistryObject<Item> HUOSHEN_FRUIT = ITEMS.register("huoshen_fruit",
			() -> new BlockItem(ModBlocks.HUOSHEN_FRUIT.get(), basicItem().stacksTo(64)));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_SLICE = ITEMS.register("huoshen_fruit_slice",
			() -> new Item(foodItem(FoodValues.HUOSHEN_FRUIT_SLICE).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_POPSICLE = ITEMS.register("huoshen_fruit_popsicle",
			() -> new PopsicleItem(foodItem(FoodValues.HUOSHEN_FRUIT_POPSICLE).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> WILD_HUOSHEN_FRUIT = ITEMS.register("wild_huoshen_fruit",
			() -> new BlockItem(ModBlocks.WILD_HUOSHEN_FRUIT.get(), basicItem()));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_CAKE = ITEMS.register("huoshen_fruit_cake",
			()-> new ItemNameBlockItem(ModBlocks.HUOSHEN_FRUIT_CAKE.get(),new Item.Properties()
					.tab(fruitstack.CREATIVE_TAB)
			));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_CAKE_SLICE = ITEMS.register("huoshen_fruit_cake_slice",
			() -> new Item(foodItem(FoodValues.HUOSHEN_FRUIT_CAKE_SLICE)));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_CRATE = ITEMS.register("huoshen_fruit_crate",
			() -> new BlockItem(ModBlocks.HUOSHEN_FRUIT_CRATE.get(), basicItem()));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_PIE = ITEMS.register("huoshen_fruit_pie",
			() -> new BlockItem(ModBlocks.HUOSHEN_FRUIT_PIE.get(), basicItem()));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_PIE_SLICE = ITEMS.register("huoshen_fruit_pie_slice",
			() -> new Item(foodItem(FoodValues.HUOSHEN_FRUIT_PIE_SLICE)));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_COOKIE = ITEMS.register("huoshen_fruit_cookie",
			() -> new Item(foodItem(FoodValues.HUOSHEN_FRUIT_COOKIE)));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_HONEY_SAUCE = ITEMS.register("huoshen_fruit_honey_sauce",
			() -> new BlockItem(ModBlocks.HUOSHEN_FRUIT_HONEY_SAUCE.get(), basicItem()));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_JAM = ITEMS.register("huoshen_fruit_jam",
			() -> new BlockItem(ModBlocks.HUOSHEN_FRUIT_JAM.get(), basicItem()));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_BREAD = ITEMS.register("huoshen_fruit_bread",
			() -> new Item(foodItem(FoodValues.HUOSHEN_FRUIT_BREAD).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_DOUGHNUT = ITEMS.register("huoshen_fruit_doughnut",
			() -> new Item(foodItem(FoodValues.HUOSHEN_FRUIT_DOUGHNUT).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_JUICE = ITEMS.register("huoshen_fruit_juice",
			() -> new DrinkableItem(juiceItem().food(FoodValues.HUOSHEN_FRUIT_JUICE), true, false));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_WINE_BARREL = ITEMS.register("huoshen_fruit_wine_barrel",
			() -> new BlockItem(ModBlocks.HUOSHEN_FRUIT_WINE_BARREL.get(), basicItem()));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_WINE_ONE = ITEMS.register("huoshen_fruit_wine_one",
			() -> new DrinkableItem(wineItem().food(FoodValues.HUOSHEN_FRUIT_WINE_ONE), true, true));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_WINE_TWO = ITEMS.register("huoshen_fruit_wine_two",
			() -> new DrinkableItem(wineItem().food(FoodValues.HUOSHEN_FRUIT_WINE_TWO), true, true));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_WINE_THREE = ITEMS.register("huoshen_fruit_wine_three",
			() -> new DrinkableItem(wineItem().food(FoodValues.HUOSHEN_FRUIT_WINE_THREE), true, true));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_WINE_FOUR = ITEMS.register("huoshen_fruit_wine_four",
			() -> new DrinkableItem(wineItem().food(FoodValues.HUOSHEN_FRUIT_WINE_FOUR), true, true));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_WINE_FIVE = ITEMS.register("huoshen_fruit_wine_five",
			() -> new DrinkableItem(wineItem().food(FoodValues.HUOSHEN_FRUIT_WINE_FIVE), true, true));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_WINE_SIX = ITEMS.register("huoshen_fruit_wine_six",
			() -> new DrinkableItem(wineItem().food(FoodValues.HUOSHEN_FRUIT_WINE_SIX), true, true));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_WINE_SEVEN = ITEMS.register("huoshen_fruit_wine_seven",
			() -> new DrinkableItem(wineItem().food(FoodValues.HUOSHEN_FRUIT_WINE_SEVEN), true, true));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_WINE_EIGHT = ITEMS.register("huoshen_fruit_wine_eight",
			() -> new DrinkableItem(wineItem().food(FoodValues.HUOSHEN_FRUIT_WINE_EIGHT), true, true));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_WINE_NINE = ITEMS.register("huoshen_fruit_wine_nine",
			() -> new DrinkableItem(wineItem().food(FoodValues.HUOSHEN_FRUIT_WINE_NINE), true, true));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_WINE_TEN = ITEMS.register("huoshen_fruit_wine_ten",
			() -> new DrinkableItem(wineItem().food(FoodValues.HUOSHEN_FRUIT_WINE_TEN), true, true));
	public static final RegistryObject<Item> BEST_HUOSHEN_FRUIT_WINE = ITEMS.register("best_huoshen_fruit_wine",
			() -> new BestWineItem(wineItem(), true, true));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_POPSICLE_MACHINE = ITEMS.register("huoshen_fruit_popsicle_machine",
			() -> new BlockItem(ModBlocks.HUOSHEN_FRUIT_POPSICLE_MACHINE.get(), basicItem()));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_MILK_TEA = ITEMS.register("huoshen_fruit_milk_tea",
			() -> new DrinkableItem(juiceItem().food(FoodValues.HUOSHEN_FRUIT_MILK_TEA), true, false));
	//September Melon
	public static final RegistryObject<Item> SEPTEMBER_MELON_SEEDS = ITEMS.register("september_melon_seeds",
			() -> new ItemNameBlockItem(ModBlocks.SEPTEMBER_MELON_CROP.get(),new Item.Properties()
					.tab(fruitstack.CREATIVE_TAB)
			));
	public static final RegistryObject<Item> SEPTEMBER_MELON = ITEMS.register("september_melon",
			() -> new Item(foodItem(FoodValues.SEPTEMBER_MELON).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> SEPTEMBER_MELON_POPSICLE = ITEMS.register("september_melon_popsicle",
			() -> new PopsicleItem(foodItem(FoodValues.SEPTEMBER_MELON_POPSICLE).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> WILD_SEPTEMBER_MELON = ITEMS.register("wild_september_melon",
			() -> new BlockItem(ModBlocks.WILD_SEPTEMBER_MELON.get(), basicItem()));
	public static final RegistryObject<Item> SEPTEMBER_MELON_CAKE = ITEMS.register("september_melon_cake",
			()-> new ItemNameBlockItem(ModBlocks.SEPTEMBER_MELON_CAKE.get(),new Item.Properties()
					.tab(fruitstack.CREATIVE_TAB)
			));
	public static final RegistryObject<Item> SEPTEMBER_MELON_CAKE_SLICE = ITEMS.register("september_melon_cake_slice",
			() -> new Item(foodItem(FoodValues.SEPTEMBER_MELON_CAKE_SLICE)));
	public static final RegistryObject<Item> SEPTEMBER_MELON_CRATE = ITEMS.register("september_melon_crate",
			() -> new BlockItem(ModBlocks.SEPTEMBER_MELON_CRATE.get(), basicItem()));
	public static final RegistryObject<Item> SEPTEMBER_MELON_PIE = ITEMS.register("september_melon_pie",
			() -> new BlockItem(ModBlocks.SEPTEMBER_MELON_PIE.get(), basicItem()));
	public static final RegistryObject<Item> SEPTEMBER_MELON_PIE_SLICE = ITEMS.register("september_melon_pie_slice",
			() -> new Item(foodItem(FoodValues.SEPTEMBER_MELON_PIE_SLICE)));
	public static final RegistryObject<Item> SEPTEMBER_MELON_COOKIE = ITEMS.register("september_melon_cookie",
			() -> new Item(foodItem(FoodValues.SEPTEMBER_MELON_COOKIE)));
	public static final RegistryObject<Item> SEPTEMBER_MELON_JAM = ITEMS.register("september_melon_jam",
			() -> new BlockItem(ModBlocks.SEPTEMBER_MELON_JAM.get(), basicItem()));
	public static final RegistryObject<Item> SEPTEMBER_MELON_BREAD = ITEMS.register("september_melon_bread",
			() -> new Item(foodItem(FoodValues.SEPTEMBER_MELON_BREAD).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> SEPTEMBER_MELON_DOUGHNUT = ITEMS.register("september_melon_doughnut",
			() -> new Item(foodItem(FoodValues.SEPTEMBER_MELON_DOUGHNUT).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> SEPTEMBER_MELON_JUICE = ITEMS.register("september_melon_juice",
			() -> new DrinkableItem(juiceItem().food(FoodValues.SEPTEMBER_MELON_JUICE), true, false));
	public static final RegistryObject<Item> SEPTEMBER_MELON_WINE_BARREL = ITEMS.register("september_melon_wine_barrel",
			() -> new BlockItem(ModBlocks.SEPTEMBER_MELON_WINE_BARREL.get(), basicItem()));
	public static final RegistryObject<Item> SEPTEMBER_MELON_WINE_ONE = ITEMS.register("september_melon_wine_one",
			() -> new DrinkableItem(wineItem().food(FoodValues.SEPTEMBER_MELON_WINE_ONE), true, true));
	public static final RegistryObject<Item> SEPTEMBER_MELON_WINE_TWO = ITEMS.register("september_melon_wine_two",
			() -> new DrinkableItem(wineItem().food(FoodValues.SEPTEMBER_MELON_WINE_TWO), true, true));
	public static final RegistryObject<Item> SEPTEMBER_MELON_WINE_THREE = ITEMS.register("september_melon_wine_three",
			() -> new DrinkableItem(wineItem().food(FoodValues.SEPTEMBER_MELON_WINE_THREE), true, true));
	public static final RegistryObject<Item> SEPTEMBER_MELON_WINE_FOUR = ITEMS.register("september_melon_wine_four",
			() -> new DrinkableItem(wineItem().food(FoodValues.SEPTEMBER_MELON_WINE_FOUR), true, true));
	public static final RegistryObject<Item> SEPTEMBER_MELON_WINE_FIVE = ITEMS.register("september_melon_wine_five",
			() -> new DrinkableItem(wineItem().food(FoodValues.SEPTEMBER_MELON_WINE_FIVE), true, true));
	public static final RegistryObject<Item> SEPTEMBER_MELON_WINE_SIX = ITEMS.register("september_melon_wine_six",
			() -> new DrinkableItem(wineItem().food(FoodValues.SEPTEMBER_MELON_WINE_SIX), true, true));
	public static final RegistryObject<Item> SEPTEMBER_MELON_WINE_SEVEN = ITEMS.register("september_melon_wine_seven",
			() -> new DrinkableItem(wineItem().food(FoodValues.SEPTEMBER_MELON_WINE_SEVEN), true, true));
	public static final RegistryObject<Item> SEPTEMBER_MELON_WINE_EIGHT = ITEMS.register("september_melon_wine_eight",
			() -> new DrinkableItem(wineItem().food(FoodValues.SEPTEMBER_MELON_WINE_EIGHT), true, true));
	public static final RegistryObject<Item> SEPTEMBER_MELON_WINE_NINE = ITEMS.register("september_melon_wine_nine",
			() -> new DrinkableItem(wineItem().food(FoodValues.SEPTEMBER_MELON_WINE_NINE), true, true));
	public static final RegistryObject<Item> SEPTEMBER_MELON_WINE_TEN = ITEMS.register("september_melon_wine_ten",
			() -> new DrinkableItem(wineItem().food(FoodValues.SEPTEMBER_MELON_WINE_TEN), true, true));
	public static final RegistryObject<Item> BEST_SEPTEMBER_MELON_WINE = ITEMS.register("best_september_melon_wine",
			() -> new BestWineItem(wineItem(), true, true));
	public static final RegistryObject<Item> SEPTEMBER_MELON_POPSICLE_MACHINE = ITEMS.register("september_melon_popsicle_machine",
			() -> new BlockItem(ModBlocks.SEPTEMBER_MELON_POPSICLE_MACHINE.get(), basicItem()));
	public static final RegistryObject<Item> SEPTEMBER_MELON_MILK_TEA = ITEMS.register("september_melon_milk_tea",
			() -> new DrinkableItem(juiceItem().food(FoodValues.SEPTEMBER_MELON_MILK_TEA), true, false));
	//pitaya
	public static final RegistryObject<Item> PITAYA_SEEDS = ITEMS.register("pitaya_seeds",
			()-> new ItemNameBlockItem(ModBlocks.PITAYA_CROP.get(),new Item.Properties()
					.tab(fruitstack.CREATIVE_TAB)
			));
	public static final RegistryObject<Item> PITAYA = ITEMS.register("pitaya",
			() -> new BlockItem(ModBlocks.PITAYA.get(), basicItem().stacksTo(64)));
	public static final RegistryObject<Item> PITAYA_SLICE = ITEMS.register("pitaya_slice",
			() -> new Item(foodItem(FoodValues.PITAYA_SLICE).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> WILD_PITAYA = ITEMS.register("wild_pitaya",
			() -> new BlockItem(ModBlocks.WILD_PITAYA.get(), basicItem()));
	public static final RegistryObject<Item> COLORFUL_FRUIT_SALAD_BLOCK = ITEMS.register("colorful_fruit_salad_block",
			() -> new BlockItem(ModBlocks.COLORFUL_FRUIT_SALAD_BLOCK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> PITAYA_POPSICLE = ITEMS.register("pitaya_popsicle",
			() -> new PopsicleItem(foodItem(FoodValues.PITAYA_POPSICLE).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> PITAYA_CAKE = ITEMS.register("pitaya_cake",
			()-> new ItemNameBlockItem(ModBlocks.PITAYA_CAKE.get(),new Item.Properties()
					.tab(fruitstack.CREATIVE_TAB)
			));
	public static final RegistryObject<Item> PITAYA_CAKE_SLICE = ITEMS.register("pitaya_cake_slice",
			() -> new Item(foodItem(FoodValues.PITAYA_CAKE_SLICE)));
	public static final RegistryObject<Item> PITAYA_CRATE = ITEMS.register("pitaya_crate",
			() -> new BlockItem(ModBlocks.PITAYA_CRATE.get(), basicItem()));
	public static final RegistryObject<Item> PITAYA_PIE = ITEMS.register("pitaya_pie",
			() -> new BlockItem(ModBlocks.PITAYA_PIE.get(), basicItem()));
	public static final RegistryObject<Item> PITAYA_PIE_SLICE = ITEMS.register("pitaya_pie_slice",
			() -> new Item(foodItem(FoodValues.PITAYA_PIE_SLICE)));
	public static final RegistryObject<Item> PITAYA_RICE_AND_VEGETABLE_ROLL = ITEMS.register("pitaya_rice_and_vegetable_roll",
			() -> new Item(foodItem(FoodValues.PITAYA_RICE_AND_VEGETABLE_ROLL)));
	public static final RegistryObject<Item> PITAYA_COOKIE = ITEMS.register("pitaya_cookie",
			() -> new Item(foodItem(FoodValues.PITAYA_COOKIE)));
	public static final RegistryObject<Item> PITAYA_JAM = ITEMS.register("pitaya_jam",
			() -> new BlockItem(ModBlocks.PITAYA_JAM.get(), basicItem()));
	public static final RegistryObject<Item> PITAYA_BREAD = ITEMS.register("pitaya_bread",
			() -> new Item(foodItem(FoodValues.PITAYA_BREAD).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> PITAYA_DOUGHNUT = ITEMS.register("pitaya_doughnut",
			() -> new Item(foodItem(FoodValues.PITAYA_DOUGHNUT).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> PITAYA_JUICE = ITEMS.register("pitaya_juice",
			() -> new DrinkableItem(juiceItem().food(FoodValues.PITAYA_JUICE), true, false));
	public static final RegistryObject<Item> SWEETENED_PITAYA = ITEMS.register("sweetened_pitaya",
			() -> new BlockItem(ModBlocks.SWEETENED_PITAYA.get(), basicItem()));
	public static final RegistryObject<Item> DRIED_PITAYA = ITEMS.register("dried_pitaya",
			() -> new Item(foodItem(FoodValues.DRIED_PITAYA).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> PITAYA_WINE_BARREL = ITEMS.register("pitaya_wine_barrel",
			() -> new BlockItem(ModBlocks.PITAYA_WINE_BARREL.get(), basicItem()));
	public static final RegistryObject<Item> PITAYA_WINE_ONE = ITEMS.register("pitaya_wine_one",
			() -> new DrinkableItem(wineItem().food(FoodValues.PITAYA_WINE_ONE), true, true));
	public static final RegistryObject<Item> PITAYA_WINE_TWO = ITEMS.register("pitaya_wine_two",
			() -> new DrinkableItem(wineItem().food(FoodValues.PITAYA_WINE_TWO), true, true));
	public static final RegistryObject<Item> PITAYA_WINE_THREE = ITEMS.register("pitaya_wine_three",
			() -> new DrinkableItem(wineItem().food(FoodValues.PITAYA_WINE_THREE), true, true));
	public static final RegistryObject<Item> PITAYA_WINE_FOUR = ITEMS.register("pitaya_wine_four",
			() -> new DrinkableItem(wineItem().food(FoodValues.PITAYA_WINE_FOUR), true, true));
	public static final RegistryObject<Item> PITAYA_WINE_FIVE = ITEMS.register("pitaya_wine_five",
			() -> new DrinkableItem(wineItem().food(FoodValues.PITAYA_WINE_FIVE), true, true));
	public static final RegistryObject<Item> PITAYA_WINE_SIX = ITEMS.register("pitaya_wine_six",
			() -> new DrinkableItem(wineItem().food(FoodValues.PITAYA_WINE_SIX), true, true));
	public static final RegistryObject<Item> PITAYA_WINE_SEVEN = ITEMS.register("pitaya_wine_seven",
			() -> new DrinkableItem(wineItem().food(FoodValues.PITAYA_WINE_SEVEN), true, true));
	public static final RegistryObject<Item> PITAYA_WINE_EIGHT = ITEMS.register("pitaya_wine_eight",
			() -> new DrinkableItem(wineItem().food(FoodValues.PITAYA_WINE_EIGHT), true, true));
	public static final RegistryObject<Item> PITAYA_WINE_NINE = ITEMS.register("pitaya_wine_nine",
			() -> new DrinkableItem(wineItem().food(FoodValues.PITAYA_WINE_NINE), true, true));
	public static final RegistryObject<Item> PITAYA_WINE_TEN = ITEMS.register("pitaya_wine_ten",
			() -> new DrinkableItem(wineItem().food(FoodValues.PITAYA_WINE_TEN), true, true));
	public static final RegistryObject<Item> BEST_PITAYA_WINE = ITEMS.register("best_pitaya_wine",
			() -> new BestWineItem(wineItem(), true, true));
	public static final RegistryObject<Item> PITAYA_POPSICLE_MACHINE = ITEMS.register("pitaya_popsicle_machine",
			() -> new BlockItem(ModBlocks.PITAYA_POPSICLE_MACHINE.get(), basicItem()));
	public static final RegistryObject<Item> PITAYA_MILK_TEA = ITEMS.register("pitaya_milk_tea",
			() -> new DrinkableItem(juiceItem().food(FoodValues.PITAYA_MILK_TEA), true, false));
	//golden pure sheep horn honey
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY = ITEMS.register("golden_pure_sheep_horn_honey",
			() -> new BlockItem(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY.get(), basicItem().stacksTo(64)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_SEEDS = ITEMS.register("golden_pure_sheep_horn_honey_seeds",
			() -> new ItemNameBlockItem(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_CROP.get(),new Item.Properties()
					.tab(fruitstack.CREATIVE_TAB)
			));
	public static final RegistryObject<Item> WILD_GOLDEN_PURE_SHEEP_HORN_HONEY = ITEMS.register("wild_golden_pure_sheep_horn_honey",
			() -> new BlockItem(ModBlocks.WILD_GOLDEN_PURE_SHEEP_HORN_HONEY.get(), basicItem()));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_SLICE = ITEMS.register("golden_pure_sheep_horn_honey_slice",
			() -> new Item(foodItem(FoodValues.GOLDEN_PURE_SHEEP_HORN_HONEY_SLICE).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_POPSICLE = ITEMS.register("golden_pure_sheep_horn_honey_popsicle",
			() -> new PopsicleItem(foodItem(FoodValues.GOLDEN_PURE_SHEEP_HORN_HONEY_POPSICLE).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_CAKE = ITEMS.register("golden_pure_sheep_horn_honey_cake",
			()-> new ItemNameBlockItem(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_CAKE.get(),new Item.Properties()
					.tab(fruitstack.CREATIVE_TAB)
			));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_CAKE_SLICE = ITEMS.register("golden_pure_sheep_horn_honey_cake_slice",
			() -> new Item(foodItem(FoodValues.GOLDEN_PURE_SHEEP_HORN_HONEY_CAKE_SLICE)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_CRATE = ITEMS.register("golden_pure_sheep_horn_honey_crate",
			() -> new BlockItem(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_CRATE.get(), basicItem()));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_PIE = ITEMS.register("golden_pure_sheep_horn_honey_pie",
			() -> new BlockItem(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_PIE.get(), basicItem()));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_PIE_SLICE = ITEMS.register("golden_pure_sheep_horn_honey_pie_slice",
			() -> new Item(foodItem(FoodValues.GOLDEN_PURE_SHEEP_HORN_HONEY_PIE_SLICE)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_COOKIE = ITEMS.register("golden_pure_sheep_horn_honey_cookie",
			() -> new Item(foodItem(FoodValues.GOLDEN_PURE_SHEEP_HORN_HONEY_COOKIE)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_FLAVOR_GOLDEN_PURE_SHEEP_HORN_HONEY = ITEMS.register("golden_pure_sheep_horn_honey_flavor_golden_pure_sheep_horn_honey",
			() -> new Item(foodItem(FoodValues.GOLDEN_PURE_SHEEP_HORN_HONEY_FLAVOR_GOLDEN_PURE_SHEEP_HORN_HONEY)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_JAM = ITEMS.register("golden_pure_sheep_horn_honey_jam",
			() -> new BlockItem(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_JAM.get(), basicItem()));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_BREAD = ITEMS.register("golden_pure_sheep_horn_honey_bread",
			() -> new Item(foodItem(FoodValues.GOLDEN_PURE_SHEEP_HORN_HONEY_BREAD).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_DOUGHNUT = ITEMS.register("golden_pure_sheep_horn_honey_doughnut",
			() -> new Item(foodItem(FoodValues.GOLDEN_PURE_SHEEP_HORN_HONEY_DOUGHNUT).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_JUICE = ITEMS.register("golden_pure_sheep_horn_honey_juice",
			() -> new DrinkableItem(juiceItem().food(FoodValues.GOLDEN_PURE_SHEEP_HORN_HONEY_JUICE), true, false));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_BARREL = ITEMS.register("golden_pure_sheep_horn_honey_wine_barrel",
			() -> new BlockItem(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_BARREL.get(), basicItem()));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_ONE = ITEMS.register("golden_pure_sheep_horn_honey_wine_one",
			() -> new DrinkableItem(wineItem().food(FoodValues.GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_ONE), true, true));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_TWO = ITEMS.register("golden_pure_sheep_horn_honey_wine_two",
			() -> new DrinkableItem(wineItem().food(FoodValues.GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_TWO), true, true));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_THREE = ITEMS.register("golden_pure_sheep_horn_honey_wine_three",
			() -> new DrinkableItem(wineItem().food(FoodValues.GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_THREE), true, true));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_FOUR = ITEMS.register("golden_pure_sheep_horn_honey_wine_four",
			() -> new DrinkableItem(wineItem().food(FoodValues.GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_FOUR), true, true));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_FIVE = ITEMS.register("golden_pure_sheep_horn_honey_wine_five",
			() -> new DrinkableItem(wineItem().food(FoodValues.GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_FIVE), true, true));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_SIX = ITEMS.register("golden_pure_sheep_horn_honey_wine_six",
			() -> new DrinkableItem(wineItem().food(FoodValues.GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_SIX), true, true));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_SEVEN = ITEMS.register("golden_pure_sheep_horn_honey_wine_seven",
			() -> new DrinkableItem(wineItem().food(FoodValues.GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_SEVEN), true, true));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_EIGHT = ITEMS.register("golden_pure_sheep_horn_honey_wine_eight",
			() -> new DrinkableItem(wineItem().food(FoodValues.GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_EIGHT), true, true));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_NINE = ITEMS.register("golden_pure_sheep_horn_honey_wine_nine",
			() -> new DrinkableItem(wineItem().food(FoodValues.GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_NINE), true, true));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_TEN = ITEMS.register("golden_pure_sheep_horn_honey_wine_ten",
			() -> new DrinkableItem(wineItem().food(FoodValues.GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_TEN), true, true));
	public static final RegistryObject<Item> BEST_GOLDEN_PURE_SHEEP_HORN_HONEY_WINE = ITEMS.register("best_golden_pure_sheep_horn_honey_wine",
			() -> new BestWineItem(wineItem(), true, true));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_POPSICLE_MACHINE = ITEMS.register("golden_pure_sheep_horn_honey_popsicle_machine",
			() -> new BlockItem(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_POPSICLE_MACHINE.get(), basicItem()));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_MILK_TEA = ITEMS.register("golden_pure_sheep_horn_honey_milk_tea",
			() -> new DrinkableItem(juiceItem().food(FoodValues.GOLDEN_PURE_SHEEP_HORN_HONEY_MILK_TEA), true, false));
	//pear
	public static final RegistryObject<Item> PEAR_BLOCK = ITEMS.register("pear_block",
			() -> new BlockItem(ModBlocks.PEAR_BLOCK.get(), basicItem().stacksTo(64)));
	public static final RegistryObject<Item> PEAR_SLICE = ITEMS.register("pear_slice",
			() -> new Item(foodItem(FoodValues.PEAR_SLICE).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> PEAR_SAPLING = ITEMS.register("pear_sapling",
			() -> new BlockItem(ModBlocks.PEAR_SAPLING.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> PEAR_POPSICLE = ITEMS.register("pear_popsicle",
			() -> new PopsicleItem(foodItem(FoodValues.PEAR_POPSICLE).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> PEAR_CAKE = ITEMS.register("pear_cake",
			()-> new ItemNameBlockItem(ModBlocks.PEAR_CAKE.get(),new Item.Properties()
					.tab(fruitstack.CREATIVE_TAB)
			));
	public static final RegistryObject<Item> PEAR_PIE = ITEMS.register("pear_pie",
			() -> new BlockItem(ModBlocks.PEAR_PIE.get(), basicItem()));
	public static final RegistryObject<Item> PEAR_PIE_SLICE = ITEMS.register("pear_pie_slice",
			() -> new Item(foodItem(FoodValues.PEAR_PIE_SLICE)));
	public static final RegistryObject<Item> PEAR_CAKE_SLICE = ITEMS.register("pear_cake_slice",
			() -> new Item(foodItem(FoodValues.PEAR_CAKE_SLICE)));
	public static final RegistryObject<Item> PEAR_CRATE = ITEMS.register("pear_crate",
			() -> new BlockItem(ModBlocks.PEAR_CRATE.get(), basicItem()));
	public static final RegistryObject<Item> PEAR_COOKIE = ITEMS.register("pear_cookie",
			() -> new Item(foodItem(FoodValues.PEAR_COOKIE)));
	public static final RegistryObject<Item> PEAR_JAM = ITEMS.register("pear_jam",
			() -> new BlockItem(ModBlocks.PEAR_JAM.get(), basicItem()));
	public static final RegistryObject<Item> PEAR_BREAD = ITEMS.register("pear_bread",
			() -> new Item(foodItem(FoodValues.PEAR_BREAD).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> PEAR_DOUGHNUT = ITEMS.register("pear_doughnut",
			() -> new Item(foodItem(FoodValues.PEAR_DOUGHNUT).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> PEAR_JUICE = ITEMS.register("pear_juice",
			() -> new DrinkableItem(juiceItem().food(FoodValues.PEAR_JUICE), true, false));
	public static final RegistryObject<Item> ROCK_SUPAR_SNOW_PEAR = ITEMS.register("rock_sugar_snow_pear",
			() -> new BlockItem(ModBlocks.ROCK_SUPAR_SNOW_PEAR.get(), basicItem()));
	public static final RegistryObject<Item> PEAR_WINE_BARREL = ITEMS.register("pear_wine_barrel",
			() -> new BlockItem(ModBlocks.PEAR_WINE_BARREL.get(), basicItem()));
	public static final RegistryObject<Item> PEAR_WINE_ONE = ITEMS.register("pear_wine_one",
			() -> new DrinkableItem(wineItem().food(FoodValues.PEAR_WINE_ONE), true, true));
	public static final RegistryObject<Item> PEAR_WINE_TWO = ITEMS.register("pear_wine_two",
			() -> new DrinkableItem(wineItem().food(FoodValues.PEAR_WINE_TWO), true, true));
	public static final RegistryObject<Item> PEAR_WINE_THREE = ITEMS.register("pear_wine_three",
			() -> new DrinkableItem(wineItem().food(FoodValues.PEAR_WINE_THREE), true, true));
	public static final RegistryObject<Item> PEAR_WINE_FOUR = ITEMS.register("pear_wine_four",
			() -> new DrinkableItem(wineItem().food(FoodValues.PEAR_WINE_FOUR), true, true));
	public static final RegistryObject<Item> PEAR_WINE_FIVE = ITEMS.register("pear_wine_five",
			() -> new DrinkableItem(wineItem().food(FoodValues.PEAR_WINE_FIVE), true, true));
	public static final RegistryObject<Item> PEAR_WINE_SIX = ITEMS.register("pear_wine_six",
			() -> new DrinkableItem(wineItem().food(FoodValues.PEAR_WINE_SIX), true, true));
	public static final RegistryObject<Item> PEAR_WINE_SEVEN = ITEMS.register("pear_wine_seven",
			() -> new DrinkableItem(wineItem().food(FoodValues.PEAR_WINE_SEVEN), true, true));
	public static final RegistryObject<Item> PEAR_WINE_EIGHT = ITEMS.register("pear_wine_eight",
			() -> new DrinkableItem(wineItem().food(FoodValues.PEAR_WINE_EIGHT), true, true));
	public static final RegistryObject<Item> PEAR_WINE_NINE = ITEMS.register("pear_wine_nine",
			() -> new DrinkableItem(wineItem().food(FoodValues.PEAR_WINE_NINE), true, true));
	public static final RegistryObject<Item> PEAR_WINE_TEN = ITEMS.register("pear_wine_ten",
			() -> new DrinkableItem(wineItem().food(FoodValues.PEAR_WINE_TEN), true, true));
	public static final RegistryObject<Item> BEST_PEAR_WINE = ITEMS.register("best_pear_wine",
			() -> new BestWineItem(wineItem(), true, true));
	public static final RegistryObject<Item> PEAR_POPSICLE_MACHINE = ITEMS.register("pear_popsicle_machine",
			() -> new BlockItem(ModBlocks.PEAR_POPSICLE_MACHINE.get(), basicItem()));
	public static final RegistryObject<Item> PEAR_MILK_TEA = ITEMS.register("pear_milk_tea",
			() -> new DrinkableItem(juiceItem().food(FoodValues.PEAR_MILK_TEA), true, false));
	//maythorn
	public static final RegistryObject<Item> MAYTHORN = ITEMS.register("maythorn",
			() -> new Item(foodItem(FoodValues.MAYTHORN).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> MAYTHORN_SAPLING = ITEMS.register("maythorn_sapling",
			() -> new BlockItem(ModBlocks.MAYTHORN_SAPLING.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> MAYTHORN_POPSICLE = ITEMS.register("maythorn_popsicle",
			() -> new PopsicleItem(foodItem(FoodValues.MAYTHORN_POPSICLE).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> MAYTHORN_CAKE = ITEMS.register("maythorn_cake",
			()-> new ItemNameBlockItem(ModBlocks.MAYTHORN_CAKE.get(),new Item.Properties()
					.tab(fruitstack.CREATIVE_TAB)
			));
	public static final RegistryObject<Item> MAYTHORN_PIE = ITEMS.register("maythorn_pie",
			() -> new BlockItem(ModBlocks.MAYTHORN_PIE.get(), basicItem()));
	public static final RegistryObject<Item> MAYTHORN_PIE_SLICE = ITEMS.register("maythorn_pie_slice",
			() -> new Item(foodItem(FoodValues.MAYTHORN_PIE_SLICE)));
	public static final RegistryObject<Item> MAYTHORN_CAKE_SLICE = ITEMS.register("maythorn_cake_slice",
			() -> new Item(foodItem(FoodValues.MAYTHORN_CAKE_SLICE)));
	public static final RegistryObject<Item> MAYTHORN_CRATE = ITEMS.register("maythorn_crate",
			() -> new BlockItem(ModBlocks.MAYTHORN_CRATE.get(), basicItem()));
	public static final RegistryObject<Item> MAYTHORN_COOKIE = ITEMS.register("maythorn_cookie",
			() -> new Item(foodItem(FoodValues.MAYTHORN_COOKIE)));
	public static final RegistryObject<Item> MAYTHORN_JAM = ITEMS.register("maythorn_jam",
			() -> new BlockItem(ModBlocks.MAYTHORN_JAM.get(), basicItem()));
	public static final RegistryObject<Item> MAYTHORN_BREAD = ITEMS.register("maythorn_bread",
			() -> new Item(foodItem(FoodValues.MAYTHORN_BREAD).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> MAYTHORN_DOUGHNUT = ITEMS.register("maythorn_doughnut",
			() -> new Item(foodItem(FoodValues.MAYTHORN_DOUGHNUT).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> MAYTHORN_JUICE = ITEMS.register("maythorn_juice",
			() -> new DrinkableItem(juiceItem().food(FoodValues.MAYTHORN_JUICE), true, false));
	public static final RegistryObject<Item> SWEETENED_MAYTHORN = ITEMS.register("sweetened_maythorn",
			() -> new BlockItem(ModBlocks.SWEETENED_MAYTHORN.get(), basicItem()));
	public static final RegistryObject<Item> DRIED_MAYTHORN = ITEMS.register("dried_maythorn",
			() -> new Item(foodItem(FoodValues.DRIED_MAYTHORN).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> CANDIED_HAWS_ON_A_STICK = ITEMS.register("candied_haws_on_a_stick",
			() -> new ConsumableItem(foodItem(FoodValues.CANDIED_HAWS_ON_A_STICK),true));
	public static final RegistryObject<Item> BOWLED_CANDIED_HAWS_ON_A_STICK = ITEMS.register("bowled_candied_haws_on_a_stick",
			() -> new BlockItem(ModBlocks.BOWLED_CANDIED_HAWS_ON_A_STICK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> A_BUNDLE_OF_CANDIED_HAWS_ON_A_STICK = ITEMS.register("a_bundle_of_candied_haws_on_a_stick",
			() -> new BlockItem(ModBlocks.A_BUNDLE_OF_CANDIED_HAWS_ON_A_STICK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> RED_FRUIT_MAYTHORN_CAKE = ITEMS.register("red_fruit_maythorn_cake",
			() -> new BlockItem(ModBlocks.RED_FRUIT_MAYTHORN_CAKE.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> MAYTHORN_WINE_BARREL = ITEMS.register("maythorn_wine_barrel",
			() -> new BlockItem(ModBlocks.MAYTHORN_WINE_BARREL.get(), basicItem()));
	public static final RegistryObject<Item> MAYTHORN_WINE_ONE = ITEMS.register("maythorn_wine_one",
			() -> new DrinkableItem(wineItem().food(FoodValues.MAYTHORN_WINE_ONE), true, true));
	public static final RegistryObject<Item> MAYTHORN_WINE_TWO = ITEMS.register("maythorn_wine_two",
			() -> new DrinkableItem(wineItem().food(FoodValues.MAYTHORN_WINE_TWO), true, true));
	public static final RegistryObject<Item> MAYTHORN_WINE_THREE = ITEMS.register("maythorn_wine_three",
			() -> new DrinkableItem(wineItem().food(FoodValues.MAYTHORN_WINE_THREE), true, true));
	public static final RegistryObject<Item> MAYTHORN_WINE_FOUR = ITEMS.register("maythorn_wine_four",
			() -> new DrinkableItem(wineItem().food(FoodValues.MAYTHORN_WINE_FOUR), true, true));
	public static final RegistryObject<Item> MAYTHORN_WINE_FIVE = ITEMS.register("maythorn_wine_five",
			() -> new DrinkableItem(wineItem().food(FoodValues.MAYTHORN_WINE_FIVE), true, true));
	public static final RegistryObject<Item> MAYTHORN_WINE_SIX = ITEMS.register("maythorn_wine_six",
			() -> new DrinkableItem(wineItem().food(FoodValues.MAYTHORN_WINE_SIX), true, true));
	public static final RegistryObject<Item> MAYTHORN_WINE_SEVEN = ITEMS.register("maythorn_wine_seven",
			() -> new DrinkableItem(wineItem().food(FoodValues.MAYTHORN_WINE_SEVEN), true, true));
	public static final RegistryObject<Item> MAYTHORN_WINE_EIGHT = ITEMS.register("maythorn_wine_eight",
			() -> new DrinkableItem(wineItem().food(FoodValues.MAYTHORN_WINE_EIGHT), true, true));
	public static final RegistryObject<Item> MAYTHORN_WINE_NINE = ITEMS.register("maythorn_wine_nine",
			() -> new DrinkableItem(wineItem().food(FoodValues.MAYTHORN_WINE_NINE), true, true));
	public static final RegistryObject<Item> MAYTHORN_WINE_TEN = ITEMS.register("maythorn_wine_ten",
			() -> new DrinkableItem(wineItem().food(FoodValues.MAYTHORN_WINE_TEN), true, true));
	public static final RegistryObject<Item> BEST_MAYTHORN_WINE = ITEMS.register("best_maythorn_wine",
			() -> new BestWineItem(wineItem(), true, true));
	public static final RegistryObject<Item> MAYTHORN_POPSICLE_MACHINE = ITEMS.register("maythorn_popsicle_machine",
			() -> new BlockItem(ModBlocks.MAYTHORN_POPSICLE_MACHINE.get(), basicItem()));
	public static final RegistryObject<Item> MAYTHORN_MILK_TEA = ITEMS.register("maythorn_milk_tea",
			() -> new DrinkableItem(juiceItem().food(FoodValues.MAYTHORN_MILK_TEA), true, false));
	//chinese_pear-leaved
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_BLOCK = ITEMS.register("chinese_pear_leaved_block",
			() -> new BlockItem(ModBlocks.CHINESE_PEAR_LEAVED_BLOCK.get(), basicItem().stacksTo(64)));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_SLICE = ITEMS.register("chinese_pear_leaved_slice",
			() -> new Item(foodItem(FoodValues.CHINESE_PEAR_LEAVED_SLICE).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_SAPLING = ITEMS.register("chinese_pear_leaved_sapling",
			() -> new BlockItem(ModBlocks.CHINESE_PEAR_LEAVED_SAPLING.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_POPSICLE = ITEMS.register("chinese_pear_leaved_popsicle",
			() -> new PopsicleItem(foodItem(FoodValues.CHINESE_PEAR_LEAVED_POPSICLE).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_CAKE = ITEMS.register("chinese_pear_leaved_cake",
			()-> new ItemNameBlockItem(ModBlocks.CHINESE_PEAR_LEAVED_CAKE.get(),new Item.Properties()
					.tab(fruitstack.CREATIVE_TAB)
			));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_PIE = ITEMS.register("chinese_pear_leaved_pie",
			() -> new BlockItem(ModBlocks.CHINESE_PEAR_LEAVED_PIE.get(), basicItem()));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_PIE_SLICE = ITEMS.register("chinese_pear_leaved_pie_slice",
			() -> new Item(foodItem(FoodValues.CHINESE_PEAR_LEAVED_PIE_SLICE)));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_CAKE_SLICE = ITEMS.register("chinese_pear_leaved_cake_slice",
			() -> new Item(foodItem(FoodValues.CHINESE_PEAR_LEAVED_CAKE_SLICE)));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_CRATE = ITEMS.register("chinese_pear_leaved_crate",
			() -> new BlockItem(ModBlocks.CHINESE_PEAR_LEAVED_CRATE.get(), basicItem()));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_COOKIE = ITEMS.register("chinese_pear_leaved_cookie",
			() -> new Item(foodItem(FoodValues.CHINESE_PEAR_LEAVED_COOKIE)));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_JAM = ITEMS.register("chinese_pear_leaved_jam",
			() -> new BlockItem(ModBlocks.CHINESE_PEAR_LEAVED_JAM.get(), basicItem()));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_BREAD = ITEMS.register("chinese_pear_leaved_bread",
			() -> new Item(foodItem(FoodValues.CHINESE_PEAR_LEAVED_BREAD).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_DOUGHNUT = ITEMS.register("chinese_pear_leaved_doughnut",
			() -> new Item(foodItem(FoodValues.CHINESE_PEAR_LEAVED_DOUGHNUT).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_JUICE = ITEMS.register("chinese_pear_leaved_juice",
			() -> new DrinkableItem(juiceItem().food(FoodValues.CHINESE_PEAR_LEAVED_JUICE), true, false));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_ROLLS = ITEMS.register("chinese_pear_leaved_rolls",
			() -> new Item(foodItem(FoodValues.CHINESE_PEAR_LEAVED_ROLLS)));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_WINE_BARREL = ITEMS.register("chinese_pear_leaved_wine_barrel",
			() -> new BlockItem(ModBlocks.CHINESE_PEAR_LEAVED_WINE_BARREL.get(), basicItem()));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_WINE_ONE = ITEMS.register("chinese_pear_leaved_wine_one",
			() -> new DrinkableItem(wineItem().food(FoodValues.CHINESE_PEAR_LEAVED_WINE_ONE), true, true));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_WINE_TWO = ITEMS.register("chinese_pear_leaved_wine_two",
			() -> new DrinkableItem(wineItem().food(FoodValues.CHINESE_PEAR_LEAVED_WINE_TWO), true, true));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_WINE_THREE = ITEMS.register("chinese_pear_leaved_wine_three",
			() -> new DrinkableItem(wineItem().food(FoodValues.CHINESE_PEAR_LEAVED_WINE_THREE), true, true));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_WINE_FOUR = ITEMS.register("chinese_pear_leaved_wine_four",
			() -> new DrinkableItem(wineItem().food(FoodValues.CHINESE_PEAR_LEAVED_WINE_FOUR), true, true));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_WINE_FIVE = ITEMS.register("chinese_pear_leaved_wine_five",
			() -> new DrinkableItem(wineItem().food(FoodValues.CHINESE_PEAR_LEAVED_WINE_FIVE), true, true));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_WINE_SIX = ITEMS.register("chinese_pear_leaved_wine_six",
			() -> new DrinkableItem(wineItem().food(FoodValues.CHINESE_PEAR_LEAVED_WINE_SIX), true, true));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_WINE_SEVEN = ITEMS.register("chinese_pear_leaved_wine_seven",
			() -> new DrinkableItem(wineItem().food(FoodValues.CHINESE_PEAR_LEAVED_WINE_SEVEN), true, true));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_WINE_EIGHT = ITEMS.register("chinese_pear_leaved_wine_eight",
			() -> new DrinkableItem(wineItem().food(FoodValues.CHINESE_PEAR_LEAVED_WINE_EIGHT), true, true));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_WINE_NINE = ITEMS.register("chinese_pear_leaved_wine_nine",
			() -> new DrinkableItem(wineItem().food(FoodValues.CHINESE_PEAR_LEAVED_WINE_NINE), true, true));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_WINE_TEN = ITEMS.register("chinese_pear_leaved_wine_ten",
			() -> new DrinkableItem(wineItem().food(FoodValues.CHINESE_PEAR_LEAVED_WINE_TEN), true, true));
	public static final RegistryObject<Item> BEST_CHINESE_PEAR_LEAVED_WINE = ITEMS.register("best_chinese_pear_leaved_wine",
			() -> new BestWineItem(wineItem(), true, true));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_POPSICLE_MACHINE = ITEMS.register("chinese_pear_leaved_popsicle_machine",
			() -> new BlockItem(ModBlocks.CHINESE_PEAR_LEAVED_POPSICLE_MACHINE.get(), basicItem()));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_MILK_TEA = ITEMS.register("chinese_pear_leaved_milk_tea",
			() -> new DrinkableItem(juiceItem().food(FoodValues.CHINESE_PEAR_LEAVED_MILK_TEA), true, false));
	//plum
	public static final RegistryObject<Item> PLUM = ITEMS.register("plum",
			() -> new Item(foodItem(FoodValues.PLUM).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> PLUM_SAPLING = ITEMS.register("plum_sapling",
			() -> new BlockItem(ModBlocks.PLUM_SAPLING.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> PLUM_POPSICLE = ITEMS.register("plum_popsicle",
			() -> new PopsicleItem(foodItem(FoodValues.PLUM_POPSICLE).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> PLUM_CAKE = ITEMS.register("plum_cake",
			()-> new ItemNameBlockItem(ModBlocks.PLUM_CAKE.get(),new Item.Properties()
					.tab(fruitstack.CREATIVE_TAB)
			));
	public static final RegistryObject<Item> PLUM_PIE = ITEMS.register("plum_pie",
			() -> new BlockItem(ModBlocks.PLUM_PIE.get(), basicItem()));
	public static final RegistryObject<Item> PLUM_PIE_SLICE = ITEMS.register("plum_pie_slice",
			() -> new Item(foodItem(FoodValues.PLUM_PIE_SLICE)));
	public static final RegistryObject<Item> PLUM_CAKE_SLICE = ITEMS.register("plum_cake_slice",
			() -> new Item(foodItem(FoodValues.PLUM_CAKE_SLICE)));
	public static final RegistryObject<Item> PLUM_CRATE = ITEMS.register("plum_crate",
			() -> new BlockItem(ModBlocks.PLUM_CRATE.get(), basicItem()));
	public static final RegistryObject<Item> PLUM_COOKIE = ITEMS.register("plum_cookie",
			() -> new Item(foodItem(FoodValues.PLUM_COOKIE)));
	public static final RegistryObject<Item> PLUM_JAM = ITEMS.register("plum_jam",
			() -> new BlockItem(ModBlocks.PLUM_JAM.get(), basicItem()));
	public static final RegistryObject<Item> PLUM_BREAD = ITEMS.register("plum_bread",
			() -> new Item(foodItem(FoodValues.PLUM_BREAD).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> PLUM_DOUGHNUT = ITEMS.register("plum_doughnut",
			() -> new Item(foodItem(FoodValues.PLUM_DOUGHNUT).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> SWEETENED_PLUM = ITEMS.register("sweetened_plum",
			() -> new BlockItem(ModBlocks.SWEETENED_PLUM.get(), basicItem()));
	public static final RegistryObject<Item> DRIED_PLUM = ITEMS.register("dried_plum",
			() -> new Item(foodItem(FoodValues.DRIED_PLUM).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> PLUM_JUICE = ITEMS.register("plum_juice",
			() -> new DrinkableItem(juiceItem().food(FoodValues.PLUM_JUICE), true, false));
	public static final RegistryObject<Item> SOUR_AND_SWEET_PLUM_CAKE = ITEMS.register("sour_and_sweet_plum_cake",
			() -> new BlockItem(ModBlocks.SOUR_AND_SWEET_PLUM_CAKE.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> PLUM_WINE_BARREL = ITEMS.register("plum_wine_barrel",
			() -> new BlockItem(ModBlocks.PLUM_WINE_BARREL.get(), basicItem()));
	public static final RegistryObject<Item> PLUM_WINE_ONE = ITEMS.register("plum_wine_one",
			() -> new DrinkableItem(wineItem().food(FoodValues.PLUM_WINE_ONE), true, true));
	public static final RegistryObject<Item> PLUM_WINE_TWO = ITEMS.register("plum_wine_two",
			() -> new DrinkableItem(wineItem().food(FoodValues.PLUM_WINE_TWO), true, true));
	public static final RegistryObject<Item> PLUM_WINE_THREE = ITEMS.register("plum_wine_three",
			() -> new DrinkableItem(wineItem().food(FoodValues.PLUM_WINE_THREE), true, true));
	public static final RegistryObject<Item> PLUM_WINE_FOUR = ITEMS.register("plum_wine_four",
			() -> new DrinkableItem(wineItem().food(FoodValues.PLUM_WINE_FOUR), true, true));
	public static final RegistryObject<Item> PLUM_WINE_FIVE = ITEMS.register("plum_wine_five",
			() -> new DrinkableItem(wineItem().food(FoodValues.PLUM_WINE_FIVE), true, true));
	public static final RegistryObject<Item> PLUM_WINE_SIX = ITEMS.register("plum_wine_six",
			() -> new DrinkableItem(wineItem().food(FoodValues.PLUM_WINE_SIX), true, true));
	public static final RegistryObject<Item> PLUM_WINE_SEVEN = ITEMS.register("plum_wine_seven",
			() -> new DrinkableItem(wineItem().food(FoodValues.PLUM_WINE_SEVEN), true, true));
	public static final RegistryObject<Item> PLUM_WINE_EIGHT = ITEMS.register("plum_wine_eight",
			() -> new DrinkableItem(wineItem().food(FoodValues.PLUM_WINE_EIGHT), true, true));
	public static final RegistryObject<Item> PLUM_WINE_NINE = ITEMS.register("plum_wine_nine",
			() -> new DrinkableItem(wineItem().food(FoodValues.PLUM_WINE_NINE), true, true));
	public static final RegistryObject<Item> PLUM_WINE_TEN = ITEMS.register("plum_wine_ten",
			() -> new DrinkableItem(wineItem().food(FoodValues.PLUM_WINE_TEN), true, true));
	public static final RegistryObject<Item> BEST_PLUM_WINE = ITEMS.register("best_plum_wine",
			() -> new BestWineItem(wineItem(), true, true));
	public static final RegistryObject<Item> PLUM_POPSICLE_MACHINE = ITEMS.register("plum_popsicle_machine",
			() -> new BlockItem(ModBlocks.PLUM_POPSICLE_MACHINE.get(), basicItem()));
	public static final RegistryObject<Item> PLUM_MILK_TEA = ITEMS.register("plum_milk_tea",
			() -> new DrinkableItem(juiceItem().food(FoodValues.PLUM_MILK_TEA), true, false));
	//jujube
	public static final RegistryObject<Item> JUJUBE = ITEMS.register("jujube",
			() -> new Item(foodItem(FoodValues.JUJUBE).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> JUJUBE_SAPLING = ITEMS.register("jujube_sapling",
			() -> new BlockItem(ModBlocks.JUJUBE_SAPLING.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> JUJUBE_POPSICLE = ITEMS.register("jujube_popsicle",
			() -> new PopsicleItem(foodItem(FoodValues.JUJUBE_POPSICLE).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> JUJUBE_CAKE = ITEMS.register("jujube_cake",
			()-> new ItemNameBlockItem(ModBlocks.JUJUBE_CAKE.get(),new Item.Properties()
					.tab(fruitstack.CREATIVE_TAB)
			));
	public static final RegistryObject<Item> JUJUBE_PIE = ITEMS.register("jujube_pie",
			() -> new BlockItem(ModBlocks.JUJUBE_PIE.get(), basicItem()));
	public static final RegistryObject<Item> JUJUBE_PIE_SLICE = ITEMS.register("jujube_pie_slice",
			() -> new Item(foodItem(FoodValues.JUJUBE_PIE_SLICE)));
	public static final RegistryObject<Item> JUJUBE_CAKE_SLICE = ITEMS.register("jujube_cake_slice",
			() -> new Item(foodItem(FoodValues.JUJUBE_CAKE_SLICE)));
	public static final RegistryObject<Item> JUJUBE_CRATE = ITEMS.register("jujube_crate",
			() -> new BlockItem(ModBlocks.JUJUBE_CRATE.get(), basicItem()));
	public static final RegistryObject<Item> JUJUBE_COOKIE = ITEMS.register("jujube_cookie",
			() -> new Item(foodItem(FoodValues.JUJUBE_COOKIE)));
	public static final RegistryObject<Item> JUJUBE_JAM = ITEMS.register("jujube_jam",
			() -> new BlockItem(ModBlocks.JUJUBE_JAM.get(), basicItem()));
	public static final RegistryObject<Item> JUJUBE_BREAD = ITEMS.register("jujube_bread",
			() -> new Item(foodItem(FoodValues.JUJUBE_BREAD).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> JUJUBE_DOUGHNUT = ITEMS.register("jujube_doughnut",
			() -> new Item(foodItem(FoodValues.JUJUBE_DOUGHNUT).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> SWEETENED_JUJUBE = ITEMS.register("sweetened_jujube",
			() -> new BlockItem(ModBlocks.SWEETENED_JUJUBE.get(), basicItem()));
	public static final RegistryObject<Item> DRIED_JUJUBE = ITEMS.register("dried_jujube",
			() -> new Item(foodItem(FoodValues.DRIED_JUJUBE).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> JUJUBE_JUICE = ITEMS.register("jujube_juice",
			() -> new DrinkableItem(juiceItem().food(FoodValues.JUJUBE_JUICE), true, false));
	public static final RegistryObject<Item> RED_GATE_GLUTINOUS_RICE = ITEMS.register("red_gate_glutinous_rice",
			() -> new BlockItem(ModBlocks.RED_GATE_GLUTINOUS_RICE.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> JUJUBE_WINE_BARREL = ITEMS.register("jujube_wine_barrel",
			() -> new BlockItem(ModBlocks.JUJUBE_WINE_BARREL.get(), basicItem()));
	public static final RegistryObject<Item> JUJUBE_WINE_ONE = ITEMS.register("jujube_wine_one",
			() -> new DrinkableItem(wineItem().food(FoodValues.JUJUBE_WINE_ONE), true, true));
	public static final RegistryObject<Item> JUJUBE_WINE_TWO = ITEMS.register("jujube_wine_two",
			() -> new DrinkableItem(wineItem().food(FoodValues.JUJUBE_WINE_TWO), true, true));
	public static final RegistryObject<Item> JUJUBE_WINE_THREE = ITEMS.register("jujube_wine_three",
			() -> new DrinkableItem(wineItem().food(FoodValues.JUJUBE_WINE_THREE), true, true));
	public static final RegistryObject<Item> JUJUBE_WINE_FOUR = ITEMS.register("jujube_wine_four",
			() -> new DrinkableItem(wineItem().food(FoodValues.JUJUBE_WINE_FOUR), true, true));
	public static final RegistryObject<Item> JUJUBE_WINE_FIVE = ITEMS.register("jujube_wine_five",
			() -> new DrinkableItem(wineItem().food(FoodValues.JUJUBE_WINE_FIVE), true, true));
	public static final RegistryObject<Item> JUJUBE_WINE_SIX = ITEMS.register("jujube_wine_six",
			() -> new DrinkableItem(wineItem().food(FoodValues.JUJUBE_WINE_SIX), true, true));
	public static final RegistryObject<Item> JUJUBE_WINE_SEVEN = ITEMS.register("jujube_wine_seven",
			() -> new DrinkableItem(wineItem().food(FoodValues.JUJUBE_WINE_SEVEN), true, true));
	public static final RegistryObject<Item> JUJUBE_WINE_EIGHT = ITEMS.register("jujube_wine_eight",
			() -> new DrinkableItem(wineItem().food(FoodValues.JUJUBE_WINE_EIGHT), true, true));
	public static final RegistryObject<Item> JUJUBE_WINE_NINE = ITEMS.register("jujube_wine_nine",
			() -> new DrinkableItem(wineItem().food(FoodValues.JUJUBE_WINE_NINE), true, true));
	public static final RegistryObject<Item> JUJUBE_WINE_TEN = ITEMS.register("jujube_wine_ten",
			() -> new DrinkableItem(wineItem().food(FoodValues.JUJUBE_WINE_TEN), true, true));
	public static final RegistryObject<Item> BEST_JUJUBE_WINE = ITEMS.register("best_jujube_wine",
			() -> new BestWineItem(wineItem(), true, true));
	public static final RegistryObject<Item> JUJUBE_POPSICLE_MACHINE = ITEMS.register("jujube_popsicle_machine",
			() -> new BlockItem(ModBlocks.JUJUBE_POPSICLE_MACHINE.get(), basicItem()));
	public static final RegistryObject<Item> JUJUBE_MILK_TEA = ITEMS.register("jujube_milk_tea",
			() -> new DrinkableItem(juiceItem().food(FoodValues.JUJUBE_MILK_TEA), true, false));
	//apricot
	public static final RegistryObject<Item> APRICOT = ITEMS.register("apricot",
			() -> new Item(foodItem(FoodValues.APRICOT).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> APRICOT_SAPLING = ITEMS.register("apricot_sapling",
			() -> new BlockItem(ModBlocks.APRICOT_SAPLING.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> APRICOT_POPSICLE = ITEMS.register("apricot_popsicle",
			() -> new PopsicleItem(foodItem(FoodValues.APRICOT_POPSICLE).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> APRICOT_CAKE = ITEMS.register("apricot_cake",
			()-> new ItemNameBlockItem(ModBlocks.APRICOT_CAKE.get(),new Item.Properties()
					.tab(fruitstack.CREATIVE_TAB)
			));
	public static final RegistryObject<Item> APRICOT_PIE = ITEMS.register("apricot_pie",
			() -> new BlockItem(ModBlocks.APRICOT_PIE.get(), basicItem()));
	public static final RegistryObject<Item> APRICOT_PIE_SLICE = ITEMS.register("apricot_pie_slice",
			() -> new Item(foodItem(FoodValues.APRICOT_PIE_SLICE)));
	public static final RegistryObject<Item> APRICOT_CAKE_SLICE = ITEMS.register("apricot_cake_slice",
			() -> new Item(foodItem(FoodValues.APRICOT_CAKE_SLICE)));
	public static final RegistryObject<Item> APRICOT_CRATE = ITEMS.register("apricot_crate",
			() -> new BlockItem(ModBlocks.APRICOT_CRATE.get(), basicItem()));
	public static final RegistryObject<Item> APRICOT_COOKIE = ITEMS.register("apricot_cookie",
			() -> new Item(foodItem(FoodValues.APRICOT_COOKIE)));
	public static final RegistryObject<Item> APRICOT_JAM = ITEMS.register("apricot_jam",
			() -> new BlockItem(ModBlocks.APRICOT_JAM.get(), basicItem()));
	public static final RegistryObject<Item> APRICOT_BREAD = ITEMS.register("apricot_bread",
			() -> new Item(foodItem(FoodValues.APRICOT_BREAD).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> APRICOT_DOUGHNUT = ITEMS.register("apricot_doughnut",
			() -> new Item(foodItem(FoodValues.APRICOT_DOUGHNUT).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> APRICOT_JUICE = ITEMS.register("apricot_juice",
			() -> new DrinkableItem(juiceItem().food(FoodValues.APRICOT_JUICE), true, false));
	public static final RegistryObject<Item> APRICOT_SMOOTHIE = ITEMS.register("apricot_smoothie",
			() -> new BlockItem(ModBlocks.APRICOT_SMOOTHIE.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> APRICOT_WINE_BARREL = ITEMS.register("apricot_wine_barrel",
			() -> new BlockItem(ModBlocks.APRICOT_WINE_BARREL.get(), basicItem()));
	public static final RegistryObject<Item> APRICOT_WINE_ONE = ITEMS.register("apricot_wine_one",
			() -> new DrinkableItem(wineItem().food(FoodValues.APRICOT_WINE_ONE), true, true));
	public static final RegistryObject<Item> APRICOT_WINE_TWO = ITEMS.register("apricot_wine_two",
			() -> new DrinkableItem(wineItem().food(FoodValues.APRICOT_WINE_TWO), true, true));
	public static final RegistryObject<Item> APRICOT_WINE_THREE = ITEMS.register("apricot_wine_three",
			() -> new DrinkableItem(wineItem().food(FoodValues.APRICOT_WINE_THREE), true, true));
	public static final RegistryObject<Item> APRICOT_WINE_FOUR = ITEMS.register("apricot_wine_four",
			() -> new DrinkableItem(wineItem().food(FoodValues.APRICOT_WINE_FOUR), true, true));
	public static final RegistryObject<Item> APRICOT_WINE_FIVE = ITEMS.register("apricot_wine_five",
			() -> new DrinkableItem(wineItem().food(FoodValues.APRICOT_WINE_FIVE), true, true));
	public static final RegistryObject<Item> APRICOT_WINE_SIX = ITEMS.register("apricot_wine_six",
			() -> new DrinkableItem(wineItem().food(FoodValues.APRICOT_WINE_SIX), true, true));
	public static final RegistryObject<Item> APRICOT_WINE_SEVEN = ITEMS.register("apricot_wine_seven",
			() -> new DrinkableItem(wineItem().food(FoodValues.APRICOT_WINE_SEVEN), true, true));
	public static final RegistryObject<Item> APRICOT_WINE_EIGHT = ITEMS.register("apricot_wine_eight",
			() -> new DrinkableItem(wineItem().food(FoodValues.APRICOT_WINE_EIGHT), true, true));
	public static final RegistryObject<Item> APRICOT_WINE_NINE = ITEMS.register("apricot_wine_nine",
			() -> new DrinkableItem(wineItem().food(FoodValues.APRICOT_WINE_NINE), true, true));
	public static final RegistryObject<Item> APRICOT_WINE_TEN = ITEMS.register("apricot_wine_ten",
			() -> new DrinkableItem(wineItem().food(FoodValues.APRICOT_WINE_TEN), true, true));
	public static final RegistryObject<Item> BEST_APRICOT_WINE = ITEMS.register("best_apricot_wine",
			() -> new BestWineItem(wineItem(), true, true));
	public static final RegistryObject<Item> APRICOT_POPSICLE_MACHINE = ITEMS.register("apricot_popsicle_machine",
			() -> new BlockItem(ModBlocks.APRICOT_POPSICLE_MACHINE.get(), basicItem()));
	public static final RegistryObject<Item> APRICOT_MILK_TEA = ITEMS.register("apricot_milk_tea",
			() -> new DrinkableItem(juiceItem().food(FoodValues.APRICOT_MILK_TEA), true, false));
	//red_bayberry
	public static final RegistryObject<Item> RED_BAYBERRY = ITEMS.register("red_bayberry",
			() -> new Item(foodItem(FoodValues.RED_BAYBERRY).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> RED_BAYBERRY_SAPLING = ITEMS.register("red_bayberry_sapling",
			() -> new BlockItem(ModBlocks.RED_BAYBERRY_SAPLING.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> RED_BAYBERRY_POPSICLE = ITEMS.register("red_bayberry_popsicle",
			() -> new PopsicleItem(foodItem(FoodValues.RED_BAYBERRY_POPSICLE).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> RED_BAYBERRY_CAKE = ITEMS.register("red_bayberry_cake",
			()-> new ItemNameBlockItem(ModBlocks.RED_BAYBERRY_CAKE.get(),new Item.Properties()
					.tab(fruitstack.CREATIVE_TAB)
			));
	public static final RegistryObject<Item> RED_BAYBERRY_PIE = ITEMS.register("red_bayberry_pie",
			() -> new BlockItem(ModBlocks.RED_BAYBERRY_PIE.get(), basicItem()));
	public static final RegistryObject<Item> RED_BAYBERRY_PIE_SLICE = ITEMS.register("red_bayberry_pie_slice",
			() -> new Item(foodItem(FoodValues.RED_BAYBERRY_PIE_SLICE)));
	public static final RegistryObject<Item> RED_BAYBERRY_CAKE_SLICE = ITEMS.register("red_bayberry_cake_slice",
			() -> new Item(foodItem(FoodValues.RED_BAYBERRY_CAKE_SLICE)));
	public static final RegistryObject<Item> RED_BAYBERRY_CRATE = ITEMS.register("red_bayberry_crate",
			() -> new BlockItem(ModBlocks.RED_BAYBERRY_CRATE.get(), basicItem()));
	public static final RegistryObject<Item> RED_BAYBERRY_COOKIE = ITEMS.register("red_bayberry_cookie",
			() -> new Item(foodItem(FoodValues.RED_BAYBERRY_COOKIE)));
	public static final RegistryObject<Item> SOUR_PLUM_CHICKEN_BLOCK = ITEMS.register("sour_plum_chicken_block",
			() -> new BlockItem(ModBlocks.SOUR_PLUM_CHICKEN_BLOCK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> SOUR_PLUM_CHICKEN = ITEMS.register("sour_plum_chicken",
			() -> new ConsumableItem(bowlFoodItem(FoodValues.SOUR_PLUM_CHICKEN), true));
	public static final RegistryObject<Item> RED_BAYBERRY_JAM = ITEMS.register("red_bayberry_jam",
			() -> new BlockItem(ModBlocks.RED_BAYBERRY_JAM.get(), basicItem()));
	public static final RegistryObject<Item> RED_BAYBERRY_BREAD = ITEMS.register("red_bayberry_bread",
			() -> new Item(foodItem(FoodValues.RED_BAYBERRY_BREAD).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> RED_BAYBERRY_DOUGHNUT = ITEMS.register("red_bayberry_doughnut",
			() -> new Item(foodItem(FoodValues.RED_BAYBERRY_DOUGHNUT).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> RED_BAYBERRY_JUICE = ITEMS.register("red_bayberry_juice",
			() -> new DrinkableItem(juiceItem().food(FoodValues.RED_BAYBERRY_JUICE), true, false));
	public static final RegistryObject<Item> RED_BAYBERRY_WINE_BARREL = ITEMS.register("red_bayberry_wine_barrel",
			() -> new BlockItem(ModBlocks.RED_BAYBERRY_WINE_BARREL.get(), basicItem()));
	public static final RegistryObject<Item> RED_BAYBERRY_WINE_ONE = ITEMS.register("red_bayberry_wine_one",
			() -> new DrinkableItem(wineItem().food(FoodValues.RED_BAYBERRY_WINE_ONE), true, true));
	public static final RegistryObject<Item> RED_BAYBERRY_WINE_TWO = ITEMS.register("red_bayberry_wine_two",
			() -> new DrinkableItem(wineItem().food(FoodValues.RED_BAYBERRY_WINE_TWO), true, true));
	public static final RegistryObject<Item> RED_BAYBERRY_WINE_THREE = ITEMS.register("red_bayberry_wine_three",
			() -> new DrinkableItem(wineItem().food(FoodValues.RED_BAYBERRY_WINE_THREE), true, true));
	public static final RegistryObject<Item> RED_BAYBERRY_WINE_FOUR = ITEMS.register("red_bayberry_wine_four",
			() -> new DrinkableItem(wineItem().food(FoodValues.RED_BAYBERRY_WINE_FOUR), true, true));
	public static final RegistryObject<Item> RED_BAYBERRY_WINE_FIVE = ITEMS.register("red_bayberry_wine_five",
			() -> new DrinkableItem(wineItem().food(FoodValues.RED_BAYBERRY_WINE_FIVE), true, true));
	public static final RegistryObject<Item> RED_BAYBERRY_WINE_SIX = ITEMS.register("red_bayberry_wine_six",
			() -> new DrinkableItem(wineItem().food(FoodValues.RED_BAYBERRY_WINE_SIX), true, true));
	public static final RegistryObject<Item> RED_BAYBERRY_WINE_SEVEN = ITEMS.register("red_bayberry_wine_seven",
			() -> new DrinkableItem(wineItem().food(FoodValues.RED_BAYBERRY_WINE_SEVEN), true, true));
	public static final RegistryObject<Item> RED_BAYBERRY_WINE_EIGHT = ITEMS.register("red_bayberry_wine_eight",
			() -> new DrinkableItem(wineItem().food(FoodValues.RED_BAYBERRY_WINE_EIGHT), true, true));
	public static final RegistryObject<Item> RED_BAYBERRY_WINE_NINE = ITEMS.register("red_bayberry_wine_nine",
			() -> new DrinkableItem(wineItem().food(FoodValues.RED_BAYBERRY_WINE_NINE), true, true));
	public static final RegistryObject<Item> RED_BAYBERRY_WINE_TEN = ITEMS.register("red_bayberry_wine_ten",
			() -> new DrinkableItem(wineItem().food(FoodValues.RED_BAYBERRY_WINE_TEN), true, true));
	public static final RegistryObject<Item> BEST_RED_BAYBERRY_WINE = ITEMS.register("best_red_bayberry_wine",
			() -> new BestWineItem(wineItem(), true, true));
	public static final RegistryObject<Item> RED_BAYBERRY_POPSICLE_MACHINE = ITEMS.register("red_bayberry_popsicle_machine",
			() -> new BlockItem(ModBlocks.RED_BAYBERRY_POPSICLE_MACHINE.get(), basicItem()));
	public static final RegistryObject<Item> RED_BAYBERRY_MILK_TEA = ITEMS.register("red_bayberry_milk_tea",
			() -> new DrinkableItem(juiceItem().food(FoodValues.RED_BAYBERRY_MILK_TEA), true, false));
	//green plum
	public static final RegistryObject<Item> GREEN_PLUM = ITEMS.register("green_plum",
			() -> new Item(foodItem(FoodValues.GREEN_PLUM).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> GREEN_PLUM_SAPLING = ITEMS.register("green_plum_sapling",
			() -> new BlockItem(ModBlocks.GREEN_PLUM_SAPLING.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> GREEN_PLUM_POPSICLE = ITEMS.register("green_plum_popsicle",
			() -> new PopsicleItem(foodItem(FoodValues.GREEN_PLUM_POPSICLE).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> GREEN_PLUM_CAKE = ITEMS.register("green_plum_cake",
			()-> new ItemNameBlockItem(ModBlocks.GREEN_PLUM_CAKE.get(),new Item.Properties()
					.tab(fruitstack.CREATIVE_TAB)
			));
	public static final RegistryObject<Item> GREEN_PLUM_PIE = ITEMS.register("green_plum_pie",
			() -> new BlockItem(ModBlocks.GREEN_PLUM_PIE.get(), basicItem()));
	public static final RegistryObject<Item> GREEN_PLUM_PIE_SLICE = ITEMS.register("green_plum_pie_slice",
			() -> new Item(foodItem(FoodValues.GREEN_PLUM_PIE_SLICE)));
	public static final RegistryObject<Item> GREEN_PLUM_CAKE_SLICE = ITEMS.register("green_plum_cake_slice",
			() -> new Item(foodItem(FoodValues.GREEN_PLUM_CAKE_SLICE)));
	public static final RegistryObject<Item> GREEN_PLUM_CRATE = ITEMS.register("green_plum_crate",
			() -> new BlockItem(ModBlocks.GREEN_PLUM_CRATE.get(), basicItem()));
	public static final RegistryObject<Item> GREEN_PLUM_COOKIE = ITEMS.register("green_plum_cookie",
			() -> new Item(foodItem(FoodValues.GREEN_PLUM_COOKIE)));
	public static final RegistryObject<Item> GREEN_PLUM_JAM = ITEMS.register("green_plum_jam",
			() -> new BlockItem(ModBlocks.GREEN_PLUM_JAM.get(), basicItem()));
	public static final RegistryObject<Item> GREEN_PLUM_BREAD = ITEMS.register("green_plum_bread",
			() -> new Item(foodItem(FoodValues.GREEN_PLUM_BREAD).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> GREEN_PLUM_DOUGHNUT = ITEMS.register("green_plum_doughnut",
			() -> new Item(foodItem(FoodValues.GREEN_PLUM_DOUGHNUT).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> GREEN_PLUM_JUICE = ITEMS.register("green_plum_juice",
			() -> new DrinkableItem(juiceItem().food(FoodValues.GREEN_PLUM_JUICE), true, false));
	public static final RegistryObject<Item> GREEN_PLUM_WINE_BARREL = ITEMS.register("green_plum_wine_barrel",
			() -> new BlockItem(ModBlocks.GREEN_PLUM_WINE_BARREL.get(), basicItem()));
	public static final RegistryObject<Item> GREEN_PLUM_WINE_ONE = ITEMS.register("green_plum_wine_one",
			() -> new DrinkableItem(wineItem().food(FoodValues.GREEN_PLUM_WINE_ONE), true, true));
	public static final RegistryObject<Item> GREEN_PLUM_WINE_TWO = ITEMS.register("green_plum_wine_two",
			() -> new DrinkableItem(wineItem().food(FoodValues.GREEN_PLUM_WINE_TWO), true, true));
	public static final RegistryObject<Item> GREEN_PLUM_WINE_THREE = ITEMS.register("green_plum_wine_three",
			() -> new DrinkableItem(wineItem().food(FoodValues.GREEN_PLUM_WINE_THREE), true, true));
	public static final RegistryObject<Item> GREEN_PLUM_WINE_FOUR = ITEMS.register("green_plum_wine_four",
			() -> new DrinkableItem(wineItem().food(FoodValues.GREEN_PLUM_WINE_FOUR), true, true));
	public static final RegistryObject<Item> GREEN_PLUM_WINE_FIVE = ITEMS.register("green_plum_wine_five",
			() -> new DrinkableItem(wineItem().food(FoodValues.GREEN_PLUM_WINE_FIVE), true, true));
	public static final RegistryObject<Item> GREEN_PLUM_WINE_SIX = ITEMS.register("green_plum_wine_six",
			() -> new DrinkableItem(wineItem().food(FoodValues.GREEN_PLUM_WINE_SIX), true, true));
	public static final RegistryObject<Item> GREEN_PLUM_WINE_SEVEN = ITEMS.register("green_plum_wine_seven",
			() -> new DrinkableItem(wineItem().food(FoodValues.GREEN_PLUM_WINE_SEVEN), true, true));
	public static final RegistryObject<Item> GREEN_PLUM_WINE_EIGHT = ITEMS.register("green_plum_wine_eight",
			() -> new DrinkableItem(wineItem().food(FoodValues.GREEN_PLUM_WINE_EIGHT), true, true));
	public static final RegistryObject<Item> GREEN_PLUM_WINE_NINE = ITEMS.register("green_plum_wine_nine",
			() -> new DrinkableItem(wineItem().food(FoodValues.GREEN_PLUM_WINE_NINE), true, true));
	public static final RegistryObject<Item> GREEN_PLUM_WINE_TEN = ITEMS.register("green_plum_wine_ten",
			() -> new DrinkableItem(wineItem().food(FoodValues.GREEN_PLUM_WINE_TEN), true, true));
	public static final RegistryObject<Item> BEST_GREEN_PLUM_WINE = ITEMS.register("best_green_plum_wine",
			() -> new BestWineItem(wineItem(), true, true));
	public static final RegistryObject<Item> GREEN_PLUM_POPSICLE_MACHINE = ITEMS.register("green_plum_popsicle_machine",
			() -> new BlockItem(ModBlocks.GREEN_PLUM_POPSICLE_MACHINE.get(), basicItem()));
	public static final RegistryObject<Item> GREEN_PLUM_MILK_TEA = ITEMS.register("green_plum_milk_tea",
			() -> new DrinkableItem(juiceItem().food(FoodValues.GREEN_PLUM_MILK_TEA), true, false));
	//grape
	public static final RegistryObject<Item> GRAPE_CROP_BOTTOM = ITEMS.register("grape_crop_bottom",
			() -> new BlockItem(ModBlocks.GRAPE_CROP_BOTTOM.get(), basicItem()));
	public static final RegistryObject<Item> GRAPE_CROP_MIDDLE = ITEMS.register("grape_crop_middle",
			() -> new BlockItem(ModBlocks.GRAPE_CROP_MIDDLE.get(), basicItem()));
	public static final RegistryObject<Item> GRAPE_CROP_TOP = ITEMS.register("grape_crop_top",
			() -> new BlockItem(ModBlocks.GRAPE_CROP_TOP.get(), basicItem()));
	public static final RegistryObject<Item> GRAPE_CROP = ITEMS.register("grape_crop",
			() -> new BlockItem(ModBlocks.GRAPE_CROP.get(), basicItem()));
	public static final RegistryObject<Item> GRAPE_BRACKET_TOP = ITEMS.register("grape_bracket_top",
			() -> new BlockItem(ModBlocks.GRAPE_BRACKET_TOP.get(), basicItem()));
	public static final RegistryObject<Item> GRAPE_BRACKET = ITEMS.register("grape_bracket",
			() -> new BlockItem(ModBlocks.GRAPE_BRACKET.get(), basicItem()));
	public static final RegistryObject<Item> WILD_GRAPE = ITEMS.register("wild_grape",
			() -> new BlockItem(ModBlocks.WILD_GRAPE.get(), basicItem()));
	public static final RegistryObject<Item> GRAPE = ITEMS.register("grape",
			() -> new Item(foodItem(FoodValues.GRAPE).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> CRUSHED_GRAPES = ITEMS.register("crushed_grapes",
			() -> new Item(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> GRAPE_POPSICLE = ITEMS.register("grape_popsicle",
			() -> new PopsicleItem(foodItem(FoodValues.GRAPE_POPSICLE).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> GRAPE_CAKE = ITEMS.register("grape_cake",
			()-> new ItemNameBlockItem(ModBlocks.GRAPE_CAKE.get(),new Item.Properties()
					.tab(fruitstack.CREATIVE_TAB)
			));
	public static final RegistryObject<Item> GRAPE_PIE = ITEMS.register("grape_pie",
			() -> new BlockItem(ModBlocks.GRAPE_PIE.get(), basicItem()));
	public static final RegistryObject<Item> GRAPE_PIE_SLICE = ITEMS.register("grape_pie_slice",
			() -> new Item(foodItem(FoodValues.GRAPE_PIE_SLICE)));
	public static final RegistryObject<Item> GRAPE_CAKE_SLICE = ITEMS.register("grape_cake_slice",
			() -> new Item(foodItem(FoodValues.GRAPE_CAKE_SLICE)));
	public static final RegistryObject<Item> GRAPE_CRATE = ITEMS.register("grape_crate",
			() -> new BlockItem(ModBlocks.GRAPE_CRATE.get(), basicItem()));
	public static final RegistryObject<Item> GRAPE_COOKIE = ITEMS.register("grape_cookie",
			() -> new Item(foodItem(FoodValues.GRAPE_COOKIE)));
	public static final RegistryObject<Item> GRAPE_JAM = ITEMS.register("grape_jam",
			() -> new BlockItem(ModBlocks.GRAPE_JAM.get(), basicItem()));
	public static final RegistryObject<Item> GRAPE_BREAD = ITEMS.register("grape_bread",
			() -> new Item(foodItem(FoodValues.GRAPE_BREAD).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> GRAPE_DOUGHNUT = ITEMS.register("grape_doughnut",
			() -> new Item(foodItem(FoodValues.GRAPE_DOUGHNUT).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> GRAPE_JUICE = ITEMS.register("grape_juice",
			() -> new DrinkableItem(juiceItem().food(FoodValues.GRAPE_JUICE), true, false));
	public static final RegistryObject<Item> SWEETENED_GRAPE = ITEMS.register("sweetened_grape",
			() -> new BlockItem(ModBlocks.SWEETENED_GRAPE.get(), basicItem()));
	public static final RegistryObject<Item> DRIED_GRAPE = ITEMS.register("dried_grape",
			() -> new Item(foodItem(FoodValues.DRIED_GRAPE).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> GRAPE_JELLY = ITEMS.register("grape_jelly",
			()-> new ItemNameBlockItem(ModBlocks.GRAPE_JELLY.get(),new Item.Properties()
					.tab(fruitstack.CREATIVE_TAB)
			));
	public static final RegistryObject<Item> GRAPE_JELLY_SLICE = ITEMS.register("grape_jelly_slice",
			() -> new Item(foodItem(FoodValues.GRAPE_JELLY_SLICE)));
	public static final RegistryObject<Item> GRAPE_WINE_BARREL = ITEMS.register("grape_wine_barrel",
			() -> new BlockItem(ModBlocks.GRAPE_WINE_BARREL.get(), basicItem()));
	public static final RegistryObject<Item> GRAPE_WINE_ONE = ITEMS.register("grape_wine_one",
			() -> new DrinkableItem(wineItem().food(FoodValues.GRAPE_WINE_ONE), true, true));
	public static final RegistryObject<Item> GRAPE_WINE_TWO = ITEMS.register("grape_wine_two",
			() -> new DrinkableItem(wineItem().food(FoodValues.GRAPE_WINE_TWO), true, true));
	public static final RegistryObject<Item> GRAPE_WINE_THREE = ITEMS.register("grape_wine_three",
			() -> new DrinkableItem(wineItem().food(FoodValues.GRAPE_WINE_THREE), true, true));
	public static final RegistryObject<Item> GRAPE_WINE_FOUR = ITEMS.register("grape_wine_four",
			() -> new DrinkableItem(wineItem().food(FoodValues.GRAPE_WINE_FOUR), true, true));
	public static final RegistryObject<Item> GRAPE_WINE_FIVE = ITEMS.register("grape_wine_five",
			() -> new DrinkableItem(wineItem().food(FoodValues.GRAPE_WINE_FIVE), true, true));
	public static final RegistryObject<Item> GRAPE_WINE_SIX = ITEMS.register("grape_wine_six",
			() -> new DrinkableItem(wineItem().food(FoodValues.GRAPE_WINE_SIX), true, true));
	public static final RegistryObject<Item> GRAPE_WINE_SEVEN = ITEMS.register("grape_wine_seven",
			() -> new DrinkableItem(wineItem().food(FoodValues.GRAPE_WINE_SEVEN), true, true));
	public static final RegistryObject<Item> GRAPE_WINE_EIGHT = ITEMS.register("grape_wine_eight",
			() -> new DrinkableItem(wineItem().food(FoodValues.GRAPE_WINE_EIGHT), true, true));
	public static final RegistryObject<Item> GRAPE_WINE_NINE = ITEMS.register("grape_wine_nine",
			() -> new DrinkableItem(wineItem().food(FoodValues.GRAPE_WINE_NINE), true, true));
	public static final RegistryObject<Item> GRAPE_WINE_TEN = ITEMS.register("grape_wine_ten",
			() -> new DrinkableItem(wineItem().food(FoodValues.GRAPE_WINE_TEN), true, true));
	public static final RegistryObject<Item> BEST_GRAPE_WINE = ITEMS.register("best_grape_wine",
			() -> new BestWineItem(wineItem(), true, true));
	public static final RegistryObject<Item> GRAPE_POPSICLE_MACHINE = ITEMS.register("grape_popsicle_machine",
			() -> new BlockItem(ModBlocks.GRAPE_POPSICLE_MACHINE.get(), basicItem()));
	public static final RegistryObject<Item> GRAPE_MILK_TEA = ITEMS.register("grape_milk_tea",
			() -> new DrinkableItem(juiceItem().food(FoodValues.GRAPE_MILK_TEA), true, false));
	//peach
	public static final RegistryObject<Item> PEACH_BLOCK = ITEMS.register("peach_block",
			() -> new BlockItem(ModBlocks.PEACH_BLOCK.get(), basicItem().stacksTo(64)));
	public static final RegistryObject<Item> PEACH_SLICE = ITEMS.register("peach_slice",
			() -> new Item(foodItem(FoodValues.PEACH_SLICE).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> PEACH_SAPLING = ITEMS.register("peach_sapling",
			() -> new BlockItem(ModBlocks.PEACH_SAPLING.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> PEACH_POPSICLE = ITEMS.register("peach_popsicle",
			() -> new PopsicleItem(foodItem(FoodValues.PEACH_POPSICLE).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> PEACH_CAKE = ITEMS.register("peach_cake",
			()-> new ItemNameBlockItem(ModBlocks.PEACH_CAKE.get(),new Item.Properties()
					.tab(fruitstack.CREATIVE_TAB)
			));
	public static final RegistryObject<Item> PEACH_PIE = ITEMS.register("peach_pie",
			() -> new BlockItem(ModBlocks.PEACH_PIE.get(), basicItem()));
	public static final RegistryObject<Item> PEACH_PIE_SLICE = ITEMS.register("peach_pie_slice",
			() -> new Item(foodItem(FoodValues.PEACH_PIE_SLICE)));
	public static final RegistryObject<Item> PEACH_CAKE_SLICE = ITEMS.register("peach_cake_slice",
			() -> new Item(foodItem(FoodValues.PEACH_CAKE_SLICE)));
	public static final RegistryObject<Item> PEACH_CRATE = ITEMS.register("peach_crate",
			() -> new BlockItem(ModBlocks.PEACH_CRATE.get(), basicItem()));
	public static final RegistryObject<Item> PEACH_COOKIE = ITEMS.register("peach_cookie",
			() -> new Item(foodItem(FoodValues.PEACH_COOKIE)));
	public static final RegistryObject<Item> PEACH_JAM = ITEMS.register("peach_jam",
			() -> new BlockItem(ModBlocks.PEACH_JAM.get(), basicItem()));
	public static final RegistryObject<Item> PEACH_BREAD = ITEMS.register("peach_bread",
			() -> new Item(foodItem(FoodValues.PEACH_BREAD).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> PEACH_DOUGHNUT = ITEMS.register("peach_doughnut",
			() -> new Item(foodItem(FoodValues.PEACH_DOUGHNUT).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> PEACH_JUICE = ITEMS.register("peach_juice",
			() -> new DrinkableItem(juiceItem().food(FoodValues.PEACH_JUICE), true, false));
	public static final RegistryObject<Item> PEACH_WINE_BARREL = ITEMS.register("peach_wine_barrel",
			() -> new BlockItem(ModBlocks.PEACH_WINE_BARREL.get(), basicItem()));
	public static final RegistryObject<Item> PEACH_WINE_ONE = ITEMS.register("peach_wine_one",
			() -> new DrinkableItem(wineItem().food(FoodValues.PEACH_WINE_ONE), true, true));
	public static final RegistryObject<Item> PEACH_WINE_TWO = ITEMS.register("peach_wine_two",
			() -> new DrinkableItem(wineItem().food(FoodValues.PEACH_WINE_TWO), true, true));
	public static final RegistryObject<Item> PEACH_WINE_THREE = ITEMS.register("peach_wine_three",
			() -> new DrinkableItem(wineItem().food(FoodValues.PEACH_WINE_THREE), true, true));
	public static final RegistryObject<Item> PEACH_WINE_FOUR = ITEMS.register("peach_wine_four",
			() -> new DrinkableItem(wineItem().food(FoodValues.PEACH_WINE_FOUR), true, true));
	public static final RegistryObject<Item> PEACH_WINE_FIVE = ITEMS.register("peach_wine_five",
			() -> new DrinkableItem(wineItem().food(FoodValues.PEACH_WINE_FIVE), true, true));
	public static final RegistryObject<Item> PEACH_WINE_SIX = ITEMS.register("peach_wine_six",
			() -> new DrinkableItem(wineItem().food(FoodValues.PEACH_WINE_SIX), true, true));
	public static final RegistryObject<Item> PEACH_WINE_SEVEN = ITEMS.register("peach_wine_seven",
			() -> new DrinkableItem(wineItem().food(FoodValues.PEACH_WINE_SEVEN), true, true));
	public static final RegistryObject<Item> PEACH_WINE_EIGHT = ITEMS.register("peach_wine_eight",
			() -> new DrinkableItem(wineItem().food(FoodValues.PEACH_WINE_EIGHT), true, true));
	public static final RegistryObject<Item> PEACH_WINE_NINE = ITEMS.register("peach_wine_nine",
			() -> new DrinkableItem(wineItem().food(FoodValues.PEACH_WINE_NINE), true, true));
	public static final RegistryObject<Item> PEACH_WINE_TEN = ITEMS.register("peach_wine_ten",
			() -> new DrinkableItem(wineItem().food(FoodValues.PEACH_WINE_TEN), true, true));
	public static final RegistryObject<Item> BEST_PEACH_WINE = ITEMS.register("best_peach_wine",
			() -> new BestWineItem(wineItem(), true, true));
	public static final RegistryObject<Item> PEACH_POPSICLE_MACHINE = ITEMS.register("peach_popsicle_machine",
			() -> new BlockItem(ModBlocks.PEACH_POPSICLE_MACHINE.get(), basicItem()));
	public static final RegistryObject<Item> PEACH_MILK_TEA = ITEMS.register("peach_milk_tea",
			() -> new DrinkableItem(juiceItem().food(FoodValues.PEACH_MILK_TEA), true, false));
	public static final RegistryObject<Item> SWEETENED_PEACH = ITEMS.register("sweetened_peach",
			() -> new BlockItem(ModBlocks.SWEETENED_PEACH.get(), basicItem()));
	public static final RegistryObject<Item> DRIED_PEACH = ITEMS.register("dried_peach",
			() -> new Item(foodItem(FoodValues.DRIED_PEACH).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> LACTOBACILLUS_HONEY_PEACH_ICE = ITEMS.register("lactobacillus_honey_peach_ice",
			() -> new BlockItem(ModBlocks.LACTOBACILLUS_HONEY_PEACH_ICE.get(), basicItem().stacksTo(1)));
	//zongzi
	public static final RegistryObject<Item> WILD_GLUTINOUS_RICE = ITEMS.register("wild_glutinous_rice",
			() -> new BlockItem(ModBlocks.WILD_GLUTINOUS_RICE.get(), basicItem()));
	public static final RegistryObject<Item> GLUTINOUS_RICE_BAG = ITEMS.register("glutinous_rice_bag",
			() -> new BlockItem(ModBlocks.GLUTINOUS_RICE_BAG.get(), basicItem()));
	public static final RegistryObject<Item> GLUTINOUS_RICE_BALE = ITEMS.register("glutinous_rice_bale",
			() -> new BlockItem(ModBlocks.GLUTINOUS_RICE_BALE.get(), basicItem()));
	public static final RegistryObject<Item> ZONG_ZI_LEAVES = ITEMS.register("zong_zi_leaves",
			()-> new ItemNameBlockItem(ModBlocks.ZONG_ZI_LEAVES_CROP.get(),new Item.Properties()
					.tab(fruitstack.CREATIVE_TAB)
			));
	public static final RegistryObject<Item> WILD_ZONG_ZI_LEAVES = ITEMS.register("wild_zong_zi_leaves",
			() -> new BlockItem(ModBlocks.WILD_ZONG_ZI_LEAVES.get(), basicItem()));
	public static final RegistryObject<Item> GLUTINOUS_RICE = ITEMS.register("glutinous_rice",
			() -> new GlutinousRiceItem(ModBlocks.GLUTINOUS_RICE_CROP.get(), basicItem()));
	public static final RegistryObject<Item> GLUTINOUS_RICE_PANICLE = ITEMS.register("glutinous_rice_panicle",
			() -> new Item(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> ZONG_ZI = ITEMS.register("zong_zi",
			() -> new BlockItem(ModBlocks.ZONG_ZI.get(), basicItem()));
	public static final RegistryObject<Item> RAW_ZONG_ZI = ITEMS.register("raw_zong_zi",
			() -> new Item(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> BLUEBERRIES_AND_MANGO_ZONG_ZI = ITEMS.register("blueberries_and_mango_zong_zi",
			() -> new BlockItem(ModBlocks.BLUEBERRIES_AND_MANGO_ZONG_ZI.get(), basicItem()));
	public static final RegistryObject<Item> RAW_BLUEBERRIES_AND_MANGO_ZONG_ZI = ITEMS.register("raw_blueberries_and_mango_zong_zi",
			() -> new Item(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> AGREEABLE_SWEETNESS_ZONG_ZI = ITEMS.register("agreeable_sweetness_zong_zi",
			() -> new BlockItem(ModBlocks.AGREEABLE_SWEETNESS_ZONG_ZI.get(), basicItem()));
	public static final RegistryObject<Item> RAW_AGREEABLE_SWEETNESS_ZONG_ZI = ITEMS.register("raw_agreeable_sweetness_zong_zi",
			() -> new Item(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> MELON_ZONG_ZI = ITEMS.register("melon_zong_zi",
			() -> new BlockItem(ModBlocks.MELON_ZONG_ZI.get(), basicItem()));
	public static final RegistryObject<Item> RAW_MELON_ZONG_ZI = ITEMS.register("raw_melon_zong_zi",
			() -> new Item(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> CRIMSON_ZONG_ZI = ITEMS.register("crimson_zong_zi",
			() -> new BlockItem(ModBlocks.CRIMSON_ZONG_ZI.get(), basicItem()));
	public static final RegistryObject<Item> RAW_CRIMSON_ZONG_ZI = ITEMS.register("raw_crimson_zong_zi",
			() -> new Item(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	//moon cake
	public static final RegistryObject<Item> BLUEBERRIES_MOON_CAKE = ITEMS.register("blueberries_moon_cake",
			() -> new BlockItem(ModBlocks.BLUEBERRIES_MOON_CAKE.get(), basicItem()));
	public static final RegistryObject<Item> RAW_BLUEBERRIES_MOON_CAKE = ITEMS.register("raw_blueberries_moon_cake",
			() -> new RawMoonCakeItem(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> BLUEBERRIES_FILLING = ITEMS.register("blueberries_filling",
			() -> new Item(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> HAMIMELON_MOON_CAKE = ITEMS.register("hamimelon_moon_cake",
			() -> new BlockItem(ModBlocks.HAMIMELON_MOON_CAKE.get(), basicItem()));
	public static final RegistryObject<Item> RAW_HAMIMELON_MOON_CAKE = ITEMS.register("raw_hamimelon_moon_cake",
			() -> new RawMoonCakeItem(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> HAMIMELON_FILLING = ITEMS.register("hamimelon_filling",
			() -> new Item(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> BEATING_MELONS_MOON_CAKE = ITEMS.register("beating_melons_moon_cake",
			() -> new BlockItem(ModBlocks.BEATING_MELONS_MOON_CAKE.get(), basicItem()));
	public static final RegistryObject<Item> RAW_BEATING_MELONS_MOON_CAKE = ITEMS.register("raw_beating_melons_moon_cake",
			() -> new RawMoonCakeItem(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> BEATING_MELONS_FILLING = ITEMS.register("beating_melons_filling",
			() -> new Item(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> GROUND_CUCUMBER_MOON_CAKE = ITEMS.register("ground_cucumber_moon_cake",
			() -> new BlockItem(ModBlocks.GROUND_CUCUMBER_MOON_CAKE.get(), basicItem()));
	public static final RegistryObject<Item> RAW_GROUND_CUCUMBER_MOON_CAKE = ITEMS.register("raw_ground_cucumber_moon_cake",
			() -> new RawMoonCakeItem(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> GROUND_CUCUMBER_FILLING = ITEMS.register("ground_cucumber_filling",
			() -> new Item(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> MANGO_MOON_CAKE = ITEMS.register("mango_moon_cake",
			() -> new BlockItem(ModBlocks.MANGO_MOON_CAKE.get(), basicItem()));
	public static final RegistryObject<Item> RAW_MANGO_MOON_CAKE = ITEMS.register("raw_mango_moon_cake",
			() -> new RawMoonCakeItem(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> MANGO_FILLING = ITEMS.register("mango_filling",
			() -> new Item(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_MOON_CAKE = ITEMS.register("holboellia_latifolia_moon_cake",
			() -> new BlockItem(ModBlocks.HOLBOELLIA_LATIFOLIA_MOON_CAKE.get(), basicItem()));
	public static final RegistryObject<Item> RAW_HOLBOELLIA_LATIFOLIA_MOON_CAKE = ITEMS.register("raw_holboellia_latifolia_moon_cake",
			() -> new RawMoonCakeItem(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_FILLING = ITEMS.register("holboellia_latifolia_filling",
			() -> new Item(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> LITCHI_MOON_CAKE = ITEMS.register("litchi_moon_cake",
			() -> new BlockItem(ModBlocks.LITCHI_MOON_CAKE.get(), basicItem()));
	public static final RegistryObject<Item> RAW_LITCHI_MOON_CAKE = ITEMS.register("raw_litchi_moon_cake",
			() -> new RawMoonCakeItem(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> LITCHI_FILLING = ITEMS.register("litchi_filling",
			() -> new Item(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_MOON_CAKE = ITEMS.register("huoshen_fruit_moon_cake",
			() -> new BlockItem(ModBlocks.HUOSHEN_FRUIT_MOON_CAKE.get(), basicItem()));
	public static final RegistryObject<Item> RAW_HUOSHEN_FRUIT_MOON_CAKE = ITEMS.register("raw_huoshen_fruit_moon_cake",
			() -> new RawMoonCakeItem(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_FILLING = ITEMS.register("huoshen_fruit_filling",
			() -> new Item(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> SEPTEMBER_MELON_MOON_CAKE = ITEMS.register("september_melon_moon_cake",
			() -> new BlockItem(ModBlocks.SEPTEMBER_MELON_MOON_CAKE.get(), basicItem()));
	public static final RegistryObject<Item> RAW_SEPTEMBER_MELON_MOON_CAKE = ITEMS.register("raw_september_melon_moon_cake",
			() -> new RawMoonCakeItem(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> SEPTEMBER_MELON_FILLING = ITEMS.register("september_melon_filling",
			() -> new Item(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> PITAYA_MOON_CAKE = ITEMS.register("pitaya_moon_cake",
			() -> new BlockItem(ModBlocks.PITAYA_MOON_CAKE.get(), basicItem()));
	public static final RegistryObject<Item> RAW_PITAYA_MOON_CAKE = ITEMS.register("raw_pitaya_moon_cake",
			() -> new RawMoonCakeItem(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> PITAYA_FILLING = ITEMS.register("pitaya_filling",
			() -> new Item(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_MOON_CAKE = ITEMS.register("golden_pure_sheep_horn_honey_moon_cake",
			() -> new BlockItem(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_MOON_CAKE.get(), basicItem()));
	public static final RegistryObject<Item> RAW_GOLDEN_PURE_SHEEP_HORN_HONEY_MOON_CAKE = ITEMS.register("raw_golden_pure_sheep_horn_honey_moon_cake",
			() -> new RawMoonCakeItem(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_FILLING = ITEMS.register("golden_pure_sheep_horn_honey_filling",
			() -> new Item(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> PEAR_MOON_CAKE = ITEMS.register("pear_moon_cake",
			() -> new BlockItem(ModBlocks.PEAR_MOON_CAKE.get(), basicItem()));
	public static final RegistryObject<Item> RAW_PEAR_MOON_CAKE = ITEMS.register("raw_pear_moon_cake",
			() -> new RawMoonCakeItem(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> PEAR_FILLING = ITEMS.register("pear_filling",
			() -> new Item(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> MAYTHORN_MOON_CAKE = ITEMS.register("maythorn_moon_cake",
			() -> new BlockItem(ModBlocks.MAYTHORN_MOON_CAKE.get(), basicItem()));
	public static final RegistryObject<Item> RAW_MAYTHORN_MOON_CAKE = ITEMS.register("raw_maythorn_moon_cake",
			() -> new RawMoonCakeItem(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> MAYTHORN_FILLING = ITEMS.register("maythorn_filling",
			() -> new Item(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_MOON_CAKE = ITEMS.register("chinese_pear_leaved_moon_cake",
			() -> new BlockItem(ModBlocks.CHINESE_PEAR_LEAVED_MOON_CAKE.get(), basicItem()));
	public static final RegistryObject<Item> RAW_CHINESE_PEAR_LEAVED_MOON_CAKE = ITEMS.register("raw_chinese_pear_leaved_moon_cake",
			() -> new RawMoonCakeItem(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_FILLING = ITEMS.register("chinese_pear_leaved_filling",
			() -> new Item(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> PLUM_MOON_CAKE = ITEMS.register("plum_moon_cake",
			() -> new BlockItem(ModBlocks.PLUM_MOON_CAKE.get(), basicItem()));
	public static final RegistryObject<Item> RAW_PLUM_MOON_CAKE = ITEMS.register("raw_plum_moon_cake",
			() -> new RawMoonCakeItem(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> PLUM_FILLING = ITEMS.register("plum_filling",
			() -> new Item(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> JUJUBE_MOON_CAKE = ITEMS.register("jujube_moon_cake",
			() -> new BlockItem(ModBlocks.JUJUBE_MOON_CAKE.get(), basicItem()));
	public static final RegistryObject<Item> RAW_JUJUBE_MOON_CAKE = ITEMS.register("raw_jujube_moon_cake",
			() -> new RawMoonCakeItem(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> JUJUBE_FILLING = ITEMS.register("jujube_filling",
			() -> new Item(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> APRICOT_MOON_CAKE = ITEMS.register("apricot_moon_cake",
			() -> new BlockItem(ModBlocks.APRICOT_MOON_CAKE.get(), basicItem()));
	public static final RegistryObject<Item> RAW_APRICOT_MOON_CAKE = ITEMS.register("raw_apricot_moon_cake",
			() -> new RawMoonCakeItem(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> APRICOT_FILLING = ITEMS.register("apricot_filling",
			() -> new Item(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> RED_BAYBERRY_MOON_CAKE = ITEMS.register("red_bayberry_moon_cake",
			() -> new BlockItem(ModBlocks.RED_BAYBERRY_MOON_CAKE.get(), basicItem()));
	public static final RegistryObject<Item> RAW_RED_BAYBERRY_MOON_CAKE = ITEMS.register("raw_red_bayberry_moon_cake",
			() -> new RawMoonCakeItem(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> RED_BAYBERRY_FILLING = ITEMS.register("red_bayberry_filling",
			() -> new Item(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> GREEN_PLUM_MOON_CAKE = ITEMS.register("green_plum_moon_cake",
			() -> new BlockItem(ModBlocks.GREEN_PLUM_MOON_CAKE.get(), basicItem()));
	public static final RegistryObject<Item> RAW_GREEN_PLUM_MOON_CAKE = ITEMS.register("raw_green_plum_moon_cake",
			() -> new RawMoonCakeItem(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> GREEN_PLUM_FILLING = ITEMS.register("green_plum_filling",
			() -> new Item(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> GRAPE_MOON_CAKE = ITEMS.register("grape_moon_cake",
			() -> new BlockItem(ModBlocks.GRAPE_MOON_CAKE.get(), basicItem()));
	public static final RegistryObject<Item> RAW_GRAPE_MOON_CAKE = ITEMS.register("raw_grape_moon_cake",
			() -> new RawMoonCakeItem(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> GRAPE_FILLING = ITEMS.register("grape_filling",
			() -> new Item(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> PEACH_MOON_CAKE = ITEMS.register("peach_moon_cake",
			() -> new BlockItem(ModBlocks.PEACH_MOON_CAKE.get(), basicItem()));
	public static final RegistryObject<Item> RAW_PEACH_MOON_CAKE = ITEMS.register("raw_peach_moon_cake",
			() -> new RawMoonCakeItem(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> PEACH_FILLING = ITEMS.register("peach_filling",
			() -> new Item(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	//rice dumpling
	public static final RegistryObject<Item> SPOON = ITEMS.register("spoon",
			() -> new ConsumableItem(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> RICE_DUMPLING_POT = ITEMS.register("rice_dumpling_pot",
			() -> new ConsumableItem(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> BLUEBERRIES_RICE_DUMPLING_BLOCK = ITEMS.register("blueberries_rice_dumpling_block",
			() -> new BlockItem(ModBlocks.BLUEBERRIES_RICE_DUMPLING_BLOCK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> BLUEBERRIES_RICE_DUMPLING = ITEMS.register("blueberries_rice_dumpling",
			() -> new ConsumableItem(foodItem(FoodValues.BLUEBERRIES_RICE_DUMPLING).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> HAMIMELON_RICE_DUMPLING_BLOCK = ITEMS.register("hamimelon_rice_dumpling_block",
			() -> new BlockItem(ModBlocks.HAMIMELON_RICE_DUMPLING_BLOCK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> HAMIMELON_RICE_DUMPLING = ITEMS.register("hamimelon_rice_dumpling",
			() -> new ConsumableItem(foodItem(FoodValues.HAMIMELON_RICE_DUMPLING).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> BEATING_MELONS_RICE_DUMPLING_BLOCK = ITEMS.register("beating_melons_rice_dumpling_block",
			() -> new BlockItem(ModBlocks.BEATING_MELONS_RICE_DUMPLING_BLOCK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> BEATING_MELONS_RICE_DUMPLING = ITEMS.register("beating_melons_rice_dumpling",
			() -> new ConsumableItem(foodItem(FoodValues.BEATING_MELONS_RICE_DUMPLING).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> GROUND_CUCUMBER_RICE_DUMPLING_BLOCK = ITEMS.register("ground_cucumber_rice_dumpling_block",
			() -> new BlockItem(ModBlocks.GROUND_CUCUMBER_RICE_DUMPLING_BLOCK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> GROUND_CUCUMBER_RICE_DUMPLING = ITEMS.register("ground_cucumber_rice_dumpling",
			() -> new ConsumableItem(foodItem(FoodValues.GROUND_CUCUMBER_RICE_DUMPLING).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> MANGO_RICE_DUMPLING_BLOCK = ITEMS.register("mango_rice_dumpling_block",
			() -> new BlockItem(ModBlocks.MANGO_RICE_DUMPLING_BLOCK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> MANGO_RICE_DUMPLING = ITEMS.register("mango_rice_dumpling",
			() -> new ConsumableItem(foodItem(FoodValues.MANGO_RICE_DUMPLING).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_RICE_DUMPLING_BLOCK = ITEMS.register("holboellia_latifolia_rice_dumpling_block",
			() -> new BlockItem(ModBlocks.HOLBOELLIA_LATIFOLIA_RICE_DUMPLING_BLOCK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_RICE_DUMPLING = ITEMS.register("holboellia_latifolia_rice_dumpling",
			() -> new ConsumableItem(foodItem(FoodValues.HOLBOELLIA_LATIFOLIA_RICE_DUMPLING).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> LITCHI_RICE_DUMPLING_BLOCK = ITEMS.register("litchi_rice_dumpling_block",
			() -> new BlockItem(ModBlocks.LITCHI_RICE_DUMPLING_BLOCK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> LITCHI_RICE_DUMPLING = ITEMS.register("litchi_rice_dumpling",
			() -> new ConsumableItem(foodItem(FoodValues.LITCHI_RICE_DUMPLING).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_RICE_DUMPLING_BLOCK = ITEMS.register("huoshen_fruit_rice_dumpling_block",
			() -> new BlockItem(ModBlocks.HUOSHEN_FRUIT_RICE_DUMPLING_BLOCK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_RICE_DUMPLING = ITEMS.register("huoshen_fruit_rice_dumpling",
			() -> new ConsumableItem(foodItem(FoodValues.HUOSHEN_FRUIT_RICE_DUMPLING).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> SEPTEMBER_MELON_RICE_DUMPLING_BLOCK = ITEMS.register("september_melon_rice_dumpling_block",
			() -> new BlockItem(ModBlocks.SEPTEMBER_MELON_RICE_DUMPLING_BLOCK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> SEPTEMBER_MELON_RICE_DUMPLING = ITEMS.register("september_melon_rice_dumpling",
			() -> new ConsumableItem(foodItem(FoodValues.SEPTEMBER_MELON_RICE_DUMPLING).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> PITAYA_RICE_DUMPLING_BLOCK = ITEMS.register("pitaya_rice_dumpling_block",
			() -> new BlockItem(ModBlocks.PITAYA_RICE_DUMPLING_BLOCK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> PITAYA_RICE_DUMPLING = ITEMS.register("pitaya_rice_dumpling",
			() -> new ConsumableItem(foodItem(FoodValues.PITAYA_RICE_DUMPLING).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_RICE_DUMPLING_BLOCK = ITEMS.register("golden_pure_sheep_horn_honey_rice_dumpling_block",
			() -> new BlockItem(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_RICE_DUMPLING_BLOCK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_RICE_DUMPLING = ITEMS.register("golden_pure_sheep_horn_honey_rice_dumpling",
			() -> new ConsumableItem(foodItem(FoodValues.GOLDEN_PURE_SHEEP_HORN_HONEY_RICE_DUMPLING).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> PEAR_RICE_DUMPLING_BLOCK = ITEMS.register("pear_rice_dumpling_block",
			() -> new BlockItem(ModBlocks.PEAR_RICE_DUMPLING_BLOCK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> PEAR_RICE_DUMPLING = ITEMS.register("pear_rice_dumpling",
			() -> new ConsumableItem(foodItem(FoodValues.PEAR_RICE_DUMPLING).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> MAYTHORN_RICE_DUMPLING_BLOCK = ITEMS.register("maythorn_rice_dumpling_block",
			() -> new BlockItem(ModBlocks.MAYTHORN_RICE_DUMPLING_BLOCK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> MAYTHORN_RICE_DUMPLING = ITEMS.register("maythorn_rice_dumpling",
			() -> new ConsumableItem(foodItem(FoodValues.MAYTHORN_RICE_DUMPLING).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_RICE_DUMPLING_BLOCK = ITEMS.register("chinese_pear_leaved_rice_dumpling_block",
			() -> new BlockItem(ModBlocks.CHINESE_PEAR_LEAVED_RICE_DUMPLING_BLOCK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_RICE_DUMPLING = ITEMS.register("chinese_pear_leaved_rice_dumpling",
			() -> new ConsumableItem(foodItem(FoodValues.CHINESE_PEAR_LEAVED_RICE_DUMPLING).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> PLUM_RICE_DUMPLING_BLOCK = ITEMS.register("plum_rice_dumpling_block",
			() -> new BlockItem(ModBlocks.PLUM_RICE_DUMPLING_BLOCK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> PLUM_RICE_DUMPLING = ITEMS.register("plum_rice_dumpling",
			() -> new ConsumableItem(foodItem(FoodValues.PLUM_RICE_DUMPLING).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> JUJUBE_RICE_DUMPLING_BLOCK = ITEMS.register("jujube_rice_dumpling_block",
			() -> new BlockItem(ModBlocks.JUJUBE_RICE_DUMPLING_BLOCK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> JUJUBE_RICE_DUMPLING = ITEMS.register("jujube_rice_dumpling",
			() -> new ConsumableItem(foodItem(FoodValues.JUJUBE_RICE_DUMPLING).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> APRICOT_RICE_DUMPLING_BLOCK = ITEMS.register("apricot_rice_dumpling_block",
			() -> new BlockItem(ModBlocks.APRICOT_RICE_DUMPLING_BLOCK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> APRICOT_RICE_DUMPLING = ITEMS.register("apricot_rice_dumpling",
			() -> new ConsumableItem(foodItem(FoodValues.APRICOT_RICE_DUMPLING).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> RED_BAYBERRY_RICE_DUMPLING_BLOCK = ITEMS.register("red_bayberry_rice_dumpling_block",
			() -> new BlockItem(ModBlocks.RED_BAYBERRY_RICE_DUMPLING_BLOCK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> RED_BAYBERRY_RICE_DUMPLING = ITEMS.register("red_bayberry_rice_dumpling",
			() -> new ConsumableItem(foodItem(FoodValues.RED_BAYBERRY_RICE_DUMPLING).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> GREEN_PLUM_RICE_DUMPLING_BLOCK = ITEMS.register("green_plum_rice_dumpling_block",
			() -> new BlockItem(ModBlocks.GREEN_PLUM_RICE_DUMPLING_BLOCK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> GREEN_PLUM_RICE_DUMPLING = ITEMS.register("green_plum_rice_dumpling",
			() -> new ConsumableItem(foodItem(FoodValues.GREEN_PLUM_RICE_DUMPLING).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> GRAPE_RICE_DUMPLING_BLOCK = ITEMS.register("grape_rice_dumpling_block",
			() -> new BlockItem(ModBlocks.GRAPE_RICE_DUMPLING_BLOCK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> GRAPE_RICE_DUMPLING = ITEMS.register("grape_rice_dumpling",
			() -> new ConsumableItem(foodItem(FoodValues.GRAPE_RICE_DUMPLING).tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> PEACH_RICE_DUMPLING_BLOCK = ITEMS.register("peach_rice_dumpling_block",
			() -> new BlockItem(ModBlocks.PEACH_RICE_DUMPLING_BLOCK.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> PEACH_RICE_DUMPLING = ITEMS.register("peach_rice_dumpling",
			() -> new ConsumableItem(foodItem(FoodValues.PEACH_RICE_DUMPLING).tab(fruitstack.CREATIVE_TAB)));
    //pizza
	public static final RegistryObject<Item> ROLLING_PIN = ITEMS.register("rolling_pin",
			() -> new Item(new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PIZZA_DOUGH = ITEMS.register("pizza_dough",
			() -> new BlockItem(ModBlocks.PIZZA_DOUGH.get(), basicItem()));
	public static final RegistryObject<Item> UNBAKED_GRAPE_FRUIT_SAND_PIZZA = ITEMS.register("unbaked_grape_fruit_sand_pizza",
			() -> new Item(new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(16)));
	public static final RegistryObject<Item> UNBAKED_BLUE_RED_MANGO_PIZZA = ITEMS.register("unbaked_blue_red_mango_pizza",
			() -> new Item(new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(16)));
	public static final RegistryObject<Item> UNBAKED_HAWTHORN_NUT_PIZZA = ITEMS.register("unbaked_hawthorn_nut_pizza",
			() -> new Item(new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(16)));
	public static final RegistryObject<Item> UNBAKED_SWEET_AND_REFRESHING_FLAVORED_PIZZA = ITEMS.register("unbaked_sweet_and_refreshing_flavored_pizza",
			() -> new Item(new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(16)));
	public static final RegistryObject<Item> GRAPE_FRUIT_SAND_PIZZA = ITEMS.register("grape_fruit_sand_pizza",
			() -> new BlockItem(ModBlocks.GRAPE_FRUIT_SAND_PIZZA.get(), basicItem()));
	public static final RegistryObject<Item> GRAPE_FRUIT_SAND_PIZZA_SLICE = ITEMS.register("grape_fruit_sand_pizza_slice",
			() -> new Item(foodItem(FoodValues.GRAPE_FRUIT_SAND_PIZZA_SLICE)));
	public static final RegistryObject<Item> BLUE_RED_MANGO_PIZZA = ITEMS.register("blue_red_mango_pizza",
			() -> new BlockItem(ModBlocks.BLUE_RED_MANGO_PIZZA.get(), basicItem()));
	public static final RegistryObject<Item> BLUE_RED_MANGO_PIZZA_SLICE = ITEMS.register("blue_red_mango_pizza_slice",
			() -> new Item(foodItem(FoodValues.BLUE_RED_MANGO_PIZZA_SLICE)));
	public static final RegistryObject<Item> HAWTHORN_NUT_PIZZA = ITEMS.register("hawthorn_nut_pizza",
			() -> new BlockItem(ModBlocks.HAWTHORN_NUT_PIZZA.get(), basicItem()));
	public static final RegistryObject<Item> HAWTHORN_NUT_PIZZA_SLICE = ITEMS.register("hawthorn_nut_pizza_slice",
			() -> new Item(foodItem(FoodValues.HAWTHORN_NUT_PIZZA_SLICE)));
	public static final RegistryObject<Item> SWEET_AND_REFRESHING_FLAVORED_PIZZA = ITEMS.register("sweet_and_refreshing_flavored_pizza",
			() -> new BlockItem(ModBlocks.SWEET_AND_REFRESHING_FLAVORED_PIZZA.get(), basicItem()));
	public static final RegistryObject<Item> SWEET_AND_REFRESHING_FLAVORED_PIZZA_SLICE = ITEMS.register("sweet_and_refreshing_flavored_pizza_slice",
			() -> new Item(foodItem(FoodValues.SWEET_AND_REFRESHING_FLAVORED_PIZZA_SLICE)));
	//fruit knfie
	public static final RegistryObject<Item> FLINT_FRUIT_KNIFE = ITEMS.register("flint_fruit_knife",
			() -> new FruitKnife(ModMaterials.FLINT, 0.6F, -2.0F, basicItem()));
	public static final RegistryObject<Item> IRON_FRUIT_KNIFE = ITEMS.register("iron_fruit_knife",
			() -> new FruitKnife(Tiers.IRON, 0.6F, -2.0F, basicItem()));
	public static final RegistryObject<Item> DIAMOND_FRUIT_KNIFE = ITEMS.register("diamond_fruit_knife",
			() -> new FruitKnife(Tiers.DIAMOND, 0.6F, -2.0F, basicItem()));
	public static final RegistryObject<Item> NETHERITE_FRUIT_KNIFE = ITEMS.register("netherite_fruit_knife",
			() -> new FruitKnife(Tiers.NETHERITE, 0.6F, -2.0F, basicItem().fireResistant()));
	public static final RegistryObject<Item> GOLDEN_FRUIT_KNIFE = ITEMS.register("golden_fruit_knife",
			() -> new FruitKnife(Tiers.GOLD, 0.6F, -2.0F, basicItem()));
	//pot
	public static final RegistryObject<Item> CLAY_OVEN = ITEMS.register("clay_oven",
			() -> new BlockItem(ModBlocks.CLAY_OVEN.get(), basicItem()));
	public static final RegistryObject<Item> JUICER = ITEMS.register("juicer",
			() -> new BlockItem(ModBlocks.JUICER.get(), basicItem()));
	public static final RegistryObject<Item> TRIPOD_VESSEL_FOR_MAKING_PILLS_OF_IMMORTALITY = ITEMS.register("tripod_vessel_for_making_pills_of_immortality",
			() -> new BlockItem(ModBlocks.TRIPOD_VESSEL_FOR_MAKING_PILLS_OF_IMMORTALITY.get(), basicItem().stacksTo(1)));
	public static final RegistryObject<Item> PLATE = ITEMS.register("plate",
			() -> new BlockItem(ModBlocks.PLATE.get(), basicItem()));
	public static final RegistryObject<Item> BOWL_BLOCK = ITEMS.register("bowl_block",
			() -> new BlockItem(ModBlocks.BOWL_BLOCK.get(), basicItem()));
	public static final RegistryObject<Item> WINE_BARREL = ITEMS.register("wine_barrel",
			() -> new BlockItem(ModBlocks.WINE_BARREL.get(), basicItem()));
	public static final RegistryObject<Item> LOW_WOODEN_BARREL = ITEMS.register("low_wooden_barrel",
			() -> new BlockItem(ModBlocks.LOW_WOODEN_BARREL.get(), basicItem()));
	public static final RegistryObject<Item> POPSICLE_MACHINE = ITEMS.register("popsicle_machine",
			() -> new BlockItem(ModBlocks.POPSICLE_MACHINE.get(), basicItem()));
	public static final RegistryObject<Item> FRYING_PAN = ITEMS.register("frying_pan",
			() -> new BlockItem(ModBlocks.FRYING_PAN.get(), basicItem()));
	public static final RegistryObject<Item> POT_COVER = ITEMS.register("pot_cover",
			() -> new Item(new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> SPATULA = ITEMS.register("spatula",
			() -> new Item(new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> OVEN = ITEMS.register("oven",
			() -> new BlockItem(ModBlocks.OVEN.get(), basicItem()));
    //farmland
    public static final RegistryObject<Item> LIFE_DIRT = ITEMS.register("life_dirt",
            () -> new BlockItem(ModBlocks.LIFE_DIRT.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(64)));
	public static final RegistryObject<Item> LIFE_FARMLAND = ITEMS.register("life_farmland",
			() -> new BlockItem(ModBlocks.LIFE_FARMLAND.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(64)));
	public static final RegistryObject<Item> CORRUPT_SOIL = ITEMS.register("corrupt_soil",
			() -> new BlockItem(ModBlocks.CORRUPT_SOIL.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(64)));
	public static final RegistryObject<Item> CORRUPT_SOIL_FARMLAND = ITEMS.register("corrupt_soil_farmland",
			() -> new BlockItem(ModBlocks.CORRUPT_SOIL_FARMLAND.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(64)));
	public static final RegistryObject<Item> CORRUPT_ESSENCE = ITEMS.register("corrupt_essence",
			() -> new Item(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> LIFE_ESSENCE = ITEMS.register("life_essence",
			() -> new Item(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	public static final RegistryObject<Item> CORPSE = ITEMS.register("corpse",
			() -> new Item(new Item.Properties().tab(fruitstack.CREATIVE_TAB)));
	//recipe
	public static final RegistryObject<Item> MANGO_RECIPE_PACKAGE = ITEMS.register("mango_recipe_package",
			() -> new BlockItem(ModBlocks.MANGO_RECIPE_PACKAGE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> MANGO_TREE_RECIPE = ITEMS.register("mango_tree_recipe",
			() -> new BlockItem(ModBlocks.MANGO_TREE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> GREEN_MANGO_SLICE_RECIPE = ITEMS.register("green_mango_slice_recipe", () -> new BlockItem(ModBlocks.GREEN_MANGO_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> MANGO_CAKE_RECIPE = ITEMS.register("mango_cake_recipe",
			() -> new BlockItem(ModBlocks.MANGO_CAKE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> MANGO_CAKE_SLICE_RECIPE = ITEMS.register("mango_cake_slice_recipe",
			() -> new BlockItem(ModBlocks.MANGO_CAKE_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> MANGO_COOKIE_RECIPE = ITEMS.register("mango_cookie_recipe",
			() -> new BlockItem(ModBlocks.MANGO_COOKIE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> MANGO_CRATE_RECIPE = ITEMS.register("mango_crate_recipe",
			() -> new BlockItem(ModBlocks.MANGO_CRATE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> MANGO_JAM_RECIPE = ITEMS.register("mango_jam_recipe",
			() -> new BlockItem(ModBlocks.MANGO_JAM_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> MANGO_PIE_RECIPE = ITEMS.register("mango_pie_recipe",
			() -> new BlockItem(ModBlocks.MANGO_PIE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> MANGO_PIE_SLICE_RECIPE = ITEMS.register("mango_pie_slice_recipe",
			() -> new BlockItem(ModBlocks.MANGO_PIE_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> MANGO_SLICE_RECIPE = ITEMS.register("mango_slice_recipe",
			() -> new BlockItem(ModBlocks.MANGO_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> MANGO_RICE_DUMPLING_BLOCK_RECIPE = ITEMS.register("mango_rice_dumpling_block_recipe",
			() -> new BlockItem(ModBlocks.MANGO_RICE_DUMPLING_BLOCK_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> MANGO_FILLING_RECIPE = ITEMS.register("mango_filling_recipe",
			() -> new BlockItem(ModBlocks.MANGO_FILLING_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> RAW_MANGO_MOON_CAKE_RECIPE = ITEMS.register("raw_mango_moon_cake_recipe",
			() -> new BlockItem(ModBlocks.RAW_MANGO_MOON_CAKE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> SWEETENED_MANGO_RECIPE = ITEMS.register("sweetened_mango_recipe",
			() -> new BlockItem(ModBlocks.SWEETENED_MANGO_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> MANGO_JUICE_RECIPE = ITEMS.register("mango_juice_recipe",
			() -> new BlockItem(ModBlocks.MANGO_JUICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> MANGO_MILK_ICE_CREAM_RECIPE = ITEMS.register("mango_milk_ice_cream_recipe",
			() -> new BlockItem(ModBlocks.MANGO_MILK_ICE_CREAM_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> MANGO_MILK_TEA_RECIPE = ITEMS.register("mango_milk_tea_recipe",
			() -> new BlockItem(ModBlocks.MANGO_MILK_TEA_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));

	public static final RegistryObject<Item> BLUEBERRIES_RECIPE_PACKAGE = ITEMS.register("blueberries_recipe_package",
			() -> new BlockItem(ModBlocks.BLUEBERRIES_RECIPE_PACKAGE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> BLUEBERRIES_CAKE_SLICE_RECIPE = ITEMS.register("blueberries_cake_slice_recipe",
			() -> new BlockItem(ModBlocks.BLUEBERRIES_CAKE_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> BLUEBERRIES_JAM_RECIPE = ITEMS.register("blueberries_jam_recipe",
			() -> new BlockItem(ModBlocks.BLUEBERRIES_JAM_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> BLUEBERRIES_CAKE_RECIPE = ITEMS.register("blueberries_cake_recipe",
			() -> new BlockItem(ModBlocks.BLUEBERRIES_CAKE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> BLUEBERRIES_BARQUILLO_RECIPE = ITEMS.register("blueberries_barquillo_recipe",
			() -> new BlockItem(ModBlocks.BLUEBERRIES_BARQUILLO_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> BLUEBERRIES_PIE_RECIPE = ITEMS.register("blueberries_pie_recipe",
			() -> new BlockItem(ModBlocks.BLUEBERRIES_PIE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> BLUEBERRIES_PIE_SLICE_RECIPE = ITEMS.register("blueberries_pie_slice_recipe",
			() -> new BlockItem(ModBlocks.BLUEBERRIES_PIE_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> BLUEBERRIES_COOKIE_RECIPE = ITEMS.register("blueberries_cookie_recipe",
			() -> new BlockItem(ModBlocks.BLUEBERRIES_COOKIE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> BLUEBERRIES_CRATE_RECIPE = ITEMS.register("blueberries_crate_recipe",
			() -> new BlockItem(ModBlocks.BLUEBERRIES_CRATE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> BLUEBERRIES_RICE_DUMPLING_BLOCK_RECIPE = ITEMS.register("blueberries_rice_dumpling_block_recipe",
			() -> new BlockItem(ModBlocks.BLUEBERRIES_RICE_DUMPLING_BLOCK_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> BLUEBERRIES_FILLING_RECIPE = ITEMS.register("blueberries_filling_recipe",
			() -> new BlockItem(ModBlocks.BLUEBERRIES_FILLING_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> RAW_BLUEBERRIES_MOON_CAKE_RECIPE = ITEMS.register("raw_blueberries_moon_cake_recipe",
			() -> new BlockItem(ModBlocks.RAW_BLUEBERRIES_MOON_CAKE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> SWEETENED_BLUEBERRIES_RECIPE = ITEMS.register("sweetened_blueberries_recipe",
			() -> new BlockItem(ModBlocks.SWEETENED_BLUEBERRIES_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> BLUEBERRIES_JUICE_RECIPE = ITEMS.register("blueberries_juice_recipe",
			() -> new BlockItem(ModBlocks.BLUEBERRIES_JUICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> BLUEBERRIES_MILK_TEA_RECIPE = ITEMS.register("blueberries_milk_tea_recipe",
			() -> new BlockItem(ModBlocks.BLUEBERRIES_MILK_TEA_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));

	public static final RegistryObject<Item> HAMIMELON_RECIPE_PACKAGE = ITEMS.register("hamimelon_recipe_package",
			() -> new BlockItem(ModBlocks.HAMIMELON_RECIPE_PACKAGE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> HAMIMELON_CAKE_SLICE_RECIPE = ITEMS.register("hamimelon_cake_slice_recipe",
			() -> new BlockItem(ModBlocks.HAMIMELON_CAKE_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> HAMIMELON_COOKIE_RECIPE = ITEMS.register("hamimelon_cookie_recipe",
			() -> new BlockItem(ModBlocks.HAMIMELON_COOKIE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> HAMIMELON_CRATE_RECIPE = ITEMS.register("hamimelon_crate_recipe",
			() -> new BlockItem(ModBlocks.HAMIMELON_CRATE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> HAMIMELON_JAM_RECIPE = ITEMS.register("hamimelon_jam_recipe",
			() -> new BlockItem(ModBlocks.HAMIMELON_JAM_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> SWEETENED_HAMIMELON_RECIPE = ITEMS.register("sweetened_hamimelon_recipe",
			() -> new BlockItem(ModBlocks.SWEETENED_HAMIMELON_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> HAMIMELON_CAKE_RECIPE = ITEMS.register("hamimelon_cake_recipe",
			() -> new BlockItem(ModBlocks.HAMIMELON_CAKE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> HAMIMELON_PIE_RECIPE = ITEMS.register("hamimelon_pie_recipe",
			() -> new BlockItem(ModBlocks.HAMIMELON_PIE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> HAMIMELON_PIE_SLICE_RECIPE = ITEMS.register("hamimelon_pie_slice_recipe",
			() -> new BlockItem(ModBlocks.HAMIMELON_PIE_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> FISH_SKIN_RECIPE = ITEMS.register("fish_skin_recipe",
			() -> new BlockItem(ModBlocks.FISH_SKIN_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> SAGO_SOUP_RECIPE = ITEMS.register("sago_soup_recipe",
			() -> new BlockItem(ModBlocks.SAGO_SOUP_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PROSCIUTTO_CANTALOUPE_RECIPE = ITEMS.register("prosciutto_cantaloupe_recipe",
			() -> new BlockItem(ModBlocks.PROSCIUTTO_CANTALOUPE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> HAMIMELON_SAGO_SOUP_BLOCK_RECIPE = ITEMS.register("hamimelon_sago_soup_block_recipe",
			() -> new BlockItem(ModBlocks.HAMIMELON_SAGO_SOUP_BLOCK_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> HAMIMELON_FILLING_RECIPE = ITEMS.register("hamimelon_filling_recipe",
			() -> new BlockItem(ModBlocks.HAMIMELON_FILLING_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> RAW_HAMIMELON_MOON_CAKE_RECIPE = ITEMS.register("raw_hamimelon_moon_cake_recipe",
			() -> new BlockItem(ModBlocks.RAW_HAMIMELON_MOON_CAKE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> HAMIMELON_RICE_DUMPLING_BLOCK_RECIPE = ITEMS.register("hamimelon_rice_dumpling_block_recipe",
			() -> new BlockItem(ModBlocks.HAMIMELON_RICE_DUMPLING_BLOCK_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> HAMIMELON_JUICE_RECIPE = ITEMS.register("hamimelon_juice_recipe",
			() -> new BlockItem(ModBlocks.HAMIMELON_JUICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> HAMIMELON_MILK_TEA_RECIPE = ITEMS.register("hamimelon_milk_tea_recipe",
			() -> new BlockItem(ModBlocks.HAMIMELON_MILK_TEA_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));

	public static final RegistryObject<Item> BEATING_MELONS_RECIPE_PACKAGE = ITEMS.register("beating_melons_recipe_package",
			() -> new BlockItem(ModBlocks.BEATING_MELONS_RECIPE_PACKAGE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> BEATING_MELONS_CRATE_RECIPE = ITEMS.register("beating_melons_crate_recipe",
			() -> new BlockItem(ModBlocks.BEATING_MELONS_CRATE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> BEATING_MELONS_CAKE_RECIPE = ITEMS.register("beating_melons_cake_recipe",
			() -> new BlockItem(ModBlocks.BEATING_MELONS_CAKE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> BEATING_MELONS_CAKE_SLICE_RECIPE = ITEMS.register("beating_melons_cake_slice_recipe",
			() -> new BlockItem(ModBlocks.BEATING_MELONS_CAKE_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> BEATING_MELONS_JAM_RECIPE = ITEMS.register("beating_melons_jam_recipe",
			() -> new BlockItem(ModBlocks.BEATING_MELONS_JAM_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> BEATING_MELONS_PIE_RECIPE = ITEMS.register("beating_melons_pie_recipe",
			() -> new BlockItem(ModBlocks.BEATING_MELONS_PIE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> BEATING_MELONS_PIE_SLICE_RECIPE = ITEMS.register("beating_melons_pie_slice_recipe",
			() -> new BlockItem(ModBlocks.BEATING_MELONS_PIE_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> BEATING_MELONS_COOKIE_RECIPE = ITEMS.register("beating_melons_cookie_recipe",
			() -> new BlockItem(ModBlocks.BEATING_MELONS_COOKIE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> BEATING_MELONS_FILLING_RECIPE = ITEMS.register("beating_melons_filling_recipe",
			() -> new BlockItem(ModBlocks.BEATING_MELONS_FILLING_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> RAW_BEATING_MELONS_MOON_CAKE_RECIPE = ITEMS.register("raw_beating_melons_moon_cake_recipe",
			() -> new BlockItem(ModBlocks.RAW_BEATING_MELONS_MOON_CAKE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> BEATING_MELONS_RICE_DUMPLING_BLOCK_RECIPE = ITEMS.register("beating_melons_rice_dumpling_block_recipe",
			() -> new BlockItem(ModBlocks.BEATING_MELONS_RICE_DUMPLING_BLOCK_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> BEATING_MELONS_JUICE_RECIPE = ITEMS.register("beating_melons_juice_recipe",
			() -> new BlockItem(ModBlocks.BEATING_MELONS_JUICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> BEATING_MELONS_MILK_TEA_RECIPE = ITEMS.register("beating_melons_milk_tea_recipe",
			() -> new BlockItem(ModBlocks.BEATING_MELONS_MILK_TEA_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));

	public static final RegistryObject<Item> GROUND_CUCUMBER_RECIPE_PACKAGE = ITEMS.register("ground_cucumber_recipe_package",
			() -> new BlockItem(ModBlocks.GROUND_CUCUMBER_RECIPE_PACKAGE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> GROUND_CUCUMBER_CAKE_RECIPE = ITEMS.register("ground_cucumber_cake_recipe",
			() -> new BlockItem(ModBlocks.GROUND_CUCUMBER_CAKE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> GROUND_CUCUMBER_CAKE_SLICE_RECIPE = ITEMS.register("ground_cucumber_cake_slice_recipe",
			() -> new BlockItem(ModBlocks.GROUND_CUCUMBER_CAKE_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> GROUND_CUCUMBER_COOKIE__RECIPE = ITEMS.register("ground_cucumber_cookie_recipe",
			() -> new BlockItem(ModBlocks.GROUND_CUCUMBER_COOKIE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> GROUND_CUCUMBER_CRATE_RECIPE = ITEMS.register("ground_cucumber_crate_recipe",
			() -> new BlockItem(ModBlocks.GROUND_CUCUMBER_CRATE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> GROUND_CUCUMBER_FILLING_RECIPE = ITEMS.register("ground_cucumber_filling_recipe",
			() -> new BlockItem(ModBlocks.GROUND_CUCUMBER_FILLING_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> GROUND_CUCUMBER_JAM_RECIPE = ITEMS.register("ground_cucumber_jam_recipe",
			() -> new BlockItem(ModBlocks.GROUND_CUCUMBER_JAM_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> GROUND_CUCUMBER_PIE_RECIPE = ITEMS.register("ground_cucumber_pie_recipe",
			() -> new BlockItem(ModBlocks.GROUND_CUCUMBER_PIE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> GROUND_CUCUMBER_PIE_SLICE_RECIPE = ITEMS.register("ground_cucumber_pie_slice_recipe",
			() -> new BlockItem(ModBlocks.GROUND_CUCUMBER_PIE_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> GROUND_CUCUMBER_RICE_DUMPLING_BLOCK_RECIPE = ITEMS.register("ground_cucumber_rice_dumpling_block_recipe",
			() -> new BlockItem(ModBlocks.GROUND_CUCUMBER_RICE_DUMPLING_BLOCK_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> GROUND_CUCUMBER_SLICE_RECIPE = ITEMS.register("ground_cucumber_slice_recipe",
			() -> new BlockItem(ModBlocks.GROUND_CUCUMBER_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> RAW_GROUND_CUCUMBER_MOON_CAKE_RECIPE = ITEMS.register("raw_ground_cucumber_moon_cake_recipe",
			() -> new BlockItem(ModBlocks.RAW_GROUND_CUCUMBER_MOON_CAKE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> GROUND_CUCUMBER_JUICE_RECIPE = ITEMS.register("ground_cucumber_juice_recipe",
			() -> new BlockItem(ModBlocks.GROUND_CUCUMBER_JUICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> GROUND_CUCUMBER_MILK_TEA_RECIPE = ITEMS.register("ground_cucumber_milk_tea_recipe",
			() -> new BlockItem(ModBlocks.GROUND_CUCUMBER_MILK_TEA_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));

	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_RECIPE_PACKAGE = ITEMS.register("holboellia_latifolia_recipe_package",
			() -> new BlockItem(ModBlocks.HOLBOELLIA_LATIFOLIA_RECIPE_PACKAGE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_CAKE_RECIPE = ITEMS.register("holboellia_latifolia_cake_recipe",
			() -> new BlockItem(ModBlocks.HOLBOELLIA_LATIFOLIA_CAKE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_CAKE_SLICE_RECIPE = ITEMS.register("holboellia_latifolia_cake_slice_recipe",
			() -> new BlockItem(ModBlocks.HOLBOELLIA_LATIFOLIA_CAKE_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_COOKIE__RECIPE = ITEMS.register("holboellia_latifolia_cookie_recipe",
			() -> new BlockItem(ModBlocks.HOLBOELLIA_LATIFOLIA_COOKIE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_CRATE_RECIPE = ITEMS.register("holboellia_latifolia_crate_recipe",
			() -> new BlockItem(ModBlocks.HOLBOELLIA_LATIFOLIA_CRATE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_FILLING_RECIPE = ITEMS.register("holboellia_latifolia_filling_recipe",
			() -> new BlockItem(ModBlocks.HOLBOELLIA_LATIFOLIA_FILLING_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_JAM_RECIPE = ITEMS.register("holboellia_latifolia_jam_recipe",
			() -> new BlockItem(ModBlocks.HOLBOELLIA_LATIFOLIA_JAM_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_PIE_RECIPE = ITEMS.register("holboellia_latifolia_pie_recipe",
			() -> new BlockItem(ModBlocks.HOLBOELLIA_LATIFOLIA_PIE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_PIE_SLICE_RECIPE = ITEMS.register("holboellia_latifolia_pie_slice_recipe",
			() -> new BlockItem(ModBlocks.HOLBOELLIA_LATIFOLIA_PIE_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_RICE_DUMPLING_BLOCK_RECIPE = ITEMS.register("holboellia_latifolia_rice_dumpling_block_recipe",
			() -> new BlockItem(ModBlocks.HOLBOELLIA_LATIFOLIA_RICE_DUMPLING_BLOCK_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_SLICE_RECIPE = ITEMS.register("holboellia_latifolia_slice_recipe",
			() -> new BlockItem(ModBlocks.HOLBOELLIA_LATIFOLIA_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> RAW_HOLBOELLIA_LATIFOLIA_MOON_CAKE_RECIPE = ITEMS.register("raw_holboellia_latifolia_moon_cake_recipe",
			() -> new BlockItem(ModBlocks.RAW_HOLBOELLIA_LATIFOLIA_MOON_CAKE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> ONION_TOMATO_HOLBOELLIA_LATIFOLIA_RECIPE = ITEMS.register("onion_tomato_holboellia_latifolia_recipe",
			() -> new BlockItem(ModBlocks.ONION_TOMATO_HOLBOELLIA_LATIFOLIA_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_EGG_MILK_PUDDING_RECIPE = ITEMS.register("holboellia_latifolia_egg_milk_pudding_recipe",
			() -> new BlockItem(ModBlocks.HOLBOELLIA_LATIFOLIA_EGG_MILK_PUDDING_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_JUICE_RECIPE = ITEMS.register("holboellia_latifolia_juice_recipe",
			() -> new BlockItem(ModBlocks.HOLBOELLIA_LATIFOLIA_JUICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> HOLBOELLIA_LATIFOLIA_MILK_TEA_RECIPE = ITEMS.register("holboellia_latifolia_milk_tea_recipe",
			() -> new BlockItem(ModBlocks.HOLBOELLIA_LATIFOLIA_MILK_TEA_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));

	public static final RegistryObject<Item> LITCHI_RECIPE_PACKAGE = ITEMS.register("litchi_recipe_package",
			() -> new BlockItem(ModBlocks.LITCHI_RECIPE_PACKAGE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> LITCHI_CAKE_RECIPE = ITEMS.register("litchi_cake_recipe",
			() -> new BlockItem(ModBlocks.LITCHI_CAKE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> LITCHI_CAKE_SLICE_RECIPE = ITEMS.register("litchi_cake_slice_recipe",
			() -> new BlockItem(ModBlocks.LITCHI_CAKE_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> LITCHI_COOKIE_RECIPE = ITEMS.register("litchi_cookie_recipe",
			() -> new BlockItem(ModBlocks.LITCHI_COOKIE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> LITCHI_CRATE_RECIPE = ITEMS.register("litchi_crate_recipe",
			() -> new BlockItem(ModBlocks.LITCHI_CRATE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> LITCHI_FILLING_RECIPE = ITEMS.register("litchi_filling_recipe",
			() -> new BlockItem(ModBlocks.LITCHI_FILLING_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> LITCHI_JAM_RECIPE = ITEMS.register("litchi_jam_recipe",
			() -> new BlockItem(ModBlocks.LITCHI_JAM_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> LITCHI_PIE_RECIPE = ITEMS.register("litchi_pie_recipe",
			() -> new BlockItem(ModBlocks.LITCHI_PIE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> LITCHI_PIE_SLICE_RECIPE = ITEMS.register("litchi_pie_slice_recipe",
			() -> new BlockItem(ModBlocks.LITCHI_PIE_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> LITCHI_RICE_DUMPLING_BLOCK_RECIPE = ITEMS.register("litchi_rice_dumpling_block_recipe",
			() -> new BlockItem(ModBlocks.LITCHI_RICE_DUMPLING_BLOCK_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> LITCHI_SLICE_RECIPE = ITEMS.register("litchi_slice_recipe",
			() -> new BlockItem(ModBlocks.LITCHI_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> RAW_LITCHI_MOON_CAKE_RECIPE = ITEMS.register("raw_litchi_moon_cake_recipe",
			() -> new BlockItem(ModBlocks.RAW_LITCHI_MOON_CAKE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> LITCHI_JUICE_RECIPE = ITEMS.register("litchi_juice_recipe",
			() -> new BlockItem(ModBlocks.LITCHI_JUICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> BOWLED_LITCHI_RIVER_NOODLES_RECIPE = ITEMS.register("bowled_litchi_river_noodles_recipe",
			() -> new BlockItem(ModBlocks.BOWLED_LITCHI_RIVER_NOODLES_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> LITCHI_ICE_CREAM_REICPE = ITEMS.register("litchi_ice_cream_recipe",
			() -> new BlockItem(ModBlocks.LITCHI_ICE_CREAM_REICPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> LITCHI_SAPLING_REICPE = ITEMS.register("litchi_sapling_recipe",
			() -> new BlockItem(ModBlocks.LITCHI_SAPLING_REICPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> SWEETENED_LITCHI_REICPE = ITEMS.register("sweetened_litchi_recipe",
			() -> new BlockItem(ModBlocks.SWEETENED_LITCHI_REICPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> UNFORMED_LITCHI_RIVER_DOUGH_REICPE = ITEMS.register("unformed_litchi_river_dough_recipe",
			() -> new BlockItem(ModBlocks.UNFORMED_LITCHI_RIVER_DOUGH_REICPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> LITCHI_MILK_TEA_RECIPE = ITEMS.register("litchi_milk_tea_recipe",
			() -> new BlockItem(ModBlocks.LITCHI_MILK_TEA_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));

	public static final RegistryObject<Item> HUOSHEN_FRUIT_RECIPE_PACKAGE = ITEMS.register("huoshen_fruit_recipe_package",
			() -> new BlockItem(ModBlocks.HUOSHEN_FRUIT_RECIPE_PACKAGE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_CAKE_RECIPE = ITEMS.register("huoshen_fruit_cake_recipe",
			() -> new BlockItem(ModBlocks.HUOSHEN_FRUIT_CAKE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_CAKE_SLICE_RECIPE = ITEMS.register("huoshen_fruit_cake_slice_recipe",
			() -> new BlockItem(ModBlocks.HUOSHEN_FRUIT_CAKE_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_COOKIE_RECIPE = ITEMS.register("huoshen_fruit_cookie_recipe",
			() -> new BlockItem(ModBlocks.HUOSHEN_FRUIT_COOKIE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_CRATE_RECIPE = ITEMS.register("huoshen_fruit_crate_recipe",
			() -> new BlockItem(ModBlocks.HUOSHEN_FRUIT_CRATE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_FILLING_RECIPE = ITEMS.register("huoshen_fruit_filling_recipe",
			() -> new BlockItem(ModBlocks.HUOSHEN_FRUIT_FILLING_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_JAM_RECIPE = ITEMS.register("huoshen_fruit_jam_recipe",
			() -> new BlockItem(ModBlocks.HUOSHEN_FRUIT_JAM_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_PIE_RECIPE = ITEMS.register("huoshen_fruit_pie_recipe",
			() -> new BlockItem(ModBlocks.HUOSHEN_FRUIT_PIE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_PIE_SLICE_RECIPE = ITEMS.register("huoshen_fruit_pie_slice_recipe",
			() -> new BlockItem(ModBlocks.HUOSHEN_FRUIT_PIE_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_RICE_DUMPLING_BLOCK_RECIPE = ITEMS.register("huoshen_fruit_rice_dumpling_block_recipe",
			() -> new BlockItem(ModBlocks.HUOSHEN_FRUIT_RICE_DUMPLING_BLOCK_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_SLICE_RECIPE = ITEMS.register("huoshen_fruit_slice_recipe",
			() -> new BlockItem(ModBlocks.HUOSHEN_FRUIT_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> RAW_HUOSHEN_FRUIT_MOON_CAKE_RECIPE = ITEMS.register("raw_huoshen_fruit_moon_cake_recipe",
			() -> new BlockItem(ModBlocks.RAW_HUOSHEN_FRUIT_MOON_CAKE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_JUICE_RECIPE = ITEMS.register("huoshen_fruit_juice_recipe",
			() -> new BlockItem(ModBlocks.HUOSHEN_FRUIT_JUICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_HONEY_SAUCE_RECIPE = ITEMS.register("huoshen_fruit_honey_sauce_recipe",
			() -> new BlockItem(ModBlocks.HUOSHEN_FRUIT_HONEY_SAUCE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_SEEDS_RECIPE = ITEMS.register("huoshen_fruit_seeds_recipe",
			() -> new BlockItem(ModBlocks.HUOSHEN_FRUIT_SEEDS_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> HUOSHEN_FRUIT_MILK_TEA_RECIPE = ITEMS.register("huoshen_fruit_milk_tea_recipe",
			() -> new BlockItem(ModBlocks.HUOSHEN_FRUIT_MILK_TEA_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));

	public static final RegistryObject<Item> SEPTEMBER_MELON_RECIPE_PACKAGE = ITEMS.register("september_melon_recipe_package",
			() -> new BlockItem(ModBlocks.SEPTEMBER_MELON_RECIPE_PACKAGE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> SEPTEMBER_MELON_CAKE_RECIPE = ITEMS.register("september_melon_cake_recipe",
			() -> new BlockItem(ModBlocks.SEPTEMBER_MELON_CAKE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> SEPTEMBER_MELON_CAKE_SLICE_RECIPE = ITEMS.register("september_melon_cake_slice_recipe",
			() -> new BlockItem(ModBlocks.SEPTEMBER_MELON_CAKE_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> SEPTEMBER_MELON_COOKIE_RECIPE = ITEMS.register("september_melon_cookie_recipe",
			() -> new BlockItem(ModBlocks.SEPTEMBER_MELON_COOKIE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> SEPTEMBER_MELON_CRATE_RECIPE = ITEMS.register("september_melon_crate_recipe",
			() -> new BlockItem(ModBlocks.SEPTEMBER_MELON_CRATE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> SEPTEMBER_MELON_FILLING_RECIPE = ITEMS.register("september_melon_filling_recipe",
			() -> new BlockItem(ModBlocks.SEPTEMBER_MELON_FILLING_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> SEPTEMBER_MELON_JAM_RECIPE = ITEMS.register("september_melon_jam_recipe",
			() -> new BlockItem(ModBlocks.SEPTEMBER_MELON_JAM_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> SEPTEMBER_MELON_PIE_RECIPE = ITEMS.register("september_melon_pie_recipe",
			() -> new BlockItem(ModBlocks.SEPTEMBER_MELON_PIE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> SEPTEMBER_MELON_PIE_SLICE_RECIPE = ITEMS.register("september_melon_pie_slice_recipe",
			() -> new BlockItem(ModBlocks.SEPTEMBER_MELON_PIE_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> SEPTEMBER_MELON_RICE_DUMPLING_BLOCK_RECIPE = ITEMS.register("september_melon_rice_dumpling_block_recipe",
			() -> new BlockItem(ModBlocks.SEPTEMBER_MELON_RICE_DUMPLING_BLOCK_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> RAW_SEPTEMBER_MELON_MOON_CAKE_RECIPE = ITEMS.register("raw_september_melon_moon_cake_recipe",
			() -> new BlockItem(ModBlocks.RAW_SEPTEMBER_MELON_MOON_CAKE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> SEPTEMBER_MELON_JUICE_RECIPE = ITEMS.register("september_melon_juice_recipe",
			() -> new BlockItem(ModBlocks.SEPTEMBER_MELON_JUICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> SEPTEMBER_MELON_SEEDS_RECIPE = ITEMS.register("september_melon_seeds_recipe",
			() -> new BlockItem(ModBlocks.SEPTEMBER_MELON_SEEDS_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> SEPTEMBER_MELON_MILK_TEA_RECIPE = ITEMS.register("september_melon_milk_tea_recipe",
			() -> new BlockItem(ModBlocks.SEPTEMBER_MELON_MILK_TEA_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));

	public static final RegistryObject<Item> PITAYA_RECIPE_PACKAGE = ITEMS.register("pitaya_recipe_package",
			() -> new BlockItem(ModBlocks.PITAYA_RECIPE_PACKAGE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PITAYA_CAKE_RECIPE = ITEMS.register("pitaya_cake_recipe",
			() -> new BlockItem(ModBlocks.PITAYA_CAKE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PITAYA_CAKE_SLICE_RECIPE = ITEMS.register("pitaya_cake_slice_recipe",
			() -> new BlockItem(ModBlocks.PITAYA_CAKE_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PITAYA_COOKIE_RECIPE = ITEMS.register("pitaya_cookie_recipe",
			() -> new BlockItem(ModBlocks.PITAYA_COOKIE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PITAYA_CRATE_RECIPE = ITEMS.register("pitaya_crate_recipe",
			() -> new BlockItem(ModBlocks.PITAYA_CRATE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PITAYA_FILLING_RECIPE = ITEMS.register("pitaya_filling_recipe",
			() -> new BlockItem(ModBlocks.PITAYA_FILLING_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PITAYA_JAM_RECIPE = ITEMS.register("pitaya_jam_recipe",
			() -> new BlockItem(ModBlocks.PITAYA_JAM_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PITAYA_PIE_RECIPE = ITEMS.register("pitaya_pie_recipe",
			() -> new BlockItem(ModBlocks.PITAYA_PIE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PITAYA_PIE_SLICE_RECIPE = ITEMS.register("pitaya_pie_slice_recipe",
			() -> new BlockItem(ModBlocks.PITAYA_PIE_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PITAYA_RICE_DUMPLING_BLOCK_RECIPE = ITEMS.register("pitaya_rice_dumpling_block_recipe",
			() -> new BlockItem(ModBlocks.PITAYA_RICE_DUMPLING_BLOCK_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> RAW_PITAYA_MOON_CAKE_RECIPE = ITEMS.register("raw_pitaya_moon_cake_recipe",
			() -> new BlockItem(ModBlocks.RAW_PITAYA_MOON_CAKE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PITAYA_JUICE_RECIPE = ITEMS.register("pitaya_juice_recipe",
			() -> new BlockItem(ModBlocks.PITAYA_JUICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PITAYA_SLICE_RECIPE = ITEMS.register("pitaya_slice_recipe",
			() -> new BlockItem(ModBlocks.PITAYA_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> SWEETENED_PITAYA_RECIPE = ITEMS.register("sweetened_pitaya_recipe",
			() -> new BlockItem(ModBlocks.SWEETENED_PITAYA_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> COLORFUL_FRUIT_SALAD_BLOCK_RECIPE = ITEMS.register("colorful_fruit_salad_block_recipe",
			() -> new BlockItem(ModBlocks.COLORFUL_FRUIT_SALAD_BLOCK_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PITAYA_RICE_AND_VEGETABLE_ROLL_RECIPE = ITEMS.register("pitaya_rice_and_vegetable_roll_recipe",
			() -> new BlockItem(ModBlocks.PITAYA_RICE_AND_VEGETABLE_ROLL_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PITAYA_MILK_TEA_RECIPE = ITEMS.register("pitaya_milk_tea_recipe",
			() -> new BlockItem(ModBlocks.PITAYA_MILK_TEA_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));

	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_RECIPE_PACKAGE = ITEMS.register("golden_pure_sheep_horn_honey_recipe_package",
			() -> new BlockItem(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_RECIPE_PACKAGE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_CAKE_RECIPE = ITEMS.register("golden_pure_sheep_horn_honey_cake_recipe",
			() -> new BlockItem(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_CAKE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_CAKE_SLICE_RECIPE = ITEMS.register("golden_pure_sheep_horn_honey_cake_slice_recipe",
			() -> new BlockItem(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_CAKE_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_COOKIE_RECIPE = ITEMS.register("golden_pure_sheep_horn_honey_cookie_recipe",
			() -> new BlockItem(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_COOKIE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_CRATE_RECIPE = ITEMS.register("golden_pure_sheep_horn_honey_crate_recipe",
			() -> new BlockItem(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_CRATE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_FILLING_RECIPE = ITEMS.register("golden_pure_sheep_horn_honey_filling_recipe",
			() -> new BlockItem(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_FILLING_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_JAM_RECIPE = ITEMS.register("golden_pure_sheep_horn_honey_jam_recipe",
			() -> new BlockItem(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_JAM_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_PIE_RECIPE = ITEMS.register("golden_pure_sheep_horn_honey_pie_recipe",
			() -> new BlockItem(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_PIE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_PIE_SLICE_RECIPE = ITEMS.register("golden_pure_sheep_horn_honey_pie_slice_recipe",
			() -> new BlockItem(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_PIE_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_RICE_DUMPLING_BLOCK_RECIPE = ITEMS.register("golden_pure_sheep_horn_honey_rice_dumpling_block_recipe",
			() -> new BlockItem(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_RICE_DUMPLING_BLOCK_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> RAW_GOLDEN_PURE_SHEEP_HORN_HONEY_MOON_CAKE_RECIPE = ITEMS.register("raw_golden_pure_sheep_horn_honey_moon_cake_recipe",
			() -> new BlockItem(ModBlocks.RAW_GOLDEN_PURE_SHEEP_HORN_HONEY_MOON_CAKE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_JUICE_RECIPE = ITEMS.register("golden_pure_sheep_horn_honey_juice_recipe",
			() -> new BlockItem(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_JUICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_SLICE_RECIPE = ITEMS.register("golden_pure_sheep_horn_honey_slice_recipe",
			() -> new BlockItem(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_SEEDS_RECIPE = ITEMS.register("golden_pure_sheep_horn_honey_seeds_recipe",
			() -> new BlockItem(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_SEEDS_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_FLAVOR_GOLDEN_PURE_SHEEP_HORN_HONEY_RECIPE = ITEMS.register("golden_pure_sheep_horn_honey_flavor_golden_pure_sheep_horn_honey_recipe",
			() -> new BlockItem(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_FLAVOR_GOLDEN_PURE_SHEEP_HORN_HONEY_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> GOLDEN_PURE_SHEEP_HORN_HONEY_MILK_TEA_RECIPE = ITEMS.register("golden_pure_sheep_horn_honey_milk_tea_recipe",
			() -> new BlockItem(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_MILK_TEA_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));

	public static final RegistryObject<Item> PEAR_RECIPE_PACKAGE = ITEMS.register("pear_recipe_package",
			() -> new BlockItem(ModBlocks.PEAR_RECIPE_PACKAGE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PEAR_CAKE_RECIPE = ITEMS.register("pear_cake_recipe",
			() -> new BlockItem(ModBlocks.PEAR_CAKE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PEAR_CAKE_SLICE_RECIPE = ITEMS.register("pear_cake_slice_recipe",
			() -> new BlockItem(ModBlocks.PEAR_CAKE_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PEAR_COOKIE_RECIPE = ITEMS.register("pear_cookie_recipe",
			() -> new BlockItem(ModBlocks.PEAR_COOKIE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PEAR_CRATE_RECIPE = ITEMS.register("pear_crate_recipe",
			() -> new BlockItem(ModBlocks.PEAR_CRATE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PEAR_FILLING_RECIPE = ITEMS.register("pear_filling_recipe",
			() -> new BlockItem(ModBlocks.PEAR_FILLING_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PEAR_JAM_RECIPE = ITEMS.register("pear_jam_recipe",
			() -> new BlockItem(ModBlocks.PEAR_JAM_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PEAR_PIE_RECIPE = ITEMS.register("pear_pie_recipe",
			() -> new BlockItem(ModBlocks.PEAR_PIE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PEAR_PIE_SLICE_RECIPE = ITEMS.register("pear_pie_slice_recipe",
			() -> new BlockItem(ModBlocks.PEAR_PIE_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PEAR_RICE_DUMPLING_BLOCK_RECIPE = ITEMS.register("pear_rice_dumpling_block_recipe",
			() -> new BlockItem(ModBlocks.PEAR_RICE_DUMPLING_BLOCK_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> RAW_PEAR_MOON_CAKE_RECIPE = ITEMS.register("raw_pear_moon_cake_recipe",
			() -> new BlockItem(ModBlocks.RAW_PEAR_MOON_CAKE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PEAR_JUICE_RECIPE = ITEMS.register("pear_juice_recipe",
			() -> new BlockItem(ModBlocks.PEAR_JUICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PEAR_SLICE_RECIPE = ITEMS.register("pear_slice_recipe",
			() -> new BlockItem(ModBlocks.PEAR_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PEAR_SAPLING_RECIPE = ITEMS.register("pear_sapling_recipe",
			() -> new BlockItem(ModBlocks.PEAR_SAPLING_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> ROCK_SUGAR_SNOW_PEAR_RECIPE = ITEMS.register("rock_sugar_snow_pear_recipe",
			() -> new BlockItem(ModBlocks.ROCK_SUGAR_SNOW_PEAR_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PEAR_MILK_TEA_RECIPE = ITEMS.register("pear_milk_tea_recipe",
			() -> new BlockItem(ModBlocks.PEAR_MILK_TEA_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));

	public static final RegistryObject<Item> MAYTHORN_RECIPE_PACKAGE = ITEMS.register("maythorn_recipe_package",
			() -> new BlockItem(ModBlocks.MAYTHORN_RECIPE_PACKAGE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> MAYTHORN_CAKE_RECIPE = ITEMS.register("maythorn_cake_recipe",
			() -> new BlockItem(ModBlocks.MAYTHORN_CAKE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> MAYTHORN_CAKE_SLICE_RECIPE = ITEMS.register("maythorn_cake_slice_recipe",
			() -> new BlockItem(ModBlocks.MAYTHORN_CAKE_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> MAYTHORN_COOKIE_RECIPE = ITEMS.register("maythorn_cookie_recipe",
			() -> new BlockItem(ModBlocks.MAYTHORN_COOKIE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> MAYTHORN_CRATE_RECIPE = ITEMS.register("maythorn_crate_recipe",
			() -> new BlockItem(ModBlocks.MAYTHORN_CRATE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> MAYTHORN_FILLING_RECIPE = ITEMS.register("maythorn_filling_recipe",
			() -> new BlockItem(ModBlocks.MAYTHORN_FILLING_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> MAYTHORN_JAM_RECIPE = ITEMS.register("maythorn_jam_recipe",
			() -> new BlockItem(ModBlocks.MAYTHORN_JAM_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> MAYTHORN_PIE_RECIPE = ITEMS.register("maythorn_pie_recipe",
			() -> new BlockItem(ModBlocks.MAYTHORN_PIE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> MAYTHORN_PIE_SLICE_RECIPE = ITEMS.register("maythorn_pie_slice_recipe",
			() -> new BlockItem(ModBlocks.MAYTHORN_PIE_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> MAYTHORN_RICE_DUMPLING_BLOCK_RECIPE = ITEMS.register("maythorn_rice_dumpling_block_recipe",
			() -> new BlockItem(ModBlocks.MAYTHORN_RICE_DUMPLING_BLOCK_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> RAW_MAYTHORN_MOON_CAKE_RECIPE = ITEMS.register("raw_maythorn_moon_cake_recipe",
			() -> new BlockItem(ModBlocks.RAW_MAYTHORN_MOON_CAKE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> MAYTHORN_JUICE_RECIPE = ITEMS.register("maythorn_juice_recipe",
			() -> new BlockItem(ModBlocks.MAYTHORN_JUICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> SWEETENED_MAYTHORN_RECIPE = ITEMS.register("sweetened_maythorn_recipe",
			() -> new BlockItem(ModBlocks.SWEETENED_MAYTHORN_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> MAYTHORN_SAPLING_RECIPE = ITEMS.register("maythorn_sapling_recipe",
			() -> new BlockItem(ModBlocks.MAYTHORN_SAPLING_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> CANDIED_HAWS_ON_A_STICK_RECIPE = ITEMS.register("candied_haws_on_a_stick_recipe",
			() -> new BlockItem(ModBlocks.CANDIED_HAWS_ON_A_STICK_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> BOWLED_CANDIED_HAWS_ON_A_STICK_RECIPE = ITEMS.register("bowled_candied_haws_on_a_stick_recipe",
			() -> new BlockItem(ModBlocks.BOWLED_CANDIED_HAWS_ON_A_STICK_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> A_BUNDLE_OF_CANDIED_HAWS_ON_A_STICK_RECIPE = ITEMS.register("a_bundle_of_candied_haws_on_a_stick_recipe",
			() -> new BlockItem(ModBlocks.A_BUNDLE_OF_CANDIED_HAWS_ON_A_STICK_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> RED_FRUIT_MAYTHORN_CAKE_RECIPE = ITEMS.register("red_fruit_maythorn_cake_recipe",
			() -> new BlockItem(ModBlocks.RED_FRUIT_MAYTHORN_CAKE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> MAYTHORN_MILK_TEA_RECIPE = ITEMS.register("maythorn_milk_tea_recipe",
			() -> new BlockItem(ModBlocks.MAYTHORN_MILK_TEA_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));

	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_RECIPE_PACKAGE = ITEMS.register("chinese_pear_leaved_recipe_package",
			() -> new BlockItem(ModBlocks.CHINESE_PEAR_LEAVED_RECIPE_PACKAGE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_CAKE_RECIPE = ITEMS.register("chinese_pear_leaved_cake_recipe",
			() -> new BlockItem(ModBlocks.CHINESE_PEAR_LEAVED_CAKE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_CAKE_SLICE_RECIPE = ITEMS.register("chinese_pear_leaved_cake_slice_recipe",
			() -> new BlockItem(ModBlocks.CHINESE_PEAR_LEAVED_CAKE_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_COOKIE_RECIPE = ITEMS.register("chinese_pear_leaved_cookie_recipe",
			() -> new BlockItem(ModBlocks.CHINESE_PEAR_LEAVED_COOKIE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_CRATE_RECIPE = ITEMS.register("chinese_pear_leaved_crate_recipe",
			() -> new BlockItem(ModBlocks.CHINESE_PEAR_LEAVED_CRATE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_FILLING_RECIPE = ITEMS.register("chinese_pear_leaved_filling_recipe",
			() -> new BlockItem(ModBlocks.CHINESE_PEAR_LEAVED_FILLING_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_JAM_RECIPE = ITEMS.register("chinese_pear_leaved_jam_recipe",
			() -> new BlockItem(ModBlocks.CHINESE_PEAR_LEAVED_JAM_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_PIE_RECIPE = ITEMS.register("chinese_pear_leaved_pie_recipe",
			() -> new BlockItem(ModBlocks.CHINESE_PEAR_LEAVED_PIE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_PIE_SLICE_RECIPE = ITEMS.register("chinese_pear_leaved_pie_slice_recipe",
			() -> new BlockItem(ModBlocks.CHINESE_PEAR_LEAVED_PIE_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_RICE_DUMPLING_BLOCK_RECIPE = ITEMS.register("chinese_pear_leaved_rice_dumpling_block_recipe",
			() -> new BlockItem(ModBlocks.CHINESE_PEAR_LEAVED_RICE_DUMPLING_BLOCK_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> RAW_CHINESE_PEAR_LEAVED_MOON_CAKE_RECIPE = ITEMS.register("raw_chinese_pear_leaved_moon_cake_recipe",
			() -> new BlockItem(ModBlocks.RAW_CHINESE_PEAR_LEAVED_MOON_CAKE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_JUICE_RECIPE = ITEMS.register("chinese_pear_leaved_juice_recipe",
			() -> new BlockItem(ModBlocks.CHINESE_PEAR_LEAVED_JUICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_SAPLING_RECIPE = ITEMS.register("chinese_pear_leaved_sapling_recipe",
			() -> new BlockItem(ModBlocks.CHINESE_PEAR_LEAVED_SAPLING_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_ROLLS_RECIPE = ITEMS.register("chinese_pear_leaved_rolls_recipe",
			() -> new BlockItem(ModBlocks.CHINESE_PEAR_LEAVED_ROLLS_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> CHINESE_PEAR_LEAVED_MILK_TEA_RECIPE = ITEMS.register("chinese_pear_leaved_milk_tea_recipe",
			() -> new BlockItem(ModBlocks.CHINESE_PEAR_LEAVED_MILK_TEA_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));

	public static final RegistryObject<Item> PLUM_RECIPE_PACKAGE = ITEMS.register("plum_recipe_package",
			() -> new BlockItem(ModBlocks.PLUM_RECIPE_PACKAGE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PLUM_CAKE_RECIPE = ITEMS.register("plum_cake_recipe",
			() -> new BlockItem(ModBlocks.PLUM_CAKE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PLUM_CAKE_SLICE_RECIPE = ITEMS.register("plum_cake_slice_recipe",
			() -> new BlockItem(ModBlocks.PLUM_CAKE_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PLUM_COOKIE_RECIPE = ITEMS.register("plum_cookie_recipe",
			() -> new BlockItem(ModBlocks.PLUM_COOKIE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PLUM_CRATE_RECIPE = ITEMS.register("plum_crate_recipe",
			() -> new BlockItem(ModBlocks.PLUM_CRATE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PLUM_FILLING_RECIPE = ITEMS.register("plum_filling_recipe",
			() -> new BlockItem(ModBlocks.PLUM_FILLING_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PLUM_JAM_RECIPE = ITEMS.register("plum_jam_recipe",
			() -> new BlockItem(ModBlocks.PLUM_JAM_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PLUM_PIE_RECIPE = ITEMS.register("plum_pie_recipe",
			() -> new BlockItem(ModBlocks.PLUM_PIE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PLUM_PIE_SLICE_RECIPE = ITEMS.register("plum_pie_slice_recipe",
			() -> new BlockItem(ModBlocks.PLUM_PIE_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PLUM_RICE_DUMPLING_BLOCK_RECIPE = ITEMS.register("plum_rice_dumpling_block_recipe",
			() -> new BlockItem(ModBlocks.PLUM_RICE_DUMPLING_BLOCK_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> RAW_PLUM_MOON_CAKE_RECIPE = ITEMS.register("raw_plum_moon_cake_recipe",
			() -> new BlockItem(ModBlocks.RAW_PLUM_MOON_CAKE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PLUM_JUICE_RECIPE = ITEMS.register("plum_juice_recipe",
			() -> new BlockItem(ModBlocks.PLUM_JUICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> SWEETENED_PLUM_RECIPE = ITEMS.register("sweetened_plum_recipe",
			() -> new BlockItem(ModBlocks.SWEETENED_PLUM_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PLUM_SAPLING_RECIPE = ITEMS.register("plum_sapling_recipe",
			() -> new BlockItem(ModBlocks.PLUM_SAPLING_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> SOUR_AND_SWEET_PLUM_CAKE_RECIPE = ITEMS.register("sour_and_sweet_plum_cake_recipe",
			() -> new BlockItem(ModBlocks.SOUR_AND_SWEET_PLUM_CAKE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PLUM_MILK_TEA_RECIPE = ITEMS.register("plum_milk_tea_recipe",
			() -> new BlockItem(ModBlocks.PLUM_MILK_TEA_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));

	public static final RegistryObject<Item> JUJUBE_RECIPE_PACKAGE = ITEMS.register("jujube_recipe_package",
			() -> new BlockItem(ModBlocks.JUJUBE_RECIPE_PACKAGE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> JUJUBE_CAKE_RECIPE = ITEMS.register("jujube_cake_recipe",
			() -> new BlockItem(ModBlocks.JUJUBE_CAKE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> JUJUBE_CAKE_SLICE_RECIPE = ITEMS.register("jujube_cake_slice_recipe",
			() -> new BlockItem(ModBlocks.JUJUBE_CAKE_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> JUJUBE_COOKIE_RECIPE = ITEMS.register("jujube_cookie_recipe",
			() -> new BlockItem(ModBlocks.JUJUBE_COOKIE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> JUJUBE_CRATE_RECIPE = ITEMS.register("jujube_crate_recipe",
			() -> new BlockItem(ModBlocks.JUJUBE_CRATE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> JUJUBE_FILLING_RECIPE = ITEMS.register("jujube_filling_recipe",
			() -> new BlockItem(ModBlocks.JUJUBE_FILLING_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> JUJUBE_JAM_RECIPE = ITEMS.register("jujube_jam_recipe",
			() -> new BlockItem(ModBlocks.JUJUBE_JAM_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> JUJUBE_PIE_RECIPE = ITEMS.register("jujube_pie_recipe",
			() -> new BlockItem(ModBlocks.JUJUBE_PIE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> JUJUBE_PIE_SLICE_RECIPE = ITEMS.register("jujube_pie_slice_recipe",
			() -> new BlockItem(ModBlocks.JUJUBE_PIE_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> JUJUBE_RICE_DUMPLING_BLOCK_RECIPE = ITEMS.register("jujube_rice_dumpling_block_recipe",
			() -> new BlockItem(ModBlocks.JUJUBE_RICE_DUMPLING_BLOCK_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> RAW_JUJUBE_MOON_CAKE_RECIPE = ITEMS.register("raw_jujube_moon_cake_recipe",
			() -> new BlockItem(ModBlocks.RAW_JUJUBE_MOON_CAKE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> JUJUBE_JUICE_RECIPE = ITEMS.register("jujube_juice_recipe",
			() -> new BlockItem(ModBlocks.JUJUBE_JUICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> SWEETENED_JUJUBE_RECIPE = ITEMS.register("sweetened_jujube_recipe",
			() -> new BlockItem(ModBlocks.SWEETENED_JUJUBE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> JUJUBE_SAPLING_RECIPE = ITEMS.register("jujube_sapling_recipe",
			() -> new BlockItem(ModBlocks.JUJUBE_SAPLING_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> RED_GATE_GLUTINOUS_RICE_RECIPE = ITEMS.register("red_gate_glutinous_rice_recipe",
			() -> new BlockItem(ModBlocks.RED_GATE_GLUTINOUS_RICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> JUJUBE_MILK_TEA_RECIPE = ITEMS.register("jujube_milk_tea_recipe",
			() -> new BlockItem(ModBlocks.JUJUBE_MILK_TEA_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));

	public static final RegistryObject<Item> APRICOT_RECIPE_PACKAGE = ITEMS.register("apricot_recipe_package",
			() -> new BlockItem(ModBlocks.APRICOT_RECIPE_PACKAGE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> APRICOT_CAKE_RECIPE = ITEMS.register("apricot_cake_recipe",
			() -> new BlockItem(ModBlocks.APRICOT_CAKE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> APRICOT_CAKE_SLICE_RECIPE = ITEMS.register("apricot_cake_slice_recipe",
			() -> new BlockItem(ModBlocks.APRICOT_CAKE_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> APRICOT_COOKIE_RECIPE = ITEMS.register("apricot_cookie_recipe",
			() -> new BlockItem(ModBlocks.APRICOT_COOKIE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> APRICOT_CRATE_RECIPE = ITEMS.register("apricot_crate_recipe",
			() -> new BlockItem(ModBlocks.APRICOT_CRATE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> APRICOT_FILLING_RECIPE = ITEMS.register("apricot_filling_recipe",
			() -> new BlockItem(ModBlocks.APRICOT_FILLING_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> APRICOT_JAM_RECIPE = ITEMS.register("apricot_jam_recipe",
			() -> new BlockItem(ModBlocks.APRICOT_JAM_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> APRICOT_PIE_RECIPE = ITEMS.register("apricot_pie_recipe",
			() -> new BlockItem(ModBlocks.APRICOT_PIE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> APRICOT_PIE_SLICE_RECIPE = ITEMS.register("apricot_pie_slice_recipe",
			() -> new BlockItem(ModBlocks.APRICOT_PIE_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> APRICOT_RICE_DUMPLING_BLOCK_RECIPE = ITEMS.register("apricot_rice_dumpling_block_recipe",
			() -> new BlockItem(ModBlocks.APRICOT_RICE_DUMPLING_BLOCK_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> RAW_APRICOT_MOON_CAKE_RECIPE = ITEMS.register("raw_apricot_moon_cake_recipe",
			() -> new BlockItem(ModBlocks.RAW_APRICOT_MOON_CAKE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> APRICOT_JUICE_RECIPE = ITEMS.register("apricot_juice_recipe",
			() -> new BlockItem(ModBlocks.APRICOT_JUICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> APRICOT_SAPLING_RECIPE = ITEMS.register("apricot_sapling_recipe",
			() -> new BlockItem(ModBlocks.APRICOT_SAPLING_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> APRICOT_SMOOTHIE_RECIPE = ITEMS.register("apricot_smoothie_recipe",
			() -> new BlockItem(ModBlocks.APRICOT_SMOOTHIE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> APRICOT_MILK_TEA_RECIPE = ITEMS.register("apricot_milk_tea_recipe",
			() -> new BlockItem(ModBlocks.APRICOT_MILK_TEA_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));

	public static final RegistryObject<Item> RED_BAYBERRY_RECIPE_PACKAGE = ITEMS.register("red_bayberry_recipe_package",
			() -> new BlockItem(ModBlocks.RED_BAYBERRY_RECIPE_PACKAGE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> RED_BAYBERRY_CAKE_RECIPE = ITEMS.register("red_bayberry_cake_recipe",
			() -> new BlockItem(ModBlocks.RED_BAYBERRY_CAKE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> RED_BAYBERRY_CAKE_SLICE_RECIPE = ITEMS.register("red_bayberry_cake_slice_recipe",
			() -> new BlockItem(ModBlocks.RED_BAYBERRY_CAKE_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> RED_BAYBERRY_COOKIE_RECIPE = ITEMS.register("red_bayberry_cookie_recipe",
			() -> new BlockItem(ModBlocks.RED_BAYBERRY_COOKIE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> RED_BAYBERRY_CRATE_RECIPE = ITEMS.register("red_bayberry_crate_recipe",
			() -> new BlockItem(ModBlocks.RED_BAYBERRY_CRATE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> RED_BAYBERRY_FILLING_RECIPE = ITEMS.register("red_bayberry_filling_recipe",
			() -> new BlockItem(ModBlocks.RED_BAYBERRY_FILLING_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> RED_BAYBERRY_JAM_RECIPE = ITEMS.register("red_bayberry_jam_recipe",
			() -> new BlockItem(ModBlocks.RED_BAYBERRY_JAM_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> RED_BAYBERRY_PIE_RECIPE = ITEMS.register("red_bayberry_pie_recipe",
			() -> new BlockItem(ModBlocks.RED_BAYBERRY_PIE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> RED_BAYBERRY_PIE_SLICE_RECIPE = ITEMS.register("red_bayberry_pie_slice_recipe",
			() -> new BlockItem(ModBlocks.RED_BAYBERRY_PIE_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> RED_BAYBERRY_RICE_DUMPLING_BLOCK_RECIPE = ITEMS.register("red_bayberry_rice_dumpling_block_recipe",
			() -> new BlockItem(ModBlocks.RED_BAYBERRY_RICE_DUMPLING_BLOCK_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> RAW_RED_BAYBERRY_MOON_CAKE_RECIPE = ITEMS.register("raw_red_bayberry_moon_cake_recipe",
			() -> new BlockItem(ModBlocks.RAW_RED_BAYBERRY_MOON_CAKE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> RED_BAYBERRY_JUICE_RECIPE = ITEMS.register("red_bayberry_juice_recipe",
			() -> new BlockItem(ModBlocks.RED_BAYBERRY_JUICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> RED_BAYBERRY_SAPLING_RECIPE = ITEMS.register("red_bayberry_sapling_recipe",
			() -> new BlockItem(ModBlocks.RED_BAYBERRY_SAPLING_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> SOUR_PLUM_CHICKEN_BLOCK_RECIPE = ITEMS.register("sour_plum_chicken_block_recipe",
			() -> new BlockItem(ModBlocks.SOUR_PLUM_CHICKEN_BLOCK_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> RED_BAYBERRY_MILK_TEA_RECIPE = ITEMS.register("red_bayberry_milk_tea_recipe",
			() -> new BlockItem(ModBlocks.RED_BAYBERRY_MILK_TEA_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));

	public static final RegistryObject<Item> GREEN_PLUM_RECIPE_PACKAGE = ITEMS.register("green_plum_recipe_package",
			() -> new BlockItem(ModBlocks.GREEN_PLUM_RECIPE_PACKAGE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> GREEN_PLUM_CAKE_RECIPE = ITEMS.register("green_plum_cake_recipe",
			() -> new BlockItem(ModBlocks.GREEN_PLUM_CAKE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> GREEN_PLUM_CAKE_SLICE_RECIPE = ITEMS.register("green_plum_cake_slice_recipe",
			() -> new BlockItem(ModBlocks.GREEN_PLUM_CAKE_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> GREEN_PLUM_COOKIE_RECIPE = ITEMS.register("green_plum_cookie_recipe",
			() -> new BlockItem(ModBlocks.GREEN_PLUM_COOKIE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> GREEN_PLUM_CRATE_RECIPE = ITEMS.register("green_plum_crate_recipe",
			() -> new BlockItem(ModBlocks.GREEN_PLUM_CRATE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> GREEN_PLUM_FILLING_RECIPE = ITEMS.register("green_plum_filling_recipe",
			() -> new BlockItem(ModBlocks.GREEN_PLUM_FILLING_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> GREEN_PLUM_JAM_RECIPE = ITEMS.register("green_plum_jam_recipe",
			() -> new BlockItem(ModBlocks.GREEN_PLUM_JAM_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> GREEN_PLUM_PIE_RECIPE = ITEMS.register("green_plum_pie_recipe",
			() -> new BlockItem(ModBlocks.GREEN_PLUM_PIE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> GREEN_PLUM_PIE_SLICE_RECIPE = ITEMS.register("green_plum_pie_slice_recipe",
			() -> new BlockItem(ModBlocks.GREEN_PLUM_PIE_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> GREEN_PLUM_RICE_DUMPLING_BLOCK_RECIPE = ITEMS.register("green_plum_rice_dumpling_block_recipe",
			() -> new BlockItem(ModBlocks.GREEN_PLUM_RICE_DUMPLING_BLOCK_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> RAW_GREEN_PLUM_MOON_CAKE_RECIPE = ITEMS.register("raw_green_plum_moon_cake_recipe",
			() -> new BlockItem(ModBlocks.RAW_GREEN_PLUM_MOON_CAKE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> GREEN_PLUM_JUICE_RECIPE = ITEMS.register("green_plum_juice_recipe",
			() -> new BlockItem(ModBlocks.GREEN_PLUM_JUICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> GREEN_PLUM_SAPLING_RECIPE = ITEMS.register("green_plum_sapling_recipe",
			() -> new BlockItem(ModBlocks.GREEN_PLUM_SAPLING_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> GREEN_PLUM_MILK_TEA_RECIPE = ITEMS.register("green_plum_milk_tea_recipe",
			() -> new BlockItem(ModBlocks.GREEN_PLUM_MILK_TEA_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));

	public static final RegistryObject<Item> GRAPE_RECIPE_PACKAGE = ITEMS.register("grape_recipe_package",
			() -> new BlockItem(ModBlocks.GRAPE_RECIPE_PACKAGE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> GRAPE_CAKE_RECIPE = ITEMS.register("grape_cake_recipe",
			() -> new BlockItem(ModBlocks.GRAPE_CAKE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> GRAPE_CAKE_SLICE_RECIPE = ITEMS.register("grape_cake_slice_recipe",
			() -> new BlockItem(ModBlocks.GRAPE_CAKE_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> GRAPE_COOKIE_RECIPE = ITEMS.register("grape_cookie_recipe",
			() -> new BlockItem(ModBlocks.GRAPE_COOKIE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> GRAPE_CRATE_RECIPE = ITEMS.register("grape_crate_recipe",
			() -> new BlockItem(ModBlocks.GRAPE_CRATE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> GRAPE_FILLING_RECIPE = ITEMS.register("grape_filling_recipe",
			() -> new BlockItem(ModBlocks.GRAPE_FILLING_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> GRAPE_JAM_RECIPE = ITEMS.register("grape_jam_recipe",
			() -> new BlockItem(ModBlocks.GRAPE_JAM_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> GRAPE_PIE_RECIPE = ITEMS.register("grape_pie_recipe",
			() -> new BlockItem(ModBlocks.GRAPE_PIE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> GRAPE_PIE_SLICE_RECIPE = ITEMS.register("grape_pie_slice_recipe",
			() -> new BlockItem(ModBlocks.GRAPE_PIE_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> GRAPE_RICE_DUMPLING_BLOCK_RECIPE = ITEMS.register("grape_rice_dumpling_block_recipe",
			() -> new BlockItem(ModBlocks.GRAPE_RICE_DUMPLING_BLOCK_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> RAW_GRAPE_MOON_CAKE_RECIPE = ITEMS.register("raw_grape_moon_cake_recipe",
			() -> new BlockItem(ModBlocks.RAW_GRAPE_MOON_CAKE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> GRAPE_JUICE_RECIPE = ITEMS.register("grape_juice_recipe",
			() -> new BlockItem(ModBlocks.GRAPE_JUICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> SWEETENED_GRAPE_RECIPE = ITEMS.register("sweetened_grape_recipe",
			() -> new BlockItem(ModBlocks.SWEETENED_GRAPE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> GRAPE_JELLY_RECIPE = ITEMS.register("grape_jelly_recipe",
			() -> new BlockItem(ModBlocks.GRAPE_JELLY_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> GRAPE_MILK_TEA_RECIPE = ITEMS.register("grape_milk_tea_recipe",
			() -> new BlockItem(ModBlocks.GRAPE_MILK_TEA_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));

	public static final RegistryObject<Item> PEACH_RECIPE_PACKAGE = ITEMS.register("peach_recipe_package",
			() -> new BlockItem(ModBlocks.PEACH_RECIPE_PACKAGE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PEACH_SAPLING_RECIPE = ITEMS.register("peach_sapling_recipe",
			() -> new BlockItem(ModBlocks.PEACH_SAPLING_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PEACH_CAKE_RECIPE = ITEMS.register("peach_cake_recipe",
			() -> new BlockItem(ModBlocks.PEACH_CAKE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PEACH_CAKE_SLICE_RECIPE = ITEMS.register("peach_cake_slice_recipe",
			() -> new BlockItem(ModBlocks.PEACH_CAKE_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PEACH_COOKIE_RECIPE = ITEMS.register("peach_cookie_recipe",
			() -> new BlockItem(ModBlocks.PEACH_COOKIE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PEACH_CRATE_RECIPE = ITEMS.register("peach_crate_recipe",
			() -> new BlockItem(ModBlocks.PEACH_CRATE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PEACH_JAM_RECIPE = ITEMS.register("peach_jam_recipe",
			() -> new BlockItem(ModBlocks.PEACH_JAM_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PEACH_PIE_RECIPE = ITEMS.register("peach_pie_recipe",
			() -> new BlockItem(ModBlocks.PEACH_PIE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PEACH_PIE_SLICE_RECIPE = ITEMS.register("peach_pie_slice_recipe",
			() -> new BlockItem(ModBlocks.PEACH_PIE_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PEACH_SLICE_RECIPE = ITEMS.register("peach_slice_recipe",
			() -> new BlockItem(ModBlocks.PEACH_SLICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PEACH_RICE_DUMPLING_BLOCK_RECIPE = ITEMS.register("peach_rice_dumpling_block_recipe",
			() -> new BlockItem(ModBlocks.PEACH_RICE_DUMPLING_BLOCK_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PEACH_FILLING_RECIPE = ITEMS.register("peach_filling_recipe",
			() -> new BlockItem(ModBlocks.PEACH_FILLING_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> RAW_PEACH_MOON_CAKE_RECIPE = ITEMS.register("raw_peach_moon_cake_recipe",
			() -> new BlockItem(ModBlocks.RAW_PEACH_MOON_CAKE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> SWEETENED_PEACH_RECIPE = ITEMS.register("sweetened_peach_recipe",
			() -> new BlockItem(ModBlocks.SWEETENED_PEACH_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PEACH_JUICE_RECIPE = ITEMS.register("peach_juice_recipe",
			() -> new BlockItem(ModBlocks.PEACH_JUICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PEACH_MILK_TEA_RECIPE = ITEMS.register("peach_milk_tea_recipe",
			() -> new BlockItem(ModBlocks.PEACH_MILK_TEA_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> LACTOBACILLUS_HONEY_PEACH_ICE_RECIPE = ITEMS.register("lactobacillus_honey_peach_ice_recipe",
			() -> new BlockItem(ModBlocks.LACTOBACILLUS_HONEY_PEACH_ICE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));

	public static final RegistryObject<Item> FRYING_PAN_RECIPE_PACKAGE = ITEMS.register("frying_pan_recipe_package",
			() -> new BlockItem(ModBlocks.FRYING_PAN_RECIPE_PACKAGE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> FRYING_PAN_STIR_FRIED_BEATING_MELONS_SEEDS_RECIPE = ITEMS.register("frying_pan_stir_fried_beating_melons_seeds_recipe",
			() -> new BlockItem(ModBlocks.FRYING_PAN_STIR_FRIED_BEATING_MELONS_SEEDS_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> FRYING_PAN_CRISPY_LITCHI_BALL_RECIPE = ITEMS.register("frying_pan_crispy_litchi_ball_recipe",
			() -> new BlockItem(ModBlocks.FRYING_PAN_CRISPY_LITCHI_BALL_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> FRYING_PAN_HONEY_MELON_CHICKEN_BALLS_RECIPE = ITEMS.register("frying_pan_honey_melon_chicken_balls_recipe",
			() -> new BlockItem(ModBlocks.FRYING_PAN_HONEY_MELON_CHICKEN_BALLS_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> FRYING_PAN_STIR_FRIED_YOGURT_RECIPE = ITEMS.register("frying_pan_stir_fried_yogurt_recipe",
			() -> new BlockItem(ModBlocks.FRYING_PAN_STIR_FRIED_YOGURT_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> FRYING_PAN_MILKY_TEA_RECIPE_RECIPE = ITEMS.register("frying_pan_milky_tea_recipe",
			() -> new BlockItem(ModBlocks.FRYING_PAN_MILKY_TEA_RECIPE_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));

	public static final RegistryObject<Item> PIZZA_RECIPE_PACKAGE = ITEMS.register("pizza_recipe_package",
			() -> new BlockItem(ModBlocks.PIZZA_RECIPE_PACKAGE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> PIZZA_RECIPE = ITEMS.register("pizza_recipe",
			() -> new BlockItem(ModBlocks.PIZZA_RECIPE.get(), new Item.Properties().tab(fruitstack.CREATIVE_TAB).stacksTo(1)));
}
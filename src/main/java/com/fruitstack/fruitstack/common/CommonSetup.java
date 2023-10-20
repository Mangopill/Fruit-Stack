package com.fruitstack.fruitstack.common;

import com.fruitstack.fruitstack.common.loot.CopyMealFunction;
import com.fruitstack.fruitstack.common.registry.ModItems;
import net.minecraft.core.Position;
import net.minecraft.core.dispenser.AbstractProjectileDispenseBehavior;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Parrot;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctions;
import net.minecraftforge.common.crafting.CompoundIngredient;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;

public class CommonSetup {
	public static void init(final FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			registerCompostables();
			registerLootItemFunctions();
		});
	}

	public static void registerCompostables() {
		//mango
		ComposterBlock.COMPOSTABLES.put(ModItems.MANGO_SLICE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.MANGO_SEEDS.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.GREEN_MANGO_SLICE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.MANGO_PIE_SLICE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.MANGO_CAKE_SLICE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.MANGO_COOKIE.get(), 0.3F);

		ComposterBlock.COMPOSTABLES.put(ModItems.MANGO_BLOCK.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(ModItems.MANGO_SAPLING.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(ModItems.GREEN_MANGO_BLOCK.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(ModItems.MANGO_BREAD.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(ModItems.MANGO_DOUGHNUT.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(ModItems.SWEETENED_MANGO.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(ModItems.DRIED_MANGO.get(), 0.5F);

		ComposterBlock.COMPOSTABLES.put(ModItems.MANGO_POPSICLE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.MANGO_CAKE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.MANGO_PIE.get(), 0.7F);
        //blueberries
		ComposterBlock.COMPOSTABLES.put(ModItems.BLUEBERRIES_SEEDS.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.BLUEBERRIES_PIE_SLICE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.BLUEBERRIES_CAKE_SLICE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.BLUEBERRIES_COOKIE.get(), 0.3F);

		ComposterBlock.COMPOSTABLES.put(ModItems.BLUEBERRIES.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(ModItems.BLUEBERRIES_BREAD.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(ModItems.BLUEBERRIES_DOUGHNUT.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(ModItems.SWEETENED_BLUEBERRIES.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(ModItems.DRIED_BLUEBERRIES.get(), 0.5F);

		ComposterBlock.COMPOSTABLES.put(ModItems.BLUEBERRIES_POPSICLE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.BLUEBERRIES_CAKE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.BLUEBERRIES_PIE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.BLUEBERRIES_BARQUILLO.get(), 0.7F);
		//hamimelon
		ComposterBlock.COMPOSTABLES.put(ModItems.HAMIMELON_SEEDS.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.HAMIMELON_PIE_SLICE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.HAMIMELON_CAKE_SLICE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.HAMIMELON_COOKIE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.FISH_SKIN.get(), 0.3F);

		ComposterBlock.COMPOSTABLES.put(ModItems.HAMIMELON.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(ModItems.HAMIMELON_SAGO_SOUP.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(ModItems.SAGO_SOUP.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(ModItems.HAMIMELON_BREAD.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(ModItems.HAMIMELON_DOUGHNUT.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(ModItems.SWEETENED_HAMIMELON.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(ModItems.DRIED_HAMIMELON.get(), 0.5F);

		ComposterBlock.COMPOSTABLES.put(ModItems.HAMIMELON_POPSICLE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.HAMIMELON_SAGO_SOUP_BLOCK.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.HAMIMELON_CAKE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.HAMIMELON_PIE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.PROSCIUTTO_CANTALOUPE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.HONEY_MELON_CHICKEN_BALLS.get(), 0.7F);
		//beating_melons
		ComposterBlock.COMPOSTABLES.put(ModItems.BEATING_MELONS_SEEDS.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.STIR_FRIED_BEATING_MELONS_SEEDS.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.DRIED_BEATING_MELONS_SEEDS.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.BEATING_MELONS_SLICE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.BEATING_MELONS_COOKIE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.BEATING_MELONS_CAKE_SLICE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.BEATING_MELONS_PIE_SLICE.get(), 0.3F);

		ComposterBlock.COMPOSTABLES.put(ModItems.BEATING_MELONS.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(ModItems.BEATING_MELONS_BREAD.get(), 0.5F);

		ComposterBlock.COMPOSTABLES.put(ModItems.BEATING_MELONS_POPSICLE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.BEATING_MELONS_CAKE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.BEATING_MELONS_PIE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.BEATING_MELONS_DOUGHNUT.get(), 0.7F);
		//ground cucumber
		ComposterBlock.COMPOSTABLES.put(ModItems.GROUND_CUCUMBER_SEEDS.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.GROUND_CUCUMBER_SLICE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.GROUND_CUCUMBER_COOKIE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.GROUND_CUCUMBER_CAKE_SLICE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.GROUND_CUCUMBER_PIE_SLICE.get(), 0.3F);

		ComposterBlock.COMPOSTABLES.put(ModItems.GROUND_CUCUMBER.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(ModItems.GROUND_CUCUMBER_BREAD.get(), 0.5F);

		ComposterBlock.COMPOSTABLES.put(ModItems.GROUND_CUCUMBER_POPSICLE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.GROUND_CUCUMBER_CAKE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.GROUND_CUCUMBER_PIE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.GROUND_CUCUMBER_DOUGHNUT.get(), 0.7F);
		//holboellia latifolia
		ComposterBlock.COMPOSTABLES.put(ModItems.HOLBOELLIA_LATIFOLIA_SEEDS.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.HOLBOELLIA_LATIFOLIA_SLICE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.HOLBOELLIA_LATIFOLIA_COOKIE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.HOLBOELLIA_LATIFOLIA_CAKE_SLICE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.HOLBOELLIA_LATIFOLIA_PIE_SLICE.get(), 0.3F);

		ComposterBlock.COMPOSTABLES.put(ModItems.HOLBOELLIA_LATIFOLIA.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(ModItems.HOLBOELLIA_LATIFOLIA_BREAD.get(), 0.5F);

		ComposterBlock.COMPOSTABLES.put(ModItems.HOLBOELLIA_LATIFOLIA_POPSICLE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.HOLBOELLIA_LATIFOLIA_CAKE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.HOLBOELLIA_LATIFOLIA_PIE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.HOLBOELLIA_LATIFOLIA_DOUGHNUT.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.ONION_TOMATO_HOLBOELLIA_LATIFOLIA.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.HOLBOELLIA_LATIFOLIA_EGG_MILK_PUDDING.get(), 0.7F);
		//litchi
		ComposterBlock.COMPOSTABLES.put(ModItems.LITCHI_SLICE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.LITCHI_SEEDS.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.LITCHI_RIVER_NOODLES.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.LITCHI_PIE_SLICE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.LITCHI_CAKE_SLICE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.LITCHI_COOKIE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.LITCHI_RIVER_DOUGH.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.UNFORMED_LITCHI_RIVER_DOUGH.get(), 0.3F);

		ComposterBlock.COMPOSTABLES.put(ModItems.LITCHI_BLOCK.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(ModItems.LITCHI_SAPLING.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(ModItems.LITCHI_BREAD.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(ModItems.LITCHI_DOUGHNUT.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(ModItems.SWEETENED_LITCHI.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(ModItems.DRIED_LITCHI.get(), 0.5F);

		ComposterBlock.COMPOSTABLES.put(ModItems.LITCHI_POPSICLE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.LITCHI_CAKE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.LITCHI_PIE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.CRISPY_LITCHI_BALL.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.BOWLED_LITCHI_RIVER_NOODLES.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.LITCHI_ICE_CREAM.get(), 0.7F);
		//huoshen fruit
		ComposterBlock.COMPOSTABLES.put(ModItems.HUOSHEN_FRUIT_SEEDS.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.HUOSHEN_FRUIT_SLICE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.HUOSHEN_FRUIT_COOKIE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.HUOSHEN_FRUIT_CAKE_SLICE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.HUOSHEN_FRUIT_PIE_SLICE.get(), 0.3F);

		ComposterBlock.COMPOSTABLES.put(ModItems.HUOSHEN_FRUIT.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(ModItems.HUOSHEN_FRUIT_BREAD.get(), 0.5F);

		ComposterBlock.COMPOSTABLES.put(ModItems.HUOSHEN_FRUIT_POPSICLE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.HUOSHEN_FRUIT_CAKE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.HUOSHEN_FRUIT_PIE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.HUOSHEN_FRUIT_DOUGHNUT.get(), 0.7F);
		//september melon
		ComposterBlock.COMPOSTABLES.put(ModItems.SEPTEMBER_MELON_SEEDS.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.SEPTEMBER_MELON_COOKIE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.SEPTEMBER_MELON_CAKE_SLICE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.SEPTEMBER_MELON_PIE_SLICE.get(), 0.3F);

		ComposterBlock.COMPOSTABLES.put(ModItems.SEPTEMBER_MELON.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(ModItems.SEPTEMBER_MELON_BREAD.get(), 0.5F);

		ComposterBlock.COMPOSTABLES.put(ModItems.SEPTEMBER_MELON_POPSICLE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.SEPTEMBER_MELON_CAKE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.SEPTEMBER_MELON_PIE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.SEPTEMBER_MELON_DOUGHNUT.get(), 0.7F);
		//pitapa
		ComposterBlock.COMPOSTABLES.put(ModItems.PITAYA_SEEDS.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.PITAYA_COOKIE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.PITAYA_CAKE_SLICE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.PITAYA_PIE_SLICE.get(), 0.3F);

		ComposterBlock.COMPOSTABLES.put(ModItems.PITAYA.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(ModItems.PITAYA_BREAD.get(), 0.5F);

		ComposterBlock.COMPOSTABLES.put(ModItems.PITAYA_POPSICLE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.PITAYA_CAKE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.PITAYA_PIE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.PITAYA_DOUGHNUT.get(), 0.7F);
		//golden_pure_sheep_horn_honey
		ComposterBlock.COMPOSTABLES.put(ModItems.GOLDEN_PURE_SHEEP_HORN_HONEY_SEEDS.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.GOLDEN_PURE_SHEEP_HORN_HONEY_COOKIE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.GOLDEN_PURE_SHEEP_HORN_HONEY_SLICE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.GOLDEN_PURE_SHEEP_HORN_HONEY_PIE_SLICE.get(), 0.3F);

		ComposterBlock.COMPOSTABLES.put(ModItems.GOLDEN_PURE_SHEEP_HORN_HONEY.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(ModItems.GOLDEN_PURE_SHEEP_HORN_HONEY_BREAD.get(), 0.5F);

		ComposterBlock.COMPOSTABLES.put(ModItems.GOLDEN_PURE_SHEEP_HORN_HONEY_POPSICLE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.GOLDEN_PURE_SHEEP_HORN_HONEY_CAKE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.GOLDEN_PURE_SHEEP_HORN_HONEY_PIE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.GOLDEN_PURE_SHEEP_HORN_HONEY_DOUGHNUT.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.GOLDEN_PURE_SHEEP_HORN_HONEY_FLAVOR_GOLDEN_PURE_SHEEP_HORN_HONEY.get(), 0.7F);
		//pear
		ComposterBlock.COMPOSTABLES.put(ModItems.PEAR_SAPLING.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.PEAR_COOKIE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.PEAR_SLICE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.PEAR_PIE_SLICE.get(), 0.3F);

		ComposterBlock.COMPOSTABLES.put(ModItems.PEAR_BLOCK.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(ModItems.PEAR_BREAD.get(), 0.5F);

		ComposterBlock.COMPOSTABLES.put(ModItems.PEAR_POPSICLE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.PEAR_CAKE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.PEAR_PIE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.PEAR_DOUGHNUT.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.ROCK_SUPAR_SNOW_PEAR.get(), 0.7F);
		//maythorn
		ComposterBlock.COMPOSTABLES.put(ModItems.MAYTHORN_SAPLING.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.MAYTHORN_COOKIE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.MAYTHORN_PIE_SLICE.get(), 0.3F);

		ComposterBlock.COMPOSTABLES.put(ModItems.MAYTHORN.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(ModItems.MAYTHORN_BREAD.get(), 0.5F);

		ComposterBlock.COMPOSTABLES.put(ModItems.MAYTHORN_POPSICLE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.MAYTHORN_CAKE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.MAYTHORN_PIE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.MAYTHORN_DOUGHNUT.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.SWEETENED_MAYTHORN.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(ModItems.DRIED_MAYTHORN.get(), 0.5F);
		//chinese_pear
		ComposterBlock.COMPOSTABLES.put(ModItems.CHINESE_PEAR_LEAVED_SAPLING.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.CHINESE_PEAR_LEAVED_COOKIE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.CHINESE_PEAR_LEAVED_PIE_SLICE.get(), 0.3F);

		ComposterBlock.COMPOSTABLES.put(ModItems.CHINESE_PEAR_LEAVED_BLOCK.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(ModItems.CHINESE_PEAR_LEAVED_BREAD.get(), 0.5F);

		ComposterBlock.COMPOSTABLES.put(ModItems.CHINESE_PEAR_LEAVED_POPSICLE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.CHINESE_PEAR_LEAVED_CAKE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.CHINESE_PEAR_LEAVED_PIE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.CHINESE_PEAR_LEAVED_DOUGHNUT.get(), 0.7F);
		//plum
		ComposterBlock.COMPOSTABLES.put(ModItems.PLUM_SAPLING.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.PLUM_COOKIE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.PLUM_PIE_SLICE.get(), 0.3F);

		ComposterBlock.COMPOSTABLES.put(ModItems.PLUM.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(ModItems.PLUM_BREAD.get(), 0.5F);

		ComposterBlock.COMPOSTABLES.put(ModItems.PLUM_POPSICLE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.PLUM_CAKE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.PLUM_PIE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.PLUM_DOUGHNUT.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.SWEETENED_PLUM.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(ModItems.DRIED_PLUM.get(), 0.5F);
		//jujube
		ComposterBlock.COMPOSTABLES.put(ModItems.JUJUBE_SAPLING.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.JUJUBE_COOKIE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.JUJUBE_PIE_SLICE.get(), 0.3F);

		ComposterBlock.COMPOSTABLES.put(ModItems.JUJUBE.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(ModItems.JUJUBE_BREAD.get(), 0.5F);

		ComposterBlock.COMPOSTABLES.put(ModItems.JUJUBE_POPSICLE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.JUJUBE_CAKE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.JUJUBE_PIE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.JUJUBE_DOUGHNUT.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.SWEETENED_JUJUBE.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(ModItems.DRIED_JUJUBE.get(), 0.5F);
		//apricot
		ComposterBlock.COMPOSTABLES.put(ModItems.APRICOT_SAPLING.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.APRICOT_COOKIE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.APRICOT_PIE_SLICE.get(), 0.3F);

		ComposterBlock.COMPOSTABLES.put(ModItems.APRICOT.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(ModItems.APRICOT_BREAD.get(), 0.5F);

		ComposterBlock.COMPOSTABLES.put(ModItems.APRICOT_POPSICLE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.APRICOT_CAKE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.APRICOT_PIE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.APRICOT_DOUGHNUT.get(), 0.7F);
		//red_bayberry
		ComposterBlock.COMPOSTABLES.put(ModItems.RED_BAYBERRY_SAPLING.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.RED_BAYBERRY_COOKIE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.RED_BAYBERRY_PIE_SLICE.get(), 0.3F);

		ComposterBlock.COMPOSTABLES.put(ModItems.RED_BAYBERRY.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(ModItems.RED_BAYBERRY_BREAD.get(), 0.5F);

		ComposterBlock.COMPOSTABLES.put(ModItems.RED_BAYBERRY_POPSICLE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.RED_BAYBERRY_CAKE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.RED_BAYBERRY_PIE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.RED_BAYBERRY_DOUGHNUT.get(), 0.7F);
		//green_plum
		ComposterBlock.COMPOSTABLES.put(ModItems.GREEN_PLUM_SAPLING.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.GREEN_PLUM_COOKIE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.GREEN_PLUM_PIE_SLICE.get(), 0.3F);

		ComposterBlock.COMPOSTABLES.put(ModItems.GREEN_PLUM.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(ModItems.GREEN_PLUM_BREAD.get(), 0.5F);

		ComposterBlock.COMPOSTABLES.put(ModItems.GREEN_PLUM_POPSICLE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.GREEN_PLUM_CAKE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.GREEN_PLUM_PIE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.GREEN_PLUM_DOUGHNUT.get(), 0.7F);
		//grape
		ComposterBlock.COMPOSTABLES.put(ModItems.GRAPE_CROP_BOTTOM.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.GRAPE_COOKIE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.GRAPE_PIE_SLICE.get(), 0.3F);

		ComposterBlock.COMPOSTABLES.put(ModItems.GRAPE.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(ModItems.GRAPE_BREAD.get(), 0.5F);

		ComposterBlock.COMPOSTABLES.put(ModItems.GRAPE_POPSICLE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.GRAPE_CAKE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.GRAPE_PIE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.GRAPE_DOUGHNUT.get(), 0.7F);
		//peach
		ComposterBlock.COMPOSTABLES.put(ModItems.PEACH_SLICE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.PEACH_PIE_SLICE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.PEACH_CAKE_SLICE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ModItems.PEACH_COOKIE.get(), 0.3F);

		ComposterBlock.COMPOSTABLES.put(ModItems.PEACH_BLOCK.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(ModItems.PEACH_SAPLING.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(ModItems.PEACH_BREAD.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(ModItems.PEACH_DOUGHNUT.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(ModItems.SWEETENED_PEACH.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(ModItems.DRIED_PEACH.get(), 0.5F);

		ComposterBlock.COMPOSTABLES.put(ModItems.PEACH_POPSICLE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.PEACH_CAKE.get(), 0.7F);
		ComposterBlock.COMPOSTABLES.put(ModItems.PEACH_PIE.get(), 0.7F);
		//pizza
		ComposterBlock.COMPOSTABLES.put(ModItems.HAWTHORN_NUT_PIZZA_SLICE.get(), 0.4F);
		ComposterBlock.COMPOSTABLES.put(ModItems.BLUE_RED_MANGO_PIZZA_SLICE.get(), 0.4F);
		ComposterBlock.COMPOSTABLES.put(ModItems.GRAPE_FRUIT_SAND_PIZZA_SLICE.get(), 0.4F);
		ComposterBlock.COMPOSTABLES.put(ModItems.SWEET_AND_REFRESHING_FLAVORED_PIZZA_SLICE.get(), 0.4F);
	}

	public static void registerLootItemFunctions() {
		try {
			Method registerMethod = LootItemFunctions.class.getDeclaredMethod("register", String.class, net.minecraft.world.level.storage.loot.Serializer.class);
			registerMethod.setAccessible(true);
			registerMethod.invoke(null, CopyMealFunction.ID.toString(), new CopyMealFunction.Serializer());
		} catch (Exception e) {
			// 异常处理
		}
	}
}

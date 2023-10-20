package com.fruitstack.fruitstack.common;

import com.fruitstack.fruitstack.common.registry.ModEffects;
import com.mojang.blaze3d.shaders.Effect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class FoodValues
{
	public static final int SWEET_SHORT_DURATION = 100;
	public static final int SWEET_DURATION = 320;
	public static final int BRIEF_DURATION = 600;    // 30 seconds
	public static final int SHORT_DURATION = 1200;    // 1 minute
	public static final int MEDIUM_DURATION = 3600;    // 3 minutes
	public static final int LONG_DURATION = 6000;    // 5 minutes
	//core food
	public static final FoodProperties THE_BURNT_DISH = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 200, 0), 1.0F).build();
	public static final FoodProperties STIR_FRIED_YOGURT = (new FoodProperties.Builder())
			.nutrition(5).saturationMod(0.5f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 350, 0, false, false), 1.0F).build();
	public static final FoodProperties DOUGHNUT = (new FoodProperties.Builder())
			.nutrition(5).saturationMod(0.5f).fast().alwaysEat().build();
	public static final FoodProperties MILKY_TEA = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 600, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.WARM_STOMACH.get(), 600, 0), 1.0F).build();
	public static final FoodProperties CHINESE_SPIRITS_ONE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 200, 0), 1.0F).build();
	public static final FoodProperties CHINESE_SPIRITS_TWO = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 300, 0), 1.0F).build();
	public static final FoodProperties CHINESE_SPIRITS_THREE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 400, 0), 1.0F).build();
	public static final FoodProperties CHINESE_SPIRITS_FOUR = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 500, 0), 1.0F).build();
	public static final FoodProperties CHINESE_SPIRITS_FIVE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 600, 0), 1.0F).build();
	public static final FoodProperties CHINESE_SPIRITS_SIX = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 700, 0), 1.0F).build();
	public static final FoodProperties CHINESE_SPIRITS_SEVEN = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 800, 0), 1.0F).build();
	public static final FoodProperties CHINESE_SPIRITS_EIGHT = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 900, 0), 1.0F).build();
	public static final FoodProperties CHINESE_SPIRITS_NINE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 1000, 0), 1.0F).build();
	public static final FoodProperties CHINESE_SPIRITS_TEN = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 1500, 0), 1.0F).build();

	//blueberries
	public static final FoodProperties BLUEBERRIES = (new FoodProperties.Builder())
			.nutrition(1).saturationMod(0.3f).fast().alwaysEat().build();
	public static final FoodProperties BLUEBERRIES_POPSICLE = (new FoodProperties.Builder())
			.nutrition(3).saturationMod(0.2f).fast().alwaysEat().build();
	public static final FoodProperties BLUEBERRIES_PIE_SLICE = (new FoodProperties.Builder())
			.nutrition(4).saturationMod(0.3f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 0, false, false), 1.0F).build();
	public static final FoodProperties BLUEBERRIES_CAKE_SLICE = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.1f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.JUMP, 400, 0, false, false), 1.0F).build();
	public static final FoodProperties BLUEBERRIES_BARQUILLO = (new FoodProperties.Builder())
			.nutrition(6).saturationMod(0.8f).alwaysEat().build();
	public static final FoodProperties BLUEBERRIES_COOKIE = (new FoodProperties.Builder())
			.nutrition(3).saturationMod(0.2f).fast().alwaysEat().build();
	public static final FoodProperties BLUEBERRIES_BREAD = (new FoodProperties.Builder())
			.nutrition(7).saturationMod(0.8f).alwaysEat().build();
	public static final FoodProperties BLUEBERRIES_DOUGHNUT = (new FoodProperties.Builder())
			.nutrition(5).saturationMod(0.5f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties DRIED_BLUEBERRIES = (new FoodProperties.Builder())
			.nutrition(5).saturationMod(0.5f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties BLUEBERRIES_JUICE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 1200, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties BLUEBERRIES_WINE_ONE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 60, 0), 1.0F).build();
	public static final FoodProperties BLUEBERRIES_WINE_TWO = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 120, 0), 1.0F).build();
	public static final FoodProperties BLUEBERRIES_WINE_THREE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 240, 0), 1.0F).build();
	public static final FoodProperties BLUEBERRIES_WINE_FOUR = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 360, 0), 1.0F).build();
	public static final FoodProperties BLUEBERRIES_WINE_FIVE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 480, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 1000, 0), 1.0F).build();
	public static final FoodProperties BLUEBERRIES_WINE_SIX = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 600, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 1200, 0), 1.0F).build();
	public static final FoodProperties BLUEBERRIES_WINE_SEVEN = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 700, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 1600, 0), 1.0F).build();
	public static final FoodProperties BLUEBERRIES_WINE_EIGHT = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 800, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 2000, 0), 1.0F).build();
	public static final FoodProperties BLUEBERRIES_WINE_NINE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 850, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 2400, 0), 1.0F).build();
	public static final FoodProperties BLUEBERRIES_WINE_TEN = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 900, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 2000, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 1000, 0), 1.0F).build();
	public static final FoodProperties BLUEBERRIES_MILK_TEA = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 1200, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.WARM_STOMACH.get(), 1200, 0), 1.0F).build();
	//hamimelon
	public static final FoodProperties HAMIMELON = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.2f).alwaysEat().build();
	public static final FoodProperties HAMIMELON_POPSICLE = (new FoodProperties.Builder())
			.nutrition(3).saturationMod(0.2f).fast().alwaysEat().build();
	public static final FoodProperties HAMIMELON_SAGO_SOUP = (new FoodProperties.Builder())
			.nutrition(10).saturationMod(0.65f)
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_DURATION, 0), 1.0F).build();
	public static final FoodProperties HAMIMELON_CAKE_SLICE = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.2f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 400, 0, false, false), 1.0F).build();
	public static final FoodProperties HAMIMELON_PIE_SLICE = (new FoodProperties.Builder())
			.nutrition(4).saturationMod(0.3f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 600, 0, false, false), 1.0F).build();
	public static final FoodProperties HAMIMELON_COOKIE = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.2f).fast().alwaysEat().build();
	public static final FoodProperties PROSCIUTTO_CANTALOUPE = (new FoodProperties.Builder())
			.nutrition(11).saturationMod(0.8f).alwaysEat().build();
	public static final FoodProperties HONEY_MELON_CHICKEN_BALLS = (new FoodProperties.Builder())
			.nutrition(10).saturationMod(0.9f)
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_DURATION, 0), 1.0F).build();
	public static final FoodProperties SAGO_SOUP = (new FoodProperties.Builder())
			.nutrition(1).saturationMod(0.1f).fast().alwaysEat().build();
	public static final FoodProperties HAMIMELON_BREAD = (new FoodProperties.Builder())
			.nutrition(7).saturationMod(0.8f).alwaysEat().build();
	public static final FoodProperties HAMIMELON_DOUGHNUT = (new FoodProperties.Builder())
			.nutrition(5).saturationMod(0.5f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties DRIED_HAMIMELON = (new FoodProperties.Builder())
			.nutrition(4).saturationMod(0.5f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties HAMIMELON_JUICE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 1200, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties HAMIMELON_WINE_ONE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 60, 0), 1.0F).build();
	public static final FoodProperties HAMIMELON_WINE_TWO = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 120, 0), 1.0F).build();
	public static final FoodProperties HAMIMELON_WINE_THREE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 240, 0), 1.0F).build();
	public static final FoodProperties HAMIMELON_WINE_FOUR = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 360, 0), 1.0F).build();
	public static final FoodProperties HAMIMELON_WINE_FIVE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 480, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1000, 0), 1.0F).build();
	public static final FoodProperties HAMIMELON_WINE_SIX = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 600, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1200, 0), 1.0F).build();
	public static final FoodProperties HAMIMELON_WINE_SEVEN = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 700, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1600, 0), 1.0F).build();
	public static final FoodProperties HAMIMELON_WINE_EIGHT = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 800, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 2000, 0), 1.0F).build();
	public static final FoodProperties HAMIMELON_WINE_NINE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 850, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 2400, 0), 1.0F).build();
	public static final FoodProperties HAMIMELON_WINE_TEN = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 900, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 2000, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 1000, 0), 1.0F).build();
	public static final FoodProperties HAMIMELON_MILK_TEA = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 1200, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.WARM_STOMACH.get(), 1200, 0), 1.0F).build();
	//mango
	public static final FoodProperties MANGO_SLICE = (new FoodProperties.Builder())
			.nutrition(1).saturationMod(0.1f).fast().alwaysEat().build();
	public static final FoodProperties GREEN_MANGO_SLICE = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.2f).fast().alwaysEat().build();
	public static final FoodProperties MANGO_POPSICLE = (new FoodProperties.Builder())
			.nutrition(3).saturationMod(0.3f).fast().alwaysEat().build();
	public static final FoodProperties MANGO_PIE_SLICE = (new FoodProperties.Builder())
			.nutrition(5).saturationMod(0.3f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 0, false, false), 1.0F).build();
	public static final FoodProperties MANGO_CAKE_SLICE = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.2f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 400, 0, false, false), 1.0F).build();
	public static final FoodProperties MANGO_COOKIE = (new FoodProperties.Builder())
			.nutrition(3).saturationMod(0.3f).fast().alwaysEat().build();
	public static final FoodProperties MANGO_BREAD = (new FoodProperties.Builder())
			.nutrition(7).saturationMod(0.8f).alwaysEat().build();
	public static final FoodProperties MANGO_DOUGHNUT = (new FoodProperties.Builder())
			.nutrition(5).saturationMod(0.6f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties DRIED_MANGO = (new FoodProperties.Builder())
			.nutrition(6).saturationMod(0.6f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties MANGO_JUICE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 1200, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties MANGO_MILK_ICE_CREAM = (new FoodProperties.Builder())
			.nutrition(10).saturationMod(0.8f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.HEAL, 20, 0), 1.0F).build();
	public static final FoodProperties MANGO_WINE_ONE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 60, 0), 1.0F).build();
	public static final FoodProperties MANGO_WINE_TWO = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 120, 0), 1.0F).build();
	public static final FoodProperties MANGO_WINE_THREE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 240, 0), 1.0F).build();
	public static final FoodProperties MANGO_WINE_FOUR = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 360, 0), 1.0F).build();
	public static final FoodProperties MANGO_WINE_FIVE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 480, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 1000, 0), 1.0F).build();
	public static final FoodProperties MANGO_WINE_SIX = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 600, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 1200, 0), 1.0F).build();
	public static final FoodProperties MANGO_WINE_SEVEN = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 700, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 1600, 0), 1.0F).build();
	public static final FoodProperties MANGO_WINE_EIGHT = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 800, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 2000, 0), 1.0F).build();
	public static final FoodProperties MANGO_WINE_NINE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 850, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 2400, 0), 1.0F).build();
	public static final FoodProperties MANGO_WINE_TEN = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 900, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 2000, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1000, 0), 1.0F).build();
	public static final FoodProperties MANGO_MILK_TEA = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 1200, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.WARM_STOMACH.get(), 1200, 0), 1.0F).build();
	//holboellia latifolia
	public static final FoodProperties HOLBOELLIA_LATIFOLIA_SLICE = (new FoodProperties.Builder())
			.nutrition(1).saturationMod(0.1f).fast().alwaysEat().build();
	public static final FoodProperties HOLBOELLIA_LATIFOLIA_POPSICLE = (new FoodProperties.Builder())
			.nutrition(3).saturationMod(0.2f).fast().alwaysEat().build();
	public static final FoodProperties HOLBOELLIA_LATIFOLIA_COOKIE = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.3f).fast().alwaysEat().build();
	public static final FoodProperties HOLBOELLIA_LATIFOLIA_PIE_SLICE = (new FoodProperties.Builder())
			.nutrition(5).saturationMod(0.3f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 600, 0, false, false), 1.0F).build();
	public static final FoodProperties HOLBOELLIA_LATIFOLIA_CAKE_SLICE = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.2f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 0, false, false), 1.0F).build();
	public static final FoodProperties ONION_TOMATO_HOLBOELLIA_LATIFOLIA = (new FoodProperties.Builder())
			.nutrition(7).saturationMod(0.65f)
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_DURATION, 0), 1.0F).build();
	public static final FoodProperties HOLBOELLIA_LATIFOLIA_BREAD = (new FoodProperties.Builder())
			.nutrition(6).saturationMod(0.8f).alwaysEat().build();
	public static final FoodProperties HOLBOELLIA_LATIFOLIA_DOUGHNUT = (new FoodProperties.Builder())
			.nutrition(5).saturationMod(0.5f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties HOLBOELLIA_LATIFOLIA_JUICE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 1200, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties HOLBOELLIA_LATIFOLIA_WINE_ONE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 60, 0), 1.0F).build();
	public static final FoodProperties HOLBOELLIA_LATIFOLIA_WINE_TWO = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 120, 0), 1.0F).build();
	public static final FoodProperties HOLBOELLIA_LATIFOLIA_WINE_THREE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 240, 0), 1.0F).build();
	public static final FoodProperties HOLBOELLIA_LATIFOLIA_WINE_FOUR = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 360, 0), 1.0F).build();
	public static final FoodProperties HOLBOELLIA_LATIFOLIA_WINE_FIVE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 480, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 1000, 0), 1.0F).build();
	public static final FoodProperties HOLBOELLIA_LATIFOLIA_WINE_SIX = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 600, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 1200, 0), 1.0F).build();
	public static final FoodProperties HOLBOELLIA_LATIFOLIA_WINE_SEVEN = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 700, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 1600, 0), 1.0F).build();
	public static final FoodProperties HOLBOELLIA_LATIFOLIA_WINE_EIGHT = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 800, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 2000, 0), 1.0F).build();
	public static final FoodProperties HOLBOELLIA_LATIFOLIA_WINE_NINE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 850, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 2400, 0), 1.0F).build();
	public static final FoodProperties HOLBOELLIA_LATIFOLIA_WINE_TEN = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 900, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 2000, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 1000, 0), 1.0F).build();
	public static final FoodProperties HOLBOELLIA_LATIFOLIA_MILK_TEA = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 1200, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.WARM_STOMACH.get(), 1200, 0), 1.0F).build();
	//huoshen fruit
	public static final FoodProperties HUOSHEN_FRUIT_SLICE = (new FoodProperties.Builder())
			.nutrition(1).saturationMod(0.1f).fast().alwaysEat().build();
	public static final FoodProperties HUOSHEN_FRUIT_POPSICLE = (new FoodProperties.Builder())
			.nutrition(3).saturationMod(0.2f).fast().alwaysEat().build();
	public static final FoodProperties HUOSHEN_FRUIT_PIE_SLICE = (new FoodProperties.Builder())
			.nutrition(3).saturationMod(0.3f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 600, 0, false, false), 1.0F).build();
	public static final FoodProperties HUOSHEN_FRUIT_CAKE_SLICE = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.2f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0, false, false), 1.0F).build();
	public static final FoodProperties HUOSHEN_FRUIT_COOKIE = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.2f).fast().alwaysEat().build();
	public static final FoodProperties HUOSHEN_FRUIT_BREAD = (new FoodProperties.Builder())
			.nutrition(7).saturationMod(0.8f).alwaysEat().build();
	public static final FoodProperties HUOSHEN_FRUIT_DOUGHNUT = (new FoodProperties.Builder())
			.nutrition(5).saturationMod(0.7f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties HUOSHEN_FRUIT_JUICE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties HUOSHEN_FRUIT_WINE_ONE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 60, 0), 1.0F).build();
	public static final FoodProperties HUOSHEN_FRUIT_WINE_TWO = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 120, 0), 1.0F).build();
	public static final FoodProperties HUOSHEN_FRUIT_WINE_THREE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 240, 0), 1.0F).build();
	public static final FoodProperties HUOSHEN_FRUIT_WINE_FOUR = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 360, 0), 1.0F).build();
	public static final FoodProperties HUOSHEN_FRUIT_WINE_FIVE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 480, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.JUMP, 1000, 0), 1.0F).build();
	public static final FoodProperties HUOSHEN_FRUIT_WINE_SIX = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 600, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.JUMP, 1200, 0), 1.0F).build();
	public static final FoodProperties HUOSHEN_FRUIT_WINE_SEVEN = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 700, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.JUMP, 1600, 0), 1.0F).build();
	public static final FoodProperties HUOSHEN_FRUIT_WINE_EIGHT = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 800, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.JUMP, 2000, 0), 1.0F).build();
	public static final FoodProperties HUOSHEN_FRUIT_WINE_NINE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 850, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.JUMP, 2400, 0), 1.0F).build();
	public static final FoodProperties HUOSHEN_FRUIT_WINE_TEN = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 900, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.JUMP, 2000, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1000, 0), 1.0F).build();
	public static final FoodProperties HUOSHEN_FRUIT_MILK_TEA = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.WARM_STOMACH.get(), 1200, 0), 1.0F).build();
	//September Melon
	public static final FoodProperties SEPTEMBER_MELON = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.2f).alwaysEat().build();
	public static final FoodProperties SEPTEMBER_MELON_POPSICLE = (new FoodProperties.Builder())
			.nutrition(3).saturationMod(0.2f).fast().alwaysEat().build();
	public static final FoodProperties SEPTEMBER_MELON_PIE_SLICE = (new FoodProperties.Builder())
			.nutrition(3).saturationMod(0.3f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.LUCK, 600, 0, false, false), 1.0F).build();
	public static final FoodProperties SEPTEMBER_MELON_CAKE_SLICE = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.2f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 400, 0, false, false), 1.0F).build();
	public static final FoodProperties SEPTEMBER_MELON_COOKIE = (new FoodProperties.Builder())
			.nutrition(3).saturationMod(0.2f).fast().alwaysEat().build();
	public static final FoodProperties SEPTEMBER_MELON_BREAD = (new FoodProperties.Builder())
			.nutrition(6).saturationMod(0.6f).alwaysEat().build();
	public static final FoodProperties SEPTEMBER_MELON_DOUGHNUT = (new FoodProperties.Builder())
			.nutrition(5).saturationMod(0.6f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties SEPTEMBER_MELON_JUICE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties SEPTEMBER_MELON_WINE_ONE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 60, 0), 1.0F).build();
	public static final FoodProperties SEPTEMBER_MELON_WINE_TWO = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 120, 0), 1.0F).build();
	public static final FoodProperties SEPTEMBER_MELON_WINE_THREE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 240, 0), 1.0F).build();
	public static final FoodProperties SEPTEMBER_MELON_WINE_FOUR = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 360, 0), 1.0F).build();
	public static final FoodProperties SEPTEMBER_MELON_WINE_FIVE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 480, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 1000, 0), 1.0F).build();
	public static final FoodProperties SEPTEMBER_MELON_WINE_SIX = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 600, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 1200, 0), 1.0F).build();
	public static final FoodProperties SEPTEMBER_MELON_WINE_SEVEN = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 700, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 1600, 0), 1.0F).build();
	public static final FoodProperties SEPTEMBER_MELON_WINE_EIGHT = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 800, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 2000, 0), 1.0F).build();
	public static final FoodProperties SEPTEMBER_MELON_WINE_NINE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 850, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 2400, 0), 1.0F).build();
	public static final FoodProperties SEPTEMBER_MELON_WINE_TEN = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 900, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 2000, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 1000, 0), 1.0F).build();
	public static final FoodProperties SEPTEMBER_MELON_MILK_TEA = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.WARM_STOMACH.get(), 1200, 0), 1.0F).build();

	//litchi
	public static final FoodProperties LITCHI_SLICE = (new FoodProperties.Builder())
			.nutrition(1).saturationMod(0.1f).fast().alwaysEat().build();
	public static final FoodProperties LITCHI_POPSICLE = (new FoodProperties.Builder())
			.nutrition(3).saturationMod(0.2f).fast().alwaysEat().build();
	public static final FoodProperties LITCHI_PIE_SLICE = (new FoodProperties.Builder())
			.nutrition(3).saturationMod(0.3f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600, 0, false, false), 1.0F).build();
	public static final FoodProperties LITCHI_CAKE_SLICE = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.2f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 400, 0, false, false), 1.0F).build();
	public static final FoodProperties LITCHI_COOKIE = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.2f).fast().alwaysEat().build();
	public static final FoodProperties LITCHI_RIVER_NOODLES = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.2f).alwaysEat().build();

	public static final FoodProperties LITCHI_ICE_CREAM = (new FoodProperties.Builder())
			.nutrition(5).saturationMod(0.6f)
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_DURATION, 0), 1.0F).build();
	public static final FoodProperties CRISPY_LITCHI_BALL = (new FoodProperties.Builder())
			.nutrition(6).saturationMod(0.5f)
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_DURATION, 0), 1.0F).build();
	public static final FoodProperties LITCHI_BREAD = (new FoodProperties.Builder())
			.nutrition(7).saturationMod(0.8f).alwaysEat().build();
	public static final FoodProperties LITCHI_DOUGHNUT = (new FoodProperties.Builder())
			.nutrition(6).saturationMod(0.4f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties DRIED_LITCHI = (new FoodProperties.Builder())
			.nutrition(5).saturationMod(0.9f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties LITCHI_JUICE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 1200, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties LITCHI_WINE_ONE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 60, 0), 1.0F).build();
	public static final FoodProperties LITCHI_WINE_TWO = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 120, 0), 1.0F).build();
	public static final FoodProperties LITCHI_WINE_THREE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 240, 0), 1.0F).build();
	public static final FoodProperties LITCHI_WINE_FOUR = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 360, 0), 1.0F).build();
	public static final FoodProperties LITCHI_WINE_FIVE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 480, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1000, 0), 1.0F).build();
	public static final FoodProperties LITCHI_WINE_SIX = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 600, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 0), 1.0F).build();
	public static final FoodProperties LITCHI_WINE_SEVEN = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 700, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1600, 0), 1.0F).build();
	public static final FoodProperties LITCHI_WINE_EIGHT = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 800, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2000, 0), 1.0F).build();
	public static final FoodProperties LITCHI_WINE_NINE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 850, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2400, 0), 1.0F).build();
	public static final FoodProperties LITCHI_WINE_TEN = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 900, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2000, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.LUCK, 1000, 0), 1.0F).build();
	public static final FoodProperties LITCHI_MILK_TEA = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 1200, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.WARM_STOMACH.get(), 1200, 0), 1.0F).build();
	//pitaya
	public static final FoodProperties PITAYA_SLICE = (new FoodProperties.Builder())
			.nutrition(1).saturationMod(0.1f).fast().alwaysEat().build();
	public static final FoodProperties PITAYA_POPSICLE = (new FoodProperties.Builder())
			.nutrition(3).saturationMod(0.3f).fast().alwaysEat().build();
	public static final FoodProperties PITAYA_PIE_SLICE = (new FoodProperties.Builder())
			.nutrition(3).saturationMod(0.3f).fast().alwaysEat()
				.effect(() -> new MobEffectInstance(MobEffects.CONDUIT_POWER, 600, 0, false, false), 1.0F).build();
	public static final FoodProperties PITAYA_CAKE_SLICE = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.3f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.JUMP, 400, 0, false, false), 1.0F).build();
	public static final FoodProperties PITAYA_RICE_AND_VEGETABLE_ROLL = (new FoodProperties.Builder())
			.nutrition(6).saturationMod(0.7f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 400, 0, false, false), 1.0F).build();
	public static final FoodProperties PITAYA_COOKIE = (new FoodProperties.Builder())
			.nutrition(3).saturationMod(0.3f).fast().alwaysEat().build();
	public static final FoodProperties PITAYA_BREAD = (new FoodProperties.Builder())
			.nutrition(6).saturationMod(0.6f).alwaysEat().build();
	public static final FoodProperties PITAYA_DOUGHNUT = (new FoodProperties.Builder())
			.nutrition(5).saturationMod(0.6f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties PITAYA_JUICE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(MobEffects.JUMP, 1200, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties DRIED_PITAYA = (new FoodProperties.Builder())
			.nutrition(6).saturationMod(0.6f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties PITAYA_WINE_ONE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 60, 0), 1.0F).build();
	public static final FoodProperties PITAYA_WINE_TWO = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 120, 0), 1.0F).build();
	public static final FoodProperties PITAYA_WINE_THREE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 240, 0), 1.0F).build();
	public static final FoodProperties PITAYA_WINE_FOUR = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 360, 0), 1.0F).build();
	public static final FoodProperties PITAYA_WINE_FIVE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 480, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 1000, 0), 1.0F).build();
	public static final FoodProperties PITAYA_WINE_SIX = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 600, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 1200, 0), 1.0F).build();
	public static final FoodProperties PITAYA_WINE_SEVEN = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 700, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 1600, 0), 1.0F).build();
	public static final FoodProperties PITAYA_WINE_EIGHT = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 800, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 2000, 0), 1.0F).build();
	public static final FoodProperties PITAYA_WINE_NINE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 850, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 2400, 0), 1.0F).build();
	public static final FoodProperties PITAYA_WINE_TEN = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 900, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 2000, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), 1000, 0), 1.0F).build();
	public static final FoodProperties PITAYA_MILK_TEA = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(MobEffects.JUMP, 1200, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.WARM_STOMACH.get(), 1200, 0), 1.0F).build();

	//beating melons
	public static final FoodProperties BEATING_MELONS = (new FoodProperties.Builder())
			.nutrition(3).saturationMod(0.4f).alwaysEat().build();
	public static final FoodProperties BEATING_MELONS_SLICE = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.1f).fast().alwaysEat().build();
	public static final FoodProperties DRIED_BEATING_MELONS_SEEDS = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.6f)
			.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 160, 0), 1.0F).build();
	public static final FoodProperties BEATING_MELONS_POPSICLE = (new FoodProperties.Builder())
			.nutrition(3).saturationMod(0.2f).fast().alwaysEat().build();
	public static final FoodProperties BEATING_MELONS_CAKE_SLICE = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.2f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 400, 0, false, false), 1.0F).build();
	public static final FoodProperties BEATING_MELONS_PIE_SLICE = (new FoodProperties.Builder())
			.nutrition(4).saturationMod(0.3f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600, 0, false, false), 1.0F).build();
	public static final FoodProperties BEATING_MELONS_COOKIE = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.4f).fast().alwaysEat().build();
	public static final FoodProperties BEATING_MELONS_BREAD = (new FoodProperties.Builder())
			.nutrition(4).saturationMod(0.5f).alwaysEat().build();
	public static final FoodProperties BEATING_MELONS_DOUGHNUT = (new FoodProperties.Builder())
			.nutrition(4).saturationMod(0.5f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties BEATING_MELONS_JUICE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 1200, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties BEATING_MELONS_WINE_ONE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 60, 0), 1.0F).build();
	public static final FoodProperties BEATING_MELONS_WINE_TWO = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 120, 0), 1.0F).build();
	public static final FoodProperties BEATING_MELONS_WINE_THREE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 240, 0), 1.0F).build();
	public static final FoodProperties BEATING_MELONS_WINE_FOUR = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 360, 0), 1.0F).build();
	public static final FoodProperties BEATING_MELONS_WINE_FIVE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 480, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1000, 0), 1.0F).build();
	public static final FoodProperties BEATING_MELONS_WINE_SIX = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 600, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200, 0), 1.0F).build();
	public static final FoodProperties BEATING_MELONS_WINE_SEVEN = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 700, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1600, 0), 1.0F).build();
	public static final FoodProperties BEATING_MELONS_WINE_EIGHT = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 800, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2000, 0), 1.0F).build();
	public static final FoodProperties BEATING_MELONS_WINE_NINE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 850, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2400, 0), 1.0F).build();
	public static final FoodProperties BEATING_MELONS_WINE_TEN = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 900, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2000, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1000, 0), 1.0F).build();
	public static final FoodProperties BEATING_MELONS_MILK_TEA = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 1200, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.WARM_STOMACH.get(), 1200, 0), 1.0F).build();

	//ground cucumber
	public static final FoodProperties GROUND_CUCUMBER_SLICE = (new FoodProperties.Builder())
			.nutrition(1).saturationMod(0.1f).fast().alwaysEat().build();
	public static final FoodProperties GROUND_CUCUMBER_POPSICLE = (new FoodProperties.Builder())
			.nutrition(3).saturationMod(0.2f).fast().alwaysEat().build();
	public static final FoodProperties GROUND_CUCUMBER_PIE_SLICE = (new FoodProperties.Builder())
			.nutrition(4).saturationMod(0.3f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 600, 0, false, false), 1.0F).build();
	public static final FoodProperties GROUND_CUCUMBER_CAKE_SLICE = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.1f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 400, 0, false, false), 1.0F).build();
	public static final FoodProperties GROUND_CUCUMBER_COOKIE = (new FoodProperties.Builder())
			.nutrition(3).saturationMod(0.2f).fast().alwaysEat().build();
	public static final FoodProperties GROUND_CUCUMBER_BREAD = (new FoodProperties.Builder())
			.nutrition(5).saturationMod(0.5f).alwaysEat().build();
	public static final FoodProperties GROUND_CUCUMBER_DOUGHNUT = (new FoodProperties.Builder())
			.nutrition(5).saturationMod(0.5f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties GROUND_CUCUMBER_JUICE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 1200, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties GROUND_CUCUMBER_WINE_ONE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 60, 0), 1.0F).build();
	public static final FoodProperties GROUND_CUCUMBER_WINE_TWO = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 120, 0), 1.0F).build();
	public static final FoodProperties GROUND_CUCUMBER_WINE_THREE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 240, 0), 1.0F).build();
	public static final FoodProperties GROUND_CUCUMBER_WINE_FOUR = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 360, 0), 1.0F).build();
	public static final FoodProperties GROUND_CUCUMBER_WINE_FIVE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 480, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 1000, 0), 1.0F).build();
	public static final FoodProperties GROUND_CUCUMBER_WINE_SIX = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 600, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 1200, 0), 1.0F).build();
	public static final FoodProperties GROUND_CUCUMBER_WINE_SEVEN = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 700, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 1600, 0), 1.0F).build();
	public static final FoodProperties GROUND_CUCUMBER_WINE_EIGHT = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 800, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 2000, 0), 1.0F).build();
	public static final FoodProperties GROUND_CUCUMBER_WINE_NINE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 850, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 2400, 0), 1.0F).build();
	public static final FoodProperties GROUND_CUCUMBER_WINE_TEN = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 900, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 2000, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1000, 0), 1.0F).build();
	public static final FoodProperties GROUND_CUCUMBER_MILK_TEA = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 1200, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.WARM_STOMACH.get(), 1200, 0), 1.0F).build();

	//golden pure sheep horn honey
	public static final FoodProperties GOLDEN_PURE_SHEEP_HORN_HONEY_SLICE = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.2f).fast().alwaysEat().build();
	public static final FoodProperties GOLDEN_PURE_SHEEP_HORN_HONEY_POPSICLE = (new FoodProperties.Builder())
			.nutrition(4).saturationMod(0.3f).fast().alwaysEat().build();
	public static final FoodProperties GOLDEN_PURE_SHEEP_HORN_HONEY_PIE_SLICE = (new FoodProperties.Builder())
			.nutrition(3).saturationMod(0.4f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.CONDUIT_POWER, 600, 0, false, false), 1.0F).build();
	public static final FoodProperties GOLDEN_PURE_SHEEP_HORN_HONEY_CAKE_SLICE = (new FoodProperties.Builder())
			.nutrition(3).saturationMod(0.4f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.JUMP, 400, 0, false, false), 1.0F).build();
	public static final FoodProperties GOLDEN_PURE_SHEEP_HORN_HONEY_COOKIE = (new FoodProperties.Builder())
			.nutrition(3).saturationMod(0.4f).fast().alwaysEat().build();
	public static final FoodProperties GOLDEN_PURE_SHEEP_HORN_HONEY_FLAVOR_GOLDEN_PURE_SHEEP_HORN_HONEY = (new FoodProperties.Builder())
			.nutrition(8).saturationMod(0.8f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 1000, 1, false, false), 1.0F).build();
	public static final FoodProperties GOLDEN_PURE_SHEEP_HORN_HONEY_BREAD = (new FoodProperties.Builder())
			.nutrition(7).saturationMod(0.7f).alwaysEat().build();
	public static final FoodProperties GOLDEN_PURE_SHEEP_HORN_HONEY_DOUGHNUT = (new FoodProperties.Builder())
			.nutrition(6).saturationMod(0.6f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties GOLDEN_PURE_SHEEP_HORN_HONEY_JUICE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 1200, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_ONE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 60, 0), 1.0F).build();
	public static final FoodProperties GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_TWO = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 120, 0), 1.0F).build();
	public static final FoodProperties GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_THREE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 240, 0), 1.0F).build();
	public static final FoodProperties GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_FOUR = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 360, 0), 1.0F).build();
	public static final FoodProperties GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_FIVE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 480, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1000, 0), 1.0F).build();
	public static final FoodProperties GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_SIX = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 600, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 0), 1.0F).build();
	public static final FoodProperties GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_SEVEN = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 700, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1600, 0), 1.0F).build();
	public static final FoodProperties GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_EIGHT = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 800, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2000, 0), 1.0F).build();
	public static final FoodProperties GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_NINE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 850, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2400, 0), 1.0F).build();
	public static final FoodProperties GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_TEN = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 900, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2000, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 1000, 0), 1.0F).build();
	public static final FoodProperties GOLDEN_PURE_SHEEP_HORN_HONEY_MILK_TEA = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 1200, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.WARM_STOMACH.get(), 1200, 0), 1.0F).build();


	//pear
	public static final FoodProperties PEAR_SLICE = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.2f).alwaysEat().build();
	public static final FoodProperties PEAR_POPSICLE = (new FoodProperties.Builder())
			.nutrition(3).saturationMod(0.3f).fast().alwaysEat().build();
	public static final FoodProperties PEAR_PIE_SLICE = (new FoodProperties.Builder())
			.nutrition(5).saturationMod(0.4f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 600, 0, false, false), 1.0F).build();
	public static final FoodProperties PEAR_CAKE_SLICE = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.3f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 400, 0, false, false), 1.0F).build();
	public static final FoodProperties PEAR_COOKIE = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.3f).fast().alwaysEat().build();
	public static final FoodProperties PEAR_BREAD = (new FoodProperties.Builder())
			.nutrition(5).saturationMod(0.7f).alwaysEat().build();
	public static final FoodProperties PEAR_DOUGHNUT = (new FoodProperties.Builder())
			.nutrition(5).saturationMod(0.6f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties PEAR_JUICE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1200, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties PEAR_WINE_ONE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 60, 0), 1.0F).build();
	public static final FoodProperties PEAR_WINE_TWO = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 120, 0), 1.0F).build();
	public static final FoodProperties PEAR_WINE_THREE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 240, 0), 1.0F).build();
	public static final FoodProperties PEAR_WINE_FOUR = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 360, 0), 1.0F).build();
	public static final FoodProperties PEAR_WINE_FIVE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 480, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1000, 0), 1.0F).build();
	public static final FoodProperties PEAR_WINE_SIX = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 600, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1200, 0), 1.0F).build();
	public static final FoodProperties PEAR_WINE_SEVEN = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 700, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1600, 0), 1.0F).build();
	public static final FoodProperties PEAR_WINE_EIGHT = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 800, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 2000, 0), 1.0F).build();
	public static final FoodProperties PEAR_WINE_NINE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 850, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 2400, 0), 1.0F).build();
	public static final FoodProperties PEAR_WINE_TEN = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 900, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 2000, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1000, 0), 1.0F).build();
	public static final FoodProperties PEAR_MILK_TEA = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1200, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.WARM_STOMACH.get(), 1200, 0), 1.0F).build();

	//maythorn
	public static final FoodProperties MAYTHORN = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.5f).effect(() -> new MobEffectInstance(MobEffects.HUNGER, 300, 1), 0.75F).alwaysEat().build();
	public static final FoodProperties MAYTHORN_POPSICLE = (new FoodProperties.Builder())
			.nutrition(3).saturationMod(0.3f).fast().alwaysEat().build();
	public static final FoodProperties MAYTHORN_PIE_SLICE = (new FoodProperties.Builder())
			.nutrition(3).saturationMod(0.5f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 600, 0, false, false), 1.0F).build();
	public static final FoodProperties MAYTHORN_CAKE_SLICE = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.4f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0, false, false), 1.0F).build();
	public static final FoodProperties MAYTHORN_COOKIE = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.4f).fast().alwaysEat().build();
	public static final FoodProperties CANDIED_HAWS_ON_A_STICK = (new FoodProperties.Builder())
			.nutrition(5).saturationMod(0.8f)
			.effect(() -> new MobEffectInstance(ModEffects.CRISP.get(), SWEET_DURATION, 0), 1.0F).build();
	public static final FoodProperties MAYTHORN_BREAD = (new FoodProperties.Builder())
			.nutrition(7).saturationMod(0.8f).alwaysEat().build();
	public static final FoodProperties MAYTHORN_DOUGHNUT = (new FoodProperties.Builder())
			.nutrition(5).saturationMod(0.5f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties DRIED_MAYTHORN = (new FoodProperties.Builder())
			.nutrition(5).saturationMod(0.5f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties MAYTHORN_JUICE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.CRISP.get(), SWEET_DURATION, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties MAYTHORN_WINE_ONE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 60, 0), 1.0F).build();
	public static final FoodProperties MAYTHORN_WINE_TWO = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 120, 0), 1.0F).build();
	public static final FoodProperties MAYTHORN_WINE_THREE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 240, 0), 1.0F).build();
	public static final FoodProperties MAYTHORN_WINE_FOUR = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 360, 0), 1.0F).build();
	public static final FoodProperties MAYTHORN_WINE_FIVE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 480, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.CRISP.get(), 1000, 0), 1.0F).build();
	public static final FoodProperties MAYTHORN_WINE_SIX = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 600, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.CRISP.get(), 1200, 0), 1.0F).build();
	public static final FoodProperties MAYTHORN_WINE_SEVEN = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 700, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.CRISP.get(), 1600, 0), 1.0F).build();
	public static final FoodProperties MAYTHORN_WINE_EIGHT = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 800, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.CRISP.get(), 2000, 0), 1.0F).build();
	public static final FoodProperties MAYTHORN_WINE_NINE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 850, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.CRISP.get(), 2400, 0), 1.0F).build();
	public static final FoodProperties MAYTHORN_WINE_TEN = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 900, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.CRISP.get(), 2000, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.JUMP, 1000, 0), 1.0F).build();
	public static final FoodProperties MAYTHORN_MILK_TEA = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.CRISP.get(), SWEET_DURATION, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.WARM_STOMACH.get(), 1200, 0), 1.0F).build();

	//chinese_pear-leaved
	public static final FoodProperties CHINESE_PEAR_LEAVED_SLICE = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.2f).alwaysEat().build();
	public static final FoodProperties CHINESE_PEAR_LEAVED_POPSICLE = (new FoodProperties.Builder())
			.nutrition(3).saturationMod(0.3f).fast().alwaysEat().build();
	public static final FoodProperties CHINESE_PEAR_LEAVED_PIE_SLICE = (new FoodProperties.Builder())
			.nutrition(4).saturationMod(0.4f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 600, 0, false, false), 1.0F).build();
	public static final FoodProperties CHINESE_PEAR_LEAVED_CAKE_SLICE = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.3f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 400, 0, false, false), 1.0F).build();
	public static final FoodProperties CHINESE_PEAR_LEAVED_COOKIE = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.3f).fast().alwaysEat().build();
	public static final FoodProperties CHINESE_PEAR_LEAVED_BREAD = (new FoodProperties.Builder())
			.nutrition(6).saturationMod(0.7f).alwaysEat().build();
	public static final FoodProperties CHINESE_PEAR_LEAVED_DOUGHNUT = (new FoodProperties.Builder())
			.nutrition(6).saturationMod(0.6f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties CHINESE_PEAR_LEAVED_JUICE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 1200, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties CHINESE_PEAR_LEAVED_ROLLS = (new FoodProperties.Builder())
			.nutrition(10).saturationMod(0.8f).alwaysEat().build();
	public static final FoodProperties CHINESE_PEAR_LEAVED_WINE_ONE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 60, 0), 1.0F).build();
	public static final FoodProperties CHINESE_PEAR_LEAVED_WINE_TWO = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 120, 0), 1.0F).build();
	public static final FoodProperties CHINESE_PEAR_LEAVED_WINE_THREE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 240, 0), 1.0F).build();
	public static final FoodProperties CHINESE_PEAR_LEAVED_WINE_FOUR = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 360, 0), 1.0F).build();
	public static final FoodProperties CHINESE_PEAR_LEAVED_WINE_FIVE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 480, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1000, 0), 1.0F).build();
	public static final FoodProperties CHINESE_PEAR_LEAVED_WINE_SIX = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 600, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200, 0), 1.0F).build();
	public static final FoodProperties CHINESE_PEAR_LEAVED_WINE_SEVEN = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 700, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1600, 0), 1.0F).build();
	public static final FoodProperties CHINESE_PEAR_LEAVED_WINE_EIGHT = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 800, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2000, 0), 1.0F).build();
	public static final FoodProperties CHINESE_PEAR_LEAVED_WINE_NINE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 850, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2400, 0), 1.0F).build();
	public static final FoodProperties CHINESE_PEAR_LEAVED_WINE_TEN = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 900, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2000, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1000, 0), 1.0F).build();
	public static final FoodProperties CHINESE_PEAR_LEAVED_MILK_TEA = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 1200, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.WARM_STOMACH.get(), 1200, 0), 1.0F).build();

	//plum
	public static final FoodProperties PLUM = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.3f).alwaysEat().build();
	public static final FoodProperties PLUM_POPSICLE = (new FoodProperties.Builder())
			.nutrition(3).saturationMod(0.3f).fast().alwaysEat().build();
	public static final FoodProperties PLUM_PIE_SLICE = (new FoodProperties.Builder())
			.nutrition(5).saturationMod(0.4f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600, 0, false, false), 1.0F).build();
	public static final FoodProperties PLUM_CAKE_SLICE = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.3f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.CONDUIT_POWER, 400, 0, false, false), 1.0F).build();
	public static final FoodProperties PLUM_COOKIE = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.3f).fast().alwaysEat().build();
	public static final FoodProperties PLUM_BREAD = (new FoodProperties.Builder())
			.nutrition(6).saturationMod(0.9f).alwaysEat().build();
	public static final FoodProperties PLUM_DOUGHNUT = (new FoodProperties.Builder())
			.nutrition(5).saturationMod(0.6f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties DRIED_PLUM = (new FoodProperties.Builder())
			.nutrition(5).saturationMod(0.6f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties PLUM_JUICE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 1200, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties PLUM_WINE_ONE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 60, 0), 1.0F).build();
	public static final FoodProperties PLUM_WINE_TWO = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 120, 0), 1.0F).build();
	public static final FoodProperties PLUM_WINE_THREE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 240, 0), 1.0F).build();
	public static final FoodProperties PLUM_WINE_FOUR = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 360, 0), 1.0F).build();
	public static final FoodProperties PLUM_WINE_FIVE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 480, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 1000, 0), 1.0F).build();
	public static final FoodProperties PLUM_WINE_SIX = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 600, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 1200, 0), 1.0F).build();
	public static final FoodProperties PLUM_WINE_SEVEN = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 700, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 1600, 0), 1.0F).build();
	public static final FoodProperties PLUM_WINE_EIGHT = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 800, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 2000, 0), 1.0F).build();
	public static final FoodProperties PLUM_WINE_NINE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 850, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 2400, 0), 1.0F).build();
	public static final FoodProperties PLUM_WINE_TEN = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 900, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 2000, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 1000, 0), 1.0F).build();
	public static final FoodProperties PLUM_MILK_TEA = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 1200, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.WARM_STOMACH.get(), 1200, 0), 1.0F).build();

	//jujube
	public static final FoodProperties JUJUBE = (new FoodProperties.Builder())
			.nutrition(1).saturationMod(0.3f).alwaysEat().build();
	public static final FoodProperties JUJUBE_POPSICLE = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.3f).fast().alwaysEat().build();
	public static final FoodProperties JUJUBE_PIE_SLICE = (new FoodProperties.Builder())
			.nutrition(3).saturationMod(0.4f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.LUCK, 600, 0, false, false), 1.0F).build();
	public static final FoodProperties JUJUBE_CAKE_SLICE = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.3f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 400, 0, false, false), 1.0F).build();
	public static final FoodProperties JUJUBE_COOKIE = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.3f).fast().alwaysEat().build();
	public static final FoodProperties JUJUBE_BREAD = (new FoodProperties.Builder())
			.nutrition(5).saturationMod(0.7f).alwaysEat().build();
	public static final FoodProperties JUJUBE_DOUGHNUT = (new FoodProperties.Builder())
			.nutrition(4).saturationMod(0.5f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties DRIED_JUJUBE = (new FoodProperties.Builder())
			.nutrition(4).saturationMod(0.5f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties JUJUBE_JUICE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.CRISP.get(), SWEET_DURATION, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties JUJUBE_WINE_ONE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 60, 0), 1.0F).build();
	public static final FoodProperties JUJUBE_WINE_TWO = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 120, 0), 1.0F).build();
	public static final FoodProperties JUJUBE_WINE_THREE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 240, 0), 1.0F).build();
	public static final FoodProperties JUJUBE_WINE_FOUR = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 360, 0), 1.0F).build();
	public static final FoodProperties JUJUBE_WINE_FIVE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 480, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.LUCK, 1000, 0), 1.0F).build();
	public static final FoodProperties JUJUBE_WINE_SIX = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 600, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.LUCK, 1200, 0), 1.0F).build();
	public static final FoodProperties JUJUBE_WINE_SEVEN = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 700, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.LUCK, 1600, 0), 1.0F).build();
	public static final FoodProperties JUJUBE_WINE_EIGHT = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 800, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.LUCK, 2000, 0), 1.0F).build();
	public static final FoodProperties JUJUBE_WINE_NINE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 850, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.LUCK, 2400, 0), 1.0F).build();
	public static final FoodProperties JUJUBE_WINE_TEN = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 900, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.LUCK, 2000, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 1000, 0), 1.0F).build();
	public static final FoodProperties JUJUBE_MILK_TEA = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.CRISP.get(), SWEET_DURATION, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.WARM_STOMACH.get(), 1200, 0), 1.0F).build();
	//apricot
	public static final FoodProperties APRICOT = (new FoodProperties.Builder())
			.nutrition(3).saturationMod(0.3f).alwaysEat().build();
	public static final FoodProperties APRICOT_POPSICLE = (new FoodProperties.Builder())
			.nutrition(3).saturationMod(0.3f).fast().alwaysEat().build();
	public static final FoodProperties APRICOT_PIE_SLICE = (new FoodProperties.Builder())
			.nutrition(5).saturationMod(0.4f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600, 0, false, false), 1.0F).build();
	public static final FoodProperties APRICOT_CAKE_SLICE = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.3f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 400, 0, false, false), 1.0F).build();
	public static final FoodProperties APRICOT_COOKIE = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.3f).fast().alwaysEat().build();
	public static final FoodProperties APRICOT_BREAD = (new FoodProperties.Builder())
			.nutrition(5).saturationMod(0.7f).alwaysEat().build();
	public static final FoodProperties APRICOT_DOUGHNUT = (new FoodProperties.Builder())
			.nutrition(4).saturationMod(0.5f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties APRICOT_JUICE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.CRISP.get(), SWEET_DURATION, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties APRICOT_WINE_ONE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 60, 0), 1.0F).build();
	public static final FoodProperties APRICOT_WINE_TWO = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 120, 0), 1.0F).build();
	public static final FoodProperties APRICOT_WINE_THREE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 240, 0), 1.0F).build();
	public static final FoodProperties APRICOT_WINE_FOUR = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 360, 0), 1.0F).build();
	public static final FoodProperties APRICOT_WINE_FIVE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 480, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 1000, 0), 1.0F).build();
	public static final FoodProperties APRICOT_WINE_SIX = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 600, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 1200, 0), 1.0F).build();
	public static final FoodProperties APRICOT_WINE_SEVEN = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 700, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 1600, 0), 1.0F).build();
	public static final FoodProperties APRICOT_WINE_EIGHT = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 800, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 2000, 0), 1.0F).build();
	public static final FoodProperties APRICOT_WINE_NINE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 850, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 2400, 0), 1.0F).build();
	public static final FoodProperties APRICOT_WINE_TEN = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 900, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 2000, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 1000, 0), 1.0F).build();
	public static final FoodProperties APRICOT_MILK_TEA = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.CRISP.get(), SWEET_DURATION, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.WARM_STOMACH.get(), 1200, 0), 1.0F).build();
	//red_bayberry
	public static final FoodProperties RED_BAYBERRY = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.3f).alwaysEat().build();
	public static final FoodProperties RED_BAYBERRY_POPSICLE = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.3f).fast().alwaysEat().build();
	public static final FoodProperties RED_BAYBERRY_PIE_SLICE = (new FoodProperties.Builder())
			.nutrition(4).saturationMod(0.4f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.JUMP, 600, 0, false, false), 1.0F).build();
	public static final FoodProperties RED_BAYBERRY_CAKE_SLICE = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.3f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0, false, false), 1.0F).build();
	public static final FoodProperties RED_BAYBERRY_COOKIE = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.3f).fast().alwaysEat().build();
	public static final FoodProperties SOUR_PLUM_CHICKEN = (new FoodProperties.Builder())
			.nutrition(15).saturationMod(0.8f)
			.effect(() -> new MobEffectInstance(ModEffects.CRISP.get(), SWEET_DURATION, 0), 1.0F).build();
	public static final FoodProperties RED_BAYBERRY_BREAD = (new FoodProperties.Builder())
			.nutrition(5).saturationMod(0.7f).alwaysEat().build();
	public static final FoodProperties RED_BAYBERRY_DOUGHNUT = (new FoodProperties.Builder())
			.nutrition(4).saturationMod(0.5f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties RED_BAYBERRY_JUICE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.CRISP.get(), SWEET_DURATION, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties RED_BAYBERRY_WINE_ONE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 60, 0), 1.0F).build();
	public static final FoodProperties RED_BAYBERRY_WINE_TWO = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 120, 0), 1.0F).build();
	public static final FoodProperties RED_BAYBERRY_WINE_THREE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 240, 0), 1.0F).build();
	public static final FoodProperties RED_BAYBERRY_WINE_FOUR = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 360, 0), 1.0F).build();
	public static final FoodProperties RED_BAYBERRY_WINE_FIVE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 480, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1000, 0), 1.0F).build();
	public static final FoodProperties RED_BAYBERRY_WINE_SIX = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 600, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 0), 1.0F).build();
	public static final FoodProperties RED_BAYBERRY_WINE_SEVEN = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 700, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1600, 0), 1.0F).build();
	public static final FoodProperties RED_BAYBERRY_WINE_EIGHT = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 800, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2000, 0), 1.0F).build();
	public static final FoodProperties RED_BAYBERRY_WINE_NINE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 850, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2400, 0), 1.0F).build();
	public static final FoodProperties RED_BAYBERRY_WINE_TEN = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 900, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2000, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 1000, 0), 1.0F).build();
	public static final FoodProperties RED_BAYBERRY_MILK_TEA = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.CRISP.get(), SWEET_DURATION, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.WARM_STOMACH.get(), 1200, 0), 1.0F).build();
	//green_plum
	public static final FoodProperties GREEN_PLUM = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.3f).alwaysEat().build();
	public static final FoodProperties GREEN_PLUM_POPSICLE = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.3f).fast().alwaysEat().build();
	public static final FoodProperties GREEN_PLUM_PIE_SLICE = (new FoodProperties.Builder())
			.nutrition(4).saturationMod(0.4f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 600, 0, false, false), 1.0F).build();
	public static final FoodProperties GREEN_PLUM_CAKE_SLICE = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.3f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 0, false, false), 1.0F).build();
	public static final FoodProperties GREEN_PLUM_COOKIE = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.3f).fast().alwaysEat().build();
	public static final FoodProperties GREEN_PLUM_BREAD = (new FoodProperties.Builder())
			.nutrition(5).saturationMod(0.7f).alwaysEat().build();
	public static final FoodProperties GREEN_PLUM_DOUGHNUT = (new FoodProperties.Builder())
			.nutrition(4).saturationMod(0.5f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties GREEN_PLUM_JUICE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.CRISP.get(), SWEET_DURATION, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties GREEN_PLUM_WINE_ONE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 60, 0), 1.0F).build();
	public static final FoodProperties GREEN_PLUM_WINE_TWO = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 120, 0), 1.0F).build();
	public static final FoodProperties GREEN_PLUM_WINE_THREE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 240, 0), 1.0F).build();
	public static final FoodProperties GREEN_PLUM_WINE_FOUR = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 360, 0), 1.0F).build();
	public static final FoodProperties GREEN_PLUM_WINE_FIVE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 480, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 1000, 0), 1.0F).build();
	public static final FoodProperties GREEN_PLUM_WINE_SIX = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 600, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 1200, 0), 1.0F).build();
	public static final FoodProperties GREEN_PLUM_WINE_SEVEN = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 700, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 1600, 0), 1.0F).build();
	public static final FoodProperties GREEN_PLUM_WINE_EIGHT = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 800, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 2000, 0), 1.0F).build();
	public static final FoodProperties GREEN_PLUM_WINE_NINE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 850, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 2400, 0), 1.0F).build();
	public static final FoodProperties GREEN_PLUM_WINE_TEN = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 900, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 2000, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 1000, 0), 1.0F).build();
	public static final FoodProperties GREEN_PLUM_MILK_TEA = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.CRISP.get(), SWEET_DURATION, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.WARM_STOMACH.get(), 1200, 0), 1.0F).build();
	//grape
	public static final FoodProperties GRAPE = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.2f).alwaysEat().build();
	public static final FoodProperties GRAPE_POPSICLE = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.3f).fast().alwaysEat().build();
	public static final FoodProperties GRAPE_PIE_SLICE = (new FoodProperties.Builder())
			.nutrition(4).saturationMod(0.4f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 600, 0, false, false), 1.0F).build();
	public static final FoodProperties GRAPE_CAKE_SLICE = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.3f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 400, 0, false, false), 1.0F).build();
	public static final FoodProperties GRAPE_COOKIE = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.3f).fast().alwaysEat().build();
	public static final FoodProperties GRAPE_BREAD = (new FoodProperties.Builder())
			.nutrition(5).saturationMod(0.7f).alwaysEat().build();
	public static final FoodProperties GRAPE_DOUGHNUT = (new FoodProperties.Builder())
			.nutrition(4).saturationMod(0.5f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties GRAPE_JUICE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1200, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties DRIED_GRAPE = (new FoodProperties.Builder())
			.nutrition(4).saturationMod(0.5f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties GRAPE_JELLY_SLICE = (new FoodProperties.Builder())
			.nutrition(3).saturationMod(0.5f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 600, 0, false, false), 1.0F).effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties GRAPE_WINE_ONE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 60, 0), 1.0F).build();
	public static final FoodProperties GRAPE_WINE_TWO = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 120, 0), 1.0F).build();
	public static final FoodProperties GRAPE_WINE_THREE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 240, 0), 1.0F).build();
	public static final FoodProperties GRAPE_WINE_FOUR = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 360, 0), 1.0F).build();
	public static final FoodProperties GRAPE_WINE_FIVE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 480, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 1000, 0), 1.0F).build();
	public static final FoodProperties GRAPE_WINE_SIX = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 600, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 1200, 0), 1.0F).build();
	public static final FoodProperties GRAPE_WINE_SEVEN = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 700, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 1600, 0), 1.0F).build();
	public static final FoodProperties GRAPE_WINE_EIGHT = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 800, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 2000, 0), 1.0F).build();
	public static final FoodProperties GRAPE_WINE_NINE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 850, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 2400, 0), 1.0F).build();
	public static final FoodProperties GRAPE_WINE_TEN = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 900, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 2000, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 1000, 0), 1.0F).build();
	public static final FoodProperties GRAPE_MILK_TEA = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1200, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.WARM_STOMACH.get(), 1200, 0), 1.0F).build();
	//peach
	public static final FoodProperties PEACH_SLICE = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.2f).alwaysEat().build();
	public static final FoodProperties PEACH_POPSICLE = (new FoodProperties.Builder())
			.nutrition(3).saturationMod(0.3f).fast().alwaysEat().build();
	public static final FoodProperties PEACH_PIE_SLICE = (new FoodProperties.Builder())
			.nutrition(3).saturationMod(0.4f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600, 0, false, false), 1.0F).build();
	public static final FoodProperties PEACH_CAKE_SLICE = (new FoodProperties.Builder())
			.nutrition(3).saturationMod(0.4f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.JUMP, 400, 0, false, false), 1.0F).build();
	public static final FoodProperties PEACH_COOKIE = (new FoodProperties.Builder())
			.nutrition(3).saturationMod(0.3f).fast().alwaysEat().build();
	public static final FoodProperties PEACH_BREAD = (new FoodProperties.Builder())
			.nutrition(6).saturationMod(0.7f).alwaysEat().build();
	public static final FoodProperties PEACH_DOUGHNUT = (new FoodProperties.Builder())
			.nutrition(5).saturationMod(0.5f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties DRIED_PEACH = (new FoodProperties.Builder())
			.nutrition(5).saturationMod(0.5f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties PEACH_JUICE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1200, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_SHORT_DURATION, 0), 1.0F).build();
	public static final FoodProperties PEACH_WINE_ONE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 60, 0), 1.0F).build();
	public static final FoodProperties PEACH_WINE_TWO = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 120, 0), 1.0F).build();
	public static final FoodProperties PEACH_WINE_THREE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 240, 0), 1.0F).build();
	public static final FoodProperties PEACH_WINE_FOUR = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 360, 0), 1.0F).build();
	public static final FoodProperties PEACH_WINE_FIVE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 480, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1000, 0), 1.0F).build();
	public static final FoodProperties PEACH_WINE_SIX = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 600, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1200, 0), 1.0F).build();
	public static final FoodProperties PEACH_WINE_SEVEN = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 700, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1600, 0), 1.0F).build();
	public static final FoodProperties PEACH_WINE_EIGHT = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 800, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 2000, 0), 1.0F).build();
	public static final FoodProperties PEACH_WINE_NINE = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 850, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 2400, 0), 1.0F).build();
	public static final FoodProperties PEACH_WINE_TEN = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(ModEffects.TIPSY.get(), 900, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 2000, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 1000, 0), 1.0F).build();
	public static final FoodProperties PEACH_MILK_TEA = (new FoodProperties.Builder())
			.alwaysEat().effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1200, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.WARM_STOMACH.get(), 1200, 0), 1.0F).build();
	//rice dumpling
	public static final FoodProperties BLUEBERRIES_RICE_DUMPLING = (new FoodProperties.Builder())
			.nutrition(6).saturationMod(0.7f)
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_DURATION, 0), 1.0F).build();
	public static final FoodProperties HAMIMELON_RICE_DUMPLING = (new FoodProperties.Builder())
			.nutrition(7).saturationMod(0.7f)
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_DURATION, 0), 1.0F).build();
	public static final FoodProperties BEATING_MELONS_RICE_DUMPLING = (new FoodProperties.Builder())
			.nutrition(6).saturationMod(0.7f)
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_DURATION, 0), 1.0F).build();
	public static final FoodProperties GROUND_CUCUMBER_RICE_DUMPLING = (new FoodProperties.Builder())
			.nutrition(6).saturationMod(0.8f)
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_DURATION, 0), 1.0F).build();
	public static final FoodProperties MANGO_RICE_DUMPLING = (new FoodProperties.Builder())
			.nutrition(7).saturationMod(0.8f)
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_DURATION, 0), 1.0F).build();
	public static final FoodProperties HOLBOELLIA_LATIFOLIA_RICE_DUMPLING = (new FoodProperties.Builder())
			.nutrition(6).saturationMod(0.7f)
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_DURATION, 0), 1.0F).build();
	public static final FoodProperties LITCHI_RICE_DUMPLING = (new FoodProperties.Builder())
			.nutrition(5).saturationMod(0.6f)
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_DURATION, 0), 1.0F).build();
	public static final FoodProperties HUOSHEN_FRUIT_RICE_DUMPLING = (new FoodProperties.Builder())
			.nutrition(7).saturationMod(0.8f)
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_DURATION, 0), 1.0F).build();
	public static final FoodProperties SEPTEMBER_MELON_RICE_DUMPLING = (new FoodProperties.Builder())
			.nutrition(6).saturationMod(0.6f)
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_DURATION, 0), 1.0F).build();
	public static final FoodProperties PITAYA_RICE_DUMPLING = (new FoodProperties.Builder())
			.nutrition(7).saturationMod(0.6f)
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_DURATION, 0), 1.0F).build();
	public static final FoodProperties GOLDEN_PURE_SHEEP_HORN_HONEY_RICE_DUMPLING = (new FoodProperties.Builder())
			.nutrition(8).saturationMod(0.8f)
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_DURATION, 0), 1.0F).build();
	public static final FoodProperties PEAR_RICE_DUMPLING = (new FoodProperties.Builder())
			.nutrition(7).saturationMod(0.8f)
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_DURATION, 0), 1.0F).build();
	public static final FoodProperties MAYTHORN_RICE_DUMPLING = (new FoodProperties.Builder())
			.nutrition(6).saturationMod(0.9f)
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_DURATION, 0), 1.0F).build();
	public static final FoodProperties CHINESE_PEAR_LEAVED_RICE_DUMPLING = (new FoodProperties.Builder())
			.nutrition(7).saturationMod(0.8f)
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_DURATION, 0), 1.0F).build();
	public static final FoodProperties PLUM_RICE_DUMPLING = (new FoodProperties.Builder())
			.nutrition(7).saturationMod(0.7f)
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_DURATION, 0), 1.0F).build();
	public static final FoodProperties JUJUBE_RICE_DUMPLING = (new FoodProperties.Builder())
			.nutrition(6).saturationMod(0.7f)
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_DURATION, 0), 1.0F).build();
	public static final FoodProperties APRICOT_RICE_DUMPLING = (new FoodProperties.Builder())
			.nutrition(8).saturationMod(0.6f)
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_DURATION, 0), 1.0F).build();
	public static final FoodProperties GREEN_PLUM_RICE_DUMPLING = (new FoodProperties.Builder())
			.nutrition(7).saturationMod(0.6f)
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_DURATION, 0), 1.0F).build();
	public static final FoodProperties RED_BAYBERRY_RICE_DUMPLING = (new FoodProperties.Builder())
			.nutrition(7).saturationMod(0.7f)
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_DURATION, 0), 1.0F).build();
	public static final FoodProperties GRAPE_RICE_DUMPLING = (new FoodProperties.Builder())
			.nutrition(6).saturationMod(0.8f)
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_DURATION, 0), 1.0F).build();
	public static final FoodProperties PEACH_RICE_DUMPLING = (new FoodProperties.Builder())
			.nutrition(7).saturationMod(0.8f)
			.effect(() -> new MobEffectInstance(ModEffects.SWEET.get(), SWEET_DURATION, 0), 1.0F).build();
	//pizza
	public static final FoodProperties GRAPE_FRUIT_SAND_PIZZA_SLICE = (new FoodProperties.Builder())
			.nutrition(6).saturationMod(0.6f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 800, 0, false, false), 1.0F).build();
	public static final FoodProperties BLUE_RED_MANGO_PIZZA_SLICE = (new FoodProperties.Builder())
			.nutrition(6).saturationMod(0.6f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 800, 0, false, false), 1.0F).build();
	public static final FoodProperties HAWTHORN_NUT_PIZZA_SLICE = (new FoodProperties.Builder())
			.nutrition(6).saturationMod(0.6f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.JUMP, 800, 0, false, false), 1.0F).build();
	public static final FoodProperties SWEET_AND_REFRESHING_FLAVORED_PIZZA_SLICE = (new FoodProperties.Builder())
			.nutrition(6).saturationMod(0.6f).fast().alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 800, 0, false, false), 1.0F).build();
}

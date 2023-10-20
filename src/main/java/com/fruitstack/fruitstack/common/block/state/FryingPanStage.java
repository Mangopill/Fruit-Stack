package com.fruitstack.fruitstack.common.block.state;

import net.minecraft.util.StringRepresentable;

public enum FryingPanStage implements StringRepresentable
{
	NONE("none"),
	SUNFLOWER_OIL("sunflower_oil"),
	FIRE("fire"),
	POT_COVER("pot_cover"),
	FRYING_PAN_STIR_FRIED_BEATING_MELONS_SEEDS_AGE0("frying_pan_stir_fried_beating_melons_seeds_age0"),
	FRYING_PAN_STIR_FRIED_BEATING_MELONS_SEEDS_AGE1("frying_pan_stir_fried_beating_melons_seeds_age1"),
	FRYING_PAN_STIR_FRIED_BEATING_MELONS_SEEDS_AGE2("frying_pan_stir_fried_beating_melons_seeds_age2"),
	FRYING_PAN_CRISPY_LITCHI_BALL_AGE0("frying_pan_crispy_litchi_ball_age0"),
	FRYING_PAN_CRISPY_LITCHI_BALL_AGE1("frying_pan_crispy_litchi_ball_age1"),
	FRYING_PAN_CRISPY_LITCHI_BALL_AGE2("frying_pan_crispy_litchi_ball_age2"),
	FRYING_PAN_UNFINISHED_HONEY_MELON_CHICKEN_BALLS_AGE0("frying_pan_unfinished_honey_melon_chicken_balls_age0"),
	FRYING_PAN_UNFINISHED_HONEY_MELON_CHICKEN_BALLS_AGE1("frying_pan_unfinished_honey_melon_chicken_balls_age1"),
	FRYING_PAN_UNFINISHED_HONEY_MELON_CHICKEN_BALLS_AGE2("frying_pan_unfinished_honey_melon_chicken_balls_age2"),
	FRYING_PAN_STIR_FRIED_YOGURT_AGE0("frying_pan_stir_fried_yogurt_age0"),
	FRYING_PAN_STIR_FRIED_YOGURT_AGE1("frying_pan_stir_fried_yogurt_age1"),
	FRYING_PAN_STIR_FRIED_YOGURT_AGE2("frying_pan_stir_fried_yogurt_age2"),
	FRYING_PAN_MILKY_TEA_SUGAR_AGE0("frying_pan_milky_tea_sugar_age0"),
	FRYING_PAN_MILKY_TEA_SUGAR_AGE1("frying_pan_milky_tea_sugar_age1"),
	FRYING_PAN_MILKY_TEA_BLACK_TEA_AGE0("frying_pan_milky_tea_black_tea_age0"),
	FRYING_PAN_MILKY_TEA_BLACK_TEA_AGE1("frying_pan_milky_tea_black_tea_age1"),
	FRYING_PAN_MILKY_TEA_MILK_AGE0("frying_pan_milky_tea_milk_age0"),
	FRYING_PAN_MILKY_TEA_MILK_AGE1("frying_pan_milky_tea_milk_age1");

	private final String stirName;

	FryingPanStage(String name) {
		this.stirName = name;
	}

	@Override
	public String toString() {
		return this.getSerializedName();
	}

	@Override
	public String getSerializedName() {
		return this.stirName;
	}
}

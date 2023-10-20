package com.fruitstack.fruitstack.common.block.state;

import net.minecraft.util.StringRepresentable;

public enum PizzaStage implements StringRepresentable
{
	DOUGH_STAGE0("dough_stage0"),
	DOUGH_STAGE1("dough_stage1"),
	DOUGH_STAGE2("dough_stage2"),
	UNBAKED_GRAPE_FRUIT_SAND_PIZZA_STAGE0("unbaked_grape_fruit_sand_pizza_stage0"),
	UNBAKED_GRAPE_FRUIT_SAND_PIZZA_STAGE1("unbaked_grape_fruit_sand_pizza_stage1"),
	UNBAKED_GRAPE_FRUIT_SAND_PIZZA_STAGE2("unbaked_grape_fruit_sand_pizza_stage2"),
	UNBAKED_BLUE_RED_MANGO_PIZZA_STAGE0("unbaked_blue_red_mango_pizza_stage0"),
	UNBAKED_BLUE_RED_MANGO_PIZZA_STAGE1("unbaked_blue_red_mango_pizza_stage1"),
	UNBAKED_BLUE_RED_MANGO_PIZZA_STAGE2("unbaked_blue_red_mango_pizza_stage2"),
	UNBAKED_HAWTHORN_NUT_PIZZA_STAGE0("unbaked_hawthorn_nut_pizza_stage0"),
	UNBAKED_HAWTHORN_NUT_PIZZA_STAGE1("unbaked_hawthorn_nut_pizza_stage1"),
	UNBAKED_HAWTHORN_NUT_PIZZA_STAGE2("unbaked_hawthorn_nut_pizza_stage2"),
	UNBAKED_SWEET_AND_REFRESHING_FLAVORED_PIZZA_STAGE0("unbaked_sweet_and_refreshing_flavored_pizza_stage0"),
	UNBAKED_SWEET_AND_REFRESHING_FLAVORED_PIZZA_STAGE1("unbaked_sweet_and_refreshing_flavored_pizza_stage1"),
	UNBAKED_SWEET_AND_REFRESHING_FLAVORED_PIZZA_STAGE2("unbaked_sweet_and_refreshing_flavored_pizza_stage2");

	private final String stirName;

	PizzaStage(String name) {
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

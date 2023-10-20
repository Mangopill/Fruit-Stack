package com.fruitstack.fruitstack.common.block.state;

import net.minecraft.util.StringRepresentable;

public enum OvenStage implements StringRepresentable
{
	OVEN("oven"),
	OVEN_WITH_GRAPE_FRUIT_SAND_PIZZA("oven_with_grape_fruit_sand_pizza"),
	OVEN_WITH_BLUE_RED_MANGO_PIZZA("oven_with_blue_red_mango_pizza"),
	OVEN_WITH_HAWTHORN_NUT_PIZZA("oven_with_hawthorn_nut_pizza"),
	OVEN_WITH_SWEET_AND_REFRESHING_FLAVORED_PIZZA("oven_with_sweet_and_refreshing_flavored_pizza"),
	OVEN_WITH_UNBAKED_GRAPE_FRUIT_SAND_PIZZA("oven_with_unbaked_grape_fruit_sand_pizza"),
	OVEN_WITH_UNBAKED_BLUE_RED_MANGO_PIZZA("oven_with_unbaked_blue_red_mango_pizza"),
	OVEN_WITH_UNBAKED_HAWTHORN_NUT_PIZZA("oven_with_unbaked_hawthorn_nut_pizza"),
	OVEN_WITH_UNBAKED_SWEET_AND_REFRESHING_FLAVORED_PIZZA("oven_with_unbaked_sweet_and_refreshing_flavored_pizza");

	private final String stirName;

	OvenStage(String name) {
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

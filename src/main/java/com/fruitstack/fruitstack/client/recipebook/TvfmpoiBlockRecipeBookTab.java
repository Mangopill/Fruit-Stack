package com.fruitstack.fruitstack.client.recipebook;

public enum TvfmpoiBlockRecipeBookTab
{
	MEALS("meals"),
	DRINKS("drinks"),
	MISC("misc");

	public final String name;

	TvfmpoiBlockRecipeBookTab(String name) {
		this.name = name;
	}

	public static TvfmpoiBlockRecipeBookTab findByName(String name) {
		for (TvfmpoiBlockRecipeBookTab value : values()) {
			if (value.name.equals(name)) {
				return value;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return this.name;
	}
}

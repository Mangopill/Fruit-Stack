package com.fruitstack.fruitstack.common.block.state;

import net.minecraft.util.StringRepresentable;

public enum JuicerStage implements StringRepresentable
{
	NONE("none"),
	STIR("stir"),
	OVER("over");

	private final String stirName;

	JuicerStage(String name) {
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

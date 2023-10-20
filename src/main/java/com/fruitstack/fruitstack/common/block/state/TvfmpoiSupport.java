package com.fruitstack.fruitstack.common.block.state;

import net.minecraft.util.StringRepresentable;

public enum TvfmpoiSupport implements StringRepresentable
{
	NONE("none"),
	TRAY("tray"),
	HANDLE("handle");

	private final String supportName;

	TvfmpoiSupport(String name) {
		this.supportName = name;
	}

	@Override
	public String toString() {
		return this.getSerializedName();
	}

	@Override
	public String getSerializedName() {
		return this.supportName;
	}
}

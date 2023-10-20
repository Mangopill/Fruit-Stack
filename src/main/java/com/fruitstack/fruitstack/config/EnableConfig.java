package com.fruitstack.fruitstack.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class EnableConfig {
	//Temperate Fruits
	//warm Fruits
	public static ForgeConfigSpec.BooleanValue mango_worldgen;
	public static ForgeConfigSpec.BooleanValue litchi_worldgen;
	public static ForgeConfigSpec.BooleanValue apple_worldgen;
	public static ForgeConfigSpec.BooleanValue blueberries_worldgen;
	public static ForgeConfigSpec.BooleanValue holboellia_latifolia_worldgen;
	public static ForgeConfigSpec.BooleanValue hamimelon_worldgen;
	public static ForgeConfigSpec.BooleanValue ground_cucumber_worldgen;
	public static ForgeConfigSpec.BooleanValue huoshen_fruit_worldgen;
	public static ForgeConfigSpec.BooleanValue beating_melons_worldgen;
	public static ForgeConfigSpec.BooleanValue september_melon_worldgen;
	public static ForgeConfigSpec.BooleanValue pitaya_worldgen;
	public static ForgeConfigSpec.BooleanValue golden_pure_sheep_horn_honey_worldgen;
	public static ForgeConfigSpec.BooleanValue zong_zi_leaves_worldgen;
	public static ForgeConfigSpec.BooleanValue pear_worldgen;
	public static ForgeConfigSpec.BooleanValue maythorn_worldgen;
	public static ForgeConfigSpec.BooleanValue chinese_pear_leaved_worldgen;
	public static ForgeConfigSpec.BooleanValue plum_worldgen;
	public static ForgeConfigSpec.BooleanValue jujube_worldgen;
	public static ForgeConfigSpec.BooleanValue apricot_worldgen;
	public static ForgeConfigSpec.BooleanValue red_bayberry_worldgen;
	public static ForgeConfigSpec.BooleanValue green_plum_worldgen;
	public static ForgeConfigSpec.BooleanValue grape_worldgen;
	public static ForgeConfigSpec.BooleanValue peach_worldgen;
	public static ForgeConfigSpec.BooleanValue glutinous_rice_worldgen;
	public static ForgeConfigSpec.BooleanValue black_tea_leaves_worldgen;

	
	public static void init(ForgeConfigSpec.Builder config) {
		mango_worldgen = config.comment("Should mango trees generate in world").define("Generate mango trees", true);
		litchi_worldgen = config.comment("Should litchi trees generate in world").define("Generate litchi trees", true);
		apple_worldgen = config.comment("Should apple trees generate in world").define("Generate apple trees", true);
		blueberries_worldgen = config.comment("Should wild blueberries generate in world").define("Generate wild blueberries", true);
		holboellia_latifolia_worldgen = config.comment("Should wild holboellia latifolia generate in world").define("Generate wild holboellia latifolia", true);
		hamimelon_worldgen = config.comment("Should wild hamimelon generate in world").define("Generate wild hamimelon", true);
		ground_cucumber_worldgen = config.comment("Should wild ground cucumber generate in world").define("Generate wild ground cucumber", true);
		huoshen_fruit_worldgen = config.comment("Should wild huoshen fruit generate in world").define("Generate wild huoshen fruit", true);
		beating_melons_worldgen = config.comment("Should wild beating melons generate in world").define("Generate wild beating melons", true);
		september_melon_worldgen = config.comment("Should wild september melon generate in world").define("Generate wild september melon", true);
		pitaya_worldgen = config.comment("Should wild pitaya generate in world").define("Generate wild pitaya", true);
		golden_pure_sheep_horn_honey_worldgen = config.comment("Should wild golden pure sheep horn honey generate in world").define("Generate wild golden pure sheep horn honey", true);
		zong_zi_leaves_worldgen = config.comment("Should wild zong zi leaves generate in world").define("Generate wild zong zi leaves", true);
		pear_worldgen = config.comment("Should pear tree generate in world").define("Generate pear tree", true);
		maythorn_worldgen = config.comment("Should maythorn tree generate in world").define("Generate maythorn tree", true);
		chinese_pear_leaved_worldgen = config.comment("Should chinese pear leaved tree generate in world").define("Generate chinese pear leaved tree", true);
		plum_worldgen = config.comment("Should plum tree generate in world").define("Generate plum tree", true);
		jujube_worldgen = config.comment("Should jujube tree generate in world").define("Generate jujube tree", true);
		apricot_worldgen = config.comment("Should apricot tree generate in world").define("Generate apricot tree", true);
		red_bayberry_worldgen = config.comment("Should red bayberry tree generate in world").define("Generate red bayberry tree", true);
		green_plum_worldgen = config.comment("Should green plum tree generate in world").define("Generate green plum tree", true);
		grape_worldgen = config.comment("Should wild grape generate in world").define("Generate wild grape", true);
		peach_worldgen = config.comment("Should wild peach tree generate in world").define("Generate wild peach tree", true);
		glutinous_rice_worldgen = config.comment("Should wild glutinous rice generate in world").define("Generate wild glutinous rice", true);
		black_tea_leaves_worldgen = config.comment("Should wild black tea leaves generate in world").define("Generate wild black tea leaves", true);
	}

}

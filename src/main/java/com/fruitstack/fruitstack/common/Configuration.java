package com.fruitstack.fruitstack.common;

import com.google.common.collect.ImmutableList;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber
public class Configuration
{
	public static ForgeConfigSpec COMMON_CONFIG;

	// COMMON
	public static final String CATEGORY_WORLD = "world";
	public static ForgeConfigSpec.BooleanValue GENERATE_WILD_BLUEBERRIES;
	public static ForgeConfigSpec.IntValue CHANCE_WILD_BLUEBERRIES;

	public static ForgeConfigSpec.BooleanValue GENERATE_WILD_HAMIMELON;
	public static ForgeConfigSpec.IntValue CHANCE_WILD_HAMIMELON;

	public static ForgeConfigSpec.BooleanValue GENERATE_WILD_BEATING_MELONS;
	public static ForgeConfigSpec.IntValue CHANCE_WILD_BEATING_MELONS;

	public static ForgeConfigSpec.BooleanValue GENERATE_WILD_GROUND_CUCUMBER;
	public static ForgeConfigSpec.IntValue CHANCE_WILD_GROUND_CUCUMBER;

	public static ForgeConfigSpec.BooleanValue GENERATE_WILD_HOLBOELLIA_LATIFOLIA;
	public static ForgeConfigSpec.IntValue CHANCE_WILD_HOLBOELLIA_LATIFOLIA;

	public static ForgeConfigSpec.BooleanValue GENERATE_WILD_HUOSHEN_FRUIT;
	public static ForgeConfigSpec.IntValue CHANCE_WILD_HUOSHEN_FRUIT;

	public static ForgeConfigSpec.BooleanValue GENERATE_WILD_SEPTEMBER_MELON;
	public static ForgeConfigSpec.IntValue CHANCE_WILD_SEPTEMBER_MELON;

	public static ForgeConfigSpec.BooleanValue GENERATE_WILD_PITAYA;
	public static ForgeConfigSpec.IntValue CHANCE_WILD_PITAYA;

	public static ForgeConfigSpec.BooleanValue GENERATE_WILD_GOLDEN_PURE_SHEEP_HORN_HONEY;
	public static ForgeConfigSpec.IntValue CHANCE_WILD_GOLDEN_PURE_SHEEP_HORN_HONEY;

	public static ForgeConfigSpec.BooleanValue GENERATE_WILD_GRAPE;
	public static ForgeConfigSpec.IntValue CHANCE_WILD_GRAPE;

	public static ForgeConfigSpec.BooleanValue GENERATE_WILD_GLUTINOUS_RICE;
	public static ForgeConfigSpec.IntValue CHANCE_WILD_GLUTINOUS_RICE;

	public static ForgeConfigSpec.BooleanValue GENERATE_WILD_ZONG_ZI_LEAVES;
	public static ForgeConfigSpec.IntValue CHANCE_WILD_ZONG_ZI_LEAVES;

	public static ForgeConfigSpec.BooleanValue GENERATE_APPLE_TREE;
	public static ForgeConfigSpec.IntValue CHANCE_APPLE_TREE;

	public static ForgeConfigSpec.BooleanValue GENERATE_WILD_BLACK_TEA_LEAVES;
	public static ForgeConfigSpec.IntValue CHANCE_WILD_BLACK_TEA_LEAVES;


	public static ForgeConfigSpec.BooleanValue GENERATE_WILD_APPLE_TREE;
	public static ForgeConfigSpec.IntValue CHANCE_WILD_APPLE_TREE;

	public static ForgeConfigSpec.BooleanValue GENERATE_WILD_APRICOT_TREE;
	public static ForgeConfigSpec.IntValue CHANCE_WILD_APRICOT_TREE;

	public static ForgeConfigSpec.BooleanValue GENERATE_WILD_GREEN_PLUM_TREE;
	public static ForgeConfigSpec.IntValue CHANCE_WILD_GREEN_PLUM_TREE;

	public static ForgeConfigSpec.BooleanValue GENERATE_WILD_JUJUBE_TREE;
	public static ForgeConfigSpec.IntValue CHANCE_WILD_JUJUBE_TREE;

	public static ForgeConfigSpec.BooleanValue GENERATE_WILD_MAYTHORN_TREE;
	public static ForgeConfigSpec.IntValue CHANCE_WILD_MAYTHORN_TREE;

	public static ForgeConfigSpec.BooleanValue GENERATE_WILD_PEAR_TREE;
	public static ForgeConfigSpec.IntValue CHANCE_WILD_PEAR_TREE;

	public static ForgeConfigSpec.BooleanValue GENERATE_WILD_PLUM_TREE;
	public static ForgeConfigSpec.IntValue CHANCE_WILD_PLUM_TREE;

	public static ForgeConfigSpec.BooleanValue GENERATE_WILD_RED_BAYBERRY_TREE;
	public static ForgeConfigSpec.IntValue CHANCE_WILD_RED_BAYBERRY_TREE;

	public static ForgeConfigSpec.BooleanValue GENERATE_WILD_CHINESE_PEAR_LEAVED_TREE;
	public static ForgeConfigSpec.IntValue CHANCE_WILD_CHINESE_PEAR_LEAVED_TREE;

	public static ForgeConfigSpec.BooleanValue GENERATE_WILD_LITCHI_TREE;
	public static ForgeConfigSpec.IntValue CHANCE_WILD_LITCHI_TREE;

	public static ForgeConfigSpec.BooleanValue GENERATE_WILD_MANGO_TREE;
	public static ForgeConfigSpec.IntValue CHANCE_WILD_MANGO_TREE;

	public static ForgeConfigSpec.BooleanValue GENERATE_WILD_PEACH_TREE;
	public static ForgeConfigSpec.IntValue CHANCE_WILD_PEACH_TREE;

	static {
		ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();

		COMMON_BUILDER.comment("World generation").push(CATEGORY_WORLD);

		COMMON_BUILDER.comment("Wild Blueberries generation").push("wild_blueberries");
		CHANCE_WILD_BLUEBERRIES = COMMON_BUILDER.comment("Chance of generating clusters. Smaller value = more frequent.")
				.defineInRange("chance", 30, 0, Integer.MAX_VALUE);
		COMMON_BUILDER.pop();

		COMMON_BUILDER.comment("Wild Hamimelon generation").push("wild_hamimelon");
		CHANCE_WILD_HAMIMELON = COMMON_BUILDER.comment("Chance of generating clusters. Smaller value = more frequent.")
				.defineInRange("chance", 30, 0, Integer.MAX_VALUE);
		COMMON_BUILDER.pop();

		COMMON_BUILDER.comment("Wild Beating melons generation").push("wild_beating_melons");
		CHANCE_WILD_BEATING_MELONS = COMMON_BUILDER.comment("Chance of generating clusters. Smaller value = more frequent.")
				.defineInRange("chance", 30, 0, Integer.MAX_VALUE);
		COMMON_BUILDER.pop();

		COMMON_BUILDER.comment("Wild Ground cucumber generation").push("wild_ground_cucumber");
		CHANCE_WILD_GROUND_CUCUMBER = COMMON_BUILDER.comment("Chance of generating clusters. Smaller value = more frequent.")
				.defineInRange("chance", 30, 0, Integer.MAX_VALUE);
		COMMON_BUILDER.pop();

		COMMON_BUILDER.comment("Wild Holboellia latifolia generation").push("wild_holboellia_latifolia");
		CHANCE_WILD_HOLBOELLIA_LATIFOLIA = COMMON_BUILDER.comment("Chance of generating clusters. Smaller value = more frequent.")
				.defineInRange("chance", 30, 0, Integer.MAX_VALUE);
		COMMON_BUILDER.pop();

		COMMON_BUILDER.comment("Wild Huoshen fruit generation").push("wild_huoshen_fruit");
		CHANCE_WILD_HUOSHEN_FRUIT = COMMON_BUILDER.comment("Chance of generating clusters. Smaller value = more frequent.")
				.defineInRange("chance", 30, 0, Integer.MAX_VALUE);
		COMMON_BUILDER.pop();

		COMMON_BUILDER.comment("Wild September melon generation").push("wild_september_melon");
		CHANCE_WILD_SEPTEMBER_MELON = COMMON_BUILDER.comment("Chance of generating clusters. Smaller value = more frequent.")
				.defineInRange("chance", 30, 0, Integer.MAX_VALUE);
		COMMON_BUILDER.pop();

		COMMON_BUILDER.comment("Wild Pitaya generation").push("wild_pitaya");
		CHANCE_WILD_PITAYA = COMMON_BUILDER.comment("Chance of generating clusters. Smaller value = more frequent.")
				.defineInRange("chance", 30, 0, Integer.MAX_VALUE);
		COMMON_BUILDER.pop();

		COMMON_BUILDER.comment("Wild Golden pure sheep horn honey generation").push("wild_golden_pure_sheep_horn_honey");
		CHANCE_WILD_GOLDEN_PURE_SHEEP_HORN_HONEY = COMMON_BUILDER.comment("Chance of generating clusters. Smaller value = more frequent.")
				.defineInRange("chance", 30, 0, Integer.MAX_VALUE);
		COMMON_BUILDER.pop();

		COMMON_BUILDER.comment("Wild Grape generation").push("wild_grape");
		CHANCE_WILD_GRAPE = COMMON_BUILDER.comment("Chance of generating clusters. Smaller value = more frequent.")
				.defineInRange("chance", 30, 0, Integer.MAX_VALUE);
		COMMON_BUILDER.pop();

		COMMON_BUILDER.comment("Wild Glutinous rice generation").push("wild_glutinous_rice");
		CHANCE_WILD_GLUTINOUS_RICE = COMMON_BUILDER.comment("Chance of generating clusters. Smaller value = more frequent.")
				.defineInRange("chance", 30, 0, Integer.MAX_VALUE);
		COMMON_BUILDER.pop();

		COMMON_BUILDER.comment("Wild Zong zi leaves generation").push("wild_zong_zi_leaves");
		CHANCE_WILD_ZONG_ZI_LEAVES = COMMON_BUILDER.comment("Chance of generating clusters. Smaller value = more frequent.")
				.defineInRange("chance", 30, 0, Integer.MAX_VALUE);
		COMMON_BUILDER.pop();

		COMMON_BUILDER.comment("Wild Black tea leaves generation").push("wild_black_tea_leaves");
		CHANCE_WILD_BLACK_TEA_LEAVES = COMMON_BUILDER.comment("Chance of generating clusters. Smaller value = more frequent.")
				.defineInRange("chance", 30, 0, Integer.MAX_VALUE);
		COMMON_BUILDER.pop();


		COMMON_BUILDER.comment("Wild Apple tree generation").push("wild_apple_tree");
		CHANCE_WILD_APPLE_TREE = COMMON_BUILDER.comment("Chance of generating clusters. Smaller value = more frequent.")
				.defineInRange("chance", 30, 0, Integer.MAX_VALUE);
		COMMON_BUILDER.pop();

		COMMON_BUILDER.comment("Wild Apricot tree generation").push("wild_apricot_tree");
		CHANCE_WILD_APRICOT_TREE = COMMON_BUILDER.comment("Chance of generating clusters. Smaller value = more frequent.")
				.defineInRange("chance", 30, 0, Integer.MAX_VALUE);
		COMMON_BUILDER.pop();

		COMMON_BUILDER.comment("Wild Green plum tree generation").push("wild_green_plum_tree");
		CHANCE_WILD_GREEN_PLUM_TREE = COMMON_BUILDER.comment("Chance of generating clusters. Smaller value = more frequent.")
				.defineInRange("chance", 30, 0, Integer.MAX_VALUE);
		COMMON_BUILDER.pop();

		COMMON_BUILDER.comment("Wild Jujube tree generation").push("wild_jujube_tree");
		CHANCE_WILD_JUJUBE_TREE = COMMON_BUILDER.comment("Chance of generating clusters. Smaller value = more frequent.")
				.defineInRange("chance", 30, 0, Integer.MAX_VALUE);
		COMMON_BUILDER.pop();

		COMMON_BUILDER.comment("Wild Maythorn tree generation").push("wild_maythorn_tree");
		CHANCE_WILD_MAYTHORN_TREE = COMMON_BUILDER.comment("Chance of generating clusters. Smaller value = more frequent.")
				.defineInRange("chance", 30, 0, Integer.MAX_VALUE);
		COMMON_BUILDER.pop();

		COMMON_BUILDER.comment("Wild Pear tree generation").push("wild_pear_tree");
		CHANCE_WILD_PEAR_TREE = COMMON_BUILDER.comment("Chance of generating clusters. Smaller value = more frequent.")
				.defineInRange("chance", 30, 0, Integer.MAX_VALUE);
		COMMON_BUILDER.pop();

		COMMON_BUILDER.comment("Wild Plum tree generation").push("wild_plum_tree");
		CHANCE_WILD_PLUM_TREE = COMMON_BUILDER.comment("Chance of generating clusters. Smaller value = more frequent.")
				.defineInRange("chance", 30, 0, Integer.MAX_VALUE);
		COMMON_BUILDER.pop();

		COMMON_BUILDER.comment("Wild Red bayberry tree generation").push("wild_red_bayberry_tree");
		CHANCE_WILD_RED_BAYBERRY_TREE = COMMON_BUILDER.comment("Chance of generating clusters. Smaller value = more frequent.")
				.defineInRange("chance", 30, 0, Integer.MAX_VALUE);
		COMMON_BUILDER.pop();

		COMMON_BUILDER.comment("Wild Chinese pear leaved tree generation").push("wild_chinese_pear_leaved_tree");
		CHANCE_WILD_CHINESE_PEAR_LEAVED_TREE = COMMON_BUILDER.comment("Chance of generating clusters. Smaller value = more frequent.")
				.defineInRange("chance", 30, 0, Integer.MAX_VALUE);
		COMMON_BUILDER.pop();

		COMMON_BUILDER.comment("Wild Litchi tree generation").push("wild_litchi_tree");
		CHANCE_WILD_LITCHI_TREE = COMMON_BUILDER.comment("Chance of generating clusters. Smaller value = more frequent.")
				.defineInRange("chance", 30, 0, Integer.MAX_VALUE);
		COMMON_BUILDER.pop();

		COMMON_BUILDER.comment("Wild Mango tree generation").push("wild_mango_tree");
		CHANCE_WILD_MANGO_TREE = COMMON_BUILDER.comment("Chance of generating clusters. Smaller value = more frequent.")
				.defineInRange("chance", 30, 0, Integer.MAX_VALUE);
		COMMON_BUILDER.pop();

		COMMON_BUILDER.comment("Wild Peach tree generation").push("wild_peach_tree");
		CHANCE_WILD_PEACH_TREE = COMMON_BUILDER.comment("Chance of generating clusters. Smaller value = more frequent.")
				.defineInRange("chance", 30, 0, Integer.MAX_VALUE);
		COMMON_BUILDER.pop();


		COMMON_CONFIG = COMMON_BUILDER.build();
	}
}

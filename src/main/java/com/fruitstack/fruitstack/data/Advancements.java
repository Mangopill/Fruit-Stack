package com.fruitstack.fruitstack.data;

import com.fruitstack.fruitstack.common.registry.ModEffects;
import com.fruitstack.fruitstack.common.registry.ModItems;
import com.fruitstack.fruitstack.common.utility.TextUtils;
import com.fruitstack.fruitstack.fruitstack;
import com.google.common.collect.Sets;
import com.google.gson.GsonBuilder;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.EffectsChangedTrigger;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.MobEffectsPredicate;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.RegistryObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.ParametersAreNonnullByDefault;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class Advancements extends AdvancementProvider
{
	private final Path PATH;
	public static final Logger LOGGER = LogManager.getLogger();

	public Advancements(DataGenerator generatorIn) {
		super(generatorIn);
		PATH = generatorIn.getOutputFolder();
	}

	@Override
	public void run(CachedOutput cache) {
		Set<ResourceLocation> set = Sets.newHashSet();
		Consumer<Advancement> consumer = (advancement) -> {
			if (!set.add(advancement.getId())) {
				throw new IllegalStateException("Duplicate advancement " + advancement.getId());
			} else {
				Path path1 = getPath(PATH, advancement);

				try {
					DataProvider.saveStable(cache, advancement.deconstruct().serializeToJson(), path1);
				}
				catch (IOException ioexception) {
					LOGGER.error("Couldn't save advancement {}", path1, ioexception);
				}
			}
		};

		new fruitstackAdvancements().accept(consumer);
	}

	private static Path getPath(Path pathIn, Advancement advancementIn) {
		return pathIn.resolve("data/" + advancementIn.getId().getNamespace() + "/advancements/" + advancementIn.getId().getPath() + ".json");
	}

	public static class fruitstackAdvancements implements Consumer<Consumer<Advancement>>
	{
		@Override
		@SuppressWarnings("unused")
		public void accept(Consumer<Advancement> consumer) {
			Advancement fruitstack = Advancement.Builder.advancement()
					.display(ModItems.CLAY_OVEN.get(),
							TextUtils.getTranslation("advancement.root"),
							TextUtils.getTranslation("advancement.root.desc"),
							new ResourceLocation("minecraft:textures/block/bricks.png"),
							FrameType.TASK, true, true, false)
					.addCriterion("root", InventoryChangeTrigger.TriggerInstance.hasItems(new ItemLike[]{}))
					.save(consumer, getNameId("main/root"));

			Advancement get_litchi = getAdvancement(fruitstack, ModItems.LITCHI_BLOCK.get(), "get_litchi_block", FrameType.TASK, true, true, false)
					.addCriterion("get_litchi_block", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LITCHI_BLOCK.get()))
					.save(consumer, getNameId("main/get_litchi_block"));
			Advancement get_glutinous_rice = getAdvancement(fruitstack, ModItems.LITCHI_BLOCK.get(), "get_glutinous_rice", FrameType.TASK, true, true, false)
					.addCriterion("get_glutinous_rice", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GLUTINOUS_RICE.get()))
					.save(consumer, getNameId("main/get_glutinous_rice"));
			Advancement get_golden_pure_sheep_horn_honey = getAdvancement(fruitstack, ModItems.GOLDEN_PURE_SHEEP_HORN_HONEY.get(), "get_golden_pure_sheep_horn_honey", FrameType.TASK, true, true, false)
					.addCriterion("get_golden_pure_sheep_horn_honey", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLDEN_PURE_SHEEP_HORN_HONEY.get()))
					.save(consumer, getNameId("main/get_golden_pure_sheep_horn_honey"));
			Advancement get_zong_zi_leaves = getAdvancement(fruitstack, ModItems.ZONG_ZI_LEAVES.get(), "get_zong_zi_leaves", FrameType.TASK, true, true, false)
					.addCriterion("get_zong_zi_leaves", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ZONG_ZI_LEAVES.get()))
					.save(consumer, getNameId("main/get_zong_zi_leaves"));
			Advancement get_golden_pure_sheep_horn_honey_flavor_golden_pure_sheep_horn_honey = getAdvancement(get_golden_pure_sheep_horn_honey, ModItems.GOLDEN_PURE_SHEEP_HORN_HONEY_FLAVOR_GOLDEN_PURE_SHEEP_HORN_HONEY.get(), "get_golden_pure_sheep_horn_honey_flavor_golden_pure_sheep_horn_honey", FrameType.TASK, true, true, false)
					.addCriterion("get_golden_pure_sheep_horn_honey_flavor_golden_pure_sheep_horn_honey", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLDEN_PURE_SHEEP_HORN_HONEY_FLAVOR_GOLDEN_PURE_SHEEP_HORN_HONEY.get()))
					.save(consumer, getNameId("main/get_golden_pure_sheep_horn_honey_flavor_golden_pure_sheep_horn_honey"));
			Advancement get_rice_dumpling_pot = getAdvancement(fruitstack, ModItems.RICE_DUMPLING_POT.get(), "get_rice_dumpling_pot", FrameType.TASK, true, true, false)
					.addCriterion("get_rice_dumpling_pot", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RICE_DUMPLING_POT.get()))
					.save(consumer, getNameId("main/get_rice_dumpling_pot"));
			Advancement get_a_bundle_of_candied_haws_on_a_stick = getAdvancement(fruitstack, ModItems.A_BUNDLE_OF_CANDIED_HAWS_ON_A_STICK.get(), "get_a_bundle_of_candied_haws_on_a_stick", FrameType.TASK, true, true, false)
					.addCriterion("get_a_bundle_of_candied_haws_on_a_stick", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.A_BUNDLE_OF_CANDIED_HAWS_ON_A_STICK.get()))
					.save(consumer, getNameId("main/get_a_bundle_of_candied_haws_on_a_stick"));
			RegistryObject<MobEffect> mobEffectRegistryObject = ModEffects.SWEET;
			MobEffect mobEffect = mobEffectRegistryObject.get();
			MobEffectsPredicate.MobEffectInstancePredicate instancePredicate = new MobEffectsPredicate.MobEffectInstancePredicate();
			Map<MobEffect, MobEffectsPredicate.MobEffectInstancePredicate> effectPredicateMap = new HashMap<>();
			effectPredicateMap.put(mobEffect, instancePredicate);
			Advancement get_sweet = getAdvancement(fruitstack, ModItems.HAMIMELON.get(), "get_sweet", FrameType.TASK, true, true, false)
					.addCriterion("get_sweet", EffectsChangedTrigger.TriggerInstance.hasEffects(new MobEffectsPredicate(effectPredicateMap)))
					.save(consumer, getNameId("main/get_sweet"));
			Advancement get_life_dirt = getAdvancement(fruitstack, ModItems.LIFE_DIRT.get(), "get_life_dirt", FrameType.TASK, true, true, false)
					.addCriterion("get_life_dirt", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LIFE_DIRT.get()))
					.save(consumer, getNameId("main/get_life_dirt"));
			Advancement get_wine_barrel = getAdvancement(fruitstack, ModItems.WINE_BARREL.get(), "get_wine_barrel", FrameType.TASK, true, true, false)
					.addCriterion("get_wine_barrel", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.WINE_BARREL.get()))
					.save(consumer, getNameId("main/get_wine_barrel"));
			Advancement get_low_wooden_barrel = getAdvancement(get_wine_barrel, ModItems.LOW_WOODEN_BARREL.get(), "get_low_wooden_barrel", FrameType.TASK, true, true, false)
					.addCriterion("get_low_wooden_barrel", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LOW_WOODEN_BARREL.get()))
					.save(consumer, getNameId("main/get_low_wooden_barrel"));
			Advancement get_tripod_vessel_for_making_pills_of_immortality = getAdvancement(fruitstack, ModItems.TRIPOD_VESSEL_FOR_MAKING_PILLS_OF_IMMORTALITY.get(), "get_tripod_vessel_for_making_pills_of_immortality", FrameType.TASK, true, true, false)
					.addCriterion("get_tripod_vessel_for_making_pills_of_immortality", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TRIPOD_VESSEL_FOR_MAKING_PILLS_OF_IMMORTALITY.get()))
					.save(consumer, getNameId("main/get_tripod_vessel_for_making_pills_of_immortality"));
			Advancement get_juicer = getAdvancement(fruitstack, ModItems.JUICER.get(), "get_juicer", FrameType.TASK, true, true, false)
					.addCriterion("get_juicer", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JUICER.get()))
					.save(consumer, getNameId("main/get_juicer"));
			Advancement get_plate = getAdvancement(fruitstack, ModItems.PLATE.get(), "get_plate", FrameType.TASK, true, true, false)
					.addCriterion("get_plate", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PLATE.get()))
					.save(consumer, getNameId("main/get_plate"));
			Advancement get_popsicle_machine = getAdvancement(fruitstack, ModItems.POPSICLE_MACHINE.get(), "get_popsicle_machine", FrameType.TASK, true, true, false)
					.addCriterion("get_popsicle_machine", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.POPSICLE_MACHINE.get()))
					.save(consumer, getNameId("main/get_popsicle_machine"));
			Advancement get_warm_stomach = getAdvancement(fruitstack, ModItems.MILKY_TEA.get(), "get_warm_stomach", FrameType.TASK, true, true, false)
					.addCriterion("get_warm_stomach", EffectsChangedTrigger.TriggerInstance.hasEffects(new MobEffectsPredicate(effectPredicateMap)))
					.save(consumer, getNameId("main/get_warm_stomach"));
		}
		Advancement.Builder getAdvancement(Advancement parent, ItemLike display, String name, FrameType frame, boolean showToast, boolean announceToChat, boolean hidden) {
			return Advancement.Builder.advancement().parent(parent).display(display,
					TextUtils.getTranslation("advancement." + name),
					TextUtils.getTranslation("advancement." + name + ".desc"),
					null, frame, showToast, announceToChat, hidden);
		}


		private String getNameId(String id) {
			return fruitstack.MODID + ":" + id;
		}
	}

}

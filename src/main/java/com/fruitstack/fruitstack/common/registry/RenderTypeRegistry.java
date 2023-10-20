package com.fruitstack.fruitstack.common.registry;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RenderTypeRegistry {
    static ItemBlockRenderTypes RenderTypeLookup;

    @SubscribeEvent
    public static void onRenderTypeSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.BLUEBERRIES_CROP.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.HAMIMELON_CROP.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.MANGO_CROP.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.MANGO_SAPLING.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.HOLBOELLIA_LATIFOLIA_CROP.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.BLUEBERRIES_CAKE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.BLUEBERRIES_PIE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.LITCHI_SAPLING.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.LITCHI_CROP.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.APPLE_SAPLING.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.APPLE_CROP.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.ZONG_ZI_LEAVES_CROP.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.GLUTINOUS_RICE_CROP.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.GLUTINOUS_RICE_CROP_PANICLES.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.HUOSHEN_FRUIT_CROP.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.WILD_BLUEBERRIES.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.SEPTEMBER_MELON_CROP.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.PITAYA_CROP.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.BEATING_MELONS_CROP.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.GROUND_CUCUMBER_CROP.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_CROP.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.HOLBOELLIA_LATIFOLIA_EGG_MILK_PUDDING.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.WILD_HOLBOELLIA_LATIFOLIA.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.HAMIMELON_SAGO_SOUP_BLOCK.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.WILD_HAMIMELON.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.WILD_GROUND_CUCUMBER.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
                RenderTypeLookup.setRenderLayer(ModBlocks.WILD_HUOSHEN_FRUIT.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.WILD_BEATING_MELONS.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.WILD_SEPTEMBER_MELON.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.WILD_PITAYA.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.WILD_GOLDEN_PURE_SHEEP_HORN_HONEY.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.WILD_ZONG_ZI_LEAVES.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.MANGO_CAKE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.MANGO_PIE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.MANGO_CRATE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.HAMIMELON_CAKE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.HAMIMELON_PIE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.HAMIMELON_CRATE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.BEATING_MELONS_CAKE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.BEATING_MELONS_PIE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.BEATING_MELONS_CRATE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.GROUND_CUCUMBER_CAKE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.GROUND_CUCUMBER_PIE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.GROUND_CUCUMBER_CRATE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.HOLBOELLIA_LATIFOLIA_CRATE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.HOLBOELLIA_LATIFOLIA_PIE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.HOLBOELLIA_LATIFOLIA_CAKE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.LITCHI_CAKE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.LITCHI_CRATE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.LITCHI_PIE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.BOWLED_LITCHI_RIVER_NOODLES.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.HUOSHEN_FRUIT_PIE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.HUOSHEN_FRUIT_CAKE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.HUOSHEN_FRUIT_CRATE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.HUOSHEN_FRUIT_HONEY_SAUCE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.PITAYA_CAKE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.PITAYA_CRATE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.PITAYA_PIE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.COLORFUL_FRUIT_SALAD_BLOCK.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_CAKE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_CRATE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_PIE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.BLUEBERRIES_MOON_CAKE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.BLUEBERRIES_RICE_DUMPLING_BLOCK.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.HAMIMELON_RICE_DUMPLING_BLOCK.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.HAMIMELON_MOON_CAKE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.BEATING_MELONS_MOON_CAKE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.BEATING_MELONS_RICE_DUMPLING_BLOCK.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.GROUND_CUCUMBER_MOON_CAKE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.GROUND_CUCUMBER_RICE_DUMPLING_BLOCK.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.MANGO_MOON_CAKE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.MANGO_RICE_DUMPLING_BLOCK.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.HOLBOELLIA_LATIFOLIA_MOON_CAKE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.HOLBOELLIA_LATIFOLIA_RICE_DUMPLING_BLOCK.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.LITCHI_MOON_CAKE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.LITCHI_RICE_DUMPLING_BLOCK.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.HUOSHEN_FRUIT_MOON_CAKE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.HUOSHEN_FRUIT_RICE_DUMPLING_BLOCK.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.SEPTEMBER_MELON_RICE_DUMPLING_BLOCK.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.SEPTEMBER_MELON_MOON_CAKE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.PITAYA_MOON_CAKE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.PITAYA_RICE_DUMPLING_BLOCK.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_MOON_CAKE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_RICE_DUMPLING_BLOCK.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.PEAR_CAKE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.PEAR_PIE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.PEAR_CRATE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.PEAR_CROP.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.PEAR_SAPLING.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.PEAR_RICE_DUMPLING_BLOCK.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.PEAR_MOON_CAKE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.ROCK_SUPAR_SNOW_PEAR.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.MAYTHORN_CAKE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.MAYTHORN_PIE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.MAYTHORN_CRATE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.MAYTHORN_CROP.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.MAYTHORN_SAPLING.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.MANGO_RICE_DUMPLING_BLOCK.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.MAYTHORN_MOON_CAKE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.BOWLED_CANDIED_HAWS_ON_A_STICK.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.A_BUNDLE_OF_CANDIED_HAWS_ON_A_STICK.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.RED_FRUIT_MAYTHORN_CAKE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.CHINESE_PEAR_LEAVED_CRATE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.CHINESE_PEAR_LEAVED_CAKE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.CHINESE_PEAR_LEAVED_SAPLING.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.CHINESE_PEAR_LEAVED_CROP.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.CHINESE_PEAR_LEAVED_PIE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.CHINESE_PEAR_LEAVED_MOON_CAKE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.CHINESE_PEAR_LEAVED_RICE_DUMPLING_BLOCK.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.PLUM_PIE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.PLUM_CRATE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.PLUM_CAKE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.PLUM_CROP.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.PLUM_SAPLING.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.PLUM_RICE_DUMPLING_BLOCK.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.PLUM_MOON_CAKE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.SOUR_AND_SWEET_PLUM_CAKE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.JUJUBE_CAKE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.JUJUBE_CRATE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.JUJUBE_PIE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.JUJUBE_CROP.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.JUJUBE_SAPLING.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.JUJUBE_RICE_DUMPLING_BLOCK.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.JUJUBE_MOON_CAKE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.APRICOT_CAKE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.APRICOT_CRATE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.APRICOT_PIE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.APRICOT_CROP.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.APRICOT_SAPLING.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.APRICOT_RICE_DUMPLING_BLOCK.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.APRICOT_MOON_CAKE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.RED_GATE_GLUTINOUS_RICE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.APRICOT_SMOOTHIE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.RED_BAYBERRY_CAKE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.RED_BAYBERRY_CRATE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.RED_BAYBERRY_PIE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.RED_BAYBERRY_CROP.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.RED_BAYBERRY_SAPLING.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.RED_BAYBERRY_RICE_DUMPLING_BLOCK.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.RED_BAYBERRY_MOON_CAKE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.SOUR_PLUM_CHICKEN_BLOCK.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.GREEN_PLUM_CAKE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.GREEN_PLUM_CRATE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.GREEN_PLUM_PIE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.GREEN_PLUM_CROP.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.GREEN_PLUM_SAPLING.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.GREEN_PLUM_RICE_DUMPLING_BLOCK.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.GREEN_PLUM_MOON_CAKE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.MANGO_LEAVES.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.MANGO_LOG_TOP.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.MANGO_LOG_BIG.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.MANGO_LOG_MEDIUM.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.MANGO_LOG_SMALL.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.MANGO_JAM.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.BLUEBERRIES_JAM.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.LITCHI_BLOCK.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.GRAPE_CROP_BOTTOM.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.GRAPE_CROP_MIDDLE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.GRAPE_CROP_TOP.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.GRAPE_BRACKET_TOP.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.GRAPE_BRACKET.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.GRAPE_CROP.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.JUICER.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.SWEETENED_MAYTHORN.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.CORRUPT_CROP.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.PLATE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.WINE_BARREL.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.MANGO_WINE_BARREL.get(), RenderType.translucent());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.LOW_WOODEN_BARREL.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.BLUEBERRIES_WINE_BARREL.get(), RenderType.translucent());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.CHINESE_SPIRITS_BARREL.get(), RenderType.translucent());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.HAMIMELON_WINE_BARREL.get(), RenderType.translucent());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.HOLBOELLIA_LATIFOLIA_WINE_BARREL.get(), RenderType.translucent());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.LITCHI_WINE_BARREL.get(), RenderType.translucent());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.MANGO_LANTERN.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.HUOSHEN_FRUIT_WINE_BARREL.get(), RenderType.translucent());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.BEATING_MELONS_WINE_BARREL.get(), RenderType.translucent());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.GROUND_CUCUMBER_WINE_BARREL.get(), RenderType.translucent());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.SEPTEMBER_MELON_WINE_BARREL.get(), RenderType.translucent());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.PITAYA_WINE_BARREL.get(), RenderType.translucent());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_WINE_BARREL.get(), RenderType.translucent());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.PEAR_WINE_BARREL.get(), RenderType.translucent());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.MAYTHORN_WINE_BARREL.get(), RenderType.translucent());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.CHINESE_PEAR_LEAVED_WINE_BARREL.get(), RenderType.translucent());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.PLUM_WINE_BARREL.get(), RenderType.translucent());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.JUJUBE_WINE_BARREL.get(), RenderType.translucent());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.APRICOT_WINE_BARREL.get(), RenderType.translucent());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.RED_BAYBERRY_WINE_BARREL.get(), RenderType.translucent());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.GREEN_PLUM_WINE_BARREL.get(), RenderType.translucent());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.GRAPE_WINE_BARREL.get(), RenderType.translucent());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.WILD_GRAPE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.WILD_GLUTINOUS_RICE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.GRAPE_JELLY.get(), RenderType.translucent());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.POPSICLE_MACHINE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.BLUEBERRIES_POPSICLE_MACHINE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.HAMIMELON_POPSICLE_MACHINE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.BEATING_MELONS_POPSICLE_MACHINE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.GROUND_CUCUMBER_POPSICLE_MACHINE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.MANGO_POPSICLE_MACHINE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.HOLBOELLIA_LATIFOLIA_POPSICLE_MACHINE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.LITCHI_POPSICLE_MACHINE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.HUOSHEN_FRUIT_POPSICLE_MACHINE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.SEPTEMBER_MELON_POPSICLE_MACHINE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.PITAYA_POPSICLE_MACHINE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.GOLDEN_PURE_SHEEP_HORN_HONEY_POPSICLE_MACHINE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.PEAR_POPSICLE_MACHINE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.MAYTHORN_POPSICLE_MACHINE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.CHINESE_PEAR_LEAVED_POPSICLE_MACHINE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.PLUM_POPSICLE_MACHINE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.JUJUBE_POPSICLE_MACHINE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.APRICOT_POPSICLE_MACHINE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.RED_BAYBERRY_POPSICLE_MACHINE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.GREEN_PLUM_POPSICLE_MACHINE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.GRAPE_POPSICLE_MACHINE.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.FRYING_PAN.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.BLACK_TEA_LEAVES.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.BLACK_TEA_LOG_TOP.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.WILD_BLACK_TEA_LEAVES.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.OVEN.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.PEACH_SAPLING.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.PEACH_LEAVES.get(), RenderType.cutoutMipped());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.PEACH_WINE_BARREL.get(), RenderType.translucent());
        });
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.PEACH_POPSICLE_MACHINE.get(), RenderType.cutoutMipped());
        });
    }
}
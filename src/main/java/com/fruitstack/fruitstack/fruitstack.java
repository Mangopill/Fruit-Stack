package com.fruitstack.fruitstack;

import com.fruitstack.fruitstack.client.ClientSetup;
import com.fruitstack.fruitstack.common.CommonSetup;
import com.fruitstack.fruitstack.common.Configuration;
import com.fruitstack.fruitstack.common.event.ModEventHandler;
import com.fruitstack.fruitstack.common.registry.*;
import com.fruitstack.fruitstack.common.world.WildCropGeneration;
import com.fruitstack.fruitstack.events.EventSetup;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nonnull;

import static net.minecraftforge.versions.forge.ForgeVersion.MOD_ID;

@Mod("fruitstack")
public class fruitstack
{
    public static final String MODID = "fruitstack";
    public static final Logger LOGGER = LogManager.getLogger();
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    public static final RecipeBookType RECIPE_TYPE_COOKING = RecipeBookType.create("COOKING");
    public fruitstack() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(ModEventHandler.class);
        modEventBus.addListener(CommonSetup::init);
        modEventBus.addListener(ClientSetup::init);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Configuration.COMMON_CONFIG);
            ModItems.ITEMS.register(modEventBus);
            ModBlocks.BLOCKS.register(modEventBus);
            ModEffects.EFFECTS.register(modEventBus);
		    ModEntityTypes.ENTITIES.register(modEventBus);
        ModCreativeTabs.CREATIVE_TABS.register(modEventBus);
        ModRecipeTypes.RECIPE_TYPES.register(modEventBus);
        ModParticleTypes.PARTICLE_TYPES.register(modEventBus);
        ModSounds.SOUNDS.register(modEventBus);
        ModBlockEntityTypes.TILES.register(modEventBus);
        ModMenuTypes.MENU_TYPES.register(modEventBus);
        ModRecipeSerializers.RECIPE_SERIALIZERS.register(modEventBus);
        ModBiomeFeatures.FEATURES.register(modEventBus);
        ModBiomeModifiers.BIOME_MODIFIER_SERIALIZERS.register(modEventBus);
        ModPlacementModifiers.PLACEMENT_MODIFIERS.register(modEventBus);
        modEventBus.addListener(fruitstack::commonSetup);
        modEventBus.addListener(fruitstack::enqueueIMC);
        modEventBus.addListener(fruitstack::processIMC);
        WildCropGeneration.load();
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.addListener(fruitstack::serverStarting);
    }


    private static void commonSetup(FMLCommonSetupEvent event) {
        fruitstack.LOGGER.debug("common setup");
        EventSetup.setupEvents();
    }
    private static void enqueueIMC(final InterModEnqueueEvent event) {
    }
    private static void processIMC(final InterModProcessEvent event) {
    }

    private static void serverStarting(ServerStartingEvent event) {
    }
    static class Server extends fruitstack {
        Server() {
            FMLJavaModLoadingContext.get().getModEventBus().addListener(Server::serverSetup);
            FMLJavaModLoadingContext.get().getModEventBus().addListener(Server::serverSetup);
        }

        private static void serverSetup(FMLDedicatedServerSetupEvent event) {
        }
    }

    @Nonnull
    public static ResourceLocation getId(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

}







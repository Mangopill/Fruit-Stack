package com.fruitstack.fruitstack;

import com.fruitstack.fruitstack.client.ClientSetup;
import com.fruitstack.fruitstack.common.CommonSetup;
import com.fruitstack.fruitstack.common.event.ModEventHandler;
import com.fruitstack.fruitstack.common.registry.*;
import com.fruitstack.fruitstack.common.tag.ModTags;
import com.fruitstack.fruitstack.config.Config;
import com.fruitstack.fruitstack.events.EventSetup;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
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
    public static final CreativeModeTab CREATIVE_TAB = new CreativeModeTab(fruitstack.MODID)
        {
            @Nonnull
            @Override
            public ItemStack makeIcon() {
            return new ItemStack(ModItems.CLAY_OVEN.get());
        }
        };

    public fruitstack() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(ModEventHandler.class);
        modEventBus.addListener(CommonSetup::init);
        modEventBus.addListener(ClientSetup::init);
            ModItems.ITEMS.register(modEventBus);
            ModBlocks.BLOCKS.register(modEventBus);
            ModEffects.EFFECTS.register(modEventBus);
		    ModEntityTypes.ENTITIES.register(modEventBus);
        ModRecipeTypes.RECIPE_TYPES.register(modEventBus);
        ModParticleTypes.PARTICLE_TYPES.register(modEventBus);
        ModSounds.SOUNDS.register(modEventBus);
        ModBlockEntityTypes.TILES.register(modEventBus);
        ModMenuTypes.MENU_TYPES.register(modEventBus);
        ModRecipeSerializers.RECIPE_SERIALIZERS.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.CONFIG, "fruitstack.toml");
        eventBus.addListener(fruitstack::commonSetup);
        eventBus.addListener(fruitstack::enqueueIMC);
        eventBus.addListener(fruitstack::processIMC);

        FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Feature.class, WorldGenRegistry::registerAll);

        Config.loadConfig(Config.CONFIG, FMLPaths.CONFIGDIR.get().resolve("fruitstack.toml").toString());

        MinecraftForge.EVENT_BUS.addListener(fruitstack::serverStarting);
        MinecraftForge.EVENT_BUS.addListener(fruitstack::onBiomeLoad);
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

    private static void onBiomeLoad(BiomeLoadingEvent event) {
        TemperateFruitTreeWorldGenRegistry.addToBiome(event);
        WarmFruitTreeWorldGenRegistry.addToBiomes(event);
        ColdFruitTreeWorldGenRegistry.addToBiomes(event);
        WildCropRegistry.addToBiome(event);
        // Debug code for printing biome tree features.
		/*final String features = event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).stream()
				.map(s -> s.get())
				.map(feat -> {
					ConfiguredFeature<?, ?> ret = feat;

					while (ret.config instanceof DecoratedFeatureConfig)
						ret = ((DecoratedFeatureConfig) ret.config).feature.get();

					return ret;
				})
				.filter(feat -> feat.feature.getRegistryName() != null && feat.feature.getRegistryName().getNamespace().equals("pamhc2trees"))
				.map(feat -> String.valueOf(feat.feature.getRegistryName()))
				.sorted()
				.collect(Collectors.joining("\n"));

		if (!features.isEmpty())
			Pamhc2trees.LOGGER.info("Biome features for {}:\n{}", event.getName(), features);*/
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







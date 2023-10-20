package com.fruitstack.fruitstack.client.event;

import com.fruitstack.fruitstack.client.renderer.BowlBlockRenderer;
import com.fruitstack.fruitstack.client.renderer.JuicerRenderer;
import com.fruitstack.fruitstack.client.particle.SteamParticle;
import com.fruitstack.fruitstack.client.renderer.PlateRenderer;
import com.fruitstack.fruitstack.common.registry.ModBlockEntityTypes;
import com.fruitstack.fruitstack.common.registry.ModEntityTypes;
import com.fruitstack.fruitstack.common.registry.ModParticleTypes;
import com.fruitstack.fruitstack.fruitstack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.SplashParticle;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = fruitstack.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetupEvents
{
	@SubscribeEvent
	public static void onEntityRendererRegister(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(ModEntityTypes.RAW_BLUEBERRIES_MOON_CAKE.get(), ThrownItemRenderer::new);
	}
	@SubscribeEvent
	public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer(ModBlockEntityTypes.JUICER.get(), JuicerRenderer::new);
		event.registerBlockEntityRenderer(ModBlockEntityTypes.PLATE.get(), PlateRenderer::new);
		event.registerBlockEntityRenderer(ModBlockEntityTypes.BOWL_BLOCK.get(), BowlBlockRenderer::new);
	}
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public static void registerParticles(ParticleFactoryRegisterEvent event) {
		Minecraft.getInstance().particleEngine.register(ModParticleTypes.STEAM.get(), SteamParticle.Factory::new);
		Minecraft.getInstance().particleEngine.register(ModParticleTypes.OIL.get(), SplashParticle.Provider::new);
	}
}

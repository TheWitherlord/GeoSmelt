package com.witherlord00.geosmelt.geocommon.entities.renderers;

import com.witherlord00.geosmelt.GeoSmelt;
import com.witherlord00.geosmelt.geocore.init.GeoEntityRegistry;

import net.minecraft.client.renderer.entity.SkeletonRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = GeoSmelt.MODID, value = Dist.CLIENT, bus = Bus.MOD)
public class ModRenderers {
	@SubscribeEvent
	public static void register(final FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(GeoEntityRegistry.SMALL_DRAGON_FIREBALL, manager -> new SmallDragonFireballRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(GeoEntityRegistry.HOLY_ORB, manager -> new HolyOrbRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(GeoEntityRegistry.GREATER_WITHER_SKULL, manager -> new GreaterWitherSkullRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(GeoEntityRegistry.ICE_BALL, manager -> new IceBallRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(GeoEntityRegistry.BIG_SNOWBALL, manager -> new BigSnowballRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(GeoEntityRegistry.STARCILIUM_GOLEM, manager -> new StarciliumGolemRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(GeoEntityRegistry.ARMORED_SKELETON, manager -> new SkeletonRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(GeoEntityRegistry.OVERGROWN, manager -> new OvergrownRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(GeoEntityRegistry.SKELETON_SCRAPPER, manager -> new SkeletonRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(GeoEntityRegistry.SKELETON_SENTINEL, manager -> new SkeletonSentinelRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(GeoEntityRegistry.SKELETON_ELITE, manager -> new SkeletonEliteRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(GeoEntityRegistry.JUNGLE_TARANTULA, manager -> new JungleTarantulaRenderer(manager));


	}
}
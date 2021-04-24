package com.witherlord00.geosmelt.geoworld;

import com.witherlord00.geosmelt.GeoSmelt;
import com.witherlord00.geosmelt.geocommon.entities.ArmoredSkeletonEntity;
import com.witherlord00.geosmelt.geocommon.entities.JungleTarantulaEntity;
import com.witherlord00.geosmelt.geocommon.entities.OvergrownEntity;
import com.witherlord00.geosmelt.geocommon.entities.SkeletonEliteEntity;
import com.witherlord00.geosmelt.geocommon.entities.SkeletonScrapperEntity;
import com.witherlord00.geosmelt.geocommon.entities.SkeletonSentinelEntity;
import com.witherlord00.geosmelt.geocore.config.GeoConfig;
import com.witherlord00.geosmelt.geocore.init.GeoEntityRegistry;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.world.MobSpawnInfoBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GeoSmelt.MODID)
public class ModEntitySpawns {

	//credits to Upgrade Aquatic/TeamAbnormals attemped use of how they handle spawns/ still some issues with how things are handled because mobs fall from sky
	
	public static void registerSpawns() {
		EntitySpawnPlacementRegistry.register(GeoEntityRegistry.ARMORED_SKELETON,
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				ArmoredSkeletonEntity::canMonsterSpawnInLight);

		EntitySpawnPlacementRegistry.register(GeoEntityRegistry.SKELETON_SCRAPPER,
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				SkeletonScrapperEntity::canMonsterSpawnInLight);

		EntitySpawnPlacementRegistry.register(GeoEntityRegistry.OVERGROWN,
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				OvergrownEntity::canMonsterSpawnInLight);

		EntitySpawnPlacementRegistry.register(GeoEntityRegistry.SKELETON_ELITE,
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				SkeletonEliteEntity::canMonsterSpawnInLight);
		
		EntitySpawnPlacementRegistry.register(GeoEntityRegistry.SKELETON_SENTINEL,
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				SkeletonSentinelEntity::canMonsterSpawnInLight);

		EntitySpawnPlacementRegistry.register(GeoEntityRegistry.JUNGLE_TARANTULA,
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				JungleTarantulaEntity::canMonsterSpawnInLight);

	}

	@SubscribeEvent
	public static void onBiomeLoading(BiomeLoadingEvent event) {
		if (event.getName() == null)
			return;
		ResourceLocation biome = event.getName();
		MobSpawnInfoBuilder spawns = event.getSpawns();
		RegistryKey<Biome> key = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, biome);

		if (BiomeDictionary.hasType(key, BiomeDictionary.Type.OVERWORLD)) {
			if (GeoConfig.COMMON.spawnArmoredSkeletonWeight.get() > 0)
				spawns.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(
						GeoEntityRegistry.ARMORED_SKELETON, GeoConfig.COMMON.spawnArmoredSkeletonWeight.get(), 1, 2));

			if (GeoConfig.COMMON.spawnSkeletonSentinelWeight.get() > 0)
				spawns.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(
						GeoEntityRegistry.SKELETON_SENTINEL, GeoConfig.COMMON.spawnSkeletonSentinelWeight.get(), 1, 2));
			
			if (GeoConfig.COMMON.spawnSkeletonEliteWeight.get() > 0)
				spawns.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(
						GeoEntityRegistry.SKELETON_ELITE, GeoConfig.COMMON.spawnSkeletonEliteWeight.get(), 1, 2));
		}
		if (BiomeDictionary.hasType(key, BiomeDictionary.Type.MOUNTAIN)
				&& GeoConfig.COMMON.spawnSkeletonScrapperWeight.get() > 0) {
			spawns.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(
					GeoEntityRegistry.SKELETON_SCRAPPER, GeoConfig.COMMON.spawnSkeletonScrapperWeight.get(), 1, 2));
		}
		if (BiomeDictionary.hasType(key, BiomeDictionary.Type.SWAMP)
				&& GeoConfig.COMMON.spawnOvergrownWeight.get() > 0) {
			spawns.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(GeoEntityRegistry.OVERGROWN,
					GeoConfig.COMMON.spawnOvergrownWeight.get(), 1, 2));
		}

		if (event.getCategory() == Biome.Category.JUNGLE) {
			if (GeoConfig.COMMON.spawnTarantulaWeight.get() > 0)
				spawns.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(GeoEntityRegistry.OVERGROWN,
						GeoConfig.COMMON.spawnOvergrownWeight.get(), 1, 2));

			if (GeoConfig.COMMON.spawnOvergrownWeight.get() > 0)
				spawns.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(
						GeoEntityRegistry.JUNGLE_TARANTULA, GeoConfig.COMMON.spawnTarantulaWeight.get(), 1, 2));

		}

	}

}

package com.witherlord00.geosmelt.geocore.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import net.minecraftforge.fml.common.Mod;
import org.apache.commons.lang3.tuple.Pair;

import com.witherlord00.geosmelt.GeoSmelt;

@Mod.EventBusSubscriber(modid = GeoSmelt.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GeoConfig {
	public static class Common {
		public final ConfigValue<Integer> spawnArmoredSkeletonWeight;

		public final ConfigValue<Integer> spawnSkeletonScrapperWeight;

		public final ConfigValue<Integer> spawnOvergrownWeight;
		
		public final ConfigValue<Integer> spawnSkeletonEliteWeight;
		
		public final ConfigValue<Integer> spawnSkeletonSentinelWeight;

		
		public final ConfigValue<Integer> spawnTarantulaWeight;



		/**
		 * Common config setup Related to both server and client options
		 *
		 * @param builder
		 */
		public Common(ForgeConfigSpec.Builder builder) {

			builder.push("spawns");
			this.spawnArmoredSkeletonWeight = builder.define("Armored Skeleton Spawn Weight, default: 48", 48);
			this.spawnSkeletonScrapperWeight = builder.define("Skeleton Scrapper Spawn Weight, default: 50", 50);
			this.spawnOvergrownWeight = builder.define("Overgrown Spawn Weight, default: 48", 48);
			this.spawnSkeletonEliteWeight = builder.define("Skeleton Elite Spawn Weight, default: 3", 3);
			this.spawnSkeletonSentinelWeight = builder.define("Skeleton Sentinel Spawn Weight default: 7", 7);
			this.spawnTarantulaWeight = builder.define("Jungle Tarantula Spawn Weight, default: 38", 38);
			
			builder.pop();

		}
	}

	public static final ForgeConfigSpec COMMON_SPEC;
	public static final Common COMMON;

	static {
		final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(GeoConfig.Common::new);
		COMMON_SPEC = specPair.getRight();
		COMMON = specPair.getLeft();
	}

}

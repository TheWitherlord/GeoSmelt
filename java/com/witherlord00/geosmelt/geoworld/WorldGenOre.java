package com.witherlord00.geosmelt.geoworld;

import java.util.ArrayList;

import com.witherlord00.geosmelt.GeoSmelt;
import com.witherlord00.geosmelt.geocore.init.InitBlock;

import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class WorldGenOre {

	private static final ArrayList<ConfiguredFeature<?, ?>> overworldMountainOres = new ArrayList<ConfiguredFeature<?, ?>>();
	private static final ArrayList<ConfiguredFeature<?, ?>> overworldOceanOres = new ArrayList<ConfiguredFeature<?, ?>>();
	private static final ArrayList<ConfiguredFeature<?, ?>> overworldJungleOres = new ArrayList<ConfiguredFeature<?, ?>>();
	private static final ArrayList<ConfiguredFeature<?, ?>> netherOres = new ArrayList<ConfiguredFeature<?, ?>>();
	private static final ArrayList<ConfiguredFeature<?, ?>> endOres = new ArrayList<ConfiguredFeature<?, ?>>();

	public static void registerOres() {

		// Overworld Ore Register
		overworldJungleOres.add(register("terranite",
				Feature.ORE
						.withConfiguration(new OreFeatureConfig(new BlockMatchRuleTest(Blocks.STONE),
								InitBlock.TERRANITE.get().getDefaultState(), 8))// Vein Size
						.range(53).square() // Spawn height start
						.func_242731_b(9))); // Chunk spawn frequency

		overworldOceanOres.add(register("tazurite_ore",
				Feature.ORE
						.withConfiguration(new OreFeatureConfig(new BlockMatchRuleTest(Blocks.SAND),
								InitBlock.TAZURITE_ORE.get().getDefaultState(), 6))// Vein Size
						.range(64).square() // Spawn height start
						.func_242731_b(8))); // Chunk spawn frequency

		overworldMountainOres.add(register("jaspillite",
				Feature.ORE
						.withConfiguration(new OreFeatureConfig(new BlockMatchRuleTest(Blocks.STONE),
								InitBlock.JASPILLITE.get().getDefaultState(), 12))// Vein Size
						.range(85).square() // Spawn height start
						.func_242731_b(7))); // Chunk spawn frequency

		// Nether Ore Register

		netherOres.add(register("mithril_ore",
				Feature.ORE
						.withConfiguration(new OreFeatureConfig(new BlockMatchRuleTest(Blocks.BASALT),
								InitBlock.MITHRIL_ORE.get().getDefaultState(), 4))// Vein Size
						.range(128).square() // Spawn height start
						.func_242731_b(10))); // Chunk spawn frequency

		// End Ore Register
		endOres.add(register("starcilium_ore",
				Feature.ORE
						.withConfiguration(new OreFeatureConfig(new BlockMatchRuleTest(Blocks.END_STONE),
								InitBlock.STARCILIUM_ORE.get().getDefaultState(), 5)) // Vein Size
						.range(50).square() // Spawn height start
						.func_242731_b(2))); // Chunk spawn frequency

		endOres.add(register("duskrok",
				Feature.ORE
						.withConfiguration(new OreFeatureConfig(new BlockMatchRuleTest(Blocks.END_STONE),
								InitBlock.DUSKROK.get().getDefaultState(), 20)) // Vein Size
						.range(38).square() // Spawn height start
						.func_242731_b(9))); // Chunk spawn frequency

	}

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void gen(BiomeLoadingEvent event) {
		BiomeGenerationSettingsBuilder generation = event.getGeneration();
		if (event.getCategory().equals(Biome.Category.NETHER)) {
			for (ConfiguredFeature<?, ?> ore : netherOres) {
				if (ore != null)
					generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
			}
		}
		if (event.getCategory().equals(Biome.Category.THEEND)) {
			for (ConfiguredFeature<?, ?> ore : endOres) {
				if (ore != null)
					generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
			}
		}
		if (event.getCategory().equals(Biome.Category.EXTREME_HILLS)) {
			for (ConfiguredFeature<?, ?> ore : overworldMountainOres) {
				if (ore != null)
					generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
			}

		}
		if (event.getCategory().equals(Biome.Category.JUNGLE)) {
			for (ConfiguredFeature<?, ?> ore : overworldJungleOres) {
				if (ore != null)
					generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
			}

		}
		if (event.getCategory().equals(Biome.Category.OCEAN)) {
			for (ConfiguredFeature<?, ?> ore : overworldOceanOres) {
				if (ore != null)
					generation.withFeature(GenerationStage.Decoration.TOP_LAYER_MODIFICATION, ore);
			}
		}
	}

	private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String name,
			ConfiguredFeature<FC, ?> configuredFeature) {
		return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, GeoSmelt.MODID + ":" + name, configuredFeature);
	}

}
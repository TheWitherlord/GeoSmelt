package com.witherlord00.geosmelt.geocore.init;

import com.witherlord00.geosmelt.GeoSmelt;
import com.witherlord00.geosmelt.geocommon.items.AquaSlashItem;
import com.witherlord00.geosmelt.geocommon.items.BananaBladeItem;
import com.witherlord00.geosmelt.geocommon.items.CelestialArmorItem;
import com.witherlord00.geosmelt.geocommon.items.CrystalIceItem;
import com.witherlord00.geosmelt.geocommon.items.DragonChargeItem;
import com.witherlord00.geosmelt.geocommon.items.EarthGlaiveItem;
import com.witherlord00.geosmelt.geocommon.items.GalaxiusItem;
import com.witherlord00.geosmelt.geocommon.items.GreaterFireTome;
import com.witherlord00.geosmelt.geocommon.items.GreaterIceTome;
import com.witherlord00.geosmelt.geocommon.items.GreaterWitherTome;
import com.witherlord00.geosmelt.geocommon.items.GummerItem;
import com.witherlord00.geosmelt.geocommon.items.HarmingStaffItem;
import com.witherlord00.geosmelt.geocommon.items.HastyAxeItem;
import com.witherlord00.geosmelt.geocommon.items.HastyHoeItem;
import com.witherlord00.geosmelt.geocommon.items.HastyPickaxeItem;
import com.witherlord00.geosmelt.geocommon.items.HastyShovelItem;
import com.witherlord00.geosmelt.geocommon.items.HastySwordItem;
import com.witherlord00.geosmelt.geocommon.items.HealingStaffItem;
import com.witherlord00.geosmelt.geocommon.items.HollowBladeItem;
import com.witherlord00.geosmelt.geocommon.items.InfinityPlateItem;
import com.witherlord00.geosmelt.geocommon.items.InfinityShardItem;
import com.witherlord00.geosmelt.geocommon.items.LesserFireTome;
import com.witherlord00.geosmelt.geocommon.items.LesserIceTome;
import com.witherlord00.geosmelt.geocommon.items.LesserWitherTome;
import com.witherlord00.geosmelt.geocommon.items.MorningStarItem;
import com.witherlord00.geosmelt.geocommon.items.StarciliumAppleItem;
import com.witherlord00.geosmelt.geocommon.items.StormbreakerItem;
import com.witherlord00.geosmelt.geocommon.items.TriSwordItem;
import com.witherlord00.geosmelt.geocommon.items.VirionAxeItem;
import com.witherlord00.geosmelt.geocore.common.ModArmorMaterial;
import com.witherlord00.geosmelt.geocore.common.ModItemTier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class InitItem {   

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GeoSmelt.MODID);

	// Block Items
	
	
	public static final RegistryObject<BlockItem> GILDED_DWARVEN_PILLAR = ITEMS.register("gilded_dwarven_pillar",
			() -> new BlockItem(InitBlock.GILDED_DWARVEN_PILLAR.get(), new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));
	
	public static final RegistryObject<BlockItem> DWARVEN_PILLAR = ITEMS.register("dwarven_pillar",
			() -> new BlockItem(InitBlock.DWARVEN_PILLAR.get(), new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));
	
	public static final RegistryObject<BlockItem> DWARVEN_TILE = ITEMS.register("dwarven_tile",
			() -> new BlockItem(InitBlock.DWARVEN_TILE.get(), new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));
	
	public static final RegistryObject<BlockItem> DWARVEN_FACE = ITEMS.register("dwarven_face_block",
			() -> new BlockItem(InitBlock.DWARVEN_FACE.get(), new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));
	
	public static final RegistryObject<BlockItem> EAGLESTEEL_BLOCK = ITEMS.register("eaglesteel_block",
			() -> new BlockItem(InitBlock.EAGLESTEEL_BLOCK.get(), new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));
	
	
	public static final RegistryObject<BlockItem> JASPILLITE = ITEMS.register("jaspillite",
			() -> new BlockItem(InitBlock.JASPILLITE.get(), new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));
	
	public static final RegistryObject<BlockItem> JASPER_BLOCK = ITEMS.register("jasper_block",
			() -> new BlockItem(InitBlock.JASPER_BLOCK.get(), new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	
	public static final RegistryObject<BlockItem> DRAGONSCORCH_BLOCK = ITEMS.register("dragonscorch",
			() -> new BlockItem(InitBlock.DRAGONSCORCH_BLOCK.get(), new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<BlockItem> DRAGONSCORCH_BRICKS = ITEMS.register("dragonscorch_bricks",
			() -> new BlockItem(InitBlock.DRAGONSCORCH_BRICKS.get(), new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));
	
	public static final RegistryObject<BlockItem> CHISELED_DRAGONSCORCH = ITEMS.register("chiseled_dragonscorch",
			() -> new BlockItem(InitBlock.CHISELED_DRAGONSCORCH.get(), new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));
	
	public static final RegistryObject<BlockItem> SMOOTH_DRAGONSCORCH_BLOCK = ITEMS.register("smooth_dragonscorch",
			() -> new BlockItem(InitBlock.SMOOTH_DRAGONSCORCH_BLOCK.get(), new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));
	
	
	
	
	public static final RegistryObject<BlockItem> TAZURITE_ORE = ITEMS.register("tazurite_ore",
			() -> new BlockItem(InitBlock.TAZURITE_ORE.get(), new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<BlockItem> FANCY_TAZURITE_BLOCK = ITEMS.register("fancy_tazurite_block",
			() -> new BlockItem(InitBlock.FANCY_TAZURITE_BLOCK.get(), new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));
	

	public static final RegistryObject<BlockItem> TAZURITE_BLOCK = ITEMS.register("tazurite_block",
			() -> new BlockItem(InitBlock.TAZURITE_BLOCK.get(), new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));


	public static final RegistryObject<BlockItem> TAZURITE_SMOOTH_BLOCK = ITEMS.register("smooth_tazurite_block",
			() -> new BlockItem(InitBlock.TAZURITE_SMOOTH_BLOCK.get(),
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<BlockItem> TAZURITE_DOOR = ITEMS.register("tazurite_door",
			() -> new BlockItem(InitBlock.TAZURITE_DOOR.get(), new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<BlockItem> TAZURITE_BRICKS = ITEMS.register("tazurite_bricks",
			() -> new BlockItem(InitBlock.TAZURITE_BRICKS.get(), new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<BlockItem> TAZURITE_CHISELED_BRICKS = ITEMS.register("chiseled_tazurite_bricks",
			() -> new BlockItem(InitBlock.CHISELED_TAZURITE_BRICKS.get(),
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<BlockItem> TAZURITE_TILES = ITEMS.register("tazurite_tiles",
			() -> new BlockItem(InitBlock.TAZURITE_TILES.get(), new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<BlockItem> TAZURITE_PILLAR = ITEMS.register("tazurite_pillar",
			() -> new BlockItem(InitBlock.TAZURITE_PILLAR.get(), new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<BlockItem> TAZURITE_PILLAR_CAP = ITEMS.register("tazurite_pillar_cap",
			() -> new BlockItem(InitBlock.TAZURITE_PILLAR_CAP.get(),
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<BlockItem> MITHRIL_ORE = ITEMS.register("mithril_ore",
			() -> new BlockItem(InitBlock.MITHRIL_ORE.get(), new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<BlockItem> MITHRIL_BLOCK = ITEMS.register("mithril_block",
			() -> new BlockItem(InitBlock.MITHRIL_BLOCK.get(), new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<BlockItem> FUNNY_MITHRIL_BLOCK = ITEMS.register("funny_mithril",
			() -> new BlockItem(InitBlock.FUNNY_MITHRIL_BLOCK.get(),
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<BlockItem> ENGRAVED_MITHRIL_BLOCK = ITEMS.register("engraved_mithril",
			() -> new BlockItem(InitBlock.ENGRAVED_MITHRIL_BLOCK.get(),
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<BlockItem> TERRANITE = ITEMS.register("terranite",
			() -> new BlockItem(InitBlock.TERRANITE.get(), new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<BlockItem> TERRANITE_BLOCK = ITEMS.register("terranite_block",
			() -> new BlockItem(InitBlock.TERRANITE_BLOCK.get(), new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<BlockItem> TERRANITE_TILES = ITEMS.register("terranite_tiles",
			() -> new BlockItem(InitBlock.TERRANITE_TILES.get(), new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<BlockItem> GLISTENING_TERRANITE = ITEMS.register("glistening_terranite",
			() -> new BlockItem(InitBlock.GLISTENING_TERRANITE.get(),
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<BlockItem> TERRANITE_BRICKS = ITEMS.register("terranite_bricks",
			() -> new BlockItem(InitBlock.TERRANITE_BRICKS.get(),
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<BlockItem> STARCILIUM_ORE = ITEMS.register("starcilium_ore",
			() -> new BlockItem(InitBlock.STARCILIUM_ORE.get(), new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<BlockItem> STARCILIUM_BLOCK = ITEMS.register("starcilium_block",
			() -> new BlockItem(InitBlock.STARCILIUM_BLOCK.get(),
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));
	
	public static final RegistryObject<BlockItem> ETCHED_STARCILIUM_BLOCK = ITEMS.register("etched_starcilium_block",
			() -> new BlockItem(InitBlock.ETCHED_STARCILIUM_BLOCK.get(),
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<BlockItem> STARCILIUM_FACE_BLOCK = ITEMS.register("starcilium_face_block",
			() -> new BlockItem(InitBlock.STARCILIUM_FACE_BLOCK.get(),
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<BlockItem> XENOKSMIT_BLOCK = ITEMS.register("xenoksmit_block",
			() -> new BlockItem(InitBlock.XENOKSMIT_BLOCK.get(), new Item.Properties().isImmuneToFire().group(GeoSmelt.GEOSMELT_GROUP)));
	

	public static final RegistryObject<BlockItem> ETCHED_XENOKSMIT_BLOCK = ITEMS.register("etched_xenoksmit_block",
			() -> new BlockItem(InitBlock.ETCHED_XENOKSMIT_BLOCK.get(), new Item.Properties().isImmuneToFire().group(GeoSmelt.GEOSMELT_GROUP)));
	
	public static final RegistryObject<BlockItem> XENOKSMIT_FANCY_BLOCK = ITEMS.register("xenoksmit_fancy_block",
			() -> new BlockItem(InitBlock.XENOKSMIT_FANCY_BLOCK.get(), new Item.Properties().isImmuneToFire().group(GeoSmelt.GEOSMELT_GROUP)));

	
	
	
	public static final RegistryObject<BlockItem> ROUGH_DUSKROK = ITEMS.register("rough_duskrok",
			() -> new BlockItem(InitBlock.ROUGH_DUSKROK.get(), new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));
	
	public static final RegistryObject<BlockItem> DUSKROK = ITEMS.register("duskrok",
			() -> new BlockItem(InitBlock.DUSKROK.get(), new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<BlockItem> DUSKROK_BRICKS = ITEMS.register("duskrok_bricks",
			() -> new BlockItem(InitBlock.DUSKROK_BRICKS.get(), new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<BlockItem> DUSKROK_SMOOTH = ITEMS.register("smooth_duskrok",
			() -> new BlockItem(InitBlock.DUSKROK_SMOOTH.get(), new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<BlockItem> DUSKROK_CHISELED = ITEMS.register("chiseled_duskrok",
			() -> new BlockItem(InitBlock.DUSKROK_CHISELED.get(),
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<BlockItem> DUSKROK_PILLAR = ITEMS.register("duskrok_pillar",
			() -> new BlockItem(InitBlock.DUSKROK_PILLAR.get(), new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	// DAWNROK
	public static final RegistryObject<BlockItem> DAWNROK = ITEMS.register("dawnrok",
			() -> new BlockItem(InitBlock.DAWNROK.get(), new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<BlockItem> DAWNROK_BRICKS = ITEMS.register("dawnrok_bricks",
			() -> new BlockItem(InitBlock.DAWNROK_BRICKS.get(), new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<BlockItem> DAWNROK_SMOOTH = ITEMS.register("smooth_dawnrok",
			() -> new BlockItem(InitBlock.DAWNROK_SMOOTH.get(), new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<BlockItem> DAWNROK_CHISELED = ITEMS.register("chiseled_dawnrok",
			() -> new BlockItem(InitBlock.DAWNROK_CHISELED.get(),
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<BlockItem> DAWNROK_PILLAR = ITEMS.register("dawnrok_pillar",
			() -> new BlockItem(InitBlock.DAWNROK_PILLAR.get(), new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<BlockItem> DUSKROK_BRICKS_STAIRS = ITEMS.register("duskrok_bricks_stairs",
			() -> new BlockItem(InitBlock.DUSKROK_BRICKS_STAIRS.get(),
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<BlockItem> SMOOTH_DUSKROK_STAIRS = ITEMS.register("smooth_duskrok_stairs",
			() -> new BlockItem(InitBlock.SMOOTH_DUSKROK_STAIRS.get(),
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<BlockItem> DAWNROK_BRICKS_STAIRS = ITEMS.register("dawnrok_bricks_stairs",
			() -> new BlockItem(InitBlock.DAWNROK_BRICKS_STAIRS.get(),
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<BlockItem> DAWNROK_DUSKROK_STAIRS = ITEMS.register("smooth_dawnrok_stairs",
			() -> new BlockItem(InitBlock.SMOOTH_DAWNROK_STAIRS.get(),
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<BlockItem> TERRANITE_BRICKS_STAIRS = ITEMS.register("terranite_bricks_stairs",
			() -> new BlockItem(InitBlock.TERRANITE_BRICKS_STAIRS.get(),
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<BlockItem> TERRANITE_TILES_STAIRS = ITEMS.register("terranite_tiles_stairs",
			() -> new BlockItem(InitBlock.TERRANITE_TILES_STAIRS.get(),
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<BlockItem> TAZURITE_STAIRS = ITEMS.register("tazurite_stairs",
			() -> new BlockItem(InitBlock.TAZURITE_STAIRS.get(), new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<BlockItem> TAZURITE_BRICK_STAIRS = ITEMS.register("tazurite_brick_stairs",
			() -> new BlockItem(InitBlock.TAZURITE_BRICK_STAIRS.get(),
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<BlockItem> SMOOTH_TAZURITE_STAIRS = ITEMS.register("smooth_tazurite_stairs",
			() -> new BlockItem(InitBlock.SMOOTH_TAZURITE_STAIRS.get(),
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));
	
	public static final RegistryObject<BlockItem> DRAGONSCORCH_BRICKS_STAIRS = ITEMS.register("dragonscorch_bricks_stairs",
			() -> new BlockItem(InitBlock.DRAGONSCORCH_BRICKS_STAIRS.get(), new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));
	
	public static final RegistryObject<BlockItem> SMOOTH_DRAGONSCORCH_STAIRS = ITEMS.register("smooth_dragonscorch_stairs",
			() -> new BlockItem(InitBlock.SMOOTH_DRAGONSCORCH_STAIRS.get(), new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));
	

	public static final RegistryObject<BlockItem> DUSKROK_BRICKS_SLAB = ITEMS.register("duskrok_bricks_slab",
			() -> new BlockItem(InitBlock.DUSKROK_BRICKS_SLAB.get(),
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<BlockItem> SMOOTH_DUSKROK_SLAB = ITEMS.register("smooth_duskrok_slab",
			() -> new BlockItem(InitBlock.SMOOTH_DUSKROK_SLAB.get(),
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<BlockItem> DAWNROK_BRICKS_SLAB = ITEMS.register("dawnrok_bricks_slab",
			() -> new BlockItem(InitBlock.DAWNROK_BRICKS_SLAB.get(),
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<BlockItem> SMOOTH_DAWNROK_SLAB = ITEMS.register("smooth_dawnrok_slab",
			() -> new BlockItem(InitBlock.SMOOTH_DAWNROK_SLAB.get(),
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<BlockItem> TERRANITE_BRICKS_SLAB = ITEMS.register("terranite_bricks_slab",
			() -> new BlockItem(InitBlock.TERRANITE_BRICKS_SLAB.get(),
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<BlockItem> TERRANITE_TILES_SLAB = ITEMS.register("terranite_tiles_slab",
			() -> new BlockItem(InitBlock.TERRANITE_TILES_SLAB.get(),
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<BlockItem> TAZURITE_SLAB = ITEMS.register("tazurite_slab",
			() -> new BlockItem(InitBlock.TAZURITE_SLAB.get(), new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<BlockItem> TAZURITE_BRICKS_SLAB = ITEMS.register("tazurite_bricks_slab",
			() -> new BlockItem(InitBlock.TAZURITE_BRICKS_SLAB.get(),
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<BlockItem> SMOOTH_TAZURITE_SSLAB = ITEMS.register("smooth_tazurite_slab",
			() -> new BlockItem(InitBlock.SMOOTH_TAZURITE_SLAB.get(),
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));
	
	public static final RegistryObject<BlockItem> DRAGONSCORCH_BRICKS_SLAB = ITEMS.register("dragonscorch_bricks_slab",
			() -> new BlockItem(InitBlock.DRAGONSCORCH_BRICKS_SLAB.get(), new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));
	
	public static final RegistryObject<BlockItem> SMOOTH_DRAGONSCORCH_SLAB = ITEMS.register("smooth_dragonscorch_slab",
			() -> new BlockItem(InitBlock.SMOOTH_DRAGONSCORCH_SLAB.get(), new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));
	
	// Tarantula Pelt
		public static final RegistryObject<Item> TARANTULA_PELT = ITEMS.register("tarantula_pelt",
				() -> new Item(new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));
	
	// DragonCharge
	public static final RegistryObject<Item> DRAGON_CHARGE = ITEMS.register("dragon_charge",
			() -> new DragonChargeItem(new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	//Copper Scrap
	public static final RegistryObject<Item> COPPER_SCRAP = ITEMS.register("copper_scrap",
			() -> new Item(new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));
	
	
	// Jasper
	public static final RegistryObject<Item> JASPER_GEM = ITEMS.register("jasper",
			() -> new Item(new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	// TazuriteGem
	public static final RegistryObject<Item> TAZURITE_GEM = ITEMS.register("tazurite",
			() -> new Item(new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	// TerraniteChunk
	public static final RegistryObject<Item> TERRANITE_CHUNK = ITEMS.register("terranite_chunk",
			() -> new Item(new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	// Eaglesteel Ingot
	public static final RegistryObject<Item> EAGLESTEEL_INGOT = ITEMS.register("eaglesteel_ingot",
			() -> new Item(new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));
	
	// MithrilIngot
	public static final RegistryObject<Item> MITHRIL_INGOT = ITEMS.register("mithril_ingot",
			() -> new Item(new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	// StarciliumIngot
	public static final RegistryObject<Item> STARCILIUM_INGOT = ITEMS.register("starcilium_ingot",
			() -> new Item(new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	// XenoksmitIngot
	public static final RegistryObject<Item> XENOKSMIT_INGOT = ITEMS.register("xenoksmit_ingot",
			() -> new Item(new Item.Properties().isImmuneToFire().group(GeoSmelt.GEOSMELT_GROUP)));

	// StarciliumGeode
	public static final RegistryObject<Item> STARCILIUM_GEODE = ITEMS.register("starcilium_geode",
			() -> new Item(new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	// StarciliumNugget
	public static final RegistryObject<Item> STARCILIUM_NUGGET = ITEMS.register("starcilium_nugget",
			() -> new Item(new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	//Eaglesteel Nugget
			public static final RegistryObject<Item> EAGLESTEEL_NUGGET = ITEMS.register("eaglesteel_nugget",
					() -> new Item(new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));
			
	// MithrilNugget
	public static final RegistryObject<Item> MITHRIL_NUGGET = ITEMS.register("mithril_nugget",
			() -> new Item(new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	// XenoksmitNugget
	public static final RegistryObject<Item> XENOKSMIT_NUGGET = ITEMS.register("xenoksmit_nugget",
			() -> new Item(new Item.Properties().isImmuneToFire().group(GeoSmelt.GEOSMELT_GROUP)));

	// StarciliumDust
	public static final RegistryObject<Item> STARCILIUM_DUST = ITEMS.register("starcilium_dust",
			() -> new Item(new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	// MithrilDust
	public static final RegistryObject<Item> MITHRIL_DUST = ITEMS.register("mithril_dust",
			() -> new Item(new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	// Xenoksmit Dust
	public static final RegistryObject<Item> XENOKSMIT_DUST = ITEMS.register("xenoksmit_dust",
			() -> new Item(new Item.Properties().isImmuneToFire().group(GeoSmelt.GEOSMELT_GROUP)));

	// StarciliumRod
	public static final RegistryObject<Item> STARCILIUM_ROD = ITEMS.register("starcilium_rod",
			() -> new Item(new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));
	
	// MithrilRod
	public static final RegistryObject<Item> MITHRIL_ROD = ITEMS.register("mithril_rod",
			() -> new Item(new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	// StarciliumGear
	public static final RegistryObject<Item> STARCILIUM_GEAR = ITEMS.register("starcilium_gear",
			() -> new Item(new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	// InfinityShard
	public static final RegistryObject<Item> INFINITY_SHARD = ITEMS.register("infinity_shard",
			() -> new InfinityShardItem(new Item.Properties().isImmuneToFire().group(GeoSmelt.GEOSMELT_GROUP)));

	// InfinityPlate
	public static final RegistryObject<Item> INFINITY_PLATE = ITEMS.register("infinity_plate",
			() -> new InfinityPlateItem(new Item.Properties().isImmuneToFire().group(GeoSmelt.GEOSMELT_GROUP)));

	// StarciliumApple
	public static final RegistryObject<Item> STARCILIUM_APPLE = ITEMS.register("starcilium_apple",
			() -> new StarciliumAppleItem(new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)
					.food(new Food.Builder().hunger(1).saturation(1.0f)
							.effect(new EffectInstance(Effects.ABSORPTION, 1200, 1), 1.0f)
							.effect(new EffectInstance(Effects.REGENERATION, 1000, 1), 1.0f)
							.effect(new EffectInstance(Effects.SLOW_FALLING, 1250, 0), 1.0f).build())));
	
	
	
	
	//negative makes things slower
	//positive makes things faster
	
	
	
	//Eaglesteel Tools
	
	public static final RegistryObject<Item> EAGLESTEEL_SWORD = ITEMS.register("eaglesteel_sword",
			() -> new SwordItem(ModItemTier.EAGLESTEEL, 5, -2.4f,
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<Item> EAGLESTEEL_SHOVEL = ITEMS.register("eaglesteel_shovel",
			() -> new ShovelItem(ModItemTier.EAGLESTEEL, 3.5f, -2.7f,
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<Item> EAGLESTEEL_PICKAXE = ITEMS.register("eaglesteel_pickaxe",
			() -> new PickaxeItem(ModItemTier.EAGLESTEEL, 3, -2.6f,
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<Item> EAGLESTEEL_AXE = ITEMS.register("eaglesteel_axe",
			() -> new AxeItem(ModItemTier.EAGLESTEEL, 6, -2.8f, new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<Item> EAGLESTEEL_HOE = ITEMS.register("eaglesteel_hoe",
			() -> new HoeItem(ModItemTier.EAGLESTEEL, 2, -1.5f, new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));
	
	
	
	public static final RegistryObject<Item> HASTY_EAGLESTEEL_SWORD = ITEMS.register("hasty_eaglesteel_sword",
			() -> new HastySwordItem(ModItemTier.HASTY, 5, -2.4f,
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<Item> HASTY_EAGLESTEEL_SHOVEL = ITEMS.register("hasty_eaglesteel_shovel",
			() -> new HastyShovelItem(ModItemTier.HASTY, 3.5f, -2.7f,
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<Item> HASTY_EAGLESTEEL_PICKAXE = ITEMS.register("hasty_eaglesteel_pickaxe",
			() -> new HastyPickaxeItem(ModItemTier.HASTY, 3, -2.6f,
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<Item> HASTY_EAGLESTEEL_AXE = ITEMS.register("hasty_eaglesteel_axe",
			() -> new HastyAxeItem(ModItemTier.HASTY, 6, -2.8f, new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<Item> HASTY_EAGLESTEEL_HOE = ITEMS.register("hasty_eaglesteel_hoe",
			() -> new HastyHoeItem(ModItemTier.HASTY, 2, -1.5f, new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	
	
	//Copper Tools  
	
	public static final RegistryObject<Item> COPPER_SWORD = ITEMS.register("copper_sword",
			() -> new SwordItem(ModItemTier.COPPER, 4, -2.4f,
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<Item> COPPER_SHOVEL = ITEMS.register("copper_shovel",
			() -> new ShovelItem(ModItemTier.COPPER, 2.5f, -2.7f,
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<Item> COPPER_PICKAXE = ITEMS.register("copper_pickaxe",
			() -> new PickaxeItem(ModItemTier.COPPER, 2, -2.6f,
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<Item> COPPER_AXE = ITEMS.register("copper_axe",
			() -> new AxeItem(ModItemTier.COPPER, 5, -2.8f, new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<Item> COPPER_HOE = ITEMS.register("copper_hoe",
			() -> new HoeItem(ModItemTier.COPPER, 0, -1.5f, new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));
	
	
	// Starcilium Tools

	public static final RegistryObject<Item> STARCILIUM_SWORD = ITEMS.register("starcilium_sword",
			() -> new SwordItem(ModItemTier.STARCILIUM, 6, -1.2f,
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<Item> STARCILIUM_SHOVEL = ITEMS.register("starcilium_shovel",
			() -> new ShovelItem(ModItemTier.STARCILIUM, 3.5f, -1.0f,
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<Item> STARCILIUM_PICKAXE = ITEMS.register("starcilium_pickaxe",
			() -> new PickaxeItem(ModItemTier.STARCILIUM, 4, -1.2f,
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<Item> STARCILIUM_AXE = ITEMS.register("starcilium_axe",
			() -> new AxeItem(ModItemTier.STARCILIUM, 7, -2.5f, new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<Item> STARCILIUM_HOE = ITEMS.register("starcilium_hoe",
			() -> new HoeItem(ModItemTier.STARCILIUM, 3, -1.2f, new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	// Rarity Gear
	public static final RegistryObject<Item> XENOKSMIT_STORMBREAKER = ITEMS.register("xenoksmit_stormbreaker",
			() -> new StormbreakerItem(ModItemTier.XENOKSMIT, new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<Item> GALAXIUS_SWORD = ITEMS.register("galaxius",
			() -> new GalaxiusItem(ModItemTier.GALAXIUS, 13, -1.4f,
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<Item> TRI_SWORD = ITEMS.register("tri_sword",
			() -> new TriSwordItem(ModItemTier.GALAXIUS, 16, -2.8f,
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<Item> BANANA_BLADE = ITEMS.register("banana_blade",
			() -> new BananaBladeItem(ModItemTier.GALAXIUS, 8, -2.0f,
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<Item> EARTH_GLAIVE = ITEMS.register("earth_glaive",
			() -> new EarthGlaiveItem(ModItemTier.GALAXIUS, 9, -2.4f,
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));
	
	public static final RegistryObject<Item> HOLLOW_BLADE = ITEMS.register("hollow_blade",
			() -> new HollowBladeItem(ModItemTier.GALAXIUS, 11, -2.6f,
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<Item> MORNING_STAR = ITEMS.register("dark_morningstar",
			() -> new MorningStarItem(ModItemTier.DARK, new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<Item> GUMMER = ITEMS.register("gummer",
			() -> new GummerItem(ModItemTier.GUMMER, new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<Item> AQUASLASH = ITEMS.register("aquaslash",
			() -> new AquaSlashItem(ModItemTier.GALAXIUS, 7, -1.7f,
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<Item> CRYSTAL_ICE = ITEMS.register("crystal_ice",
			() -> new CrystalIceItem(ModItemTier.GALAXIUS, 7, -1.2f,
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<Item> VIRION_AXE = ITEMS.register("virion_axe",
			() -> new VirionAxeItem(ModItemTier.GALAXIUS, 7, -2.4f,
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));
		

	public static final RegistryObject<Item> DRAGON_STAFF = ITEMS.register("draconic_staff",
			() -> new HarmingStaffItem(ModItemTier.GALAXIUS, 4, -2.4f,
					new Item.Properties().maxStackSize(1).maxDamage(2425).group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<Item> HOLY_STAFF = ITEMS.register("holy_staff",
			() -> new HealingStaffItem(ModItemTier.GALAXIUS, 4, -2.4f,
					new Item.Properties().maxStackSize(1).maxDamage(2280).group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<Item> LESSER_FIRE_TOME = ITEMS.register("lesser_fire_tome",
			() -> new LesserFireTome(
					new Item.Properties().maxStackSize(1).maxDamage(2340).group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<Item> GREATER_FIRE_TOME = ITEMS.register("greater_fire_tome",
			() -> new GreaterFireTome(
					new Item.Properties().maxStackSize(1).maxDamage(3140).group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<Item> LESSER_WITHER_TOME = ITEMS.register("lesser_wither_tome",
			() -> new LesserWitherTome(
					new Item.Properties().maxStackSize(1).maxDamage(2340).group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<Item> GREATER_WITHER_TOME = ITEMS.register("greater_wither_tome",
			() -> new GreaterWitherTome(
					new Item.Properties().maxStackSize(1).maxDamage(3140).group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<Item> LESSER_ICE_TOME = ITEMS.register("lesser_ice_tome",
			() -> new LesserIceTome(
					new Item.Properties().maxStackSize(1).maxDamage(2340).group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<Item> GREATER_ICE_TOME = ITEMS.register("greater_ice_tome",
			() -> new GreaterIceTome(
					new Item.Properties().maxStackSize(1).maxDamage(3140).group(GeoSmelt.GEOSMELT_GROUP)));

	// Xenoksmit Armor
	public static final RegistryObject<Item> XENOKSMIT_HELMET = ITEMS.register("xenoksmit_helmet",
			() -> new ArmorItem(ModArmorMaterial.XENOKSMIT, EquipmentSlotType.HEAD,
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<Item> XENOKSMIT_CHESTPLATE = ITEMS.register("xenoksmit_chestplate",
			() -> new ArmorItem(ModArmorMaterial.XENOKSMIT, EquipmentSlotType.CHEST,
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<Item> XENOKSMIT_LEGGINGS = ITEMS.register("xenoksmit_leggings",
			() -> new ArmorItem(ModArmorMaterial.XENOKSMIT, EquipmentSlotType.LEGS,
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<Item> XENOKSMIT_BOOTS = ITEMS.register("xenoksmit_boots",
			() -> new ArmorItem(ModArmorMaterial.XENOKSMIT, EquipmentSlotType.FEET,
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));
	
	//Starcilium Armor
	public static final RegistryObject<Item> STARCILIUM_HELMET = ITEMS.register("starcilium_helmet",
			() -> new ArmorItem(ModArmorMaterial.STARCILIUM, EquipmentSlotType.HEAD,
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<Item> STARCILIUM_CHESTPLATE = ITEMS.register("starcilium_chestplate",
			() -> new ArmorItem(ModArmorMaterial.STARCILIUM, EquipmentSlotType.CHEST,
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<Item> STARCILIUM_LEGGINGS = ITEMS.register("starcilium_leggings",
			() -> new ArmorItem(ModArmorMaterial.STARCILIUM, EquipmentSlotType.LEGS,
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<Item> STARCILIUM_BOOTS = ITEMS.register("starcilium_boots",
			() -> new ArmorItem(ModArmorMaterial.STARCILIUM, EquipmentSlotType.FEET,
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));


	// Celestial Armor
	public static final RegistryObject<Item> CELESTIAL_HELMET = ITEMS.register("celestial_helmet",
			() -> new CelestialArmorItem(ModArmorMaterial.CELESTIAL, EquipmentSlotType.HEAD,
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<Item> CELESTIAL_CHESTPLATE = ITEMS.register("celestial_chestplate",
			() -> new CelestialArmorItem(ModArmorMaterial.CELESTIAL, EquipmentSlotType.CHEST,
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<Item> CELESTIAL_LEGGINGS = ITEMS.register("celestial_leggings",
			() -> new CelestialArmorItem(ModArmorMaterial.CELESTIAL, EquipmentSlotType.LEGS,
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	public static final RegistryObject<Item> CELESTIAL_BOOTS = ITEMS.register("celestial_boots",
			() -> new CelestialArmorItem(ModArmorMaterial.CELESTIAL, EquipmentSlotType.FEET,
					new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));

	//Spawn Eggs
		public static final RegistryObject<Item> ARMORED_SKELETON_SPAWN_EGG = ITEMS.register("armored_skeleton_spawn_egg",
				() -> new SpawnEggItem(GeoEntityRegistry.ARMORED_SKELETON, 0XF3F8F1, 0X595F56, new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));
	
		public static final RegistryObject<Item> OVERGROWN_SPAWN_EGG = ITEMS.register("overgrown_spawn_egg",
				() -> new SpawnEggItem(GeoEntityRegistry.OVERGROWN, 0X307A0A, 0XD5D9D3, new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));
		
		public static final RegistryObject<Item> SKELETON_SCRAPPER_SPAWN_EGG = ITEMS.register("skeleton_scrapper_spawn_egg",
				() -> new SpawnEggItem(GeoEntityRegistry.SKELETON_SCRAPPER, 0XF3F8F1, 0XF2A65D, new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));
		
		public static final RegistryObject<Item> SKELETON_SENTINEL_SPAWN_EGG = ITEMS.register("skeleton_sentinel_spawn_egg",
				() -> new SpawnEggItem(GeoEntityRegistry.SKELETON_SENTINEL, 0XF3F8F1, 0XC0C0C0, new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));
		
		public static final RegistryObject<Item> SKELETON_ELITE_SPAWN_EGG = ITEMS.register("skeleton_elite_spawn_egg",
				() -> new SpawnEggItem(GeoEntityRegistry.SKELETON_ELITE, 0XF3F8F1, 0X02A4D3, new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));
		
		public static final RegistryObject<Item> JUNGLE_TARANTULA_SPAWN_EGG = ITEMS.register("jungle_tarantula_spawn_egg",
				() -> new SpawnEggItem(GeoEntityRegistry.JUNGLE_TARANTULA, 0X3C4F3C, 0XC34C00, new Item.Properties().group(GeoSmelt.GEOSMELT_GROUP)));
	
}


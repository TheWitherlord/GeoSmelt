package com.witherlord00.geosmelt.geocore.init;

import com.witherlord00.geosmelt.GeoSmelt;
import com.witherlord00.geosmelt.geocommon.blocks.DwarvenFaceBlock;
import com.witherlord00.geosmelt.geocommon.blocks.GeoOreBlock;
import com.witherlord00.geosmelt.geocommon.blocks.StarciliumFaceBlock;
import com.witherlord00.geosmelt.geocommon.blocks.XenoksmitFancyBlock;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.OreBlock;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class InitBlock { 

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, GeoSmelt.MODID);
	
	
	//hardness: stone-1.5  ore-3  basalt-1.25  plant-1  sandstone-0.8  gravel-0.6  sand-0.5 iron-5
	
	
	//Blocks
	
	public static final RegistryObject<Block> GILDED_DWARVEN_PILLAR = BLOCKS.register("gilded_dwarven_pillar", () -> new RotatedPillarBlock (AbstractBlock.Properties.create(Material.ROCK, MaterialColor.YELLOW_TERRACOTTA)
			.hardnessAndResistance(3.2f, 7f)
			.harvestTool(ToolType.PICKAXE)
			.harvestLevel(0)
			.sound(SoundType.STONE)));
	
	
	public static final RegistryObject<Block> DWARVEN_PILLAR = BLOCKS.register("dwarven_pillar", () -> new RotatedPillarBlock (AbstractBlock.Properties.create(Material.ROCK, MaterialColor.YELLOW_TERRACOTTA)
			.hardnessAndResistance(3.2f, 6f)
			.harvestTool(ToolType.PICKAXE)
			.harvestLevel(0)
			.sound(SoundType.STONE)));
	
	
	public static final RegistryObject<Block> DWARVEN_TILE = BLOCKS.register("dwarven_tile", () -> new Block (AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GOLD)
			.hardnessAndResistance(3.2f, 7f)
			.harvestTool(ToolType.PICKAXE)
			.harvestLevel(0)
			.sound(SoundType.STONE)));
	
	
	
	public static final RegistryObject<Block> DWARVEN_FACE = BLOCKS.register("dwarven_face_block", () -> new DwarvenFaceBlock (AbstractBlock.Properties.create(Material.IRON, MaterialColor.GOLD)
			.hardnessAndResistance(3.2f, 7f)
			.harvestTool(ToolType.PICKAXE)
			.harvestLevel(0)
			.sound(SoundType.METAL)));
	
	
	public static final RegistryObject<Block> EAGLESTEEL_BLOCK = BLOCKS.register("eaglesteel_block", () -> new Block (AbstractBlock.Properties.create(Material.IRON, MaterialColor.GOLD)
			.hardnessAndResistance(3.2f, 7f)
			.harvestTool(ToolType.PICKAXE)
			.harvestLevel(0)
			.sound(SoundType.METAL)));
	
	
	
	
	public static final RegistryObject<Block> JASPILLITE = BLOCKS.register("jaspillite", () -> new GeoOreBlock (AbstractBlock.Properties.create(Material.ROCK, MaterialColor.RED_TERRACOTTA)
			.hardnessAndResistance(3.5f, 3f)
			.harvestTool(ToolType.PICKAXE)
			.harvestLevel(2)
			.sound(SoundType.GILDED_BLACKSTONE)));
	
	public static final RegistryObject<Block> JASPER_BLOCK = BLOCKS.register("jasper_block", () -> new Block (AbstractBlock.Properties.create(Material.ROCK, MaterialColor.RED_TERRACOTTA)
			.hardnessAndResistance(3.5f, 6f)
			.harvestTool(ToolType.PICKAXE)
			.harvestLevel(2)
			.sound(SoundType.STONE)));
	
	
	
	public static final RegistryObject<Block> DRAGONSCORCH_BLOCK = BLOCKS.register("dragonscorch", () -> new Block (AbstractBlock.Properties.create(Material.ROCK, MaterialColor.MAGENTA_TERRACOTTA)
			.hardnessAndResistance(5.5f, 1200f)
			.harvestTool(ToolType.PICKAXE)
			.harvestLevel(2)
			.sound(SoundType.BASALT)));
	
	public static final RegistryObject<Block> DRAGONSCORCH_BRICKS = BLOCKS.register("dragonscorch_bricks", () -> new Block (AbstractBlock.Properties.create(Material.ROCK, MaterialColor.MAGENTA_TERRACOTTA)
			.hardnessAndResistance(5.5f, 1200f)
			.harvestTool(ToolType.PICKAXE)
			.harvestLevel(2)
			.sound(SoundType.NETHER_BRICK)));
	
	public static final RegistryObject<Block> CHISELED_DRAGONSCORCH = BLOCKS.register("chiseled_dragonscorch", () -> new Block (AbstractBlock.Properties.create(Material.ROCK, MaterialColor.MAGENTA_TERRACOTTA)
			.hardnessAndResistance(5.5f, 1200f)
			.harvestTool(ToolType.PICKAXE)
			.harvestLevel(2)
			.sound(SoundType.BASALT)));
	
	public static final RegistryObject<Block> SMOOTH_DRAGONSCORCH_BLOCK = BLOCKS.register("smooth_dragonscorch", () -> new Block (AbstractBlock.Properties.create(Material.ROCK, MaterialColor.MAGENTA_TERRACOTTA)
			.hardnessAndResistance(5.5f, 1200f)
			.harvestTool(ToolType.PICKAXE)
			.harvestLevel(2)
			.sound(SoundType.BASALT)));
	
	
	public static final RegistryObject<Block> TAZURITE_ORE = BLOCKS.register("tazurite_ore", () -> new GeoOreBlock (AbstractBlock.Properties.create(Material.ROCK, MaterialColor.DIAMOND)
			.hardnessAndResistance(0.8f, 3f)
			.setLightLevel((value) -> {return 2;})
			.harvestTool(ToolType.SHOVEL)
			.sound(SoundType.SAND)));
	
	public static final RegistryObject<Block> TAZURITE_BLOCK = BLOCKS.register("tazurite_block", () -> new Block (AbstractBlock.Properties.create(Material.ROCK, MaterialColor.DIAMOND)
			.hardnessAndResistance(1.2f, 120f)
			.setLightLevel((value) -> {return 6;})
			.harvestTool(ToolType.PICKAXE)
			.harvestLevel(0)
			.setRequiresTool()
			.sound(SoundType.STONE)));
	
	public static final RegistryObject<Block> FANCY_TAZURITE_BLOCK = BLOCKS.register("fancy_tazurite_block", () -> new RotatedPillarBlock (AbstractBlock.Properties.create(Material.ROCK, MaterialColor.DIAMOND)
			.hardnessAndResistance(1.2f, 120f)
			.setLightLevel((value) -> {return 6;})
			.harvestTool(ToolType.PICKAXE)
			.harvestLevel(0)
			.setRequiresTool()
			.sound(SoundType.STONE)));
	
	public static final RegistryObject<Block> TAZURITE_SMOOTH_BLOCK = BLOCKS.register("smooth_tazurite_block", () -> new Block (AbstractBlock.Properties.create(Material.ROCK, MaterialColor.DIAMOND)
			.hardnessAndResistance(1.2f, 120f)
			.setLightLevel((value) -> {return 6;})
			.harvestTool(ToolType.PICKAXE)
			.harvestLevel(0)
			.setRequiresTool()
			.sound(SoundType.STONE)));
	
	public static final RegistryObject<Block> TAZURITE_DOOR = BLOCKS.register("tazurite_door", () -> new DoorBlock (AbstractBlock.Properties.create(Material.ROCK, MaterialColor.DIAMOND)
			.hardnessAndResistance(1.2f, 120f)
			.setLightLevel((value) -> {return 6;})
			.harvestTool(ToolType.PICKAXE)
			.harvestLevel(0)
			.setRequiresTool()
			.sound(SoundType.STONE)));
	
	public static final RegistryObject<Block> TAZURITE_BRICKS = BLOCKS.register("tazurite_bricks", () -> new Block (AbstractBlock.Properties.create(Material.ROCK, MaterialColor.DIAMOND)
			.hardnessAndResistance(1.2f, 120f)
			.setLightLevel((value) -> {return 6;})
			.harvestTool(ToolType.PICKAXE)
			.harvestLevel(0)
			.setRequiresTool()
			.sound(SoundType.STONE)));
	
	public static final RegistryObject<Block> CHISELED_TAZURITE_BRICKS = BLOCKS.register("chiseled_tazurite_bricks", () -> new Block (AbstractBlock.Properties.create(Material.ROCK, MaterialColor.DIAMOND)
			.hardnessAndResistance(1.2f, 120f)
			.setLightLevel((value) -> {return 6;})
			.harvestTool(ToolType.PICKAXE)
			.harvestLevel(0)
			.setRequiresTool()
			.sound(SoundType.STONE)));
	
	public static final RegistryObject<Block> TAZURITE_TILES = BLOCKS.register("tazurite_tiles", () -> new Block (AbstractBlock.Properties.create(Material.ROCK, MaterialColor.DIAMOND)
			.hardnessAndResistance(1.2f, 120f)
			.setLightLevel((value) -> {return 6;})
			.harvestTool(ToolType.PICKAXE)
			.harvestLevel(0)
			.setRequiresTool()
			.sound(SoundType.STONE)));
	
	public static final RegistryObject<Block> TAZURITE_PILLAR = BLOCKS.register("tazurite_pillar", () -> new RotatedPillarBlock (AbstractBlock.Properties.create(Material.ROCK, MaterialColor.DIAMOND)
			.hardnessAndResistance(1.2f, 120f)
			.setLightLevel((value) -> {return 6;})
			.harvestTool(ToolType.PICKAXE)
			.harvestLevel(0)
			.setRequiresTool()
			.sound(SoundType.STONE)));
	
	public static final RegistryObject<Block> TAZURITE_PILLAR_CAP = BLOCKS.register("tazurite_pillar_cap", () -> new RotatedPillarBlock (AbstractBlock.Properties.create(Material.ROCK, MaterialColor.DIAMOND)
			.hardnessAndResistance(1.2f, 120f)
			.setLightLevel((value) -> {return 6;})
			.harvestTool(ToolType.PICKAXE)
			.harvestLevel(0)
			.setRequiresTool()
			.sound(SoundType.STONE)));
	
	
	public static final RegistryObject<Block> TERRANITE = BLOCKS.register("terranite", () -> new GeoOreBlock (AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GREEN)
			.hardnessAndResistance(3f, 3f)
			.harvestTool(ToolType.PICKAXE)
			.harvestLevel(0)
			.setRequiresTool()
			.sound(SoundType.STONE)));
	
	public static final RegistryObject<Block> TERRANITE_BLOCK = BLOCKS.register("terranite_block", () -> new Block (AbstractBlock.Properties.create(Material.IRON, MaterialColor.GREEN)
			.hardnessAndResistance(1.5f, 6f)
			.harvestTool(ToolType.PICKAXE)
			.harvestLevel(0)
			.setRequiresTool()
			.sound(SoundType.STONE)));
	
	public static final RegistryObject<Block> TERRANITE_TILES = BLOCKS.register("terranite_tiles", () -> new Block (AbstractBlock.Properties.create(Material.IRON, MaterialColor.GREEN)
			.hardnessAndResistance(1.5f, 6f)
			.harvestTool(ToolType.PICKAXE)
			.harvestLevel(0)
			.setRequiresTool()
			.sound(SoundType.STONE)));
	
	public static final RegistryObject<Block> GLISTENING_TERRANITE = BLOCKS.register("glistening_terranite", () -> new Block (AbstractBlock.Properties.create(Material.IRON, MaterialColor.YELLOW)
			.hardnessAndResistance(1.5f, 6.5f).
			setLightLevel((value) -> {return 10;})
			.harvestTool(ToolType.PICKAXE)
			.harvestLevel(0)
			.setRequiresTool()
			.sound(SoundType.STONE)));	
	

	
	public static final RegistryObject<Block> TERRANITE_BRICKS = BLOCKS.register("terranite_bricks", () -> new Block (AbstractBlock.Properties.create(Material.IRON, MaterialColor.GREEN)
			.hardnessAndResistance(1.5f, 6f)
			.harvestTool(ToolType.PICKAXE)
			.harvestLevel(0)
			.setRequiresTool()
			.sound(SoundType.STONE)));
	
	
	public static final RegistryObject<Block> MITHRIL_ORE = BLOCKS.register("mithril_ore", () -> new RotatedPillarBlock (AbstractBlock.Properties.create(Material.ROCK, MaterialColor.LIGHT_BLUE)
			.hardnessAndResistance(1.25f, 4.5f)
			.harvestTool(ToolType.PICKAXE)
			.harvestLevel(2)
			.setRequiresTool()
			.sound(SoundType.BASALT)));

	
	public static final RegistryObject<Block> MITHRIL_BLOCK = BLOCKS.register("mithril_block", () -> new Block (AbstractBlock.Properties.create(Material.IRON, MaterialColor.LIGHT_BLUE)
			.hardnessAndResistance(5f, 8f)
			.harvestTool(ToolType.PICKAXE)
			.harvestLevel(2)
			.setRequiresTool()
			.sound(SoundType.METAL)));

	public static final RegistryObject<Block> FUNNY_MITHRIL_BLOCK = BLOCKS.register("funny_mithril", () -> new Block (AbstractBlock.Properties.create(Material.IRON, MaterialColor.LIGHT_BLUE)
			.hardnessAndResistance(5f, 8f)
			.harvestTool(ToolType.PICKAXE)
			.harvestLevel(2)
			.setRequiresTool()
			.sound(SoundType.METAL)));

	public static final RegistryObject<Block> ENGRAVED_MITHRIL_BLOCK = BLOCKS.register("engraved_mithril", () -> new Block (AbstractBlock.Properties.create(Material.IRON, MaterialColor.LIGHT_BLUE)
			.hardnessAndResistance(5f, 8f)
			.harvestTool(ToolType.PICKAXE)
			.harvestLevel(2)
			.setRequiresTool()
			.sound(SoundType.METAL)));
	
	
	
	public static final RegistryObject<Block> STARCILIUM_ORE = BLOCKS.register("starcilium_ore", () -> new GeoOreBlock (AbstractBlock.Properties.create(Material.ROCK, MaterialColor.PURPLE)
	.hardnessAndResistance(3.2f, 1200f)
	.harvestTool(ToolType.PICKAXE)
	.harvestLevel(4)
	.setRequiresTool()
	.sound(SoundType.STONE)));
		
	
	public static final RegistryObject<Block> STARCILIUM_BLOCK = BLOCKS.register("starcilium_block", () -> new Block (AbstractBlock.Properties.create(Material.IRON, MaterialColor.PURPLE)
	.hardnessAndResistance(7.8f, 1200f)
	.harvestTool(ToolType.PICKAXE)
	.harvestLevel(4)
	.setRequiresTool()
	.sound(SoundType.NETHERITE)));
	
	
	public static final RegistryObject<Block> ETCHED_STARCILIUM_BLOCK = BLOCKS.register("etched_starcilium_block", () -> new XenoksmitFancyBlock (AbstractBlock.Properties.create(Material.IRON, MaterialColor.PURPLE)
			.hardnessAndResistance(7.8f, 1200f)
			.harvestTool(ToolType.PICKAXE)
			.harvestLevel(4)
			.setRequiresTool()
			.sound(SoundType.NETHERITE)));
	
	public static final RegistryObject<Block> STARCILIUM_FACE_BLOCK = BLOCKS.register("starcilium_face_block", () -> new StarciliumFaceBlock (AbstractBlock.Properties.create(Material.IRON, MaterialColor.PURPLE)
			.hardnessAndResistance(7.8f, 1200f)
			.harvestTool(ToolType.PICKAXE)
			.harvestLevel(4)
			.setRequiresTool()
			.sound(SoundType.NETHERITE)));
	
	
	public static final RegistryObject<Block> XENOKSMIT_BLOCK = BLOCKS.register("xenoksmit_block", () -> new Block (AbstractBlock.Properties.create(Material.IRON, MaterialColor.PURPLE)
			.hardnessAndResistance(6.5f, 1200f)
			.harvestTool(ToolType.PICKAXE)
			.harvestLevel(4)
			.setRequiresTool()
			.sound(SoundType.NETHERITE)));
	
	
	public static final RegistryObject<Block> ETCHED_XENOKSMIT_BLOCK = BLOCKS.register("etched_xenoksmit_block", () -> new XenoksmitFancyBlock (AbstractBlock.Properties.create(Material.IRON, MaterialColor.PURPLE)
			.hardnessAndResistance(6.5f, 1200f)
			.harvestTool(ToolType.PICKAXE)
			.harvestLevel(4)
			.setRequiresTool()
			.sound(SoundType.NETHERITE)));
			
	public static final RegistryObject<Block> XENOKSMIT_FANCY_BLOCK = BLOCKS.register("xenoksmit_fancy_block", () -> new XenoksmitFancyBlock (AbstractBlock.Properties.create(Material.IRON, MaterialColor.PURPLE)
			.hardnessAndResistance(6.5f, 1200f)
			.harvestTool(ToolType.PICKAXE)
			.harvestLevel(4)
			.setRequiresTool()
			.sound(SoundType.NETHERITE)));
	
	
	public static final RegistryObject<Block> ROUGH_DUSKROK = BLOCKS.register("rough_duskrok", () -> new Block (AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLUE)
			.hardnessAndResistance(2.5f, 1200f).
			harvestTool(ToolType.PICKAXE)
			.harvestLevel(3)			
			.setRequiresTool()
			.sound(SoundType.BASALT)));
	
	public static final RegistryObject<Block> DUSKROK = BLOCKS.register("duskrok", () -> new Block (AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLUE)
			.hardnessAndResistance(2.5f, 1200f).
			harvestTool(ToolType.PICKAXE)
			.harvestLevel(3)			
			.setRequiresTool()
			.sound(SoundType.BASALT)));
			
	public static final RegistryObject<Block> DUSKROK_BRICKS = BLOCKS.register("duskrok_bricks", () -> new Block (AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLUE)
			.hardnessAndResistance(2.5f, 1200f).
			harvestTool(ToolType.PICKAXE)
			.harvestLevel(3)		
			.setRequiresTool()
			.sound(SoundType.STONE)));
	
	public static final RegistryObject<Block> DUSKROK_SMOOTH = BLOCKS.register("smooth_duskrok", () -> new Block (AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLUE)
			.hardnessAndResistance(2.5f, 1200f).
			harvestTool(ToolType.PICKAXE)
			.harvestLevel(3)			
			.setRequiresTool()
			.sound(SoundType.BASALT)));
	
	public static final RegistryObject<Block> DUSKROK_CHISELED = BLOCKS.register("chiseled_duskrok", () -> new Block (AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLUE)
			.hardnessAndResistance(2.5f, 1200f).
			harvestTool(ToolType.PICKAXE)
			.harvestLevel(3)	
			.setRequiresTool()
			.sound(SoundType.BASALT)));
	
	public static final RegistryObject<Block> DUSKROK_PILLAR = BLOCKS.register("duskrok_pillar", () -> new RotatedPillarBlock (AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLUE)
			.hardnessAndResistance(2.5f, 1200f).
			harvestTool(ToolType.PICKAXE)
			.harvestLevel(3)	
			.setRequiresTool()
			.sound(SoundType.BASALT)));
	
	//DAWNROK
	public static final RegistryObject<Block> DAWNROK = BLOCKS.register("dawnrok", () -> new Block (AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GOLD)
			.hardnessAndResistance(0.8f, 1200f).
			setLightLevel((value) -> {return 12;}).
			harvestTool(ToolType.PICKAXE)
			.harvestLevel(3)
			.setRequiresTool()
			.sound(SoundType.BASALT)));
	
	public static final RegistryObject<Block> DAWNROK_BRICKS = BLOCKS.register("dawnrok_bricks", () -> new Block (AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GOLD)
			.hardnessAndResistance(0.8f, 1200f).
			setLightLevel((value) -> {return 12;}).
			harvestTool(ToolType.PICKAXE)
			.harvestLevel(3)
			.setRequiresTool()
			.sound(SoundType.STONE)));
	
	public static final RegistryObject<Block> DAWNROK_SMOOTH = BLOCKS.register("smooth_dawnrok", () -> new Block (AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GOLD)
			.hardnessAndResistance(0.8f, 1200f).
			setLightLevel((value) -> {return 12;}).
			harvestTool(ToolType.PICKAXE)
			.harvestLevel(3)
			.setRequiresTool()
			.sound(SoundType.BASALT)));
	
	public static final RegistryObject<Block> DAWNROK_CHISELED = BLOCKS.register("chiseled_dawnrok", () -> new Block (AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GOLD)
			.hardnessAndResistance(0.8f, 1200f).
			setLightLevel((value) -> {return 12;}).
			harvestTool(ToolType.PICKAXE)
			.harvestLevel(3)	
			.setRequiresTool()
			.sound(SoundType.BASALT)));
	
	public static final RegistryObject<Block> DAWNROK_PILLAR = BLOCKS.register("dawnrok_pillar", () -> new RotatedPillarBlock (AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GOLD)
			.hardnessAndResistance(0.8f, 1200f).
			setLightLevel((value) -> {return 12;}).
			harvestTool(ToolType.PICKAXE)
			.harvestLevel(3)			
			.setRequiresTool()
			.sound(SoundType.BASALT)));
		
	
	//STAIRS
    public static final RegistryObject<StairsBlock> DUSKROK_BRICKS_STAIRS = BLOCKS.register("duskrok_bricks_stairs", () -> new StairsBlock(() -> InitBlock.DUSKROK_BRICKS.get().getDefaultState(), AbstractBlock.Properties.from(InitBlock.DUSKROK_BRICKS.get()).notSolid()));
    
    public static final RegistryObject<StairsBlock> SMOOTH_DUSKROK_STAIRS = BLOCKS.register("smooth_duskrok_stairs", () -> new StairsBlock(() -> InitBlock.DUSKROK_SMOOTH.get().getDefaultState(), AbstractBlock.Properties.from(InitBlock.DUSKROK_SMOOTH.get()).notSolid()));

  public static final RegistryObject<StairsBlock> DAWNROK_BRICKS_STAIRS = BLOCKS.register("dawnrok_bricks_stairs", () -> new StairsBlock(() -> InitBlock.DAWNROK_BRICKS.get().getDefaultState(), AbstractBlock.Properties.from(InitBlock.DAWNROK_BRICKS.get()).notSolid()));
    
    public static final RegistryObject<StairsBlock> SMOOTH_DAWNROK_STAIRS = BLOCKS.register("smooth_dawnrok_stairs", () -> new StairsBlock(() -> InitBlock.DAWNROK_SMOOTH.get().getDefaultState(), AbstractBlock.Properties.from(InitBlock.DAWNROK_SMOOTH.get()).notSolid()));

    public static final RegistryObject<StairsBlock> TERRANITE_BRICKS_STAIRS = BLOCKS.register("terranite_bricks_stairs", () -> new StairsBlock(() -> InitBlock.TERRANITE_BRICKS.get().getDefaultState(), AbstractBlock.Properties.from(InitBlock.TERRANITE_BRICKS.get()).notSolid()));

    public static final RegistryObject<StairsBlock> TERRANITE_TILES_STAIRS = BLOCKS.register("terranite_tiles_stairs", () -> new StairsBlock(() -> InitBlock.TERRANITE_TILES.get().getDefaultState(), AbstractBlock.Properties.from(InitBlock.TERRANITE_TILES.get()).notSolid()));

    public static final RegistryObject<StairsBlock> TAZURITE_STAIRS = BLOCKS.register("tazurite_stairs", () -> new StairsBlock(() -> InitBlock.TAZURITE_BLOCK.get().getDefaultState(), AbstractBlock.Properties.from(InitBlock.TAZURITE_BLOCK.get()).notSolid()));
    public static final RegistryObject<StairsBlock> TAZURITE_BRICK_STAIRS = BLOCKS.register("tazurite_brick_stairs", () -> new StairsBlock(() -> InitBlock.TAZURITE_BRICKS.get().getDefaultState(), AbstractBlock.Properties.from(InitBlock.TAZURITE_BRICKS.get()).notSolid()));
    public static final RegistryObject<StairsBlock> SMOOTH_TAZURITE_STAIRS = BLOCKS.register("smooth_tazurite_stairs", () -> new StairsBlock(() -> InitBlock.TAZURITE_SMOOTH_BLOCK.get().getDefaultState(), AbstractBlock.Properties.from(InitBlock.TAZURITE_SMOOTH_BLOCK.get()).notSolid()));

 public static final RegistryObject<StairsBlock> DRAGONSCORCH_BRICKS_STAIRS = BLOCKS.register("dragonscorch_bricks_stairs", () -> new StairsBlock(() -> InitBlock.DRAGONSCORCH_BRICKS.get().getDefaultState(), AbstractBlock.Properties.from(InitBlock.DRAGONSCORCH_BRICKS.get()).notSolid()));
    
    public static final RegistryObject<StairsBlock> SMOOTH_DRAGONSCORCH_STAIRS = BLOCKS.register("smooth_dragonscorch_stairs", () -> new StairsBlock(() -> InitBlock.SMOOTH_DRAGONSCORCH_BLOCK.get().getDefaultState(), AbstractBlock.Properties.from(InitBlock.SMOOTH_DRAGONSCORCH_BLOCK.get()).notSolid()));

    
    
    //SLABS
    
    public static final RegistryObject<Block> DUSKROK_BRICKS_SLAB = BLOCKS.register("duskrok_bricks_slab", () -> new SlabBlock (AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLUE)
    		.hardnessAndResistance(2.5f, 1200f).
			harvestTool(ToolType.PICKAXE)
			.harvestLevel(3)		
			.setRequiresTool()
			.sound(SoundType.STONE)));
	
	public static final RegistryObject<Block> SMOOTH_DUSKROK_SLAB = BLOCKS.register("smooth_duskrok_slab", () -> new SlabBlock (AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLUE)
			.hardnessAndResistance(2.5f, 1200f).
			harvestTool(ToolType.PICKAXE)
			.harvestLevel(3)		
			.setRequiresTool()
			.sound(SoundType.BASALT)));
	
	public static final RegistryObject<Block> DAWNROK_BRICKS_SLAB = BLOCKS.register("dawnrok_bricks_slab", () -> new SlabBlock (AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GOLD)
			.hardnessAndResistance(0.8f, 1200f).
			setLightLevel((value) -> {return 12;}).
			harvestTool(ToolType.PICKAXE)
			.harvestLevel(3)
			.setRequiresTool()
			.sound(SoundType.BASALT)));
	
	public static final RegistryObject<Block> SMOOTH_DAWNROK_SLAB = BLOCKS.register("smooth_dawnrok_slab", () -> new SlabBlock (AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GOLD)
			.hardnessAndResistance(0.8f, 1200f).
			setLightLevel((value) -> {return 12;}).
			harvestTool(ToolType.PICKAXE)
			.harvestLevel(3)
			.setRequiresTool()
			.sound(SoundType.BASALT)));
	
	public static final RegistryObject<Block> TERRANITE_BRICKS_SLAB = BLOCKS.register("terranite_bricks_slab", () -> new SlabBlock (AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GREEN)
			.hardnessAndResistance(1.5f, 6f)
			.harvestTool(ToolType.PICKAXE)
			.harvestLevel(0)
			.setRequiresTool()
			.sound(SoundType.STONE)));
	
	public static final RegistryObject<Block> TERRANITE_TILES_SLAB = BLOCKS.register("terranite_tiles_slab", () -> new SlabBlock (AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GREEN)
			.hardnessAndResistance(1.5f, 6f)
			.harvestTool(ToolType.PICKAXE)
			.harvestLevel(0)
			.setRequiresTool()
			.sound(SoundType.METAL)));
	
		
	public static final RegistryObject<Block> TAZURITE_SLAB = BLOCKS.register("tazurite_slab", () -> new SlabBlock (AbstractBlock.Properties.create(Material.ROCK, MaterialColor.DIAMOND)
			.hardnessAndResistance(1.2f, 6f)
			.setLightLevel((value) -> {return 5;})
			.harvestTool(ToolType.PICKAXE)
			.harvestLevel(0)
			.setRequiresTool()
			.sound(SoundType.STONE)));
	
	public static final RegistryObject<Block> TAZURITE_BRICKS_SLAB = BLOCKS.register("tazurite_bricks_slab", () -> new SlabBlock (AbstractBlock.Properties.create(Material.ROCK, MaterialColor.DIAMOND)
			.hardnessAndResistance(1.2f, 6f)
			.setLightLevel((value) -> {return 5;})
			.harvestTool(ToolType.PICKAXE)
			.harvestLevel(0)
			.setRequiresTool()
			.sound(SoundType.STONE)));
	
	
	public static final RegistryObject<Block> SMOOTH_TAZURITE_SLAB = BLOCKS.register("smooth_tazurite_slab", () -> new SlabBlock (AbstractBlock.Properties.create(Material.ROCK, MaterialColor.DIAMOND)
			.hardnessAndResistance(1.2f, 6f)
			.setLightLevel((value) -> {return 5;})
			.harvestTool(ToolType.PICKAXE)
			.harvestLevel(0)
			.setRequiresTool()
			.sound(SoundType.STONE)));

	public static final RegistryObject<Block> DRAGONSCORCH_BRICKS_SLAB = BLOCKS.register("dragonscorch_bricks_slab", () -> new SlabBlock (AbstractBlock.Properties.create(Material.ROCK, MaterialColor.MAGENTA_TERRACOTTA)
			.hardnessAndResistance(5.5f, 1200f)
			.harvestTool(ToolType.PICKAXE)
			.harvestLevel(2)
			.sound(SoundType.NETHER_BRICK)));

	
	public static final RegistryObject<Block> SMOOTH_DRAGONSCORCH_SLAB = BLOCKS.register("smooth_dragonscorch_slab", () -> new SlabBlock (AbstractBlock.Properties.create(Material.ROCK, MaterialColor.MAGENTA_TERRACOTTA)
			.hardnessAndResistance(5.5f, 1200f)
			.harvestTool(ToolType.PICKAXE)
			.harvestLevel(2)
			.sound(SoundType.BASALT)));

    
}

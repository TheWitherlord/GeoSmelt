package com.witherlord00.geosmelt;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraftforge.fml.config.ModConfig;

import com.witherlord00.geosmelt.events.LootTableHandler;
import com.witherlord00.geosmelt.geoclient.util.OnCelestialArmorTick;
import com.witherlord00.geosmelt.geocore.config.GeoConfig;
import com.witherlord00.geosmelt.geocore.init.GeoEntityRegistry;
import com.witherlord00.geosmelt.geocore.init.InitBlock;
import com.witherlord00.geosmelt.geocore.init.InitItem;
import com.witherlord00.geosmelt.geoworld.ModEntitySpawns;
import com.witherlord00.geosmelt.geoworld.WorldGenOre;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


@Mod(GeoSmelt.MODID)
public class GeoSmelt {
	
	public static final Logger LOGGER = LogManager.getLogger();
   public static final String MODID = "geosmelt";
	public static final ItemGroup GEOSMELT_GROUP = new GeoSmeltGroup("geosmeltgroup");

	
	public GeoSmelt() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, GeoConfig.COMMON_SPEC);
		bus.addListener(this::setup);
		InitItem.ITEMS.register(bus);
		InitBlock.BLOCKS.register(bus);
		ModEntitySpawns.registerSpawns();
		bus.addGenericListener(GlobalLootModifierSerializer.class, LootTableHandler::registerGlobalModifiers);
        MinecraftForge.EVENT_BUS.register(new OnCelestialArmorTick());


		MinecraftForge.EVENT_BUS.register(this);
	}

	private void setup(final FMLCommonSetupEvent event) {
		// some preinit code
		LOGGER.info("Preinitialized");
		
    	WorldGenOre.registerOres();

		}
		public static class GeoSmeltGroup extends ItemGroup {

			public GeoSmeltGroup(String label) {
				super(label);
			}

			@Override
			public ItemStack createIcon() {
				return InitItem.GALAXIUS_SWORD.get().getDefaultInstance();
			
		
	}

		}}	



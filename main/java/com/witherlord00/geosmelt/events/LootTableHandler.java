package com.witherlord00.geosmelt.events;

import com.witherlord00.geosmelt.GeoSmelt;

import net.minecraft.loot.LootEntry;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.TableLootEntry;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber
public class LootTableHandler {

	 public static void registerGlobalModifiers(RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {
	        
	    }
	
	 private static <T extends GlobalLootModifierSerializer<?>> void register(String name, T serializer) {
	        serializer.setRegistryName(new ResourceLocation(GeoSmelt.MODID, name));
	        ForgeRegistries.LOOT_MODIFIER_SERIALIZERS.register(serializer);
	    }
	
    @SubscribeEvent
    public static void onLootTableLoad(LootTableLoadEvent event) {
        String prefix = "minecraft:chests/";
        String name = event.getName().toString();

        if (name.startsWith(prefix)) {
            String file = name.substring(name.indexOf(prefix) + prefix.length());
            switch (file) {
                case "bastion_treasure":
                case "end_city_treasure":
                case "buried_treasure":
                case "igloo_chest":
                case "jungle_temple":
                case "woodland_mansion": event.getTable().addPool(getInjectPool(file)); break;
                default: break;
            }
        }

        if (name.equals("minecraft:entities/wither")) {
            event.getTable().addPool(getInjectPool("wither"));
        } else if (name.equals("minecraft:entities/ender_dragon")) {
            event.getTable().addPool(getInjectPool("ender_dragon"));
        }
       
    }

    private static LootPool getInjectPool(String entryName) {
        return LootPool.builder()
                .addEntry(getInjectEntry(entryName, 1))
                .bonusRolls(0, 3)
                .name("geosmelt_inject")
                .build();
    }

    private static LootEntry.Builder getInjectEntry(String name, int weight) {
        ResourceLocation table = new ResourceLocation(GeoSmelt.MODID, "inject/" + name);
        return TableLootEntry.builder(table).weight(weight);
    }
}
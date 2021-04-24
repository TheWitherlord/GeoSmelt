package com.witherlord00.geosmelt.geocore.init;

import java.lang.reflect.Field;
import java.util.Random;
import java.util.function.Predicate;

import com.witherlord00.geosmelt.GeoSmelt;
import com.witherlord00.geosmelt.geocommon.entities.ArmoredSkeletonEntity;
import com.witherlord00.geosmelt.geocommon.entities.BigSnowballEntity;
import com.witherlord00.geosmelt.geocommon.entities.GreaterWitherSkullEntity;
import com.witherlord00.geosmelt.geocommon.entities.HolyOrbEntity;
import com.witherlord00.geosmelt.geocommon.entities.IceBallEntity;
import com.witherlord00.geosmelt.geocommon.entities.JungleTarantulaEntity;
import com.witherlord00.geosmelt.geocommon.entities.OvergrownEntity;
import com.witherlord00.geosmelt.geocommon.entities.SkeletonEliteEntity;
import com.witherlord00.geosmelt.geocommon.entities.SkeletonScrapperEntity;
import com.witherlord00.geosmelt.geocommon.entities.SkeletonSentinelEntity;
import com.witherlord00.geosmelt.geocommon.entities.SmallDragonFireballEntity;
import com.witherlord00.geosmelt.geocommon.entities.StarciliumGolemEntity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.tags.ITag;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GeoSmelt.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GeoEntityRegistry {
 
   
    public static final EntityType<SmallDragonFireballEntity> SMALL_DRAGON_FIREBALL = registerEntity(EntityType.Builder.create(SmallDragonFireballEntity::new, EntityClassification.MISC).size(0.95F, 0.65F).setCustomClientFactory(SmallDragonFireballEntity::new).immuneToFire(), "small_dragon_fireball");

    public static final EntityType<HolyOrbEntity> HOLY_ORB = registerEntity(EntityType.Builder.create(HolyOrbEntity::new, EntityClassification.MISC).size(0.95F, 0.65F).setCustomClientFactory(HolyOrbEntity::new).immuneToFire(), "holy_orb");

    public static final EntityType<GreaterWitherSkullEntity> GREATER_WITHER_SKULL = registerEntity(EntityType.Builder.create(GreaterWitherSkullEntity::new, EntityClassification.MISC).size(0.95F, 0.65F).setCustomClientFactory(GreaterWitherSkullEntity::new).immuneToFire(), "greater_wither_skull");

    public static final EntityType<IceBallEntity> ICE_BALL = registerEntity(EntityType.Builder.create(IceBallEntity::new, EntityClassification.MISC).size(0.95F, 0.65F).setCustomClientFactory(IceBallEntity::new).immuneToFire(), "ice_ball");

    public static final EntityType<BigSnowballEntity> BIG_SNOWBALL = registerEntity(EntityType.Builder.create(BigSnowballEntity::new, EntityClassification.MISC).size(0.95F, 0.65F).setCustomClientFactory(BigSnowballEntity::new).immuneToFire(), "big_snow_ball");

    public static final EntityType<StarciliumGolemEntity> STARCILIUM_GOLEM = registerEntity(EntityType.Builder.create(StarciliumGolemEntity::new, EntityClassification.CREATURE).size(1.4F, 2.7F), "starcilium_golem");

    public static final EntityType<ArmoredSkeletonEntity> ARMORED_SKELETON = registerEntity(EntityType.Builder.create(ArmoredSkeletonEntity::new, EntityClassification.MONSTER).size(0.6F, 1.99F), "armored_skeleton");

    public static final EntityType<OvergrownEntity> OVERGROWN = registerEntity(EntityType.Builder.create(OvergrownEntity::new, EntityClassification.MONSTER).size(0.6F, 1.99F), "overgrown");

    public static final EntityType<SkeletonScrapperEntity> SKELETON_SCRAPPER = registerEntity(EntityType.Builder.create(SkeletonScrapperEntity::new, EntityClassification.MONSTER).size(0.6F, 1.99F), "skeleton_scrapper");

    public static final EntityType<SkeletonSentinelEntity> SKELETON_SENTINEL = registerEntity(EntityType.Builder.create(SkeletonSentinelEntity::new, EntityClassification.MONSTER).size(1.2F, 2.1F), "skeleton_sentinel");

    public static final EntityType<SkeletonEliteEntity> SKELETON_ELITE = registerEntity(EntityType.Builder.create(SkeletonEliteEntity::new, EntityClassification.MONSTER).size(1.2F, 2.1F), "skeleton_elite");
    
    public static final EntityType<JungleTarantulaEntity> JUNGLE_TARANTULA = registerEntity(EntityType.Builder.create(JungleTarantulaEntity::new, EntityClassification.MONSTER).size(2.4F, 1.3F), "jungle_tarantula");

    
    
    private static final EntityType registerEntity(EntityType.Builder builder, String entityName) {
        ResourceLocation nameLoc = new ResourceLocation(GeoSmelt.MODID, entityName);
        return (EntityType) builder.build(entityName).setRegistryName(nameLoc);
    }

   

    

        @SubscribeEvent
    public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) {
        try {
            for (Field f : GeoEntityRegistry.class.getDeclaredFields()) {
                Object obj = f.get(null);
                if (obj instanceof EntityType) {
                    event.getRegistry().register((EntityType) obj);
                } else if (obj instanceof EntityType[]) {
                    for (EntityType type : (EntityType[]) obj) {
                        event.getRegistry().register(type);
                    }
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        initializeAttributes();
    }

    private static void initializeAttributes() {
      
        GlobalEntityTypeAttributes.put(STARCILIUM_GOLEM, StarciliumGolemEntity.registerAttributes().create());
        GlobalEntityTypeAttributes.put(ARMORED_SKELETON, ArmoredSkeletonEntity.registerAttributes().create());
        GlobalEntityTypeAttributes.put(OVERGROWN, OvergrownEntity.registerAttributes().create());
        GlobalEntityTypeAttributes.put(SKELETON_SCRAPPER, SkeletonScrapperEntity.registerAttributes().create());
        GlobalEntityTypeAttributes.put(SKELETON_SENTINEL, SkeletonSentinelEntity.registerAttributes().create());
        GlobalEntityTypeAttributes.put(SKELETON_ELITE, SkeletonEliteEntity.registerAttributes().create());
        GlobalEntityTypeAttributes.put(JUNGLE_TARANTULA, JungleTarantulaEntity.registerAttributes().create());


    }

    public static Predicate<LivingEntity> buildPredicateFromTag(ITag entityTag){
        return (com.google.common.base.Predicate<LivingEntity>) e -> e.isAlive() && e.getType().isContained(entityTag);
    }

   

     
    }


    

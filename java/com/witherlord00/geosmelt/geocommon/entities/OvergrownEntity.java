package com.witherlord00.geosmelt.geocommon.entities;

import java.util.Random;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

public class OvergrownEntity extends AbstractSkeletonEntity { 
   public OvergrownEntity(EntityType<? extends OvergrownEntity> p_i50191_1_, World p_i50191_2_) {
      super(p_i50191_1_, p_i50191_2_);
   }

   public static boolean func_223327_b(EntityType<OvergrownEntity> p_223327_0_, IServerWorld p_223327_1_, SpawnReason reason, BlockPos p_223327_3_, Random p_223327_4_) {
      return canMonsterSpawnInLight(p_223327_0_, p_223327_1_, reason, p_223327_3_, p_223327_4_) && (reason == SpawnReason.SPAWNER || p_223327_1_.canSeeSky(p_223327_3_));
   }

   public static AttributeModifierMap.MutableAttribute registerAttributes() {
		return MonsterEntity.registerAttributes().createMutableAttribute(Attributes.MAX_HEALTH, 20.0D)
		.createMutableAttribute(Attributes.ARMOR, 2.0D)
		.createMutableAttribute(Attributes.FOLLOW_RANGE, 8.0D)
		.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25D);
   }
   
   
   protected SoundEvent getAmbientSound() {
      return SoundEvents.ENTITY_SKELETON_AMBIENT;
   }

   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
      return SoundEvents.ENTITY_SKELETON_HURT;
   }

   protected SoundEvent getDeathSound() {
      return SoundEvents.ENTITY_SKELETON_DEATH;
   }

   protected SoundEvent getStepSound() {
      return SoundEvents.ENTITY_SKELETON_STEP;
   }
   /**
    * Fires an arrow
    */
   protected AbstractArrowEntity fireArrow(ItemStack arrowStack, float distanceFactor) {
      AbstractArrowEntity abstractarrowentity = super.fireArrow(arrowStack, distanceFactor);
      if (abstractarrowentity instanceof ArrowEntity) {
         ((ArrowEntity)abstractarrowentity).addEffect(new EffectInstance(Effects.POISON, 400));
      }

      return abstractarrowentity;
   }
}

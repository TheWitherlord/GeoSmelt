package com.witherlord00.geosmelt.geocommon.entities;

import java.util.Random;

import javax.annotation.Nullable;

import com.witherlord00.geosmelt.geocore.init.InitItem;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

public class SkeletonSentinelEntity extends AbstractSkeletonEntity{ 

	public SkeletonSentinelEntity(EntityType<? extends SkeletonSentinelEntity> p_i50191_1_, World p_i50191_2_) {
	      super(p_i50191_1_, p_i50191_2_);
	   
	   }
	
	public static boolean func_223327_b(EntityType<SkeletonSentinelEntity> p_223327_0_, IServerWorld p_223327_1_, SpawnReason reason, BlockPos p_223327_3_, Random p_223327_4_) {
	      return canMonsterSpawnInLight(p_223327_0_, p_223327_1_, reason, p_223327_3_, p_223327_4_) && (reason == SpawnReason.SPAWNER || p_223327_1_.canSeeSky(p_223327_3_));
	}
	      public static AttributeModifierMap.MutableAttribute registerAttributes() {
	  		return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, 30.0D)
	  		.createMutableAttribute(Attributes.FOLLOW_RANGE, 28.0D)
	  		.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 0.6D)
	  		.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.17D);

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
	    * Gives armor or weapon for entity based on given DifficultyInstance
	    */
	   protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
	      this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack (InitItem.EAGLESTEEL_AXE.get()));
	      this.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack (Items.SHIELD));
	         this.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(Items.IRON_HELMET));
	         this.setItemStackToSlot(EquipmentSlotType.CHEST, new ItemStack(Items.IRON_CHESTPLATE));
	         this.setItemStackToSlot(EquipmentSlotType.LEGS, new ItemStack(Items.IRON_LEGGINGS));
	         this.setItemStackToSlot(EquipmentSlotType.FEET, new ItemStack(Items.IRON_BOOTS));

	   }

	   /**
	    * Enchants Entity's current equipments based on given DifficultyInstance
	    */
	   protected void setEnchantmentBasedOnDifficulty(DifficultyInstance difficulty) {
	   }

	   @Nullable
	   public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
	      ILivingEntityData ilivingentitydata = super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	      this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(7.0D);
	      this.setCombatTask();
	      return ilivingentitydata;
	      
	      
	   }

	  

	   /**
	    * Fires an arrow
	    */
	   protected AbstractArrowEntity fireArrow(ItemStack arrowStack, float distanceFactor) {
	      AbstractArrowEntity abstractarrowentity = super.fireArrow(arrowStack, distanceFactor);
	      abstractarrowentity.setFire(100);
	      return abstractarrowentity;
	   }

}

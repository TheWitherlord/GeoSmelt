package com.witherlord00.geosmelt.geocommon.entities;

import java.util.Random;

import javax.annotation.Nullable;

import com.witherlord00.geosmelt.geocore.init.InitItem;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.monster.WitherSkeletonEntity;
import net.minecraft.entity.monster.piglin.AbstractPiglinEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

public class ArmoredSkeletonEntity extends AbstractSkeletonEntity{ 

	public ArmoredSkeletonEntity(EntityType<? extends ArmoredSkeletonEntity> typeIn, World worldIn) {
	      super(typeIn, worldIn);
	   
	   }
	
	public static boolean func_223327_b(EntityType<ArmoredSkeletonEntity> p_223327_0_, IServerWorld p_223327_1_, SpawnReason reason, BlockPos p_223327_3_, Random p_223327_4_) {
	      return canMonsterSpawnInLight(p_223327_0_, p_223327_1_, reason, p_223327_3_, p_223327_4_) && (reason == SpawnReason.SPAWNER || p_223327_1_.canSeeSky(p_223327_3_));
	
		

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
	      this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack (InitItem.COPPER_SWORD.get()));
	         this.setItemStackToSlot(EquipmentSlotType.CHEST, new ItemStack(Items.CHAINMAIL_CHESTPLATE));
	         this.setItemStackToSlot(EquipmentSlotType.FEET, new ItemStack(Items.CHAINMAIL_BOOTS));

	   }

	   /**
	    * Enchants Entity's current equipments based on given DifficultyInstance
	    */
	   protected void setEnchantmentBasedOnDifficulty(DifficultyInstance difficulty) {
	   }

	   @Nullable
	   public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
	      ILivingEntityData ilivingentitydata = super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	      this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(5.0D);
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

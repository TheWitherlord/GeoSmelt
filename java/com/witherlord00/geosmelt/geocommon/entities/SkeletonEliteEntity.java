package com.witherlord00.geosmelt.geocommon.entities;

import java.util.Random;

import javax.annotation.Nullable;

import com.witherlord00.geosmelt.geocore.init.InitItem;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.villager.VillagerType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.ClimberPathNavigator;
import net.minecraft.pathfinding.GroundPathNavigator;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.util.DamageSource;
import net.minecraft.util.GroundPathHelper;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BossInfo;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

public class SkeletonEliteEntity extends AbstractSkeletonEntity{ 

	private static final DataParameter<Byte> CLIMBING = EntityDataManager.createKey(SkeletonEliteEntity.class,
			DataSerializers.BYTE);
	
	public SkeletonEliteEntity(EntityType<? extends SkeletonEliteEntity> p_i50191_1_, World p_i50191_2_) {
	      super(p_i50191_1_, p_i50191_2_);
	     
	   }
	
	public static boolean func_223327_b(EntityType<SkeletonEliteEntity> p_223327_0_, IServerWorld p_223327_1_, SpawnReason reason, BlockPos p_223327_3_, Random p_223327_4_) {
	      return canMonsterSpawnInLight(p_223327_0_, p_223327_1_, reason, p_223327_3_, p_223327_4_) && (reason == SpawnReason.SPAWNER || p_223327_1_.canSeeSky(p_223327_3_));
	}
	      public static AttributeModifierMap.MutableAttribute registerAttributes() {
	  		return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, 35.0D)
	  		.createMutableAttribute(Attributes.FOLLOW_RANGE, 60.0D)
	  		.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 0.8D)
	  		.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.24D);



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
	      this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack (Items.BOW));
	      this.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack (Items.TOTEM_OF_UNDYING));
	      this.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack (Items.DIAMOND_HELMET));
	      this.setItemStackToSlot(EquipmentSlotType.CHEST, new ItemStack (Items.DIAMOND_CHESTPLATE));
	      this.setItemStackToSlot(EquipmentSlotType.LEGS, new ItemStack (Items.DIAMOND_LEGGINGS));
	      this.setItemStackToSlot(EquipmentSlotType.FEET, new ItemStack (Items.DIAMOND_BOOTS));


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

		protected PathNavigator createNavigator(World worldIn) {
			return new ClimberPathNavigator(this, worldIn);
		}

		protected void registerData() {
			super.registerData();
			this.dataManager.register(CLIMBING, (byte) 0);
		}

		/**
		 * Called to update the entity's position/logic.
		 */
		public void tick() {
			super.tick();
			if (!this.world.isRemote) {
				this.setBesideClimbableBlock(this.collidedHorizontally);
			}
		}

		public boolean isOnLadder() {
			return this.isBesideClimbableBlock();
		}

		public boolean isBesideClimbableBlock() {
			return (this.dataManager.get(CLIMBING) & 1) != 0;
		}

		public void setBesideClimbableBlock(boolean climbing) {
			byte b0 = this.dataManager.get(CLIMBING);
			if (climbing) {
				b0 = (byte) (b0 | 1);
			} else {
				b0 = (byte) (b0 & -2);
			}

			this.dataManager.set(CLIMBING, b0);
		}

		/**
		 * Fires an arrow
		 */
		protected AbstractArrowEntity fireArrow(ItemStack arrowStack, float distanceFactor) {
			AbstractArrowEntity abstractarrowentity = super.fireArrow(arrowStack, distanceFactor);
			abstractarrowentity.setFire(10);
			abstractarrowentity.setDamage(5);
			return abstractarrowentity;
		}
		
		public boolean isNonBoss() {
		      return false;
		   }
		}

	

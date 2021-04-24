package com.witherlord00.geosmelt.geocommon.entities;

import java.util.List;

import com.witherlord00.geosmelt.geocore.init.GeoEntityRegistry;

import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractFireballEntity;
import net.minecraft.network.IPacket;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.network.NetworkHooks;

public class GreaterWitherSkullEntity extends AbstractFireballEntity {  

	public int ticksInAir;

	public GreaterWitherSkullEntity(EntityType t, World worldIn) {
		super(t, worldIn);
	}

	public GreaterWitherSkullEntity(FMLPlayMessages.SpawnEntity spawnEntity, World worldIn) {
		this(GeoEntityRegistry.GREATER_WITHER_SKULL, worldIn);
	}

	public GreaterWitherSkullEntity(EntityType t, World worldIn, double posX, double posY, double posZ, double accelX,
			double accelY, double accelZ) {
		super(t, posX, posY, posZ, accelX, accelY, accelZ, worldIn);
		double d0 = MathHelper.sqrt(accelX * accelX + accelY * accelY + accelZ * accelZ);
		this.accelerationX = accelX / d0 * 0.04D;
		this.accelerationY = accelY / d0 * 0.04D;
		this.accelerationZ = accelZ / d0 * 0.04D;
	}

	public GreaterWitherSkullEntity(EntityType t, World worldIn, PlayerEntity shooter, double accelX, double accelY,
			double accelZ) {
		super(t, shooter, accelX, accelY, accelZ, worldIn);
		double d0 = MathHelper.sqrt(accelX * accelX + accelY * accelY + accelZ * accelZ);
		this.accelerationX = accelX / d0 * 0.04D;
		this.accelerationY = accelY / d0 * 0.04D;
		this.accelerationZ = accelZ / d0 * 0.04D;
	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	protected boolean isFireballFiery() {
		return false;
	}

	 protected IParticleData getParticle() {
	      return ParticleTypes.LARGE_SMOKE;
	   }
	
	@Override
	public boolean canBeCollidedWith() {
		return false;
	}

	protected void onImpact(RayTraceResult result) {
	      super.onImpact(result);
	      if (!this.world.isRemote) {
	         Explosion.Mode explosion$mode = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.world, this.func_234616_v_()) ? Explosion.Mode.DESTROY : Explosion.Mode.NONE;
	         this.world.createExplosion(this, this.getPosX(), this.getPosY(), this.getPosZ(), 2.0F, false, explosion$mode);
	         this.remove();
	      }

	   }

	protected void onEntityHit(EntityRayTraceResult p_213868_1_) {
	      super.onEntityHit(p_213868_1_);
	      Entity entity = p_213868_1_.getEntity();
	      entity.attackEntityFrom(DamageSource.causeIndirectMagicDamage(this, entity), 7.0F);
	            ((LivingEntity)entity).addPotionEffect(new EffectInstance(Effects.WITHER, 85, 2));
			}

		
	}


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
import net.minecraft.world.World;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.network.NetworkHooks;

public class BigSnowballEntity extends AbstractFireballEntity {

	public int ticksInAir;

	public BigSnowballEntity(EntityType t, World worldIn) {
		super(t, worldIn);

	}

	public BigSnowballEntity(FMLPlayMessages.SpawnEntity spawnEntity, World worldIn) {
		this(GeoEntityRegistry.BIG_SNOWBALL, worldIn);
	}

	public BigSnowballEntity(EntityType t, World worldIn, double posX, double posY, double posZ, double accelX,
			double accelY, double accelZ) {
		super(t, posX, posY, posZ, accelX, accelY, accelZ, worldIn);
		double d0 = MathHelper.sqrt(accelX * accelX + accelY * accelY + accelZ * accelZ);
		this.accelerationX = accelX / d0 * 0.09D;
		this.accelerationY = accelY / d0 * 0.09D;
		this.accelerationZ = accelZ / d0 * 0.09D;
	}

	public BigSnowballEntity(EntityType t, World worldIn, PlayerEntity shooter, double accelX, double accelY,
			double accelZ) {
		super(t, shooter, accelX, accelY, accelZ, worldIn);
		double d0 = MathHelper.sqrt(accelX * accelX + accelY * accelY + accelZ * accelZ);
		this.accelerationX = accelX / d0 * 0.09D;
		this.accelerationY = accelY / d0 * 0.09D;
		this.accelerationZ = accelZ / d0 * 0.09D;
	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	protected boolean isFireballFiery() {
		return false;
	}
	
	 protected IParticleData getParticle() {
	      return ParticleTypes.CLOUD;
	   }


	@Override
	public boolean canBeCollidedWith() {
		return false;
	}

	protected void onImpact(RayTraceResult result) {
		super.onImpact(result);
		Entity entity = this.func_234616_v_();
		if (result.getType() != RayTraceResult.Type.ENTITY
				|| !((EntityRayTraceResult) result).getEntity().isEntityEqual(entity)) {
			if (!this.world.isRemote) {
				List<LivingEntity> list = this.world.getEntitiesWithinAABB(LivingEntity.class,
						this.getBoundingBox().grow(4.0D, 2.0D, 4.0D));
				AreaEffectCloudEntity areaeffectcloudentity = new AreaEffectCloudEntity(this.world, this.getPosX(),
						this.getPosY(), this.getPosZ());
				if (entity instanceof LivingEntity) {
					areaeffectcloudentity.setOwner((LivingEntity) entity);
				}

				areaeffectcloudentity.setParticleData(ParticleTypes.ITEM_SNOWBALL);
				areaeffectcloudentity.setRadius(4.0F);
				areaeffectcloudentity.setDuration(85);
				areaeffectcloudentity.setRadiusPerTick(
						(1.0F - areaeffectcloudentity.getRadius()) / (float) areaeffectcloudentity.getDuration());
				areaeffectcloudentity.addEffect(new EffectInstance(Effects.SLOWNESS, 85, 0));
				if (!list.isEmpty()) {
					for (LivingEntity livingentity : list) {
						double d0 = this.getDistanceSq(livingentity);
						if (d0 < 16.0D) {
							areaeffectcloudentity.setPosition(livingentity.getPosX(), livingentity.getPosY(),
									livingentity.getPosZ());
							break;
						}
					}
				}

				this.world.playEvent(2006, this.getPosition(), this.isSilent() ? -1 : 1);
				this.world.addEntity(areaeffectcloudentity);
				this.remove();
			}
		}
	}

	protected void onEntityHit(EntityRayTraceResult p_213868_1_) {
		super.onEntityHit(p_213868_1_);
		Entity entity = p_213868_1_.getEntity();
		entity.attackEntityFrom(DamageSource.causeIndirectMagicDamage(this, entity), 8.0F);
		((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, 85, 2));

	}

}

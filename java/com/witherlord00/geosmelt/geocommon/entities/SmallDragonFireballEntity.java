package com.witherlord00.geosmelt.geocommon.entities;

import java.util.List;

import com.witherlord00.geosmelt.geocore.init.GeoEntityRegistry;

import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractFireballEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.network.NetworkHooks;

public class SmallDragonFireballEntity extends AbstractFireballEntity {

	public int ticksInAir;

	public SmallDragonFireballEntity(EntityType t, World worldIn) {
		super(t, worldIn);
	}

	public SmallDragonFireballEntity(FMLPlayMessages.SpawnEntity spawnEntity, World worldIn) {
		this(GeoEntityRegistry.SMALL_DRAGON_FIREBALL, worldIn);
	}

	public SmallDragonFireballEntity(EntityType t, World worldIn, double posX, double posY, double posZ, double accelX,
			double accelY, double accelZ) {
		super(t, posX, posY, posZ, accelX, accelY, accelZ, worldIn);
		double d0 = MathHelper.sqrt(accelX * accelX + accelY * accelY + accelZ * accelZ);
		this.accelerationX = accelX / d0 * 0.07D;
		this.accelerationY = accelY / d0 * 0.07D;
		this.accelerationZ = accelZ / d0 * 0.07D;
	}

	public SmallDragonFireballEntity(EntityType t, World worldIn, PlayerEntity shooter, double accelX, double accelY,
			double accelZ) {
		super(t, shooter, accelX, accelY, accelZ, worldIn);
		double d0 = MathHelper.sqrt(accelX * accelX + accelY * accelY + accelZ * accelZ);
		this.accelerationX = accelX / d0 * 0.07D;
		this.accelerationY = accelY / d0 * 0.07D;
		this.accelerationZ = accelZ / d0 * 0.07D;
	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	protected boolean isFireballFiery() {
		return false;
	}

	@Override
	public boolean canBeCollidedWith() {
		return true;
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
				areaeffectcloudentity.setParticleData(ParticleTypes.DRAGON_BREATH);
				areaeffectcloudentity.setRadius(2.0F);
				areaeffectcloudentity.setDuration(55);
				areaeffectcloudentity.setRadiusPerTick(
						(2.0F - areaeffectcloudentity.getRadius()) / (float) areaeffectcloudentity.getDuration());
				areaeffectcloudentity.addEffect(new EffectInstance(Effects.INSTANT_DAMAGE, 0, 0));
				areaeffectcloudentity.addEffect(new EffectInstance(Effects.SLOWNESS, 25, 0));

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
		entity.attackEntityFrom(DamageSource.causeIndirectMagicDamage(this, entity), 4.0F);
	}
}

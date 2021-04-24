package com.witherlord00.geosmelt.geocommon.entities;

import java.util.List;

import com.witherlord00.geosmelt.geocore.init.GeoEntityRegistry;

import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.BlazeEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractFireballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.network.NetworkHooks;

public class IceBallEntity extends AbstractFireballEntity {

	public int ticksInAir;

	public IceBallEntity(EntityType t, World worldIn) {
		super(t, worldIn);

	}

	public IceBallEntity(FMLPlayMessages.SpawnEntity spawnEntity, World worldIn) {
		this(GeoEntityRegistry.ICE_BALL, worldIn);
	}

	public IceBallEntity(EntityType t, World worldIn, double posX, double posY, double posZ, double accelX,
			double accelY, double accelZ) {
		super(t, posX, posY, posZ, accelX, accelY, accelZ, worldIn);
		double d0 = MathHelper.sqrt(accelX * accelX + accelY * accelY + accelZ * accelZ);
		this.accelerationX = accelX / d0 * 0.09D;
		this.accelerationY = accelY / d0 * 0.08D;
		this.accelerationZ = accelZ / d0 * 0.08D;
	}

	public IceBallEntity(EntityType t, World worldIn, PlayerEntity shooter, double accelX, double accelY,
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
	      return ParticleTypes.ITEM_SNOWBALL;
	   }
	
	@Override
	public boolean canBeCollidedWith() {
		return false;
	}

	protected void onImpact(RayTraceResult result) {
	      super.onImpact(result);
	      if (!this.world.isRemote) {
	         this.world.setEntityState(this, (byte)3);
	         this.remove();
	      }
	
	}
	protected void onEntityHit(EntityRayTraceResult p_213868_1_) {
		super.onEntityHit(p_213868_1_);
		Entity entity = p_213868_1_.getEntity();
		entity.attackEntityFrom(DamageSource.causeIndirectMagicDamage(this, entity), 2.0F);
		((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, 85, 1));

	}

}

package com.witherlord00.geosmelt.geocommon.entities;

import javax.annotation.Nullable;

import com.witherlord00.geosmelt.geocore.init.GeoEntityRegistry;

import net.minecraft.entity.BoostHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IEquipable;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.IRideable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.TransportationHelper;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

public class JungleTarantulaEntity extends SpiderEntity implements IRideable, IEquipable { 

	private static final DataParameter<Boolean> SADDLED = EntityDataManager.createKey(JungleTarantulaEntity.class,
			DataSerializers.BOOLEAN);
	private static final DataParameter<Integer> BOOST_TIME = EntityDataManager.createKey(JungleTarantulaEntity.class,
			DataSerializers.VARINT);
	private final BoostHelper field_234214_bx_ = new BoostHelper(this.dataManager, BOOST_TIME, SADDLED);
	private static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(Items.APPLE, Items.SWEET_BERRIES);

	public JungleTarantulaEntity(EntityType<? extends JungleTarantulaEntity> type, World worldIn) {
		super(type, worldIn);
	}

	public double getMountedYOffset() {
		return (double) (this.getHeight() * 0.8F);
	}

	public boolean canDespawn(double distanceToClosestPlayer) {
		return false;
	}

	public static AttributeModifierMap.MutableAttribute registerAttributes() {
		return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, 20.0D)
				.createMutableAttribute(Attributes.ATTACK_DAMAGE, 6.0D)
				.createMutableAttribute(Attributes.FOLLOW_RANGE, 12.0D)
				.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.4D);

	}

	public boolean attackEntityAsMob(Entity entityIn) {
		if (super.attackEntityAsMob(entityIn)) {
			if (entityIn instanceof LivingEntity) {
				int i = 0;
				if (this.world.getDifficulty() == Difficulty.EASY) {
					i = 2;
				}
				if (this.world.getDifficulty() == Difficulty.NORMAL) {
					i = 7;
				} else if (this.world.getDifficulty() == Difficulty.HARD) {
					i = 15;
				}

				if (i > 0) {
					((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.POISON, i * 20, 1));
					((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.SLOWNESS, i * 20, 1));

				}
			}

			return true;
		} else {
			return false;
		}
	}

	@Nullable
	public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason,
			@Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
		spawnDataIn = super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
		if (worldIn.getRandom().nextInt(100) == 0) {
			OvergrownEntity skeletonentity = GeoEntityRegistry.OVERGROWN.create(this.world);
			skeletonentity.setLocationAndAngles(this.getPosX(), this.getPosY(), this.getPosZ(), this.rotationYaw, 0.0F);
			skeletonentity.onInitialSpawn(worldIn, difficultyIn, reason, (ILivingEntityData) null, (CompoundNBT) null);
			skeletonentity.startRiding(this);
		}

		if (spawnDataIn == null) {
			spawnDataIn = new JungleTarantulaEntity.GroupData();
			if (worldIn.getDifficulty() == Difficulty.HARD
					&& worldIn.getRandom().nextFloat() < 0.2F * difficultyIn.getClampedAdditionalDifficulty()) {
				((JungleTarantulaEntity.GroupData) spawnDataIn).setRandomEffect(worldIn.getRandom());
			}
		}

		if (spawnDataIn instanceof JungleTarantulaEntity.GroupData) {
			Effect effect = ((JungleTarantulaEntity.GroupData) spawnDataIn).effect;
			if (effect != null) {
				this.addPotionEffect(new EffectInstance(effect, Integer.MAX_VALUE));
			}
		}

		return spawnDataIn;
	}

	@Nullable
	public Entity getControllingPassenger() {
		return this.getPassengers().isEmpty() ? null : this.getPassengers().get(0);
	}

	/**
	 * returns true if all the conditions for steering the entity are met. For pigs,
	 * this is true if it is being ridden by a player and the player is holding a
	 * carrot-on-a-stick
	 */
	public boolean canBeSteered() {
		Entity entity = this.getControllingPassenger();
		if (!(entity instanceof PlayerEntity)) {
		}
		return true;

	}

	public void notifyDataManagerChange(DataParameter<?> key) {
		if (BOOST_TIME.equals(key) && this.world.isRemote) {
			this.field_234214_bx_.updateData();
		}

		super.notifyDataManagerChange(key);
	}

	protected void registerData() {
		super.registerData();
		this.dataManager.register(SADDLED, false);
		this.dataManager.register(BOOST_TIME, 0);
	}

	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		this.field_234214_bx_.setSaddledToNBT(compound);
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.field_234214_bx_.setSaddledFromNBT(compound);
	}

	public ActionResultType func_230254_b_(PlayerEntity p_230254_1_, Hand p_230254_2_) {
		boolean flag = this.isBreedingItem(p_230254_1_.getHeldItem(p_230254_2_));
		if (!flag && this.isHorseSaddled() && !this.isBeingRidden() && !p_230254_1_.isSecondaryUseActive()) {
			if (!this.world.isRemote) {
				p_230254_1_.startRiding(this);
			}

			return ActionResultType.func_233537_a_(this.world.isRemote);
		} else {
			ActionResultType actionresulttype = super.func_230254_b_(p_230254_1_, p_230254_2_);
			if (!actionresulttype.isSuccessOrConsume()) {
				ItemStack itemstack = p_230254_1_.getHeldItem(p_230254_2_);
				return itemstack.getItem() == Items.SADDLE
						? itemstack.interactWithEntity(p_230254_1_, this, p_230254_2_)
						: ActionResultType.PASS;
			} else {
				return actionresulttype;
			}
		}
	}

	public boolean func_230264_L__() {
		return this.isAlive() && !this.isChild();
	}

	protected void dropInventory() {
		super.dropInventory();
		if (this.isHorseSaddled()) {
			this.entityDropItem(Items.SADDLE);
		}

	}

	public boolean isHorseSaddled() {
		return this.field_234214_bx_.getSaddled();
	}

	public void func_230266_a_(@Nullable SoundCategory p_230266_1_) {
		this.field_234214_bx_.setSaddledFromBoolean(true);
		if (p_230266_1_ != null) {
			this.world.playMovingSound((PlayerEntity) null, this, SoundEvents.ENTITY_PIG_SADDLE, p_230266_1_, 0.5F,
					1.0F);
		}

	}

	public Vector3d func_230268_c_(LivingEntity livingEntity) {
		Direction direction = this.getAdjustedHorizontalFacing();
		if (direction.getAxis() == Direction.Axis.Y) {
			return super.func_230268_c_(livingEntity);
		} else {
			int[][] aint = TransportationHelper.func_234632_a_(direction);
			BlockPos blockpos = this.getPosition();
			BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

			for (Pose pose : livingEntity.getAvailablePoses()) {
				AxisAlignedBB axisalignedbb = livingEntity.getPoseAABB(pose);

				for (int[] aint1 : aint) {
					blockpos$mutable.setPos(blockpos.getX() + aint1[0], blockpos.getY(), blockpos.getZ() + aint1[1]);
					double d0 = this.world.func_242403_h(blockpos$mutable);
					if (TransportationHelper.func_234630_a_(d0)) {
						Vector3d vector3d = Vector3d.copyCenteredWithVerticalOffset(blockpos$mutable, d0);
						if (TransportationHelper.func_234631_a_(this.world, livingEntity,
								axisalignedbb.offset(vector3d))) {
							livingEntity.setPose(pose);
							return vector3d;
						}
					}
				}
			}

			return super.func_230268_c_(livingEntity);
		}
	}

	public void travel(Vector3d travelVector) {
		this.ride(this, this.field_234214_bx_, travelVector);
	}

	public float getMountedSpeed() {
		return (float) this.getAttributeValue(Attributes.MOVEMENT_SPEED) * 0.5F;
	}

	public void travelTowards(Vector3d travelVec) {
		super.travel(travelVec);
	}

	public boolean isBreedingItem(ItemStack stack) {
		return TEMPTATION_ITEMS.test(stack);
	}

	public boolean boost() {
		return this.field_234214_bx_.boost(this.getRNG());
	}

	
	}


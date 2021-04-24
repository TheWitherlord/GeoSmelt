package com.witherlord00.geosmelt.geocommon.items;

import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;

public class GalaxiusItem extends LegendarySwordItem{

	public GalaxiusItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {
		super(tier, attackDamageIn, attackSpeedIn, builderIn);
	}
	 @Override
	    public boolean hitEntity(final ItemStack itemstack, final  LivingEntity target, final  LivingEntity attacker) {
		 if (target.getCreatureAttribute() != CreatureAttribute.ILLAGER) {
             target.attackEntityFrom(DamageSource.MAGIC, this.getAttackDamage() + 5F);	 
		 }
      target.setFire(4);
		itemstack.damageItem(1, attacker, (entity) -> entity.sendBreakAnimation(Hand.MAIN_HAND));

      return true;
}
	 }

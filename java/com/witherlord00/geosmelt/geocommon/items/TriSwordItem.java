package com.witherlord00.geosmelt.geocommon.items;

import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;

public class TriSwordItem extends LegendarySwordItem{

	public TriSwordItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {
		super(tier, attackDamageIn, attackSpeedIn, builderIn);
	}
	 @Override
	    public boolean hitEntity(final ItemStack itemstack, final  LivingEntity target, final  LivingEntity attacker) {
	    	 target.applyKnockback( 1.2F, attacker.getPosX() - target.getPosX(), attacker.getPosZ() - target.getPosZ());
		 
   target.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 200, 2));
   target.setFire(8);
	itemstack.damageItem(1, attacker, (entity) -> entity.sendBreakAnimation(Hand.MAIN_HAND));
   return true;
}
}

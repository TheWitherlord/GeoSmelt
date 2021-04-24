package com.witherlord00.geosmelt.geocommon.items;

import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.NonNullList;

public class HollowBladeItem extends LegendarySwordItem{  

	public HollowBladeItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {
		super(tier, attackDamageIn, attackSpeedIn, builderIn);
	}
	
	 @Override
	    public boolean hitEntity(final ItemStack itemstack, final  LivingEntity target, final  LivingEntity attacker) {
         target.attackEntityFrom(DamageSource.MAGIC, this.getAttackDamage() + 5F);	   
		itemstack.damageItem(1, attacker, (entity) -> entity.sendBreakAnimation(Hand.MAIN_HAND));

   return true;
}
	
}
	

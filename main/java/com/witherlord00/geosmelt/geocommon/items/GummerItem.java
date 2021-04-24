package com.witherlord00.geosmelt.geocommon.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;

public class GummerItem extends GummerHammerItem{ 

	public GummerItem(IItemTier tier, Properties builderIn) {
		super(tier, builderIn);
	}
	@Override
    public boolean hitEntity(final ItemStack itemstack, final  LivingEntity target, final  LivingEntity attacker) {		 
		 target.applyKnockback( 1.6F, attacker.getPosX() - target.getPosX(), attacker.getPosZ() - target.getPosZ());
		 
	itemstack.damageItem(1, attacker, (entity) -> entity.sendBreakAnimation(Hand.MAIN_HAND));

  return true;
}
}
	
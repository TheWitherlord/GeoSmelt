package com.witherlord00.geosmelt.geocommon.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.Hand;

public class MorningStarItem extends DarkMaceItem{

	public MorningStarItem(IItemTier tier, Properties builderIn) {
		super(tier, builderIn);
		
	}
	@Override
    public boolean hitEntity(final ItemStack itemstack, final  LivingEntity target, final  LivingEntity attacker) {
  target.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 200, 0));
  target.addPotionEffect(new EffectInstance(Effects.BLINDNESS, 200, 0));
	itemstack.damageItem(1, attacker, (entity) -> entity.sendBreakAnimation(Hand.MAIN_HAND));

  return true;
}
}

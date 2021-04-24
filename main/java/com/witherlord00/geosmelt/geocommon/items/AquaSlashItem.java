package com.witherlord00.geosmelt.geocommon.items;


import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class AquaSlashItem extends SwordItem{  

	public AquaSlashItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {
		super(tier, attackDamageIn, attackSpeedIn, builderIn);
	}
	 @Override
	    public boolean hitEntity(final ItemStack itemstack, final  LivingEntity target, final  LivingEntity attacker) {
    	 target.applyKnockback( 1.3F, attacker.getPosX() - target.getPosX(), attacker.getPosZ() - target.getPosZ());
	 
      target.addPotionEffect(new EffectInstance(Effects.LEVITATION, 20, 0));
		itemstack.damageItem(1, attacker, (entity) -> entity.sendBreakAnimation(Hand.MAIN_HAND));

      return true;
}
	 @Override
		public Rarity getRarity(ItemStack stack) {
			return Rarity.RARE;
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void addInformation(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag flags) {
			tooltip.add(new TranslationTextComponent(getTranslationKey() + ".tooltip").mergeStyle(TextFormatting.GOLD));
		}
	}

			
	 

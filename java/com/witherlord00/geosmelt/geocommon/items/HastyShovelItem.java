package com.witherlord00.geosmelt.geocommon.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Item.Properties;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;


public class HastyShovelItem extends ShovelItem {
	public HastyShovelItem(IItemTier tier, float f, float attackSpeedIn, Properties builderIn) {
		super(tier, f, attackSpeedIn, builderIn);
	}

	
}
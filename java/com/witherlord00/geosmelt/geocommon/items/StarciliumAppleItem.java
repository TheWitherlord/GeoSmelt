package com.witherlord00.geosmelt.geocommon.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;

public class StarciliumAppleItem extends Item{

	public StarciliumAppleItem(Properties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}
	@Override
    public Rarity getRarity(ItemStack stack) {
        return Rarity.RARE;
    }
}

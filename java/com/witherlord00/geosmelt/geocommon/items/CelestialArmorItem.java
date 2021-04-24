package com.witherlord00.geosmelt.geocommon.items;


import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;

public class CelestialArmorItem extends ArmorItem{

	public CelestialArmorItem(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builderIn) {
		super(materialIn, slot, builderIn);
	}
	@Override
	public Rarity getRarity(ItemStack stack) {
		return Rarity.UNCOMMON;
		
	}
}

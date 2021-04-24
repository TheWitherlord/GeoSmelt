package com.witherlord00.geosmelt.geocore.common;

import java.util.function.Supplier;

import com.witherlord00.geosmelt.GeoSmelt;
import com.witherlord00.geosmelt.geocore.init.InitItem;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public enum ModArmorMaterial implements IArmorMaterial
{
	XENOKSMIT(GeoSmelt.MODID + ":xenoksmit", 36, new int[] {4, 8, 7, 3}, 18, 
			SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 3.5F, () -> {
				return Ingredient.fromItems(InitItem.XENOKSMIT_INGOT.get());}, 0.05F),
	
	STARCILIUM(GeoSmelt.MODID + ":starcilium", 36, new int[] {4, 8, 7, 3}, 18, 
			SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 4.0F, () -> {
				return Ingredient.fromItems(InitItem.STARCILIUM_INGOT.get());}, 0.05F),
	
	CELESTIAL(GeoSmelt.MODID + ":celestial", 43, new int[] {5, 9, 8, 4}, 19, 
			SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 4.2F, () -> {
				return Ingredient.fromItems(InitItem.INFINITY_PLATE.get());}, 0.15F);

	
	private static final int[] MAX_DAMAGE_ARRAY = { 11, 16, 15, 13 };
	private final String name;
	private final int maxDamageFactor;
	private final int[] damageReductionAmountArray;
	private final int enchantability;
	private final SoundEvent soundEvent;
	private final float toughness;
	private final Supplier<Ingredient> repairMaterial;
	private final float knockbackResistance;
	
	ModArmorMaterial(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantability, 
			SoundEvent soundEvent, float thoughness, Supplier<Ingredient> repairMaterial, float knockbackResistance)
	{
		this.name = name;
		this.maxDamageFactor = maxDamageFactor;
		this.damageReductionAmountArray = damageReductionAmountArray;
		this.enchantability = enchantability;
		this.soundEvent = soundEvent;
		this.toughness = thoughness;
		this.repairMaterial = repairMaterial;
		this.knockbackResistance = knockbackResistance;
	}
	
	@Override
	public int getDurability(EquipmentSlotType slotIn) 
	{
		return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
	}

	@Override
	public int getDamageReductionAmount(EquipmentSlotType slotIn) 
	{
		return damageReductionAmountArray[slotIn.getIndex()];
	}

	@Override
	public int getEnchantability() 
	{
		return enchantability;
	}

	@Override
	public SoundEvent getSoundEvent() 
	{
		return soundEvent;
	}

	@Override
	public Ingredient getRepairMaterial() 
	{
		return repairMaterial.get();
	}

	@Override
	public String getName() 
	{
		return name;
	}

	@Override
	public float getToughness() 
	{
		return toughness;
	}

	@Override
	public float getKnockbackResistance()
	{
		return knockbackResistance;
	}

}
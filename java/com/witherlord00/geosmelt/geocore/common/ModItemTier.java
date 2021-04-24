package com.witherlord00.geosmelt.geocore.common;

import java.util.function.Supplier;  

import com.witherlord00.geosmelt.geocore.init.InitItem;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

public enum ModItemTier implements IItemTier {
	
	//(harvest, durability, efficiency, damage, enchant)
	STARCILIUM(5, 3021, 6.5F, 0F, 16, () -> {
		return Ingredient.fromItems(InitItem.STARCILIUM_INGOT.get());
	}), 
		COPPER(2, 125, 2.7F, 0F, 7, () -> {
			return Ingredient.fromItems(InitItem.COPPER_SCRAP.get());

	}), 
		EAGLESTEEL(3, 740, 5.6F, 0F, 10, () -> {
			return Ingredient.fromItems(InitItem.EAGLESTEEL_INGOT.get());

	}), 
		HASTY(3, 924, 11F, 0F, 10, () -> {
			return Ingredient.fromItems(InitItem.EAGLESTEEL_INGOT.get());

	}), 
	XENOKSMIT(5, 3256, 10.0F, 5F, 16, () -> {
		return Ingredient.fromItems(InitItem.XENOKSMIT_INGOT.get());
	}),
		GALAXIUS(5, 4076, 10.0F, 0F, 12, () -> {
			return Ingredient.fromItems(InitItem.INFINITY_PLATE.get());
		}),
			GUMMER(5, 3896, 12.0F, 11F, 8, () -> {
				return Ingredient.fromItems(InitItem.INFINITY_PLATE.get());					
			}),	
				DARK(4, 2650, 8.0F, 9F, 8, () -> {
					return Ingredient.fromItems(InitItem.INFINITY_PLATE.get());			
	});

	private final int maxUses;
	private final float efficiency;
	private final float attackDamage;
	private final int harvestLevel; //first thing
	private final int enchantability;
	
	private final Supplier<Ingredient> repairMaterial;

	ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability,
			Supplier<Ingredient> repairMaterial) {
		this.maxUses = maxUses;
		this.efficiency = efficiency;
		this.attackDamage = attackDamage;
		this.harvestLevel = harvestLevel;
		this.enchantability = enchantability;
		this.repairMaterial = repairMaterial;
	}

	@Override
	public int getMaxUses() {
		return maxUses;
	}

	@Override
	public float getEfficiency() {
		return efficiency;
	}

	@Override
	public float getAttackDamage() {
		return attackDamage;
	}

	@Override
	public int getHarvestLevel() {
		return harvestLevel;
	}

	@Override
	public int getEnchantability() {
		return enchantability;
	}

	@Override
	public Ingredient getRepairMaterial() {
		return repairMaterial.get();
	}

}
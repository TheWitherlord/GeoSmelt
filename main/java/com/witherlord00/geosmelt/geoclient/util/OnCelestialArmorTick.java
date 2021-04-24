package com.witherlord00.geosmelt.geoclient.util;

import com.witherlord00.geosmelt.geocommon.items.CelestialArmorItem;
import com.witherlord00.geosmelt.geocommon.items.HastyAxeItem;
import com.witherlord00.geosmelt.geocommon.items.HastyHoeItem;
import com.witherlord00.geosmelt.geocommon.items.HastyPickaxeItem;
import com.witherlord00.geosmelt.geocommon.items.HastyShovelItem;
import com.witherlord00.geosmelt.geocommon.items.HastySwordItem;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class OnCelestialArmorTick {

	@SubscribeEvent
	public void onArmorTick(LivingEvent.LivingUpdateEvent event) {

		if (event.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.HEAD)
				.getItem() instanceof CelestialArmorItem) {
			event.getEntityLiving().addPotionEffect(new EffectInstance(Effects.LUCK, 10, 0, false, false));
		}
		if (event.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.CHEST)
				.getItem() instanceof CelestialArmorItem) {
			event.getEntityLiving().addPotionEffect(new EffectInstance(Effects.RESISTANCE, 10, 0, false, false));
		}
		if (event.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.LEGS)
				.getItem() instanceof CelestialArmorItem) {
			event.getEntityLiving().addPotionEffect(new EffectInstance(Effects.SLOW_FALLING, 10, 0, false, false));
		}
		if (event.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.FEET)
				.getItem() instanceof CelestialArmorItem) {
			event.getEntityLiving().addPotionEffect(new EffectInstance(Effects.SPEED, 10, 1, false, false));
		}
		
			if (event.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.MAINHAND)
					.getItem() instanceof HastySwordItem) {
				event.getEntityLiving().addPotionEffect(new EffectInstance(Effects.HASTE, 10, 1, false, false));
			}
			if (event.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.MAINHAND)
					.getItem() instanceof HastyAxeItem) {
				event.getEntityLiving().addPotionEffect(new EffectInstance(Effects.HASTE, 10, 1, false, false));
			}
			if (event.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.MAINHAND)
					.getItem() instanceof HastyPickaxeItem) {
				event.getEntityLiving().addPotionEffect(new EffectInstance(Effects.HASTE, 10, 1, false, false));
			}
			if (event.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.MAINHAND)
					.getItem() instanceof HastyShovelItem) {
				event.getEntityLiving().addPotionEffect(new EffectInstance(Effects.HASTE, 10, 1, false, false));
			}
			if (event.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.MAINHAND)
					.getItem() instanceof HastyHoeItem) {
				event.getEntityLiving().addPotionEffect(new EffectInstance(Effects.HASTE, 10, 1, false, false));

			}

		}
	}


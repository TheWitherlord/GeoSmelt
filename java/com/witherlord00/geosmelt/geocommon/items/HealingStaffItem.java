package com.witherlord00.geosmelt.geocommon.items;

import java.util.List;

import com.witherlord00.geosmelt.geocommon.entities.HolyOrbEntity;
import com.witherlord00.geosmelt.geocore.common.ModItemTier;
import com.witherlord00.geosmelt.geocore.init.GeoEntityRegistry;
import com.witherlord00.geosmelt.geocore.init.InitItem;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.Rarity;
import net.minecraft.item.SwordItem;
import net.minecraft.item.UseAction;
import net.minecraft.item.Item.Properties;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class HealingStaffItem extends SwordItem {

	public HealingStaffItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {
		super(tier, attackDamageIn, attackSpeedIn, builderIn);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand hand) {
		ItemStack itemStackIn = playerIn.getHeldItem(hand);
		boolean flag = playerIn.isCreative()
				|| EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, itemStackIn) > 0;
		ItemStack itemstack = this.findAmmo(playerIn);
		playerIn.setActiveHand(hand);
		playerIn.swingArm(hand);
		if (!itemstack.isEmpty() || flag) {
			boolean flag1 = playerIn.isCreative() || this.isInfinite(itemstack, itemStackIn, playerIn);
			if (!flag1) {
				itemstack.shrink(1);
				if (itemstack.isEmpty()) {
					playerIn.inventory.deleteStack(itemstack);
				}
			}
			double d2 = playerIn.getLookVec().x;
			double d3 = playerIn.getLookVec().y;
			double d4 = playerIn.getLookVec().z;
			float inaccuracy = 1.0F;
			d2 = d2 + playerIn.getRNG().nextGaussian() * 0.007499999832361937D * (double) inaccuracy;
			d3 = d3 + playerIn.getRNG().nextGaussian() * 0.007499999832361937D * (double) inaccuracy;
			d4 = d4 + playerIn.getRNG().nextGaussian() * 0.007499999832361937D * (double) inaccuracy;
			HolyOrbEntity charge = new HolyOrbEntity(GeoEntityRegistry.HOLY_ORB, worldIn, playerIn, d2, d3, d4);
			charge.setPosition(playerIn.getPosX(), playerIn.getPosY() + 1, playerIn.getPosZ());
			if (!worldIn.isRemote) {
				worldIn.addEntity(charge);
			}
			playerIn.playSound(SoundEvents.ENTITY_ENDER_DRAGON_SHOOT, 1F, 0.75F + 0.5F * playerIn.getRNG().nextFloat());
			playerIn.getCooldownTracker().setCooldown(this, 180);
			itemStackIn.damageItem(1, playerIn, p -> p.sendBreakAnimation(hand));

		}
		return new ActionResult<ItemStack>(ActionResultType.PASS, itemStackIn);

	}

	public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.entity.player.PlayerEntity player) {
		int enchant = net.minecraft.enchantment.EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, bow);
		return enchant > 0 && stack.getItem() == InitItem.DRAGON_CHARGE.get();
	}

	private ItemStack findAmmo(PlayerEntity player) {
		if (this.isAmmo(player.getHeldItem(Hand.OFF_HAND))) {
			return player.getHeldItem(Hand.OFF_HAND);
		} else if (this.isAmmo(player.getHeldItem(Hand.MAIN_HAND))) {
			return player.getHeldItem(Hand.MAIN_HAND);
		} else {
			for (int i = 0; i < player.inventory.getSizeInventory(); ++i) {
				ItemStack itemstack = player.inventory.getStackInSlot(i);

				if (this.isAmmo(itemstack)) {
					return itemstack;
				}
			}

			return ItemStack.EMPTY;
		}
	}

	protected boolean isAmmo(ItemStack stack) {
		return !stack.isEmpty() && stack.getItem() == InitItem.DRAGON_CHARGE.get();
	}

	@Override
	public Rarity getRarity(ItemStack stack) {
		return Rarity.EPIC;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag flags) {
		tooltip.add(new TranslationTextComponent(getTranslationKey() + ".tooltip").mergeStyle(TextFormatting.GOLD));
	}

	@Override
	public boolean hitEntity(final ItemStack itemstack, final LivingEntity target, final LivingEntity attacker) {
		if (target.getCreatureAttribute() == CreatureAttribute.UNDEAD) {
			target.attackEntityFrom(DamageSource.MAGIC, this.getAttackDamage() + 5);

		}

		itemstack.damageItem(1, attacker, (entity) -> entity.sendBreakAnimation(Hand.MAIN_HAND));

		return true;
	}
	public int getUseDuration(ItemStack stack) {
	      return 180;
	   }

	   /**
	    * returns the action that specifies what animation to play when the items is being used
	    */
	   public UseAction getUseAction(ItemStack stack) {
	      return UseAction.BOW;
	   }
	
	}

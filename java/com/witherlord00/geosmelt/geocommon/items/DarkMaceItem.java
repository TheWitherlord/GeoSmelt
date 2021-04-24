package com.witherlord00.geosmelt.geocommon.items;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableMap.Builder;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Rarity;
import net.minecraft.item.ToolItem;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

//Credits to @author Choonster/ Modified by Witherlord00

public class DarkMaceItem extends ToolItem {
	

	private static final float DIG_SPEED_COBWEB = 12.0f;

	private static final float DIG_SPEED_SWORD = 1.3f;

	private static final float DIG_SPEED_DEFAULT = 1.2f;

	private static final float BASE_DAMAGE = 0.0f;

	private static final float ATTACK_SPEED = -2.7f;

	public DarkMaceItem(final IItemTier itemTier, final Item.Properties properties) {
		super(BASE_DAMAGE, ATTACK_SPEED, itemTier, Collections.emptySet(), properties);
	}

	/**
	 * Add the pickaxe, axe, shovel and sword tool types to the item properties,
	 * using the {@link IItemTier}'s harvest level for each tool.
	 *
	 * @param itemTier   The item tier
	 * @param properties The item properties to add the tool types to
	 * @return The item properties with the tool types added
	 */
	public static Item.Properties addToolTypes(final IItemTier itemTier, final Item.Properties properties) {
		return properties.addToolType(ToolType.PICKAXE, itemTier.getHarvestLevel())
				.addToolType(ToolType.AXE, itemTier.getHarvestLevel())
				.addToolType(ToolType.SHOVEL, itemTier.getHarvestLevel())
				.addToolType(ToolType.get("sword"), itemTier.getHarvestLevel()); // Waila Harvestability sets the
																					// harvest tool of Cobwebs to
																					// "sword"
	}

	/**
	 * The {@link Material}s that this tool is effective on.
	 */
	private static final Set<Material> EFFECTIVE_MATERIALS = ImmutableSet.of(
			// Pickaxe
			Material.ROCK, Material.IRON, Material.IRON, Material.GLASS, Material.PISTON, Material.ANVIL,
			Material.MISCELLANEOUS,

			// Axe
			Material.WOOD, Material.GOURD, Material.PLANTS, Material.TALL_PLANTS,

			// Shovel
			Material.ORGANIC, Material.EARTH, Material.SAND, Material.SNOW, Material.SNOW_BLOCK, Material.CLAY);

	/**
	 * The {@link Material}s that Swords are effective on.
	 */
	private static final Set<Material> SWORD_MATERIALS = ImmutableSet.of(Material.PLANTS, Material.TALL_PLANTS,
			Material.CORAL, Material.LEAVES, Material.GOURD);

	@Override
	public boolean canHarvestBlock(final BlockState blockIn) {
		return super.canHarvestBlock(blockIn);
	}

	@Override
	public boolean canHarvestBlock(final ItemStack stack, final BlockState state) {
		return EFFECTIVE_MATERIALS.contains(state.getMaterial()) || state.getBlock() == Blocks.COBWEB;
	}

	@Override
	public float getDestroySpeed(final ItemStack stack, final BlockState state) {
		if (state.getBlock() == Blocks.COBWEB) {
			return DIG_SPEED_COBWEB;
		}

		for (final ToolType type : getToolTypes(stack)) {
			if (state.isToolEffective(type)) {
				return efficiency;
			}
		}

		// Not all blocks have a harvest tool/level set, so we need to fall back to
		// checking the Material like the vanilla tools do
		if (EFFECTIVE_MATERIALS.contains(state.getMaterial())) {
			return efficiency;
		}

		if (SWORD_MATERIALS.contains(state.getMaterial())) {
			return DIG_SPEED_SWORD;
		}

		return DIG_SPEED_DEFAULT;
	}

	@Override
	public boolean hitEntity(final ItemStack itemStack, final LivingEntity target, final LivingEntity attacker) {
		// Only reduce the durability by 1 point (like swords do) instead of 2 (like
		// tools do)
		itemStack.damageItem(1, attacker, (entity) -> entity.sendBreakAnimation(Hand.MAIN_HAND));
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

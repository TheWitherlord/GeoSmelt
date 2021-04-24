package com.witherlord00.geosmelt.geocommon.blocks;

import java.util.Random;

import com.witherlord00.geosmelt.geocore.init.InitBlock;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.server.ServerWorld;

public class GeoOreBlock extends Block {
   public GeoOreBlock(AbstractBlock.Properties properties) {
      super(properties);
   }

   protected int getExperience(Random rand) {
	   
      if (this ==  InitBlock.STARCILIUM_ORE.get()) {
         return MathHelper.nextInt(rand, 3, 6);
      } else if (this == InitBlock.TERRANITE.get()) {
         return MathHelper.nextInt(rand, 0, 2);
      } else if (this == InitBlock.JASPILLITE.get()) {
         return MathHelper.nextInt(rand, 0, 4);
      } else if (this == InitBlock.TAZURITE_ORE.get()) {
         return MathHelper.nextInt(rand, 0, 4);
     
      }
	return 0;
   }

   /**
    * Perform side-effects from block dropping, such as creating silverfish
    */
   public void spawnAdditionalDrops(BlockState state, ServerWorld worldIn, BlockPos pos, ItemStack stack) {
      super.spawnAdditionalDrops(state, worldIn, pos, stack);
   }

   @Override
   public int getExpDrop(BlockState state, net.minecraft.world.IWorldReader reader, BlockPos pos, int fortune, int silktouch) {
      return silktouch == 0 ? this.getExperience(RANDOM) : 0;
   }
}

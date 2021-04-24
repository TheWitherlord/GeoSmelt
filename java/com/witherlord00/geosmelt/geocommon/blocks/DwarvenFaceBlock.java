package com.witherlord00.geosmelt.geocommon.blocks;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;
import com.witherlord00.geosmelt.geocore.init.InitBlock;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;

public class DwarvenFaceBlock extends HorizontalBlock  { 

	  private static final Predicate<BlockState> DWARVEN_FACE_BLOCK = new Predicate<BlockState>() {
	        public boolean apply(@Nullable BlockState p_apply_1_) {
	        	
	            return p_apply_1_ != null && (p_apply_1_.getBlock() == InitBlock.STARCILIUM_BLOCK.get()
	                    
	            );
	        }
	    };
	   
	    public DwarvenFaceBlock(AbstractBlock.Properties builder) {
	        super(builder);
	        
	       
	        this.setDefaultState(this.getStateContainer().getBaseState().with(HORIZONTAL_FACING, Direction.NORTH));
	    }
	        @Override
	        public BlockState getStateForPlacement(BlockItemUseContext context) {
	          return this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite());
	        }

	        @Override
	        protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
	          builder.add(HORIZONTAL_FACING);
	        }
	    
}
	  
package com.witherlord00.geosmelt.geocommon.blocks;

import net.minecraft.block.*;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;

public class XenoksmitFancyBlock extends HorizontalBlock   {   


   
    public XenoksmitFancyBlock(AbstractBlock.Properties builder) {
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
package com.witherlord00.geosmelt.geocommon.blocks;

import com.google.common.base.Predicate;
import com.witherlord00.geosmelt.geocommon.entities.StarciliumGolemEntity;
import com.witherlord00.geosmelt.geocore.init.GeoEntityRegistry;
import com.witherlord00.geosmelt.geocore.init.InitBlock;
import com.witherlord00.geosmelt.geocore.init.InitItem;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.pattern.BlockMaterialMatcher;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.block.pattern.BlockPatternBuilder;
import net.minecraft.block.pattern.BlockStateMatcher;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.CachedBlockInfo;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class StarciliumFaceBlock extends HorizontalBlock  {    


    private static final Predicate<BlockState> STARCILIUM = new Predicate<BlockState>() {
        public boolean apply(@Nullable BlockState p_apply_1_) {
        	
            return p_apply_1_ != null && (p_apply_1_.getBlock() == InitBlock.STARCILIUM_BLOCK.get()
                    
            );
        }
    };
    private BlockPattern starciliumgolemBasePattern;
    private BlockPattern starciliumgolemPattern;

    public StarciliumFaceBlock(AbstractBlock.Properties builder) {
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
    

  
   

    public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
        if (oldState.getBlock() != state.getBlock()) {
            this.trySpawnGolem(worldIn, pos);
        }
    }

    public boolean canDispenserPlace(World worldIn, BlockPos pos) {
        return this.getGolemBasePattern().match(worldIn, pos) != null;
    }

    private void trySpawnGolem(World worldIn, BlockPos pos) {
        BlockPattern.PatternHelper blockpattern$patternhelper = this.getGolemPattern().match(worldIn, pos);

        if (blockpattern$patternhelper != null) {
            for (int j = 0; j < this.getGolemPattern().getPalmLength(); ++j) {
                for (int k = 0; k < this.getGolemPattern().getThumbLength(); ++k) {
                    worldIn.setBlockState(blockpattern$patternhelper.translateOffset(j, k, 0).getPos(), Blocks.AIR.getDefaultState(), 2);
                }
            }

            BlockPos blockpos = blockpattern$patternhelper.translateOffset(1, 2, 0).getPos();
            StarciliumGolemEntity entityirongolem = new StarciliumGolemEntity(GeoEntityRegistry.STARCILIUM_GOLEM, worldIn);
            entityirongolem.setLocationAndAngles((double) blockpos.getX() + 0.5D, (double) blockpos.getY() + 0.05D, (double) blockpos.getZ() + 0.5D, 0.0F, 0.0F);
            worldIn.addEntity(entityirongolem);
            entityirongolem.setPlayerCreated(true);

            for (ServerPlayerEntity serverplayerentity1 : worldIn.getEntitiesWithinAABB(ServerPlayerEntity.class, entityirongolem.getBoundingBox().grow(5.0D))) {
                CriteriaTriggers.SUMMONED_ENTITY.trigger(serverplayerentity1, entityirongolem);
            }

            for (int i1 = 0; i1 < this.getGolemPattern().getPalmLength(); ++i1) {
                for (int j1 = 0; j1 < this.getGolemPattern().getThumbLength(); ++j1) {
                    CachedBlockInfo cachedblockinfo1 = blockpattern$patternhelper.translateOffset(i1, j1, 0);
                    worldIn.notifyBlockUpdate(cachedblockinfo1.getPos(), cachedblockinfo1.getBlockState(), cachedblockinfo1.getBlockState(), 4);
                }
            }
        }
    }

   
    protected BlockPattern getGolemBasePattern() {
        if (this.starciliumgolemBasePattern == null) {
            this.starciliumgolemBasePattern = BlockPatternBuilder.start().aisle("~ ~", "###", "~#~").where('#', CachedBlockInfo.hasState(STARCILIUM)).where('~', CachedBlockInfo.hasState(BlockMaterialMatcher.forMaterial(Material.AIR))).build();
        }

        return this.starciliumgolemBasePattern;
    }

    protected BlockPattern getGolemPattern() {
        if (this.starciliumgolemPattern == null) {
            this.starciliumgolemPattern = BlockPatternBuilder.start().aisle("~^~", "###", "~#~").where('^', CachedBlockInfo.hasState(BlockStateMatcher.forBlock(InitBlock.STARCILIUM_FACE_BLOCK.get()))).where('#', CachedBlockInfo.hasState(STARCILIUM)).where('~', CachedBlockInfo.hasState(BlockMaterialMatcher.forMaterial(Material.AIR))).build();
        }

        return this.starciliumgolemPattern;
    }

	
	

}
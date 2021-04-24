package com.witherlord00.geosmelt.geocommon.entities.renderers;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.witherlord00.geosmelt.geocommon.entities.StarciliumGolemEntity;
import com.witherlord00.geosmelt.geocommon.entities.models.StarciliumGolemModel;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.IronGolemCracksLayer;
import net.minecraft.client.renderer.entity.model.IronGolemModel;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class StarciliumGolemRenderer extends MobRenderer<StarciliumGolemEntity, StarciliumGolemModel <StarciliumGolemEntity>> { 
   private static final ResourceLocation STARCILIUM_GOLEM_TEXTURES = new ResourceLocation("geosmelt:textures/entity/starcilium_golem/starcilium_golem.png");

   public StarciliumGolemRenderer(EntityRendererManager renderManagerIn) {
      super(renderManagerIn, new StarciliumGolemModel<>(), 0.7F);
      this.addLayer(new StarciliumGolemCracksLayer(this));
      this.addLayer(new StarciliumGolemEyesLayer(this));

      
   }

   /**
    * Returns the location of an entity's texture.
    */
   public ResourceLocation getEntityTexture(StarciliumGolemEntity entity) {
      return STARCILIUM_GOLEM_TEXTURES;
   }

   protected void applyRotations(StarciliumGolemEntity entityLiving, MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
      super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
      if (!((double)entityLiving.limbSwingAmount < 0.01D)) {
         float f = 13.0F;
         float f1 = entityLiving.limbSwing - entityLiving.limbSwingAmount * (1.0F - partialTicks) + 6.0F;
         float f2 = (Math.abs(f1 % 13.0F - 6.5F) - 3.25F) / 3.25F;
         matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(6.5F * f2));
      }
   }
}

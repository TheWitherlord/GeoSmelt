package com.witherlord00.geosmelt.geocommon.entities.renderers;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.witherlord00.geosmelt.geocommon.entities.GreaterWitherSkullEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.GenericHeadModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.projectile.WitherSkullEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GreaterWitherSkullRenderer extends EntityRenderer<GreaterWitherSkullEntity> {
   private static final ResourceLocation WITHER_TEXTURES = new ResourceLocation("geosmelt:textures/entity/greater_wither_skull.png");
   private final GenericHeadModel skeletonHeadModel = new GenericHeadModel();

   public GreaterWitherSkullRenderer(EntityRendererManager renderManagerIn) {
      super(renderManagerIn);
   }

   protected int getBlockLight(WitherSkullEntity entityIn, BlockPos partialTicks) {
      return 15;
   }

   public void render(GreaterWitherSkullEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
      matrixStackIn.push();
      matrixStackIn.scale(-1.5F, -1.5F, 1.5F);
      float f = MathHelper.rotLerp(entityIn.prevRotationYaw, entityIn.rotationYaw, partialTicks);
      float f1 = MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch);
      IVertexBuilder ivertexbuilder = bufferIn.getBuffer(this.skeletonHeadModel.getRenderType(this.getEntityTexture(entityIn)));
      this.skeletonHeadModel.func_225603_a_(0.0F, f, f1);
      this.skeletonHeadModel.render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
      matrixStackIn.pop();
      super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
   }

   /**
    * Returns the location of an entity's texture.
    */
   public ResourceLocation getEntityTexture(GreaterWitherSkullEntity entity) {
      return WITHER_TEXTURES;
   }
}

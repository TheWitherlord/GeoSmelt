package com.witherlord00.geosmelt.geocommon.entities.renderers;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.witherlord00.geosmelt.geocommon.entities.JungleTarantulaEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.SaddleLayer;
import net.minecraft.client.renderer.entity.layers.SpiderEyesLayer;
import net.minecraft.client.renderer.entity.model.PigModel;
import net.minecraft.client.renderer.entity.model.SpiderModel;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class JungleTarantulaRenderer<T extends JungleTarantulaEntity> extends MobRenderer<T, SpiderModel<T>> {
   private static final ResourceLocation TARANTULA_TEXTURES = new ResourceLocation("geosmelt:textures/entity/jungle_tarantula/jungle_tarantula.png");

   public JungleTarantulaRenderer(EntityRendererManager renderManagerIn) {
      super(renderManagerIn, new SpiderModel<>(), 0.8F);
      this.addLayer(new SaddleLayer<>(this, new SpiderModel<>(), new ResourceLocation("geosmelt:textures/entity/jungle_tarantula/jungle_tarantula_saddle.png")));
      this.addLayer(new SpiderEyesLayer<>(this));

   }

   protected float getDeathMaxRotation(T entityLivingBaseIn) {
      return 180.0F;
   }

   /**
    * Returns the location of an entity's texture.
    */
   public ResourceLocation getEntityTexture(T entity) {
      return TARANTULA_TEXTURES;
   }
   protected void preRenderCallback(JungleTarantulaEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
	      matrixStackIn.scale( 1.6F,  1.6F, 1.6F);
}
}

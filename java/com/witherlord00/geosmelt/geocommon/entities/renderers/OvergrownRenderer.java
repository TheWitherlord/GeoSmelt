package com.witherlord00.geosmelt.geocommon.entities.renderers;

import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.layers.StayClothingLayer;
import net.minecraft.client.renderer.entity.model.SkeletonModel;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class OvergrownRenderer extends BipedRenderer<AbstractSkeletonEntity, SkeletonModel<AbstractSkeletonEntity>> { 
   private static final ResourceLocation OVERGROWN_TEXTURES = new ResourceLocation("geosmelt:textures/entity/overgrown/overgrown.png");

   public OvergrownRenderer(EntityRendererManager renderManagerIn) {
      super(renderManagerIn, new SkeletonModel<>(), 0.5F);
      this.addLayer(new BipedArmorLayer<>(this, new SkeletonModel(0.5F, true), new SkeletonModel(1.0F, true)));
      this.addLayer(new OvergrownMossLayer<>(this));

   }

   /**
    * Returns the location of an entity's texture.
    */
   public ResourceLocation getEntityTexture(AbstractSkeletonEntity entity) {
      return OVERGROWN_TEXTURES;
   }
}

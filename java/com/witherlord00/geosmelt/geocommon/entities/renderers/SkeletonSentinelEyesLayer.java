package com.witherlord00.geosmelt.geocommon.entities.renderers;

import com.witherlord00.geosmelt.geocommon.entities.StarciliumGolemEntity;
import com.witherlord00.geosmelt.geocommon.entities.models.StarciliumGolemModel;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.AbstractEyesLayer;
import net.minecraft.client.renderer.entity.model.SkeletonModel;
import net.minecraft.client.renderer.entity.model.SpiderModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SkeletonSentinelEyesLayer extends AbstractEyesLayer<AbstractSkeletonEntity, SkeletonModel<AbstractSkeletonEntity>> {
   private static final RenderType RENDER_TYPE = RenderType.getEyes(new ResourceLocation("geosmelt:textures/entity/skeleton_sentinel/skeleton_sentinel_eyes.png"));

   public SkeletonSentinelEyesLayer(IEntityRenderer<AbstractSkeletonEntity, SkeletonModel<AbstractSkeletonEntity>> p_i226040_1_) {
	      super(p_i226040_1_);
	   }

   public RenderType getRenderType() {
      return RENDER_TYPE;
   }
}

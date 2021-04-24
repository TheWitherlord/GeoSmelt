package com.witherlord00.geosmelt.geocommon.entities.renderers;

import com.witherlord00.geosmelt.geocommon.entities.StarciliumGolemEntity;
import com.witherlord00.geosmelt.geocommon.entities.models.StarciliumGolemModel;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.AbstractEyesLayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.SpiderModel;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class StarciliumGolemEyesLayer extends AbstractEyesLayer<StarciliumGolemEntity, StarciliumGolemModel<StarciliumGolemEntity>> {

   private static final RenderType RENDER_TYPE = RenderType.getEyes(new ResourceLocation("geosmelt:textures/entity/starcilium_golem/starcilium_golem_eyes.png"));

   public StarciliumGolemEyesLayer(IEntityRenderer<StarciliumGolemEntity, StarciliumGolemModel<StarciliumGolemEntity>> p_i226040_1_) {
	      super(p_i226040_1_);
	   }

   public RenderType getRenderType() {
      return RENDER_TYPE;
   }
}

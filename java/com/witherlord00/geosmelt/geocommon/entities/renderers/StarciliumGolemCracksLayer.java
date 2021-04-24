package com.witherlord00.geosmelt.geocommon.entities.renderers;

import com.google.common.collect.ImmutableMap;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.witherlord00.geosmelt.geocommon.entities.StarciliumGolemEntity;
import com.witherlord00.geosmelt.geocommon.entities.models.StarciliumGolemModel;

import java.util.Map;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class StarciliumGolemCracksLayer extends LayerRenderer<StarciliumGolemEntity, StarciliumGolemModel<StarciliumGolemEntity>> {
   private static final Map<StarciliumGolemEntity.Dents, ResourceLocation> field_229134_a_ = ImmutableMap.of(StarciliumGolemEntity.Dents.LOW, new ResourceLocation("geosmelt:textures/entity/starcilium_golem/starcilium_golem_crackiness_low.png"), StarciliumGolemEntity.Dents.MEDIUM, new ResourceLocation("geosmelt:textures/entity/starcilium_golem/starcilium_golem_crackiness_medium.png"), StarciliumGolemEntity.Dents.HIGH, new ResourceLocation("geosmelt:textures/entity/starcilium_golem/starcilium_golem_crackiness_high.png"));

   public StarciliumGolemCracksLayer(IEntityRenderer<StarciliumGolemEntity, StarciliumGolemModel<StarciliumGolemEntity>> p_i226040_1_) {
      super(p_i226040_1_);
   }

   public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, StarciliumGolemEntity entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
      if (!entitylivingbaseIn.isInvisible()) {
    	  StarciliumGolemEntity.Dents StarciliumGolemEntity$cracks = entitylivingbaseIn.Cracks();
         if (StarciliumGolemEntity$cracks != StarciliumGolemEntity.Dents.NONE) {
            ResourceLocation resourcelocation = field_229134_a_.get(StarciliumGolemEntity$cracks);
            renderCutoutModel(this.getEntityModel(), resourcelocation, matrixStackIn, bufferIn, packedLightIn, entitylivingbaseIn, 1.0F, 1.0F, 1.0F);
         }
      }
   }
}

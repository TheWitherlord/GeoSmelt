package com.witherlord00.geosmelt.geocommon.entities.models;

import com.google.common.collect.ImmutableList;
import com.witherlord00.geosmelt.geocommon.entities.StarciliumGolemEntity;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class StarciliumGolemModel<T extends StarciliumGolemEntity> extends SegmentedModel<T> {
	private final ModelRenderer starciliumGolemHead;
	private final ModelRenderer starciliumGolemBody;
	private final ModelRenderer starciliumGolemRightArm;
	private final ModelRenderer starciliumGolemLeftArm;
	private final ModelRenderer starciliumGolemLeftLeg;
	private final ModelRenderer starciliumGolemRightLeg;

	public StarciliumGolemModel() {
		int i = 128;
		int j = 128;
		this.starciliumGolemHead = (new ModelRenderer(this)).setTextureSize(128, 128);
		this.starciliumGolemHead.setRotationPoint(0.0F, -7.0F, -2.0F);
		this.starciliumGolemHead.setTextureOffset(0, 0).addBox(-4.0F, -10.0F, -4.5F, 8.0F, 9.0F, 8.0F, 0.0F);
		this.starciliumGolemHead.setTextureOffset(24, 0).addBox(-1.0F, -6.0F, -5.5F, 2.0F, 4.0F, 2.0F, 0.0F);
		this.starciliumGolemBody = (new ModelRenderer(this)).setTextureSize(128, 128);
		this.starciliumGolemBody.setRotationPoint(0.0F, -7.0F, 0.0F);
		this.starciliumGolemBody.setTextureOffset(0, 40).addBox(-9.0F, -2.0F, -6.0F, 18.0F, 12.0F, 11.0F, 0.0F);
		this.starciliumGolemBody.setTextureOffset(0, 70).addBox(-4.5F, 10.0F, -3.0F, 9.0F, 5.0F, 6.0F, 0.5F);
		this.starciliumGolemRightArm = (new ModelRenderer(this)).setTextureSize(128, 128);
		this.starciliumGolemRightArm.setRotationPoint(0.0F, -7.0F, 0.0F);
		this.starciliumGolemRightArm.setTextureOffset(60, 21).addBox(-13.0F, -2.5F, -3.0F, 4.0F, 30.0F, 6.0F, 0.0F);
		this.starciliumGolemLeftArm = (new ModelRenderer(this)).setTextureSize(128, 128);
		this.starciliumGolemLeftArm.setRotationPoint(0.0F, -7.0F, 0.0F);
		this.starciliumGolemLeftArm.setTextureOffset(60, 58).addBox(9.0F, -2.5F, -3.0F, 4.0F, 30.0F, 6.0F, 0.0F);
		this.starciliumGolemLeftLeg = (new ModelRenderer(this, 0, 22)).setTextureSize(128, 128);
		this.starciliumGolemLeftLeg.setRotationPoint(-4.0F, 11.0F, 0.0F);
		this.starciliumGolemLeftLeg.setTextureOffset(37, 0).addBox(-3.5F, -3.0F, -3.0F, 6.0F, 16.0F, 5.0F, 0.0F);
		this.starciliumGolemRightLeg = (new ModelRenderer(this, 0, 22)).setTextureSize(128, 128);
		this.starciliumGolemRightLeg.mirror = true;
		this.starciliumGolemRightLeg.setTextureOffset(60, 0).setRotationPoint(5.0F, 11.0F, 0.0F);
		this.starciliumGolemRightLeg.addBox(-3.5F, -3.0F, -3.0F, 6.0F, 16.0F, 5.0F, 0.0F);
	}

	public Iterable<ModelRenderer> getParts() {
		return ImmutableList.of(this.starciliumGolemHead, this.starciliumGolemBody, this.starciliumGolemLeftLeg, this.starciliumGolemRightLeg,
				this.starciliumGolemRightArm, this.starciliumGolemLeftArm);
	}

	/**
	 * Sets this entity's model rotation angles
	 */
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		this.starciliumGolemHead.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
		this.starciliumGolemHead.rotateAngleX = headPitch * ((float) Math.PI / 180F);
		this.starciliumGolemLeftLeg.rotateAngleX = -1.5F * MathHelper.func_233021_e_(limbSwing, 13.0F) * limbSwingAmount;
		this.starciliumGolemRightLeg.rotateAngleX = 1.5F * MathHelper.func_233021_e_(limbSwing, 13.0F) * limbSwingAmount;
		this.starciliumGolemLeftLeg.rotateAngleY = 0.0F;
		this.starciliumGolemRightLeg.rotateAngleY = 0.0F;
	}

	public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		int i = entityIn.getAttackTimer();
		if (i > 0) {
			this.starciliumGolemRightArm.rotateAngleX = -2.0F
					+ 1.5F * MathHelper.func_233021_e_((float) i - partialTick, 10.0F);
			this.starciliumGolemLeftArm.rotateAngleX = -2.0F
					+ 1.5F * MathHelper.func_233021_e_((float) i - partialTick, 10.0F);					
			} else {
				this.starciliumGolemRightArm.rotateAngleX = (-0.2F + 1.5F * MathHelper.func_233021_e_(limbSwing, 13.0F))
						* limbSwingAmount;
				this.starciliumGolemLeftArm.rotateAngleX = (-0.2F - 1.5F * MathHelper.func_233021_e_(limbSwing, 13.0F))
						* limbSwingAmount;
			}
		}

	

	public ModelRenderer getArmHoldingRose() {
		return this.starciliumGolemRightArm;
	}
}

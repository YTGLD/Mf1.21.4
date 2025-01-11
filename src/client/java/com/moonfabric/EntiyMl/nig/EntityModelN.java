package com.moonfabric.EntiyMl.nig;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.animation.WardenAnimations;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.render.entity.state.WardenEntityRenderState;
import net.minecraft.util.math.MathHelper;

import java.util.List;

public class EntityModelN extends EntityModel<WardenEntityRenderState> {
    private static final float field_38324 = 13.0F;
    private static final float field_38325 = 1.0F;
    protected final ModelPart bone;
    protected final ModelPart body;
    protected final ModelPart head;
    protected final ModelPart rightTendril;
    protected final ModelPart leftTendril;
    protected final ModelPart leftLeg;
    protected final ModelPart leftArm;
    protected final ModelPart leftRibcage;
    protected final ModelPart rightArm;
    protected final ModelPart rightLeg;
    protected final ModelPart rightRibcage;
    private final List<ModelPart> tendrils;
    private final List<ModelPart> justBody;
    private final List<ModelPart> headAndLimbs;
    private final List<ModelPart> bodyHeadAndLimbs;

    public EntityModelN(ModelPart modelPart) {
        super(modelPart, RenderLayer::getEntityCutoutNoCull);
        this.bone = modelPart.getChild(EntityModelPartNames.BONE);
        this.body = this.bone.getChild(EntityModelPartNames.BODY);
        this.head = this.body.getChild(EntityModelPartNames.HEAD);
        this.rightLeg = this.bone.getChild(EntityModelPartNames.RIGHT_LEG);
        this.leftLeg = this.bone.getChild(EntityModelPartNames.LEFT_LEG);
        this.rightArm = this.body.getChild(EntityModelPartNames.RIGHT_ARM);
        this.leftArm = this.body.getChild(EntityModelPartNames.LEFT_ARM);
        this.rightTendril = this.head.getChild(EntityModelPartNames.RIGHT_TENDRIL);
        this.leftTendril = this.head.getChild(EntityModelPartNames.LEFT_TENDRIL);
        this.rightRibcage = this.body.getChild(EntityModelPartNames.RIGHT_RIBCAGE);
        this.leftRibcage = this.body.getChild(EntityModelPartNames.LEFT_RIBCAGE);
        this.tendrils = ImmutableList.of(this.leftTendril, this.rightTendril);
        this.justBody = ImmutableList.of(this.body);
        this.headAndLimbs = ImmutableList.of(this.head, this.leftArm, this.rightArm, this.leftLeg, this.rightLeg);
        this.bodyHeadAndLimbs = ImmutableList.of(this.body, this.head, this.leftArm, this.rightArm, this.leftLeg, this.rightLeg);
    }

    public void setAngles(WardenEntityRenderState wardenEntityRenderState) {
        super.setAngles(wardenEntityRenderState);
        this.setHeadAngle(wardenEntityRenderState.yawDegrees, wardenEntityRenderState.pitch);
        this.setLimbAngles(wardenEntityRenderState.limbFrequency, wardenEntityRenderState.limbAmplitudeMultiplier);
        this.setHeadAndBodyAngles(wardenEntityRenderState.age);
        this.setTendrilPitches(wardenEntityRenderState, wardenEntityRenderState.age);
        this.animate(wardenEntityRenderState.attackingAnimationState, WardenAnimations.ATTACKING, wardenEntityRenderState.age);
        this.animate(wardenEntityRenderState.chargingSonicBoomAnimationState, WardenAnimations.CHARGING_SONIC_BOOM, wardenEntityRenderState.age);
        this.animate(wardenEntityRenderState.diggingAnimationState, WardenAnimations.DIGGING, wardenEntityRenderState.age);
        this.animate(wardenEntityRenderState.emergingAnimationState, WardenAnimations.EMERGING, wardenEntityRenderState.age);
        this.animate(wardenEntityRenderState.roaringAnimationState, WardenAnimations.ROARING, wardenEntityRenderState.age);
        this.animate(wardenEntityRenderState.sniffingAnimationState, WardenAnimations.SNIFFING, wardenEntityRenderState.age);
    }

    private void setHeadAngle(float yaw, float pitch) {
        this.head.pitch = pitch * (float) (Math.PI / 180.0);
        this.head.yaw = yaw * (float) (Math.PI / 180.0);
    }

    private void setHeadAndBodyAngles(float animationProgress) {
        float f = animationProgress * 0.1F;
        float g = MathHelper.cos(f);
        float h = MathHelper.sin(f);
        this.head.roll += 0.06F * g;
        this.head.pitch += 0.06F * h;
        this.body.roll += 0.025F * h;
        this.body.pitch += 0.025F * g;

        this.body.pitch  += 35 * 0.017453292F;


    }

    private void setLimbAngles(float angle, float distance) {
        float f = Math.min(0.5F, 3.0F * distance);
        float g = angle * 0.8662F;
        float h = MathHelper.cos(g);
        float i = MathHelper.sin(g);
        float j = Math.min(0.35F, f);
        this.head.roll += 0.3F * i * f;
        this.head.pitch = this.head.pitch + 1.2F * MathHelper.cos(g + (float) (Math.PI / 2)) * j;
        this.body.roll = 0.1F * i * f;
        this.body.pitch = 1.0F * h * j;
        this.leftLeg.pitch = 1.0F * h * f;
        this.rightLeg.pitch = 1.0F * MathHelper.cos(g + (float) Math.PI) * f;
        this.leftArm.pitch = -(0.8F * h * f);
        this.leftArm.roll = 0.0F;
        this.rightArm.pitch = -(0.8F * i * f);
        this.rightArm.roll = 0.0F;
        this.setArmPivots();
    }

    private void setArmPivots() {
        this.leftArm.yaw = 0.0F;
        this.leftArm.pivotZ = 1.0F;
        this.leftArm.pivotX = 13.0F;
        this.leftArm.pivotY = -13.0F;
        this.rightArm.yaw = 0.0F;
        this.rightArm.pivotZ = 1.0F;
        this.rightArm.pivotX = -13.0F;
        this.rightArm.pivotY = -13.0F;


        this.leftArm.pitch  -= 35 * 0.017453292F;

        this.rightArm.pitch  -= 35 * 0.017453292F;

    }

    private void setTendrilPitches(WardenEntityRenderState state, float animationProgress) {
        float f = state.tendrilAlpha * (float)(Math.cos((double)animationProgress * 2.25) * Math.PI * 0.1F);
        this.leftTendril.pitch = f;
        this.rightTendril.pitch = -f;
    }

    public List<ModelPart> getTendrils(WardenEntityRenderState state) {
        return this.tendrils;
    }

    public List<ModelPart> getBody(WardenEntityRenderState state) {
        return this.justBody;
    }

    public List<ModelPart> getHeadAndLimbs(WardenEntityRenderState state) {
        return this.headAndLimbs;
    }

    public List<ModelPart> getBodyHeadAndLimbs(WardenEntityRenderState state) {
        return this.bodyHeadAndLimbs;
    }
}


package com.moonfabric.EntiyMl;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.CrossbowPosing;
import net.minecraft.client.render.entity.state.ZombieEntityRenderState;

public abstract class AbstractZombieModel <S extends ZombieEntityRenderState> extends BipedEntityModel<S> {
    protected AbstractZombieModel(ModelPart modelPart) {
        super(modelPart);
    }

    public void setAngles(S zombieLivingEntityRenderState) {
        super.setAngles(zombieLivingEntityRenderState);
        float f = zombieLivingEntityRenderState.handSwingProgress;
        CrossbowPosing.meleeAttack(this.leftArm, this.rightArm, zombieLivingEntityRenderState.attacking, f, zombieLivingEntityRenderState.age);
    }
}

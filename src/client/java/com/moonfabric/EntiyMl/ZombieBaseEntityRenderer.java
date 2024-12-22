package com.moonfabric.EntiyMl;

import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.ZombieEntityModel;
import net.minecraft.client.render.entity.state.ZombieEntityRenderState;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.util.Identifier;

public abstract class ZombieBaseEntityRenderer<T extends TameableEntity, S extends ZombieEntityRenderState, M extends ZombieEntityModel<S>> extends BipedEntityRenderer<T, S, M> {
    private static final Identifier TEXTURE = Identifier.ofVanilla("textures/entity/zombie/zombie.png");

    protected ZombieBaseEntityRenderer(EntityRendererFactory.Context context, M mainModel, M babyMainModel, M armorInnerModel, M armorOuterModel, M babyArmorInnerModel, M babyArmorOuterModel) {
        super(context, mainModel, babyMainModel, 0.5F);
        this.addFeature(new ArmorFeatureRenderer(this, armorInnerModel, armorOuterModel, babyArmorInnerModel, babyArmorOuterModel, context.getEquipmentRenderer()));
    }

    public Identifier getTexture(S zombieLivingEntityRenderState) {
        return TEXTURE;
    }


    public void updateRenderState(T zombieEntity, S zombieLivingEntityRenderState, float f) {
        super.updateRenderState(zombieEntity, zombieLivingEntityRenderState, f);
        zombieLivingEntityRenderState.attacking = zombieEntity.isAttacking();
    }

    protected boolean isShaking(S zombieLivingEntityRenderState) {
        return super.isShaking(zombieLivingEntityRenderState) || zombieLivingEntityRenderState.convertingInWater;
    }
}

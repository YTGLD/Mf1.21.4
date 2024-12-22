package com.moonfabric.EntiyMl;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.ZombieEntityModel;
import net.minecraft.client.render.entity.state.ZombieEntityRenderState;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.util.Identifier;

public class ZombieEntityRenderer  extends ZombieBaseEntityRenderer<TameableEntity, ZombieEntityRenderState, ZombieEntityModel<ZombieEntityRenderState>> {
    private static final Identifier TEXTURE = Identifier.ofVanilla("textures/entity/zombie/zombie.png");

    public ZombieEntityRenderer(EntityRendererFactory.Context context) {
        this(context, EntityModelLayers.ZOMBIE, EntityModelLayers.ZOMBIE_BABY, EntityModelLayers.ZOMBIE_INNER_ARMOR, EntityModelLayers.ZOMBIE_OUTER_ARMOR, EntityModelLayers.ZOMBIE_BABY_INNER_ARMOR, EntityModelLayers.ZOMBIE_BABY_OUTER_ARMOR);
    }

    public ZombieEntityRenderState createRenderState() {
        return new ZombieEntityRenderState();
    }

    public ZombieEntityRenderer(EntityRendererFactory.Context ctx, EntityModelLayer layer, EntityModelLayer legsArmorLayer, EntityModelLayer bodyArmorLayer, EntityModelLayer entityModelLayer, EntityModelLayer entityModelLayer2, EntityModelLayer entityModelLayer3) {
        super(ctx, new net.minecraft.client.render.entity.model.ZombieEntityModel(ctx.getPart(layer)), new net.minecraft.client.render.entity.model.ZombieEntityModel(ctx.getPart(legsArmorLayer)), new net.minecraft.client.render.entity.model.ZombieEntityModel(ctx.getPart(bodyArmorLayer)), new net.minecraft.client.render.entity.model.ZombieEntityModel(ctx.getPart(entityModelLayer)), new net.minecraft.client.render.entity.model.ZombieEntityModel(ctx.getPart(entityModelLayer2)), new net.minecraft.client.render.entity.model.ZombieEntityModel(ctx.getPart(entityModelLayer3)));
    }
}


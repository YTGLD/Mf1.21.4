package com.moonfabric.EntiyMl;

import com.moonfabric.Entity.flysword;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.ArrowEntityRenderState;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;

public class FlyEntityRenderer<T extends flysword> extends EntityRenderer<T, ArrowEntityRenderState> {
    public FlyEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }


    @Override
    public ArrowEntityRenderState createRenderState() {
        return new ArrowEntityRenderState();
    }

}

package com.moonfabric.EntiyMl;

import com.moonfabric.Entity.flysword;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;

public class FlyEntityRenderer<T extends flysword> extends EntityRenderer<T, LivingEntityRenderState> {
    public FlyEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public LivingEntityRenderState createRenderState() {
        return new LivingEntityRenderState();
    }

}

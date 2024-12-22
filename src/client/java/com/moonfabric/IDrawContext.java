package com.moonfabric;

import net.minecraft.client.render.VertexConsumerProvider;

public interface IDrawContext {
    VertexConsumerProvider.Immediate vertexConsumers();

}

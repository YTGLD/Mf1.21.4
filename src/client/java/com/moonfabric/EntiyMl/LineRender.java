package com.moonfabric.EntiyMl;

import com.moonfabric.Entity.line;
import com.moonfabric.Entity.owner_blood;
import com.moonfabric.Handler;
import io.wispforest.accessories.pond.LivingEntityRenderStateExtension;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;

public class LineRender <T extends line> extends EntityRenderer<T, LivingEntityRenderState> {
    public LineRender(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public LivingEntityRenderState createRenderState() {
        return new LivingEntityRenderState();
    }
    @Override
    public void render(LivingEntityRenderState state, MatrixStack matrixStack, VertexConsumerProvider vertexConsumers, int light) {
        super.render(state, matrixStack, vertexConsumers, light);
        if (state instanceof LivingEntityRenderStateExtension e){
            if (e.getEntity() instanceof line t) {
                setT(matrixStack, t, vertexConsumers);
            }
        }
    }
    private void setT(MatrixStack matrices,
                      line entity,
                      VertexConsumerProvider vertexConsumers){

        matrices.push();
        matrices.multiply(RotationAxis.NEGATIVE_Z.rotationDegrees(0));
        matrices.multiply(RotationAxis.NEGATIVE_X.rotationDegrees(0));
        matrices.multiply(RotationAxis.NEGATIVE_Y.rotationDegrees(0));
        for (int i = 1; i < entity.getTrailPositions().size(); i++){
            Vec3d prevPos = entity.getTrailPositions().get(i - 1);
            Vec3d currPos = entity.getTrailPositions().get(i);
            Vec3d adjustedPrevPos = new Vec3d(prevPos.x - entity.getX(), prevPos.y - entity.getY(), prevPos.z - entity.getZ());
            Vec3d adjustedCurrPos = new Vec3d(currPos.x - entity.getX(), currPos.y - entity.getY(), currPos.z - entity.getZ());

            float alpha = (float)(i) / (float)(entity.getTrailPositions().size());

            Handler.renderLine(matrices, vertexConsumers, adjustedPrevPos, adjustedCurrPos, alpha, RenderLayer.getLightning(),0.075f);

        }
        matrices.pop();

    }
}


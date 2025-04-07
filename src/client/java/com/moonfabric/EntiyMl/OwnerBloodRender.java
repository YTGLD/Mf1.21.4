package com.moonfabric.EntiyMl;

import com.moonfabric.Entity.owner_blood;
import com.moonfabric.EntiyMl.state.OwnerBloodState;
import com.moonfabric.Handler;
import com.moonfabric.MRender;
import com.moonfabric.MoonFabricMod;
import io.wispforest.accessories.pond.LivingEntityRenderStateExtension;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.*;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.BakedQuad;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.*;
import net.minecraft.util.math.random.Random;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;

import java.util.List;

public class OwnerBloodRender <T extends owner_blood> extends EntityRenderer<T, OwnerBloodState> {
    public OwnerBloodRender(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public OwnerBloodState createRenderState() {
        return new OwnerBloodState();
    }

    @Override
    public boolean shouldRender(T entity, Frustum frustum, double x, double y, double z) {
        return true;
    }

    @Override
    public void updateRenderState(T entity, OwnerBloodState state, float tickDelta) {
        super.updateRenderState(entity, state, tickDelta);
        state.tickDelta = tickDelta;
    }

    @Override
    public void render(OwnerBloodState state, MatrixStack matrixStack, VertexConsumerProvider vertexConsumers, int light) {
        super.render(state, matrixStack, vertexConsumers, light);


        if (state instanceof LivingEntityRenderStateExtension e){


            LivingEntity entity  = e.accessories$getEntity().get();

            double x = MathHelper.lerp(state.tickDelta, entity.lastRenderX, entity.getX());
            double y = MathHelper.lerp(state.tickDelta, entity.lastRenderY, entity.getY());
            double z = MathHelper.lerp(state.tickDelta, entity.lastRenderZ, entity.getZ());
            matrixStack.push();


            matrixStack.translate(-x, -y, -z);

            if (MoonFabricMod.CONFIG.isLight()) {
                setMatrices(matrixStack, vertexConsumers, entity);
            }
            if (e.accessories$getEntity().isPresent() &&e.accessories$getEntity().get() instanceof owner_blood t) {
                renderTrail(t,state.tickDelta,matrixStack,vertexConsumers,1,0,0,240);
            }

            matrixStack.pop();
        }

        getBloodOutLine(matrixStack,vertexConsumers,240,0.6f);
    }
    private void renderTrail(owner_blood entityIn, float partialTicks, MatrixStack poseStack, VertexConsumerProvider bufferIn, float trailR, float trailG, float trailB, int packedLightIn) {
        int samples = 0;
        int sampleSize = owner_blood.max;
        float as = 0.3f; // 调整高度
        float trailZRot = 0;
        Vec3d topAngleVec = new Vec3d(as, as, as).rotateZ(trailZRot);
        Vec3d bottomAngleVec = new Vec3d(-as, -as, as).rotateZ(trailZRot);
        Vec3d drawFrom = entityIn.getTrailPosition(0, partialTicks);
        VertexConsumer vertexconsumer = bufferIn.getBuffer(MRender.LIGHTNING);

        while (samples < sampleSize - 1) { // 减少一个采样点以避免访问越界
            Vec3d sample = entityIn.getTrailPosition(samples + 1, partialTicks); // 修改这里的指针偏移量
            float u1 = samples / (float) sampleSize;
            float u2 = u1 + 1 / (float) sampleSize;

            // 计算动态透明度
            float alpha1 = 1 - u1; // 从1到0
            float alpha2 = 1 - u2; // 从1到0

            Vec3d draw1 = drawFrom;

            MatrixStack.Entry posestack$pose = poseStack.peek();
            Matrix4f matrix4f = posestack$pose.getPositionMatrix();

            // 添加四边形的四个顶点
            vertexconsumer.vertex(matrix4f, (float) draw1.x + (float) bottomAngleVec.x, (float) draw1.y + (float) bottomAngleVec.y, (float) draw1.z + (float) bottomAngleVec.z).color(trailR, trailG, trailB, alpha1).texture(0, 0).overlay(OverlayTexture.DEFAULT_UV).light(packedLightIn,240).normal(0.0F, 0.0F, 0.0F);
            vertexconsumer.vertex(matrix4f, (float) sample.x + (float) bottomAngleVec.x, (float) sample.y + (float) bottomAngleVec.y, (float) sample.z + (float) bottomAngleVec.z).color(trailR, trailG, trailB, alpha2).texture(0, 0).overlay(OverlayTexture.DEFAULT_UV).light(packedLightIn,240).normal(0.0F, 0.0F, 0.0F);
            vertexconsumer.vertex(matrix4f, (float) sample.x + (float) topAngleVec.x, (float) sample.y + (float) topAngleVec.y, (float) sample.z + (float) topAngleVec.z).color(trailR, trailG, trailB, alpha2).texture(0, 0).overlay(OverlayTexture.DEFAULT_UV).light(packedLightIn,240).normal(0.0F, 0.0F, 0.0F);
            vertexconsumer.vertex(matrix4f, (float) draw1.x + (float) topAngleVec.x, (float) draw1.y + (float) topAngleVec.y, (float) draw1.z + (float) topAngleVec.z).color(trailR, trailG, trailB, alpha1).texture(0, 0).overlay(OverlayTexture.DEFAULT_UV).light(packedLightIn,240).normal(0.0F, 0.0F, 0.0F);

            samples++;
            drawFrom = sample;
        }
    }

    public void getBloodOutLine(@NotNull MatrixStack matrices, @NotNull VertexConsumerProvider vertexConsumers, int light, float s) {
        {
            int stacks = 16; // 垂直方向的分割数
            int slices = 16; // 水平方向的分割数
            VertexConsumer vertexConsumer = vertexConsumers.getBuffer(MRender.BLOOD_OUTLINE);
            for (int i = 0; i < stacks; ++i) {
                float phi0 = (float) Math.PI * ((i + 0) / (float) stacks);
                float phi1 = (float) Math.PI * ((i + 1) / (float) stacks);

                for (int j = 0; j < slices; ++j) {
                    float theta0 = (float) (2 * Math.PI) * ((j + 0) / (float) slices);
                    float theta1 = (float) (2 * Math.PI) * ((j + 1) / (float) slices);

                    float x0 = s * (float) Math.sin(phi0) * (float) Math.cos(theta0);
                    float y0 = s * (float) Math.cos(phi0);
                    float z0 = s * (float) Math.sin(phi0) * (float) Math.sin(theta0);

                    float x1 = s * (float) Math.sin(phi0) * (float) Math.cos(theta1);
                    float y1 = s * (float) Math.cos(phi0);
                    float z1 = s * (float) Math.sin(phi0) * (float) Math.sin(theta1);

                    float x2 = s * (float) Math.sin(phi1) * (float) Math.cos(theta1);
                    float y2 = s * (float) Math.cos(phi1);
                    float z2 = s * (float) Math.sin(phi1) * (float) Math.sin(theta1);

                    float x3 = s * (float) Math.sin(phi1) * (float) Math.cos(theta0);
                    float y3 = s * (float) Math.cos(phi1);
                    float z3 = s * (float) Math.sin(phi1) * (float) Math.sin(theta0);

                    vertexConsumer.vertex(matrices.peek().getPositionMatrix(), x0, y0, z0).color(1.0f, 1.0f, 1.0f, 1.0f).overlay(OverlayTexture.DEFAULT_UV).light(light, light).normal(1, 0, 0);
                    vertexConsumer.vertex(matrices.peek().getPositionMatrix(), x1, y1, z1).color(1.0f, 1.0f, 1.0f, 1.0f).overlay(OverlayTexture.DEFAULT_UV).light(light, light).normal(1, 0, 0);
                    vertexConsumer.vertex(matrices.peek().getPositionMatrix(), x2, y2, z2).color(1.0f, 1.0f, 1.0f, 1.0f).overlay(OverlayTexture.DEFAULT_UV).light(light, light).normal(1, 0, 0);
                    vertexConsumer.vertex(matrices.peek().getPositionMatrix(), x3, y3, z3).color(1.0f, 1.0f, 1.0f, 1.0f).overlay(OverlayTexture.DEFAULT_UV).light(light, light).normal(1, 0, 0);
                }
            }
        }
        int stacks = 16; // 垂直方向的分割数
        int slices = 16; // 水平方向的分割数
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(MRender.getBloodCommon());
        for (int i = 0; i < stacks; ++i) {
            float phi0 = (float) Math.PI * ((i + 0) / (float) stacks);
            float phi1 = (float) Math.PI * ((i + 1) / (float) stacks);

            for (int j = 0; j < slices; ++j) {
                float theta0 = (float) (2 * Math.PI) * ((j + 0) / (float) slices);
                float theta1 = (float) (2 * Math.PI) * ((j + 1) / (float) slices);

                float x0 = s * (float) Math.sin(phi0) * (float) Math.cos(theta0);
                float y0 = s * (float) Math.cos(phi0);
                float z0 = s * (float) Math.sin(phi0) * (float) Math.sin(theta0);

                float x1 = s * (float) Math.sin(phi0) * (float) Math.cos(theta1);
                float y1 = s * (float) Math.cos(phi0);
                float z1 = s * (float) Math.sin(phi0) * (float) Math.sin(theta1);

                float x2 = s * (float) Math.sin(phi1) * (float) Math.cos(theta1);
                float y2 = s * (float) Math.cos(phi1);
                float z2 = s * (float) Math.sin(phi1) * (float) Math.sin(theta1);

                float x3 = s * (float) Math.sin(phi1) * (float) Math.cos(theta0);
                float y3 = s * (float) Math.cos(phi1);
                float z3 = s * (float) Math.sin(phi1) * (float) Math.sin(theta0);

                vertexConsumer.vertex(matrices.peek().getPositionMatrix(), x0, y0, z0).color(1.0f, 1.0f, 1.0f, 1.0f).overlay(OverlayTexture.DEFAULT_UV).light(light, light).normal(1, 0, 0);
                vertexConsumer.vertex(matrices.peek().getPositionMatrix(), x1, y1, z1).color(1.0f, 1.0f, 1.0f, 1.0f).overlay(OverlayTexture.DEFAULT_UV).light(light, light).normal(1, 0, 0);
                vertexConsumer.vertex(matrices.peek().getPositionMatrix(), x2, y2, z2).color(1.0f, 1.0f, 1.0f, 1.0f).overlay(OverlayTexture.DEFAULT_UV).light(light, light).normal(1, 0, 0);
                vertexConsumer.vertex(matrices.peek().getPositionMatrix(), x3, y3, z3).color(1.0f, 1.0f, 1.0f, 1.0f).overlay(OverlayTexture.DEFAULT_UV).light(light, light).normal(1, 0, 0);
            }
        }
    }
    public void setMatrices(MatrixStack matrices, VertexConsumerProvider vertexConsumers, Entity ownerBlood) {
        int rage = 12;
        float posAdd = 1.001F;

        BlockPos playerPos = ownerBlood.getBlockPos();
        Vec3d playerVec = new Vec3d(playerPos.getX(), playerPos.getY(), playerPos.getZ());

        for (int x = -rage; x <= rage; x++) {
            for (int y = -rage; y <= rage; y++) {
                for (int z = -rage; z <= rage; z++) {
                    BlockPos currentPos = playerPos.add(x, y, z);
                    Vec3d currentVec = new Vec3d(currentPos.getX(), currentPos.getY(), currentPos.getZ());
                    BlockState blockState = ownerBlood.getWorld().getBlockState(currentPos);
                    if (!blockState.isAir() && blockState.isOpaque()) {
                        matrices.push();

                        matrices.translate(currentPos.getX() + 0.5, currentPos.getY() + 0.5, currentPos.getZ() + 0.5);

                        matrices.scale(posAdd, posAdd, posAdd);

                        matrices.translate(-(currentPos.getX() + 0.5), -(currentPos.getY() + 0.5), -(currentPos.getZ() + 0.5));

                        matrices.translate(currentPos.getX(), currentPos.getY(), currentPos.getZ());

                        double distance = playerVec.distanceTo(currentVec);

                        float alp = Math.max(0, 1 - (float) distance / rage);

                        BakedModel bakedModel = MinecraftClient.getInstance().getBlockRenderManager().getModel(blockState);
                        for (Direction direction : Direction.values()) {
                            BlockPos offsetPos = currentPos.offset(direction);
                            if (!ownerBlood.getWorld().getBlockState(offsetPos).isSolid()) {
                                List<BakedQuad> quads = bakedModel.getQuads(blockState, direction, Random.create());
                                for (BakedQuad quad : quads) {
                                    vertexConsumers.getBuffer(MRender.LIGHTNING).quad(matrices.peek(), quad, new float[]{
                                            1.32f, 1.32f, 1.32f, 1.32f
                                    }, 1, 0, 0, alp, new int[]{240, 240, 240, 240}, OverlayTexture.DEFAULT_UV, true);
                                }
                            }
                        }

                        matrices.pop();
                    }
                }
            }
        }
    }



}




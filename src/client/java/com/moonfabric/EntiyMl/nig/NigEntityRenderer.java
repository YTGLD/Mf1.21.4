package com.moonfabric.EntiyMl.nig;

import com.moonfabric.*;
import com.moonfabric.Entity.attack_blood;
import com.moonfabric.Entity.cell_zombie;
import com.moonfabric.Entity.nightmare_giant;
import io.wispforest.accessories.pond.LivingEntityRenderStateExtension;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.*;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.EmissiveFeatureRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.WardenEntityModel;
import net.minecraft.client.render.entity.state.WardenEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class NigEntityRenderer  extends MobEntityRenderer<nightmare_giant, WardenEntityRenderState, EntityModelN> {
    private static final Identifier TEXTURE = Identifier.of(MoonFabricMod.MODID,"textures/entity/nightmare_giant.png");
    private static final Identifier PULSATING_SPOTS_1_TEXTURE = Identifier.of(MoonFabricMod.MODID,"textures/entity/nig_boot.png");
    private static final Identifier PULSATING_SPOTS_2_TEXTURE = Identifier.of(MoonFabricMod.MODID,"textures/entity/nig_boot_2.png");

    public NigEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new EntityModelN(context.getPart(EntityModelLayers.WARDEN)), 0.9F);

        this.addFeature(
                new EmissiveFeatureRenderer<>(
                        this,
                        PULSATING_SPOTS_1_TEXTURE,
                        (state, tickDelta) -> Math.max(0.0F, MathHelper.cos(tickDelta * 0.045F) * 0.25F),
                        EntityModelN::getBodyHeadAndLimbs,
                        RenderLayer::getEntityTranslucentEmissive,
                        false
                )
        );
        this.addFeature(
                new EmissiveFeatureRenderer<>(
                        this,
                        PULSATING_SPOTS_2_TEXTURE,
                        (state, tickDelta) -> Math.max(0.0F, MathHelper.cos(tickDelta * 0.045F + (float) Math.PI) * 0.25F),
                        EntityModelN::getBodyHeadAndLimbs,
                        RenderLayer::getEntityTranslucentEmissive,
                        false
                )
        );
    }

    @Override
    public void render(WardenEntityRenderState livingLivingEntityRenderState, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(livingLivingEntityRenderState,matrixStack,vertexConsumerProvider,i);
        matrixStack.push();
        matrixStack.translate(0,1.7,-0.15);
        renderSphereBlood(matrixStack,vertexConsumerProvider,240,0.35f);
        matrixStack.pop();
        if (livingLivingEntityRenderState instanceof LivingEntityRenderStateExtension e) {
            if (e.accessories$getEntity().isPresent()&&e.accessories$getEntity().get() instanceof nightmare_giant nightmareGiant) {
                Vec3d playerPos = nightmareGiant.getPos();
                float range = 16;
                List<cell_zombie> entities =
                        nightmareGiant.getWorld().getEntitiesByClass(cell_zombie.class,
                                new Box(playerPos.x - range,
                                        playerPos.y - range,
                                        playerPos.z - range,
                                        playerPos.x + range,
                                        playerPos.y + range,
                                        playerPos.z + range), EntityPredicates.EXCEPT_SPECTATOR);

                for (cell_zombie entity : entities) {
                    Vec3d entityPos = nightmareGiant.getPos();
                    Vec3d nearbyEntityPos = entity.getPos();

                    Vec3d end = nearbyEntityPos.subtract(entityPos);

                    Handler.renderLine(matrixStack, vertexConsumerProvider, new Vec3d(0, 2, 0), end, 1, MRender.getBlood_common(), 0.01f);
                }
            }
        }
    }

    @Override
    protected void scale(WardenEntityRenderState state, MatrixStack matrices) {
        matrices.scale(1.35f,1.35f,1.35f);
    }

    public void renderSphereBlood(@NotNull MatrixStack matrices, @NotNull VertexConsumerProvider vertexConsumers, int light, float s) {
        {
            int stacks = 20; // 垂直方向的分割数
            int slices = 20; // 水平方向的分割数
            VertexConsumer vertexConsumer = vertexConsumers.getBuffer(MRender.getBlood_common());
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

                    vertexConsumer.vertex(matrices.peek().getPositionMatrix(), x0, y0, z0).color(1.0f, 1.0f, 1.0f, 0.5f).overlay(OverlayTexture.DEFAULT_UV).light(light, light).normal(1, 0, 0);
                    vertexConsumer.vertex(matrices.peek().getPositionMatrix(), x1, y1, z1).color(1.0f, 1.0f, 1.0f, 0.5f).overlay(OverlayTexture.DEFAULT_UV).light(light, light).normal(1, 0, 0);
                    vertexConsumer.vertex(matrices.peek().getPositionMatrix(), x2, y2, z2).color(1.0f, 1.0f, 1.0f, 0.5f).overlay(OverlayTexture.DEFAULT_UV).light(light, light).normal(1, 0, 0);
                    vertexConsumer.vertex(matrices.peek().getPositionMatrix(), x3, y3, z3).color(1.0f, 1.0f, 1.0f, 0.5f).overlay(OverlayTexture.DEFAULT_UV).light(light, light).normal(1, 0, 0);
                }
            }
        }
        {
            int stacks = 20; // 垂直方向的分割数
            int slices = 20; // 水平方向的分割数
            VertexConsumer vertexConsumer = vertexConsumers.getBuffer(MRender.getBloodNIG());
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
    }


    public Identifier getTexture(WardenEntityRenderState wardenLivingEntityRenderState) {
        return TEXTURE;
    }

    public WardenEntityRenderState createRenderState() {
        return new WardenEntityRenderState();
    }

    public void updateRenderState(nightmare_giant wardenEntity, WardenEntityRenderState wardenLivingEntityRenderState, float f) {
        super.updateRenderState(wardenEntity, wardenLivingEntityRenderState, f);
        wardenLivingEntityRenderState.roaringAnimationState.copyFrom(wardenEntity.roaringAnimationState);
        wardenLivingEntityRenderState.sniffingAnimationState.copyFrom(wardenEntity.sniffingAnimationState);
        wardenLivingEntityRenderState.emergingAnimationState.copyFrom(wardenEntity.emergingAnimationState);
        wardenLivingEntityRenderState.diggingAnimationState.copyFrom(wardenEntity.diggingAnimationState);
        wardenLivingEntityRenderState.attackingAnimationState.copyFrom(wardenEntity.attackingAnimationState);
        wardenLivingEntityRenderState.chargingSonicBoomAnimationState.copyFrom(wardenEntity.chargingSonicBoomAnimationState);
    }
}

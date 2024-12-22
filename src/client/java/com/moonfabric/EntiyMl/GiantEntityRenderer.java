package com.moonfabric.EntiyMl;

import com.moonfabric.Entity.cell_giant;
import com.moonfabric.MoonFabricMod;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.EmissiveFeatureRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.WardenEntityModel;
import net.minecraft.client.render.entity.state.WardenEntityRenderState;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class GiantEntityRenderer  extends MobEntityRenderer<cell_giant, WardenEntityRenderState, WardenEntityModel> {
    private static final Identifier TEXTURE = Identifier.of(MoonFabricMod.MODID,"textures/entity/cell_giant.png");
    private static final Identifier HEART_TEXTURE = Identifier.of(MoonFabricMod.MODID,"textures/entity/hearth.png");
    private static final Identifier PULSATING_SPOTS_1_TEXTURE = Identifier.of(MoonFabricMod.MODID,"textures/entity/cell_giant_spots_1.png");
    private static final Identifier PULSATING_SPOTS_2_TEXTURE = Identifier.of(MoonFabricMod.MODID,"textures/entity/cell_giant_spots_2.png");

    public GiantEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new WardenEntityModel(context.getPart(EntityModelLayers.WARDEN)), 0.9F);

        this.addFeature(
                new EmissiveFeatureRenderer<>(
                        this,
                        PULSATING_SPOTS_1_TEXTURE,
                        (state, tickDelta) -> Math.max(0.0F, MathHelper.cos(tickDelta * 0.045F) * 0.25F),
                        WardenEntityModel::getBodyHeadAndLimbs,
                        RenderLayer::getEntityTranslucentEmissive,
                        false
                )
        );
        this.addFeature(
                new EmissiveFeatureRenderer<>(
                        this,
                        PULSATING_SPOTS_2_TEXTURE,
                        (state, tickDelta) -> Math.max(0.0F, MathHelper.cos(tickDelta * 0.045F + (float) Math.PI) * 0.25F),
                        WardenEntityModel::getBodyHeadAndLimbs,
                        RenderLayer::getEntityTranslucentEmissive,
                        false
                )
        );
        this.addFeature(
                new EmissiveFeatureRenderer<>(
                        this, TEXTURE, (state, tickDelta) -> state.tendrilAlpha, WardenEntityModel::getTendrils, RenderLayer::getEntityTranslucentEmissive, false
                )
        );
        this.addFeature(
                new EmissiveFeatureRenderer<>(
                        this, HEART_TEXTURE, (state, tickDelta) -> state.heartAlpha, WardenEntityModel::getBody, RenderLayer::getEntityTranslucentEmissive, false
                )
        );
    }

    public Identifier getTexture(WardenEntityRenderState wardenLivingEntityRenderState) {
        return TEXTURE;
    }

    public WardenEntityRenderState createRenderState() {
        return new WardenEntityRenderState();
    }

    public void updateRenderState(cell_giant wardenEntity, WardenEntityRenderState wardenLivingEntityRenderState, float f) {
        super.updateRenderState(wardenEntity, wardenLivingEntityRenderState, f);
        wardenLivingEntityRenderState.roaringAnimationState.copyFrom(wardenEntity.roaringAnimationState);
        wardenLivingEntityRenderState.sniffingAnimationState.copyFrom(wardenEntity.sniffingAnimationState);
        wardenLivingEntityRenderState.emergingAnimationState.copyFrom(wardenEntity.emergingAnimationState);
        wardenLivingEntityRenderState.diggingAnimationState.copyFrom(wardenEntity.diggingAnimationState);
        wardenLivingEntityRenderState.attackingAnimationState.copyFrom(wardenEntity.attackingAnimationState);
        wardenLivingEntityRenderState.chargingSonicBoomAnimationState.copyFrom(wardenEntity.chargingSonicBoomAnimationState);
    }
}

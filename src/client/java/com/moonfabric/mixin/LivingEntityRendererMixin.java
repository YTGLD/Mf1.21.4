package com.moonfabric.mixin;

import com.moonfabric.Sword;
import io.wispforest.accessories.pond.LivingEntityRenderStateExtension;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Optional;
//
//@Mixin(LivingEntityRenderer.class)
//public abstract class LivingEntityRendererMixin<T extends LivingEntity, S extends LivingEntityRenderState, M extends EntityModel<? super S>>
//        extends EntityRenderer<T, S>
//        implements FeatureRendererContext<S, M> {
//
//    protected LivingEntityRendererMixin(EntityRendererFactory.Context ctx) {
//        super(ctx);
//    }
//
//    @Inject(at = @At("RETURN"), method = "render(Lnet/minecraft/client/render/entity/state/LivingEntityRenderState;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V")
//    public void render(S livingEntityRenderState, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {
//        if (livingEntityRenderState instanceof LivingEntityRenderStateExtension livingEntityRenderStateExtension) {
//            Optional<LivingEntity> living = livingEntityRenderStateExtension.getEntity();
//            if (living.isPresent()) {
//                if (living.get() instanceof LivingEntity livingEntity) {
//                    matrixStack.push();
//                    new Sword(matrixStack, vertexConsumerProvider, 240, livingEntity);
//                    matrixStack.pop();
//                }
//            }
//        }
//
//        super.render(livingEntityRenderState, matrixStack, vertexConsumerProvider, i);
//    }
//
//}
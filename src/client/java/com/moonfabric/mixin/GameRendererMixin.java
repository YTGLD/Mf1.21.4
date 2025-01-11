package com.moonfabric.mixin;

import com.moonfabric.HasCurio;
import com.moonfabric.init.init;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.PostEffectProcessor;
import net.minecraft.client.render.*;
import net.minecraft.client.util.Pool;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GameRenderer.class)
public class GameRendererMixin {
    @Shadow @Final private Camera camera;

    @Shadow @Final private MinecraftClient client;

    @Shadow @Final private static Identifier field_53899;

    @Shadow @Final private Pool pool;

    @Inject(method = "render", at = @At(value = "RETURN"))
    private void render(RenderTickCounter tickCounter, boolean tick, CallbackInfo ci) {
        if (camera.getFocusedEntity() instanceof PlayerEntity player) {
            if (HasCurio.has(init.nightmare_base_black_eye, player)) {
                float f = 1;
                PostEffectProcessor postEffectProcessor = this.client.getShaderLoader().loadPostEffect(field_53899, DefaultFramebufferSet.MAIN_ONLY);
                if (postEffectProcessor != null) {
                    postEffectProcessor.setUniforms("Radius", f);
                    postEffectProcessor.render(this.client.getFramebuffer(), this.pool);
                }
            }
        }
    }
}

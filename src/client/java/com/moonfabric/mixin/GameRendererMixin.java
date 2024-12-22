package com.moonfabric.mixin;

import net.minecraft.client.render.GameRenderer;
import net.minecraft.resource.ResourceFactory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class GameRendererMixin {

    @Inject(method = "preloadPrograms", at = @At(value = "RETURN"), cancellable = true)
    private void mf$RenderLayers(ResourceFactory factory, CallbackInfo ci) {

    }
}


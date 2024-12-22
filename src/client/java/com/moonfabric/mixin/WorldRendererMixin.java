package com.moonfabric.mixin;

import com.fasterxml.jackson.core.ObjectCodec;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.moonfabric.DefaultFramebufferSets;
import com.moonfabric.MoonFabricMod;
import com.moonfabric.MoonFabricModClient;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.*;
import net.minecraft.client.render.*;
import net.minecraft.client.util.Handle;
import net.minecraft.client.util.ObjectAllocator;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Mixin(WorldRenderer.class)
public abstract class WorldRendererMixin{
    @Shadow @Final private MinecraftClient client;
    @Shadow @Final private static Identifier ENTITY_OUTLINE;
    @Shadow @Final private List<Entity> renderedEntities;
    @Shadow private Frustum frustum;
    @Shadow protected abstract boolean getEntitiesToRender(Camera camera, Frustum frustum, List<Entity> output);
    @Shadow private @Nullable Frustum capturedFrustum;
    @Unique private final DefaultFramebufferSets framebufferSet =new DefaultFramebufferSets();
    @Unique private Framebuffer entityOutlineFramebuffer;


    @Inject(method = "loadEntityOutlinePostProcessor", at = @At(value = "RETURN"))
    private void reload(CallbackInfo ci) {
        if (this.entityOutlineFramebuffer != null) {
            this.entityOutlineFramebuffer.delete();
        }

        this.entityOutlineFramebuffer = new SimpleFramebuffer(this.client.getWindow().getFramebufferWidth(), this.client.getWindow().getFramebufferHeight(), true);
        this.entityOutlineFramebuffer.setClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    }
    @Inject(method = "close", at = @At(value = "RETURN"))
    private void close(CallbackInfo ci) {
        if (this.entityOutlineFramebuffer != null) {
            this.entityOutlineFramebuffer.delete();
        }

    }
    @Inject(method = "onResized", at = @At(value = "RETURN"))
    private void onResized(int width, int height, CallbackInfo ci) {
        if (this.entityOutlineFramebuffer != null) {
            this.entityOutlineFramebuffer.resize(width, height);
        }
    }
    @Inject(method = "drawEntityOutlinesFramebuffer", at = @At(value = "RETURN"))
    private void drawEntityOutlinesFramebuffer(CallbackInfo ci) {
        RenderSystem.enableBlend();
        RenderSystem.blendFuncSeparate(GlStateManager.SrcFactor.SRC_ALPHA, GlStateManager.DstFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SrcFactor.ZERO, GlStateManager.DstFactor.ONE);
        this.entityOutlineFramebuffer.drawInternal(this.client.getWindow().getFramebufferWidth(), this.client.getWindow().getFramebufferHeight());
        RenderSystem.disableBlend();
        RenderSystem.defaultBlendFunc();
    }
    @Inject(method = "render", at = @At(value = "RETURN"))
    private void render(ObjectAllocator allocator, RenderTickCounter tickCounter, boolean renderBlockOutline, Camera camera, GameRenderer gameRenderer, Matrix4f positionMatrix, Matrix4f projectionMatrix, CallbackInfo ci) {
        if (this.entityOutlineFramebuffer != null) {
            FrameGraphBuilder frameGraphBuilder = new FrameGraphBuilder();
            DefaultFramebufferSets.entityOutlineFramebuffer = frameGraphBuilder.createObjectNode("entity_outline", this.entityOutlineFramebuffer);
        }
    }

    @Inject(method = "renderMain", at = @At(value = "RETURN"))
    private void renderMain(FrameGraphBuilder frameGraphBuilder, Frustum frustum, Camera camera, Matrix4f positionMatrix, Matrix4f projectionMatrix, Fog fog, boolean renderBlockOutline, boolean renderEntityOutlines, RenderTickCounter renderTickCounter, Profiler profiler, CallbackInfo ci) {
        RenderPass renderPass = frameGraphBuilder.createPass("moonfabric_m");

        if ( DefaultFramebufferSets.entityOutlineFramebuffer != null) {
            DefaultFramebufferSets.entityOutlineFramebuffer = renderPass.transfer(DefaultFramebufferSets.entityOutlineFramebuffer);
        }

        Handle<Framebuffer> handle = DefaultFramebufferSets.mainFramebuffer;
        Handle<Framebuffer> handle5 = DefaultFramebufferSets.entityOutlineFramebuffer;

        renderPass.setRenderer(() -> {
            if (handle5 != null) {
                handle5.get().setClearColor(0.0F, 0.0F, 0.0F, 0.0F);
                handle5.get().clear();
                handle.get().beginWrite(false);
            }
        });

        int i = this.client.getFramebuffer().textureWidth;
        int j = this.client.getFramebuffer().textureHeight;


        try {
            PostEffectProcessor postEffectProcessor2 = this.client.getShaderLoader().loadPostEffect(MoonFabricModClient.POST, Set.of(DefaultFramebufferSets.MAIN,DefaultFramebufferSets.ENTITY_OUTLINE));

            if (postEffectProcessor2 != null) {
                postEffectProcessor2.render(frameGraphBuilder, i, j, this.framebufferSet);
            }
        }catch (Exception e){
             MoonFabricMod.LOGGER.error(String.valueOf(e));
        }

    }
}

package com.moonfabric;

import com.google.gson.JsonSyntaxException;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gl.PostEffectProcessor;
import net.minecraft.client.gl.SimpleFramebuffer;
import net.minecraft.client.render.DefaultFramebufferSet;
import net.minecraft.client.render.FrameGraphBuilder;
import net.minecraft.client.render.RenderPass;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.*;

public class MoonPost {
//
//    public static final Map<Identifier, MoonPost.PostEffect> postEffects = new HashMap<>();
//
//    public static void clear() {
//
//        for(MoonPost.PostEffect postEffect : postEffects.values()){
//            postEffect.close();
//        }
//        postEffects.clear();
//    }
//
//    public static void onInitializeOutline(MinecraftClient minecraft,Framebuffer mFramebuffer) {
//        clear();
//        PostEffectProcessor postChain = minecraft.getShaderLoader().loadPostEffect(MoonFabricModClient.POST, Set.of(DefaultFramebufferSets.MAIN, DefaultFramebufferSets.ENTITY_OUTLINE));
//
//        postEffects.put(MoonFabricModClient.POST,
//                new PostEffect(postChain, mFramebuffer, false));
//    }
//
//    public static void rrr(Framebuffer mFramebuffer){
//        if (mFramebuffer!=null) {
//            mFramebuffer.setClearColor(0, 0, 0, 0);
//            mFramebuffer.clear();
//            mFramebuffer.beginWrite(false);
//        }
//    }
//
//    public static void resize(int x, int y) {
//        for (MoonPost.PostEffect postEffect : postEffects.values()) {
//            postEffect.setupDimensions(x, y);
//        }
//    }
//
//    public static Framebuffer getFramebufferFor(Identifier resourceLocation) {
//        MoonPost.PostEffect effect = postEffects.get(resourceLocation);
//
//        if (effect.getFramebuffer()!=null) {
//            return effect.getFramebuffer();
//        }else return null;
//    }
//
//    public static void renderEffectForNextTick(Identifier resourceLocation) {
//        MoonPost.PostEffect effect = postEffects.get(resourceLocation);
//        if (effect != null) {
//            effect.setEnabled(true);
//        }
//    }
//
//    public static void blitEffects(MinecraftClient minecraft) {
//        RenderSystem.enableBlend();
//        RenderSystem.enableDepthTest();
//        RenderSystem.blendFuncSeparate(GlStateManager.SrcFactor.SRC_ALPHA, GlStateManager.DstFactor.ONE, GlStateManager.SrcFactor.ONE, GlStateManager.DstFactor.ZERO);
//
//        for (MoonPost.PostEffect postEffect : postEffects.values()) {
//            if (postEffect.getFramebuffer()!= null) {
//                if (postEffect.postChain != null && postEffect.isEnabled()) {
//                    postEffect.getFramebuffer().draw(minecraft.getWindow().getWidth(), minecraft.getWindow().getHeight());
//                    postEffect.getFramebuffer().clear();
//                    postEffect.setEnabled(false);
//                }
//            }
//        }
//        RenderSystem.disableBlend();
//        RenderSystem.defaultBlendFunc();
//    }
//
//    public static void clearAndBindWrite(Framebuffer mainTarget) {
//        for (MoonPost.PostEffect postEffect : postEffects.values()) {
//            if (postEffect.isEnabled() && postEffect.postChain != null&&postEffect.getFramebuffer()!=null) {
//                postEffect.setClearColor();
//                postEffect.getFramebuffer().clear();
//                mainTarget.beginWrite(false);
//            }
//        }
//    }
//
//    public static class PostEffect {
//        public final PostEffectProcessor postChain;
//        private final Framebuffer renderTarget;
//        private boolean enabled;
//
//        public PostEffect(PostEffectProcessor postChain, Framebuffer renderTarget, boolean enabled) {
//            this.postChain = postChain;
//            this.renderTarget = renderTarget;
//            this.enabled = enabled;
//        }
//
//        public Framebuffer getFramebuffer() {
//            return renderTarget;
//        }
//
//        public boolean isEnabled() {
//            return enabled;
//        }
//
//        public void setEnabled(boolean enabled) {
//            this.enabled = enabled;
//        }
//
//        public void close() {
//            if (renderTarget != null) {
//                renderTarget.clear();
//            }
//        }
//
//        public void setClearColor(){
//            if (renderTarget != null) {
//                renderTarget.setClearColor(0,0,0,0);
//            }
//        }
//        public void setupDimensions(int x, int y) {
//            if (renderTarget != null) {
//                renderTarget.resize(x, y);
//            }
//        }
//    }
}


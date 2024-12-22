package com.moonfabric;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gl.PostEffectProcessor;
import net.minecraft.client.render.DefaultFramebufferSet;
import net.minecraft.client.render.FrameGraphBuilder;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class MoonPost {

//
//    private static final List<Identifier> registry = new ArrayList<>();
//
//    private static final Map<Identifier, PostEffect> postEffects = new HashMap<>();
//
//    public static void clear() {
//        for(PostEffect postEffect : postEffects.values()){
//            postEffect.close();
//        }
//        postEffects.clear();
//    }
//
//    public static void onInitializeOutline(MinecraftClient minecraft, FrameGraphBuilder frameGraphBuilder,
//                                           int i ,
//                                           int j, DefaultFramebufferSet framebufferSet, @Nullable Framebuffer entityOutlineFramebuffer) {
//        registry.add(MoonFabricModClient.POST);
//        clear();
//        for (Identifier resourceLocation : registry) {
//            PostEffectProcessor postChain;
//            Framebuffer renderTarget = entityOutlineFramebuffer;
//            try {
//                postChain = minecraft.getShaderLoader().loadPostEffect(resourceLocation, DefaultFramebufferSet.MAIN_AND_ENTITY_OUTLINE);
//                if (postChain != null) {
//                    postChain.render(frameGraphBuilder,i,j,framebufferSet);
//                }
//                if (DefaultFramebufferSets.entityOutlineFramebuffer!=null) {
//                    renderTarget = DefaultFramebufferSets.entityOutlineFramebuffer.get();
//                }
//            } catch (Exception ee) {
//                MoonFabricMod.LOGGER.error(String.valueOf(ee));
//                postChain = null;
//            }
//            if (renderTarget!=null  ) {
//                postEffects.put(resourceLocation, new PostEffect(postChain, renderTarget, false));
//            }
//        }
//    }
//
//
//    public static void resize(int x, int y) {
//        for (PostEffect postEffect : postEffects.values()) {
//            postEffect.setupDimensions(x, y);
//        }
//    }
//
//    public static void blitEffects(MinecraftClient minecraft) {
//        RenderSystem.enableBlend();
//        RenderSystem.enableDepthTest();
//        RenderSystem.blendFuncSeparate(GlStateManager.SrcFactor.SRC_ALPHA, GlStateManager.DstFactor.ONE, GlStateManager.SrcFactor.ONE, GlStateManager.DstFactor.ZERO);
//        for (PostEffect postEffect : postEffects.values()) {
//            if (postEffect.postChain != null && postEffect.isEnabled()) {
//                postEffect.getFramebuffer().draw(minecraft.getWindow().getWidth(), minecraft.getWindow().getHeight());
//                postEffect.getFramebuffer().clear();
//                minecraft.getFramebuffer().beginWrite(false);
//                postEffect.setEnabled(false);
//            }
//        }
//        RenderSystem.disableBlend();
//        RenderSystem.defaultBlendFunc();
//    }
//
//    public static void  clearAndBindWrite(Framebuffer mainTarget) {
//        for (PostEffect postEffect : postEffects.values()) {
//            if (postEffect.isEnabled() && postEffect.postChain != null) {
//                postEffect.getFramebuffer().clear();
//                mainTarget.beginWrite(false);
//            }
//        }
//    }
//
//    public static void processEffects(FrameGraphBuilder frameGraphBuilder,
//                                      int i ,
//                                      int j, DefaultFramebufferSet framebufferSet ,
//                                      Framebuffer mainTarget) {
//        for (PostEffect postEffect : postEffects.values()) {
//            if (postEffect.isEnabled() && postEffect.postChain != null) {
//                postEffect.postChain.render(frameGraphBuilder,i,j,framebufferSet);
//                mainTarget.beginWrite(false);
//            }
//        }
//    }
//    public static Framebuffer getFramebufferFor(Identifier resourceLocation) {
//        MoonPost.PostEffect effect = postEffects.get(resourceLocation);
//        return effect == null ? null : effect.getFramebuffer();
//    }
//
//    public static void renderEffectForNextTick(Identifier resourceLocation) {
//        MoonPost.PostEffect effect = postEffects.get(resourceLocation);
//        if (effect != null) {
//            effect.setEnabled(true);
//        }
//    }
//    public static class PostEffect {
//        private final PostEffectProcessor postChain;
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
//                renderTarget.delete();
//            }
//        }
//
//        public void setupDimensions(int x, int y) {
//            if (renderTarget != null) {
//                renderTarget.draw(x,y);
//            }
//        }
//    }
}


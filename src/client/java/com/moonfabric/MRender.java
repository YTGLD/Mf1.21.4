package com.moonfabric;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Defines;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gl.ShaderProgramKey;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.render.*;
import net.minecraft.util.Identifier;


@Environment(EnvType.CLIENT)
public class MRender extends RenderLayer {
    public MRender(String name, VertexFormat vertexFormat, VertexFormat.DrawMode drawMode, int expectedBufferSize, boolean hasCrumbling, boolean translucent, Runnable startAction, Runnable endAction) {
        super(name, vertexFormat, drawMode, expectedBufferSize, hasCrumbling, translucent, startAction, endAction);
    }
    public static ShaderProgramKey register(String id, VertexFormat format) {
        return register(id, format, Defines.EMPTY);
    }
    public static ShaderProgramKey register(String is, VertexFormat format, Defines defines) {
        ShaderProgramKey shaderProgramKey = new ShaderProgramKey(Identifier.of(MoonFabricMod.MODID,"core/" + is), format, defines);
        ShaderProgramKeys.getAll().add(shaderProgramKey);
        return shaderProgramKey;
    }
    protected static final RenderPhase.Target O = new RenderPhase.Target("set", () -> {
        if (MinecraftClient.getInstance().worldRenderer instanceof MFramebuffer framebuffer) {
            Framebuffer target = framebuffer.defaultFramebufferSets();

            if (target != null) {
                target.copyDepthFrom(MinecraftClient.getInstance().getFramebuffer());
                target.beginWrite(false);
            }
        }
    }, () -> {
        MinecraftClient.getInstance().getFramebuffer().beginWrite(false);
    });
    public static final Transparency TransparencyStateShard = new Transparency("lightning_transparency", () -> {
        RenderSystem.enableDepthTest();
        RenderSystem.enableBlend();
        RenderSystem.blendFunc(GlStateManager.SrcFactor.SRC_ALPHA,
                GlStateManager.DstFactor.ONE);
        RenderSystem.depthFunc(519);
        RenderSystem.depthMask(false);

    }, () -> {
        RenderSystem.disableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.depthMask(true);
        RenderSystem.depthFunc(515);
        RenderSystem.disableDepthTest();
    });
    public static final ShaderProgramKey BLOOD_PROGRAMKey = register("blood", VertexFormats.POSITION);
    public static final RenderPhase.ShaderProgram BLOOD_PROGRAM = new RenderPhase.ShaderProgram(BLOOD_PROGRAMKey);

    public static final RenderLayer BLOOD =
            of("blood",
                    VertexFormats.POSITION,
                    VertexFormat.DrawMode.QUADS,
                    1536,
                    false,
                    false,
                    RenderLayer.MultiPhaseParameters.builder().program(BLOOD_PROGRAM)
                            .texture(Textures.create().add(Identifier.of(MoonFabricMod.MODID,"textures/gui/blood.png"),
                                    false, false).add(Identifier.of(MoonFabricMod.MODID,"textures/gui/blood.png"),
                                    false, false).build()).build(false));
    public static final RenderLayer LIGHTNING = of(
                    "mf_lightning",
                    VertexFormats.POSITION_COLOR,
                    VertexFormat.DrawMode.QUADS,
                    1536,
                    false,
                    true,
                    RenderLayer.MultiPhaseParameters.builder()
                            .cull(DISABLE_CULLING)
                            .program(LIGHTNING_PROGRAM)
                            .writeMaskState(ALL_MASK)
                            .transparency(TransparencyStateShard)
                            .target(WEATHER_TARGET)
                            .build(false)
            );
    public static final RenderLayer BLOOD_OUTLINE =
            of("blood",
                    VertexFormats.POSITION,
                    VertexFormat.DrawMode.QUADS,
                    1536,
                    false,
                    true,
                    RenderLayer.MultiPhaseParameters.builder()
                            .program(BLOOD_PROGRAM)
                            .target(O)
                            .transparency(RenderPhase.TRANSLUCENT_TRANSPARENCY)
                            .texture(Textures.create().add(Identifier.of(MoonFabricMod.MODID,"textures/gui/blood.png"),
                                    true, false).add(Identifier.of(MoonFabricMod.MODID,"textures/gui/blood.png"),
                                    true, false).build()).build(false));



    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static RenderLayer getBlood() {
        return BLOOD;
    }
    public static RenderLayer getBloodCommon() {
        return BLOOD;
    }
    ///=-
    ///=-
    ///=-
    ///=-
    ///=-
    ///=-

    public static final ShaderProgramKey BBLOOD_PROGRAMNIGeKey = register("nig_common", VertexFormats.POSITION);
    public static final RenderPhase.ShaderProgram BLOOD_PROGRAMNIG = new RenderPhase.ShaderProgram(BBLOOD_PROGRAMNIGeKey);

    public static final RenderLayer BLOODNIG =
            of("blood",
                    VertexFormats.POSITION,
                    VertexFormat.DrawMode.QUADS,
                    1536,
                    false,
                    false,
                    RenderLayer.MultiPhaseParameters.builder()
                            .program(BLOOD_PROGRAMNIG)
                            .texture(Textures.create().add(Identifier.of(MoonFabricMod.MODID,"textures/gui/nig.png"),
                                    false, false).add(Identifier.of(MoonFabricMod.MODID,"textures/gui/nig.png"),
                                    false, false).build()).build(false));



    public static RenderLayer getBloodNIG() {
        return BLOODNIG;
    }

    //--------------------------------------


    public static final ShaderProgramKey BBLOBLOOD_PROGRAM_commonAMNIGeKey = register("nig_common", VertexFormats.POSITION);
    public static final RenderPhase.ShaderProgram BLOOD_PROGRAM_common = new RenderPhase.ShaderProgram(BBLOBLOOD_PROGRAM_commonAMNIGeKey);


    public static final RenderLayer BLOOD_common =
            of("blood",
                    VertexFormats.POSITION,
                    VertexFormat.DrawMode.QUADS,
                    1536,
                    false,
                    true,
                    RenderLayer.MultiPhaseParameters.builder()
                            .program(BLOOD_PROGRAM_common)
                            .transparency(RenderPhase.TRANSLUCENT_TRANSPARENCY)
                            .target(O)
                            .texture(Textures.create().add(Identifier.of(MoonFabricMod.MODID,"textures/gui/nig.png"),
                                    true, false).add(Identifier.of(MoonFabricMod.MODID,"textures/gui/nig.png"),
                                    true, false).build()).build(false));


    public static RenderLayer getBlood_common() {
        return BLOOD_common;
    }

}

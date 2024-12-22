package com.moonfabric;

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


    public static RenderLayer getBlood() {
        return BLOOD;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static RenderLayer  getBloodOutLine() {
        return BLOOD;
    }
    ///=-
    ///=-
    ///=-
    ///=-
    ///=-
    ///=-

    public static final ShaderProgramKey BBLOOD_PROGRAMNIGeKey = register("nig", VertexFormats.POSITION);
    public static final RenderPhase.ShaderProgram BLOOD_PROGRAMNIG = new RenderPhase.ShaderProgram(BBLOOD_PROGRAMNIGeKey);

    public static final RenderLayer BLOODNIG =of(
            "nig",
            VertexFormats.POSITION,
            VertexFormat.DrawMode.QUADS,
            256,
            false,
            true,
            RenderLayer.MultiPhaseParameters.builder()
                    .program(BLOOD_PROGRAMNIG)
                    .writeMaskState(RenderPhase.COLOR_MASK)
                    .transparency(LIGHTNING_TRANSPARENCY)
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
                    false,
                    RenderLayer.MultiPhaseParameters.builder()
                            .program(BLOOD_PROGRAM_common)
                            .texture(Textures.create().add(Identifier.of(MoonFabricMod.MODID,"textures/gui/nig.png"),
                                    false, false).add(Identifier.of(MoonFabricMod.MODID,"textures/gui/nig.png"),
                                    false, false).build()).build(false));


    public static RenderLayer getBlood_common() {
        return BLOOD_common;
    }

}

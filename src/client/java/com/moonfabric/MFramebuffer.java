package com.moonfabric;

import net.minecraft.client.gl.Framebuffer;
import org.lwjgl.opengl.GL30;

import java.nio.ByteBuffer;

public interface MFramebuffer {
    Framebuffer defaultFramebufferSets();
}

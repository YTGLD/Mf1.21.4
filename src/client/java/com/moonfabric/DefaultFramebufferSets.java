package com.moonfabric;

import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gl.PostEffectProcessor;
import net.minecraft.client.render.DefaultFramebufferSet;
import net.minecraft.client.util.Handle;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

public class DefaultFramebufferSets
        implements PostEffectProcessor.FramebufferSet {
    public static Handle<Framebuffer> entityOutlineFramebuffer;
    public static Handle<Framebuffer> mainFramebuffer = Handle.empty();
    public static final Identifier MAIN =Identifier.of(MoonFabricMod.MODID,"moonfabric");
    public static final Identifier ENTITY_OUTLINE = Identifier.of(MoonFabricMod.MODID,"entity_outline");

    @Override
    public void set(Identifier id, Handle<Framebuffer> framebuffer) {
        if (id.equals(ENTITY_OUTLINE) ) {
            entityOutlineFramebuffer = framebuffer;
        }else if (id.equals(MAIN)){
            mainFramebuffer = framebuffer;
        }else {
            System.out.println(id);
        }
    }

    @Nullable
    @Override
    public Handle<Framebuffer> get(Identifier id) {
        if (id == ENTITY_OUTLINE) {
            return entityOutlineFramebuffer;
        }else if (id==MAIN){
           return mainFramebuffer;
        }
        return entityOutlineFramebuffer;
    }
}

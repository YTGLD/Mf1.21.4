package com.moonfabric.mixin;

import com.google.common.collect.ImmutableMap;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.mojang.serialization.JsonOps;
import com.moonfabric.MoonFabricMod;
import com.moonfabric.MoonFabricModClient;
import net.minecraft.client.gl.PostEffectPipeline;
import net.minecraft.client.gl.ShaderLoader;
import net.minecraft.resource.Resource;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.Reader;

@Mixin( ShaderLoader.class)
public class ShaderLoaderMixin {
    @Inject(at = @At("HEAD"), method = "loadPostEffect(Lnet/minecraft/util/Identifier;Lnet/minecraft/resource/Resource;Lcom/google/common/collect/ImmutableMap$Builder;)V")
    private static void loadPostEffect(Identifier id, Resource resource, ImmutableMap.Builder<Identifier, PostEffectPipeline> builder, CallbackInfo ci) {
        try {
            Reader reader = resource.getReader();
            JsonElement jsonElement = JsonParser.parseReader(reader);
            builder.put(MoonFabricModClient.POST, PostEffectPipeline.CODEC.parse(JsonOps.INSTANCE, jsonElement).getOrThrow(JsonSyntaxException::new));
        }catch (Exception e){
            MoonFabricMod.LOGGER.error(String.valueOf(e));
        }
    }
}

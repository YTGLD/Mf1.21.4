package com.moonfabric;

import com.moonfabric.EntiyMl.*;
import com.moonfabric.EntiyMl.nig.NigEntityRenderer;
import com.moonfabric.PAT.*;
import com.moonfabric.init.InItEntity;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.gl.ShaderLoader;
import net.minecraft.util.Identifier;

@net.fabricmc.api.Environment(net.fabricmc.api.EnvType.CLIENT)
public class MoonFabricModClient implements ClientModInitializer {
	public static final Identifier POST =  Identifier.of(MoonFabricMod.MODID,"entity_outline");
	@Environment(EnvType.CLIENT)
	@Override
	public void onInitializeClient() {
		net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry.register(InItEntity.Fly ,FlyEntityRenderer::new);
		net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry.register(InItEntity.Line , LineRender::new);
		net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry.register(InItEntity.attack_blood , AttackBloodRender::new);
		net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry.register(InItEntity.owner_blood , OwnerBloodRender::new);
		net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry.register(InItEntity.cell_zombie , ZombieEntityRenderer::new);
		net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry.register(InItEntity.cell_giant , GiantEntityRenderer::new);
		net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry.register(InItEntity.nightmare_giant , NigEntityRenderer::new);
		net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry.register(InItEntity.head , HeadAttackRenderer::new);
		net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry.register(InItEntity.penalty , PenaltyRenderer::new);



		ParticleFactoryRegistry.getInstance().register(MoonFabricMod.GOLD, Gold.CloudFactory::new);
		ParticleFactoryRegistry.getInstance().register(MoonFabricMod.FOLLOW, Follow.CloudFactory::new);
		ParticleFactoryRegistry.getInstance().register(MoonFabricMod.t, Blood.CloudFactory::new);
		ParticleFactoryRegistry.getInstance().register(MoonFabricMod.Origin, Origin.CloudFactory::new);
		ParticleFactoryRegistry.getInstance().register(MoonFabricMod.S, sword.CloudFactory::new);
	}
}
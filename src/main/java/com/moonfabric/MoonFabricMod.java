package com.moonfabric;

import com.mojang.logging.LogUtils;
import com.moonfabric.Effects.initEffect;
import com.moonfabric.Ievent.evt.Aevent;
import com.moonfabric.init.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;


public class MoonFabricMod implements ModInitializer {

	public static final Logger LOGGER = LogUtils.getLogger();
	public static final String MODID = "moonfabric";

	public static final SimpleParticleType t  =FabricParticleTypes.simple();
	public static final SimpleParticleType  GOLD  =FabricParticleTypes.simple();
	public static final SimpleParticleType  FOLLOW  =FabricParticleTypes.simple();
	public static final SimpleParticleType  Origin  =FabricParticleTypes.simple();
	public static final SimpleParticleType  S  =FabricParticleTypes.simple();
	@Override
	public void onInitialize() {


		new Aevent();


		new DNAItems();
		new init();

		new Data();

		Registry.register(Registries.PARTICLE_TYPE, Identifier.of("moonfabric", "blood"), t);
		Registry.register(Registries.PARTICLE_TYPE, Identifier.of("moonfabric", "gold"), GOLD);
		Registry.register(Registries.PARTICLE_TYPE, Identifier.of("moonfabric", "follow"), FOLLOW);
		Registry.register(Registries.PARTICLE_TYPE, Identifier.of("moonfabric", "origin"), Origin);
		Registry.register(Registries.PARTICLE_TYPE, Identifier.of("moonfabric", "sword"), S);

		LootTableEvents.MODIFY.register((key,builder,source,wrapperLookup)->{
			moonfabricLoot.onLootTableLoad(key,builder);
		});

		Registry.register(Registries.ENTITY_TYPE, Identifier.of("moonfabric", "nightmare_giant"), InItEntity.nightmare_giant);
		Registry.register(Registries.ENTITY_TYPE, Identifier.of("moonfabric", "cell_giant"), InItEntity.cell_giant);
		Registry.register(Registries.ENTITY_TYPE, Identifier.of("moonfabric", "cell_zombie"), InItEntity.cell_zombie);
		Registry.register(Registries.ENTITY_TYPE, Identifier.of("moonfabric", "nig_test"), InItEntity.nig_test);

		Registry.register(Registries.ENTITY_TYPE, Identifier.of("moonfabric", "head"), InItEntity.head);
		Registry.register(Registries.ENTITY_TYPE, Identifier.of("moonfabric", "penalty"), InItEntity.penalty);



		Registry.register(Registries.ENTITY_TYPE, Identifier.of("moonfabric", "flysword"), InItEntity.Fly);
		Registry.register(Registries.ENTITY_TYPE, Identifier.of("moonfabric", "line"), InItEntity.Line);

		Registry.register(Registries.ENTITY_TYPE, Identifier.of("moonfabric", "owner_blood"), InItEntity.owner_blood);
		Registry.register(Registries.ENTITY_TYPE, Identifier.of("moonfabric", "attack_blood"), InItEntity.attack_blood);


		Registry.register(Registries.ITEM_GROUP, Identifier.of("moonfabric", "moonfabric_tab"), aaa.Moon_Fabric_Tab);
		Registry.register(Registries.ITEM_GROUP, Identifier.of("moonfabric", "moonfabric_tab_dna"), aaa.DNA);

	}
}
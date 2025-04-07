package com.moonfabric;

import com.mojang.logging.LogUtils;
import com.moonfabric.Ievent.evt.Aevent;
import com.moonfabric.init.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.ComposterBlock;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;

import java.io.File;


public class MoonFabricMod implements ModInitializer {

	public static MFConfig CONFIG;
	private static final File CONFIG_FILE = new File(FabricLoader.getInstance().getConfigDir().toFile(),
			"moonfabric.json");


	public static final Logger LOGGER = LogUtils.getLogger();
	public static final String MODID = "moonfabric";

	public static final SimpleParticleType t  =FabricParticleTypes.simple();
	public static final SimpleParticleType  GOLD  =FabricParticleTypes.simple();
	public static final SimpleParticleType  FOLLOW  =FabricParticleTypes.simple();
	public static final SimpleParticleType  Origin  =FabricParticleTypes.simple();
	public static final SimpleParticleType  S  =FabricParticleTypes.simple();
	@Override
	public void onInitialize() {

		if (!CONFIG_FILE.exists()) {
			CONFIG = new MFConfig();
			CONFIG.save(CONFIG_FILE);
		} else {
			CONFIG = MFConfig.load(CONFIG_FILE);
		}

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

		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(DNAItems.atp_height, 0.8f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(DNAItems.cell_acid, 0.8f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(DNAItems.cell_big_boom, 0.8f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(DNAItems.cell_bone_add, 0.8f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(DNAItems.cell_break_down_water, 0.8f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(DNAItems.cell_chromosome, 0.8f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(DNAItems.cell_compress, 0.8f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(DNAItems.cell_constant, 0.8f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(DNAItems.cell_cranial, 0.8f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(DNAItems.cell_darwin, 0.8f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(DNAItems.cell_digestion, 0.8f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(DNAItems.cell_disorder, 0.8f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(DNAItems.cell_dna_suppression, 0.8f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(DNAItems.cell_eyes, 0.8f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(DNAItems.cell_flu, 0.8f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(DNAItems.cell_god, 0.8f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(DNAItems.cell_ground, 0.8f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(DNAItems.cell_in_air, 0.8f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(DNAItems.cell_in_water, 0.8f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(DNAItems.cell_inheritance, 0.8f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(DNAItems.cell_necrosis, 0.8f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(DNAItems.cell_off_on, 0.8f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(DNAItems.cell_oxygen, 0.8f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(DNAItems.cell_preferential, 0.8f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(DNAItems.cell_putrefactive, 0.8f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(DNAItems.cell_sense, 0.8f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(DNAItems.cell_synthesis, 0.8f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(DNAItems.speed_metabolism, 0.8f);
	}
}
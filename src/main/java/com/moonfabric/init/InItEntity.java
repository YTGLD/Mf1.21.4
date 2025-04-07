package com.moonfabric.init;

import com.moonfabric.Entity.*;
import com.moonfabric.MoonFabricMod;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.WardenEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class InItEntity {
    public static final EntityType<flysword> Fly =
            FabricEntityTypeBuilder.create()
                    .dimensions(EntityDimensions.changing(0.25f,0.25f))
                    .trackRangeBlocks(50)
                    .entityFactory(flysword::new)
                    .build(RegistryKey.of(Registries.ENTITY_TYPE.getKey(), Identifier.of(MoonFabricMod.MODID,"fly")));

    public static final EntityType<line> Line =
            FabricEntityTypeBuilder.createLiving()
                    .dimensions(EntityDimensions.changing(0.1f,0.85f))
                    .trackRangeBlocks(50)
                    .defaultAttributes(ZombieEntity::createZombieAttributes)
                    .entityFactory(line::new)
                    .build(RegistryKey.of(Registries.ENTITY_TYPE.getKey(), Identifier.of(MoonFabricMod.MODID,"line")));
    public static final EntityType<attack_blood> attack_blood=
            FabricEntityTypeBuilder.createLiving()
                    .dimensions(EntityDimensions.changing(0.5f,0.5f))
                    .trackRangeBlocks(500)
                    .defaultAttributes(ZombieEntity::createZombieAttributes)
                    .entityFactory(attack_blood::new)
                    .build(RegistryKey.of(Registries.ENTITY_TYPE.getKey(), Identifier.of(MoonFabricMod.MODID,"attack_blood")));

    public static final EntityType<owner_blood> owner_blood =
            FabricEntityTypeBuilder.createLiving()
                    .dimensions(EntityDimensions.changing(1,1))
                    .trackRangeBlocks(500)
                    .defaultAttributes(IronGolemEntity::createIronGolemAttributes)
                    .entityFactory(owner_blood::new)
                    .build(RegistryKey.of(Registries.ENTITY_TYPE.getKey(), Identifier.of(MoonFabricMod.MODID,"owner_blood")));

    public static final EntityType<cell_zombie> cell_zombie =
            FabricEntityTypeBuilder.createLiving()
                    .dimensions(EntityDimensions.changing(1,2))
                    .trackRangeBlocks(50)
                    .defaultAttributes(ZombieEntity::createZombieAttributes)
                    .entityFactory(cell_zombie::new)
                    .build(RegistryKey.of(Registries.ENTITY_TYPE.getKey(), Identifier.of(MoonFabricMod.MODID,"cell_zombie")));


    public static final EntityType<nightmare_giant> nightmare_giant =
            FabricEntityTypeBuilder.createLiving()
                    .dimensions(EntityDimensions.changing(2,3))
                    .trackRangeBlocks(50)
                    .defaultAttributes(com.moonfabric.Entity.nightmare_giant::addAttributes)
                    .entityFactory(nightmare_giant::new)
                    .build(RegistryKey.of(Registries.ENTITY_TYPE.getKey(), Identifier.of(MoonFabricMod.MODID,"nightmare_giant")));

    public static final EntityType<nig_test> nig_test =
            FabricEntityTypeBuilder.createLiving()
                    .dimensions(EntityDimensions.changing(1,1))
                    .trackRangeBlocks(50)
                    .defaultAttributes(WardenEntity::addAttributes)
                    .entityFactory(nig_test::new)
                    .build(RegistryKey.of(Registries.ENTITY_TYPE.getKey(), Identifier.of(MoonFabricMod.MODID,"nig_test")));


    public static final EntityType<cell_giant> cell_giant =
            FabricEntityTypeBuilder.createLiving()
                    .dimensions(EntityDimensions.changing(1.5F,2))
                    .trackRangeBlocks(50)
                    .defaultAttributes(com.moonfabric.Entity.cell_giant::addAttributes)
                    .entityFactory(cell_giant::new)
                    .build(RegistryKey.of(Registries.ENTITY_TYPE.getKey(), Identifier.of(MoonFabricMod.MODID,"cell_giant")));

    public static final EntityType<head> head =
            FabricEntityTypeBuilder.createLiving()
                    .dimensions(EntityDimensions.changing(0.5f,0.5f))
                    .trackRangeBlocks(50)
                    .defaultAttributes(com.moonfabric.Entity.cell_giant::addAttributes)
                    .entityFactory(head::new)
                    .build(RegistryKey.of(Registries.ENTITY_TYPE.getKey(), Identifier.of(MoonFabricMod.MODID,"head")));

    public static final EntityType<penalty> penalty =
            FabricEntityTypeBuilder.createLiving()
                    .dimensions(EntityDimensions.changing(0.5f,0.5f))
                    .trackRangeBlocks(50)
                    .defaultAttributes(com.moonfabric.Entity.cell_giant::addAttributes)
                    .entityFactory(penalty::new)
                    .build(RegistryKey.of(Registries.ENTITY_TYPE.getKey(), Identifier.of(MoonFabricMod.MODID,"penalty")));

}

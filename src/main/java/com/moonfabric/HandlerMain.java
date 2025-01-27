package com.moonfabric;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class HandlerMain {
    public static boolean IsNoon(MobEntity me , LivingEntity target){
        Identifier entityTypeId = Registries.ENTITY_TYPE.getId(target.getType());
        if (entityTypeId.getNamespace().equals(MoonFabricMod.MODID)){
            return false;
        }
        return true;
    }
}

package com.moonfabric.Entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public abstract class TameableZombie extends TameableEntity {
    protected TameableZombie(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
    }

}

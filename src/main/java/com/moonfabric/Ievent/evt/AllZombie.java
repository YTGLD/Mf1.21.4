package com.moonfabric.Ievent.evt;

import com.moonfabric.Entity.TameableZombie;
import com.moonfabric.Entity.cell_giant;
import com.moonfabric.Entity.cell_zombie;
import com.moonfabric.Entity.nightmare_giant;
import com.moonfabric.HasCurio;
import com.moonfabric.init.InItEntity;
import com.moonfabric.init.init;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.LargeEntitySpawnHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static com.moonfabric.HasCurio.*;
import static com.moonfabric.Ievent.AllEvent.*;

public class AllZombie {

    public static void evils(LivingEntity me , DamageSource source, CallbackInfoReturnable<Float> cir){
        if (HasCurio.has(init.cell, me)){
            if (source.getSource() instanceof cell_zombie){
                cir.setReturnValue(0f);
            }
        }
        if (HasCurio.has(init.giant_nightmare, me)){
            if (source.getSource() instanceof nightmare_giant){
                cir.setReturnValue(0f);
            }
        }
    }
    public static void addTag(TameableZombie mobEntity,PlayerEntity player){
        if (mobEntity != null) {
            mobEntity.setOwnerUuid(player.getUuid());

            if (HasCurio.has(init.anaerobic_cell, player)) {
                mobEntity.addCommandTag(Giant_Time);
            }
            if (HasCurio.has(init.giant_boom_cell, player)) {
                mobEntity.addCommandTag(Giant_Boom);
            }
            if (HasCurio.has(init.subspace_cell, player)) {
                mobEntity.addCommandTag(Subspace_Giant);
            }
            if (HasCurio.has(init.bone_cell, player)) {
                mobEntity.addCommandTag(Bone_Giant);
            }
            if (HasCurio.has(init.parasitic_cell, player)) {
                mobEntity.addCommandTag(Parasitic_cell_Giant);
            }
            if (HasCurio.has(init.disgusting_cells, player)) {
                mobEntity.addCommandTag(Disgusting__cell_Giant);
            }

        }
    }
    public static void evil(LivingEntity me , DamageSource source){
        if ((me instanceof PlayerEntity player)) {
            if (HasCurio.has(init.cell_boom, player)){
                player.getEntityWorld().createExplosion(null,player.getX(),player.getY(),player.getZ(),5.5f,true , World.ExplosionSourceType.MOB);
            }
        }
        if (source.getSource() instanceof PlayerEntity player){

            if (HasCurio.has(init.giant, player)){
                if (!HasCurio.has(init.giant_nightmare, player)) {
                    if (player.getWorld() instanceof ServerWorld p_222881_) {
                        if (MathHelper.nextInt(Random.create(), 1, 8) == 1) {
                            {
                                cell_giant cell_giant = new cell_giant(InItEntity.cell_giant, player.getWorld());
                                addTag(cell_giant, player);
                                cell_giant.setPos(player.getX(), player.getY(), player.getZ());
                                cell_giant.setOwner(player);
                                cell_giant.setOwnerUuid(player.getUuid());
                                player.getWorld().spawnEntity(cell_giant);
                                player.getWorld().playSound(null, player.getBlockPos(), SoundEvents.ENTITY_WARDEN_EMERGE, SoundCategory.NEUTRAL, 1.0F, 1.0F);
                            }
                            if (HasCurio.has(init.mother_cell, player)) {
                                if (MathHelper.nextInt(Random.create(), 1, 2) == 1) {
                                    cell_giant cell_giant = new cell_giant(InItEntity.cell_giant, player.getWorld());
                                    addTag(cell_giant, player);
                                    cell_giant.setPos(player.getX(), player.getY(), player.getZ());
                                    cell_giant.setOwner(player);
                                    cell_giant.setOwnerUuid(player.getUuid());
                                    player.getWorld().spawnEntity(cell_giant);
                                }
                                for (int i = 0; i < 2; i++) {
                                    cell_zombie cell_zombie = new cell_zombie(InItEntity.cell_zombie, player.getWorld());
                                    cell_zombie.setOwnerUuid(player.getUuid());
                                    cell_zombie.setOwner(player);
                                    cell_zombie.setPos(player.getPos().x, player.getPos().y, player.getPos().z);
                                    player.getWorld().spawnEntity(cell_zombie);

                                }
                            }

                        }
                    }
                } else {
                    if (player.getWorld() instanceof ServerWorld p_222881_) {
                        if (MathHelper.nextInt(Random.create(), 1, 8) == 1) {
                            nightmare_giant cell_giant = new nightmare_giant(InItEntity.nightmare_giant, player.getWorld());
                            addTag(cell_giant, player);
                            cell_giant.setPos(player.getX(), player.getY(), player.getZ());
                            cell_giant.setOwner(player);
                            cell_giant.setOwnerUuid(player.getUuid());
                            player.getWorld().spawnEntity(cell_giant);
                            player.getWorld().playSound(null, player.getBlockPos(), SoundEvents.ENTITY_WARDEN_EMERGE, SoundCategory.NEUTRAL, 1.0F, 1.0F);

                            if (HasCurio.has(init.subspace_cell, player)) {
                                for (int i = 0; i < 3; i++) {
                                    cell_zombie cell_zombie = new cell_zombie(InItEntity.cell_zombie, player.getWorld());
                                    cell_zombie.setOwnerUuid(player.getUuid());
                                    cell_zombie.setOwner(player);
                                    cell_zombie.setPos(player.getPos().x, player.getPos().y, player.getPos().z);
                                    player.getWorld().spawnEntity(cell_zombie);
                                }
                            }

                        }
                    }
                }
            }
            if (HasCurio.has(init.cell, player)){
                if (!player.getItemCooldownManager().isCoolingDown(init.cell.getDefaultStack())) {
                    if (MathHelper.nextInt(Random.create(), 1, 2) == 1) {
                        cell_zombie z = new cell_zombie(InItEntity.cell_zombie, player.getWorld());
                        z.setPos(me.getX(), me.getY()+1, me.getZ());
                        z.setOwnerUuid(player.getUuid());
                        z.setOwner(player);

                        if (HasCurio.has(init.adrenaline, player)) {
                            z.addCommandTag(DamageCell);
                        }
                        if (HasCurio.has(init.cell_mummy, player)) {
                            z.addCommandTag(muMMY);
                        }
                        if (HasCurio.has(init.cell_boom, player)) {
                            z.addCommandTag(boom);
                        }
                        if (HasCurio.has(init.cell_calcification, player)) {
                            z.addCommandTag(calcification);
                        }
                        if (HasCurio.has(init.cell_blood, player)) {
                            z.addCommandTag(cb_blood);
                        }
                        player.getWorld().spawnEntity(z);
                    }
                }
            }
        }
    }
}

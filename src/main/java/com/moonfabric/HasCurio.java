package com.moonfabric;

import com.moonfabric.init.init;
import io.wispforest.accessories.api.AccessoriesCapability;
import io.wispforest.accessories.api.slot.SlotEntryReference;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;

import java.util.Optional;

public class HasCurio {
    public static final String Giant_Time ="Giant_Time";
    public static final String Giant_Boom ="Giant_Boom";
    public static final String Subspace_Giant ="Subspace_Giant";

    public static final String Bone_Giant = "Bone_Giant";
    public static final String Parasitic_cell_Giant = "Parasitic_cell_Giant";
    public static final String Disgusting__cell_Giant = "Disgusting__cell_Giant";


    public static boolean has(Item item , LivingEntity player){
        if (AccessoriesCapability.get(player)!=null){
            return AccessoriesCapability.get(player).isEquipped(item);
        }
        return false;
    }
    public static ItemStack getItemStack(LivingEntity living){
        if ( AccessoriesCapability.get(living)!=null) {
            for (SlotEntryReference slotEntryReference : AccessoriesCapability.get(living).getAllEquipped()) {
                return slotEntryReference.stack();
            }
        }
        return ItemStack.EMPTY;
    }
    public static <T extends TameableEntity> Optional<T> trySpawnMob(LivingEntity player, EntityType<T> entityType, SpawnReason reason, ServerWorld world, BlockPos pos, int tries, int horizontalRange, int verticalRange, LargeEntitySpawnHelper.Requirements requirements) {
        BlockPos.Mutable mutable = pos.mutableCopy();

        for(int i = 0; i < tries; ++i) {
            int j = MathHelper.nextBetween(world.random, -horizontalRange, horizontalRange);
            int k = MathHelper.nextBetween(world.random, -horizontalRange, horizontalRange);
            mutable.set(pos, j, verticalRange, k);
            if (world.getWorldBorder().contains(mutable) && findSpawnPos(world, verticalRange, mutable, requirements)) {
                T mobEntity = entityType.create(world, null, mutable, reason, false, false);
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
                    mobEntity.setPose(EntityPose.EMERGING);
                    if (mobEntity.canSpawn(world, reason) && mobEntity.canSpawn(world)) {
                        world.spawnEntityAndPassengers(mobEntity);
                        return Optional.of(mobEntity);
                    }

                    mobEntity.discard();
                }
            }
        }

        return Optional.empty();
    }

    private static boolean findSpawnPos(ServerWorld world, int verticalRange, BlockPos.Mutable pos, LargeEntitySpawnHelper.Requirements requirements) {
        BlockPos.Mutable mutable = (new BlockPos.Mutable()).set(pos);
        BlockState blockState = world.getBlockState(mutable);

        for(int i = verticalRange; i >= -verticalRange; --i) {
            pos.move(Direction.DOWN);
            mutable.set(pos, Direction.UP);
            BlockState blockState2 = world.getBlockState(pos);
            if (requirements.canSpawnOn(world, pos, blockState2, mutable, blockState)) {
                pos.move(Direction.UP);
                return true;
            }

            blockState = blockState2;
        }

        return false;
    }

}

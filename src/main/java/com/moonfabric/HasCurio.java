package com.moonfabric;

import com.moonfabric.init.init;
import io.wispforest.accessories.Accessories;
import io.wispforest.accessories.api.AccessoriesCapability;
import io.wispforest.accessories.api.AccessoriesContainer;
import io.wispforest.accessories.api.client.AccessoriesRendererRegistry;
import io.wispforest.accessories.api.client.AccessoryRenderer;
import io.wispforest.accessories.api.slot.SlotEntryReference;
import io.wispforest.accessories.api.slot.SlotReference;
import io.wispforest.accessories.impl.ExpandedSimpleContainer;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class HasCurio {
    public static final String Giant_Time ="Giant_Time";
    public static final String Giant_Boom ="Giant_Boom";
    public static final String Subspace_Giant ="Subspace_Giant";

    public static final String Bone_Giant = "Bone_Giant";
    public static final String Parasitic_cell_Giant = "Parasitic_cell_Giant";
    public static final String Disgusting__cell_Giant = "Disgusting__cell_Giant";


    public static boolean has(Item item , LivingEntity player){
        AccessoriesCapability capability = AccessoriesCapability.get(player);
        if (capability == null) {
            return false;
        }

        for (Map.Entry<String, AccessoriesContainer> stringAccessoriesContainerEntry : capability.getContainers().entrySet()) {
            AccessoriesContainer container = stringAccessoriesContainerEntry.getValue();
            ExpandedSimpleContainer accessories = container.getAccessories();
            for (int i = 0; i < accessories.size(); ++i) {
                ItemStack stack = accessories.getStack(i);
                if (!stack.isEmpty()) {
                    if (stack.isOf(item)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static ItemStack getItemStackCapability(LivingEntity living){
        AccessoriesCapability capability = AccessoriesCapability.get(living);
        if (capability != null) {
            for (Map.Entry<String, AccessoriesContainer> stringAccessoriesContainerEntry : capability.getContainers().entrySet()) {
                AccessoriesContainer container = stringAccessoriesContainerEntry.getValue();
                ExpandedSimpleContainer accessories = container.getAccessories();
                for (int i = 0; i < accessories.size(); ++i) {
                    ItemStack stack = accessories.getStack(i);
                    if (!stack.isEmpty()) {

                    }
                }
            }
        }
        return ItemStack.EMPTY;
    }
}

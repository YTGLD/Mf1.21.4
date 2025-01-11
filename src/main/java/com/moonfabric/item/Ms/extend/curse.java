package com.moonfabric.item.Ms.extend;

import com.moonfabric.HasCurio;
import com.moonfabric.init.Data;
import io.wispforest.accessories.api.AccessoryItem;
import io.wispforest.accessories.api.slot.SlotReference;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Rarity;

public class curse extends AccessoryItem {
    public curse(Settings settings) {
        super(settings.maxCount(1));
    }



    @Override
    public void onEquip(ItemStack stack, SlotReference reference) {
        if (stack.get(Data.CUSTOM_DATA) == null) {
            stack.set(Data.CUSTOM_DATA,new NbtCompound());
        }
    }
}

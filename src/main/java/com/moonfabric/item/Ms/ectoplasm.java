package com.moonfabric.item.Ms;

import com.moonfabric.HasCurio;
import com.moonfabric.init.Data;
import io.wispforest.accessories.api.AccessoryItem;
import io.wispforest.accessories.api.slot.SlotReference;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Rarity;

public class ectoplasm extends AccessoryItem {
    public ectoplasm(Settings settings) {
        super(settings.maxCount(64).rarity(Rarity.RARE).fireproof()
                .food(new FoodComponent.Builder().nutrition(4).alwaysEdible().saturationModifier(0.2f).build()));
    }

    @Override
    public boolean canEquip(ItemStack stack, SlotReference reference) {
        if (reference.entity() instanceof PlayerEntity player){
            return !HasCurio.has(this, player);
        }
        return true;
    }


    @Override
    public void onEquip(ItemStack stack, SlotReference reference) {
        if (stack.get(Data.CUSTOM_DATA) == null) {
            stack.set(Data.CUSTOM_DATA,new NbtCompound());
        }
    }
}


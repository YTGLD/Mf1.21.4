package com.moonfabric.item.Ms;

import com.moonfabric.init.Data;
import com.moonfabric.item.Ms.extend.ItemTir;
import io.wispforest.accessories.api.DropRule;
import io.wispforest.accessories.api.slot.SlotReference;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;

public class SNightmare  extends ItemTir {

    public SNightmare(Settings settings) {
        super(settings);
    }

    @Override
    public DropRule getDropRule(ItemStack stack, SlotReference reference, DamageSource source) {
        return DropRule.KEEP;
    }

    @Override
    public void onEquip(ItemStack stack, SlotReference reference) {
        super.onEquip(stack, reference);
    }
}



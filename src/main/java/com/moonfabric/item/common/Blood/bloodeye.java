package com.moonfabric.item.common.Blood;

import com.moonfabric.item.Ms.TheNecoraIC;
import io.wispforest.accessories.api.attributes.AccessoryAttributeBuilder;
import io.wispforest.accessories.api.slot.SlotReference;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class bloodeye extends TheNecoraIC {

    public bloodeye(Settings settings) {
        super(settings);
    }

    @Override
    public void getDynamicModifiers(ItemStack stack, SlotReference reference, AccessoryAttributeBuilder builder) {
        builder.addExclusive(EntityAttributes.MAX_HEALTH,new EntityAttributeModifier(Identifier.of("moonfabric"+this.getTranslationKey()),0.15, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE));
    }
}

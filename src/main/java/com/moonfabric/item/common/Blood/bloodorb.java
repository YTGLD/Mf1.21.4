package com.moonfabric.item.common.Blood;

import com.moonfabric.init.AttReg;
import com.moonfabric.item.Ms.TheNecoraIC;
import io.wispforest.accessories.api.attributes.AccessoryAttributeBuilder;
import io.wispforest.accessories.api.slot.SlotReference;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class bloodorb extends TheNecoraIC {


    public bloodorb(Settings settings) {
        super(settings);
    }

    @Override
    public void getDynamicModifiers(ItemStack stack, SlotReference reference, AccessoryAttributeBuilder builder) {
        builder.addExclusive(EntityAttributes.MAX_ABSORPTION,new EntityAttributeModifier(Identifier.of("moonfabric"+this.getTranslationKey()),0.4, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE));
        builder.addExclusive(EntityAttributes.ARMOR,new EntityAttributeModifier(Identifier.of("moonfabric"+this.getTranslationKey()),10, EntityAttributeModifier.Operation.ADD_VALUE));
        builder.addExclusive(AttReg.heal,new EntityAttributeModifier(Identifier.of("moonfabric"+this.getTranslationKey()),1.25, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE));

    }

}

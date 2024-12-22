package com.moonfabric.item.ectoplasm;

import com.moonfabric.MoonFabricMod;
import com.moonfabric.item.Ms.ectoplasm;
import io.wispforest.accessories.api.attributes.AccessoryAttributeBuilder;
import io.wispforest.accessories.api.slot.SlotReference;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ectoplasmbattery extends ectoplasm {
    public ectoplasmbattery(Settings settings) {
        super(settings);
    }

    @Override
    public void getDynamicModifiers(ItemStack stack, SlotReference reference, AccessoryAttributeBuilder builder) {
        builder.addExclusive(EntityAttributes.MAX_HEALTH, new EntityAttributeModifier(Identifier.of(MoonFabricMod.MODID,this.getTranslationKey()), 10, EntityAttributeModifier.Operation.ADD_VALUE));
        builder.addExclusive(EntityAttributes.ARMOR, new EntityAttributeModifier(Identifier.of(MoonFabricMod.MODID,this.getTranslationKey()), 4, EntityAttributeModifier.Operation.ADD_VALUE));
        builder.addExclusive(EntityAttributes.MOVEMENT_SPEED, new EntityAttributeModifier(Identifier.of(MoonFabricMod.MODID,this.getTranslationKey()), 0.05, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE));
        builder.addExclusive(EntityAttributes.ATTACK_SPEED, new EntityAttributeModifier(Identifier.of(MoonFabricMod.MODID,this.getTranslationKey()), 0.05, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE));
    }

}


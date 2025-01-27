package com.moonfabric.item.nightmare.super_nightmare;

import com.moonfabric.item.Ms.nightmare;
import io.wispforest.accessories.api.attributes.AccessoryAttributeBuilder;
import io.wispforest.accessories.api.attributes.SlotAttribute;
import io.wispforest.accessories.api.slot.SlotReference;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class nightmare_base_insight_collapse extends com.moonfabric.item.Ms.SNightmare{
    public nightmare_base_insight_collapse(Settings settings) {
        super(settings);
    }

    @Override
    public void getDynamicModifiers(ItemStack stack, SlotReference reference, AccessoryAttributeBuilder builder) {
        SlotAttribute.addSlotAttribute(builder,"hat", Identifier.of(String.valueOf(this.getTranslationKey())),1, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE,true);
        SlotAttribute.addSlotAttribute(builder,"hand", Identifier.of(String.valueOf(this.getTranslationKey())),1, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE,true);
    }
}



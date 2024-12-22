package com.moonfabric.item.common.pain;

import com.moonfabric.HasCurio;
import com.moonfabric.Ievent.old.IHurtSizeEvent;
import com.moonfabric.init.AttReg;
import com.moonfabric.init.Data;
import com.moonfabric.init.init;
import com.moonfabric.item.Ms.extend.ItemTir;
import io.wispforest.accessories.api.attributes.AccessoryAttributeBuilder;
import io.wispforest.accessories.api.slot.SlotReference;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

import java.util.List;

public class pain_heart extends ItemTir {
    public static final String hurt="StringHurt";

    public pain_heart(Settings settings) {
        super(settings);
    }

    public static void  pain(){
        IHurtSizeEvent.ON_HURT.register((living, source, size,stack) -> {
            if (stack.isOf(init.pain_heart)&& HasCurio.has(init.pain_heart,living)){
                if (stack.get(Data.CUSTOM_DATA) != null) {
                    stack.get(Data.CUSTOM_DATA).putInt(hurt, stack.get(Data.CUSTOM_DATA).getInt(hurt) + 1);
                    float get = (float) stack.get(Data.CUSTOM_DATA).getInt(hurt) / 33;
                   return size *(1 + get);
                }
            }
            return size;
        });
    }

    @Override
    public void getDynamicModifiers(ItemStack stack, SlotReference reference, AccessoryAttributeBuilder builder) {
        builder.addExclusive(EntityAttributes.MAX_HEALTH,new EntityAttributeModifier(Identifier.of("moonfabric"+this.getTranslationKey()),10, EntityAttributeModifier.Operation.ADD_VALUE));
        builder.addExclusive(AttReg.heal,new EntityAttributeModifier(Identifier.of("moonfabric"+this.getTranslationKey()),0.33, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE));
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, net.minecraft.item.tooltip.TooltipType type) {
        tooltip.add(Text.literal(""));
        tooltip.add(Text.translatable("moonfabric.tooltip.pain_heart.1" ).formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("moonfabric.tooltip.pain_heart.2" ).formatted(Formatting.GRAY));
        tooltip.add(Text.literal(""));

    }
}

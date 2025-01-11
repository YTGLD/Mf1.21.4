package com.moonfabric.item.common.pain;

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

public class pain_stone  extends ItemTir {

    public pain_stone(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, net.minecraft.item.tooltip.TooltipType type) {
        tooltip.add(Text.literal(""));
        tooltip.add(Text.translatable("moonfabric.tooltip.pain_stone.1" ).formatted(Formatting.GRAY));
        tooltip.add(Text.literal(""));

    }

    @Override
    public void getDynamicModifiers(ItemStack stack, SlotReference reference, AccessoryAttributeBuilder builder) {
        builder.addStackable(EntityAttributes.JUMP_STRENGTH,new EntityAttributeModifier(Identifier.of("moonfabric"+this.getTranslationKey()),0.42, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE));
        builder.addStackable(EntityAttributes.SAFE_FALL_DISTANCE,new EntityAttributeModifier(Identifier.of("moonfabric"+this.getTranslationKey()),0.5, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE));
    }
}

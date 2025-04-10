package com.moonfabric.item.common.CurseOrDoom;

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

public class twistedsoul extends ItemTir {
    public twistedsoul(Settings settings) {
        super(settings);
    }

    @Override
    public void getDynamicModifiers(ItemStack stack, SlotReference reference, AccessoryAttributeBuilder builder) {
        builder.addStackable(EntityAttributes.MOVEMENT_SPEED,new EntityAttributeModifier(Identifier.of(String.valueOf(this.getTranslationKey())),-0.1, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE));
    }



  @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, net.minecraft.item.tooltip.TooltipType type) {
        tooltip.add(Text.translatable("moonfabric.tooltip.twistedsoul.1").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("moonfabric.tooltip.twistedsoul.2").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable(""));
    }
}
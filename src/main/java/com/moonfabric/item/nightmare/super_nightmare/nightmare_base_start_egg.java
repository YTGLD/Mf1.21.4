package com.moonfabric.item.nightmare.super_nightmare;

import com.moonfabric.init.AttReg;
import com.moonfabric.item.Ms.nightmare;
import io.wispforest.accessories.api.attributes.AccessoryAttributeBuilder;
import io.wispforest.accessories.api.slot.SlotReference;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

import java.util.List;

public class nightmare_base_start_egg extends com.moonfabric.item.Ms.SNightmare{
    public nightmare_base_start_egg(Settings settings) {
        super(settings);
    }

    @Override
    public void getDynamicModifiers(ItemStack stack, SlotReference reference, AccessoryAttributeBuilder builder) {
        super.getDynamicModifiers(stack, reference, builder);
        builder.addStackable(EntityAttributes.ATTACK_DAMAGE, new EntityAttributeModifier(Identifier.of(String.valueOf(this.getTranslationKey())), 0.2, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE));
        builder.addStackable(AttReg.heal, new EntityAttributeModifier(Identifier.of(String.valueOf(this.getTranslationKey())), 0.5, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE));
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        tooltip.add(Text.translatable("item.nightmare_base_start_egg.tool.string.1").formatted(Formatting.DARK_RED));
        tooltip.add(Text.translatable("item.nightmare_base_start_egg.tool.string.2").formatted(Formatting.DARK_RED));
    }

}



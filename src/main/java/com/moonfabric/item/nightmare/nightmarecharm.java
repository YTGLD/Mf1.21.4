package com.moonfabric.item.nightmare;

import com.moonfabric.item.Ms.nightmare;
import io.wispforest.accessories.api.attributes.AccessoryAttributeBuilder;
import io.wispforest.accessories.api.attributes.SlotAttribute;
import io.wispforest.accessories.api.slot.SlotReference;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

import java.util.List;

public class nightmarecharm extends nightmare {


    public nightmarecharm(Settings settings) {
        super(settings);
    }

    @Override
    public void getDynamicModifiers(ItemStack stack, SlotReference reference, AccessoryAttributeBuilder builder) {
        SlotAttribute.addSlotAttribute(builder,"ring", Identifier.of(String.valueOf(this.getTranslationKey())),1, EntityAttributeModifier.Operation.ADD_VALUE,true);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable(""));
        tooltip.add(Text.translatable("item.nightmarecharm.tool.string").formatted(Formatting.RED));
        tooltip.add(Text.translatable("item.nightmarecharm.tool.string.1").formatted(Formatting.RED));
        tooltip.add(Text.translatable(""));
        tooltip.add(Text.translatable("item.nightmarecharm.tool.string.2").formatted(Formatting.RED));

        tooltip.add(Text.translatable(""));
        tooltip.add(Text.translatable("item.nightmareanchor.tool.string.6").formatted(Formatting.RED));
        tooltip.add(Text.translatable("item.nightmareanchor.tool.string.7").formatted(Formatting.RED));
    }
}

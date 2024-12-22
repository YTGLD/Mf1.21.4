package com.moonfabric.item.nightmare;

import com.moonfabric.item.Ms.nightmare;
import io.wispforest.accessories.api.attributes.AccessoryAttributeBuilder;
import io.wispforest.accessories.api.slot.SlotReference;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

import java.util.List;

public class nightmareanchor extends nightmare {
    public nightmareanchor(Settings settings) {
        super(settings);
    }

    @Override
    public void getDynamicModifiers(ItemStack stack, SlotReference reference, AccessoryAttributeBuilder builder) {
        builder.getSlotModifiers().put("hand/ring",new EntityAttributeModifier(Identifier.of(String.valueOf(this.getTranslationKey())),1, EntityAttributeModifier.Operation.ADD_VALUE));
    }


    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable(""));
        tooltip.add(Text.translatable("item.nightmareanchor.tool.string.5").formatted(Formatting.RED));

        tooltip.add(Text.translatable(""));
        tooltip.add(Text.translatable("item.nightmareanchor.tool.string.6").formatted(Formatting.RED));
        tooltip.add(Text.translatable("item.nightmareanchor.tool.string.7").formatted(Formatting.RED));
        tooltip.add(Text.translatable(""));


    }

}

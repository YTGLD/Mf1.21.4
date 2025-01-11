package com.moonfabric.item.nightmare.super_nightmare;

import com.moonfabric.item.Ms.nightmare;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class nightmare_base_reversal_card extends com.moonfabric.item.Ms.SNightmare{
    public nightmare_base_reversal_card(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        tooltip.add(Text.translatable("item.nightmare_base_reversal_card.tool.string").formatted(Formatting.DARK_RED));
        tooltip.add(Text.translatable("item.nightmare_base_reversal_card.tool.string.2").formatted(Formatting.DARK_RED));
    }

}

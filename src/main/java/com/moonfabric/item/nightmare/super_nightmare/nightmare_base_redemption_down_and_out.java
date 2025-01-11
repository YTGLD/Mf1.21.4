package com.moonfabric.item.nightmare.super_nightmare;

import com.moonfabric.item.Ms.nightmare;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class nightmare_base_redemption_down_and_out extends com.moonfabric.item.Ms.SNightmare{
    public nightmare_base_redemption_down_and_out(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        tooltip.add(Text.translatable("item.nightmare_base_redemption_down_and_out.tool.string").formatted(Formatting.DARK_RED));
    }

}



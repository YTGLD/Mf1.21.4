package com.moonfabric.item.common.Mise;

import com.moonfabric.item.Ms.extend.ItemTir;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class gazer extends ItemTir {

    public gazer(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, net.minecraft.item.tooltip.TooltipType type) {
        tooltip.add(Text.translatable("moonfabric.tooltip.gazer.1").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("moonfabric.tooltip.gazer.2").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable(""));

    }
}



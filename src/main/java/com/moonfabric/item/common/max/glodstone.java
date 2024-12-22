package com.moonfabric.item.common.max;

import com.moonfabric.item.Ms.extend.ItemTir;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class glodstone extends ItemTir {
    public glodstone(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, net.minecraft.item.tooltip.TooltipType type) {
        tooltip.add(Text.translatable(""));
        tooltip.add(Text.translatable("moonfabric.tooltip.glodstone.1").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("moonfabric.tooltip.glodstone.2").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("moonfabric.tooltip.glodstone.3").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable(""));
        tooltip.add(Text.translatable("moonfabric.tooltip.glodstone.4").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("moonfabric.tooltip.glodstone.5").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("moonfabric.tooltip.glodstone.6").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable(""));

    }
}

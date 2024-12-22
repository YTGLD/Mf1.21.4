package com.moonfabric.item.common.CurseOrDoom;

import com.moonfabric.item.Ms.extend.curse;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class curseshield extends curse {


    public curseshield(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, net.minecraft.item.tooltip.TooltipType type) {
        tooltip.add(Text.translatable("moonfabric.tooltip.curseshield.1").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("moonfabric.tooltip.curseshield.2").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable(""));
    }
}

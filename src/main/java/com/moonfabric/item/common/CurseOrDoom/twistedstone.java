package com.moonfabric.item.common.CurseOrDoom;

import com.moonfabric.item.Ms.extend.ItemTir;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class twistedstone extends ItemTir {

    public twistedstone(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, net.minecraft.item.tooltip.TooltipType type) {
        tooltip.add(Text.translatable("moonfabric.tooltip.twistedstone.1").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("moonfabric.tooltip.twistedstone.2").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable(""));



    }
}

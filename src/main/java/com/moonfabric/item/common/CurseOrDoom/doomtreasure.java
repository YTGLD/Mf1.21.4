package com.moonfabric.item.common.CurseOrDoom;

import com.moonfabric.item.Ms.extend.doom;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class doomtreasure extends doom {


    public doomtreasure(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, net.minecraft.item.tooltip.TooltipType type) {
        tooltip.add(Text.translatable("moonfabric.tooltip.doomtreasure.1").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("moonfabric.tooltip.doomtreasure.2").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable(""));

    }
}

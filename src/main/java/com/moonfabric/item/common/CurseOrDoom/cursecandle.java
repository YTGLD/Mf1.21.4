package com.moonfabric.item.common.CurseOrDoom;

import com.moonfabric.item.Ms.extend.curse;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class cursecandle extends curse {


    public cursecandle(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, net.minecraft.item.tooltip.TooltipType type) {
        tooltip.add(Text.translatable("moonfabric.tooltip.cursecandle.1").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable(""));
    }
}

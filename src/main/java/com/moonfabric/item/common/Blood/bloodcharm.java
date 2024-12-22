package com.moonfabric.item.common.Blood;

import com.moonfabric.item.Ms.TheNecoraIC;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class bloodcharm extends TheNecoraIC {


    public bloodcharm(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, net.minecraft.item.tooltip.TooltipType type) {
        tooltip.add(Text.translatable(""));


        tooltip.add(Text.translatable("moonfabric.tooltip.bloodcharm.1").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("moonfabric.tooltip.bloodcharm.2").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable(""));
        tooltip.add(Text.translatable("moonfabric.tooltip.bloodcharm.3").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable(""));


    }
}

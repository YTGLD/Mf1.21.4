package com.moonfabric.item.Ms.CottonCandy;

import com.moonfabric.HasCurio;
import com.moonfabric.init.init;
import io.wispforest.accessories.api.slot.SlotReference;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class goldcottoncandy extends CottonCandy {
    public goldcottoncandy(Settings settings) {
        super(settings);
    }

    @Override
    public boolean canEquip(ItemStack stack, SlotReference reference) {
        boolean a = true;
        if (reference.entity() instanceof PlayerEntity player){
            if (HasCurio.has(init.goldcottoncandy, player)){
                a = false;
            }
            if (HasCurio.has(init.woodcottoncandy, player)){
                a = false;
            }
            if (HasCurio.has(init.watercottoncandy, player)){
                a = false;
            }
            if (HasCurio.has(init.firecottoncandy, player)){
                a = false;
            }if (HasCurio.has(init.stonecottoncandy, player)){
                a = false;
            }

        }
        return a;
    }
  @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, net.minecraft.item.tooltip.TooltipType type) {
        tooltip.add(Text.translatable(""));
        tooltip.add(Text.translatable("moonfabric.tooltip.goldcottoncandy.1").formatted(Formatting.GRAY));//
        tooltip.add(Text.translatable("moonfabric.tooltip.goldcottoncandy.2").formatted(Formatting.GRAY));//
        tooltip.add(Text.translatable("moonfabric.tooltip.goldcottoncandy.3").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable(""));
        tooltip.add(Text.translatable("moonfabric.tooltip.goldcottoncandy.4").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("moonfabric.tooltip.goldcottoncandy.5").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable(""));
        tooltip.add(Text.translatable("moonfabric.tooltip.goldcottoncandy.6").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable(""));


    }
}

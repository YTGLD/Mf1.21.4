package com.moonfabric.item.common.NaNo;

import com.moonfabric.item.Ms.extend.doom;
import io.wispforest.accessories.api.slot.SlotReference;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class nanofruit extends doom {
    public nanofruit(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, net.minecraft.item.tooltip.TooltipType type) {
        tooltip.add(Text.translatable("moonfabric.tooltip.nanofruit.1").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("moonfabric.tooltip.nanofruit.2").formatted(Formatting.GRAY));

        tooltip.add(Text.translatable(""));
    }

    @Override
    public void tick(ItemStack stack, SlotReference reference) {
        if (reference.entity().hasStatusEffect(StatusEffects.DARKNESS)) {
            reference.entity().removeStatusEffect(StatusEffects.DARKNESS);
        }
  }


}

package com.moonfabric.item.common.Mise;

import com.moonfabric.item.Ms.extend.ItemTir;
import io.wispforest.accessories.api.slot.SlotReference;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class firehead extends ItemTir {

    public firehead(Settings settings) {
        super(settings);
    }

    @Override
    public void tick(ItemStack stack, SlotReference reference) {
        if (reference.entity() instanceof PlayerEntity player){
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 320, 2));
        }
    }



    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, net.minecraft.item.tooltip.TooltipType type) {
        tooltip.add(Text.translatable("moonfabric.tooltip.firehead.1").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable(""));

    }
}



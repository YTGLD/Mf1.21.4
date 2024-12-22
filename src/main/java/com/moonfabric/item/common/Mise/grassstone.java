package com.moonfabric.item.common.Mise;

import com.moonfabric.item.Ms.extend.ItemTir;
import io.wispforest.accessories.api.slot.SlotReference;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class grassstone extends ItemTir {


    public grassstone(Settings settings) {
        super(settings);
    }

    @Override
    public void tick(ItemStack stack, SlotReference reference) {
        if (reference.entity() instanceof PlayerEntity player){
            if (!player.getWorld().isClient){
                player.heal(0.01f);
            }
        }
    }



  

  @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, net.minecraft.item.tooltip.TooltipType type) {
        tooltip.add(Text.translatable("moonfabric.tooltip.grassstone.1").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable(""));

    }
}



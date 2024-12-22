package com.moonfabric.item.common.Mise;

import com.moonfabric.init.Data;
import com.moonfabric.item.Ms.extend.ItemTir;
import io.wispforest.accessories.api.slot.SlotReference;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class goldbox extends ItemTir {
    public goldbox(Settings settings) {
        super(settings);
    }

    @Override
    public void tick(ItemStack stack, SlotReference reference) {
        if (stack.get(Data.CUSTOM_DATA)!= null) {
            if (stack.get(Data.CUSTOM_DATA).getInt(goldbox.gold) >= 1000) {
                if (reference.entity() instanceof PlayerEntity player) {

                    player.giveItemStack(new ItemStack(Items.ENCHANTED_GOLDEN_APPLE));

                    player.giveItemStack(new ItemStack(Items.GOLDEN_APPLE));
                    player.giveItemStack(new ItemStack(Items.GOLDEN_APPLE));
                    player.giveItemStack(new ItemStack(Items.GOLDEN_APPLE));

                    stack.get(Data.CUSTOM_DATA).putInt(gold, stack.get(Data.CUSTOM_DATA).getInt(goldbox.gold) - 1000);
                }
            }
        }
    }


    public static String gold = "gold";
  @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, net.minecraft.item.tooltip.TooltipType type) {
        tooltip.add(Text.translatable("moonfabric.tooltip.goldbox.1").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("moonfabric.tooltip.goldbox.2").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("moonfabric.tooltip.goldbox.3").formatted(Formatting.GRAY));
        if (stack.get(Data.CUSTOM_DATA)!= null) {
          tooltip.add(Text.translatable("Now:" + stack.get(Data.CUSTOM_DATA).getInt(goldbox.gold)).formatted(Formatting.WHITE));
          tooltip.add(Text.translatable(""));
      }


    }
}

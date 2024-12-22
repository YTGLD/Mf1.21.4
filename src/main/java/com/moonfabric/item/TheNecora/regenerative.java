package com.moonfabric.item.TheNecora;

import com.moonfabric.item.INecora;
import com.moonfabric.item.Ms.TheNecoraIC;
import io.wispforest.accessories.api.slot.SlotReference;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class regenerative extends TheNecoraIC implements INecora {


    public regenerative(Settings settings) {
        super(settings);
    }

    @Override
    public void tick(ItemStack stack, SlotReference reference) {
        if (reference.entity() instanceof PlayerEntity player) {
            if (!player.getItemCooldownManager().isCoolingDown(this.getDefaultStack())) {
                player.heal(1);
                player.getItemCooldownManager().set(this.getDefaultStack(), 30);
            }
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        tooltip.add(Text.translatable(""));
        tooltip.add(Text.translatable("item.regenerative.tool.string").formatted(Formatting.RED));
        tooltip.add(Text.translatable(""));
    }
}





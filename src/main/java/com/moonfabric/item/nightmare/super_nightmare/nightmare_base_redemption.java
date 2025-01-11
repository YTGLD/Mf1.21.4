package com.moonfabric.item.nightmare.super_nightmare;

import com.moonfabric.item.Ms.nightmare;
import io.wispforest.accessories.api.slot.SlotReference;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class nightmare_base_redemption extends com.moonfabric.item.Ms.SNightmare{
    public nightmare_base_redemption(Settings settings) {
        super(settings);
    }

    @Override
    public boolean canUnequip(ItemStack stack, SlotReference reference) {
        if (reference.entity() instanceof PlayerEntity player){
            if (player.isCreative()){
                return true;
            }
        }
        return false;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        tooltip.add(Text.translatable("item.nightmare_base_redemption.tool.string").formatted(Formatting.DARK_RED));
        tooltip.add(Text.literal(""));
        tooltip.add(Text.translatable("item.nightmare_base_black_eye.tool.string.1").formatted(Formatting.RED));
        tooltip.add(Text.translatable("item.moonfabric.nightmare_base_redemption_deception").formatted(Formatting.DARK_RED));
        tooltip.add(Text.translatable("item.moonfabric.nightmare_base_redemption_degenerate").formatted(Formatting.DARK_RED));
        tooltip.add(Text.translatable("item.moonfabric.nightmare_base_redemption_down_and_out").formatted(Formatting.DARK_RED));
        tooltip.add(Text.literal(""));

        tooltip.add(Text.translatable("item.nightmareeye.tool.string.2").formatted(Formatting.DARK_RED));

    }
}

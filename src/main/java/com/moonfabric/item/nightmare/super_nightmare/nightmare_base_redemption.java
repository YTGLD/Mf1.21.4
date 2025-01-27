package com.moonfabric.item.nightmare.super_nightmare;

import com.moonfabric.Ievent.AdvancementEvt;
import com.moonfabric.init.Data;
import com.moonfabric.init.init;
import com.moonfabric.item.Ms.nightmare;
import io.wispforest.accessories.api.slot.SlotReference;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.world.ServerWorld;
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
    public void tick(ItemStack stack, SlotReference reference) {
        super.tick(stack, reference);
        if (reference.entity() instanceof PlayerEntity player){
            if (player.getWorld() instanceof ServerWorld serverLevel){
                if (serverLevel.getRaidAt(player.getBlockPos())!=null && serverLevel.getRaidAt(player.getBlockPos()).hasLost()){
                    if (stack.get(Data.CUSTOM_DATA)!=null&&!stack.get(Data.CUSTOM_DATA).getBoolean(AdvancementEvt.nightmare_base_redemption_down_and_out)){
                        player.giveItemStack(new ItemStack(init.nightmare_base_redemption_down_and_out));
                        stack.get(Data.CUSTOM_DATA).putBoolean(AdvancementEvt.nightmare_base_redemption_down_and_out,true);
                    }
                }
            }
        }
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

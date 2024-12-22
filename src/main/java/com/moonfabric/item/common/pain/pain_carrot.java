package com.moonfabric.item.common.pain;

import com.moonfabric.HasCurio;
import com.moonfabric.Ievent.old.IeventAttack;
import com.moonfabric.init.Data;
import com.moonfabric.init.init;
import com.moonfabric.item.Ms.extend.ItemTir;
import io.wispforest.accessories.api.slot.SlotReference;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class pain_carrot extends ItemTir {
    /*
    吃下食物获得10%的力量提升
    在满饥饿值时清除

     */
    public static final String eat = "Eat";

    public pain_carrot(Settings settings) {
        super(settings);
    }

    public static void str(){
        IeventAttack.ON_HURT.register(((living, source, size, stack) -> {
            if (stack.isOf(init.pain_carrot)&& HasCurio.has(init.pain_carrot, living)){
                if (stack.get(Data.CUSTOM_DATA)!= null) {
                    float s = stack.get(Data.CUSTOM_DATA).getFloat(eat);
                    return size*(1+s);
                }
            }
            return size;
        }));
    }

    @Override
    public void tick(ItemStack stack, SlotReference reference) {
        if (stack.get(Data.CUSTOM_DATA)!=null){
            if (reference.entity() instanceof PlayerEntity player) {
                if (player.getHungerManager().getFoodLevel() >= 20) {
                    stack.get(Data.CUSTOM_DATA).remove(eat);
                }
            }
        }
    }


    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, net.minecraft.item.tooltip.TooltipType type) {
        tooltip.add(Text.translatable("moonfabric.tooltip.pain_carrot.1").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("moonfabric.tooltip.pain_carrot.2").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable(""));

    }

}

package com.moonfabric.item.Ms.CottonCandy;

import com.moonfabric.HasCurio;
import com.moonfabric.init.init;
import io.wispforest.accessories.api.slot.SlotReference;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class watercottoncandy extends CottonCandy{
    public watercottoncandy(Settings settings) {
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
    public void tick(ItemStack stack, SlotReference reference) {
        if (reference.entity().isTouchingWaterOrRain()){
            if (reference.entity() instanceof PlayerEntity player) {
                if (!player.getItemCooldownManager().isCoolingDown(this.getDefaultStack())) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.CONDUIT_POWER, 400, 2));
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 400, 2));
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 400, 0));
                }
            }
        }    }

  @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, net.minecraft.item.tooltip.TooltipType type) {
        tooltip.add(Text.translatable(""));
        tooltip.add(Text.translatable("moonfabric.tooltip.watercottoncandy.1").formatted(Formatting.GRAY));//
        tooltip.add(Text.translatable("moonfabric.tooltip.watercottoncandy.2").formatted(Formatting.GRAY));//
        tooltip.add(Text.translatable("moonfabric.tooltip.watercottoncandy.3").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable(""));
        tooltip.add(Text.translatable("moonfabric.tooltip.watercottoncandy.5").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable(""));
        tooltip.add(Text.translatable("moonfabric.tooltip.watercottoncandy.6").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable(""));


    }
}

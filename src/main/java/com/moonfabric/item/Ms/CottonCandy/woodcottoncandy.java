package com.moonfabric.item.Ms.CottonCandy;

import com.moonfabric.HasCurio;
import com.moonfabric.MoonFabricMod;
import com.moonfabric.init.AttReg;
import com.moonfabric.init.init;
import io.wispforest.accessories.api.attributes.AccessoryAttributeBuilder;
import io.wispforest.accessories.api.slot.SlotReference;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

import java.util.List;

public class woodcottoncandy extends CottonCandy{
    public woodcottoncandy(Settings settings) {
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
    public void getDynamicModifiers(ItemStack stack, SlotReference reference, AccessoryAttributeBuilder builder) {
        builder.addExclusive(AttReg.heal, new EntityAttributeModifier(Identifier.of(MoonFabricMod.MODID+this.getTranslationKey()), 1, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE));
    }


  @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, net.minecraft.item.tooltip.TooltipType type) {
        tooltip.add(Text.translatable(""));
        tooltip.add(Text.translatable("moonfabric.tooltip.woodcottoncandy.1").formatted(Formatting.GRAY));//
        tooltip.add(Text.translatable("moonfabric.tooltip.woodcottoncandy.2").formatted(Formatting.GRAY));//
        tooltip.add(Text.translatable("moonfabric.tooltip.woodcottoncandy.3").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable(""));
        tooltip.add(Text.translatable("moonfabric.tooltip.woodcottoncandy.4").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("moonfabric.tooltip.woodcottoncandy.5").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable(""));
        tooltip.add(Text.translatable("moonfabric.tooltip.woodcottoncandy.6").formatted(Formatting.GRAY));
    }
}






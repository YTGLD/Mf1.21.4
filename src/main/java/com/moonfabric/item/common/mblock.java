package com.moonfabric.item.common;

import com.moonfabric.HasCurio;
import com.moonfabric.init.init;
import com.moonfabric.item.Ms.extend.ItemTir;
import io.wispforest.accessories.api.attributes.AccessoryAttributeBuilder;
import io.wispforest.accessories.api.slot.SlotReference;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

import java.util.List;

public class mblock extends ItemTir {
    public mblock(Settings settings) {
        super(settings);
    }

    public static int Block(LivingEntity living){
        if( HasCurio.has(init.mblock,living)){
            return 1;
        }else return 0;
    }
    public static int loot(LivingEntity living){
        if( HasCurio.has(init.mblock,living)){
            return 1;
        }else return 0;
    }
    @Override
    public void getDynamicModifiers(ItemStack stack, SlotReference reference, AccessoryAttributeBuilder builder) {
        builder.getSlotModifiers().put("legs/belt",new EntityAttributeModifier(Identifier.of(String.valueOf(this.getTranslationKey())),1, EntityAttributeModifier.Operation.ADD_VALUE));
    }


    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, net.minecraft.item.tooltip.TooltipType type) {
        tooltip.add(Text.translatable(""));
        tooltip.add(Text.translatable("moonfabric.tooltip.mblock").formatted(Formatting.GRAY));

    }
}


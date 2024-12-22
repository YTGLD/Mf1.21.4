package com.moonfabric.item.TheNecora;

import com.moonfabric.item.INecora;
import com.moonfabric.item.Ms.TheNecoraIC;
import io.wispforest.accessories.api.attributes.AccessoryAttributeBuilder;
import io.wispforest.accessories.api.slot.SlotReference;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

import java.util.List;

public class giant extends TheNecoraIC implements INecora {

    public giant(Settings settings) {
        super(settings);
    }

    @Override
    public void getDynamicModifiers(ItemStack stack, SlotReference reference, AccessoryAttributeBuilder builder) {
        builder.getSlotModifiers().put("legs/belt",new EntityAttributeModifier(Identifier.of(String.valueOf(this.getTranslationKey())),1, EntityAttributeModifier.Operation.ADD_VALUE));
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        tooltip.add(Text.translatable("moonfabric.tooltip.necora").formatted(Formatting.RED));
        tooltip.add(Text.translatable(""));
        tooltip.add(Text.translatable("item.giant.tool.string").formatted(Formatting.RED));
        tooltip.add(Text.translatable(""));
    }
}

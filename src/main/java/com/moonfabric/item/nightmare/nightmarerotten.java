package com.moonfabric.item.nightmare;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.moonfabric.init.Data;
import com.moonfabric.item.Ms.nightmare;
import io.wispforest.accessories.api.slot.SlotReference;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

import java.util.List;

public class nightmarerotten extends nightmare {

    public static final String nightmarerotten = "NightmareRotten";

    public nightmarerotten(Settings settings) {
        super(settings);
    }


    public Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> getModifiers(LivingEntity entity) {
        Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> modifierMultimap = HashMultimap.create();

        for(EntityAttribute entityAttribute : Registries.ATTRIBUTE) {
            modifierMultimap.put(Registries.ATTRIBUTE.getEntry(entityAttribute),new EntityAttributeModifier(Identifier.of("base_attack_damage"+this.getTranslationKey()),0.2, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE));
        }

        return modifierMultimap;
    }

    @Override
    public void tick(ItemStack stack, SlotReference reference) {
        reference.entity().getAttributes().addTemporaryModifiers(this.getModifiers(  reference.entity()));
        if (stack.get(Data.CUSTOM_DATA)==null   ){
            stack.set(Data.CUSTOM_DATA,new NbtCompound());
        }else {
            int s = Registries.ATTRIBUTE.size();
            stack.get(Data.CUSTOM_DATA).putInt(nightmarerotten,s);
        }
    }

    @Override
    public void onUnequip(ItemStack stack, SlotReference reference) {
        super.onUnequip(stack,reference);
        reference.entity().getAttributes().removeModifiers(this.getModifiers(reference.entity()));
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable(""));
        tooltip.add(Text.translatable("item.nightmarerotten.tool.string").formatted(Formatting.RED));
        tooltip.add(Text.translatable("item.nightmarerotten.tool.string.1").formatted(Formatting.RED));
        tooltip.add(Text.translatable("item.nightmarerotten.tool.string.2").formatted(Formatting.RED));
        tooltip.add(Text.translatable(""));
        NbtCompound tag = stack.get(Data.CUSTOM_DATA);
        if (tag != null){
            tooltip.add(Text.translatable("·now：" + ((float) (tag.getInt(nightmarerotten) * 1.1)) + "%").formatted(Formatting.RED));

        }
        tooltip.add(Text.translatable(""));

        tooltip.add(Text.translatable("item.nightmarerotten.tool.string.3").formatted(Formatting.RED));
        tooltip.add(Text.translatable("item.nightmarerotten.tool.string.4").formatted(Formatting.RED));
    }

}

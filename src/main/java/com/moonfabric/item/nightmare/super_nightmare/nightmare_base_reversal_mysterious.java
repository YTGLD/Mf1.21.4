package com.moonfabric.item.nightmare.super_nightmare;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.moonfabric.init.Data;
import com.moonfabric.item.Ms.nightmare;
import io.wispforest.accessories.api.slot.SlotReference;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

import java.util.List;

public class nightmare_base_reversal_mysterious extends com.moonfabric.item.Ms.SNightmare{

    public nightmare_base_reversal_mysterious(Settings settings) {
        super(settings);
    }

    public Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> getAttributeModifierss() {
        Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> get = HashMultimap.create();
        double as = -0.1f;

        for (EntityAttribute attribute : Registries.ATTRIBUTE){
            get.put(Registries.ATTRIBUTE.getEntry(attribute), new EntityAttributeModifier(Identifier.of("base_attack_damage"+this.getTranslationKey()), as, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE));
        }
        return get;
    }

    @Override
    public void tick(ItemStack stack, SlotReference reference) {
        if (reference.entity() instanceof PlayerEntity player) {
            NbtCompound tag = stack.get(Data.CUSTOM_DATA);
            if (tag != null){
                player.getAttributes().addTemporaryModifiers(this.getAttributeModifierss());
            }else {
                stack.set(Data.CUSTOM_DATA,new NbtCompound());
            }
        }
    }

    @Override
    public void onUnequip(ItemStack stack, SlotReference reference) {
        if (reference.entity() instanceof PlayerEntity player){
            player.getAttributes().removeModifiers(this.getAttributeModifierss());
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        tooltip.add(Text.translatable("item.nightmare_base_reversal_mysterious.tool.string").formatted(Formatting.DARK_RED));
    }

}


package com.moonfabric.item.common.Mise;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.moonfabric.HasCurio;
import com.moonfabric.init.init;
import com.moonfabric.item.Ms.extend.ItemTir;
import io.wispforest.accessories.api.attributes.AccessoryAttributeBuilder;
import io.wispforest.accessories.api.slot.SlotReference;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

import java.util.List;

public class whiteorb extends ItemTir {


    public whiteorb(Settings settings) {
        super(settings);
    }

    @Override
    public void getDynamicModifiers(ItemStack stack, SlotReference reference, AccessoryAttributeBuilder builder) {
        Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> modifierMultimap = HashMultimap.create();
        float a = 0.15f;

        if (reference.entity() instanceof PlayerEntity p){
            if (HasCurio.has(init.blackorb, p)){
                a *= 2;
            }
        }


        builder.addStackable(EntityAttributes.ATTACK_SPEED,new EntityAttributeModifier(Identifier.of(String.valueOf(this.getTranslationKey())),a, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE));
    }


  @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, net.minecraft.item.tooltip.TooltipType type) {
        tooltip.add(Text.translatable("moonfabric.tooltip.whiteorb.1").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable(""));


    }
}


package com.moonfabric.item.ectoplasm;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.moonfabric.item.Ms.ectoplasm;
import io.wispforest.accessories.api.slot.SlotReference;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.UUID;

public class ectoplasmstar extends ectoplasm {
    public ectoplasmstar(Settings settings) {
        super(settings);
    }

    @Override
    public void tick(ItemStack stack, SlotReference reference) {
        if (reference.entity() instanceof PlayerEntity player) {
            player.getAttributes().addTemporaryModifiers(att());
            player.getAttributes().addTemporaryModifiers(att2(player));
        }
    }

    @Override
    public void onUnequip(ItemStack stack, SlotReference reference) {
        if (reference.entity() instanceof PlayerEntity player){
            player.getAttributes().removeModifiers(att());
            player.getAttributes().removeModifiers(att2(player));
        }
    }


    public Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> att(){
        Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> modifierMultimap = HashMultimap.create();
        modifierMultimap.put(EntityAttributes. LUCK, new EntityAttributeModifier(Identifier.of("ectoplasmstar"), 0.2, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE));
        return modifierMultimap;
    }
    public Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> att2(PlayerEntity player){
        Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> modifierMultimap = HashMultimap.create();
        UUID uuid = UUID.fromString("00000000-0000-3005-998f-50309b7cf9e8");
        float s = player.getLuck();
        s /= 100;
        modifierMultimap.put(EntityAttributes. ATTACK_DAMAGE, new EntityAttributeModifier(Identifier.of("ectoplasmstar"), s/2, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE));
        modifierMultimap.put(EntityAttributes. ATTACK_SPEED, new EntityAttributeModifier(Identifier.of("ectoplasmstar"), s, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE));
        return modifierMultimap;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        tooltip.add(Text.translatable("item.ectoplasmstar.tool.string").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable(""));
        tooltip.add(Text.translatable("item.ectoplasmstar.tool.string.1").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable(""));  }


}



package com.moonfabric.item.common.CurseOrDoom;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.moonfabric.init.Data;
import com.moonfabric.item.Ms.extend.rage;
import io.wispforest.accessories.api.slot.SlotReference;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
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
import java.util.Set;

public class rageapple extends rage {
    public static float aFloat = 0;
    public static String lvl = "lvl";

    public rageapple(Settings settings) {
        super(settings);
    }

    @Override
    public void onUnequip(ItemStack stack, SlotReference reference) {
        if (reference.entity() instanceof PlayerEntity player){
            player.getAttributes().removeModifiers(get(stack, player));
        }
    }

    @Override
    public void onEquip(ItemStack stack, SlotReference reference) {
        if (reference.entity() instanceof PlayerEntity player) {
            player.getAttributes().addTemporaryModifiers(get(stack, player));
        }
    }

    @Override
    public void tick(ItemStack stack, SlotReference reference) {
        if (reference.entity() instanceof PlayerEntity player){
            if (stack.get(Data.CUSTOM_DATA)!= null){
                aFloat = acc(player);
                stack.get(Data.CUSTOM_DATA).putFloat(lvl, acc(player));
            }
        }
    }


   

  @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, net.minecraft.item.tooltip.TooltipType type) {
        tooltip.add(Text.translatable("moonfabric.tooltip.rageapple.1").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("moonfabric.tooltip.rageapple.2").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("moonfabric.tooltip.rageapple.3").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable(""+aFloat).formatted(Formatting.GRAY));
        tooltip.add(Text.translatable(""));

    }

    private float acc(PlayerEntity player) {
        float size = 0;
        List<ItemStack> slot_stack = Lists.newArrayList();
        Iterable<ItemStack> S  = player.getArmorItems();
        for (ItemStack sck : S){
            slot_stack.add(sck);
        }

        for (ItemStack stack : slot_stack){
            if (!stack.isEmpty()){
                Set<RegistryEntry<Enchantment>> map =  EnchantmentHelper.getEnchantments(stack).getEnchantments();
                for (RegistryEntry<Enchantment> enchantment : map){
                    int lvl = EnchantmentHelper.getLevel(enchantment, stack);
                    if  (size < 75){
                        size += lvl;
                    }else {
                        size = 75;
                    }

                }

            }
        }

        return size;
    }
    public Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> get(ItemStack stack, PlayerEntity entity) {
        Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> modifierMultimap = HashMultimap.create();


        modifierMultimap.put(EntityAttributes.MOVEMENT_SPEED, new EntityAttributeModifier(Identifier.of(String.valueOf(this.getTranslationKey())),stack.get(Data.CUSTOM_DATA).getFloat(lvl) / 100, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE));
        modifierMultimap.put(EntityAttributes.ARMOR, new EntityAttributeModifier(Identifier.of(String.valueOf(this.getTranslationKey())),stack.get(Data.CUSTOM_DATA).getFloat(lvl) / 100, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE));
        modifierMultimap.put(EntityAttributes.MAX_HEALTH, new EntityAttributeModifier(Identifier.of(String.valueOf(this.getTranslationKey())),stack.get(Data.CUSTOM_DATA).getFloat(lvl) / 100, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE));
        modifierMultimap.put(EntityAttributes.ATTACK_DAMAGE, new EntityAttributeModifier(Identifier.of(String.valueOf(this.getTranslationKey())),stack.get(Data.CUSTOM_DATA).getFloat(lvl) / 100, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE));

        modifierMultimap.put(EntityAttributes.ATTACK_SPEED, new EntityAttributeModifier(Identifier.of(String.valueOf(this.getTranslationKey())),stack.get(Data.CUSTOM_DATA).getFloat(lvl) / 100, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE));

        return modifierMultimap;
    }
}





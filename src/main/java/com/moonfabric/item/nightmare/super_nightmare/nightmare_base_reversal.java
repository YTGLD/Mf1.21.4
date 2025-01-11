package com.moonfabric.item.nightmare.super_nightmare;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.moonfabric.HasCurio;
import com.moonfabric.init.Data;
import com.moonfabric.init.init;
import com.moonfabric.item.Ms.nightmare;
import io.wispforest.accessories.api.AccessoriesCapability;
import io.wispforest.accessories.api.AccessoriesContainer;
import io.wispforest.accessories.api.slot.SlotReference;
import io.wispforest.accessories.impl.ExpandedSimpleContainer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffects;
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
import java.util.Map;

public class nightmare_base_reversal extends com.moonfabric.item.Ms.SNightmare{


    public static final String att= "Attrib";

    public nightmare_base_reversal(Settings settings) {
        super(settings);
    }


    @Override
    public boolean canUnequip(ItemStack stack, SlotReference reference) {
        if (reference.entity() instanceof PlayerEntity player){
            if (player.isCreative()){
                return true;
            }
        }
        return false;
    }
    public static void LivingDeathEvent(DamageSource damageSource, LivingEntity living){
        if (living instanceof PlayerEntity player) {
            if (HasCurio.has(init.nightmare_base_reversal, player)){
                AccessoriesCapability capability = AccessoriesCapability.get(player);
                if (capability != null) {
                    if (HasCurio.has(init.nightmare_base_reversal, player)) {
                        for (Map.Entry<String, AccessoriesContainer> stringAccessoriesContainerEntry : capability.getContainers().entrySet()) {
                            AccessoriesContainer container = stringAccessoriesContainerEntry.getValue();
                            ExpandedSimpleContainer accessories = container.getAccessories();
                            for (int i = 0; i < accessories.size(); ++i) {
                                ItemStack stack = accessories.getStack(i);
                                if (stack.isOf(init.nightmare_base_reversal)) {
                                    if (stack.get(Data.CUSTOM_DATA) != null) {
                                        if (stack.get(Data.CUSTOM_DATA)!=null){
                                            stack.get(Data.CUSTOM_DATA).putInt(att,96);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void tick(ItemStack stack, SlotReference reference) {
        reference.entity().getAttributes().addTemporaryModifiers(geta(stack));
        if (reference.entity().hasStatusEffect(StatusEffects.POISON)){

            if (reference.entity().getHealth()<=1){
                reference.entity().serverDamage(reference.entity().getDamageSources().generic(),10);
            }
        }
        if (stack.get(Data.CUSTOM_DATA)!=null){
            if (!HasCurio.has(init.nightmare_base_reversal_card, reference.entity())) {
                if (stack.get(Data.CUSTOM_DATA).getInt(att) >= 4) {
                    if (reference.entity() instanceof PlayerEntity player && !player.getItemCooldownManager().isCoolingDown(stack.getItem().getDefaultStack())) {
                        stack.get(Data.CUSTOM_DATA).putInt(att, stack.get(Data.CUSTOM_DATA).getInt(att) - 4);
                        player.getItemCooldownManager().set(stack.getItem().getDefaultStack(), 20);
                    }
                }
            }else {
                if (stack.get(Data.CUSTOM_DATA).getInt(att) >= -46) {
                    if (reference.entity() instanceof PlayerEntity player && !player.getItemCooldownManager().isCoolingDown(stack.getItem().getDefaultStack())) {
                        stack.get(Data.CUSTOM_DATA).putInt(att, stack.get(Data.CUSTOM_DATA).getInt(att) - 2);
                        player.getItemCooldownManager().set(stack.getItem().getDefaultStack(), 20);
                    }
                }
            }
        }else {
            stack.set(Data.CUSTOM_DATA,new NbtCompound());
        }
    }

    @Override
    public void onUnequip(ItemStack stack, SlotReference reference) {
        reference.entity().getAttributes().removeModifiers(geta(stack));
    }

    public Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> geta(ItemStack stack) {
        Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> get = HashMultimap.create();

        if (stack.get(Data.CUSTOM_DATA)!=null) {
            double as = -stack.get(Data.CUSTOM_DATA).getInt(att);
            as/=100;
            for (EntityAttribute attribute : Registries.ATTRIBUTE) {

                get.put(Registries.ATTRIBUTE.getEntry(attribute), new EntityAttributeModifier(Identifier.of("base_attack_damage" + this.getTranslationKey()), as, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE));
            }
        }
        return get;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        tooltip.add(Text.translatable("item.nightmare_base_reversal.tool.string").formatted(Formatting.DARK_RED));
        tooltip.add(Text.translatable("item.nightmare_base_reversal.tool.string.2").formatted(Formatting.DARK_RED));
        tooltip.add(Text.translatable("item.nightmare_base_reversal.tool.string.3").formatted(Formatting.DARK_RED));
        tooltip.add(Text.literal(""));
        tooltip.add(Text.translatable("item.nightmare_base_black_eye.tool.string.1").formatted(Formatting.RED));
        tooltip.add(Text.translatable("item.moonfabric.nightmare_base_reversal_orb").formatted(Formatting.DARK_RED));
        tooltip.add(Text.translatable("item.moonfabric.nightmare_base_reversal_card").formatted(Formatting.DARK_RED));
        tooltip.add(Text.translatable("item.moonfabric.nightmare_base_reversal_mysterious").formatted(Formatting.DARK_RED));

        tooltip.add(Text.literal(""));

        tooltip.add(Text.translatable("item.nightmareeye.tool.string.2").formatted(Formatting.DARK_RED));

    }

}


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
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.damage.DamageSource;
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

public class nightmare_base_black_eye_red  extends com.moonfabric.item.Ms.SNightmare{
    public static final String aty = "NightmareRed";

    public nightmare_base_black_eye_red(Settings settings) {
        super(settings);
    }

    public static void kill(DamageSource damageSource) {
        if (damageSource.getAttacker() instanceof PlayerEntity player) {
            if (HasCurio.has(init.nightmare_base_black_eye_red, player)) {
                AccessoriesCapability capability = AccessoriesCapability.get(player);
                if (capability != null) {
                    if (HasCurio.has(init.nightmare_base_black_eye_red, player)) {
                        for (Map.Entry<String, AccessoriesContainer> stringAccessoriesContainerEntry : capability.getContainers().entrySet()) {
                            AccessoriesContainer container = stringAccessoriesContainerEntry.getValue();
                            ExpandedSimpleContainer accessories = container.getAccessories();
                            for (int i = 0; i < accessories.size(); ++i) {
                                ItemStack stack = accessories.getStack(i);
                                if (stack.isOf(init.nightmare_base_black_eye_red)) {
                                    if (stack.get(Data.CUSTOM_DATA) != null) {
                                        if (stack.get(Data.CUSTOM_DATA).getInt(aty) < 50) {
                                            stack.get(Data.CUSTOM_DATA).putInt(aty, stack.get(Data.CUSTOM_DATA).getInt(aty) + 5);
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
    public void onEquip(ItemStack stack, SlotReference reference) {
        super.onEquip(stack, reference);
        reference.entity().getAttributes().addTemporaryModifiers(getAttributeModifiers(stack));

    }

    @Override
    public void tick(ItemStack stack, SlotReference reference) {
        stack.setDamage(stack.getDamage() + 1);
        if (stack.get(Data.CUSTOM_DATA) == null) {
            stack.set(Data.CUSTOM_DATA, new NbtCompound());
        } else {
            if (reference.entity().age % 20 == 1) {
                if (stack.get(Data.CUSTOM_DATA).getInt(aty) > 0) {
                    stack.get(Data.CUSTOM_DATA).putInt(aty, stack.get(Data.CUSTOM_DATA).getInt(aty) - 1);
                }
            }
        }
    }

    public Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> getAttributeModifiers(ItemStack stack) {
        Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> get = HashMultimap.create();
        if (stack.get(Data.CUSTOM_DATA) != null) {
            double as = stack.get(Data.CUSTOM_DATA).getInt(aty) / 100f;

            for (EntityAttribute attribute : Registries.ATTRIBUTE) {

                get.put(Registries.ATTRIBUTE.getEntry(attribute), new EntityAttributeModifier(Identifier.of("base_attack_damage" + this.getTranslationKey()), as, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE));
            }
        }
        return get;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        tooltip.add(Text.translatable("item.nightmare_base_black_eye_red.tool.string").formatted(Formatting.DARK_RED));
        tooltip.add(Text.translatable("item.nightmare_base_black_eye_red.tool.string.1").formatted(Formatting.DARK_RED));
        tooltip.add(Text.translatable("item.nightmare_base_black_eye_red.tool.string.2").formatted(Formatting.DARK_RED));
    }

    @Override
    public void onUnequip(ItemStack stack, SlotReference reference) {
        reference.entity().getAttributes().removeModifiers(getAttributeModifiers(stack));
    }
}

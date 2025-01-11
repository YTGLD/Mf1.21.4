package com.moonfabric.item.nightmare.super_nightmare;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.moonfabric.HasCurio;
import com.moonfabric.init.init;
import com.moonfabric.item.Ms.nightmare;
import io.wispforest.accessories.api.AccessoriesCapability;
import io.wispforest.accessories.api.AccessoriesContainer;
import io.wispforest.accessories.api.slot.SlotReference;
import io.wispforest.accessories.impl.ExpandedSimpleContainer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class nightmare_base_insight_drug extends com.moonfabric.item.Ms.SNightmare{
    public nightmare_base_insight_drug(Settings settings) {
        super(settings);
    }

    @Override
    public void tick(ItemStack stack, SlotReference reference) {
        reference.entity().getAttributes().addTemporaryModifiers(gets(reference));
    }


    @Override
    public void onUnequip(ItemStack stack, SlotReference reference) {
        reference.entity().getAttributes().removeModifiers(gets(reference));
    }

    public Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> gets(SlotReference slotContext) {
        Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> linkedHashMultimap = HashMultimap.create();
        LivingEntity living = slotContext.entity();
        List<Integer> integersHealth = new ArrayList<>();
        AccessoriesCapability capability = AccessoriesCapability.get(living);
        if (capability != null) {
            if (HasCurio.has(init.nightmare_base_insight_drug, living)) {
                for (Map.Entry<String, AccessoriesContainer> stringAccessoriesContainerEntry : capability.getContainers().entrySet()) {
                    AccessoriesContainer container = stringAccessoriesContainerEntry.getValue();
                    ExpandedSimpleContainer accessories = container.getAccessories();
                    for (int i = 0; i < accessories.size(); ++i) {
                        ItemStack stack = accessories.getStack(i);
                        if (!stack.isEmpty()&&stack.getItem() instanceof nightmare) {
                            integersHealth.add(1);
                        }
                    }
                }
            }
        }

        float health = 100;
        for (int ignored : integersHealth) {
            health-=8;
        }
        health/=100;
        linkedHashMultimap.put(EntityAttributes.MAX_HEALTH, new EntityAttributeModifier(Identifier.of("base_attack_damage" + this.getTranslationKey()), health, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE));
        linkedHashMultimap.put(EntityAttributes.ARMOR, new EntityAttributeModifier(Identifier.of("base_attack_damage" + this.getTranslationKey()), health, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE));
        linkedHashMultimap.put(EntityAttributes.ATTACK_DAMAGE, new EntityAttributeModifier(Identifier.of("base_attack_damage" + this.getTranslationKey()), health, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE));
        return linkedHashMultimap;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        tooltip.add(Text.translatable("item.nightmare_base_insight_drug.tool.string").formatted(Formatting.DARK_RED));
        tooltip.add(Text.translatable("item.nightmare_base_insight_drug.tool.string.1").formatted(Formatting.DARK_RED));
    }

}



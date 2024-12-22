package com.moonfabric.item.nightmare;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.moonfabric.HasCurio;
import com.moonfabric.init.init;
import com.moonfabric.item.Ms.nightmare;
import io.wispforest.accessories.api.slot.SlotReference;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;

import java.util.Collection;
import java.util.List;

public class nightmarestone extends nightmare {


    public nightmarestone(Settings settings) {
        super(settings);
    }

    public static void hurt(LivingEntity entity, DamageSource source){
        if (HasCurio.has(init.nightmarestone,entity)){
            if (source.getSource() != null) {
                switch (MathHelper.nextInt(Random.create(), 1, 5)) {
                    case 1:
                        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 100, 0));
                    case 2:
                        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 100, 0));
                    case 3:
                        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 100, 0));
                    case 4:
                        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 100, 0));
                    case 5:
                        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.UNLUCK, 100, 0));
                }
            }
        }
    }

    @Override
    public void tick(ItemStack stack, SlotReference reference) {
        if (reference.entity() instanceof PlayerEntity player){
            aDouble = EffectInstance(player);
            if (!player.getWorld().isClient && player.age % 20 == 0) {
                player.getAttributes().addTemporaryModifiers(un_un_pla(player));

                Collection<StatusEffectInstance> collection = player.getStatusEffects();
                for (StatusEffectInstance mobEffectInstance : collection) {
                    StatusEffect mobEffect = mobEffectInstance.getEffectType().value();
                    if (!mobEffect.isBeneficial()) {
                        int lvl = mobEffectInstance.getAmplifier();
                        int time = mobEffectInstance.getDuration();

                        player.addStatusEffect(new StatusEffectInstance(Registries.STATUS_EFFECT.getEntry(mobEffect), time + 10, lvl));

                    }
                }
            }
        }
    }

    public static float EffectInstance(PlayerEntity player) {
        float size = 0;
        List<Integer> Int = Lists.newArrayList();
        Collection<StatusEffectInstance> collection = player.getStatusEffects();
        for (StatusEffectInstance mobEffectInstance : collection){
            StatusEffect mobEffect = mobEffectInstance.getEffectType().value();
            if (!mobEffect.isBeneficial()){
                Int.add(1);
            }
        }
        for (Integer i : Int){
            size += 1;
        }
        return size;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable(""));

        tooltip.add(Text.translatable("item.nightmarestone.tool.string").formatted(Formatting.RED));
        tooltip.add(Text.translatable("item.nightmarestone.tool.string.1").formatted(Formatting.RED));
        tooltip.add(Text.translatable("item.nightmarestone.tool.string.2").formatted(Formatting.RED));
        tooltip.add(Text.translatable("item.nightmarestone.tool.string.3").formatted(Formatting.RED));
        tooltip.add(Text.translatable(""));
        tooltip.add(Text.translatable("item.nightmarestone.tool.string.7").formatted(Formatting.RED));
        tooltip.add(Text.translatable(""));
        tooltip.add(Text.translatable("item.nightmarestone.tool.string.8").formatted(Formatting.RED));

        tooltip.add(Text.translatable(""));
        tooltip.add(Text.translatable("item.nightmarestone.tool.string.9").formatted(Formatting.RED));
        tooltip.add(Text.translatable("item.nightmarestone.tool.string.10").formatted(Formatting.RED));

    }


    public Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> un_un_pla(PlayerEntity player) {
        Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> modifierMultimap = HashMultimap.create();


        modifierMultimap.put(EntityAttributes.ATTACK_DAMAGE, new EntityAttributeModifier(Identifier.of("base_attack_damage"+this.getTranslationKey()), EffectInstance(player)/10, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE));
        modifierMultimap.put(EntityAttributes.ARMOR, new EntityAttributeModifier(Identifier.of("base_attack_damage"+this.getTranslationKey()),  EffectInstance(player)/10, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE));
        modifierMultimap.put(EntityAttributes.MOVEMENT_EFFICIENCY, new EntityAttributeModifier(Identifier.of("base_attack_damage"+this.getTranslationKey()),  EffectInstance(player)/10, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE));
        modifierMultimap.put(EntityAttributes.MAX_HEALTH, new EntityAttributeModifier(Identifier.of("base_attack_damage"+this.getTranslationKey()),  EffectInstance(player)/10, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE));
        modifierMultimap.put(EntityAttributes.ATTACK_SPEED, new EntityAttributeModifier(Identifier.of("base_attack_damage"+this.getTranslationKey()),  EffectInstance(player)/10, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE));

        return modifierMultimap;
    }
    public static double aDouble;
}

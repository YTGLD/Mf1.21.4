package com.moonfabric.item.nightmare.super_nightmare;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.moonfabric.HasCurio;
import com.moonfabric.init.Data;
import com.moonfabric.init.init;
import com.moonfabric.item.Ms.nightmare;
import io.wispforest.accessories.api.slot.SlotReference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class nightmare_base  extends com.moonfabric.item.Ms.SNightmare{

    public int tick = 0;

    public nightmare_base(Settings settings) {
        super(settings);
    }


    @Override
    public void tick(ItemStack stack, SlotReference reference) {
        reference.entity().getAttributes().addTemporaryModifiers(gets(reference,stack));
        tick = 100;
        if (stack.get(Data.CUSTOM_DATA)==null) {
            reference.entity().getWorld().playSound(null, reference.entity().getX(), reference.entity().getY(), reference.entity().getZ(), SoundEvents.ENTITY_ELDER_GUARDIAN_CURSE, SoundCategory.NEUTRAL, 1, 1);
            stack.set(Data.CUSTOM_DATA,new NbtCompound());
        }else {
            if (!stack.get(Data.CUSTOM_DATA).getBoolean("canDo")) {
                Random random = new Random();
                ArrayList<Item> items= new ArrayList<>(List.of(
                        init.nightmare_base_stone,
                        init.nightmare_base_reversal,
                        init.nightmare_base_black_eye,

                        init.nightmare_base_redemption,
                        init.nightmare_base_fool,
                        init.nightmare_base_insight,

                        init.nightmare_base_start
                ));
                for (int i = 0; i < 3; i++) {

                    if (!items.isEmpty()) {
                        int index = random.nextInt(items.size());
                        Item selectedItem = items.remove(index);
                        addLoot(reference.entity(), selectedItem, stack);
                    }
                }
                stack.get(Data.CUSTOM_DATA).putBoolean("canDo",true);
            }
        }  
    }


    public Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> gets(SlotReference slotContext, ItemStack stack) {
        Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> linkedHashMultimap = HashMultimap.create();
        float s= -0.3f;
        if (HasCurio.has(init.nightmare_base_reversal_mysterious, slotContext.entity())){
            s = 0;
        }
        if (HasCurio.has(init.nightmare_base_redemption_down_and_out, slotContext.entity())){
            s += 0.35f;
        }
        if (HasCurio.has(init.nightmare_base_redemption, slotContext.entity())){
            s -= 0.15f;
        }
        linkedHashMultimap.put(EntityAttributes.ATTACK_DAMAGE, new EntityAttributeModifier(Identifier.of("base_attack_damage" + this.getTranslationKey()), s, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE));
        linkedHashMultimap.put(EntityAttributes.MAX_HEALTH, new EntityAttributeModifier(Identifier.of("base_attack_damage" + this.getTranslationKey()), s, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE));
        linkedHashMultimap.put(EntityAttributes.ARMOR, new EntityAttributeModifier(Identifier.of("base_attack_damage" + this.getTranslationKey()), s, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE));
        return linkedHashMultimap;
    }

    @Override
    public boolean canUnequip(ItemStack stack, SlotReference reference) {
        return false;
    }


    private void addLoot(Entity entity ,
                         Item itemList,
                         ItemStack stack){
        if (entity instanceof PlayerEntity player){
            if (stack.get(Data.CUSTOM_DATA)!=null) {
                player.giveItemStack(itemList.getDefaultStack());
            }
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        tooltip.add(Text.translatable("item.nightmare_base.tool.string").formatted(Formatting.DARK_RED));
        tooltip.add(Text.translatable("item.nightmare_base.tool.string.1").formatted(Formatting.DARK_RED));
        tooltip.add(Text.literal(""));
        tooltip.add(Text.translatable("item.nightmareeye.tool.string.2").formatted(Formatting.DARK_RED));
    }

}


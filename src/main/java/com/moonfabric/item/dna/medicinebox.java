package com.moonfabric.item.dna;

import com.moonfabric.HasCurio;
import com.moonfabric.Ievent.AllEvent;
import com.moonfabric.init.Data;
import com.moonfabric.init.init;
import com.moonfabric.item.Ms.TheNecoraIC;
import com.moonfabric.item.common.pain.pain_carrot;
import io.wispforest.accessories.api.AccessoriesCapability;
import io.wispforest.accessories.api.AccessoriesContainer;
import io.wispforest.accessories.api.attributes.AccessoryAttributeBuilder;
import io.wispforest.accessories.api.attributes.SlotAttribute;
import io.wispforest.accessories.api.slot.SlotReference;

import io.wispforest.accessories.impl.ExpandedSimpleContainer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.Map;

import static com.moonfabric.Ievent.AllEvent.*;

public class medicinebox extends TheNecoraIC {
    public medicinebox(Settings settings) {
        super(settings);
    }

    @Override
    public void getDynamicModifiers(ItemStack stack, SlotReference reference, AccessoryAttributeBuilder builder) {
        super.getDynamicModifiers(stack, reference, builder);
        SlotAttribute.addSlotAttribute(builder,"belt", Identifier.of(String.valueOf(this.getTranslationKey())),2, EntityAttributeModifier.Operation.ADD_VALUE,true);
    }
    public static  void die(LivingEntity me,DamageSource source) {
        if (source.getSource() instanceof PlayerEntity player) {
            AccessoriesCapability capability = AccessoriesCapability.get(player);
            if (capability != null) {
                for (Map.Entry<String, AccessoriesContainer> stringAccessoriesContainerEntry : capability.getContainers().entrySet()) {
                    AccessoriesContainer container = stringAccessoriesContainerEntry.getValue();
                    ExpandedSimpleContainer accessories = container.getAccessories();
                    for (int i = 0; i < accessories.size(); ++i) {
                        ItemStack stack = accessories.getStack(i);
                        if (!stack.isEmpty()) {
                            if (stack.isOf(init.medicinebox)) {
                                NbtCompound tag = stack.get(Data.CUSTOM_DATA);
                                if (tag != null) {
                                    if (!tag.getBoolean(AllEvent.spawn)) {
                                        if (HasCurio.has(init.medicinebox, player)) {
                                            player.giveItemStack(new ItemStack(init.reanimation));
                                            tag.putBoolean(AllEvent.spawn, true);
                                            tag.putBoolean(AllEvent.blood_spawn, true);
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
    public static void hurt(LivingEntity me , DamageSource source) {
        if (me instanceof PlayerEntity player){
            AccessoriesCapability capability = AccessoriesCapability.get(player);
            if (capability != null) {
                for (Map.Entry<String, AccessoriesContainer> stringAccessoriesContainerEntry : capability.getContainers().entrySet()) {
                    AccessoriesContainer container = stringAccessoriesContainerEntry.getValue();
                    ExpandedSimpleContainer accessories = container.getAccessories();
                    for (int i = 0; i < accessories.size(); ++i) {
                        ItemStack stack = accessories.getStack(i);
                        if (!stack.isEmpty()) {
                            if (stack.isOf(init.medicinebox)) {
                                NbtCompound tag = stack.get(Data.CUSTOM_DATA);
                                if (tag != null) {
                                    if (tag.getInt(hurt_size) < 351) {
                                        tag.putInt(hurt_size, tag.getInt(hurt_size) + 1);
                                    }
                                    if (tag.getInt(hurt_size) == 350) {
                                        player.giveItemStack(new ItemStack(init.calcification));
                                        tag.putBoolean(blood_hurt, true);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    public  static void apple(LivingEntity me ,CallbackInfoReturnable<ItemStack> cir) {
        if (me instanceof PlayerEntity player){
            AccessoriesCapability capability = AccessoriesCapability.get(player);
            if (capability != null) {
                for (Map.Entry<String, AccessoriesContainer> stringAccessoriesContainerEntry : capability.getContainers().entrySet()) {
                    AccessoriesContainer container = stringAccessoriesContainerEntry.getValue();
                    ExpandedSimpleContainer accessories = container.getAccessories();
                    for (int i = 0; i < accessories.size(); ++i) {
                        ItemStack stack = accessories.getStack(i);
                        if (!stack.isEmpty()) {
                            if (stack.isOf(init.medicinebox)) {
                                ItemStack a = cir.getReturnValue();
                                NbtCompound tag = stack.get(Data.CUSTOM_DATA);
                                if (tag != null) {
                                    ;
                                    if (a.isOf(Items.GOLDEN_APPLE)) {

                                        if (tag.getInt(apple) < 9) {
                                            tag.putInt(apple, tag.getInt(apple) + 1);
                                        }
                                        if (tag.getInt(apple) == 8) {
                                            player.giveItemStack(new ItemStack(init.masticatory));
                                            tag.putBoolean(blood_eat, true);
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
    public static   void jumo(LivingEntity me ) {
        if (me instanceof PlayerEntity player){
            AccessoriesCapability capability = AccessoriesCapability.get(player);
            if (capability != null) {
                for (Map.Entry<String, AccessoriesContainer> stringAccessoriesContainerEntry : capability.getContainers().entrySet()) {
                    AccessoriesContainer container = stringAccessoriesContainerEntry.getValue();
                    ExpandedSimpleContainer accessories = container.getAccessories();
                    for (int i = 0; i < accessories.size(); ++i) {
                        ItemStack stack = accessories.getStack(i);
                        if (!stack.isEmpty()) {
                            if (stack.isOf(init.medicinebox)) {
                                NbtCompound tag = stack.get(Data.CUSTOM_DATA);
                                if (tag != null) {
                                    ;
                                    if (tag != null && tag.getInt(jump_size) < 501) {
                                        tag.putInt(jump_size, tag.getInt(jump_size) + 1);

                                    }
                                    if (tag != null && tag.getInt(jump_size) == 500) {
                                        player.giveItemStack(new ItemStack(init.quadriceps));
                                        tag.putBoolean(blood_jump, true);

                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    public   static void enchant(LivingEntity me ,CallbackInfoReturnable<ItemStack> cir) {

        if (me instanceof PlayerEntity player){
            AccessoriesCapability capability = AccessoriesCapability.get(player);
            if (capability != null) {
                for (Map.Entry<String, AccessoriesContainer> stringAccessoriesContainerEntry : capability.getContainers().entrySet()) {
                    AccessoriesContainer container = stringAccessoriesContainerEntry.getValue();
                    ExpandedSimpleContainer accessories = container.getAccessories();
                    for (int i = 0; i < accessories.size(); ++i) {
                        ItemStack stack = accessories.getStack(i);
                        if (!stack.isEmpty()) {
                            if (stack.isOf(init.medicinebox)) {
                                ItemStack a = cir.getReturnValue();
                                if (a.isOf(Items.ENCHANTED_GOLDEN_APPLE)) {
                                    NbtCompound tag = stack.get(Data.CUSTOM_DATA);
                                    if (tag != null) {
                                        if (!tag.getBoolean(enchant)) {
                                            player.giveItemStack(new ItemStack(init.polyphagia));
                                            tag.putBoolean(enchant, true);
                                            tag.putBoolean(blood_enchant, true);

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
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        tooltip.add(Text.translatable("item.medicinebox.tool.string").formatted(Formatting.GOLD).formatted(Formatting.ITALIC));
        tooltip.add(Text.translatable("item.medicinebox.tool.string.1").formatted(Formatting.GOLD).formatted(Formatting.ITALIC));
        tooltip.add(Text.translatable(""));
        tooltip.add(Text.translatable("item.medicinebox.tool.string.2").formatted(Formatting.GOLD).formatted(Formatting.ITALIC));
        tooltip.add(Text.translatable("item.medicinebox.tool.string.3").formatted(Formatting.GOLD).formatted(Formatting.ITALIC));
        tooltip.add(Text.translatable(""));
        tooltip.add(Text.translatable("item.medicinebox.tool.string.4").formatted(Formatting.GOLD).formatted(Formatting.BOLD));
        tooltip.add(Text.translatable(""));
    }
}

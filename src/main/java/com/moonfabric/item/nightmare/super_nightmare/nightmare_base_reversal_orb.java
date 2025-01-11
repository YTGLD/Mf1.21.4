package com.moonfabric.item.nightmare.super_nightmare;

import com.moonfabric.HasCurio;
import com.moonfabric.MoonFabricMod;
import com.moonfabric.init.AttReg;
import com.moonfabric.init.init;
import com.moonfabric.item.Ms.nightmare;
import io.wispforest.accessories.api.attributes.AccessoryAttributeBuilder;
import io.wispforest.accessories.api.slot.SlotReference;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

import java.util.List;

public class nightmare_base_reversal_orb extends com.moonfabric.item.Ms.SNightmare{
    public nightmare_base_reversal_orb(Settings settings) {
        super(settings);
    }

    public static void LivingHealEvent(LivingEntity living, float a){
        if (living instanceof PlayerEntity player){
            if (HasCurio.has(init.nightmare_base_reversal_orb, player)){
                player.serverDamage(player.getDamageSources().dryOut(),a);
            }
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        tooltip.add(Text.translatable("item.nightmare_base_reversal_orb.tool.string").formatted(Formatting.DARK_RED));
        tooltip.add(Text.translatable("item.nightmare_base_reversal_orb.tool.string.2").formatted(Formatting.DARK_RED));
    }

    @Override
    public void getDynamicModifiers(ItemStack stack, SlotReference reference, AccessoryAttributeBuilder builder) {
        builder.addStackable(AttReg.heal, new EntityAttributeModifier(Identifier.of(MoonFabricMod.MODID,this.getTranslationKey()), -4, EntityAttributeModifier.Operation.ADD_VALUE));
    }

    @Override
    public void tick(ItemStack stack, SlotReference reference) {
        if (reference.entity() instanceof PlayerEntity player){
            if (!player.getItemCooldownManager().isCoolingDown(this.getDefaultStack())){
                player.setHealth(player.getMaxHealth());
                player.getItemCooldownManager().set(this.getDefaultStack(),200);
            }
        }
    }

}

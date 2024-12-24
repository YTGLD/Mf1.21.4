package com.moonfabric.item.common.Blood;

import com.moonfabric.Entity.owner_blood;
import com.moonfabric.init.Data;
import com.moonfabric.init.InItEntity;
import com.moonfabric.item.Ms.TheNecoraIC;
import io.wispforest.accessories.api.attributes.AccessoryAttributeBuilder;
import io.wispforest.accessories.api.slot.SlotReference;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

import java.util.List;

public class blood_candle extends TheNecoraIC {

    public static final String bloods= " hasBlood";

    public blood_candle(Settings settings) {
        super(settings);
    }

    @Override
    public void onUnequip(ItemStack stack, SlotReference reference) {
        if (stack.get(Data.CUSTOM_DATA)!=null){
            stack.get(Data.CUSTOM_DATA).putBoolean(bloods,false);
        }
    }

    @Override
    public void getDynamicModifiers(ItemStack stack, SlotReference reference, AccessoryAttributeBuilder builder) {
        builder.getSlotModifiers().put("legs/belt",new EntityAttributeModifier(Identifier.of(String.valueOf(this.getTranslationKey())),2, EntityAttributeModifier.Operation.ADD_VALUE));
    }

    @Override
    public void onEquip(ItemStack stack, SlotReference reference) {
        stack.set(Data.CUSTOM_DATA,new NbtCompound());
        if (!stack.get(Data.CUSTOM_DATA).getBoolean(bloods)){
            if (reference.entity() instanceof PlayerEntity player) {
                owner_blood owner_blood = new owner_blood(InItEntity.owner_blood, reference.entity().getEntityWorld());
                owner_blood.setOwner(player);
                owner_blood.setOwnerUuid(player.getUuid());
                owner_blood.setPos(player.getX(),player.getY(),player.getZ());

                player.getWorld().spawnEntity(owner_blood);

                stack.get(Data.CUSTOM_DATA).putBoolean(bloods, true);
            }
        }
    }


    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, net.minecraft.item.tooltip.TooltipType type) {

        tooltip.add(Text.translatable(""));
        tooltip.add(Text.translatable("moonfabric.tooltip.blood_candle").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("moonfabric.tooltip.blood_candle.1").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("moonfabric.tooltip.blood_candle.2").formatted(Formatting.GRAY));

        tooltip.add(Text.translatable(""));

    }
}


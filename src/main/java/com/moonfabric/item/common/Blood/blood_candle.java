package com.moonfabric.item.common.Blood;

import com.moonfabric.Entity.owner_blood;
import com.moonfabric.data.BundleContentsComponent;
import com.moonfabric.init.Data;
import com.moonfabric.init.InItEntity;
import com.moonfabric.init.init;
import com.moonfabric.item.Ms.TheNecoraIC;
import com.moonfabric.item.dna.DNAItem;
import io.wispforest.accessories.api.attributes.AccessoryAttributeBuilder;
import io.wispforest.accessories.api.attributes.SlotAttribute;
import io.wispforest.accessories.api.slot.SlotReference;
import io.wispforest.accessories.api.slot.SlotType;
import io.wispforest.accessories.menu.ArmorSlotTypes;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import net.minecraft.util.ClickType;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

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
    public boolean onClicked(ItemStack stack, ItemStack otherStack, Slot slot, ClickType clickType, PlayerEntity player, StackReference cursorStackReference) {
        if (clickType == ClickType.RIGHT && slot.canTakePartial(player)) {
            if (otherStack.isEmpty()){
                stack.get(Data.CUSTOM_DATA).putBoolean(bloods, false);
                player.getItemCooldownManager().set(init.blood_candle.getDefaultStack(),10);
                return true;
            }
        }
        return false;
    }
    @Override
    public void getDynamicModifiers(ItemStack stack, SlotReference reference, @NotNull AccessoryAttributeBuilder builder) {
        SlotAttribute.addSlotAttribute(builder,"belt", Identifier.of(String.valueOf(this.getTranslationKey())),2, EntityAttributeModifier.Operation.ADD_VALUE,true);
    }

    @Override
    public void tick(ItemStack stack, SlotReference reference) {
        if (stack.get(Data.CUSTOM_DATA) == null) {
            stack.set(Data.CUSTOM_DATA, new NbtCompound());
        }
        if (!stack.get(Data.CUSTOM_DATA).getBoolean(bloods)) {
            if (reference.entity() instanceof PlayerEntity player) {
                if (!player.getItemCooldownManager().isCoolingDown(init.blood_candle.getDefaultStack())) {
                    owner_blood owner_blood = new owner_blood(InItEntity.owner_blood, reference.entity().getEntityWorld());
                    owner_blood.setOwner(player);
                    owner_blood.setOwnerUuid(player.getUuid());
                    owner_blood.setPos(player.getX(), player.getY(), player.getZ());

                    player.getWorld().spawnEntity(owner_blood);

                    stack.get(Data.CUSTOM_DATA).putBoolean(bloods, true);
                }
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


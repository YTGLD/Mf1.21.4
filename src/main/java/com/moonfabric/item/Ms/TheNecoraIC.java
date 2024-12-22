package com.moonfabric.item.Ms;

import com.moonfabric.HasCurio;
import com.moonfabric.Ievent.AllEvent;
import com.moonfabric.init.Data;
import io.wispforest.accessories.api.AccessoryItem;
import io.wispforest.accessories.api.DropRule;
import io.wispforest.accessories.api.slot.SlotReference;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Rarity;
import net.minecraft.world.Difficulty;

import java.util.List;

public class TheNecoraIC  extends AccessoryItem {
    public TheNecoraIC(Item.Settings settings) {
        super(settings);
    }
    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (stack.get(Data.CUSTOM_DATA)!= null) {
            if (stack.get(Data.CUSTOM_DATA).getBoolean(Difficulty.PEACEFUL.getName())) {

                tooltip.add(1, Text.translatable("moonfabric.difficulty.name.peaceful").fillStyle(Style.EMPTY.withColor(TextColor.fromRgb(0XFFCD853F)))
                        .append(Text.translatable("moonfabric.difficulty.name.all").fillStyle(Style.EMPTY.withColor(TextColor.fromRgb(0XFFDEB887)))));

            }
            if (stack.get(Data.CUSTOM_DATA).getBoolean(Difficulty.EASY.getName())) {

                tooltip.add(1, Text.translatable("moonfabric.difficulty.name.easy").fillStyle(Style.EMPTY.withColor(TextColor.fromRgb(0XFFCD853F)))
                        .append(Text.translatable("moonfabric.difficulty.name.all").fillStyle(Style.EMPTY.withColor(TextColor.fromRgb(0XFFDEB887)))));

            }
            if (stack.get(Data.CUSTOM_DATA).getBoolean(Difficulty.NORMAL.getName())) {
                tooltip.add(1, Text.translatable("moonfabric.difficulty.name.normal").fillStyle(Style.EMPTY.withColor(TextColor.fromRgb(0XFFCD853F)))
                        .append(Text.translatable("moonfabric.difficulty.name.all").fillStyle(Style.EMPTY.withColor(TextColor.fromRgb(0XFFDEB887)))));

            }
            if (stack.get(Data.CUSTOM_DATA).getBoolean(Difficulty.HARD.getName())) {
                tooltip.add(1, Text.translatable("moonfabric.difficulty.name.hard").fillStyle(Style.EMPTY.withColor(TextColor.fromRgb(0XFFCD853F)))
                        .append(Text.translatable("moonfabric.difficulty.name.all").fillStyle(Style.EMPTY.withColor(TextColor.fromRgb(0XFFDEB887)))));
            }
            if (stack.get(Data.CUSTOM_DATA).getBoolean(AllEvent.lootTable)) {
                tooltip.add(1, Text.translatable("moonfabric.difficulty.name.god").fillStyle(Style.EMPTY.withColor(TextColor.fromRgb(0XFFCD853F)))
                        .append(Text.translatable("moonfabric.difficulty.name.all").fillStyle(Style.EMPTY.withColor(TextColor.fromRgb(0XFFDEB887)))));
            }
        }
    }

    @Override
    public boolean canEquip(ItemStack stack, SlotReference reference) {
        if (reference.entity() instanceof PlayerEntity player){
            return !HasCurio.has(this, player);
        }
        return true;
    }

    @Override
    public DropRule getDropRule(ItemStack stack, SlotReference reference, DamageSource source) {
        return DropRule.KEEP;
    }

    @Override
    public void onEquip(ItemStack stack, SlotReference reference) {
        if (stack.get(Data.CUSTOM_DATA) == null) {
            stack.set(Data.CUSTOM_DATA,new NbtCompound());
        }
    }
}



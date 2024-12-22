package com.moonfabric;

import com.moonfabric.init.init;
import com.moonfabric.item.INecora;
import com.moonfabric.item.Ms.ectoplasm;
import com.moonfabric.item.Ms.extend.ItemTir;
import com.moonfabric.item.Ms.nightmare;
import com.moonfabric.item.dna.DNAItem;
import com.moonfabric.item.necora;
import io.wispforest.accessories.api.attributes.AccessoryAttributeBuilder;
import io.wispforest.accessories.api.slot.SlotReference;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

public class ABook extends ItemTir {

    public ABook(Settings settings) {
        super(settings);
    }

    public static void getTooltip(ItemStack stack, Item.TooltipContext context, @Nullable PlayerEntity player, TooltipType type, CallbackInfoReturnable<List<Text>> cir){
        if (player!=null&&HasCurio.has(init.abook,player)){
            if (stack.getItem() instanceof DNAItem){
                List<Text> texts = cir.getReturnValue();
                texts.add(Text.translatable("book.moonfabric.dna").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0XFFDB7093))));
                texts.add(Text.translatable("book.moonfabric.dna.1").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0XFFDB7093))));
                cir.setReturnValue(texts);
            }
            if (stack.getItem() instanceof nightmare){
                List<Text> texts = cir.getReturnValue();
                texts.add(Text.translatable("book.moonfabric.nightmare").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0XFFDB7093))));
                texts.add(Text.translatable("book.moonfabric.nightmare.1").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0XFFDB7093))));
                cir.setReturnValue(texts);
            }
            if (stack.getItem() instanceof ectoplasm){
                List<Text> texts = cir.getReturnValue();
                texts.add(Text.translatable("book.moonfabric.ectoplasm").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0XFFDB7093))));
                cir.setReturnValue(texts);
            }
            if (stack.getItem() instanceof INecora){
                List<Text> texts = cir.getReturnValue();
                texts.add(Text.translatable("book.moonfabric.necora.all").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0XFFDB7093))));
                texts.add(Text.translatable("book.moonfabric.necora.all.1").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0XFFDB7093))));
                texts.add(Text.translatable("book.moonfabric.necora.all.2").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0XFFDB7093))));
                cir.setReturnValue(texts);
            }
            if (stack.getItem() instanceof necora){
                List<Text> texts = cir.getReturnValue();
                texts.add(Text.translatable("book.moonfabric.necora").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0XFFDB7093))));
                cir.setReturnValue(texts);
            }
        }
    }
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, net.minecraft.item.tooltip.TooltipType type) {
        tooltip.add(Text.translatable("moonfabric.tooltip.abook").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0XFFDB7093))));
        tooltip.add(Text.translatable(""));
    }

    @Override
    public void getDynamicModifiers(ItemStack stack, SlotReference reference, AccessoryAttributeBuilder builder) {
        builder.getSlotModifiers().put("legs/belt",new EntityAttributeModifier(Identifier.of(String.valueOf(this.getTranslationKey())),1, EntityAttributeModifier.Operation.ADD_VALUE));
    }
}

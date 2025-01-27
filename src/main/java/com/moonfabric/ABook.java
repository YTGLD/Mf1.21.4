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
    public static void TerNightmare(ItemStack stack, Item item, List<Text> texts, String string, String has){
        if (stack.isOf(item)) {
            texts.add(Text.translatable(string)
                    .append(Text.translatable("moonstone.jei.item.moonfabric.nightmare_base.all"))
                    .append(Text.translatable("item.moonfabric."+has)).setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0XFFDB7093))));
        }
    }
    public static void TerCommon(ItemStack stack, Item item, List<Text> texts, String string){
        if (stack.isOf(item)) {
            texts.add(Text.translatable(string)
                    .setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0XFFDB7093))));
        }
    }
    public static void getTooltip(ItemStack stack, Item.TooltipContext context, @Nullable PlayerEntity player, TooltipType type, CallbackInfoReturnable<List<Text>> cir){
        {
            List<Text> texts = cir.getReturnValue();

            TerNightmare(stack,init.nightmare_base_black_eye_eye,texts, "moonstone.jei.item.moonfabric.nightmare_base_black_eye_eye","nightmare_base_black_eye");
            TerNightmare(stack,init.nightmare_base_black_eye_heart,texts, "moonstone.jei.item.moonfabric.nightmare_base_black_eye_heart","nightmare_base_black_eye");
            TerNightmare(stack,init.nightmare_base_black_eye_red,texts, "moonstone.jei.item.moonfabric.nightmare_base_black_eye_red","nightmare_base_black_eye");

            TerNightmare(stack,init.nightmare_base_fool_betray,texts, "moonstone.jei.item.moonfabric.nightmare_base_fool_betray","nightmare_base_fool");
            TerNightmare(stack,init.nightmare_base_fool_bone,texts, "moonstone.jei.item.moonfabric.nightmare_base_fool_bone","nightmare_base_fool");
            TerNightmare(stack,init.nightmare_base_fool_soul,texts, "moonstone.jei.item.moonfabric.nightmare_base_fool_soul","nightmare_base_fool");

            TerNightmare(stack,init.nightmare_base_insight_collapse,texts, "moonstone.jei.item.moonfabric.nightmare_base_insight_collapse","nightmare_base_insight");
            TerNightmare(stack,init.nightmare_base_insight_drug,texts, "moonstone.jei.item.moonfabric.nightmare_base_insight_drug","nightmare_base_insight");
            TerNightmare(stack,init.nightmare_base_insight_insane,texts, "moonstone.jei.item.moonfabric.nightmare_base_insight_insane","nightmare_base_insight");

            TerNightmare(stack,init.nightmare_base_redemption_deception,texts, "moonstone.jei.item.moonfabric.nightmare_base_redemption_deception","nightmare_base_redemption");
            TerNightmare(stack,init.nightmare_base_redemption_degenerate,texts, "moonstone.jei.item.moonfabric.nightmare_base_redemption_degenerate","nightmare_base_redemption");
            TerNightmare(stack,init.nightmare_base_redemption_down_and_out,texts, "moonstone.jei.item.moonfabric.nightmare_base_redemption_down_and_out","nightmare_base_redemption");

            TerNightmare(stack,init.nightmare_base_reversal_card,texts, "moonstone.jei.item.moonfabric.nightmare_base_reversal_card","nightmare_base_reversal");
            TerNightmare(stack,init.nightmare_base_reversal_mysterious,texts, "moonstone.jei.item.moonfabric.nightmare_base_reversal_mysterious","nightmare_base_reversal");
            TerNightmare(stack,init.nightmare_base_reversal_orb,texts, "moonstone.jei.item.moonfabric.nightmare_base_reversal_orb","nightmare_base_reversal");

            TerNightmare(stack,init.nightmare_base_start_egg,texts, "moonstone.jei.item.moonfabric.nightmare_base_start_egg","nightmare_base_start");
            TerNightmare(stack,init.nightmare_base_start_pod,texts, "moonstone.jei.item.moonfabric.nightmare_base_start_pod","nightmare_base_start");
            TerNightmare(stack,init.nightmare_base_start_power,texts, "moonstone.jei.item.moonfabric.nightmare_base_start_power","nightmare_base_start");

            TerNightmare(stack,init.nightmare_base_stone_brain,texts, "moonstone.jei.item.moonfabric.nightmare_base_stone_brain","nightmare_base_stone");
            TerNightmare(stack,init.nightmare_base_stone_meet,texts, "moonstone.jei.item.moonfabric.nightmare_base_stone_meet","nightmare_base_stone");
            TerNightmare(stack,init.nightmare_base_stone_virus,texts, "moonstone.jei.item.moonfabric.nightmare_base_stone_virus","nightmare_base_stone");

            TerCommon(stack,init.calcification,texts,   "item.calcification.tool.string.2");
            TerCommon(stack,init.masticatory,texts, "item.masticatory.tool.string.2");
            TerCommon(stack,init.polyphagia,texts,   "item.polyphagia.tool.string");
            TerCommon(stack,init.quadriceps,texts,  "item.quadriceps.tool.string.3");
            TerCommon(stack,init.reanimation,texts,   "item.reanimation.tool.string.4");












            if (stack.isOf(init.owner_blood_boom_eye)) {
                texts.add(Text.translatable("item.moonfabric.owner_blood_boom_eye.tool").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0XFFDB7093))));
                texts.add(Text.translatable("item.moonfabric.owner_blood_boom_eye.tool.1").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0XFFDB7093))));
                texts.add(Text.translatable("item.moonfabric.owner_blood_boom_eye.tool.2").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0XFFDB7093))));
                texts.add(Text.translatable("item.moonfabric.owner_blood_boom_eye.tool.3").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0XFFDB7093))));
            }
            if (stack.isOf(init.owner_blood_eye)) {
                texts.add(Text.translatable("item.moonfabric.owner_blood_eye.tool").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0XFFDB7093))));
            }
            if (stack.isOf(init.owner_blood_attack_eye)) {
                texts.add(Text.translatable("item.moonfabric.owner_blood_attack_eye.tool").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0XFFDB7093))));
                texts.add(Text.translatable("item.moonfabric.owner_blood_attack_eye.tool.1").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0XFFDB7093))));
               }
            if (stack.isOf(init.owner_blood_speed_eye)) {
                texts.add(Text.translatable("item.moonfabric.owner_blood_speed_eye.tool").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0XFFDB7093))));
                texts.add(Text.translatable("item.moonfabric.owner_blood_speed_eye.tool.1").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0XFFDB7093))));

            }
            if (stack.isOf(init.owner_blood_earth)) {
                texts.add(Text.translatable("item.moonfabric.owner_blood_earth.tool").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0XFFDB7093))));
                texts.add(Text.translatable("item.moonfabric.owner_blood_earth.tool.1").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0XFFDB7093))));
                texts.add(Text.translatable("item.moonfabric.owner_blood_earth.tool.2").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0XFFDB7093))));
                texts.add(Text.translatable("item.moonfabric.owner_blood_earth.tool.3").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0XFFDB7093))));
            }
            if (stack.isOf(init.owner_blood_effect_eye)) {
                texts.add(Text.translatable("item.moonfabric.owner_blood_effect_eye.tool").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0XFFDB7093))));
                texts.add(Text.translatable("item.moonfabric.owner_blood_effect_eye.tool.1").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0XFFDB7093))));
            }
            if (stack.isOf(init.owner_blood_vex)) {
                texts.add(Text.translatable("item.moonfabric.owner_blood_vex.tool").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0XFFDB7093))));
                texts.add(Text.translatable("item.moonfabric.owner_blood_vex.tool.1").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0XFFDB7093))));
                texts.add(Text.translatable("item.moonfabric.owner_blood_vex.tool.2").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0XFFDB7093))));
            }
        }
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

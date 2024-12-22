package com.moonfabric.item.common.CurseOrDoom;

import com.moonfabric.HasCurio;
import com.moonfabric.Ievent.old.IEventHurt;
import com.moonfabric.item.Ms.extend.doom;
import io.wispforest.accessories.api.attributes.AccessoryAttributeBuilder;
import io.wispforest.accessories.api.slot.SlotReference;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

import java.util.List;

public class doomstone extends doom {
    public doomstone(Settings S){
        super(S);
        IEventHurt.ALLOW_DAMAGE.register((livingEntity, source, amt)->{
            if (livingEntity instanceof PlayerEntity player) {
                if (HasCurio.has(this, player)) {
                    if (amt <= 1){
                        return false;
                    }
                    if (!player.getItemCooldownManager().isCoolingDown(this.getDefaultStack())) {
                        player.getItemCooldownManager().set(this.getDefaultStack(), 24);
                        return false;
                    }else {
                        amt *= 4;
                        player.setHealth(player.getHealth() - amt);
                    }
                }
            }
            return true;
        });
    }


    @Override
    public void getDynamicModifiers(ItemStack stack, SlotReference reference, AccessoryAttributeBuilder builder) {
        builder.getSlotModifiers().put("hand/ring",new EntityAttributeModifier(Identifier.of(String.valueOf(this.getTranslationKey())),2, EntityAttributeModifier.Operation.ADD_VALUE));
    }


  @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, net.minecraft.item.tooltip.TooltipType type) {
        tooltip.add(Text.translatable("moonfabric.tooltip.doomstone.1").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("moonfabric.tooltip.doomstone.2").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("moonfabric.tooltip.doomstone.3").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable(""));

    }
}

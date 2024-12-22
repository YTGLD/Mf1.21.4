package com.moonfabric.item.common.Mise;

import com.moonfabric.HasCurio;
import com.moonfabric.Ievent.old.IEventHurt;
import com.moonfabric.item.Ms.extend.ItemTir;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class blackhead extends ItemTir {
    public blackhead(Settings S){
        super(S);
        IEventHurt.ALLOW_DAMAGE.register((livingEntity, source, amt)->{
            if (livingEntity instanceof PlayerEntity player) {
                if (HasCurio.has(this, player)) {
                    if (!player.getItemCooldownManager().isCoolingDown(this.getDefaultStack())){
                        player.getItemCooldownManager().set(this.getDefaultStack(), 140);
                        return false;
                    }
                }
            }
            return true;
        });
    }

  @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, net.minecraft.item.tooltip.TooltipType type) {
        tooltip.add(Text.translatable("moonfabric.tooltip.blackhead.1").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("moonfabric.tooltip.blackhead.2").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable(""));


    }
}




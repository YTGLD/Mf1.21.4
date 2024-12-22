package com.moonfabric.item.common.CurseOrDoom;

import com.moonfabric.item.Ms.extend.doom;
import io.wispforest.accessories.api.slot.SlotReference;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class doomsoul extends doom {


    public doomsoul(Settings settings) {
        super(settings);
    }

    @Override
    public void tick(ItemStack stack, SlotReference reference) {
        if (reference.entity() instanceof PlayerEntity player){
            if (player.isDead()){
                player.getEntityWorld().createExplosion(null,player.getX(), player.getY(), player.getZ(), 5.0f, true, World.ExplosionSourceType.MOB);
            }
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, net.minecraft.item.tooltip.TooltipType type) {
        tooltip.add(Text.translatable("moonfabric.tooltip.doomsoul.1").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("moonfabric.tooltip.doomsoul.2").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("moonfabric.tooltip.doomsoul.3").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("moonfabric.tooltip.doomsoul.4").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("moonfabric.tooltip.doomsoul.5").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable(""));
    }
}

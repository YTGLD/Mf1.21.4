package com.moonfabric.item.common.Blood;

import com.moonfabric.Entity.line;
import com.moonfabric.HasCurio;
import com.moonfabric.init.InItEntity;
import com.moonfabric.init.init;
import com.moonfabric.item.Ms.TheNecoraIC;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class blood_amout extends TheNecoraIC {

    public blood_amout(Settings settings) {
        super(settings);
    }

    public static void Hurt(LivingEntity me, DamageSource source) {

        if (me instanceof PlayerEntity player) {

            if (source.getSource() != null && HasCurio.has(init.blood_amout, player)) {

                if (!player.getItemCooldownManager().isCoolingDown(init.blood_amout.getDefaultStack())) {
                    line line = new line(InItEntity.Line, player.getEntityWorld());
                    line.setPos(player.getX(),player.getY(),player.getZ());
                    line.setOwnerUuid(player.getUuid());
                    player.getWorld().spawnEntity(line);

                    player.getItemCooldownManager().set(init.blood_amout.getDefaultStack(), 10);
                }
            }
        }
    }


    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, net.minecraft.item.tooltip.TooltipType type) {
        tooltip.add(Text.translatable(""));
        tooltip.add(Text.translatable("moonfabric.tooltip.blood_amout").formatted(Formatting.GRAY));

    }
}

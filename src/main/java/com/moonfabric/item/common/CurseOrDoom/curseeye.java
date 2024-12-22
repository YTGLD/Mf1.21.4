package com.moonfabric.item.common.CurseOrDoom;

import com.moonfabric.item.Ms.extend.curse;
import io.wispforest.accessories.api.slot.SlotReference;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;

import java.util.List;

public class curseeye extends curse {
    public curseeye(Settings settings) {
        super(settings);
    }

    @Override
    public void tick(ItemStack stack, SlotReference reference) {
        if (reference.entity() instanceof PlayerEntity player){
            Vec3d vec3d = player.getPos();
            int r = 10;
            List<LivingEntity> list = player.getEntityWorld().getEntitiesByClass(LivingEntity.class,new Box(vec3d.x + r,vec3d.y + r,vec3d.z + r,vec3d.x - r,vec3d.y - r,vec3d.z - r), EntityPredicates.EXCEPT_SPECTATOR);
            for (LivingEntity livingEntity : list){
                if (livingEntity != player){
                    livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 20, 0,false,false));

                }

            }

        }
    }

   

  @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, net.minecraft.item.tooltip.TooltipType type) {
        tooltip.add(Text.translatable("moonfabric.tooltip.curseeye.1").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable(""));
    }
}

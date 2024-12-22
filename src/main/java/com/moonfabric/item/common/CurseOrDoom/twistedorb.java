package com.moonfabric.item.common.CurseOrDoom;

import com.moonfabric.item.Ms.extend.ItemTir;
import io.wispforest.accessories.api.slot.SlotReference;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;

import java.util.List;

public class twistedorb extends ItemTir {
    public static boolean aBoolean = false;

    public twistedorb(Settings settings) {
        super(settings);
    }

    @Override
    public void tick(ItemStack stack, SlotReference reference) {
        Vec3d playerPos = reference.entity().getPos().add(0,0.5,0);
        float range = 1.5f;
        List<ItemEntity> entities = reference.entity().getEntityWorld().getNonSpectatingEntities(ItemEntity.class, new Box(playerPos.x - range, playerPos.y - range, playerPos.z - range, playerPos.x + range, playerPos.y + range, playerPos.z + range));
        for (ItemEntity item : entities) {
            if (item.hasNoGravity()&&item.cannotPickup()&&item.getStack().isOf(Items.NETHERRACK)) {

                for (String s : item.getCommandTags()){
                    if (s.contains("twisted")){
                        reference.entity().addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 100, 2));
                        reference.entity().addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 100, 2));
                        reference.entity().addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 2));

                        reference.entity().getWorld().playSound(null,reference.entity().getX(), reference.entity().getY(),reference.entity().getZ(), SoundEvents.BLOCK_BEACON_ACTIVATE, SoundCategory.NEUTRAL,1.5F,1.5F);

                        item.discard();
                    }
                }
            }
        }
    }

  @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, net.minecraft.item.tooltip.TooltipType type) {
        tooltip.add(Text.translatable("moonfabric.tooltip.twistedorb.1").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("moonfabric.tooltip.twistedorb.2").formatted(Formatting.GRAY));



        tooltip.add(Text.translatable(""));
    }
}

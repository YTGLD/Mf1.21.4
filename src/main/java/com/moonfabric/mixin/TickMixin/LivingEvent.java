package com.moonfabric.mixin.TickMixin;

import com.moonfabric.HasCurio;
import com.moonfabric.Ievent.old.IHurtSizeEvent;
import com.moonfabric.Ievent.old.IeventAttack;
import com.moonfabric.item.common.Blood.blood_amout;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
@Mixin(LivingEntity.class)
public class LivingEvent {
    @Inject(method = "modifyAppliedDamage", at = @At(value = "RETURN"), cancellable = true)
    private void mf$modifyAppliedDamage_m(DamageSource source, float amount, CallbackInfoReturnable<Float> cir){
        LivingEntity livingEntity = (LivingEntity) (Object) this;

        blood_amout.Hurt(livingEntity,source);


        ItemStack itemStack = HasCurio.getItemStack(livingEntity);
        {
            float size = IHurtSizeEvent.ON_HURT.invoker().hurt(livingEntity, source, cir.getReturnValue(), itemStack);
            cir.setReturnValue(size);

        }
        if (source != null && source.getAttacker() instanceof LivingEntity living) {
            float size= IeventAttack.ON_HURT.invoker().hurt(living,source,cir.getReturnValue(),itemStack);
            cir.setReturnValue(size);
        }
    }
}

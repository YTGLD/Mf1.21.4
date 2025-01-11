package com.moonfabric.mixin.TickMixin;

import com.moonfabric.HasCurio;
import com.moonfabric.Ievent.old.IHurtSizeEvent;
import com.moonfabric.Ievent.old.IeventAttack;
import com.moonfabric.item.common.Blood.blood_amout;
import io.wispforest.accessories.api.AccessoriesCapability;
import io.wispforest.accessories.api.AccessoriesContainer;
import io.wispforest.accessories.impl.ExpandedSimpleContainer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(LivingEntity.class)
public class LivingEvent {
    @Inject(method = "modifyAppliedDamage", at = @At(value = "RETURN"), cancellable = true)
    private void mf$modifyAppliedDamage_m(DamageSource source, float amount, CallbackInfoReturnable<Float> cir){
        LivingEntity livingEntity = (LivingEntity) (Object) this;

        blood_amout.Hurt(livingEntity,source);
        AccessoriesCapability capability = AccessoriesCapability.get(livingEntity);
        if (capability != null) {
            for (Map.Entry<String, AccessoriesContainer> stringAccessoriesContainerEntry : capability.getContainers().entrySet()) {
                AccessoriesContainer container = stringAccessoriesContainerEntry.getValue();
                ExpandedSimpleContainer accessories = container.getAccessories();
                for (int i = 0; i < accessories.size(); ++i) {
                    ItemStack stack = accessories.getStack(i);
                    if (!stack.isEmpty()) {
                        float size = IHurtSizeEvent.ON_HURT.invoker().hurt(livingEntity, source, cir.getReturnValue(), stack);
                        cir.setReturnValue(size);

                    }
                }
                for (int i = 0; i < accessories.size(); ++i) {
                    ItemStack stack = accessories.getStack(i);
                    if (!stack.isEmpty()) {
                        if (source != null && source.getAttacker() instanceof LivingEntity living) {
                            float size= IeventAttack.ON_HURT.invoker().hurt(living,source,cir.getReturnValue(),stack);
                            cir.setReturnValue(size);
                        }
                    }
                }
            }

        }



    }
}

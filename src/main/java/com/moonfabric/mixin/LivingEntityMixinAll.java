package com.moonfabric.mixin;

import com.moonfabric.HasCurio;
import com.moonfabric.Ievent.AllEvent;
import com.moonfabric.Ievent.AdvancementEvt;
import com.moonfabric.Ievent.evt.AllZombie;
import com.moonfabric.Ievent.evt.LootOrBlockLuck;
import com.moonfabric.init.AttReg;
import com.moonfabric.init.init;
import com.moonfabric.item.common.Blood.blood_stones;
import com.moonfabric.item.common.death_penalty;
import com.moonfabric.item.common.double_head;
import com.moonfabric.item.dna.dna;
import com.moonfabric.item.ectoplasm.ectoplasmapple;
import com.moonfabric.item.ectoplasm.ectoplasmhorseshoe;
import com.moonfabric.item.ectoplasm.ectoplasmshild;
import com.moonfabric.item.nightmare.nightmarestone;
import com.moonfabric.item.nightmare.super_nightmare.*;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixinAll {
    @Inject(method = "modifyAppliedDamage", at = @At(value = "RETURN"), cancellable = true)
    private void mf$modifyAppliedDamage_m(DamageSource source, float amount, CallbackInfoReturnable<Float> cir){
        LivingEntity livingEntity = (LivingEntity) (Object) this;
        ectoplasmapple.hurt(livingEntity, source);
        ectoplasmshild.hurt(livingEntity,cir);
        ectoplasmhorseshoe.ectoplasmhorseshoeHurt(livingEntity,source,cir);
        AllZombie.evils(livingEntity, source,cir);
        dna.hurt(source,livingEntity,cir);
        nightmarestone.hurt(livingEntity,source);
        AllEvent.doDifLootDamage(livingEntity,cir);
        double_head.hurts(livingEntity, source);
        blood_stones.hurt(livingEntity,source,cir);
        nightmare_base_black_eye_eye.attLook(source,livingEntity,cir);
        nightmare_base_start.damage(source,livingEntity,cir);
        nightmare_base_start_pod.damage(source,livingEntity,cir);
        nightmare_base_black_eye_heart.hurt(source,cir);
        nightmare_base_stone_brain.hurts(source,livingEntity,cir);
        nightmare_base_stone_virus.h(source,livingEntity,cir);
        nightmare_base_stone.LivingHurtEvent(source,livingEntity,cir);
        nightmare_base_insight_insane.damage(source,cir);
        nightmare_base_fool_bone.attLook(livingEntity, source,cir);
        nightmare_base_redemption_deception.LivingIncomingDamageEvent(source, livingEntity,cir);
    }
    @Inject(method = "getMaxHealth", at = @At(value = "RETURN"), cancellable = true)
    private void getMaxHealth(CallbackInfoReturnable<Float> cir){
        LivingEntity livingEntity = (LivingEntity) (Object) this;
        AllEvent.doDifLootHealth(livingEntity,cir);
    }
    @Inject(method = "tryUseDeathProtector", at = @At(value = "RETURN"))
    private void tryUseDeathProtector(DamageSource source, CallbackInfoReturnable<Boolean> cir){
        LivingEntity livingEntity = (LivingEntity) (Object) this;

        AdvancementEvt.nightmare_base_stone_virus(source,livingEntity);
        AdvancementEvt.LivingUseTotemEvent(source,livingEntity);

    }
    @Inject(method = "onDeath", at = @At(value = "RETURN"))
    private void mf$modifyAppliedDamage_m(DamageSource damageSource, CallbackInfo ci){
        LivingEntity livingEntity = (LivingEntity) (Object) this;
        AdvancementEvt.nightmare_base_start_egg(damageSource,livingEntity);
        AdvancementEvt.nightmare_base_insight_insane(damageSource,livingEntity);
        AdvancementEvt.nightmare_base_fool(damageSource,livingEntity);
        AdvancementEvt.nightmare_base_redemption_degenerate(damageSource,livingEntity);
        AdvancementEvt.nightmare_base_redemption_deception(damageSource,livingEntity);
        AdvancementEvt.nightmare_base_reversal_card(damageSource,livingEntity);
        AdvancementEvt.nightmare_base_stone_meet(damageSource,livingEntity);
        AdvancementEvt.nightmare_base_stone_brain(damageSource,livingEntity);
        AdvancementEvt.drop(damageSource,livingEntity);








        AllZombie.evil(livingEntity,damageSource);
        dna.dieD(livingEntity, damageSource);
        death_penalty.hurts(livingEntity,damageSource);
        blood_stones.die(damageSource);
        nightmare_base_reversal.LivingDeathEvent(damageSource,livingEntity);
        nightmare_base_insight_insane.LivingDeathEvents(damageSource,livingEntity);
        nightmare_base_black_eye_red.kill(damageSource);
        LootOrBlockLuck.dropLootItem(livingEntity,init.mblock,1,damageSource, EntityType.ZOMBIE);
        LootOrBlockLuck.dropLootItem(livingEntity,init.greedcrystal,1,damageSource, EntityType.ZOMBIE);
    }
    @Inject(method = "canWalkOnFluid", at = @At(value = "RETURN"), cancellable = true)
    private void canWalkOnFluid(FluidState state, CallbackInfoReturnable<Boolean> cir){
        LivingEntity livingEntity = (LivingEntity) (Object) this;
        if (HasCurio.has(init.ambush,livingEntity)){
            cir.setReturnValue(true);
        }

    }
    @Inject(method = "travel", at = @At(value = "HEAD"))
    private void onDeath(Vec3d movementInput, CallbackInfo ci){
        LivingEntity livingEntity = (LivingEntity) (Object) this;
        if (livingEntity.isTouchingWater()) {
            if (livingEntity instanceof PlayerEntity player) {
                if (player.getAttributeInstance(AttReg.swiming) != null) {
                    float speed = (float) player.getAttributeInstance(AttReg.swiming).getValue();
                    //1

                    livingEntity.updateVelocity((speed - 1)/2, movementInput);


                }
            }
        }

    }
    @ModifyVariable(method = "heal", at = @At(value = "HEAD"), index = 1, argsOnly = true)
    public float heal(float amout) {
        LivingEntity livingEntity = (LivingEntity) (Object) this;
        nightmare_base_black_eye_heart.heal(livingEntity,amout);
        nightmare_base_reversal_orb.LivingHealEvent(livingEntity,amout);
        if (livingEntity instanceof PlayerEntity player) {
            if (player.getAttributeInstance(AttReg.heal)!= null) {
                return (float) (amout * (player.getAttributeInstance(AttReg.heal).getValue()));
            }
        }
        return amout;
    }
}

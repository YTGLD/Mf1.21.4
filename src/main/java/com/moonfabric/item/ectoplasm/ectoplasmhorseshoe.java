package com.moonfabric.item.ectoplasm;

import com.moonfabric.HasCurio;
import com.moonfabric.init.init;
import com.moonfabric.item.Ms.ectoplasm;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

public class ectoplasmhorseshoe extends ectoplasm {


    public ectoplasmhorseshoe(Settings settings) {
        super(settings);
    }

    public static void ectoplasmhorseshoeHurt (LivingEntity me, DamageSource source, CallbackInfoReturnable<Float> cit){
        if (HasCurio.has(init.ectoplasmhorseshoe,me)){
           if (source.isOf(DamageTypes.FALL)){
               cit.setReturnValue(cit.getReturnValue() * 0.1f);
           }

        }
    }
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        tooltip.add(Text.translatable("item.ectoplasmhorseshoe.tool.string").formatted(Formatting.GRAY));
    }
}



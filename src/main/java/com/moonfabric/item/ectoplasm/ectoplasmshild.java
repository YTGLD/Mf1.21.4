package com.moonfabric.item.ectoplasm;


import com.moonfabric.HasCurio;
import com.moonfabric.init.Data;
import com.moonfabric.init.init;
import com.moonfabric.item.Ms.ectoplasm;
import io.wispforest.accessories.api.AccessoriesCapability;
import io.wispforest.accessories.api.AccessoriesContainer;
import io.wispforest.accessories.api.slot.SlotReference;
import io.wispforest.accessories.impl.ExpandedSimpleContainer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.Map;

public class ectoplasmshild extends ectoplasm {

    public static final String size = "HurtSize";

    public ectoplasmshild(Settings settings) {
        super(settings);
    }

    public static void hurt (LivingEntity me, CallbackInfoReturnable<Float> cit){
        if (HasCurio.has(init.ectoplasmshild,me)){
            AccessoriesCapability capability = AccessoriesCapability.get(me);
            if (capability != null) {
                for (Map.Entry<String, AccessoriesContainer> stringAccessoriesContainerEntry : capability.getContainers().entrySet()) {
                    AccessoriesContainer container = stringAccessoriesContainerEntry.getValue();
                    ExpandedSimpleContainer accessories = container.getAccessories();
                    for (int i = 0; i < accessories.size(); ++i) {
                        ItemStack stack = accessories.getStack(i);
                        if (!stack.isEmpty()) {
                            if (stack.get(Data.CUSTOM_DATA)!= null) {
                                if (stack.get(Data.CUSTOM_DATA).getInt(size) <= 5) {
                                    stack.get(Data.CUSTOM_DATA).putInt(size, stack.get(Data.CUSTOM_DATA).getInt(size) + 1);
                                } else {
                                    stack.get(Data.CUSTOM_DATA).putInt(size, 0);
                                    cit.setReturnValue(0f);
                                }

                            }
                        }
                    }
                }
            }

        }
    }

    @Override
    public void tick(ItemStack stack, SlotReference reference) {
        reference.entity().addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 20, 0, false, false));

        if (stack.get(Data.CUSTOM_DATA) == null){
            stack.set(Data.CUSTOM_DATA,new NbtCompound());
        }
    }



    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        tooltip.add(Text.translatable("item.ectoplasmshild.tool.string").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable(""));
        tooltip.add(Text.translatable("item.ectoplasmshild.tool.string.1").formatted(Formatting.GRAY));
    }

}

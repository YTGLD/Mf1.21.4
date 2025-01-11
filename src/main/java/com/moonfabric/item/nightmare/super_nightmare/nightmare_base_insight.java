package com.moonfabric.item.nightmare.super_nightmare;

import com.moonfabric.HasCurio;
import com.moonfabric.init.init;
import com.moonfabric.item.Ms.nightmare;
import io.wispforest.accessories.api.AccessoriesCapability;
import io.wispforest.accessories.api.AccessoriesContainer;
import io.wispforest.accessories.api.slot.SlotReference;
import io.wispforest.accessories.impl.ExpandedSimpleContainer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;
import java.util.Map;

public class nightmare_base_insight extends com.moonfabric.item.Ms.SNightmare{
    public nightmare_base_insight(Settings settings) {
        super(settings);
    }
    @Override
    public boolean canUnequip(ItemStack stack, SlotReference reference) {
        if (reference.entity() instanceof PlayerEntity player){
            if (player.isCreative()){
                return true;
            }
        }
        return false;
    }
    @Override
    public void tick(ItemStack stack, SlotReference reference) {
        AccessoriesCapability capability = AccessoriesCapability.get(reference.entity());
        if (capability != null) {
            if (HasCurio.has(init.nightmare_base_insight, reference.entity())) {
                for (Map.Entry<String, AccessoriesContainer> stringAccessoriesContainerEntry : capability.getContainers().entrySet()) {
                    AccessoriesContainer container = stringAccessoriesContainerEntry.getValue();
                    ExpandedSimpleContainer accessories = container.getAccessories();
                    for (int i = 0; i < accessories.size(); ++i) {

                    }
                }
            }
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        tooltip.add(Text.translatable("item.nightmare_base_insight.tool.string").formatted(Formatting.DARK_RED));
        tooltip.add(Text.translatable("item.nightmare_base_insight.tool.string.1").formatted(Formatting.DARK_RED));
        tooltip.add(Text.translatable("item.nightmare_base_black_eye.tool.string.1").formatted(Formatting.RED));

        tooltip.add(Text.translatable("item.moonfabric.nightmare_base_insight_collapse").formatted(Formatting.DARK_RED));
        tooltip.add(Text.translatable("item.moonfabric.nightmare_base_insight_insane").formatted(Formatting.DARK_RED));
        tooltip.add(Text.translatable("item.moonfabric.nightmare_base_insight_drug").formatted(Formatting.DARK_RED));
        tooltip.add(Text.literal(""));
        tooltip.add(Text.translatable("item.nightmareeye.tool.string.2").formatted(Formatting.DARK_RED));
    }
}

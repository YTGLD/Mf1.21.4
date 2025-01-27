package com.moonfabric.item.nightmare.super_nightmare;

import com.moonfabric.HasCurio;
import com.moonfabric.Ievent.AdvancementEvt;
import com.moonfabric.Ievent.AllEvent;
import com.moonfabric.init.Data;
import com.moonfabric.init.init;
import com.moonfabric.item.Ms.nightmare;
import io.wispforest.accessories.api.AccessoriesCapability;
import io.wispforest.accessories.api.AccessoriesContainer;
import io.wispforest.accessories.api.slot.SlotReference;
import io.wispforest.accessories.impl.ExpandedSimpleContainer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.nbt.NbtCompound;
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
                        ItemStack box = accessories.getStack(i);
                        if (box.isOf(init.medicinebox)) {
                            NbtCompound tag = box.get(Data.CUSTOM_DATA);
                            if (tag != null) {
                                if (tag.getBoolean(AllEvent.blood_eat) &&
                                        tag.getBoolean(AllEvent.blood_hurt) &&
                                        tag.getBoolean(AllEvent.blood_jump) &&
                                        tag.getBoolean(AllEvent.blood_spawn) &&
                                        tag.getBoolean(AllEvent.blood_enchant))
                                {
                                    if (stack.get(Data.CUSTOM_DATA)!=null&& !stack.get(Data.CUSTOM_DATA).getBoolean(AdvancementEvt.nightmare_base_insight_drug)){
                                        if (reference.entity() instanceof PlayerEntity player){
                                            player.giveItemStack(new ItemStack(init.nightmare_base_insight_drug));
                                            stack.get(Data.CUSTOM_DATA).putBoolean(AdvancementEvt.nightmare_base_insight_drug,true);
                                        }
                                    }
                                }
                            }
                        }
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

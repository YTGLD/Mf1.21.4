package com.moonfabric.Ievent;

import com.moonfabric.HasCurio;
import com.moonfabric.init.Data;
import com.moonfabric.item.Ms.TheNecoraIC;
import com.moonfabric.item.TheNecora.cell_blood;
import com.moonfabric.item.TheNecora.cell_boom;
import com.moonfabric.item.TheNecora.cell_calcification;
import com.moonfabric.item.TheNecora.cell_mummy;
import io.wispforest.accessories.api.AccessoriesCapability;
import io.wispforest.accessories.api.AccessoriesContainer;
import io.wispforest.accessories.impl.ExpandedSimpleContainer;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Difficulty;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

public class AllEvent {
    public static String blood = "bloodgene";
    public static String rage = "ragegene";
    public static final String DamageCell = "DamageCell";
    public static final  String muMMY = cell_mummy.Mummy;
    public static final  String boom = cell_boom.cb;
    public static final  String calcification = cell_calcification.cc;
    public static final  String cb_blood = cell_blood.c_blood;
    public static final String lootTable = "god_loot";
    public static void doDifLootDamage(LivingEntity player, CallbackInfoReturnable<Float> cir){

        AccessoriesCapability capability = AccessoriesCapability.get(player);
        if (capability != null) {
            for (Map.Entry<String, AccessoriesContainer> stringAccessoriesContainerEntry : capability.getContainers().entrySet()) {
                AccessoriesContainer container = stringAccessoriesContainerEntry.getValue();
                ExpandedSimpleContainer accessories = container.getAccessories();
                for (int i = 0; i < accessories.size(); ++i) {
                    ItemStack stack = accessories.getStack(i);
                    if (!stack.isEmpty()) {
                        if (stack.get(Data.CUSTOM_DATA)!=null){
                            if (stack.get(Data.CUSTOM_DATA).getBoolean(Difficulty.EASY.getName())){
                            }
                            if (stack.get(Data.CUSTOM_DATA).getBoolean(Difficulty.NORMAL.getName())){
                                cir.setReturnValue(cir.getReturnValue()+0.15f);
                            }
                            if (stack.get(Data.CUSTOM_DATA).getBoolean(Difficulty.HARD.getName())){
                                cir.setReturnValue(cir.getReturnValue()+0.25f);
                            }
                            if (stack.get(Data.CUSTOM_DATA).getBoolean(lootTable)){
                                cir.setReturnValue(cir.getReturnValue()+0.35f);
                            }

                        }
                    }
                }
            }
        }

    }
    public static void doDifLootHealth(LivingEntity player, CallbackInfoReturnable<Float> cir){
        AccessoriesCapability capability = AccessoriesCapability.get(player);
        if (capability != null) {
            for (Map.Entry<String, AccessoriesContainer> stringAccessoriesContainerEntry : capability.getContainers().entrySet()) {
                AccessoriesContainer container = stringAccessoriesContainerEntry.getValue();
                ExpandedSimpleContainer accessories = container.getAccessories();
                for (int i = 0; i < accessories.size(); ++i) {
                    ItemStack stack = accessories.getStack(i);
                    if (!stack.isEmpty()) {
                        if (stack.get(Data.CUSTOM_DATA)!=null){
                            if (stack.get(Data.CUSTOM_DATA).getBoolean(Difficulty.EASY.getName())){
                                cir.setReturnValue(cir.getReturnValue()+0.25f);
                            }
                            if (stack.get(Data.CUSTOM_DATA).getBoolean(Difficulty.NORMAL.getName())){
                                cir.setReturnValue(cir.getReturnValue()+0.5f);
                            }
                            if (stack.get(Data.CUSTOM_DATA).getBoolean(Difficulty.HARD.getName())){
                                cir.setReturnValue(cir.getReturnValue()+0.75f);
                            }
                            if (stack.get(Data.CUSTOM_DATA).getBoolean(lootTable)){
                                cir.setReturnValue(cir.getReturnValue()+1f);
                            }

                        }
                    }
                }
            }
        }

    }

    public static void doDifLoot(LootContext context, ObjectArrayList<ItemStack> objectArrayList){
        Entity entity = context.get(LootContextParameters.THIS_ENTITY);
        if (entity instanceof PlayerEntity player){
            if (player.getWorld() instanceof ServerWorld serverLevel) {

                for (ItemStack itemStack : objectArrayList) {
                    if (itemStack.getItem() instanceof TheNecoraIC) {
                        if (itemStack.get(Data.CUSTOM_DATA) == null) {
                            NbtCompound compound = new NbtCompound();
                            itemStack.set(Data.CUSTOM_DATA, compound);
                        }

                        if (serverLevel.getDifficulty() == (Difficulty.PEACEFUL)) {
                            itemStack.get(Data.CUSTOM_DATA).putBoolean(Difficulty.PEACEFUL.getName(), true);

                        }
                        if (serverLevel.getDifficulty() == (Difficulty.EASY)) {
                            itemStack.get(Data.CUSTOM_DATA).putBoolean(Difficulty.EASY.getName(), true);
                        }
                        if (serverLevel.getDifficulty() == (Difficulty.NORMAL)) {
                            itemStack.get(Data.CUSTOM_DATA).putBoolean(Difficulty.NORMAL.getName(), true);
                        }
                        if (serverLevel.getDifficulty() == (Difficulty.HARD)) {
                            int lv = MathHelper.nextInt(Random.create(), 1, 2);
                            if (lv == 1) {
                                itemStack.get(Data.CUSTOM_DATA).putBoolean(Difficulty.HARD.getName(), true);
                            } else if (lv == 2) {
                                itemStack.get(Data.CUSTOM_DATA).putBoolean(lootTable, true);
                            }
                        }
                    }
                }
            }
        }
    }


}

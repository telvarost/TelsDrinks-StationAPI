package com.github.telvarost.telsdrinks.mixin;

import com.github.telvarost.telsdrinks.events.BlockListener;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CowEntity.class)
public class CowEntityMixin {

    @Inject(
            method = "interact",
            at = @At("RETURN"),
            cancellable = true
    )
    public void telsDrinks_interact(PlayerEntity player, CallbackInfoReturnable<Boolean> cir) {
        ItemStack stack = player.inventory.getSelectedItem();
        if (stack != null && stack.itemId == BlockListener.EMPTY_MUG.id) {
            if (stack.count == 1) {
                player.inventory.setStack(player.inventory.selectedSlot, new ItemStack(BlockListener.CUP_OF_MILK.asItem(), 1));
            } else {
                player.inventory.addStack(new ItemStack(BlockListener.CUP_OF_MILK.asItem(), 1));
                stack.count--;
            }
            cir.setReturnValue(true);
        }
    }
}
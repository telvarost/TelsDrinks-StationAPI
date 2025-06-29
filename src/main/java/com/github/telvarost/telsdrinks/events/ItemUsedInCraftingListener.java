package com.github.telvarost.telsdrinks.events;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.event.container.slot.ItemUsedInCraftingEvent;

import static com.github.telvarost.telsdrinks.events.BlockListener.*;

public class ItemUsedInCraftingListener {

    @EventListener
    public void telsdrinks_fillKettleCheck(ItemUsedInCraftingEvent event) {

        if (  (null != event.itemCrafted)
           && (null != event.itemUsed)
        ) {
            if (  (  (POISON.id       == event.itemUsed.itemId)
                  || (CUP_OF_WATER.id == event.itemUsed.itemId)
                  || (CUP_OF_MILK.id  == event.itemUsed.itemId)
                  || (APPLE_CIDER.id  == event.itemUsed.itemId)
                  || (BITTER_WATER.id == event.itemUsed.itemId)
                  )
               && (DANDELION_TEA.id != event.itemCrafted.itemId)
               && (ROSE_TEA.id      != event.itemCrafted.itemId)
               && (FAIRY_TEA.id     != event.itemCrafted.itemId)
               && (HOT_CHOCOLATE.id != event.itemCrafted.itemId)
               && (LATTE.id         != event.itemCrafted.itemId)
               && (MOCHA.id         != event.itemCrafted.itemId)
            ) {
                event.craftingMatrix.setStack(event.itemOrdinal, new ItemStack(EMPTY_MUG.asItem(), 1));
            }
        }
    }
}
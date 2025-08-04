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
            if (  (  (POISON.asItem().id       == event.itemUsed.itemId)
                  || (CUP_OF_WATER.asItem().id == event.itemUsed.itemId)
                  || (CUP_OF_MILK.asItem().id  == event.itemUsed.itemId)
                  || (APPLE_CIDER.asItem().id  == event.itemUsed.itemId)
                  || (ELIXIR.asItem().id       == event.itemUsed.itemId)
                  || (BITTER_WATER.asItem().id == event.itemUsed.itemId)
                  )
               && (TOXIC_SLUDGE.asItem().id  != event.itemCrafted.itemId)
               && (DANDELION_TEA.asItem().id != event.itemCrafted.itemId)
               && (ROSE_TEA.asItem().id      != event.itemCrafted.itemId)
               && (FAIRY_TEA.asItem().id     != event.itemCrafted.itemId)
               && (HOT_CHOCOLATE.asItem().id != event.itemCrafted.itemId)
               && (LATTE.asItem().id         != event.itemCrafted.itemId)
               && (MOCHA.asItem().id         != event.itemCrafted.itemId)
            ) {
                event.craftingMatrix.setStack(event.itemOrdinal, new ItemStack(EMPTY_MUG.asItem(), 1));
            }
        }
    }
}
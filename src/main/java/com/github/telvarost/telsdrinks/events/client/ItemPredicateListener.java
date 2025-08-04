package com.github.telvarost.telsdrinks.events.client;

import com.github.telvarost.telsdrinks.TelsDrinks;
import com.github.telvarost.telsdrinks.events.BlockListener;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.modificationstation.stationapi.api.client.event.render.model.ItemModelPredicateProviderRegistryEvent;

public class ItemPredicateListener {

    @EventListener
    public void registerItemModelPredicates(ItemModelPredicateProviderRegistryEvent event) {
        for (Block block : new Block[]{BlockListener.BITTER_WATER, BlockListener.CUP_OF_WATER, BlockListener.CUP_OF_MILK, BlockListener.APPLE_CIDER}) {
            Item item = block.asItem();
            event.registry.register(item, TelsDrinks.TELS_DRINKS.id("hot"),
                    (stack, world, entity, seed) -> (float)stack.getDamage());
        }
    }
}

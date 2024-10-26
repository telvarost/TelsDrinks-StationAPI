package com.github.telvarost.telsdrinks.events.client;

import com.github.telvarost.telsdrinks.events.BlockListener;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.modificationstation.stationapi.api.client.event.render.model.ItemModelPredicateProviderRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

public class ItemPredicateListener {

    @Entrypoint.Namespace
    public static final Namespace NAMESPACE = Null.get();

    @EventListener
    public void registerItemModelPredicates(ItemModelPredicateProviderRegistryEvent event) {
        for (Block block : new Block[]{BlockListener.BITTER_WATER, BlockListener.CUP_OF_WATER, BlockListener.CUP_OF_MILK, BlockListener.APPLE_CIDER}) {
            Item item = block.asItem();
            event.registry.register(item, NAMESPACE.id("hot"),
                    (stack, world, entity, seed) -> (float)stack.getDamage());
        }
    }
}

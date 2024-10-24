package com.github.telvarost.telsdrinks.events;

import com.github.telvarost.telsdrinks.item.ClayMug;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.Item;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

public class ItemListener {
    public static Item[] items;
    public static Item CLAY_MUG;

    @Entrypoint.Namespace
    public static final Namespace NAMESPACE = Null.get();

    @EventListener
    void registerItems(ItemRegistryEvent event) {
        CLAY_MUG = new ClayMug(NAMESPACE.id("clay_mug")).setTranslationKey(NAMESPACE, "clay_mug");

        items = new Item[]{
                CLAY_MUG
        };
    }
}
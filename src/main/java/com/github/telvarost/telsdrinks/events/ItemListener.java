package com.github.telvarost.telsdrinks.events;

import com.github.telvarost.telsdrinks.ModHelper;
import com.github.telvarost.telsdrinks.item.ClayMug;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.Item;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;

public class ItemListener {
    public static Item[] items;
    public static Item CLAY_MUG;

    @EventListener
    public void registerItems(ItemRegistryEvent event) {
        CLAY_MUG = new ClayMug(ModHelper.NAMESPACE.id("clay_mug")).setTranslationKey(ModHelper.NAMESPACE, "clay_mug");

        items = new Item[]{
                CLAY_MUG
        };
    }
}
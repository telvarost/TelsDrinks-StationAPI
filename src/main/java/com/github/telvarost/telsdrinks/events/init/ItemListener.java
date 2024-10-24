//package com.github.telvarost.telsdrinks.events.init;
//
//import net.mine_diver.unsafeevents.listener.EventListener;
//import net.minecraft.item.Item;
//import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;
//import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
//import net.modificationstation.stationapi.api.util.Namespace;
//import net.modificationstation.stationapi.api.util.Null;
//
//public class ItemListener {
//    public static Item[] items;
//    public static Item raw_common_fish;
//    public static Item cooked_common_fish;
//    public static Item raw_river_fish;
//    public static Item cooked_river_fish;
//    public static Item raw_sea_fish;
//    public static Item cooked_sea_fish;
//    public static Item raw_ocean_fish;
//    public static Item cooked_ocean_fish;
//
//    @Entrypoint.Namespace
//    public static final Namespace NAMESPACE = Null.get();
//
//    @EventListener
//    void registerItems(ItemRegistryEvent event) {
//        raw_common_fish = new ClayMug(NAMESPACE.id("raw_common_fish"), 2, false).setMaxCount(1).setTranslationKey(NAMESPACE, "RawCommonFish");
//
//        items = new Item[]{
//                Fish.raw_common_fish,
//        };
//    }
//}
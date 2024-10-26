package com.github.telvarost.telsdrinks.events;

import com.github.telvarost.telsdrinks.block.EmptyMug;
import com.github.telvarost.telsdrinks.block.Kettle;
import com.github.telvarost.telsdrinks.block.Mug;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.event.registry.BlockRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

import static net.minecraft.block.Block.*;

public class BlockListener {

    public static Block[] blocks;
    public static Block KETTLE;
    public static Block APPLE_KETTLE;
    public static Block BITTER_KETTLE;
    public static Block MILK_KETTLE;
    public static Block POISON_KETTLE;
    public static Block WATER_KETTLE;
    public static Block EMPTY_MUG;
    public static Block CUP_OF_WATER;
    public static Block CUP_OF_MILK;

    @Entrypoint.Namespace
    public static final Namespace NAMESPACE = Null.get();

    @EventListener
    public void registerBlocks(BlockRegistryEvent event) {

        KETTLE = new Kettle(Identifier.of(NAMESPACE, "kettle"), Material.CLAY).setSoundGroup(METAL_SOUND_GROUP).setTranslationKey(NAMESPACE, "kettle");
        APPLE_KETTLE = new Kettle(Identifier.of(NAMESPACE, "apple_kettle"), Material.CLAY).setSoundGroup(METAL_SOUND_GROUP).setTranslationKey(NAMESPACE, "apple_kettle");
        BITTER_KETTLE = new Kettle(Identifier.of(NAMESPACE, "bitter_kettle"), Material.CLAY).setSoundGroup(METAL_SOUND_GROUP).setTranslationKey(NAMESPACE, "bitter_kettle");
        MILK_KETTLE = new Kettle(Identifier.of(NAMESPACE, "milk_kettle"), Material.CLAY).setSoundGroup(METAL_SOUND_GROUP).setTranslationKey(NAMESPACE, "milk_kettle");
        POISON_KETTLE = new Kettle(Identifier.of(NAMESPACE, "poison_kettle"), Material.CLAY).setSoundGroup(METAL_SOUND_GROUP).setTranslationKey(NAMESPACE, "poison_kettle");
        WATER_KETTLE = new Kettle(Identifier.of(NAMESPACE, "water_kettle"), Material.CLAY).setSoundGroup(METAL_SOUND_GROUP).setTranslationKey(NAMESPACE, "water_kettle");
        EMPTY_MUG = new EmptyMug(Identifier.of(NAMESPACE, "empty_mug"), Material.CLAY).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(NAMESPACE, "empty_mug");
        CUP_OF_WATER = new Mug(Identifier.of(NAMESPACE, "cup_of_water"), Material.CLAY).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(NAMESPACE, "cup_of_water");
        CUP_OF_MILK = new Mug(Identifier.of(NAMESPACE, "cup_of_milk"), Material.CLAY).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(NAMESPACE, "cup_of_milk");

        blocks = new Block[]
        {   KETTLE
        ,   APPLE_KETTLE
        ,   BITTER_KETTLE
        ,   MILK_KETTLE
        ,   WATER_KETTLE
        ,   EMPTY_MUG
        ,   CUP_OF_WATER
        ,   CUP_OF_MILK
        };
    }
}


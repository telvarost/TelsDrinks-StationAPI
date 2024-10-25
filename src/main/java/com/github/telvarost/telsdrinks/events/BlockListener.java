package com.github.telvarost.telsdrinks.events;

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
    public static Block WATER_KETTLE;
    public static Block MUG;

    @Entrypoint.Namespace
    public static final Namespace NAMESPACE = Null.get();

    @EventListener
    public void registerBlocks(BlockRegistryEvent event) {

        KETTLE = new Kettle(Identifier.of(NAMESPACE, "kettle"), Material.CLAY).setSoundGroup(METAL_SOUND_GROUP).setTranslationKey(NAMESPACE, "kettle");
        APPLE_KETTLE = new Kettle(Identifier.of(NAMESPACE, "apple_kettle"), Material.CLAY).setSoundGroup(METAL_SOUND_GROUP).setTranslationKey(NAMESPACE, "apple_kettle");
        BITTER_KETTLE = new Kettle(Identifier.of(NAMESPACE, "bitter_kettle"), Material.CLAY).setSoundGroup(METAL_SOUND_GROUP).setTranslationKey(NAMESPACE, "bitter_kettle");
        MILK_KETTLE = new Kettle(Identifier.of(NAMESPACE, "milk_kettle"), Material.CLAY).setSoundGroup(METAL_SOUND_GROUP).setTranslationKey(NAMESPACE, "milk_kettle");
        WATER_KETTLE = new Kettle(Identifier.of(NAMESPACE, "water_kettle"), Material.CLAY).setSoundGroup(METAL_SOUND_GROUP).setTranslationKey(NAMESPACE, "water_kettle");
        MUG = new Mug(Identifier.of(NAMESPACE, "mug"), Material.CLAY).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(NAMESPACE, "mug");

        blocks = new Block[]
        {   KETTLE
        ,   APPLE_KETTLE
        ,   BITTER_KETTLE
        ,   MILK_KETTLE
        ,   WATER_KETTLE
        ,   MUG
        };
    }
}


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
    public static Block POISON;
    public static Block BITTER_WATER;
    public static Block APPLE_CIDER;
    public static Block HOT_CHOCOLATE;
    public static Block LATTE;
    public static Block MOCHA;
    public static Block PUMPKIN_SPICE_LATTE;
    public static Block ROSE_TEA;
    public static Block DANDELION_TEA;

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

        EMPTY_MUG = new EmptyMug(Identifier.of(NAMESPACE, "empty_mug"), Material.PISTON_BREAKABLE).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(NAMESPACE, "empty_mug");
        APPLE_CIDER = new Mug(Identifier.of(NAMESPACE, "apple_cider"), Material.PISTON_BREAKABLE).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(NAMESPACE, "apple_cider");
        BITTER_WATER = new Mug(Identifier.of(NAMESPACE, "bitter_water"), Material.PISTON_BREAKABLE).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(NAMESPACE, "bitter_water");
        CUP_OF_MILK = new Mug(Identifier.of(NAMESPACE, "cup_of_milk"), Material.PISTON_BREAKABLE).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(NAMESPACE, "cup_of_milk");
        POISON = new Mug(Identifier.of(NAMESPACE, "poison"), Material.PISTON_BREAKABLE).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(NAMESPACE, "poison");
        CUP_OF_WATER = new Mug(Identifier.of(NAMESPACE, "cup_of_water"), Material.PISTON_BREAKABLE).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(NAMESPACE, "cup_of_water");
        HOT_CHOCOLATE = new Mug(Identifier.of(NAMESPACE, "hot_chocolate"), Material.PISTON_BREAKABLE).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(NAMESPACE, "hot_chocolate");
        LATTE = new Mug(Identifier.of(NAMESPACE, "latte"), Material.PISTON_BREAKABLE).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(NAMESPACE, "latte");
        MOCHA = new Mug(Identifier.of(NAMESPACE, "mocha"), Material.PISTON_BREAKABLE).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(NAMESPACE, "mocha");
        PUMPKIN_SPICE_LATTE = new Mug(Identifier.of(NAMESPACE, "pumpkin_spice_latte"), Material.PISTON_BREAKABLE).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(NAMESPACE, "pumpkin_spice_latte");
        DANDELION_TEA = new Mug(Identifier.of(NAMESPACE, "dandelion_tea"), Material.PISTON_BREAKABLE).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(NAMESPACE, "dandelion_tea");
        ROSE_TEA = new Mug(Identifier.of(NAMESPACE, "rose_tea"), Material.PISTON_BREAKABLE).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(NAMESPACE, "rose_tea");

        blocks = new Block[]
        {   KETTLE
        ,   APPLE_KETTLE
        ,   BITTER_KETTLE
        ,   MILK_KETTLE
        ,   POISON_KETTLE
        ,   WATER_KETTLE
        ,   EMPTY_MUG
        ,   APPLE_CIDER
        ,   BITTER_WATER
        ,   CUP_OF_MILK
        ,   POISON
        ,   CUP_OF_WATER
        ,   HOT_CHOCOLATE
        ,   LATTE
        ,   MOCHA
        ,   PUMPKIN_SPICE_LATTE
        ,   DANDELION_TEA
        ,   ROSE_TEA
        };
    }
}


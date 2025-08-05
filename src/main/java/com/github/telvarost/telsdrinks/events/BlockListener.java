package com.github.telvarost.telsdrinks.events;

import com.github.telvarost.telsdrinks.TelsDrinks;
import com.github.telvarost.telsdrinks.block.*;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.event.registry.BlockRegistryEvent;
import net.modificationstation.stationapi.api.util.Identifier;

import static net.minecraft.block.Block.*;

public class BlockListener {

    public static Block[] blocks;
    public static Block KETTLE;
    public static Block APPLE_KETTLE;
    public static Block ELIXIR_KETTLE;
    public static Block BITTER_KETTLE;
    public static Block MILK_KETTLE;
    public static Block POISON_KETTLE;
    public static Block WATER_KETTLE;
    public static Block LAVA_KETTLE;

    public static Block EMPTY_MUG;
    public static Block CUP_OF_WATER;
    public static Block CUP_OF_LAVA;
    public static Block CUP_OF_MILK;
    public static Block POISON;
    public static Block TOXIC_SLUDGE;
    public static Block BITTER_WATER;
    public static Block APPLE_CIDER;
    public static Block ELIXIR;
    public static Block ANGELIC_ELIXIR;
    public static Block HOT_CHOCOLATE;
    public static Block LATTE;
    public static Block MOCHA;
    public static Block PUMPKIN_SPICE_LATTE;
    public static Block DANDELION_TEA;
    public static Block ROSE_TEA;
    public static Block FAIRY_TEA;

    public static Block APPLE_CAKE;
    public static Block CHOCOLATE_CAKE;
    public static Block GOLDEN_CAKE;
    public static Block POISON_CAKE;

    @EventListener
    public void registerBlocks(BlockRegistryEvent event) {

        KETTLE = new EmptyKettle(Identifier.of(TelsDrinks.TELS_DRINKS, "kettle"), Material.CLAY).setSoundGroup(METAL_SOUND_GROUP).setTranslationKey(TelsDrinks.TELS_DRINKS, "kettle");
        APPLE_KETTLE = new Kettle(Identifier.of(TelsDrinks.TELS_DRINKS, "apple_kettle"), Material.CLAY).setSoundGroup(METAL_SOUND_GROUP).setTranslationKey(TelsDrinks.TELS_DRINKS, "apple_kettle");
        ELIXIR_KETTLE = new Kettle(Identifier.of(TelsDrinks.TELS_DRINKS, "elixir_kettle"), Material.CLAY).setSoundGroup(METAL_SOUND_GROUP).setTranslationKey(TelsDrinks.TELS_DRINKS, "elixir_kettle");
        BITTER_KETTLE = new Kettle(Identifier.of(TelsDrinks.TELS_DRINKS, "bitter_kettle"), Material.CLAY).setSoundGroup(METAL_SOUND_GROUP).setTranslationKey(TelsDrinks.TELS_DRINKS, "bitter_kettle");
        MILK_KETTLE = new Kettle(Identifier.of(TelsDrinks.TELS_DRINKS, "milk_kettle"), Material.CLAY).setSoundGroup(METAL_SOUND_GROUP).setTranslationKey(TelsDrinks.TELS_DRINKS, "milk_kettle");
        POISON_KETTLE = new Kettle(Identifier.of(TelsDrinks.TELS_DRINKS, "poison_kettle"), Material.CLAY).setSoundGroup(METAL_SOUND_GROUP).setTranslationKey(TelsDrinks.TELS_DRINKS, "poison_kettle");
        WATER_KETTLE = new Kettle(Identifier.of(TelsDrinks.TELS_DRINKS, "water_kettle"), Material.CLAY).setSoundGroup(METAL_SOUND_GROUP).setTranslationKey(TelsDrinks.TELS_DRINKS, "water_kettle");
        LAVA_KETTLE = new Kettle(Identifier.of(TelsDrinks.TELS_DRINKS, "lava_kettle"), Material.CLAY).setLuminance(0.875F).setSoundGroup(METAL_SOUND_GROUP).setTranslationKey(TelsDrinks.TELS_DRINKS, "lava_kettle");

        EMPTY_MUG = new EmptyMug(Identifier.of(TelsDrinks.TELS_DRINKS, "empty_mug"), Material.PISTON_BREAKABLE).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(TelsDrinks.TELS_DRINKS, "empty_mug");
        APPLE_CIDER = new Mug(Identifier.of(TelsDrinks.TELS_DRINKS, "apple_cider"), Material.PISTON_BREAKABLE).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(TelsDrinks.TELS_DRINKS, "apple_cider");
        ELIXIR = new Mug(Identifier.of(TelsDrinks.TELS_DRINKS, "elixir"), Material.PISTON_BREAKABLE).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(TelsDrinks.TELS_DRINKS, "elixir");
        ANGELIC_ELIXIR = new Mug(Identifier.of(TelsDrinks.TELS_DRINKS, "angelic_elixir"), Material.PISTON_BREAKABLE).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(TelsDrinks.TELS_DRINKS, "angelic_elixir");
        BITTER_WATER = new Mug(Identifier.of(TelsDrinks.TELS_DRINKS, "bitter_water"), Material.PISTON_BREAKABLE).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(TelsDrinks.TELS_DRINKS, "bitter_water");
        CUP_OF_MILK = new Mug(Identifier.of(TelsDrinks.TELS_DRINKS, "cup_of_milk"), Material.PISTON_BREAKABLE).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(TelsDrinks.TELS_DRINKS, "cup_of_milk");
        POISON = new Mug(Identifier.of(TelsDrinks.TELS_DRINKS, "poison"), Material.PISTON_BREAKABLE).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(TelsDrinks.TELS_DRINKS, "poison");
        TOXIC_SLUDGE = new Mug(Identifier.of(TelsDrinks.TELS_DRINKS, "toxic_sludge"), Material.PISTON_BREAKABLE).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(TelsDrinks.TELS_DRINKS, "toxic_sludge");
        CUP_OF_WATER = new Mug(Identifier.of(TelsDrinks.TELS_DRINKS, "cup_of_water"), Material.PISTON_BREAKABLE).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(TelsDrinks.TELS_DRINKS, "cup_of_water");
        CUP_OF_LAVA = new Mug(Identifier.of(TelsDrinks.TELS_DRINKS, "cup_of_lava"), Material.PISTON_BREAKABLE).setLuminance(0.875F).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(TelsDrinks.TELS_DRINKS, "cup_of_lava");
        HOT_CHOCOLATE = new Mug(Identifier.of(TelsDrinks.TELS_DRINKS, "hot_chocolate"), Material.PISTON_BREAKABLE).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(TelsDrinks.TELS_DRINKS, "hot_chocolate");
        LATTE = new Mug(Identifier.of(TelsDrinks.TELS_DRINKS, "latte"), Material.PISTON_BREAKABLE).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(TelsDrinks.TELS_DRINKS, "latte");
        MOCHA = new Mug(Identifier.of(TelsDrinks.TELS_DRINKS, "mocha"), Material.PISTON_BREAKABLE).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(TelsDrinks.TELS_DRINKS, "mocha");
        PUMPKIN_SPICE_LATTE = new Mug(Identifier.of(TelsDrinks.TELS_DRINKS, "pumpkin_spice_latte"), Material.PISTON_BREAKABLE).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(TelsDrinks.TELS_DRINKS, "pumpkin_spice_latte");
        DANDELION_TEA = new Mug(Identifier.of(TelsDrinks.TELS_DRINKS, "dandelion_tea"), Material.PISTON_BREAKABLE).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(TelsDrinks.TELS_DRINKS, "dandelion_tea");
        ROSE_TEA = new Mug(Identifier.of(TelsDrinks.TELS_DRINKS, "rose_tea"), Material.PISTON_BREAKABLE).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(TelsDrinks.TELS_DRINKS, "rose_tea");
        FAIRY_TEA = new Mug(Identifier.of(TelsDrinks.TELS_DRINKS, "fairy_tea"), Material.PISTON_BREAKABLE).setLuminance(0.875F).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(TelsDrinks.TELS_DRINKS, "fairy_tea");

        APPLE_CAKE = new AppleCake(Identifier.of(TelsDrinks.TELS_DRINKS, "apple_cake"), 121).setHardness(0.5F).setSoundGroup(WOOL_SOUND_GROUP).setTranslationKey(TelsDrinks.TELS_DRINKS, "apple_cake").disableTrackingStatistics().ignoreMetaUpdates();
        CHOCOLATE_CAKE = new ChocolateCake(Identifier.of(TelsDrinks.TELS_DRINKS, "chocolate_cake"), 121).setHardness(0.5F).setSoundGroup(WOOL_SOUND_GROUP).setTranslationKey(TelsDrinks.TELS_DRINKS, "chocolate_cake").disableTrackingStatistics().ignoreMetaUpdates();
        GOLDEN_CAKE = new GoldenCake(Identifier.of(TelsDrinks.TELS_DRINKS, "golden_cake"), 121).setHardness(0.5F).setSoundGroup(WOOL_SOUND_GROUP).setTranslationKey(TelsDrinks.TELS_DRINKS, "golden_cake").disableTrackingStatistics().ignoreMetaUpdates();
        POISON_CAKE = new PoisonCake(Identifier.of(TelsDrinks.TELS_DRINKS, "poison_cake"), 121).setHardness(0.5F).setSoundGroup(WOOL_SOUND_GROUP).setTranslationKey(TelsDrinks.TELS_DRINKS, "poison_cake").disableTrackingStatistics().ignoreMetaUpdates();

        blocks = new Block[]
        {   KETTLE
        ,   APPLE_KETTLE
        ,   ELIXIR_KETTLE
        ,   BITTER_KETTLE
        ,   MILK_KETTLE
        ,   POISON_KETTLE
        ,   WATER_KETTLE
        ,   LAVA_KETTLE
        ,   EMPTY_MUG
        ,   APPLE_CIDER
        ,   ELIXIR
        ,   ANGELIC_ELIXIR
        ,   BITTER_WATER
        ,   CUP_OF_MILK
        ,   POISON
        ,   TOXIC_SLUDGE
        ,   CUP_OF_WATER
        ,   CUP_OF_LAVA
        ,   HOT_CHOCOLATE
        ,   LATTE
        ,   MOCHA
        ,   PUMPKIN_SPICE_LATTE
        ,   DANDELION_TEA
        ,   ROSE_TEA
        ,   FAIRY_TEA
        ,   APPLE_CAKE
        ,   CHOCOLATE_CAKE
        ,   GOLDEN_CAKE
        ,   POISON_CAKE
        };
    }
}


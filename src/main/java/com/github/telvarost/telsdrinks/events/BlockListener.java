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
    public static Block MUG;

    @Entrypoint.Namespace
    public static final Namespace NAMESPACE = Null.get();

    @EventListener
    public void registerBlocks(BlockRegistryEvent event) {

        KETTLE = new Kettle(Identifier.of(NAMESPACE, "kettle"), Material.CLAY).setSoundGroup(METAL_SOUND_GROUP).setTranslationKey(NAMESPACE, "kettle");
        MUG = new Mug(Identifier.of(NAMESPACE, "mug"), Material.CLAY).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(NAMESPACE, "mug");

        blocks = new Block[]
        {   KETTLE
        ,   MUG
        };
    }
}


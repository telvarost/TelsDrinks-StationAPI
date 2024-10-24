package com.github.telvarost.telsdrinks.events;

import com.github.telvarost.telsdrinks.blockentity.KettleBlockEntity;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.event.block.entity.BlockEntityRegisterEvent;

public class BlockEntityListener {
    @EventListener
    public static void registerBlockEntities(BlockEntityRegisterEvent event) {
        event.register(KettleBlockEntity.class, "telsdrinks:kettle");
    }
}

package com.github.telvarost.telsdrinks.events.client;

import com.github.telvarost.telsdrinks.blockentity.KettleBlockEntity;
import com.github.telvarost.telsdrinks.client.render.blockentity.KettleBlockEntityRenderer;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.client.event.block.entity.BlockEntityRendererRegisterEvent;

public class BlockEntityRendererListener {
    @EventListener
    public static void registerEntityRenderers(BlockEntityRendererRegisterEvent event) {
        event.renderers.put(KettleBlockEntity.class, new KettleBlockEntityRenderer());
    }
}

package com.github.telvarost.telsdrinks.events;

import com.github.telvarost.telsdrinks.network.packet.UpdateKettlePacket;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.event.network.packet.PacketRegisterEvent;

public class PacketListener {
    @EventListener
    public void registerPackets(PacketRegisterEvent event) {
        event.register(250, true, false, UpdateKettlePacket.class);
    }
}

package com.github.telvarost.telsdrinks.network.packet;

import com.github.telvarost.telsdrinks.blockentity.KettleBlockEntity;
import com.github.telvarost.telsdrinks.mixin.ClientNetworkHandlerAccessor;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.client.network.ClientNetworkHandler;
import net.minecraft.network.NetworkHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.world.World;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class UpdateKettlePacket extends Packet {
    public int x;
    public int y;
    public int z;
    public int liquidLevel;

    public static ArrayList<UpdateKettlePacket> pending = new ArrayList<>();

    public UpdateKettlePacket() {

    }

    public UpdateKettlePacket(int x, int y, int z, int liquidLevel) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.liquidLevel = liquidLevel;
    }

    @Override
    public void read(DataInputStream stream) {
        try {
            this.x = stream.readInt();
            this.y = stream.readInt();
            this.z = stream.readInt();
            this.liquidLevel = stream.readInt();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void write(DataOutputStream stream) {
        try {
            stream.writeInt(x);
            stream.writeInt(y);
            stream.writeInt(z);
            stream.writeInt(liquidLevel);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void apply(NetworkHandler networkHandler) {
        if (!networkHandler.isServerSide()) {
            clientApply(networkHandler);
        }
    }

    @Environment(EnvType.CLIENT)
    public void clientApply(NetworkHandler networkHandler) {
        if (networkHandler instanceof ClientNetworkHandler handler) {
            pending.add(this);
        }
    }

    @Override
    public int size() {
        return 16;
    }
}

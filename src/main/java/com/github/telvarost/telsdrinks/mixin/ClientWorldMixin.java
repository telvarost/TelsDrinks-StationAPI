package com.github.telvarost.telsdrinks.mixin;

import com.github.telvarost.telsdrinks.blockentity.KettleBlockEntity;
import com.github.telvarost.telsdrinks.network.packet.UpdateKettlePacket;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.world.ClientWorld;
import net.minecraft.world.World;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.storage.WorldStorage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientWorld.class)
abstract public class ClientWorldMixin extends World {

    public ClientWorldMixin(WorldStorage dimensionData, String name, Dimension dimension, long seed) {
        super(dimensionData, name, dimension, seed);
    }

    private int ticks = 10;

    @Inject(method = "tick", at = @At("TAIL"))
    public void kettlePacket(CallbackInfo ci) {
        ticks++;
        if (ticks % 20 == 0) {
            try {
                for (UpdateKettlePacket packet : UpdateKettlePacket.pending) {
                    if (isPosLoaded(packet.x, packet.y, packet.z)) {
                        BlockEntity e = getBlockEntity(packet.x, packet.y, packet.z);
                        if (e instanceof KettleBlockEntity kettle) {
                            kettle.liquidLevel = packet.liquidLevel;
                            e.markDirty();
                            UpdateKettlePacket.pending.remove(packet);
                        }
                    }
                }
            } catch (Exception ignored) {
                // in the case of concurrent modification
            }
        }
    }
}

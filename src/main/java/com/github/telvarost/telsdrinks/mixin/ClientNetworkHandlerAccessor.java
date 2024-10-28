package com.github.telvarost.telsdrinks.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.network.ClientNetworkHandler;
import net.minecraft.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ClientNetworkHandler.class)
public interface ClientNetworkHandlerAccessor {
    @Accessor("minecraft")
    Minecraft getMinecraft();
    @Accessor("world")
    ClientWorld getWorld();
}

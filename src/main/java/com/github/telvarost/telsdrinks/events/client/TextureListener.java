package com.github.telvarost.telsdrinks.events.client;

import com.github.telvarost.telsdrinks.ModHelper;
import com.github.telvarost.telsdrinks.events.ItemListener;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.client.event.texture.TextureRegisterEvent;

public class TextureListener {

    @EventListener
    public void registerTextures(TextureRegisterEvent event) {
        ItemListener.CLAY_MUG.setTexture(ModHelper.NAMESPACE.id("item/clay_mug"));
    }
}

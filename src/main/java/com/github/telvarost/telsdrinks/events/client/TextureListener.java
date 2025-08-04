package com.github.telvarost.telsdrinks.events.client;

import com.github.telvarost.telsdrinks.TelsDrinks;
import com.github.telvarost.telsdrinks.events.ItemListener;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.client.event.texture.TextureRegisterEvent;
import net.modificationstation.stationapi.api.client.texture.atlas.Atlases;
import net.modificationstation.stationapi.api.util.Identifier;

public class TextureListener {

    @EventListener
    public void registerTextures(TextureRegisterEvent event) {
        TelsDrinks.APPLE_CAKE_TOP_TEXTURE        = Atlases.getTerrain().addTexture(Identifier.of(TelsDrinks.TELS_DRINKS, "block/apple_cake_top")).index;
        TelsDrinks.APPLE_CAKE_SIDE_TEXTURE       = Atlases.getTerrain().addTexture(Identifier.of(TelsDrinks.TELS_DRINKS, "block/apple_cake_side")).index;
        TelsDrinks.APPLE_CAKE_INSIDE_TEXTURE     = Atlases.getTerrain().addTexture(Identifier.of(TelsDrinks.TELS_DRINKS, "block/apple_cake_inside")).index;
        TelsDrinks.CHOCOLATE_CAKE_TOP_TEXTURE    = Atlases.getTerrain().addTexture(Identifier.of(TelsDrinks.TELS_DRINKS, "block/chocolate_cake_top")).index;
        TelsDrinks.CHOCOLATE_CAKE_SIDE_TEXTURE   = Atlases.getTerrain().addTexture(Identifier.of(TelsDrinks.TELS_DRINKS, "block/chocolate_cake_side")).index;
        TelsDrinks.CHOCOLATE_CAKE_INSIDE_TEXTURE = Atlases.getTerrain().addTexture(Identifier.of(TelsDrinks.TELS_DRINKS, "block/chocolate_cake_inside")).index;
        TelsDrinks.GOLDEN_CAKE_TOP_TEXTURE       = Atlases.getTerrain().addTexture(Identifier.of(TelsDrinks.TELS_DRINKS, "block/golden_cake_top")).index;
        TelsDrinks.GOLDEN_CAKE_SIDE_TEXTURE      = Atlases.getTerrain().addTexture(Identifier.of(TelsDrinks.TELS_DRINKS, "block/golden_cake_side")).index;
        TelsDrinks.GOLDEN_CAKE_INSIDE_TEXTURE    = Atlases.getTerrain().addTexture(Identifier.of(TelsDrinks.TELS_DRINKS, "block/golden_cake_inside")).index;
        TelsDrinks.POISON_CAKE_INSIDE_TEXTURE    = Atlases.getTerrain().addTexture(Identifier.of(TelsDrinks.TELS_DRINKS, "block/poison_cake_inside")).index;

        ItemListener.CLAY_MUG.setTexture(TelsDrinks.TELS_DRINKS.id("item/clay_mug"));
    }
}

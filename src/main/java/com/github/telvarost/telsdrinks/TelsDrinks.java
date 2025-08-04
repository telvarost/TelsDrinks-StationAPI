package com.github.telvarost.telsdrinks;

import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Null;
import net.modificationstation.stationapi.api.util.Namespace;

public class TelsDrinks {
    //public static final Namespace TELS_DRINKS = Namespace.resolve();
    @Entrypoint.Namespace
    public static Namespace TELS_DRINKS = Null.get();

    public static int APPLE_CAKE_TOP_TEXTURE = 0;
    public static int APPLE_CAKE_SIDE_TEXTURE = 0;
    public static int APPLE_CAKE_INSIDE_TEXTURE = 0;
    public static int CHOCOLATE_CAKE_TOP_TEXTURE = 0;
    public static int CHOCOLATE_CAKE_SIDE_TEXTURE = 0;
    public static int CHOCOLATE_CAKE_INSIDE_TEXTURE = 0;
    public static int GOLDEN_CAKE_TOP_TEXTURE = 0;
    public static int GOLDEN_CAKE_SIDE_TEXTURE = 0;
    public static int GOLDEN_CAKE_INSIDE_TEXTURE = 0;
    public static int POISON_CAKE_INSIDE_TEXTURE = 0;

    public static class ModHelperFields {
    }
}

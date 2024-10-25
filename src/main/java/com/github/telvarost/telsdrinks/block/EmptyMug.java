package com.github.telvarost.telsdrinks.block;

import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.block.BlockState;
import net.modificationstation.stationapi.api.item.ItemPlacementContext;
import net.modificationstation.stationapi.api.state.property.BooleanProperty;
import net.modificationstation.stationapi.api.state.property.Property;
import net.modificationstation.stationapi.api.util.Identifier;

public class EmptyMug extends Mug {

    public static final Property<Boolean> EMPTY = BooleanProperty.of("empty");
    private final float MUG_WIDTH = 0.0625F * 5;
    private final float MUG_HEIGHT = 0.5F - 0.0625F;

    public EmptyMug(Identifier identifier, Material material) {
        super(identifier, material);
        setBoundingBox(MUG_WIDTH, 0.0F, MUG_WIDTH, 1.0F - MUG_WIDTH, MUG_HEIGHT, 1.0F - MUG_WIDTH);
        setDefaultState(getDefaultState().with(EMPTY, true));
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return getDefaultState().with(EMPTY, true);
    }
}

package com.github.telvarost.telsdrinks.block;

import com.github.telvarost.telsdrinks.item.EmptyMugBlockItem;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.block.HasCustomBlockItemFactory;
import net.modificationstation.stationapi.api.util.Identifier;

@HasCustomBlockItemFactory(EmptyMugBlockItem.class)
public class EmptyMug extends Mug {
    public EmptyMug(Identifier identifier, Material material) {
        super(identifier, material);
    }
}

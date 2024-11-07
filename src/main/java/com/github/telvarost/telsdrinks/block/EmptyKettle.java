package com.github.telvarost.telsdrinks.block;

import com.github.telvarost.telsdrinks.item.KettleBlockItem;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.block.HasCustomBlockItemFactory;
import net.modificationstation.stationapi.api.util.Identifier;

@HasCustomBlockItemFactory(KettleBlockItem.class)
public class EmptyKettle extends Kettle {
    public EmptyKettle(Identifier identifier, Material material) {
        super(identifier, material);
    }

    @Override
    protected int getDroppedItemMeta(int blockMeta) {
        return 0;
    }
}

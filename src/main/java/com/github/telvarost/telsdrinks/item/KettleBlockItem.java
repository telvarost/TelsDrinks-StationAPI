package com.github.telvarost.telsdrinks.item;

import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.client.item.CustomTooltipProvider;
import net.modificationstation.stationapi.api.template.item.TemplateBlockItem;

public class KettleBlockItem extends TemplateBlockItem implements CustomTooltipProvider {
    public KettleBlockItem(int i) {
        super(i);
        setMaxCount(1);
    }

    @Override
    public String[] getTooltip(ItemStack itemInstance, String originalTooltip) {
        return new String[]{originalTooltip};
    }

    @Override
    public int getPlacementMetadata(int meta) {
        return meta;
    }

    @Override
    public int getMaxDamage() {
        return 5;
    }
}
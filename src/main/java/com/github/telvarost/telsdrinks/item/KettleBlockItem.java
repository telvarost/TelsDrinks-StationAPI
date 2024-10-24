package com.github.telvarost.telsdrinks.item;

import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.client.item.CustomTooltipProvider;
import net.modificationstation.stationapi.api.template.item.TemplateBlockItem;

public class KettleBlockItem extends TemplateBlockItem implements CustomTooltipProvider {
    public KettleBlockItem(int i) {
        super(i);
    }

    @Override
    public String[] getTooltip(ItemStack itemInstance, String originalTooltip) {
        return new String[]{originalTooltip + " Block Item"};
    }
}
package com.github.telvarost.telsdrinks.item;

import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.client.item.CustomTooltipProvider;
import net.modificationstation.stationapi.api.template.item.TemplateItem;

public class ClayMug extends TemplateItem implements CustomTooltipProvider {
    public ClayMug(int i) {
        super(i);
    }

    @Override
    public String[] getTooltip(ItemStack itemInstance, String originalTooltip) {
        return new String[]{originalTooltip + " Block Item"};
    }
}

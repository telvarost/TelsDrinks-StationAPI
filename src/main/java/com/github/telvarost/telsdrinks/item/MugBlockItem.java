package com.github.telvarost.telsdrinks.item;

import com.github.telvarost.telsdrinks.block.Kettle;
import com.github.telvarost.telsdrinks.blockentity.KettleBlockEntity;
import com.github.telvarost.telsdrinks.events.BlockListener;
import com.github.telvarost.telsdrinks.events.ItemListener;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.client.item.CustomTooltipProvider;
import net.modificationstation.stationapi.api.template.item.TemplateBlockItem;

public class MugBlockItem extends TemplateBlockItem implements CustomTooltipProvider {
    public MugBlockItem(int i) {
        super(i);
        setHasSubtypes(true);
        setMaxCount(1);
    }

    @Override
    public ItemStack use(ItemStack stack, World world, PlayerEntity user) {
        if (stack.itemId == BlockListener.CUP_OF_WATER.asItem().id) {
            // no healing
        }
        if (stack.itemId == BlockListener.CUP_OF_MILK.asItem().id) {
            if (stack.getDamage() == 1) {
                user.heal(0);
            } else {
                user.heal(1);
            }
        }
        if (stack.itemId == BlockListener.POISON.asItem().id) {
            user.heal(-1);
        }
        if (stack.itemId == BlockListener.APPLE_CIDER.asItem().id) {
            if (stack.getDamage() == 1) {
                user.heal(1);
            } else {
                user.heal(2);
            }
        }
        if (stack.itemId == BlockListener.BITTER_WATER.asItem().id) {
            if (stack.getDamage() == 1) {
                user.heal(0);
            } else {
                user.heal(1);
            }
        }

        return new ItemStack(BlockListener.EMPTY_MUG.asItem(), 1, 1);
    }

    @Override
    public String[] getTooltip(ItemStack stack, String originalTooltip) {
        if (stack.itemId == BlockListener.CUP_OF_WATER.asItem().id) {
            if (stack.getDamage() == 0) {
                return new String[]{ "Cup of Water" };
            }
            if (stack.getDamage() == 1) {
                return new String[]{ "Hot Water" };
            }
        }
        if (stack.itemId == BlockListener.CUP_OF_MILK.asItem().id) {
            if (stack.getDamage() == 0) {
                return new String[]{ "Cup of Milk" };
            }
            if (stack.getDamage() == 1) {
                return new String[]{ "Steamed Milk" };
            }
        }
        if (stack.itemId == BlockListener.POISON.asItem().id) {
            return new String[]{ "Poison" };
        }
        if (stack.itemId == BlockListener.APPLE_CIDER.asItem().id) {
            if (stack.getDamage() == 0) {
                return new String[]{ "Apple Cider" };
            }
            if (stack.getDamage() == 1) {
                return new String[]{ "Hot Cider" };
            }
        }
        if (stack.itemId == BlockListener.BITTER_WATER.asItem().id) {
            if (stack.getDamage() == 0) {
                return new String[]{ "Bitter Water" };
            }
            if (stack.getDamage() == 1) {
                return new String[]{ "Hot Cocoa" };
            }
        }
        return new String[]{ originalTooltip };
    }
}

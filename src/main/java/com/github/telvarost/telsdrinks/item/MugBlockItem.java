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
        } else if (stack.itemId == BlockListener.CUP_OF_MILK.asItem().id) {
            if (stack.getDamage() == 1) {
                user.heal(0);
            } else {
                user.heal(1);
            }
        } else if (stack.itemId == BlockListener.POISON.asItem().id) {
            user.heal(-1);
        } else if (stack.itemId == BlockListener.APPLE_CIDER.asItem().id) {
            if (stack.getDamage() == 1) {
                user.heal(1);
            } else {
                user.heal(2);
            }
        } else if (stack.itemId == BlockListener.BITTER_WATER.asItem().id) {
            if (stack.getDamage() == 1) {
                user.heal(0);
            } else {
                user.heal(1);
            }
        } else if (stack.itemId == BlockListener.HOT_CHOCOLATE.asItem().id) {
            user.heal(2);
        } else if (stack.itemId == BlockListener.LATTE.asItem().id) {
            user.heal(3);
        } else if (stack.itemId == BlockListener.MOCHA.asItem().id) {
            user.heal(4);
        } else if (stack.itemId == BlockListener.PUMPKIN_SPICE_LATTE.asItem().id) {
            user.heal(6);
        } else if (stack.itemId == BlockListener.DANDELION_TEA.asItem().id) {
            user.heal(1);
        } else if (stack.itemId == BlockListener.ROSE_TEA.asItem().id) {
            user.heal(1);
        }

        return new ItemStack(BlockListener.EMPTY_MUG.asItem(), 1, 1);
    }

    @Override
    public String[] getTooltip(ItemStack stack, String originalTooltip) {
        if (stack.itemId == BlockListener.CUP_OF_WATER.asItem().id) {
            if (stack.getDamage() == 1) {
                return new String[]{ "Hot Water" };
            }
        } else if (stack.itemId == BlockListener.CUP_OF_MILK.asItem().id) {
            if (stack.getDamage() == 1) {
                return new String[]{ "Steamed Milk" };
            }
        } else if (stack.itemId == BlockListener.POISON.asItem().id) {
            return new String[]{originalTooltip};
        } else if (stack.itemId == BlockListener.APPLE_CIDER.asItem().id) {
            if (stack.getDamage() == 1) {
                return new String[]{ "Hot Cider" };
            }
        } else if (stack.itemId == BlockListener.BITTER_WATER.asItem().id) {
            if (stack.getDamage() == 1) {
                return new String[]{ "Hot Cocoa" };
            }
        }

        return new String[]{ originalTooltip };
    }
}

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

    public boolean fill(int KettleID, ItemStack stack, PlayerEntity user, World world, int id, boolean heat, int x, int y, int z, Item result) {
        if (id == KettleID) {
            if (((KettleBlockEntity) world.getBlockEntity(x,y,z)).takeLiquidOut()) {
                if (heat)
                    if (stack.count == 1) {
                        user.inventory.main[user.inventory.selectedSlot] = new ItemStack(result, 1, 1);
                    } else {
                        user.inventory.addStack(new ItemStack(result, 1, 1));
                        stack.count--;
                    }
                else
                    if (stack.count == 1) {
                        user.inventory.main[user.inventory.selectedSlot] = new ItemStack(result, 1, 0);
                    } else {
                        user.inventory.addStack(new ItemStack(result, 1, 0));
                        stack.count--;
                    }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean useOnBlock(ItemStack stack, PlayerEntity user, World world, int x, int y, int z, int side) {


        if (world.getBlockState(x, y, z).getBlock() instanceof Kettle) {
            boolean heat = world.getBlockId(x,y-1,z) == Block.LAVA.id || world.getBlockId(x,y-1,z) == Block.FLOWING_LAVA.id || world.getBlockId(x, y-1, z) == Block.FIRE.id || world.getBlockId(x, y-1, z) == Block.LIT_FURNACE.id;

            int id = world.getBlockId(x,y,z);
            if (fill(BlockListener.WATER_KETTLE.id, stack, user, world, id, heat, x, y, z, BlockListener.CUP_OF_WATER.asItem()))
                return true;
            if (fill(BlockListener.MILK_KETTLE.id, stack, user, world, id, heat, x, y, z, BlockListener.CUP_OF_MILK.asItem()))
                return true;
        }
        return super.useOnBlock(stack, user, world, x, y, z, side);
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
        return new String[]{ originalTooltip };
    }
}

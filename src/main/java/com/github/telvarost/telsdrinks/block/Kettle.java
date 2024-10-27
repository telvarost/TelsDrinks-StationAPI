package com.github.telvarost.telsdrinks.block;

import com.github.telvarost.telsdrinks.blockentity.KettleBlockEntity;
import com.github.telvarost.telsdrinks.events.BlockListener;
import com.github.telvarost.telsdrinks.item.KettleBlockItem;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.block.BlockState;
import net.modificationstation.stationapi.api.block.HasCustomBlockItemFactory;
import net.modificationstation.stationapi.api.item.ItemPlacementContext;
import net.modificationstation.stationapi.api.state.StateManager;
import net.modificationstation.stationapi.api.state.property.Properties;
import net.modificationstation.stationapi.api.template.block.TemplateBlockWithEntity;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.util.math.Direction;

import java.util.Random;

@HasCustomBlockItemFactory(KettleBlockItem.class)
public class Kettle extends TemplateBlockWithEntity {

    private final float MUG_WIDTH = 0.0625F * 3;
    private final float MUG_HEIGHT = 0.5F + 0.0625F;

    public Kettle(Identifier identifier, Material material) {
        super(identifier, material);
        setBoundingBox(MUG_WIDTH, 0.0F + 0.0625F, MUG_WIDTH, 1.0F - MUG_WIDTH, MUG_HEIGHT, 1.0F - MUG_WIDTH);
        setDefaultState(getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
        setHardness(0.5F);
    }

    @Override
    public boolean isOpaque() {
        return false;
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    @Override
    public boolean isSolidFace(BlockView blockView, int x, int y, int z, int i) {
        return false;
    }

    @Override
    public void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.HORIZONTAL_FACING);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        Direction direction = context.getHorizontalPlayerFacing().rotateClockwise(Direction.Axis.Y);

        return getDefaultState().with(Properties.HORIZONTAL_FACING, direction);
    }

    @Override
    protected BlockEntity createBlockEntity() {
        return new KettleBlockEntity();
    }

    @Override
    public int getDroppedItemId(int blockMeta, Random random) {
        return BlockListener.KETTLE.id;
    }

    @Override
    public boolean onUse(World world, int x, int y, int z, PlayerEntity player) {
        int blockId = world.getBlockId(x, y, z);
        ItemStack heldItem = player.inventory.getSelectedItem();
        KettleBlockEntity kettleBlockEntity = (KettleBlockEntity)world.getBlockEntity(x, y, z);

        if (null != heldItem) {
            if (  (  blockId == BlockListener.KETTLE.id
                  || (blockId == BlockListener.WATER_KETTLE.id && kettleBlockEntity.liquidLevel < 5)
                  || kettleBlockEntity.liquidLevel == 0
                  )
               && heldItem.itemId == Item.WATER_BUCKET.id
            ) {
                player.inventory.setStack(player.inventory.selectedSlot, new ItemStack(Item.BUCKET));
                Direction direction = world.getBlockState(x, y, z).get(Properties.HORIZONTAL_FACING);
                world.setBlock(x, y, z, BlockListener.WATER_KETTLE.id);
                BlockState blockState = world.getBlockState(x, y, z);
                world.setBlockState(x, y, z, blockState.with(Properties.HORIZONTAL_FACING, direction));
                return true;
            } else if (  (  blockId == BlockListener.KETTLE.id
                         || (blockId == BlockListener.MILK_KETTLE.id && kettleBlockEntity.liquidLevel < 5)
                         || kettleBlockEntity.liquidLevel == 0
                         )
                      && heldItem.itemId == Item.MILK_BUCKET.id
            ) {
                player.inventory.setStack(player.inventory.selectedSlot, new ItemStack(Item.BUCKET));
                Direction direction =  world.getBlockState(x,y,z).get(Properties.HORIZONTAL_FACING);
                world.setBlock(x, y, z, BlockListener.MILK_KETTLE.id);
                BlockState blockState = world.getBlockState(x, y, z);
                world.setBlockState(x, y, z, blockState.with(Properties.HORIZONTAL_FACING, direction));
                return true;
            } else if (blockId == BlockListener.WATER_KETTLE.id && heldItem.itemId == Item.APPLE.id) {
                if (heldItem.count == 1) {
                    player.inventory.setStack(player.inventory.selectedSlot, null);
                } else {
                    heldItem.count--;
                }
                Direction direction =  world.getBlockState(x,y,z).get(Properties.HORIZONTAL_FACING);
                world.setBlock(x, y, z, BlockListener.APPLE_KETTLE.id);
                BlockState blockState = world.getBlockState(x, y, z);
                world.setBlockState(x, y, z, blockState.with(Properties.HORIZONTAL_FACING, direction));
                return true;
            } else if (blockId == BlockListener.WATER_KETTLE.id && heldItem.itemId == Item.DYE.id && heldItem.getDamage() == 3) {
                if (heldItem.count == 1) {
                    player.inventory.setStack(player.inventory.selectedSlot, null);
                } else {
                    heldItem.count--;
                }
                Direction direction =  world.getBlockState(x,y,z).get(Properties.HORIZONTAL_FACING);
                world.setBlock(x, y, z, BlockListener.BITTER_KETTLE.id);
                BlockState blockState = world.getBlockState(x, y, z);
                world.setBlockState(x, y, z, blockState.with(Properties.HORIZONTAL_FACING, direction));
                return true;
            } else if (blockId == BlockListener.KETTLE.id && heldItem.itemId == Block.CACTUS.asItem().id) {
                if (heldItem.count == 1) {
                    player.inventory.setStack(player.inventory.selectedSlot, null);
                } else {
                    heldItem.count--;
                }
                Direction direction =  world.getBlockState(x,y,z).get(Properties.HORIZONTAL_FACING);
                world.setBlock(x, y, z, BlockListener.POISON_KETTLE.id);
                BlockState blockState = world.getBlockState(x, y, z);
                world.setBlockState(x, y, z, blockState.with(Properties.HORIZONTAL_FACING, direction));
                return true;
            } else if (  heldItem.itemId == Item.BUCKET.id
                      && kettleBlockEntity.liquidLevel == 5
            ) {
                if (blockId == BlockListener.WATER_KETTLE.id) {
                    player.inventory.setStack(player.inventory.selectedSlot, new ItemStack(Item.WATER_BUCKET));
                    kettleBlockEntity.takeLiquidOut();
                    kettleBlockEntity.takeLiquidOut();
                    kettleBlockEntity.takeLiquidOut();
                    return true;
                } else if (blockId == BlockListener.MILK_KETTLE.id) {
                    player.inventory.setStack(player.inventory.selectedSlot, new ItemStack(Item.MILK_BUCKET));
                    kettleBlockEntity.takeLiquidOut();
                    kettleBlockEntity.takeLiquidOut();
                    kettleBlockEntity.takeLiquidOut();
                    return true;
                }
            }
        }

        return false;
    }
}
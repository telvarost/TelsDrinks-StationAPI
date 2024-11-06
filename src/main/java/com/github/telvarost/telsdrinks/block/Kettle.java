package com.github.telvarost.telsdrinks.block;

import com.github.telvarost.telsdrinks.blockentity.KettleBlockEntity;
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

import static com.github.telvarost.telsdrinks.events.BlockListener.*;

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
    protected int getDroppedItemMeta(int blockMeta) {
        return blockMeta;
    }

    @Override
    public boolean onUse(World world, int x, int y, int z, PlayerEntity player) {
        int blockId = world.getBlockId(x, y, z);
        int liquidLevel = (5 - world.getBlockMeta(x, y, z));
        ItemStack heldItem = player.inventory.getSelectedItem();
        KettleBlockEntity kettleBlockEntity = (KettleBlockEntity)world.getBlockEntity(x, y, z);

        if (null != heldItem) {
            if (  (  blockId == KETTLE.id
                  || (blockId == POISON_KETTLE.id && liquidLevel < 5)
                  )
               && heldItem.itemId == Block.CACTUS.asItem().id
            ) {
                if (heldItem.count == 1) {
                    player.inventory.setStack(player.inventory.selectedSlot, null);
                } else {
                    heldItem.count--;
                }
                Direction direction =  world.getBlockState(x,y,z).get(Properties.HORIZONTAL_FACING);
                world.setBlock(x, y, z, POISON_KETTLE.id);
                BlockState blockState = world.getBlockState(x, y, z);
                world.setBlockState(x, y, z, blockState.with(Properties.HORIZONTAL_FACING, direction));
                return true;
            } else if (  (  blockId == KETTLE.id
                         || (blockId == WATER_KETTLE.id && liquidLevel < 5)
                         || (blockId == POISON_KETTLE.id && liquidLevel == 0)
                         )
                      && heldItem.itemId == Item.WATER_BUCKET.id
            ) {
                player.inventory.setStack(player.inventory.selectedSlot, new ItemStack(Item.BUCKET));
                Direction direction = world.getBlockState(x, y, z).get(Properties.HORIZONTAL_FACING);
                world.setBlock(x, y, z, WATER_KETTLE.id);
                BlockState blockState = world.getBlockState(x, y, z);
                world.setBlockState(x, y, z, blockState.with(Properties.HORIZONTAL_FACING, direction));
                return true;
            } else if (  (  blockId == KETTLE.id
                         || (blockId == MILK_KETTLE.id && liquidLevel < 5)
                         || (blockId == POISON_KETTLE.id && liquidLevel == 0)
                         )
                      && heldItem.itemId == Item.MILK_BUCKET.id
            ) {
                player.inventory.setStack(player.inventory.selectedSlot, new ItemStack(Item.BUCKET));
                Direction direction =  world.getBlockState(x,y,z).get(Properties.HORIZONTAL_FACING);
                world.setBlock(x, y, z, MILK_KETTLE.id);
                BlockState blockState = world.getBlockState(x, y, z);
                world.setBlockState(x, y, z, blockState.with(Properties.HORIZONTAL_FACING, direction));
                return true;
            } else if (  blockId == WATER_KETTLE.id
                      && heldItem.itemId == Item.APPLE.id
                      && liquidLevel > 0
            ) {
                if (heldItem.count == 1) {
                    player.inventory.setStack(player.inventory.selectedSlot, null);
                } else {
                    heldItem.count--;
                }
                Direction direction =  world.getBlockState(x,y,z).get(Properties.HORIZONTAL_FACING);
                world.setBlock(x, y, z, APPLE_KETTLE.id);
                BlockState blockState = world.getBlockState(x, y, z);
                world.setBlockState(x, y, z, blockState.with(Properties.HORIZONTAL_FACING, direction));
                world.setBlockMeta(x, y, z, liquidLevel);
                return true;
            } else if (  blockId == WATER_KETTLE.id
                      && heldItem.itemId == Item.DYE.id
                      && heldItem.getDamage() == 3
                      && liquidLevel > 0
            ) {
                if (heldItem.count == 1) {
                    player.inventory.setStack(player.inventory.selectedSlot, null);
                } else {
                    heldItem.count--;
                }
                Direction direction =  world.getBlockState(x,y,z).get(Properties.HORIZONTAL_FACING);
                world.setBlock(x, y, z, BITTER_KETTLE.id);
                BlockState blockState = world.getBlockState(x, y, z);
                world.setBlockState(x, y, z, blockState.with(Properties.HORIZONTAL_FACING, direction));
                world.setBlockMeta(x, y, z, liquidLevel);
                return true;
            } else if (  heldItem.itemId == Item.BUCKET.id
                      && liquidLevel == 5
            ) {
                if (blockId == WATER_KETTLE.id) {
                    player.inventory.setStack(player.inventory.selectedSlot, new ItemStack(Item.WATER_BUCKET));
                    kettleBlockEntity.takeLiquidOut(world, x, y, z, 5);
                    return true;
                } else if (blockId == MILK_KETTLE.id) {
                    player.inventory.setStack(player.inventory.selectedSlot, new ItemStack(Item.MILK_BUCKET));
                    kettleBlockEntity.takeLiquidOut(world, x, y, z, 5);
                    return true;
                }
            } else if (  (blockId == KETTLE.id || blockId == POISON_KETTLE.id)
                      && heldItem.itemId == POISON.id
                      && liquidLevel == 0
            ) {
                player.inventory.setStack(player.inventory.selectedSlot, new ItemStack(EMPTY_MUG.asItem(), 1));
                Direction direction = world.getBlockState(x, y, z).get(Properties.HORIZONTAL_FACING);
                world.setBlock(x, y, z, POISON_KETTLE.id);
                BlockState blockState = world.getBlockState(x, y, z);
                world.setBlockState(x, y, z, blockState.with(Properties.HORIZONTAL_FACING, direction));
                world.setBlockMeta(x, y, z, 4);
                return true;
            } else if (  (blockId == KETTLE.id || blockId == POISON_KETTLE.id)
                      && heldItem.itemId == CUP_OF_WATER.id
                      && liquidLevel == 0
            ) {
                player.inventory.setStack(player.inventory.selectedSlot, new ItemStack(EMPTY_MUG.asItem(), 1));
                Direction direction = world.getBlockState(x, y, z).get(Properties.HORIZONTAL_FACING);
                world.setBlock(x, y, z, WATER_KETTLE.id);
                BlockState blockState = world.getBlockState(x, y, z);
                world.setBlockState(x, y, z, blockState.with(Properties.HORIZONTAL_FACING, direction));
                world.setBlockMeta(x, y, z, 4);
                return true;
            } else if (  (blockId == KETTLE.id || blockId == POISON_KETTLE.id)
                      && heldItem.itemId == CUP_OF_MILK.id
                      && liquidLevel == 0
            ) {
                player.inventory.setStack(player.inventory.selectedSlot, new ItemStack(EMPTY_MUG.asItem(), 1));
                Direction direction = world.getBlockState(x, y, z).get(Properties.HORIZONTAL_FACING);
                world.setBlock(x, y, z, MILK_KETTLE.id);
                BlockState blockState = world.getBlockState(x, y, z);
                world.setBlockState(x, y, z, blockState.with(Properties.HORIZONTAL_FACING, direction));
                world.setBlockMeta(x, y, z, 4);
                return true;
            } else if (  (blockId == KETTLE.id || blockId == POISON_KETTLE.id)
                      && heldItem.itemId == APPLE_CIDER.id
                      && liquidLevel == 0
            ) {
                player.inventory.setStack(player.inventory.selectedSlot, new ItemStack(EMPTY_MUG.asItem(), 1));
                Direction direction = world.getBlockState(x, y, z).get(Properties.HORIZONTAL_FACING);
                world.setBlock(x, y, z, APPLE_KETTLE.id);
                BlockState blockState = world.getBlockState(x, y, z);
                world.setBlockState(x, y, z, blockState.with(Properties.HORIZONTAL_FACING, direction));
                world.setBlockMeta(x, y, z, 4);
                return true;
            } else if (  (blockId == KETTLE.id || blockId == POISON_KETTLE.id)
                      && heldItem.itemId == BITTER_WATER.id
                      && liquidLevel == 0
            ) {
                player.inventory.setStack(player.inventory.selectedSlot, new ItemStack(EMPTY_MUG.asItem(), 1));
                Direction direction = world.getBlockState(x, y, z).get(Properties.HORIZONTAL_FACING);
                world.setBlock(x, y, z, BITTER_KETTLE.id);
                BlockState blockState = world.getBlockState(x, y, z);
                world.setBlockState(x, y, z, blockState.with(Properties.HORIZONTAL_FACING, direction));
                world.setBlockMeta(x, y, z, 4);
                return true;
            }
        } else if (  blockId == KETTLE.id
                  || liquidLevel == 0
        ) {
            Direction direction = world.getBlockState(x, y, z).get(Properties.HORIZONTAL_FACING);
            world.setBlock(x, y, z, KETTLE.id);
            BlockState blockState = world.getBlockState(x, y, z);
            world.setBlockState(x, y, z, blockState.with(Properties.HORIZONTAL_FACING, direction));
            world.setBlockMeta(x, y, z, 5);
            return true;
        }

        return false;
    }
}
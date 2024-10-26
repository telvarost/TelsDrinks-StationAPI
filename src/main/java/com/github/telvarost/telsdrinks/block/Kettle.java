package com.github.telvarost.telsdrinks.block;

import com.github.telvarost.telsdrinks.blockentity.KettleBlockEntity;
import com.github.telvarost.telsdrinks.events.BlockListener;
import com.github.telvarost.telsdrinks.events.ItemListener;
import com.github.telvarost.telsdrinks.item.KettleBlockItem;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.material.Material;
import net.minecraft.world.BlockView;
import net.modificationstation.stationapi.api.block.BlockState;
import net.modificationstation.stationapi.api.block.HasCustomBlockItemFactory;
import net.modificationstation.stationapi.api.item.ItemPlacementContext;
import net.modificationstation.stationapi.api.state.StateManager;
import net.modificationstation.stationapi.api.state.property.Properties;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
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
        setBoundingBox(MUG_WIDTH, 0.0F, MUG_WIDTH, 1.0F - MUG_WIDTH, MUG_HEIGHT, 1.0F - MUG_WIDTH);
        setDefaultState(getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
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
}
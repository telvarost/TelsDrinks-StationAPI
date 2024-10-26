package com.github.telvarost.telsdrinks.block;

import com.github.telvarost.telsdrinks.item.KettleBlockItem;
import com.github.telvarost.telsdrinks.item.MugBlockItem;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Box;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.block.BlockState;
import net.modificationstation.stationapi.api.block.HasCustomBlockItemFactory;
import net.modificationstation.stationapi.api.item.ItemPlacementContext;
import net.modificationstation.stationapi.api.state.StateManager;
import net.modificationstation.stationapi.api.state.property.BooleanProperty;
import net.modificationstation.stationapi.api.state.property.Property;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

@HasCustomBlockItemFactory(MugBlockItem.class)
public class Mug extends TemplateBlock {

    public static final Property<Boolean> EMPTY = BooleanProperty.of("empty");
    private final float MUG_WIDTH = 0.0625F * 5;
    private final float MUG_HEIGHT = 0.5F - 0.0625F;

    public Mug(Identifier identifier, Material material) {
        super(identifier, material);
        setBoundingBox(MUG_WIDTH, 0.0F, MUG_WIDTH, 1.0F - MUG_WIDTH, MUG_HEIGHT, 1.0F - MUG_WIDTH);
        setDefaultState(getDefaultState().with(EMPTY, true));
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
    public Box getCollisionShape(World world, int x, int y, int z) {
        return Box.createCached((double)((float)x + MUG_WIDTH), (double)y, (double)((float)z + MUG_WIDTH), (double)((float)(x + 1) - MUG_WIDTH), (double)((float)y + (MUG_HEIGHT - 0.0625F)), (double)((float)(z + 1) - MUG_WIDTH));
    }

    @Override
    public void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(EMPTY);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        boolean isSneaking = context.getPlayer().isSneaking();

        return getDefaultState().with(EMPTY, isSneaking);
    }

    @Override
    public boolean canPlaceAt(World world, int x, int y, int z) {
        return world.shouldSuffocate(x, y - 1, z);
    }

    @Override
    public void neighborUpdate(World world, int x, int y, int z, int id) {
        boolean var6 = false;
        if (!world.shouldSuffocate(x, y - 1, z)) {
            var6 = true;
        }

        if (var6) {
            this.dropStacks(world, x, y, z, world.getBlockMeta(x, y, z));
            world.setBlock(x, y, z, 0);
        }
    }
}
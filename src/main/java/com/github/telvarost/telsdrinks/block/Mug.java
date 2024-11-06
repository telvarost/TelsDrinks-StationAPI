package com.github.telvarost.telsdrinks.block;

import com.github.telvarost.telsdrinks.events.BlockListener;
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

    public static final Property<Boolean> HOT = BooleanProperty.of("hot");
    public static final Property<Boolean> UPSIDE_DOWN = BooleanProperty.of("upside_down");
    private final float MUG_WIDTH = 0.0625F * 5;
    private final float MUG_HEIGHT = 0.375F;

    public Mug(Identifier identifier, Material material) {
        super(identifier, material);
        setBoundingBox(MUG_WIDTH, 0.0F, MUG_WIDTH, 1.0F - MUG_WIDTH, MUG_HEIGHT, 1.0F - MUG_WIDTH);
        setDefaultState(getDefaultState().with(UPSIDE_DOWN, true).with(HOT, false));
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
    public Box getCollisionShape(World world, int x, int y, int z) {
        return Box.createCached((double)((float)x + MUG_WIDTH), (double)y, (double)((float)z + MUG_WIDTH), (double)((float)(x + 1) - MUG_WIDTH), (double)((float)y + (MUG_HEIGHT - 0.0625F)), (double)((float)(z + 1) - MUG_WIDTH));
    }

    @Override
    public void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(UPSIDE_DOWN);
        builder.add(HOT);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        boolean isSneaking = context.getPlayer().isSneaking();
        boolean hot = context.getStack().getDamage() == 1;

        return getDefaultState().with(UPSIDE_DOWN, isSneaking).with(HOT, hot);
    }

    @Override
    public boolean canPlaceAt(World world, int x, int y, int z) {
        return canPlaceOn(world, x, y - 1, z);
    }

//    @Override
//    public void neighborUpdate(World world, int x, int y, int z, int id) {
//        boolean var6 = false;
//        if (!world.shouldSuffocate(x, y - 1, z)) {
//            var6 = true;
//        }
//
//        if (var6) {
//            this.dropStacks(world, x, y, z, world.getBlockMeta(x, y, z));
//            world.setBlock(x, y, z, 0);
//        }
//    }

    @Override
    public void neighborUpdate(World world, int x, int y, int z, int id) {
        if (this.breakIfCannotPlaceAt(world, x, y, z)) {
            int var6 = world.getBlockMeta(x, y, z);
            boolean var7 = false;
            if (!world.shouldSuffocate(x - 1, y, z) && var6 == 1) {
                var7 = true;
            }

            if (!world.shouldSuffocate(x + 1, y, z) && var6 == 2) {
                var7 = true;
            }

            if (!world.shouldSuffocate(x, y, z - 1) && var6 == 3) {
                var7 = true;
            }

            if (!world.shouldSuffocate(x, y, z + 1) && var6 == 4) {
                var7 = true;
            }

            if (!this.canPlaceOn(world, x, y - 1, z) && var6 == 5) {
                var7 = true;
            }

            if (var7) {
                this.dropStacks(world, x, y, z, world.getBlockMeta(x, y, z));
                world.setBlock(x, y, z, 0);
            }
        }

    }

    private boolean breakIfCannotPlaceAt(World world, int x, int y, int z) {
        if (!this.canPlaceAt(world, x, y, z)) {
            this.dropStacks(world, x, y, z, world.getBlockMeta(x, y, z));
            world.setBlock(x, y, z, 0);
            return false;
        } else {
            return true;
        }
    }

    private boolean canPlaceOn(World world, int x, int y, int z) {
        return world.shouldSuffocate(x, y, z) || world.getBlockId(x, y, z) == Block.FENCE.id;
    }

    // workaround stapi bug
    private static int hot = 0;

    @Override
    public void onBlockBreakStart(World world, int x, int y, int z, PlayerEntity player) {
        super.onBlockBreakStart(world, x, y, z, player);
        hot = world.getBlockState(x,y,z).get(HOT) ? 1 : 0;
    }

    @Override
    protected int getDroppedItemMeta(int blockMeta) {
        return hot;
    }
    // end workaround

    @Override
    public boolean onUse(World world, int x, int y, int z, PlayerEntity player) {
        int blockId = world.getBlockId(x, y, z);
        int heatValue = world.getBlockState(x,y,z).get(HOT) ? 1 : 0;

        if (blockId == BlockListener.CUP_OF_WATER.id) {
            drink(world, x, y, z, player, 0);
            return true;
        } else if (blockId == BlockListener.CUP_OF_MILK.id) {
            if (heatValue == 1) {
                drink(world, x, y, z, player, 1);
            } else {
                drink(world, x, y, z, player, 0);
            }
            return true;
        } else if (blockId == BlockListener.POISON.id) {
            drink(world, x, y, z, player, -1);
            return true;
        } else if (blockId == BlockListener.APPLE_CIDER.id) {
            if (heatValue == 1) {
                drink(world, x, y, z, player, 2);
            } else {
                drink(world, x, y, z, player, 1);
            }
            return true;
        } else if (blockId == BlockListener.BITTER_WATER.id) {
            if (heatValue == 1) {
                drink(world, x, y, z, player, 1);
            } else {
                drink(world, x, y, z, player, 0);
            }
            return true;
        } else if (blockId == BlockListener.HOT_CHOCOLATE.id) {
            drink(world, x, y, z, player, 2);
            return true;
        } else if (blockId == BlockListener.LATTE.id) {
            drink(world, x, y, z, player, 3);
            return true;
        } else if (blockId == BlockListener.MOCHA.id) {
            drink(world, x, y, z, player, 4);
            return true;
        } else if (blockId == BlockListener.PUMPKIN_SPICE_LATTE.id) {
            drink(world, x, y, z, player, 6);
            return true;
        } else if (blockId == BlockListener.DANDELION_TEA.id) {
            drink(world, x, y, z, player, 1);
            return true;
        } else if (blockId == BlockListener.ROSE_TEA.id) {
            drink(world, x, y, z, player, 1);
            return true;
        }

        return false;
    }

    private void drink(World world, int x, int y, int z, PlayerEntity player, int healAmount) {
        if (0 > healAmount) {
            player.damage(null, (healAmount * -1));
        } else {
            player.heal(healAmount);
        }
        world.playSound(player.x, player.y, player.z, "telsdrinks:drink", 1.0F, 1.0F);
        world.setBlock(x, y, z, BlockListener.EMPTY_MUG.id, 0);
    }
}
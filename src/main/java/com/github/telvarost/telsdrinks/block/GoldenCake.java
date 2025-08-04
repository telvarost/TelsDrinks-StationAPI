package com.github.telvarost.telsdrinks.block;

import com.github.telvarost.telsdrinks.TelsDrinks;
import com.github.telvarost.telsdrinks.item.CakeBlockItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.block.HasCustomBlockItemFactory;
import net.modificationstation.stationapi.api.template.block.TemplateCakeBlock;
import net.modificationstation.stationapi.api.util.Identifier;

@HasCustomBlockItemFactory(CakeBlockItem.class)
public class GoldenCake extends TemplateCakeBlock {
    public GoldenCake(Identifier identifier, int texture) {
        super(identifier, texture);
    }

    @Override
    public int getTexture(int side, int meta) {
        if (side == 1) {
            return TelsDrinks.GOLDEN_CAKE_TOP_TEXTURE;
        } else if (side == 0) {
            return this.textureId + 3;
        } else {
            return meta > 0 && side == 4 ? TelsDrinks.GOLDEN_CAKE_INSIDE_TEXTURE : TelsDrinks.GOLDEN_CAKE_SIDE_TEXTURE;
        }
    }

    @Override
    public int getTexture(int side) {
        if (side == 1) {
            return TelsDrinks.GOLDEN_CAKE_TOP_TEXTURE;
        } else {
            return side == 0 ? this.textureId + 3 : TelsDrinks.GOLDEN_CAKE_SIDE_TEXTURE;
        }
    }

    @Override
    public boolean onUse(World world, int x, int y, int z, PlayerEntity player) {
        this.tryEat(world, x, y, z, player);
        return true;
    }

    @Override
    public void onBlockBreakStart(World world, int x, int y, int z, PlayerEntity player) {
        this.tryEat(world, x, y, z, player);
    }

    private void tryEat(World world, int x, int y, int z, PlayerEntity player) {
        if (player.health < 20) {
            player.heal(6);
            int var6 = world.getBlockMeta(x, y, z) + 1;
            if (var6 >= 6) {
                world.setBlock(x, y, z, 0);
            } else {
                world.setBlockMeta(x, y, z, var6);
                world.setBlockDirty(x, y, z);
            }
        }
    }
}

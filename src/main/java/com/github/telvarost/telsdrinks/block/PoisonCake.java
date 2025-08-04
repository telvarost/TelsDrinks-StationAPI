package com.github.telvarost.telsdrinks.block;

import com.github.telvarost.telsdrinks.TelsDrinks;
import com.github.telvarost.telsdrinks.item.CakeBlockItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.block.HasCustomBlockItemFactory;
import net.modificationstation.stationapi.api.template.block.TemplateCakeBlock;
import net.modificationstation.stationapi.api.util.Identifier;

@HasCustomBlockItemFactory(CakeBlockItem.class)
public class PoisonCake extends TemplateCakeBlock {
    public PoisonCake(Identifier identifier, int texture) {
        super(identifier, texture);
    }

    @Override
    public int getTexture(int side, int meta) {
        if (side == 1) {
            return this.textureId;
        } else if (side == 0) {
            return this.textureId + 3;
        } else {
            return meta > 0 && side == 4 ? TelsDrinks.POISON_CAKE_INSIDE_TEXTURE : this.textureId + 1;
        }
    }

    @Override
    public int getTexture(int side) {
        if (side == 1) {
            return this.textureId;
        } else {
            return side == 0 ? this.textureId + 3 : this.textureId + 1;
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
        player.damage(null, 3);
        int var6 = world.getBlockMeta(x, y, z) + 1;
        if (var6 >= 6) {
            world.setBlock(x, y, z, 0);
        } else {
            world.setBlockMeta(x, y, z, var6);
            world.setBlockDirty(x, y, z);
        }
    }
}

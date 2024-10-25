package com.github.telvarost.telsdrinks.blockentity;

import com.github.telvarost.telsdrinks.block.Kettle;
import net.minecraft.block.entity.BlockEntity;
import net.modificationstation.stationapi.api.block.BlockState;
import net.modificationstation.stationapi.api.state.property.Properties;
import net.modificationstation.stationapi.api.util.math.Direction;


public class KettleBlockEntity extends BlockEntity {
    public boolean dirXSet = false;
    public boolean dirX = false;

    public KettleBlockEntity() {

    }

    @Override
    public void tick() {
        if (!dirXSet) {
            if (world != null) {
                Direction dir = world.getBlockState(x, y, z).get(Properties.HORIZONTAL_FACING);
                if (dir == Direction.EAST || dir == Direction.WEST) {
                    dirX = true;
                    dirXSet = true;
                }
            }
        }
        super.tick();
    }
}

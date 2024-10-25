package com.github.telvarost.telsdrinks.blockentity;

import com.github.telvarost.telsdrinks.events.BlockListener;
import net.minecraft.block.entity.BlockEntity;
import net.modificationstation.stationapi.api.state.property.Properties;
import net.modificationstation.stationapi.api.util.math.Direction;


public class KettleBlockEntity extends BlockEntity {
    public boolean initialized = false;
    public boolean dirX = false;

    public int liquidHorizontalOffset = 0;

    public int tempTickCounter = 0;
    public int liquidLevel = 0;

    public KettleBlockEntity() {

    }

    @Override
    public void tick() {
        if (!initialized) {
            if (world != null) {
                Direction dir = world.getBlockState(x, y, z).get(Properties.HORIZONTAL_FACING);
                if (dir == Direction.EAST || dir == Direction.WEST) {
                    dirX = true;
                }

                final int poison = BlockListener.KETTLE.id;
                final int water = BlockListener.WATER_KETTLE.id;
                final int milk = BlockListener.MILK_KETTLE.id;
                final int bitter = BlockListener.BITTER_KETTLE.id;
                final int apple = BlockListener.APPLE_KETTLE.id;

                int blockId = world.getBlockId(x,y,z);

                if (blockId == poison) {
                    liquidHorizontalOffset = 0;
                }
                if (blockId == water) {
                    liquidHorizontalOffset = 2;
                }
                if (blockId == milk) {
                    liquidHorizontalOffset = 4;
                }
                if (blockId == bitter) {
                    liquidHorizontalOffset = 6;
                }
                if (blockId == apple) {
                    liquidHorizontalOffset = 8;
                }

                initialized = true;
            }
        }

        tempTickCounter++;
        if (tempTickCounter > 40) {
            liquidLevel++;
            if (liquidLevel > 5) {
                liquidLevel = 0;
            }
            tempTickCounter = 0;
        }


        super.tick();
    }
}

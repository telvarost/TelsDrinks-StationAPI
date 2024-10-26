package com.github.telvarost.telsdrinks.blockentity;

import com.github.telvarost.telsdrinks.events.BlockListener;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.modificationstation.stationapi.api.block.BlockState;
import net.modificationstation.stationapi.api.state.property.Properties;
import net.modificationstation.stationapi.api.util.math.Direction;


public class KettleBlockEntity extends BlockEntity {
    public boolean initialized = false;
    public boolean dirX = false;

    public int liquidHorizontalOffset = 0;

    public int liquidLevel = 5;

    public KettleBlockEntity() {

    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        if (nbt.contains("liquidLevel"))
            this.liquidLevel = nbt.getInt("liquidLevel");
        else
            this.liquidLevel = 0;
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        if (liquidLevel > 0)
            nbt.putInt("liquidLevel", liquidLevel);
    }

    public boolean takeLiquidOut() {
        if (liquidLevel > 0)  {
            liquidLevel -= 2;
            if (liquidLevel < 0) {
                liquidLevel = 0;
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean putLiquidIn() {
        if (liquidLevel < 5)  {
            if (liquidLevel > 0) {
                liquidLevel += 1;
            }
            liquidLevel += 1;
            if (liquidLevel > 5) {
                liquidLevel = 5;
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void tick() {
        if (!initialized) {
            if (world != null) {
                BlockState state = world.getBlockState(x, y, z);
                Direction dir = state.get(Properties.HORIZONTAL_FACING);
                if (dir == Direction.EAST || dir == Direction.WEST) {
                    dirX = true;
                }

                if (state.getBlock().id == BlockListener.KETTLE.id) {
                    liquidLevel = 0;
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

        super.tick();
    }
}

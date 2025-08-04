package com.github.telvarost.telsdrinks.item;

import com.github.telvarost.telsdrinks.block.Kettle;
import com.github.telvarost.telsdrinks.blockentity.KettleBlockEntity;
import com.github.telvarost.telsdrinks.events.BlockListener;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.hit.HitResultType;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.block.BlockState;
import net.modificationstation.stationapi.api.state.property.Properties;
import net.modificationstation.stationapi.api.template.item.TemplateBlockItem;
import net.modificationstation.stationapi.api.util.math.Direction;

import static com.github.telvarost.telsdrinks.events.BlockListener.KETTLE;

public class EmptyMugBlockItem extends TemplateBlockItem {
    public EmptyMugBlockItem(int i) {
        super(i);
    }

    @Override
    public ItemStack use(ItemStack stack, World world, PlayerEntity user) {
        float var4 = 1.0F;
        float var5 = user.prevPitch + (user.pitch - user.prevPitch) * var4;
        float var6 = user.prevYaw + (user.yaw - user.prevYaw) * var4;
        double var7 = user.prevX + (user.x - user.prevX) * (double)var4;
        double var9 = user.prevY + (user.y - user.prevY) * (double)var4 + 1.62 - (double)user.standingEyeHeight;
        double var11 = user.prevZ + (user.z - user.prevZ) * (double)var4;
        Vec3d var13 = Vec3d.createCached(var7, var9, var11);
        float var14 = MathHelper.cos(-var6 * 0.017453292F - 3.1415927F);
        float var15 = MathHelper.sin(-var6 * 0.017453292F - 3.1415927F);
        float var16 = -MathHelper.cos(-var5 * 0.017453292F);
        float var17 = MathHelper.sin(-var5 * 0.017453292F);
        float var18 = var15 * var16;
        float var20 = var14 * var16;
        double var21 = 5.0;
        Vec3d var23 = var13.add((double)var18 * var21, (double)var17 * var21, (double)var20 * var21);
        HitResult var24 = world.raycast(var13, var23, true);
        if (var24 == null) {
            return stack;
        } else {
            if (var24.type == HitResultType.BLOCK) {
                int var25 = var24.blockX;
                int var26 = var24.blockY;
                int var27 = var24.blockZ;
                if (!world.canInteract(user, var25, var26, var27)) {
                    return stack;
                }

                if (world.getMaterial(var25, var26, var27) == Material.WATER && world.getBlockMeta(var25, var26, var27) == 0) {
                    if (stack.count == 1) {
                        return new ItemStack(BlockListener.CUP_OF_WATER.asItem(), 1);
                    } else {
                        user.inventory.addStack(new ItemStack(BlockListener.CUP_OF_WATER.asItem(), 1));
                        stack.count--;
                    }
                }
            } else if (var24.entity instanceof CowEntity) {
                // This does nothing, I copied it from bucket code
                // Buckets and mugs are actually filled with milk by using the CowEntity's interact method
                if (stack.count == 1) {
                    return new ItemStack(BlockListener.CUP_OF_MILK.asItem(), 1);
                } else {
                    user.inventory.addStack(new ItemStack(BlockListener.CUP_OF_MILK.asItem(), 1));
                    stack.count--;
                }
            }

            return stack;
        }
    }

    public boolean fill(int KettleID, ItemStack stack, PlayerEntity user, World world, int id, boolean heat, int x, int y, int z, Item result) {
        if (id == KettleID) {
            if (((KettleBlockEntity) world.getBlockEntity(x,y,z)).takeLiquidOut(world, x, y, z, 2)) {
                if (heat) {
                    if (stack.count == 1) {
                        user.inventory.main[user.inventory.selectedSlot] = new ItemStack(result, 1, 1);
                    } else {
                        user.inventory.addStack(new ItemStack(result, 1, 1));
                        stack.count--;
                    }
                } else {
                    if (stack.count == 1) {
                        user.inventory.main[user.inventory.selectedSlot] = new ItemStack(result, 1, 0);
                    } else {
                        user.inventory.addStack(new ItemStack(result, 1, 0));
                        stack.count--;
                    }
                }

                return true;
            }
        }
        return false;
    }

    @Override
    public boolean useOnBlock(ItemStack stack, PlayerEntity user, World world, int x, int y, int z, int side) {
        if (world.getBlockState(x, y, z).getBlock() instanceof Kettle) {
            boolean heat = world.getBlockId(x,y-1,z) == Block.LAVA.id || world.getBlockId(x,y-1,z) == Block.FLOWING_LAVA.id || world.getBlockId(x, y-1, z) == Block.FIRE.id || world.getBlockId(x, y-1, z) == Block.LIT_FURNACE.id;
            int id = world.getBlockId(x,y,z);

            if (fill(BlockListener.WATER_KETTLE.id, stack, user, world, id, heat, x, y, z, BlockListener.CUP_OF_WATER.asItem()))
                return true;
            if (fill(BlockListener.MILK_KETTLE.id, stack, user, world, id, heat, x, y, z, BlockListener.CUP_OF_MILK.asItem()))
                return true;
            if (fill(BlockListener.POISON_KETTLE.id, stack, user, world, id, heat, x, y, z, BlockListener.POISON.asItem()))
                return true;
            if (fill(BlockListener.APPLE_KETTLE.id, stack, user, world, id, heat, x, y, z, BlockListener.APPLE_CIDER.asItem()))
                return true;
            if (fill(BlockListener.ELIXIR_KETTLE.id, stack, user, world, id, heat, x, y, z, BlockListener.ELIXIR.asItem()))
                return true;
            if (fill(BlockListener.BITTER_KETTLE.id, stack, user, world, id, heat, x, y, z, BlockListener.BITTER_WATER.asItem()))
                return true;


            if (fill(BlockListener.LAVA_KETTLE.id, stack, user, world, id, heat, x, y, z, BlockListener.CUP_OF_LAVA.asItem())) {
                if (5 == world.getBlockMeta(x, y, z)) {
                    Direction direction = world.getBlockState(x, y, z).get(Properties.HORIZONTAL_FACING);
                    world.setBlock(x, y, z, KETTLE.id);
                    BlockState blockState = world.getBlockState(x, y, z);
                    world.setBlockState(x, y, z, blockState.with(Properties.HORIZONTAL_FACING, direction));
                    world.setBlockMeta(x, y, z, 5);
                }
                return true;
            }
        }

        return super.useOnBlock(stack, user, world, x, y, z, side);
    }
}

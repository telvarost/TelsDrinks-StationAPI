package com.github.telvarost.telsdrinks.mixin;

import net.minecraft.block.LeavesBlock;
import net.minecraft.block.TransparentBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(LeavesBlock.class)
public abstract class LeavesBlockMixin extends TransparentBlock {

    public LeavesBlockMixin(int i, int j) {
        super(i, j, Material.LEAVES, false);
    }

    @Inject(method = "breakLeaves", at = @At("HEAD"), cancellable = true)
    private void miscTweaks_dropAndRemove(World arg, int i, int j, int k, CallbackInfo ci) {
//        if (0 >= Config.config.appleDropChance) {
//            return;
//        }

        /** - Special drop logic */
        int l = arg.getBlockMeta(i, j, k);
        miscTweaks_rareAppleDrop(arg, i, j, k, (l & 3));
    }

    @Inject(method = "afterBreak", at = @At("HEAD"), cancellable = true)
    public void miscTweaks_afterBreak(World arg, PlayerEntity arg2, int i, int j, int k, int l, CallbackInfo ci) {
//        if (0 >= Config.config.appleDropChance) {
//            return;
//        }

        if (!arg.isRemote && arg2.getHand() != null && arg2.getHand().itemId == Item.SHEARS.id) {
            /** - Do nothing */
        } else {
            /** - Special drop logic */
            miscTweaks_rareAppleDrop(arg, i, j, k, (l & 3));
        }
    }

    @Unique
    private void miscTweaks_rareAppleDrop(World world, int x, int y, int z, int leafType) {
        if (0 == leafType) {
            Random random = new Random();
            //boolean isSomethingDropped = (random.nextInt(1000/Config.config.appleDropChance) == 0) ? true : false;
            boolean isSomethingDropped = (random.nextInt(1000/5) == 0) ? true : false;

            if (isSomethingDropped) {
                Biome biome = world.method_1781().getBiome(x, z);

                if (biome == Biome.RAINFOREST) {
                    ItemStack arg2 = new ItemStack(Item.DYE, 1, 3);

                    if (!world.isRemote) {
                        float var6 = 0.7F;
                        double var7 = (double) (world.random.nextFloat() * var6) + (double) (1.0F - var6) * 0.5;
                        double var9 = (double) (world.random.nextFloat() * var6) + (double) (1.0F - var6) * 0.5;
                        double var11 = (double) (world.random.nextFloat() * var6) + (double) (1.0F - var6) * 0.5;
                        ItemEntity var13 = new ItemEntity(world, (double) x + var7, (double) y + var9, (double) z + var11, arg2);
                        var13.pickupDelay = 10;
                        world.spawnEntity(var13);
                    }
                } else if (biome == Biome.SEASONAL_FOREST) {
                    ItemStack arg2 = new ItemStack(Item.APPLE);

                    if (!world.isRemote) {
                        float var6 = 0.7F;
                        double var7 = (double) (world.random.nextFloat() * var6) + (double) (1.0F - var6) * 0.5;
                        double var9 = (double) (world.random.nextFloat() * var6) + (double) (1.0F - var6) * 0.5;
                        double var11 = (double) (world.random.nextFloat() * var6) + (double) (1.0F - var6) * 0.5;
                        ItemEntity var13 = new ItemEntity(world, (double) x + var7, (double) y + var9, (double) z + var11, arg2);
                        var13.pickupDelay = 10;
                        world.spawnEntity(var13);
                    }
                } else if (biome == Biome.FOREST) {
                    boolean isAppleDropped = (random.nextInt(2) == 0) ? true : false;
                    if (isAppleDropped) {
                        ItemStack arg2 = new ItemStack(Item.APPLE);

                        if (!world.isRemote) {
                            float var6 = 0.7F;
                            double var7 = (double) (world.random.nextFloat() * var6) + (double) (1.0F - var6) * 0.5;
                            double var9 = (double) (world.random.nextFloat() * var6) + (double) (1.0F - var6) * 0.5;
                            double var11 = (double) (world.random.nextFloat() * var6) + (double) (1.0F - var6) * 0.5;
                            ItemEntity var13 = new ItemEntity(world, (double) x + var7, (double) y + var9, (double) z + var11, arg2);
                            var13.pickupDelay = 10;
                            world.spawnEntity(var13);
                        }
                    }
                } else {
                    ItemStack arg2 = new ItemStack(Item.STICK);

                    if (!world.isRemote) {
                        float var6 = 0.7F;
                        double var7 = (double) (world.random.nextFloat() * var6) + (double) (1.0F - var6) * 0.5;
                        double var9 = (double) (world.random.nextFloat() * var6) + (double) (1.0F - var6) * 0.5;
                        double var11 = (double) (world.random.nextFloat() * var6) + (double) (1.0F - var6) * 0.5;
                        ItemEntity var13 = new ItemEntity(world, (double) x + var7, (double) y + var9, (double) z + var11, arg2);
                        var13.pickupDelay = 10;
                        world.spawnEntity(var13);
                    }
                }
            }
        }
    }

}

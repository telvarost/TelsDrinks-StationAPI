package com.github.telvarost.telsdrinks.item;

import com.github.telvarost.telsdrinks.block.Kettle;
import com.github.telvarost.telsdrinks.blockentity.KettleBlockEntity;
import com.github.telvarost.telsdrinks.events.BlockListener;
import net.minecraft.client.resource.language.TranslationStorage;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.client.item.CustomTooltipProvider;
import net.modificationstation.stationapi.api.template.item.TemplateBlockItem;

public class MugBlockItem extends TemplateBlockItem implements CustomTooltipProvider {
    public MugBlockItem(int i) {
        super(i);
        setHasSubtypes(true);
        setMaxCount(1);
    }

    @Override
    public ItemStack use(ItemStack stack, World world, PlayerEntity user) {
        world.playSound(user.x, user.y, user.z, "telsdrinks:drink", 1.0F, 1.0F);

        if (stack.itemId == BlockListener.CUP_OF_WATER.asItem().id) {
            // no healing
        } else if (stack.itemId == BlockListener.CUP_OF_LAVA.asItem().id) {
            user.damage(null, 4);
            user.fireTicks = 600;
        } else if (stack.itemId == BlockListener.CUP_OF_MILK.asItem().id) {
            if (stack.getDamage() == 1) {
                user.heal(1);
            } else {
                user.heal(0);
            }
        } else if (stack.itemId == BlockListener.POISON.asItem().id) {
            user.damage(null, 1);
        } else if (stack.itemId == BlockListener.TOXIC_SLUDGE.asItem().id) {
            user.damage(null, 7);
        } else if (stack.itemId == BlockListener.APPLE_CIDER.asItem().id) {
            if (stack.getDamage() == 1) {
                user.heal(2);
            } else {
                user.heal(1);
            }
        } else if (stack.itemId == BlockListener.ELIXIR.asItem().id) {
            user.heal(14);
        } else if (stack.itemId == BlockListener.ANGELIC_ELIXIR.asItem().id) {
            user.heal(15);
            user.fireTicks = 0;
            user.air = 300;
            user.fallDistance = 0.0F;
        } else if (stack.itemId == BlockListener.BITTER_WATER.asItem().id) {
            if (stack.getDamage() == 1) {
                user.heal(1);
            } else {
                user.heal(0);
            }
        } else if (stack.itemId == BlockListener.HOT_CHOCOLATE.asItem().id) {
            user.heal(2);
        } else if (stack.itemId == BlockListener.LATTE.asItem().id) {
            user.heal(3);
        } else if (stack.itemId == BlockListener.MOCHA.asItem().id) {
            user.heal(4);
        } else if (stack.itemId == BlockListener.PUMPKIN_SPICE_LATTE.asItem().id) {
            user.heal(6);
        } else if (stack.itemId == BlockListener.DANDELION_TEA.asItem().id) {
            user.heal(1);
        } else if (stack.itemId == BlockListener.ROSE_TEA.asItem().id) {
            user.heal(1);
        } else if (stack.itemId == BlockListener.FAIRY_TEA.asItem().id) {
            user.heal(5);
            user.fireTicks = 0;
        }

        return new ItemStack(BlockListener.EMPTY_MUG.asItem(), 1, 1);
    }

    @Override
    public boolean useOnBlock(ItemStack stack, PlayerEntity user, World world, int x, int y, int z, int side) {
        if (world.getBlockState(x, y, z).getBlock() instanceof Kettle) {
            int id = world.getBlockId(x,y,z);
            int meta = world.getBlockMeta(x, y, z);

            if (0 != meta) {
                if (stack.itemId == BlockListener.CUP_OF_WATER.asItem().id && id == BlockListener.WATER_KETTLE.id) {
                    KettleBlockEntity kettleBlockEntity = (KettleBlockEntity) world.getBlockEntity(x, y, z);
                    kettleBlockEntity.putLiquidIn(world, x, y, z, 2);
                    user.inventory.main[user.inventory.selectedSlot] = new ItemStack(BlockListener.EMPTY_MUG.asItem(), 1);
                    return true;
                } else if (stack.itemId == BlockListener.CUP_OF_LAVA.asItem().id && id == BlockListener.LAVA_KETTLE.id) {
                    KettleBlockEntity kettleBlockEntity = (KettleBlockEntity) world.getBlockEntity(x, y, z);
                    kettleBlockEntity.putLiquidIn(world, x, y, z, 2);
                    user.inventory.main[user.inventory.selectedSlot] = new ItemStack(BlockListener.EMPTY_MUG.asItem(), 1);
                    return true;
                } else if (stack.itemId == BlockListener.CUP_OF_MILK.asItem().id && id == BlockListener.MILK_KETTLE.id) {
                    KettleBlockEntity kettleBlockEntity = (KettleBlockEntity) world.getBlockEntity(x, y, z);
                    kettleBlockEntity.putLiquidIn(world, x, y, z, 2);
                    user.inventory.main[user.inventory.selectedSlot] = new ItemStack(BlockListener.EMPTY_MUG.asItem(), 1);
                    return true;
                } else if (stack.itemId == BlockListener.POISON.asItem().id && id == BlockListener.POISON_KETTLE.id) {
                    KettleBlockEntity kettleBlockEntity = (KettleBlockEntity) world.getBlockEntity(x, y, z);
                    kettleBlockEntity.putLiquidIn(world, x, y, z, 2);
                    user.inventory.main[user.inventory.selectedSlot] = new ItemStack(BlockListener.EMPTY_MUG.asItem(), 1);
                    return true;
                } else if (stack.itemId == BlockListener.APPLE_CIDER.asItem().id && id == BlockListener.APPLE_KETTLE.id) {
                    KettleBlockEntity kettleBlockEntity = (KettleBlockEntity) world.getBlockEntity(x, y, z);
                    kettleBlockEntity.putLiquidIn(world, x, y, z, 2);
                    user.inventory.main[user.inventory.selectedSlot] = new ItemStack(BlockListener.EMPTY_MUG.asItem(), 1);
                    return true;
                } else if (stack.itemId == BlockListener.ELIXIR.asItem().id && id == BlockListener.ELIXIR_KETTLE.id) {
                    KettleBlockEntity kettleBlockEntity = (KettleBlockEntity) world.getBlockEntity(x, y, z);
                    kettleBlockEntity.putLiquidIn(world, x, y, z, 2);
                    user.inventory.main[user.inventory.selectedSlot] = new ItemStack(BlockListener.EMPTY_MUG.asItem(), 1);
                    return true;
                } else if (stack.itemId == BlockListener.BITTER_WATER.asItem().id && id == BlockListener.BITTER_KETTLE.id) {
                    KettleBlockEntity kettleBlockEntity = (KettleBlockEntity) world.getBlockEntity(x, y, z);
                    kettleBlockEntity.putLiquidIn(world, x, y, z, 2);
                    user.inventory.main[user.inventory.selectedSlot] = new ItemStack(BlockListener.EMPTY_MUG.asItem(), 1);
                    return true;
                }
            }
        }

        return super.useOnBlock(stack, user, world, x, y, z, side);
    }

    @Override
    public String[] getTooltip(ItemStack stack, String originalTooltip) {
        if (stack.itemId == BlockListener.CUP_OF_WATER.asItem().id) {
            if (stack.getDamage() == 1) {
                return new String[]{ TranslationStorage.getInstance().get("tile.telsdrinks.hot_water.name") };
            }
        } else if (stack.itemId == BlockListener.CUP_OF_MILK.asItem().id) {
            if (stack.getDamage() == 1) {
                return new String[]{ TranslationStorage.getInstance().get("tile.telsdrinks.steamed_milk.name") };
            }
        } else if (stack.itemId == BlockListener.APPLE_CIDER.asItem().id) {
            if (stack.getDamage() == 1) {
                return new String[]{ TranslationStorage.getInstance().get("tile.telsdrinks.hot_cider.name") };
            }
        } else if (stack.itemId == BlockListener.BITTER_WATER.asItem().id) {
            if (stack.getDamage() == 1) {
                return new String[]{ TranslationStorage.getInstance().get("tile.telsdrinks.hot_cocoa.name") };
            }
        }

        return new String[]{ originalTooltip };
    }
}

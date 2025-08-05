package com.github.telvarost.telsdrinks.events;

import com.github.telvarost.telsdrinks.ModHelperOldAndOrnate;
import net.fabricmc.loader.api.FabricLoader;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.event.recipe.RecipeRegisterEvent;
import net.modificationstation.stationapi.api.recipe.CraftingRegistry;
import net.modificationstation.stationapi.api.recipe.SmeltingRegistry;
import net.modificationstation.stationapi.api.util.Identifier;

import static com.github.telvarost.telsdrinks.events.BlockListener.*;
import static com.github.telvarost.telsdrinks.events.ItemListener.CLAY_MUG;

public class RecipeListener {

    @EventListener
    public void registerRecipes(RecipeRegisterEvent event) {
        Identifier type = event.recipeId;

        if (type == RecipeRegisterEvent.Vanilla.CRAFTING_SHAPED.type()) {
            /** - Cake crafting recipes */
            CraftingRegistry.addShapedRecipe(new ItemStack(APPLE_CAKE.asItem(), 1), "XYX", "ZCZ", "VVV", 'X', Item.MILK_BUCKET, 'Y', Item.APPLE, 'Z', Item.SUGAR, 'C', Item.EGG, 'V', Item.WHEAT);
            CraftingRegistry.addShapedRecipe(new ItemStack(GOLDEN_CAKE.asItem(), 1), "XYX", "ZCZ", "VVV", 'X', Item.MILK_BUCKET, 'Y', Block.GOLD_BLOCK, 'Z', Item.SUGAR, 'C', Item.EGG, 'V', Item.WHEAT);
            CraftingRegistry.addShapedRecipe(new ItemStack(GOLDEN_CAKE.asItem(), 1), "XXX", "XYX", "XXX", 'X', Item.GOLD_INGOT, 'Y', Item.CAKE);
            CraftingRegistry.addShapedRecipe(new ItemStack(CHOCOLATE_CAKE.asItem(), 1), "XYX", "ZCZ", "VVV", 'X', Item.MILK_BUCKET, 'Y', new ItemStack(Item.DYE, 1, 3), 'Z', Item.SUGAR, 'C', Item.EGG, 'V', Item.WHEAT);
            CraftingRegistry.addShapedRecipe(new ItemStack(POISON_CAKE.asItem(), 1), "XYX", "ZCZ", "VVV", 'X', Item.MILK_BUCKET, 'Y', Block.CACTUS, 'Z', Item.SUGAR, 'C', Item.EGG, 'V', Item.WHEAT);

            /** - Kettle crafting recipes */
            CraftingRegistry.addShapedRecipe(new ItemStack(KETTLE.asItem(), 1), " X ", "X X", "XXX", 'X', Item.IRON_INGOT);
            CraftingRegistry.addShapedRecipe(new ItemStack(POISON_KETTLE.asItem(), 1), " X ", "XYX", "XXX", 'X', Item.IRON_INGOT, 'Y', Block.CACTUS);
            CraftingRegistry.addShapedRecipe(new ItemStack(WATER_KETTLE.asItem(), 1), " X ", "XYX", "XXX", 'X', Item.IRON_INGOT, 'Y', Item.WATER_BUCKET);
            CraftingRegistry.addShapedRecipe(new ItemStack(LAVA_KETTLE.asItem(), 1), " X ", "XYX", "XXX", 'X', Item.IRON_INGOT, 'Y', Item.LAVA_BUCKET);
            CraftingRegistry.addShapedRecipe(new ItemStack(MILK_KETTLE.asItem(), 1), " X ", "XYX", "XXX", 'X', Item.IRON_INGOT, 'Y', Item.MILK_BUCKET);

            /** - Mug crafting recipes */
            CraftingRegistry.addShapedRecipe(new ItemStack(CLAY_MUG.asItem(), 2), "   ", "XXX", " X ", 'X', Item.CLAY);
        }

        if (type == RecipeRegisterEvent.Vanilla.SMELTING.type()) {
            /** - Mug smelting recipes */
            SmeltingRegistry.addSmeltingRecipe(new ItemStack(CLAY_MUG.asItem(), 1), new ItemStack(EMPTY_MUG.asItem(), 1));
        }

        if (type == RecipeRegisterEvent.Vanilla.CRAFTING_SHAPELESS.type()) {
            /** - Drink recipes */
            CraftingRegistry.addShapelessRecipe(new ItemStack(TOXIC_SLUDGE.asItem(), 1), new ItemStack(POISON.asItem(), 1, -1), new ItemStack(Item.DYE, 1, 0), new ItemStack(Item.DYE, 1, 15), Item.GUNPOWDER);
            CraftingRegistry.addShapelessRecipe(new ItemStack(ANGELIC_ELIXIR.asItem(), 1), new ItemStack(ELIXIR.asItem(), 1, -1), Item.FEATHER, Item.SNOWBALL, Item.GOLD_INGOT);
            CraftingRegistry.addShapelessRecipe(new ItemStack(DANDELION_TEA.asItem(), 1), new ItemStack(CUP_OF_WATER.asItem(), 1, 1), Block.DANDELION);
            CraftingRegistry.addShapelessRecipe(new ItemStack(ROSE_TEA.asItem(), 1), new ItemStack(CUP_OF_WATER.asItem(), 1, 1), Block.ROSE);
            CraftingRegistry.addShapelessRecipe(new ItemStack(FAIRY_TEA.asItem(), 1), new ItemStack(CUP_OF_WATER.asItem(), 1, 1), Item.GLOWSTONE_DUST, Block.DANDELION, Block.ROSE);
            CraftingRegistry.addShapelessRecipe(new ItemStack(HOT_CHOCOLATE.asItem(), 1), new ItemStack(BITTER_WATER.asItem(), 1, 1), Item.SUGAR);
            CraftingRegistry.addShapelessRecipe(new ItemStack(LATTE.asItem(), 1), new ItemStack(BITTER_WATER.asItem(), 1, 1), Item.MILK_BUCKET);
            CraftingRegistry.addShapelessRecipe(new ItemStack(MOCHA.asItem(), 1), new ItemStack(BITTER_WATER.asItem(), 1, 1), Item.SUGAR, Item.MILK_BUCKET);

            /** - Compatibility recipes/extra recipes when other mods are loaded */
            if (FabricLoader.getInstance().isModLoaded("oldandornate")) {
                CraftingRegistry.addShapelessRecipe(new ItemStack(FAIRY_TEA.asItem(), 1), new ItemStack(CUP_OF_WATER.asItem(), 1, 1), ModHelperOldAndOrnate.getOldAndOrnateStarFlowerBlock(), Block.ROSE);
            }
            /** - Added by JSON file(s) */
            //CraftingRegistry.addShapelessRecipe(new ItemStack(PUMPKIN_SPICE_LATTE.asItem(), 1), new ItemStack(BITTER_WATER.asItem(), 1, 1), Item.SUGAR, Item.MILK_BUCKET, Block.PUMPKIN);

            /** - Fill kettle recipes */
            CraftingRegistry.addShapelessRecipe(new ItemStack(POISON_KETTLE.asItem(), 1), new ItemStack(KETTLE.asItem(), 1, -1), Block.CACTUS);
            CraftingRegistry.addShapelessRecipe(new ItemStack(WATER_KETTLE.asItem(), 1), new ItemStack(KETTLE.asItem(), 1, -1), Item.WATER_BUCKET);
            CraftingRegistry.addShapelessRecipe(new ItemStack(LAVA_KETTLE.asItem(), 1), new ItemStack(KETTLE.asItem(), 1, -1), Item.LAVA_BUCKET);
            CraftingRegistry.addShapelessRecipe(new ItemStack(MILK_KETTLE.asItem(), 1), new ItemStack(KETTLE.asItem(), 1, -1), Item.MILK_BUCKET);

            CraftingRegistry.addShapelessRecipe(new ItemStack(APPLE_KETTLE.asItem(), 1), new ItemStack(KETTLE.asItem(), 1, -1), Item.WATER_BUCKET, Item.APPLE);
            CraftingRegistry.addShapelessRecipe(new ItemStack(APPLE_KETTLE.asItem(), 1, 0), new ItemStack(WATER_KETTLE.asItem(), 1, 0), Item.APPLE);
            CraftingRegistry.addShapelessRecipe(new ItemStack(APPLE_KETTLE.asItem(), 1, 1), new ItemStack(WATER_KETTLE.asItem(), 1, 1), Item.APPLE);
            CraftingRegistry.addShapelessRecipe(new ItemStack(APPLE_KETTLE.asItem(), 1, 2), new ItemStack(WATER_KETTLE.asItem(), 1, 2), Item.APPLE);
            CraftingRegistry.addShapelessRecipe(new ItemStack(APPLE_KETTLE.asItem(), 1, 3), new ItemStack(WATER_KETTLE.asItem(), 1, 3), Item.APPLE);
            CraftingRegistry.addShapelessRecipe(new ItemStack(APPLE_KETTLE.asItem(), 1, 4), new ItemStack(WATER_KETTLE.asItem(), 1, 4), Item.APPLE);

            CraftingRegistry.addShapelessRecipe(new ItemStack(ELIXIR_KETTLE.asItem(), 1), new ItemStack(KETTLE.asItem(), 1, -1), Item.WATER_BUCKET, Item.GOLDEN_APPLE);
            CraftingRegistry.addShapelessRecipe(new ItemStack(ELIXIR_KETTLE.asItem(), 1, 0), new ItemStack(WATER_KETTLE.asItem(), 1, 0), Item.GOLDEN_APPLE);
            CraftingRegistry.addShapelessRecipe(new ItemStack(ELIXIR_KETTLE.asItem(), 1, 1), new ItemStack(WATER_KETTLE.asItem(), 1, 1), Item.GOLDEN_APPLE);
            CraftingRegistry.addShapelessRecipe(new ItemStack(ELIXIR_KETTLE.asItem(), 1, 2), new ItemStack(WATER_KETTLE.asItem(), 1, 2), Item.GOLDEN_APPLE);
            CraftingRegistry.addShapelessRecipe(new ItemStack(ELIXIR_KETTLE.asItem(), 1, 3), new ItemStack(WATER_KETTLE.asItem(), 1, 3), Item.GOLDEN_APPLE);
            CraftingRegistry.addShapelessRecipe(new ItemStack(ELIXIR_KETTLE.asItem(), 1, 4), new ItemStack(WATER_KETTLE.asItem(), 1, 4), Item.GOLDEN_APPLE);

            CraftingRegistry.addShapelessRecipe(new ItemStack(BITTER_KETTLE.asItem(), 1), new ItemStack(KETTLE.asItem(), 1, -1), Item.WATER_BUCKET, new ItemStack(Item.DYE, 1, 3));
            CraftingRegistry.addShapelessRecipe(new ItemStack(BITTER_KETTLE.asItem(), 1, 0), new ItemStack(WATER_KETTLE.asItem(), 1, 0), new ItemStack(Item.DYE, 1, 3));
            CraftingRegistry.addShapelessRecipe(new ItemStack(BITTER_KETTLE.asItem(), 1, 1), new ItemStack(WATER_KETTLE.asItem(), 1, 1), new ItemStack(Item.DYE, 1, 3));
            CraftingRegistry.addShapelessRecipe(new ItemStack(BITTER_KETTLE.asItem(), 1, 2), new ItemStack(WATER_KETTLE.asItem(), 1, 2), new ItemStack(Item.DYE, 1, 3));
            CraftingRegistry.addShapelessRecipe(new ItemStack(BITTER_KETTLE.asItem(), 1, 3), new ItemStack(WATER_KETTLE.asItem(), 1, 3), new ItemStack(Item.DYE, 1, 3));
            CraftingRegistry.addShapelessRecipe(new ItemStack(BITTER_KETTLE.asItem(), 1, 4), new ItemStack(WATER_KETTLE.asItem(), 1, 4), new ItemStack(Item.DYE, 1, 3));

            CraftingRegistry.addShapelessRecipe(new ItemStack(POISON_KETTLE.asItem(), 1, 4), new ItemStack(KETTLE.asItem(), 1, -1), new ItemStack(POISON.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(POISON_KETTLE.asItem(), 1, 4), new ItemStack(POISON_KETTLE.asItem(), 1, 5), new ItemStack(POISON.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(POISON_KETTLE.asItem(), 1, 2), new ItemStack(POISON_KETTLE.asItem(), 1, 5), new ItemStack(POISON.asItem(), 1, -1), new ItemStack(POISON.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(POISON_KETTLE.asItem(), 1, 0), new ItemStack(POISON_KETTLE.asItem(), 1, 5), new ItemStack(POISON.asItem(), 1, -1), new ItemStack(POISON.asItem(), 1, -1), new ItemStack(POISON.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(POISON_KETTLE.asItem(), 1, 2), new ItemStack(POISON_KETTLE.asItem(), 1, 4), new ItemStack(POISON.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(POISON_KETTLE.asItem(), 1, 0), new ItemStack(POISON_KETTLE.asItem(), 1, 4), new ItemStack(POISON.asItem(), 1, -1), new ItemStack(POISON.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(POISON_KETTLE.asItem(), 1, 0), new ItemStack(POISON_KETTLE.asItem(), 1, 2), new ItemStack(POISON.asItem(), 1, -1));

            CraftingRegistry.addShapelessRecipe(new ItemStack(WATER_KETTLE.asItem(), 1, 4), new ItemStack(KETTLE.asItem(), 1, -1), new ItemStack(CUP_OF_WATER.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(WATER_KETTLE.asItem(), 1, 4), new ItemStack(WATER_KETTLE.asItem(), 1, 5), new ItemStack(CUP_OF_WATER.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(WATER_KETTLE.asItem(), 1, 2), new ItemStack(WATER_KETTLE.asItem(), 1, 5), new ItemStack(CUP_OF_WATER.asItem(), 1, -1), new ItemStack(CUP_OF_WATER.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(WATER_KETTLE.asItem(), 1, 0), new ItemStack(WATER_KETTLE.asItem(), 1, 5), new ItemStack(CUP_OF_WATER.asItem(), 1, -1), new ItemStack(CUP_OF_WATER.asItem(), 1, -1), new ItemStack(CUP_OF_WATER.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(WATER_KETTLE.asItem(), 1, 2), new ItemStack(WATER_KETTLE.asItem(), 1, 4), new ItemStack(CUP_OF_WATER.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(WATER_KETTLE.asItem(), 1, 0), new ItemStack(WATER_KETTLE.asItem(), 1, 4), new ItemStack(CUP_OF_WATER.asItem(), 1, -1), new ItemStack(CUP_OF_WATER.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(WATER_KETTLE.asItem(), 1, 0), new ItemStack(WATER_KETTLE.asItem(), 1, 2), new ItemStack(CUP_OF_WATER.asItem(), 1, -1));

            CraftingRegistry.addShapelessRecipe(new ItemStack(LAVA_KETTLE.asItem(), 1, 4), new ItemStack(KETTLE.asItem(), 1, -1), new ItemStack(CUP_OF_LAVA.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(LAVA_KETTLE.asItem(), 1, 4), new ItemStack(LAVA_KETTLE.asItem(), 1, 5), new ItemStack(CUP_OF_LAVA.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(LAVA_KETTLE.asItem(), 1, 2), new ItemStack(LAVA_KETTLE.asItem(), 1, 5), new ItemStack(CUP_OF_LAVA.asItem(), 1, -1), new ItemStack(CUP_OF_LAVA.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(LAVA_KETTLE.asItem(), 1, 0), new ItemStack(LAVA_KETTLE.asItem(), 1, 5), new ItemStack(CUP_OF_LAVA.asItem(), 1, -1), new ItemStack(CUP_OF_LAVA.asItem(), 1, -1), new ItemStack(CUP_OF_LAVA.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(LAVA_KETTLE.asItem(), 1, 2), new ItemStack(LAVA_KETTLE.asItem(), 1, 4), new ItemStack(CUP_OF_LAVA.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(LAVA_KETTLE.asItem(), 1, 0), new ItemStack(LAVA_KETTLE.asItem(), 1, 4), new ItemStack(CUP_OF_LAVA.asItem(), 1, -1), new ItemStack(CUP_OF_LAVA.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(LAVA_KETTLE.asItem(), 1, 0), new ItemStack(LAVA_KETTLE.asItem(), 1, 2), new ItemStack(CUP_OF_LAVA.asItem(), 1, -1));

            CraftingRegistry.addShapelessRecipe(new ItemStack(MILK_KETTLE.asItem(), 1, 4), new ItemStack(KETTLE.asItem(), 1, -1), new ItemStack(CUP_OF_MILK.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(MILK_KETTLE.asItem(), 1, 4), new ItemStack(MILK_KETTLE.asItem(), 1, 5), new ItemStack(CUP_OF_MILK.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(MILK_KETTLE.asItem(), 1, 2), new ItemStack(MILK_KETTLE.asItem(), 1, 5), new ItemStack(CUP_OF_MILK.asItem(), 1, -1), new ItemStack(CUP_OF_MILK.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(MILK_KETTLE.asItem(), 1, 0), new ItemStack(MILK_KETTLE.asItem(), 1, 5), new ItemStack(CUP_OF_MILK.asItem(), 1, -1), new ItemStack(CUP_OF_MILK.asItem(), 1, -1), new ItemStack(CUP_OF_MILK.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(MILK_KETTLE.asItem(), 1, 2), new ItemStack(MILK_KETTLE.asItem(), 1, 4), new ItemStack(CUP_OF_MILK.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(MILK_KETTLE.asItem(), 1, 0), new ItemStack(MILK_KETTLE.asItem(), 1, 4), new ItemStack(CUP_OF_MILK.asItem(), 1, -1), new ItemStack(CUP_OF_MILK.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(MILK_KETTLE.asItem(), 1, 0), new ItemStack(MILK_KETTLE.asItem(), 1, 2), new ItemStack(CUP_OF_MILK.asItem(), 1, -1));

            CraftingRegistry.addShapelessRecipe(new ItemStack(APPLE_KETTLE.asItem(), 1, 4), new ItemStack(KETTLE.asItem(), 1, -1), new ItemStack(APPLE_CIDER.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(APPLE_KETTLE.asItem(), 1, 4), new ItemStack(APPLE_KETTLE.asItem(), 1, 5), new ItemStack(APPLE_CIDER.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(APPLE_KETTLE.asItem(), 1, 2), new ItemStack(APPLE_KETTLE.asItem(), 1, 5), new ItemStack(APPLE_CIDER.asItem(), 1, -1), new ItemStack(APPLE_CIDER.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(APPLE_KETTLE.asItem(), 1, 0), new ItemStack(APPLE_KETTLE.asItem(), 1, 5), new ItemStack(APPLE_CIDER.asItem(), 1, -1), new ItemStack(APPLE_CIDER.asItem(), 1, -1), new ItemStack(APPLE_CIDER.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(APPLE_KETTLE.asItem(), 1, 2), new ItemStack(APPLE_KETTLE.asItem(), 1, 4), new ItemStack(APPLE_CIDER.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(APPLE_KETTLE.asItem(), 1, 0), new ItemStack(APPLE_KETTLE.asItem(), 1, 4), new ItemStack(APPLE_CIDER.asItem(), 1, -1), new ItemStack(APPLE_CIDER.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(APPLE_KETTLE.asItem(), 1, 0), new ItemStack(APPLE_KETTLE.asItem(), 1, 2), new ItemStack(APPLE_CIDER.asItem(), 1, -1));

            CraftingRegistry.addShapelessRecipe(new ItemStack(ELIXIR_KETTLE.asItem(), 1, 4), new ItemStack(KETTLE.asItem(), 1, -1), new ItemStack(ELIXIR.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(ELIXIR_KETTLE.asItem(), 1, 4), new ItemStack(ELIXIR_KETTLE.asItem(), 1, 5), new ItemStack(ELIXIR.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(ELIXIR_KETTLE.asItem(), 1, 2), new ItemStack(ELIXIR_KETTLE.asItem(), 1, 5), new ItemStack(ELIXIR.asItem(), 1, -1), new ItemStack(ELIXIR.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(ELIXIR_KETTLE.asItem(), 1, 0), new ItemStack(ELIXIR_KETTLE.asItem(), 1, 5), new ItemStack(ELIXIR.asItem(), 1, -1), new ItemStack(ELIXIR.asItem(), 1, -1), new ItemStack(ELIXIR.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(ELIXIR_KETTLE.asItem(), 1, 2), new ItemStack(ELIXIR_KETTLE.asItem(), 1, 4), new ItemStack(ELIXIR.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(ELIXIR_KETTLE.asItem(), 1, 0), new ItemStack(ELIXIR_KETTLE.asItem(), 1, 4), new ItemStack(ELIXIR.asItem(), 1, -1), new ItemStack(ELIXIR.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(ELIXIR_KETTLE.asItem(), 1, 0), new ItemStack(ELIXIR_KETTLE.asItem(), 1, 2), new ItemStack(ELIXIR.asItem(), 1, -1));

            CraftingRegistry.addShapelessRecipe(new ItemStack(BITTER_KETTLE.asItem(), 1, 4), new ItemStack(KETTLE.asItem(), 1, -1), new ItemStack(BITTER_WATER.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(BITTER_KETTLE.asItem(), 1, 4), new ItemStack(BITTER_KETTLE.asItem(), 1, 5), new ItemStack(BITTER_WATER.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(BITTER_KETTLE.asItem(), 1, 2), new ItemStack(BITTER_KETTLE.asItem(), 1, 5), new ItemStack(BITTER_WATER.asItem(), 1, -1), new ItemStack(BITTER_WATER.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(BITTER_KETTLE.asItem(), 1, 0), new ItemStack(BITTER_KETTLE.asItem(), 1, 5), new ItemStack(BITTER_WATER.asItem(), 1, -1), new ItemStack(BITTER_WATER.asItem(), 1, -1), new ItemStack(BITTER_WATER.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(BITTER_KETTLE.asItem(), 1, 2), new ItemStack(BITTER_KETTLE.asItem(), 1, 4), new ItemStack(BITTER_WATER.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(BITTER_KETTLE.asItem(), 1, 0), new ItemStack(BITTER_KETTLE.asItem(), 1, 4), new ItemStack(BITTER_WATER.asItem(), 1, -1), new ItemStack(BITTER_WATER.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(BITTER_KETTLE.asItem(), 1, 0), new ItemStack(BITTER_KETTLE.asItem(), 1, 2), new ItemStack(BITTER_WATER.asItem(), 1, -1));

            CraftingRegistry.addShapelessRecipe(new ItemStack(POISON_KETTLE.asItem(), 1, 2), new ItemStack(KETTLE.asItem(), 1, -1), new ItemStack(POISON.asItem(), 1, -1), new ItemStack(POISON.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(WATER_KETTLE.asItem(), 1, 2), new ItemStack(KETTLE.asItem(), 1, -1), new ItemStack(CUP_OF_WATER.asItem(), 1, -1), new ItemStack(CUP_OF_WATER.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(LAVA_KETTLE.asItem(), 1, 2), new ItemStack(KETTLE.asItem(), 1, -1), new ItemStack(CUP_OF_LAVA.asItem(), 1, -1), new ItemStack(CUP_OF_LAVA.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(MILK_KETTLE.asItem(), 1, 2), new ItemStack(KETTLE.asItem(), 1, -1), new ItemStack(CUP_OF_MILK.asItem(), 1, -1), new ItemStack(CUP_OF_MILK.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(APPLE_KETTLE.asItem(), 1, 2), new ItemStack(KETTLE.asItem(), 1, -1), new ItemStack(APPLE_CIDER.asItem(), 1, -1), new ItemStack(APPLE_CIDER.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(ELIXIR_KETTLE.asItem(), 1, 2), new ItemStack(KETTLE.asItem(), 1, -1), new ItemStack(ELIXIR.asItem(), 1, -1), new ItemStack(ELIXIR.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(BITTER_KETTLE.asItem(), 1, 2), new ItemStack(KETTLE.asItem(), 1, -1), new ItemStack(BITTER_WATER.asItem(), 1, -1), new ItemStack(BITTER_WATER.asItem(), 1, -1));

            CraftingRegistry.addShapelessRecipe(new ItemStack(POISON_KETTLE.asItem(), 1), new ItemStack(KETTLE.asItem(), 1, -1), new ItemStack(POISON.asItem(), 1, -1), new ItemStack(POISON.asItem(), 1, -1), new ItemStack(POISON.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(WATER_KETTLE.asItem(), 1), new ItemStack(KETTLE.asItem(), 1, -1), new ItemStack(CUP_OF_WATER.asItem(), 1, -1), new ItemStack(CUP_OF_WATER.asItem(), 1, -1), new ItemStack(CUP_OF_WATER.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(LAVA_KETTLE.asItem(), 1), new ItemStack(KETTLE.asItem(), 1, -1), new ItemStack(CUP_OF_LAVA.asItem(), 1, -1), new ItemStack(CUP_OF_LAVA.asItem(), 1, -1), new ItemStack(CUP_OF_LAVA.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(MILK_KETTLE.asItem(), 1), new ItemStack(KETTLE.asItem(), 1, -1), new ItemStack(CUP_OF_MILK.asItem(), 1, -1), new ItemStack(CUP_OF_MILK.asItem(), 1, -1), new ItemStack(CUP_OF_MILK.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(APPLE_KETTLE.asItem(), 1), new ItemStack(KETTLE.asItem(), 1, -1), new ItemStack(APPLE_CIDER.asItem(), 1, -1), new ItemStack(APPLE_CIDER.asItem(), 1, -1), new ItemStack(APPLE_CIDER.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(ELIXIR_KETTLE.asItem(), 1), new ItemStack(KETTLE.asItem(), 1, -1), new ItemStack(ELIXIR.asItem(), 1, -1), new ItemStack(ELIXIR.asItem(), 1, -1), new ItemStack(ELIXIR.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(BITTER_KETTLE.asItem(), 1), new ItemStack(KETTLE.asItem(), 1, -1), new ItemStack(BITTER_WATER.asItem(), 1, -1), new ItemStack(BITTER_WATER.asItem(), 1, -1), new ItemStack(BITTER_WATER.asItem(), 1, -1));

            /** - Clean out kettle recipes */
            CraftingRegistry.addShapelessRecipe(new ItemStack(KETTLE.asItem(), 1), new ItemStack(POISON_KETTLE.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(KETTLE.asItem(), 1), new ItemStack(WATER_KETTLE.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(KETTLE.asItem(), 1), new ItemStack(LAVA_KETTLE.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(KETTLE.asItem(), 1), new ItemStack(MILK_KETTLE.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(KETTLE.asItem(), 1), new ItemStack(APPLE_KETTLE.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(KETTLE.asItem(), 1), new ItemStack(ELIXIR_KETTLE.asItem(), 1, -1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(KETTLE.asItem(), 1), new ItemStack(BITTER_KETTLE.asItem(), 1, -1));
        }
    }
}
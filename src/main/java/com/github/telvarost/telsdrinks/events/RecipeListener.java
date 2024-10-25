package com.github.telvarost.telsdrinks.events;

import net.mine_diver.unsafeevents.listener.EventListener;
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
            CraftingRegistry.addShapedRecipe(new ItemStack(KETTLE.asItem(), 1), " X ", "X X", "XXX", 'X', Item.IRON_INGOT);
            CraftingRegistry.addShapedRecipe(new ItemStack(WATER_KETTLE.asItem(), 1), " X ", "XYX", "XXX", 'X', Item.IRON_INGOT, 'Y', Item.WATER_BUCKET);
            CraftingRegistry.addShapedRecipe(new ItemStack(MILK_KETTLE.asItem(), 1), " X ", "XYX", "XXX", 'X', Item.IRON_INGOT, 'Y', Item.MILK_BUCKET);
            CraftingRegistry.addShapedRecipe(new ItemStack(CLAY_MUG.asItem(), 2), "   ", "XXX", " X ", 'X', Item.CLAY);
        }

        if (type == RecipeRegisterEvent.Vanilla.SMELTING.type()) {
            SmeltingRegistry.addSmeltingRecipe(new ItemStack(CLAY_MUG.asItem(), 1), new ItemStack(EMPTY_MUG.asItem(), 1));
        }

        if (type == RecipeRegisterEvent.Vanilla.CRAFTING_SHAPELESS.type()) {
            CraftingRegistry.addShapelessRecipe(new ItemStack(KETTLE.asItem(), 1), new ItemStack(WATER_KETTLE.asItem(), 1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(KETTLE.asItem(), 1), new ItemStack(MILK_KETTLE.asItem(), 1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(KETTLE.asItem(), 1), new ItemStack(BITTER_KETTLE.asItem(), 1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(KETTLE.asItem(), 1), new ItemStack(APPLE_KETTLE.asItem(), 1));
            CraftingRegistry.addShapelessRecipe(new ItemStack(WATER_KETTLE.asItem(), 1), new ItemStack(KETTLE.asItem(), 1), Item.WATER_BUCKET);
            CraftingRegistry.addShapelessRecipe(new ItemStack(MILK_KETTLE.asItem(), 1), new ItemStack(KETTLE.asItem(), 1), Item.MILK_BUCKET);
            CraftingRegistry.addShapelessRecipe(new ItemStack(APPLE_KETTLE.asItem(), 1), new ItemStack(WATER_KETTLE.asItem(), 1), Item.APPLE);
            CraftingRegistry.addShapelessRecipe(new ItemStack(BITTER_KETTLE.asItem(), 1), new ItemStack(WATER_KETTLE.asItem(), 1), new ItemStack(Item.DYE, 1, 3));
        }
    }
}
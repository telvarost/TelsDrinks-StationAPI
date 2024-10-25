package com.github.telvarost.telsdrinks.events;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.event.recipe.RecipeRegisterEvent;
import net.modificationstation.stationapi.api.recipe.CraftingRegistry;
import net.modificationstation.stationapi.api.recipe.SmeltingRegistry;
import net.modificationstation.stationapi.api.util.Identifier;

import static com.github.telvarost.telsdrinks.events.BlockListener.EMPTY_MUG;
import static com.github.telvarost.telsdrinks.events.BlockListener.KETTLE;
import static com.github.telvarost.telsdrinks.events.ItemListener.CLAY_MUG;

public class RecipeListener {

    @EventListener
    public void registerRecipes(RecipeRegisterEvent event) {
        Identifier type = event.recipeId;

        if (type == RecipeRegisterEvent.Vanilla.CRAFTING_SHAPED.type()) {
            CraftingRegistry.addShapedRecipe(new ItemStack(KETTLE.asItem(), 1), " X ", "X X", "XXX", 'X', Item.IRON_INGOT);
            CraftingRegistry.addShapedRecipe(new ItemStack(CLAY_MUG.asItem(), 2), "   ", "XXX", " X ", 'X', Item.CLAY);
        }

        if (type == RecipeRegisterEvent.Vanilla.SMELTING.type()) {
            SmeltingRegistry.addSmeltingRecipe(new ItemStack(CLAY_MUG.asItem(), 1), new ItemStack(EMPTY_MUG.asItem(), 1));
        }

        if (type == RecipeRegisterEvent.Vanilla.CRAFTING_SHAPELESS.type()) {
        }
    }
}
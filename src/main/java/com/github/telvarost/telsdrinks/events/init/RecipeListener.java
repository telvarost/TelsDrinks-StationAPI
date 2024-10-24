package com.github.telvarost.telsdrinks.events.init;

import com.github.telvarost.telsdrinks.block.Kettle;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.event.recipe.RecipeRegisterEvent;
import net.modificationstation.stationapi.api.recipe.CraftingRegistry;
import net.modificationstation.stationapi.api.recipe.FuelRegistry;
import net.modificationstation.stationapi.api.recipe.SmeltingRegistry;
import net.modificationstation.stationapi.api.util.Identifier;

import static com.github.telvarost.telsdrinks.events.init.BlockListener.KETTLE;
import static com.github.telvarost.telsdrinks.events.init.BlockListener.MUG;

public class RecipeListener {

    @EventListener
    public void registerRecipes(RecipeRegisterEvent event) {
        Identifier type = event.recipeId;

        if (type == RecipeRegisterEvent.Vanilla.CRAFTING_SHAPED.type()) {
            CraftingRegistry.addShapedRecipe(new ItemStack(KETTLE.asItem(), 1), " X ", "X X", "XXX", 'X', Item.IRON_INGOT);
            CraftingRegistry.addShapedRecipe(new ItemStack(MUG.asItem(), 1), "   ", "XXX", " X ", 'X', Item.CLAY);
        }

        if (type == RecipeRegisterEvent.Vanilla.SMELTING.type()) {
//            FuelRegistry.addFuelItem(Item.BOAT, 1200);
//            SmeltingRegistry.addSmeltingRecipe();
        }

        if (type == RecipeRegisterEvent.Vanilla.CRAFTING_SHAPELESS.type()) {
        }
    }
}
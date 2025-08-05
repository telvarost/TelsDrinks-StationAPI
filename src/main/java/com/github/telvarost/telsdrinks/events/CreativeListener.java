package com.github.telvarost.telsdrinks.events;

import com.github.telvarost.telsdrinks.TelsDrinks;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import paulevs.bhcreative.api.CreativeTab;
import paulevs.bhcreative.api.SimpleTab;
import paulevs.bhcreative.registry.TabRegistryEvent;

public class CreativeListener {
    public static CreativeTab tabTelsDrinks;

    @EventListener
    public void onTabInit(TabRegistryEvent event){
        tabTelsDrinks = new SimpleTab(TelsDrinks.TELS_DRINKS.id("kettle"), BlockListener.KETTLE.asItem());
        event.register(tabTelsDrinks);
        for (Block block : BlockListener.blocks){
            if (BlockListener.EMPTY_MUG.id == block.id) {
                for (Item item : ItemListener.items){
                    tabTelsDrinks.addItem(new ItemStack(item, 1));
                }
            }

            tabTelsDrinks.addItem(new ItemStack(block.asItem(), 1));

            if (  BlockListener.CUP_OF_WATER.id == block.id
               || BlockListener.CUP_OF_MILK.id == block.id
               || BlockListener.APPLE_CIDER.id == block.id
               || BlockListener.BITTER_WATER.id == block.id
            ) {
                tabTelsDrinks.addItem(new ItemStack(block.asItem(), 1, 1));
            }
        }
    }
}
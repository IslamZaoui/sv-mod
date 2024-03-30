package net.igdz77.svmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.igdz77.svmod.SVMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item SV = registerModItem("sv", new Item(new FabricItemSettings()));

    private static Item registerModItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(SVMod.MOD_ID, name), item);
    }

    private static void addItemToToolsTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(SV);
    }

    public static void registerModItems() {
        SVMod.LOGGER.info("Registering Mod Items for " + SVMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addItemToToolsTabItemGroup);
    }
}

package net.IslamZaoui.sovietunionmememod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.IslamZaoui.sovietunionmememod.SVMod;
import net.IslamZaoui.sovietunionmememod.item.custom.SVItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final SVItem SV = (SVItem) registerModItem("soviet-union-flag", new SVItem(new FabricItemSettings().maxCount(1)));

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

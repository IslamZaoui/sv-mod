package net.IslamZaoui.sovietunionmememod.item;

import net.IslamZaoui.sovietunionmememod.SVMod;
import net.IslamZaoui.sovietunionmememod.item.custom.GoldenHammer;
import net.IslamZaoui.sovietunionmememod.item.custom.GoldenSickle;
import net.IslamZaoui.sovietunionmememod.item.custom.soviet_union_flag;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final soviet_union_flag SVFlag = (soviet_union_flag) registerModItem("soviet-union-flag", new soviet_union_flag(
            new FabricItemSettings()
                    .maxCount(1)
    ));
    public static final Item golden_bar = registerModItem("golden_bar", new Item(
            new FabricItemSettings()
    ));

    public static final GoldenHammer golden_hammer = (GoldenHammer) registerModItem("golden_hammer", new GoldenHammer(
            ModToolMaterial.GOLD,
            7,
            -2f,
            new FabricItemSettings()
    ));
    public static final GoldenSickle golden_sickle = (GoldenSickle) registerModItem("golden_sickle", new GoldenSickle(
            ModToolMaterial.GOLD,
            9,
            -3.5f,
            new FabricItemSettings()
    ));


    private static Item registerModItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(SVMod.MOD_ID, name), item);
    }

    private static void addItemToToolsTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(SVFlag);
        entries.add(golden_hammer);
        entries.add(golden_sickle);
    }

    private static void addItemToIngredientsTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(golden_bar);
    }

    public static void registerModItems() {
        SVMod.LOGGER.info("Registering Mod Items for " + SVMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addItemToToolsTabItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemToIngredientsTabItemGroup);
    }
}

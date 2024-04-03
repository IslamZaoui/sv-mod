package net.IslamZaoui.sovietunionmememod.item;

import net.IslamZaoui.sovietunionmememod.SVMod;
import net.IslamZaoui.sovietunionmememod.item.custom.GoldenHammer;
import net.IslamZaoui.sovietunionmememod.item.custom.GoldenSickle;
import net.IslamZaoui.sovietunionmememod.item.custom.SovietUnionFlag;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final SovietUnionFlag SOVIET_UNION_FLAG = (SovietUnionFlag) registerModItem("soviet_union_flag", new SovietUnionFlag(
            new FabricItemSettings()
                    .maxCount(1)
    ));
    public static final Item GOLDEN_BAR = registerModItem("golden_bar", new Item(
            new FabricItemSettings()
    ));

    public static final GoldenHammer GOLDEN_HAMMER = (GoldenHammer) registerModItem("golden_hammer", new GoldenHammer(
            ModToolMaterials.GOLD,
            2,
            2f,
            new FabricItemSettings()
    ));
    public static final GoldenSickle GOLDEN_SICKLE = (GoldenSickle) registerModItem("golden_sickle", new GoldenSickle(
            ModToolMaterials.GOLD,
            5,
            -2f,
            new FabricItemSettings()
    ));


    private static Item registerModItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(SVMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        SVMod.LOGGER.info("Registering Mod Items for " + SVMod.MOD_ID);
    }
}

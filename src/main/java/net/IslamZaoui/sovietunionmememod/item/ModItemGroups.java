package net.IslamZaoui.sovietunionmememod.item;

import net.IslamZaoui.sovietunionmememod.SVMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup SOVIET_UNION_ITEM_GROUP;

    static {
        SOVIET_UNION_ITEM_GROUP = Registry.register(
                Registries.ITEM_GROUP,
                new Identifier(SVMod.MOD_ID, "soviet_union"),
                FabricItemGroup
                        .builder()
                        .displayName(Text.translatable("itemgroup.soviet_union"))
                        .icon(() -> new ItemStack(ModItems.SOVIET_UNION_FLAG))
                        .entries((displayContext, entries) -> {
                            entries.add(ModItems.SOVIET_UNION_FLAG);
                            entries.add(ModItems.GOLDEN_BAR);
                            entries.add(ModItems.GOLDEN_HAMMER);
                            entries.add(ModItems.GOLDEN_SICKLE);
                        })
                        .build()
        );
    }

    public static void registerItemGroups() {
        SVMod.LOGGER.info("Registering Item Groups for " + SVMod.MOD_ID);
    }
}

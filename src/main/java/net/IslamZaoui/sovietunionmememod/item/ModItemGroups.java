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
    public static final ItemGroup SOVIET_UNION_ITEM_GROUP = Registry.register(
            Registries.ITEM_GROUP,
            new Identifier(SVMod.MOD_ID, "soviet_union"),
            FabricItemGroup
                    .builder()
                    .displayName(Text.translatable("itemgroup.soviet_union"))
                    .icon(() -> new ItemStack(ModItems.SVFlag))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.SVFlag);
                        entries.add(ModItems.golden_bar);
                        entries.add(ModItems.golden_hammer);
                        entries.add(ModItems.golden_sickle);
                    })
                    .build()
    );

    public static void registerItemGroups() {
        SVMod.LOGGER.info("Registering Item Groups for " + SVMod.MOD_ID);
    }
}

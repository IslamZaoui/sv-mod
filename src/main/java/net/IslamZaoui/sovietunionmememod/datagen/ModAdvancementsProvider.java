package net.IslamZaoui.sovietunionmememod.datagen;

import net.IslamZaoui.sovietunionmememod.SVMod;
import net.IslamZaoui.sovietunionmememod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModAdvancementsProvider extends FabricAdvancementProvider {
    public ModAdvancementsProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<AdvancementEntry> consumer) {
        AdvancementEntry rootAdvancement = Advancement.Builder.create()
                .display(
                        ModItems.SOVIET_UNION_FLAG,
                        Text.translatable("advancement.sovietunionmememod.title"),
                        Text.translatable("advancement.sovietunionmememod.description"),
                        new Identifier(SVMod.MOD_ID, "textures/gui/advancements/backgrounds/soviet_union.png"),
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        true
                )
                .criterion("welcome_back", InventoryChangedCriterion.Conditions.items(ModItems.SOVIET_UNION_FLAG))
                .build(consumer, SVMod.MOD_ID + "/root");
    }
}

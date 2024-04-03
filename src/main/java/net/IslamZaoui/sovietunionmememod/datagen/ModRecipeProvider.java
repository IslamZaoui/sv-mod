package net.IslamZaoui.sovietunionmememod.datagen;

import net.IslamZaoui.sovietunionmememod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GOLDEN_BAR, 3)
                .pattern("G")
                .pattern("G")
                .input('G', Items.GOLD_INGOT)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GOLDEN_BAR)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.GOLDEN_HAMMER, 1)
                .pattern("GGG")
                .pattern("GBG")
                .pattern(" B ")
                .input('G', Items.GOLD_INGOT)
                .input('B', ModItems.GOLDEN_BAR)
                .criterion(hasItem(ModItems.GOLDEN_BAR), conditionsFromItem(ModItems.GOLDEN_BAR))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GOLDEN_HAMMER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.GOLDEN_SICKLE, 1)
                .pattern(" G ")
                .pattern("  G")
                .pattern("BG ")
                .input('G', Items.GOLD_INGOT)
                .input('B', ModItems.GOLDEN_BAR)
                .criterion(hasItem(ModItems.GOLDEN_BAR), conditionsFromItem(ModItems.GOLDEN_BAR))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GOLDEN_SICKLE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SOVIET_UNION_FLAG, 1)
                .pattern("*##")
                .pattern("SH#")
                .pattern("###")
                .input('*', Items.NETHER_STAR)
                .input('S', ModItems.GOLDEN_SICKLE)
                .input('H', ModItems.GOLDEN_HAMMER)
                .input('#', Items.RED_WOOL)
                .criterion(hasItem(Items.NETHER_STAR), conditionsFromItem(Items.NETHER_STAR))
                .criterion(hasItem(ModItems.GOLDEN_SICKLE), conditionsFromItem(ModItems.GOLDEN_SICKLE))
                .criterion(hasItem(ModItems.GOLDEN_HAMMER), conditionsFromItem(ModItems.GOLDEN_HAMMER))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SOVIET_UNION_FLAG)));
    }
}

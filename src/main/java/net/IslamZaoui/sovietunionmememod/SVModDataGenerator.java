package net.IslamZaoui.sovietunionmememod;

import net.IslamZaoui.sovietunionmememod.datagen.ModAdvancementsProvider;
import net.IslamZaoui.sovietunionmememod.datagen.ModBlockTagProvider;
import net.IslamZaoui.sovietunionmememod.datagen.ModModelProvider;
import net.IslamZaoui.sovietunionmememod.datagen.ModRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class SVModDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModModelProvider::new);
        pack.addProvider(ModRecipeProvider::new);
        pack.addProvider(ModBlockTagProvider::new);
        pack.addProvider(ModAdvancementsProvider::new);
    }
}

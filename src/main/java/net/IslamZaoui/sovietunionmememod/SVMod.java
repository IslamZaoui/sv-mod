package net.IslamZaoui.sovietunionmememod;

import net.IslamZaoui.sovietunionmememod.config.ModConfigs;
import net.IslamZaoui.sovietunionmememod.item.ModItemGroups;
import net.IslamZaoui.sovietunionmememod.item.ModItems;
import net.IslamZaoui.sovietunionmememod.sound.ModSounds;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SVMod implements ModInitializer {
    public static final String MOD_ID = "sovietunionmememod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModConfigs.registerConfigs();
        ModSounds.registerModSounds();
        ModItemGroups.registerItemGroups();
        ModItems.registerModItems();
    }
}
package net.IslamZaoui.sovietunionmememod;

import me.emafire003.dev.coloredglowlib.ColoredGlowLibAPI;
import me.emafire003.dev.coloredglowlib.ColoredGlowLibMod;
import net.IslamZaoui.sovietunionmememod.config.ModConfigs;
import net.IslamZaoui.sovietunionmememod.item.ModItemGroups;
import net.IslamZaoui.sovietunionmememod.item.ModItems;
import net.IslamZaoui.sovietunionmememod.sound.ModSounds;
import net.IslamZaoui.sovietunionmememod.util.CGL;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SVMod implements ModInitializer {
    public static final String MOD_ID = "sovietunionmememod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModConfigs.registerConfigs();
        CGL.register();
        ModSounds.registerModSounds();
        ModItemGroups.registerItemGroups();
        ModItems.registerModItems();
    }
}
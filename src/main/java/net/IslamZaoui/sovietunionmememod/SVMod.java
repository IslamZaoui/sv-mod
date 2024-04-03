package net.IslamZaoui.sovietunionmememod;

import me.emafire003.dev.coloredglowlib.ColoredGlowLibAPI;
import me.emafire003.dev.coloredglowlib.ColoredGlowLibMod;
import net.IslamZaoui.sovietunionmememod.config.ModConfigs;
import net.IslamZaoui.sovietunionmememod.item.ModItemGroups;
import net.IslamZaoui.sovietunionmememod.item.ModItems;
import net.IslamZaoui.sovietunionmememod.sound.ModSounds;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SVMod implements ModInitializer {
    public static final String MOD_ID = "sovietunionmememod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static ColoredGlowLibAPI CGL;

    public static void registerCGL() {
        ServerLifecycleEvents.SERVER_STARTED.register(server -> {
            CGL = ColoredGlowLibMod.getColoredGlowLib();
        });
    }

    @Override
    public void onInitialize() {
        registerCGL();
        ModConfigs.registerConfigs();
        ModSounds.registerModSounds();
        ModItemGroups.registerItemGroups();
        ModItems.registerModItems();
    }
}
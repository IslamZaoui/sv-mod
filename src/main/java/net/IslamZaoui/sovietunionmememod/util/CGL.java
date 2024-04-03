package net.IslamZaoui.sovietunionmememod.util;

import me.emafire003.dev.coloredglowlib.ColoredGlowLibAPI;
import me.emafire003.dev.coloredglowlib.ColoredGlowLibMod;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.loader.api.FabricLoader;

public class CGL {
    public static ColoredGlowLibAPI api;

    public static void register() {
        ServerLifecycleEvents.SERVER_STARTED.register(server -> {
            api = ColoredGlowLibMod.getColoredGlowLib();
        });
    }

    public static boolean isAPIRegistered() {
        return FabricLoader.getInstance().isModLoaded("coloredglowlib") && CGL.api != null;
    }
}

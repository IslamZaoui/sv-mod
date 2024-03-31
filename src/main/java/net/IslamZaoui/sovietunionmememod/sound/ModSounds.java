package net.IslamZaoui.sovietunionmememod.sound;

import net.IslamZaoui.sovietunionmememod.SVMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import static net.IslamZaoui.sovietunionmememod.SVMod.MOD_ID;

public class ModSounds {
    public static final Identifier SV_SOUND_ID = new Identifier(MOD_ID, "sv_sound");
    public static SoundEvent SV_SOUND_EVENT = SoundEvent.of(SV_SOUND_ID);

    public static void registerModSounds() {
        SVMod.LOGGER.info("Registering Mod Sounds for " + SVMod.MOD_ID);
        Registry.register(Registries.SOUND_EVENT, SV_SOUND_ID, SV_SOUND_EVENT);
    }
}

package net.igdz77.svmod;

import net.fabricmc.api.ModInitializer;

import net.igdz77.svmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SVMod implements ModInitializer {
	public static final String MOD_ID = "svmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
	}
}
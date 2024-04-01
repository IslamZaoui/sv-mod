package net.IslamZaoui.sovietunionmememod.config;

import com.mojang.datafixers.util.Pair;
import net.IslamZaoui.sovietunionmememod.SVMod;

public class ModConfigs {
    public static final float DEFAULT_SOVIET_UNION_FLAG_DAMAGE = 2.5f;
    public static SimpleConfig CONFIG;
    public static float SOVIET_UNION_FLAG_DAMAGE;
    private static ModConfigProvider configs;

    public static void registerConfigs() {
        configs = new ModConfigProvider();
        createConfigs();

        CONFIG = SimpleConfig.of(SVMod.MOD_ID + "config").provider(configs).request();

        assignConfigs();
    }

    private static void createConfigs() {
        configs.addKeyValuePair(new Pair<>("soviet.union.flag.damage", DEFAULT_SOVIET_UNION_FLAG_DAMAGE), "float");
    }

    private static void assignConfigs() {
        SOVIET_UNION_FLAG_DAMAGE = (float) CONFIG.getOrDefault("soviet.union.flag.damage", DEFAULT_SOVIET_UNION_FLAG_DAMAGE);

        System.out.println("All " + configs.getConfigsList().size() + " have been set properly");
    }
}

package net.IslamZaoui.sovietunionmememod.util;

import net.IslamZaoui.sovietunionmememod.SVMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> GOLDEN_HAMMER_MINEABLE = createTag("golden_hammer_mineable");
        public static final TagKey<Block> GOLDEN_HAMMER_DOUBLE_DROPS_MINEABLE = createTag("golden_hammer_double_drops_mineable");
        public static final TagKey<Block> GOLDEN_SICKLE_MINEABLE = createTag("golden_sickle_mineable");

        public static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(SVMod.MOD_ID, name));
        }
    }
    public static class Items {
        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(SVMod.MOD_ID, name));
        }
    }
}

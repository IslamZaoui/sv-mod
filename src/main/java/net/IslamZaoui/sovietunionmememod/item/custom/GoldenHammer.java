package net.IslamZaoui.sovietunionmememod.item.custom;

import net.IslamZaoui.sovietunionmememod.util.ModTags;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;

public class GoldenHammer extends MiningToolItem {
    public GoldenHammer(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(attackDamage, attackSpeed, material, ModTags.Blocks.GOLDEN_HAMMER_MINEABLE, settings);
    }
}
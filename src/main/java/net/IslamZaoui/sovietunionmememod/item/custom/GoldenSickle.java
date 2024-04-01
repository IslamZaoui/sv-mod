package net.IslamZaoui.sovietunionmememod.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class GoldenSickle extends SwordItem {

    public GoldenSickle(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 75), attacker);
        attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 2));
        return super.postHit(stack, target, attacker);
    }
}

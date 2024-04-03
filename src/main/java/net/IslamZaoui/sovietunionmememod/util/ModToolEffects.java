package net.IslamZaoui.sovietunionmememod.util;

import net.IslamZaoui.sovietunionmememod.item.ModItems;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;

import java.util.List;

import static net.IslamZaoui.sovietunionmememod.SVMod.CGL;

public class ModToolEffects {
    private static final List<StatusEffectInstance> EFFECTS = List.of(
            new StatusEffectInstance(StatusEffects.SPEED, 200, 1, false, false, false),
            new StatusEffectInstance(StatusEffects.HASTE, 200, 1, false, false, false),
            new StatusEffectInstance(StatusEffects.GLOWING, 200, 1, true, false, false)
    );

    public static void tickEffects(Entity entity) {
        if (entity instanceof LivingEntity livingEntity) {
            if (hasBothHandsEquipped(livingEntity))
                evaluateEffects(livingEntity);
            else {
                resetGlowColor(livingEntity);
            }
        }
    }

    private static void evaluateEffects(LivingEntity livingEntity) {
        if (hasCorrectToolsEquipped(livingEntity))
            addStatusEffects(livingEntity);
    }

    private static void addStatusEffects(LivingEntity livingEntity) {
        boolean hasAllEffects = true;

        for (StatusEffectInstance statusEffect : ModToolEffects.EFFECTS) {
            if (!livingEntity.hasStatusEffect(statusEffect.getEffectType())) {
                hasAllEffects = false;
                break;
            }
        }

        if (hasCorrectToolsEquipped(livingEntity)) {
            setGlowColor(livingEntity);
            if (!hasAllEffects) {
                for (StatusEffectInstance statusEffect : ModToolEffects.EFFECTS) {
                    livingEntity.addStatusEffect(new StatusEffectInstance(statusEffect));
                }
            }
        } else {
            resetGlowColor(livingEntity);
        }
    }

    private static void setGlowColor(LivingEntity livingEntity) {
        if (FabricLoader.getInstance().isModLoaded("coloredglowlib") && CGL != null)
            if (CGL.hasCustomColor(livingEntity))
                CGL.setColor(livingEntity, "soviet_union");
    }

    private static void resetGlowColor(LivingEntity livingEntity) {
        if (FabricLoader.getInstance().isModLoaded("coloredglowlib") && CGL != null)
            CGL.clearColor(livingEntity, true);
    }

    private static boolean hasCorrectToolsEquipped(LivingEntity livingEntity) {
        ItemStack mainHandStack = livingEntity.getMainHandStack();
        ItemStack offHandStack = livingEntity.getOffHandStack();

        return (mainHandStack.isOf(ModItems.GOLDEN_HAMMER) && offHandStack.isOf(ModItems.GOLDEN_SICKLE))
                || (mainHandStack.isOf(ModItems.GOLDEN_SICKLE) && offHandStack.isOf(ModItems.GOLDEN_HAMMER));
    }

    private static boolean hasBothHandsEquipped(LivingEntity livingEntity) {
        ItemStack mainHand = livingEntity.getMainHandStack();
        ItemStack offHand = livingEntity.getOffHandStack();
        return !mainHand.isEmpty() && !offHand.isEmpty();
    }
}

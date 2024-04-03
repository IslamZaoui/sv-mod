package net.IslamZaoui.sovietunionmememod.item.custom;

import net.IslamZaoui.sovietunionmememod.util.ModTags;
import net.IslamZaoui.sovietunionmememod.util.ModToolEffects;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import java.util.List;

public class GoldenHammer extends MiningToolItem {
    public GoldenHammer(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(attackDamage, attackSpeed, material, ModTags.Blocks.GOLDEN_HAMMER_MINEABLE, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.sovietunionmememod.golden_hammer.tooltip1"));
        if(Screen.hasShiftDown()){
            tooltip.add(Text.translatable("item.sovietunionmememod.golden_hammer.tooltip2"));
        }
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (!world.isClient) {
            if (state.isIn(ModTags.Blocks.GOLDEN_HAMMER_DOUBLE_DROPS_MINEABLE))
                Block.dropStacks(state, world, pos, null, miner, miner.getMainHandStack());
        }
        return super.postMine(stack, world, state, pos, miner);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient())
            ModToolEffects.tickEffects(entity);
        super.inventoryTick(stack, world, entity, slot, selected);
    }
}

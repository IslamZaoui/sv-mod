package net.IslamZaoui.sovietunionmememod.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.block.BeetrootsBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static net.IslamZaoui.sovietunionmememod.util.ModTags.Blocks.GOLDEN_SICKLE_MINEABLE;


public class GoldenSickle extends ToolItem implements Vanishable {
    private final float attackDamage;
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

    public GoldenSickle(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material,settings);
        this.attackDamage = attackDamage;
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Weapon modifier", this.attackDamage, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Weapon modifier", attackSpeed, EntityAttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.sovietunionmememod.golden_sickle.tooltip1"));
        if(Screen.hasShiftDown()){
            tooltip.add(Text.translatable("item.sovietunionmememod.golden_sickle.tooltip2"));
        }
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        var player = context.getPlayer();
        var world = context.getWorld();
        if(player != null) {
            if (player.isSneaking()) return ActionResult.PASS;
            BlockState blockState = world.getBlockState(context.getBlockPos());
            BlockPos pos = context.getBlockPos();
            if (blockState.getBlock() instanceof BeetrootsBlock) {
                int age = blockState.get(Properties.AGE_3);
                if (age == 3) {
                    world.breakBlock(pos,true,player);
                    world.setBlockState(pos,blockState.with(BeetrootsBlock.AGE,0));
                    context.getStack().damage(1, player, p -> p.sendToolBreakStatus(context.getHand()));
                    return ActionResult.SUCCESS;
                }
                return ActionResult.PASS;
            }
            if (blockState.getBlock() instanceof CropBlock) {
                int age = blockState.get(CropBlock.AGE);
                if (age == 7) {
                    world.breakBlock(pos,true,player);
                    world.setBlockState(pos,blockState.with(CropBlock.AGE,0));
                    context.getStack().damage(1, player, p -> p.sendToolBreakStatus(context.getHand()));
                    return ActionResult.SUCCESS;
                }
            }
        }
        return ActionResult.PASS;
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        return super.useOnEntity(stack, user, entity, hand);
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        if (state.isIn(GOLDEN_SICKLE_MINEABLE)) {
            return 15.0f;
        }
        return state.isIn(BlockTags.SWORD_EFFICIENT) ? 1.5f : 1.0f;
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1, attacker, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        return true;
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if(state.isIn(GOLDEN_SICKLE_MINEABLE)) {
            stack.damage(1, miner, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        }
        else if (state.getHardness(world, pos) != 0.0f) {
            stack.damage(2, miner, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        }
        return true;
    }

    @Override
    public boolean isSuitableFor(BlockState state) {
        return state.isIn(GOLDEN_SICKLE_MINEABLE);
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        if (slot == EquipmentSlot.MAINHAND) {
            return this.attributeModifiers;
        }
        return super.getAttributeModifiers(slot);
    }
}
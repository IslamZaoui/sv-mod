package net.IslamZaoui.sovietunionmememod.item.custom;

import net.IslamZaoui.sovietunionmememod.sound.ModSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.s2c.play.StopSoundS2CPacket;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Predicate;

public class SovietUnionFlag extends BowItem {

    public SovietUnionFlag(FabricItemSettings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.sovietunionmememod.soviet_union_flag.tooltip"));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        world.playSound(user, user.getBlockPos(), ModSounds.SV_SOUND_EVENT, SoundCategory.PLAYERS, 1f, 1f);
        ItemStack itemStack = user.getStackInHand(hand);
        user.setCurrentHand(hand);
        return TypedActionResult.consume(itemStack);
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (world.isClient) {
            MinecraftClient.getInstance().getSoundManager().stopSounds(ModSounds.SV_SOUND_ID, SoundCategory.PLAYERS);
        } else {
            ServerWorld serverWorld = (ServerWorld) world;
            serverWorld.getPlayers().forEach(player -> player.networkHandler.sendPacket(new StopSoundS2CPacket(ModSounds.SV_SOUND_ID, SoundCategory.PLAYERS)));
        }
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 5200;
    }

    @Override
    public int getRange() {
        return 0;
    }

    @Override
    public Predicate<ItemStack> getProjectiles() {
        return ItemStack::isEmpty;
    }

    @Override
    public boolean isFireproof() {
        return true;
    }
}

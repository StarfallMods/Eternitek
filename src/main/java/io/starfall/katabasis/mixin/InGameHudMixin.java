package io.starfall.katabasis.mixin;

import io.starfall.katabasis.Katabasis;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

// Removed from Mixin config intentionally
// Will be added back once time is right
@Mixin(InGameHud.class)
public abstract class InGameHudMixin {

    @Unique
    private static final Identifier NEW_HOTBAR_TEXTURE = Katabasis.id("textures/gui/sprites/hud/hotbar.png");
    @Unique
    private static final Identifier NEW_HOTBAR_SELECTION_TEXTURE = Katabasis.id("textures/gui/sprites/hud/hotbar_selector.png");

    @Shadow @Nullable protected abstract PlayerEntity getCameraPlayer();

    @Shadow protected abstract void renderHotbarItem(DrawContext context, int x, int y, float tickDelta, PlayerEntity player, ItemStack stack, int seed);

    @Redirect(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/hud/InGameHud;renderHotbar(FLnet/minecraft/client/gui/DrawContext;)V"))
    private void katabasis$renderNewHotbar(InGameHud instance, float tickDelta, DrawContext context) {
        PlayerEntity player = this.getCameraPlayer();

        int scaledHeight = context.getScaledWindowHeight();
        int scaledWidth = context.getScaledWindowWidth();
        int halfWidth = scaledWidth / 2;

        if(player != null) {

            int hotbarWidth = 194;
            int hotbarHeight = 30;
            context.drawTexture(
                NEW_HOTBAR_TEXTURE,
                halfWidth - (hotbarWidth / 2),
                scaledHeight - (hotbarHeight + 6),
                0,
                0,
                hotbarWidth,
                hotbarHeight,
                hotbarWidth,
                hotbarHeight
            );

            int selectorSize = 20;
            context.drawTexture(
                NEW_HOTBAR_SELECTION_TEXTURE,
                (halfWidth - 90) + (player.getInventory().selectedSlot * 20),
                scaledHeight - (selectorSize + 12),
                0,
                0,
                selectorSize,
                selectorSize,
                selectorSize,
                selectorSize
            );

            for(int i = 0; i < 9; i++) {

                this.renderHotbarItem(
                    context,
                    (halfWidth - 90) + (i * 20) + 2,
                    scaledHeight - 30,
                    tickDelta,
                    player,
                    player.getInventory().main.get(i),
                    i
                );

            }

        }
    }

}

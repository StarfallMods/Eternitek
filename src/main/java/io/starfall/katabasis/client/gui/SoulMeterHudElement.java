package io.starfall.katabasis.client.gui;

import io.starfall.katabasis.Katabasis;
import io.starfall.katabasis.registry.KatabasisComponents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class SoulMeterHudElement {

	public static final Identifier SOUL_METER_TEXTURE = Katabasis.id("textures/gui/soul_meter.png");

	public static void render(DrawContext drawContext, float tickDelta) {

		int windowHeight = drawContext.getScaledWindowHeight();
		PlayerEntity player = MinecraftClient.getInstance().player;

		int soul = player == null ? 0 : KatabasisComponents.SOUL.get(player).getValue();

		int meterX = 10;
		int meterY = windowHeight - (10 + 45);
		drawContext.drawTexture(
			SOUL_METER_TEXTURE,
			meterX,
			meterY,
			0,
			0,
			21,
			45,
			32,
			64
		);

		drawContext.drawTexture(
			SOUL_METER_TEXTURE,
			meterX + 8,
			(meterY + 42) - soul,
			21,
			39 - soul,
			5,
			soul,
			32,
			64
		);

	}

}

package io.starfall.katabasis;

import io.starfall.katabasis.client.gui.SoulMeterHudElement;
import io.starfall.katabasis.entity.renderer.ThrownWeaponEntityRenderer;
import io.starfall.katabasis.item.Disciplined;
import io.starfall.katabasis.registry.KatabasisEntityTypes;
import io.starfall.katabasis.registry.KatabasisItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.impl.resource.loader.*;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.resource.DefaultClientResourcePackProvider;
import net.minecraft.client.resource.server.ServerResourcePackLoader;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.resource.ResourcePackProvider;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

@Environment(EnvType.CLIENT)
public class KatabasisClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {

		EntityRendererRegistry.register(KatabasisEntityTypes.KNIFE, ThrownWeaponEntityRenderer::new);

		HudRenderCallback.EVENT.register(SoulMeterHudElement::render);

		ItemTooltipCallback.EVENT.register(KatabasisClient::appendDisciplineTooltip);

		ModelLoadingPlugin.register(KatabasisClient::registerHeldItemModels);

	}

	private static void appendDisciplineTooltip(ItemStack stack, TooltipContext context, List<Text> lines) {

		if(stack.getItem() instanceof Disciplined item) {
			lines.add(1, item.getDiscipline().getName());
		}

	}

	private static void registerHeldItemModels(ModelLoadingPlugin.Context context) {
		for(Identifier id : KatabasisItems.models) {
			context.addModels(new ModelIdentifier(id, "inventory"));
		}
	}

}

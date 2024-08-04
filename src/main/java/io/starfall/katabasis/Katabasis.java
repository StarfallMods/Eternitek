package io.starfall.katabasis;

import io.starfall.katabasis.registry.KatabasisAttributes;
import io.starfall.katabasis.registry.KatabasisBlocks;
import io.starfall.katabasis.registry.KatabasisItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import team.lodestar.lodestone.registry.common.particle.LodestoneScreenParticleRegistry;

public class Katabasis implements ModInitializer {

	public static final String NAME = "Katabasis";
	public static final String ID = NAME.toLowerCase();
	public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

	@Override
	public void onInitialize() {

		KatabasisAttributes.register();
		KatabasisBlocks.register();
		// Components register automatically
		// Entity types register automatically
		KatabasisItems.register();

		LOGGER.info("Loaded successfully");

	}

	public static Identifier id(String path) {
		return new Identifier(ID, path);
	}

	public static ModContainer getModContainer() {
		return FabricLoader.getInstance().getModContainer(Katabasis.ID).orElseThrow(() -> new IllegalStateException("Couldn't find a ModContainer for Katabasis"));
	}

}

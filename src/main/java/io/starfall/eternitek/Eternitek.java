package io.starfall.eternitek;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Eternitek implements ModInitializer {

	public static final String NAME = "Eternitek";
	public static final String ID = NAME.toLowerCase();
	public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

	@Override
	public void onInitialize() {

		LOGGER.info("Loaded successfully");

	}

	public static Identifier id(String path) {
		return Identifier.of(ID, path);
	}

	public static ModContainer getModContainer() {
		return FabricLoader.getInstance().getModContainer(Eternitek.ID).orElseThrow(() -> new IllegalStateException("Couldn't find a ModContainer for Eternitek"));
	}

}

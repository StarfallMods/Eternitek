package io.starfall.katabasis.registry;

import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import io.starfall.katabasis.Katabasis;
import io.starfall.katabasis.components.IntegerComponent;
import io.starfall.katabasis.components.SoulComponent;
import net.minecraft.entity.player.PlayerEntity;

public class KatabasisComponents implements EntityComponentInitializer {

	// TO-DO: Fix this once CCA is installed

	public static final ComponentKey<IntegerComponent> SOUL = ComponentRegistry.getOrCreate(
		Katabasis.id("soul"),
		IntegerComponent.class
	);

	@Override
	public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
		registry.registerFor(PlayerEntity.class, SOUL, SoulComponent::new);
	}

}

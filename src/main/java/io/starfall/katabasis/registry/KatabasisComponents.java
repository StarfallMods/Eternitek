package io.starfall.katabasis.registry;

import dev.onyxstudios.cca.api.v3.component.Component;
import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import dev.onyxstudios.cca.api.v3.item.ItemComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.item.ItemComponentInitializer;
import io.starfall.katabasis.Katabasis;
import io.starfall.katabasis.components.EnumComponent;
import io.starfall.katabasis.components.IntegerComponent;
import io.starfall.katabasis.components.SoulComponent;
import io.starfall.katabasis.item.Disciplined;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.SwordItem;

public class KatabasisComponents implements EntityComponentInitializer {

	public static final ComponentKey<IntegerComponent> SOUL = ComponentRegistry.getOrCreate(
		Katabasis.id("soul"),
		IntegerComponent.class
	);

//	public static final ComponentKey<EnumComponent> DISCIPLINE = ComponentRegistry.getOrCreate(
//		Katabasis.id("discipline"),
//		EnumComponent.class
//	);

	@Override
	public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
		registry.registerFor(LivingEntity.class, SOUL, SoulComponent::new);
	}

}

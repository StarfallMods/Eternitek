package io.starfall.katabasis.registry;

import io.starfall.katabasis.Katabasis;
import net.minecraft.entity.attribute.ClampedEntityAttribute;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class KatabasisAttributes {

	public static final EntityAttribute MAGE_DAMAGE = createAttribute("mage_damage", 0.0, 0.0, 7.0).setTracked(true);
	public static final EntityAttribute MELEE_DAMAGE = createAttribute("melee_damage", 0.0, 0.0, 7.0).setTracked(true);
	public static final EntityAttribute RANGER_DAMAGE = createAttribute("ranger_damage", 0.0, 0.0, 7.0).setTracked(true);
	public static final EntityAttribute ROGUE_DAMAGE = createAttribute("rogue_damage", 0.0, 0.0, 7.0).setTracked(true);

	public static void register() {

		registerAttribute("mage_damage", MAGE_DAMAGE);
		registerAttribute("melee_damage", MELEE_DAMAGE);
		registerAttribute("ranger_damage", RANGER_DAMAGE);
		registerAttribute("rogue_damage", ROGUE_DAMAGE);

	}

	public static EntityAttribute createAttribute(String name, double base, double min, double max) {
		return new ClampedEntityAttribute("attribute.name.generic." + Katabasis.ID + "." + name, base, min, max);
	}

	public static void registerAttribute(String name, EntityAttribute attribute) {
		Registry.register(Registries.ATTRIBUTE, Katabasis.id(name), attribute);
	}


}

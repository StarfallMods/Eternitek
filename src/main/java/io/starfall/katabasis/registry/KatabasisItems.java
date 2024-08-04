package io.starfall.katabasis.registry;

import io.starfall.katabasis.Katabasis;
import io.starfall.katabasis.item.SeparatePerspective;
import io.starfall.katabasis.item.mage.TwistedQuarterstaffItem;
import io.starfall.katabasis.item.melee.GlaiveItem;
import io.starfall.katabasis.item.melee.MaceItem;
import io.starfall.katabasis.item.rogue.HatchetItem;
import io.starfall.katabasis.item.rogue.KnifeItem;
import io.starfall.katabasis.item.rogue.ScytheItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class KatabasisItems {

	public static List<Identifier> models = new ArrayList<>();

	public static final Item MACE = new MaceItem(ToolMaterials.NETHERITE, 9, -3.4F, "mace_hand");
	public static final Item GLAIVE = new GlaiveItem(ToolMaterials.NETHERITE, 9, -3.4F, "glaive_hand");
	public static final Item SCYTHE = new ScytheItem(ToolMaterials.NETHERITE, 9, -3.4F, "scythe_hand");

	public static final Item KNIFE = new KnifeItem(ToolMaterials.NETHERITE, 2, -1.1F, new FabricItemSettings().maxCount(128));
	public static final Item HATCHET = new HatchetItem(new FabricItemSettings());

	public static final Item TWISTED_QUARTERSTAFF = new TwistedQuarterstaffItem(new FabricItemSettings().maxCount(1), "twisted_quarterstaff_hand");

	public static void register() {

		registerItem("mace", MACE);
		registerItem("glaive", GLAIVE);
		registerItem("scythe", SCYTHE);

		registerItem("knife", KNIFE);
		registerItem("hatchet", HATCHET);

		registerItem("twisted_quarterstaff", TWISTED_QUARTERSTAFF);

	}

	public static void registerItem(String name, Item item) {
		if(item instanceof SeparatePerspective spItem) {
			models.add(spItem.getHeldModelIdentifier());
		}
		Registry.register(Registries.ITEM, Katabasis.id(name), item);
	}

}

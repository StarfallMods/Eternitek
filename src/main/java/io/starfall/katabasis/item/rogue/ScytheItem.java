package io.starfall.katabasis.item.rogue;

import io.starfall.katabasis.Katabasis;
import io.starfall.katabasis.item.Disciplined;
import io.starfall.katabasis.item.SeparatePerspective;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Identifier;

public class ScytheItem extends BaseRogueItem implements SeparatePerspective {

	private final Identifier heldModel;

	public ScytheItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, String heldModel) {
		super(toolMaterial, attackDamage, attackSpeed, new FabricItemSettings());
		this.heldModel = Katabasis.id(heldModel);
	}

	@Override
	public Identifier getHeldModelIdentifier() {
		return heldModel;
	}

}

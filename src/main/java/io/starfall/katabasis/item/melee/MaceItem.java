package io.starfall.katabasis.item.melee;

import io.starfall.katabasis.Katabasis;
import io.starfall.katabasis.item.SeparatePerspective;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Identifier;

public class MaceItem extends SwordItem implements SeparatePerspective {

	private Identifier heldModel;

	public MaceItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, String heldModel) {
		super(toolMaterial, attackDamage, attackSpeed, new FabricItemSettings());
		this.heldModel = Katabasis.id(heldModel);
	}

	@Override
	public Identifier getHeldModelIdentifier() {
		return heldModel;
	}

}

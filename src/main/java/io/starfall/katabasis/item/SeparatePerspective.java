package io.starfall.katabasis.item;

import io.starfall.katabasis.Katabasis;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.util.Identifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface SeparatePerspective {

	List<ModelTransformationMode> INVENTORY = List.of(
		ModelTransformationMode.GUI,
		ModelTransformationMode.GROUND,
		ModelTransformationMode.FIXED
	);

	// All you need to do is implement this method and return your instance of heldModel, however you want to do that.
	Identifier getHeldModelIdentifier();

	// If you want to do something custom, just reimplement this method; default serves as an example here.
	@Environment(EnvType.CLIENT)
	default ModelIdentifier getHeldModel(ModelTransformationMode mode) {
		return INVENTORY.contains(mode) ? null : new ModelIdentifier(getHeldModelIdentifier(), "inventory");
	}

}

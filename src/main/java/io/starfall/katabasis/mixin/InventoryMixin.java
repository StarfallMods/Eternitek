package io.starfall.katabasis.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.inventory.Inventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Inventory.class)
public interface InventoryMixin {

	@Inject(method = "getMaxCountPerStack", at = @At("RETURN"), cancellable = true)
	private void getMaxCountPerStack(CallbackInfoReturnable<Integer> cir){
		cir.setReturnValue(128);
	}

}

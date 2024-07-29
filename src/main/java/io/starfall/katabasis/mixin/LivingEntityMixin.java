package io.starfall.katabasis.mixin;

import io.starfall.katabasis.registry.KatabasisComponents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

	@Inject(method = "damage", at = @At("HEAD"))
	private void katabasis$addSoul(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {

		if(source.getSource() instanceof PlayerEntity player) {
			KatabasisComponents.SOUL.get(player).increment();
		}

	}

}

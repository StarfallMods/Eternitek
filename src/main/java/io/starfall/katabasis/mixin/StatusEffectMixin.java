package io.starfall.katabasis.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import io.starfall.katabasis.Katabasis;
import io.starfall.katabasis.util.PotionColor;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(StatusEffect.class)
public abstract class StatusEffectMixin {

	@Shadow
	public abstract Text getName();

	@Shadow
	public abstract int getColor();

	@ModifyReturnValue(method = "getColor", at = @At(value = "RETURN"))
	public int katabasis$setPotionColors(int original) {
		int color;
		try {
			color = PotionColor.valueOf(this.getName().getString().toUpperCase().replace(' ', '_')).getColor();
		} catch(IllegalArgumentException exception) {
			return original;
		}
		return color;
	}

}

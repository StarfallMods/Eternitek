package io.starfall.katabasis.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import io.starfall.katabasis.registry.KatabasisAttributes;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {

    @WrapOperation(method = "attack", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;getAttributeValue(Lnet/minecraft/entity/attribute/EntityAttribute;)D"))
    public double katabasis$addDisciplineDamage(PlayerEntity instance, EntityAttribute entityAttribute, Operation<Double> original) {
        return original.call(instance, entityAttribute) +
                instance.getAttributeValue(KatabasisAttributes.MAGE_DAMAGE) +
                instance.getAttributeValue(KatabasisAttributes.MELEE_DAMAGE) +
                instance.getAttributeValue(KatabasisAttributes.RANGER_DAMAGE) +
                instance.getAttributeValue(KatabasisAttributes.ROGUE_DAMAGE);
    }

    @ModifyReturnValue(method = "createPlayerAttributes", at = @At("RETURN"))
    private static DefaultAttributeContainer.Builder katabasis$addDefaultDisciplineAttributes(DefaultAttributeContainer.Builder original) {
        return original
                .add(KatabasisAttributes.MAGE_DAMAGE)
                .add(KatabasisAttributes.MELEE_DAMAGE)
                .add(KatabasisAttributes.RANGER_DAMAGE)
                .add(KatabasisAttributes.ROGUE_DAMAGE);
    }

}

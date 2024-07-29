package io.starfall.katabasis.entity;

import io.starfall.katabasis.registry.KatabasisEntityTypes;
import io.starfall.katabasis.registry.KatabasisItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

public class KnifeEntity extends ThrownWeaponEntity {

	public KnifeEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
		super(entityType, world, KatabasisItems.KNIFE.getDefaultStack());
	}

	public KnifeEntity(World world, LivingEntity user, ItemStack stack) {
		super(KatabasisEntityTypes.KNIFE, user, world, stack);
		this.stack = stack.copy();
	}

	@Override
	protected SoundEvent getHitSound() {
		return SoundEvents.ENTITY_PLAYER_ATTACK_KNOCKBACK;
	}

}

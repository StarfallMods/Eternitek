package io.starfall.katabasis.entity;

import io.starfall.katabasis.Katabasis;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public abstract class ThrownWeaponEntity extends PersistentProjectileEntity {

	protected ItemStack stack;

	protected ThrownWeaponEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world, ItemStack stack) {
		super(entityType, world, stack);
		this.stack = stack;
	}

	protected ThrownWeaponEntity(EntityType<? extends PersistentProjectileEntity> entityType, double d, double e, double f, World world, ItemStack stack) {
		super(entityType, d, e, f, world, stack);
		this.stack = stack;
	}

	protected ThrownWeaponEntity(EntityType<? extends PersistentProjectileEntity> entityType, LivingEntity livingEntity, World world, ItemStack stack) {
		super(entityType, livingEntity, world, stack);
		this.stack = stack;
	}

	@Override
	public ItemStack asItemStack() {
		return this.stack.copy();
	}



}

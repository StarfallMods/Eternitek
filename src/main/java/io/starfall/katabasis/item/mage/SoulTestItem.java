package io.starfall.katabasis.item.mage;

import io.starfall.katabasis.registry.KatabasisComponents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class SoulTestItem extends Item {

	public SoulTestItem(Settings settings) {
		super(settings);
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

		KatabasisComponents.SOUL.get(user).setValue(0);
		if(world instanceof ServerWorld server) {
			server.spawnParticles(
				ParticleTypes.SOUL,
				user.getX(),
				user.getY(),
				user.getZ(),
				10,
				0.1,
				0.1,
				0.1,
				1000
			);
		}

		return super.use(world, user, hand);

	}

}

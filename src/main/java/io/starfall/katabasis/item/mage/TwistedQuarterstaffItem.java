package io.starfall.katabasis.item.mage;

import io.starfall.katabasis.Katabasis;
import io.starfall.katabasis.components.IntegerComponent;
import io.starfall.katabasis.components.SoulComponent;
import io.starfall.katabasis.item.Disciplined;
import io.starfall.katabasis.item.SeparatePerspective;
import io.starfall.katabasis.registry.KatabasisComponents;
import io.starfall.katabasis.registry.KatabasisItems;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import team.lodestar.lodestone.handlers.screenparticle.ParticleEmitterHandler;
import team.lodestar.lodestone.registry.common.particle.LodestoneParticleRegistry;
import team.lodestar.lodestone.registry.common.particle.LodestoneScreenParticleRegistry;
import team.lodestar.lodestone.systems.easing.Easing;
import team.lodestar.lodestone.systems.particle.builder.ScreenParticleBuilder;
import team.lodestar.lodestone.systems.particle.builder.WorldParticleBuilder;
import team.lodestar.lodestone.systems.particle.data.GenericParticleData;
import team.lodestar.lodestone.systems.particle.data.color.ColorParticleData;
import team.lodestar.lodestone.systems.particle.screen.ScreenParticleHolder;
import team.lodestar.lodestone.systems.particle.world.type.LodestoneWorldParticleType;

import java.awt.*;

public class TwistedQuarterstaffItem extends Item implements ParticleEmitterHandler.ItemParticleSupplier, SeparatePerspective, Disciplined {

	private final Identifier heldModel;

	private static final Color startingColor = new Color(105, 97, 212);
	private static final Color endingColor = new Color(141, 250, 254);

	public TwistedQuarterstaffItem(Item.Settings settings, String heldModel) {
		super(settings);
		this.heldModel = Katabasis.id(heldModel);
	}

	@Override
	public Identifier getHeldModelIdentifier() {
		return heldModel;
	}

	@Override
	public Discipline getDiscipline() {
		return Discipline.MAGE;
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

		IntegerComponent soulComponent = KatabasisComponents.SOUL.get(user);
		int soul = soulComponent.getValue();
		boolean creative = user.getAbilities().creativeMode;

		if (soul > 0 || creative) {
			spawnParticleCircle(world, user);
			if(!creative) soulComponent.decrement();
		}

		return TypedActionResult.pass(user.getStackInHand(hand));

	}

	@Override
	public void spawnLateParticles(ScreenParticleHolder target, World level, float partialTick, ItemStack stack, float x, float y) {
		ScreenParticleBuilder.create(LodestoneScreenParticleRegistry.STAR, target)
			.setColorData(ColorParticleData.create(startingColor, endingColor).setCoefficient(1.4F).setEasing(Easing.CUBIC_IN_OUT).build())
			.setTransparencyData(GenericParticleData.create(0.55F, 0.15F).build())
			.setScaleData(GenericParticleData.create(0.45F, 0).build())
			.setLifetime(15)
			.setRandomMotion(1)
			.addMotion(1.0, -1.0)
			.spawn(x + 4, y - 4);
	}

	private static void spawnParticleCircle(World world, LivingEntity user) {

		WorldParticleBuilder.create(LodestoneParticleRegistry.STAR_PARTICLE)
			.setColorData(ColorParticleData.create(startingColor, endingColor).setCoefficient(1.4F).setEasing(Easing.CUBIC_IN_OUT).build())
			.setTransparencyData(GenericParticleData.create(0.55F, 0.15F).build())
			.setScaleData(GenericParticleData.create(0.45F, 0).build())
			.setLifetime(60)
			.repeatCircle(world, user.getX(), user.getY() + 0.25, user.getZ(), 5.0, 100);

	}

}

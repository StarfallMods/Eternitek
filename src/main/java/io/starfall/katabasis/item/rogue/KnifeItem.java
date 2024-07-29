package io.starfall.katabasis.item.rogue;

import io.starfall.katabasis.entity.KnifeEntity;
import io.starfall.katabasis.item.Disciplined;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class KnifeItem extends SwordItem implements Disciplined {

	public KnifeItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
		super(toolMaterial, attackDamage, attackSpeed, settings);
	}

	@Override
	public Discipline getDiscipline() {
		return Discipline.ROGUE;
	}

	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		ItemStack itemStack = user.getStackInHand(hand);
		if (!world.isClient) {

			KnifeEntity entity = new KnifeEntity(world, user, itemStack.copyWithCount(1));
			entity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 1.0F);

			if (user.getAbilities().creativeMode) {
				entity.pickupType = PersistentProjectileEntity.PickupPermission.CREATIVE_ONLY;
			}

			world.spawnEntity(entity);
			world.playSoundFromEntity(null, entity, SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, SoundCategory.NEUTRAL, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));

			if (!user.getAbilities().creativeMode) {
				int slotStack = user.getInventory().getSlotWithStack(itemStack);
				user.getInventory().setStack(slotStack, itemStack.copyWithCount(itemStack.getCount() - 1));
			}

		}

		user.incrementStat(Stats.USED.getOrCreateStat(this));
		return TypedActionResult.success(itemStack, world.isClient());

	}

}

package io.starfall.katabasis.item.rogue;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import io.starfall.katabasis.item.Disciplined;
import io.starfall.katabasis.registry.KatabasisAttributes;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

import java.util.UUID;

public class BaseRogueItem extends Item implements Disciplined {

    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

	public BaseRogueItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
		super(settings);
        float combinedAttackDamage = attackDamage + material.getAttackDamage();

		ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
			builder.put(KatabasisAttributes.ROGUE_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Weapon modifier", combinedAttackDamage, EntityAttributeModifier.Operation.ADDITION));
			builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Weapon modifier", attackSpeed, EntityAttributeModifier.Operation.ADDITION));
		this.attributeModifiers = builder.build();
	}

	@Override
	public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
		return super.getMiningSpeedMultiplier(stack, state);
	}

	@Override
	public Discipline getDiscipline() {
		return Discipline.ROGUE;
	}

	@Override
	public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
		return slot == EquipmentSlot.MAINHAND ? this.attributeModifiers : super.getAttributeModifiers(slot);
	}

}

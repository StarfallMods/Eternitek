package io.starfall.katabasis.item.rogue;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import io.starfall.katabasis.item.Disciplined;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class BaseRogueItem extends Item implements Disciplined {

	private final float attackDamage;
	private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

	public BaseRogueItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
		super(settings);
		this.attackDamage = attackDamage + material.getAttackDamage();
		ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
		this.attributeModifiers = builder.build();
	}

	public float getAttackDamage() {
		return this.attackDamage;
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

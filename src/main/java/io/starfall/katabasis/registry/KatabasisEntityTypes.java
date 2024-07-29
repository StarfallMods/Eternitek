package io.starfall.katabasis.registry;

import io.starfall.katabasis.Katabasis;
import io.starfall.katabasis.block.entity.MagneticBlockEntity;
import io.starfall.katabasis.entity.KnifeEntity;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class KatabasisEntityTypes {

	public static final EntityType<KnifeEntity> KNIFE = registerEntity(
		"knife",
		SpawnGroup.MISC,
		KnifeEntity::new,
		EntityDimensions.fixed(0.40F, 0.40F),
		false
	);

	public static final BlockEntityType<MagneticBlockEntity> MAGNETIC_BLOCK = registerBlockEntity(
		"magnetic_block",
		KatabasisBlocks.MAGNETITE_BLOCK,
		MagneticBlockEntity::new
	);

	public static <T extends Entity> EntityType<T> registerEntity(String name, SpawnGroup group, EntityType.EntityFactory<T> factory , EntityDimensions dimensions, boolean fireImmune) {
		EntityType.Builder<T> builder = EntityType.Builder.create(factory, group).setDimensions(dimensions.width, dimensions.height);
		if (fireImmune) {
			builder = builder.makeFireImmune();
		}
		return Registry.register(Registries.ENTITY_TYPE, Katabasis.id(name),
			builder.build());
	}

	public static <T extends BlockEntity> BlockEntityType<T> registerBlockEntity(String name, Block block, BlockEntityType.BlockEntityFactory<T> factory) {
		BlockEntityType.Builder<T> builder = BlockEntityType.Builder.create(factory, block);
		return Registry.register(Registries.BLOCK_ENTITY_TYPE, Katabasis.id(name),
			builder.build());
	}

}

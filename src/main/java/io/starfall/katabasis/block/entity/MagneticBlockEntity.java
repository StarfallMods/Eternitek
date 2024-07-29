package io.starfall.katabasis.block.entity;

import io.starfall.katabasis.block.MagneticBlock;
import io.starfall.katabasis.registry.KatabasisEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

import javax.swing.text.html.parser.Entity;
import java.util.List;

public class MagneticBlockEntity extends BlockEntity implements BlockEntityTicker<MagneticBlockEntity> {

	public MagneticBlockEntity(BlockPos pos, BlockState state) {
		super(KatabasisEntityTypes.MAGNETIC_BLOCK, pos, state);
	}

	@Override
	public void tick(World world, BlockPos blockPos, BlockState blockState, MagneticBlockEntity blockEntity) {

		Box checkerBox = new Box(
			blockPos.getX() - 10,
			blockPos.getY() - 10,
			blockPos.getZ() - 10,
			blockPos.getX() + 10,
			blockPos.getY() + 10,
			blockPos.getZ() + 10
		);

		List<ItemEntity> items = world.getEntitiesByType(
			EntityType.ITEM,
			checkerBox,
			(item ) -> true
		);

		for(ItemEntity item : items) {
			item.setVelocity(item.getPos().subtract(blockPos.toCenterPos()));
		}

	}

}

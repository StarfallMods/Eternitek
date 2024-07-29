package io.starfall.katabasis.block;

import com.mojang.serialization.MapCodec;
import io.starfall.katabasis.block.entity.MagneticBlockEntity;
import io.starfall.katabasis.registry.KatabasisEntityTypes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class MagneticBlock extends BlockWithEntity {

	public MagneticBlock(Settings settings) {
		super(settings);
	}

	@Override
	protected MapCodec<? extends BlockWithEntity> getCodec() {
		return null;
	}

	@Nullable
	@Override
	public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
		return new MagneticBlockEntity(pos, state);
	}

	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
		return validateTicker(type, KatabasisEntityTypes.MAGNETIC_BLOCK, (world1, pos, state1, be) -> be.tick(world1, pos, state1, be));
	}
}

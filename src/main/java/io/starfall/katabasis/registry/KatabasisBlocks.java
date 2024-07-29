package io.starfall.katabasis.registry;

import io.starfall.katabasis.Katabasis;
import io.starfall.katabasis.block.MagneticBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class KatabasisBlocks {

	public static final Block MAGNETITE_BLOCK = new MagneticBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));

	public static void register() {

		registerBlockWithItem("magnetite_block", MAGNETITE_BLOCK);

	}

	public static void registerBlockWithItem(String name, Block block) {
		Registry.register(Registries.ITEM, Katabasis.id(name), new BlockItem(block, new FabricItemSettings()));
		registerBlock(name, block);
	}

	public static void registerBlock(String name, Block block) {
		Registry.register(Registries.BLOCK, Katabasis.id(name), block);
	}

}

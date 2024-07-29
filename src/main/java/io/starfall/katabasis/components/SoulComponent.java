package io.starfall.katabasis.components;

import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import io.starfall.katabasis.registry.KatabasisComponents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.MathHelper;

public class SoulComponent implements IntegerComponent, AutoSyncedComponent {

	private int soul = 0;
	private final PlayerEntity provider;

	public SoulComponent(PlayerEntity provider) {
		this.provider = provider;
	}

	@Override
	public void writeToNbt(NbtCompound tag) {
		tag.putInt("soul", this.soul);
	}

	@Override
	public void readFromNbt(NbtCompound tag) {
		this.setValue(tag.getInt("soul"));
	}

	@Override
	public void decrement() {
		this.add(-1);
	}

	@Override
	public void increment() {
		this.add(1);
	}

	@Override
	public void add(int value) {
		this.setValue(this.soul + value);
	}

	@Override
	public void subtract(int value) {
		this.add(-1 * value);
	}

	@Override
	public void setValue(int value) {
		this.soul = MathHelper.clamp(value, 0, 39);
		KatabasisComponents.SOUL.sync(this.provider);
	}

	@Override
	public int getValue() {
		return this.soul;
	}

}

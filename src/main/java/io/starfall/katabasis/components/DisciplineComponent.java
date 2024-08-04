package io.starfall.katabasis.components;

import io.starfall.katabasis.item.Disciplined;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;

public class DisciplineComponent implements EnumComponent<Disciplined.Discipline> {

    private Disciplined.Discipline discipline;
    private final ItemStack provider;

    public DisciplineComponent(ItemStack provider) {
        this.provider = provider;
    }

    @Override
    public void writeToNbt(NbtCompound tag) {
        tag.putString("discipline", this.discipline.getName().getString());
    }

    @Override
    public void readFromNbt(NbtCompound tag) {

    }

    @Override
    public Disciplined.Discipline getValue() {
        return null;
    }

    @Override
    public void setValue(Disciplined.Discipline value) {

    }

    @Override
    public void nextValue() {

    }

    @Override
    public void previousValue() {

    }

}

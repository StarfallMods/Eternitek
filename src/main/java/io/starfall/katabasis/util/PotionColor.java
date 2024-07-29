package io.starfall.katabasis.util;

public enum PotionColor {

	JUMP_BOOST(5882118);

	PotionColor(int color) {
		this.color = color;
	}

	private int color;

	public int getColor() {
		return color;
	}

}

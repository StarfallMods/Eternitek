package io.starfall.katabasis.item;

import net.minecraft.text.Style;
import net.minecraft.text.Text;

public interface Disciplined {

	Discipline getDiscipline();

	enum Discipline {

		MAGE("mage", 0x004478),
		MELEE("melee", 0x483742),
		RANGER("ranger", 0x896727),
		ROGUE("rogue", 0x872333);

		private final String translationKey;
		private final int color;

		Discipline(String translationKey, int color) {
			this.translationKey = "discipline.katabasis." + translationKey;
			this.color = color;
		}

		public Text getName() {
			return Text.translatable(translationKey).fillStyle(Style.EMPTY.withColor(color));
		}

	}

}

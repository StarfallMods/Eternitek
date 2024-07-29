package io.starfall.katabasis.components;

import dev.onyxstudios.cca.api.v3.component.Component;

public interface IntegerComponent extends Component {

	int getValue();
	void setValue(int value);

	void add(int value);
	void subtract(int value);

	void increment();
	void decrement();

}

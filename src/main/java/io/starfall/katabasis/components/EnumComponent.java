package io.starfall.katabasis.components;

import dev.onyxstudios.cca.api.v3.component.Component;

public interface EnumComponent<T extends Enum<T>> extends Component {

    T getValue();
    void setValue(T value);

    void nextValue();
    void previousValue();

}

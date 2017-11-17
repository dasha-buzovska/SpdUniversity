package pizzeria.goods.pizza;

import java.util.Optional;

public enum PizzaSize {
    NORMAL(Optional.of("Normal")), BIG(Optional.of("Big")), MAXI(Optional.of("Maxi"));
    private Optional<String> name;
    PizzaSize(Optional<String>  name) {
        this.name = name;
    }

    public Optional<String> getName() {
        return name;
    }
}

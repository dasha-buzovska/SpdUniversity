package pizzeria.goods.pizza;

import java.util.Optional;

public enum PizzaSize {
    NORMAL("Normal"), BIG("Big"), MAXI("Maxi");
    private String name;
    PizzaSize(String  name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

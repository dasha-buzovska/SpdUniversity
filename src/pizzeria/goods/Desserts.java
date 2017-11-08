package pizzeria.goods;

import pizzeria.goods.food.Eatable;
import pizzeria.goods.food.Good;

public enum Desserts implements Good, Eatable {
    PUN_CAKE("Pun-cake", 20), FONDANT("Fondant", 40), COOKIES("Cookies", 12), ICE_CREAM("Ice-cream", 10);

    private String name;
    private int price;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public boolean isVegetarian() {
        return true;
    }

    Desserts(String name, int price) {
        this.name = name;
        this.price = price;
    }

}

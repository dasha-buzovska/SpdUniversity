package pizzeria.goods.pizza;

import pizzeria.goods.food.Eatable;
import pizzeria.goods.food.Good;

public enum Ingredients implements Good, Eatable {
    CHEESE("Cheese", 5, true), SAUSAGE("Sausage", 8, false), PINEAPPLE("Pineapple", 7, true),
    CORN("Corn", 6, true), TOMATO("Tomato", 5, true), SALMON("Salmon", 12, true),
    CHICKEN("Chicken", 10, false), ONION("Onion", 4, true);
    private String name;
    private int price;
    private boolean isVegetarian;

    Ingredients(String name, int price, boolean isVegetarian) {
        this.name = name;
        this.price = price;
        this.isVegetarian = isVegetarian;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }
}


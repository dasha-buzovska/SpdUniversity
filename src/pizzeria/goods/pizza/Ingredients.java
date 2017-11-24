package pizzeria.goods.pizza;

import pizzeria.goods.GoodsTypes;
import pizzeria.goods.food.Eatable;
import pizzeria.goods.food.Good;

import java.util.Optional;

public enum Ingredients implements Good, Eatable {
    BASE("Base", 20, true), CHEESE("Cheese", 5, true), SAUSAGE("Sausage", 8, false), PINEAPPLE("Pineapple", 7, true),
    CORN("Corn", 6, true), TOMATO("Tomato", 5, true), SALMON("Salmon", 12, true),
    CHICKEN("Chicken", 10, false), ONION("Onion", 4, true), SAUCE("Sauce", 2, true), MUSHROOMS("Mushrooms", 6, true);
    private String name;
    private int price;
    private boolean isVegetarian;

    public GoodsTypes getType() {
        return GoodsTypes.INGREDIENT;
    }

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

    public static Optional<Ingredients> getByIndex(int index) {
        if (values().length < index) {
            return Optional.empty();
        }
        return Optional.of(values()[index]);
    }
}


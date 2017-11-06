package pizzeria.goods.pizza;

import pizzeria.interfaces.Eatable;
import pizzeria.interfaces.Good;
import pizzeria.interfaces.PizzaItem;

public enum Pizza implements Good, Eatable, PizzaItem {

    YOUR_PIZZA("Your pizza", 15, 20, 25, true), MARGARITA("Margarita", 35, 40, 45, true),
    PEPERONI("Peperoni", 45, 50, 55, false), FOUR_CHEESES("4 Cheeses", 50, 60, 70, true),
    SEAFOOD("Seafood", 70, 85, 100, true), HAWAIIAN("Hawaiian", 65, 70, 80, false);

    private String name;
    private int price;
    private int bigPrice;
    private int maxiPrice;
    private boolean isVegetarian;

    Pizza(String name, int price, int bigPrice, int maxiPrice, boolean isVegetarian) {
        this.name = name;
        this.price = price;
        this.bigPrice = bigPrice;
        this.maxiPrice = maxiPrice;
        this.isVegetarian = isVegetarian;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int getBigPrice() {
        return bigPrice;
    }

    @Override
    public int getMaxiPrice() {
        return maxiPrice;
    }

    @Override
    public boolean isVegetarian() {
        return isVegetarian;
    }
}

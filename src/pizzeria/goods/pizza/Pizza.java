package pizzeria.goods.pizza;

import pizzeria.goods.items.PizzaItem;

public class Pizza {

    public static final PizzaItem[] pizzas = new PizzaItem[]{
            new PizzaItem("Your pizza", 15, 20, 25),
            new PizzaItem("Margarita", 35, 40, 45),
            new PizzaItem("Peperoni", 45, 50, 55),
            new PizzaItem("4 Cheeses", 50, 60, 70),
            new PizzaItem("Seafood", 70, 85, 100)
    };
}

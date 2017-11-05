package pizzeria.goods.pizza;

import pizzeria.goods.items.PizzaItem;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

    public static final ArrayList<PizzaItem> pizzas = new ArrayList<>();

    static {
        pizzas.add(new PizzaItem("Your pizza", 15, 20, 25));
        pizzas.add(new PizzaItem("Margarita", 35, 40, 45));
        pizzas.add(new PizzaItem("Peperoni", 45, 50, 55));
        pizzas.add(new PizzaItem("4 Cheeses", 50, 60, 70));
        pizzas.add(new PizzaItem("Seafood", 70, 85, 100));
    }
}

package pizzeria.goods;

import pizzeria.goods.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Drinks {

    public static final ArrayList<Item> drinks = new ArrayList<>();

    static {
        drinks.add(new Item("Tea", 10));
        drinks.add(new Item("Coffee", 20));
        drinks.add(new Item("Beer", 24));
        drinks.add(new Item("Water", 11));
        drinks.add(new Item("Juice", 15));
    }
}

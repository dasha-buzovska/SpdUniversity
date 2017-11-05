package pizzeria.goods;

import pizzeria.goods.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Desserts {

    public static final ArrayList<Item> desserts = new ArrayList<>();

    static {
        desserts.add(new Item("Pun-cake", 20));
        desserts.add(new Item("Fondant", 40));
        desserts.add(new Item("Cookies", 12));
        desserts.add(new Item("Ice-cream", 10));
    }
}

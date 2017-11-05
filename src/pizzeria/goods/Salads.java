package pizzeria.goods;

import pizzeria.goods.items.Item;

import java.util.ArrayList;

public class Salads {

    public static final ArrayList<Item> salads = new ArrayList<>();

    static {
        salads.add(new Item("Greek", 30));
        salads.add(new Item("Spring", 40));
        salads.add(new Item("Happy", 24));
        salads.add(new Item("Healthy", 18));
        salads.add(new Item("Tsezar", 34));
    }

}

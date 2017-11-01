package pizzeria.goods;
//можна зробити, щоб був тільки метод ед, який би приймвав назву салату

import pizzeria.goods.items.Item;

public class Salads {

    public static final Item[] salads = new Item[]{
            new Item("Greek", 30),
            new Item("Spring", 40),
            new Item("Happy", 24),
            new Item("Healthy", 18),
            new Item("Tsezar", 34)
    };

}

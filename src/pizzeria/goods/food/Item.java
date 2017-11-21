package pizzeria.goods.food;

import pizzeria.goods.GoodsTypes;

public class Item implements Good, Eatable {
    private String name;
    private int price;
    private boolean isVegetarian;
    private GoodsTypes type;

    @Override
    public GoodsTypes getType() {
        return type;
    }

    public Item (String name, int price, boolean isVegetarian, GoodsTypes type) {
        this.name = name;
        this.price = price;
        this.isVegetarian = isVegetarian;
        this.type = type;

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

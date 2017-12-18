package pizzeria.goods;

import pizzeria.goods.food.Good;

public class GoodItem implements Good{
    protected String name;
    protected int price;
    protected GoodsTypes type;

    public GoodItem(GoodsTypes type, String name, int price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public GoodsTypes getType() {
        return type;
    }
}

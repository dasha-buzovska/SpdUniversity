package pizzeria.goods.food;

import pizzeria.goods.GoodsTypes;

public interface Good {
    String getName();
    int getPrice();
    GoodsTypes getType();
}

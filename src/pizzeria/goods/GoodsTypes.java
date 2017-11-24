package pizzeria.goods;
import pizzeria.goods.food.Good;
import pizzeria.goods.pizza.Ingredients;
import pizzeria.goods.pizza.Pizza;

public enum GoodsTypes {
    SALAD("Salads", Salads.values()), DRINK("Drinks", Drinks.values()), DESSERT("Desserts", Desserts.values()),
    PIZZA("Pizza", Pizza.values()), INGREDIENT("Ingredients", Ingredients.values());
    private String name;
    private Good[] goodsList;
    GoodsTypes(String name, Good[] type) {
        this.name = name;
        this.goodsList = type;
    }

    public String getName() {
        return name;
    }

    public Good[] getGoodsList() {
        return goodsList;
    }
}

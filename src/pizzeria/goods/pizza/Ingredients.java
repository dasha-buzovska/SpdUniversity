package pizzeria.goods.pizza;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import pizzeria.fileManager.Store;
import pizzeria.goods.GoodItem;
import pizzeria.goods.GoodsTypes;
import pizzeria.goods.food.Eatable;
import pizzeria.goods.food.Good;


public class Ingredients extends GoodItem implements Good, Eatable {
    static JsonArray innerArray = Store.readGoodType("storage/ingredients.json");

    public static Ingredients get(int id) {
        return values()[id];
    }

    public static Ingredients[] values() {
        Ingredients[] ingredients = new Ingredients[innerArray.size()];
        for (int i = 0; i < ingredients.length; i++) {
            JsonObject data = innerArray.get(i).getAsJsonObject();
            ingredients[i] = new Ingredients(data.get("name").getAsString(),
                    data.get("price").getAsInt(), data.get("isVegetarian").getAsBoolean());
        }
        return ingredients;
    }

    public static Ingredients valueOf(String type) {
        for (Ingredients ingredients: values()){
            if (ingredients.getName().equals(type)) {
                return ingredients;
            }
        }
        return null;
    }

    private boolean isVegetarian;

    private Ingredients(String name, int price, boolean isVegetarian) {
        super(GoodsTypes.INGREDIENT, name, price);
        this.isVegetarian = isVegetarian;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

}


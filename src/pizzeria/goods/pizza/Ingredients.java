package pizzeria.goods.pizza;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import pizzeria.fileManager.Store;
import pizzeria.goods.GoodsTypes;
import pizzeria.goods.food.Eatable;
import pizzeria.goods.food.Good;


public class Ingredients implements Good, Eatable {
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

    private String name;
    private int price;
    private boolean isVegetarian;

    public GoodsTypes getType() {
        return GoodsTypes.INGREDIENT;
    }

    Ingredients(String name, int price, boolean isVegetarian) {
        this.name = name;
        this.price = price;
        this.isVegetarian = isVegetarian;
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


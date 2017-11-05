package pizzeria.goods.pizza;

import pizzeria.goods.items.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class Ingredients {

    public static final ArrayList<Ingredient> ingredients = new ArrayList<>();

    static {
        ingredients.add(new Ingredient("Cheese", 5));
        ingredients.add(new Ingredient("Sausage", 8));
        ingredients.add(new Ingredient("Pineapple", 7));
        ingredients.add(new Ingredient("Corn", 4));
        ingredients.add(new Ingredient("Tomato", 6));
        ingredients.add(new Ingredient("Salmon", 15));
    }

}

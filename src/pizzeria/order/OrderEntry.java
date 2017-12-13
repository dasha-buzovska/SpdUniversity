package pizzeria.order;

import pizzeria.goods.Desserts;
import pizzeria.goods.Drinks;
import pizzeria.goods.Salads;
import pizzeria.goods.food.Good;
import pizzeria.goods.pizza.Ingredients;
import pizzeria.goods.pizza.Pizza;
import pizzeria.utils.Helper;

public class OrderEntry {

    private Good type;

    OrderEntry(Good type) {
        this.type = type;
    }

    OrderEntry(String type) {
        this.type = Desserts.valueOf(type);
        if (this.type != null){
            return;
        }
        this.type = Salads.valueOf(type);
        if (this.type != null){
            return;
        }
        this.type = Drinks.valueOf(type);
        if (this.type != null){
            return;
        }
        try {
            this.type = Pizza.valueOf(type);
            return;
        } catch (IllegalArgumentException e) {}

        try {
            this.type = Ingredients.valueOf(type);
            return;
        } catch (IllegalArgumentException e) {}
    }

    public boolean isIngredient() {
        return type instanceof Ingredients;
    }

    public boolean isPizza() {
        return type instanceof Pizza;
    }

    public int getPrice() {
        return type.getPrice();
    }

    public String displayRow() {
        return "" + Helper.appendSpaces(type.getName()) + type.getPrice();
    }

    public boolean contains(String name) {
        return type.getName().contains(name);
    }

    public String getName() {
        return type.getName();
    }
}

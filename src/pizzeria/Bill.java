package pizzeria;

import pizzeria.goods.Desserts;
import pizzeria.goods.Drinks;
import pizzeria.goods.items.Item;
import pizzeria.goods.Salads;
import pizzeria.goods.constants.GoodsTypes;
import pizzeria.goods.constants.PizzaSize;
import pizzeria.goods.pizza.Ingredients;
import pizzeria.goods.pizza.Pizza;

import java.util.ArrayList;


public class Bill {

    public ArrayList<Item> order = new ArrayList<>();
    private int sum = 0;

    public void add(GoodsTypes type, int id) {
        switch (type) {
            case SALAD:
                order.add(Salads.salads.get(id));
                break;
            case DRINK:
                order.add(Drinks.drinks.get(id));
                break;
            case DESSERT:
                order.add(Desserts.desserts.get(id));
                break;
            case PIZZA:
                order.add(Pizza.pizzas.get(id));
                break;
            case INGREDIENT:
                order.add(Ingredients.ingredients.get(id));
                break;
            default:
                System.out.println("error");
                return;
        }
    }

    boolean addPizza(int id, String size) {
        if (size.equals("n")) {
            order.add(new Item(PizzaSize.NORMAL.getName() + " " + Pizza.pizzas.get(id).getName(),
                    Pizza.pizzas.get(id).getPrice()));
        } else if (size.equals("b")) {
            order.add(new Item(PizzaSize.BIG.getName() + " " + Pizza.pizzas.get(id).getName(),
                    Pizza.pizzas.get(id).getBigPrice()));
        } else if (size.equals("m")) {
            order.add(new Item(PizzaSize.MAXI.getName() + " " + Pizza.pizzas.get(id).getName(),
                    Pizza.pizzas.get(id).getMaxiPrice()));
        } else {
            return false;
        }
        return true;
    }

    public int calculate() {
        for (int i = 0; i < order.size(); i++) {
            sum += order.get(i).getPrice();
        }
        return sum;
    }

}

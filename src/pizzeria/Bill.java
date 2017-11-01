package pizzeria;

import pizzeria.goods.Desserts;
import pizzeria.goods.Drinks;
import pizzeria.goods.Item;
import pizzeria.goods.Salads;
import pizzeria.goods.constants.GoodsTypes;
import pizzeria.goods.constants.PizzaSize;
import pizzeria.goods.pizza.Ingredients;
import pizzeria.goods.pizza.Pizza;
import pizzeria.goods.pizza.PizzaItem;


public class Bill {

    private static final int MAX_NUMBER_OF_ORDER = 50;
    public Item[] order = new Item[MAX_NUMBER_OF_ORDER];
    private int counter = 0;
    private int sum = 0;

    public void add(int type, int id) {
        switch (type) {
            case GoodsTypes.SALAD:
                order[counter] = Salads.salads[id];
                break;
            case GoodsTypes.DRINK:
                order[counter] = Drinks.drinks[id];
                break;
            case GoodsTypes.DESSERT:
                order[counter] = Desserts.desserts[id];
                break;
            case GoodsTypes.PIZZA:
                order[counter] = Pizza.pizzas[id];
                break;
            case GoodsTypes.INGREDIENT:
                order[counter] = Ingredients.ingredients[id];
                break;
            default:
                System.out.println("error");
                return;
        }
        counter++;
    }

    void addPizza(int id, String size) {
        if (size.equals("n")) {
            order[counter] = new Item(Pizza.pizzas[id].getName(), Pizza.pizzas[id].getPrice());
        } else if (size.equals("b")) {
            order[counter] = new Item(Pizza.pizzas[id].getName(), Pizza.pizzas[id].getBigPrice());
        } else if (size.equals("m")) {
            order[counter] = new Item(Pizza.pizzas[id].getName(), Pizza.pizzas[id].getMaxiPrice());
        }
        counter++;
    }

    public void calculatePizza(String size) {
        for (int i = 0; i < order.length && order[i] != null; i++) {
            PizzaItem pizzaItem = (PizzaItem) order[i];
            if (size.equals(PizzaSize.NORMAL)) {
                sum += pizzaItem.getPrice();
            } else if (size.equals(PizzaSize.BIG)) {
                sum += pizzaItem.getBigPrice();
            } else if (size.equals(PizzaSize.MAXI)) {
                sum += pizzaItem.getMaxiPrice();
            }
        }
    }

    public int calculate() {
        for (int i = 0; i < order.length && order[i] != null; i++) {
            sum += order[i].getPrice();
        }
        return sum;
    }



    private static void validate(Item[] array, int id) {
        if (id >= array.length) {
            System.out.println("No item with this id.");
        }
    }
}

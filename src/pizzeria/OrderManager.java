package pizzeria;

import pizzeria.goods.Desserts;
import pizzeria.goods.Drinks;
import pizzeria.goods.GoodsTypes;
import pizzeria.goods.Salads;
import pizzeria.goods.pizza.Ingredients;
import pizzeria.goods.pizza.Pizza;
import pizzeria.goods.pizza.PizzaSize;

public class OrderManager {

    void addGood(GoodsTypes type, int id, Order order) {
        switch (type) {
            case SALAD:
                if (Salads.getByIndex(id).isPresent()) {
                    order.orderList.add(Salads.getByIndex(id).get());
                }
                break;
            case DRINK:
                if (Drinks.getByIndex(id).isPresent()) {
                    order.orderList.add(Drinks.getByIndex(id).get());
                }
                break;
            case DESSERT:
                if (Desserts.getByIndex(id).isPresent()) {
                    order.orderList.add(Desserts.getByIndex(id).get());
                }
                break;
            case INGREDIENT:
                if (Ingredients.getByIndex(id).isPresent()) {
                    order.orderList.add(Ingredients.getByIndex(id).get());
                }
                break;
            default:
                System.out.println("error");
        }
    }

    boolean addPizza(int id, String size, Order order) {
        if (size.equals("n")) {
            Pizza.values()[id].setSize(PizzaSize.NORMAL);
        } else if (size.equals("b")) {
            Pizza.values()[id].setSize(PizzaSize.BIG);
            order.orderList.add(Pizza.values()[id]);
        } else if (size.equals("m")) {
            Pizza.values()[id].setSize(PizzaSize.MAXI);
        } else {
            return false;
        }
        order.orderList.add(Pizza.values()[id]);
        return true;
    }
}

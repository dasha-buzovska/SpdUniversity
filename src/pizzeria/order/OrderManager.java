package pizzeria.order;

import pizzeria.goods.Desserts;
import pizzeria.goods.Drinks;
import pizzeria.goods.GoodsTypes;
import pizzeria.goods.Salads;
import pizzeria.goods.pizza.Ingredients;
import pizzeria.goods.pizza.Pizza;
import pizzeria.goods.pizza.PizzaSize;

public class OrderManager {

    public void addGood(GoodsTypes type, int id, OrdersList ordersList) {
        switch (type) {
            case SALAD:
                if (Salads.getByIndex(id).isPresent()) {
                    ordersList.orderList.add(Salads.getByIndex(id).get());
                }
                break;
            case DRINK:
                if (Drinks.getByIndex(id).isPresent()) {
                    ordersList.orderList.add(Drinks.getByIndex(id).get());
                }
                break;
            case DESSERT:
                if (Desserts.getByIndex(id).isPresent()) {
                    ordersList.orderList.add(Desserts.getByIndex(id).get());
                }
                break;
            case INGREDIENT:
                if (Ingredients.getByIndex(id).isPresent()) {
                    ordersList.orderList.add(Ingredients.getByIndex(id).get());
                }
                break;
            default:
                System.out.println("error");
        }
    }

    public boolean addPizza(int id, String size, OrdersList ordersList) {
        if (size.equals("n")) {
            Pizza.values()[id].setSize(PizzaSize.NORMAL);
        } else if (size.equals("b")) {
            Pizza.values()[id].setSize(PizzaSize.BIG);
            ordersList.orderList.add(Pizza.values()[id]);
        } else if (size.equals("m")) {
            Pizza.values()[id].setSize(PizzaSize.MAXI);
        } else {
            return false;
        }
        ordersList.orderList.add(Pizza.values()[id]);
        return true;
    }
}

package pizzeria.order;

import pizzeria.goods.pizza.Pizza;
import pizzeria.goods.pizza.PizzaSize;

public class OrderManager {

    public boolean addPizza(int id, String size, OrdersList ordersList) {
        PizzaSize pizzaSize;
        if (size.equals("n")) {
            pizzaSize = PizzaSize.NORMAL;
        } else if (size.equals("b")) {
            pizzaSize = PizzaSize.BIG;
        } else if (size.equals("m")) {
            pizzaSize = PizzaSize.MAXI;
        } else {
            return false;
        }
        ordersList.orderList.add(Pizza.values()[id], pizzaSize);
        return true;
    }
}

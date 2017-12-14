package pizzeria.order;

import pizzeria.goods.pizza.Pizza;
import pizzeria.goods.pizza.PizzaSize;

public class OrderManager {

    public boolean addPizza(int id, String size, OrdersList ordersList) {
        if (size.equals("n")) {
            Pizza.values()[id].setSize(PizzaSize.NORMAL);
        } else if (size.equals("b")) {
            Pizza.values()[id].setSize(PizzaSize.BIG);
        } else if (size.equals("m")) {
            Pizza.values()[id].setSize(PizzaSize.MAXI);
        } else {
            return false;
        }
        ordersList.orderList.add(Pizza.values()[id]);
        return true;
    }
}

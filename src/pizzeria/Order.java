package pizzeria;


import pizzeria.goods.food.Good;
import java.util.ArrayList;


public class Order {

    public ArrayList<Good> orderList = new ArrayList<>();
    public ArrayList<ArrayList<Good>> allOrders = new ArrayList<>();

    public int calculate(ArrayList<Good> abstractOrder) {
        return abstractOrder.stream().mapToInt(Good::getPrice).sum();
    }

    void finishOrder() {
        if (!orderList.isEmpty()) {
            allOrders.add(orderList);
        }
        orderList = new ArrayList<>();
    }
}

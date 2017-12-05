package pizzeria.order;


import pizzeria.billsStore.BillStore;
import pizzeria.goods.food.Good;
import pizzeria.order.Order;

import java.util.ArrayList;

public class OrdersList {

    public Order orderList = new Order();
    public ArrayList<Order> allOrders = new ArrayList<>();
    BillStore billStore = new BillStore();
    public ArrayList<Order> archivedOrders = createArchivedList(1000);

    //TODO: think about title and where to put this method
    public ArrayList<Order> createArchivedList(int count) {
        ArrayList<Order> archivedOrders = new ArrayList();
        for (int i = 0; i < count; i++) {
            archivedOrders.add(billStore.generate());
        }
        return archivedOrders;
    }

    public int calculate(ArrayList<Good> abstractOrder) {
        return abstractOrder.stream().mapToInt(Good::getPrice).sum();
    }

    public void finishOrder() {
        if (!orderList.isEmpty()) {
            allOrders.add(orderList);
        }
        orderList = new Order();
    }

    public void addOrdersToArchive() {
        archivedOrders.addAll(allOrders);
        allOrders = new ArrayList<>();
    }
}

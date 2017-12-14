package pizzeria.order;


import pizzeria.fileManager.Store;

import java.util.ArrayList;
import java.util.List;

public class OrdersList {

    public Order orderList = new Order();
    public List<Order> allOrders = new ArrayList<>();

    public List<Order> getArchive() {
        return Store.readArchive();
    }

    public void finishOrder() {
        if (!orderList.isEmpty()) {
            allOrders.add(orderList);
        }
        orderList = new Order();
    }

    public void addOrdersToArchive() {
        List<Order> list = Store.readArchive();
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(allOrders);
        Store.write(list);
        allOrders = new ArrayList<>();
    }

}

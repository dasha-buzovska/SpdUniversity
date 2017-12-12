package pizzeria.order;


import pizzeria.store.FileController;

import java.util.ArrayList;
import java.util.List;

public class OrdersList {

    public Order orderList = new Order();
    public ArrayList<Order> allOrders = new ArrayList<>();

    public List<Order> getArchive() {
        return FileController.read();
    }

    public void finishOrder() {
        if (!orderList.isEmpty()) {
            allOrders.add(orderList);
        }
        orderList = new Order();
    }

    public void addOrdersToArchive() {
        //TODO: archive
        //if (!archivedOrders.isEmpty()) {
        //    archivedOrders.addAll(allOrders);
        //}
        allOrders = new ArrayList<>();
    }
}

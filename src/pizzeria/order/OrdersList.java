package pizzeria.order;


import pizzeria.fileManager.Store;

import java.util.ArrayList;
import java.util.List;

public class OrdersList {

    public Order orderList = new Order();
    public ArrayList<Order> allOrders = new ArrayList<>();

    public List<Order> getArchive() {
        return Store.read();
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

    public static ArrayList<Order> createArchivedList(int count) {
        ArrayList<Order> archivedOrders = new ArrayList();
        for (int i = 0; i < count; i++) {
            archivedOrders.add(OrdersGenerator.generate());
        }
        return archivedOrders;
    }

}

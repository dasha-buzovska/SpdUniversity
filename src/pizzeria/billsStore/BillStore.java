package pizzeria.billsStore;

import pizzeria.goods.food.Good;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillStore {
    public static List<BillBuilder> orderStore = new ArrayList<>();

    public BillStore(int count) {
        for (int i = 0; i < count; i++) {
            orderStore.add(new BillBuilder());
        }
    }

//    public BillStore(List<Good> foodStore, int sum, Date date) {
//        orderStore.add(new BillBuilder(foodStore, sum, date));
//    }

    public void printStore() {
        orderStore.forEach(order -> System.out.println("List:" + order.getFoodStore()
                + "\nSum: "+ order.getSum() + "\nDate: " + order.getDate()));
    }
}

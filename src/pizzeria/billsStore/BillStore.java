package pizzeria.billsStore;

import java.util.ArrayList;
import java.util.List;

public class BillStore {
    public List<BillBuilder> orderStore = new ArrayList<>();

    public BillStore(int count) {
        for (int i = 0; i < count; i++) {
            orderStore.add(new BillBuilder());
        }
    }

    public void printList() {
        orderStore.forEach(order -> System.out.println("List:" + order.getFoodStore()
                + "\nSum: "+ order.getSum() + "\nDate: " + order.getDate()));
    }
}

package pizzeria;

import pizzeria.billsStore.BillStore;

public class PizzaHouse {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.initialize();
        BillStore store = new BillStore(10);
    }
}

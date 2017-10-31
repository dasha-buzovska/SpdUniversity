package pizzeria.print;

import pizzeria.Bill;

public class PrintBills {

    public void printShortBill(Bill bill) {
        System.out.println("Pizza House.");
        for (int i = 0; i < bill.order.length && bill.order[i] != null; i++) {
            System.out.println(bill.order[i].getName() + "\t\t" + bill.order[i].getPrice());
        }
        System.out.println("\nTo pay:\t\t\t" + bill.calculate());
        System.out.println("See you next time!");
    }

    public void printFullBill(Bill bill) {

    }
}

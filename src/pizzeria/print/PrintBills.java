package pizzeria.print;

import pizzeria.Bill;
import pizzeria.goods.pizza.Ingredient;

public class PrintBills {

    public void printFullBill(Bill bill) {
        System.out.println("Pizza House.");
        for (int i = 0; i < bill.order.length && bill.order[i] != null; i++) {
            System.out.println(bill.order[i].getName() + "\t\t" + bill.order[i].getPrice());
        }
        System.out.println("\nTo pay:\t\t\t" + bill.calculate());
        System.out.println("See you next time!");
    }

    public void printShortBill(Bill bill) {
        int ingredientsSum = 0;
        System.out.println("Pizza House.");
        for (int i = 0; i < bill.order.length && bill.order[i] != null; i++) {
            if (bill.order[i] instanceof Ingredient) {
                ingredientsSum += bill.order[i].getPrice();
            } else {
                if (ingredientsSum != 0) {
                    System.out.println("Additions\t\t" + ingredientsSum);
                    ingredientsSum = 0;
                }
                System.out.println(bill.order[i].getName() + "\t\t" + bill.order[i].getPrice());
            }
        }
        if (ingredientsSum != 0) {
            System.out.println("Additions\t\t" + ingredientsSum);
        }

        System.out.println("\nTo pay:\t\t\t" + bill.calculate());
        System.out.println("See you next time!");
    }
}

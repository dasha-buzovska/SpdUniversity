package pizzeria.print;

import pizzeria.Bill;
import pizzeria.interfaces.Good;
import pizzeria.goods.pizza.Ingredients;

public class PrintBills {

    WhiteSpace whiteSpace = new WhiteSpace();

    public void printFullBill(Bill bill) {
        System.out.println("Pizza House.");
        for (int i = 0; i < bill.order.size(); i++) {
            Good good = (Good) bill.order.get(i);
            System.out.println("" + whiteSpace.print(good.getName()) + good.getPrice());
        }
        printSum(bill);
    }

    public void printShortBill(Bill bill) {
        int ingredientsSum = 0;
        System.out.println("Pizza House.");
        for (int i = 0; i < bill.order.size(); i++) {
            Good good = (Good) bill.order.get(i);
            if (bill.order.get(i) instanceof Ingredients) {
                ingredientsSum += good.getPrice();
            } else {
                if (ingredientsSum != 0) {
                    System.out.println("" + whiteSpace.print("Additions") + ingredientsSum);
                    ingredientsSum = 0;
                }
                System.out.println("" + whiteSpace.print(good.getName()) + good.getPrice());
            }
        }
        if (ingredientsSum != 0) {
            System.out.println("" + whiteSpace.print("Additions") + ingredientsSum);
        }
        printSum(bill);
    }

    private static void printSum(Bill bill) {
        System.out.println("\nTo pay:\t\t\t\t" + bill.calculate());
        System.out.println("See you next time!");
    }
}

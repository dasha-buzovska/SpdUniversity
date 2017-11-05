package pizzeria.print;

import pizzeria.Bill;
import pizzeria.goods.items.Ingredient;

public class PrintBills {

    WhiteSpace whiteSpace = new WhiteSpace();

    public void printFullBill(Bill bill) {
        System.out.println("Pizza House.");
        for (int i = 0; i < bill.order.size(); i++) {
            System.out.println("" + whiteSpace.print(bill.order.get(i).getName()) + bill.order.get(i).getPrice());
        }
        printSum(bill);
    }

    public void printShortBill(Bill bill) {
        int ingredientsSum = 0;
        System.out.println("Pizza House.");
        for (int i = 0; i < bill.order.size(); i++) {
            if (bill.order.get(i) instanceof Ingredient) {
                ingredientsSum += bill.order.get(i).getPrice();
            } else {
                if (ingredientsSum != 0) {
                    System.out.println("" + whiteSpace.print("Additions") + ingredientsSum);
                    ingredientsSum = 0;
                }
                System.out.println("" + whiteSpace.print(bill.order.get(i).getName()) + bill.order.get(i).getPrice());
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

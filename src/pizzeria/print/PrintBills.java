package pizzeria.print;

import pizzeria.Bill;
import pizzeria.interfaces.Drinkable;
import pizzeria.interfaces.Eatable;
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

    public void printVegetarianBill(Bill bill) {
        System.out.println("Pizza House.");
        for (int i = 0; i < bill.order.size(); i++) {
            Good good = (Good) bill.order.get(i);
            if (good instanceof Eatable && ((Eatable) good).isVegetarian() ||
                    good instanceof Drinkable && !((Drinkable) good).isAlcoholic()) {
                System.out.println("" + whiteSpace.print(good.getName()) + good.getPrice());
            } else {
                System.out.println("Your order is not vegetarian or contains alcohol");
                return;
            }
        }
        printSum(bill);
    }

    private static void printSum(Bill bill) {
        System.out.println("\nTo pay:\t\t\t\t" + bill.calculate());
        System.out.println("See you next time!");
    }
}

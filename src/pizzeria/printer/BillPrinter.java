package pizzeria.printer;

import pizzeria.Order;
import pizzeria.goods.food.Drinkable;
import pizzeria.goods.food.Eatable;
import pizzeria.goods.food.Good;
import pizzeria.goods.pizza.Ingredients;

public class BillPrinter {

    public void printFullBill(Order order) {
        System.out.println("Pizza House.");
        for (int i = 0; i < order.orderList.size(); i++) {
            Good good = order.orderList.get(i);
            System.out.println("" + Helper.appendSpaces(good.getName()) + good.getPrice());
        }
        printSum(order);
    }

    public void printShortBill(Order order) {
        int ingredientsSum = 0;
        System.out.println("Pizza House.");
        for (int i = 0; i < order.orderList.size(); i++) {
            Good good = order.orderList.get(i);
            if (order.orderList.get(i) instanceof Ingredients) {
                ingredientsSum += good.getPrice();
            } else {
                if (ingredientsSum != 0) {
                    System.out.println("" + Helper.appendSpaces("Additions") + ingredientsSum);
                    ingredientsSum = 0;
                }
                System.out.println("" + Helper.appendSpaces(good.getName()) + good.getPrice());
            }
        }
        if (ingredientsSum != 0) {
            System.out.println("" + Helper.appendSpaces("Additions") + ingredientsSum);
        }
        printSum(order);
    }

    public void printVegetarianBill(Order order, String parameter) {
        for (int i = 0; i < order.orderList.size(); i++) {
            Good good = order.orderList.get(i);
            if (good instanceof Eatable && ((Eatable) good).isVegetarian() ||
                    good instanceof Drinkable && !((Drinkable) good).isAlcoholic()) {
                Helper.sort(order.orderList, parameter);
            } else {
                System.out.println("Your order is not vegetarian or contains alcohol");
                return;
            }
        }
        printFullBill(order);
    }

    private static void printSum(Order order) {
        System.out.println("\nTo pay:\t\t\t\t" + order.calculate());
        System.out.println("See you next time!");
    }


}

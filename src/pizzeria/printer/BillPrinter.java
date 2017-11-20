package pizzeria.printer;

import pizzeria.Order;
import pizzeria.goods.food.Drinkable;
import pizzeria.goods.food.Eatable;
import pizzeria.goods.food.Good;
import pizzeria.goods.pizza.Ingredients;

import java.util.ArrayList;

public class BillPrinter {

    public void printFullBill(Order order) {
        for (int i = 0; i < order.allOrders.size(); i++) {
            printSingleOrderFullStyle(order.allOrders.get(i), order, i);
        }
    }

    public void printShortBill(Order order) {
        int ingredientsSum = 0;
        for (int i = 0; i < order.allOrders.size(); i++) {
            System.out.println("Order #" + (i + 1) + "\nPizza House.");
            for (int j = 0; j < order.allOrders.get(i).size(); j++) {
                Good good = order.allOrders.get(i).get(j);
                if (good instanceof Ingredients) {
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
            printSum(order.allOrders.get(i), order);
        }
    }

    public void printVegetarianBill(Order order, String parameter) {
        for (int i = 0; i < order.allOrders.size(); i++) {
            if (isVegetarianBill(order.allOrders.get(i))) {
                if (parameter.startsWith("p")) {
                    Helper.sortByPrice(order.allOrders.get(i), parameter);
                } else {
                    Helper.sortByName(order.allOrders.get(i), parameter);
                }
                printSingleOrderFullStyle(order.allOrders.get(i), order, i);
            }
        }
    }

    private boolean isVegetarianBill(ArrayList<Good> order) {
        for (Good good : order) {
            if (good instanceof Eatable && !((Eatable) good).isVegetarian() ||
                    good instanceof Drinkable && ((Drinkable) good).isAlcoholic()) {
                return false;
            }
        }
        return true;
    }

    private static void printSingleOrderFullStyle(ArrayList<Good> singleOrder, Order order, int i) {
        System.out.println("Order #" + (i + 1) + "\nPizza House.");
        for (Good good : singleOrder) {
            System.out.println("" + Helper.appendSpaces(good.getName()) + good.getPrice());
        }
        printSum(singleOrder, order);
    }

    private static void printSum(ArrayList<Good> list, Order order) {
        System.out.println("\nTo pay:\t\t\t\t" + order.calculate(list));
        System.out.println("See you next time!\n");
    }




}

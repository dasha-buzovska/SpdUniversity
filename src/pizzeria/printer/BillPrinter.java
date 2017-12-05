package pizzeria.printer;

import pizzeria.Order;
import pizzeria.OrdersList;
import pizzeria.WrongInputException;
import pizzeria.goods.GoodsTypes;
import pizzeria.goods.food.Good;
import pizzeria.goods.pizza.Ingredients;

import java.util.*;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toCollection;

public class BillPrinter {

    public void printFullBill(OrdersList ordersList) {
        ordersList.allOrders
                .forEach(singleOrder -> printSingleOrderFullStyle(singleOrder, ordersList));
    }

    public void printShortBill(OrdersList ordersList) {
        int ingredientsSum = 0;
        for (Order singleOrder: ordersList.allOrders) {
            System.out.println("Order #" + (ordersList.allOrders.indexOf(singleOrder) + 1) + "\nPizza House.");
            for (Good good : singleOrder.getGoodsList()) {
                if (good instanceof Ingredients) {
                    ingredientsSum += good.getPrice();
                } else {
                    printAdditions(ingredientsSum);
                    ingredientsSum = 0;
                    System.out.println("" + Helper.appendSpaces(good.getName()) + good.getPrice());
                }
            }
            printAdditions(ingredientsSum);
            printSum(singleOrder);
        }
    }

    //TODO: fix empty bill
    public void printVegetarianBill(OrdersList ordersList, String parameter) {
        try {
            ordersList.allOrders
                    .stream()
                    .filter(Order::isVegetarianBill)
                    .forEach(singleOrder -> {
                        if (parameter.startsWith("p")) {
                            Helper.sortByPrice(singleOrder.getGoodsList(), parameter);
                        } else {
                            Helper.sortByName(singleOrder.getGoodsList(), parameter);
                        }
                    });
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        }
    }

    public void printConcretePizzaAndPriceBill(OrdersList ordersList, int measure, String pizza) {
        ordersList.allOrders
                .stream()
                .filter(singleOrder -> singleOrder.calculate() <= measure)
                .forEach(singleOrder -> {
                    if (Helper.containsName(singleOrder.getGoodsList(), pizza)) {
                        printSingleOrderFullStyle(singleOrder, ordersList);
                    }
                });
    }
//tODO: separate into two methods
    public void printGroupedBill(OrdersList ordersList, int orderIndex) {
        ArrayList<Good> orderWithPackedAdditions = ordersList.allOrders.get(orderIndex).packAdditionsToPizza();
        Map<GoodsTypes, ArrayList<Good>> goodByItem = orderWithPackedAdditions
                .stream()
                .collect(groupingBy(Good::getType, toCollection(ArrayList::new)));
        System.out.println("Order #" + (orderIndex + 1) + "\nPizza House.");
        int sum = 0;
        for (Map.Entry<GoodsTypes, ArrayList<Good>> entry : goodByItem.entrySet()) {
            System.out.println(entry.getKey() + ":");
            entry.getValue()
                    .forEach(good ->
                        System.out.println("" + Helper.appendSpaces(good.getName()) + good.getPrice())
                    );
            sum += ordersList.calculate(entry.getValue());
        }
        System.out.println("\nTo pay:\t\t\t\t" + sum);
        System.out.println(ordersList.allOrders.get(orderIndex).getDate());
        System.out.println("See you next time!\n");
    }

    private static void printSingleOrderFullStyle(Order singleOrder, OrdersList ordersList) {
        System.out.println("Order #" + (ordersList.allOrders.indexOf(singleOrder) + 1) + "\nPizza House.");
        singleOrder.getGoodsList()
                .stream()
                .map(good -> "" + Helper.appendSpaces(good.getName()) + good.getPrice())
                .forEach(System.out::println);
        printSum(singleOrder);
    }

    private static void printSum(Order list) {
        System.out.println("\nTo pay:\t\t\t\t" + list.calculate());
        System.out.println(list.getDate());
        System.out.println("See you next time!\n");
    }

    private void printAdditions(int ingredientsSum){
        if (ingredientsSum != 0) {
            System.out.println("" + Helper.appendSpaces("Additions") + ingredientsSum);
        }
    }

}

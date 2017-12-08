package pizzeria.printer;

import pizzeria.dateTimeTools.discounts.HolidaySales;
import pizzeria.order.Order;
import pizzeria.order.OrdersList;
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

    //TODO: not check if only one good in order
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
                        printSingleOrderFullStyle(singleOrder, ordersList);
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

    public void printGroupedBill(Order order, int index) {
        Map<GoodsTypes, ArrayList<Good>> goodByItem = groupByType(order);
        System.out.println("Order #" + (index + 1) + "\nPizza House.");
        for (Map.Entry<GoodsTypes, ArrayList<Good>> entry : goodByItem.entrySet()) {
            System.out.println(entry.getKey() + ":");
            entry.getValue()
                    .forEach(good ->
                        System.out.println("" + Helper.appendSpaces(good.getName()) + good.getPrice())
                    );
        }
        printSum(order);
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
        System.out.println(list.getStringDate());
        //TODO: Make motto for every holiday
        if (HolidaySales.getReductionIfSalesToday() != 0) {
            System.out.println("Happy holidays!");
        }
        System.out.println("See you next time!\n");
    }

    private void printAdditions(int ingredientsSum){
        if (ingredientsSum != 0) {
            System.out.println("" + Helper.appendSpaces("Additions") + ingredientsSum);
        }
    }

    private Map<GoodsTypes, ArrayList<Good>> groupByType(Order order) {
        ArrayList<Good> orderWithPackedAdditions = order.packAdditionsToPizza();
        return orderWithPackedAdditions
                .stream()
                .collect(groupingBy(Good::getType, toCollection(ArrayList::new)));
    }

}

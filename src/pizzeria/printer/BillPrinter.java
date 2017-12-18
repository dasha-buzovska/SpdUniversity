package pizzeria.printer;

import pizzeria.dateTimeTools.discounts.HolidaySales;
import pizzeria.order.Order;
import pizzeria.order.OrderEntry;
import pizzeria.order.OrdersList;
import pizzeria.order.PizzaItem;
import pizzeria.utils.Helper;
import pizzeria.utils.WrongInputException;
import pizzeria.goods.GoodsTypes;

import java.util.*;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toCollection;

public class BillPrinter {

    public void printFullBill(OrdersList ordersList) {
        ordersList.allOrders
                .forEach(singleOrder -> printSingleOrderFullStyle(singleOrder, ordersList));
    }

    public void printShortBill(OrdersList ordersList) {
        for (Order singleOrder: ordersList.allOrders) {
            System.out.println("Order #" + (ordersList.allOrders.indexOf(singleOrder) + 1) + "\nPizza House.");
            for (OrderEntry good : singleOrder.getGoodsList()) {

                if (good.isPizza()) {
                    System.out.println(((PizzaItem) good).displayPizzaRow());
                    System.out.println("" + Helper.appendSpaces("Additions") + ((PizzaItem)good).getIngredientsPrice());
                } else {
                    System.out.println(good.displayRow());
                }
            }
            printSum(singleOrder);
        }
    }

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
        Map<GoodsTypes, List<OrderEntry>> goodByItem = order
                .getGoodsList()
                .stream()
                .collect(groupingBy(OrderEntry::getType, toCollection(ArrayList::new)));
        System.out.println("Order #" + (index + 1) + "\nPizza House.");
        for (Map.Entry<GoodsTypes, List<OrderEntry>> entry : goodByItem.entrySet()) {
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
                .map(OrderEntry::displayRow)
                .forEach(System.out::println);
        printSum(singleOrder);
    }

    private static void printSum(Order list) {
        System.out.println("\nTo pay:\t\t\t\t" + list.calculate());
        System.out.println(list.getStringDate());
        if (HolidaySales.getReductionIfSalesToday() != 0) {
            System.out.println("Happy holidays!");
        }
        System.out.println("See you next time!\n");
    }

}

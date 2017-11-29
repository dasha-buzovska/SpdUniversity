package pizzeria.printer;

import pizzeria.Order;
import pizzeria.WrongInputException;
import pizzeria.goods.GoodsTypes;
import pizzeria.goods.food.Drinkable;
import pizzeria.goods.food.Eatable;
import pizzeria.goods.food.Good;
import pizzeria.goods.pizza.Ingredients;
import pizzeria.goods.pizza.Pizza;

import java.util.*;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toCollection;

public class BillPrinter {

    public void printFullBill(Order order) {
        order.allOrders
                .forEach(singleOrder -> printSingleOrderFullStyle(singleOrder, order));
    }

    public void printShortBill(Order order) {
        int ingredientsSum = 0;
        for (ArrayList<Good> singleOrder: order.allOrders) {
            System.out.println("Order #" + (order.allOrders.indexOf(singleOrder) + 1) + "\nPizza House.");
            for (Good good : singleOrder) {
                if (good instanceof Ingredients) {
                    ingredientsSum += good.getPrice();
                } else {
                    printAdditions(ingredientsSum);
                    ingredientsSum = 0;
                    System.out.println("" + Helper.appendSpaces(good.getName()) + good.getPrice());
                }
            }
            printAdditions(ingredientsSum);
            printSum(singleOrder, order);
        }
    }

    public void printVegetarianBill(Order order, String parameter) {
        try {
            order.allOrders
                    .stream()
                    .filter(this::isVegetarianBill)
                    .forEach(singleOrder -> {
                        if (parameter.startsWith("p")) {
                            Helper.sortByPrice(singleOrder, parameter);
                        } else {
                            Helper.sortByName(singleOrder, parameter);
                        }
                    });
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        }
    }

    public void printConcretePizzaAndPriceBill(Order order, int measure, String pizza) {
        order.allOrders
                .stream()
                .filter(singleOrder -> order.calculate(singleOrder) <= measure)
                .forEach(singleOrder -> {
                    if (containsName(singleOrder, pizza)) {
                        printSingleOrderFullStyle(singleOrder, order);
                    }
                });
    }

    public void printGroupedBill(Order order, int orderIndex) {
        ArrayList<Good> orderWithPackedAdditions = packAdditionsToPizza(order.allOrders.get(orderIndex));
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
            sum += order.calculate(entry.getValue());
        }
        System.out.println("\nTo pay:\t\t\t\t" + sum);
        System.out.println("See you next time!\n");
    }

    private boolean isVegetarianBill(ArrayList<Good> order) {
        return order.stream().noneMatch(good -> good instanceof Eatable
                && !((Eatable) good).isVegetarian() ||
                good instanceof Drinkable && ((Drinkable) good).isAlcoholic());
    }

    private boolean containsName(ArrayList<Good> order, String name) {
        return order.stream().anyMatch(good -> good.getName().contains(name));
    }

    private static void printSingleOrderFullStyle(ArrayList<Good> singleOrder, Order order) {
        System.out.println("Order #" + (order.allOrders.indexOf(singleOrder) + 1) + "\nPizza House.");
        singleOrder
                .stream()
                .map(good -> "" + Helper.appendSpaces(good.getName()) + good.getPrice())
                .forEach(System.out::println);
        printSum(singleOrder, order);
    }

    private static void printSum(ArrayList<Good> list, Order order) {
        System.out.println("\nTo pay:\t\t\t\t" + order.calculate(list));
        System.out.println("See you next time!\n");
    }

    private void printAdditions(int ingredientsSum){
        if (ingredientsSum != 0) {
            System.out.println("" + Helper.appendSpaces("Additions") + ingredientsSum);
        }
    }

    private ArrayList<Good> packAdditionsToPizza(ArrayList<Good> goods) {
        ArrayList<Good> goodsWithoutIngredients = new ArrayList<>();
        for (int i = 0; i < goods.size(); i++) {
            if (goods.get(i) instanceof Pizza) {
                Pizza pizza = (Pizza) goods.get(i);
                int index = goods.indexOf(pizza) + 1;
                while (index < goods.size() && goods.get(index) instanceof Ingredients) {
                    pizza.addIngredients((Ingredients)goods.get(index));
                    goods.remove(index);
                }
            }
            goodsWithoutIngredients.add(goods.get(i));
        }
        return goodsWithoutIngredients;
    }
}

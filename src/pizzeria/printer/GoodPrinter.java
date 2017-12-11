package pizzeria.printer;

import pizzeria.goods.food.Good;
import pizzeria.goods.pizza.Pizza;

import java.util.Arrays;
import java.util.List;

public class GoodPrinter implements Printable {

    public static void print(List<Good> array, String name) {
        System.out.println("Choose your " + name);
        System.out.println("index  " + Helper.appendSpaces(name) + "price");
        array.stream().map(item -> "  " + array.indexOf(item) + "  | " + Helper.appendSpaces(item.getName()) + item.getPrice())
                .forEach(System.out::println);
    }


    public static void print() {
        System.out.println("Choose your pizza");
        System.out.println("index    " + Helper.appendSpaces("pizza") + "Normal Big Maxi");
        Arrays.asList(Pizza.values())
                .forEach(item -> {
                    System.out.println("  " + Arrays.asList(Pizza.values()).indexOf(item) + "  | "
                            + Helper.appendSpaces(item.getName())
                            + "    " + item.getPrice() + "   "
                            + item.getBigPrice() + "   "
                            + item.getMaxiPrice());
                    item.printElements();
                });
    }
}


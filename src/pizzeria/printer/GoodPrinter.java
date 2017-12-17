package pizzeria.printer;

import pizzeria.goods.GoodsTypes;
import pizzeria.goods.pizza.Pizza;
import pizzeria.utils.Helper;

import java.util.stream.IntStream;

public class GoodPrinter {

    public static void print(GoodsTypes option) {
        System.out.println("Choose your " + option.getName().toLowerCase());
        System.out.println("index  " + Helper.appendSpaces(option.getName().toLowerCase()) + "price");
        IntStream.range(0, option.getGoodsList().length).mapToObj(i -> "  " + i + "  | "
                + Helper.appendSpaces(option.getGoodsList()[i].getName())
                + option.getGoodsList()[i].getPrice()).forEach(System.out::println);
    }


    public static void printPizzaInfo() {
        System.out.println("Choose your pizza");
        System.out.println("index    " + Helper.appendSpaces("pizza") + "Normal Big Maxi");
        IntStream
                .range(0, Pizza.values().length)
                .forEach(i -> System.out.println("  " + i + "  | "
                + Helper.appendSpaces(Pizza.values()[i].getName()) + "    "
                + Pizza.values()[i].getPrice() + "   "
                + Pizza.values()[i].getBigPrice() + "   "
                + Pizza.values()[i].getMaxiPrice() + "\n"
                + Pizza.values()[i].printElements()));
    }
}


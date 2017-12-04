package pizzeria.printer;

import pizzeria.goods.food.Good;
import pizzeria.goods.GoodsTypes;
import pizzeria.goods.pizza.Pizza;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MenuPrinter {

    public void printMenu() {
        System.out.println("What do you want?");
        Stream.of(GoodsTypes.SALAD,
                GoodsTypes.DRINK,
                GoodsTypes.DESSERT,
                GoodsTypes.PIZZA)
                .map(goodsTypes -> goodsTypes.ordinal() + " " + goodsTypes.getName())
                .forEach(System.out::println);
        System.out.println("b Go to bills printing");
        System.out.println("p Know sum for some period");
        System.out.println("- Finish order");
    }

    public void printBills() {
        System.out.println("s Print short bill");
        System.out.println("f Print full bill");
        System.out.println("v Print veggie-non/alcohol bill");
        System.out.println("p Print bill with special pizza and less then your price");
        System.out.println("g Print grouped bill");
    }

    public void printGood(List<Good> array, String name) {
        System.out.println("Choose your " + name);
        System.out.println("index  " + Helper.appendSpaces(name) + "price");
        array.stream().map(item -> "  " + array.indexOf(item) + "  | " + Helper.appendSpaces(item.getName()) + item.getPrice())
                .forEach(System.out::println);
    }

    public void printPizza() {
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

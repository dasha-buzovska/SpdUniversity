package pizzeria.printer;

import pizzeria.goods.food.Good;
import pizzeria.goods.GoodsTypes;
import pizzeria.goods.pizza.Pizza;

import java.util.stream.IntStream;

public class MenuPrinter {

    public void printMenu() {
        System.out.println("What do you want?");
        IntStream.range(0, GoodsTypes.values().length - 1).mapToObj(i -> i + " " + GoodsTypes.values()[i].getName()).forEach(System.out::println);
        System.out.println("b Go to bills printing");
        System.out.println("- Finish order");
    }

    public void printBills() {
        System.out.println("s Print short bill");
        System.out.println("f Print full bill");
        System.out.println("v Print veggie-non/alcohol bill");
        System.out.println("p Print bill with special pizza and less then your price");
        System.out.println("g Print grouped bill");
    }

    public void printGood(Good[] array, String name) {
        System.out.println("Choose your " + name);
        System.out.println("index  " + Helper.appendSpaces(name) + "price");
        IntStream.range(0, array.length).mapToObj(i -> "  " + i + "  | " + Helper.appendSpaces(array[i].getName()) + array[i].getPrice()).forEach(System.out::println);
    }

    public void printPizza() {
        System.out.println("Choose your pizza");
        System.out.println("index    " + Helper.appendSpaces("pizza") + "Normal Big Maxi");
        IntStream.range(0, Pizza.values().length).forEach(i -> {
            System.out.println("  " + i + "  | "
                    + Helper.appendSpaces(Pizza.values()[i].getName())
                    + "  " + Pizza.values()[i].getPrice() + "   "
                    + Pizza.values()[i].getBigPrice() + "   "
                    + Pizza.values()[i].getMaxiPrice());
            Pizza.values()[i].printElements();
        });
    }

}

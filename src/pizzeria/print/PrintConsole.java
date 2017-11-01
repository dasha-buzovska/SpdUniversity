package pizzeria.print;

import pizzeria.goods.items.Item;
import pizzeria.goods.constants.GoodsTypes;
import pizzeria.goods.pizza.Pizza;

public class PrintConsole {

    public void printMenu() {
        System.out.println("What do you want?");
        for (int i = 0; i < GoodsTypes.MENU_NAMES.length; i++) {
            System.out.println(i + " " + GoodsTypes.MENU_NAMES[i]);
        }
        System.out.println("s Print short bill");
        System.out.println("f Print full bill");
    }

    public void printGood(Item[] array, String name) {
        System.out.println("Choose your " + name);
        System.out.println("index  " + whiteSpaceCounter(name) + "price");
        for (int i = 0; i < array.length; i++) {
            System.out.println("  " + i + "  | " + whiteSpaceCounter(array[i].getName()) + array[i].getPrice());
        }
    }

    public void printPizza() {
        System.out.println("Choose your pizza");
        System.out.println("index    " + whiteSpaceCounter("pizza") + "Normal Big Maxi");
        for (int i = 0; i < Pizza.pizzas.length; i++) {
            System.out.println("  " + i + "  | "
                    + whiteSpaceCounter(Pizza.pizzas[i].getName())
                    + "  " + Pizza.pizzas[i].getPrice() + "   "
                    + Pizza.pizzas[i].getBigPrice() + "   "
                    + Pizza.pizzas[i].getMaxiPrice());
        }
    }

    private static StringBuffer whiteSpaceCounter(String name) {
        StringBuffer space = new StringBuffer(name);
        int spacesDistance = 20;
        for (int i = 0; i < spacesDistance - name.length(); i++) {
            space = space.append(" ");
        }
        return space;
    }

}

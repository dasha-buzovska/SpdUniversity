package pizzeria.print;

import pizzeria.goods.items.Item;
import pizzeria.goods.constants.GoodsTypes;
import pizzeria.goods.pizza.Pizza;

import java.util.ArrayList;

public class PrintConsole {
    WhiteSpace whiteSpace = new WhiteSpace();

    public void printMenu() {
        System.out.println("What do you want?");
        for (int i = 0; i < GoodsTypes.values().length - 1; i++) {
            System.out.println(i + " " + GoodsTypes.values()[i].getName());
        }
        System.out.println("s Print short bill");
        System.out.println("f Print full bill");
    }

    public void printGood(ArrayList<? extends Item> array, String name) {
        System.out.println("Choose your " + name);
        System.out.println("index  " + whiteSpace.print(name) + "price");
        for (int i = 0; i < array.size(); i++) {
            System.out.println("  " + i + "  | " + whiteSpace.print(array.get(i).getName()) + array.get(i).getPrice());
        }
    }

    public void printPizza() {
        System.out.println("Choose your pizza");
        System.out.println("index    " + whiteSpace.print("pizza") + "Normal Big Maxi");
        for (int i = 0; i < Pizza.pizzas.size(); i++) {
            System.out.println("  " + i + "  | "
                    + whiteSpace.print(Pizza.pizzas.get(i).getName())
                    + "  " + Pizza.pizzas.get(i).getPrice() + "   "
                    + Pizza.pizzas.get(i).getBigPrice() + "   "
                    + Pizza.pizzas.get(i).getMaxiPrice());
        }
    }

}

package pizzeria.printer;

import pizzeria.goods.food.Good;
import pizzeria.goods.GoodsTypes;
import pizzeria.goods.pizza.Pizza;

public class MenuPrinter {

    public void printMenu() {
        System.out.println("What do you want?");
        for (int i = 0; i < GoodsTypes.values().length - 1; i++) {
            System.out.println(i + " " + GoodsTypes.values()[i].getName());
        }
        System.out.println("s Print short bill");
        System.out.println("f Print full bill");
        System.out.println("v Print veggie-non/alcohol bill");
    }

    public void printGood(Good[] array, String name) {
        System.out.println("Choose your " + name);
        System.out.println("index  " + Helper.appendSpaces(name) + "price");
        for (int i = 0; i < array.length; i++) {
            System.out.println("  " + i + "  | " + Helper.appendSpaces(array[i].getName()) + array[i].getPrice());
        }
    }

    public void printPizza() {
        System.out.println("Choose your pizza");
        System.out.println("index    " + Helper.appendSpaces("pizza") + "Normal Big Maxi");
        for (int i = 0; i < Pizza.values().length; i++) {
            System.out.println("  " + i + "  | "
                    + Helper.appendSpaces(Pizza.values()[i].getName())
                    + "  " + Pizza.values()[i].getPrice() + "   "
                    + Pizza.values()[i].getBigPrice() + "   "
                    + Pizza.values()[i].getMaxiPrice());
            Pizza.values()[i].printElements();
        }
    }

}

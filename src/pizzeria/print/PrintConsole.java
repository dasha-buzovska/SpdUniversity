package pizzeria.print;

import pizzeria.goods.Drinks;
import pizzeria.goods.Item;
import pizzeria.goods.Salads;
import pizzeria.goods.constants.GoodsTypes;

import java.util.Scanner;

public class PrintConsole {
    public void printMenu() {
        System.out.println("What do you want?");
        for (int i = 0; i < GoodsTypes.MENU_NAMES.length; i++) {
            System.out.println(i + " " + GoodsTypes.MENU_NAMES[i]);
        }
        System.out.println("10 Print short bill");
        System.out.println("11 Print full bill");
    }

    public void print(Item[] array, String name) {
        System.out.println("Choose your " + name);
        System.out.println("index " + name + " price");
        for (int i = 0; i < array.length; i++) {
            System.out.println("  " + i + "  | " + array[i].getName() + "  " + array[i].getPrice());
        }
    }

}

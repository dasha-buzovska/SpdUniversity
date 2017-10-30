package pizzeria.print;

import pizzeria.goods.Drinks;
import pizzeria.goods.Salads;
import pizzeria.goods.constants.GoodsTypes;

import java.util.Scanner;

public class PrintConsole {
    public void printMenu() {
        System.out.println("What do you want?");
        for (int i = 0; i < GoodsTypes.MENU_NAMES.length; i++) {
            System.out.println(i + 1 + " " + GoodsTypes.MENU_NAMES[i]);
        }
    }

    public void printSalads() {
        System.out.println("Choose your salad");
        System.out.println("index  salad  price");
        for (int i = 0; i < Salads.salads.length; i++) {
            System.out.println("  " + (i + 1) + "  | " + Salads.salads[i].getName() + "  " + Salads.salads[i].getPrice());
        }
    }

    public void printDrinks() {
        System.out.println("Choose your drink");
        System.out.println("index  drink  price");
        for (int i = 0; i < Drinks.drinks.length; i++) {
            System.out.println("  " + (i + 1) + "  | " + Drinks.drinks[i].getName() + "  " + Drinks.drinks[i].getPrice());
        }
    }
}

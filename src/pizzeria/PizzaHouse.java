package pizzeria;

import pizzeria.goods.Desserts;
import pizzeria.goods.Drinks;
import pizzeria.goods.Item;
import pizzeria.goods.Salads;
import pizzeria.goods.constants.GoodsTypes;
import pizzeria.goods.pizza.Pizza;
import pizzeria.print.PrintBills;
import pizzeria.print.PrintConsole;

import java.util.Scanner;

public class PizzaHouse {
    static Scanner scanner = new Scanner(System.in);
    static PrintConsole printConsole = new PrintConsole();
    static Bill bill = new Bill();
    static PrintBills bills = new PrintBills();

    public static void main(String[] args) {
        makeOrder();
    }

    static void makeOrder() {
        while (true) {

            printConsole.printMenu();
            System.out.print("Type index: ");
            String input = scanner.nextLine();
            System.out.println("-----------\n");


            chooseGood(input, "0", Salads.salads, "salad");
            chooseGood(input, "1", Drinks.drinks, "drink");
            chooseGood(input, "2", Desserts.desserts, "dessert");

            if ("10".equals(input)) {
                bills.printShortBill(bill);
                break;
            }

            if ("11".equals(input)) {
                bills.printFullBill(bill);
                break;
            }
        }

        scanner.close();
    }

    private static void chooseGood(String input, String index, Item[] good, String goodName) {
        if (index.equals(input)) {
            printConsole.print(good, goodName);
            System.out.print("Type index: ");
            String inputIndex = scanner.nextLine();
            for (int j = 0; j < good.length; j++) {
                String stringIndex = "" + j;
                if (stringIndex.equals(inputIndex)) {
                    bill.add(GoodsTypes.MENU[Integer.parseInt(index)], j);
                }
            }
            System.out.println("-----------\n");
        }
    }

}

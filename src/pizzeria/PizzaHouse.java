package pizzeria;

import pizzeria.goods.Desserts;
import pizzeria.goods.Drinks;
import pizzeria.goods.Item;
import pizzeria.goods.Salads;
import pizzeria.goods.constants.GoodsTypes;
import pizzeria.goods.constants.PizzaSize;
import pizzeria.goods.pizza.Ingredients;
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
            choosePizza(input);

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

    private static void choosePizza(String input) {
        if ("3".equals(input)) {
            printConsole.printPizza();
            System.out.print("Type index: ");
            String inputIndex = scanner.nextLine();
            System.out.println("Type size (n, b, m): ");
            String sizeIndex = scanner.nextLine();
            for (int i = 0; i < Pizza.pizzas.length; i++) {
                String stringIndex = i + "";
                if (inputIndex.equals(stringIndex)) {
                    bill.addPizza(i, sizeIndex);
                }
            }
            System.out.println("Do you want some additions? \n Type here (yes/no): ");
            String wantAdditional = scanner.nextLine();
            if (wantAdditional.equals("yes")) {
                printConsole.print(Ingredients.ingredients, "ingredient");
                System.out.print("Type index: ");
                String ingredientIndex = scanner.nextLine();
                for (int j = 0; j < Ingredients.ingredients.length; j++) {
                    String stringIndex = "" + j;
                    if (stringIndex.equals(ingredientIndex)) {
                        bill.add(GoodsTypes.INGREDIENT, j);
                        if (sizeIndex.equals("m")) {
                            bill.add(GoodsTypes.INGREDIENT, j);
                        }
                    }
                }
            }
        }
    }

}

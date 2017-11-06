package pizzeria;

import pizzeria.goods.Desserts;
import pizzeria.goods.Drinks;
import pizzeria.interfaces.Good;
import pizzeria.goods.Salads;
import pizzeria.goods.constants.GoodsTypes;
import pizzeria.goods.pizza.Ingredients;
import pizzeria.print.PrintBills;
import pizzeria.print.PrintConsole;

import java.util.Scanner;

import static pizzeria.goods.constants.GoodsTypes.INGREDIENT;

public class PizzaHouse {
    private static Scanner scanner = new Scanner(System.in);
    private static PrintConsole printConsole = new PrintConsole();
    private static Bill bill = new Bill();
    private static PrintBills bills = new PrintBills();

    public static void main(String[] args) {
        makeOrder();
    }

    private static void makeOrder() {
        while (true) {
            printConsole.printMenu();
            String index = typeIndex();
            System.out.println("\n");
            chooseGood(index, "0", Salads.values(), "salad");
            chooseGood(index, "1", Drinks.values(), "drink");
            chooseGood(index, "2", Desserts.values(), "dessert");
            choosePizza(index);

            if ("s".equals(index)) {
                bills.printShortBill(bill);
                break;
            } else if ("f".equals(index)) {
                bills.printFullBill(bill);
                break;
            }
        }
        scanner.close();
    }

    private static void chooseGood(String input, String index, Good[] good, String goodName) {
        if (index.equals(input)) {
            printConsole.printGood(good, goodName);
            System.out.println("  -  | back to menu");
            String inputIndex = typeIndex();
            if ("-".equals(inputIndex)) {
                return;
            }
            try {
                bill.addGood(GoodsTypes.values()[Integer.parseInt(index)], Integer.parseInt(inputIndex));
            } catch (Exception e) {
                System.out.println("Wrong sign was typed. Try again.");
            }
            System.out.println("\n");
        }
    }

    private static void choosePizza(String index) {
        if ("3".equals(index)) {
            printConsole.printPizza();
            String inputIndex = typeIndex();
            System.out.println("Choose size (n, b, m): ");
            String sizeIndex = typeIndex();
            boolean success = bill.addPizza(Integer.parseInt(inputIndex), sizeIndex);
            if (!success) {
                return;
            }
            System.out.println("Do you want some additions? \n Type here (yes/no): ");
            String wantAdditional = scanner.nextLine();
            if (wantAdditional.equals("yes") || wantAdditional.equals("y")) {
                chooseIngredients(sizeIndex);
            }
        }
    }

    private static void chooseIngredients(String sizeIndex) {
        String ingredientIndex = "";
        while (true) {
            printConsole.printGood(Ingredients.values(), "ingredient");
            System.out.println("  -  | back to menu");
            ingredientIndex = typeIndex();
            if ("-".equals(ingredientIndex)) {
                return;
            }
            try {
                bill.addGood(INGREDIENT, Integer.parseInt(ingredientIndex));
                if (sizeIndex.equals("m")) {
                    bill.addGood(INGREDIENT, Integer.parseInt(ingredientIndex));
                }
            } catch (Exception e) {
                System.out.println("Wrong sign was typed. Try again.");
            }
        }
    }

    private static String typeIndex() {
        System.out.print("Type index: ");
        return scanner.nextLine();
    }

}

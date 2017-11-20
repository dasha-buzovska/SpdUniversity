package pizzeria;

import pizzeria.goods.Desserts;
import pizzeria.goods.Drinks;
import pizzeria.goods.GoodsTypes;
import pizzeria.goods.Salads;
import pizzeria.goods.food.Good;
import pizzeria.goods.pizza.Ingredients;
import pizzeria.printer.BillPrinter;
import pizzeria.printer.MenuPrinter;

import java.util.Scanner;

import static pizzeria.goods.GoodsTypes.*;

class Menu {
    private Scanner scanner = new Scanner(System.in);
    private MenuPrinter menuPrinter = new MenuPrinter();
    private Order order = new Order();
    private BillPrinter bills = new BillPrinter();

    void makeOrder() {
        while (true) {
            menuPrinter.printMenu();
            String index = typeIndex();
            System.out.println("\n");
            chooseGood(index, "0", Salads.values(), SALAD.getName().toLowerCase());
            chooseGood(index, "1", Drinks.values(), DRINK.getName().toLowerCase());
            chooseGood(index, "2", Desserts.values(), DESSERT.getName().toLowerCase());
            choosePizza(index);

            if ("s".equals(index)) {
                order.finishOrder();
                bills.printShortBill(order);
                break;
            } else if ("f".equals(index)) {
                order.finishOrder();
                bills.printFullBill(order);
                break;
            } else if ("v".equals(index)) {
                order.finishOrder();
                System.out.println("Do you want order by titles(t) or by prices(p)?");
                String orderIndex = typeIndex();
                if (orderIndex.equals("t")) {
                    System.out.println("Choose titles order ascending(a)/descending(d)");
                    bills.printVegetarianBill(order, "t" + typeIndex());
                    break;
                } else if (orderIndex.equals("p")) {
                    System.out.println("Choose prices order ascending(a)/descending(d)");
                    bills.printVegetarianBill(order, "p" + typeIndex());
                    break;
                }
            } else if (index.equals("-")) {
                order.finishOrder();
            }
        }
        scanner.close();
    }


    private void chooseGood(String input, String index, Good[] good, String goodName) {
        if (index.equals(input)) {
            menuPrinter.printGood(good, goodName);
            System.out.println("  -  | back to menu");
            String inputIndex = typeIndex();
            if ("-".equals(inputIndex)) {
                return;
            }
            order.addGood(GoodsTypes.values()[Integer.parseInt(index)], Integer.parseInt(inputIndex));
            System.out.println("\n");
        }
    }

    private void choosePizza(String index) {
        if ("3".equals(index)) {
            menuPrinter.printPizza();
            String inputIndex = typeIndex();
            System.out.println("Choose size (n, b, m): ");
            String sizeIndex = typeIndex();
            boolean success = order.addPizza(Integer.parseInt(inputIndex), sizeIndex);
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

    private void chooseIngredients(String sizeIndex) {
        String ingredientIndex = "";
        while (true) {
            menuPrinter.printGood(Ingredients.values(), "ingredient");
            System.out.println("  -  | back to menu");
            ingredientIndex = typeIndex();
            if ("-".equals(ingredientIndex)) {
                return;
            }
            order.addGood(INGREDIENT, Integer.parseInt(ingredientIndex));
            if (sizeIndex.equals("m")) {
                order.addGood(INGREDIENT, Integer.parseInt(ingredientIndex));
            }
        }
    }

    private String typeIndex() {
        System.out.print("Type index: ");
        return scanner.nextLine();
    }
}

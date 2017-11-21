package pizzeria;

import pizzeria.goods.GoodsTypes;
import pizzeria.goods.food.Good;
import pizzeria.goods.pizza.Ingredients;
import pizzeria.goods.pizza.Pizza;
import pizzeria.printer.BillPrinter;
import pizzeria.printer.MenuPrinter;

import java.util.Scanner;

import static pizzeria.goods.GoodsTypes.INGREDIENT;

class MenuTools {

    Scanner scanner = new Scanner(System.in);
    MenuPrinter menuPrinter = new MenuPrinter();
    Order order = new Order();
    BillPrinter bills = new BillPrinter();

    void chooseGood(String input, String index, Good[] good, String goodName) {
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

    void choosePizza(String index) {
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

    void choosePizzaStyle() {
        System.out.println("Choose pizza type:\n" + Pizza.YOUR_PIZZA.getName() + "\n" + Pizza.MARGARITA.getName()
                + "\n" + Pizza.PEPERONI.getName() + "\n" + Pizza.FOUR_CHEESES.getName() + "\n" + Pizza.HAWAIIAN.getName()
                + "\n" + Pizza.SEAFOOD.getName());
        String pizzaName = typeIndex();
        System.out.println("Type max price, please");
        String maxPrice = typeIndex();
        bills.printConcretePizzaAndPriceBill(order, Integer.parseInt(maxPrice), pizzaName);
    }

    void chooseBillNumber() {
        Integer orderIndex = 0;
        try {
            if (order.allOrders.size() > 1) {
                System.out.println("Choose bill number from " + 1 + " to " + order.allOrders.size());
                orderIndex = Integer.parseInt(typeIndex()) - 1;
                bills.printGroupedBill(order,orderIndex);
            }
        } catch (Exception e) {
            System.out.println("Wrong index was typed.");
        }
    }

    void chooseOrderStyle() {
        System.out.println("Do you want order by titles(t) or by prices(p)?");
        String orderIndex = typeIndex();
        if (orderIndex.equals("t")) {
            System.out.println("Choose titles order ascending(a)/descending(d)");
            bills.printVegetarianBill(order, "t" + typeIndex());
        } else if (orderIndex.equals("p")) {
            System.out.println("Choose prices order ascending(a)/descending(d)");
            bills.printVegetarianBill(order, "p" + typeIndex());
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

    String typeIndex() {
        System.out.print("Type index: ");
        return scanner.nextLine();
    }


}

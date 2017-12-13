package pizzeria.menu;

import pizzeria.dateTimeTools.SumForPeriod;
import pizzeria.goods.GoodsTypes;
import pizzeria.goods.food.Good;
import pizzeria.goods.pizza.Ingredients;
import pizzeria.goods.pizza.Pizza;
import pizzeria.order.OrderManager;
import pizzeria.order.OrdersList;
import pizzeria.printer.BillPrinter;
import pizzeria.printer.GoodPrinter;

import java.util.Arrays;
import java.util.Scanner;

import static pizzeria.goods.GoodsTypes.INGREDIENT;

class MenuTools {

    Scanner scanner;
    OrdersList ordersList = new OrdersList();
    BillPrinter bills = new BillPrinter();
    private OrderManager orderManager = new OrderManager();
    private SumForPeriod sumForPeriod = new SumForPeriod(ordersList);

    void archive() {
        ordersList.addOrdersToArchive();
    }

    void choosePeriod(){
        System.out.println("Choose period you want to \nknow sum (year, month, week, day):");
        String periodIndex = readUserOption();
        System.out.println("\n" + sumForPeriod.findSumByConcretePeriod(periodIndex) + "\n");
    }

    void chooseGood(int index) {
        if (index < GoodsTypes.PIZZA.ordinal()) {
            Good[] good = GoodsTypes.values()[index].getGoodsList();
            GoodPrinter.print(Arrays.asList(good), GoodsTypes.values()[index].getName());
            System.out.println("  -  | back to menu");
            String inputIndex = readUserOption();
            if ("-".equals(inputIndex)) {
                return;
            }
            orderManager.addGood(GoodsTypes.values()[index], Integer.parseInt(inputIndex), ordersList);
            System.out.println("\n");
        }
    }

    void choosePizza() {
        try {
            GoodPrinter.print();
            String inputIndex = readUserOption();
            System.out.println("Choose size (n, b, m): ");
            String sizeIndex = readUserOption();
            boolean success = orderManager.addPizza(Integer.parseInt(inputIndex), sizeIndex, ordersList);
            //TODO: create custom exception instead of if
            if (!success) {
                return;
            }
            System.out.println("Do you want some additions? \n Type here (yes/no): ");
            String wantAdditional = scanner.nextLine();
            if (wantAdditional.equals("yes") || wantAdditional.equals("y")) {
                chooseIngredients(sizeIndex);
            }
        } catch (NumberFormatException e) {
            System.out.println("Type appropriate sign, please!");
        }
    }

    void choosePizzaStyle() {
        System.out.println("Choose pizza type:");
        Arrays.stream(Pizza.values())
                .forEach(pizza -> System.out.println(pizza.getName()));
        String pizzaName = readUserOption();
        System.out.println("Type max price, please");
        String maxPrice = readUserOption();
        assert Integer.parseInt(maxPrice) > 0 : "Price can't be negative number!";
        bills.printConcretePizzaAndPriceBill(ordersList, Integer.parseInt(maxPrice), pizzaName);
    }

    void chooseBillNumber() {
        try {
            Integer orderIndex = 0;
            if (ordersList.allOrders.size() > 1) {
                System.out.println("Choose bill number from " + 1 + " to " + ordersList.allOrders.size());
                orderIndex = Integer.parseInt(readUserOption()) - 1;
            }
            bills.printGroupedBill(ordersList.allOrders.get(orderIndex), orderIndex);
        } catch (Exception e) {
            System.out.println("Wrong index was typed.");
        }
    }

    void chooseOrderStyle() {
        System.out.println("Do you want order by titles(t) or by prices(p)?");
        String orderIndex = readUserOption();
        if (orderIndex.equals("t")) {
            System.out.println("Choose titles order ascending(a)/descending(d)");
            bills.printVegetarianBill(ordersList, "t" + readUserOption());
        } else if (orderIndex.equals("p")) {
            System.out.println("Choose prices order ascending(a)/descending(d)");
            bills.printVegetarianBill(ordersList, "p" + readUserOption());
        }
    }

    private void chooseIngredients(String sizeIndex) {
        try {
            String ingredientIndex;
            while (true) {
                GoodPrinter.print(Arrays.asList(Ingredients.values()),"ingredient");
                System.out.println("  -  | back to menu");
                ingredientIndex = readUserOption();
                if ("-".equals(ingredientIndex)) {
                    return;
                }
                orderManager.addGood(INGREDIENT, Integer.parseInt(ingredientIndex), ordersList);
                if (sizeIndex.equals("m")) {
                    orderManager.addGood(INGREDIENT, Integer.parseInt(ingredientIndex), ordersList);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Bad index was typed, try again!");
        }
    }

    String readUserOption() {
        System.out.print("Type index: ");
        return scanner.nextLine();
    }


}

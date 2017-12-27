package pizzeria.menu;

import pizzeria.dateTimeTools.SumForPeriod;
import pizzeria.goods.GoodsTypes;
import pizzeria.goods.pizza.Ingredients;
import pizzeria.goods.pizza.Pizza;
import pizzeria.order.OrderManager;
import pizzeria.order.OrdersList;
import pizzeria.printer.BillPrinter;
import pizzeria.printer.GoodPrinter;
import pizzeria.printer.MenuOptions;

import java.util.Arrays;
import java.util.Scanner;

public class MenuTools {

    private Scanner scanner;
    private OrdersList ordersList = new OrdersList();
    private BillPrinter bill = new BillPrinter();
    private OrderManager orderManager = new OrderManager();
    public SumForPeriod sumForPeriod = new SumForPeriod(ordersList.getArchive());

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public OrdersList getOrdersList() {
        return ordersList;
    }

    public BillPrinter getBill() {
        return bill;
    }

    void archive() {
        ordersList.addOrdersToArchive();
    }

    void choosePeriod(){
        System.out.println("Choose period you want to \nknow sum (year, month, week, day):");
        String periodIndex = readUserOption();
        System.out.println("\n" + sumForPeriod.findSumByConcretePeriod(periodIndex) + "\n");
    }

    void chooseGood(MenuOptions option) {
        GoodPrinter.print(option.getType());
        System.out.println("  -  | back to menu");
        String inputIndex = readUserOption();
        if ("-".equals(inputIndex)) {
            return;
        }
        ordersList.orderList.add(option.getType().getGoodsList()[Integer.parseInt(inputIndex)]);
        System.out.println("\n");
    }

    void choosePizza() {
        try {
            GoodPrinter.printPizzaInfo();
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
                chooseIngredients();
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
        bill.printConcretePizzaAndPriceBill(ordersList, Integer.parseInt(maxPrice), pizzaName);
    }

    void chooseBillNumber() {
        try {
            Integer orderIndex = 0;
            if (ordersList.allOrders.size() > 1) {
                System.out.println("Choose bill number from " + 1 + " to " + ordersList.allOrders.size());
                orderIndex = Integer.parseInt(readUserOption()) - 1;
            }
            bill.printGroupedBill(ordersList.allOrders.get(orderIndex), orderIndex);
        } catch (Exception e) {
            System.out.println("Wrong index was typed.");
        }
    }

    void chooseOrderStyle() {
        System.out.println("Do you want order by titles(t) or by prices(p)?");
        String orderIndex = readUserOption();
        if (orderIndex.equals("t")) {
            System.out.println("Choose titles order ascending(a)/descending(d)");
            bill.printVegetarianBill(ordersList, "t" + readUserOption());
        } else if (orderIndex.equals("p")) {
            System.out.println("Choose prices order ascending(a)/descending(d)");
            bill.printVegetarianBill(ordersList, "p" + readUserOption());
        }
    }

    private void chooseIngredients() {
        try {
            String ingredientIndex;
            while (true) {
                GoodPrinter.print(GoodsTypes.INGREDIENT);
                System.out.println("  -  | back to menu");
                ingredientIndex = readUserOption();
                if ("-".equals(ingredientIndex)) {
                    return;
                }
                ordersList.orderList.add(Ingredients.values()[Integer.parseInt(ingredientIndex)]);
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

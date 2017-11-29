package pizzeria;

import java.util.Scanner;

class Menu {
    private MenuTools tool = new MenuTools();

    void initialize() {
        try(Scanner scanner = new Scanner(System.in)) {
            tool.scanner = scanner;
            makeOrder();
        }
    }

    private void makeOrder() {
        while (true) {
            tool.menuPrinter.printMenu();
            String index = tool.readUserOption();
            if (index.equals("-")) {
                tool.order.finishOrder();
            } else if ("b".equals(index)) {
                tool.menuPrinter.printBills();
                chooseBillType(tool.readUserOption());
                break;
            } else {
                System.out.println("\n");
                try {
                    tool.chooseGood(Integer.parseInt(index));
                } catch (NumberFormatException e) {
                    System.out.println("It must be number or '-'. Try again!");
                } finally {
                    tool.choosePizza(index);
                }
            }
        }
    }

    private void chooseBillType(String index) {
        tool.order.finishOrder();
        assert tool.order.allOrders.size() != 0: "don't work with no order!";
        switch (index) {
            case "s":
                tool.bills.printShortBill(tool.order);
                break;
            case "f":
                tool.bills.printFullBill(tool.order);
                break;
            case "v":
                tool.chooseOrderStyle();
                break;
            case "p":
                tool.choosePizzaStyle();
                break;
            case "g":
                tool.chooseBillNumber();
                break;
            default:
                System.out.println("Wrong sign was typed. Try again, please!");
        }
    }
}

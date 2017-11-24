package pizzeria;

class Menu {
    private MenuTools tool = new MenuTools();

    void makeOrder() {
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
                tool.chooseGood(Integer.parseInt(index));
                tool.choosePizza(index);
            }
        }
        tool.scanner.close();
    }

    private void chooseBillType(String index) {
        tool.order.finishOrder();
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

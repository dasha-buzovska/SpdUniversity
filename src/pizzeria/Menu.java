package pizzeria;

import pizzeria.goods.Desserts;
import pizzeria.goods.Drinks;
import pizzeria.goods.Salads;

import static pizzeria.goods.GoodsTypes.*;

class Menu {
    private MenuTools tool = new MenuTools();

    void makeOrder() {
        while (true) {
            tool.menuPrinter.printMenu();
            String index = tool.typeIndex();
            System.out.println("\n");
            tool.chooseGood(index, "0", Salads.values(), SALAD.getName().toLowerCase());
            tool.chooseGood(index, "1", Drinks.values(), DRINK.getName().toLowerCase());
            tool.chooseGood(index, "2", Desserts.values(), DESSERT.getName().toLowerCase());
            tool.choosePizza(index);

            if (index.equals("-")) {
                tool.order.finishOrder();
            } else if ("b".equals(index)) {
                tool.menuPrinter.printBills();
                chooseBillType(tool.typeIndex());
                break;
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

package pizzeria.menu;

import pizzeria.dateTimeTools.CalendarPrinter;
import pizzeria.printer.BillsTypePrinter;
import pizzeria.printer.MenuPrinter;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Menu {
    private MenuTools tool = new MenuTools();

    public void initialize() {
        try(Scanner scanner = new Scanner(System.in)) {
            tool.scanner = scanner;
            makeOrder();
        }
    }

    private void makeOrder() {
        while (true) {
            MenuPrinter.print();
            String index = tool.readUserOption();
            MenuPrinter option;
            try {
                option = MenuPrinter.createOption(index);
            } catch (NoSuchElementException e) {
                System.out.println("Wrong sign was typed. Try again!");
                continue;
            }
            switch (option){
                case END_OF_ORDER:
                    tool.ordersList.finishOrder();
                    break;
                case BILLS:
                    BillsTypePrinter.print();
                    chooseBillType(tool.readUserOption());
                    return;
                case SUM_FOR_PERIOD:
                    tool.choosePeriod();
                    break;
                case ARCHIVED:
                    tool.ordersList.finishOrder();
                    tool.archive();
                    break;
                case CALENDAR:
                    CalendarPrinter.printYearCalendar(2018);
                    break;
                case SALADS:
                case DRINKS:
                case DESSERTS:
                    System.out.println("\n");
                    tool.chooseGood(Integer.parseInt(index) - 1);
                    break;
                case PIZZAS:
                    tool.choosePizza();
                    break;
                default:
                    assert false;
                    break;
            }
        }
    }

    private void chooseBillType(String index) {
        tool.ordersList.finishOrder();
        assert tool.ordersList.allOrders.size() != 0: "don't work with no orders!";
        BillsTypePrinter option;
        try {
            option = BillsTypePrinter.createOption(index);
            switch (option) {
                case SHORT:
                    tool.bills.printShortBill(tool.ordersList);
                    break;
                case FULL:
                    tool.bills.printFullBill(tool.ordersList);
                    break;
                case VEGGIE:
                    tool.chooseOrderStyle();
                    break;
                case SPECIAL:
                    tool.choosePizzaStyle();
                    break;
                case GROUPED:
                    tool.chooseBillNumber();
                    break;
                default:
                    System.out.println("Wrong sign was typed. Try again, please!");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Wrong sign was typed. Try again!");
        }
    }
}

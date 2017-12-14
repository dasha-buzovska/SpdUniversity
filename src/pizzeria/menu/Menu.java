package pizzeria.menu;

import pizzeria.dateTimeTools.CalendarPrinter;
import pizzeria.printer.BillsTypePrinter;
import pizzeria.printer.MenuOptions;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Menu {
    private MenuTools tool = new MenuTools();

    public void initialize() {
        try(Scanner scanner = new Scanner(System.in)) {
            tool.setScanner(scanner);
            makeOrder();
        }
    }

    private void makeOrder() {
        while (true) {
            MenuOptions.print();
            String index = tool.readUserOption();
            MenuOptions option;
            try {
                option = MenuOptions.getOption(index);
            } catch (NoSuchElementException e) {
                System.out.println("Wrong sign was typed. Try again!");
                continue;
            }
            chooseMenuOption(option);
            if (option.equals(MenuOptions.BILLS)) {
                return;
            }
        }
    }

    private void chooseMenuOption(MenuOptions option){
        switch (option){
            case END_OF_ORDER:
                tool.getOrdersList().finishOrder();
                break;
            case BILLS:
                BillsTypePrinter.print();
                chooseBillType(tool.readUserOption());
                return;
            case SUM_FOR_PERIOD:
                tool.choosePeriod();
                break;
            case ARCHIVED:
                tool.getOrdersList().finishOrder();
                tool.archive();
                break;
            case CALENDAR:
                CalendarPrinter.printYearCalendar(2018);
                break;
            case SALADS:
            case DRINKS:
            case DESSERTS:
                System.out.println("\n");
                tool.chooseGood(option);
                break;
            case PIZZAS:
                tool.choosePizza();
                break;
            default:
                assert false;
                break;
        }

    }
    private void chooseBillType(String index) {
        tool.getOrdersList().finishOrder();
        assert tool.getOrdersList().allOrders.size() != 0: "don't work with no orders!";
        BillsTypePrinter option;
        try {
            option = BillsTypePrinter.createOption(index);
            switch (option) {
                case SHORT:
                    tool.getBill().printShortBill(tool.getOrdersList());
                    break;
                case FULL:
                    tool.getBill().printFullBill(tool.getOrdersList());
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

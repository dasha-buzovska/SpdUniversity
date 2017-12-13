package pizzeria.printer;

import java.util.Arrays;

public enum MenuPrinter {
    SALADS("1", "Salads"),
    DRINKS("2", "Drinks"),
    DESSERTS("3", "Deserts"),
    PIZZAS("4", "Pizza"),
    SUM_FOR_PERIOD("s", "Know sum for some period"),
    CALENDAR("c", "Print calendar with discounts"),
    BILLS("b", "Go to bills printing"),
    ARCHIVED("a", "Add orders to archive"),
    END_OF_ORDER("-", "Finish order");

    private String sign;
    private String option;

    MenuPrinter(String sign, String option) {
        this.sign = sign;
        this.option = option;
    }

    public static void print() {
        System.out.println("What do you want?");
        Arrays
                .stream(values())
                .map(element -> element.sign + " " + element.option)
                .forEach(System.out::println);
    }

    public static MenuPrinter createOption(String index) {
        return Arrays.stream(values()).filter(element -> element.sign.equals(index)).findFirst().get();
    }
}

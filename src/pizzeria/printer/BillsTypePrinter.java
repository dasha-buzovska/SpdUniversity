package pizzeria.printer;

import java.util.Arrays;

public enum BillsTypePrinter {
    SHORT("s", "Print short bill"), FULL("f", "Print full bill"),
    VEGGIE("v", "Print veggie-non/alcohol bill"), SPECIAL("p", "Print bill with special pizza and less then your price"),
    GROUPED("g", "Print grouped bill");

    private String sign;
    private String option;

    BillsTypePrinter(String sign, String option) {
        this.sign = sign;
        this.option = option;
    }

    public static void print() {
        Arrays
                .stream(values())
                .map(bill -> bill.sign + " " + bill.option)
                .forEach(System.out::println);
    }
}

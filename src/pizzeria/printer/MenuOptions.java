package pizzeria.printer;

import pizzeria.goods.GoodsTypes;

import java.util.Arrays;

public enum MenuOptions {
    SALADS("1", "Salads", GoodsTypes.SALAD),
    DRINKS("2", "Drinks", GoodsTypes.DRINK),
    DESSERTS("3", "Deserts", GoodsTypes.DESSERT),
    PIZZAS("4", "Pizza", GoodsTypes.PIZZA),
    SUM_FOR_PERIOD("s", "Know sum for some period"),
    CALENDAR("c", "Print calendar with discounts"),
    BILLS("b", "Go to bills printing"),
    ARCHIVED("a", "Add orders to archive"),
    END_OF_ORDER("-", "Finish order");

    private String sign;
    private String option;
    private GoodsTypes type;

    MenuOptions(String sign, String option) {
        this.sign = sign;
        this.option = option;
    }

    MenuOptions(String sign, String option, GoodsTypes type) {
        this.sign = sign;
        this.option = option;
        this.type = type;
    }

    public static void print() {
        System.out.println("What do you want?");
        Arrays
                .asList(values())
                .forEach(element-> System.out.println(element.sign + " " + element.option));
    }

    public static MenuOptions getOption(String index) {
        return Arrays.stream(values()).filter(element -> element.sign.equals(index)).findFirst().get();
    }

    public GoodsTypes getType() {
        return type;
    }

}

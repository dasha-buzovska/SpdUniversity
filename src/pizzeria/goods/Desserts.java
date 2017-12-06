package pizzeria.goods;

import pizzeria.dateTimeTools.discounts.DiscountPrices;
import pizzeria.dateTimeTools.discounts.SpecialWeeklyDiscounts;
import pizzeria.goods.food.Eatable;
import pizzeria.goods.food.Good;

import java.util.Optional;

public enum Desserts implements Good, Eatable {
    PUN_CAKE("Pun-cake", 20), FONDANT("Fondant", 40), COOKIES("Cookies", 12), ICE_CREAM("Ice-cream", 10);

    private String name;
    private int price;

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return true;
    }

    public GoodsTypes getType() {
        return GoodsTypes.DESSERT;
    }

    Desserts(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public static Optional<Desserts> getByIndex(int index) {
        if (values().length < index) {
            return Optional.empty();
        }
        return Optional.of(values()[index]);
    }

    DiscountPrices discountPrices = new DiscountPrices();
    public int getPrice() {
        return price * discountPrices.getReductionToWholeType(getType(), SpecialWeeklyDiscounts.MONDAY_DESSERTS_DISCOUNT)/100;
    }

}

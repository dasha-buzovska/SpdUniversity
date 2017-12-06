package pizzeria.goods;

import pizzeria.dateTimeTools.discounts.DiscountPrices;
import pizzeria.dateTimeTools.discounts.SpecialWeeklyDiscounts;
import pizzeria.goods.food.Drinkable;

import java.util.Optional;

public enum Drinks implements Drinkable {
    TEA("Tea", 10, false), COFFEE("Coffee", 20, false), WATER("Water", 11, false),
    JUICE("Juice", 15, false), BEER("Beer", 24, true), VODKA("Vodka", 20, true);

    private String name;
    private int price;
    private boolean isAlcoholic;

    Drinks(String name, int price, boolean isAlcoholic){
        this.name = name;
        this.price = price;
        this.isAlcoholic = isAlcoholic;
    }

    public String getName() {
        return name;
    }

    DiscountPrices discountPrices = new DiscountPrices();

    public int getPrice() {
        for (int i = 0; i < values().length; i++) {
            if (values()[i].isAlcoholic) {
                return price * discountPrices
                        .getReductionToSomeGoods(SpecialWeeklyDiscounts.FRIDAY_ALCOHOL_DISCOUNT) / 100;
            }
        }
        return price;
    }

    public boolean isAlcoholic() {
        return isAlcoholic;
    }

    public GoodsTypes getType() {
        return GoodsTypes.DRINK;
    }

    public static Optional<Drinks> getByIndex(int index) {
        if (values().length < index) {
            return Optional.empty();
        }
        return Optional.of(values()[index]);
    }
}

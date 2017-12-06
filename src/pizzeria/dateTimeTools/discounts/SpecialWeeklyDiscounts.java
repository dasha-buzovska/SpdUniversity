package pizzeria.dateTimeTools.discounts;

import pizzeria.goods.Desserts;
import pizzeria.goods.Drinks;
import pizzeria.goods.Salads;
import pizzeria.goods.food.Good;
import pizzeria.goods.pizza.PizzaSize;

public enum SpecialWeeklyDiscounts {

    MONDAY_DISCOUNT(1, Desserts.values(), 30), WEDNESDAY_DISCOUNT(3, Salads.values(), 20),
    THURSDAY_DISCOUNT(4, PizzaSize.MAXI, 50),
    FRIDAY_DISCOUNT(5, Drinks.BEER, 40);

    private int dayOfWeek;
    private Good[] allGoods;
    private PizzaSize size;
    private Good good;
    private int reduction;
    SpecialWeeklyDiscounts(int dayOfWeek, Good[] allGoods, int reduction) {
        this.dayOfWeek = dayOfWeek;
        this.allGoods = allGoods;
        this.reduction = reduction;
    }

    SpecialWeeklyDiscounts(int dayOfWeek, PizzaSize size, int reduction) {
        this.dayOfWeek = dayOfWeek;
        this.size = size;
        this.reduction = reduction;
    }

    SpecialWeeklyDiscounts(int dayOfWeek, Good good, int reduction) {
        this.dayOfWeek = dayOfWeek;
        this.good = good;
        this.reduction = reduction;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public Good[] getAllGoods() {
        return allGoods;
    }

    public int getReduction() {
        return reduction;
    }
}

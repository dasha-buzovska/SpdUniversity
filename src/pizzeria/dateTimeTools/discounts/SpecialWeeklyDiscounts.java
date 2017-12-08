package pizzeria.dateTimeTools.discounts;

import pizzeria.goods.Desserts;
import pizzeria.goods.Salads;
import pizzeria.goods.food.Good;

public enum SpecialWeeklyDiscounts {
    //TODO: change dayOfWeek to special enum
    MONDAY_DESSERTS_DISCOUNT(1, Desserts.values(), 30), WEDNESDAY_SALADS_DISCOUNT(3, Salads.values(), 20),
    THURSDAY_MAXI_PIZZA_DISCOUNT(4, 30),
    FRIDAY_ALCOHOL_DISCOUNT(5, 40);

    private int dayOfWeek;
    private Good[] allGoods;
    private int reduction;

    SpecialWeeklyDiscounts(int dayOfWeek, Good[] allGoods, int reduction) {
        this.dayOfWeek = dayOfWeek;
        this.allGoods = allGoods;
        this.reduction = reduction;
    }

    SpecialWeeklyDiscounts(int dayOfWeek, int reduction) {
        this.dayOfWeek = dayOfWeek;
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

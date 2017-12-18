package pizzeria.dateTimeTools.discounts;

import pizzeria.goods.food.Good;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.Arrays;

public class DiscountPrices {

    public int getReductionToWholeType(Good[] array, SpecialWeeklyDiscounts dayDiscount) {
        int fullPrice = 100;
        if (Arrays.equals(array, dayDiscount.getAllGoods()) && isAppropriateDayOfWeek(dayDiscount)) {
            return fullPrice - dayDiscount.getReduction();
        }
        return fullPrice;
    }

    public int getReductionToSomeGoods(SpecialWeeklyDiscounts dayDiscount) {
        int fullPrice = 100;
        if (isAppropriateDayOfWeek(dayDiscount)) {
            return fullPrice - dayDiscount.getReduction();
        }
        return fullPrice;
    }

    private boolean isAppropriateDayOfWeek(SpecialWeeklyDiscounts dayDiscount){
        return LocalDate.now().get(ChronoField.DAY_OF_WEEK) == dayDiscount.getDayOfWeek();
    }


}

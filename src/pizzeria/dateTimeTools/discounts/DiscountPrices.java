package pizzeria.dateTimeTools.discounts;

import pizzeria.goods.GoodsTypes;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.Arrays;

public class DiscountPrices {
    public int getReductionToWholeType(GoodsTypes type, SpecialWeeklyDiscounts dayDiscount) {
        int fullPrice = 100;
        if (Arrays.equals(type.getGoodsList(), dayDiscount.getAllGoods())
                && LocalDate.now().get(ChronoField.DAY_OF_WEEK) == dayDiscount.getDayOfWeek()) {
            return fullPrice - dayDiscount.getReduction();
        }
        return fullPrice;
    }


}

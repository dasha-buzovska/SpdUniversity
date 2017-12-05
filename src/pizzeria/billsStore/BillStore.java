package pizzeria.billsStore;

import pizzeria.order.Order;
import pizzeria.goods.GoodsTypes;

import java.util.Calendar;
import java.util.Random;

public class BillStore {


    public Order generate() {
        Order order = new Order();
        //TODO(?): add ingredients to pizza
        int bound = getRandomNumberOfRange(1, 10);
        for (int i = 0; i < bound; i++) {
            int typeIndex = getRandomNumberOfRange(0, GoodsTypes.values().length - 2);
            int itemIndex = getRandomNumberOfRange(0, GoodsTypes.values()[typeIndex].getGoodsList().length - 1);

            order.add(GoodsTypes.values()[typeIndex].getGoodsList()[itemIndex]);
        }
        order.setDate(dateGenerator());
        return order;
    }

    private Calendar dateGenerator() {
        Calendar date = Calendar.getInstance();
        date.set(Calendar.YEAR, getRandomNumberOfRange(2015, date.get(Calendar.YEAR)));
        date.set(Calendar.DAY_OF_YEAR, getRandomNumberOfRange(1, date.get(Calendar.DAY_OF_YEAR)));
        date.set(Calendar.HOUR_OF_DAY, getRandomNumberOfRange(0, 23));
        date.set(Calendar.MINUTE, getRandomNumberOfRange(0, 59));
        return date;
    }

    private int getRandomNumberOfRange(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}

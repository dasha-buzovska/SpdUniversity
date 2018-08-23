package pizzeria.billsStore;

import pizzeria.order.Order;
import pizzeria.goods.GoodsTypes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

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

    private LocalDateTime dateGenerator() {
        long start = LocalDate.of(2015, 1, 1).toEpochDay();
        long end = LocalDate.now().toEpochDay();
        long randomEpochDay = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();
        Random random = new Random();
        LocalDateTime dateTime = LocalDateTime.of(LocalDate.ofEpochDay(randomEpochDay),
                LocalTime.of(random.nextInt(24), random.nextInt(60),
                        random.nextInt(60)));
        return dateTime;
    }

    private int getRandomNumberOfRange(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
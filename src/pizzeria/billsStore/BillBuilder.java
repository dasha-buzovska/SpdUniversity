package pizzeria.billsStore;

import pizzeria.goods.GoodsTypes;
import pizzeria.goods.food.Good;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class BillBuilder {
    private List<Good> foodStore;
    private int sum;
    private Date date;


    public List<Good> getFoodStore() {
        return foodStore;
    }

    public int getSum() {
        return sum;
    }

    public Date getDate() {
        return date;
    }

    public BillBuilder() {
        foodStore = new ArrayList<>();
        //TODO(?): add ingredients to pizza
        int bound = getRandomNumberOfRange(1, 10);
        for (int i = 0; i < bound; i++) {
            int typeIndex = getRandomNumberOfRange(0, GoodsTypes.values().length - 2);
            int itemIndex = getRandomNumberOfRange(0, GoodsTypes.values()[typeIndex].getGoodsList().length - 1);

            foodStore.add(GoodsTypes.values()[typeIndex].getGoodsList()[itemIndex]);
        }
        sum = foodStore.stream().mapToInt(Good::getPrice).sum();
        date = dateGenerator();
    }

    private int getRandomNumberOfRange(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    private Date dateGenerator() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        Date date = null;

        try {
            date = sdf.parse("01-01-2015 10:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Long max = new Date().getTime();
        assert date != null;
        Long min = date.getTime();

        Long randomLong = min + (long) (Math.random() *(max - min));
        return new Date(randomLong);
    }
}

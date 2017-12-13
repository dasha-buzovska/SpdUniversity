package pizzeria.goods;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import pizzeria.dateTimeTools.discounts.DiscountPrices;
import pizzeria.dateTimeTools.discounts.SpecialWeeklyDiscounts;
import pizzeria.fileManager.Store;
import pizzeria.goods.food.Eatable;
import pizzeria.goods.food.Good;

import java.util.Optional;

public class Desserts implements Good, Eatable {

    static JsonArray innerArray = Store.readGoodType("storage/desserts.json");

    public static Desserts get(int id) {
        return values()[id];
    }

    public static Desserts[] values() {
        Desserts[] desserts = new Desserts[innerArray.size()];
        for (int i = 0; i < desserts.length; i++) {
            JsonObject data = innerArray.get(i).getAsJsonObject();
            desserts[i] = new Desserts(data.get("name").getAsString(),
                    data.get("price").getAsInt());
        }
        return desserts;
    }

    public static Desserts valueOf(String type) {
        for (Desserts desserts: values()){
            if (desserts.getName().equals(type)) {
                return desserts;
            }
        }
        return null;
    }

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

    transient DiscountPrices discountPrices = new DiscountPrices();

    public int getPrice() {
        return price * discountPrices.getReductionToWholeType(getType(), SpecialWeeklyDiscounts.MONDAY_DESSERTS_DISCOUNT)/100;
    }

}

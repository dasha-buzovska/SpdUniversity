package pizzeria.goods;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import pizzeria.dateTimeTools.discounts.DiscountPrices;
import pizzeria.dateTimeTools.discounts.SpecialWeeklyDiscounts;
import pizzeria.fileManager.Store;
import pizzeria.goods.food.Eatable;

public class Desserts extends GoodItem implements Eatable {

    private boolean isVegetarian;
    static JsonArray innerArray = Store.readGoodType("storage/desserts.json");

    public boolean isVegetarian() {
        return isVegetarian;
    }

    private Desserts(String name, int price) {
        super(GoodsTypes.DESSERT, name, price);
        this.isVegetarian = true;
    }


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

    private transient DiscountPrices discountPrices = new DiscountPrices();

    public int getPrice() {
        return price * discountPrices.getReductionToWholeType(values(), SpecialWeeklyDiscounts.MONDAY_DESSERTS_DISCOUNT)/100;
    }

}

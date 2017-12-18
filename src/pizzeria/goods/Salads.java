package pizzeria.goods;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import pizzeria.dateTimeTools.discounts.DiscountPrices;
import pizzeria.dateTimeTools.discounts.SpecialWeeklyDiscounts;
import pizzeria.fileManager.Store;
import pizzeria.goods.food.Eatable;

public class Salads extends GoodItem implements Eatable {

    private boolean isVegetarian;

    Salads(String name, int price, boolean isVegetarian) {
        super(GoodsTypes.SALAD, name, price);
        this.isVegetarian = isVegetarian;
    }

    static JsonArray innerArray = Store.readGoodType("storage/salads.json");

    public static Salads get(int id) {
        return values()[id];
    }

    public static Salads[] values() {
        Salads[] salads = new Salads[innerArray.size()];
        for (int i = 0; i < salads.length; i++) {
            JsonObject data = innerArray.get(i).getAsJsonObject();
            salads[i] = new Salads(data.get("name").getAsString(),
                    data.get("price").getAsInt(),
                    data.get("isVegetarian").getAsBoolean());
        }
        return salads;
    }

    public static Salads valueOf(String type) {
        for (Salads salads: values()){
            if (salads.getName().equals(type)) {
                return salads;
            }
        }
        return null;
    }

    private transient DiscountPrices discountPrices = new DiscountPrices();
    public int getPrice() {
        return price * discountPrices.getReductionToWholeType(values(), SpecialWeeklyDiscounts.WEDNESDAY_SALADS_DISCOUNT)/100;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

    public GoodsTypes getType(){
        return GoodsTypes.SALAD;
    }

}

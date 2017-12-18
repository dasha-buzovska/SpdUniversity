package pizzeria.goods;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import pizzeria.dateTimeTools.discounts.DiscountPrices;
import pizzeria.dateTimeTools.discounts.SpecialWeeklyDiscounts;
import pizzeria.fileManager.Store;
import pizzeria.goods.food.Drinkable;

public class Drinks extends GoodItem implements Drinkable {

    private boolean isAlcoholic;

    private Drinks(String name, int price, boolean isAlcoholic){
        super(GoodsTypes.DRINK, name, price);
        this.isAlcoholic = isAlcoholic;
    }

    static JsonArray innerArray = Store.readGoodType("storage/drinks.json");

    public static Drinks get(int id) {
        return values()[id];
    }

    public static Drinks[] values() {
        Drinks[] drinks = new Drinks[innerArray.size()];
        for (int i = 0; i < drinks.length; i++) {
            JsonObject data = innerArray.get(i).getAsJsonObject();
            drinks[i] = new Drinks(data.get("name").getAsString(),
                    data.get("price").getAsInt(),
                    data.get("isAlcoholic").getAsBoolean());
        }
        return drinks;
    }

    public static Drinks valueOf(String type) {
        for (Drinks drinks: values()){
            if (drinks.getName().equals(type)) {
                return drinks;
            }
        }
        return null;
    }

    transient DiscountPrices discountPrices = new DiscountPrices();

    public int getPrice() {
        for (int i = 0; i < values().length; i++) {
            if (values()[i].isAlcoholic) {
                return price * discountPrices
                        .getReductionToSomeGoods(SpecialWeeklyDiscounts.FRIDAY_ALCOHOL_DISCOUNT) / 100;
            }
        }
        return price;
    }

    public boolean isAlcoholic() {
        return isAlcoholic;
    }

    public GoodsTypes getType() {
        return GoodsTypes.DRINK;
    }

}

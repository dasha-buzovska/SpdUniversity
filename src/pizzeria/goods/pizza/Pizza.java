package pizzeria.goods.pizza;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import pizzeria.dateTimeTools.discounts.DiscountPrices;
import pizzeria.dateTimeTools.discounts.SpecialWeeklyDiscounts;
import pizzeria.fileManager.Store;
import pizzeria.goods.GoodItem;
import pizzeria.goods.GoodsTypes;
import pizzeria.goods.food.Eatable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pizza extends GoodItem implements Eatable {

    static JsonArray innerArray = Store.readGoodType("storage/pizza.json");

    public static Pizza get(int id) {
        return values()[id];
    }

    public static Pizza[] values() {
        Pizza[] pizzas = new Pizza[innerArray.size()];
        for (int i = 0; i < pizzas.length; i++) {
            JsonObject data = innerArray.get(i).getAsJsonObject();
            pizzas[i] = new Pizza(data.get("name").getAsString(),
                    data.get("isVegetarian").getAsBoolean(), parseJsonArray(data.get("ingredients").getAsJsonArray()));
        }
        return pizzas;
    }

    public static Pizza valueOf(String type) {
        for (Pizza pizzas: values()){
            if (pizzas.getName().equals(type)) {
                return pizzas;
            }
        }
        return null;
    }

    private boolean isVegetarian;
    private List<Ingredients> pizzaElements;
    private PizzaSize size;

    private static List<Ingredients> parseJsonArray(JsonArray jsonArray){
        List<Ingredients> list = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            list.add(Ingredients.valueOf(jsonArray.get(i).getAsString()));
        }
        return list;
    }

    public void addIngredient(Ingredients ingredient) {
        pizzaElements.add(ingredient);
    }

    Pizza(String name,
          boolean isVegetarian, List<Ingredients> pizzaElements) {
        super(GoodsTypes.PIZZA, name, 0);
        this.isVegetarian = isVegetarian;
        this.pizzaElements = pizzaElements;
        this.size = PizzaSize.NORMAL;
    }

    public static final double normalSizeMultiplier = 1;
    public static final double bigSizeMultiplier = 1.3;
    public static final double maxiSizeMultiplier = 2;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return getSum(normalSizeMultiplier,normalSizeMultiplier);
    }

    public int getBigPrice() {
        return getSum(bigSizeMultiplier, normalSizeMultiplier);
    }

    DiscountPrices discountPrices = new DiscountPrices();

    public int getMaxiPrice() {
        return getSum(maxiSizeMultiplier,maxiSizeMultiplier)* discountPrices.getReductionToSomeGoods(SpecialWeeklyDiscounts.THURSDAY_MAXI_PIZZA_DISCOUNT) / 100;
    }

    @Override
    public boolean isVegetarian() {
        return isVegetarian;
    }

    public String printElements() {
        return pizzaElements.stream()
                .map(Ingredients::getName)
                .collect(Collectors.joining(", ", "(", ")"));
    }

    public void setSize(PizzaSize size) {
        this.size = size;
    }

    private int getSum(double pizzaBaseMultiplier, double ingredientsMultiplier){
        return (int)(pizzaBaseMultiplier*Ingredients.valueOf("Base").getPrice()
                + ingredientsMultiplier*pizzaElements
                .stream()
                .mapToInt(Ingredients::getPrice)
                .sum());
    }

}

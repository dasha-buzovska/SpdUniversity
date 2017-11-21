package pizzeria.goods;

import pizzeria.goods.food.Eatable;
import pizzeria.goods.food.Good;

import java.util.Optional;

public enum Salads implements Good, Eatable {
    GREEK("Greek", 30, true), SPRING("Spring", 40, false), HAPPY("Happy", 24, false),
    HEALTHY("Healthy", 18, true), CARROT_SALAD("Carrot salad", 15, true), INSALATA("Insalata", 25, true);

    private String name;
    private int price;
    private boolean isVegetarian;
    private GoodsTypes type;

    Salads(String name, int price, boolean isVegetarian) {
        this.name = name;
        this.price = price;
        this.isVegetarian = isVegetarian;
        this.type = GoodsTypes.SALAD;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

    public GoodsTypes getType() {
        return type;
    }

    public static Optional<Salads> getByIndex(int index) {
        if (values().length < index) {
            return Optional.empty();
        }
        return Optional.of(values()[index]);
    }
}

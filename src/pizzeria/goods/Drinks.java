package pizzeria.goods;

import pizzeria.goods.food.Drinkable;

import java.util.Optional;

public enum Drinks implements Drinkable {
    TEA("Tea", 10, false), COFFEE("Coffee", 20, false), WATER("Water", 11, false),
    JUICE("Juice", 15, false), BEER("Beer", 24, true), VODKA("Vodka", 20, true);

    private String name;
    private int price;
    private boolean isAlcoholic;
    private GoodsTypes type;

    Drinks(String name, int price, boolean isAlcoholic){
        this.name = name;
        this.price = price;
        this.isAlcoholic = isAlcoholic;
        this.type = GoodsTypes.DRINK;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public boolean isAlcoholic() {
        return isAlcoholic;
    }

    public GoodsTypes getType() {
        return type;
    }

    public static Optional<Drinks> getByIndex(int index) {
        if (values().length < index) {
            return Optional.empty();
        }
        return Optional.of(values()[index]);
    }
}

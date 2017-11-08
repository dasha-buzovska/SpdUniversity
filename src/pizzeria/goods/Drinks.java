package pizzeria.goods;

import pizzeria.goods.food.Drinkable;

public enum Drinks implements Drinkable {
    TEA("Tea", 10, false), COFFEE("Coffee", 20, false), WATER("Water", 11, false),
    JUICE("Juice", 15, false), BEER("Beer", 24, true), VODKA("Vodka", 20, true);

    private String name;
    private int price;
    private boolean isAlcoholic;

    Drinks(String name, int price, boolean isAlcoholic){
        this.name = name;
        this.price = price;
        this.isAlcoholic = isAlcoholic;
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
}

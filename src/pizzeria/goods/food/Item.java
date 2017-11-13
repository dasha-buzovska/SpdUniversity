package pizzeria.goods.food;

public class Item implements Good, Eatable {
    private String name;
    private int price;
    private boolean isVegetarian;

    public Item (String name, int price, boolean isVegetarian) {
        this.name = name;
        this.price = price;
        this.isVegetarian = isVegetarian;
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
}

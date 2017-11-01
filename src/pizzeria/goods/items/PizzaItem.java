package pizzeria.goods.items;

public class PizzaItem extends Item {

    private int normalPrice;
    private int bigPrice;
    private int maxiPrice;

    public PizzaItem(String name, int normalPrice, int bigPrice, int maxiPrice) {
        super(name, normalPrice);
        this.bigPrice = bigPrice;
        this.maxiPrice = maxiPrice;
    }

    public int getBigPrice() {
        return bigPrice;
    }

    public int getMaxiPrice() {
        return maxiPrice;
    }
}

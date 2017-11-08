package pizzeria.goods;

public enum GoodsTypes {
    SALAD("Salads"), DRINK("Drinks"), DESSERT("Desserts"), PIZZA("Pizza"), INGREDIENT("Ingredients");
    private String name;
    GoodsTypes(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

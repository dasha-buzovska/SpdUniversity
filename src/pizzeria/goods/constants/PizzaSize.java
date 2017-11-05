package pizzeria.goods.constants;

public enum PizzaSize {
    NORMAL("Normal"), BIG("Big"), MAXI("Maxi");
    private String name;
    PizzaSize(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

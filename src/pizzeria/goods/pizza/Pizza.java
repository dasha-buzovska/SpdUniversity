package pizzeria.goods.pizza;

import pizzeria.goods.GoodsTypes;
import pizzeria.goods.food.Eatable;
import pizzeria.goods.food.Good;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public enum Pizza implements Good, Eatable {

    YOUR_PIZZA("Your pizza", true, new ArrayList<>(Collections.singletonList(Ingredients.SAUCE))),
    MARGARITA("Margarita", true, new ArrayList<>(Arrays.asList(Ingredients.TOMATO, Ingredients.CHEESE))),
    PEPERONI("Peperoni", false, new ArrayList<>(Arrays.asList(Ingredients.TOMATO, Ingredients.CHEESE,
            Ingredients.SAUSAGE))),
    SEAFOOD("Seafood", true, new ArrayList<>(Arrays.asList(Ingredients.PINEAPPLE, Ingredients.CHEESE,
            Ingredients.SALMON))),
    HAWAIIAN("Hawaiian", false, new ArrayList<>(Arrays.asList(Ingredients.PINEAPPLE, Ingredients.CHEESE,
            Ingredients.TOMATO, Ingredients.CHICKEN, Ingredients.MUSHROOMS)));

    private String name;
    private boolean isVegetarian;
    private ArrayList<Ingredients> pizzaElements;
    private PizzaSize size;

    public GoodsTypes getType() {
        return GoodsTypes.PIZZA;
    }

    public void addIngredients(Ingredients item) {
        pizzaElements.add(item);
    }

    Pizza(String name,
          boolean isVegetarian, ArrayList<Ingredients> pizzaElements) {
        this.name = name;
        this.isVegetarian = isVegetarian;
        this.pizzaElements = pizzaElements;
        this.size = PizzaSize.NORMAL;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return Ingredients.BASE.getPrice()
                + pizzaElements.stream().mapToInt(Ingredients::getPrice).sum();
    }

    public int getBigPrice() {
        return (int)(1.3*Ingredients.BASE.getPrice())
                + pizzaElements.stream().mapToInt(Ingredients::getPrice).sum();
    }

    public int getMaxiPrice() {
        return 2*(Ingredients.BASE.getPrice()
                + pizzaElements.stream().mapToInt(Ingredients::getPrice).sum());
    }

    @Override
    public boolean isVegetarian() {
        return isVegetarian;
    }

    public void printElements() {
        System.out.println(pizzaElements.stream()
                .map(Ingredients::getName)
                .collect(Collectors.joining(", ", "(", ")")));
    }

    public void setSize(PizzaSize size) {
        this.size = size;
    }
}

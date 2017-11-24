package pizzeria.goods.pizza;

import pizzeria.goods.GoodsTypes;
import pizzeria.goods.food.Eatable;
import pizzeria.goods.food.Good;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Pizza implements Good, Eatable {

    YOUR_PIZZA("Your pizza", true, new Ingredients[]{Ingredients.SAUCE}),
    MARGARITA("Margarita", true, new Ingredients[]{Ingredients.TOMATO, Ingredients.CHEESE}),
    PEPERONI("Peperoni", false, new Ingredients[]{Ingredients.TOMATO, Ingredients.CHEESE,
            Ingredients.SAUSAGE}),
    SEAFOOD("Seafood", true, new Ingredients[]{Ingredients.PINEAPPLE, Ingredients.CHEESE,
            Ingredients.SALMON}),
    HAWAIIAN("Hawaiian", false, new Ingredients[]{Ingredients.PINEAPPLE, Ingredients.CHEESE,
            Ingredients.TOMATO, Ingredients.CHICKEN, Ingredients.MUSHROOMS});

    public Ingredients[] getPizzaElements() {
        return pizzaElements;
    }

    private String name;
    private boolean isVegetarian;
    private Ingredients[] pizzaElements;

    public GoodsTypes getType() {
        return GoodsTypes.PIZZA;
    }

    Pizza(String name,
          boolean isVegetarian, Ingredients[] pizzaElements) {
        this.name = name;
        this.isVegetarian = isVegetarian;
        this.pizzaElements = pizzaElements;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return Ingredients.BASE.getPrice()
                + Arrays.stream(pizzaElements).mapToInt(Ingredients::getPrice).sum();
    }

    public int getBigPrice() {
        return (int)(1.3*Ingredients.BASE.getPrice())
                + Arrays.stream(pizzaElements).mapToInt(Ingredients::getPrice).sum();
    }

    public int getMaxiPrice() {
        return 2*(Ingredients.BASE.getPrice()
                + Arrays.stream(pizzaElements).mapToInt(Ingredients::getPrice).sum());
    }

    @Override
    public boolean isVegetarian() {
        return isVegetarian;
    }

    public void printElements() {
        System.out.println(Arrays.stream(pizzaElements)
                .map(Ingredients::getName)
                .collect(Collectors.joining(", ", "(", ")")));
    }

}

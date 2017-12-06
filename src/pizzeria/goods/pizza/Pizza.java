package pizzeria.goods.pizza;

import pizzeria.dateTimeTools.discounts.DiscountPrices;
import pizzeria.dateTimeTools.discounts.SpecialWeeklyDiscounts;
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
        return getSum(1,1);
    }

    public int getBigPrice() {
        return getSum(1.3, 1);
    }

    DiscountPrices discountPrices = new DiscountPrices();

    public int getMaxiPrice() {
        return getSum(2,2)* discountPrices.getReductionToSomeGoods(SpecialWeeklyDiscounts.THURSDAY_MAXI_PIZZA_DISCOUNT) / 100;
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

    private int getSum(double a, double b){
        return (int)(a*Ingredients.BASE.getPrice()
                + b*pizzaElements
                .stream()
                .mapToInt(Ingredients::getPrice)
                .sum());
    }


}

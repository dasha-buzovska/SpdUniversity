package pizzeria.goods.pizza;

import pizzeria.goods.food.Eatable;
import pizzeria.goods.food.Good;

public enum Pizza implements Good, Eatable {

    YOUR_PIZZA("Your pizza", 15, 20, 25, true, new String[]{"Base", "Sauce"}),
    MARGARITA("Margarita", 35, 40, 45, true, new String[]{"Tomato", "Cheese"}),
    PEPERONI("Peperoni", 45, 50, 55, false, new String[]{"Tomato", "Cheese", "Salami", "Paprika"}),
    FOUR_CHEESES("4 Cheeses", 50, 60, 70, true, new String[]{"Mozzarella", "Parmesan", "Gorgonzola", "Cheddar"}),
    SEAFOOD("Seafood", 70, 85, 100, true, new String[]{"Pineapple", "Cheese", "Smoked salmon", "Squid", "Mussels"}),
    HAWAIIAN("Hawaiian", 65, 70, 80, false, new String[]{"Pineapple", "Cheese", "Tomato", "Chicken", "Olives", "Mushrooms"});

    private String name;
    private int price;
    private int bigPrice;
    private int maxiPrice;
    private boolean isVegetarian;
    private String[] pizzaElements;

    Pizza(String name, int price, int bigPrice, int maxiPrice,
          boolean isVegetarian, String[] pizzaElements) {
        this.name = name;
        this.price = price;
        this.bigPrice = bigPrice;
        this.maxiPrice = maxiPrice;
        this.isVegetarian = isVegetarian;
        this.pizzaElements = pizzaElements;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    public int getBigPrice() {
        return bigPrice;
    }

    public int getMaxiPrice() {
        return maxiPrice;
    }

    @Override
    public boolean isVegetarian() {
        return isVegetarian;
    }

    public void printElements() {
        System.out.print("( ");
        for (int i = 0; i < pizzaElements.length; i++) {
            System.out.print(pizzaElements[i] + " ");
        }
        System.out.println(")");
    }
}

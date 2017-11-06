package pizzeria;

import pizzeria.goods.Desserts;
import pizzeria.goods.Drinks;
import pizzeria.goods.constants.PizzaSize;
import pizzeria.interfaces.Good;
import pizzeria.goods.Salads;
import pizzeria.goods.constants.GoodsTypes;
import pizzeria.goods.items.Item;
import pizzeria.goods.pizza.Ingredients;
import pizzeria.goods.pizza.Pizza;

import java.util.ArrayList;


public class Bill {

    public ArrayList<? super Good> order = new ArrayList<>();
    private int sum = 0;

    public void addGood(GoodsTypes type, int id) {
        switch (type) {
            case SALAD:
                order.add(Salads.values()[id]);
                sum += Salads.values()[id].getPrice();
                break;
            case DRINK:
                order.add(Drinks.values()[id]);
                sum += Drinks.values()[id].getPrice();
                break;
            case DESSERT:
                order.add(Desserts.values()[id]);
                sum += Desserts.values()[id].getPrice();
                break;
            case INGREDIENT:
                order.add(Ingredients.values()[id]);
                sum += Ingredients.values()[id].getPrice();
                break;
            default:
                System.out.println("error");
                return;
        }
    }

    boolean addPizza(int id, String size) {
        if (size.equals("n")) {
            order.add(new Item(PizzaSize.NORMAL.getName() + " " + Pizza.values()[id].getName(),
                    Pizza.values()[id].getPrice(),
                    Pizza.values()[id].isVegetarian()));
            sum += Pizza.values()[id].getPrice();
        } else if (size.equals("b")) {
            order.add(new Item(PizzaSize.BIG.getName() + " " + Pizza.values()[id].getName(),
                    Pizza.values()[id].getBigPrice(),
                    Pizza.values()[id].isVegetarian()));
            sum += Pizza.values()[id].getBigPrice();
        } else if (size.equals("m")) {
            order.add(new Item(PizzaSize.MAXI.getName() + " " + Pizza.values()[id].getName(),
                    Pizza.values()[id].getMaxiPrice(),
                    Pizza.values()[id].isVegetarian()));
            sum += Pizza.values()[id].getMaxiPrice();
        } else {
            return false;
        }
        return true;
    }

    public int calculate() {
        return sum;
    }


}

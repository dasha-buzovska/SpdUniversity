package pizzeria;

import pizzeria.goods.Desserts;
import pizzeria.goods.Drinks;
import pizzeria.goods.pizza.PizzaSize;
import pizzeria.goods.food.Good;
import pizzeria.goods.Salads;
import pizzeria.goods.GoodsTypes;
import pizzeria.goods.food.Item;
import pizzeria.goods.pizza.Ingredients;
import pizzeria.goods.pizza.Pizza;

import java.util.ArrayList;


public class Order {

    public ArrayList<Good> orderList = new ArrayList<>();

    public void addGood(GoodsTypes type, int id) {
        switch (type) {
            case SALAD:
                if (Salads.getByIndex(id).isPresent()) {
                    orderList.add(Salads.getByIndex(id).get());
                }
                break;
            case DRINK:
                orderList.add(Drinks.values()[id]);
                break;
            case DESSERT:
                orderList.add(Desserts.values()[id]);
                break;
            case INGREDIENT:
                orderList.add(Ingredients.values()[id]);
                break;
            default:
                System.out.println("error");
                return;
        }
    }

    boolean addPizza(int id, String size) {
        if (size.equals("n")) {
            orderList.add(new Item(PizzaSize.NORMAL.getName() + " " + Pizza.values()[id].getName(),
                    Pizza.values()[id].getPrice(),
                    Pizza.values()[id].isVegetarian()));
        } else if (size.equals("b")) {
            orderList.add(new Item(PizzaSize.BIG.getName() + " " + Pizza.values()[id].getName(),
                    Pizza.values()[id].getBigPrice(),
                    Pizza.values()[id].isVegetarian()));
        } else if (size.equals("m")) {
            orderList.add(new Item(PizzaSize.MAXI.getName() + " " + Pizza.values()[id].getName(),
                    Pizza.values()[id].getMaxiPrice(),
                    Pizza.values()[id].isVegetarian()));
        } else {
            return false;
        }
        return true;
    }

    public int calculate() {
        int sum = 0;
        for (int i = 0; i < orderList.size(); i++) {
            sum += orderList.get(i).getPrice();
        }
        return sum;
    }

}

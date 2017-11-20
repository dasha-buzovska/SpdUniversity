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

    private ArrayList<Good> orderList = new ArrayList<>();
    public ArrayList<ArrayList<Good>> allOrders = new ArrayList<>();

    void addGood(GoodsTypes type, int id) {
        switch (type) {
            case SALAD:
                if (Salads.getByIndex(id).isPresent()) {
                    orderList.add(Salads.getByIndex(id).get());
                }
                break;
            case DRINK:
                if (Drinks.getByIndex(id).isPresent()) {
                    orderList.add(Drinks.getByIndex(id).get());
                }
                break;
            case DESSERT:
                if (Desserts.getByIndex(id).isPresent()) {
                    orderList.add(Desserts.getByIndex(id).get());
                }
                break;
            case INGREDIENT:
                if (Ingredients.getByIndex(id).isPresent()) {
                    orderList.add(Ingredients.getByIndex(id).get());
                }
                break;
            default:
                System.out.println("error");
        }
    }

    boolean addPizza(int id, String size) {
        if (Salads.getByIndex(id).isPresent()) {
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
        }
        return true;
    }

    public int calculate(ArrayList<Good> abstractOrder) {
        return abstractOrder.stream().mapToInt(Good::getPrice).sum();
    }

    void finishOrder() {
        allOrders.add(orderList);
        orderList = new ArrayList<>();
    }
}

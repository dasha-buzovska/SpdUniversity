package pizzeria;

import pizzeria.goods.Desserts;
import pizzeria.goods.Drinks;
import pizzeria.goods.GoodsTypes;
import pizzeria.goods.Salads;
import pizzeria.goods.food.Item;
import pizzeria.goods.pizza.Ingredients;
import pizzeria.goods.pizza.Pizza;
import pizzeria.goods.pizza.PizzaSize;

public class OrderManager {

    void addGood(GoodsTypes type, int id, Order order) {
        switch (type) {
            case SALAD:
                if (Salads.getByIndex(id).isPresent()) {
                    order.orderList.add(Salads.getByIndex(id).get());
                }
                break;
            case DRINK:
                if (Drinks.getByIndex(id).isPresent()) {
                    order.orderList.add(Drinks.getByIndex(id).get());
                }
                break;
            case DESSERT:
                if (Desserts.getByIndex(id).isPresent()) {
                    order.orderList.add(Desserts.getByIndex(id).get());
                }
                break;
            case INGREDIENT:
                if (Ingredients.getByIndex(id).isPresent()) {
                    order.orderList.add(Ingredients.getByIndex(id).get());
                }
                break;
            default:
                System.out.println("error");
        }
    }

    boolean addPizza(int id, String size, Order order) {
        if (Salads.getByIndex(id).isPresent()) {
            if (size.equals("n")) {
                order.orderList.add(new Item(PizzaSize.NORMAL.getName() + " " + Pizza.values()[id].getName(),
                        Pizza.values()[id].getPrice(),
                        Pizza.values()[id].isVegetarian(), GoodsTypes.PIZZA));
            } else if (size.equals("b")) {
                order.orderList.add(new Item(PizzaSize.BIG.getName() + " " + Pizza.values()[id].getName(),
                        Pizza.values()[id].getBigPrice(),
                        Pizza.values()[id].isVegetarian(), GoodsTypes.PIZZA));
            } else if (size.equals("m")) {
                order.orderList.add(new Item(PizzaSize.MAXI.getName() + " " + Pizza.values()[id].getName(),
                        Pizza.values()[id].getMaxiPrice(),
                        Pizza.values()[id].isVegetarian(), GoodsTypes.PIZZA));
            } else {
                return false;
            }
        }
        return true;
    }


}

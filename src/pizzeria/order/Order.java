package pizzeria.order;

import pizzeria.dateTimeTools.discounts.HolidaySales;
import pizzeria.goods.food.Drinkable;
import pizzeria.goods.food.Eatable;
import pizzeria.goods.food.Good;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderEntry> goodsList = new ArrayList<>();
    private LocalDateTime date = LocalDateTime.now();

    public List<OrderEntry> getGoodsList() {
        return goodsList;
    }

    public String getStringDate() {
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy\nHH:mm:ss"));
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void add(Good good) {
        goodsList.add(new OrderEntry(good));
    }

    public void add(OrderEntry orderEntry) {
        goodsList.add(orderEntry);
    }

    public boolean isEmpty() {
        return goodsList.isEmpty();
    }

    //TODO: fix situation when there are two same pizzas with different additions
    //TODO: Everything is bad.You add additions to enum and it changes next pizzas. try to avoid it
    public ArrayList<Good> packAdditionsToPizza() {
        ArrayList<Good> goodsWithoutIngredients = new ArrayList<>();
//        for (int i = 0; i < goodsList.size(); i++) {
//            if (goodsList.get(i).isPizza()) {
//                Pizza pizza = (Pizza) goodsList.get(i).type;
//                int index = goodsList.indexOf(pizza) + 1;
//                while (index < goodsList.size() && goodsList.get(index).isIngredient()) {
//                    pizza.addIngredients((Ingredients) goodsList.get(index).type);
//                    goodsList.remove(index);
//                }
//            }
//            goodsWithoutIngredients.add(goodsList.get(i).type);
//        }
        return goodsWithoutIngredients;
    }

    public int calculate() {
        return goodsList.stream().mapToInt(OrderEntry::getPrice).sum()*(100 - HolidaySales.getReductionIfSalesToday())/100;
    }

    public boolean isVegetarianBill() {
        return goodsList.stream().noneMatch(good -> good instanceof Eatable
                && !((Eatable) good).isVegetarian() ||
                good instanceof Drinkable && ((Drinkable) good).isAlcoholic());
    }
}

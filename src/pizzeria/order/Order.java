package pizzeria.order;

import pizzeria.dateTimeTools.discounts.HolidaySales;
import pizzeria.goods.food.Drinkable;
import pizzeria.goods.food.Eatable;
import pizzeria.goods.food.Good;
import pizzeria.goods.pizza.Pizza;
import pizzeria.goods.pizza.PizzaSize;

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
        add(new OrderEntry(good));
    }

    public void add(Pizza pizza, PizzaSize size) {
        add(new PizzaItem(pizza, size));
    }

    public void add(OrderEntry orderEntry) {
        if(orderEntry.isIngredient()) {
            ((PizzaItem) goodsList.get(goodsList.size()-1)).addIngredientsToPizza(orderEntry);
        } else {
            goodsList.add(orderEntry);
        }
    }

    public boolean isEmpty() {
        return goodsList.isEmpty();
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

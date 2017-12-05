package pizzeria.order;

import pizzeria.goods.food.Drinkable;
import pizzeria.goods.food.Eatable;
import pizzeria.goods.food.Good;
import pizzeria.goods.pizza.Ingredients;
import pizzeria.goods.pizza.Pizza;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Order {
    private ArrayList<Good> goodsList = new ArrayList<>();
    private Calendar date = Calendar.getInstance();

    public ArrayList<Good> getGoodsList() {
        return goodsList;
    }

    public String getStringDate() {
        return new SimpleDateFormat("dd/MM/yyyy\nHH:mm:ss").format(date.getTime());
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public void add(Good good) {
        goodsList.add(good);
    }

    public boolean isEmpty() {
        return goodsList.isEmpty();
    }

    //TODO: fix situation when there are two same pizzas with different additions
    public ArrayList<Good> packAdditionsToPizza() {
        ArrayList<Good> goodsWithoutIngredients = new ArrayList<>();
        for (int i = 0; i < goodsList.size(); i++) {
            if (goodsList.get(i) instanceof Pizza) {
                Pizza pizza = (Pizza) goodsList.get(i);
                int index = goodsList.indexOf(pizza) + 1;
                while (index < goodsList.size() && goodsList.get(index) instanceof Ingredients) {
                    pizza.addIngredients((Ingredients) goodsList.get(index));
                    goodsList.remove(index);
                }
            }
            goodsWithoutIngredients.add(goodsList.get(i));
        }
        return goodsWithoutIngredients;
    }

    public int calculate() {
        return goodsList.stream().mapToInt(Good::getPrice).sum();
    }

    public boolean isVegetarianBill() {
        return goodsList.stream().noneMatch(good -> good instanceof Eatable
                && !((Eatable) good).isVegetarian() ||
                good instanceof Drinkable && ((Drinkable) good).isAlcoholic());
    }
}

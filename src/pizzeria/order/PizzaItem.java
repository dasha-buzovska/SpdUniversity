package pizzeria.order;

import pizzeria.goods.pizza.Pizza;
import pizzeria.goods.pizza.PizzaSize;
import pizzeria.utils.Helper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PizzaItem extends OrderEntry {

    private List<OrderEntry> ingredientsList = new ArrayList<>();
    private PizzaSize size;

    PizzaItem(Pizza type, PizzaSize size){
        super(type);
        this.size = size;
    }

    public void addIngredientsToPizza(OrderEntry orderEntry) {
        if (size.equals(PizzaSize.MAXI)) {
            ingredientsList.add(orderEntry);
        }
        ingredientsList.add(orderEntry);
    }

    public int getBasePrice() {
        int basePrice;
        if (size == PizzaSize.NORMAL) {
            basePrice = type.getPrice();
        } else if (size == PizzaSize.BIG) {
            basePrice = ((Pizza) type).getBigPrice();
        } else {
            basePrice = ((Pizza) type).getMaxiPrice();
        }
        return basePrice;
    }

    public int getIngredientsPrice(){
        return ingredientsList.stream().mapToInt(OrderEntry::getPrice).sum();
    }

    public int getPrice(){
        return getBasePrice() + getIngredientsPrice();
    }

    public String displayPizzaRow() {
        return "" + Helper.appendSpaces(type.getName()) + getBasePrice();
    }

    public String displayRow() {
        return displayPizzaRow() + ingredientsList
                .stream()
                .map(type -> "" + Helper.appendSpaces(type.getName()) + type.getPrice())
                .collect(Collectors.joining("\n"));
    }

}

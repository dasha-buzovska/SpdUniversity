package pizzeria.utils;

import pizzeria.order.OrderEntry;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Helper {
    public static StringBuffer appendSpaces(String name) {
        assert name.length() < 40: "too long title!";
        StringBuffer space = new StringBuffer(name);
        int spacesDistance = 20;
        for (int i = 0; i < spacesDistance - name.length(); i++) {
            space = space.append(" ");
        }
        return space;
    }

    public static void sortByPrice(List<OrderEntry> list, String parameter) {
        Comparator<OrderEntry> comparator = Comparator.comparingInt(OrderEntry::getPrice);
        if (parameter.equals("pa")) {
            list.sort(comparator);
        } else if (parameter.equals("pd")) {
            list.sort(comparator.reversed());
        } else {
            throw new WrongInputException();
        }
    }

    public static void sortByName(ArrayList<OrderEntry> list, String parameter) {
        list.sort(new Comparator<OrderEntry>() {
            @Override
            public int compare(OrderEntry a, OrderEntry b) {
                if (parameter.equals("ta")) {
                    return a.getName().compareTo(b.getName());
                } else if (parameter.equals("td")) {
                    return b.getName().compareTo(a.getName());
                } else {
                    throw new WrongInputException();
                }
            }
        });
    }

    public static boolean containsName(ArrayList<OrderEntry> order, String name) {
        return order.stream().anyMatch(good -> good.contains(name));
    }
}

package pizzeria.printer;

import pizzeria.WrongInputException;
import pizzeria.goods.food.Good;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Helper {
    static StringBuffer appendSpaces(String name) {
        assert name.length() < 40: "too long title!";
        StringBuffer space = new StringBuffer(name);
        int spacesDistance = 20;
        for (int i = 0; i < spacesDistance - name.length(); i++) {
            space = space.append(" ");
        }
        return space;
    }

    static void sortByPrice(List<Good> list, String parameter) {
        Comparator<Good> comparator = Comparator.comparingInt(Good::getPrice);
        if (parameter.equals("pa")) {
            list.sort(comparator);
        } else if (parameter.equals("pd")) {
            list.sort(comparator.reversed());
        } else {
            throw new WrongInputException();
        }
    }

    static void sortByName(List<Good> list, String parameter) {
        list.sort(new Comparator<Good>() {
            @Override
            public int compare(Good a, Good b) {
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

    static boolean containsName(ArrayList<Good> order, String name) {
        return order.stream().anyMatch(good -> good.getName().contains(name));
    }
}

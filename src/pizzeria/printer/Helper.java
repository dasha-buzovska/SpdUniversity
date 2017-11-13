package pizzeria.printer;

import pizzeria.goods.food.Good;

import java.util.Comparator;
import java.util.List;

public class Helper {
    public static StringBuffer appendSpaces(String name) {
        StringBuffer space = new StringBuffer(name);
        int spacesDistance = 20;
        for (int i = 0; i < spacesDistance - name.length(); i++) {
            space = space.append(" ");
        }
        return space;
    }

    static void sort(List<Good> list, String parameter) {
        list.sort(new Comparator<Good>() {
            @Override
            public int compare(Good a, Good b) {
                if (parameter.equals("ta")) {
                    return a.getName().compareTo(b.getName());
                } else if (parameter.equals("td")) {
                    return b.getName().compareTo(a.getName());
                } else if ((parameter.equals("pa"))) {
                    return Integer.compare(a.getPrice(), b.getPrice());
                } else if ((parameter.equals("pd"))) {
                    return Integer.compare(b.getPrice(), a.getPrice());
                } else {
                    return 0;
                }
            }
        });
    }
}

package pizzeria;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import pizzeria.order.OrdersGenerator;
import pizzeria.order.Order;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FileController {
    static OrdersGenerator ordersGenerator = new OrdersGenerator();

    public static void main(String[] args) {
        List<Order> list = createArchivedList(1000);
        Gson gson = new Gson();
        Type type = new TypeToken<List<Order>>() {}.getType();

        try (FileWriter file = new FileWriter("archivedOrders.json")) {

            file.write(gson.toJson(list, type));
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //TODO: think about title and where to put this method
    public static ArrayList<Order> createArchivedList(int count) {
        ArrayList<Order> archivedOrders = new ArrayList();
        for (int i = 0; i < count; i++) {
            archivedOrders.add(ordersGenerator.generate());
        }
        return archivedOrders;
    }

}

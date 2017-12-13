package pizzeria.fileManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import pizzeria.order.Order;
import pizzeria.order.OrderDeserializer;
import pizzeria.order.OrderEntry;
import pizzeria.order.OrderEntryDeserializer;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.*;
import java.io.IOException;

public class Store {
    public static final String ARCHIVE_FILE = "archivedOrders.json";

    public static List<Order> read() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Order.class, new OrderDeserializer())
                .registerTypeAdapter(OrderEntry.class, new OrderEntryDeserializer())
                .create();
        try {
            JsonReader reader = new JsonReader(new FileReader(ARCHIVE_FILE));
            return gson.fromJson(reader, new TypeToken<java.util.List<Order>>() {}.getType());
        } catch (IOException e) {
            System.out.println("WARNING! HANDLE EXCEPTION!");
            return null;
        }
    }

    public static void write(List<Order> list) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Order>>() {}.getType();

        try (FileWriter file = new FileWriter(ARCHIVE_FILE)) {

            file.write(gson.toJson(list, type));
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

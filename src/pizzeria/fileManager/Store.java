package pizzeria.fileManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import pizzeria.dateTimeTools.SumForPeriod;
import pizzeria.order.Order;
import pizzeria.order.OrderDeserializer;
import pizzeria.order.OrderEntry;
import pizzeria.order.OrderEntryDeserializer;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.*;

public class Store {
    public static final String DIRECTORY = "storage/";
    public static final String INCOME_DIRECTORY = "income/";
    public static final String YEAR_DIRECTORY = "2017/";
    public static final String ARCHIVE_FILE = DIRECTORY + "archivedOrders.json";

    public static List<Order> readArchive() {
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

    public static JsonArray readGoodType(String filename) {
        JsonParser parser = new JsonParser();
        try {
            JsonReader reader = new JsonReader(new FileReader(filename));
            Object object = parser.parse(reader);
            JsonArray array = (JsonArray) object;
            return array;
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

    public static void writeSumsForPeriods(SumForPeriod sumForPeriod) {
        String standardName = "01.txt";
        String localDir = DIRECTORY + INCOME_DIRECTORY + YEAR_DIRECTORY;
        String yearPath = localDir + "totals.txt";
        String monthPath = localDir + "month/" + standardName;
        String weekPath = localDir + "week/" + standardName;
        String dayPath = localDir + "day/" + LocalDate.now() + ".txt";

        writeFile(yearPath, "" + sumForPeriod.findSumByConcretePeriod("year"));
        writeFile(monthPath, "" + sumForPeriod.findSumByConcretePeriod("month"));
        writeFile(weekPath, "" + sumForPeriod.findSumByConcretePeriod("week"));
        writeFile(dayPath, "" + sumForPeriod.findSumByConcretePeriod("day"));
    }

    private static void writeFile(String fileName, String data) {
        try ( Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(fileName), "utf-8"))) {
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

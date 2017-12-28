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
    public static final String standardName = "01.txt";
    public static final String localDir = DIRECTORY + INCOME_DIRECTORY + YEAR_DIRECTORY;
    public static final String yearPath = localDir + "totals.txt";
    public static final String monthPath = localDir + "month/" + standardName;
    public static final String weekPath = localDir + "week/" + standardName;
    public static final String dayPath = localDir + "day/" + LocalDate.now() + ".txt";

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
            System.out.println("we rewrite to archive file");
            file.write(gson.toJson(list, type));
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeSumsForPeriods(SumForPeriod sumForPeriod) {
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

    public static String readSum(String period, SumForPeriod sumForPeriod) {
        String fileName;
        if (period.equals("year")) {
            fileName = yearPath;
        } else if (period.equals("month")) {
            fileName = monthPath;
        } else if (period.equals("week")) {
            fileName = weekPath;
        } else {
            fileName = dayPath;
        }

        String sCurrentLine = "";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            sCurrentLine = br.readLine();
            if (isZero(sCurrentLine)) {
                System.out.println("ZERO PER DAy");
                sCurrentLine = "" + sumForPeriod.findSumByConcretePeriod(period);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sCurrentLine;
    }

    private static boolean isZero(String a){
        return a.equals("0");
    }
}

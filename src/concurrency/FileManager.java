package concurrency;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    public static final String DIRECTORY = "concurrencyFiles/";
    public static final String START_FILE = DIRECTORY + "storage.json";
    public static final String CHANGED_FILE = DIRECTORY + "newStorage.json";

    static JsonArray read(String filename) {
        JsonParser parser = new JsonParser();
        try {
            Object object = parser.parse(new JsonReader(new FileReader(filename)));
            return (JsonArray)object;
        } catch (IOException e) {
            System.out.println("WARNING! HANDLE EXCEPTION!");
            return null;
        }
    }

    static List<FileEntry> parseFileEntry() {
        JsonArray array = read(START_FILE);
        List<FileEntry> entries = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            JsonObject data = array.get(i).getAsJsonObject();
            entries.add(new FileEntry(data.get("id").getAsInt(),
                    data.get("title").getAsString(),
                    parseStringArray(data.get("tags").getAsJsonArray()),
                    data.get("url").getAsString(),
                    data.get("status").getAsString()));
        }
        return entries;
    }

    private static String[] parseStringArray(JsonArray jsonArray) {
        String[] array = new String[jsonArray.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = jsonArray.get(i).getAsString();
        }
        return array;
    }

    public static void rewrite(List<FileEntry> list) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<FileEntry>>() {}.getType();
        try (FileWriter file = new FileWriter(CHANGED_FILE)) {
            file.write(gson.toJson(list, type));
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createNewTXTFile(){

    }
}

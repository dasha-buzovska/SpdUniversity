package exam;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    public static List<String> readFile(String fileName) {
        List<String> list = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            for(String line; (line = br.readLine()) != null; ) {
                list.add(line);
            }
            return list;
        } catch (IOException e) {
            e.printStackTrace();
            return list;
        }
    }

    public static void write(List<Booking> list) {
        String a = "";
        for (int i = 0; i < list.size(); i++) {
            a+=list.get(i).writeToFile();
        }
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("resources/bookings.txt")))) {
            bufferedWriter.write(a);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

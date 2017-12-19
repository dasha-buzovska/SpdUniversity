package concurrency;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Controller {
    public static void main(String[] args) throws IOException {
        List<FileEntry> list = FileManager.parseFileEntry();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write pool number from 1 to " + list.size());
        String inputIndex = scanner.nextLine();
        int index = 0;
        try {
            index = Integer.parseInt(inputIndex);
            if (index > list.size()) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        ThreadPool.callThreadPool(index);
    }
}

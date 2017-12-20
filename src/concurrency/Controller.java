package concurrency;

import java.io.IOException;
import java.util.List;
public class Controller {
    public static void main(String[] args) throws IOException {
        List<FileEntry> list = FileManager.parseFileEntry();
        try {
            int index = Integer.parseInt(args[0]);
            if (index > list.size()) {
                throw new NumberFormatException();
            }
            ThreadPool.callThreadPool(index);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

    }
}

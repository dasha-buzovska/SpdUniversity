package concurrency;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Написать файлЕнтри
//Написать ридер и райтер для файлов
//написать довнлоадер
//написать к нему проверки

//rewrite storage with new status
//наисать средпул
//оформить контролер
//запустить

public class Controller {
    public static void main(String[] args) throws IOException {
        List<FileEntry> list = FileManager.parseFileEntry();
        for (int i = 0; i < list.size(); i++) {
            if (!DownloaderManager.endsWithWrongExtension(list.get(i).getUrl())
                    && !DownloaderManager.contains18PlusContent(list.get(i).getUrl())) {
                File file = new File(FileManager.DIRECTORY + list.get(i).getId() + ".txt");
                Downloader.download(list.get(i).getUrl(), file);
            }
        }
        //питаємо у користувача число н, менше кількості ссилок
        //check the number and rewrite if bad
        //ExecutorService executor = Executors.newFixedThreadPool(5);
        //execute threadPool + stop thread pool
        //executor must be an argument

        //ThreadPool.callThreadPool(executor, 5);

    }
}

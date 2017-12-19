package concurrency;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Написать файлЕнтри
//Написать ридер и райтер для файлов

//написать довнлоадер
//написать к нему промерки
//наисать средпул
//оформить контролер
//запустить

public class Controller {
    public static void main(String[] args) {
        List<FileEntry> list = FileManager.parseFileEntry();
        list.stream().map(FileEntry::toString).forEach(System.out::println);
        //питаємо у користувача число н, менше кількості ссилок
        //check the number and rewrite if bad
        //ExecutorService executor = Executors.newFixedThreadPool(5);
        //execute threadPool + stop thread pool
        //executor must be an argument

        //ThreadPool.callThreadPool(executor, 5);

    }
}

package concurrency;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void callThreadPool(int numberOfPools) throws IOException{
        ExecutorService executor = Executors.newFixedThreadPool(numberOfPools);
        List<FileEntry> fileEntryList = FileManager.parseFileEntry();
        for (int i = 0; i < fileEntryList.size(); i++) {
            Runnable worker = new EntryWorker(fileEntryList.get(i));
            executor.execute(worker);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        FileManager.rewrite(EntryWorker.getChangedStatusList());
    }
}

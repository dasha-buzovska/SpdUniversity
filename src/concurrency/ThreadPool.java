package concurrency;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class ThreadPool {
    public static void callThreadPool(int numberOfPools, int timeInterval) throws IOException{
        ExecutorService executor = Executors.newFixedThreadPool(numberOfPools);
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(timeInterval);
        List<FileEntry> fileEntryList = FileManager.parseFileEntry();
        for (int i = 0; i < fileEntryList.size(); i++) {
            Runnable worker = new EntryWorker(fileEntryList.get(i));
            executor.execute(worker);
            ses.scheduleAtFixedRate(worker, 0, timeInterval, TimeUnit.MILLISECONDS);
        }
        while (!executor.isTerminated()) {
            executor.shutdown();
        }
        FileManager.rewrite(fileEntryList);
    }
}

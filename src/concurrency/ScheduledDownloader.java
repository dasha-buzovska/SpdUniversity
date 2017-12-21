package concurrency;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ScheduledDownloader implements Runnable {

    private int poolSize;

    ScheduledDownloader (int poolSize) {
        this.poolSize = poolSize;
    }

    @Override
    public void run() {
        ExecutorService executor = Executors.newFixedThreadPool(poolSize);
        List<WebLink> webLinkList = FileManager.parseFileEntry();
        for (WebLink webLink : webLinkList) {
            Runnable worker = new EntryWorker(webLink);
            executor.execute(worker);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        FileManager.rewrite(webLinkList);
    }
}

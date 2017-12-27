package concurrency;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ScheduledDownloader implements Runnable {

    private int poolSize;
    private WebLinksCollector collector;
    static int triesForFailedNumber;
    static int counter = 0;

    ScheduledDownloader (int poolSize, WebLinksCollector collector, int triesNumber) {
        this.poolSize = poolSize;
        this.collector = collector;
        triesForFailedNumber = triesNumber;
    }

    @Override
    public void run() {
        ExecutorService executor = Executors.newFixedThreadPool(poolSize);
        List<WebLink> webLinkList = FileManager.parseFileEntry();
        collector.start();
        for (WebLink webLink : webLinkList) {
            Runnable worker = new EntryWorker(webLink, collector);
            executor.execute(worker);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        collector.finish();
        FileManager.rewrite(webLinkList);
    }
}

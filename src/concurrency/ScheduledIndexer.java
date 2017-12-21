package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ScheduledIndexer implements Runnable {
    private int poolSize;
    private WebLinksCollector collector;

    ScheduledIndexer (int poolSize, WebLinksCollector collector) {
        this.poolSize = poolSize;
        this.collector = collector;
    }

    @Override
    public void run() {
        ExecutorService executor = Executors.newFixedThreadPool(poolSize);
        while (!executor.isTerminated()) {
            if (collector.isFinished()) {
                executor.shutdown();
            }
            try {
                Thread.currentThread();
                Thread.sleep(200);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            WebLink webLink = collector.get();
            if (webLink != null) {
                Runnable worker = new ElasticSearchIndexator(webLink);
                executor.execute(worker);
            }
        }
    }
}

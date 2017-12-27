package concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Controller {

    public static void main(String[] args) throws Exception {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(2);
        Parameters parameters = new Parameters(args);
        WebLinksCollector collector = new WebLinksCollector();

        Runnable downloader = new ScheduledDownloader(parameters.getPoolSize(), collector, parameters.getTriesForFailedNumber());
        Runnable indexer = new ScheduledIndexer(parameters.getPoolSize(), collector);

        ses.scheduleAtFixedRate(downloader, 0, parameters.getTimeInterval(), parameters.getTimeUnit());
        ses.scheduleAtFixedRate(indexer, 0, parameters.getTimeInterval(), parameters.getTimeUnit());
    }
}

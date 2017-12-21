package concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Controller {
    public static void main(String[] args) throws Exception {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
        Parameters parameters = new Parameters(args);
        Runnable worker = new ScheduledDownloader(parameters.getPoolSize());
        ses.scheduleAtFixedRate(worker, 0, parameters.getTimeInterval(), parameters.getTimeUnit());
    }
}

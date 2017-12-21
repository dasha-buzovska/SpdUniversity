package concurrency;

import java.util.concurrent.ConcurrentLinkedQueue;

public class WebLinksCollector {
    private ConcurrentLinkedQueue<WebLink> collection;
    private boolean finished;

    public void start() {
        collection = new ConcurrentLinkedQueue<>();
        finished = false;
    }

    public void collect(WebLink webLink) {
        collection.add(webLink);
    }

    public WebLink get() {
        return collection.poll();
    }

    public boolean isFinished() {
        return finished;
    }

    public void finish() {
        finished = true;
    }
}

package concurrency;

import java.io.FileNotFoundException;
import java.io.IOException;

public class EntryWorker implements Runnable {

    private WebLink entry;
    WebLinksCollector collector;

    EntryWorker(WebLink entry, WebLinksCollector collector) {
        this.entry = entry;
        this.collector = collector;
    }
    @Override
    public void run() {
        try {
            downloadEntry();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private synchronized void downloadEntry() throws IOException {
        try {
            if (!DownloaderManager.endsWithWrongExtension(entry.getUrl())
                    && !DownloaderManager.contains18PlusContent(entry.getUrl())
                    && entry.getStatus().equals(WebLink.NOT_ATTEMPTED)) {
                System.out.println("Downloading: "+ entry.getUrl());
                FileManager.createNewTXTFile(entry);
                collector.collect(entry);
                addEntry(WebLink.SUCCESS);
            } else {
                addEntry(WebLink.NOT_ELIGIBLE);
            }
        } catch (FileNotFoundException e) {
            addEntry(WebLink.FAILED);
        }
    }

    private void addEntry(String status){
        entry.setStatus(status);
    }
}

package concurrency;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Queue;

public class EntryWorker implements Runnable {

    private FileEntry entry;
    private Queue<FileEntry> webLinkQueue = new PriorityQueue<>();

    EntryWorker(FileEntry entry) {
        this.entry = entry;
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
                    && entry.getStatus().equals(FileEntry.NOT_ATTEMPTED)) {
                FileManager.createNewTXTFile(entry);
                webLinkQueue.add(entry);
                System.out.println(entry.getUrl());
                ElasticSearchIndexator.setIndex(webLinkQueue);
                addEntry(FileEntry.SUCCESS);
            } else {
                addEntry(FileEntry.NOT_ELIGIBLE);
            }
        } catch (FileNotFoundException e) {
            addEntry(FileEntry.FAILED);
        }
    }

    private void addEntry(String status){
        entry.setStatus(status);
    }
}

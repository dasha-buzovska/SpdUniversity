package concurrency;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EntryWorker implements Runnable {

    private FileEntry entry;
    private static List<FileEntry> changedStatusList = new ArrayList<>();

    public static List<FileEntry> getChangedStatusList() {
        return changedStatusList;
    }

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
        processCommand();
    }

    private void processCommand() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void downloadEntry() throws IOException {
        try {
            if (!DownloaderManager.endsWithWrongExtension(entry.getUrl())
                    && !DownloaderManager.contains18PlusContent(entry.getUrl())
                    && entry.getStatus().equals(FileEntry.NOT_ATTEMPTED)) {
                FileManager.createNewTXTFile(entry);
                System.out.println(entry.getUrl());
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
        changedStatusList.add(entry);
    }
}

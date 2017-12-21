package concurrency;

import java.util.Queue;

class ElasticSearchIndexator {

    static void setIndex(Queue<FileEntry> queue){
        System.out.println(queue.element().getId() + ".txt");
        System.out.println(queue.element().getId());
    }

}

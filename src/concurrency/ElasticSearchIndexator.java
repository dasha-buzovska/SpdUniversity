package concurrency;

class ElasticSearchIndexator implements Runnable {

    private WebLink webLink;

    ElasticSearchIndexator (WebLink webLink) {
        this.webLink = webLink;
    }

    @Override
    public void run() {
        System.out.println("Indexing: " + webLink.getId());
    }
}

package concurrency;

public class WebLink implements Comparable {
    private int id;
    private String title;
    private String[] tags;
    private String url;
    private String status;

    public static final String NOT_ATTEMPTED = "NOT_ATTEMPTED";
    public static final String SUCCESS = "SUCCESS";
    public static final String FAILED = "FAILED";
    public static final String NOT_ELIGIBLE = "NOT_ELIGIBLE";

    public WebLink(int id, String title, String[] tags, String url, String status) {
        this.id = id;
        this.title = title;
        this.tags = tags;
        this.url = url;
        this.status = status;
    }

    @Override
    public int compareTo(Object o) {
        WebLink entry = (WebLink) o;
        return Integer.compare(id, entry.id);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    String getStatus() {
        return status;
    }

    void setStatus(String status) {
        this.status = status;
    }

    public String toString(){
        return "id: " + id + "\n" +
                "title: " + title + "\n" +
                "tags: " + tags + "\n" +
                "url: " + url + "\n" +
                "status: " + status + "\n";
    }
}

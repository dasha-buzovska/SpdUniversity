package concurrency.badUrlList;

public enum Extensions {
    AVI(".avi"), PDF(".pdf"), MP4(".mp4"), PNG(".png"), JPG(".jpg");

    private String extension;

    Extensions(String extension) {
        this.extension = extension;
    }

    public String getExtension() {
        return extension;
    }
}

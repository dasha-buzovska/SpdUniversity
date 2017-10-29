package com.spduniversity.spdulib.entity;


/* TODO: Authors, language and genre looks like common fields for
OnlineCourse and Book, so why not to move them into Item class?
* */
public class OnlineCourse extends Item {
    private String source;  // Coursera, udemy, edx, Prometheus, etc.
    private String level;   // Basic, Intermediate, Advanced, Hard
    private String[] authors; // Course authors
    private int durationInWeeks; // 6 weeks
    private String language;    // English, Russian, Ukrainian, etc.
    private String genre;       // Programming, Business, Computer Science
    private double rating;

    public static class Builder {
        private long id;
        private String title;
        private String url;
        private String source;  // Coursera, udemy, edx, Prometheus, etc.
        private String level;   // Basic, Intermediate, Advanced, Hard
        private String[] authors; // Course authors
        private int durationInWeeks; // 6 weeks
        private String language;    // English, Russian, Ukrainian, etc.
        private String genre;       // Programming, Business, Computer Science
        private double rating;

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder source(String source) {
            this.source = source;
            return this;
        }

        public Builder level(String level) {
            this.level = level;
            return this;
        }

        public Builder authors(String[] authors) {
            this.authors = authors;
            return this;
        }

        public Builder durationInWeeks(int durationInWeeks) {
            this.durationInWeeks = durationInWeeks;
            return this;
        }

        public Builder language(String language) {
            this.language = language;
            return this;
        }

        public Builder genre(String genre) {
            this.genre = genre;
            return this;
        }

        public Builder rating(double rating) {
            this.rating = rating;
            return this;
        }
        public OnlineCourse build() {
            return new OnlineCourse(this);
        }
    }

    public OnlineCourse(Builder builder) {
        setId(builder.id);
        setTitle(builder.title);
        setUrl(builder.url);
        source = builder.source;
        level = builder.level;
        authors = builder.authors;
        durationInWeeks = builder.durationInWeeks;
        language = builder.language;
        genre = builder.genre;
        rating = builder.rating;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public int getDurationInWeeks() {
        return durationInWeeks;
    }

    public void setDurationInWeeks(int durationInWeeks) {
        this.durationInWeeks = durationInWeeks;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String toString() {
        String str = "";
        str += "Id: " + getId() + "\n";
        str += "Title: " + getTitle() + "\n";
        str += "Link: " + getUrl() + "\n";
        str += "Source: " + getSource() + "\n";
        str += "Level: " + getLevel() + "\n";
        str += "Authors: " + String.join(", ", getAuthors()) + "\n";
        str += "Duration In Weeks: " + getDurationInWeeks() + "\n";
        str += "Genre: " + getGenre() + "\n";
        str += "Language: " + getLanguage() + "\n";
        str += "Rating: " + getRating() + "\n";
        return str;
    }
}

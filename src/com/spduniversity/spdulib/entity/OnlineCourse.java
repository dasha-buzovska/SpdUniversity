package com.spduniversity.spdulib.entity;

public class OnlineCourse extends Item {
    private String source;  // Coursera, udemy, edx, Prometheus, etc.
    private String level;   // Basic, Intermediate, Advanced, Hard
    private String[] authors; // Course authors
    private int durationInWeeks; // 6 weeks
    private String language;    // English, Russian, Ukrainian, etc.
    private String genre;       // Programming, Business, Computer Science
    private double rating;      // 4.9

    public OnlineCourse(long id, String title, String url, String source, String level, String[] authors, int durationInWeeks, String language, String genre, double rating) {
        super(id, title, url);
        this.source = source;
        this.level = level;
        this.authors = authors;
        this.durationInWeeks = durationInWeeks;
        this.language = language;
        this.genre = genre;
        this.rating = rating;
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

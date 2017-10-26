package com.spduniversity.spdulib.entity;

public class Book extends Item {
    private int publicationYear;    // 2017
    private String publisher;   // O'Relly
    private String[] authors;
    private String genre;   // Engineering, Business, Programming
    private String language;    // English, Russian, etc
    private double amazonRating;

    public static class Builder {
        private long id;
        private String title;
        private String url;
        private int publicationYear;
        private String publisher;
        private String[] authors;
        private String genre;
        private String language;
        private double amazonRating;

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

        public Builder publicationYear(int publicationYear) {
            this.publicationYear = publicationYear;
            return this;
        }

        public Builder publisher(String publisher) {
            this.publisher = publisher;
            return this;
        }

        public Builder authors(String[] authors) {
            this.authors = authors;
            return this;
        }

        public Builder genre(String genre) {
            this.genre = genre;
            return this;
        }

        public Builder language(String language) {
            this.language = language;
            return this;
        }

        public Builder amazonRating(double amazonRating) {
            this.amazonRating = amazonRating;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }

    private Book(Builder builder) {
        setId(builder.id);
        setTitle(builder.title);
        setUrl(builder.url);
        publicationYear = builder.publicationYear;
        publisher = builder.publisher;
        authors = builder.authors;
        genre = builder.genre;
        language = builder.language;
        amazonRating = builder.amazonRating;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public double getAmazonRating() {
        return amazonRating;
    }

    public void setAmazonRating(double amazonRating) {
        this.amazonRating = amazonRating;
    }

    public String toString() {
        String str = "";
        str += "Id: " + getId() + "\n";
        str += "Title: " + getTitle() + "\n";
        str += "Link: " + getUrl() + "\n";
        str += "Publication Year: " + getPublicationYear() + "\n";
        str += "Publisher: " + getPublisher() + "\n";
        str += "Authors: " + String.join(", ", getAuthors()) + "\n";
        str += "Genre: " + getGenre() + "\n";
        str += "Language: " + getLanguage() + "\n";
        str += "Amazon rating: " + getAmazonRating() + "\n";
        return str;
    }
}

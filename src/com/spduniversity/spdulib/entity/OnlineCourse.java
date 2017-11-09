package com.spduniversity.spdulib.entity;



public class OnlineCourse extends Item {
    private String source;  // Coursera, udemy, edx, Prometheus, etc.
    private String level;   // Basic, Intermediate, Advanced, Hard
    private int durationInWeeks; // 6 weeks
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
        setAuthors(builder.authors);
        durationInWeeks = builder.durationInWeeks;
        setLanguage(builder.language);
        setGenre(builder.genre);
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

    public int getDurationInWeeks() {
        return durationInWeeks;
    }

    public void setDurationInWeeks(int durationInWeeks) {
        this.durationInWeeks = durationInWeeks;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public AbstractDisplayInfo getDisplayInfo() {
        return new ConcreteOnlineCourseInfo(this);
    }
}

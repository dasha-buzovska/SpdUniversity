package exam;

public class Film {
    private int idFilm;
    private String title;
    private String country;
    private int year;
    private String[] genres;
    private String[] actors;
    private String budget;
    private int duration;
    private int rate;
    private String description;

    public int getIdFilm() {
        return idFilm;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String[] getGenres() {
        return genres;
    }

    public String[] getActors() {
        return actors;
    }

    public String getBudget() {
        return budget;
    }

    public int getDuration() {
        return duration;
    }

    public int getRate() {
        return rate;
    }

    public String getDescription() {
        return description;
    }

    public Film(int idFilm, String title, String country, int year, String[] genres, String[] actors, String budget,
                int duration, int rate, String description) {
        this.idFilm = idFilm;
        this.title = title;
        this.country = country;
        this.year = year;
        this.genres = genres;
        this.actors = actors;
        this.budget = budget;
        this.duration = duration;
        this.rate = rate;
        this.description = description;
    }
}

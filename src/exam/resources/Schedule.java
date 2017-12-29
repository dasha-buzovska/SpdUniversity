package exam.resources;

import java.time.LocalDate;
import java.time.LocalTime;

public class Schedule {
    private int id;
    private int idFilm;
    private String theater;
    private int price;
    private LocalDate date;
    private LocalTime[] time;
    private boolean format;

    public Schedule(int id, int idFilm, String theater, int price, LocalDate date, LocalTime[] time, boolean format) {
        this.id = id;
        this.idFilm = idFilm;
        this.theater = theater;
        this.price = price;
        this.date = date;
        this.time = time;
        this.format = format;
    }

    public int getId() {
        return id;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public String getTheater() {
        return theater;
    }

    public int getPrice() {
        return price;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime[] getTime() {
        return time;
    }

    public boolean isFormat() {
        return format;
    }
}

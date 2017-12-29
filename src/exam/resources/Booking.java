package exam.resources;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Booking {
    private int id;
    private LocalDate date;
    private LocalTime[] time;
    private int idFilm;
    private int place;
    private LocalDateTime booking;
    private String firstName;
    private String lastName;
    private String email;
    private long mobile;

    public Booking(int id, LocalDate date, LocalTime[] time, int idFilm, int place,
                   LocalDateTime booking, String firstName, String lastName, String email, long mobile) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.idFilm = idFilm;
        this.place = place;
        this.booking = booking;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime[] getTime() {
        return time;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public int getPlace() {
        return place;
    }

    public LocalDateTime getBooking() {
        return booking;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public long getMobile() {
        return mobile;
    }
}

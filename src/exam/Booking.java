package exam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class Booking {
    private int id;
    private LocalDate date;
    private LocalTime time;
    private int idFilm;
    private int places;
    private LocalDateTime booking;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;

    public Booking(int id, LocalDate date, LocalTime time, int idFilm, int place,
                   LocalDateTime booking, String firstName, String lastName, String email, String mobile) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.idFilm = idFilm;
        this.places = place;
        this.booking = booking;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
    }

    public static Booking bookingByFilmId(List<Booking> list, int id) {
        Booking booking = null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getIdFilm() == id) {
                booking = list.get(i);
            }
        }
        return booking;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public int getPlaces() {
        return places;
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

    public String getMobile() {
        return mobile;
    }
}

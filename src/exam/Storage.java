package exam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Storage {
    Parser parser = new Parser();
    List<Film> films = parser.parseFilm(FileManager.readFile("resources/film-details.txt"));
    List<Schedule> schedules = parser.parseSchedule(FileManager.readFile("resources/film-schedule.txt"));
    List<Booking> bookings = parser.parseBookings(FileManager.readFile("resources/bookings.txt"));


    public void findCurrentFilm(LocalDate date, LocalTime time) {

        for (Schedule schedule: schedules) {
            if (schedule.getDate().equals(date)) {
                for (LocalTime time1: schedule.getTime()) {
                    if (time.equals(time1)) {
                        Film film = Film.filmById(films, schedule.getIdFilm());
                        Booking booking = Booking.bookingByFilmId(bookings, schedule.getIdFilm());
                        System.out.println(film.getTitle() + "\n" + time1 +
                                " - " + time1.plusMinutes(film.getDuration()) + "\nHall: " + schedule.getTheater()
                                + " Empty places: " + findEmptyPlace(schedule.getTheater(), booking.getPlaces()));
                    }
                }
            }
        }
    }

    public void findCurrentFilm(LocalDate date) {
        LocalTime time = LocalTime.now();
        LocalTime startTime = LocalTime.of(time.getHour()+1, 0);
        while (startTime.isBefore(LocalTime.of(0,0))) {
            findCurrentFilm(date, startTime);
            startTime = startTime.minusHours(1);
        }
    }

    public void findCurrentFilm() {
        findCurrentFilm(LocalDate.now());
    }

    private int findEmptyPlace(String size, int places) {
        if (size.equals("big")) {
            return 20 - places;
        } else {
            return 10 - places;
        }
    }

    public void displayInfo(String title) {
        Film chosenFilm = null;
        for (Film film: films) {
            if (film.getTitle().equals(title)) {
                chosenFilm = film;
                System.out.println(film.toString());
            }
            for(Schedule schedule: schedules) {
                if (schedule.getIdFilm() == chosenFilm.getIdFilm()) {
                    Booking booking = Booking.bookingByFilmId(bookings, chosenFilm.getIdFilm());
                    System.out.println(film.getTitle() + "\n" + schedule.getTime() +
                            "\nHall: " + schedule.getTheater()
                            + " Empty places: " + findEmptyPlace(schedule.getTheater(), booking.getPlaces()));
                }
            }
        }
    }

    public void bookPlace(LocalDate date, LocalTime time, String hall, int place,
                          String title, String firsName, String lastName, String email, String mobile) {
        List<Booking> currentBooking = new ArrayList<>();
        int counter = bookings.size();
        for (Booking booking: bookings) {
            if (booking.getDate().equals(date) && booking.getTime().equals(time) && booking.getPlaces() == place) {
                System.out.println("this place is empty");
            } else {
                counter++;
                currentBooking.add(new Booking(counter, date, time, 3000, place,
                        LocalDateTime.now(), firsName, lastName, email, mobile));
            }
        }
        bookings.addAll(currentBooking);
    }
}

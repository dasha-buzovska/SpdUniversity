package exam;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class CinemaHall {
    public static void main(String[] args) {
// По заданному фильму вывести подробную инфу о фильме, время начала/окончания, зал, к-во свободных мест
    Parser parser = new Parser();
//        List<Film> list = parser.parseFilm(FileManager.readFile("resources/film-details.txt"));
//        System.out.println(list.get(0).getGenres());
//        List<Schedule> list1 = parser.parseSchedule(FileManager.readFile("resources/film-schedule.txt"));
//// 2017-12-25 | [11:00, 14:00, 18:00, 22:00] | 3D |
//        2 | 3000 | big | 150 | 2017-12-25 | [12:00, 18:00, 21:00] | |
        Storage storage = new Storage();
        storage.findCurrentFilm(LocalDate.parse("2017-12-25"), LocalTime.of(18, 0));
        storage.findCurrentFilm(LocalDate.parse("2017-12-25"));

        storage.displayInfo("Predator");
//        List<Booking> list = parser.parseBookings(FileManager.readFile("resources/bookings.txt"));
//        System.out.println(list.get(0).getDate());



    }
}

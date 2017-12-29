package exam;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Stream;

public class Storage {
    Parser parser = new Parser();
    List<Film> films = parser.parseFilm(FileManager.readFile("resources/film-details.txt"));
    List<Schedule> schedules = parser.parseSchedule(FileManager.readFile("resources/film-schedule.txt"));

    public void findCurrentFilm(LocalDate date, LocalTime time) {
//        Stream<Schedule> today = schedules.stream().filter(schedule -> schedule.getDate().equals(date));
//        //По заданной дате (если не задана, то берется текущая) и времени (если время не задано, то берем весь день)
//        // вывести список фильмов с временем начала/конца и залом, количество свободных мест
//        today
//                .filter(time1 -> time.equals(time1))
//                .forEach(schedule -> System.out.println(schedule.getTime() + " " + schedule.getTheater()));
        for (Schedule schedule: schedules) {
            if (schedule.getDate().equals(date)) {
                for (LocalTime time1: schedule.getTime()) {
                    if (time.equals(time1)) {
                        Film film = Film.filmById(films, schedule.getIdFilm());
                        System.out.println(film.getTitle() + "\n" + time1 +
                                " - " + time1.plusMinutes(film.getDuration()) + " " + schedule.getTheater());
                    }
                }
            }
        }
    }
}

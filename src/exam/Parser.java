package exam;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Parser {

    public List<Film> parseFilm(List<String> list) {
        List<Film> films = new ArrayList<>();
        for (String line: list) {
            String[] array = line.split("\\|");
            int id = Integer.parseInt(array[0].trim());
            String title = array[1].trim();
            String country = array[2].trim();
            int year = Integer.parseInt(array[3].trim());
            String[] genres = array[4].substring(1, array[4].length() - 1).split(", ");
            String[] actors = array[5].substring(1, array[5].length() - 1).split(", ");;
            String budget = array[6].trim();
            int duration = Integer.parseInt(array[7].trim());
            int rate = Integer.parseInt(array[8].trim());
            String description = array[9].trim();
            films.add(new Film(id, title, country, year, genres, actors, budget, duration, rate, description));
        }
        return films;
    }

    public List<Schedule> parseSchedule(List<String> list) {
        List<Schedule> schedules = new ArrayList<>();
        for (String line: list) {
            String[] array = line.split("\\|");
            int id = Integer.parseInt(array[0].trim());
            int idFilm = Integer.parseInt(array[1].trim());
            String theater = array[2];
            int price = Integer.parseInt(array[3].trim());
            LocalDate date = LocalDate.parse(array[4].trim());
            List<LocalTime> time = new ArrayList<>();
            for (int i = 0; i < array[5].trim().substring(1, array[5].length() - 3).split(", ").length; i++) {
                time.add(LocalTime.parse(array[5].trim().substring(1, array[5].length() - 3).split(", ")[i]));
            }
            boolean format = array[6].trim().equals("3D");
            schedules.add(new Schedule(id, idFilm, theater, price, date, time, format));
        }
        return schedules;
    }

}

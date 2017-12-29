package exam;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    public List<Film> parseFilm(List<String> list) {
        List<Film> films = new ArrayList<>();
        for (String line: list) {
            String[] array = line.split("\\|");
            System.out.println(array[0]);
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
}

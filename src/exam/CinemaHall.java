package exam;

import java.util.List;

public class CinemaHall {
    public static void main(String[] args) {
//        System.out.println(FileManager.readFile("resources/bookings.txt"));
        Parser parser = new Parser();
        List<Film> list = parser.parseFilm(FileManager.readFile("resources/film-details.txt"));
        System.out.println(list.get(0).getGenres());

    }
}

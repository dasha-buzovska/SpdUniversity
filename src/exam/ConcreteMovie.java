package exam;

import java.time.LocalDate;
import java.time.LocalTime;

public class ConcreteMovie {

    private LocalDate date;
    private LocalTime time;
    private String hall;

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getHall() {
        return hall;
    }

    public ConcreteMovie(LocalDate date, LocalTime time, String hall) {

        this.date = date;
        this.time = time;
        this.hall = hall;
    }
}

package pizzeria.dateTimeTools.discounts;

import java.time.LocalDate;

public enum HolidaySales {
    CHRISTMAS(LocalDate.of(2018, 1, 7), 20),
    NEW_YEAR(LocalDate.of(2018,1,1), 15),
    EASTER(LocalDate.of(2018, 4,8), 25),
    BLACK_FRIDAY(LocalDate.of(2018, 11, 30), 5),
    PIZZA_HOUSE_BIRTHDAY(LocalDate.of(2018, 5, 12));

    private LocalDate date;
    private int reduction;

    public LocalDate getDate() {
        return date;
    }

    HolidaySales(LocalDate date) {
        this.date = date;
    }

    HolidaySales(LocalDate date, int reduction) {
        this.date = date;
        this.reduction = reduction;
    }

    public static int getReductionIfSalesToday() {
        for (int i = 0; i < values().length - 1; i++) {
            if (LocalDate.now().equals(values()[i].date)) {
                return HolidaySales.values()[i].reduction;
            }
        }
        return 0;
    }

}

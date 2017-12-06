package pizzeria.dateTimeTools.discounts;

import java.time.LocalDate;

public enum HolidaySales {
    //TODO: set year automatic in date
    CHRISTMAS(LocalDate.of(2018, 1, 7), 20),
    NEW_YEAR(LocalDate.of(2018,1,1), 15),
    EASTER(LocalDate.of(2018, 4,8), 25),
    BLACK_FRIDAY(LocalDate.of(2018, 11, 30), 5);

    private LocalDate date;
    private int reduction;

    HolidaySales(LocalDate date, int reduction) {
        this.date = date;
        this.reduction = reduction;
    }

    public static int isReductionToday() {
        LocalDate today = LocalDate.now();
        for (int i = 0; i < HolidaySales.values().length; i++) {
            if (today.equals(HolidaySales.values()[i].date)) {
                return HolidaySales.values()[i].reduction;
            }
        }
        return 0;
    }
}

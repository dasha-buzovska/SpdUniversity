package pizzeria.dateTimeTools;

import pizzeria.dateTimeTools.discounts.HolidaySales;
import pizzeria.dateTimeTools.discounts.SpecialWeeklyDiscounts;
import pizzeria.utils.Colors;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.util.Arrays;

public class CalendarPrinter {

    public static void printYearCalendar(int year) {
        Arrays.stream(Month.values())
                .forEach(month -> {System.out.println("\n" + month);
                    printMonth(month.getValue(), year);
                    System.out.println();
                });
    }

    private static void printMonth(int month, int year) {
        System.out.println("Mon   Tue   Wed   Thu   Fri   Sat   Sun");
        LocalDate currentDate = LocalDate.of(year, month, 1);
        for (int dayOfMonth = 0; dayOfMonth < currentDate.lengthOfMonth(); dayOfMonth++) {
            for (int dayOfWeek = 1; dayOfWeek <= 7 && dayOfMonth < currentDate.lengthOfMonth(); dayOfWeek++) {
                if (currentDate.plusDays(dayOfMonth).get(ChronoField.DAY_OF_WEEK) == dayOfWeek) {
                    printColoredDay(currentDate, dayOfMonth);
                    printSpaces(currentDate, dayOfMonth);
                    dayOfMonth++;
                } else {
                    System.out.print("      ");
                }
            }
            System.out.println();
            dayOfMonth--;
        }
    }

    private static void printColoredDay(LocalDate date, int i){
        if (isHoliday(date.plusDays(i))) {
            System.out.print(Colors.RED.getCode() + date.plusDays(i).get(ChronoField.DAY_OF_MONTH) + Colors.RESET.getCode());
        } else if (isDiscountsToday(date.plusDays(i))) {
            System.out.print(Colors.GREEN.getCode() + date.plusDays(i).get(ChronoField.DAY_OF_MONTH) + Colors.RESET.getCode());
        } else {
            System.out.print(date.plusDays(i).get(ChronoField.DAY_OF_MONTH));
        }
    }

    private static void printSpaces(LocalDate currentDate, int i) {
        if (currentDate.plusDays(i).get(ChronoField.DAY_OF_MONTH)/10 == 0) {
            System.out.print(" ");
        }
        System.out.print("    ");
    }

    private static boolean isHoliday(LocalDate date) {
        return Arrays.stream(HolidaySales.values()).anyMatch(sale -> sale.getDate().equals(date));
    }

    private static boolean isDiscountsToday(LocalDate date){
        return Arrays.stream(SpecialWeeklyDiscounts.values()).anyMatch(discount ->
            discount.getDayOfWeek() == date.get(ChronoField.DAY_OF_WEEK) && !isHoliday(date)
        );
    }

}

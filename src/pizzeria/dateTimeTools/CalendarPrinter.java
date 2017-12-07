package pizzeria.dateTimeTools;

import pizzeria.dateTimeTools.discounts.HolidaySales;
import pizzeria.dateTimeTools.discounts.SpecialWeeklyDiscounts;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class CalendarPrinter {

    static final String ANSI_RESET = "\u001B[0m";
    static final String ANSI_RED = "\u001B[31m";
    static final String ANSI_GREEN = "\u001B[32m";

    static boolean isHoliday(LocalDate date) {
        for (int i = 0; i < HolidaySales.values().length; i++) {
            if (HolidaySales.values()[i].getDate().equals(date)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDiscountsToday(LocalDate date){
        for (int i = 0; i < SpecialWeeklyDiscounts.values().length; i++) {
            if (SpecialWeeklyDiscounts.values()[i].getDayOfWeek() == date.get(ChronoField.DAY_OF_WEEK) && !isHoliday(date)) {
                return true;
            }
        }
        return false;
    }


    public static void printYearCalendar(int year) {
        LocalDate start = LocalDate.of(year, 1, 1);
        for (int i = 0; i < 12; i++) {
            LocalDate date = start.plusMonths(i);
            System.out.println("\n" + date.getMonth());
            printMonth(date.getMonthValue(), year);
            System.out.println();
        }

    }
    private static void printMonth(int month, int year) {
        System.out.println("Mon   Tue   Wed   Thu   Fri   Sat   Sun");
        LocalDate currentDate = LocalDate.of(year, month, 1);
        for (int i = 0; i < currentDate.lengthOfMonth(); i++) {
            for (int j = 1; j <= 7 && i < currentDate.lengthOfMonth(); j++) {
                if (currentDate.plusDays(i).get(ChronoField.DAY_OF_WEEK) == j) {
                    printColoredDay(currentDate, i);
                    if (currentDate.plusDays(i).get(ChronoField.DAY_OF_MONTH)/10 == 0) {
                        System.out.print(" ");
                    }
                    System.out.print("    ");
                    i++;
                } else {
                    System.out.print("      ");
                }
            }
            System.out.println();
           i--;
        }
    }

    private static void printColoredDay(LocalDate date, int i){
        if (isHoliday(date.plusDays(i))) {
            System.out.print(ANSI_RED + date.plusDays(i).get(ChronoField.DAY_OF_MONTH) + ANSI_RESET);
        } else if (isDiscountsToday(date.plusDays(i))) {
            System.out.print(ANSI_GREEN + date.plusDays(i).get(ChronoField.DAY_OF_MONTH) + ANSI_RESET);
        } else {
            System.out.print(date.plusDays(i).get(ChronoField.DAY_OF_MONTH));
        }
    }

}

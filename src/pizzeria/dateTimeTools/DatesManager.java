package pizzeria.dateTimeTools;

import pizzeria.order.Order;
import pizzeria.order.OrdersList;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DatesManager {
    private OrdersList ordersList;

    public DatesManager(OrdersList ordersList) {
        this.ordersList = ordersList;
    }

    public int findSumByConcretePeriod(String period) {
        int sum = 0;
        switch (period) {
            case "year":
                sum = findSumForYear();
                break;
            case "month":
                sum = findSumForMonth();
                break;
            case "week":
                sum = findSumForWeek();
                break;
            case "day":
                sum = findSumForDay();
                break;
            default:
                System.out.println("Wrong sign was typed. Try again!");
                break;
        }
        return sum;
    }

    public int findSumForYear() {
        Calendar date = new GregorianCalendar();
        date.set(Calendar.YEAR, date.get(Calendar.YEAR) - 1);
        return calculateSumAfterDate(date);
    }

    public int findSumForMonth() {
        Calendar date = new GregorianCalendar();
        date.set(Calendar.MONTH, date.get(Calendar.MONTH) - 1);
        return calculateSumAfterDate(date);
    }

    public int findSumForWeek() {
        Calendar date = new GregorianCalendar();
        date.set(Calendar.DAY_OF_MONTH, date.get(Calendar.DAY_OF_MONTH) - 7);
        return calculateSumAfterDate(date);
    }

    public int findSumForDay() {
        Calendar date = new GregorianCalendar();
        date.set(Calendar.DAY_OF_MONTH, date.get(Calendar.DAY_OF_MONTH) - 1);
        return calculateSumAfterDate(date);
    }

    private int calculateSumAfterDate(Calendar date) {
        return ordersList.archivedOrders
                .stream()
                .filter(order -> order.getDate().after(date))
                .mapToInt(Order::calculate)
                .sum();
    }

}

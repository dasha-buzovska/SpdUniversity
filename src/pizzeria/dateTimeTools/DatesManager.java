package pizzeria.dateTimeTools;

import pizzeria.Order;
import pizzeria.OrdersList;

import java.util.Date;

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
        Date date = new Date();
        int yearAgo = date.getYear() - 1;
        date.setYear(yearAgo);
        return calculateSumAfterDate(date);
    }

    public int findSumForMonth() {
        Date date = new Date();
        int monthAgo = date.getMonth() - 1;
        date.setMonth(monthAgo);
        return calculateSumAfterDate(date);
    }

    public int findSumForWeek() {
        Date today = new Date();
        Date dateWeekAgo = new Date(today.getTime() - (1000 * 60 * 60 * 24 * 7));
        return calculateSumAfterDate(dateWeekAgo);
    }

    public int findSumForDay() {
        Date today = new Date();
        Date dateDayAgo = new Date(today.getTime() - (1000 * 60 * 60 * 24));
        return calculateSumAfterDate(dateDayAgo);
    }

    private int calculateSumAfterDate(Date date) {
        return ordersList.archivedOrders
                .stream()
                .filter(order -> order.getDate().after(date))
                .mapToInt(Order::calculate)
                .sum();
    }

}

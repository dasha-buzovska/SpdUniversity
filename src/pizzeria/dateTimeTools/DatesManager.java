package pizzeria.dateTimeTools;

import pizzeria.order.Order;
import pizzeria.order.OrdersList;

import java.time.LocalDateTime;


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

    private int findSumForYear() {
        return calculateSumAfterDate(LocalDateTime.now().minusYears(1));
    }

    private int findSumForMonth() {
        return calculateSumAfterDate(LocalDateTime.now().minusMonths(1));
    }

    private int findSumForWeek() {
        return calculateSumAfterDate(LocalDateTime.now().minusWeeks(1));
    }

    private int findSumForDay() {
        return calculateSumAfterDate(LocalDateTime.now().minusDays(1));
    }

    private int calculateSumAfterDate(LocalDateTime date) {
        return ordersList.archivedOrders
                .stream()
                .filter(order -> order.getDate().isAfter(date))
                .mapToInt(Order::calculate)
                .sum();
    }
}

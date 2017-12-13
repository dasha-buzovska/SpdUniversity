package pizzeria.dateTimeTools;

import pizzeria.order.Order;
import pizzeria.order.OrdersList;

import java.time.LocalDateTime;


public class SumForPeriod {
    private OrdersList ordersList;

    public SumForPeriod(OrdersList ordersList) {
        this.ordersList = ordersList;
    }

    public int findSumByConcretePeriod(String period) {
        int sum = 0;
        switch (period) {
            case "year":
                sum = calculateSumAfterDate(LocalDateTime.now().minusYears(1));
                break;
            case "month":
                sum = calculateSumAfterDate(LocalDateTime.now().minusMonths(1));
                break;
            case "week":
                sum = calculateSumAfterDate(LocalDateTime.now().minusWeeks(1));
                break;
            case "day":
                sum = calculateSumAfterDate(LocalDateTime.now().minusDays(1));
                break;
            default:
                System.out.println("Wrong sign was typed. Try again!");
                break;
        }
        return sum;
    }

    private int calculateSumAfterDate(LocalDateTime date) {
        return ordersList.getArchive()
                .stream()
                .filter(order -> order.getDate().isAfter(date))
                .mapToInt(Order::calculate)
                .sum();
    }
}

package transport;
/*
Задаем текущую остановку. Вывести на экран список маршрутов, проходящих через эту остановку и список автобусов, наиболее близких по времени, которые будут проезжать через эту остановку в нужную нам сторону.
Задаем текущую остановку и остановку назначения. Вывести список маршрутов (если таковые есть), которые позволят добраться из А в Б и список наиболее близких по времени автобусов.
Для пункта 3 находим самый оптимальный по времени автобус.
*/

public class BusPrinter {
    public static void main(String[] args) {
        printRoutesAndStops(); //1 task
    }

    public static void printRoutesAndStops() {
        for (int i = 0; i < Routes.values().length; i++) {
            System.out.println("\n" + Routes.values()[i].toString());
            for (int j = 0; j < Routes.values()[i].getStops().length; j++) {
                System.out.println(Routes.values()[i].getStops()[j]);
            }
        }
    }

}

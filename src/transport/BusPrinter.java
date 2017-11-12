package transport;
/*
Задаем текущую остановку. Вывести на экран список маршрутов, проходящих через эту остановку
и список автобусов, наиболее близких по времени, которые будут проезжать через эту остановку в нужную нам сторону.
Задаем текущую остановку и остановку назначения. Вывести список маршрутов (если таковые есть), которые позволят добраться из А в Б и список наиболее близких по времени автобусов.
Для пункта 3 находим самый оптимальный по времени автобус.
*/

import java.util.ArrayList;

public class BusPrinter {
    public static void main(String[] args) {
        BusPrinter busPrinter = new BusPrinter();
        //printRoutesAndStops(); //1 task
        busPrinter.findBusesForStop(Stop.SEDOVA_MARKET.getDirection1(), 58);
    }

    public static void printRoutesAndStops() {
        for (int i = 0; i < Routes.values().length; i++) {
            System.out.println("\n" + Routes.values()[i].toString());
            for (int j = 0; j < Routes.values()[i].getStops().length; j++) {
                System.out.println(Routes.values()[i].getStops()[j]);
            }
        }
    }

    public void findBusesForStop(String stop, int currentTime) {
        for (int i = 0; i < Routes.values().length; i++) {
            for (int j = 0; j < Routes.values()[i].getStops().length; j++) {
                if(stop.equals(Routes.values()[i].getStops()[j])) {
                    System.out.println(Routes.values()[i].toString());
                    ArrayList<String> list = getCurrentBuses(Routes.values()[i], currentTime, stop);
                    printList(list);
                }
            }
        }
    }

    public ArrayList<String> getCurrentBuses(Routes routeNumber, int currentTime, String stop){
        ArrayList<String> busList = new ArrayList<>();
        BusStore bus = new BusStore();
        Bus[] array = null;
        if (routeNumber.getNumber() == 4) {
            array = bus.busesRoute4;
        } else if (routeNumber.getNumber() == 7) {
            array = bus.busesRoute7;
        } else if (routeNumber.getNumber() == 11) {
            array = bus.busesRoute11;
        } else {
            System.out.println("Error");
        }
        int min = 60;
        int time = 0, busIndex = 0;
        int MINS_IN_HOUR = 60;
        for (int i = 0; i < array.length; i++) {
            time = getTimeDifference(findBusTimeForStop(array[i].getCurrentStop(), stop, routeNumber), currentTime);
            if (time < min) {
                min = time;
                busIndex = i;
                //busList.add("bus" + array[i].getId() + " will be at " + min);
            }
        }
        busList.add("bus" + array[busIndex].getId() + " will be at " + min + "min");
        return busList;
    }

    private int getTimeDifference(int busCurrentTime, int currentTime) {
        if (busCurrentTime <= currentTime) {
            return currentTime - busCurrentTime;
        } else {
            return  60 - busCurrentTime + currentTime;
        }
    }

    private int findBusTimeForStop(String busStop, String currentStop, Routes route) {
        int counter = 0;
        for (int i = 0; i < route.getStops().length; i++) {
            if (busStop.equals(route.getStops()[i].toString())) {
                while (i < route.getStops().length && !route.getStops()[i].toString().equals(currentStop)) {
                    counter += route.getTimeDifference();
                    i++;
                }
                return counter;
            }
        }
        return 0;
    }

    void printList(ArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}

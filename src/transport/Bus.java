package transport;

public class Bus {
    private int id;
    private Routes route;
    private int currentTime;
    private String currentStop;

    public int getId() {
        return id;
    }

    public Routes getRoute() {
        return route;
    }

    public int getCurrentTime() {
        return currentTime;
    }

    public String getCurrentStop() {
        return currentStop;
    }

    public Bus(int id, Routes route, int currentTime, String currentStop) {
        this.id = id;
        this.route = route;
        this.currentTime = currentTime;
        this.currentStop = currentStop;
    }
}

package transport;

public class Bus {
    private int id;
    private Routes route;
    private long currentTime;
    private String currentStop;

    public Bus(int id, Routes route, long currentTime, String currentStop) {
        this.id = id;
        this.route = route;
        this.currentTime = currentTime;
        this.currentStop = currentStop;
    }
}

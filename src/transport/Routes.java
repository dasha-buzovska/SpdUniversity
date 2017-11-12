package transport;

public enum Routes {
    FOUR(4, new String[]{Stop.AVRORA.getDirection1(),
            Stop.SEVEN_YEARS_SQUARE.getDirection1(),
            Stop.SEDOVA_MARKET.getDirection1(),
            Stop.DRUZGBA_NARIDIV.getDirection1(),
            Stop.DOM_TORGOVLI.getDirection1(),
            Stop.UNIVERSITY.getDirection1(),
            Stop.HOSPITAL.getDirection1(),
            Stop.HOSPITAL.getDirection2(),
            Stop.UNIVERSITY.getDirection2(),
            Stop.DOM_TORGOVLI.getDirection2(),
            Stop.DRUZGBA_NARIDIV.getDirection2(),
            Stop.SEDOVA_MARKET.getDirection2(),
            Stop.SEVEN_YEARS_SQUARE.getDirection2(),
            Stop.AVRORA.getDirection2()}, 5),
    SEVEN(7, new String[]{Stop.GRUZ_PORT.getDirection1(),
            Stop.SEDOVA_MARKET.getDirection1(),
            Stop.DRUZGBA_NARIDIV.getDirection1(),
            Stop.DOM_TORGOVLI.getDirection1(),
            Stop.CENTRAL_MARKET.getDirection1(),
            Stop.TABAC_FACTORY.getDirection1(),
            Stop.FOREST_STREET.getDirection1(),
            Stop.LUNA_DISTRICT.getDirection1(),
            Stop.LUNA_DISTRICT.getDirection2(),
            Stop.FOREST_STREET.getDirection2(),
            Stop.TABAC_FACTORY.getDirection2(),
            Stop.CENTRAL_MARKET.getDirection2(),
            Stop.DOM_TORGOVLI.getDirection2(),
            Stop.DRUZGBA_NARIDIV.getDirection2(),
            Stop.SEDOVA_MARKET.getDirection2(),
            Stop.GRUZ_PORT.getDirection2()}, 7),
    ELEVEN(11, new String[]{
            Stop.AVRORA.getDirection1(),
            Stop.SEVEN_YEARS_SQUARE.getDirection1(),
            Stop.SEDOVA_MARKET.getDirection1(),
            Stop.MYTNUTSA.getDirection1(),
            Stop.UNIVERSITY.getDirection1(),
            Stop.DNIPRO.getDirection1(),
            Stop.DNIPRO.getDirection2(),
            Stop.UNIVERSITY.getDirection2(),
            Stop.MYTNUTSA.getDirection2(),
            Stop.SEDOVA_MARKET.getDirection2(),
            Stop.SEVEN_YEARS_SQUARE.getDirection2(),
            Stop.AVRORA.getDirection2()}, 8);
    private int number;
    private String[] stops;
    private int timeDifference;

    public String[] getStops() {
        return stops;
    }

    public int getNumber() {

        return number;
    }

    public int getTimeDifference() {
        return timeDifference;
    }

    private Routes(int number, String[] stops, int timeDifference) {
        this.number = number;
        this.stops = stops;
        this.timeDifference = timeDifference;

    }
}

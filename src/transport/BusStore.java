package transport;

public class BusStore {
    public Bus bus41 = new Bus(41, Routes.FOUR, 34, Routes.FOUR.getStops()[3]);
    public Bus bus42 = new Bus(42, Routes.FOUR, 24, Routes.FOUR.getStops()[4]);
    public Bus bus43 = new Bus(43, Routes.FOUR, 10, Routes.FOUR.getStops()[6]);
    public Bus bus44 = new Bus(44, Routes.FOUR, 25, Routes.FOUR.getStops()[2]);

    public Bus bus71 = new Bus(71, Routes.SEVEN, 21, Routes.ELEVEN.getStops()[0]);
    public Bus bus72 = new Bus(72, Routes.SEVEN, 5, Routes.ELEVEN.getStops()[2]);
    public Bus bus73 = new Bus(73, Routes.SEVEN, 0, Routes.ELEVEN.getStops()[7]);
    public Bus bus74 = new Bus(74, Routes.SEVEN, 9, Routes.ELEVEN.getStops()[4]);

    public Bus bus111 = new Bus(111, Routes.ELEVEN, 45, Routes.ELEVEN.getStops()[1]);
    public Bus bus112 = new Bus(112, Routes.ELEVEN, 55, Routes.ELEVEN.getStops()[5]);
    public Bus bus113 = new Bus(113, Routes.ELEVEN, 4, Routes.ELEVEN.getStops()[2]);
    public Bus bus114 = new Bus(114, Routes.ELEVEN, 30, Routes.ELEVEN.getStops()[3]);

    public Bus[] busesRoute4 = {bus41, bus42, bus43, bus44};
    public Bus[] busesRoute7 = {bus71, bus72, bus73, bus74};
    public Bus[] busesRoute11 = {bus111, bus112, bus113, bus114};




}

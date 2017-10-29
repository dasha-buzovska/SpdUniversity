package hw3;

public class Concatenation {

    public static void main(String[] args) {
        String str = "";
        String value = "a";
        StringBuilder sbul = new StringBuilder(100);
        StringBuffer sbuf = new StringBuffer(100);
        System.out.println(getDifferenceStringPlus(str, value)); //711766522
        System.out.println(getDifferenceStringConcat(str, value)); //133648044
        System.out.println(getDifferenceStringBuilder(sbul, value)); //2126625
        System.out.println(getDifferenceStringBuffer(sbuf, value)); //2870280
    }


    static long getDifferenceStringPlus(String str, String value) {
        long startPoint = System.nanoTime();
        for (int i = 0; i < 20000; i++) {
            str += value;
        }
        return System.nanoTime() - startPoint;
    }

    static long getDifferenceStringConcat(String str, String value) {
        long startPoint = System.nanoTime();
        for (int i = 0; i < 20000; i++) {
            str = str.concat(value);
        }
        return System.nanoTime() - startPoint;
    }

    static long getDifferenceStringBuilder(StringBuilder str, String value) {
        long startPoint = System.nanoTime();
        for (int i = 0; i < 20000; i++) {
            str = str.append(value);
        }
        return (long) System.nanoTime() - startPoint;
    }

    static long getDifferenceStringBuffer(StringBuffer str, String value) {
        long startPoint = System.nanoTime();
        for (int i = 0; i < 20000; i++) {
            str = str.append(value);
        }
        return System.nanoTime() - startPoint;
    }
}

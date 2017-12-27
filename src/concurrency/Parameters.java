package concurrency;

import java.text.ParseException;
import java.util.concurrent.TimeUnit;

public class Parameters {
    private TimeUnit timeUnit;
    private int timeInterval;
    private int poolSize;
    private int triesForFailedNumber;

    Parameters(String[] args) throws ParseException {
        if (args[0].equals("-s")) {
            timeUnit = TimeUnit.SECONDS;
        } else if (args[0].equals("-m")) {
            timeUnit = TimeUnit.MINUTES;
        } else if (args[0].equals("-h")) {
            timeUnit = TimeUnit.HOURS;
        } else {
            throw new ParseException("TimeUnit error", 0);
        }

        timeInterval = Integer.parseInt(args[1]);

        if (args[2].toLowerCase().equals("-poolsize")) {
            poolSize = Integer.parseInt(args[3]);
        }

        if (args[4].toLowerCase().equals("-tryforfail")) {
            triesForFailedNumber = Integer.parseInt(args[5]);
        }
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public int getTimeInterval() {
        return timeInterval;
    }

    public int getPoolSize() {
        return poolSize;
    }

    public int getTriesForFailedNumber() {
        return triesForFailedNumber;
    }
}

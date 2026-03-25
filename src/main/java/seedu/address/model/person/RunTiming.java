package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

/**
 * Represents a recorded 2.4km run timing for an athlete.
 *
 * <p>A {@code RunTiming} stores the completion time of a fixed-distance
 * 2.4 kilometre run using minutes and seconds. This format mirrors how
 * timing is typically recorded in athletics training and fitness tests
 * such as the IPPT 2.4km run.</p>
 *
 * <p>This class is immutable. Once created, the stored timing values
 * cannot be modified.</p>
 *
 * <p>The run distance is fixed at {@code 2.4km} and therefore not stored
 * as a mutable field.</p>
 */
public class RunTiming {

    public static final String MESSAGE_DISTANCE_CONSTRAINTS = "Distance must be one of: 2.4km, 400m, 10km, 42km";

    /** Distance of the run command. */
    private final String distance;

    /** Minutes component of the recorded timing. */
    private final int minutes;

    /** Seconds component of the recorded timing. */
    private final double seconds;

    /**
     * Constructs a {@code RunTiming}.
     *
     * @param minutes The minutes component of the timing.
     * @param seconds The seconds component of the timing.
     * @throws NullPointerException if any argument is null.
     */
    public RunTiming(String distance, int minutes, double seconds) {
        requireNonNull(distance);
        requireNonNull(minutes);
        requireNonNull(seconds);

        this.distance = distance;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    /**
     * Returns whether the given distance is supported.
     *
     * @param test Distance string to validate.
     * @return {@code true} if supported.
     */
    public static boolean isValidDistance(String test) {
        return "2.4km".equals(test)
                || "400m".equals(test)
                || "10km".equals(test)
                || "42km".equals(test);
    }

    /**
     * Returns the minutes component of the run timing.
     *
     * @return the recorded minutes.
     */
    public int getMinutes() {
        return this.minutes;
    }

    /**
     * Returns the seconds component of the run timing.
     *
     * @return the recorded seconds.
     */
    public double getSeconds() {
        return this.seconds;
    }

    /**
     * Returns the fixed run distance.
     *
     * @return the run distance in kilometres (always {@code 2.4}).
     */
    public String getDistance() {
        return this.distance;
    }

    /**
     * Returns the total run time in seconds.
     *
     * <p>This value is useful for comparing run timings,
     * such as when calculating an athlete's personal best.</p>
     *
     * @return total run time in seconds.
     */
    public double getTotalSeconds() {
        return minutes * 60 + seconds;
    }

    /**
     * Returns a formatted string representation suitable for compact display.
     *
     * @return formatted timing string (e.g. {@code "2.4km, 10min 30s"}).
     */
    public String getPrintFormat() {
        return this.distance + ", " + this.minutes + "min " + this.seconds + "s";
    }

    /**
     * Returns the standard string representation of this run timing.
     *
     * @return formatted timing string (e.g. {@code "2.4km in 10min 30s"}).
     */
    @Override
    public String toString() {
        return this.distance + " in " + this.minutes + "min " + this.seconds + "s";
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof RunTiming)) {
            return false;
        }
        RunTiming otherTiming = (RunTiming) other;
        return distance.equals(otherTiming.distance)
                && minutes == otherTiming.minutes
                && Double.compare(seconds, otherTiming.seconds) == 0;
    }

    @Override
    public int hashCode() {
        return distance.hashCode() + 31 * minutes + Double.hashCode(seconds);
    }
}

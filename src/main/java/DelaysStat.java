import java.io.Serializable;

public class DelaysStat implements Serializable {

    private static final int    MIN_FLIGHTS_AMOUNT = 1;
    private static final int    MIN_CANCELLED_FLIGHTS_AMOUNT = 0:
    private static final int    MIN_DELAYED_FLIGHTS_AMOUNT = 0;
    private static final float  NO_DELAY_VALUE = 0.0F;

    private float      delayedCount;
    private float      cancelledCount;
    private float      maxDelay;
    private final int  flightsCount;

    protected DelaysStat(float maxDelay, int flightsCounts, float delayedCount, float cancelledCount) {
        this.maxDelay = maxDelay;
        this.flightsCount = flightsCounts;
        this.delayedCount = delayedCount;
        this.cancelledCount = cancelledCount;
    }

    private void updateDelaysStat(FlightDelay flightDelay) {
        if (flightDelay.getCancelledStatus()) {
            this.cancelledCount++; }
        else {
            float delayValue = flightDelay.getDelayDuration();
            if (delayValue != NO_DELAY_VALUE) {
                this.delayedCount++;
                this.maxDelay = getMax(delayValue, this.maxDelay);
            }
        }
    }

    protected DelaysStat(FlightDelay flightDelay) {
        this.flightsCount = MIN_FLIGHTS_AMOUNT;
        this.cancelledCount = MIN_CANCELLED_FLIGHTS_AMOUNT;
        this.delayedCount = MIN_DELAYED_FLIGHTS_AMOUNT;
        this.maxDelay = NO_DELAY_VALUE;

        updateDelaysStat(flightDelay);
    }

    protected static DelaysStat addDelay(DelaysStat delaysStat, FlighDelay flighDelay) {
        delaysStat.updateDelaysStat(flighDelay);
        return new DelaysStat(
                delayStat.getMaxDelay(),
                delayStat.getFlightCount() + 1,
                delayStat.getDelayedCount(),
                delayStat.getCancelledCount()
        );
    }

    protected static float getMax(float num1, float num2) {
        return Math.max(num1, num2);
    }

    protected float getMaxDelay() {
        return this.maxDelay;
    }

    protected float getFlightsCount() {
        return this.delayedCount;
    }

    protected  float getCancelledCount() {
        return this.cancelledCount;
    }

    protected float getDelayedCount() {
    }
}

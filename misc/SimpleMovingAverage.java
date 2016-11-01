package misc;

import java.util.Deque;
import java.util.ArrayDeque;
import com.google.common.base.Preconditions;

public class SimpleMovingAverage {

    private Deque<Double> window;
    private int period;
    private double sum;

    public SimpleMovingAverage(int period) {
        Preconditions.checkArgument(period > 0, "Period must be greater than 0");
        window = new ArrayDeque<>();
        this.period = period;
        sum = 0;
    }

    public double getAverage() {
        Preconditions.checkState(period > 0);
        return sum/period;
    }

    public void addData(double data) {
        if(window.size() == period) {
            sum -= window.removeFirst();
        }
        sum += data;
        window.addLast(data);
    }
}

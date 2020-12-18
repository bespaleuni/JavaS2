package by.gsu.pms;

public class CalculatorThread extends Thread {
    private long result = 1;
    private final int minValue;
    private final int maxValue;

    public long getResult() {
        return this.result;
    }

    public CalculatorThread(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println("Thread " + threadName + " starting ");
        for (int i = this.minValue; i <= this.maxValue * 2 + 1; i++)
            this.result *= i;
    }
}

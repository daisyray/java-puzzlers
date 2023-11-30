package ray.daisy.puzzlers;

public class Aggregate {

    int min;
    int max;
    double average;

    public Aggregate(int min, int max, double average) {
        this.min = min;
        this.max = max;
        this.average = average;
    }

    @Override
    public String toString() {
        return "Aggregate{" +
                "min=" + min +
                ", max=" + max +
                ", average=" + average +
                '}';
    }
}

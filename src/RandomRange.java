import java.util.Random;

public class RandomRange {

    static public double dblRandom(double min, double max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random rn = new Random();
        return min + ((max - min) * rn.nextDouble());
    }

    static int intRandom(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random rn = new Random();
        return rn.nextInt((max - min) + 1) + min;
    }
}

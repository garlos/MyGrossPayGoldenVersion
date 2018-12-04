import java.text.DecimalFormat;

public class NormToPercent {
    public static double normalize(double x, double dataLow, double dataHigh, double normalizedLow, double normalizedHigh) {
        return ((x - dataLow) / (dataHigh - dataLow)) * (normalizedHigh - normalizedLow) + normalizedLow;
    }
}

import java.text.DecimalFormat;

public class NormalizeToPercentage {
    public static double normalize(double x, double dataLow, double dataHigh, double normalizedLow, double normalizedHigh) {
        return ((x - dataLow)/ (dataHigh - dataLow)) * (normalizedHigh - normalizedLow) + normalizedLow;
    }
}

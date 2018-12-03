public class TaxCalc {
    public static double taxCalc(double netPay) {
        if (netPay > 1500) {
            netPay *= 0.09;
        } else if (netPay <= 1500) {
            netPay *= 0.05;
        }
        return netPay;
    }
}

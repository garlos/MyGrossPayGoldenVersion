public class NetPayCalc {

    final double STANDARD = 4;
    double rate = 0;


    public double netPayCalc(double staffType, double hours, double exHours, double workQuality) {

        double exPay = 0;
        double netPay;

        if (staffType == 1) {
            rate = 1.6;
        } else if (staffType == 2) {
            rate = 2.2;
        } else if (staffType == 3) {
            rate = 3.1;
        }

        netPay = (hours * (STANDARD * rate)) + (exHours * (rate * (STANDARD * 2)));

        if ((exHours >= 25) && (workQuality >= 90)) {
             exPay += (exHours - 25) * (STANDARD * rate);     //reward
        } else if ((exHours >= 20) || (workQuality >= 80)) {
            netPay += 200;
        }

        netPay += exPay;

        return netPay;
    }


}
